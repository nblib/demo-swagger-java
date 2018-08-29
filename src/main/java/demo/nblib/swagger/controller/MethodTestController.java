package demo.nblib.swagger.controller;

import demo.nblib.swagger.common.ReqEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@Api(value = "测试不同请求方法的使用样例", tags = "不同请求")
@RestController
@RequestMapping("/method")
public class MethodTestController {


    @ApiOperation(value = "测试GET", notes = "测试使用get方法提交请求")
    @GetMapping("/get")
    public ReqEntity<String> get() {
        ReqEntity<String> req = new ReqEntity<>();
        req.setCode(1);
        req.setMsg("success");
        req.setData("hello,you got a msg");
        return req;
    }

    @ApiOperation(value = "测试POST", notes = "测试使用post方法提交请求")
    @PostMapping("/post")
    public ReqEntity<String> post(@ApiParam(name = "姓名", value = "测试参数", required = true) @RequestParam("name") String name,
                                  @ApiParam(name = "年龄", value = "测试年龄", required = true) @RequestParam("name") Integer age
    ) {
        ReqEntity<String> req = new ReqEntity<>();
        req.setCode(1);
        req.setMsg("success");
        req.setData("post is:" + name + age);
        return req;
    }
}
