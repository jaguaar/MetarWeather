package be.brusselsairport.weather.data;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Weather {
	@XmlElement(name = "raw_text")
	private String rawText;

	@XmlElement(name = "station_id")
	private String station;

	@XmlElement(name = "temp_c")
	private String temperature;

	@XmlElement(name = "dewpoint_c")
	private String dewpoint;

	@XmlElement(name = "sky_condition")
	private List<SkyCondition> skyConditionList;

	public String getRawText() {
		return rawText;
	}

	public String getStation() {
		return station;
	}

	@Override
	public String toString() {
		return "Weather{" +
				"rawText='" + rawText + '\'' +
				", station='" + station + '\'' +
				", temperature='" + temperature + '\'' +
				", dewpoint='" + dewpoint + '\'' +
				", skyConditionList=" + skyConditionList +
				'}';
	}
}
