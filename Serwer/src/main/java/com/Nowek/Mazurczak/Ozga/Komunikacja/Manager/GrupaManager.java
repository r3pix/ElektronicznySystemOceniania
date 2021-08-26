package com.Nowek.Mazurczak.Ozga.Komunikacja.Manager;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Grupa;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.GrupaDane;
/**
 * klasa odpowiedzialna za obuge grupy w bazie danych
 * @author Lee
 *
 */
public class GrupaManager {
	static EntityManagerFactory factory=Persistence.createEntityManagerFactory("Serwer");
	static EntityManager entityManager;
	/**
	 *nowy sesja do bazy daynch 
	 */
	public static EntityManager getEntityManager()
	{
		return factory.createEntityManager();
	}
	/**
	 * zapisuje grupe do bazy danych
	 * @param grup
	 * @return zwraca true jesli powodzenie inaczej false
	 */
	public static boolean saveGrupa(Grupa grup)
	{
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(grup);
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * usuwa grupe z bazy danej  przyjmuje obiekt klasy grupa
	 * @param a
	 * @return zwraca true jesli powodzenie inaczej false
	 */
	public static boolean removeGrupa(Grupa a)
	{
		
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			Grupa grupa=entityManager.find(Grupa.class, a.getIdGrupa());
			entityManager.remove(grupa);
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	/**
	 * usuwa grupe z bazy danej  przyjmuje nazwe grupy
	 * @param nazwa
	 * @return zwraca true jesli powodzenie inaczej false
	 */
	public static boolean removeeGrupa(String nazwa)
	{
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.createQuery("Delete from Grupa where Nazwa_grupy='"+nazwa+"'").executeUpdate();
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	/**
	 * zwraca liste grup z bazy danych
	 * @return
	 */
	public static List<GrupaDane> getGrupaList()
	{
		List<GrupaDane> lista=new ArrayList<GrupaDane>();
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		List <Grupa> grupy=(List<Grupa>)entityManager.createQuery("from Grupa").getResultList();
		for(Grupa a:grupy)
		{
			lista.add(new GrupaDane(a.getIdGrupa(),a.getNazwa_grupy()));
			
		}
		return lista;
		
	}

}
