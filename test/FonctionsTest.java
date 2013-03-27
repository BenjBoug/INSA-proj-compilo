package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import compilateur.*;

public class FonctionsTest {
	
	Fonctions fonctions;
	TabIdent tabIdent;
	Expression expr;

	@Before
	public void setUp() throws Exception {
		tabIdent = new TabIdent();
		expr = new Expression(tabIdent);
		fonctions = new Fonctions(tabIdent,expr);
	}

	@Test
	public void testTestTypesArguments() {
		fonctions.setTypeRetour(0);
		fonctions.ajouteFonction("test");
		fonctions.ajoutParam("test1");
		fonctions.ajoutParam("test2");

		expr.empilerType(1);
		expr.empilerType(0);
		expr.empilerType(0);
		expr.empilerType(0);
		
		fonctions.testTypesArguments(2, new Token());
		
		assertEquals(0, expr.getSommetTypes());
	}

	@Test
	public void testAjouteFonction() {
		fonctions.ajouteFonction("test");
		Ident id = tabIdent.chercheIdent("test");
		assertEquals("test", id.getNom());
		assertEquals("test", fonctions.getNomFoncActuel());
		assertEquals("test", fonctions.foncActuelle().getNom());
	}

	@Test
	public void testAjoutParam() {
		fonctions.setTypeRetour(0);
		fonctions.ajouteFonction("test");
		fonctions.ajoutParam("test1");
		assertTrue(tabIdent.existeIdentLocal("test1"));
		assertFalse(tabIdent.existeIdentGlobal("test1"));
		fonctions.ajoutParam("test2");
		
		assertEquals(2, fonctions.foncActuelle().getNbParam());
		fonctions.ajoutParam("test3");
		assertEquals(3, fonctions.foncActuelle().getNbParam());
		
		
	}

}
