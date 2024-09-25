package org.example.data.services.Impl;

import java.util.List;

import org.example.data.entities.Rv;
import org.example.data.repositories.db.RvRepositoryDbImpl;
import org.example.data.repositories.db.RvRepositoryDbImpl;

public class RvServiceImpl extends ServiceImpl<Rv>{
    private RvRepositoryDbImpl rvRepository;

    public RvServiceImpl(RvRepositoryDbImpl rvRepository) {
        this.rvRepository = rvRepository;
    }

    public void create(Rv user) {
        rvRepository.insert(user);
    }

    public List<Rv> findAll() {
        return rvRepository.selectAll();
    }

    public Rv search(String date) {
        return rvRepository.selectByDate(date);
    }
}