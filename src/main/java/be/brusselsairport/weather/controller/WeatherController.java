package be.brusselsairport.weather.controller;

import be.brusselsairport.weather.apis.AviationWeatherConsumer;
import be.brusselsairport.weather.config.CacheConfiguration;
import be.brusselsairport.weather.data.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
	private final AviationWeatherConsumer aviationWeatherConsumer;
	private final CacheManager cacheManager;

	@Autowired
	public WeatherController(AviationWeatherConsumer aviationWeatherConsumer, CacheManager cacheManager) {
		this.aviationWeatherConsumer = aviationWeatherConsumer;
		this.cacheManager = cacheManager;
	}

	@GetMapping(path = "/")
	public String getWeatherForBrussels(@RequestParam("icao") String icao) {
		Weather weather = getWeather(icao);

		if (weather == null) {
			return "No weather found for ICAO " + icao;
		}

		return weather.toString();
	}

	@Cacheable
	private Weather getWeather(String destinationICAO) {
		return aviationWeatherConsumer.getWeather(destinationICAO).getData().getWeather();
	}
}
