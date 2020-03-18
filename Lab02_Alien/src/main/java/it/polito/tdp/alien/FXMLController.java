package it.polito.tdp.alien;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import it.polito.tdp.alien.model.*;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTranslate;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea msgArea;

    @FXML
    private Button btnReset;

	private Model model;

    @FXML
    void doReset(ActionEvent event) {
    	model.clear();
    	msgArea.setText("");
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	StringTokenizer temp = new StringTokenizer(txtTranslate.getText(), " ");
    	String result;
    	try
    	{
    		if (temp.countTokens()==2)
	    		result = model.addWord(temp.nextToken(),temp.nextToken());
	    	else if (temp.countTokens()==1)
	    		result = model.translateWord(temp.nextToken());
	    	else
	    		result = model.throwMoreThanOneException();
    	} catch (InvalidParameterException e)
    	{
    		result = "E' stato riscontrato un errore: " + e;
    	} catch (IllegalStateException e)
    	{
    		result = "Sono stati inseriti più campi del richiesto: " + e;
    	}
    	
    	msgArea.appendText(result + "\n");
    	
    	//% Clear text field and get focus in order to write again in
    	txtTranslate.clear();
    	txtTranslate.requestFocus();
    }

    @FXML
    void initialize() {
        assert txtTranslate != null : "fx:id=\"txtTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert msgArea != null : "fx:id=\"msgArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}
}
