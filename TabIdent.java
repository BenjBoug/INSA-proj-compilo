

import java.util.HashMap;
import java.util.Iterator;

public class TabIdent {
	private HashMap<String, IdFonc> globaux;
	private HashMap<String, Ident> locaux;
	private int offset = 0;
	
	public TabIdent(){
		globaux = new HashMap<String, IdFonc>();
		locaux = new HashMap<String, Ident>();
	}

	public TabIdent(int taille) {
		globaux = new HashMap<String, IdFonc>(taille);
	}

	public Ident chercheIdent(String clef) {
		if (locaux.get(clef)!=null)
			return locaux.get(clef);
		else
			return globaux.get(clef);
	}
	
	public IdFonc chercheFonction(String nom)
	{
		return globaux.get(nom);
	}
	
	public int nombreParametresFonction(String nom) {
		return chercheFonction(nom).getListeParams().size(); 
		
	}

	public boolean existeIdent(String clef) {
		return locaux.containsKey(clef);
	}

	public void rangeIdent(String clef, Ident id) {
		offset -= 2;
		id.setOffset(offset);
		locaux.put(clef, id);
	}
	
	
	public void rangeFonction(String clef, IdFonc fonc)
	{
		globaux.put(clef,fonc);
	}
	
	public void calculerOffsetParam(int taille) {
		Iterator<Ident> i = locaux.values().iterator();
		while (i.hasNext()) {
			i.next().calculerOffset(taille);
		}
	}
	
	public int nombreVariable() {
		int compteur = 0;
		
		Iterator<Ident> i = locaux.values().iterator();
		while (i.hasNext()) {
			if(i.next().getVarOrConst() == Ident.VAR) {
				compteur++;
			}
		}
		
		return compteur;
	}
	
	public int valeurIdent(String nom) {
		if (!existeIdent(nom)) {
			return 0;
		}
		
		return chercheIdent(nom).getValeur();
	}
		
	
	public void videLocaux()
	{
		locaux.clear();
	}
	
	public IdFonc chercheIdentFonction(String nom)
	{
		return globaux.get(nom);
	}
	
	public void ecrireDebug()
	{
		System.out.println(globaux + " \n"+locaux);
	}
	
	
}
