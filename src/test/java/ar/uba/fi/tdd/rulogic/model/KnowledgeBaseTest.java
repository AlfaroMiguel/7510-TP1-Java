package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class KnowledgeBaseTest {

	@InjectMocks
	private KnowledgeBase knowledgeBase;

	@Before
	public void setUp() throws Exception {
		initMocks(this);
		knowledgeBase.parseDB("src/main/resources/rules.db");
	}

	@Test
	public void testTrueFact() {
		Assert.assertTrue(this.knowledgeBase.answer("varon(juan)."));
	}

	@Test
	public void testTrueFactWithoutWhiteSpace() {
		Assert.assertTrue(this.knowledgeBase.answer("mujer(maria)."));
	}

	@Test
	public void testTrueFactWithWhitepace() {
		Assert.assertTrue(this.knowledgeBase.answer("mujer (maria) ."));
	}

	@Test
	public void testFalseFact() {
		Assert.assertFalse(this.knowledgeBase.answer("varon (javier)."));
	}

	@Test
	public void testTrueFactWithTwoArgs() {
		Assert.assertTrue(this.knowledgeBase.answer("padre(juan, pepe)."));
	}

	@Test
	public void testTrueFactWithTwoArgsAndWhitespaces() {
		Assert.assertTrue(this.knowledgeBase.answer("padre (juan,   pepe)   ."));
	}

	@Test
	public void testFalseFactWithTwoArgs() {
		Assert.assertFalse(this.knowledgeBase.answer("padre (juan, miguel)."));
	}

	@Test
	public void testTrueRuleWithTwoArgs() {
		Assert.assertTrue(this.knowledgeBase.answer("hijo(pepe,juan)."));
	}

	@Test
	public void testFalseRuleWithTwoArgs() {
		Assert.assertFalse(this.knowledgeBase.answer("hijo(juan,pepe)."));
	}

	@Test
	public void testTrueRuleWithThreeArgs() {
		Assert.assertTrue(this.knowledgeBase.answer("tio(nicolas, cecilia, roberto)."));
	}

	@Test
	public void testFalseRuleWithThreeArgs() {
		Assert.assertFalse(this.knowledgeBase.answer("tio(pepe, cecilia, roberto)."));
	}

	@Test
	public void testIncompleteQueryIsFalse() {
		Assert.assertFalse(this.knowledgeBase.answer("tio(pepe, cecil"));
	}

	@Test
	public void testNonExistingRuleIsFalse() {
		Assert.assertFalse(this.knowledgeBase.answer("sobrino(pepe, cecilia)"));
	}

}
