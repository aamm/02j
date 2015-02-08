package org.aamm.z2java.lesson3;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class GuidanceTest {

	@Test
	public void testMain() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		MockPrintStream mockPrintStream = new MockPrintStream( System.out, bos );
		System.setOut( mockPrintStream );
		
		App.main(new String[] {});
		
		if ( mockPrintStream.callCount() != 2 ) {
			fail("The main method should call the method System.out.println(String) 2 times.");
		}
		
		mockPrintStream.flush();
		String s = bos.toString();
		assertEquals( "", "The message: ciao\n-58\n", s );
	}

	@Test
	public void testPrintDifference() {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                MockPrintStream mockPrintStream = new MockPrintStream( System.out, bos );
                System.setOut( mockPrintStream );

                App.printDifference(100, 10);
		App.printDifference(50, 50);
		App.printDifference(6, 20);

                if ( mockPrintStream.callCount() != 3 ) {
                        fail("The main method should call the method System.out.println(String) 3 times.");
                }

                mockPrintStream.flush();
                String s = bos.toString();
                assertEquals( "", "90\n0\n-14\n", s );
	}
}
