package com.yan.demo.exceldemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author: sixcolor
 * @Date: 2024-03-05 8:41
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("PRODUCT_LIST")
public class ProductList {
    private Long productListID;
    private String businessMajor;
    private String businessModule;
    private String productName;
    private String businessItem;
    private String channels;
    private String productPath;
    private String productCapabilities;
    private LocalDate addedTime;
    private String developmentGroup;
    private String developmentDataResponsible;
    private String productClassification;
    private String frontendBackendClassification;
    private String productStatus;
    private String promotionApplicationMethod;
    private String usingOrganization;
    private String isPcOrMobile;
    private String remarks;
}
