package it.tulchiar.books.model;

import java.util.List;

import it.tulchiar.books.db.LibroDAO;

public class Model {
	
	
	public Model() {
		
	}
	/**
	 * Ricerca un libro nel database dato l'ISBN
	 * @param isbn il numero di isbn 
	 * @return Libro il libro trovato
	 */
	public Libro getLibro(String isbn) {
		LibroDAO libroDAO = new LibroDAO();
		
		Libro libro = libroDAO.getLibro(isbn);
		return libro;
	
	}
	
	/**
	 * 
	 * @return List<Libro> 
	 */
	public List<Libro> getAllLibri(){
		
		LibroDAO libroDAO = new LibroDAO();
		
		List<Libro> libri;
		
		libri = libroDAO.getAll(100);
		
		return libri;
	}
	
	/**
	 * 
	 * @param libro
	 */
	public boolean create(Libro libro) {
		
		LibroDAO dao = new LibroDAO();
		
		return dao.create(libro);	
	}
	
}
