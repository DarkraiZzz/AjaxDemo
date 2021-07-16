package com.Darkra1Zzz.entity;

/**
 * @Author DarkraiZzz
 * @Time 2021/7/15 0:40
 * @Version 1.0
 */
public class Emp {
    private int eid;
    private String ename;
    private Dept dept;

    public Emp(int eid, String ename) {
        this.eid = eid;
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", dept=" + dept +
                '}';
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
