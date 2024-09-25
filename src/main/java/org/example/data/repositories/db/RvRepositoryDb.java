package org.example.data.repositories.db;

import org.example.data.entities.Rv;

public interface RvRepositoryDb {
    Rv selectByDate(String date);
    // User selectById(int id);

}
