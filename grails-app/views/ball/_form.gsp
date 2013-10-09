<%@ page import="de.javandry.minigolf.webapp.balls.Ball" %>

<div class="control-group ${hasErrors(bean: ballInstance, field: 'manufacturer', 'error')}">
    <label class="control-label" for="manufacturer">
        <g:message code="ball.manufacturer.label"/>
    </label>

    <div class="controls">
        <g:select id="manufacturer" name="manufacturer.id"
                  from="${de.javandry.minigolf.webapp.balls.Manufacturer.list()}"
                  optionKey="id"
                  value="${ballInstance?.manufacturer?.id}"
                  noSelection="['null': '']"/>
    </div>
</div>

<div class="control-group required ${hasErrors(bean: ballInstance, field: 'name', 'error')} ">
    <label class="control-label" for="name">
        <g:message code="ball.name.label"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="controls">
        <g:textField name="name" value="${ballInstance?.name}"/>
    </div>
</div>

<div class="control-group ${hasErrors(bean: ballInstance, field: 'size', 'error')} ">
    <label class="control-label" for="size">
        <g:message code="ball.size.label"/>
    </label>

    <div class="controls">
        <g:select name="size"
                  from="${de.javandry.minigolf.webapp.balls.Size?.values()}"
                  keys="${de.javandry.minigolf.webapp.balls.Size.values()*.name()}"
                  value="${ballInstance?.size?.name()}"
                  noSelection="['': '']"/>
    </div>
</div>

<div class="control-group ${hasErrors(bean: ballInstance, field: 'surface', 'error')} ">
    <label class="control-label" for="surface">
        <g:message code="ball.surface.label"/>
    </label>

    <div class="controls">
        <g:select name="surface"
                  from="${de.javandry.minigolf.webapp.balls.Surface?.values()}"
                  keys="${de.javandry.minigolf.webapp.balls.Surface.values()*.name()}"
                  value="${ballInstance?.surface?.name()}"
                  noSelection="['': '']"/>
    </div>
</div>

<div class="control-group ${hasErrors(bean: ballInstance, field: 'speed', 'error')} ">
    <label class="control-label" for="speed">
        <g:message code="ball.speed.label"/>
    </label>

    <div class="controls">
        <g:field name="speed" value="${fieldValue(bean: ballInstance, field: 'speed')}"/>
    </div>
</div>

<div class="control-group ${hasErrors(bean: ballInstance, field: 'shore', 'error')} ">
    <label class="control-label" for="shore">
        <g:message code="ball.shore.label"/>
    </label>

    <div class="controls">
        <g:field name="shore" value="${fieldValue(bean: ballInstance, field: 'shore')}"/>
    </div>
</div>

<div class="control-group ${hasErrors(bean: ballInstance, field: 'weight', 'error')} ">
    <label class="control-label" for="weight">
        <g:message code="ball.weight.label"/>
    </label>

    <div class="controls">
        <g:field name="weight" value="${fieldValue(bean: ballInstance, field: 'weight')}"/>
    </div>
</div>

