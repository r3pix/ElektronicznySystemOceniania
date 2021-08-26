package com.Nowek.Mazurczak.Ozga.Komunikacja.Manager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Nauczyciel;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Ocena;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Student;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.OcenaDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PosDane;
/**
 * Obsluguje ocena w bazie danych
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class OcenaManager {
	static EntityManagerFactory factory=Persistence.createEntityManagerFactory("Serwer");
	static EntityManager entityManager;
	/**
	 * nowy sesja do bazy daynch 
	 * @return
	 */
	public static EntityManager getEntityManager()
	{
		return factory.createEntityManager();
	}
	/**
	 * zapisuje ocene do bazy danych 
	 * @param ocena
	 * @return zwraca true jesli operacja sie powiodla w przeciwnym wypadku false
	 */
	public static boolean saveOcena(Ocena ocena)
	{
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(ocena);
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
		
	}
	/**
	 * usuwa ocene z bazy danych 
	 * @param ocena
	 * @return zwraca true jesli operacja sie powiodla w przeciwnym wypadku false
	 */
	public static boolean removeOcena(Ocena ocena)
	{
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			Ocena ocena1=entityManager.find(Ocena.class,ocena.getIdOcena());
			entityManager.remove(ocena1);
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	/**
	 * zwraca liste ocen z bazy danych
	 * @return
	 */
	public static List<OcenaDane> getOcenaList()
	{
		PosDane pos=new PosDane();
		List<OcenaDane> listaa=new ArrayList<OcenaDane>();
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		List<Ocena> lista=entityManager.createQuery("from Ocena").getResultList();
		for(Ocena c:lista)
		{
			
			//System.out.println(c[0]);
			//System.out.println(c[1]);
			//System.out.println(c[2]);
			listaa.add(new OcenaDane(c.getIdOcena(),c.getWaga(),c.getIdStudent(),c.getIdPos(),c.getOcena()));
		}
		
		
		for(OcenaDane bb:listaa)
		{
			pos.setIdPos(bb.getIdPos());
			pos=PosManager.getOcenaPos(pos);
			bb.setImie(PosManager.getNauczycielImie(pos));
			bb.setNazwisko(PosManager.getNauczycielNaziwsko(pos));
			bb.setNazwa(PosManager.getPrzedmiotNazwa(pos));
			bb.setTyp(PosManager.getPrzedmiotTyp(pos));
		}
		return listaa;
	}
	/**
	 * zwraca liste ocen studenta
	 * @param a
	 * @return
	 */
	public static List<OcenaDane> getOcenaStudentList(Student a)
	{
		BigDecimal a1,b1,c1,d1,e1;
		PosDane pos=new PosDane();
		List<OcenaDane> listaa=new ArrayList<OcenaDane>();
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		
		List<Object[]> lista=entityManager.createNativeQuery("Select Ocena.idOcena, Ocena.Waga, Ocena.idStudent, Ocena.idPos,Ocena.ocena from Ocena where Ocena.idStudent="+a.getIdStudent()).getResultList();
		for(Object[] c:lista)
		{
			a1=(BigDecimal)c[0];
			b1=(BigDecimal)c[1];
			c1=(BigDecimal)c[2];
			d1=(BigDecimal)c[3];
			e1=(BigDecimal)c[4];
			//System.out.println(c[0]);
			//System.out.println(c[1]);
			//System.out.println(c[2]);
			listaa.add(new OcenaDane(a1.intValue(),b1.intValue(),c1.intValue(),d1.intValue(),e1.floatValue()));
			
		}
		for(OcenaDane bb:listaa)
		{
			pos.setIdPos(bb.getIdPos());
			pos=PosManager.getOcenaPos(pos);
			bb.setImie(PosManager.getNauczycielImie(pos));
			bb.setNazwisko(PosManager.getNauczycielNaziwsko(pos));
			bb.setNazwa(PosManager.getPrzedmiotNazwa(pos));
			bb.setTyp(PosManager.getPrzedmiotTyp(pos));
		}
		return listaa;
		
		
		
	}	
		/**
		 * zwraca liste ocen danego nauczyciela
		 * @param a
		 * @return
		 */
		public static List<OcenaDane> getOcenaNauczycielList(Nauczyciel a)
		{
			BigDecimal a1,b1,c1,d1,e1;
		
			List<OcenaDane> listaa=new ArrayList<OcenaDane>();
			entityManager=getEntityManager();
			@SuppressWarnings("unchecked")
			
			List<Object[]> lista=entityManager.createNativeQuery("Select Ocena.idOcena, Ocena.Waga,Student.idStudent,Pos.idPos,Ocena.ocena,Student.nazwisko, Student.imie, Przedmiot.nazwa, przedmiot.typ from Nauczyciel join Pos on Nauczyciel.idNauczyciel=Pos.idNauczyciel join Przedmiot on Pos.idPrzedmiot=Przedmiot.idPrzedmiot join Ocena on Pos.idPos=Ocena.idPos join Student on Ocena.idStudent=Student.idStudent where Nauczyciel.idnauczyciel="+a.getIdNauczyciel()).getResultList();
			for(Object[] c:lista)
			{
				a1=(BigDecimal)c[0];
				b1=(BigDecimal)c[1];
				c1=(BigDecimal)c[2];
				d1=(BigDecimal)c[3];
				e1=(BigDecimal)c[4];
				//System.out.println(c[0]);
				//System.out.println(c[1]);
				//System.out.println(c[2]);
				listaa.add(new OcenaDane(a1.intValue(),b1.intValue(),c1.intValue(),d1.intValue(),e1.floatValue(),(String)c[5],(String)c[6],(String)c[7],(String)c[8]));
				
	
			}
		
		
		
		return listaa;
	}
	
	
}
