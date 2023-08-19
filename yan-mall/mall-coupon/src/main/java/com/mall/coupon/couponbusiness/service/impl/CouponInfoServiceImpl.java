package com.mall.coupon.couponbusiness.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.coupon.couponbusiness.dao.CouponInfoDao;
import com.mall.coupon.couponbusiness.model.CouponInfo;
import com.mall.coupon.couponbusiness.service.CouponInfoService;
import com.yan.common.utils.RResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("couponService")
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoDao, CouponInfo> implements CouponInfoService {
    @Autowired
    CouponInfoDao couponInfoDao;

    @Override
    public List<CouponInfo> queryCouponInfo(CouponInfo couponInfo) {
        return couponInfoDao.queryCouponInfo(couponInfo);
    }

    @Override
    public List<CouponInfo> getCouponInfoByName(CouponInfo couponInfo) {
        return couponInfoDao.queryCouponInfoByName(couponInfo);
    }
}