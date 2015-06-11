package main;
import tools.SQLGenerator;
import configReader.DataReader;
import db.DBTools;
import entity.dimTerm;

import entity.dimDateTime;

import entity.dimGeoLocation;

import entity.dimPeriod;
import entity.dimTerm;
import entity.dimZone;

import entity.factRelatedness;


public class Main {
	public static void main(String args[]){
		DBTools db = new DBTools();
		DataReader reader = new DataReader();
//		for(dimZone z:reader.getZoneData()){
//			String SQL = SQLGenerator.getInsertQuery(z);
//			System.out.println(SQL);
//			//db.execute(SQL);
//		}
//		for(dimPeriod z:reader.getPeriodData()){
//			String SQL = SQLGenerator.getInsertQuery(z);

//			System.out.println(SQL);
//			db.execute(SQL);
//		}
		for(dimDateTime z:reader.getDateTimeData()){
			String SQL = SQLGenerator.getInsertQuery(z);
			System.out.println(SQL);
			//db.execute(SQL);
		}

//			//System.out.println(SQL);
//			//db.execute(SQL);
//		}
//		for(dimGeoLocation z:reader.getGeoLocationData()){
//			String SQL = SQLGenerator.getInsertQuery(z);
//			System.out.println(SQL);
//			db.execute(SQL);
//		}
//		for(dimTerm d:reader.getDimeTermData()){
//			String SQL = SQLGenerator.getInsertQuery(d);
//			db.execute(SQL);
//		}
		for(factRelatedness f:reader.getFactRelatedness()){
			String SQL = SQLGenerator.getInsertQuery(f);
			db.execute(SQL);
		}

	}
}
