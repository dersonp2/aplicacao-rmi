
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Remoto extends Remote {
    
   String dizerOlaMundo() throws RemoteException;
   
   int multiplaNumeros(int num1, int num2) throws RemoteException;
}
