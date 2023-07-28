package com.yunna.com.apitest.service;

import com.yunna.com.apitest.bean.ResponseData;
import com.yunna.com.apitest.bean.SeriesData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * @Author zhuxd
 * @Date 2023/7/28 15:11
 * @Version 1.0
 */
@Service
public class RedisServiceImpl implements RedisService {
    /**
     * Type parameters:
     * <K> – the Redis key type against which the template works (usually a String)
     * <V> – the Redis value type against which the template works
     */
    @Autowired
    private RedisTemplate<String, String> redisClient;
    //从配置文件中读取指定的value，赋值给当前变量
    @Value("${apiTest.redis.key}")
    private String redisKey;


    @Override
    public ResponseData queryVisitStatsTop3() {
        Set<ZSetOperations.TypedTuple<String>> res = redisClient.opsForZSet().reverseRangeWithScores(redisKey, 0, 3);

        ArrayList<String> categories = new ArrayList<>();
        ArrayList<Double> brandData = new ArrayList<>();

        for (ZSetOperations.TypedTuple<String> re : res) {
            categories.add(re.getValue());
            brandData.add(re.getScore());
        }
        SeriesData<Double> orderSeriesData = new SeriesData<>("手机品牌", brandData);

        ResponseData responseData = new ResponseData("", 0, categories, Arrays.asList(orderSeriesData));
        return responseData;
    }
}
