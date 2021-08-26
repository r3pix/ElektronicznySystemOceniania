package com.Nowek.Mazurczak.Ozga.Komunikacja.Klient;

import java.io.Serializable;
/**
 * Klasa odpowiadajca za dane przedmiotu
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class PrzedmiotDane implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2985773392095715819L;
	private int idPrzedmiot;
	private String Nazwa;
	private String Typ;
	private int operacja;
	/**
	 * konstruktor ustwiajacy pola przedmiotu
	 * @param idPrzedmiot
	 * @param nazwa
	 * @param typ
	 */
	
	public PrzedmiotDane(int idPrzedmiot, String nazwa, String typ) {
		super();
		this.idPrzedmiot = idPrzedmiot;
		Nazwa = nazwa;
		Typ = typ;
	}
/**
 * konstruktor ustwiajacy dane przedmiotu
 * @param nazwa
 * @param typ
 */
	public PrzedmiotDane(String nazwa, String typ) {
		Nazwa = nazwa;
		Typ = typ;
		
	}
/**
 * konstruktor ustwiajacy typ operacji
 * @param operacja
 */
	public PrzedmiotDane(int operacja) {
		super();
		this.operacja = operacja;
	}
/**
 * konstruktor domyslny 
 */
	public PrzedmiotDane() {
		super();
	}

	/**
	 * zwraca id przedmiot 
	 * @return
	 */
		public int getIdPrzedmiot() {
			return idPrzedmiot;
		}
	/**
	 * ustawia id przedmiot
	 * @param idPrzedmiot
	 */
		public void setIdPrzedmiot(int idPrzedmiot) {
			this.idPrzedmiot = idPrzedmiot;
		}
	/**
	 * zwraca id Przedmiot
	 * @return
	 */
		public String getNazwa() {
			return Nazwa;
		}
	/**
	 * ustawia id przedmiot
	 * @param nazwa
	 */
		public void setNazwa(String nazwa) {
			Nazwa = nazwa;
		}
	/**
	 * zwraca typ przedmiotu
	 * @return
	 */
		public String getTyp() {
			return Typ;
		}
		/**
		 * ustwia typ przedmiotu
		 * @param typ
		 */
		public void setTyp(String typ) {
			Typ = typ;
		}
		/**
		 * metoda zwracajaca typ operacji
		 * @return
		 */
		public int getOperacja() {
			// TODO Auto-generated method stub
			return this.operacja;
		}
		
	
	
	
	
}
