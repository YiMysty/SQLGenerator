package entity;

import com.vividsolutions.jts.geom.Geometry;

public class dimPeriod {
	int PeriodID;
	Boolean RushHour;
	String PartOfDay;
	public int getPeriodID() {
		return PeriodID;
	}
	public void setPeriodID(int periodID) {
		PeriodID = periodID;
	}
	public Boolean getRushHour() {
		return RushHour;
	}
	public void setRushHour(int periodID) {
		if ((periodID>=7&&periodID<=9)||(periodID>=17&&periodID<=19)){
			this.RushHour = true;
		}
		else{
			this.RushHour = false;
		}
	}
	public String getPartOfDay() {
		return PartOfDay;
	}
	public void setPartOfDay(int periodID) {
		if ((periodID>=17&&periodID<=23)||(periodID>=0&&periodID<=5)){
			this.PartOfDay = "Evening";
		}
		else if (periodID>=6&&periodID<=12){
			this.PartOfDay = "Morning";
		}
		else if (periodID>=13&&periodID<=18){
			this.PartOfDay = "Afternoon";
		}
	}
	
	public dimPeriod(){
		this.PeriodID = -1;
		this.RushHour = null;
		this.PartOfDay = null;
	}
}
