package com.MiFrame.element;

import com.MiFrame.ui.MainFrame;

import javax.swing.*;

public class MiButton extends JButton {
    public MiButton() {
        Init();
    }

    public MiButton(String title) {
        super(title);

        Init();
    }

    public MiButton(Icon icon) {
        super(icon);

        Init();
    }

    private void Init() {
        setFont(MainFrame.getNotoSans(14));
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }
}