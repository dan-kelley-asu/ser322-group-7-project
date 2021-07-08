package query;

public class DbExecuteResult implements DbQueryResult {
    public final boolean Success;

    public DbExecuteResult(boolean success) {
        Success = success;
    }
}
