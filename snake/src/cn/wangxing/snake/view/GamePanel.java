package cn.wangxing.snake.view;

import cn.wangxing.snake.domain.Food;
import cn.wangxing.snake.domain.GamePoint;
import cn.wangxing.snake.utils.GameContext;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * 贪吃蛇的主panle
 */
public class GamePanel extends JPanel {

    //初始化
    public GamePanel init(int x,int y,int width,int heigth){
        //设置 位置
        //this.setLocation( 0 ,0);
        // 大小
        //this.setSize(500,500);
        this.setBounds(x,y,width,heigth);
        //背景颜色
        this.setBackground(new Color(0, 0, 0));
        return this;
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(new Color(47, 47, 47));

        //划线 shu
        for(int x = 0 ; x<=GameContext.map_width_init*GameContext.point_length; x+=GameContext.point_length){
            g.drawLine(x,0,x,GameContext.map_height_init*GameContext.point_length);
        }
        for(int y = 0 ; y<=GameContext.map_height_init*GameContext.point_length; y+=GameContext.point_length){
            g.drawLine(0,y,GameContext.map_width_init*GameContext.point_length,y);
        }

        //分数
        g.setColor(new Color(244, 3, 0));
        g.drawString("分数： "+GameContext.fengshu,10,20);

        g.setColor(new Color(255, 255, 255));


        //将蛇对象画出
        LinkedList<GamePoint> snakeBody = GameContext.snake.getBodyList();
        for(int i = snakeBody.size()-1; i>= 0;i--){
            int x = snakeBody.get(i).getX();
            int y = snakeBody.get(i).getY();
            int width = snakeBody.get(i).getWidth();
            int height= snakeBody.get(i).getHeight();

            if( i == 0){//头
                g.setColor(new Color(244, 3, 0));
                g.drawRect(x,y,width,height);
                g.setColor(new Color(0, 0, 0));
            }else {//身
                g.draw3DRect(x,y,width,height,false);
            }
        }

        //画出食物
        g.setColor(new Color(59, 255, 70));
        for( Food food : GameContext.foodList ){
            g.drawRect(food.getX(),food.getY(),food.getWidth(),food.getHeight());
        }
     }
}
