package org.example;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static int getSum(int a, int b) {
        return a + b ;
    }

    public static String getPad(String substr, int count){
                    return StringUtils.repeat(substr,count);

    }
    }
