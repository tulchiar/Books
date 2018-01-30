package it.tulchiar.books.model;

public class TestLibro {
	public static void main(String[] args) {
		
		Libro l1 = new Libro("titolo_1", "id_autore_1", "isbn_1");
		Libro l2 = new Libro("titolo_2", "id_autore_2", "isbn_2");
		Libro l3 = new Libro("titolo_1", "id_autore_1", "isbn_2");
		
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);

		System.out.println("\n");
		
		System.out.println(l2.equals(l1)); // false
		System.out.println(l2.equals(l3)); // true
		System.out.println(l3.equals(l1)); // false
		
	}
}
