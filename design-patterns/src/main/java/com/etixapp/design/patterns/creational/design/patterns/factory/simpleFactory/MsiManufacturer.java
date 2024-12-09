package com.etixapp.design.patterns.creational.design.patterns.factory.simpleFactory;

public class MsiManufacturer extends Company{
	@Override
	public Gpu createGpu() {
		return new MsiGpu();
	}
}
