package com.MiFrame.ui;

import com.MiFrame.element.MiButton;
import com.MiFrame.element.MiPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Sidebar extends MiPanel {
    private MiPanel ButtonSection, ModeToggler, Toolbar;
    private MiButton FileMenu, FullBtn, MinBtn, CloseBtn;
    private MiButton EditorMode, DesignerMode;

    public Sidebar() {
        setLayout(MainFrame.GapLessFlowLayout);
        setPreferredSize(new Dimension(136, 0));
        ButtonSectionInit();
        ModeTogglerInit();
        ToolbarInit();
    }

    private void ButtonSectionInit() {
        Border btnSpace = BorderFactory.createEmptyBorder(0, 0, 0, 7);

        ButtonSection = new MiPanel(MainFrame.GapLessFlowLayout);
        ButtonSection.setBorder(BorderFactory.createEmptyBorder(13, 0, 0, 0));

        FileMenu = new MiButton(new ImageIcon("img/File_Btn.png"));
        FileMenu.setBorder(btnSpace);
        FullBtn = new MiButton(new ImageIcon("img/Full_Btn.png"));
        FullBtn.setBorder(btnSpace);
        MinBtn = new MiButton(new ImageIcon("img/Min_Btn.png"));
        MinBtn.setBorder(btnSpace);
        CloseBtn = new MiButton(new ImageIcon("img/Close_Btn.png"));
        CloseBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 21));

        ButtonSection.add(FileMenu);
        ButtonSection.add(FullBtn);
        ButtonSection.add(MinBtn);
        ButtonSection.add(CloseBtn);

        add(ButtonSection);
    }

    private void ModeTogglerInit() {
        ModeToggler = new MiPanel(MainFrame.GapLessFlowLayout);
        ModeToggler.setBackground(ColorPack.LightBlue);
        ModeToggler.setBorder(BorderFactory.createMatteBorder(13, 0, 13, 21, Color.white));

        EditorMode = new MiButton(new ImageIcon("img/EditorMode_Btn_Unselected.png"));
        EditorMode.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 1));
        DesignerMode = new MiButton(new ImageIcon("img/DesignerMode_Btn_Selected.png"));
        DesignerMode.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 2));

        ModeToggler.add(EditorMode);
        ModeToggler.add(DesignerMode);

        add(ModeToggler);
    }

    private void ToolbarInit() {
        Toolbar = new MiPanel();

        add(Toolbar);
    }
}