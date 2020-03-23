package com.aladdin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgc
 **/
@Api(value = "Demo")
@RestController
@RequestMapping("/demo")
public class DemoController {
    @ApiOperation(value = "demo 测试")
    @GetMapping("/list")
    public String out(@ApiParam(value = "name",required = false,example = "123") String name) {
        return "demo out";
    }
}
