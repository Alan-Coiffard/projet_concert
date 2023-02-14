package concertDAO;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * Connexion à la base de BDD à partir d'un fichier XML de configuration pour JPA.
 * @author Eric
 */
public class SQLConnection {

   /**
    * Configuration JPA
    */
    private static ConfigJPA config = null;
    
    /**
     * Connexion à la base de données, pour réaliser les requêtes SQL
     */
    private static Connection connection = null;
    
    /**
     * Nom et emplacement du fichier XML de configuration de JPA
     */
    private static String configFile = "src/main/java/concertDAO/configJPA.xml";
 
    /**
     * Charge le contenu du fichier XML de configuration.
     * @throws DAOException en cas de problème d'accès au fichier ou de 
     * lecture de son contenu
     */
    private static void loadConfigFile() throws DAOException {
        try {
            JAXBContext jc = JAXBContext.newInstance(concertDAO.ConfigJPA.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            config = (ConfigJPA)unmarshaller.unmarshal(new File(configFile));
        }
        catch(Exception ex) {
            throw new DAOException("Impossible de charger la configuration JPA ("+ex.getMessage()+")");
        }
    }
    
    /**
     * Renvoie la connexion vers le SGBD. Fonctionne en mode singleton : la connexion est instanciée une seule fois.
     * Utilise le fichier de config JPA par défaut se trouvant dans le package œ des sources.
     * @return la connexion JPA vers le SGBD
     * @throws DAOException en cas de problème
     */
    public static Connection getConnection() throws DAOException {
        try {
            if (config == null)loadConfigFile();
            if (connection == null)
                connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            return connection;
        } catch (SQLException ex) {
            throw new DAOException("Impossible de se connecter à la BDD ("+ex.getMessage()+")"); 
        }
    }
    
    /**
     * Renvoie la connexion vers le SGBD. Fonctionne en mode singleton : la connexion est instanciée une seule fois.
     * Utilise le fichier de config JPA passé en paramètre.
     * @param configFile nom du fichier XML de connexion JPA
     * @return la connexion JPA vers le SGBD
     * @throws DAOException en cas de problème
     */
    public static Connection getConnection(String configFile) throws DAOException {
        SQLConnection.configFile = configFile;
        return SQLConnection.getConnection();
    }
    
    /**
     * Ferme la connexion actuellement ouverte avec le SGBD.
     */
    public static void closeConnection() {
        if (connection != null) try {
            connection.close();
        } catch (SQLException ex) {
            // rien à faire
        }
        connection = null;
    }
}