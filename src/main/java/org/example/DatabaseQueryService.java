package org.example;

import org.example.ClassesForLists.LongestProject;
import org.example.ClassesForLists.MaxProjectCountClient;
import org.example.ClassesForLists.ProjectPrice;
import org.example.ClassesForLists.Worker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DatabaseQueryService {

    public static void main(String[] args) {
//        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
//        List<LongestProject> longestProject = new DatabaseQueryService().findLongestProject();
//        List<Worker> worker = new DatabaseQueryService().findYoungestAndEldestWorkers();
//        List<Worker> worker = new DatabaseQueryService().findMaxSalaryWorker();
//        List<ProjectPrice> projectPrice = new DatabaseQueryService().printProjectPrices();

    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String filePath = "sql/find_max_projects_client.sql";

        try {
            // Зчитуємо вміст файлу find_max_projects_client.sql
            String sql = new String(Files.readAllBytes(Paths.get(filePath)));

            // Встановлюємо з'єднання з базою даних
            Database database = Database.getInstance();
            Connection connection = database.getConnection();

            // Створюємо PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Виконуємо SQL-запит
            ResultSet resultSet = statement.executeQuery();

                // Створюємо список для збереження результатів
                List<MaxProjectCountClient> clients = new ArrayList<>();

                // Обробляємо результати запиту
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int projectCount = resultSet.getInt("project_count");

                    // Створюємо об'єкт MaxProjectCountClient і додаємо його до списку
                    MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                    clients.add(client);
                }

                // Виводимо результати в консоль
                for (MaxProjectCountClient client : clients) {
                    System.out.println("Name: " + client.getName());
                    System.out.println("Project Count: " + client.getProjectCount());
                    System.out.println();
                }

                return clients;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public List<LongestProject> findLongestProject() {
        try {
            // Зчитуємо SQL-запит з файлу
            String sql = readSqlFile("sql/find_longest_project.sql");

            Database database = Database.getInstance();
            Connection connection = database.getConnection();

            // Створюємо PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Виконуємо SQL-запит
            ResultSet resultSet = statement.executeQuery();

            // Створюємо список для збереження результатів
            List<LongestProject> projects = new ArrayList<>();

            // Обробляємо результати запиту
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int monthCount = resultSet.getInt("MONTH_COUNT");

                // Створюємо об'єкт LongestProject і додаємо його до списку
                LongestProject project = new LongestProject(id, monthCount);
                projects.add(project);
            }

            // Виводимо результати в консоль
            for (LongestProject project : projects) {
                System.out.println("ID: " + project.getId());
                System.out.println("Month Count: " + project.getMonthCount());
                System.out.println();
            }

            return projects;
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }



    public List<Worker> findYoungestAndEldestWorkers() {
        try {
            // Зчитуємо SQL-запит з файлу
            String sql = readSqlFile("sql/find_youngest_eldest_workers.sql");

            Database database = Database.getInstance();
            Connection connection = database.getConnection();

            // Створюємо PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Виконуємо SQL-запит
            ResultSet resultSet = statement.executeQuery();

            // Створюємо список для збереження результатів
            List<Worker> workers = new ArrayList<>();

            // Обробляємо результати запиту
            while (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                String birthday = resultSet.getString("BIRTHDAY");

                // Створюємо об'єкт Worker і додаємо його до списку
                Worker worker = new Worker(type, name, birthday);
                workers.add(worker);
            }

            // Виводимо результати в консоль
            for (Worker worker : workers) {
                System.out.println("Type: " + worker.getType());
                System.out.println("Name: " + worker.getName());
                System.out.println("Birthday: " + worker.getBirthday());
                System.out.println();
            }

            return workers;

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Worker> findMaxSalaryWorker() {
        try {
            // Зчитуємо SQL-запит з файлу
            String sql = readSqlFile("sql/find_max_salary_worker.sql");

            Database database = Database.getInstance();
            Connection connection = database.getConnection();

            // Створюємо PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Виконуємо SQL-запит
            ResultSet resultSet = statement.executeQuery();

            // Створюємо список для збереження результатів
            List<Worker> workers = new ArrayList<>();

            // Обробляємо результати запиту
            if (resultSet.next()) {
                String name = resultSet.getString("NAME");
                double salary = resultSet.getDouble("SALARY");

                // Створюємо об'єкт Worker і додаємо його до списку
                Worker worker = new Worker(name, salary);
                workers.add(worker);
            }

            // Виводимо результати в консоль
            for (Worker worker : workers) {
                System.out.println("Name: " + worker.getName());
                System.out.println("Salary: " + worker.getSalary());
                System.out.println();
            }

            return workers;

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }


    public List<ProjectPrice> printProjectPrices() {
        try {
            // Зчитуємо SQL-запит з файлу
            String sql = readSqlFile("sql/print_project_prices.sql");

            Database database = Database.getInstance();
            Connection connection = database.getConnection();

            // Створюємо PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Виконуємо SQL-запит
            ResultSet resultSet = statement.executeQuery();

            // Створюємо список для збереження результатів
            List<ProjectPrice> projectPrices = new ArrayList<>();

            // Обробляємо результати запиту
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double price = resultSet.getDouble("PRICE");

                // Створюємо об'єкт ProjectPrice і додаємо його до списку
                ProjectPrice projectPrice = new ProjectPrice(id, price);
                projectPrices.add(projectPrice);
            }

            // Виводимо результати в консоль
            for (ProjectPrice projectPrice : projectPrices) {
                System.out.println("ID: " + projectPrice.getId());
                System.out.println("Price: " + projectPrice.getPrice());
                System.out.println();
            }

            return projectPrices;

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    private String readSqlFile(String filePath) throws IOException {
        // Зчитуємо вміст SQL-файлу як рядок
        return Files.readString(Path.of(filePath));
    }
}