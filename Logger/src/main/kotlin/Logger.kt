package org.example

class Logger {
    companion object {

        var instance: Logger? = null

        @Volatile
        lateinit var chainOfLogger: AbstractLogger

        @Volatile
        lateinit var logSubject: LogSubject
        fun getLoggerInstance(): Logger {
            instance ?: synchronized(this){
                chainOfLogger = LoggerManager.buildChainOfLoggers()
                logSubject = LoggerManager.buildLogSubject()
                instance = Logger()
            }
           return instance!!
        }


    }

    fun logInfo(msg:String){
        chainOfLogger.log(1,msg)
        logSubject.notifyObservers(1,msg)
    }

    fun logError(msg:String){
        chainOfLogger.log(2,msg)
        logSubject.notifyObservers(2,msg)
    }



}