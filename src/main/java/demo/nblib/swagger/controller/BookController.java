package demo.nblib.swagger.controller;

import demo.nblib.swagger.common.ReqEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "图书信息", tags = "图书信息")
@RestController
@RequestMapping("/v1/book")
public class BookController {

    @ApiOperation(value = "获取图书信息", notes = "根据id获取图书信息")
    @GetMapping("/info")
    public ReqEntity<String> book(@RequestParam("id") String id) {
        ReqEntity<String> result = new ReqEntity<String>();
        result.setCode(1);
        result.setMsg("success");
        result.setData(id);
        return result;
    }
}
