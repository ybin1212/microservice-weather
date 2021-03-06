package com.study.demo.microservice.weather.service.impl;

import com.study.demo.microservice.weather.service.CityDataService;
import com.study.demo.microservice.weather.uitl.XmlBuilder;
import com.study.demo.microservice.weather.vo.City;
import com.study.demo.microservice.weather.vo.CityList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author yangbin
 **/
@Slf4j
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        // 1. 读取XML文件
        Resource resource = new ClassPathResource("/data/city-list-gd.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        // 2. XML转为Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, sb.toString());
        return cityList.getList();
    }
}
