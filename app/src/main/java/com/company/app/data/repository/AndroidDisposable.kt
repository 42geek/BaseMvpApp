package com.company.app.data.repository

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * This class extends the CompositeDisposable to contain all the observables in one place in order to clean them all when the app destroy
 */
class AndroidDisposable {
    private var compositeDisposable: CompositeDisposable? = null

    fun add(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable?.add(disposable)
    }

    fun dispose() {
        compositeDisposable?.dispose()
        compositeDisposable = null
    }

    fun clear() {
        compositeDisposable?.clear()
    }

    fun isDisposed(): Boolean {
        return compositeDisposable?.isDisposed ?: true
    }
}