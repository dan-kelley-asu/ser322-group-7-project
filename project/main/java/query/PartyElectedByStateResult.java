package query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PartyElectedByStateResult {

    public final DbQueryType type = DbQueryType.PARTY_ELECTED_BY_STATE;

    public ArrayList<String> State = new ArrayList<>();
    public ArrayList<String> Party = new ArrayList<>();

    public PartyElectedByStateResult(ResultSet rs) throws SQLException {
        while (rs.next()) {
            State.add(rs.getString("State"));
            Party.add(rs.getString("Party"));
        }
    }
}
