package com.gs.misc;

import org.owasp.esapi.ESAPI;

public class Example {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			String str1 = ESAPI.encoder().canonicalize("amitgautam").toString();
			System.out.println(str1);
			/*
			 * String str2=ESAPI.encoder().encodeForHTML("<html> </html>").toString(); System.out.println(str2);
			 */

			/*
			 * String str3=ESAPI.initialize(""); System.out.println("String is-- "+str3+"  yes");
			 */
		} catch (Exception e) {
			System.out.println(" Exceptioncatch by me----" + e);
		}
	}
}
