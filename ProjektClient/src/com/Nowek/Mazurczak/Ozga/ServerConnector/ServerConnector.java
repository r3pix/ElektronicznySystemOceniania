package com.Nowek.Mazurczak.Ozga.ServerConnector;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import org.apache.log4j.Logger;

import com.Nowek.Mazurczak.Ozga.Klient.Okno;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.ComList;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.GrupaDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.KlientLogin;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.NauczycielDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.OcenaDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PosDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PrzedmiotDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.StudentDane;
/**
 * Klasa w ktorej znajduja sie metody odpowidzialne za polaczenie pomiedzy klientem a serwerem
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class ServerConnector {
	private static final Logger logger=Logger.getLogger(ServerConnector.class);
	private static Socket socket = null;
	private static ObjectOutputStream output=null;
	private static ObjectInputStream input=null;  
	/**
	 * Tworzy nowe polaczenie 
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void initialize() throws UnknownHostException, IOException
	{
		socket=new Socket("localhost",52137);
		output=new ObjectOutputStream(socket.getOutputStream());
		input=new ObjectInputStream(socket.getInputStream());
		
	}
	/**
	 * Metoda zwraca liste z Nauczycielami
	 * @param a
	 * @return
	 */
	public static List<NauczycielDane> getNauczycielList(NauczycielDane a)
	{
		ComList lista=null;
		try {
			output.writeObject(a);
			lista = (ComList)input.readObject();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error(e1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return (List<NauczycielDane>)lista.getLista();
	}
	/**
	 * sprawdza czy dane
	 * @param a
	 * @return
	 */
	public static boolean sendNauczyciel(NauczycielDane a)
	{
		boolean result=false;
		try {
			output.writeObject(a);
			KlientLogin klt=(KlientLogin)input.readObject();
			if(klt.isCorrect())
				result=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return result;
		
	}
	
	public static boolean sendGrupa(GrupaDane a)
	{
		boolean result=false;
		try {
			output.writeObject(a);
			KlientLogin klt=(KlientLogin)input.readObject();
			if(klt.isCorrect())
				result=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return result;
	}
	
	public static List<GrupaDane> getGrupaList(GrupaDane a)
	{
		ComList lista=null;
		try {
			output.writeObject(a);
			lista = (ComList)input.readObject();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error(e1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return (List<GrupaDane>)lista.getLista();
	}
	
	public static boolean sendPrzedmiot(PrzedmiotDane a)
	{
		boolean result=false;
		try {
			output.writeObject(a);
			KlientLogin klt=(KlientLogin)input.readObject();
			if(klt.isCorrect())
				result=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return result;
	}
	
	public static List<PrzedmiotDane> getPrzedmiotList(PrzedmiotDane a)
	{
		ComList lista=null;
		try {
			output.writeObject(a);
			lista = (ComList)input.readObject();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error(e1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return (List<PrzedmiotDane>)lista.getLista();
	}
	
	public static boolean sendStudent(StudentDane a)
	{
		boolean result=false;
		try {
			output.writeObject(a);
			KlientLogin klt=(KlientLogin)input.readObject();
			if(klt.isCorrect())
				result=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return result;
	}
	
	public static List<StudentDane> getStudentList(StudentDane a)
	{
		ComList lista=null;
		try {
			output.writeObject(a);
			lista = (ComList)input.readObject();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error(e1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return (List<StudentDane>)lista.getLista();
	}
	
	public static List<OcenaDane> getOcenaStudentList(StudentDane a)
	{
		ComList lista=null;
		try {
			output.writeObject(a);
			lista = (ComList)input.readObject();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error(e1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return (List<OcenaDane>)lista.getLista();
	}
	
	public static List<OcenaDane> getOcenaNauczycielList(NauczycielDane a)
	{
		ComList lista=null;
		try {
			output.writeObject(a);
			lista = (ComList)input.readObject();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error(e1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return (List<OcenaDane>)lista.getLista();
	}
	
	public static List<OcenaDane> getOcenaList(OcenaDane a)
	{
		ComList lista=null;
		try {
			output.writeObject(a);
			lista = (ComList)input.readObject();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error(e1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return (List<OcenaDane>)lista.getLista();
	}
	
	
	public static StudentDane getStudentLog(KlientLogin a)
	{
		StudentDane stud=null;
		try {
			output.writeObject(a);
			KlientLogin klt=(KlientLogin)input.readObject();
			if(klt.isCorrect())
				stud=klt.getStud();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return stud;
	}
	public static NauczycielDane getNauczycielLog(KlientLogin a)
	{
		NauczycielDane naucz=null;
		try {
			output.writeObject(a);
			KlientLogin klt=(KlientLogin)input.readObject();
			if(klt.isCorrect())
				naucz=klt.getNaucz();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return naucz;
	}
	
	public static boolean sendPos(PosDane a)
	{
		boolean result=false;
		try {
			output.writeObject(a);
			KlientLogin klt=(KlientLogin)input.readObject();
			if(klt.isCorrect())
				result=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return result;
	}
	
	public static List<PosDane> getPosList(PosDane a)
	{
		ComList lista=null;
		try {
			output.writeObject(a);
			lista = (ComList)input.readObject();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			logger.error(e1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return (List<PosDane>)lista.getLista();
	}
	
	public static boolean sendOcena(OcenaDane a)
	{
		boolean result=false;
		try {
			output.writeObject(a);
			KlientLogin klt=(KlientLogin)input.readObject();
			if(klt.isCorrect())
				result=true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return result;
	}
	
	
	public static void test()
	{
		try {
			output.writeObject(new KlientLogin("login","haslo"));
			KlientLogin klt=(KlientLogin)input.readObject();

			System.out.println("Czy zalogowano: "+klt.isCorrect());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		while(true) {}
	}
	
}
