package BaseSetup;


import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Properties;


public class  ConfigFileReader {

String path = System.getProperty("user.dir");
private Properties properties;

//private final String configFilePath= path+"\\resources\\Data.Properties";

private final String configFilePath= "resources//Data.properties";


public ConfigFileReader() {


File  ConfigFile=new File(configFilePath);


try {

FileInputStream configFileReader=new FileInputStream(ConfigFile);

      properties = new Properties();


try {

      properties.load(configFileReader);

      configFileReader.close();

    } catch (IOException e) 

      {

        System.out.println(e.getMessage());

      }

  }  catch (FileNotFoundException e) 

      {

        System.out.println(e.getMessage());

throw new RuntimeException("config.properties not found at config file path" + configFilePath);

      }

  }


public String getUserAge() {

String UserAge= properties.getProperty("Age");

if(UserAge != null)

return UserAge;

else

throw new RuntimeException("Application url not specified in the config.properties file.");

}


public String getUserName() {

String username= properties.getProperty("username");

if(username != null)

return username;

else

throw new RuntimeException("username not specified in the config.properties file.");

}

public String getEmail() {

String Email= properties.getProperty("email");

if(Email != null)

return Email;

else

throw new RuntimeException("username not specified in the config.properties file.");

}

public String getEmiratesIdExpiryYear() {

String ExpiryYear= properties.getProperty("EmiratesIdExpiryYearInfo");

if(ExpiryYear != null)

return ExpiryYear;

else

throw new RuntimeException("username not specified in the config.properties file.");

}

public String getPhoneNumber() {

String PhoneNumberinfo= properties.getProperty("PhoneNumber");

if(PhoneNumberinfo != null)

return PhoneNumberinfo;

else

throw new RuntimeException("username not specified in the config.properties file.");

}

public String getEmiratesId() {

String EmiratesId= properties.getProperty("ID");

if(EmiratesId != null)

return EmiratesId;

else

throw new RuntimeException("username not specified in the config.properties file.");

}

}





