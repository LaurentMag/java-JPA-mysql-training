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

public abstract class RepositoryAbstract<T> {
    // ABSTRACT MANAGER C'EST UN REPOSITORY ( couche qui permet de communiquer avec la base de donnée )

    private Class<T> theClass;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public RepositoryAbstract(Class<T> theClass) {
        this.theClass = theClass;
    }

    //========================================================================

    // 'ouverture de sessions' => ouverture d'une transaction
    private void getManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    private void closeManager() {
        this.entityManager.close();
        this.entityManagerFactory.close();
    }

    //========================================================================
    public List<T> findAll() {
        this.getManager();

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(this.theClass);
        Root<T> root = query.from(this.theClass);
        query.select(root);

        return this.entityManager.createQuery(query).getResultList();
    }


    public T find(int id) {
        this.getManager();
        return this.entityManager.find(this.theClass, id);
        // not closing the manager there to have it pass it to the method using find
    }


    public void create(T entity) {
        this.getManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        this.closeManager();
    }

    public void update(T entity, int id) {
        // this.getManager();
        // pas besoin de getManager since we already has the one from .find()
        this.entityManager.getTransaction().begin();
        T entityToUpdate = this.entityManager.find(this.theClass, id);
        entityToUpdate = entity;
        this.entityManager.getTransaction().commit();
        this.closeManager();

    }

    public void delete(int id) {
        this.getManager();
        this.entityManager.getTransaction().begin();

        T entityToDelete = this.entityManager.find(this.theClass, id);
        this.entityManager.remove(entityToDelete);

        this.entityManager.getTransaction().commit();
        this.closeManager();
    }


}

