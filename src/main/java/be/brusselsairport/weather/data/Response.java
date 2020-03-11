package be.brusselsairport.weather.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class Response {
	@XmlElement(name = "data")
	private Data data;

	public Data getData() {
		return data;
	}
}
