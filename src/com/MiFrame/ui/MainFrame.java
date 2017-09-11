package com.MiFrame.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Sidebar side;

    //1 = 에디터 모드, 2 = 디자이너 모드
    private static int Mode = 2;
    protected static FlowLayout GapLessFlowLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);

    public MainFrame() {
        side = new Sidebar();

        add(side, BorderLayout.EAST);
        Init();
    }

    private void Init() {
        setSize(800, 500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    public static Font getNotoSans(int size) {
        return new Font("Noto Sans KR", Font.PLAIN, size);
    }
}
