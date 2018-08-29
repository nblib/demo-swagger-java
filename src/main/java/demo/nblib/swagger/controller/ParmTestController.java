package demo.nblib.swagger.controller;

import demo.nblib.swagger.common.CarInfo;
import demo.nblib.swagger.common.ReqEntity;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "不同参数不同返回值得使用方法,这里举例了不同参数,不同返回值的类型的使用方法", tags = "参数测试")
@RestController
@RequestMapping("/parm")
public class ParmTestController {

    @ApiOperation(value = "无参string", notes = "无参数返回String类型")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功,返回字符串", response = String.class), @ApiResponse(code = 404, message = "请求地址或方法不对")})
    @GetMapping("/noparm")
    public String noParm() {
        return "nihao";
    }

    @ApiOperation(value = "有参string", notes = "有参数返回String类型")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功,返回字符串", response = String.class), @ApiResponse(code = 404, message = "请求地址或方法不对")})
    @GetMapping("/parmm")
    public String parm(@ApiParam(name = "name", example = "nblib") @RequestParam("name") String name) {
        return "nihao: " + name;
    }

    @ApiOperation(value = "无参实体", notes = "返回自定义的实体类型,使用范型.实体类型的返回结果描述在实体类型定义的类中书写")
    @GetMapping("/entity")
    public ReqEntity<String> entity() {
        ReqEntity<String> req = new ReqEntity<>();
        req.setCode(1);
        req.setMsg("success");
        req.setData("hello,this is a messageÒ");
        return req;
    }

    @ApiOperation(value = "请求头说明", notes = "参数包含请求头")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "请求头中包含的参数", paramType = "header"),
            @ApiImplicitParam(name = "age", value = "参数age", paramType = "query")
    })
    @GetMapping("/header")
    public ReqEntity<String> header(@RequestHeader("token") String token, @RequestParam("age") Integer age) {
        ReqEntity<String> req = new ReqEntity<>();
        req.setCode(1);
        req.setMsg("success");
        req.setData("post is :" + token + age);
        return req;
    }

    @ApiOperation(value = "上传文件说明", notes = "参数包含上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ufile", value = "要上传的文件", paramType = "form", dataType = "MultipartFile", allowMultiple = true),
            @ApiImplicitParam(name = "name", value = "参数文件名", paramType = "form")
    })
    @PostMapping("/upload")
    public ReqEntity<String> upload(@RequestParam("ufile") MultipartFile file,
                                    @RequestParam("name") String name) {
        ReqEntity<String> req = new ReqEntity<>();
        req.setCode(1);
        req.setMsg("success");
        req.setData("file name is :" + name);
        return req;
    }

    @ApiOperation(value = "范型返回结果", notes = "测试使用范型的数据类型作为返回值")
    @GetMapping("/pattern")
    public ReqEntity<CarInfo> pattern() {
        ReqEntity<CarInfo> req = new ReqEntity<>();

        CarInfo carInfo = new CarInfo();
        carInfo.setInfoId("234");
        carInfo.setPrice(345.22f);
        carInfo.setSpecName("宝马");
        req.setData(carInfo);
        req.setMsg("success");
        req.setCode(1);
        return req;
    }

}
