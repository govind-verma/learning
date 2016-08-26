package com.gs.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateInsert {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:\\property.txt"))));
		String property = null;
		String sql = "INSERT INTO snapdeal_property(name, value) VALUES";
		String values = "";
		
		while((property = bf.readLine()) != null) {
			values = values + "( '";
			String key = property.split("=")[0];
			values = values + key + "','";
			
			String value = property.split("=")[1];
			
			values = values + value + "'),";
		}
		System.out.println(sql + values);
	}
}
