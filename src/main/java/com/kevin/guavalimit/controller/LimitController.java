package com.kevin.guavalimit.controller;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class LimitController {

    private RateLimiter rateLimiter = RateLimiter.create(10);

    /**
     * 创建放两个令牌的捅，且每秒放2个令牌 0.5秒放一个
     */
    @GetMapping(value = "/guava")
    public void guava(){
//        RateLimiter rateLimiter = RateLimiter.create(2);
//        //平滑输出  允许突发流量  透支了，令牌后面要还的
//        log.info("{}",rateLimiter.acquire(3));
//        log.info("{}",rateLimiter.acquire());
//        log.info("{}",rateLimiter.acquire());
//        log.info("{}",rateLimiter.acquire());

        /**
         * 下面的代码适合于高并发的情况下
         * ab -n 100 -c 10 http://127.0.0.1:8080/guava  11行
         */
        if (rateLimiter.tryAcquire()){
            log.info("抢到货物了");
        }else {
            log.info("手慢了，没抢到货物");
        }
    }
}
