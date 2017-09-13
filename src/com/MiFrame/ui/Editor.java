package com.MiFrame.ui;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rtextarea.RTextScrollPane;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class Editor {
    private RSyntaxTextArea textArea;
    private RTextScrollPane sp;
    private Timer t = new Timer();

    public Editor() {
        textArea = new RSyntaxTextArea(20, 60);

        setInit();

        textArea.addKeyListener(new AutoCloseParen());

        sp = new RTextScrollPane(textArea);
        sp.setBorder(null);
    }

    protected RTextScrollPane getPane() {
        return sp;
    }

    private void setInit() {
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        textArea.setFont(MainFrame.getD2Coding(12));
        textArea.setAntiAliasingEnabled(true);
        textArea.setBracketMatchingEnabled(true);

        SyntaxScheme scheme = textArea.getSyntaxScheme();
        scheme.getStyle(Token.RESERVED_WORD).background = Color.pink;
        scheme.getStyle(Token.DATA_TYPE).foreground = Color.blue;
        scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).underline = true;
        scheme.getStyle(Token.COMMENT_EOL).font = new Font("D2Coding",
                Font.ITALIC, 12);

        textArea.revalidate();
    }

    private int cursorPosition;

    class AutoCloseParen extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            cursorPosition = textArea.getCaretPosition();

            if((e.getModifiers() & 1) != 0){
                if(e.getKeyCode() == 57) {
                    TimerTask tt = new TimerTask() {

                        @Override
                        public void run() {
                            textArea.setText(textArea.getText() + ")");
                            textArea.setCaretPosition(cursorPosition + 1);
                        }
                    };

                    t.schedule(tt, 5);
                }
            }
        }
    }
}
