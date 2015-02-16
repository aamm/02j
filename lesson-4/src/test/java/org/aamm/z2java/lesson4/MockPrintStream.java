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
package org.aamm.z2java.lesson4;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class MockPrintStream extends PrintStream {

	private PrintStream original;
	private PrintStream shadow;
	private int callCount = 0;
	
	public MockPrintStream(PrintStream original, OutputStream myout) {
		super(myout);
		this.original = original;
		shadow = new PrintStream(myout, true);
	}
	
	public int callCount() {
		return callCount;
	}
	
	public PrintStream append(char c) {
		shadow.append(c);
		return original.append(c);
	}

	public PrintStream append(CharSequence csq, int start, int end) {
		shadow.append(csq, start, end);
		return original.append(csq, start, end);
	}

	public PrintStream append(CharSequence csq) {
		shadow.append(csq);
		return original.append(csq);
	}

	public boolean checkError() {
		shadow.checkError();
		return original.checkError();
	}

	public void close() {
		shadow.close();
		original.close();
	}

	public boolean equals(Object obj) {
		shadow.equals(obj);
		return original.equals(obj);
	}

	public void flush() {
		shadow.flush();
		original.flush();
	}

	public PrintStream format(Locale l, String format, Object... args) {
		shadow.format(l, format, args);
		return original.format(l, format, args);
	}

	public PrintStream format(String format, Object... args) {
		shadow.format(format, args);
		return original.format(format, args);
	}

	public int hashCode() {
		shadow.hashCode();
		return original.hashCode();
	}

	public void print(boolean b) {
		callCount++;
		shadow.print(b);
		original.print(b);
	}

	public void print(char c) {
		callCount++;
		shadow.print(c);
		original.print(c);
	}

	public void print(char[] s) {
		callCount++;
		shadow.print(s);
		original.print(s);
	}

	public void print(double d) {
		callCount++;
		shadow.print(d);
		original.print(d);
	}

	public void print(float f) {
		callCount++;
		shadow.print(f);
		original.print(f);
	}

	public void print(int i) {
		callCount++;
		shadow.print(i);
		original.print(i);
	}

	public void print(long l) {
		callCount++;
		shadow.print(l);
		original.print(l);
	}

	public void print(Object obj) {
		callCount++;
		shadow.print(obj);
		original.print(obj);
	}

	public void print(String s) {
		callCount++;
		shadow.print(s);
		original.print(s);
	}

	public PrintStream printf(Locale l, String format, Object... args) {
		callCount++;
		shadow.printf(l, format, args);
		return original.printf(l, format, args);
	}

	public PrintStream printf(String format, Object... args) {
		callCount++;
		shadow.printf(format, args);
		return original.printf(format, args);
	}

	public void println() {
		callCount++;
		shadow.println();
		original.println();
	}

	public void println(boolean x) {
		callCount++;
		shadow.println(x);
		original.println(x);
	}

	public void println(char x) {
		callCount++;
		shadow.println(x);
		original.println(x);
	}

	public void println(char[] x) {
		callCount++;
		shadow.println(x);
		original.println(x);
	}

	public void println(double x) {
		callCount++;
		shadow.println(x);
		original.println(x);
	}

	public void println(float x) {
		callCount++;
		shadow.println(x);
		original.println(x);
	}

	public void println(int x) {
		callCount++;
		shadow.println(x);
		original.println(x);
	}

	public void println(long x) {
		callCount++;
		shadow.println(x);
		original.println(x);
	}

	public void println(Object x) {
		callCount++;
		shadow.println(x);
		original.println(x);
	}

	public void println(String x) {
		callCount++;
		shadow.println(x);
		original.println(x);
	}

	public String toString() {
		shadow.toString();
		return original.toString();
	}

	public void write(byte[] buf, int off, int len) {
		shadow.write(buf, off, len);
		original.write(buf, off, len);
	}

	public void write(byte[] b) throws IOException {
		shadow.write(b);
		original.write(b);
	}

	public void write(int b) {
		shadow.write(b);
		original.write(b);
	}
}
