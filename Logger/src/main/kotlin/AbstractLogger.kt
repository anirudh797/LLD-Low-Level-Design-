package org.example

abstract class AbstractLogger {
    open var level: Int = 0

    lateinit var nextLevelLogger: AbstractLogger

    fun log(level: Int, msg: String) {
        if (this.level <= level) {
            //logs message
            nextLevelLogger.log(level, msg)
        }
    }

    fun addNextLevelLogger(logger: AbstractLogger) {
        nextLevelLogger = logger
    }

    protected abstract fun display(level: Int, msg: String)
}