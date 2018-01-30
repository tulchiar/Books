package it.tulchiar.books.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.tulchiar.books.model.Libro;

public class LibroDAO {
	
private final static String DB_CONNECTION_STRING = "jdbc:mysql://localhost/books?user=root&password=Chrmrc84a15";


/**
 * Inserisce il libro nel database
 * @param libro oggetto Libro
 * @return true se l'inserimento è andato a buon fine, false se qualcosa è andato storto.
 */
public boolean create(Libro libro) {
	
	String sql = "INSERT INTO `books`.`libri` (`titolo`, `id_autore`, `isbn`) VALUES (?, ?, ?);";
	
	try {
		
		Connection conn = DriverManager.getConnection(DB_CONNECTION_STRING);
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, libro.getTitolo());
		ps.setString(2, libro.getId_autore());
		ps.setString(3, libro.getIsbn());
		
		ps.executeUpdate();
		conn.close();
		
		System.out.println("Libro inserito con successo! \n === " + libro + " ===");
		return true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}

/**
 * Restituisce una lista contenente tutti i libri entro il limite impostato
 * @param limit limite massimo di libri restituiti
 * @return List<Libro> oggetto List contenente il risultato del'interrogazione
 */
public List<Libro> getAll(int limit) {
		
		List<Libro> libri = new ArrayList<Libro>();
		
		String sql = "SELECT titolo, id_autore, isbn FROM books.libri LIMIT ?";
		
		try {
			Connection conn = DriverManager.getConnection(DB_CONNECTION_STRING);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, limit);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String titolo = rs.getString("titolo");
				String id_autore = rs.getString("id_autore");
				String isbn = rs.getString("isbn");
				
				libri.add(new Libro(titolo, id_autore, isbn));
			}
			
			conn.close();
			return libri;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

/**
 * Ricerca il libro dato il numero ISBN
 * @param _isbn (String) il numero ISBN da ricercare
 * @return oggetto Libro individuato dalla ricerca, null in caso di errore;
 */
public Libro getLibro(String _isbn) {

	String sql = "SELECT titolo, id_autore, isbn FROM books.libri WHERE  isbn  = ?;";
	
	try {
		Connection conn = DriverManager.getConnection(DB_CONNECTION_STRING);
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, _isbn);

		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			String titolo = rs.getString("titolo");
			String id_autore = rs.getString("id_autore");
			String isbn = rs.getString("isbn");
			
			conn.close();
			return new Libro(titolo, id_autore, isbn);	
			
		} else {
			conn.close();
			return null;
		}	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	} 
}


}



// INSERT INTO `books`.`libri` (`titolo`, `id_autore`, `isbn`) VALUES ('titolo_1', 'id_autore_1', 'isbn_1');
