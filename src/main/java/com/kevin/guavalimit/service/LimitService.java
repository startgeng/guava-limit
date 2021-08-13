package com.kevin.guavalimit.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kevin.guavalimit.util.ExceptionUtil;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class LimitService {

    @SentinelResource(value = "LimitService.process",blockHandler = "exceptionHandler")
    public String process(){
        return "process";
    }


    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "开小差了，请重试.......";
    }
}
