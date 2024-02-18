package org.example

class ConsoleLogObserver : LogObserver {
    override fun display(msg: String) {
        println("Logged msg $msg in Console")
    }
}