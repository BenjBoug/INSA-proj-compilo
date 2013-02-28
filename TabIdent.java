

import java.util.HashMap;
import java.util.Iterator;

public class TabIdent {
	private HashMap<String, Ident> table;
	private int offset = -2;
	
	public TabIdent(){
		table = new HashMap<String, Ident>();
		}

	public TabIdent(int taille) {
		table = new HashMap<String, Ident>(taille);
	}

	public Ident chercheIdent(String clef) {
		return table.get(clef);
	}

	public boolean existeIdent(String clef) {
		return table.containsKey(clef);
	}

	public void rangeIdent(String clef, Ident id) {
		id.setOffset(offset);
		offset -= 2;
		table.put(clef, id);
	}
	
	public int nombreVariable() {
		int compteur = 0;
		
		Iterator<Ident> i = table.values().iterator();
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
	
	
}
