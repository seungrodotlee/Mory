package com.MiFrame.ui;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Editor {
    private RSyntaxTextArea textArea;
    private RTextScrollPane sp;

    public Editor() {
        textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);

        sp = new RTextScrollPane(textArea);
        sp.setBorder(null);
    }

    protected RTextScrollPane getPane() {
        return sp;
    }

    protected void setVisible(boolean b) {
        if(b) {
            sp.setVisible(true);
        } else {
            sp.setVisible(false);
        }
    }
}
