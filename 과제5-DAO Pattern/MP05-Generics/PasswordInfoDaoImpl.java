import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordInfoDaoImpl extends DaoImpl<PasswordInfo, String> {
    public PasswordInfoDaoImpl(String filename, String tableName) {
        super(filename, tableName);
    }

    @Override
    public String getTableStatement() {
        return " (url text PRIMARY KEY, userId text, password text)";
    }

    @Override
    public String getInsertValueString(PasswordInfo d) {
        String fmt = "'%s', '%s', '%s'";
        String q = String.format(fmt, d.getUrl(), d.getUserId(), d.getPassword());

        return q;
    }

    @Override
    public PasswordInfo getNewData(ResultSet rs) {
        PasswordInfo p = null;
        try {
            p = new PasswordInfo(rs.getString("url"), rs.getString("userId"),
                    rs.getString("password"));
            return p;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public String getUpdateString(PasswordInfo d) {
        String fmt = "userId = '%s', password = '%s'";
        String q = String.format(fmt, d.getUserId(), d.getPassword());
        return q;
    }

    public String getKeyColumnName() { return "url"; }
}
