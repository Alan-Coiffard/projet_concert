package concertDAO;

public class AbstractDAOFactory {

    /**
     * Renvoie la fabrique concr�te de DAO en fonction du support de persistance.
     * @param type le support de persistance � utiliser
     * @return la fabrique de DAO pour ce type de persistance
     */
    public static Concerts_JPA_DAOFactory getDAOFactory(PersistenceKind type) {
        if (type.equals(PersistenceKind.JPA)) {
            return new Concerts_JPA_DAOFactory();
        } else {
            return null;
        }
    }
}
