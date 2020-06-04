package com.company.app.ui.activities.onboarding

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.company.app.R
import com.company.app.appbase.injection.AppComponent
import com.company.app.appbase.settings.UserSettings
import com.company.app.databinding.ActivityOnboardingBinding
import com.company.app.ui.activities.base.BaseActivity
import com.company.app.ui.activities.main.MainActivity
import com.company.app.ui.activities.onboarding.di.OnboardingModule
import javax.inject.Inject


class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>(), OnboardingContractor.View {

    @Inject
    internal lateinit var presenter: OnboardingContractor.Presenter

    @Inject
    internal lateinit var userSettings: UserSettings
    private val onboardingFragmentsAdapter = OnboardingFragmentsAdapter(supportFragmentManager, lifecycle)

    /**
     * Super class & android system functions:
     */
    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(OnboardingModule(this)).inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_onboarding
    }

    override fun onFinishCreatingBaseActivity() {
        initViewPager()
        initActionButtonsClickListeners()
    }

    override fun onBackPressed() {
        if (dataBinding.viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            dataBinding.viewPager.currentItem = dataBinding.viewPager.currentItem - 1
        }
    }


    /**
     * Private Functions:
     */

    private fun initViewPager() {
        dataBinding.viewPager.adapter = onboardingFragmentsAdapter
        dataBinding.tabDots.setViewPager2(dataBinding.viewPager)

        dataBinding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateActionButtonsBasedOnPagePosition(position)
                super.onPageSelected(position)
            }
        })
    }

    private fun initActionButtonsClickListeners() {
        dataBinding.nextButton.setOnClickListener {
            if ((dataBinding.viewPager.currentItem + 1) < (dataBinding.viewPager.adapter?.itemCount ?: 0)) {
                dataBinding.viewPager.setCurrentItem(dataBinding.viewPager.currentItem + 1, true)
            } else {
                startMainActivity()
            }
        }

        dataBinding.backButton.setOnClickListener {
            if (dataBinding.viewPager.currentItem > 0) {
                dataBinding.viewPager.setCurrentItem(dataBinding.viewPager.currentItem - 1, true)
            }
        }
    }

    private fun updateActionButtonsBasedOnPagePosition(position: Int) {
        when (position) {
            0 -> {
                updateButton(dataBinding.backButton, "", false)
                updateButton(dataBinding.nextButton, getString(R.string.lets_start), true)
            }

            (onboardingFragmentsAdapter.itemCount - 1) -> {
                updateButton(dataBinding.backButton, resources.getString(R.string.back), true)
                updateButton(dataBinding.nextButton, getString(R.string.done), true)
            }

            else -> {
                updateButton(dataBinding.backButton, resources.getString(R.string.back), true)
                updateButton(dataBinding.nextButton, resources.getString(R.string.next), true)
            }
        }
    }

    private fun updateButton(textView: TextView, text: String, isViable: Boolean) {
        textView.text = text
        textView.visibility = if (isViable) View.VISIBLE else View.INVISIBLE
    }

    private fun startMainActivity() {
        userSettings.setIsFirstTime(false)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}