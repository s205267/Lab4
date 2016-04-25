package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.Permutazioni;
import it.polito.tdp.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AnagrammiController {
	
	private Permutazioni p;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="bttCalcola"
    private Button bttCalcola; // Value injected by FXMLLoader

    @FXML 
    private TextFlow txtRisultato; // Value injected by FXMLLoader

    @FXML // fx:id="bttReset"
    private Button bttReset; // Value injected by FXMLLoader

    @FXML
    void doCalcola(ActionEvent event) {
    	
    	String result ="";
    	List<String> risultati = new ArrayList<>(); //Ci metto tutte le permutazioni
    	List<RichWord>paroleCorrette = new ArrayList<>();
    	
    	String parola = txtParola.getText();
    	risultati  = p.permuta(parola);
    	paroleCorrette = p.ControlloParole(risultati);
    	aggiornarisultato(paroleCorrette);
    	
    	
    }

    
    private void aggiornarisultato(List<RichWord> risultato) {
    	for(RichWord r : risultato)
		{
			
			if(r.getStato()== true)
			{
				Text t=new Text();
				t.setText(r.getParola()+"\n");
				t.setFill(javafx.scene.paint.Color.RED);
				txtRisultato.getChildren().add(t); 
			}
			else{
				Text t=new Text();
				t.setText(r.getParola()+"\n");
				t.setFill(javafx.scene.paint.Color.BLACK);
				txtRisultato.getChildren().add(t); 
				
			}
		}	

	}
    @FXML
    void doReset(ActionEvent event) {

    }
    public void setModel(Permutazioni p) {
		// TODO Auto-generated method stub
		
    	this.p = p;
	}

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert bttCalcola != null : "fx:id=\"bttCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert bttReset != null : "fx:id=\"bttReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	
}
