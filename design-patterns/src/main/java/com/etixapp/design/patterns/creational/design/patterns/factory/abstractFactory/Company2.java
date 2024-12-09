package com.etixapp.design.patterns.creational.design.patterns.factory.abstractFactory;

public abstract class Company2 {

//	public Gpu2 assambleGpu(){
//		Gpu2 gpu = createGpu();
//		gpu.assamble();
//		return gpu;
//	}

	public abstract Gpu2 createGpu();
	public  abstract Monitor createMonitor();
}
