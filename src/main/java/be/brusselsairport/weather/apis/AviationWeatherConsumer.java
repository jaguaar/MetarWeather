package be.brusselsairport.weather.apis;

import be.brusselsairport.weather.data.Response;
import feign.Param;
import feign.RequestLine;

public interface AviationWeatherConsumer {
	@RequestLine("GET /adds/dataserver_current/httpparam?dataSource=metars&requestType=retrieve&stationString={icao}&hoursBeforeNow=3&mostRecent=true&format=xml")
	Response getWeather(@Param("icao") String icao);
}
