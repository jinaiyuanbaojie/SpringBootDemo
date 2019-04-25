package com.jinaiyuan.web.atuowired.component;

import com.jinaiyuan.web.atuowired.protocol.CompactDisc;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//可以被Spring容器扫描发现的Bean,内部字符串为Bean的id,用于替换默认的id值"sgtPeppers".
@Component("lonelyHeartsClub")
//每次都新建Bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SgtPeppers implements CompactDisc {
    @Override
    public void play() {
        System.out.println("Playing the Beatles..");
    }
}
