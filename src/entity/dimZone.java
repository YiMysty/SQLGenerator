package entity;

import com.vividsolutions.jts.geom.Geometry;

public class dimZone {
	int ZoneID;
	Geometry geo;
	String city;
	//String state;
	String ZoneName;
	public String getZoneName() {
		return ZoneName;
	}
	public void setZoneName(String zoneName) {
		ZoneName = zoneName;
	}
	public int getZoneID() {
		return ZoneID;
	}
	public void setZoneID(int zoneID) {
		ZoneID = zoneID;
	}
	public Geometry getGeo() {
		return geo;
	}
	public void setGeo(Geometry geo) {
		this.geo = geo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public dimZone(){
		this.city = null;
	//	this.state = null;
		this.ZoneID = -1;
		this.ZoneName = null;
		this.geo = null;
	}
}
