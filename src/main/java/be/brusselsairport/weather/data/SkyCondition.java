package be.brusselsairport.weather.data;

import javax.xml.bind.annotation.XmlAttribute;

public class SkyCondition {
	@XmlAttribute(name = "sky_cover")
	private String skyCoverage;

	@XmlAttribute(name = "cloud_base_ft_agl")
	private String height;

	@Override
	public String toString() {
		return "SkyCondition{" +
				"skyCoverage='" + skyCoverage + '\'' +
				", height='" + height + '\'' +
				'}';
	}
}
