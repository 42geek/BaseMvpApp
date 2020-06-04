package com.company.app.ui.activities.main

import androidx.viewpager2.widget.ViewPager2
import com.company.app.R
import com.company.app.appbase.injection.AppComponent
import com.company.app.databinding.ActivityMainBinding
import com.company.app.ui.activities.base.BaseActivity
import com.company.app.ui.activities.main.di.MainActivityModule
import javax.inject.Inject


/**
 * This main activity just hold a ViewPager and a BottomNavigationView and make sure to add all the fragments while update the activity title when change fragments.
 */
class MainActivity : BaseActivity<ActivityMainBinding>(), MainActivityContractor.View {

    @Inject
    internal lateinit var presenter: MainActivityContractor.Presenter

    private val mainActivityViewPagerAdapter = MainActivityViewPagerAdapter(supportFragmentManager, lifecycle)

    private var currentShownFragment = 0

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(MainActivityModule(this)).inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onFinishCreatingBaseActivity() {
        presenter.subscribe()
        initBottomNavigationBar()
        initMainViewPager()
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }

    /**
     * View Pager Stuff
     */
    private fun initMainViewPager() {
        updateToolbarTitle(currentShownFragment)

        dataBinding.activityMainViewPager.adapter = mainActivityViewPagerAdapter
        dataBinding.activityMainViewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                dataBinding.navigation.menu.getItem(position).isChecked = true
                currentShownFragment = position
                updateToolbarTitle(position)
                super.onPageSelected(position)
            }
        })
    }

    private fun updateToolbarTitle(fragmentPosition: Int) {
        supportActionBar?.setTitle(mainActivityViewPagerAdapter.getFragmentTitleRes(fragmentPosition))
    }



    /**
     * Bottom Navigation Stuff
     */
    private fun initBottomNavigationBar() {
        dataBinding.navigation.setOnNavigationItemSelectedListener { item ->
            onBottomNavigationItemClicked(mainActivityViewPagerAdapter.getFragmentIdBasedOnNavItemId(item.itemId))
            true
        }
    }

    private fun onBottomNavigationItemClicked(fragmentPosition: Int) {
        if (currentShownFragment != fragmentPosition) {
            currentShownFragment = fragmentPosition
            replaceFragment(fragmentPosition)
        }
    }


    /**
     * Fragments Related stuff
     */
    private fun replaceFragment(fragmentPosition: Int) {
        dataBinding.activityMainViewPager.setCurrentItem(fragmentPosition, true)
        updateToolbarTitle(fragmentPosition)
    }
}
