package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {

    public static void main(String[] args) {
        DatabasePopulateService dps = new DatabasePopulateService();

//        try {
//            dps.populateClients();
//            System.out.println("Clients populated successfully.");
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            dps.populateWorkers();
//            System.out.println("Workers populated successfully.");
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            dps.populateProjects();
//            System.out.println("Projects populated successfully.");
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }

    }

    public void populateClients() throws SQLException, IOException {
        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlFilePath = "sql/populate_client.sql";
            String sqlContent = Files.readString(Paths.get(sqlFilePath));
            String[] lines = sqlContent.split("\\r?\\n");

            String insertWorkerQuery = "INSERT INTO client (ID, NAME) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertWorkerQuery)) {
                for (String line : lines) {
                    if (!line.trim().isEmpty()) {
                        String[] values = line.substring(1, line.length() - 1).split(", ");
                        preparedStatement.setInt(1, Integer.parseInt(values[0].trim())); // ID
                        preparedStatement.setString(2, values[1].trim()); // NAME
                        preparedStatement.addBatch();
                    }
                }
                preparedStatement.executeBatch();
            }
        }
    }


        public void populateWorkers() throws SQLException, IOException{
            try (Connection connection = Database.getInstance().getConnection()) {
                String sqlFilePath = "sql/populate_worker.sql";
                String sqlContent = Files.readString(Paths.get(sqlFilePath));
                String[] lines = sqlContent.split("\\r?\\n");

                String insertWorkerQuery = "INSERT INTO worker (ID, NAME, BIRTHDAY, SALARY, LEVELS) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertWorkerQuery)) {
                    for (String line : lines) {
                        if (!line.trim().isEmpty()) {
                            String[] values = line.substring(1, line.length() - 1).split(", ");
                            preparedStatement.setInt(1, Integer.parseInt(values[0].trim())); // ID
                            preparedStatement.setString(2, values[1].trim()); // NAME
                            preparedStatement.setString(3, values[2].trim().replace("'", "")); // BIRTHDAY
                            preparedStatement.setString(5, values[4].trim()); // LEVELS
                            preparedStatement.setInt(4, Integer.parseInt(values[3].trim())); // SALARY
                            preparedStatement.addBatch();
                        }
                    }
                    preparedStatement.executeBatch();
                }


            }
        }

    public void populateProjects() throws SQLException, IOException{
        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlFilePath = "sql/populate_project.sql";
            String sqlContent = Files.readString(Paths.get(sqlFilePath));
            String[] lines = sqlContent.split("\\r?\\n");

            String insertWorkerQuery = "INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertWorkerQuery)) {
                for (String line : lines) {
                    if (!line.trim().isEmpty()) {
                        String[] values = line.substring(1, line.length() - 1).split(", ");
                        preparedStatement.setInt(1, Integer.parseInt(values[0].trim())); // ID
                        preparedStatement.setInt(2, Integer.parseInt(values[1].trim())); // NAME
                        preparedStatement.setString(3, values[2].trim().replace("'", "")); // DATE
                        preparedStatement.setString(4, values[3].trim().replace("'", "")); // DATE
                        preparedStatement.addBatch();
                    }
                }
                preparedStatement.executeBatch();
            }


        }
    }
}
