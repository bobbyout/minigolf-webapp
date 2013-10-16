<%@ page import="de.javandry.minigolf.webapp.balls.Ball" %>

<fieldset>
    <div class="form-line ${hasErrors(bean: ballInstance, field: 'manufacturer', 'error')}">
        <label for="manufacturer">${g.message(code: 'ball.manufacturer.label')}</label>
        <g:select id="manufacturer" name="manufacturer.id"
                  from="${de.javandry.minigolf.webapp.balls.Manufacturer.list()}"
                  optionKey="id"
                  value="${ballInstance?.manufacturer?.id}"
                  noSelection="['null': '']"
                  class="${hasErrors(bean: ballInstance, field: 'manufacturer', 'error')}"/>
    </div>

    <div class="form-line required ${hasErrors(bean: ballInstance, field: 'name', 'error')}">
        <label for="name" class="required">${g.message(code: 'ball.name.label')}</label>
        <g:textField name="name" value="${ballInstance?.name}"
                     class="${hasErrors(bean: ballInstance, field: 'name', 'error')}"/>
    </div>

    <div class="form-line ${hasErrors(bean: ballInstance, field: 'size', 'error')}">
        <label for="size">${g.message(code: 'ball.size.label')}</label>
        <g:select name="size"
                  from="${de.javandry.minigolf.webapp.balls.Size?.values()}"
                  keys="${de.javandry.minigolf.webapp.balls.Size.values()*.name()}"
                  value="${ballInstance?.size?.name()}"
                  noSelection="['': '']"
                  class="${hasErrors(bean: ballInstance, field: 'size', 'error')}"/>
    </div>

    <div class="form-line ${hasErrors(bean: ballInstance, field: 'surface', 'error')}">
        <label for="surface">${g.message(code: 'ball.surface.label')}</label>
        <g:select name="surface"
                  from="${de.javandry.minigolf.webapp.balls.Surface?.values()}"
                  keys="${de.javandry.minigolf.webapp.balls.Surface.values()*.name()}"
                  value="${ballInstance?.surface?.name()}"
                  noSelection="['': '']"
                  class="${hasErrors(bean: ballInstance, field: 'surface', 'error')}"/>
    </div>

    <div class="form-line ${hasErrors(bean: ballInstance, field: 'speed', 'error')}">
        <label for="speed">${g.message(code: 'ball.speed.label')}</label>
        <g:field type="number" name="speed" value="${fieldValue(bean: ballInstance, field: 'speed')}"
                 class="${hasErrors(bean: ballInstance, field: 'speed', 'error')}"/>
    </div>

    <div class="form-line ${hasErrors(bean: ballInstance, field: 'shore', 'error')}">
        <label for="shore">${g.message(code: 'ball.shore.label')}</label>
        <g:field type="number" name="shore" value="${fieldValue(bean: ballInstance, field: 'shore')}"
                 class="${hasErrors(bean: ballInstance, field: 'shore', 'error')}"/>
    </div>

    <div class="form-line ${hasErrors(bean: ballInstance, field: 'weight', 'error')}">
        <label for="weight">${g.message(code: 'ball.weight.label')}</label>
        <g:field type="number" name="weight" value="${fieldValue(bean: ballInstance, field: 'weight')}"
                 class="${hasErrors(bean: ballInstance, field: 'weight', 'error')}"/>
    </div>
</fieldset>
