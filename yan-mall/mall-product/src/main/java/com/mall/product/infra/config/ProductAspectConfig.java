package com.mall.product.infra.config;

import com.yan.common.aspect.WebLogAspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebLogAspect.class)
@ComponentScan("com.mall.product.*.*")
public class ProductAspectConfig {

}
