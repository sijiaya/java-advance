package com.soft1841.swing;

/**
 * 枚举类型实例 p217
 * @author sijia
 * 2019.3.21
 */

//将常量放入枚举类型中
enum Season {
    SPRING("春天"), SUMMER("夏天"), AUTUMN("秋天"), WINTER("冬天");
    String seasonName;

    Season(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

        //定义一个静态方法，根据一个简称能够得到完整的季节名称
    public static Season getResult(String input){
        switch (input){
            case "spr":
                return Season.SPRING;
            case "sum":
                return Season.SUMMER;
            case "aut":
                return Season.AUTUMN;
            case "win":
                return Season.WINTER;
            default:
                return Season.SPRING;
        }
    }
}

//    public class EnumTest {
//        public static void main(String[] args) {
//            for (Season e : Season.values()
//            ) {
//                System.out.println(e);
//            }
//        }
//    }
public class EnumTest {
    public static void main(String[] args) {
        //写入需要输出的季节简写
        Season season = Season.getResult("win");
        System.out.println(season+"——"+season.getSeasonName());
    }
}
