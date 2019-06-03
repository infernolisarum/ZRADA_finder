package infrastructure;

public class Settings {
    private static Settings settings = null;

    private String chromeDriverPath;

    private Settings(){
        chromeDriverPath = System.getenv ("CHROMEDRIVER_PATH");
        if (chromeDriverPath == null)
            chromeDriverPath = "D:/JAVA_COMMON/JAVA_HELPFUL/Selenium/chromedriver.exe";
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static Settings get() {
        if (settings == null)
            settings = new Settings ();
        return settings;
    }
}
