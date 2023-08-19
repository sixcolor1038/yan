package com.mall.coupon.couponbusiness.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.coupon.couponbusiness.model.CouponInfo;
import com.yan.common.utils.RResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Mapper
public interface CouponInfoDao extends BaseMapper<CouponInfo> {

	List<CouponInfo> queryCouponInfoByName(CouponInfo couponInfo);

	List<CouponInfo> queryCouponInfo(@RequestBody CouponInfo couponInfo) ;
}
