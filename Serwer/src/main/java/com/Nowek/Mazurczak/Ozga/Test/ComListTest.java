package com.Nowek.Mazurczak.Ozga.Test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.ComList;
/**
 * Klasa testujaca Comlist 
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class ComListTest {
@Test
/**
 * metoda testujaca metody Comlist
 */
	public void test() {
		List<String> lista =new ArrayList<String>();
		lista.add("jeden");
		lista.add("dwa");
		lista.add("trzy");
		
		ComList com =new ComList(lista);
		if(!lista.equals(com.getLista())) {
			fail("nie udalo sie pobrac listy");
		}
	}

}
