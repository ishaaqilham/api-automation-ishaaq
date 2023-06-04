package common;

import util.ReadPropertyFile;

public class Constants {

    /*
    Get Property Values from Property File
     */
    public static final String BASE_URL = new ReadPropertyFile().getProperty("base.url");
    public static final String API_VERSION = new ReadPropertyFile().getProperty("api.version");

}
