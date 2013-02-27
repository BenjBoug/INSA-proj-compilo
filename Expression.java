import java.util.Stack;


public class Expression implements Constantes {
	private TabIdent tabIdent;
	private Stack<Integer> types = new Stack<Integer>();
	private Stack<Integer> operateur = new Stack<Integer>();
	
	private  final int[][] tabOpe = {{ENTIER,	ERROR,		ERROR	},
								     {BOOLEAN,	ERROR,		ERROR	},
								     {BOOLEAN,	BOOLEAN,	ERROR	},
								     {ERROR,	BOOLEAN,	ERROR	}};

	
	public Expression(TabIdent tabIdent) {
		super();
		this.tabIdent = tabIdent;
	}
	
	public void empilerOperation(int ope)
	{
		operateur.push(ope);
	}
	
	public void empilerType(int type)
	{
		this.types.push(type);
	}
	
	public int depilerOperation()
	{
		return operateur.pop();
	}
	
	public int depilerType()
	{
		return types.pop();
	}
	public int getSommetTypes()
	{
		return types.peek();
	}
	
	public int getSommetOp()
	{
		return operateur.peek();
	}
	
	
	public boolean operation()
	{
		int type1 = types.pop();
		int type2 = types.pop();
		int ope = operateur.pop();
		if (type1==type2)
		{
			switch (ope)
			{
				case PLUS:
					System.out.println("plus");
				case MOINS:
				case MUL:
				case DIV:
					System.out.println("div");
					if (tabOpe[0][type1]==ERROR)
						System.out.println("Erreur: l'expression n'est pas correct.");
					types.push(tabOpe[0][type1]);
					break;
					
				case INF:
				case SUP:
				case INFEG:
				case SUPEG:
					if (tabOpe[1][type1]==ERROR)
						System.out.println("Erreur: l'expression n'est pas correct.");
					types.push(tabOpe[1][type1]);
					break;
	
				case EGAL:
				case NEGAL:
					if (tabOpe[2][type1]==ERROR)
						System.out.println("Erreur: l'expression n'est pas correct.");
					types.push(tabOpe[2][type1]);				
					break;
					
				case ET:
				case OU:
					if (tabOpe[3][type1]==ERROR)
						System.out.println("Erreur: l'expression n'est pas correct.");
					types.push(tabOpe[3][type1]);
					break;
			}
			return true;
		}
		else
		{
			types.push(ERROR);
			return false;
		}
	}
	


	public void empilerEnt(int a) {
		empilerType(ENTIER);
	}
	
	public void empilerBool(int a) {
		empilerType(BOOLEAN);
	}
	
	public void empilerIdent(String nomIdent)
	{
		if (tabIdent.existeIdent(nomIdent))
		{
			Ident ident = tabIdent.chercheIdent(nomIdent);
			empilerType(ident.getType());
		}
		else
		{
			//erreur
		}
	}

	public TabIdent getTabIdent() {
		return tabIdent;
	}

	public void setTabIdent(TabIdent tabIdent) {
		this.tabIdent = tabIdent;
	}


}
