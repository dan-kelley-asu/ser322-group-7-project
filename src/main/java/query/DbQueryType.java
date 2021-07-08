package query;

import java.sql.Array;
import java.sql.Types;
import java.util.ArrayList;

public enum DbQueryType {
    CANDIDATE_BY_PARTY("Candidate by party"),
    VOTER_TOTAL_COUNT("Voter total count"),
    VOTER_PER_STATE_COUNT("Voters per state"),
    PARTY_ELECTED_BY_STATE("Party elected by state"),
    STATES_WITH_DIFFERENT_ELECTED_PARTY("Swing states"),
    ROW_COUNT("Row counts"),
    VOTER("Voters"),
    VOTER_INSERT("Voter - Insert"),
    VOTER_UPDATE("Voter - Update"),
    VOTER_DELETE("Voter - Delete");

    public final String value;

    DbQueryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static ArrayList<DbQueryType> getList() {
        ArrayList<DbQueryType> list = new ArrayList<DbQueryType>();
        list.add(CANDIDATE_BY_PARTY);
        list.add(VOTER_TOTAL_COUNT);
        list.add(VOTER_PER_STATE_COUNT);
        list.add(PARTY_ELECTED_BY_STATE);
        list.add(STATES_WITH_DIFFERENT_ELECTED_PARTY);
        list.add(ROW_COUNT);
        list.add(VOTER);
        list.add(VOTER_INSERT);
        list.add(VOTER_UPDATE);
        list.add(VOTER_DELETE);

        return list;
    }
}
