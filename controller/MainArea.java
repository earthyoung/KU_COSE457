package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainArea extends JFrame {
    private static final long serialVersionUID = 1L;

    private MenuBar menuBar;
    private ToolBar toolBar;

    private static MainArea instance;
    private EditorArea editorArea;

    private MainArea() {
        this.addWindowListener(new JFrameWindowClosingEventHandler());

        // 속성
        this.setSize(900, 600);
        this.setTitle("Graphics Editor");
        this.setLocationRelativeTo(null);

        // 자식
        BorderLayout layoutManager = new BorderLayout();  // JFrame의 레이아웃
        this.setLayout(layoutManager);

        this.menuBar = new MenuBar();
        this.setJMenuBar(this.menuBar);

        this.toolBar = new ToolBar();
        this.add(toolBar, layoutManager.NORTH);

        this.editorArea = EditorArea.getInstance();
        this.add(editorArea, layoutManager.CENTER);

        this.menuBar.associate(this.editorArea);
        this.toolBar.associate(this.editorArea);
    }

    public static MainArea getInstance() {
        if (instance == null) {
            instance = new MainArea();
        }
        return instance;
    }

    public void initialize() { // new 다음에 무조건
        this.menuBar.initialize();
        this.toolBar.initialize();
        this.editorArea.initialize();
    }

    public void handleClosing() {
        if (this.editorArea.isUpdated() != false) {
            int answer = showWarningMessage();
            switch (answer) {
                case JOptionPane.YES_OPTION:
                    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    break;
                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(null, "창을 종료합니다.");
                    dispose();
                    break;
                case JOptionPane.CANCEL_OPTION:
                    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "창을 종료합니다.");
            dispose();
        }
    }

    private int showWarningMessage() {
        String[] buttonLabels = new String[] {"Yes", "No", "Cancel"};
        String defaultOption = buttonLabels[0];
        Icon icon = null;

        return JOptionPane.showOptionDialog(this,
                "저장되지 않은 그림이 있습니다.\n" +
                        "저장을 하고 지우시겠습니까?",
                "Warning",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                icon,
                buttonLabels,
                defaultOption);
    }


    class JFrameWindowClosingEventHandler extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            handleClosing();
        }
    }

}