package com.pinyougou.pinyougouweb.testController;/**
 * @program: pinyougou-parent
 * @author: yzy
 * @create: 2019-10-18 17:13
 **/

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.test.testService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@ClassName testController
 *@Author yzy
 *@Date 2019/10/18 17:13
 */
@Controller
@RequestMapping("test")
public class testController {

    @Reference
    private testService testService;

    public void test(){


        testService.test();

    }
}
