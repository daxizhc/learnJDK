import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.naming.NamingException;

public class WareHouseClient {

    public static void main(String[] args) throws NamingException, RemoteException, MalformedURLException, NotBoundException {
        System.out.println("RMI registry bindings:");

        // 可以打印注册的所有rmi服务
        String[] e = Naming.list("//localhost:9000");
        for (String s : e) {
            System.out.println(s);
        }

        String url = "//localhost:9000/central_warehouse";
        Warehouse warehouse = (Warehouse)Naming.lookup(url);

        String descr = "Blackwell Toaster";
        double price = warehouse.getPrice(descr);
        System.out.println(descr + ": " + price);
    }


}
