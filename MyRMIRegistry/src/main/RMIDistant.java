package main;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * Implémentation des méthodes de base d'un RMI registry : bind, list, rebind et lookup.
 * 
 * @author Arnaud Garnier & Lisa Joanno
 *
 */
public class RMIDistant extends UnicastRemoteObject implements IMyRMIRegistry {

	/**
	 * Auto-generated serial number
	 */
	private static final long serialVersionUID = 1L;

	private HashMap<String, Remote> registry;

	protected RMIDistant() throws RemoteException {
		super();
		registry = new HashMap<String, Remote>();
	}

	/**
	 * Enregistre l'objet obj dans le registry
	 */
	@Override
	public void bind(String name, Remote obj) throws RemoteException {
		registry.put(name, obj);
	}

	/**
	 * Retourne la list des noms enregistrés dans le registry
	 */
	@Override
	public String[] list() throws RemoteException {
		System.out.println("Je liste !");
		String[] res = registry.keySet().toArray(new String[registry.size()]);
		return res;
	}

	/**
	 * Permet de récupérer l'objet dont la clé est name
	 */
	@Override
	public Remote lookup(String name) throws RemoteException {
		System.out.println("Je lookup !");
		System.out.println("Taille de la hashmap : " + registry.size());
		return registry.get(name);
	}

	/**
	 * Permet de réenregistrer un objet dans le registry
	 */
	@Override
    public void rebind(String name, Remote obj) throws RemoteException {
		System.out.println("Je rebind !");
        registry.put(name, obj);
        
    }
	/**
	 * Permet de supprimer un objet du registry
	 */
	@Override
	public void unbind(String name) throws RemoteException {
		System.out.println("J'unbind !");
		registry.remove(name);
	}

}
