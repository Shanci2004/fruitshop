package dao;

import model.Fruit;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import utiils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class FruitDao {
    public List<Fruit> getFruitsList(int recommendType) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from fruit f, recommend r where r.type = ? and f.fruitId = r.fruitId";
        return runner.query(sql, new BeanListHandler<Fruit>(Fruit.class), recommendType);
    }
}
