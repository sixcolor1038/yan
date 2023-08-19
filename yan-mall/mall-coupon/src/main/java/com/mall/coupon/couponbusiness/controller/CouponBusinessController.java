package com.mall.coupon.couponbusiness.controller;

import com.mall.coupon.couponbusiness.model.CouponInfo;
import com.mall.coupon.couponbusiness.service.CouponInfoService;
import com.yan.common.aspect.WebLogAspect;
import com.yan.common.utils.RResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "CouponBusinessController", description = "优惠券信息")
@RestController
@RequestMapping("coupon/couponBusiness")
public class CouponBusinessController {
    private final static Logger log = LoggerFactory.getLogger(WebLogAspect.class);

    @Autowired
    private CouponInfoService couponInfoService;

    @Operation(summary = "新增优惠券", description = "根据传参新增优惠券")
    @RequestMapping(value = "/saveCouponInfo", method = RequestMethod.POST)
    public RResult<CouponInfo> saveCouponInfo(@RequestBody CouponInfo couponInfo) {
        log.info("11111111111111111111111111111111");
        couponInfoService.save(couponInfo);
        return RResult.success(couponInfo);
    }

    @Transactional
    @Operation(summary = "删除优惠券", description = "根据id删除优惠券")
    @RequestMapping(value = "/deleteCouponInfo", method = RequestMethod.DELETE)
    public RResult<CouponInfo> deleteCouponInfo(@RequestBody int id) {
        couponInfoService.removeById(id);
        return RResult.success(null);
    }

    @Operation(summary = "查询优惠券", description = "根据名称查询优惠券")
    @RequestMapping(value = "/listCouponInfo", method = RequestMethod.POST)
    public RResult<List<CouponInfo>> listCouponInfo(@RequestBody CouponInfo couponInfo) {
        List<CouponInfo> listRResult = couponInfoService.queryCouponInfo(couponInfo);
        return RResult.success(listRResult);
    }

    @RequestMapping(value = "/queryCouponInfoByName", method = RequestMethod.POST)
    public RResult<List<CouponInfo>> queryCouponInfoByName(@RequestBody CouponInfo couponInfo) {
        System.out.println("入参：：："+couponInfo);
        List<CouponInfo> couponInfoByName = couponInfoService.getCouponInfoByName(couponInfo);
        return RResult.success(couponInfoByName);
    }
}
