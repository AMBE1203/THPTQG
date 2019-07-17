package com.ambe.onthithptqg

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.ambe.onthithptqg.ui.dialog.ExitAlertDialog
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), DuoMenuView.OnMenuClickListener {
    override fun onOptionClicked(position: Int, objectClicked: Any?) {
        // Set the toolbar title
        title = mTitles[position]

        // Set the right options selected
        mMenuAdapter?.setViewSelected(position, true)

        // Navigate to the right fragment
        when (position) {
            0 -> mViewHolder?.mDuoDrawerLayout?.closeDrawer()
            1 -> shareApp()
            2 -> rateApp()
            3 -> communityPrinciples()
            4 -> alarm()

        }

    }

    private fun alarm() {

    }

    private fun communityPrinciples() {
    }

    private fun rateApp() {

    }

    private fun shareApp() {
    }

    override fun onHeaderClicked() {
        Toast.makeText(this, "onHeaderClicked", Toast.LENGTH_SHORT).show()
    }

    override fun onFooterClicked() {
        val exitAlertDialog = ExitAlertDialog(this@MainActivity)
        exitAlertDialog.setListener(object : ExitAlertDialog.IOnExitAlertDialogListener {
            override fun onCancel() {
                exitAlertDialog.cancel()
            }

            override fun onAgree() {

                finish()
                exitProcess(0)
            }
        })
        exitAlertDialog.show()
    }

    private var mMenuAdapter: MenuAdapter? = null
    private var mViewHolder: ViewHolder? = null
    private var mTitles = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = resources.getStringArray(R.array.menuOptions)
        mTitles.addAll(list)

        // Initialize the views
        mViewHolder = ViewHolder()

        // Handle toolbar actions
        handleToolbar()

        // Handle menu actions
        handleMenu()

        // Handle drawer actions
        handleDrawer()

        mMenuAdapter?.setViewSelected(0, true)
        title = mTitles[0]


    }

    private fun handleDrawer() {
        val duoDrawerToggle = DuoDrawerToggle(
            this,
            mViewHolder?.mDuoDrawerLayout,
            mViewHolder?.mToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        mViewHolder?.mDuoDrawerLayout?.setDrawerListener(duoDrawerToggle)
        duoDrawerToggle.syncState()
    }

    private fun handleMenu() {
        mMenuAdapter = MenuAdapter(mTitles)

        mViewHolder?.mDuoMenuView?.setOnMenuClickListener(this)
        mViewHolder?.mDuoMenuView?.adapter = mMenuAdapter
    }

    private fun handleToolbar() {
        setSupportActionBar(mViewHolder?.mToolbar)
    }

    private inner class ViewHolder internal constructor() {
        val mDuoDrawerLayout: DuoDrawerLayout = findViewById(R.id.drawer)
        val mDuoMenuView: DuoMenuView
        val mToolbar: Toolbar

        init {
            mDuoMenuView = mDuoDrawerLayout.menuView as DuoMenuView
            mToolbar = findViewById(R.id.toolbar)
        }
    }
}
