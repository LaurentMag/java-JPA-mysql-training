package dharmaproject.repository;

import dharmaproject.entities.SalleDeClass;
import dharmaproject.entities.Session;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class RepositorySession extends RepositoryAbstract<Session>{
    public RepositorySession(Class<Session> theClass) {
        super(theClass);
    }

/*    public List<Session> findByWhereSalle(SalleDeClass salle) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Session> query = builder.createQuery(Session.class);
        Root<Session> root = query.from(Session.class);
        query.select(root);
        query.where();

        return entityManager.createQuery(query).getResultList();
    }*/
}
