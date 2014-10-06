package codeparser;
// -------------------------------------------------------------------------
/**
 *  The parser handles strings of parentheses: ( ) and curly braces: { }
 *  to make sure they are balanced and nest correctly.
 *
 *  TODO: Refactor this class!
 *
 *  @author CSCI 430 Class
 *  @version Sep 14, 2014
 */

public class CodeParser
{
    private String content;
    private final static int MAX_LINE_LENGTH = 80;
    //maximum depth of the parens nesting: ()()=1, (())=2, ((()))=3
    public int maxDepthParens;
    //maximum depth of the curly brace nesting: {}=1, {{}}=2, {}{}=1
    public int maxDepthCurlyBrace;

    public CodeParser()
    {
    }



    public void setContent(String content)
    {
        this.content = content;
    }
    public String getContent()
    {
        return content;
    }
    /**
     * Finds whether or not every open paren ( has a corresponding closed
     * paren ) following it
     * @return whether or not open and closed parens are balanced within
     *         the <code>
     */
    public Boolean hasBalancedParentheses()
    {
        maxDepthParens = 0;
        return hasBalancedCharacters('(',')');
    }
    // same deal, but with {} instead of ()
    public Boolean hasBalancedCurlyBraces()
    {
        maxDepthCurlyBrace = 0;
        return hasBalancedCharacters('{','}');
    }

    private Boolean hasBalancedCharacters(char open, char closed)
    {
        int count = 0;
        for( int i = 0; i< content.length(); i++ )
        {
            if( content.charAt(i) == open )
            {
                count++;
            }
            else if ( content.charAt(i) == closed )
            {
                count--;
                if( count < 0 )
                {
                    return false;
                }
            }

            if( count > maxDepthCurlyBrace && open == '{' )
            {
                maxDepthCurlyBrace = count;
            }
            else if( count > maxDepthParens && open == '(' )
            {
                maxDepthParens = count;
            }
        }
        return count == 0;
    }


    /**
     * Checks to see if each line of the code is less than or equal to
     * 80 characters long
     * @return true if all lines are <=80 characters long, false otherwise
     */
    public Boolean allLinesWithinLimit()
    {
        String[] lines = content.split("\n");
        for(int i=0; i< lines.length; i++)
        {
            if( lines[i].length() > MAX_LINE_LENGTH )
            {
                return false;
            }
        }
        return true;
    }
}



















