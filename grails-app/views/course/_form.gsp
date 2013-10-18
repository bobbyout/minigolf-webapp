<%@ page import="de.javandry.minigolf.webapp.Course" %>

<fieldset>
    <div class="form-line ${hasErrors(bean: courseInstance, field: 'name', 'error')}">
        <label for="name" class="required">${g.message(code: 'course.name.label')}</label>

        <div class="input-field">
            <g:textField name="name" value="${courseInstance?.name}"
                         class="${hasErrors(bean: courseInstance, field: 'name', 'error')}"/>
        </div>
    </div>

    <div class="form-line ${hasErrors(bean: courseInstance, field: 'type', 'error')}">
        <label for="type" class="required">${g.message(code: 'course.type.label')}</label>

        <div class="input-field">
            <g:select name="type"
                      from="${Course.Type.values()}"
                      keys="${Course.Type.values()*.name()}"
                      value="${courseInstance?.type?.name()}"
                      valueMessagePrefix="course.type.option"
                      noSelection="['': '']"
                      class="${hasErrors(bean: courseInstance, field: 'type', 'error')}"/>
        </div>
    </div>

    <div class="form-line ${hasErrors(bean: courseInstance, field: 'address', 'error')}">
        <label for="address">${g.message(code: 'course.address.label')}</label>

        <div class="input-field">
            <g:textArea name="address" rows="3" cols="80"
                        value="${courseInstance?.address}"
                        class="${hasErrors(bean: courseInstance, field: 'address', 'error')}"/>
        </div>
    </div>
</fieldset>