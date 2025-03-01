package dataprovider;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{

	public static String getValue(String key) 
	{
		
        Properties pro=new Properties() ;
        try 
        {
        pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/configurations/config.properties")));
        }
        catch(IOException e)
        {
        	System.out.println("LOG:FAIL - Unable to to read config file "+e.getMessage());
        }
        String value=pro.getProperty(key);
        return value;
        
	}

}
