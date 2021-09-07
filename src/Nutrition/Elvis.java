package Nutrition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class Elvis {
    //公有静态成员是个final域
//    public static final Elvis INSTANCE=new Elvis();
    //声明一个包含单个元素的枚举类型
//    public enum ElvisSet{
//        INSTANCE;
//    }
    //公有成员是个静态工厂方法
    private static final Elvis INSTANCE=new Elvis();

    private Elvis(){}
    public static Elvis getInstance(){return INSTANCE;}
    public static  void main(String args[]){
        Object[] temp={0,1};
        Object result=temp[1];
        temp[1]=null;
        System.out.println(result);
    }
}
