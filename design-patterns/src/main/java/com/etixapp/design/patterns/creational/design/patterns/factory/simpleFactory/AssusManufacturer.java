package com.etixapp.design.patterns.creational.design.patterns.factory.simpleFactory;

public class AssusManufacturer extends Company{
	@Override
	public Gpu createGpu() {
		return new AssusGpu();
	}
}
