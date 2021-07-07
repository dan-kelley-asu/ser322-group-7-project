package query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoterQuery extends DbQuery {

    public VoterQuery(String url, String user, String password, String driver) {
        super(DbQueryType.VOTER);
    }

    @Override
    public DbQueryResult executeQuery() throws SQLException {

        DbQueryResult result = null;

        this.connect();

        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT * FROM query.Voter;"
        );

        try {
            ResultSet rs = stmt.executeQuery();

            result = new VoterResult(rs);

        } catch (SQLException e) {
            System.out.println("Error executing SQL statement:");
            System.out.print(e.getMessage());
        }
        finally {
            this.close();
        }

        return result;
    }
}