package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.chart.ValueAxis;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }

    /**
     * 要求客户端携带cookies访问
     */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "你必须携带cookies信息来";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "这是一个需要携带cookies信息才能访问的get请求";
            }
        }

        return "你必须携带cookies信息来";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式：url：key=value&key=value
     * 模拟获取商品列表
     */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求方法1",httpMethod = "GET")
    public Map<String,Integer> getList1(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("小浣熊",1);
        myList.put("柳叶风林",20);

        return myList;
    }
    /**
     * 第二种实现方式：
     * url:ip:port/get/with/param/10/20
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求方法2",httpMethod = "GET")
    public Map<String,Integer> getList2(@PathVariable Integer start,
                                       @PathVariable Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("小浣熊",1);
        myList.put("柳叶风林",20);
        myList.put("水杯",30);

        return myList;
    }

}
