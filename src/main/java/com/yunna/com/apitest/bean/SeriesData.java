package com.yunna.com.apitest.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author zhuxd
 * @Date 2023/7/28 15:04
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeriesData<T> {
    private String name;
    private List<T> data;

}
