package cn.wangxing.snake.utils;

import cn.wangxing.snake.domain.Food;
import cn.wangxing.snake.domain.GamePoint;
import cn.wangxing.snake.domain.Snake;
import cn.wangxing.snake.view.GameFrame;
import cn.wangxing.snake.view.GamePanel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;


public class GameContext {
    public static GameFrame    frame;
    public static GamePanel    panel;
    public static Snake        snake;
    public static List<Food>   foodList;
    public static Properties   gameProperties;

    public static int   fengshu;

    //设置项
    public static int  snake_length_init;
    public static int  map_width_init;
    public static int  map_height_init;
    public static int  food_number_init;
    public static int  point_length;

    static {
        // 加载配置文件
        gameProperties = new Properties();
        try {
            gameProperties.load(GameContext.class.getResourceAsStream("/snake.properties"));
            snake_length_init = Integer.valueOf(gameProperties.getProperty("snake_length_init"));
            map_width_init =    Integer.valueOf(gameProperties.getProperty("map_width_init"));
            map_height_init =   Integer.valueOf(gameProperties.getProperty("map_height_init"));
            food_number_init =  Integer.valueOf(gameProperties.getProperty("food_number_init"));
            point_length =  Integer.valueOf(gameProperties.getProperty("point_length"));
        } catch (IOException e) {
            System.out.println("读取配置文件发生异常\r\n"+e);
        }


        //创建视图
        int frame_width = map_width_init*point_length;
        int frame_height= map_height_init*point_length;
        frame = new GameFrame().init(800,300,frame_width,frame_height);
        panel = new GamePanel().init(0,0,frame_width,frame_height);
        snake = new Snake().init(snake_length_init,point_length);

        fengshu = 0;

        //初始化食物集合
        foodList = new ArrayList<Food>();
        Random r = new Random();
        List<GamePoint> bodyList = snake.getBodyList();
        for(int i=0; i<food_number_init; ){
            Food food = new Food();
            food.setX( r.nextInt(map_width_init)*point_length  );
            food.setY( r.nextInt(map_width_init)*point_length  );
            food.setWidth(point_length);
            food.setHeight(point_length);

            // 如果于蛇身重合则不添加
            for (int j = 0; j < bodyList.size(); j++) {
                if(bodyList.get(j).getX()==food.getX() && bodyList.get(j).getY()==food.getY()){
                    continue;
                }
            }
            foodList.add(food);
            i++;
        }
    }
}
