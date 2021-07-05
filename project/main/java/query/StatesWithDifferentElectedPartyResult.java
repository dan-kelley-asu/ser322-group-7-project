package query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StatesWithDifferentElectedPartyResult {

    public final DbQueryType type = DbQueryType.STATES_WITH_DIFFERENT_ELECTED_PARTY;

    public ArrayList<String> State = new ArrayList<>();
    public ArrayList<String> CurrentParty = new ArrayList<>();
    public ArrayList<String> PastParty = new ArrayList<>();

    public StatesWithDifferentElectedPartyResult(ResultSet rs) throws SQLException {
        while (rs.next()) {
            State.add(rs.getString("State"));
            CurrentParty.add(rs.getString("CurrentParty"));
            PastParty.add(rs.getString("PastParty"));
        }
    }
}
