package com.Nowek.Mazurczak.Ozga.Komunikacja.Klient;

import java.io.Serializable;
import java.util.List;
/**
 * klasa 
 * @author Nowek.Mazurczak.Ozga
 *
 */
public class ComList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5251328463633333747L;
	private List<?> lista;
/**
 * konstruktor przyjmujacy i ustwiajacy liste
 * @param lista
 */
	public ComList(List<?> lista) {
		super();
		this.lista = lista;
	}
/**
 * metoda zwracajaca liste 
 * @return
 */
	public List<?> getLista() {
		return lista;
	}

	
}
