package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.db.ParolaDAO;

public class Permutazioni {

	List<String> parola = new ArrayList<>();
	int lunghezza;
	
	
	
	
	public List<String> permuta(String word)
	{
		lunghezza = word.length();
		for(int i =0 ; i < lunghezza;i++)
		{
			parola.add(i,word.substring(i, i+1));
		}
		List<String> tutte = new ArrayList<>();
		
		permuta_ric(0,lunghezza,parola,new ArrayList<String>(),tutte);
		
		return tutte;
	}

	private void permuta_ric(int step, int lunghezza,List<String>parola,List<String>risultato, List<String> tutte) {
		// TODO Auto-generated method stub
		String result = "";
		if(step == lunghezza)
		{
			for(String s : risultato)
			{
				result += s ;
			}
			tutte.add(result);
			
			return;
			
		}
		else
		{
			for(int i=0 ; i<lunghezza;i++)
			{
				if(!risultato.contains(parola.get(i)))
				{
					risultato.add(parola.get(i));
					
					permuta_ric(step+1,lunghezza,parola,risultato,tutte);
					
					risultato.remove(step);
				}
				
			}
		}
	}
	
	public List<RichWord> ControlloParole(List<String> parole)
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

	public static void main (String[] args){
		Permutazioni m = new Permutazioni();
		
		m.permuta("ea");
	}
	
}
