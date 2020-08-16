package com.howie.vo;

public class ProvinceAndCityVo {
    // 省份相关的信息
    private Integer pid;
    private String pname;
    private String jiancheng;
    private String shenghui;

    // 城市相关的信息
    private Integer cid;
    private String cname;

    public ProvinceAndCityVo() {
    }

    public ProvinceAndCityVo(Integer pid, String pname, String jiancheng, String shenghui, Integer cid, String cname) {
        this.pid = pid;
        this.pname = pname;
        this.jiancheng = jiancheng;
        this.shenghui = shenghui;
        this.cid = cid;
        this.cname = cname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getJiancheng() {
        return jiancheng;
    }

    public void setJiancheng(String jiancheng) {
        this.jiancheng = jiancheng;
    }

    public String getShenghui() {
        return shenghui;
    }

    public void setShenghui(String shenghui) {
        this.shenghui = shenghui;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "ProvinceAndCityVo{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", jiancheng='" + jiancheng + '\'' +
                ", shenghui='" + shenghui + '\'' +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
