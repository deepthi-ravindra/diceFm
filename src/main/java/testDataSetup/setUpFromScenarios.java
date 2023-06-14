package testDataSetup;

import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Properties;
import java.util.stream.Collectors;

public class setUpFromScenarios {
    public static Properties getBaseURLS() {
        String environment;
        try {
            environment = System.getProperty("environment").trim().toLowerCase();
        } catch (NullPointerException e) {
            throw new NullPointerException("environment system property not set");
        }

        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        Properties environmentProperties = environmentVariables.getPropertiesWithPrefix(environment + ".");
        Properties availableCountryURLs = new Properties();

        //Get all urls starting with above environment prefix
        availableCountryURLs.putAll(environmentProperties.entrySet().stream().filter(p -> p.getKey().toString().endsWith("base.url")).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue())));

        return availableCountryURLs;
    }
}
