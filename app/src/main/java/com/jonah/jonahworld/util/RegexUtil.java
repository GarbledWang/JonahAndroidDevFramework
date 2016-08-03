package com.jonah.jonahworld.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ringo on 15/11/13.
 */
public class RegexUtil {


    public static boolean checkName(String name) {
        boolean flag = false;
        try {
            String check = "[\\u4e00-\\u9fa5·]{2,10}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(name);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static boolean checkLocation(String location) {
        boolean flag = false;
        try {
            String check = "([A-Za-z0-9]){6,12}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(location);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static boolean checkPassword(String password) {
        boolean flag = false;
        try {
//            String check = "([^\\x00-\\xff]|[A-Za-z0-9_]){6,12}";
            String check = "([^\\u4e00-\\u9fa5]|[A-Za-z0-9_]){6,12}";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(password);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号码
     *
     * @param mobile
     * @return
     */
    public static boolean checkMobileNumber(String mobile) {
        boolean flag = false;
        try {
            Pattern regex = Pattern.compile("(^(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7})$");
            Matcher matcher = regex.matcher(mobile);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证固定电话号码
     *
     * @param telephone 座机号,格式为：国家(地区)代码+区号(城市代码)+电话号码,如:+8602085588447
     * @see 国家(地区)代码:标识电话号码的国家(地区)的标准国家(地区)代码,它包含从0到9的一位或多位数字
     * @see 区号(城市代码):这可能包含一个或多个从0到9的数字,地区或城市代码放在圆括号标明对不使用地区或城市代码的国家(地区)则省略该组件
     * @see 电话号码:包含从0到9的七位或八位数字
     */
    public static boolean checkTelephone(String telephone) {
        return Pattern.matches("^(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$", telephone);
    }

    /**
     * 验证运营商手机号码
     *
     * @see -------------------------------------------------------------------------------------------------------
     * @see 【移动】
     * @see 上网卡----------------147(14号段以前为上网卡专属号段,如中国联通的是145,中国移动的是147)
     * @see 2G号段(GSM网络)-------134(0~8),135,136,137,138,139,150,151,152,158,159
     * @see 3G号段(TD-SCDMA网络)--157,182,183,184,187,188
     * @see 4G号段----------------178
     * @see -------------------------------------------------------------------------------------------------------
     * @see 【联通】
     * @see 上网卡-------------145
     * @see 2G号段(GSM网络)----130,131,132,155,156
     * @see 3G号段(WCDMA网络)--185,186
     * @see 4G号段-------------176
     * @see -------------------------------------------------------------------------------------------------------
     * @see 【电信】
     * @see 2G号段(CDMA网络)--133,153
     * @see 3G号段(CDMA网络)--180,181,189
     * @see 4G号段------------177
     * @see -------------------------------------------------------------------------------------------------------
     * @see 【其它】
     * @see 卫通-------------1349
     * @see 中国电信转售号码--1700(170号段为虚拟运营商专属号段,170号段的11位手机号的前四位来区分基础运营商)
     * @see 中国移动转售号码--1705
     * @see 中国联通转售号码--1709
     * @see -------------------------------------------------------------------------------------------------------
     */
    public static boolean isPhone(String phone) {
        //return Pattern.matches("^(\\+\\d+)?((13\\d{9}$)|(15[0,1,2,3,5,6,7,8,9]\\d{8}$)|(18[0,2,5,6,7,8,9]\\d{8}$)|(14[5,7]\\d{8})$)$", phone);
        String PHONE_MOBILE = "^(86)?1((34[0-8]\\d{7})|(((3[5-9])|(5[012789])|(8[23478])|(47)|(78))\\d{8}))$";
        String PHONE_UNICOM = "^(86)?1((3[0-2]{1})|(45)|(5[56])|(8[56]|76))\\d{8}$";
        String PHONE_TELECOM = "^(86)?1((33)|(53)|(8[019])|77)\\d{8}$";
        String PHONE_SATCOM = "^(86)?1349\\d{7}$";
        String PHONE_VIRTUAL = "^(86)?170\\d{8}$";
        boolean flag = false;
        if (Pattern.matches(PHONE_MOBILE, phone)) {
            flag = true;
        } else if (Pattern.matches(PHONE_UNICOM, phone)) {
            flag = true;
        } else if (Pattern.matches(PHONE_TELECOM, phone)) {
            flag = true;
        } else if (Pattern.matches(PHONE_SATCOM, phone)) {
            flag = true;
        } else if (Pattern.matches(PHONE_VIRTUAL, phone)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 验证中文
     */
    public static boolean isChinese(String chinese){
        return Pattern.matches("^[\u4E00-\u9FA5]+$", chinese);
    }


    /**
     * 验证中国邮政编码
     */
    public static boolean isPostCode(String postCode){
        return Pattern.matches("^[1-9]\\d{5}$", postCode);
    }


    /**
     * 验证IP地址
     * @see 这里并未匹配IP段的大小
     * @param ipAddress IPv4标准地址
     */
    public static boolean isIPAddress(String ipAddress){
        return Pattern.matches("^[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))$", ipAddress);
    }


    /**
     * 验证URL地址
     */
    public static boolean isURL(String url){
        return Pattern.matches("^(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?$", url);
    }

}
