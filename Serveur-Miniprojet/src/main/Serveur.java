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
			Registry reg = LocateRegistry.getRegistry(rmiPort);
			reg.lookup("MyRMI");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
