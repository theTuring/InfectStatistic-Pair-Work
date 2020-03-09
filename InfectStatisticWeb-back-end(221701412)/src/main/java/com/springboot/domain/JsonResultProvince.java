package com.springboot.domain;

import java.util.List;

/**
 * JsonResultProvince
 * TODO
 * @description 对应以下
 * {
 *       "provinceName": "湖北省",
 *       "provinceShortName": "湖北",
 *       "currentConfirmedCount": 18285,
 *       "confirmedCount": 67743,
 *       "suspectedCount": 0,
 *       "curedCount": 46451,
 *       "deadCount": 3007,
 *       "comment": "",
 *       "locationId": 420000,
 *       "cities": [
 *         {
 *
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since
 */
public class JsonResultProvince {

    private String provinceName;

    private String provinceShortName;

    private int currentConfirmedCount;

    private int confirmedCount;

    private int suspectedCount;

    private int curedCount;

    private int deadCount;

    private String comment;

    private int locationId;

    private List<JsonResultCity> cities;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName;
    }

    public int getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(int currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public int getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(int confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public int getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(int suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public int getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(int curedCount) {
        this.curedCount = curedCount;
    }

    public int getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(int deadCount) {
        this.deadCount = deadCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public List<JsonResultCity> getCities() {
        return cities;
    }

    public void setCities(List<JsonResultCity> cities) {
        this.cities = cities;
    }
}
    