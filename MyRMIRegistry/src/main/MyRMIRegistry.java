package main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class MyRMIRegistry {

	public MyRMIRegistry(int rmiPort) {
		RMIDistant rd;
		try {
			rd = new RMIDistant();
			Registry reg = LocateRegistry.getRegistry(rmiPort);
			reg.rebind("MyRMI", rd);
		} catch (RemoteException re) {
			System.err.println(re.getCause().getMessage());
		}
	}
}
