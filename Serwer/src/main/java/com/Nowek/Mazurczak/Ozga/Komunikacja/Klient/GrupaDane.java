package com.Nowek.Mazurczak.Ozga.Komunikacja.Klient;

import java.io.Serializable;
/**
 * klasa w ktorej przypisywane sa dane dotyczace grupy
 * @author Lee
 *
 */
public class GrupaDane implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8109724866145071547L;
	private int idGrupa;
	private String Nazwa_grupy;
	private int operacja;
	
	/**
	 * konstruktor domyslny 
	 */
	public GrupaDane() {
		super();
	}
/**
 * kontruktor ustwiajacy id grupy i nazwe grupy
 * @param idGrupa
 * @param nazwa_grupy
 */
	public GrupaDane(int idGrupa, String nazwa_grupy) {
		super();
		this.idGrupa = idGrupa;
		Nazwa_grupy = nazwa_grupy;
	}

	/**
	 * konstruktor ustwiajacy id grupy
	 * @param idGrupa
	 */
	public GrupaDane(int idGrupa) {
		super();
		this.idGrupa = idGrupa;
	}
/**
 * konstruktor ustawiajacy nazwe grupy
 * @param nazwa_grupy
 */
	public GrupaDane(String nazwa_grupy) {
		super();
		Nazwa_grupy = nazwa_grupy;
	}
/**
 * metoda zwracajaca id grupy
 * @return
 */
	public int getIdGrupa() {
		return idGrupa;
	}
/**
 * Metoda ustawiajaca id Grupy
 * @param idGrupa
 */
	public void setIdGrupa(int idGrupa) {
		this.idGrupa = idGrupa;
	}
/**
 * metoda zwracajaca nazwe grupy
 * @return
 */
	public String getNazwa_grupy() {
		return Nazwa_grupy;
	}
/**
 * metoda ustwiajaca nazwe grupy
 * @param nazwa_grupy
 */
	public void setNazwa_grupy(String nazwa_grupy) {
		Nazwa_grupy = nazwa_grupy;
	}
/**
 * metoda zwracajaca operacje 
 * @return
 */
	public int getOperacja() {
		return operacja;
	}
/**
 * metoda ustawiajaca operacje
 * @param operacja
 */
	public void setOperacja(int operacja) {
		this.operacja = operacja;
	}
	
	
	
	
	
	
	
}
