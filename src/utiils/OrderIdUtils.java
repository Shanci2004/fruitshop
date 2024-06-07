package utiils;

import model.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderIdUtils {
    public static String createOrderId(Date date, User user, int fruitId){
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
        return "114514" + ft.format(date) + user.getUserId() + fruitId;
    }
}
