package com.gs.ds.spring;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CustomIOC {

	private String metadata;

	public CustomIOC(String metadata) {
		this.metadata = metadata;
		init();
	}

	private void init() {
		if(metadata == null || metadata.isEmpty()) {
			throw new IllegalArgumentException("Metadata can not be empty or null");
		}
		InputStream is = null;
		BufferedReader bf = null;
		
		is = Thread.currentThread().getContextClassLoader().getResourceAsStream(metadata);
		if(is == null) {
			bf = new BufferedReader(new InputStreamReader(is));
		}

	}
}
