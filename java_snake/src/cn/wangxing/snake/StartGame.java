package cn.wangxing.snake;

import cn.wangxing.snake.utils.GameContext;

import javax.swing.*;

public class StartGame {

    /**
     * 程序入口类
     */
    public static void main(String[] args) {

        JFrame frame = GameContext.frame;

        JPanel mainPanle = GameContext.panel;

        frame.add(mainPanle);
        frame.setVisible(true);//是否显示

        /*
         * 创建线程实时刷新界面
         */
        Thread flashThread = new Thread(){
            @Override
            public void run() {
            while(true) {
                mainPanle.repaint();
                GameContext.snake.sport();

                //限制刷新间隔
                try {Thread.sleep((long) (200));} catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
            }
        };
        flashThread.start();
    }
}