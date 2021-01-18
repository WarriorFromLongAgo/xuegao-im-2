package com.xuegao.im.util;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <br/> @PackageName：com.sf.edu.util
 * <br/> @ClassName：CalcUtil
 * <br/> @Description：各种 东西的转换
 * <br/> @author：80004960
 * <br/> @date：2020/12/16 10:08
 */
public class ConvertUtils {

    private ConvertUtils() {
    }

    public static final String FLOOR = "floor";
    public static final String ROUND = "round";
    public static final String LOCAL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    enum secondsToMinutes {
        // 向上 取整
        FLOOR,
        // 向下取整
        ROUND;
    }

    /**
     * <br/> @Title:
     * <br/> @Description: 秒转换成分钟
     * <br/> @MethodName: secondsToMinutes
     * <br/> @param seconds:
     * <br/> @param round: 向上取整，还是向下取整
     * <br/> @return: java.lang.String
     * <br/> @author: 80004960
     * <br/> @date: 2020/12/16 11:43
     */
    public static String secondsToMinutes(String seconds, String round) {
        String minutes = "";
        if (StringUtils.isBlank(seconds)) {
            return "0";
        }
        double secondsInt = Double.parseDouble(seconds);
        int merchant = (int) (secondsInt / 60);
        int remainder = (int) (secondsInt % 60);

        // 如果是向上取整
        if (ConvertUtils.FLOOR.equals(round)) {
            minutes = String.valueOf(remainder > 0 ? ++merchant : merchant);
        }
        // 如果是向下取整
        if (ConvertUtils.ROUND.equals(round)) {
            minutes = String.valueOf(merchant);
        }

        return minutes;
    }

    /**
     * <br/> @Title: date 转成 string 格式化
     * <br/> @Description:
     * <br/> @MethodName: getLocalDateTimeStr
     * <br/> @param date:
     * <br/> @return: java.lang.String
     * <br/> @author: 80004960
     * <br/> @date: 2020/12/16 16:22
     */
    public static String getLocalDateTimeStr(Date date) {
        // yyyy-MM-dd HH:mm:ss
        return getLocalDateTimeStr(date, LOCAL_DATE_TIME);
    }

    public static String getLocalDateTimeStr(Date date, String formatter) {
        if (ObjectUtils.isEmpty(date)) {
            return "";
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * fullCode 1>2>3
     * get last level code
     * return 3
     */
    public static String getLastLevelCode(String fullCode) {
        String code = "";
        if (fullCode != null && !"".equals(fullCode)) {
            int index = fullCode.lastIndexOf(">");
            if (index > -1) {
                code = fullCode.substring(index + 1);
            } else {
                code = fullCode;
            }
        }
        return code;
    }

    /**
     * 将传入的字段名按照javaBean推荐的驼峰格式转换为对应的属性名，
     * 如column “person_wife_name”将转换为：personWifeName，
     *
     * @param column
     * @return
     */
    public static String toHumpFormat(String column) {
        if (column == null) {
            return null;
        }
        String[] splits = column.toUpperCase().split("_");
        StringBuilder sb = new StringBuilder();
        if (splits.length > 0) {
            sb.append(splits[0].toLowerCase());
            for (int i = 1; i < splits.length; i++) {
                if (splits[i].length() >= 2) {
                    sb.append(splits[i].charAt(0)).append(splits[i].substring(1).toLowerCase());
                } else {
                    sb.append(splits[i].toLowerCase());
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = secondsToMinutes("30", ConvertUtils.FLOOR);
        System.out.println(s);
        String s1 = secondsToMinutes("90", ConvertUtils.FLOOR);
        System.out.println(s1);
        String s2 = secondsToMinutes("90.01", ConvertUtils.ROUND);
        System.out.println(s2);

        // Math.floor() 向上取整；
        // Math.round() 向下取整；
    }
}
