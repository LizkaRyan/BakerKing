package mg.itu.bakerking.service;

import mg.itu.bakerking.dto.Config;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

@Service
public class ConfigService {
    private static final String FILE_PATH = "src/main/resources/config.properties";

    // Lire une propriété
    public Config readProperty() throws IOException {
        Properties properties = new Properties();
        Config config=null;
        try (FileInputStream input = new FileInputStream(FILE_PATH)) {
            properties.load(input);
            config = new Config(Double.parseDouble(properties.getProperty("commission.taux", "Propriété non trouvée")),
                                Double.parseDouble(properties.getProperty("commission.min", "Propriété non trouvée")));
        }
        return config;
    }

    // Modifier une propriété
    public void updateProperty(String key, String newValue) throws IOException {
        Properties properties = new Properties();

        // Charger le fichier .properties
        try (FileInputStream input = new FileInputStream(FILE_PATH)) {
            properties.load(input);
        }

        // Modifier la propriété
        if (properties.containsKey(key)) {
            properties.setProperty(key, newValue);
        } else {
            throw new IOException("Clé non trouvée : " + key);
        }

        // Réécrire le fichier avec les nouvelles données
        try (FileOutputStream output = new FileOutputStream(FILE_PATH)) {
            properties.store(output, null); // Le second paramètre peut être un commentaire
        }
    }
}
