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
            Fruit fruit = fruitDao.selectFruitByFruitId(fruitId);
            fruit.setClassify();
            fruit.setImages();
            return fruit;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Fruit> getFruitListByClassifyId(int classifyId){
        try {
            return fruitDao.selectFruitListByClassifyId(classifyId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Fruit> getAllFruitList(){
        try {
            return fruitDao.selectAllFruitList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Fruit> searchFruit(String keyword){
        try {
            return fruitDao.selectFruitByKeyword(keyword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean lessenFruit(int fruitId, int quantity){
        try {
            return fruitDao.lessenFruit(fruitId, quantity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean fruitEnough(int fruitId, int quantity){
        try {
            return fruitDao.enoughFruit(fruitId, quantity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
