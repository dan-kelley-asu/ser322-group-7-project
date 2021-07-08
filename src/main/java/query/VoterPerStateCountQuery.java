package query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoterPerStateCountQuery extends DbQuery {

    public VoterPerStateCountQuery() {
        super(DbQueryType.VOTER_PER_STATE_COUNT);
    }

    @Override
    public DbQueryResult executeQuery() throws SQLException {

        DbQueryResult result = null;

        this.connect();

        PreparedStatement stmt = this.conn.prepareStatement(
                "SELECT\n" +
                        "    s.Name as State,\n" +
                        "    (SELECT count(*)\n" +
                        "    FROM voter v\n" +
                        "    WHERE EXISTS (\n" +
                        "        SELECT *\n" +
                        "        FROM voter_address va\n" +
                        "        WHERE va.StateID = s.StateID\n" +
                        "        AND va.VoterID = v.VoterID)\n" +
                        "    ) as VoterCount\n" +
                        "FROM state s;"
        );

        try {
            ResultSet rs = stmt.executeQuery();

            result = new VoterPerStateCountResult(rs);

        } catch (SQLException e) {
            System.out.println("Error executing SQL statement:");
            System.out.print(e.getMessage());
        } finally {
            this.close();
        }

        return result;
    }
}