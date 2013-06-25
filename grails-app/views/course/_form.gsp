<%@ page import="de.javandry.minigolf.webapp.Course" %>

<div class="control-group required ${hasErrors(bean: courseInstance, field: 'name', 'error')}">
    <label class="control-label" for="name">
        <g:message code="course.name.label"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="controls">
        <g:textField name="name" value="${courseInstance?.name}" class="input-xlarge"/>
    </div>
</div>

<div class="control-group required ${hasErrors(bean: courseInstance, field: 'type', 'error')}">
    <label class="control-label" for="type">
        <g:message code="course.type.label"/>
        <span class="required-indicator">*</span>
    </label>

    <div class="controls">
        <g:select name="type" value="${courseInstance?.type?.name()}"
                  from="${Course.Type.values()}"
                  valueMessagePrefix="course.type.option"/>
    </div>
</div>

<div class="control-group ${hasErrors(bean: courseInstance, field: 'address', 'error')}">
    <label class="control-label" for="address">
        <g:message code="course.address.label"/>
    </label>

    <div class="controls">
        <g:textArea name="address" rows="3" cols="80"
                    value="${courseInstance?.address}" class="input-xlarge"/>
    </div>
</div>


