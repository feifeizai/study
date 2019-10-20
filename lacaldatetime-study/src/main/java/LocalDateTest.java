import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-10-9 22:18
 */
public class LocalDateTest {

    @Test
    public void localDateTest(){

        LocalDate localDate = LocalDate.ofYearDay(2016, 300);
        System.out.println("某年的第几天:"+localDate);
        LocalDate localDate1 = LocalDate.ofEpochDay(360);
        System.out.println("根据某年的第n天获取 LocalDate1:"+localDate1);

        System.out.println("==============================");

        LocalDate now = LocalDate.now();
        System.out.println("现在:"+now);
        System.out.println("年:"+now.getYear());
        System.out.println("月:"+now.getMonthValue());
        System.out.println("月:"+now.getMonth());
        System.out.println("当天所在这一年的第几天（从1开始）:"+now.getDayOfYear());
        System.out.println("这个月的第几天（从1开始）:"+now.getDayOfMonth());
        System.out.println("周几:"+now.getDayOfWeek());
        System.out.println("当年的天数:"+now.lengthOfYear());
        System.out.println("当月的天数:"+now.lengthOfMonth());
        System.out.println("与时间纪元（1970年1月1日）相差的天数:"+now.toEpochDay());
        System.out.println("是否闰年:"+now.isLeapYear());
        System.out.println("今天的开始时间:"+now.atStartOfDay());

        System.out.println("==============加法================");

        System.out.println("加法运算");
        System.out.println("当前：" + LocalDate.now());
        System.out.println("加1天：" + LocalDate.now().plusDays(1));
        System.out.println("加1周：" + LocalDate.now().plusWeeks(1));
        System.out.println("加1月：" + LocalDate.now().plusMonths(1));
        System.out.println("加1年：" + LocalDate.now().plusYears(1));

        System.out.println("==============减法================");

        System.out.println("当前：" + LocalDate.now());
        System.out.println("减1天：" + LocalDate.now().minusDays(1));
        System.out.println("减1周：" + LocalDate.now().minusWeeks(1));
        System.out.println("减1月：" + LocalDate.now().minusMonths(1));
        System.out.println("减1年：" + LocalDate.now().minusYears(1));

        System.out.println("==============替换================");

        System.out.println("当前：" + LocalDate.now());
        System.out.println("替换日期为1：" + LocalDate.now().withDayOfMonth(1));
        System.out.println("替换天数为1：" + LocalDate.now().withDayOfYear(1));
        System.out.println("替换月份为1：" + LocalDate.now().withMonth(1));
        System.out.println("替换年份为1：" + LocalDate.now().withYear(1));
        System.out.println("时间错 秒：" + LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
        System.out.println("时间错 毫秒：" + LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());

        System.out.println("==============格式化时间================");

        String dateTimeStr = "2018-07-28 14:11:15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, df);
        System.out.println("转化后时间:"+dateTime);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formatRs = LocalDateTime.now().format(dtf);
        System.out.println("格式化时间:"+formatRs);

    }

}
