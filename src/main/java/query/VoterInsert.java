package query;

import jdk.jshell.spi.ExecutionControl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoterInsert extends DbQuery {

    public VoterInsert() {
        super(DbQueryType.VOTER_INSERT);
    }

    public DbQueryResult executeQuery(Voter voter) throws SQLException {

        DbQueryResult result = null;

        this.connect();

        PreparedStatement stmt = this.conn.prepareStatement(
                "INSERT INTO voter (SSN, Name, Age, Gender, Ethnicity, FelonStatus, PartyID) VALUES\n" +
                        "(?, ?, ?, ?, ?, ?, ?);"
        );

        stmt.setString(1, voter.SSN);
        stmt.setString(2, voter.Name);
        stmt.setInt(3, voter.Age);
        stmt.setString(4, voter.Gender);
        stmt.setString(5, voter.Ethnicity);
        stmt.setBoolean(6, voter.FelonStatus);
        stmt.setInt(7, voter.PartyID);

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