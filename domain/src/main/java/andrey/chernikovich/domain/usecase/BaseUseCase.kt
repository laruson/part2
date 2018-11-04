package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.executer.PostExecutorThread
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCase(val postExecutorThread: Scheduler,
                           val workExecutorThread: Scheduler = Schedulers.io()) {

    constructor(postExecutorThread: PostExecutorThread) : this(postExecutorThread.getScheduler())

}