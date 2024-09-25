package org.example.data.services.Impl;

import org.example.data.core.config.Repository;
import org.example.data.entities.Medecin;
import org.example.data.repositories.db.MedecinRepositoryDb;
import org.example.data.repositories.db.MedecinRepositoryDbImpl;

import java.util.List;

public class MedecinServiceImpl extends ServiceImpl<Medecin> {
    private MedecinRepositoryDbImpl medecinRepository;

    public MedecinServiceImpl(MedecinRepositoryDbImpl medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    public void create(Medecin client) {
        medecinRepository.insert(client);
    }

    public List<Medecin> findAll() {
        return medecinRepository.selectAll();
    }

    // public Medecin search(String phone) {
    //     return medecinRepository.selectByPhone(phone);
    // }
}
