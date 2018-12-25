package com.pcidata.renrenstudy.config;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: dzy
 * @Date: 2018/12/21 17:22
 * @Describe: Shiro的配置文件
 */
@Configuration
public class ShiroConfig {

    /**
     * 单机环境,session交给shiro管理
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "renren", name = "cluster", havingValue = "false")
    public DefaultWebSessionManager sessionManager(@Value("${renren.globalSessionTimeout:3600}") long globalSessionTimeout) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        sessionManager.setSessionValidationInterval(globalSessionTimeout * 1000);
        sessionManager.setGlobalSessionTimeout(globalSessionTimeout * 1000);

        return sessionManager;
    }

}
