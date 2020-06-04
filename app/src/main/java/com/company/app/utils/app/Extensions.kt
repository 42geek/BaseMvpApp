package com.company.app.utils.app

import com.company.app.data.repository.AndroidDisposable
import io.reactivex.disposables.Disposable

/**
 * An extension to the Disposable class to allow adding observables to a collection and clear then later in the app
 * */
fun Disposable.disposeBy(androidDisposable: AndroidDisposable): Disposable
        = apply { androidDisposable.add(this) }

