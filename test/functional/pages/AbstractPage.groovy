package pages

import geb.Page


class AbstractPage extends Page {

    protected void compareValue(def label, def expected, def actual) {
        def expectedNullsafe = expected ?: ""
        def actualNullsafe = actual ?: ""
        if (actualNullsafe != expectedNullsafe)
            throw new AssertionError("$label: expected '$expectedNullsafe' but was '$actualNullsafe'")
    }

}
