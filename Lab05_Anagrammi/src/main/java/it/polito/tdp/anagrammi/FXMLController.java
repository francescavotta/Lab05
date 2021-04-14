package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcoloAnagramma(ActionEvent event) {
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	
    	String parola = txtParola.getText();
    	
    	parola = parola.toLowerCase().replaceAll("[.?,\\/#!$%\\^&\\*;:{}=\\-_()']","");
    	if(parola.length()>7) {
    		txtAnagrammiCorretti.setText("Inserire parole con meno di 8 caratteri!");
    		return;
    	}
    	model.controlla(parola);
    	txtAnagrammiCorretti.setText(model.stampaCorretto(model.getC()));
    	txtAnagrammiErrati.setText(model.stampaCorretto(model.getE()));
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	txtParola.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = new Model();
		
	}
}
