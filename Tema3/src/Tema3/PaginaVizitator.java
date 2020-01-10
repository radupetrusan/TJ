package Tema3;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;

@WebServlet("/PaginaVizitator")
public class PaginaVizitator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	
	public PaginaVizitator() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();

		if((session.getAttribute("tip"))!=null)
		{
			int tip=Integer.parseInt(session.getAttribute("tip").toString());
			int id=Integer.parseInt(session.getAttribute("id").toString());
	
			try{
				Configuration configuration = new Configuration();
				configuration.configure();
				configuration.addAnnotatedClass(Masina.class);
				configuration.addAnnotatedClass(Utilizator.class);
				ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
				factory = configuration.buildSessionFactory(serviceRegistry);
			}
			catch(Throwable ex){
				System.err.println("Failed to create sessionFactory object." + ex);
				throw new ExceptionInInitializerError(ex);
			}

			out.print("<br><h1><center>Bine ai venit, "+ session.getAttribute("nume") +"</center></h1>");
			out.print("<br><br><br>");

			if(tip==2) //Operator
			{
				out.print("<center><form method ='GET' action='http://localhost:8080/Tema3/PaginaVizitator'>");
				out.print("<table border=2><tr><td> Numarul de inmatriculare </td><td><input type='text' name='nr_inma'></td></tr>");
				out.print("<tr><td> Marca </td><td><input type='text' name='marca'></td></tr>");
				out.print("<tr><td> Modelul </td><td><input type='text' name='modelul'></td></tr>");
				out.print("<tr><td> Culoarea </td><td><input type='text' name='culoarea'></td></tr>");
				out.print("<tr><td> Anul fabricatiei </td><td><input type='text' name='an_fabr'></td></tr>");
				out.print("<tr><td> Capacitatea cilindrica </td><td><input type='text' name='Capacitate'></td></tr>");
				out.print("<tr><td> Tipul de combustibil </td><td><select name='TipulComb'>"
						+ "<option value='motorina'>Motorina</option><option value='benzina'>Benzina</option></select></td></tr>");
				out.print("<tr><td> Puterea </td><td><input type='text' name='Puterea'></td></tr>");
				out.print("<tr><td> Cuplul </td><td><input type='text' name='Cuplul'></td></tr>");
				out.print("<tr><td> Volumul portbagajului </td><td><input type='text' name='VolumulP'></td></tr>");
				out.print("<tr><td> Pretul </td><td><input type='text' name='Pretul'></td></tr>");
				out.print("<tr align='center'><td colspan='2'><input type='submit' name='adauga' value ='Adauga'>"
						+ "<input type='submit' name='modifica' value ='Modifica'><input type='submit' name='sterge' value='Sterge'></td></tr>");
				out.print("</table></form></center>");
				
				String adauga=request.getParameter("adauga");
				String modifica=request.getParameter("modifica");
				String sterge=request.getParameter("sterge");
				
				String nr_inma="";
				String marcam="";
				String modelul="";
				String culoaream="";
				String an_fabr="0";
				String capacitate="0";
				String tipulcomb="0";
				String puterea="0";
				String cuplul="0";
				String VolumulP="0";
				String Pretul="0";

				if(request.getParameter("nr_inma")!="")
				{
					nr_inma=request.getParameter("nr_inma");
				}

				if(request.getParameter("marca")!="")
				{
					marcam=request.getParameter("marca");
				}

				if(request.getParameter("modelul")!="")
				{
					modelul=request.getParameter("modelul");
				}

				if(request.getParameter("culoarea")!="")
				{
					culoaream=request.getParameter("culoarea");
				}

				if(request.getParameter("an_fabr")!="")
				{
					an_fabr=request.getParameter("an_fabr");
				}

				if(request.getParameter("Capacitate")!="")
				{
					capacitate=request.getParameter("Capacitate");
				}

				if(request.getParameter("TipulComb")!="")
				{
					tipulcomb=request.getParameter("TipulComb");
				}

				if(request.getParameter("Puterea")!="")
				{
					puterea=request.getParameter("Puterea");
				}

				if(request.getParameter("Cuplul")!="")
				{
					cuplul=request.getParameter("Cuplul");
				}

				if(request.getParameter("VolumulP")!="")
				{
					VolumulP=request.getParameter("VolumulP");
				}

				if(request.getParameter("Pretul")!="")
				{
					Pretul=request.getParameter("Pretul");
				}

				if(adauga!=null)
				{
					Session session_adauga = factory.openSession();
					Transaction tx = null;

					try{
						if(nr_inma==null)
						{
							out.print("<center><br><font color='red'>Eroare! Nr inmatriculare nu a fost introdus!</font></center>");
						}
						else
						{
							tx = session_adauga.beginTransaction();
							Masina m= new Masina(nr_inma,id, marcam,modelul,culoaream,Integer.parseInt(an_fabr),Integer.parseInt(capacitate), 
									tipulcomb, Integer.parseInt(puterea), Integer.parseInt(cuplul), Integer.parseInt(VolumulP),Float.parseFloat(Pretul));
							System.out.print(m.toString());
							session_adauga.save(m);
							tx.commit();
							out.print("<center><br><font color='green'>Adaugare cu succes!</font></center>");
						}

					}
					catch (HibernateException e) {
						if (tx!=null) tx.rollback();
						e.printStackTrace();
					}
					finally { 
						session_adauga.close();
					}
				}
				else if(modifica!=null)
				{
					Session session_modifica = factory.openSession();
					Transaction tx = null;
					
					try{
						if(nr_inma==null)
						{
							out.print("<center><br><font color='red'>Eroare! Nr inmatriculare nu a fost introdus!</font></center>");
						}
						else
						{	
							tx = session_modifica.beginTransaction();
							Query query = session_modifica.createQuery("from Masina where nr_inmatriculare=:nr");
							query.setParameter("nr", nr_inma);
							Masina masina=(Masina)query.uniqueResult();

							if (masina!=null)
							{
								if(marcam!=null)
									masina.setMarca(marcam);
								if(modelul!=null)
									masina.setModelul(modelul);
								if(culoaream!=null)
									masina.setCuloarea(culoaream);
								if(an_fabr!=null)
									masina.setAnul_fabricatiei(Integer.parseInt(an_fabr));
								if(capacitate!="0")
									masina.setCapacitatea_cilindrica(Integer.parseInt(capacitate));
								if(tipulcomb!=null)
									masina.setTipul_de_combustibil(tipulcomb);
								if(puterea!="0")
									masina.setPuterea(Integer.parseInt(puterea));
								if(cuplul!="0")
									masina.setCuplul(Integer.parseInt(cuplul));
								if(VolumulP!="0")
									masina.setVolumul_portbagajului(Integer.parseInt(VolumulP));
								if(Pretul!="0")
									masina.setPret(Float.parseFloat(Pretul));								
								session_modifica.update(masina);
								out.print("<center><br><font color='green'>Modificare cu succes pentru masina " + nr_inma +"</font></center>");
								}
							else
							{
								out.print("<center><br><font color='red'>Masina cautata nu se gaseste!</font></center>");
							}
							tx.commit();
					}
					}
					catch (HibernateException e)
					{
						out.print("<center><br><font color='red'>Modificare fara succes!</font></center>");
						if (tx!=null) 
							tx.rollback();
						e.printStackTrace();
					}
					finally 
					{
						session_modifica.close();
					}
				}
				else if(sterge!=null)
				{
					if(nr_inma==null)
					{
						out.print("<center><br><font color='red'>Eroare! Nr inmatriculare nu a fost introdus!</font></center>");
					}
					else
					{ 
						int status=0;
						Session session_sterge = factory.openSession();
						Transaction tx = null;
						try{
							tx = session_sterge.beginTransaction();
							Query query=session_sterge.createQuery("FROM Masina");
							List<Masina> m1 = query.list(); 							
							for (Masina m:m1){
								if (m.getNr_inmatriculare().equalsIgnoreCase(nr_inma)){
									session_sterge.delete(m);
									out.print("<center><br><font color='green'>Stergere cu succes!</font></center>");
									status=1;
								}
							}
							if(status==0)
								out.print("<center><br><font color='red'>Masina cautata nu s-a gasit!</font></center>");
							tx.commit();
						}
						catch (HibernateException e) {
							if (tx!=null) tx.rollback();
							e.printStackTrace();
						}
						finally {
							session_sterge.close();
						}
						}
				}
			}
			
			String marca="";
			String culoarea="";
			String anFabric="";
			
			if(request.getParameter("Marca")!=null)
			{
				marca=request.getParameter("Marca");
			}
			
			if(request.getParameter("Culoarea")!=null)
			{
				culoarea=request.getParameter("Culoarea");
			}
			
			if(request.getParameter("AnFabric")!=null)
			{
				anFabric=request.getParameter("AnFabric");
			}

			out.print("<br><br><br>");
			out.print("<center><table border=2><tr><th><b> Nr de inmatriculare </b></th><th><b> Marca </b></th> "
					+ "<th><b> Modelul </b></th><th><b> Culoarea </b></th><th><b>  Anul fabricatiei </b></th> "
					+ "<th><b> Capacitatea cilindrica </b></th><th><b> Tipul de combustibil </b></th> "
					+ "<th><b> Puterea </b></th><th><b> Cuplul </b></th> "
					+ "<th><b> Volumul portbajului </b></th><th><b> Pretul </b></th></tr>");

			Session session1 = factory.openSession();
			Transaction tx = null;
			try{
				tx = session1.beginTransaction();
				Query query=null;

				if ( (marca =="") && (culoarea=="") && (anFabric=="") )
				{
					query = session1.createQuery("FROM Masina");
				}

				if ( (marca !="") && (culoarea=="") && (anFabric=="") )
				{
					query = session1.createQuery("FROM Masina where marca=:m");
					query.setParameter("m", marca);
				}
				
				if ( (marca =="") && (culoarea!="") && (anFabric=="") )
				{
					query = session1.createQuery("FROM Masina where culoarea=:c");
					query.setParameter("c", culoarea);
				}

				if ( (marca =="") && (culoarea =="") && (anFabric !="") )
				{
					query = session1.createQuery("FROM Masina where anul_fabricatiei =:an");
					query.setParameter("an", Integer.parseInt(anFabric));
				}

				if ( (marca !="") && (culoarea !="") && (anFabric=="") )
				{
					query = session1.createQuery("FROM Masina where marca=:m and culoarea=:c");
					query.setParameter("m", marca);
					query.setParameter("c", culoarea);
				}

				if ( (marca !="") && (culoarea=="") && (anFabric !="") )
				{
					query = session1.createQuery("FROM Masina where marca=:m and anul_fabricatiei =:an");
					query.setParameter("m", marca);
					query.setParameter("an", Integer.parseInt(anFabric));
				}

				if ( (marca =="") && (culoarea !="") && (anFabric !="") )
				{
					query = session1.createQuery("FROM Masina where culoarea=:c and anul_fabricatiei =:an");
					query.setParameter("c", culoarea);
					query.setParameter("an", Integer.parseInt(anFabric));
				}

				if ( (marca !="") && (culoarea !="") && (anFabric !="") )
				{
					query = session1.createQuery("FROM Masina where marca=:m and culoarea=:c and anul_fabricatiei =:an");
					query.setParameter("m", marca);
					query.setParameter("c", culoarea);
					query.setParameter("an", Integer.parseInt(anFabric));
				}

				List<Masina> masini=query.list();
				for(Masina a: masini)
				{
					out.print("<tr><td>"+ a.getNr_inmatriculare() + "</td>");
					out.print("<td>"+a.getMarca() + "</td>");
					out.print("<td>"+a.getModelul() + "</td>");
					out.print("<td>"+a.getCuloarea() + "</td>");
					out.print("<td>"+a.getAnul_fabricatiei() + "</td>");
					out.print("<td>"+a.getCapacitatea_cilindrica() + "</td>");
					out.print("<td>"+a.getTipul_de_combustibil() + "</td>");
					out.print("<td>"+a.getPuterea() + "</td>");
					out.print("<td>"+a.getCuplul() + "</td>");
					out.print("<td>"+a.getVolumul_portbagajului()+ "</td>");
					out.print("<td>"+a.getPret() + "</td></tr>");
				}
				out.print("</table></center>");
				tx.commit();

				out.print("<center><form method ='GET' action='http://localhost:8080/Tema3/PaginaVizitator'>");
				out.print("<p>Marca: <input type='text' value='"+marca+"'name='Marca'>"
						+ " Culoare: <input type='text' value='"+culoarea +"'name='Culoarea'>"
						+ " An fabricatie: <input type='text' value='"+anFabric+"'name='AnFabric'>"
						+ " <input type='submit' value ='Filtreaza'></p></form><br>");
				out.print("<a href='http://localhost:8080/Tema3/Logout'>Logout</a></center>");
			}
			catch (HibernateException e){
				if (tx!=null) tx.rollback();
				e.printStackTrace();
			}
			finally {
				session1.close();
			}
		}
		else
		{
			response.sendRedirect("Login.html");
		}
		//session.invalidate();
	}
}
