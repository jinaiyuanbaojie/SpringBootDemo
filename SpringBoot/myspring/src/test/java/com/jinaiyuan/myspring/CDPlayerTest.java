package com.jinaiyuan.myspring;

import com.jinaiyuan.web.atuowired.CDPlayerConfig;
import com.jinaiyuan.web.atuowired.protocol.CompactDisc;
import com.jinaiyuan.web.atuowired.protocol.MediaPlayer;
import com.jinaiyuan.web.atuowired.component.SgtPeppers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
@ActiveProfiles("test")
public class CDPlayerTest {
    @Autowired
    private CompactDisc compactDisc;
    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void cdShouldNotBeNull() {
        if (compactDisc instanceof SgtPeppers) {
            System.out.println("Hello world.");
        }
        compactDisc.play();
    }

    @Test
    public void testMediaPlayer() {
        mediaPlayer.play();
    }
}
