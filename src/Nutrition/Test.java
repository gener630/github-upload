package Nutrition;

import java.lang.ref.SoftReference;

/**
 * @ClassName Test
 * @Description TODO
 * @Author gy
 * @Date 2021/7/22 15:29
 */
public class Test {

    public static void main(String[] args){
        System.out.println("开始");
        A a = new A();
        SoftReference<A> sr = new SoftReference<A>(a);
        a = null;
        if(sr!=null){
            a = sr.get();
        }
        else{
            a = new A();
            sr = new SoftReference<A>(a);
        }
        System.out.println("结束");
    }

}

class A{
    int[] a ;
    public A(){
        a = new int[100000000];
    }
}
