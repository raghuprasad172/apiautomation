package org.generalUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

    public String getDataFromPropertyFile(String key){
        String value = "";
        try {
            FileInputStream fileInputStream = new FileInputStream("./config_env.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            value= properties.getProperty(key);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  value;
    }
}
