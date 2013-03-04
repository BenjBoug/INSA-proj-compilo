import java.util.Stack;


public class Iteration {

	protected Stack<Integer> stackBoucle = new Stack<Integer>(); 	
	protected int nbBoucles = 1;
	protected final String labelEtiquetteDebut = "FAIRE";
	protected final String labelEtiquetteFin = "FAIT";
	
	
	
	public void nouvelleIterationb()
	{
		stackBoucle.push(nbBoucles);
		nbBoucles++;
	}
	
	public String getLabelIteration()
	{
		return labelEtiquetteDebut+nbBoucles;
	}
	
	public String getEtiquetteFin()
	{
		return labelEtiquetteFin+stackBoucle.peek();
	}
	
	public String getEtiquetteDebut()
	{
		return labelEtiquetteDebut+stackBoucle.peek();
	}
	
	public String getEtiquetteFinAndFinish()
	{
		return labelEtiquetteFin+stackBoucle.pop();
	}
}
