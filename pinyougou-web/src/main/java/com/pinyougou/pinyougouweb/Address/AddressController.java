package com.pinyougou.pinyougouweb.Address;

import com.alibaba.dubbo.config.annotation.Reference;

import com.pinyougou.pojo.TbAddress;
import com.pinyougou.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * author:zkx
 * create:time:2019/10/18
 * email:
 * tel:
 */
@Controller
@RequestMapping("address")
public class AddressController {
    @Reference
    private AddressService addressService;
    @RequestMapping("findAddressList")
    @ResponseBody
    public List<TbAddress> findAddressList(){
        return addressService.findAddRessList();
    }
    @RequestMapping("deleteAll")
    @ResponseBody
    public void deleteAll(Integer ids) {
        addressService.deleteAll(ids);
    }
    @RequestMapping("addAddress")
    @ResponseBody
    public void addAddress(TbAddress address){
        addressService.addAddress(address);
    }
    @RequestMapping("queryById")
    @ResponseBody
    public TbAddress queryById(Integer id){
        return addressService.queryById(id);
    }
}
