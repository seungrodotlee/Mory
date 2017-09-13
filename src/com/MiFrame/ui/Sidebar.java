package com.MiFrame.ui;

import com.MiFrame.element.MiButton;
import com.MiFrame.element.MiPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sidebar extends MiPanel {
    MainFrame parent;

    private MiPanel ButtonSection, ModeToggler, Toolbar;
    private MiButton FileMenu, FullBtn, MinBtn, CloseBtn;
    private MiButton EditorMode, DesignerMode;

    public Sidebar(Component frame) {
        parent = (MainFrame) frame;

        setLayout(MainFrame.GAPLESSFLOWLAYOUT);
        setPreferredSize(new Dimension(136, 0));
        setBorder(BorderFactory.createEmptyBorder(0, 21, 0, 0));

        ButtonSectionInit();
        ModeTogglerInit();
        ToolbarInit();
    }

    private void ButtonSectionInit() {
        Border btnSpace = BorderFactory.createEmptyBorder(0, 0, 0, 7);

        ButtonSection = new MiPanel(MainFrame.GAPLESSFLOWLAYOUT);
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

        FullBtn.addMouseListener(new FullBtnAdaptor());
        MinBtn.addMouseListener(new MinBtnAdaptor());
        CloseBtn.addMouseListener(new CloseBtnAdaptor());

        add(ButtonSection);
    }

    private void ModeTogglerInit() {
        ModeToggler = new MiPanel(MainFrame.GAPLESSFLOWLAYOUT);
        ModeToggler.setBackground(ColorPack.LIGHT_BLUE);
        ModeToggler.setBorder(BorderFactory.createMatteBorder(13, 0, 13, 21, Color.white));

        EditorMode = new MiButton(new ImageIcon("img/EditorMode_Btn_Unselected.png"));
        EditorMode.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 1));
        EditorMode.addMouseListener(new toggleToEditor());
        DesignerMode = new MiButton(new ImageIcon("img/DesignerMode_Btn_Selected.png"));
        DesignerMode.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 2));
        DesignerMode.addMouseListener(new toggleToDesigner());

        ModeToggler.add(EditorMode);
        ModeToggler.add(DesignerMode);

        add(ModeToggler);
    }

    private void ToolbarInit() {
        Toolbar = new MiPanel(MainFrame.GAPLESSFLOWLAYOUT);
        Toolbar.setPreferredSize(new Dimension(136, 0));

        add(Toolbar);
    }

    class FullBtnAdaptor extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(parent.getExtendedState() == 0) {
                parent.setExtendedState(JFrame.MAXIMIZED_BOTH);
            } else {
                parent.setExtendedState(JFrame.NORMAL);
            }
        }
    }

    class MinBtnAdaptor extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(parent.getExtendedState() == 0) {
                parent.setExtendedState(JFrame.ICONIFIED);
            } else {
                parent.setExtendedState(JFrame.NORMAL);
            }
        }
    }

    class CloseBtnAdaptor extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.exit(0);
        }
    }

    class toggleToEditor extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(MainFrame.currentMode == MainFrame.DESIGNER_MODE) {

                EditorMode.setIcon(new ImageIcon("img/EditorMode_Btn_Selected.png"));
                DesignerMode.setIcon(new ImageIcon("img/DesignerMode_Btn_Unselected.png"));

                parent.toggleMode();
            }
        }
    }

    class toggleToDesigner extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(MainFrame.currentMode == MainFrame.EDITOR_MODE) {

                EditorMode.setIcon(new ImageIcon("img/EditorMode_Btn_Unselected.png"));
                DesignerMode.setIcon(new ImageIcon("img/DesignerMode_Btn_Selected.png"));

                parent.toggleMode();
            }
        }
    }
}