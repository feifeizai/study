import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-10-10 23:08
 */
public class LocalTimeTest {


    @Test
    public void localTimeTest() {

        LocalTime now = LocalTime.now();

        System.out.println("当前小时:" + now.getHour());
        System.out.println("当前分钟:" + now.getMinute());
        System.out.println("当前秒:" + now.getSecond());


        System.out.println("加小时:" + now.plusHours(1));
        System.out.println("加分钟:" + now.plusMinutes(10));
        System.out.println("加秒:" + now.plusSeconds(30));


        System.out.println("改变小时:" + now.withHour(15));


        System.out.println("今天第多少秒:" + now.toSecondOfDay());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("格式化时间:" + now.format(dtf));

    }

}
