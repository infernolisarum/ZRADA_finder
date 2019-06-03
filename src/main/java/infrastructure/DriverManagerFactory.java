package infrastructure;

import infrastructure.driver_managers.ChromeDriverManager;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(BrowserType type) {
        DriverManager manager = null;
        switch (type) {
            case CHROME:
                manager = new ChromeDriverManager ();
                break;
            case FIREFOX:
                System.out.println ("Browser " + type.name () + " is not supported at the moment." +
                        "\nChoose a different browser.");
                break;
        }
        return manager;
    }
}
