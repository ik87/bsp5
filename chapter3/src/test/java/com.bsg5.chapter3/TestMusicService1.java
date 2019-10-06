package com.bsg5.chapter3;

import com.bsg5.chapter3.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

@ContextConfiguration(locations = "/config-01.xml")
public class TestMusicService1 extends AbstractTestNGSpringContextTests {
    @Autowired
    ApplicationContext context;
    @Autowired
    MusicService service;

    @Test
    public void testConfiguration() {
        assertNotNull(context);
        Set<String> definition = new HashSet<>(
                Arrays.asList(context.getBeanDefinitionNames())
        );
        assertTrue(definition.contains("musicService1"));
        for(var def : definition) {
            System.out.println(def);
        }
    }

    @Test
    public void testMusicService() {
        Song song = service.getSong("Thread Loaf", "Some Stole the Flour");
        assertEquals(song.getVotes(), 0);

    }
}
