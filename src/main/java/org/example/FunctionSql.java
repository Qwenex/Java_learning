package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface FunctionSql<R> {
    R getData(ResultSet resultSet) throws SQLException;
}
