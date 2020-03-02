package com.muhammad.registration.model.dao.util;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ConnectionWrapper {
    private Connection connection;
    private LocalDateTime localDateTime;
    private PreparedStatement preparedStatement;


    public ConnectionWrapper(Connection connection) {
        this.connection = connection;
        this.localDateTime = LocalDateTime.now();
    }

    public boolean isAlive() {
        return this.localDateTime.plusHours(6).compareTo(LocalDateTime.now()) <= 0;
    }

    public ResultSet getData(String query) throws SQLException {
        return connection.prepareStatement(query).executeQuery();
    }

}
