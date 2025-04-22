package com.example.adapterdesignpattern;

public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public String play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            return "Playing mp3 file: " + fileName;
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            return mediaAdapter.play(audioType, fileName);
        } else {
            return "Invalid media. " + audioType + " format not supported";
        }
    }
}