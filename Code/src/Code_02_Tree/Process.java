package Code_02_Tree;

import java.io.ObjectInputStream;

/**
 * @ClassName Process
 * @Description TODO
 * @Author ZhangLei
 * @Date 2019/10/10 20:33
 * @Version 1.0
 **/
public class Process {
    public static void process(int N,String from,String to,String help){
        if (N==1){
            System.out.println("Move 1 from " + from + " to "+ to);
        }else{
            process(N-1,from,help,to);
            System.out.println("Move "+ N + " from " + from + " to "+ to);
            process(N-1,help,to,from);
        }
    }
    public static void main(String[] args){
        process(3,"左","右","中");
    }
}
