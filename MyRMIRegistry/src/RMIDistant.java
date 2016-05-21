import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

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
		String[] res = registry.keySet().toArray(new String[registry.size()]);
		return res;
	}

	/**
	 * Permet de récupérer l'objet dont la clé est name
	 */
	@Override
	public Remote lookup(String name) throws RemoteException {
		if (registry.containsKey(name)) {
			return registry.get(name);
		}
		return null;
	}

	/**
	 * Permet de réenregistrer un objet dans le registry
	 */
	@Override
	public void rebind(String name, Remote obj) throws RemoteException {
		registry.remove(name);
		registry.put(name, obj);
	}

	/**
	 * Permet de supprimer un objet du registry
	 */
	@Override
	public void unbind(String name) throws RemoteException, NotBoundException {
		registry.remove(name);
	}

}
