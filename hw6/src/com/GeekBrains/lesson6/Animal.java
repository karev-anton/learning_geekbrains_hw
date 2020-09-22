package com.GeekBrains.lesson6;

public abstract class Animal {
    protected String name;
    protected int mRun;
    protected int mJump;
    protected float mSwim;

    Animal (String name, int mRun, int mJump, float mSwim)
    {
        this.name=name;
        this.mRun=mRun;
        this.mJump=mJump;
        this.mSwim=mSwim;
    }

    void run(int run){
        System.out.println(name + " побежала: "+ isAvail(run,mRun) );
    }
    void swim(float swim){
        System.out.println(name + " проплыла: " + isAvail(swim,mSwim) );
    }
    void jump(int jump){
        System.out.println(name + " прыгнула: " +  isAvail(jump,mJump));
    }
    private boolean isAvail(float required, float expected)
    {
        return required<=expected;
    }
}
