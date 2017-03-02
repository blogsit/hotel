package com.blog.blogsit.arithmetic;

import java.util.ArrayList;

/**
 * Created by blogsit on 16/8/15.
 */
public class Pingpang {
    String a, b, c;

    public Pingpang(String a, String b, String c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "a的对手是" + a + "," + "b的对手是" + b + "," + "c的对手是" + c + "\n";
    }

    public static void main(String[] args) {
        String[] op = {"x", "y", "z"};
        ArrayList<Pingpang> arrayList = new ArrayList<Pingpang>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    Pingpang a = new Pingpang(op[i], op[j], op[k]);
                    if (!a.a.equals(a.b) && !a.b.equals(a.c) && !a.a.equals("x") && !a.c.equals("x") && !a.c.equals("z")) {
                        arrayList.add(a);
                    }
                }
            }
        }
        for (Object a : arrayList) {
            System.out.println(a);
        }

    }
}
