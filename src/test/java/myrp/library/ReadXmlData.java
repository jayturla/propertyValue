package myrp.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class ReadXmlData {
    public String value;

    public String data(String node) {
        try {
            File file = new File("src/test/java/myrp/library/testdata.xml");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.loadFromXML(fileInput);
            fileInput.close();
            @SuppressWarnings("rawtypes")
			Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                if (((String) enuKeys.nextElement()).contains(node)) {
                    value = properties.getProperty(node);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}