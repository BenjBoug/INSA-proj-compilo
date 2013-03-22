
public class IdParam extends Ident  {
	private int offset;
	
	public IdParam(int type, String nom, int rang) {
		super(type, nom);
		offset = rang;
	}


	
	@Override
	public int getValeur() {
		// TODO Auto-generated method stub
		return offset;
	}

	@Override
	public void setValeur(int valeur) {
		offset = valeur;
		
	}

	@Override
	public int getVarOrConst() {
		return PARAM;
	}

	@Override
	public void setOffset(int o) {
		
	}

	@Override
	public void calculerOffset(int taille) {
		offset = taille + 4 - (offset*2);
	}

}
