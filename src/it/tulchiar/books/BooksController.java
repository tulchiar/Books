/**
 * Sample Skeleton for 'Books.fxml' Controller Class
 */

package it.tulchiar.books;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.tulchiar.books.model.Libro;
import it.tulchiar.books.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BooksController {
	
	private Model model;
	
    /**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtAutore"
    private TextField txtAutore; // Value injected by FXMLLoader

    @FXML // fx:id="txtIsbn"
    private TextField txtIsbn; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCerca(ActionEvent event) {
    		String isbn = txtIsbn.getText();
    		
    		if(txtIsbn.getText().length() > 0) {
	    		Libro libro = model.getLibro(isbn);
	    		txtResult.setText(libro.toString());
    		} else {
    			txtResult.clear();
    			List<Libro> libri = new ArrayList<Libro>();
    			libri = model.getAllLibri();
    			if(!libri.isEmpty()) {
	    			for (Libro libro : libri) {
	    					txtResult.appendText(libro.toString() +"\n");
				}
    			}
    		}
    }

    @FXML
    void doInserisci(ActionEvent event) {
    		String titolo = txtTitolo.getText();
    		String id_autore = txtAutore.getText();
    		String isbn = txtIsbn.getText();
    		    		
    		model.create(new Libro(titolo, id_autore, isbn));
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtAutore != null : "fx:id=\"txtAutore\" was not injected: check your FXML file 'Books.fxml'.";
        assert txtIsbn != null : "fx:id=\"txtIsbn\" was not injected: check your FXML file 'Books.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Books.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Books.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Books.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Books.fxml'.";

    }
}
