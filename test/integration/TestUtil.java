package integration;

import io.github.bonigarcia.wdm.PhantomJsDriverManager;

public class TestUtil {
    /**
     * Use the driver manager to install phantom and set the right system property
     */
    public static void setupPhantom() {
        PhantomJsDriverManager.getInstance().setup();
    }

    public static String getProperty(String name) {
        String prop = System.getProperty(name);

        if (isEmpty(prop)) {
            prop = System.getenv(name);
        }

        if (isEmpty(prop)) {
            throw new IllegalArgumentException("Property '" + name + "' not provided.");
        }

        return prop;
    }

    protected static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }
}
