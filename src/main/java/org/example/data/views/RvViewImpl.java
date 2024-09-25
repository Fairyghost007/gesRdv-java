package org.example.data.views;

import java.util.List;
import java.util.Scanner;
import org.example.data.core.config.Service;
import org.example.data.core.config.ViewImpl;
import org.example.data.entities.Medecin;
import org.example.data.entities.Rv;
import org.example.data.services.Impl.MedecinServiceImpl;
import org.example.data.services.Impl.RvServiceImpl;

import com.mysql.cj.xdevapi.Client;

public class RvViewImpl extends ViewImpl<Rv>{

    private Service<Rv> RvViewImpl;
    private MedecinServiceImpl medecinServiceImpl;
    public  RvViewImpl(Service<Rv> rvServiceImpl) {
        this.RvViewImpl = RvViewImpl;
        this.medecinServiceImpl = medecinServiceImpl;
    }

    @Override
    public Rv saisie() {
        Rv rv = new Rv();
        System.out.println("Enter la date: ");
        rv.setDate(scanner.nextLine());
        System.out.println("Enter l'heure: ");
        rv.setHeure(scanner.nextLine());
        List<Medecin> medecinList = medecinServiceImpl.findAll();
        System.out.println("List of existing Medecin accounts:");
        for (int i = 0; i < medecinList.size(); i++) {
            Medecin medecin = medecinList.get(i);
            System.out.println((i + 1) + ". Nom: " + medecin.getNom() + ", Prenom: " + medecin.getPrenom());
        }
        
        int choice2;
        do {
            System.out.println("Enter the number of the Medecin you want to assign: ");
            choice2 = scanner.nextInt();
            scanner.nextLine(); 
            
            if (choice2 < 1 || choice2 > medecinList.size()) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice2 < 1 || choice2 > medecinList.size());

        Medecin selectedMedecin = medecinList.get(choice2 - 1);
        
        rv.setMedecin(selectedMedecin);
        return rv;
    }


   public void afficheClientByPhone(RvServiceImpl rvService) {
        System.out.println("Enter la date: ");
        String date = scanner.nextLine();
        Rv rv = rvService.search(date);
        if (rv != null) {
            affiche(rv);
        } else {
            System.out.println("No client found with phone:"+date);
        }
    }

    
    
}
