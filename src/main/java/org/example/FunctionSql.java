package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface FunctionSql<T> {
    T getData(ResultSet resultSet) throws SQLException;
}
