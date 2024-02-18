package org.example

class LogSubject {

    private var logObservers: MutableMap<Int, ArrayList<LogObserver>> = mutableMapOf()

    fun addObserver(level: Int, logObserver: LogObserver) {
        val observerList = logObservers.getOrDefault(level, arrayListOf())
        observerList?.add(logObserver)
        logObservers[level] = observerList
    }

    fun notifyObservers(level: Int, msg: String) {
        val observerList = logObservers[level]
        observerList?.forEach {
            it.display(msg)
        }
    }
}