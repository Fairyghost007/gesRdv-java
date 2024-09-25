package org.example.data.repositories.db;

import org.example.data.entities.Medecin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedecinRepositoryDbImpl extends RepositoryDbImpl<Medecin> implements MedecinRepositoryDb {
    // UserRepositoryDbImpl userRepositoryDb =new UserRepositoryDbImpl();

    public MedecinRepositoryDbImpl() {
        this.tableName = "medecin";
        // this.userRepositoryDb =userRepositoryDb;
    }
    @Override
    public void insert(Medecin medecin) {
        try {
            String sql = String.format("INSERT INTO %s (nom, prenom) VALUES (?, ?)", this.tableName);
            this.init(sql);
            this.ps.setString(1, medecin.getNom());
            this.ps.setString(2, medecin.getPrenom());

            this.executeUpdate();
            ResultSet rs = this.ps.getGeneratedKeys();
            if (rs.next()) {
                medecin.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // @Override
    // public Client selectByPhone(String phone) {
    //     Client client = null;
    //     try{
    //         String sql=String.format("SELECT * FROM %s WHERE phone = ?", this.tableName);
    //         this.init(sql);
    //         this.ps.setString(1, sql);
    //         ResultSet rs = this.executeQuery();
    //         if (rs.next()) {
    //             client = this.convertToObject(rs);
    //         }
    //         rs.close();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }finally{
    //         try {
    //             this.close();
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     return client;
    // }
    @Override
    public List<Medecin> selectAll() {
        List<Medecin> medecins = new ArrayList<>();
        try{
            String sql =String.format("SELECT * FROM %s", this.tableName);
            this.init(sql);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                medecins.add( this.convertToObject(rs));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return medecins;
    }



    @Override
    public boolean update(Medecin objet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public Medecin selectById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }
    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Medecin convertToObject(ResultSet rs)  throws SQLException {
        Medecin client = new Medecin();
        client.setId(rs.getInt("id"));
        client.setNom(rs.getString("nom"));
        client.setPrenom(rs.getString("prenom"));
        return client;
    }
    @Override
    public int insert(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }
}
