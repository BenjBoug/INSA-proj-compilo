import java.util.Stack;


public class Fonctions {
	
	TabIdent tabIdent;
	Expression expr;	
	private int rangParam = 1;
	public int typeRetour;
	private Stack<IdFonc> fonctions = new Stack<IdFonc>();
	
	public Fonctions(TabIdent tabIdent, Expression expr) {
		super();
		this.tabIdent = tabIdent;
		this.expr = expr;
	}
	
	public IdFonc foncActuelle(){
		return fonctions.peek();
	}	
	
	public void empilerFonction(String nom){
		IdFonc fonc = tabIdent.chercheFonction(nom);
		fonctions.push(fonc);
	}
	
	public void depilerFonction(){
		fonctions.pop();
	}
	


	public void testValeurRetour(Token tok)
	{
		if (expr.getSommetTypes() != foncActuelle().getType())
		{
			System.out.println("Erreur: la valeur de retour incorrecte a la ligne "+tok.beginLine);	
		}
		
	}
	public void testArgumentsFonction(int id)
	{
		IdFonc fonc = tabIdent.chercheFonction(fonctions.peek().getNom());
		expr.testExpr(fonc.getParam(id));
	}
	

	public void setTypeRetour(int type)
	{
		typeRetour=type;
	}
	
	
	
	public void ajouteFonction(String nom)
	{
		tabIdent.rangeFonction(nom, new IdFonc(nom,typeRetour));
		rangParam=1;
		fonctions.push(tabIdent.chercheFonction(nom));
	}
	
	public void ajoutParam(String param)
	{
		tabIdent.chercheFonction(getNomFoncActuel()).ajoutParam(typeRetour);
		tabIdent.rangeIdent(param, new IdParam(typeRetour,param,rangParam));
		rangParam++;
	}
	
	// Une fois que tous les rans ont été renseignés, on calcule leur offset
	// (voir page 23 pour les détails)
	public void calculerOffsetParam() {
		int tailleParametres =  getTailleParam();
		tabIdent.calculerOffsetParam(tailleParametres);
	}
	
	public String getNomFoncActuel() {
		return fonctions.peek().getNom();
	}
	
	public int getTailleParam() {
		return tabIdent.nombreParametresFonction(getNomFoncActuel()) * 2;
	}
}
