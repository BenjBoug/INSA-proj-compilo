
public class Declaration implements Constantes {
	private TabIdent tabIdent;
	int type;

	public Declaration(TabIdent tabIdent) {
		super();
		this.tabIdent = tabIdent;
		type=ENTIER;
	}
	public void ajoutConstEntier(String id, int entier)
	{
		if (!tabIdent.existeIdent(id))
		{
			tabIdent.rangeIdent(id, new IdConst(ENTIER,id,entier));
		}
		else
		{
			System.out.println("Erreur: la constante "+id+" est deja declaree.");
		}
	}
	public void ajoutConstIdent(String id, String ident)
	{
		if (!tabIdent.existeIdent(id))
		{
			if (tabIdent.existeIdent(ident))
			{
				int entier = tabIdent.chercheIdent(ident).getValeur();
				int type = tabIdent.chercheIdent(ident).getType();
				tabIdent.rangeIdent(id, new IdConst(type,id,entier));
			}
			else
			{
				System.out.println("Erreur: la constante "+ident+" n'est pas declaree.");
			}
		}
		else
		{
			System.out.println("Erreur: la constante "+id+" est deja uilisee.");
		}
	}
	public void ajoutConstBool(String id, int val)
	{
		if (!tabIdent.existeIdent(id))
		{
			tabIdent.rangeIdent(id, new IdConst(BOOLEAN,id,val));
		}
		else
		{
			System.out.println("Erreur: la constante "+id+" est deja declaree.");
		}
	}
	
	
	public void definirTypeVar(int type)
	{
		this.type=type;
	}
	
	
	public void ajoutVariable(String ident)
	{
		if (!tabIdent.existeIdent(ident))
		{
			tabIdent.rangeIdent(ident,new IdVar(type,ident));
		}
		else
		{
			System.out.println("Erreur: la variable "+ident+" est deja declaree.");			
		}
	}
	

}
