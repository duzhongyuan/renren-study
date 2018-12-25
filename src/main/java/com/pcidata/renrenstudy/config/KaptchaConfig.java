package com.pcidata.renrenstudy.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author: dzy
 * @Date: 2018/12/21 15:56
 * @Describe: 生成验证码的配置
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();

        properties.put(Constants.KAPTCHA_BORDER, "no");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "black");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "5");

//        properties.put("kaptcha.border", "no");
//        properties.put("kaptcha.textproducer.font.color", "black");
//        properties.put("kaptcha.textproducer.char.space", "5");

        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
