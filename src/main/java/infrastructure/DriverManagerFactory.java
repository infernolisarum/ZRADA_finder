package infrastructure;

import infrastructure.driver_managers.ChromeDriverManager;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(BrowserType type) {
        DriverManager manager = null;
        switch (type) {
            case CHROME:
                manager = new ChromeDriverManager ();
                break;
            case FIREFOX:
                throw new NotImplementedException ();
        }
        return manager;
    }
}
