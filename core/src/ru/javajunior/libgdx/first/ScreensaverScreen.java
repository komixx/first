package ru.javajunior.libgdx.first;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Отдельный экран - Заставка.
 */
public class ScreensaverScreen implements Screen {

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
     * Группа - контейнер для нескольких актеров, позволяет управлять
     * одновременно несколькими актерами как одним целым, например перемещая,
     * масштабируя и прочее.
     */
    private Group group;

    public ScreensaverScreen() {
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
                actorSprite.setPosition(250, 50);
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

        // инициализируем группу и добавим ее к сцене
        group = new Group();
        stage.addActor(group);

        // добавим к группе пару актеров
        group.addActor(new Actor(){
            // Инициализируем спрайт куском рисунка тестуры, огрниченным координатами
            // x=57, y=10 от левого верхнего угла текстуры и размерами (130, 40)
            Sprite actorSprite = new Sprite(texture, 57, 10, 130, 40);
            // Производит изменения над актером, которые должны были с ним произойти
            // с момента последней отрисовки. Дергается при вызове метода act у сцены
            // (или или другого контейнера, который содержит текущего актера).
            @Override
            public void act(float delta) {
                actorSprite.setPosition(0, 0);
                if (actorSprite.getScaleX() < 2) {
                    actorSprite.setScale(actorSprite.getScaleX() + delta);
                } else {
                    actorSprite.setScale(0.1f);
                }
            }
            // Отрисовывает актера. Дергается при вызове метода draw у сцены
            // (или или другого контейнера, который содержит текущего актера).
            @Override
            public void draw(Batch batch, float parentAlpha) {
                actorSprite.draw(batch, parentAlpha);
            }
        });
        group.addActor(new Actor(){
            // Инициализируем спрайт куском рисунка тестуры, огрниченным координатами
            // x=57, y=10 от левого верхнего угла текстуры и размерами (130, 40)
            Sprite actorSprite = new Sprite(texture, 57, 10, 130, 40);
            // Производит изменения над актером, которые должны были с ним произойти
            // с момента последней отрисовки. Дергается при вызове метода act у сцены
            // (или или другого контейнера, который содержит текущего актера).
            @Override
            public void act(float delta) {
                actorSprite.setPosition(50, 0);
                if (actorSprite.getScaleX() > 0.5) {
                    actorSprite.setScale(actorSprite.getScaleX() - delta);
                } else {
                    actorSprite.setScale(2f);
                }
            }
            // Отрисовывает актера. Дергается при вызове метода draw у сцены
            // (или или другого контейнера, который содержит текущего актера).
            @Override
            public void draw(Batch batch, float parentAlpha) {
                actorSprite.draw(batch, parentAlpha);
            }
        });

        // переместим группу
        group.setPosition(50, 100);

        // устанавливаем центр вращения
        group.setOrigin(80, 20);
    }

    @Override
    public void render(float delta) {
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
        stage.act(delta);
        // Отрисовываем сцену (точнее все объекты привязанные к ней).
        stage.draw();

        // повернем группу
        group.setRotation(group.getRotation() - Gdx.graphics.getDeltaTime());
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        texture.dispose();
    }
}
