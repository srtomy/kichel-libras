package io.github.srtomy.repository;

import io.github.srtomy.connection.Database;

import java.sql.Connection;

public interface Repository {
    Connection conn = Database.getInstance().getConnection();
}
