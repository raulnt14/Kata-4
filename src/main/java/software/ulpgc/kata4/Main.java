package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:laptops.db")) {
            ComputerLoader computerLoader = new SqliteComputerLoader(connection);
            List<Computer> computers = computerLoader.loadAll();

            for (Computer computer:computers) {
                System.out.println(computer);
            }
        }
    }
}
