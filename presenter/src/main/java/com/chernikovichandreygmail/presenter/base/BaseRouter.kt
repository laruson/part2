package com.chernikovichandreygmail.presenter.base

import android.app.Activity
import android.support.v4.app.FragmentManager
import android.widget.Toast

abstract class BaseRouter<A : Activity>(val activity: A) {
    fun showError(e: Throwable) {
        Toast.makeText(activity,
                "Error $e",
                Toast.LENGTH_LONG).show()
    }

    fun replaceFragment(currentFragment: BaseFragment,
                        fragmentManager: FragmentManager,
                        fragment: BaseFragment,
                        containerResId: Int,
                        addToBackStack: Boolean = false) {
        val fragmentTransient = fragmentManager.beginTransaction()

        fragmentTransient.hide(currentFragment).replace(containerResId, fragment, fragment::class.java.canonicalName)

        if (addToBackStack) {
            fragmentTransient.addToBackStack(null)
        }

        fragmentTransient.commit()
    }

    fun goBack() {
        activity.onBackPressed()
    }
}