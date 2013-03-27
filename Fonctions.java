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
			System.out.println("Erreur (l."+tok.beginLine+"): valeur de retour incorrecte");	
		}
		
	}
	public void testArgumentsFonction(int id,Token tok)
	{
		IdFonc fonc = fonctions.peek();
		expr.testExpr(fonc.getParam(id).getType(),tok);
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
	
	public void ajoutParam(String param) {
		IdParam idPar = new IdParam(typeRetour,param,rangParam);
		fonctions.peek().ajoutParam(idPar);
		tabIdent.rangeIdent(param, idPar);
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

	public void testTypesArguments(int nbArg, Token tok)
	{
		IdFonc fonc = fonctions.peek();
		if (nbArg == fonc.getNbParam())
		{
			for (int i=fonc.getNbParam()-1;i>=0;i--)
			{
				int typeEmpiler = expr.depilerType();
				int typeArg = fonc.getParam(i).getType();
				if (typeEmpiler!=typeArg)
				{
					System.out.println("Erreur (l."+tok.beginLine+"): le type de l'argument "+(i+1)+" n'a pas le bon type");
					
				}
			}
			
		}
		else
		{
			System.out.println("Erreur (l."+tok.beginLine+"): nombre d'argument(s) invalide.");
		}
	}
}















