<%@ page import="de.javandry.minigolf.webapp.Manufacturer" %>


<fieldset>

    <div class="form-line required ${hasErrors(bean: manufacturerInstance, field: 'shortName', 'error')}">
        <label for="shortName" class="required">${g.message(code: 'manufacturer.shortName.label')}</label>

        <div class="input-field">
            <g:textField name="shortName" value="${manufacturerInstance?.shortName}"
                         class="${hasErrors(bean: manufacturerInstance, field: 'shortName', 'error')}"/>
        </div>
    </div>

    <div class="form-line ${hasErrors(bean: manufacturerInstance, field: 'longName', 'error')}">
        <label for="longName">${g.message(code: 'manufacturer.longName.label')}</label>

        <div class="input-field">
            <g:textField name="longName" value="${manufacturerInstance?.longName}"
                         class="${hasErrors(bean: manufacturerInstance, field: 'longName', 'error')}"/>
        </div>
    </div>

</fieldset>
