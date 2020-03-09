package com.springboot.domain;

/**
 * JsonResultCity
 * TODO
 * @description 对应以下
 * {
 *           "cityName": "武汉",
 *           "currentConfirmedCount": 16609,
 *           "confirmedCount": 49948,
 *           "suspectedCount": 0,
 *           "curedCount": 30951,
 *           "deadCount": 2388,
 *           "locationId": 420100
 *         },
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since
 */
public class JsonResultCity {

    private String cityName;

    private int currentConfirmedCount;

    private int confirmedCount;

    private int suspectedCount;

    private int curedCount;

    private int deadCount;

    private int locationId;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
    