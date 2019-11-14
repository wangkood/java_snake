package cn.wangxing.snake.listener;

import cn.wangxing.snake.utils.GameContext;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {    //按下按键
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case 87:
            case 104:
            case 38:
                GameContext.snake.setDirection('U');
                break;
            case 83:
            case 98:
            case 40:
                GameContext.snake.setDirection('D');
                break;
            case 65:
            case 100:
            case 37:
                GameContext.snake.setDirection('L');
                break;
            case 68:
            case 102:
            case 39:
                GameContext.snake.setDirection('R');
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {   //释放按键

    }
}
