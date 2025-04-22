package com.example.adapterdesignpattern;

public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        advancedMediaPlayer = new AdvancedMediaPlayer();
    }

    @Override
    public String play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            return advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            return advancedMediaPlayer.playMp4(fileName);
        } else {
            return "Invalid format";
        }
    }
}