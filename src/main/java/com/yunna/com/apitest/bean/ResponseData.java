package com.yunna.com.apitest.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author zhuxd
 * @Date 2023/7/28 15:00
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {

    private String msg;

    private Integer status;

    private JSONObject data;

    public ResponseData(String msg, Integer status, List<String> categories, List<SeriesData> series) {
        this.msg = msg;
        this.status = status;
        JSONObject dataJO = new JSONObject();
        dataJO.put("series", series);
        dataJO.put("categories", categories);

        this.data = dataJO;
    }
}
