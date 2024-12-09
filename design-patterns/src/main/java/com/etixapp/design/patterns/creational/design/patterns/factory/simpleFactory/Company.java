package com.etixapp.design.patterns.creational.design.patterns.factory.simpleFactory;

public abstract class Company {

	public Gpu assambleGpu(){
		Gpu gpu = createGpu();
		gpu.assamble();
		return gpu;
	}

	protected abstract Gpu createGpu();
}
