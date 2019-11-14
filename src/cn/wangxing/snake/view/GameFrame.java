package cn.wangxing.snake.view;

import cn.wangxing.snake.listener.GameKeyListener;
import cn.wangxing.snake.listener.MoveFrameListener;

import javax.swing.*;

/**
 * 贪吃蛇主窗口
 */
public class GameFrame extends JFrame {

    //初始化
    public GameFrame init(int x,int y,int width,int heigth){
        //设置点击关闭按钮默认事件
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置宽高
        //this.setSize(500,500);

        //设置基于显示器坐标
        //this.setLocation(800,300);
        this.setBounds(x,y,width,heigth);

        //是否关闭标题栏显示
        this.setUndecorated(true);

        //是否允许调整大小
        this.setResizable(false);

        //添加鼠标拖动事件
        this.addMouseMotionListener(new MoveFrameListener());

        //添加键盘监听
        this.addKeyListener(new GameKeyListener());

        //布局
        this.setLayout(null);

        //背景颜色
        // frame.setBackground(new Color(55,55,55));

        return this;
    }
}
