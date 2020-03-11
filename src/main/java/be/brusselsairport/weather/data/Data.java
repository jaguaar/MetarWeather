package be.brusselsairport.weather.data;

import javax.xml.bind.annotation.XmlElement;

public class Data {
	@XmlElement(name="METAR")
	private Weather weather;

	public Weather getWeather() {
		return weather;
	}
}
