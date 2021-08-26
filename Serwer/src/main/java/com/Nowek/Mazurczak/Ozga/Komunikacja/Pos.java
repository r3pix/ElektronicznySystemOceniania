package com.Nowek.Mazurczak.Ozga.Komunikacja;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.PosDane;


@Entity
@Table(name="Pos")
/**
 * Klasa odpowiada za getery i setery Pos czyli tabeli posredniej 
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class Pos {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Pos")
	@SequenceGenerator(name="Pos",sequenceName="PosSeq",allocationSize=1)
	@Column(name="idPos")
	private int idPos;
	
	@Column(name="idNauczyciel")
	private int idNauczyciel;
	
	@Column(name="idPrzedmiot")
	private int idPrzedmiot;
/**
 * konstruktor ktory przyjmuje obiekt klasy posDane i ustawia pola
 * @param a
 */
	public Pos(PosDane a)
	{
		this.idPos=a.getIdPos();
		this.idNauczyciel=a.getIdNauczyciel();
		this.idPrzedmiot=a.getIdPrzedmiot();
	}
/**
 * Konstruktor ktory ustawia pola klasy
 * @param idNauczyciel
 * @param idPrzedmiot
 */
	public Pos(int idNauczyciel, int idPrzedmiot) {
		super();
		this.idNauczyciel = idNauczyciel;
		this.idPrzedmiot = idPrzedmiot;
	}
/**
 * konstruktor domyslny
 */
	public Pos() {
		super();
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


}
