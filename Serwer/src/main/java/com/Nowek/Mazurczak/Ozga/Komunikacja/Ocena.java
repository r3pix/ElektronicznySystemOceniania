package com.Nowek.Mazurczak.Ozga.Komunikacja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.OcenaDane;



@Entity
@Table(name="Ocena")
/**
 * klasa odpowiada za getery i setery oceny
 * @author Lee
 *
 */
public class Ocena{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Ocena")
	@SequenceGenerator(name="Ocena",sequenceName="OcenaSeq",allocationSize=1)
	@Column(name="idOcena")
	private int idOcena;
	
	
	@Column(name="Waga")
	private int waga;
	
	@Column(name="idStudent")
	private int idStudent;
	
	@Column(name="idPos")
	private int idPos;
	
	@Column(name="Ocena")
	private float ocena;
	/**
	 * konstruktor domyslny
	 */
	public Ocena() {
		super();
	}
	/**
	 * konstuktor ktory przyjmuje obiekt klasy OcenaDane i ustawia dane pola
	 * @param a
	 */
	public Ocena(OcenaDane a)
	{
		this.idOcena=a.getIdOcena();
		this.waga = a.getWaga();
		this.idStudent = a.getIdStudent();
		this.idPos = a.getIdPos();
		this.ocena = a.getOcena();
	}
	/**
	 * Konstruktor ktory ustawia pola 
	 * @param waga
	 * @param idStudent
	 * @param idPos
	 * @param ocena
	 */
	public Ocena(int waga, int idStudent, int idPos, float ocena) {
		super();
		this.waga = waga;
		this.idStudent = idStudent;
		this.idPos = idPos;
		this.ocena = ocena;
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
	
	
}
