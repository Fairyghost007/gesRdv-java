package org.example;

// import org.example.data.core.factory.Factory;
import org.example.data.core.factory.RepositoryFactory;
import org.example.data.entities.Medecin;
import org.example.data.repositories.db.MedecinRepositoryDbImpl;
import org.example.data.services.Impl.MedecinServiceImpl;
import org.example.data.services.Impl.RvServiceImpl;
import org.example.data.views.MedecinViewImpl;
import org.example.data.views.RvViewImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //repository
        // ClientRepositoryDbImpl clientRepositoryImpl = new ClientRepositoryDbImpl();
        //service
        MedecinServiceImpl medecinServiceImpl = new MedecinServiceImpl(RepositoryFactory.createMedecinRepository());
        RvServiceImpl rvServiceImpl = new RvServiceImpl(RepositoryFactory.createRvRepository());
        //views
        MedecinViewImpl medecinView = new MedecinViewImpl(medecinServiceImpl,rvServiceImpl);
        RvViewImpl rvView = new RvViewImpl(rvServiceImpl);

        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1- Create Medecin");
            System.out.println("2- Create Rv ");
            System.out.println("3- Lister Rv");
            System.out.println("4- Lister Rv par date");
            System.out.println("5- Quiter");
            choice = scanner.nextInt();

            
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    medecinServiceImpl.create(medecinView.saisie());
                    break;
                }
                case 2 -> {
                    rvServiceImpl.create(rvView.saisie());
                    
                    break;
                }
                case 3 -> {
                    rvView.affiche(rvServiceImpl.findAll());
                    
                    break;
                }
                case 4 -> {
                    rvView.afficheClientByPhone(rvServiceImpl);
                    break;
                }
            }
        } while (choice != 5);


    }
}