package com.Nowek.Mazurczak.Ozga.Komunikacja.Klient;

import java.io.Serializable;
/**
 * Klasa Odpowiadajaca za Dane Nauczyciela 
 * @author Nowek.Mazurczak.Ozga.Komunikacja
 *
 */
public class NauczycielDane implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 256173081735373043L;
	private int idNauczyciel;
	private String Imie;
	private String Nazwisko;
	private String Stopien;
	private String Login;
	private String Haslo;
	private int operacja;
	/**
	 * Konstruktor przyjmujacy i ustwiajacy dane zwiazane z Danymi Nauczyciela
	 * @param idNauczyciel
	 * @param imie
	 * @param nazwisko
	 * @param stopien
	 * @param login
	 * @param haslo
	 */
	public NauczycielDane(int idNauczyciel, String imie, String nazwisko, String stopien, String login, String haslo) {
		super();
		this.idNauczyciel = idNauczyciel;
		Imie = imie;
		Nazwisko = nazwisko;
		Stopien = stopien;
		Login = login;
		Haslo = haslo;
	}
/**
 * konstrukor przyjmujacy i ustwiajacy pola Nauczyciel dane bez id
 * @param imie
 * @param nazwisko
 * @param stopien
 * @param login
 * @param haslo
 */
	public NauczycielDane(String imie, String nazwisko, String stopien, String login, String haslo) {
		super();
		Imie = imie;
		Nazwisko = nazwisko;
		Stopien = stopien;
		Login = login;
		Haslo = haslo;
	}
/**
 * konstruktor przyjmujacy id nauczyciela
 * @param idNauczyciel
 */
	public NauczycielDane(int idNauczyciel) {
		super();
		this.idNauczyciel = idNauczyciel;
		
	}

	/**
	 * zwraca id nauczyciela
	 * @return idNauczyciel
	 */
	public int getIdNauczyciel() {
		return idNauczyciel;
	}
	/**
	 * Ustawia pole idNauczyciel
	 * @param idNauczyciel
	 */
	public void setIdNauczyciel(int idNauczyciel) {
		this.idNauczyciel = idNauczyciel;
	}
	/**
	 * zwraca imie nauczyciela
	 * @return
	 */
	public String getImie() {
		return Imie;
	}
	/**
	 * ustawia imie nauczyciela
	 * @param imie
	 */
	public void setImie(String imie) {
		Imie = imie;
	}
	/**
	 * zwraca Nazwisko nauczyciela
	 * @return
	 */
	public String getNazwisko() {
		return Nazwisko;
	}
	/**
	 * Ustawia nazwisko nauczyciela 
	 * @param nazwisko
	 */
	public void setNazwisko(String nazwisko) {
		Nazwisko = nazwisko;
	}
	/**
	 * zwraca stopien nauczyciela
	 * @return
	 */
	public String getStopien() {
		return Stopien;
	}
	/**
	 * ustawia stopien nauczyciela
	 * @param stopien
	 */
	public void setStopien(String stopien) {
		Stopien = stopien;
	}
	/**
	 * zwraca login nauczyciela
	 * @return
	 */
	public String getLogin() {
		return Login;
	}
	/**
	 * ustawia login nauczyciela
	 * @param login
	 */
	public void setLogin(String login) {
		Login = login;
	}
	/**
	 * zwraca haslo nauczyciela
	 * @return
	 */
	public String getHaslo() {
		return Haslo;
	}
	/**
	 * ustawia haslo nauczyciela
	 * @param haslo
	 */
	public void setHaslo(String haslo) {
		Haslo = haslo;
	}
/**
 * metoda zwracajaca operacje 
 * @return
 */
	public int getOperacja() {
		return operacja;
	}
/**
 * metoda przyjmujaca operacje i ustawiajaca ja
 * @param operacja
 */
	public void setOperacja(int operacja) {
		this.operacja = operacja;
	}
	
	
	
	
}
