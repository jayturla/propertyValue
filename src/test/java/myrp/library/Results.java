package myrp.library;

import java.util.Arrays;
import java.util.HashMap;

public class Results extends ObjectReference {

	public void pass(String value) {
		System.out.println("PASS - " + value);
		logs(value, "PASS");
	}

	public void fail(String value) {
		java.lang.System.err.println("FAIL - " + value);
		logs(value, "FAIL");
	}

	public void logInput(String[] input) {
		System.out.println("INPUT - " + Arrays.toString(input));
	}

	public void logs(String value, String status) {
		list.put(status, value);
	}

	public void log(String input) {
		System.out.println("LOG - " + input);
	}

}
