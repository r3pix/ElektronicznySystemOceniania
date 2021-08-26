package com.Nowek.Mazurczak.Ozga.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Grupa;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.GrupaDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.GrupaManager;
/**
 * Klasa testujaca GrupaDane
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class GrupaDaneTest {

	@Test
	/**
	 * metoda tesujca wszykie metody klasy GrupaDane
	 */
	public void test() {
		Grupa grd = new Grupa("2ID14B");
		Grupa grd2 = new Grupa("2ID14A");
		List<GrupaDane> lista=GrupaManager.getGrupaList();
		if(lista.isEmpty()) {
			fail("lista jest pusta");
		}
		if(!GrupaManager.saveGrupa(grd)) {
			fail("Nie udalo sie zapisac grupy");
		}
		if(!GrupaManager.saveGrupa(grd2)) {
			fail("Nie udalo sie zapisac grupy");
		}
		
		if(!GrupaManager.removeGrupa(grd))
		{
			fail("nie udalo sie usunac grupy");
		}
		if(!GrupaManager.removeeGrupa("2ID14A")) {
			fail("nie udalo sie usunac grupy");
		}
	} 

}
