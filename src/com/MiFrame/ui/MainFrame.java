package com.MiFrame.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Rectangle maxBounds;

    private WorkPane wp;
    private Sidebar side;

    public final static int EditorMode = 1;
    public final static int DesignerMode = 2;


    private static int Mode = DesignerMode;

    protected final static FlowLayout GapLessFlowLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);

    public MainFrame() {
        wp = new WorkPane();
        side = new Sidebar(this);

        add(wp




















                , BorderLayout.CENTER);
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

    public static Font getNotoSans(int size) {
        return new Font("Noto Sans KR", Font.PLAIN, size);
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
