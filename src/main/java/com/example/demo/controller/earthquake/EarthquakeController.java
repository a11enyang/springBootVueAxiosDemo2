package com.example.demo.controller.earthquake;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/earthquake")
public class EarthquakeController {

    @GetMapping("/manager")
    public String getManager() {
        return "earthquake_manager";
    }
    @GetMapping("/list")
    public String getList(){
        return "earthquake_list";
    }


    /**
     * 查看详细内容
     * @return
     */
    @GetMapping("/info/{id}")
    public String getInfo(@PathVariable int id){
        return "earthquake_info";
    }

    /**
     * 返回主页面
     * @return
     */
    @GetMapping("/index")
    public String getIndex(){
        return "earthquake_index";
    }
}
