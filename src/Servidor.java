
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor implements Remoto {
    
 @Override
    public String dizerOlaMundo() throws RemoteException {
        return "Esta mensagem veio do Servidor. Ola Mundo!";
    }

    @Override
    public int multiplaNumeros(int num1, int num2) throws RemoteException {
        int resultado = num1 * num2;

        return resultado;
    }
   

    public static void main(String[] args) {

        try {
            Servidor obj = new Servidor();
            
            // Exportar esse objeto criado - Deixar disponivel para qualquer cliente
            // acessar esse objeto
            Remoto stub = (Remoto) UnicastRemoteObject.exportObject(obj, 0);
            
            // Criou um registro 
            Registry registro = LocateRegistry.getRegistry();
            // inserri ro objeto neste registro
            registro.bind("objeto", stub);

        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao exportar um objeto");
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nao foi possivel registrar o objeto");
        }

    }



}
