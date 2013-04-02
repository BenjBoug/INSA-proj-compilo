package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import compilateur.IdVar;
import compilateur.Ident;
import compilateur.TabIdent;

public class TabIdentTest {
	
	TabIdent tabIdent;

	@Before
	public void setUp() throws Exception {
		
		tabIdent = new TabIdent();
	}

	@Test
	public void testChercheIdent() {
		Ident id1 = new IdVar(IdVar.ENTIER,"test",50);
		tabIdent.rangeIdent("test", id1);
		assertEquals(id1, tabIdent.chercheIdent("test"));
	}

	@Test
	public void testChercheFonction() {
		fail("Not yet implemented");
	}

	@Test
	public void testExisteIdent() {
		fail("Not yet implemented");
	}

	@Test
	public void testExisteIdentLocal() {
		fail("Not yet implemented");
	}

	@Test
	public void testExisteIdentGlobal() {
		fail("Not yet implemented");
	}

	@Test
	public void testRangeIdentStringIdent() {
		fail("Not yet implemented");
	}

	@Test
	public void testRangeFonction() {
		fail("Not yet implemented");
	}

	@Test
	public void testNombreVariable() {
		fail("Not yet implemented");
	}

}
