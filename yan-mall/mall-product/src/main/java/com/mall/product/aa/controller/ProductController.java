package com.mall.product.aa.controller;

import com.mall.coupon.couponbusiness.model.CouponInfo;
import com.mall.product.aa.feign.AxService;
import com.yan.common.utils.RResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("aaa")
@RestController
public class ProductController {
    @Autowired
    AxService axService;

    @Operation(summary = "测试feign", description = "测试feign")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public RResult<List<CouponInfo>> query() {
        CouponInfo couponInfo = new CouponInfo();
        couponInfo.setId(5L);
        return axService.listCouponInfo(couponInfo);
    }
}
