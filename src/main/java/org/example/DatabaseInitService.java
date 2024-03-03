package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {
    public static void main(String[] args) {
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "sql/init_db.sql";
            String sqlContent = Files.readString(Paths.get(sqlFilePath));
            String[] queries = sqlContent.split(";");

            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    try (PreparedStatement statement = connection.prepareStatement(query)) {
                        statement.execute();
                    }
                }
            }

            System.out.println("Database initialized successfully.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
