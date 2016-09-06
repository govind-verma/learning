package com.gs.ds.designpatterns.singleton;
/**
 * This is best way to create Singleton
 * @author govinda.verma
 *
 */
public class BillPaughSingleton {
	private BillPaughSingleton() {

	}

	private static class BillPaughSingletonHelper {
		private static final BillPaughSingleton INSTANCE = new BillPaughSingleton();
	}

	public static BillPaughSingleton getInstance(){
		return BillPaughSingletonHelper.INSTANCE;
	}
}
