package com.shuyun.controller;

import com.shuyun.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by shuyun on 2016/8/10.
 */
@Controller
@RequestMapping("/article")
public class TestController {
  @RequestMapping("/list")
    public String list(){
      return "article/list";
  }
    @RequestMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") int id){
        ModelAndView modelAndView=new ModelAndView();
        if(id==1){
         modelAndView.addObject("article",new Article("第一章","数据结构"));
        }else if(id==2){
         modelAndView.addObject("article",new Article("第二章","开始做题"));
        }
        modelAndView.setViewName("article/details");
        return modelAndView;
    }
}
