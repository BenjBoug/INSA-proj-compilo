import java.util.ArrayList;
import java.util.List;


public class Fonctions {
	
	TabIdent tabIdent;
	Expression expr;	
	private int offsetParam = 2;
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
			System.out.println("Erreur: la valeur de retour incorrecte à la ligne "+tok.beginLine);			
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
		offsetParam=2;
	}
	
	public void ajoutParam(String param)
	{
		tabIdent.chercheFonction(nomFoncActuel).ajoutParam(typeRetour);
		offsetParam+=2;
		tabIdent.rangeIdent(param, new IdVar(typeRetour,param,offsetParam));
	}
}
