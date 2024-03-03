package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "sql/populate_db.sql";
            String sqlContent = Files.readString(Paths.get(sqlFilePath));
            String[] queries = sqlContent.split(";");

            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    try (Statement statement = connection.createStatement()) {
                        statement.execute(query);
                    }
                }
            }

            System.out.println("Database populated successfully.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            // Можна обробити помилку підключення до БД або зчитування файлу тут
        }
    }
}
