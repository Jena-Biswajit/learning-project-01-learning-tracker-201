package com.oops;


class Block
{
    static {
        System.out.println("Static block executed.");
    }

    {
        System.out.println("Non-static block executed.");
    }

    public Block() {
        System.out.println("Constructor executed.");
    }

}
public class StaticNonStaticBlock {
    public static void main(String[] args) {
        System.out.println("Main method starts.");
        Block checkBlock = new Block();
        Block checkType = new Block();
    }
}
