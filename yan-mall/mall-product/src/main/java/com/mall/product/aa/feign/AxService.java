package com.mall.product.aa.feign;

import com.mall.coupon.couponbusiness.model.CouponInfo;
import com.yan.common.utils.RResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient("mall-coupon")
public interface AxService {

    @RequestMapping(value = "/coupon/couponBusiness/listCouponInfo", method = RequestMethod.POST)
    public RResult<List<CouponInfo>> listCouponInfo(@RequestBody CouponInfo couponInfo);
}
