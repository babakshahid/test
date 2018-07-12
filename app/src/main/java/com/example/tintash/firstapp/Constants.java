package com.example.tintash.firstapp;

public class Constants {
    public interface ACTION{
        public static String MAIN_ACTION = "com.example.tintash.firstapp.action.main";
        public static String PREV_ACTION = "com.example.tintash.firstapp.action.prev";
        public static String PLAY_ACTION = "com.example.tintash.firstapp.action.play";
        public static String PAUSE_ACTION = "com.example.tintash.firstapp.action.pause";
        public static String NEXT_ACTION = "com.example.tintash.firstapp.action.next";
        public static String STARTFOREGROUND_ACTION = "com.example.tintash.firstapp.action.startforeground";
        public static String STOPFOREGROUND_ACTION = "com.example.tintash.firstapp.action.stopforeground";
        public static String TOTAL_COUNT = "total_count";
    }
    public interface NOTIFICATION_ID {
        public static int FOREGROUND_SERVICE = 101;
    }
}
