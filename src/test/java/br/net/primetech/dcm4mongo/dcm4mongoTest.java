package br.net.primetech.dcm4mongo;

import junit.framework.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * Unit test for simple dcm4mongo.
 */
public class dcm4mongoTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public dcm4mongoTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( dcm4mongoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
