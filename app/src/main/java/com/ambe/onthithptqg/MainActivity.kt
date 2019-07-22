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
import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), DuoMenuView.OnMenuClickListener {
    override fun onOptionClicked(position: Int, objectClicked: Any?) {
        // Set the toolbar title
        title = mTitles[position]

        // Set the right options selected
        mMenuAdapter?.setViewSelected(position, true)

        // Navigate to the right fragment
        when (position) {
            0 -> goToMainFragment()
            1 -> rateApp()
            2 -> shareApp()
            3 -> communityPrinciples()
            4 -> alarm()

        }

    }

    private fun goToMainFragment() {


        navController?.navigateUp()
        mViewHolder?.mDuoDrawerLayout?.closeDrawer()
    }

    private fun alarm() {

    }

    private fun communityPrinciples() {
        navController?.navigate(R.id.action_mainFragment_to_communityFragment)
        mViewHolder?.mDuoDrawerLayout?.closeDrawer()
    }

    private fun rateApp() {

    }

    private fun shareApp() {

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.chia_se_ung_dung))
        intent.putExtra(Intent.EXTRA_TEXT, "This is my text") // todo link tai app
        startActivity(Intent.createChooser(intent, getString(R.string.chon_mot_ung_dung)))
    }

    override fun onHeaderClicked() {
        Toast.makeText(this, "onHeaderClicked", Toast.LENGTH_SHORT).show()
    }

    override fun onFooterClicked() {
        exits()
    }

    private fun exits() {
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
    private var navController: NavController? = null


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

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)


    }

    override fun onBackPressed() {
        var id = navController?.currentDestination?.id
        //  var fragment = nav_host_fragment.childFragmentManager.primaryNavigationFragment
        when (id) {
            R.id.mainFragment -> {
                exits()
            }
            R.id.communityFragment -> {
                title = mTitles[0]
                mMenuAdapter?.setViewSelected(0, true)
                super.onBackPressed()
            }

            else -> super.onBackPressed()

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController!!.navigateUp()
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
