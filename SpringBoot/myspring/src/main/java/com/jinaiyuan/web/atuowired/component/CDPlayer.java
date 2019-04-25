package com.jinaiyuan.web.atuowired.component;

import com.jinaiyuan.web.atuowired.protocol.CompactDisc;
import com.jinaiyuan.web.atuowired.protocol.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;

    @Autowired
    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    // 依赖的字段不是必须的
    @Autowired(required = false)
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }
}
