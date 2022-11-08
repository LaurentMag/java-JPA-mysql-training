package dharmaproject.services;

import dharmaproject.entities.SalleDeClass;
import dharmaproject.entities.Session;
import dharmaproject.exception.DateInvalidException;
import dharmaproject.repository.RepositorySession;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.zip.DataFormatException;


// ARCHI N TIER ( ici on fait du 3 tiers )
public class SessionService {

    private RepositorySession repoSession;


    public SessionService() {
        this.repoSession = new RepositorySession(Session.class);
    }

    // =========================================

    public Session find(int id) {
        return repoSession.find(id);
    }

    public List<Session> findAll() {
        return this.repoSession.findAll();
    }

    public void create(Session session) throws DateInvalidException {
        //this.repoSession.create(session);
        if (this.datecompare(session)) {
            this.repoSession.create(session);
        } else {
            throw new DateInvalidException("La date de fin doit être sup à la date de début de formation");
        }
        System.out.println(session);
    }


    public void update(Session session) {
        this.repoSession.update(session, session.getId());
    }

    public void delete(Session session) {
        this.repoSession.delete(session.getId());
    }

    // =========================================


    public boolean datecompare(Session session) {
        return (session.getDateDebut().before(session.getDateFin()) ? true : false);
    }

/*    private boolean emptyClass(Session session) {
        List<SalleDeClass> s = session.getListSalles();
        List<Session> lesSessions = this.findAll();

        Boolean isPresent = false;

        for ()

        return true;
    }*/




}
