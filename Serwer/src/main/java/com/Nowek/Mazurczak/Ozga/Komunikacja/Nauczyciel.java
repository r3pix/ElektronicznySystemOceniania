package com.Nowek.Mazurczak.Ozga.Komunikacja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.NauczycielDane;



@Entity
@Table(name="Nauczyciel")
/**
 * klasa odpowiada za getery i setery Nauczyciela
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class Nauczyciel{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Nauczyciel")
	@SequenceGenerator(name="Nauczyciel",sequenceName="NauczycielSeq",allocationSize=1)
	@Column(name="idNauczyciel")
	private int idNauczyciel;
	
	@Column(name="Imie")
	private String Imie;
	
	@Column(name="Nazwisko")
	private String Nazwisko;
	
	@Column(name="Stopien")
	private String Stopien;
	
	@Column(name="Login")
	private String Login;
	
	@Column(name="Haslo")
	private String Haslo;
	/**
	 * konstruktor domyslny klasy
	 */
	public Nauczyciel() {
		super();
	}
	/**
	 * konstruktor ktory przyjmuje obiekt z Nauczyciel dane i ustawia wartosci
	 * @param a
	 */
	public Nauczyciel(NauczycielDane a)
	{
		super();
		this.idNauczyciel=a.getIdNauczyciel();
		Imie = a.getImie();
		Nazwisko = a.getNazwisko();
		Stopien = a.getStopien();
		Login = a.getLogin();
		Haslo = a.getHaslo();
	}
	/**
	 * Konstruktor ktory ustawia podane pola
	 * @param imie
	 * @param nazwisko
	 * @param stopien
	 * @param login
	 * @param haslo
	 */
	public Nauczyciel(String imie, String nazwisko, String stopien, String login, String haslo) {
		super();
		Imie = imie;
		Nazwisko = nazwisko;
		Stopien = stopien;
		Login = login;
		Haslo = haslo;
	}
	/**
	 * metoda ktora przyjmuje obiekt klasy Nauczyciel i ustawia wszykie pola 
	 * @param a
	 */
	public void copy(Nauczyciel a)
	{
		this.Imie = a.Imie;
		this.Nazwisko = a.Nazwisko;
		this.Stopien = a.Stopien;
		this.Login = a.Login;
		this.Haslo = a.Haslo;
		
		
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
}
