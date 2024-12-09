package designpatterns;

import org.junit.jupiter.api.Test;

import com.etixapp.design.patterns.creational.design.patterns.factory.abstractFactory.AssusManufacturer2;
import com.etixapp.design.patterns.creational.design.patterns.factory.abstractFactory.Company2;
import com.etixapp.design.patterns.creational.design.patterns.factory.abstractFactory.Gpu2;
import com.etixapp.design.patterns.creational.design.patterns.factory.abstractFactory.Monitor;
import com.etixapp.design.patterns.creational.design.patterns.factory.abstractFactory.MsiManufacturer2;
import com.etixapp.design.patterns.creational.design.patterns.factory.simpleFactory.Company;
import com.etixapp.design.patterns.creational.design.patterns.factory.simpleFactory.MsiManufacturer;
import com.etixapp.design.patterns.creational.design.patterns.factory.explainedSimpleFactory.BeefBurger;
import com.etixapp.design.patterns.creational.design.patterns.factory.explainedSimpleFactory.Burger;
import com.etixapp.design.patterns.creational.design.patterns.factory.explainedSimpleFactory.Restaurant;
import com.etixapp.design.patterns.creational.design.patterns.factory.explainedSimpleFactory.VeggieBurger;

public class FactoryTest {

	@Test
	public void test(){

		// SECOND implementation
		/*
		Restaurant restaurant = new Restaurant();
		restaurant.orderBurger("BEEF");
		 */

		//THIRD implementation

		Restaurant beefRestaurant = new BeefBurger();
		Burger beefBurger = beefRestaurant.createBurger();


		Restaurant veggieRestaurant = new VeggieBurger();
		Burger veggieBurger = veggieRestaurant.createBurger();

		// simple factory
		Company msiCompany = new MsiManufacturer();
		msiCompany.assambleGpu();


		Company2 msi = new MsiManufacturer2();
		Gpu2 msiGpu = msi.createGpu();
		Monitor msiMonitormonitor = msi.createMonitor();

		Company2 assus = new AssusManufacturer2();
		Gpu2 assusGpu = assus.createGpu();
		Monitor assusMonitor = assus.createMonitor();

	}
}
