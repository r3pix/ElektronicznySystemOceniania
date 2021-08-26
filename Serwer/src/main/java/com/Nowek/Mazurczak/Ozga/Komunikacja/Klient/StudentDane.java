package com.Nowek.Mazurczak.Ozga.Komunikacja.Klient;

import java.io.Serializable;
/**
 * klasa odpowiedzialna za dane studenta
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class StudentDane implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6815828087694536666L;
	private int idStudent;
	private String Imie;
	private String Nazwisko;
	private String Pesel;
	private String Login;
	private String Haslo;
	private int idGrupa;
	private int operacja;
	/**
	 * konstruktor domyslny
	 */
	public StudentDane() {
		super();
	}
/**
 * konstruktor ustwiajacy dane studenta
 * @param imie
 * @param nazwisko
 * @param pesel
 * @param login
 * @param haslo
 * @param idGrupa
 */
	public StudentDane(String imie, String nazwisko, String pesel, String login, String haslo, int idGrupa) {
		super();
		Imie = imie;
		Nazwisko = nazwisko;
		Pesel = pesel;
		Login = login;
		Haslo = haslo;
		this.idGrupa = idGrupa;
	}
/**
 * konstruktor ustwiajacy dane studenta
 * @param idStudent
 * @param imie
 * @param nazwisko
 * @param pesel
 * @param login
 * @param haslo
 * @param idGrupa
 */
	public StudentDane(int idStudent, String imie, String nazwisko, String pesel, String login, String haslo,
			int idGrupa) {
		super();
		this.idStudent = idStudent;
		Imie = imie;
		Nazwisko = nazwisko;
		Pesel = pesel;
		Login = login;
		Haslo = haslo;
		this.idGrupa = idGrupa;
	}

	/**
	 * zwraca pole id Student
	 * @return
	 */
	public int getIdStudent() {
		return idStudent;
	}
	/**
	 * Ustawienie pola id student
	 */
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	/**
	 * zwraca pole imie studenta
	 * @return
	 */
	public String getImie() {
		return Imie;
	}
	/**
	 * ustawia imie studenta
	 * @param imie
	 */
	public void setImie(String imie) {
		Imie = imie;
	}
	/**
	 * zwraca nazwisko studenta
	 * @return
	 */
	public String getNazwisko() {
		return Nazwisko;
	}
	/**
	 * ustawia nazwisko studenta
	 * @param nazwisko
	 */
	public void setNazwisko(String nazwisko) {
		Nazwisko = nazwisko;
	}
	/**
	 * zwraca pesel studenta
	 * @return
	 */
	public String getPesel() {
		return Pesel;
	}
	/**
	 * ustawia pesel studenta
	 * @param pesel
	 */
	public void setPesel(String pesel) {
		Pesel = pesel;
	}
	/**
	 * zwraca login studenta
	 * @return
	 */
	public String getLogin() {
		return Login;
	}
	/**
	 * ustwia login studenta
	 * @param login
	 */
	public void setLogin(String login) {
		Login = login;
	}
	/**
	 * zwraca haslo studenta
	 * @return
	 */
	public String getHaslo() {
		return Haslo;
	}
	/**
	 * ustawia haslo studenta
	 * @param haslo
	 */
	public void setHaslo(String haslo) {
		Haslo = haslo;
	}
	/**
	 * zwraca id Grupy do ktorej nalezy student
	 * @return
	 */
	public int getIdGrupa() {
		return idGrupa;
	}
	/**
	 * ustawia id Grupy do ktorej nalezy student
	 * @param idGrupa
	 */
	public void setIdGrupa(int idGrupa) {
		this.idGrupa = idGrupa;
	}
/**
 * metoda zwraca typ operacji 
 * @return
 */
	public int getOperacja() {
		return this.operacja;
	}
/**
 * metoda ustawiajca typ operacji
 * @param operacja
 */
	public void setOperacja(int operacja) {
		this.operacja = operacja;
	}

	
	
	
	
	
	
	
}
