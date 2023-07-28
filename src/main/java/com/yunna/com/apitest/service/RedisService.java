package com.yunna.com.apitest.service;

import com.yunna.com.apitest.bean.ResponseData;

/**
 * @Author zhuxd
 * @Date 2023/7/28 14:58
 * @Version 1.0
 */
public interface RedisService {

    //从redis中查询各手机的访问量
    ResponseData queryVisitStatsTop3();
}
