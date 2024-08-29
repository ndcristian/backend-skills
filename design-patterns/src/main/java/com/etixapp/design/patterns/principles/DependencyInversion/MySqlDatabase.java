package com.etixapp.design.patterns.principles.DependencyInversion;

// low level module
public class MySqlDatabase implements Database {

	public void connect(){
		System.out.println("Connecting to MySQL database");
	}

	public void disconnect(){
		System.out.println("Disconnecting to MySQL database");
	}
}
