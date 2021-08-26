package com.Nowek.Mazurczak.Ozga.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Przedmiot;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PrzedmiotDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.PrzedmiotManager;
/**
 * Klasa testujca PrzedmiotManager
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class PrzedmiotManagerTest {

	@Test
	/**
	 * metoda testujca wszykie metody klasy PrzedmiotManager
	 */
	public void test() {
		Przedmiot przed = new Przedmiot("Matma","Scisly");
		if(!PrzedmiotManager.savePrzedmiot(przed)) {
			fail("nie udalo sie dodac");
		}
		if(!PrzedmiotManager.removePrzedmiot(przed)){
			fail("nie udalo sie usunac");
		}
		List<PrzedmiotDane>lista=PrzedmiotManager.getPrzedmiotList();
		if(lista.isEmpty()) {
			fail("lista jest pusta");
		}
	}

}
