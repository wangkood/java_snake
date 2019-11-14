package cn.wangxing.snake.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * 鼠标拖动事件
 *      可以使用鼠标拖动窗口
 */
public class MoveFrameListener implements MouseMotionListener {

    //鼠标拖动开始坐标，基准为frame
    Point startPoint = new Point();
    @Override
    public void mouseDragged(MouseEvent e) { //当鼠标点击并拖动时触发此方法
       // System.out.println(  startPoint+"  "+startPoint.y+"");
        JFrame frame = (JFrame)e.getSource();
        frame.setLocation(e.getX()+frame.getX()-startPoint.x,e.getY()+frame.getY()-startPoint.y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {  ////当鼠标在界面移动时时触发此方法
        startPoint.x = e.getX();
        startPoint.y = e.getY();
    }
}
