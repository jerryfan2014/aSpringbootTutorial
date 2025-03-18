package com.kangda.cotroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(@RequestParam String msg){
//        return "hello, springboooooo!";
        return msg;
    }


    @RequestMapping("/printTable")
    public String genTable(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>").append("<table border='2'>");
        sb.append("<tr >").append("<td width='200px'>姓名</td>").append("<td width='150px'>年龄</td>").append("<td width='100px'>性别</td>").append("</tr>");
        sb.append("<tr>").append("<td>tom</td>").append("<td>18</td>").append("<td>男</td>").append("</tr>");
        sb.append("<tr>").append("<td>lisa</td>").append("<td>18</td>").append("<td>nv</td>").append("</tr>");
        sb.append("</table>").append("</html>");

        return sb.toString();
    }



}
