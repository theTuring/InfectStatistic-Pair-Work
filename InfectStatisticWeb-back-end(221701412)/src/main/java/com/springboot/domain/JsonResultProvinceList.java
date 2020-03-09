package com.springboot.domain;

import java.util.List;

/**
 * JsonResultProvinceList
 * TODO
 * @description 对应以下
 * {
 *   "code": 200,
 *   "msg": "success",
 *   "newslist": [
 *     {
 *
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since
 */
public class JsonResultProvinceList {

    private int code;

    private String msg;

    private List<JsonResultProvince> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<JsonResultProvince> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<JsonResultProvince> newslist) {
        this.newslist = newslist;
    }
}
    