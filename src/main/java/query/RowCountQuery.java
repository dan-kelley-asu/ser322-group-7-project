package query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RowCountQuery extends DbQuery {

    public RowCountQuery() {
        super(DbQueryType.ROW_COUNT);
    }

    @Override
    public DbQueryResult executeQuery() throws SQLException {

        DbQueryResult result = null;

        this.connect();

        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT TABLE_NAME, TABLE_ROWS\n" +
                        "FROM information_schema.TABLES\n" +
                        "WHERE TABLE_SCHEMA = 'project';"
        );

        try {
            ResultSet rs = stmt.executeQuery();

            result = new RowCountResult(rs);

        } catch (SQLException e) {
            System.out.println("Error executing SQL statement:");
            System.out.print(e.getMessage());
        } finally {
            this.close();
        }

        return result;
    }
}