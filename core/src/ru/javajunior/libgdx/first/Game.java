package ru.javajunior.libgdx.first;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Основной класс, реализует интерфейс ApplicationListener.
 * В игре должен быть по крайней игре один класс, который реализует такой интерфейс.
 */
public class Game extends ApplicationAdapter {

    /**
     * Отрисовщик спрайтов, умеет рисовать картинки в нужном размере и в нужных местах.
     */
	private SpriteBatch spriteBatch;

    /**
     * Текстура. Это картинка, база для графической части игры. Игра может
     * содержать множество текстур.
     */
	private Texture texture;

    /**
     * Регион текстуры - предназначен для работы с частью текстуры.
     */
    private TextureRegion textureRegion;

    /**
     * Метод, который инициализирует игру. Этот метод вызывается самым первым,
     * его основная задача - подготовить необходимые ресурсы.
     */
    @Override
	public void create () {
        spriteBatch = new SpriteBatch();
        // Инициализируем текстуру графическим файлом.
        texture = new Texture("badlogic.jpg");
        // Инициализируем регион куском рисунка тестуры, огрниченным координатами
        // x=57, y=10 от левого верхнего угла текстуры и размерами (130, 40)
        textureRegion = new TextureRegion(texture, 57, 10, 130, 40);
	}

    /**
     * Этот метод вызывается каждый кадр отрисовки.
     * Частота его вызова непостоянна - FPS может "прыгать".
     */
    @Override
	public void render () {
        // Очистка экрана - вызов OpenGL функций.
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        // Указываем отрисовать текстуру полностью в координатах x=0 y=0 от левого
        // нижнего угла экрана.
        spriteBatch.draw(texture, 0, 0);
        // Указываем отрисовать часть текстуры в координатах x=300 y=200 от левого
        // нижнего угла экрана.
        spriteBatch.draw(textureRegion, 300, 210);
        spriteBatch.end();
	}

    /**
     * Вызывается, когда сворачиваем приложение или поступает звонок.
     * Также он вызывается перед закрытием игры на всех платформах.
     */
    @Override
    public void pause() {
    }

    /**
     * Вызывается, когда разворачиваем уже запущенное приложение.
     */
    @Override
    public void resume() {
    }

    /**
     * Этот метод вызывается, когда игра закрывается.
     * Здесь необходимо освободить ресурсы,
     * которые не собираются сборщиком мусора.
     */
    @Override
    public void dispose() {
        spriteBatch.dispose();
        texture.dispose();
    }
}
