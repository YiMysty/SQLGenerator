package configReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import entity.dimPeriod;
import entity.dimGeoLocation;
import entity.dimZone;

public class DataReader {
	public ArrayList<dimZone> getZoneData(){
		ArrayList<dimZone> zone = new ArrayList<dimZone>();
		ConfigReader config = new ConfigReader();
		String fileName = config.getConfigurationReader().getZoneDataFileName();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String s = "";
			while((s=reader.readLine())!=null){
				dimZone temp = new dimZone();
				temp.setZoneID(Integer.parseInt(s.split(",")[1]));
				temp.setZoneName(s.split(",")[0]);
				temp.setCity("Chicago");
				temp.setZState("IL");
				zone.add(temp);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		config.close();
		return zone;
	}
	public ArrayList<dimPeriod> getPeriodData(){
		ArrayList<dimPeriod> period = new ArrayList<dimPeriod>();
		ConfigReader config = new ConfigReader();
		String fileName = config.getConfigurationReader().getPeriodDataFileName();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String s = "";
			while((s=reader.readLine())!=null){
				dimPeriod temp = new dimPeriod();
				temp.setPeriodID(Integer.parseInt(s));
				temp.setRushHour(Integer.parseInt(s));
				temp.setPartOfDay(Integer.parseInt(s));
				period.add(temp);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		config.close();
		return period;
	public ArrayList<dimGeoLocation> getGeoLocationData(){
		ArrayList<dimGeoLocation> data = new ArrayList<dimGeoLocation>();
		return data;
	}
}
