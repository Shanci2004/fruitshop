package utiils;

import model.User;
import org.apache.commons.lang.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderIdUtils {
    public static String createOrderId(Date date, User user){
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
        return "114514" + ft.format(date) + user.getUserId() + RandomStringUtils.randomNumeric(6);
    }
}
