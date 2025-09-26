package datasource;

import jakarta.persistence.*;

public class MariaDbJpaConnection {
    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("CurrencyMariaDbUnit");
    }

    public static EntityManager getInstance() {
        return emf.createEntityManager();
    }
}

