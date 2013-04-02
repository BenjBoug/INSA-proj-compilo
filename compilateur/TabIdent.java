package compilateur;


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
		return locaux.containsKey(clef) | globaux.containsKey(clef);
	}
	

	public boolean existeIdentLocal(String clef) {
		return locaux.containsKey(clef);
	}
	

	public boolean existeIdentGlobal(String clef) {
		return globaux.containsKey(clef);
	}

	
	public void rangeIdent(String clef, Ident id,int modifOffset) {
		offset += modifOffset;
		id.setOffset(offset);
		locaux.put(clef, id);
	}
	
	public void rangeIdent(String clef, Ident id) {
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
			if(i.next().getForme() == Ident.VAR) {
				compteur++;
			}
		}
		
		return compteur;
	}
	public void videLocaux()
	{
		locaux.clear();
		offset = 0;
	}
	
	public void ecrireDebug()
	{
		System.out.println(globaux + " \n"+locaux);
	}
	
	
}
