package org.aamm.z2java.lesson1;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class GuidanceTest {

	@Test
	public void test() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		MockPrintStream mockPrintStream = new MockPrintStream(System.out, bos);
		System.setOut(mockPrintStream);
		
		App.main(new String[]{});
		
		if(mockPrintStream.callCount()==0) {
			fail("The main method should call the method System.out.println(String) to print \"Hello World\"");
		}
		
		mockPrintStream.flush();
		String s = bos.toString();
		assertEquals("The message you printed was not \"Hello World\". Take care about the differences between print and println.", "Hello World\n", s);
	}

}
