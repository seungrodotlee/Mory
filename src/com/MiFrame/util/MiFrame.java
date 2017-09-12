package com.MiFrame.util;

import com.MiFrame.ui.MainFrame;

public class MiFrame {
    private static MainFrame mf;
    public static void main(String[] args) {
        mf = new MainFrame();
    }

    public static MainFrame getMainFrame() {
        return mf;
    }
}