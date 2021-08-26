package com.Nowek.Mazurczak.Ozga.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.Nowek.Mazurczak.Ozga.Klient.Okno;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Grupa;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Nauczyciel;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Ocena;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Pos;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Przedmiot;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Student;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.ComList;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.GrupaDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.KlientLogin;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.NauczycielDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.OcenaDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PosDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PrzedmiotDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.StudentDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.GrupaManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.NauczycielManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.OcenaManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.PosManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.PrzedmiotManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.StudentManager;
import org.apache.log4j.Logger;
/**
 * Klasa odpowiada za wszykie operacje przeprowadzane na serwerze 
 * @author Nowek.Mazurczak.Ozga.Serverg
 *
 */
public class ServerOperator extends Thread{
	private Socket socket=null;
	private ObjectOutputStream output=null;
	private ObjectInputStream input=null;
	private static final Logger logger=Logger.getLogger(ServerOperator.class);
	/**
	 * Konstruktor ktory przyjmuje obiekt klasy Socket i ustawia go
	 * @param socket
	 * @throws IOException
	 */
	public ServerOperator(Socket socket) throws IOException
	{
		this.socket=socket;
		output=new ObjectOutputStream(socket.getOutputStream());
		input=new ObjectInputStream(socket.getInputStream());
	}
	@Override
	/**
	 * Medota ktora uruchamiana jest wielowatkowo
	 * Obsuga wszykich klas zwiazanych z transportem danych
	 * 
	 */
	public void run()
	{
		while(true)
		{
			try {
				Object obj=input.readObject();
				if(obj instanceof KlientLogin)
				{
					klientLogin((KlientLogin) obj); 
				}
				else if(obj instanceof NauczycielDane)
				{
					nauczycielDane((NauczycielDane) obj);
				}
				else if(obj instanceof GrupaDane)
				{
					grupaDane((GrupaDane)obj);
					
				}
				else if(obj instanceof PrzedmiotDane)
				{
					przedmiotDane((PrzedmiotDane)obj);
					
				}
				else if(obj instanceof StudentDane)
				{
					studentDane((StudentDane)obj);
					
					
				}
				else if(obj instanceof PosDane)
				{
					posDane((PosDane)obj);
					
				}
				else if(obj instanceof OcenaDane)
				{
					ocenaDane((OcenaDane)obj);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				logger.error("ERROR",e);
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("Polaczenie zamkniete");
				break;
				// TODO Auto-generated catch block
				
			}
		}
	}
	/**
	 * Metoda przjmuje obiekt klasy KlientLogin i odpowiada za logowanie zwrocenie odpowiedzi i dane zalogowanego uzytkownika
	 * @param klt
	 * @throws IOException
	 */
private void klientLogin(KlientLogin klt) throws IOException {
	if(klt.isStudent())
	{
		output.writeObject(new KlientLogin(StudentManager.getLog(klt.getLogin(), klt.getHaslo()),StudentManager.getLogData(klt.getLogin(), klt.getHaslo())));
	}
	
	else
	{
		output.writeObject(new KlientLogin(NauczycielManager.getLog(klt.getLogin(), klt.getHaslo()),NauczycielManager.getLogData(klt.getLogin(), klt.getHaslo())));
	}
}
/**
 *  Metoda przyjmuje obiekt klasy NauczycielDane i odpowiadza za obsluge operacji zwiazanych z nauczycielem
 * @param klt
 * @throws IOException
 */
private void nauczycielDane(NauczycielDane klt) throws IOException {
	if(klt.getOperacja()==1)
	{
		KlientLogin log=new KlientLogin(NauczycielManager.saveNauczyciel(new Nauczyciel(klt)));
		output.writeObject(log);
	}
	else if(klt.getOperacja()==2)
	{
		KlientLogin log=new KlientLogin(NauczycielManager.removeNauczyciel(new Nauczyciel(klt)));
		output.writeObject(log);
	}
	else if(klt.getOperacja()==3)
	{
		ComList list=new ComList(NauczycielManager.getNauczycielList());
		output.writeObject(list);
	}
	else if(klt.getOperacja()==4)
	{
		ComList list=new ComList(OcenaManager.getOcenaNauczycielList(new Nauczyciel(klt)));
		output.writeObject(list);
	}
}
/**
 * Metoda przyjmuje obiekt klasy GrupaDane i odpowiada za operacje zwiazane z grupa
 * @param klt
 * @throws IOException
 */
private void grupaDane(GrupaDane klt) throws IOException {
	if(klt.getOperacja()==1)
	{
		KlientLogin log=new KlientLogin(GrupaManager.saveGrupa(new Grupa(klt)));
		output.writeObject(log);
	}
	else if(klt.getOperacja()==2)
	{
		KlientLogin log=new KlientLogin(GrupaManager.removeGrupa(new Grupa(klt)));
		output.writeObject(log);
	}
	else if(klt.getOperacja()==3)
	{
		ComList list=new ComList(GrupaManager.getGrupaList());
		output.writeObject(list);
	}
}
/**
 * Metoda przyjmuje obiekt klasy PrzedmiotDane i odpowiada za operacje zwiazane z przedmiotem 
 * @param klt
 * @throws IOException
 */
private void przedmiotDane(PrzedmiotDane klt) throws IOException {
	if(klt.getOperacja()==1)
	{
		KlientLogin log=new KlientLogin(PrzedmiotManager.savePrzedmiot(new Przedmiot(klt)));
		output.writeObject(log);
	}
	else if(klt.getOperacja()==2)
	{
		KlientLogin log=new KlientLogin(PrzedmiotManager.removePrzedmiot(new Przedmiot(klt)));
		output.writeObject(log);
	}
	else if(klt.getOperacja()==3)
	{
		ComList list=new ComList(PrzedmiotManager.getPrzedmiotList());
		output.writeObject(list);
	}
}
/**
 * Metoda przyjmuje obiekt klasy StudentDane i odpowiada za operacje zwiazane ze studentem
 * @param klt
 * @throws IOException
 */
private void studentDane(StudentDane klt) throws IOException {
	if(klt.getOperacja()==1)
	{
		KlientLogin log=new KlientLogin(StudentManager.saveStudent(new Student(klt)));
		output.writeObject(log);
	}
	else if(klt.getOperacja()==2)
	{
		KlientLogin log=new KlientLogin(StudentManager.removeStudent(new Student(klt)));
		output.writeObject(log);
	}
	else if(klt.getOperacja()==3)
	{
		ComList list=new ComList(StudentManager.getStudentList());
		output.writeObject(list);
	}
	else if(klt.getOperacja()==4)
	{
		ComList list=new ComList(OcenaManager.getOcenaStudentList(new Student(klt)));
		output.writeObject(list);
	}
}
/**
 * Metoda przyjmuje obiekt klasty PosDane i odpowiada za operacje zwiazane z tabela posrednia
 * @param klt
 * @throws IOException
 */
private void posDane(PosDane klt) throws IOException {
	if(klt.getOperacja()==1)
	{
		KlientLogin log=new KlientLogin(PosManager.savePos(new Pos(klt)));
		output.writeObject(log);
	}
	if(klt.getOperacja()==2)
	{
		KlientLogin log=new KlientLogin(PosManager.removePos(new Pos(klt)));
		output.writeObject(log);
	}
	if(klt.getOperacja()==3)
	{
		ComList list=new ComList(PosManager.getPosList());
		output.writeObject(list);
	}
	if(klt.getOperacja()==4)
	{
		//ComList list=new ComList(PosManager.getPosList());
		ComList list=new ComList(PosManager.getNauczycielPosList(klt));
		output.writeObject(list);
	}
}
/**
 * Metoda przyjmuje obiekt klasy OcenaDane i odpowiada za operacje zwiazane z ocena
 * @param klt
 * @throws IOException
 */
private void ocenaDane(OcenaDane klt) throws IOException {
	if(klt.getOperacja()==1)
	{
		KlientLogin log=new KlientLogin(OcenaManager.saveOcena(new Ocena(klt)));
		output.writeObject(log);
	}
	else if(klt.getOperacja()==2)
	{
		KlientLogin log=new KlientLogin(OcenaManager.removeOcena(new Ocena(klt)));
		output.writeObject(log);
	}
	else if(klt.getOperacja()==3)
	{
		ComList list=new ComList(OcenaManager.getOcenaList());
		output.writeObject(list);
	}
}
}

