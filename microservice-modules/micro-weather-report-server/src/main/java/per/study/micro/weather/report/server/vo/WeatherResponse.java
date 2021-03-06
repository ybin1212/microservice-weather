package per.study.micro.weather.report.server.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 天气信息的响应实体.
 *
 * @author yangbin
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse implements Serializable {
    /** 天气数据. **/
    private Weather data;
    /** 异常码. **/
    private Integer status;
    /** 异常信息. **/
    private String desc;
}
