package com.Nowek.Mazurczak.Ozga.Komunikacja.Klient;

import java.io.Serializable;
/**
 * klasa odpowiadajaca za dane tabeli posredniej 
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class PosDane implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7987481509098008404L;
	private int idPos;
	private int idNauczyciel;
	private int idPrzedmiot;
	private String imie, nazwisko,nazwa;
	private int operacja;
	private String typ;
	
	/**
	 * konstruktor ustwiajacy id
	 * @param idPos
	 */
	public PosDane(int idPos) {
		super();
		this.idPos = idPos;
	}
	/**
	 * konstruktor domyslny
	 */
	public PosDane() {
		super();
	}
	/**
	 * konstruktor ustwiajacy pola tabeli posredniej
	 * @param idPos
	 * @param idNauczyciel
	 * @param idPrzedmiot
	 */
	public PosDane(int idPos, int idNauczyciel, int idPrzedmiot) {
		super();
		this.idPos = idPos;
		this.idNauczyciel = idNauczyciel;
		this.idPrzedmiot = idPrzedmiot;
	}
	/**
	 * zwraca id tabeli posredniej
	 * @return idPos
	 */
	public int getIdPos() {
		return idPos;
	}
/**
 * Ustawia id tabeli posredniej
 * @param idPol
 */
	public void setIdPos(int idPol) {
		this.idPos = idPol;
	}
/**
 * zwraca id nauczyciela 
 * @return
 */
	public int getIdNauczyciel() {
		return idNauczyciel;
	}
/**
 * ustawia id nauczyciela
 * @param idNauczyciel
 */
	public void setIdNauczyciel(int idNauczyciel) {
		this.idNauczyciel = idNauczyciel;
	}
/**
 * zwraca id Przedmiotu
 * @return
 */
	public int getIdPrzedmiot() {
		return idPrzedmiot;
	}
/**
 * ustawia id przedmiotu
 */
	public void setIdPrzedmiot(int idPrzedmiot) {
		this.idPrzedmiot = idPrzedmiot;
	}
	/**
	 * metoda zwracajaca imie 
	 * @return
	 */
	public String getImie() {
		return imie;
	}
	/**
	 * metoda ustwiajaca imie
	 * @param imie
	 */
	public void setImie(String imie) {
		this.imie = imie;
	}
	/**
	 * metoda zwracajaca nazwisko
	 * @return
	 */
	public String getNazwisko() {
		return nazwisko;
	}
	/**
	 * metoda ustwiajaca nazwisko
	 * @param nazwisko
	 */
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	/**
	 * metoda zwracajaca nazwe przedmiotu
	 * @return
	 */
	public String getNazwa() {
		return nazwa;
	}
	/**
	 * metoda ustwiajaca nazwe przedmiotu
	 * @param nazwa
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	/**
	 * metoda zwracajaca  operacjie
	 * @return
	 */
	public int getOperacja() {
		return operacja;
	}
	/**
	 * metoda ustwiajaca  operacjie
	 * @param operacja
	 */
	public void setOperacja(int operacja) {
		this.operacja = operacja;
	}
	/**
	 * metoda zwracajaca typ
	 * @return
	 */
	public String getTyp() {
		return typ;
	}
	/**
	 * metoda ustwiajaca typ
	 * @param typ
	 */
	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	
	
	
	
}
