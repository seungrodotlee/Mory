package com.MiFrame.ui;

import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Rectangle maxBounds;

    private Sidebar side;
    private Editor editor;
    private Designer designer;
    private RTextScrollPane editorPane;

    protected final static int EDITOR_MODE = 1;
    protected final static int DESIGNER_MODE = 2;
    protected final static FlowLayout GAPLESSFLOWLAYOUT = new FlowLayout(FlowLayout.CENTER, 0, 0);

    protected static int currentMode = DESIGNER_MODE;

    public MainFrame() {
        side = new Sidebar(this);
        editor = new Editor();
        designer = new Designer();
        editorPane = editor.getPane();

        add(designer, BorderLayout.CENTER);
        add(side, BorderLayout.EAST);
        Init();
    }

    private void Init() {
        setSize(800, 500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultLookAndFeelDecorated(true);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    protected void toggleMode() {
        if(currentMode == EDITOR_MODE) {
            currentMode = DESIGNER_MODE;

            remove(editorPane);
            add(designer, BorderLayout.CENTER);
        } else {
            currentMode = EDITOR_MODE;

            remove(designer);
            add(editorPane, BorderLayout.CENTER);
        }

        revalidate();
        repaint();
    }

    public static Font getNotoSans(int size) {
        return new Font("Noto Sans CJK KR", Font.PLAIN, size);
    }

    public static Font getD2Coding(int size) {
        return new Font("D2Coding", Font.PLAIN, size);
    }

    public Rectangle getMaximizedBounds()
    {
        return maxBounds;
    }

    public synchronized void setMaximizedBounds(Rectangle maxBounds)
    {
        this.maxBounds = maxBounds;
        super.setMaximizedBounds(maxBounds);
    }

    public synchronized void setExtendedState(int state)
    {
        if (maxBounds == null &&
                (state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH)
        {
            Insets screenInsets = getToolkit().getScreenInsets(getGraphicsConfiguration());
            Rectangle screenSize = getGraphicsConfiguration().getBounds();
            Rectangle maxBounds = new Rectangle(screenInsets.left + screenSize.x,
                    screenInsets.top + screenSize.y,
                    screenSize.x + screenSize.width - screenInsets.right - screenInsets.left,
                    screenSize.y + screenSize.height - screenInsets.bottom - screenInsets.top);
            super.setMaximizedBounds(maxBounds);
        }

        super.setExtendedState(state);
    }
}
