package basic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ShowCalendar {
    public static void main(String[] args){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String input = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入日期，格式类似于：2010-01-29。输入q退出");
        Date date = null;
        while (true){
            input = scanner.nextLine();
            if (input.equals("q")){
                return;
            }
            try {
                date = dateFormat.parse(input);
                break;
            } catch (ParseException e) {
                System.out.println("您输入的日期格式有误，请重新输入日期，格式类似于：2010-01-29。输入q退出");
            }
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        int maxMonthDays = calendar.getActualMaximum(Calendar.DATE);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int weekDayFirst = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for (int i =0; i<weekDayFirst-1;i++){
            System.out.print('\t');
        }
        for (int i = 0; i<maxMonthDays; i++){

            int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
            int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
            if (nowDay == day){
                System.out.print(nowDay + "*\t");
            }else {
                System.out.print( nowDay+"\t");
            }
            if (weekDay == 7)
                System.out.println();
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
