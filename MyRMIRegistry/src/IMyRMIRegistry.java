import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMyRMIRegistry extends Remote {

	public void bind(String name, Remote obj) throws RemoteException;

	public String[] list() throws RemoteException;

	public Remote lookup(String name) throws RemoteException;

	public void rebind(String name, Remote obj) throws RemoteException;

	public void unbind(String name) throws RemoteException, NotBoundException;

}
