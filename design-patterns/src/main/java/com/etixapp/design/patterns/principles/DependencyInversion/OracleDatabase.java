package com.etixapp.design.patterns.principles.DependencyInversion;

public class OracleDatabase implements Database {

	public void connect(){
		System.out.println("Connecting to Oracle database");
	}
	public void disconnect(){
		System.out.println("Disconnecting to Oracle database");
	}
}
