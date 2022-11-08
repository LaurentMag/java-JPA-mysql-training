package dharmaproject;

import dharmaproject.entities.*;
import dharmaproject.exception.DateInvalidException;
import dharmaproject.repository.*;
import dharmaproject.services.SessionService;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // ======================================
        RepositorySession reposession = new RepositorySession(Session.class);
        RepositoryStagiaire repostagiaire = new RepositoryStagiaire(Stagiaire.class);
        RepositorySalleDeClass reposalleClasse = new RepositorySalleDeClass(SalleDeClass.class);
        RepositoryLocalisation repoGeoPos = new RepositoryLocalisation(Localisation.class);

        RepositoryFormateur repoFormateur = new RepositoryFormateur(Formateur.class);
        RepositoryCompetences repoComp = new RepositoryCompetences(Competences.class);


        SessionService sessionService = new SessionService();
        // permet de faire une archi N tier et on va virer le repo pour passer avant par le service


        // ======================================

        // EASIER WAY TO SET DATE
        /*SimpleDateFormat simpleDateTest = new SimpleDateFormat("MM-DD-YYYY");
        Date nouvelleDate = simpleDateTest.parse("12-30-2000");*/

        //Date test = new Date("2023, 05, 23");
        // Date est barré parce que c'est déprécié mais apparemment ça fonctionne toujours
        // par contre créer un bug au niveau de la récupération de la date dans la base de donnée


        // =========================================================================================
        // PART 1
       /* Date cdaStart = new GregorianCalendar(2022, Calendar.MAY, 9).getTime();
        Date dEnd = new GregorianCalendar(2023, Calendar.MAY, 15).getTime();

        Session cda = new Session();
        cda.setNom("cda");
        cda.setNbreEleves(16);
        cda.setDateDebut(cdaStart);
        cda.setDateFin(dEnd);*/


        /*reposession.create(cda);

         cda = reposession.find(501);*/


        /*Stagiaire robert = new Stagiaire();
        robert.setNom("DuPuit");
        robert.setPrenom("Robert");
        robert.setEmail("robertPuit@gmail.com");
        robert.setSession(cda);*/
        // repostagiaire.create(robert);

        /*Stagiaire brenda = new Stagiaire();
        brenda.setNom("Makeup");
        brenda.setPrenom("Brenda");
        brenda.setEmail("makeBrenda@gmail.com");
        brenda.setSession(cda);*/
        // repostagiaire.create(brenda);


        /*List<Stagiaire> cdaStagiaireList = new ArrayList<>();
        cdaStagiaireList.add(robert);
        cdaStagiaireList.add(brenda);*/

        //cda.setListStagiaire(cdaStagiaireList);

        // =========================================================================================
        // PART 2

       /*Localisation lille = new Localisation();
        lille.setPosition("Lille");

        Localisation lyon = new Localisation();
        lyon.setPosition("Lyon");

        Localisation paris = new Localisation();
        paris.setPosition("Paris");


        SalleDeClass salle1 = new SalleDeClass();
        salle1.setNom("Salle 1");
        salle1.setCapacity(30);
        salle1.setLocalisation(lille);

        SalleDeClass salle2 = new SalleDeClass();
        salle2.setNom("Salle 2");
        salle2.setCapacity(10);
        salle2.setLocalisation(lille);

        SalleDeClass salle3 = new SalleDeClass();
        salle3.setNom("Salle 3");
        salle3.setCapacity(40);
        salle3.setLocalisation(lyon);

        SalleDeClass salle4 = new SalleDeClass();
        salle4.setNom("Salle 4");
        salle4.setCapacity(20);
        salle4.setLocalisation(lyon);

        SalleDeClass salle5 = new SalleDeClass();
        salle5.setNom("Salle 5");
        salle5.setCapacity(12);
        salle5.setLocalisation(paris);*/

        /*repoGeoPos.create(lille);
        repoGeoPos.create(lyon);
        repoGeoPos.create(paris);*/

        /*reposalleClasse.create(salle1);
        reposalleClasse.create(salle2);
        reposalleClasse.create(salle3);
        reposalleClasse.create(salle4);
        reposalleClasse.create(salle5);*/


        // ---------------------------------------------------------------------
        // 2

        /*Session poo = new Session();
        poo.setNom("poo");
        poo.setNbreEleves(20);
        poo.setDateDebut(cdaStart);
        poo.setDateFin(dEnd);*/

        // reposession.create(poo);


        /*poo = reposession.find(2451);
        cda = reposession.find(501);*/

        /*List<Session> listsession = new ArrayList<>();
        listsession.add(cda);
        listsession.add(poo);*/

       /* SalleDeClass salle1update = reposalleClasse.find(2201);
        salle1update.setListSession(listsession);
        reposalleClasse.update(salle1update, 2201);*/

       /* salle1 = reposalleClasse.find(2201);
        salle2 = reposalleClasse.find(2251);
        salle3 = reposalleClasse.find(2301);
        salle4 = reposalleClasse.find(2351);
        salle5 = reposalleClasse.find(2401);

        List<SalleDeClass> listeClassCDA = new ArrayList<>();
        listeClassCDA.add(salle1);
        listeClassCDA.add(salle2);
        listeClassCDA.add(salle3);

        List<SalleDeClass> listClassepoo = new ArrayList<>();
        listClassepoo.add(salle4);
        listClassepoo.add(salle5);*/

        /*SalleDeClass salle2update = reposalleClasse.find(2251);
        SalleDeClass salle3update = reposalleClasse.find(2301);
        SalleDeClass salle4update = reposalleClasse.find(2351);
        SalleDeClass salle5update = reposalleClasse.find(2401);*/

        // permet de rajouter un element directement
        // cda.setListSalles(new ArrayList<>(Collections.singleton(salle1)));

       /* Session cdaudpate = reposession.find(501);
        cdaudpate.setListSalles(listeClassCDA);
        reposession.update(cdaudpate, 501);*/

       /* Session pooupdate = reposession.find(2451);
        pooupdate.setListSalles(listClassepoo);
        reposession.update(pooupdate, 2451);*/


        Formateur formateur1 = new Formateur();
        formateur1.setNom("formateur1");

        Formateur formateur2 = new Formateur();
        formateur2.setNom("formateur2");


        Competences js = new Competences();
        js.setNom("javascript");
       // repoComp.create(js);

        Competences java = new Competences();
        java.setNom("Java");
        //repoComp.create(java);

        Competences css = new Competences();
        css.setNom("CSS");
        //repoComp.create(css);

        js = repoComp.find(3151);
        java = repoComp.find(3201);
        css = repoComp.find(3251);


        List<Competences> listCompFormateur1 = new ArrayList<>();
        listCompFormateur1.add(js);
        listCompFormateur1.add(css);

        List<Competences> listCompFormateur2 = new ArrayList<>();
        listCompFormateur2.add(js);
        listCompFormateur2.add(java);
        listCompFormateur2.add(css);

        formateur1.setListcompetences(listCompFormateur1);
        formateur2.setListcompetences(listCompFormateur2);

        //repoFormateur.create(formateur1);
        //repoFormateur.create(formateur2);

        Session session1 = reposession.find(501);
        Session session2 = reposession.find(2451);

        List<Session> sessionformateur1 = new ArrayList<>(Collections.singleton(session1));
        List<Session> sessionformateur2 = new ArrayList<>(Collections.singleton(session2));

        formateur1 = repoFormateur.find(3301);
        formateur1.setListSession(sessionformateur1);
        repoFormateur.update(formateur1, 3301);


        formateur2 = repoFormateur.find(3302);
        formateur2.setListSession(sessionformateur2);
        repoFormateur.update(formateur2, 3302);


    }
}
