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
    private int count;

    public CodeParser()
    {
    }

    //maximum depth of the parens nesting: ()()=1, (())=2, ((()))=3
    public int maxDepthParens;
    //maximum depth of the curly brace nesting: {}=1, {{}}=2, {}{}=1
    public int maxDepthCurlyBrace;

    public void setContent(String content)
    {
        this.content = content;
    }
    public String getContent()
    {
        return this.content;
    }
    /**
     * Finds whether or not every open paren ( has a corresponding closed
     * paren ) following it
     * @return whether or not open and closed parens are balanced within
     *         the <code>
     */
    public Boolean hasBalancedParentheses()
    {

        String word = content;
        count = 0;
        for(int i = 0; i< word.length(); i++)
        {
            if( word.charAt(i) == '(' )
                count++;
            else if ( word.charAt(i) == ')')
                count--;
            if( count < 0 )
                return false;
            if( count > maxDepthParens ) maxDepthParens = count;
        }
        return count==0;
    }
    // same deal, but with {} instead of ()
    public Boolean hasBalancedCurlyBraces()
    {

        String word = content;
        count = 0;
        for(int i = 0; i< word.length(); i++){
            if( word.charAt(i) == '{' ){
                count++;
            }
            else if ( word.charAt(i) == '}'){
                count--;
            }
            if( count < 0 ){
                return false;
            }
            if( count > maxDepthCurlyBrace ) {
                maxDepthCurlyBrace = count;
            }
        }
        return count==0;
    }
    /**
     * Checks to see if each line of the code is less than or equal to
     * 80 characters long
     * @return true if all lines are <=80 characters long, false otherwise
     */
    public Boolean allLinesWithinLimit()
    {
        String[] lines = content.split("\n");
        for(int i=0; i< lines.length; i++) {
            if( lines[i].length() > 80 )
                return false;
        }
        return true;
    }
}




