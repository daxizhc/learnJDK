import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.NamingException;

public class WareHouseServer {

    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException, MalformedURLException {
//        System.setProperty("java.rmi.server.hostname", "192.168.0.102");
        System.out.println("Constructing server implementation...");
        WarehouseImpl centralWarehouse = new WarehouseImpl();

        System.out.println("Binding server implementation to registry...");
        // 创建注册表
        LocateRegistry.createRegistry(9000);
        Naming.bind("//localhost:9000/central_warehouse", centralWarehouse);

        System.out.println("Waiting for invocations from clients...");
    }

}
