package compilateur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class IdFonc extends Ident {
	
	List<IdParam> listeParams;
	
	public IdFonc(String nom, int typeRetour) {
		super(typeRetour,nom);
		listeParams= new ArrayList<IdParam>();
	}
	
	void ajoutParam(IdParam param)
	{
		listeParams.add(param);
	}

	public IdParam getParam(int i)
	{
		return listeParams.get(i);
	}

	
	public String toString()
	{
		String tmp = getNom()+" FONCTION resultat : "+getType()+ " param: ";
		for(IdParam e : listeParams)
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


	@Override
	public void calculerOffset(int taille) {
		// TODO Auto-generated method stub
		
	}


	public List<IdParam> getListeParams() {
		return listeParams;
	}
	
	public int getNbParam()
	{
		return listeParams.size();
	}
	
	
}
