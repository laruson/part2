package andrey.chernikovich.domain.executer

import io.reactivex.Scheduler

interface PostExecutorThread {
    fun getScheduler(): Scheduler

}