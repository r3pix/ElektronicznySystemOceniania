package com.Nowek.Mazurczak.Ozga.Komunikacja.Klient;

import java.io.Serializable;
/**
 * metoda odpawiajaca za sprawdzenie logoawania klienta
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class KlientLogin implements Serializable{
	private String Login, Haslo;
	private NauczycielDane naucz=null;
	private StudentDane stud=null;
	private boolean isCorrect;
	private boolean isStudent=false;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4051677924595497757L;
	/**
	 * zwraca login klienta
	 * @return
	 */
	public String getLogin() {
		return Login;
	}
	/**
	 * zwraca haslo klienta
	 * @return
	 */
	public String getHaslo() {
		return Haslo;
	}
	/**
	 * zwraca wynik sprwdzenia
	 * @return
	 */
	public boolean isCorrect() {
		return isCorrect;
	}
	/**
	 * konstrukor przyjmujacy login i haslo
	 * @param login
	 * @param haslo
	 */
	public KlientLogin(String login, String haslo) {
		super();
		Login = login;
		Haslo = haslo;
	}
	/**
	 * konstruktor przyjmujacy sprawdzenie poprawnosci danych
	 * @param isCorrect
	 */
	public KlientLogin(boolean isCorrect) {
		super();
		this.isCorrect = isCorrect;
	}
	/**
	 * metoda sprawdzajaca czy klient jest studentem
	 * @return
	 */
	public boolean isStudent() {
		return isStudent;
	}
	/**
	 * metoda ustawiajaca wynik operacji sprawdzenia
	 * @param isStudent
	 */
	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}
	/**
	 * Konstruktor ktory przyjmuje wynik operacji oraz obiekt klasy NauczycielDane
	 * @param isCorrect
	 * @param naucz
	 */
	public KlientLogin(boolean isCorrect,NauczycielDane naucz) {
		super();
		this.naucz = naucz;
		this.isCorrect = isCorrect;
	}
	/**
	 * Konstruktor ktory przyjmuje wynik operacji oraz obiekt klasy StudentDane
	 * @param isCorrect
	 * @param stud
	 */
	public KlientLogin(boolean isCorrect,StudentDane stud) {
		super();
		this.stud = stud;
		this.isCorrect = isCorrect;
	}
	/**
	 * zwraca obiekt klasy NauczycielDane
	 * @return
	 */
	public NauczycielDane getNaucz() {
		return naucz;
	}
	/**
	 * ustawia obiekt klasy NauczycielDAne
	 * @param naucz
	 */
	public void setNaucz(NauczycielDane naucz) {
		this.naucz = naucz;
	}
	/**
	 * Zwraca obiekt StudentDane
	 * @return
	 */
	public StudentDane getStud() {
		return stud;
	}
	/**
	 * ustawia obiekt klasy StudentDane
	 * @param stud
	 */
	public void setStud(StudentDane stud) {
		this.stud = stud;
	}
	

}
