package ru.javajunior.libgdx.first;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

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
     * Спрайт - та же концепция, что и у TextureRegion, но более продвинутый.
     */
    private Sprite sprite;

    /**
     * Сцена - игровое поле.
     */
    private Stage stage;

    /**
     * Actor - актер, объект, являющийся частью сцены.
     */
    private Actor actor;

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

        // Инициализируем спрайт куском рисунка тестуры, огрниченным координатами
        // x=57, y=10 от левого верхнего угла текстуры и размерами (130, 40)
        sprite = new Sprite(texture, 57, 10, 130, 40);
        sprite.setPosition(300, 150);
        sprite.setRotation(180);

        // Инициализаруем сцену, по умолчанию ей заданы размеры экрана.
        stage = new Stage();

        // Инициализируем актера
        actor = new Actor(){

            // Инициализируем спрайт куском рисунка тестуры, огрниченным координатами
            // x=57, y=10 от левого верхнего угла текстуры и размерами (130, 40)
            Sprite actorSprite = new Sprite(texture, 57, 10, 130, 40);

            // Производит изменения над актером, которые должны были с ним произойти
            // с момента последней отрисовки. Дергается при вызове метода act у сцены
            // (или или другого контейнера, который содержит текущего актера).
            @Override
            public void act(float delta) {
                actorSprite.setPosition(300, 50);
                actorSprite.setRotation(actorSprite.getRotation() + delta);
            }

            // Отрисовывает актера. Дергается при вызове метода draw у сцены
            // (или или другого контейнера, который содержит текущего актера).
            @Override
            public void draw(Batch batch, float parentAlpha) {
                actorSprite.draw(batch, parentAlpha);
            }

        };

        // Добавляем актера к сцене (привязываем объект к сцене).
        stage.addActor(actor);
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
        // Указываем отрисовать регион текстуры в координатах x=300 y=200 от левого
        // нижнего угла экрана.
        spriteBatch.draw(textureRegion, 300, 210);
        // Указываем отрисовать спрайт в координатах x=300 y=200 от левого
        // нижнего угла экрана.
        sprite.draw(spriteBatch);
        spriteBatch.end();

        // Производим изменение сцены, будет вызван метод act у всех привязанных
        // к сцене объектов. В качестве параметра ожидается время в сек с момента
        // последней отрисовки сцены.
        stage.act(Gdx.graphics.getDeltaTime());
        // Отрисовываем сцену (точнее все объекты привязанные к ней).
        stage.draw();
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
