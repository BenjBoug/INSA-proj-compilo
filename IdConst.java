
public class IdConst extends Ident {
	private int valeur;

	public IdConst(int type, String nom, int valeur) {
		super(type, nom);
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public int getVarOrConst() {
		return CONST;
	}
	
	public void setOffset(int offset) {
	}

}