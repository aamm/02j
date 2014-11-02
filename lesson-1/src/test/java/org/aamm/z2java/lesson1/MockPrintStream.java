package org.aamm.z2java.lesson1;

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
		shadow.print(b);
		original.print(b);
	}

	public void print(char c) {
		shadow.print(c);
		original.print(c);
	}

	public void print(char[] s) {
		shadow.print(s);
		original.print(s);
	}

	public void print(double d) {
		shadow.print(d);
		original.print(d);
	}

	public void print(float f) {
		shadow.print(f);
		original.print(f);
	}

	public void print(int i) {
		shadow.print(i);
		original.print(i);
	}

	public void print(long l) {
		shadow.print(l);
		original.print(l);
	}

	public void print(Object obj) {
		shadow.print(obj);
		original.print(obj);
	}

	public void print(String s) {
		shadow.print(s);
		original.print(s);
	}

	public PrintStream printf(Locale l, String format, Object... args) {
		shadow.printf(l, format, args);
		return original.printf(l, format, args);
	}

	public PrintStream printf(String format, Object... args) {
		shadow.printf(format, args);
		return original.printf(format, args);
	}

	public void println() {
		shadow.println();
		original.println();
	}

	public void println(boolean x) {
		shadow.println(x);
		original.println(x);
	}

	public void println(char x) {
		shadow.println(x);
		original.println(x);
	}

	public void println(char[] x) {
		shadow.println(x);
		original.println(x);
	}

	public void println(double x) {
		shadow.println(x);
		original.println(x);
	}

	public void println(float x) {
		shadow.println(x);
		original.println(x);
	}

	public void println(int x) {
		shadow.println(x);
		original.println(x);
	}

	public void println(long x) {
		shadow.println(x);
		original.println(x);
	}

	public void println(Object x) {
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