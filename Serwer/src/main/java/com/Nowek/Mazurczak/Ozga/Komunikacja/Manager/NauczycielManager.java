package com.Nowek.Mazurczak.Ozga.Komunikacja.Manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Nauczyciel;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.NauczycielDane;
/**
 * klasa odowiedzialna za nauczyciela w bazie danych
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class NauczycielManager {
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
	 * zapisuje nauczyciela do bazy danych przjmuje obiekt klasy nauczyciel
	 * @param naucz
	 * @return zwraca true jesli powodzenie inaczej false
	 */
	public static boolean saveNauczyciel(Nauczyciel naucz)
	{
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(naucz);
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
		
	}
	/**
	 * usuwa nauczyciela z bazy danych przyjmuje obiekt klasy nauczyciel
	 * @param naucz
	 * @return zwraca true jesli powodzenie inaczej false
	 */
	public static boolean removeNauczyciel(Nauczyciel naucz)
	{
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			Nauczyciel naucz1=entityManager.find(Nauczyciel.class,naucz.getIdNauczyciel());
			entityManager.remove(naucz1);
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	/**
	 * sprawdza czy istnieje login i haslo dla nauczyciela 
	 * @param login
	 * @param haslo
	 * @return zwraca true jesli powodzenie inaczej false
	 */
	public static boolean getLog(String login, String haslo)
	{
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		List<Nauczyciel> lista=(List<Nauczyciel>)entityManager.createQuery("from Nauczyciel").getResultList();
		for(Nauczyciel a:lista)
		{
			if(login.equals(a.getLogin()) && haslo.equals(a.getHaslo()))
			{
				return true;
			}
				
		}
		return false;
	}
	/**
	 * sprawdza czy istnieje login i haslo dla nauczyciela 
	 * @param login
	 * @param haslo
	 * @return zwraca nowego nauczyliela lub null
	 */
	public static NauczycielDane getLogData(String login, String haslo)
	{
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		List<Nauczyciel> lista=(List<Nauczyciel>)entityManager.createQuery("from Nauczyciel").getResultList();
		for(Nauczyciel a:lista)
		{
			if(login.equals(a.getLogin()) && haslo.equals(a.getHaslo()))
			{
				return new NauczycielDane(a.getIdNauczyciel(),a.getImie(),a.getNazwisko(),a.getStopien(),a.getLogin(),a.getHaslo());
			}
				
		}
		return null;
	}
	/**
	 * zwraca liste nauczycieli
	 * @return
	 */
	public static List<NauczycielDane> getNauczycielList()
	{
		List<NauczycielDane> listaa=new ArrayList<NauczycielDane>();
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		List<Nauczyciel> lista=(List<Nauczyciel>)entityManager.createQuery("from Nauczyciel").getResultList();
		for(Nauczyciel a:lista)
		{
			listaa.add(new NauczycielDane(a.getIdNauczyciel(),a.getImie(),a.getNazwisko(),a.getStopien(),a.getLogin(),a.getHaslo()));
		}
		return listaa;
	}
	
}
