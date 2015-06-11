package configReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
				temp.setState("IL");
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
}
