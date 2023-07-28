package com.yunna.com.apitest.controller;

import com.yunna.com.apitest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuxd
 * @Date 2023/7/28 15:51
 * @Version 1.0
 */
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/queryVisitStatsTop3")
    public Object queryVisitStatsTop5() {
        return redisService.queryVisitStatsTop3();
    }
}
