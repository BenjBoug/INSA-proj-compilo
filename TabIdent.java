

import java.util.HashMap;
import java.util.Iterator;

public class TabIdent {
	private HashMap<String, IdFonc> globaux;
	private HashMap<String, Ident> locaux;
	private int offset = 0;
	private int offsetParam = 0;
	private int typeRetour;
	private String nomFoncActuel;
	
	public TabIdent(){
		globaux = new HashMap<String, IdFonc>();
		locaux = new HashMap<String, Ident>();
	}

	public TabIdent(int taille) {
		globaux = new HashMap<String, IdFonc>(taille);
	}

	public Ident chercheIdent(String clef) {
		return locaux.get(clef);
	}

	public boolean existeIdent(String clef) {
		return locaux.containsKey(clef);
	}

	public void rangeIdent(String clef, Ident id) {
		offset -= 2;
		id.setOffset(offset);
		locaux.put(clef, id);
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
	
	public void ajouteFonction(String nom)
	{
		globaux.put(nom, new IdFonc(nom,typeRetour));
		nomFoncActuel=nom;
	}
	
	public void ajoutParam(String param)
	{
		globaux.get(nomFoncActuel).ajoutParam(typeRetour);
		offsetParam+=2;
		rangeIdent(param,new IdVar(typeRetour,param,offsetParam));
	}
	
	public void setTypeRetour(int type)
	{
		typeRetour=type;
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
