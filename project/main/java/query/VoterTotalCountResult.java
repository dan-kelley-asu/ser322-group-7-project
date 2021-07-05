package query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoterTotalCountResult {

    public final DbQueryType type = DbQueryType.VOTER_TOTAL_COUNT;

    public int count;

    public VoterTotalCountResult(ResultSet rs) throws SQLException {
        while (rs.next()) {
            count = rs.getInt("Count");
        }
    }
}
