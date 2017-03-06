package com.blog.blogsit.enums;

import java.util.Locale;

/**
 * 包含有地区和没有地区的语言类型，提供toLocale方法支持国际化
 *
 * @author hua.chen
 * @date 2017年03月05 22:31
 */

public enum LanguageType implements EnumTrait {
    /**
     * 不包含地区
     */
    ZH(0, "中文", "ZH", ""), //
    AR(1, "阿拉伯文", "AR", ""), //
    BE(2, "白俄罗斯文", "BE", ""), //
    BG(3, "保加利亚文", "BG", ""), //
    CA(4, "加泰罗尼亚文", "CA", ""), //
    CS(5, "捷克文", "CS", ""), //
    DA(6, "丹麦文", "DA", ""), //
    DE(7, "德文", "DE", ""), //
    EL(8, "希腊文", "EL", ""), //
    EN(9, "英文", "EN", ""), //
    ES(10, "西班牙文", "ES", ""), //
    ET(11, "爱沙尼亚文", "ET", ""), //
    FI(12, "芬兰文", "FI", ""), //
    FR(13, "法文", "FR", ""), //
    GA(14, "爱尔兰文", "GA", ""), //
    HI(15, "印地文", "HI", ""), //
    HR(16, "克罗地亚文", "HR", ""), //
    HU(17, "匈牙利文", "HU", ""), //
    IN(18, "印度尼西亚文", "IN", ""), //
    IS(19, "冰岛文", "IS", ""), //
    IT(20, "意大利文", "IT", ""), //
    IW(21, "希伯来文", "IW", ""), //
    JA(22, "日文", "JA", ""), //
    KO(23, "朝鲜文", "KO", ""), //
    LT(24, "立陶宛文", "LT", ""), //
    LV(25, "拉托维亚文(列托)", "LV", ""), //
    MK(26, "马其顿文", "MK", ""), //
    MS(27, "马来文", "MS", ""), //
    MT(28, "马耳他文", "MT", ""), //
    NL(29, "荷兰文", "NL", ""), //
    NO(30, "挪威文", "NO", ""), //
    PL(31, "波兰文", "PL", ""), //
    PT(32, "葡萄牙文", "PT", ""), //
    RO(33, "罗马尼亚文", "RO", ""), //
    RU(34, "俄文", "RU", ""), //
    SK(35, "斯洛伐克文", "SK", ""), //
    SL(36, "斯洛文尼亚文", "SL", ""), //
    SQ(37, "阿尔巴尼亚文", "SQ", ""), //
    SR(38, "塞尔维亚文", "SR", ""), //
    SV(39, "瑞典文", "SV", ""), //
    TH(40, "泰文", "TH", ""), //
    TR(41, "土耳其文", "TR", ""), //
    UK(42, "乌克兰文", "UK", ""), //
    VI(43, "越南文", "VI", ""), //

    /**
     * 包含地区
     */
    // Asia
    ZH_CN(1001, "简体中文(中国)", "ZH", "CN"), //
    ZH_HK(1002, "繁体中文(香港)", "ZH", "HK"), //
    ZH_TW(1003, "繁体中文(台湾)", "ZH", "TW"), //
    JA_JP(1004, "日文(日本)", "JA", "JP"), //
    KO_KR(1005, "韩文(韩国)", "KO", "KR"), //
    TH_TH(1006, "泰文(泰国)", "TH", "TH"), //
    VI_VN(1007, "越南文(越南)", "VI", "VN"), //
    IN_ID(1008, "印度尼西亚文(印度尼西亚)", "IN", "ID"), //
    EN_SG(1009, "英文(新加坡)", "EN", "SG"), //
    ZH_SG(1010, "中文(新加坡)", "ZH", "SG"), //
    EN_PH(1011, "英文(菲律宾)", "EN", "PH"), //
    IW_IL(1012, "希伯来文(以色列)", "IW", "IL"), //
    AR_QA(1013, "阿拉伯文(卡塔尔)", "AR", "QA"), //
    MS_MY(1014, "马来文(马来西亚)", "MS", "MY"), //
    AR_IQ(1015, "阿拉伯文(伊拉克)", "AR", "IQ"), //

    // Europe
    EN_GB(2001, "英文(英国)", "EN", "GB"), //
    FR_FR(2002, "法文(法国)", "FR", "FR"), //
    ES_ES(2003, "西班牙文(西班牙)", "ES", "ES"), //
    DE_DE(2004, "德文(德国)", "DE", "DE"), //
    RU_RU(2005, "俄文(俄罗斯)", "RU", "RU"), //
    IT_IT(2006, "意大利文(意大利)", "IT", "IT"), //
    PT_PT(2007, "葡萄牙文(葡萄牙)", "PT", "PT"), //
    DA_DK(2008, "丹麦文（丹麦)", "DA", "DK"), //
    PL_PL(2009, "波兰文(波兰)", "PL", "PL"), //
    UK_UA(2010, "乌克兰文(乌克兰)", "UK", "UA"), //
    EL_GR(2011, "希腊文(希腊)", "EL", "GR"), //
    SL_SI(2012, "斯洛文尼亚文(斯洛文尼亚)", "SI", "SL"), //
    DE_LU(2013, "德文(卢森堡),", "DE", "LU"), //
    FR_CH(2014, "法文(瑞士)", "FR", "CH"), //
    IT_CH(2015, "意大利文(瑞士)", "IT", "CH"), //
    SR_ME(2016, "塞尔维亚文(黑山)", "SR", "ME"), //
    SR_RS(2017, "塞尔维亚文(塞尔维亚)", "SR", "RS"), //
    NO_NO(2018, "挪威文(挪威)", "NO", "NO"), //
    IS_IS(2019, "冰岛文(冰岛)", "IS", "IS"), //
    FI_FI(2020, "芬兰文(芬兰)", "FI", "FI"), //

    // North America
    EN_US(3001, "英文(美国)", "EN", "US"), //
    EN_CA(3002, "英文(加拿大)", "EN", "CA"), //
    FR_CA(3003, "法文(加拿大)", "FR", "CA"), //
    ES_MX(3004, "西班牙文(墨西哥)", "ES", "MX"), //

    // South America
    ES_AR(4001, "西班牙文(阿根廷)", "ES", "AR"), //
    PT_BR(4002, "葡萄牙文(巴西)", "PT", "BR"), //
    ES_CL(4003, "西班牙文(智利)", "ES", "CL"), //

    // Austrilia
    EN_AU(5001, "英文(澳大利亚)", "EN", "AU"), //
    EN_NZ(5002, "英文(新西兰)", "EN", "NZ"), //

    // Africa
    EN_ZA(6001, "英文(南非)", "EN", "ZA") //
    ;
    private int code;
    private String desc;
    private String langCode;
    private String countryCode;

    LanguageType(int code, String desc, String langCode, String countryCode) {
        this.code = code;
        this.desc = desc;
        this.langCode = langCode;
        this.countryCode = countryCode;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getLangCode() {
        return langCode;
    }

    public static LanguageType codeOf(int code) {
        for (LanguageType languageType : LanguageType.values()) {
            if (languageType.getCode() == code) {
                return languageType;
            }
        }
        return null;
    }

    public static LanguageType descOf(String desc) {
        for (LanguageType languageType : LanguageType.values()) {
            if (languageType.getDesc().equals(desc)) {
                return languageType;
            }
        }
        return null;
    }

    public static LanguageType langCodeAndCountryCodeOf(String langCode, String countryCode) {
        for (LanguageType languageType : LanguageType.values()) {
            if (languageType.getLangCode().equals(langCode)&&languageType.getCountryCode().equals(countryCode)) {
                return languageType;
            }
        }
        return null;
    }

    public Locale toLocale() {
        return new Locale(getLangCode(), getCountryCode());
    }
}
