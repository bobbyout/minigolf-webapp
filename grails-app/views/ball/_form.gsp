<%@ page import="de.javandry.minigolf.webapp.Ball" %>
<%@ page import="de.javandry.minigolf.webapp.Manufacturer" %>
<%@ page import="de.javandry.minigolf.webapp.Size" %>
<%@ page import="de.javandry.minigolf.webapp.Surface" %>

<fieldset>
    <div class="form-line ${hasErrors(bean: ballInstance, field: 'manufacturer', 'error')}">
        <label for="manufacturer">${g.message(code: 'ball.manufacturer.label')}</label>

        <div class="input-field">
            <g:select id="manufacturer" name="manufacturer.id"
                      from="${Manufacturer.list()}"
                      optionKey="id"
                      value="${ballInstance?.manufacturer?.id}"
                      noSelection="['null': '']"
                      class="${hasErrors(bean: ballInstance, field: 'manufacturer', 'error')}"/>
        </div>
    </div>

    <div class="form-line required ${hasErrors(bean: ballInstance, field: 'name', 'error')}">
        <label for="name" class="required">${g.message(code: 'ball.name.label')}</label>

        <div class="input-field">
            <g:textField name="name" value="${ballInstance?.name}"
                         class="${hasErrors(bean: ballInstance, field: 'name', 'error')}"/>
        </div>
    </div>

    <div class="form-line ${hasErrors(bean: ballInstance, field: 'size', 'error')}">
        <label for="size">${g.message(code: 'ball.size.label')}</label>

        <div class="input-field">
            <g:select name="size"
                      from="${Size?.values()}"
                      keys="${Size.values()*.name()}"
                      value="${ballInstance?.size?.name()}"
                      noSelection="['': '']"
                      class="${hasErrors(bean: ballInstance, field: 'size', 'error')}"/>
        </div>
    </div>

    <div class="form-line ${hasErrors(bean: ballInstance, field: 'surface', 'error')}">
        <label for="surface">${g.message(code: 'ball.surface.label')}</label>

        <div class="input-field">
            <g:select name="surface"
                      from="${Surface?.values()}"
                      keys="${Surface.values()*.name()}"
                      value="${ballInstance?.surface?.name()}"
                      noSelection="['': '']"
                      class="${hasErrors(bean: ballInstance, field: 'surface', 'error')}"/>
        </div>
    </div>

    <div class="form-line ${hasErrors(bean: ballInstance, field: 'speed', 'error')}">
        <label for="speed">${g.message(code: 'ball.speed.label')}</label>

        <div class="input-field">
            <g:field type="number" name="speed" value="${fieldValue(bean: ballInstance, field: 'speed')}"
                     class="${hasErrors(bean: ballInstance, field: 'speed', 'error')}"/>
        </div>
    </div>

    <div class="form-line ${hasErrors(bean: ballInstance, field: 'shore', 'error')}">
        <label for="shore">${g.message(code: 'ball.shore.label')}</label>

        <div class="input-field">
            <g:field type="number" name="shore" value="${fieldValue(bean: ballInstance, field: 'shore')}"
                     class="${hasErrors(bean: ballInstance, field: 'shore', 'error')}"/>
        </div>
    </div>

    <div class="form-line ${hasErrors(bean: ballInstance, field: 'weight', 'error')}">
        <label for="weight">${g.message(code: 'ball.weight.label')}</label>

        <div class="input-field">
            <g:field type="number" name="weight" value="${fieldValue(bean: ballInstance, field: 'weight')}"
                     class="${hasErrors(bean: ballInstance, field: 'weight', 'error')}"/>
        </div>
    </div>
</fieldset>
