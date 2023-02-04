package actors;

public class Mesure {
	
	private String mesureType = "";
	private User user = new User();
	private String observations = "";
	private String date ="";
	private String id ="";
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMesureType() {
		return mesureType;
	}
	public void setMesureType(String mesureType) {
		this.mesureType = mesureType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	
	
}
