package com.jerry.java.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) throws Throwable {
//        try{
//            int i = 3;
//            i = i/0;
//        }catch (ArithmeticException e) {
//            Throwable t = new Exception("runtime exception");
//            t.initCause(e);
//            throw t;
//        }

//        Logger.getGlobal().info(String.valueOf(f(3)));

        tryWithResource();
    }

    // 如果 n 输入2 这个方法将返回 0， 覆盖掉正确的返回结果 2 * 2 = 4
    private static int f(int n) {
        try{
            int r = n * n;
            return r;
        }finally{
            if (n == 2) return 0;
        }
    }

    // try with resource
    private static void tryWithResource () throws FileNotFoundException {
        //When the block exits normally, or when there was an exception, the in.close()
        //method is called, exactly as if you had used a finally block.
        try(Scanner in = new Scanner(new FileInputStream("/Users/Jerry/Desktop/线上发布.sh"), "UTF-8")) {
            while (in.hasNext()) {
                System.out.println(in.next());
            }
        }

        //You can specify multiple resources. For example,
        try(Scanner in = new Scanner(new FileInputStream("/Users/Jerry/Desktop/线上发布.sh"), "UTF-8");
            PrintWriter out = new PrintWriter("out.txt")) {
            while (in.hasNext()) {
                out.println(in.next().toUpperCase());
            }
        }
    }
}
