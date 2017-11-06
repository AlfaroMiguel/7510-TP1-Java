package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class NumbersDBTest {

    @InjectMocks
    private KnowledgeBase knowledgeBase;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        knowledgeBase.parseDB("src/main/resources/numbers.db");
    }

    @Test
    public void testFact1ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("add(zero, zero, zero)."));
    }

    @Test
    public void testFact2ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("add(zero, zero, one)."));
    }

    @Test
    public void testFact3ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("add(one, one, two)."));
    }

    @Test
    public void testFact4ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("add(zero, two, two)."));
    }

    @Test
    public void testFact5ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("add(zero, two, zero)."));
    }

    @Test
    public void testFact6ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("add(two, one, one)."));
    }

    @Test
    public void testFact7ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("add(zero, one, two)."));
    }

    @Test
    public void testRule1ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("subtract(one, one, two)."));
    }

    @Test
    public void testRule2houldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("subtract(two, one, one)."));
    }

    @Test
    public void testRule3ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("subtract(one, one, zero)."));
    }

    @Test
    public void testRule4ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("subtract(one, one, one)."));
    }

    @Test
    public void testRule5ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("subtract(two, one, one)."));
    }


}
