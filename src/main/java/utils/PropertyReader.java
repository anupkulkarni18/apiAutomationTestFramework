package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

public class PropertyReader {
	public static String getProperties(String key) {
        Properties prop = new Properties();

        Hashtable<String,String> propertyTable = new Hashtable<String, String>();
        try {
            InputStream filename = new FileInputStream(new File(System.getProperty("user.dir")+"/config.properties"));
            prop.load(filename);
            for(int i=0;i<prop.keySet().size(); i++)
                propertyTable.put(prop.keySet().toArray()[i].toString(), prop.values().toArray()[i].toString());
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyTable.get(key);
    }
}
