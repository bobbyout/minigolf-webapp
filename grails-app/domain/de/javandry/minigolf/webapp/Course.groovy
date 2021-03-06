package de.javandry.minigolf.webapp

class Course {

    enum Type {
        ABT_1, ABT_2, ABT_3, ABT_4, FILZ
    }

    String name
    Type type
    String address

    static constraints = {
        name(nullable: false, blank: false)
        address(nullable: true, blank: true)
        type(nullable: false)
    }

    static void clear() {
        Course.executeUpdate('delete from Course')
    }
}
