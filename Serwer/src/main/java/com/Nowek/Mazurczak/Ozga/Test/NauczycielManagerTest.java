package com.Nowek.Mazurczak.Ozga.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Nauczyciel;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.NauczycielDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.NauczycielManager;
/**
 * klasa testujaca NauczycielManager
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class NauczycielManagerTest {

	@Test
	/**
	 * Metoda testujca wszykie metody klasy NauczycielManager
	 */
	public void test() {
		Nauczyciel nau =new Nauczyciel("Kamil","Wojcik","dr","Kamil","123");
		if(!NauczycielManager.saveNauczyciel(nau)) {
			fail("nie udalo sie zapisac nauczyciela");
		}
		if(!NauczycielManager.getLog("Kamil", "123")) {
			fail("nie ma takich danych logowania");
		}
		if(NauczycielManager.getLogData("Kamil" ,"123")==null) {
			fail("nie ma takich danych logowania");
		}
		
		List<NauczycielDane>lista=NauczycielManager.getNauczycielList();
		if(lista.isEmpty()) {
			fail("lista jest pusta");
		}
		if(!NauczycielManager.removeNauczyciel(nau)) {
			fail("nie udalo sie usunac nauczyciela");
		}
	}

}
