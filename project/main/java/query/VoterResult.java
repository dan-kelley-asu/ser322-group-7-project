package query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VoterResult implements DbQueryResult {

    public final DbQueryType type = DbQueryType.VOTER;

    public ArrayList<Integer> VoterID = new ArrayList<>();
    public ArrayList<String> Name = new ArrayList<>();
    public ArrayList<String> SSN = new ArrayList<>();
    public ArrayList<Integer> Age = new ArrayList<>();
    public ArrayList<String> Gender = new ArrayList<>();
    public ArrayList<String> Ethnicity = new ArrayList<>();
    public ArrayList<Boolean> FelonStatus = new ArrayList<>();
    public ArrayList<Integer> PartyID = new ArrayList<>();

    public VoterResult(ResultSet rs) throws SQLException {
        while (rs.next()) {
            VoterID.add(rs.getInt("VoterID"));
            Name.add(rs.getString("Name"));
            SSN.add(rs.getString("SSN"));
            Age.add(rs.getInt("Age"));
            Gender.add(rs.getString("Gender"));
            Ethnicity.add(rs.getString("Ethnicity"));
            FelonStatus.add(rs.getBoolean("FelonStatus"));
            PartyID.add(rs.getInt("PartyID"));
        }
    }
}