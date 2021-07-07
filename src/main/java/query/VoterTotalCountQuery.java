package query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoterTotalCountQuery extends DbQuery {

    public VoterTotalCountQuery(String url, String user, String password, String driver) {
        super(DbQueryType.VOTER_TOTAL_COUNT);
    }

    @Override
    public DbQueryResult executeQuery() throws SQLException {

        DbQueryResult result = null;

        this.connect();

        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT count(*) AS Count FROM query.Voter;"
        );

        try {
            ResultSet rs = stmt.executeQuery();

            result = new VoterTotalCountResult(rs);

        } catch (SQLException e) {
            System.out.println("Error executing SQL statement:");
            System.out.print(e.getMessage());
        } finally {
            this.close();
        }

        return result;
    }
}