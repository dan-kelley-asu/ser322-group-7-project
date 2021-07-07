package query;

import jdk.jshell.spi.ExecutionControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public abstract class DbQuery {

    public final DbQueryType type;
    public final String url;
    public final String user;
    public final String password;
    public final String driver;

    protected Connection conn;
    protected Statement statement;

    public DbQuery(DbQueryType type, String url, String user, String password, String driver) {
        this.type = type;
        this.url = url;
        this.user = user;
        this.password = password;
        this.driver = driver;
    }

    /**
     * Loads the driver using the specificed driver string (i.e., jdbc)
     * @param driverString This should be 'JDBC'
     */
    private void loadDriver(String driverString) {
        try {
            Class.forName(driverString).newInstance();
        } catch (Exception ex) {
            System.out.printf("Error: could not load driver %s\n", driverString);
        }

    }

    /**
     * Connects to the database specified
     * @throws SQLException Error connecting to database
     */
    protected void connect() throws SQLException {
<<<<<<< Updated upstream:project/main/java/query/DbQuery.java
        this.loadDriver(driver);

        Properties credentials = new Properties();
        credentials.setProperty("user", user);
        credentials.setProperty("password", password);

        this.conn = DriverManager.getConnection(this.url, credentials);
=======
        this.loadDriver(Config.config.driver);

        Properties credentials = new Properties();
        credentials.setProperty("user", Config.config.user);
        credentials.setProperty("password", Config.config.password);

        this.conn = DriverManager.getConnection(Config.config.url, credentials);
>>>>>>> Stashed changes:src/main/java/query/DbQuery.java
    }

    /**
     * Closes the connection to the database
     * @throws SQLException Error closing connection to database
     */
    protected void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            this.conn.close();
        }
    }

    /**
     * Connects to database and attempts to execute the query, returning a result set
     * @return
     * @throws SQLException
     */
    public abstract DbQueryResult executeQuery() throws SQLException, ExecutionControl.NotImplementedException;
}
