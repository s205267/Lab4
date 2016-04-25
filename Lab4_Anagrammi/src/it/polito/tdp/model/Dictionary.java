package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.db.ParolaDAO;

public class Dictionary {
	
	public Dictionary() {
		super();
	}
	
	
	public List<RichWord> spellCheckText(List<String> parole)
	{
		List<RichWord> risultato = new ArrayList<RichWord>();
		
		for(String parola:parole)
		{
			RichWord temp = new RichWord(parola);
			
			//DIRETTAMENTE SUL DATABASE 
			ParolaDAO dao = new ParolaDAO();
			if(dao.contains(parola))
			{
				risultato.add(temp);
				temp.setStato(false);
			}
			else
			{
				risultato.add(temp);
				temp.setStato(true);
			}
			
		}
		
		return risultato;
	}
	
	
	
	

}
