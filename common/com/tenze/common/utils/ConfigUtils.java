package com.tenze.common.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigUtils {
    private static final HashMap<String, String> configMap = new HashMap();

    public ConfigUtils() {
    }

    public static HashMap getConfigMap() {
        return configMap;
    }

    public static String getValue(String key) {
        Iterator it = configMap.keySet().iterator();

        do {
            if (!it.hasNext()) {
                return "";
            }
        } while(!((String)it.next()).equalsIgnoreCase(key));

        return (String)configMap.get(key);
    }

    static {
        FileInputStream inputStream = null;

        try {
            System.out.println(System.getProperty("user.dir"));
            Properties propertie = new Properties();
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/config/config.properties");
            propertie.load(inputStream);
            inputStream.close();
            Enumeration enumeration = propertie.propertyNames();

            while(enumeration.hasMoreElements()) {
                String key = enumeration.nextElement().toString();
                String value = propertie.getProperty(key, "");
                configMap.put(key, value);
            }
        } catch (FileNotFoundException var15) {
            Logger.getLogger(ConfigUtils.class.getName()).log(Level.SEVERE, (String)null, var15);
        } catch (IOException var16) {
            Logger.getLogger(ConfigUtils.class.getName()).log(Level.SEVERE, (String)null, var16);
        } finally {
            try {
                inputStream.close();
            } catch (IOException var14) {
                Logger.getLogger(ConfigUtils.class.getName()).log(Level.SEVERE, (String)null, var14);
            }

        }

    }
}
