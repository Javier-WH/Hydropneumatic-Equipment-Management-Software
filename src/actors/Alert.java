package actors;

public class Alert extends WaterPump{
	String alertName = "";
	
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
