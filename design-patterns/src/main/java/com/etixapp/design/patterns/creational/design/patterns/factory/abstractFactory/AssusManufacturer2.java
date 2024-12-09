package com.etixapp.design.patterns.creational.design.patterns.factory.abstractFactory;

public class AssusManufacturer2 extends Company2 {
	@Override
	public Gpu2 createGpu() {
		return new AssusGpu2();
	}

	@Override
	public Monitor createMonitor() {
		return new AssusMonitor();
	}
}
