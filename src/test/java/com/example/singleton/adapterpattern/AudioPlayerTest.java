package com.example.singleton.adapterpattern;

import com.example.adapterdesignpattern.AudioPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudioPlayerTest {

    private AudioPlayer audioPlayer;

    @BeforeEach
    void setUp() {
        audioPlayer = new AudioPlayer();
    }

    @Test
    void testMp3Playback() {
        String result = audioPlayer.play("mp3", "song.mp3");
        assertEquals("Playing mp3 file: song.mp3", result);
    }

    @Test
    void testMp4Playback() {
        String result = audioPlayer.play("mp4", "movie.mp4");
        assertEquals("Playing mp4 file: movie.mp4", result);
    }

    @Test
    void testVlcPlayback() {
        String result = audioPlayer.play("vlc", "concert.vlc");
        assertEquals("Playing vlc file: concert.vlc", result);
    }

    @Test
    void testInvalidFormat() {
        String result = audioPlayer.play("avi", "clip.avi");
        assertEquals("Invalid media. avi format not supported", result);
    }
}
