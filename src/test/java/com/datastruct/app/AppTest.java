package com.datastruct.app;

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
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws InterruptedException {
        assertTrue( true );
        StackOfStringLinkListTest();
        StackGenericLinkListTest();
        StackGenericLinkListThreadingTest();
    }


    public void StackOfStringLinkListTest(){
        StackOfStringLinkList stack = new StackOfStringLinkList();
        stack.push("first");
        assertFalse(stack.isEmpty());

        stack.push("second");
        assertTrue(stack.pop().equals("second"));
        stack.push("third");
        stack.push("fourth");
        assertTrue(stack.pop().equals("fourth"));
        assertTrue(stack.pop().equals("third"));
        assertTrue(stack.pop().equals("first"));
        assertTrue(stack.isEmpty());
    }

    public void StackGenericLinkListTest(){
        StackGenericLinkList<String> stackOfString = new StackGenericLinkList();
        stackOfString.push("first");
        assertFalse(stackOfString.isEmpty());

        stackOfString.push("second");
        assertTrue(stackOfString.pop().equals("second"));
        stackOfString.push("third");
        stackOfString.push("fourth");
        assertTrue(stackOfString.pop().equals("fourth"));
        assertTrue(stackOfString.pop().equals("third"));
        assertTrue(stackOfString.pop().equals("first"));
        assertTrue(stackOfString.isEmpty());

        StackGenericLinkList<Integer> stackOfInt = new StackGenericLinkList();
        stackOfInt.push(1);
        assertFalse(stackOfInt.isEmpty());

        stackOfInt.push(2);
        assertTrue(stackOfInt.pop().equals(2));
        stackOfInt.push(3);
        stackOfInt.push(4);
        assertTrue(stackOfInt.pop().equals(4));
        assertTrue(stackOfInt.pop().equals(3));
        assertTrue(stackOfInt.pop().equals(1));
        assertTrue(stackOfInt.isEmpty());

    }

    public void StackGenericLinkListThreadingTest() throws InterruptedException {
        final int numOfLoop = 10;

        final StackGenericLinkList<Integer> stackOfInt = new StackGenericLinkList();

        Thread t1 = new Thread(){
            @Override
            public void run(){
                for (int i=0; i < numOfLoop; i++ ){
                    stackOfInt.push(i);
                    System.out.println("thread 1 " + i );
                }

            }

        };

        Thread t2 = new Thread(){
            @Override
            public void run(){
                for (int i=0; i < numOfLoop; i++ )
                    System.out.println("thread 2 " + stackOfInt.pop() );
            }

        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }



}
