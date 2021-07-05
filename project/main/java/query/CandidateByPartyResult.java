package query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidateByPartyResult implements DbQueryResult {

    public final DbQueryType type = DbQueryType.CANDIDATE_BY_PARTY;

    public ArrayList<String> Candidate = new ArrayList<>();
    public ArrayList<String> Party = new ArrayList<>();

    public CandidateByPartyResult(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Candidate.add(rs.getString("Candidate"));
            Party.add(rs.getString("Party"));
        }
    }
}