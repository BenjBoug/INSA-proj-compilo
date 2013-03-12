import java.util.Stack;


public class Conditionnelle implements Etiquette {
	
	protected Stack<Integer> stack = new Stack<Integer>();
	protected int nbCondition = 0; 	
	protected final String labelEtiquetteSinon = "SINON";
	protected final String labelEtiquetteFin = "FSI";

	

	public void nouvelleConditionnelle()
	{
		nbCondition++;
		stack.push(nbCondition);
	}
	
	public String getEtiquetteSinon()
	{
		return labelEtiquetteSinon+stack.peek();
	}

	@Override
	public String getEtiquetteFin()
	{
		return labelEtiquetteFin+stack.peek();
	}

	@Override
	public String getEtiquetteFinAndFinish()
	{
		return labelEtiquetteFin+stack.pop();
	}

	@Override
	public String getEtiquetteDebut() {
		return "SI"+stack.peek();
	}

	@Override
	public String getEtiquetteSuivante() {
		return getEtiquetteSinon();
	}
}
