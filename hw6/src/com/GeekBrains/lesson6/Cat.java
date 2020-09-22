package com.GeekBrains.lesson6;

public class Cat extends Animal
{


    Cat(String name, int mRun, int mJump)
    {
        super(name, mRun, mJump, 0);
    }
    @Override
    void swim(float swim){
        System.out.println(name + " не умеет плавать");
    }
}
