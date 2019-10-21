package com.pinyougou.test.impl;/**
 * @program: pinyougou-parent
 * @author: yzy
 * @create: 2019-10-18 17:11
 **/

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.StudentModelMapper;
import com.pinyougou.test.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *@ClassName testServiceImpl
 *@Author yzy
 *@Date 2019/10/18 17:11
 */

@Service
@Component
public class testServiceImpl implements testService {

    @Autowired
    private StudentModelMapper studentModelMapper;

    @Override
    public void test() {
        System.out.println("测试");
    }
}
