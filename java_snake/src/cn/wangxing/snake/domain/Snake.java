package cn.wangxing.snake.domain;

import cn.wangxing.snake.utils.GameContext;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Snake {
    private LinkedList<GamePoint> bodyList = new LinkedList<>();

    private char direction = 'U'; // Up R D L




    public Snake init(int snake_length_init,int point_length){
        for(int x = 0; x< snake_length_init*point_length; x+=point_length){
            bodyList.addLast(new GamePoint(GameContext.map_width_init/2*GameContext.point_length+x,point_length*(GameContext.map_height_init/2),point_length,point_length));
        }
        return this;
    }


    public GamePoint getHead(){
        return bodyList.getFirst();
    }

    public void setDirection(char newDirection){
        switch (newDirection){
            case 'U':
                this.direction =   direction=='D' ?  'D' : 'U';
                break;
            case 'D':
                this.direction =   direction=='U' ?  'U' : 'D';
                break;
            case 'L':
                this.direction =   direction=='R' ?  'R' : 'L';
                break;
            case 'R':
                this.direction =   direction=='L' ?  'L' : 'R';
                break;
        }
    }

    //每执行一次，前进一格
    public void sport(){
        GamePoint oldFoot = GameContext.snake.bodyList.get( bodyList.size()-1) ;
        GamePoint oldHead = bodyList.getFirst();
        GamePoint newHead = new GamePoint();
        newHead.setSize(GameContext.point_length,GameContext.point_length);
        switch (direction){
            case 'U':
                newHead.setLocation(oldHead.getX(),oldHead.getY()-GameContext.point_length);
                isEatOwn(newHead);
                if(oldHead.getY() < (0+1)*GameContext.point_length){
                    System.out.println("--|GAME OVER|--");
                    System.exit(0);
                }
                bodyList.removeLast();
                bodyList.addFirst(newHead);
                break;

            case 'D':
                newHead.setLocation(oldHead.getX(),oldHead.getY()+GameContext.point_length);
                isEatOwn(newHead);
                if(oldHead.getY() >= (GameContext.map_height_init-1)*GameContext.point_length){
                    System.out.println("--|GAME OVER|--");
                    System.exit(0);
                }
                bodyList.removeLast();
                bodyList.addFirst(newHead);
                break;

            case 'L':
                newHead.setLocation(oldHead.getX()-GameContext.point_length,oldHead.getY());
                isEatOwn(newHead);
                if(oldHead.getX() < (0+1)*GameContext.point_length){
                    System.out.println("--|GAME OVER|--");
                    System.exit(0);
                }
                bodyList.removeLast();
                bodyList.addFirst(newHead);
                break;

            case 'R':
                newHead.setLocation(oldHead.getX()+GameContext.point_length,oldHead.getY());
                isEatOwn(newHead);
                if(oldHead.getX() >= (GameContext.map_width_init-1)*GameContext.point_length){
                    System.out.println("--|GAME OVER|--");
                    System.exit(0);
                }
                bodyList.removeLast();
                bodyList.addFirst(newHead);
                break;
        }

        //判断是否吃到食物
        List<Food> foodList = GameContext.foodList;
        if( GameContext.foodList.size() != 0){
            // 遍历食物集合中元素是否和蛇头重合，
            GamePoint head = GameContext.snake.getHead();
            for(int i =0 ; i< foodList.size(); i++){
                if(head.getX() == foodList.get(i).getX() && head.getY() == foodList.get(i).getY()){
                    //删除食物
                    foodList.remove(i);

                    //将蛇长度加一
                    GameContext.snake.bodyList.getLast();
                    GameContext.snake.bodyList.addLast(oldFoot);
                    System.out.println(++GameContext.fengshu);
                }
            }
        }else{
            //添加食物 10个
            Random r = new Random();
            for(int i=0; i<GameContext.food_number_init; ){
                Food food = new Food();
                food.setX( r.nextInt(GameContext.map_width_init)*GameContext.point_length );
                food.setY( r.nextInt(GameContext.map_height_init)*GameContext.point_length );
                food.setWidth(GameContext.point_length);
                food.setHeight(GameContext.point_length);

                // 如果于蛇身重合则不添加
                List<GamePoint> bodyList = this.bodyList;
                for (int j = 0; j < bodyList.size(); j++) {
                    if(bodyList.get(i).getX()==food.getX() && bodyList.get(i).getY()==food.getY()){
                        continue;
                    }
                }

                foodList.add(food);
                i++;

            }
        }
    }

    /**
     * 是否吃到自己
     * @return
     */
    public boolean isEatOwn(GamePoint newHead){
        for(int i = 1;i<bodyList.size();i++){
            if(bodyList.get(i).getX()==newHead.getX() && bodyList.get(i).getY()==newHead.getY()){
                System.out.println("--|GAME OVER|--");
                System.exit(0);
                return true;
            }
        }
        return false;
    }

    public LinkedList<GamePoint> getBodyList() {
        return bodyList;
    }

    public void setBodyList(LinkedList<GamePoint> bodyList) {
        this.bodyList = bodyList;
    }

    public char getDirection() {
        return direction;
    }
}
