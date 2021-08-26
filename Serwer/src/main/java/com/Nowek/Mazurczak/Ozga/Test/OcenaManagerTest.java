package com.Nowek.Mazurczak.Ozga.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Grupa;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Nauczyciel;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Ocena;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Pos;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Przedmiot;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Student;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.OcenaDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.GrupaManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.NauczycielManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.OcenaManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.PosManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.PrzedmiotManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.StudentManager;
/**
 * klasa testuja OcenaManager
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class OcenaManagerTest {

	@Test
	/**
	 * Metoda testujaca wszykie metody OcenaManager
	 */
	public void test() {
		Nauczyciel nau =new Nauczyciel("Kamil","Wojcik","dr","Kamil","123");
		NauczycielManager.saveNauczyciel(nau);
		Przedmiot przed = new Przedmiot("Wloski","jezyk");
		PrzedmiotManager.savePrzedmiot(przed);
		Grupa g = new Grupa("2ID14B");
		GrupaManager.saveGrupa(g);
		Student s = new Student("Wiktor","Mazurczak","00","Danza","123", g.getIdGrupa());
		StudentManager.saveStudent(s);
		Pos pos = new Pos(nau.getIdNauczyciel(),przed.getIdPrzedmiot());
		PosManager.savePos(pos);
		Ocena ocena = new Ocena(5,s.getIdStudent(),pos.getIdPos(),5);
		
		if(!OcenaManager.saveOcena(ocena))
			fail("nie udalo sie zapisac oceny");
		
		List<OcenaDane> ocenadane=OcenaManager.getOcenaList();
		
		List<OcenaDane> studentow=OcenaManager.getOcenaStudentList(s);
		
		List<OcenaDane> nauczycieli=OcenaManager.getOcenaNauczycielList(nau);
		
		if(ocenadane.isEmpty()) {
			fail("lista  jest pusta");
		}
		if(studentow.isEmpty()) {
			fail("lista jest pusta");
		}
		
		if(nauczycieli.isEmpty()) {
			fail("lista jest pusta");
		}
		
		if(!OcenaManager.removeOcena(ocena)) {
			fail("nie udalo sie usunac oceny");
		}
		if(!PosManager.removePos(pos)) {
			fail("nie udalo sie usunac");
		}
		if(!StudentManager.removeStudent(s)) {
			fail("nie udalo sie usunac studenta");
		}
		if(!GrupaManager.removeGrupa(g)) {
			fail("nie udalo sie usunac gr");
		}
		if(!PrzedmiotManager.removePrzedmiot(przed)) {
			fail("nie udalo sie usunac przedmiotu");
		}
		if(!NauczycielManager.removeNauczyciel(nau)) {
			fail("nie udalo sie usunac nauczyciela");
		}
	}

}
