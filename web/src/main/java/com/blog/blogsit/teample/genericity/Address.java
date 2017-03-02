package com.blog.blogsit.teample.genericity;

/**
 * 功能描述
 * 地址模型
 *
 * @author hua.chen
 * @create 2016年11月09日11:50
 **/
public class Address implements  Comparable{
    public String city;
    public String town;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

/*    @Override
    public boolean equals(Object obj) {
        Address otherAddress = (Address) obj;
        return otherAddress.getCity().equals(getCity()) && otherAddress.getTown().equals(getTown());
    }*/

    @Override
    public int hashCode() {
        return getCity().hashCode() + getTown().hashCode();
    }

    @Override
    public String toString() {
        return "城市:" + getCity() + "城镇:" + getTown();
    }

    @Override
    public int compareTo(Object obj) {
        Address otherAddress = (Address) obj;
        if(otherAddress.getCity().equals(getCity()) && otherAddress.getTown().equals(getTown())){
            return 0;
        }
        return -1;
    }
}
