/* From Zero to Java
 * Copyright (C) 2015 Aurelio Akira M. Matsui
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
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
