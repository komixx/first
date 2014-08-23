package ru.javajunior.libgdx.first;

/**
 * Основной класс, расширяет класс com.badlogic.gdx.Game реализующий интерфейс ApplicationListener.
 * В игре должен быть по крайней игре один класс, который реализует такой интерфейс.
 * com.badlogic.gdx.Game предоставляет реализацию работы с экранами по умолчанию.
 */
public class Game extends com.badlogic.gdx.Game {

    private static Game game;
    private ScreensaverScreen screensaverScreen;
    private MenuScreen menuScreen;

    private Game() {
    }

    public static synchronized Game getInstance(){
        if (game == null){
            game = new Game();
        }
        return game;
    }

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

    public void showMenu() {
        setScreen(menuScreen);
    }

    public void showScreensaver() {
        setScreen(screensaverScreen);
    }
}
