package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class FriendsDBTest {

    @InjectMocks
    private KnowledgeBase knowledgeBase;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        knowledgeBase.parseDB("src/main/resources/friends.db");
    }

    @Test
    public void testFact1ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("friend(pepe, juan)."));
    }

    @Test
    public void testFact2ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("friend(franco, pedro)."));
    }

    @Test
    public void testFact3ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("friend(tomas, pablo)."));
    }

    @Test
    public void testFact4ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("friend(pepe, miguel)."));
    }

    @Test
    public void testFact5ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("friend(tomas, mariano)."));
    }

    @Test
    public void testFact6ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("friend(micaela, juan)."));
    }

    @Test
    public void testFact7ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("enemy(miguel, pepe)."));
    }

    @Test
    public void testFact8ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("enemy(tomas, juan)."));
    }

    @Test
    public void testFact9ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("friend(micaela, juan)."));
    }

    @Test
    public void testFact10ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("friend(micaela, juan)."));
    }



    @Test
    public void testRule1ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("group(pepe, juan, franco)."));
    }

    @Test
    public void testRule2ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("group(miguel, tomas, pablo)."));
    }

    @Test
    public void testRule3ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("group(pepe, juan, tomas)."));
    }

    @Test
    public void testRule4ShouldBeFalse() {
        Assert.assertFalse(knowledgeBase.answer("group(tomas, pablo, pepe)."));
    }

    @Test
    public void testRule5ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("fight(gabriel, miguel, marcos, martin)."));
    }

    @Test
    public void testRule6ShouldBeTrue() {
        Assert.assertTrue(knowledgeBase.answer("fight(miguel, tomas, pepe, juan)."));
    }

}
