package org.aamm.z2java.lesson2;

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
		
		if ( mockPrintStream.callCount() != 3 ) {
			fail("The main method should call the method System.out.println(String) 3 times.");
		}
		
		mockPrintStream.flush();
		String s = bos.toString();
		assertEquals( "", "56544\n580\n-332\n", s );
	}

}