package com.robb1e.simplebdd

interface SimpleBdd {

    fun describe(comment: String, f:() -> Unit) { f() }
    fun scenario(comment: String, f:() -> Unit) { f() }

    fun given(description: String) = behave(description)
    fun then(description: String) = behave(description)
    fun on(description: String) = behave(description)

    fun behave(description: String) {
        for (member in this.javaClass.kotlin.members) {
            val name = methodize(member.name)
            if (name.equals(description)) {
                member.call(this)
                break
            }
        }
    }

    fun methodize(description: String) : String {
        val methodName = description.split(" ").map { token -> token.toLowerCase().capitalize() }.joinToString("")
        return methodName.substring(0, 1).toLowerCase() + methodName.substring(1)
    }
}