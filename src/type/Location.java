package type;

public class Location {
	float latitude;
	float longtitude;
	String Name;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(float intitude) {
		this.longtitude = intitude;
	}
	public Location(float longtitude,float latitude,String Name){
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.Name = Name;
	}
}
