package com.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Nation
 * TODO
 * @description Nation表对应的实体类
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.3.8
 */

@Entity
public class Nation {

    @Id
    //国家疫情记录id
    private int id;

    //日期
    private String date;

    //现有确诊
    private int current_diagnosis;

    //累计确诊
    private int cumulative_diagnosis;

    //疑似
    private int suspected;

    //治愈
    private int cured;

    //重症
    private int acute;

    //死亡
    private int dead;

    /**
     * Nation
     * TODO
     * @description Nation实体成员对应的getter与setter方法
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since 2020.3.8
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCurrent_diagnosis() {
        return current_diagnosis;
    }

    public void setCurrent_diagnosis(int current_diagnosis) {
        this.current_diagnosis = current_diagnosis;
    }

    public int getCumulative_diagnosis() {
        return cumulative_diagnosis;
    }

    public void setCumulative_diagnosis(int cumulative_diagnosis) {
        this.cumulative_diagnosis = cumulative_diagnosis;
    }

    public int getSuspected() {
        return suspected;
    }

    public void setSuspected(int suspected) {
        this.suspected = suspected;
    }

    public int getCured() {
        return cured;
    }

    public void setCured(int cured) {
        this.cured = cured;
    }

    public int getAcute() {
        return acute;
    }

    public void setAcute(int acute) {
        this.acute = acute;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }
}
    