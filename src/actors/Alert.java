package actors;

public class Alert extends WaterPump{
	String alertName = "";
	String frecuency = "";
	String type = "";


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFrecuency() {
		return frecuency;
	}

	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}

	public Alert(String alertName) {
		
		this.alertName = alertName;
		
	}

	public String getAlertName() {
		return alertName;
	}

	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}
}
