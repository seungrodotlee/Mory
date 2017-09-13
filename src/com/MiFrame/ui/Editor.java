package com.MiFrame.ui;

import org.fife.ui.rsyntaxtextarea.*;
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
        textArea.setBracketMatchingEnabled(true)

        SyntaxScheme scheme = textArea.getSyntaxScheme();
        scheme.getStyle(Token.COMMENT_DOCUMENTATION).foreground = ColorPack.COMMENT;
        scheme.getStyle(Token.COMMENT_EOL).foreground = ColorPack.COMMENT;
        scheme.getStyle(Token.COMMENT_KEYWORD).foreground = ColorPack.COMMENT;
        scheme.getStyle(Token.COMMENT_MARKUP).foreground = ColorPack.COMMENT;
        scheme.getStyle(Token.COMMENT_MULTILINE).foreground = ColorPack.COMMENT;
        scheme.getStyle(Token.DATA_TYPE).foreground = ColorPack.DATA_TYPE;
        scheme.getStyle(Token.ERROR_CHAR).foreground = ColorPack._UNF;
        scheme.getStyle(Token.ERROR_STRING_DOUBLE).foreground = ColorPack._UNF;
        scheme.getStyle(Token.FUNCTION).foreground = ColorPack.FUNCTION;
        scheme.getStyle(Token.IDENTIFIER).foreground = ColorPack.IDENTIFIER;
        scheme.getStyle(Token.LITERAL_BOOLEAN).foreground = ColorPack.NUM;
        scheme.getStyle(Token.LITERAL_CHAR).foreground = ColorPack.STRING;
        scheme.getStyle(Token.LITERAL_NUMBER_DECIMAL_INT).foreground = ColorPack.STRING;
        scheme.getStyle(Token.LITERAL_NUMBER_FLOAT).foreground = ColorPack.NUM;
        scheme.getStyle(Token.LITERAL_NUMBER_HEXADECIMAL).foreground = ColorPack.NUM;
        scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).foreground = ColorPack.STRING;
        scheme.getStyle(Token.NULL).foreground = ColorPack.STRING;
        scheme.getStyle(Token.RESERVED_WORD).foreground = ColorPack.DATA_TYPE;
        textArea.setSyntaxScheme(scheme);

        textArea.revalidate();
    }

    private int cursorPosition;
    private String front, end;

    class AutoCloseParen extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            front = "";
            end = "";

            if((e.getModifiers() & 1) != 0){
                if(e.getKeyCode() == 57) {
                    cursorPosition = textArea.getCaretPosition();

                    TimerTask tt = new TimerTask() {

                        @Override
                        public void run() {
                            front = textArea.getText().substring(0, cursorPosition + 1);
                            if(textArea.getText().length() > cursorPosition + 2) {
                                end = textArea.getText().substring(cursorPosition + 2);
                            }

                            textArea.setText(front + ")\n" + end);
                            textArea.setCaretPosition(cursorPosition + 1);
                        }
                    };

                    t.schedule(tt, 5);
                }
            }
        }
    }
}
