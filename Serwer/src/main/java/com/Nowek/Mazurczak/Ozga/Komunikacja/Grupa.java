package com.Nowek.Mazurczak.Ozga.Komunikacja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.GrupaDane;

/**
 * 
 * @author Nowek.Mazurczak.Ozga
 * Klasa odpowidzialana za getery i setery dla grupy
 */

@Entity
@Table(name="Grupa")
public class Grupa{
	/**
	 * Automatyczne gernerowanie kolejnej idGrupy
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Grupa")
	@SequenceGenerator(name="Grupa",sequenceName="GrupaSeq",allocationSize=1)
	@Column(name="idGrupa")
	private int idGrupa;
	
	@Column(name="Nazwa_grupy")
	private String Nazwa_grupy;

/**
 * konstruktor domyslny
 */
	public Grupa() {
		super();
	}

	/**
	 * konstruktor ktory przyjmuje obiekt z klasy GrupaDane i ustawia wartosci
	 * @param a
	 */
	public Grupa(GrupaDane a) {
		super();
		Nazwa_grupy = a.getNazwa_grupy();
		idGrupa=a.getIdGrupa();
	}
	/**
	 * konstruktor ktory przyjmuje string i przypisuje go do nazwy grupy
	 * @param nazwa_grupy
	 */
	public Grupa(String nazwa_grupy) {
		super();
		Nazwa_grupy = nazwa_grupy;
	}
	/**
	 * zwraca idGrupa
	 * @return idGrupa
	 */
	public int getIdGrupa() {
		return idGrupa;
	}
	/**
	 * ustwaia idGrupa o przyjetym argumecie
	 * @param idGrupa
	 */
	public void setIdGrupa(int idGrupa) {
		this.idGrupa = idGrupa;
	}
	/**
	 * zwraca nazwe grupy
	 * @return Nazwa_grupy
	 */
	public String getNazwa_grupy() {
		return Nazwa_grupy;
	}
	/**
	 * ustawienie nazwy grupy podanym Stringiem
	 * @param nazwa_grupy
	 */
	public void setNazwa_grupy(String nazwa_grupy) {
		Nazwa_grupy = nazwa_grupy;
	}
	

}
