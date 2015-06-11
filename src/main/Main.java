package main;
import tools.SQLGenerator;
import configReader.DataReader;
import db.DBTools;
import entity.dimGeoLocation;
import entity.dimPeriod;
import entity.dimTerm;

public class Main {
	public static void main(String args[]){
		DBTools db = new DBTools();
		DataReader reader = new DataReader();
////		for(dimZone z:reader.getZoneData()){
////			String SQL = SQLGenerator.getInsertQuery(z);
////			System.out.println(SQL);
////			//db.execute(SQL);
////		}
//		for(dimPeriod z:reader.getPeriodData()){
//			String SQL = SQLGenerator.getInsertQuery(z);
//			//System.out.println(SQL);
//			//db.execute(SQL);
//		}
//		for(dimGeoLocation z:reader.getGeoLocationData()){
//			String SQL = SQLGenerator.getInsertQuery(z);
//			System.out.println(SQL);
//			db.execute(SQL);
//		}
	for(dimTerm d:reader.getDimeTermData()){
		String SQL = SQLGenerator.getInsertQuery(d);
		System.out.println(SQL);
	}
	}
}
