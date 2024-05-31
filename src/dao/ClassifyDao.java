package dao;

import model.Classify;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utiils.DataSourceUtils;

import java.sql.SQLException;

public class ClassifyDao {
    public static Classify getClassify(int classifyId) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from classify where classifyId = ?";
        return runner.query(sql, new BeanHandler<Classify>(Classify.class), classifyId);
    }
}
