package org.example

class DbLogObserver : LogObserver {
    override fun display(msg: String) {
        println("Logged msg $msg in DB")
    }
}