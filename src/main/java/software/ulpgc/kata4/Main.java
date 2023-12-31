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
            double[] prices = new double[977];
            int i = 0;
            for (Computer computer:computers) {
                prices[i++] = Double.valueOf(computer.price())*0.000108;
                System.out.println(computer);
            }
            Histogram histogram = new Histogram("Prices of computers", "Prices in euros", "Number of computers", prices, 5);
            MainFrame frame = new MainFrame();
            frame.histogramDisplay().show(histogram);
            frame.setVisible(true);

        }
    }
}
