package com.etixapp.design.patterns.creational.design.patterns.factory.abstractFactory;

public class MsiManufacturer2 extends Company2 {
	@Override
	public Gpu2 createGpu() {
		return new MsiGpu2();
	}

	@Override
	public Monitor createMonitor() {
		return new MsiMonitor();
	}
}
