package ru.javajunior.libgdx.first;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

/**
 * Экран меню.
 */
public class MenuScreen extends ScreenAdapter{
    @Override
    public void render(float delta) {
        // Очистка экрана - вызов OpenGL функций.
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
