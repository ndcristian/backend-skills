package com.etixapp.design.patterns.principles.DependencyInversion;

// the high level module
public class DatabaseController {

	private MySqlDatabase database;// replace with:

	// this is programing to an interface
	private Database decoupledDatabase;

	// !!wrong way because
	// if we want to change the database we have to change the higher level module (this module)
	// because we are using the new keyword to instantiate database property
	//to solve this we have to create a interface Database
	public DatabaseController() {
		database = new MySqlDatabase();// tightly coupled dependency !!!!
		// the scope is to have loosely coupled software modules
	}

	//!!good way
	// because we shouldn't be aware of the database type parameter
	public DatabaseController(Database database) {
		this.decoupledDatabase = database;
	}

	void connect() {
		this.database.connect();
	}

	void disconnect() {
		this.database.disconnect();
	}

}
