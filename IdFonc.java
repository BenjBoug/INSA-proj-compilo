import java.util.ArrayList;
import java.util.List;
public class IdFonc extends Ident {
	
	List<Integer> listeParams;
	public IdFonc(String nom, int typeRetour) {
		super(typeRetour,nom);
		listeParams= new ArrayList<Integer>();
	}
	
	
	void ajoutParam(int type)
	{
		listeParams.add(type);
	}

	public List<Integer> getListeParams() {
		return listeParams;
	}


	public void setListeParams(List<Integer> listeParams) {
		this.listeParams = listeParams;
	}
	
	public String toString()
	{
		String tmp = " FONCTION resultat : "+getType()+ " param: ";
		for(Integer e : listeParams)
		{
			tmp+= e+" ";
		}
		tmp+="\n";
		return tmp;
	}


	@Override
	public int getValeur() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setValeur(int valeur) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getVarOrConst() {
		return FONC;
	}


	@Override
	public void setOffset(int o) {
		// TODO Auto-generated method stub
		
	}
}
