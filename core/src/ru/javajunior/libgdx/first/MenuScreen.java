package ru.javajunior.libgdx.first;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Экран меню.
 */
public class MenuScreen extends ScreenAdapter{

    /**
     * Сцена. Содержит управляет всем что имеется на экране.
     */
    private Stage stage;

    private Actor button;

    /**
     * Создает и инициализирует экран меню
     */
    public MenuScreen() {
        // Инициализирует сцену
        this.stage = new Stage() {
            /** Вызывается при прикосновении к сенсорному экрану и нажатии на кнопку мыши.
             * Параметр button должен быть {@link com.badlogic.gdx.Input.Buttons#LEFT} для
             * Android и iOS.
             * @param screenX Координата по оси x, от левого верхнего угла.
             * @param screenY Координата по оси y, от левого верхнего угла.
             * @param pointer идентификатор события. Если экран поддерживает мультитач,
             *                то у разных прикосновений будут разные идентификаторы.
             * @param button кнопка мыши, которая была нажата. Для сенсорного экрана будет Buttons.LEFT
             * @return было ли событие обработано */
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                return super.touchDown(screenX, screenY, pointer, button);
            }
        };
        stage.addActor(button = new Actor(){
            {
                // Устанавливает размеры актера. Размеры актера ограничивают область ввода с
                // помощью мыши и сенсорного эрана.
                setSize(130, 40);
            }
            // Инициализирует спрайт куском тестуры, огрниченным координатами
            // x=57, y=10 от левого верхнего угла текстуры и размерами (130, 40)
            Sprite actorSprite = new Sprite(Game.getInstance().getTexture(), 57, 10, (int)getWidth(), (int)getHeight());
            // Отрисовывает актера. Дергается при вызове метода draw у сцены
            // (или или другого контейнера, который содержит текущего актера).
            @Override
            public void draw(Batch batch, float parentAlpha) {
                actorSprite.draw(batch, parentAlpha);
            }
        });
        button.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Game.getInstance().showScreensaver();
                return true;
            }
        });
    }

    /**
     * Вызывается, когда экран становится акитвным.
     */
    @Override
    public void show() {
        // Устанавлиаем обработчик событий ввода
        Gdx.input.setInputProcessor(stage);
    }

    /**
     * Этот метод вызывается каждый кадр отрисовки.
     * Частота его вызова непостоянна - FPS может "прыгать".
     * @param delta - время в секундах с момента последней отрисовки.
     */
    @Override
    public void render(float delta) {
        // Очистка экрана - вызов OpenGL функций.
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Отрисовываем сцену (точнее все объекты привязанные к ней).
        stage.draw();
    }

}
