package framework.config;

public class ConfigFactory {

    // To get the environment property file name, with which we want to work.

    public static String getPropertyFile(String envName){

        if(envName ==  null || envName.isB)
        switch (envName.toLowerCase()){
            case "dev":
                return "dev.properties";
            case "qa":
                return "qa.properties";
            case "sit":
                return "sit.properties";
            case "uat":
                return "uat.properties";
            case "preprod":
                return "preprod.properties";
            case "prod":
                return "prod.properties";
            default:
                throw new IllegalArgumentException("No such environment available named " + envName.toUpperCase());
        }
    }
}
