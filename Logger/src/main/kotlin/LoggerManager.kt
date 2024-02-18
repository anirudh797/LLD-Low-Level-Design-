package org.example

import kotlin.math.log

object LoggerManager {

    fun buildChainOfLoggers() :  AbstractLogger{
        val infoLogger = InfoLogger()
        val debugLogger= DebugLogger()
        val errorLogger = ErrorLogger()
        errorLogger.addNextLevelLogger(infoLogger)
        debugLogger.addNextLevelLogger(errorLogger)
        return debugLogger
    }

    fun buildLogSubject() : LogSubject {
        val logSubject = LogSubject()
        val dbLogObserver = DbLogObserver()
        val consoleLogObserver = ConsoleLogObserver()
        //for info add Console as observer
        logSubject.addObserver(1,consoleLogObserver)
        logSubject.addObserver(2,dbLogObserver)
        // for error add Db as observer
        return logSubject
    }
}