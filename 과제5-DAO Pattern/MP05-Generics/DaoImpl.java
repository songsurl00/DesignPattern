import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DaoImpl<D extends DBData<K>, K> implements Dao<D, K> {
    String tableName;
    Connection connection = null;
    ResultSet rs = null;
    Statement statement = null;

    public abstract String getTableStatement();
    public abstract String getInsertValueString(D d);
    public abstract D getNewData(ResultSet rs);
    public abstract String getUpdateString(D d);
    public abstract String getKeyColumnName();

    public DaoImpl(String filename, String tableName) {
        this.tableName = tableName;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
//            final String table = " (url text PRIMARY KEY, userId text, password text)";

            // create table
            statement.executeUpdate("DROP TABLE IF EXISTS " + tableName);
            statement.executeUpdate("CREATE TABLE " + tableName + getTableStatement());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(D p) {
        try {
            String fmt = "INSERT INTO %s VALUES(%s)"; // VALUES('%s', '%s', '%s')
            String q = String.format(fmt, tableName, getInsertValueString(p));
            System.out.println(q);

            
            statement.execute(q);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<D> findAll() {
        ArrayList<D> list = new ArrayList<D>();
        try {
            rs = statement.executeQuery("SELECT * FROM " + tableName);
            while (rs.next()) {
                D d = getNewData(rs);
                if (d != null)
                    list.add(d);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public D findByKey(K key) {
        D d = null;
        try {
            String fmt = "SELECT * FROM %s WHERE %s = '%s'";
            String q = String.format(fmt, tableName, getKeyColumnName(), key.toString());
            rs = statement.executeQuery(q);
            if (rs.next()) {
                d = getNewData(rs);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }

    public void update(K key, D p) {
        //PasswordInfo p2 = findByKey(key);
        if (p != null) {
            try {
                String fmt = "UPDATE %s SET %s WHERE %s = '%s'"; // WHERE url = 'https://
                String q = String.format(fmt, tableName, getUpdateString(p), getKeyColumnName(), key.toString());
                System.out.println(q);
                statement.execute(q);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteByKey(K key) {
        try {
            String fmt = "DELETE FROM %s WHERE %s = '%s'";
            String q = String.format(fmt, tableName, getKeyColumnName(), key.toString());
            
            statement.execute(q);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByData(D p) {
        deleteByKey(p.getKey());
    }
}
