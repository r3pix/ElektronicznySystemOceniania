package com.Nowek.Mazurczak.Ozga.Komunikacja.Manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Student;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.StudentDane;

/**
 * obluguje student w bazie danych 
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class StudentManager {
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
	 * zapisuje studenta do bazy danych 
	 * @param a
	 * @return zwraca true jesli operacja sie powiodla w przeciwnym wypadku false
	 */
	public static boolean saveStudent(Student a)
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
	 * usuwa studenta z bazy danych 
	 * @param a
	 * @return zwraca true jesli operacja sie powiodla w przeciwnym wypadku false
	 */
	public static boolean removeStudent(Student a)
	{
		try
		{
			entityManager=getEntityManager();
			entityManager.getTransaction().begin();
			Student b=entityManager.find(Student.class, a.getIdStudent());
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
	 * sprawdza czy dane logowania studenta sa w bazie i czy sie zgadzaja 
	 * @param login
	 * @param haslo
	 * @return zwraca true jesli operacja sie powiodla w przeciwnym wypadku false
	 */
	public static boolean getLog(String login, String haslo)
	{
		
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		List<Student> lista=(List<Student>)entityManager.createQuery("from Student").getResultList();
		for(Student a:lista)
		{
			if(login.equals(a.getLogin()) && haslo.equals(a.getHaslo()))
			{
				return true;
			}
			
		}
		return false;
	}
	/**
	 * Sprawdza czy istnieja dane w bazie 
	 * @param login
	 * @param haslo
	 * @return  zwraca nowego studenta jesli sie powiedzie inaczej null
	 */
	public static StudentDane getLogData(String login, String haslo)
	{
		
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		List<Student> lista=(List<Student>)entityManager.createQuery("from Student").getResultList();
		for(Student a:lista)
		{
			if(login.equals(a.getLogin()) && haslo.equals(a.getHaslo()))
			{
				return new StudentDane(a.getIdStudent(),a.getImie(),a.getNazwisko(),a.getPesel(),a.getLogin(),a.getHaslo(),a.getIdGrupa());
			}
			
		}
		return null;
	}
	/**
	 * zwraca liste studentow
	 * @return
	 */
	public static List<StudentDane> getStudentList()
	{
		List<StudentDane> listaa=new ArrayList<StudentDane>();
		entityManager=getEntityManager();
		@SuppressWarnings("unchecked")
		List<Student> lista=(List<Student>)entityManager.createQuery("from Student").getResultList();
		for(Student a:lista)
		{
			listaa.add(new StudentDane(a.getIdStudent(),a.getImie(),a.getNazwisko(),a.getPesel(),a.getLogin(),a.getHaslo(),a.getIdGrupa()));
		}
		return listaa;
	}
}
