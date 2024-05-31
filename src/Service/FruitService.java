package Service;

import dao.FruitDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class FruitService {
    private FruitDao fruitDao = new FruitDao();
    public List<Map<String, Object>> getHotFruit(int recommendType){
        try {
            return fruitDao.getFruitsList(recommendType);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, Object>> getNewFruit(int recommendType){
        try {
            return fruitDao.getFruitsList(recommendType);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
