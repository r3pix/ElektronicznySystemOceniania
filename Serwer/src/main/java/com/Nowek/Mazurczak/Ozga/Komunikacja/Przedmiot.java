package com.Nowek.Mazurczak.Ozga.Komunikacja;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PrzedmiotDane;


@Entity
@Table(name="Przedmiot")
/**
 * Klasa odpowiadajaca za getery i setery przedmiotu
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class Przedmiot{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Przedmiot")
	@SequenceGenerator(name="Przedmiot",sequenceName="PrzedmiotSeq", allocationSize=1)
	@Column(name="idPrzedmiot")
	private int idPrzedmiot;
	
	
	@Column(name="Nazwa")
	private String Nazwa;
	
	@Column(name="Typ")
	private String Typ;

	/**
	 * konstruktor przyjmujacy obiekt klas PrzedmiotDane i ustawiajacy pola
	 * @param a
	 */
	public Przedmiot(PrzedmiotDane a) {
		super();
		this.idPrzedmiot = a.getIdPrzedmiot();
		Nazwa = a.getNazwa();
		Typ = a.getTyp();
	}
/**
 * konstruktor domyslny
 */
	public Przedmiot() {
		super();
	}
/**
 * Konstruktor ustawiajacy odpowiednie pola
 * @param nazwa
 * @param typ
 */
	public Przedmiot(String nazwa, String typ) {
		super();
		Nazwa = nazwa;
		Typ = typ;
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
	
	
}

