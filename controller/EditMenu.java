package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

import models.Constants.EEditMenu;

public class EditMenu extends JMenu {
    private static final long serialVersionUID = 1L;

    private EditorArea editorArea;

    public EditMenu(String title) {
        super(title);

        KeyStroke key;

        ActionHandler actionHandler = new ActionHandler();
        for (EEditMenu eEditMenu : EEditMenu.values()) {
            JMenuItem EditMenu = new JMenuItem(eEditMenu.getLabel());
            EditMenu.setActionCommand(eEditMenu.name());

            if(eEditMenu.equals(eEditMenu.eUndo)) {
                EditMenu.setMnemonic(KeyEvent.VK_Z);
                key = KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK);
                EditMenu.setAccelerator(key);
            }

            if(eEditMenu.equals(eEditMenu.eRedo)) {
                EditMenu.setMnemonic(KeyEvent.VK_Y);
                key = KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK);
                EditMenu.setAccelerator(key);
            }

            if(eEditMenu.equals(eEditMenu.eDeleteOne)) {
                EditMenu.setMnemonic(KeyEvent.VK_X);
                key = KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK);
                EditMenu.setAccelerator(key);
            }

            if(eEditMenu.equals(eEditMenu.eCopy)) {
                EditMenu.setMnemonic(KeyEvent.VK_C);
                key = KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK);
                EditMenu.setAccelerator(key);
            }

            if(eEditMenu.equals(eEditMenu.ePaste)) {
                EditMenu.setMnemonic(KeyEvent.VK_V);
                key = KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK);
                EditMenu.setAccelerator(key);
            }

            if(eEditMenu.equals(eEditMenu.eGroup)) {
                EditMenu.setMnemonic(KeyEvent.VK_A);
                key = KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK);
                EditMenu.setAccelerator(key);
            }

            if(eEditMenu.equals(eEditMenu.eUnGroup)) {
                EditMenu.setMnemonic(KeyEvent.VK_G);
                key = KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK);
                EditMenu.setAccelerator(key);
            }

            EditMenu.addActionListener(actionHandler);
            this.add(EditMenu); // 자식으로 등록한다는 것은 무슨 뜻인지 나중에 설명
        }

    }

    public void associate(EditorArea editorArea) {
        this.editorArea = editorArea;
    }

    public void initialize() {

    }

    // 실행취소
    public void undo() {
        this.editorArea.undoShape();
    }

    // 다시 실행
    public void redo() {
        this.editorArea.redoShape();
    }

    // 전체 삭제하기
    public void delete() {
        int result = JOptionPane.showConfirmDialog(null, "전체삭제 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.editorArea.clearShapes();
            JOptionPane.showMessageDialog(null, "전체삭제 되었습니다.");
            this.editorArea.setUpdated(false);
        } else {
            JOptionPane.showMessageDialog(null, "전체삭제가 취소되었습니다.");
        }
    }

    // 복사하기
    public void copy() {
        this.editorArea.copy();
    }

    public void paste() {
        this.editorArea.paste();
    }

    // 삭제하기
    public void deleteOne() {
        this.editorArea.delete();
    }

    public void groupAll() {
        this.editorArea.groupAll();
    }

    public void unGroup() {
        this.editorArea.unGroup();
    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(EEditMenu.eUndo.name())) { // Undo : 맨 처음 상태 (아예 지우기)
                undo();
            } else if (e.getActionCommand().equals(EEditMenu.eRedo.name())) { // 그 전 상태
                redo();
            } else if (e.getActionCommand().equals(EEditMenu.eDelete.name())) {
                delete();
            } else if (e.getActionCommand().equals(EEditMenu.eCopy.name())) {
                copy();
            } else if (e.getActionCommand().equals(EEditMenu.ePaste.name())) {
                paste();
            } else if (e.getActionCommand().equals(EEditMenu.eDeleteOne.name())) {
                deleteOne();
            } else if(e.getActionCommand().equals(EEditMenu.eGroup.name())) {
                groupAll();
            }else if(e.getActionCommand().equals(EEditMenu.eUnGroup.name())) {
                unGroup();
            }
        }
    }

}