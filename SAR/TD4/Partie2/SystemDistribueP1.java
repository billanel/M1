package Partie2;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

public class SystemDistribueP1 {
    public static void main(String[] args) throws RemoteException, Exception {
        OD1I od1 = new OD1Impl();
        Registry reg = LocateRegistry.createRegistry(1099);
        // dans le cas où od1 n'est pas un UnicastRemoteObject
        // od1 = (OD1I)UnicastRemoteObject.exportObject(od1);
        reg.rebind("OD1I", od1); // lancement d'un serveur d'OD (Skeleton)

        // Tread.sleep(qqsecondes); // pour attendre que tous les processus soient
        // synchronisés

        // Naming.rebind("rmi://@IP_RMIRegistry:1099/OD1I", od1);
        Registry reg2 = LocateRegistry.getRegistry("@IP_serveur2", 1099);
        Registry reg3 = LocateRegistry.getRegistry("@IP_serveur3", 1099);
        OD2I od2 = (OD2I) reg2.lookup("OD2I");
        OD3I od3 = (OD3I) reg3.lookup("OD3I");
        // OD2I od2 = (OD2I)Naming.lookup("rmi://@IP_RMIRegistry:1099/OD2I");
        // OD3I od3 = (OB3I)Naming.lookup("rmi://@IP_RMIRegistry:1099/OD3I");

        ProcessusP1 p1 = new ProcessusP1(od1, od2, od3);
        p1.run();
    }

}
