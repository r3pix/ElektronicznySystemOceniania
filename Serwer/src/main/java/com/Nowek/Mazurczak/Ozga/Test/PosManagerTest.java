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
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.NauczycielDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PosDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PrzedmiotDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.GrupaManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.NauczycielManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.OcenaManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.PosManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.PrzedmiotManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.StudentManager;
/**
 * klasa testujca PosManager
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class PosManagerTest {

	@Test
	/**
	 * metoda testujca wszykie metody klasy PosManager 
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
		
		Pos p = new Pos(nau.getIdNauczyciel(),przed.getIdPrzedmiot());
		
		PosDane pd = new PosDane(p.getIdPos(),nau.getIdNauczyciel(),przed.getIdPrzedmiot());
	
		if(!PosManager.savePos(p)) {
			fail("nie udalo sie dodac");
		}
		Ocena ocena = new Ocena(1,s.getIdStudent(),p.getIdPos(),(float) 4);
		
		OcenaManager.saveOcena(ocena);
		/**
		if(PosManager.getOcenaPos(pd)==null) {
			fail("nie udalo sie pobrac oceny");
		}
		**/
		if(PosManager.getNauczycielImie(pd)=="") {
			fail("nie udalo sie pobrac imienia");
		}
		
		if(PosManager.getNauczycielNaziwsko(pd)=="") {
			fail("nie udalo sie pobrac nazwiska");
		}
		
		if(PosManager.getPrzedmiotNazwa(pd)=="") {
			fail("nie udalo sie pobrac nazwy przedmiotu");
		}
		
		if(PosManager.getPrzedmiotTyp(pd)=="") {
			fail("nie udalo sie pobrac typu przeedmiotu");
		}
		
		List<PosDane> lista=PosManager.getPosList();
		
		if(lista.isEmpty()) {
			fail("lista jest pusta");
		}
		
		
		
		if(PosManager.getNauczycielPosList(pd).isEmpty()) {
			fail("lista jest pusta");
		}
		
		if(!OcenaManager.removeOcena(ocena)) {
			fail("nie udalo sie usunac oceny");
		}
		
		if(!PosManager.removePos(p)) {
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
