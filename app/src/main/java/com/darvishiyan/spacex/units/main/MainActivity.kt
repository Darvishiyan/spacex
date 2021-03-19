package com.darvishiyan.spacex.units.main

import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.darvishiyan.spacex.BR
import com.darvishiyan.spacex.R
import com.darvishiyan.spacex.core.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel, ViewDataBinding>() {

    override val layoutResId = R.layout.activity_main
    override val viewModelId = BR.vm
    override val viewModel: MainViewModel by viewModel()

    override fun onLifecycleOwnerBounded(viewLifecycleOwner: LifecycleOwner) {
        super.onLifecycleOwnerBounded(viewLifecycleOwner)
        viewModel.eventHandler.setActionBarTitleObserver.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { title ->
                supportActionBar?.title = title
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }

        viewModel.eventHandler.resetActionBarTitleObserver.observe(viewLifecycleOwner) {
            supportActionBar?.title = getString(R.string.app_name)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }

        viewModel.eventHandler.showErrorDialogObserver.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { data ->
                AlertDialog.Builder(this)
                    .setTitle(data.title)
                    .setMessage(data.message)
                    .setPositiveButton(data.action) { dialog, _ ->
                        dialog.dismiss()
                        data.run()
                    }.show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        viewModel.eventHandler.resetActionBarTitle()
    }
}