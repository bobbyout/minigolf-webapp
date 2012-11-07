<%@ page import="de.javandry.minigolf.webapp.balls.Ball" %>



<div class="fieldcontain ${hasErrors(bean: ballInstance, field: 'manufacturer', 'error')} ">
    <label for="manufacturer">
        <g:message code="ball.manufacturer.label" default="Manufacturer"/>

    </label>
    <g:select id="manufacturer" name="manufacturer.id" from="${de.javandry.minigolf.webapp.balls.Manufacturer.list()}"
              optionKey="id" value="${ballInstance?.manufacturer?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ballInstance, field: 'name', 'error')} ">
    <label for="name">
        <g:message code="ball.name.label" default="Name"/>

    </label>
    <g:textField name="name" value="${ballInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ballInstance, field: 'size', 'error')} ">
    <label for="size">
        <g:message code="ball.size.label" default="Size"/>

    </label>
    <g:select name="size" from="${de.javandry.minigolf.webapp.balls.Size?.values()}"
              keys="${de.javandry.minigolf.webapp.balls.Size.values()*.name()}" value="${ballInstance?.size?.name()}"
              noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ballInstance, field: 'surface', 'error')} ">
    <label for="surface">
        <g:message code="ball.surface.label" default="Surface"/>

    </label>
    <g:select name="surface" from="${de.javandry.minigolf.webapp.balls.Surface?.values()}"
              keys="${de.javandry.minigolf.webapp.balls.Surface.values()*.name()}"
              value="${ballInstance?.surface?.name()}" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ballInstance, field: 'speed', 'error')} ">
    <label for="speed">
        <g:message code="ball.speed.label" default="Speed"/>

    </label>
    <g:field name="speed" value="${fieldValue(bean: ballInstance, field: 'speed')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ballInstance, field: 'shore', 'error')} ">
    <label for="shore">
        <g:message code="ball.shore.label" default="Shore"/>

    </label>
    <g:field name="shore" value="${fieldValue(bean: ballInstance, field: 'shore')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ballInstance, field: 'weight', 'error')} ">
    <label for="weight">
        <g:message code="ball.weight.label" default="Weight"/>

    </label>
    <g:field name="weight" value="${fieldValue(bean: ballInstance, field: 'weight')}"/>
</div>

