package com.example.adapterdesignpattern;

public class AdvancedMediaPlayer {
    public String playMp4(String fileName) {
        return "Playing mp4 file: " + fileName;
    }

    public String playVlc(String fileName) {
        return "Playing vlc file: " + fileName;
    }
}