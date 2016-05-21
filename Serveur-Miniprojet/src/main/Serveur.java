package main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Le serveur de l'application
 * 
 * @author Arnaud Garnier & Lisa Joanno
 * 
 */
public class Serveur {

	/**
	 * Constructeur
	 * 
	 * @param rmiPort
	 *            le port sur lequel le rmiregistry est lancé
	 */
	public Serveur(int rmiPort) {
		ObjetDistant od;
		try {
			od = new ObjetDistant();
			MyRMIRegistry reg = LocateRegistry.getRegistry(rmiPort);
			reg.rebind("ObjDist", od);
		} catch (RemoteException re) {
			System.err.println(re.getCause().getMessage());
		}
	}

}
