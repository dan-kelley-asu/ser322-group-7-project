package query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateByPartyQuery extends DbQuery {

    public CandidateByPartyQuery(String url, String user, String password, String driver) {
        super(DbQueryType.CANDIDATE_BY_PARTY, url, user, password, driver);
    }

    @Override
    public DbQueryResult executeQuery() throws SQLException {

        DbQueryResult result = null;

        this.connect();

        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT ec.Name as Candidate, p.Name as Party "+
                    "FROM election_candidate ec "+
                    "LEFT JOIN party p ON p.PartyID = ec.PartyID;"
        );

        try {
            ResultSet rs = stmt.executeQuery();

            result = new CandidateByPartyResult(rs);

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


