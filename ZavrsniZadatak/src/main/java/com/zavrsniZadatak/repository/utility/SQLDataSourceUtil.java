package com.zavrsniZadatak.repository.utility;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class SQLDataSourceUtil {
    public static SQLServerDataSource getSQLServerDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("localhost");
        ds.setPortNumber(1433);
        ds.setDatabaseName("JavaAdv");
        ds.setUser("java");
        ds.setPassword("sql");
        ds.setEncrypt("true");
        ds.setTrustServerCertificate(true);

        return ds;
    }
}

