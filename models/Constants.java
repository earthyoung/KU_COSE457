package models;

import javax.swing.*;
import java.awt.*;

public class Constants {

    public enum ETransformationStyle{
        e2point,
        eNpoint
    }

    public enum ETools{
        eSelection("선택",new TSelection(),"Selection Tool", ETransformationStyle.e2point),
        eRectangle("네모",new TRectangle(),"네모", ETransformationStyle.e2point),
        eOval("동그라미" ,new TEllipse(),"동그라미", ETransformationStyle.e2point),
        eLine("선",new TLine(),"선", ETransformationStyle.e2point);

        private String label;
        private TShape tool;
        private String toolTip;
        private ETransformationStyle eTransformationStyle;

        private ETools(String lable, TShape tool, String toolTip, ETransformationStyle eTransformationStyle) {
            this.label = lable;
            this.tool = tool;
            this.toolTip = toolTip;
            this.eTransformationStyle = eTransformationStyle;
        }

        public TShape newShape() {
            return this.tool.clone();
        }

        public String getLabel() {
            return this.label;
        }

        public String getToolTip() {
            return this.toolTip;
        }

        public ETransformationStyle getETransformationStyle() {
            return this.eTransformationStyle;
        }
    }

    public enum EFileMenu{
        eNew("새로만들기"),
        eOpen("열기"),
        eSave("저장"),
        eSaveAs("다른이름으로 저장하기"),
        eQuit("종료"),
        eImg("이미지 추가");

        private String getLabel;

        private EFileMenu(String lable) {
            this.getLabel = lable;
        }

        public String getLabel() {
            return this.getLabel;
        }

    }

    public enum EEditMenu{
        eUndo("실행 취소"),
        eRedo("다시 실행"),
        eCopy("복사하기"),
        ePaste("붙여넣기"),
        eGroup("전체 그룹묶기"),
        eUnGroup("그룹취소하기");

        private String getLabel;

        private EEditMenu(String lable) {
            this.getLabel = lable;
        }

        public String getLabel() {
            return this.getLabel;
        }
    }

    public enum EColorMenu{
        Red("RED",Color.RED,new ImageIcon("./Image/red.png")),
        ORANGE("ORANGE", Color.ORANGE,new ImageIcon("./Image/orange.png")),
        YELLOW("YELLOW", Color.YELLOW,new ImageIcon("./Image/yellow.png")),
        GREEN("GREEN", Color.GREEN,new ImageIcon("./Image/green.png")),
        Blue("BLUE",Color.BLUE,new ImageIcon("./Image/blue.png")),
        PINK("PINK", Color.PINK,new ImageIcon("./Image/pink.png")),
        BLACK("BLACK", Color.BLACK,new ImageIcon("./Image/black.png")),
        WHITE("WHITE", Color.WHITE,new ImageIcon("./Image/white.png"));

        private String getLabel;
        private Color getColor;
        private ImageIcon img;

        private EColorMenu(String lable, Color color,ImageIcon img) {
            this.getLabel = lable;
            this.getColor = color;
            this.img = img;
        }

        public String getLabel() {
            return this.getLabel;
        }

        public Color getColor() {
            return this.getColor;
        }

        public ImageIcon getImg() {
            Image image = this.img.getImage();  //ImageIcon을 Image로 변환
            Image newImage = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newImageIcon = new ImageIcon(newImage);
            return newImageIcon;
        }
    }

}