package com.Nowek.Mazurczak.Ozga.Komunikacja;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.Nowek.Mazurczak.Ozga.Komunikacja.Klient.StudentDane;

@Entity
@Table(name="Student")
/**
 * Klasa odpowiada za getery i setery Studenta
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class Student{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Student")
	@SequenceGenerator(name="Student",sequenceName="StudentSeq",allocationSize=1)
	@Column(name="idStudent")
	private int idStudent;
	
	
	@Column(name="Imie")
	private String Imie;
	
	@Column(name="Nazwisko")
	private String Nazwisko;
	
	@Column(name="Pesel")
	private String Pesel;
	
	@Column(name="Login")
	private String Login;
	
	@Column(name="Haslo")
	private String Haslo;
	
	@Column(name="idGrupa")
	private int idGrupa;
	/**
	 * konstruktor domyslny
	 */
	public Student() {
		super();
	}
	
	/**
	 * kontruktor przyjmujacy obiekt klasy StudentDane ustwiajacy odpowiednie pola studenta
	 */
	public Student(StudentDane a) {
		super();
		this.idStudent = a.getIdStudent();
		Imie = a.getImie();
		Nazwisko = a.getNazwisko();
		Pesel = a.getPesel();
		Login = a.getLogin();
		Haslo = a.getHaslo();
		this.idGrupa = a.getIdGrupa();
	}

/**
 * konstuktor odpowiadjacy pola studenta
 * @param imie
 * @param nazwisko
 * @param pesel
 * @param login
 * @param haslo
 * @param idGrupa
 */
	public Student (String imie, String nazwisko, String pesel, String login,String haslo,int idGrupa) {
		super();
		
		Imie = imie;
		Nazwisko = nazwisko;
		Pesel = pesel;
		Login = login;
		Haslo = haslo;
		this.idGrupa = idGrupa;
	}
	/**
	 * Metoda kopiujaca z innego obiektu
	 * @param a
	 */
	public void copy(Student a)
	{
		this.idStudent=a.idStudent;
		Imie = a.Imie;
		Nazwisko = a.Nazwisko;
		Pesel = a.Pesel;
		Login = a.Login;
		Haslo = a.Haslo;
		this.idGrupa = a.idGrupa;
	}
	/**
	 * zwraca pole id Student
	 * @return
	 */
	public int getIdStudent() {
		return idStudent;
	}
	/**
	 * Ustawienie pola id student
	 */
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	/**
	 * zwraca pole imie studenta
	 * @return
	 */
	public String getImie() {
		return Imie;
	}
	/**
	 * ustawia imie studenta
	 * @param imie
	 */
	public void setImie(String imie) {
		Imie = imie;
	}
	/**
	 * zwraca nazwisko studenta
	 * @return
	 */
	public String getNazwisko() {
		return Nazwisko;
	}
	/**
	 * ustawia nazwisko studenta
	 * @param nazwisko
	 */
	public void setNazwisko(String nazwisko) {
		Nazwisko = nazwisko;
	}
	/**
	 * zwraca pesel studenta
	 * @return
	 */
	public String getPesel() {
		return Pesel;
	}
	/**
	 * ustawia pesel studenta
	 * @param pesel
	 */
	public void setPesel(String pesel) {
		Pesel = pesel;
	}
	/**
	 * zwraca login studenta
	 * @return
	 */
	public String getLogin() {
		return Login;
	}
	/**
	 * ustwia login studenta
	 * @param login
	 */
	public void setLogin(String login) {
		Login = login;
	}
	/**
	 * zwraca haslo studenta
	 * @return
	 */
	public String getHaslo() {
		return Haslo;
	}
	/**
	 * ustawia haslo studenta
	 * @param haslo
	 */
	public void setHaslo(String haslo) {
		Haslo = haslo;
	}
	/**
	 * zwraca id Grupy do ktorej nalezy student
	 * @return
	 */
	public int getIdGrupa() {
		return idGrupa;
	}
	/**
	 * ustawia id Grupy do ktorej nalezy student
	 * @param idGrupa
	 */
	public void setIdGrupa(int idGrupa) {
		this.idGrupa = idGrupa;
	}
}
