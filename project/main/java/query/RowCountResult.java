package query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RowCountResult {

    public final DbQueryType type = DbQueryType.ROW_COUNT;

    public ArrayList<String> TableName = new ArrayList<>();
    public ArrayList<Integer> TableRows = new ArrayList<>();

    public RowCountResult(ResultSet rs) throws SQLException {
        while (rs.next()) {
            TableName.add(rs.getString("TABLE_NAME"));
            TableRows.add(rs.getInt("TABLE_ROWS"));
        }
    }
}
