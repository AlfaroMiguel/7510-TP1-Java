package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class IncompleteDBTest {

    @InjectMocks
    private KnowledgeBase knowledgeBase;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void testParseIncompleteDatabaseReturnFalse() {
        Assert.assertFalse(knowledgeBase.parseDB("src/main/resources/incomplete.db"));
    }

    @Test
    public void testParseNonExistingDBReturnFalse() {
        Assert.assertFalse(knowledgeBase.parseDB("src/main/resources/nonExistingFile.db"));
    }



}
