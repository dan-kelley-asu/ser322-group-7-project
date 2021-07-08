package query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PartyElectedByStateQuery extends DbQuery {

    public PartyElectedByStateQuery(String url, String user, String password, String driver) {
        super(DbQueryType.PARTY_ELECTED_BY_STATE);
    }

    @Override
    public DbQueryResult executeQuery() throws SQLException {

        DbQueryResult result = null;

        this.connect();

        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT ec.Name as Candidate, p.Name as Party\n" +
                        "FROM election_candidate ec\n" +
                        "LEFT JOIN party p ON p.PartyID = ec.PartyID;"
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