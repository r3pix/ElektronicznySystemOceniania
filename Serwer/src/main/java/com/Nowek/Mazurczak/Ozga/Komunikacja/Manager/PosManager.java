package com.Nowek.Mazurczak.Ozga.Komunikacja.Manager;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.internal.build.AllowSysOut;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Nauczyciel;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Ocena;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Pos;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Przedmiot;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PosDane;
/**
 * obluguje table posrednia w bazie danych 
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class PosManager {
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
	 * zapisuje dane do tabeli posredniej 
	 * @param a
	 * @return zwraca true jesli operacja sie powiodla w przeciwnym wypadku false
	 */
	public static boolean savePos(Pos a)
	{
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(a);
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
	 * @param a
	 * @return zwraca true jesli operacja sie powiodla w przeciwnym wypadku false
	 */
	public static boolean removePos(Pos a)
	{
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			Pos pos1=entityManager.find(Pos.class,a.getIdPos());
			entityManager.remove(pos1);
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}	
	/**
	 * zwraca imie nauczyciela przyjmuje obiekt klas PosDane
	 * @param a
	 * @return jesli sie powiedzie zwraca imie inaczej pusty string 
	 */
	public static String getNauczycielImie(PosDane a)
	{
		Nauczyciel naucz1=new Nauczyciel();
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			naucz1=entityManager.find(Nauczyciel.class,a.getIdNauczyciel());
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return "";
		}
		
		return naucz1.getImie();
	}
	/**
	 * zwraca nazwisko nauczyciela przyjmuje obiekt klas PosDane
	 * @param a
	 * @return jesli sie powiedzie zwraca imie inaczej pusty string 
	 */
	public static String getNauczycielNaziwsko(PosDane a)
	{
		Nauczyciel naucz1=new Nauczyciel();
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			naucz1=entityManager.find(Nauczyciel.class,a.getIdNauczyciel());
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return "";
		}
		
		return naucz1.getNazwisko();
	}
	/**
	 * zwraca ocene z tabeli posredniej i przyjmuje obiekt klas PosDane
	 * @param a
	 * @return jesli sie powiedzie zwraca pos1 inaczej zwraca null
	 */
	
	public static PosDane getOcenaPos(PosDane a)
	{
		Pos pos=new Pos();
		PosDane pos1=new PosDane();
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			pos=entityManager.find(Pos.class,a.getIdPos());
			entityManager.getTransaction().commit();
			pos1.setIdNauczyciel(pos.getIdNauczyciel());
			pos1.setIdPos(pos.getIdPos());
			pos1.setIdPrzedmiot(pos.getIdPrzedmiot());
		}
		catch(Exception e)
		{
			return null;
		}
		
		return pos1;
	}
	
	/**
	 * zwraca nazwe przedmiotu przyjmuje obiekt klasy PosDane
	 * @param a
	 * @return zwraca nazwe jesli sie powiedzie inaczej zwraca pusty string;
	 */
	public static String getPrzedmiotNazwa(PosDane a)
	{
		Przedmiot przed1=new Przedmiot();
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			przed1=entityManager.find(Przedmiot.class,a.getIdPrzedmiot());
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return "";
		}
		
		return przed1.getNazwa();
	}
	/**
	 * zwraca Typ  przedmiotu przyjmuje obiekt klasy PosDane 
	 * @param a
	 * @return zwraca typ jesli sie powiedzie inaczej zwraca pusty string;
	 */
	public static String getPrzedmiotTyp(PosDane a)
	{
		Przedmiot przed1=new Przedmiot();
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			przed1=entityManager.find(Przedmiot.class,a.getIdPrzedmiot());
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return "";
		}
		
		return przed1.getTyp();
	}
	/**
	 * zwraca liste z tablei posredniej 
	 * @return
	 */
	public static List<PosDane> getPosList()
	{
		List<PosDane> listaa=new ArrayList<PosDane>();
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		List<Pos> lista=(List<Pos>)entityManager.createQuery("from Pos").getResultList();
		for(Pos a:lista)
		{
			listaa.add(new PosDane(a.getIdPos(),a.getIdNauczyciel(),a.getIdPrzedmiot()));
		}
		for(PosDane b:listaa)
		{
			b.setImie(PosManager.getNauczycielImie(b));
			b.setNazwisko(PosManager.getNauczycielNaziwsko(b));
			b.setNazwa(PosManager.getPrzedmiotNazwa(b));
			b.setTyp(PosManager.getPrzedmiotTyp(b));
		}
		//dopisac pobieranie imienia,nazwiska i nazwy przedmiotu
		return listaa;
	}
	/**
	 * zwraca liste tabeli posredniej dla nauczyciela
	 * @param a
	 * @return
	 */
	public static List<PosDane> getNauczycielPosList(PosDane a)
	{
		BigDecimal a1,b1,c1;
		List<PosDane> listaa=new ArrayList<PosDane>();
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		//List<Pos> lista=(List<Pos>)entityManager.createQuery("from Pos").getResultList();
		
		
		
		List<Object[]> lista=entityManager.createNativeQuery("Select Pos.idPos, Pos.idNauczyciel, Pos.idPrzedmiot from Pos where Pos.idNauczyciel="+a.getIdNauczyciel()).getResultList();
		for(Object[] c:lista)
		{
			a1=(BigDecimal)c[0];
			b1=(BigDecimal)c[1];
			c1=(BigDecimal)c[2];
			//System.out.println(c[0]);
			//System.out.println(c[1]);
			//System.out.println(c[2]);
			listaa.add(new PosDane(a1.intValue(),b1.intValue(),c1.intValue()));
		}
		for(PosDane b:listaa)
		{
			b.setImie(PosManager.getNauczycielImie(b));
			b.setNazwisko(PosManager.getNauczycielNaziwsko(b));
			b.setNazwa(PosManager.getPrzedmiotNazwa(b));
			b.setTyp(PosManager.getPrzedmiotTyp(b));
		}
		//dopisac pobieranie imienia,nazwiska i nazwy przedmiotu
		return listaa;
	}
}
