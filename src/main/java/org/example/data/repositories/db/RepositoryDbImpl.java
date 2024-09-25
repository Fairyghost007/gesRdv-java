package org.example.data.repositories.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.data.core.config.DataSourceImpl;
import org.example.data.core.config.Repository;

public abstract class RepositoryDbImpl<T> extends DataSourceImpl implements Repository<T>{

    protected String tableName;

    public abstract T convertToObject(ResultSet rs) throws SQLException;
    
}
