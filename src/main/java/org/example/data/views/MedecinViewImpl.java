package org.example.data.views;

import java.util.List;
import java.util.Scanner;

import org.example.data.services.Impl.MedecinServiceImpl;
import org.example.data.services.Impl.RvServiceImpl;
import org.example.data.core.config.Service;
import org.example.data.core.config.ViewImpl;
import org.example.data.entities.Medecin;
import org.example.data.entities.Rv;
import org.example.data.repositories.db.RvRepositoryDbImpl;

public class MedecinViewImpl extends ViewImpl<Medecin>{

    private Service<Medecin> medecinServiceImpl;
    private Service<Rv> rvServiceImpl;
    public  MedecinViewImpl(Service<Medecin> medecinServiceImpl, Service<Rv> rvServiceImpl) {
        this.medecinServiceImpl = medecinServiceImpl;
        this.rvServiceImpl = rvServiceImpl;
    }

    @Override
    public Medecin saisie() {
        Medecin medecin = new Medecin();
        System.out.println("Enter le nom: ");
        medecin.setNom(scanner.nextLine());
        System.out.println("Enter le prenom: ");
        medecin.setPrenom(scanner.nextLine());
        return medecin;
    }

    // public void afficheClientByPhone(ClientServiceImpl clientService) {
    //     System.out.println("Enter telephone: ");
    //     String phone = scanner.nextLine();
    //     Client client = clientService.search(phone);
    //     if (client != null) {
    //         affiche(client);
    //     } else {
    //         System.out.println("No client found with phone:"+phone);
    //     }
    // }


  
}
