package restassured.util;

import org.apache.commons.lang3.StringUtils;
import java.util.Properties;

public class GetProperty {

    private static final String CONFIG_FILE = "./configuration.properties";

    private static String getPropertyValue(Properties properties, String propertyName) {
        if (StringUtils.isBlank(propertyName)) {
            throw new IllegalArgumentException("System property name cannot be null or blank");
        }
        final String propertyValue = properties.getProperty(propertyName);
        if (StringUtils.isNotBlank(propertyValue)) {
            return propertyValue;
        }
        else {
            throw new IllegalArgumentException(String.format(
                    "Environment variable '%s' does not exist or is blank", propertyValue));
        }
    }

    private static Properties getPropertyFileContent(String propertiesFileName) {
        return new ReadPropertyFile().getPropertiesValue(propertiesFileName);
    }

    public static String fromConfigProp(String prop) {
        return getPropertyValue(getPropertyFileContent(CONFIG_FILE), prop);
    }
}

