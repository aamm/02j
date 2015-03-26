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
package org.aamm.z2java.lesson6;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class GuidanceTest {

	@Test
	public void testMain() {
		assertEquals((1 + 5) * 5 / 2, App.sum(1, 5));
		assertEquals((1 + 1000) * 1000 / 2, App.sum(1, 1000));
		assertEquals(0, App.sum(42, 13));
	}
}
