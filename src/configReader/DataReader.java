package configReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import type.Location;
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
	}
	public ArrayList<dimGeoLocation> getGeoLocationData(){
		ArrayList<dimGeoLocation> data = new ArrayList<dimGeoLocation>();
		ConfigReader config = new ConfigReader();
		String fileName = config.getConfigurationReader().getPOIDataFileName();
		String s = "";
		try {
			BufferedReader  reader = new BufferedReader(new FileReader(fileName));
			while((s=reader.readLine())!=null){
				if(s.equals(""))
					continue;
				if(s.charAt(s.length()-1)<='9'&&s.charAt(s.length()-1)>='0'){
					dimGeoLocation temp = new dimGeoLocation();
					try{
						Integer.parseInt(s.split(" ")[2]);
					}catch(Exception e){
						continue;
					}
					temp.setZoneID(8);
					temp.setLocation(new Location(Float.parseFloat(s.split(" ")[0]),Float.parseFloat(s.split(" ")[1]),"L_Geography"));
					data.add(temp);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERR:"+s);
			e.printStackTrace();
		}
		config.close();
		return data;
	}
}
