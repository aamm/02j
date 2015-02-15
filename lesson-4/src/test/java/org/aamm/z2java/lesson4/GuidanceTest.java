package org.aamm.z2java.lesson4;

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
		
		if ( mockPrintStream.callCount() != 1 ) {
			fail("The main method should call the method System.out.println(String) 2 times.");
		}
		
		mockPrintStream.flush();
		String s = bos.toString();
		assertEquals( "", "10 * 20 = 200\n", s );
	}

	@Test
	public void testMultiply() {
		assertEquals(23 * 44, App.multiply(23, 44));
		assertEquals(-1 * -5, App.multiply(-1, -5));
	}
}
