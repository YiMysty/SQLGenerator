package entity;

import com.vividsolutions.jts.geom.Geometry;

public class dimDateTime {
	//int DateTimeID;
	int TimeStep;
	String Time;
	int Hour;
	String Date;
	int Day;
	int Month;
	int Year;
	int Quarter;
	int DayOfWeek;
	int PeriodID;
	//String hours="",minutes="",seconds="";
	//int hour=0,minute=0,second=0,temp=0;
	String []s = new String[3];
	int    []a = new int[4];
//	String days="";
//	int day=1,month=5,year=2015;
	
//	public int getDateTimeID() {
//		return DateTimeID;
//	}
//
//
//	public void setDateTimeID(int dateTimeID) {
//		DateTimeID = dateTimeID;
//	}


	public int getTimeStep() {
		return TimeStep;
	}


	public void setTimeStep(int timeStep) {
		TimeStep = timeStep;
	}



	public int getPeriodID() {
		return PeriodID;
	}


	public void setPeriodID(int periodID) {
		PeriodID = a[0];
	}


	public String getTime() {
		return Time;
	}


	public void setTime(int dateTimeID) {
		s[0]="";
		s[1]="";
		s[2]="";
		a[0]=0;
		a[1]=0;
		a[2]=0;
		a[3]=0;
		a[3] = dateTimeID * 10 / 3600 ;
		a[0] = a[3] % 24;
		//minute = (dateTimeID * 10 - 3600 * temp) / 60;
		a[1] = dateTimeID * 10 % 3600 / 60;
		a[2] = dateTimeID % 60;
		
		if ( a[0] > 0){
			switch (Integer.toString(a[0]).length()){
				case 1:
					s[0] ="0".concat(Integer.toString(a[0]));
					break;
				case 2:
					s[0] = Integer.toString(a[0]);
					break;	
			}
		}
		else 
		{
			s[0]="00";
		}
		
		if ( a[1] > 0){
			switch (Integer.toString(a[1]).length()){
				case 1:
					s[1] ="0".concat(Integer.toString(a[1]));
					break;
				case 2:
					s[1] = Integer.toString(a[1]);
					break;	
			}
		}
		else 
		{
			s[1] = "00";
		}
		
		if ( a[2] > 0){
			switch (Integer.toString(a[2]).length()){
				case 1:
					s[2] ="0".concat(Integer.toString(a[2]));
					break;
				case 2:
					s[2] = Integer.toString(a[2]);
					break;	
			}
		}
		else 
		{
			s[2] = "00";
		}
		Time = (s[0].concat(s[1])).concat(s[2]);
	}


	public int getHour() {
		return Hour;
	}


	public void setHour() {
		Hour = a[0];
	}


	public String getDate() {
		return Date;
	}


	public void setDate(int dateTimeID) {
		String days="";
		String temp3="201505";
		int day = 1 + dateTimeID / 3600 /24 ;
		if ( day > 1){
			switch (Integer.toString(day).length()){
				case 1:
					days ="0".concat(Integer.toString(day));
					break;
				case 2:
					days = Integer.toString(day);
					break;	
			}
		}
		else 
		{
			days ="01";
		}
		
		Date = temp3.concat(days);
	}


	public int getDay() {
		return Day;
	}


	public void setDay(int dateTimeID) {
		int day = 1 + dateTimeID / 3600 /24 ;
		Day = day;
	}


	public int getMonth() {
		return Month;
	}


	public void setMonth() {
		Month = 5;
	}


	public int getYear() {
		return Year;
	}


	public void setYear() {
		Year = 2015;
	}


	public int getQuarter() {
		return Quarter;
	}


	public void setQuarter() {
		Quarter = 2;
	}


	public int getDayOfWeek() {
		return DayOfWeek;
	}


	public void setDayOfWeek(int dataTimeID) {
		int day = 1 + dataTimeID / 3600 /24 ;
		DayOfWeek = day % 7;
	}


	public dimDateTime(){
		//this.DateTimeID = -1;
		this.TimeStep = -1;
		this.Time = null;
		this.Hour = -1;
		this.Date = null;
		this.Day = -1;
		this.Month = -1;
		this.Year = -1;
		this.Quarter = -1;
		this.DayOfWeek = -1;
		this.PeriodID = -1;
	}
}
