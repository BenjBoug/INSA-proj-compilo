package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import compilateur.IdConst;

public class IdConstTest {
	
	IdConst constante;

	@Before
	public void setUp() throws Exception {
		constante = new IdConst(IdConst.ENTIER,"aa",5);
	}

	@Test
	public void testGetValeur() {
		assertEquals(5, constante.getValeur());
	}

	@Test
	public void testGetForme() {
		assertEquals(1, constante.getForme());
	}
	
	@Test
	public void testGetType() {
		assertEquals(IdConst.ENTIER, constante.getType());
	}

	@Test
	public void testGetNom() {
		assertEquals("aa", constante.getNom());
	}

}
