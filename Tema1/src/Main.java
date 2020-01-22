import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tema1.AngajatiEntity;
import tema1.CursuriEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    private static final SessionFactory ourSessionFactory;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o.toString());
//                }
//            }
//        } finally {
//            session.close();
//        }
        Meniu();
    }



    private static void Meniu() throws IOException {
        boolean loop = true;
        int optiune = 0;
        while (loop) {
            System.out.println("1. Gestionare angajati");
            System.out.println("2. Gestionare cursuri");
            System.out.println("3. Afisarea tuturor angajatilor unei firme");
            System.out.println("4. Afisarea angajatilor care au o vechime mai mare decat o valoare introdusa");
            System.out.println("5. Afisarea angajatilor care au urmat un curs specificat");
            System.out.println("0. Iesire");
            System.out.println("");
            System.out.println("Alege optiune:");

            try {
                optiune = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException ex) {
                System.err.println("Format invalid");
                continue;
            }

            switch (optiune) {
                case 1:
                    GestionareAngajati();
                    break;
                case 2:
                    GestionareCursuri();
                    break;
                case 3: AfisareAngajatiFirma();
                    break;
                case 4: AfisareAngajatiVechime();
                    break;
                case 5:
                    AfisareAngajatiCurs();
                    break;
                default:
                    loop = false;
                    break;
            }
        }
    }

    private static void GestionareAngajati() {
        int optiune = 0;

        System.out.println("1. Introdu angajat");
        System.out.println("2. Cauta angajat");
        System.out.println("3. Sterge angajat");
        System.out.println("4. Modificat angajat");

        System.out.println("");
        System.out.println("Alege optiune:");

        try {
            optiune = Integer.parseInt(br.readLine());

            switch (optiune) {
                case 1:
                    AngajatiEntity angajatNou = new AngajatiEntity();
                    System.out.print("Nume: ");
                    angajatNou.setNume(br.readLine());
                    System.out.print("Firma: ");
                    angajatNou.setFirma(br.readLine());
                    System.out.print("Functia:");
                    angajatNou.setFunctia(br.readLine());
                    System.out.print("Data angajarii (YYYY-MM-DD): ");

                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsedDate = dateFormat.parse(br.readLine());
                        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
                        angajatNou.setDataAngajarii(timestamp);
                    } catch(Exception e) { //this generic but you can control another types of exception
                        // look the origin of excption
                        angajatNou.setDataAngajarii(new Timestamp(System.currentTimeMillis()));
                    }

                    AddAngajat(angajatNou);
                    break;
                case 2:
                    System.out.println("Introdu nume: ");
                    String nume = br.readLine();
                    AngajatiEntity angajat = GetAngajat(nume);
                    if (angajat != null) {
                        System.out.println(angajat.toString());
                    } else {
                        System.out.println("Nu a fost gasit angajatul " + nume);
                    }
                    break;
                case 3:
                    System.out.print("Introdu id angajat: ");
                    Integer id = Integer.parseInt(br.readLine());
                    DeleteAngajat(id);
                    break;
                case 4:
                    System.out.print("Introdu nume angajat: ");
                    AngajatiEntity angajatEdit = GetAngajat(br.readLine());
                    if (angajatEdit == null) {
                        return;
                    }
                    System.out.print("Nume: ");
                    angajatEdit.setNume(br.readLine());
                    System.out.print("Firma: ");
                    angajatEdit.setFirma(br.readLine());
                    System.out.print("Functia:");
                    angajatEdit.setFunctia(br.readLine());
                    System.out.print("Data angajarii (YYYY-MM-DD): ");
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date parsedDate = dateFormat.parse(br.readLine());
                        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
                        angajatEdit.setDataAngajarii(timestamp);
                    } catch(Exception e) { //this generic but you can control another types of exception
                        // look the origin of excption
                        angajatEdit.setDataAngajarii(new Timestamp(System.currentTimeMillis()));
                    }

                    ModificaAngajat(angajatEdit);

                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void GestionareCursuri() {
        int optiune = 0;

        System.out.println("1. Introdu curs");
        System.out.println("2. Cauta curs");
        System.out.println("3. Sterge curs");
        System.out.println("4. Modificare curs");

        System.out.println("");
        System.out.println("Alege optiune:");

        try {
            optiune = Integer.parseInt(br.readLine());

            switch (optiune) {
                case 1:
                    CursuriEntity cursNou = new CursuriEntity();
                    System.out.print("Denumire: ");
                    cursNou.setDenumire(br.readLine());
                    System.out.print("Numar Ore: ");
                    cursNou.setNumarOre(Integer.parseInt(br.readLine()));
                    System.out.print("Valoare: ");
                    cursNou.setValoare(Integer.parseInt(br.readLine()));
                    System.out.print("Diploma absolvire (0/1): ");
                    cursNou.setDiplomaAbsolvire(Integer.parseInt(br.readLine()));
                    System.out.print("Anul: ");
                    cursNou.setAnul(Integer.parseInt(br.readLine()));
                    System.out.print("ID Angajat: ");
                    cursNou.setIdAngajat(Integer.parseInt(br.readLine()));


                    AddCurs(cursNou);
                    break;
                case 2:
                    System.out.println("Introdu denumire: ");
                    String nume = br.readLine();
                    CursuriEntity curs = GetCurs(nume);
                    if (curs != null) {
                        System.out.println(curs.toString());
                    } else {
                        System.out.println("Nu a fost gasit cursul " + nume);
                    }
                    break;
                case 3:
                    System.out.print("Introdu id curs: ");
                    Integer id = Integer.parseInt(br.readLine());
                    DeleteCurs(id);
                    break;
                case 4:
                    System.out.println("Introdu denumire: ");
                    CursuriEntity cursEdit = GetCurs(br.readLine());
                    if (cursEdit == null) {
                        return;
                    }
                    System.out.print("Denumire: ");
                    cursEdit.setDenumire(br.readLine());
                    System.out.print("Numar Ore: ");
                    cursEdit.setNumarOre(Integer.parseInt(br.readLine()));
                    System.out.print("Valoare: ");
                    cursEdit.setValoare(Integer.parseInt(br.readLine()));
                    System.out.print("Diploma absolvire (0/1): ");
                    cursEdit.setDiplomaAbsolvire(Integer.parseInt(br.readLine()));
                    System.out.print("Anul: ");
                    cursEdit.setAnul(Integer.parseInt(br.readLine()));
                    System.out.print("ID Angajat: ");
                    cursEdit.setIdAngajat(Integer.parseInt(br.readLine()));
                    ModificaCurs(cursEdit);
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void AfisareAngajatiFirma() {
        System.out.println("Introduceti firma: ");
        try {
            String firma = br.readLine();
            String query = "where firma like '".concat(firma).concat("'");
            List<AngajatiEntity> angajati = GetAngajati(query);
            for (AngajatiEntity a:angajati)
                  {
                System.out.println(a.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void AfisareAngajatiVechime() {
        System.out.println("Introduceti vechimea dorita (ani): ");
        try {
            int ani = Integer.parseInt(br.readLine());
            Date timestamp = new Date(System.currentTimeMillis());
            Calendar cal = Calendar.getInstance();
            cal.setTime(timestamp);
            cal.add(Calendar.YEAR, -ani);
            timestamp.setTime(cal.getTime().getTime()); // or

            String query = "where dataAngajarii <= '" + new SimpleDateFormat("yyyy-MM-dd").format(timestamp) + "'";

            List<AngajatiEntity> angajati = GetAngajati(query);
            for (AngajatiEntity a:angajati)
            {
                System.out.println(a.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void AfisareAngajatiCurs() throws IOException {
        Session session = getSession();
        Transaction tx =null;

        CursuriEntity diploma;
        System.out.println("Introdu denumire curs: ");
        String nume = br.readLine();
        diploma = GetCurs(nume);
        try
        {
            tx=	session.beginTransaction();
            Query query = session.createQuery("FROM CursuriEntity C where C.denumire=:denumire");
            query.setParameter("denumire", nume);
            List<CursuriEntity> cursuri= query.list();
            tx.commit();
            session = getSession();
            tx=	session.beginTransaction();
            for(CursuriEntity c:cursuri)
            {
                if(c.getDiplomaAbsolvire() == 1)
                {
                    Query query1 = session.createQuery("FROM AngajatiEntity A where A.id=:id");
                    query1.setParameter("id", c.getIdAngajat());
                    AngajatiEntity angajat = (AngajatiEntity) query1.uniqueResult();
                    if(angajat != null)
                    {
                        System.out.println(angajat.toString());
                    }
                }
            }
            tx.commit();
        }
        catch(HibernateException e)
        {
            if(tx !=null)
                tx.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    private static List<AngajatiEntity> GetAngajati(String queryText) {
        final Session session = getSession();
        try {
            String text = "from AngajatiEntity ".concat(String.valueOf(queryText));
            Query query = session.createQuery(text);
            List<AngajatiEntity> angajati = query.list();
            return angajati;
        } finally {
            session.close();
        }
    }

    private static AngajatiEntity GetAngajat(String nume) {
        final Session session = getSession();
        try {
            String text = "from AngajatiEntity where nume like '" + nume + "'";
            Query query = session.createQuery(text);
            try {
                AngajatiEntity angajat = (AngajatiEntity) query.getSingleResult();
                return angajat;
            }
            catch (Exception e) {
                return null;
            }
        } finally {
            session.close();
        }
    }

    private static void AddAngajat(AngajatiEntity angajat) {
        Session session = getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(angajat);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { session.close(); }
    }

    private static void DeleteAngajat(Integer id) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String text = "from AngajatiEntity where id = " + id;
            Query query = session.createQuery(text);
            try {
                AngajatiEntity a = (AngajatiEntity) query.getSingleResult();
                if (a != null) {
                    session.delete(a);
                    tx.commit();
                }
            }
            catch (Exception e) {
                System.out.println("Nu s-a sters nici un angajat (nu exista cu id-ul " + id);
            }
        }
        finally {
            session.close();
        }
    }

    private static void ModificaAngajat(AngajatiEntity angajat) {
        if (angajat == null) {
            return;
        }

        Session session = getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(angajat);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { session.close(); }
    }

    private static CursuriEntity GetCurs(String nume) {
        final Session session = getSession();
        try {
            String text = "from CursuriEntity where denumire like '" + nume + "'";
            Query query = session.createQuery(text);
            try {
                CursuriEntity curs = (CursuriEntity) query.getSingleResult();
                return curs;
            }
            catch (Exception e) {
                return null;
            }
        } finally {
            session.close();
        }
    }

    private static void AddCurs(CursuriEntity curs) {
        Session session = getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(curs);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { session.close(); }
    }

    private static void DeleteCurs(Integer id) {
        Session session = getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String text = "from CursuriEntity where idCurs = " + id;
            Query query = session.createQuery(text);
            try {
                CursuriEntity a = (CursuriEntity) query.getSingleResult();
                if (a != null) {
                    session.delete(a);
                    tx.commit();
                }
            }
            catch (Exception e) {
                System.out.println("Nu s-a sters nici un curs (nu exista cu id-ul " + id);
            }
        }
        finally {
            session.close();
        }
    }

    private static void ModificaCurs(CursuriEntity curs) {
        if (curs == null) {
            return;
        }

        Session session = getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(curs);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { session.close(); }
    }
}