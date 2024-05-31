package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import utiils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class FruitDao {
    public List<Map<String, Object>> getFruitsList(int recommendType) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select f.fruitId, f.fruitName, f.price, f.cover, c.classifyName from fruit f, recommend r, classify c where r.type = ? and f.classifyId = c.classifyId and f.fruitId = r.fruitId";
        return runner.query(sql, new MapListHandler(), recommendType);
    }
}
