
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente {

 
    public static void main(String[] args) {
        try {
            Registry registroCliente = LocateRegistry.getRegistry(null);
            Remoto stub = (Remoto) registroCliente.lookup("objeto");
            
            String mensagemDoServidor = stub.dizerOlaMundo();
            
            int resultado = stub.multiplaNumeros(5, 5);
            
            System.out.println(mensagemDoServidor);
            
            System.out.println("O resultado da multiplicacao é: "+ resultado);
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao se comunicar com o Registry");
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Não Encontrou o objeto");
        }
    }
    
}
