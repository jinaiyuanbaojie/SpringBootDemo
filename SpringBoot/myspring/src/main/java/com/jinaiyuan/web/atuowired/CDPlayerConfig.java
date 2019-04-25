package com.jinaiyuan.web.atuowired;

import com.jinaiyuan.web.atuowired.advanced.MagicBean;
import com.jinaiyuan.web.atuowired.advanced.MagicExistsCondition;
import com.jinaiyuan.web.atuowired.component.CDPlayer;
import com.jinaiyuan.web.atuowired.component.SgtPeppers;
import com.jinaiyuan.web.atuowired.protocol.MediaPlayer;
import org.springframework.context.annotation.*;

/**
 * @Import()告知Spring容器两个Config类之间的关联。
 */

//自动扫描和装配Bean,默认情况下Bean都是单例的
@Configuration
//默认扫描本类相同包名以及子包下的@Component类,还可以指定待扫描的Component的包名
@ComponentScan("com.jinaiyuan.web.atuowired")
public class CDPlayerConfig {
    //JavaConfig的方式使用依赖注入。优先使用自动扫描，但是有时候无法避免使用JavaConfig，因为需要注入的是第三方类
    @Bean
    @Profile("prod")
    public MediaPlayer getMediaPlayer() {
        return new CDPlayer(new SgtPeppers());
    }


    //条件化创建Bean,执行实现了Condition接口的类的matches()方法，方法返回true时，创建Bean
    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }
}

