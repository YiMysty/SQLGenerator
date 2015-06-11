package main;
import tools.SQLGenerator;
import configReader.DataReader;
import db.DBTools;
import entity.dimZone;

public class Main {
	public static void main(String args[]){
		DBTools db = new DBTools();
		DataReader reader = new DataReader();
		for(dimZone z:reader.getZoneData()){
			String SQL = SQLGenerator.getInsertQuery(z);
			System.out.println(SQL);
			db.execute(SQL);
		}
	}
}
