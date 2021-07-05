package query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VoterPerStateCountResult {

    public final DbQueryType type = DbQueryType.VOTER_PER_STATE_COUNT;

    public ArrayList<String> State = new ArrayList<>();
    public ArrayList<Integer> VoterCount = new ArrayList<>();

    public VoterPerStateCountResult(ResultSet rs) throws SQLException {
        while (rs.next()) {
            State.add(rs.getString("State"));
            VoterCount.add(rs.getInt("VoterCount"));
        }
    }
}
