package it.tulchiar.books.db;

import java.util.List;

import it.tulchiar.books.model.Libro;

public class TestLibroDAO {	
	public static void main(String[] args) {
		
		LibroDAO libroDAO = new LibroDAO();
		
		List<Libro> libri;
		
		libri = libroDAO.getAll(100);
		
		for (Libro libro : libri) {
			System.out.println(libro);
		}
		
		Libro l3 = libroDAO.getLibro("isbn_1");
		System.out.println("\n" + l3);
		
		// Test inserimento nuovo libro
		//libroDAO.create(new Libro("titolo_4", "id_autore_4", "isbn_4"));
				
	}
}
