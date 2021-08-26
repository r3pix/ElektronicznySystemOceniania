package com.Nowek.Mazurczak.Ozga.Komunikacja.Klient;

import java.io.Serializable;
/**
 * klasa odpowidzialana za dane oceny
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class OcenaDane implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5724723669351057208L;
	private int idOcena;
	private int waga;
	private int idStudent;
	private int idPos;
	private float ocena;
	private String nazwisko, imie, nazwa, typ;
	
	private int operacja;
	/**
	 * kontruktor przyjmujacy id oceny i ustwiajacy go
	 * @param idOcena
	 */
	public OcenaDane(int idOcena) {
		super();
		this.idOcena = idOcena;
	}
	
	
	
	/**
	 * konstruktor domyslny
	 */
	public OcenaDane() {
		super();
	}



/**
 * konstruktor ustwiajacy wszykie dane oceny
 * @param idOcena
 * @param waga
 * @param idStudent
 * @param idPos
 * @param ocena
 * @param nazwisko
 * @param imie
 * @param nazwa
 * @param typ
 */
	public OcenaDane(int idOcena, int waga, int idStudent, int idPos, float ocena, String nazwisko, String imie,
			String nazwa, String typ) {
		super();
		this.idOcena = idOcena;
		this.waga = waga;
		this.idStudent = idStudent;
		this.idPos = idPos;
		this.ocena = ocena;
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.nazwa = nazwa;
		this.typ = typ;
	}


/**
 * konstruktor ustawiajacy ocene 
 * @param idOcena
 * @param waga
 * @param idStudent
 * @param idPos
 * @param ocena
 */

	public OcenaDane(int idOcena, int waga, int idStudent, int idPos, float ocena) {
		super();
		this.idOcena = idOcena;
		this.waga = waga;
		this.idStudent = idStudent;
		this.idPos = idPos;
		this.ocena = ocena;
	}
	/**
	 * konstruktor ustawiajacy ocene 
	 * @param waga
	 * @param idStudent
	 * @param idPos
	 * @param ocena
	 */
	
	public OcenaDane(int waga, int idStudent, int idPos, float ocena) {
		super();
		this.waga = waga;
		this.idStudent = idStudent;
		this.idPos = idPos;
		this.ocena = ocena;
	}
	
/**
 * metoda zwracajaca typ operacji
 * @return
 */

	public int getOperacja() {
		return operacja;
	}



/**
 * metoda ustwiajaca typ operacji 
 * @param operacja
 */
	public void setOperacja(int operacja) {
		this.operacja = operacja;
	}
	/**
	 * zwraza pole idOcena
	 * @return
	 */
	public int getIdOcena() {
		return idOcena;
	}

	/**
	 * ustawia pole idOcena
	 * @param idOcena
	 */
	public void setIdOcena(int idOcena) {
		this.idOcena = idOcena;
	}

/**
 * metoda ktora zwraca wage oceny
 * @return waga
 */
	public int getWaga() {
		return this.waga;
	}

/**
 * ustawaia wage oceny
 * @param waga
 */
	public void setWaga(int waga) {
		this.waga = waga;
	}

/**
 * zwraca id sutdenta
 * @return idStudent
 */
	public int getIdStudent() {
		return idStudent;
	}

/**
 * ustawia id Studenta
 * @param idStudent
 */
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

/**
 * zwraca id z tabeli posredniej 
 * @return
 */
	public int getIdPos() {
		return idPos;
	}

/**
 * ustawia id przedmiotu
 * @param idPrzedmiot
 */
	public void setIdPos(int idPrzedmiot) {
		this.idPos = idPrzedmiot;
	}
/**
 * metoda zwraca ocene 
 * @return
 */

	public float getOcena() {
		return this.ocena;
	}

/**
 * metoda ustawia ocene
 * @param ocena
 */
	public void setOcena(float ocena) {
		this.ocena = ocena;
	}


/**
 * metoda ustwiajaca imie
 * @param nauczycielImie
 */
public void setImie(String nauczycielImie) {
	// TODO Auto-generated method stub
	this.imie=nauczycielImie;
}


/**
 * metoda ustwiajaca nazwisko
 * @param nauczycielNaziwsko
 */
public void setNazwisko(String nauczycielNaziwsko) {
	// TODO Auto-generated method stub
	this.nazwisko=nauczycielNaziwsko;
}


/**
 * metoda ustawiajaca nazwe
 * @param przedmiotNazwa
 */
public void setNazwa(String przedmiotNazwa) {
	// TODO Auto-generated method stub
	this.nazwa=przedmiotNazwa;
}


/**
 * metoda ustwiajaca typ
 * @param przedmiotTyp
 */
public void setTyp(String przedmiotTyp) {
	// TODO Auto-generated method stub
	this.typ=przedmiotTyp;
}
	
	
	
	
}
