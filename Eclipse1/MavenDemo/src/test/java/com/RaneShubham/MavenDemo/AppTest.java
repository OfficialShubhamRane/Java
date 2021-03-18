package com.RaneShubham.MavenDemo;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Rigourous Test :-)
     */
	 public void testApp()
	    {
		 	
	        assertTrue( App.check().length() == 2 );
	    }
}
