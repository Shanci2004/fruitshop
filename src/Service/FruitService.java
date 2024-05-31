package Service;

import dao.FruitDao;
import model.Fruit;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class FruitService {
    private FruitDao fruitDao = new FruitDao();
    public List<Fruit> getHotFruit(int recommendType){
        try {
            return fruitDao.getFruitsList(recommendType);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Fruit> getNewFruit(int recommendType){
        try {
            return fruitDao.getFruitsList(recommendType);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Fruit getFruitInfo(int fruitId){
        try {
            return fruitDao.selectFruitByFruitId(fruitId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
