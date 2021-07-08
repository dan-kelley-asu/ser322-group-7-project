package query;

import jdk.jshell.spi.ExecutionControl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoterDelete extends DbQuery {

    public VoterDelete() {
        super(DbQueryType.VOTER_DELETE);
    }

    public DbQueryResult executeQuery(int voterId) throws SQLException {

        DbQueryResult result = null;

        this.connect();

        PreparedStatement stmt = this.conn.prepareStatement(
                "DELETE FROM Voter WHERE VoterID = ?;"
        );

        stmt.setInt(1, voterId);

        try {
            ResultSet rs = stmt.executeQuery();

            result = new DbExecuteResult(true);

        } catch (SQLException e) {
            System.out.println("Error executing SQL statement:");
            System.out.print(e.getMessage());

            result = new DbExecuteResult(false);

        } finally {
            this.close();
        }

        return result;
    }

    @Override
    public DbQueryResult executeQuery() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("This method requires a parameter.");
    }
}