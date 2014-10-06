package codeparser;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;


public class CodeParserTest extends TestCase
{
    private CodeParser parse;

    @Before
    public void setUp()
        throws Exception
    {
        parse = new CodeParser();
    }

    @Test
    public void testMutators()
    {
        CodeParser code = new CodeParser();
        String s = "word";
        code.setContent(s);
        String t = code.getContent();
        assertEquals(s, t);
    }

    @Test
    public void testParensBalancedClosedOnly()
    {
        parse.setContent(")");
        Boolean result = parse.hasBalancedParentheses();
        assertFalse(result);
    }

    @Test
    public void testNestedParensBalanced()
    {
        parse.setContent("(())");
        assertTrue(parse.hasBalancedParentheses());

    }

    @Test
    public void testOutOfOrderParensBalanced()
    {
        parse.setContent("())(");
        assertFalse(parse.hasBalancedParentheses());
    }

    @Test
    public void testMoreOpenParensBalanced()
    {
        parse.setContent("(()");
        assertFalse(parse.hasBalancedParentheses());
    }

    @Test
    public void testOtherCharactersBalanced()
    {
        parse.setContent("( ) (hi), . ( (K ))");
        assertTrue(parse.hasBalancedParentheses());
    }

    @Test
    public void testCurlyBalancedClosedOnly()
    {
        parse.setContent("}");
        Boolean result = parse.hasBalancedCurlyBraces();
        assertFalse(result);
    }

    @Test
    public void testNestedCurlyBalanced()
    {
        parse.setContent("{{}}");
        assertTrue(parse.hasBalancedCurlyBraces());

    }

    @Test
    public void testOutOfOrderCurlyBalanced()
    {
        parse.setContent("{}}{");
        assertFalse(parse.hasBalancedCurlyBraces());
    }

    @Test
    public void testMoreOpenCurlyBalanced()
    {
        parse.setContent("{{}");
        assertFalse(parse.hasBalancedCurlyBraces());
    }

    @Test
    public void testOtherCharactersCurlyBalanced()
    {
        parse.setContent("{ } {hi}, . { {K }}");
        assertTrue(parse.hasBalancedCurlyBraces());
    }

    @Test
    public void testAllLinesOneShortLine()
    {
        parse.setContent("Less than the limit");
        assertTrue(parse.allLinesWithinLimit());
    }

    @Test
    public void testAllLinesMultipleShortLines()
    {
        parse.setContent("Less\nthan\nthe\nlimit\nmulti-\nline");
        assertTrue(parse.allLinesWithinLimit());
    }

    @Test
    public void testAllLinesOnlyEndlines()
    {
        parse.setContent("\n\n");
        assertTrue(parse.allLinesWithinLimit());
    }

    @Test
    public void testAllLinesOneLongLine()
    {
        parse.setContent("A lot of Characters.................................................................................. like, really long.");
        assertFalse(parse.allLinesWithinLimit());
    }

    @Test
    public void testAllLinesSecondLineLong()
    {
        parse.setContent("First line is short\nBut second has a lot of Characters...........                    ! ! ! and more stuff                         ");
        assertFalse(parse.allLinesWithinLimit());
    }

    @Test
    public void testAllLinesMiddleLineLong()
    {
        parse.setContent("First\nand second lines are short\nBut third                    has              a                lot              of                    Characters.\nLast is short!!!!!!!!!!!");
        assertFalse(parse.allLinesWithinLimit());
    }

    @Test
    public void testMaxParensNone()
    {
        parse.setContent("{}{}{{{}}}[[[[]]]][][]");
        Boolean result = parse.hasBalancedParentheses();
        assertEquals(0,parse.maxDepthParens);
    }

    @Test
    public void testMaxParensSequential()
    {
        parse.setContent("()()()()()()()");
        Boolean result = parse.hasBalancedParentheses();
        assertEquals(1,parse.maxDepthParens);
    }

    @Test
    public void testMaxParensThreeDeep()
    {
        parse.setContent("((()))");
        Boolean result = parse.hasBalancedParentheses();
        assertEquals(3,parse.maxDepthParens);
    }

    @Test
    public void testMaxParensDeeperDepth()
    {
        parse.setContent("(()(())((())))");
        Boolean result = parse.hasBalancedParentheses();
        assertEquals(4,parse.maxDepthParens);
    }

    @Test
    public void testMaxCurlyNone()
    {
        parse.setContent("()(())[[[[]]]][][]");
        Boolean result = parse.hasBalancedCurlyBraces();
        assertEquals(0,parse.maxDepthCurlyBrace);
    }

    @Test
    public void testMaxCurlySequential()
    {
        parse.setContent("{}{}{}{}");
        Boolean result = parse.hasBalancedCurlyBraces();
        assertEquals(1,parse.maxDepthCurlyBrace);
    }

    @Test
    public void testMaxCurlyThreeDeep()
    {
        parse.setContent("{{{}}}");
        Boolean result = parse.hasBalancedCurlyBraces();
        assertEquals(3,parse.maxDepthCurlyBrace);
    }

    @Test
    public void testMaxCurlyDeeperDepth()
    {
        parse.setContent("{{}{{{}}}{{}}}");
        Boolean result = parse.hasBalancedCurlyBraces();
        assertEquals(4,parse.maxDepthCurlyBrace);
    }

}















