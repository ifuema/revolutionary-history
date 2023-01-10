package indi.revolutionaryhistory.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class HttpRequestUtil {
    @Resource
    RestTemplate restTemplate;
    @Resource
    ObjectMapper objectMapper;

    /**
     * 发起get请求
     * @param url
     * @param map
     * @return
     */
    public JsonNode getRequest(String url, Map<String, String> map) {
        if (url == null) {
            return null;
        }
        url = url + "?";
        if (map != null) {
            for (String key: map.keySet()) {
                url = url + "&" + key + "={" + key + "}";
            }
        }
        try {
            return objectMapper.readTree(restTemplate.getForObject(url, String.class, map));
        } catch (Exception e) {
            return null;
        }
    }
}
