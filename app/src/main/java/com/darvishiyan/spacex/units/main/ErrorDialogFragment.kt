package com.darvishiyan.spacex.units.main

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.darvishiyan.spacex.models.ErrorDialogModel

class ErrorDialogFragment : DialogFragment() {

    var dataModel: ErrorDialogModel? = null

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable("data", dataModel)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        if (dataModel == null)
            dataModel = savedInstanceState?.getParcelable("data")

        return dataModel?.let { model ->
            AlertDialog.Builder(activity)
                .setTitle(model.title)
                .setMessage(model.message)
                .setPositiveButton(model.action) { dialog, _ ->
                    dialog.dismiss()
                    model.run()
                }.create()
        } ?: run {
            AlertDialog.Builder(activity).create()
        }
    }
}