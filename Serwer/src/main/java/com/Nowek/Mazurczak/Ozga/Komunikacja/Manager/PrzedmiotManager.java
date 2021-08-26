package com.Nowek.Mazurczak.Ozga.Komunikacja.Manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Przedmiot;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PrzedmiotDane;
/**
 * obsluguje przedmiot w bazie danych 
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class PrzedmiotManager {
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
	 * zapisuje przedmiot do bazy danych 
	 * @param a
	 * @return zwraca true jesli operacja sie powiodla w przeciwnym wypadku false
	 */
	public static boolean savePrzedmiot(Przedmiot a)
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
	 * usuwa przedmoiot z bazy danych 
	 * @param a
	 * @return zwraca true jesli operacja sie powiodla w przeciwnym wypadku false
	 */
	public static boolean removePrzedmiot(Przedmiot a)
	{
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			Przedmiot b=entityManager.find(Przedmiot.class, a.getIdPrzedmiot());
			entityManager.remove(b);
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
	public static List<PrzedmiotDane> getPrzedmiotList()
	{
		List<PrzedmiotDane> listaa=new ArrayList<PrzedmiotDane>();
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		List<Przedmiot> lista=(List<Przedmiot>)entityManager.createQuery("from Przedmiot").getResultList();
		for(Przedmiot a:lista)
		{
			listaa.add(new PrzedmiotDane(a.getIdPrzedmiot(),a.getNazwa(),a.getTyp()));
		}
		return listaa;
	}
	
	
	
}
