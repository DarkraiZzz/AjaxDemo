package com.Darkra1Zzz.entity;

/**
 * @Author DarkraiZzz
 * @Time 2021/7/15 0:39
 * @Version 1.0
 */
public class Dept {
    private int did;
    private String dname;

    public Dept(int did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
