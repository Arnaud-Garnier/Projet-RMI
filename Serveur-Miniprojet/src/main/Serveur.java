package main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import object.Distante;


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
			
			// Teste du RMI regsitry de Java
			Registry reg = LocateRegistry.getRegistry("localhost", 1098);
			reg.rebind("ObjDist", od);
			
			/**** RMI ****/
			

			// Chargement du registre RMI universel implémenté
			IMyRMIRegistry myReg = (IMyRMIRegistry) Naming.lookup("rmi://localhost:1098/MyRMI");
			
			// Côté MyRMIRegistry, on voit que la taille de la hashmap est 0
			myReg.lookup("rmi://localhost:1098/ObjDist");
			// On bind un ObjetDistant
			myReg.bind("ObjDist", od);
			// Côté MyRMIRegistry, on voit que la taille de la hashmap est 1 !
			myReg.lookup("rmi://localhost:1098/ObjDist");
            
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
