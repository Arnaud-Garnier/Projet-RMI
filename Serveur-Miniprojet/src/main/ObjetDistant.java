package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import object.Fougere;

/**
 * L'objet distant qui contient l'implémentation des méthodes de l'interface
 * distante.
 * 
 * @author Arnaud Garnier & Lisa Joanno
 * 
 */
public class ObjetDistant extends UnicastRemoteObject implements Distante {

	/**
	 * AUTO-GENERATED serial number
	 */
	private static final long serialVersionUID = 1L;

	private String stubName;

	public ObjetDistant() throws RemoteException {
	}

	/**
	 * Test function
	 */
	@Override
	public String saySomething() throws RemoteException {
		Fougere f = new Fougere();
		return f.toString() + " ; The RMI is working well";
	}

}
