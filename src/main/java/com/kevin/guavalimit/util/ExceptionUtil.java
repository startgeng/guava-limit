package com.kevin.guavalimit.util;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class ExceptionUtil {

    public static void handleException(BlockException ex) {
        System.out.println("开小差了");
    }
}
