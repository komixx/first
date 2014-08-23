package ru.javajunior.libgdx.first;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

/**
 * Основной класс, расширяет класс com.badlogic.gdx.Game реализующий интерфейс ApplicationListener.
 * В игре должен быть по крайней игре один класс, который реализует такой интерфейс.
 * com.badlogic.gdx.Game предоставляет реализацию работы с экранами по умолчанию.
 */
public class Game extends com.badlogic.gdx.Game {

    private ScreensaverScreen screensaverScreen;
    private MenuScreen menuScreen;

    /**
     * Метод, который инициализирует игру. Этот метод вызывается самым первым,
     * его основная задача - подготовить необходимые ресурсы.
     */
    @Override
	public void create () {
        screensaverScreen = new ScreensaverScreen();
        menuScreen = new MenuScreen();
        // Устанавливает активный экран
        setScreen(screensaverScreen);
        // Устанавлиаем обработчик событий ввода
        Gdx.input.setInputProcessor(new InputAdapter(){
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
                setScreen(menuScreen);
                return true;
            }
        });
    }

    /**
     * Этот метод вызывается каждый кадр отрисовки.
     * Частота его вызова непостоянна - FPS может "прыгать".
     */
    @Override
	public void render () {
        super.render();
	}

    /**
     * Вызывается, когда сворачиваем приложение или поступает звонок.
     * Также он вызывается перед закрытием игры на всех платформах.
     */
    @Override
    public void pause() {
        super.pause();
    }

    /**
     * Вызывается, когда разворачиваем уже запущенное приложение.
     */
    @Override
    public void resume() {
        super.resume();
    }

    /**
     * Этот метод вызывается, когда игра закрывается.
     * Здесь необходимо освободить ресурсы,
     * которые не собираются сборщиком мусора.
     */
    @Override
    public void dispose() {
        super.dispose();
        screensaverScreen.dispose();
    }
}
