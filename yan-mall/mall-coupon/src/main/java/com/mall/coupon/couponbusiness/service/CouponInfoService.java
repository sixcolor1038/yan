package com.mall.coupon.couponbusiness.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.coupon.couponbusiness.model.CouponInfo;
import com.yan.common.utils.RResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CouponInfoService extends IService<CouponInfo> {

    List<CouponInfo> queryCouponInfo(@RequestBody CouponInfo couponInfo) ;

    List<CouponInfo> getCouponInfoByName(CouponInfo couponInfo);


}

