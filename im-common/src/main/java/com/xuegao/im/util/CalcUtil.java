package com.xuegao.im.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * <br/> @PackageName：com.sf.edu.util
 * <br/> @ClassName：CalcUtil
 * <br/> @Description：计算，加减乘除，百分比，等等
 * <br/> @author：80004960
 * <br/> @date：2020/12/16 10:08
 */
public class CalcUtil {
    private static final Logger log = LoggerFactory.getLogger(CalcUtil.class);

    private CalcUtil() {
    }

    /**
     * <br/> @Title: 根据分子分母，获取最终的百分比
     * <br/> @Description:
     * <br/> @MethodName: getPercentage
     * <br/> @param molecule: 分子
     * <br/> @param denominator: 分母
     * <br/> @return: java.lang.String
     * <br/> @author: 80004960
     * <br/> @date: 2020/12/14 20:20
     */
    public static String getPercentage(String molecule, String denominator) {
        String returnStr = "0%";
        // 如果 分子分母都为 0
        if ("0".equals(molecule) && "0".equals(denominator)) {
            return returnStr;
        }
        // 如果 分子 单独为 0
        if (StringUtils.isBlank(molecule)) {
            return returnStr;
        }
        // 如果 分子不为 0，但是分母为 0
        if (StringUtils.isBlank(denominator) || "0".equals(denominator)) {
            returnStr = "100%";
            log.error(" ExportStudentVO getPercentage 分母为 blank {}", denominator);
            return returnStr;
        }

        int moleculeInt = Integer.parseInt(molecule);
        int denominatorInt = Integer.parseInt(denominator);
        int merchant = (int) ((BigDecimal.valueOf((float) moleculeInt / denominatorInt).doubleValue()) * 100);

        returnStr = merchant + "%";
        return returnStr;
    }

    public static void main(String[] args) {
        String percentage = getPercentage("1", "5");
        System.out.println(percentage);
    }
}