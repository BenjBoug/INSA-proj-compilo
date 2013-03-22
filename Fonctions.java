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
		System.out.println("Avant l'emp"+fonctions+"\n");
		IdFonc fonc = tabIdent.chercheFonction(nom);
		fonctions.push(fonc);
		System.out.println("Apres l'emp"+fonctions+"\n");
	}
	
	public void depilerFonction(){
		System.out.println("Avant le dep"+fonctions+"\n");
		fonctions.pop();
		System.out.println("Apres le dep"+fonctions+"\n");
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
		rangParam++;
		tabIdent.rangeIdent(param, new IdParam(typeRetour,param,rangParam));
	}
	
	// Une fois que tous les rans ont été renseignés, on calcule leur offset
	// (voir page 23 pour les détails)
	public void calculerOffsetParam() {
		int tailleParametres = tabIdent.nombreParametresFonction(getNomFoncActuel());
		tabIdent.calculerOffsetParam(tailleParametres);
	}
	
	public String getNomFoncActuel() {
		return fonctions.peek().getNom();
	}
}
