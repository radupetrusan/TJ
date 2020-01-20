package Tema3;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	int tip=0;
       
    public Login() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nume=null;
		int id=0;
		HttpSession session=request.getSession();
		
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Masina.class);
			configuration.addAnnotatedClass(Utilizator.class);
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			factory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Throwable ex){
			System.err.println("Failed to create sessionFactory object!" + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		String utilizator=request.getParameter("utilizator");
		String parola=request.getParameter("parola");
		validare_utilizator(utilizator, parola);
		
		Session session2 = factory.openSession();
		Transaction tx = null;
		try{
			tx = session2.beginTransaction();
			Query query = session2.createQuery("FROM Utilizator where utilizator=:u");
			query.setParameter("u", utilizator);
			Utilizator u=(Utilizator)query.uniqueResult();
			if (u!=null){
				nume=u.getNume();
				id=u.getId_utilizator();	
			}
		}
		catch (HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally {
			session2.close();
		}

		if((tip == 1) || (tip ==2)) //daca user si parola sunt corecte
		{
			session.setAttribute("tip", tip);
			session.setAttribute("id", id);
			session.setAttribute("nume", nume);
			session.setAttribute("utilizator", utilizator);
			response.sendRedirect("PaginaVizitator");
		}
		else if(tip==3) //daca user sau parola sunt incorecte
		{
			response.sendRedirect("Login_Esuat.html");	
		}
		else
		{
			response.sendRedirect("Login.html"); //initializare
		}
		tip=3;
	}

	private void validare_utilizator(String nume, String parola)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Utilizator where utilizator=:n and parola=:p");
			query.setParameter("n", nume);
			query.setParameter("p", parola);
			
			Utilizator u=(Utilizator)query.uniqueResult();
			if (u!=null){
				if(u.getNivel_acces()==1)
				{
					tip=1;
				}
				else if(u.getNivel_acces()==2)
				{
					tip=2;			
				}
			}
			tx.commit();
		}
		catch (HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}
