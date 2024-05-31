package dao;

import model.Fruit;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

    public Fruit selectFruitByFruitId(int fruitId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from fruit where fruitId = ?";
        return runner.query(sql, new BeanHandler<Fruit>(Fruit.class), fruitId);
    }

    public List<Fruit> selectFruitListByClassifyId(int classifyId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from fruit where classifyId = ?";
        return runner.query(sql, new BeanListHandler<Fruit>(Fruit.class), classifyId);
    }
}
