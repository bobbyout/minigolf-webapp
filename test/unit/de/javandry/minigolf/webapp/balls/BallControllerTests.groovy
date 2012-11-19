package de.javandry.minigolf.webapp.balls

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(BallController)
@Mock(Ball)
class BallControllerTests {

    def populateValidParams(params) {
        assert params != null
        params["manufacturer"] = new Manufacturer(shortName: "3D", longName: "3D")
        params["name"] = 'type 543'
    }

    void testIndex() {
        controller.index()
        assert "/ball/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.ballInstanceList.size() == 0
        assert model.ballInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.ballInstance != null
    }

    void testSave() {
        controller.save()

        assert model.ballInstance != null
        assert view == '/ball/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/ball/list'
        assert controller.flash.message != null
        assert Ball.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/ball/list'

        populateValidParams(params)
        def ball = new Ball(params)

        assert ball.save() != null

        params.id = ball.id

        def model = controller.show()

        assert model.ballInstance == ball
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/ball/list'

        populateValidParams(params)
        def ball = new Ball(params)

        assert ball.save() != null

        params.id = ball.id

        def model = controller.edit()

        assert model.ballInstance == ball
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/ball/list'

        response.reset()

        populateValidParams(params)
        def ball = new Ball(params)

        assert ball.save() != null

        // test invalid parameters in update
        params.id = ball.id
        params.name = null

        controller.update()

        assert view == "/ball/edit"
        assert model.ballInstance != null

        ball.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/ball/show/$ball.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        ball.clearErrors()

        populateValidParams(params)
        params.id = ball.id
        params.version = -1
        controller.update()

        assert view == "/ball/edit"
        assert model.ballInstance != null
        assert model.ballInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/ball/list'

        response.reset()

        populateValidParams(params)
        def ball = new Ball(params)

        assert ball.save() != null
        assert Ball.count() == 1

        params.id = ball.id

        controller.delete()

        assert Ball.count() == 0
        assert Ball.get(ball.id) == null
        assert response.redirectedUrl == '/ball/list'
    }
}
