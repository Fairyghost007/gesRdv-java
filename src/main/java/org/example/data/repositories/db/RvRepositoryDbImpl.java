package org.example.data.repositories.db;

import org.example.data.entities.Medecin;
import org.example.data.entities.Rv;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RvRepositoryDbImpl extends RepositoryDbImpl<Rv> implements RvRepositoryDb {
    private MedecinRepositoryDbImpl medecinRepositoryDb;
    public RvRepositoryDbImpl() {
        tableName = "rv";
        this.medecinRepositoryDb =medecinRepositoryDb;
    }

    @Override
    public void insert(Rv rv) {
        Medecin medecin = rv.getMedecin();
        try{
            if (medecin != null) {
                // Ensure user is created and ID is set
                medecinRepositoryDb.insert(medecin);
                // Here, you should retrieve the generated ID from the userRepositoryDb if necessary
            }
            String sql =String.format("INSERT INTO %s (date, heure,\"medecinId\") VALUES (?, ?,?)", this.tableName);
            this.init(sql);
            this.ps.setString(1, rv.getDate());
            this.ps.setString(2, rv.getHeure());
            if (medecin != null && medecin.getId() > 0) {
                this.ps.setInt(4, medecin.getId());
            } else {
                this.ps.setNull(4, Types.INTEGER);
            }
            this.executeUpdate();
            ResultSet rs = this.ps.getGeneratedKeys();
            if(rs.next()){
                rv.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // }
    @Override
    public List<Rv> selectAll() {
        List<Rv> rvs = new ArrayList<>();
        try{
            String sql =String.format("SELECT * FROM %s",this.tableName);
            this.init(sql);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                rvs.add( this.convertToObject(rs));
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
        return rvs;
    }



    @Override
    public int insert(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }
    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Rv convertToObject(ResultSet rs)  throws SQLException {
        Rv rv = new Rv();
        rv.setId(rs.getInt("id"));
        rv.setDate(rs.getString("email"));
        rv.setHeure(rs.getString("login"));
        int medecinId = rs.getInt("medecinId");
        Medecin medecin =this.medecinRepositoryDb.selectById(medecinId);
        rv.setMedecin(medecin);
        return rv;
    }
    @Override
    public boolean update(Rv objet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Rv selectById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public Rv selectByDate(String date) {
        Rv rv = null;
        try{
            String sql=String.format("SELECT * FROM %s WHERE date = ?",this.tableName);
            this.init(sql);
            this.ps.setString(1, date);
            ResultSet rs = this.executeQuery();
            if (rs.next()) {
                rv = this.convertToObject(rs);
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
        return rv;
    }



    
}
