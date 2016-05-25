package object;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface décrivant les méthodes que l'on souhaite exposer au client.
 * 
 * @author Arnaud Garnier & Lisa Joanno
 * 
 */
public interface Distante extends Remote {

	public String saySomething() throws RemoteException;
	
	public void sabonnerFougereMag(String nomClient) throws RemoteException;

}
