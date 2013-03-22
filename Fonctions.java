import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Fonctions {
	
	TabIdent tabIdent;
	Expression expr;	
	private int rangParam = 1;
	public int typeRetour;
	private String nomFoncActuel;
	
	public Fonctions(TabIdent tabIdent, Expression expr) {
		super();
		this.tabIdent = tabIdent;
		this.expr = expr;
	}
	

	public void empilerTypeFonction(String nom){
		IdFonc fonc = tabIdent.chercheIdentFonction(nom);
		expr.empilerType(fonc.getType());
	}

	public void testValeurRetour(Token tok)
	{
		if (expr.getSommetTypes() != getFoncActuel().getType())
		{
			System.out.println("Erreur: la valeur de retour incorrecte � la ligne "+tok.beginLine);			
		}
		
	}
	public void testArgumentsFonction(int id)
	{
		IdFonc fonc = tabIdent.chercheFonction(nomFoncActuel);
		expr.testExpr(fonc.getParam(id));//erreur outofboundexception, a voir !!!!!!!!!!!!
	}
	

	public void setTypeRetour(int type)
	{
		typeRetour=type;
	}
	
	public IdFonc getFoncActuel()
	{
		return tabIdent.chercheFonction(nomFoncActuel);
	}
	
	public void ajouteFonction(String nom)
	{
		tabIdent.rangeFonction(nom, new IdFonc(nom,typeRetour));
		nomFoncActuel=nom;
		rangParam=1;
	}
	
	public void ajoutParam(String param)
	{
		tabIdent.chercheFonction(nomFoncActuel).ajoutParam(typeRetour);
		rangParam++;
		tabIdent.rangeIdent(param, new IdParam(typeRetour,param,rangParam));
	}
	
	// Une fois que tous les rans ont été renseignés, on calcule leur offset
	// (voir page 23 pour les détails)
	public void calculerOffsetParam() {
		int tailleParametres = tabIdent.nombreParametresFonction(nomFoncActuel);
		tabIdent.calculerOffsetParam(tailleParametres);
	}
}
