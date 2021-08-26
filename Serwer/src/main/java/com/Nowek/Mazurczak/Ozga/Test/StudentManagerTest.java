package com.Nowek.Mazurczak.Ozga.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Grupa;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Student;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.GrupaDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.StudentDane;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.GrupaManager;
import com.Nowek.Mazurczak.Ozga.Komunikacja.Manager.StudentManager;
/**
 * klasa testujca StudentManager
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class StudentManagerTest {

	@Test
	/**
	 * metoda testujca wszykie metody klasy StudentManager
	 */
	public void test() {
		Grupa g = new Grupa("2ID14B");
		GrupaManager.saveGrupa(g);
		Student s = new Student("Wiktor","Mazurczak","00","Danza","123", g.getIdGrupa());
		if(!StudentManager.saveStudent(s)) {
			fail("nie udalo sie dodac studenta");
		}
		if(!StudentManager.getLog("Danza", "123")) {
			fail("danych nie ma w bazie");
		}
		if(StudentManager.getLogData("Danza", "123")==null) {
			fail("nie ma danych w bazie");
		}
		List<StudentDane>lista=StudentManager.getStudentList();
		if(lista.isEmpty()) {
			fail("lista jest pusta");
		}
		if(!StudentManager.removeStudent(s)) {
			fail("nie udalo sie usunac studenta");
		}
		if(!GrupaManager.removeGrupa(g)) {
			fail("nie udalo sie usunac gr");
		}
	
		
	}

}
