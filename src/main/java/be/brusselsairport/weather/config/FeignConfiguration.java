package be.brusselsairport.weather.config;

import be.brusselsairport.weather.apis.AviationWeatherConsumer;
import feign.Feign;
import feign.Logger;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
	@Bean
	public AviationWeatherConsumer aviationWeatherConsumer(Logger.JavaLogger feignLogger, @Value("${api.host}") String apiUrl) {
		JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
				.withMarshallerJAXBEncoding("UTF-8")
				.withMarshallerSchemaLocation("http://aviationweather.gov http://aviationweather.gov/adds/schema/metar1_2.xsd")
				.build();

		return Feign.builder()
				.logger(feignLogger)
				.logLevel(Logger.Level.FULL)
				.decoder(new JAXBDecoder(jaxbFactory))
				.target(AviationWeatherConsumer.class, apiUrl);
	}

	@Bean
	Logger.JavaLogger feignLogger() {
		return new Logger.JavaLogger(Logger.class.getName()).appendToFile("http.log");
	}
}
