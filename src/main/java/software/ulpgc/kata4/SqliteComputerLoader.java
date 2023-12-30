package software.ulpgc.kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SqliteComputerLoader implements ComputerLoader {

    private final Connection connection;

    private static final String SQLquery = "select Manufacturer, ModelName, ScreenSize, RAM, Storage, Price from laptops_train";

    public SqliteComputerLoader(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<Computer> loadAll() {
        try {
            return load(queryAll());
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    private List<Computer> load(ResultSet resultSet) throws SQLException {
        List<Computer> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(computerFrom(resultSet));
        }
        return result;
    }

    private static Computer computerFrom(ResultSet resultSet) throws SQLException {
        return new Computer(
                resultSet.getString("Manufacturer"),
                resultSet.getString("ModelName"),
                resultSet.getString("ScreenSize"),
                resultSet.getString("RAM"),
                resultSet.getString("Storage"),
                resultSet.getString("Price")
        );
    }

    private ResultSet queryAll() throws SQLException {
        return connection.createStatement().executeQuery(SQLquery);
    }
}
