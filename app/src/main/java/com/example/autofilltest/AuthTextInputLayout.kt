package com.example.autofilltest

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.util.SparseArray
import android.view.ViewStructure
import android.view.autofill.AutofillId
import android.view.autofill.AutofillValue
import androidx.annotation.RequiresApi
import com.google.android.material.textfield.TextInputLayout

class AuthTextInputLayout: TextInputLayout {

  companion object {
    const val TAG = "AuthTextInputLayout"
  }

  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  )

  override fun isVisibleToUserForAutofill(virtualId: Int): Boolean {
    val iv = super.isVisibleToUserForAutofill(virtualId)
    Log.d(TAG, "isVisibleToUserForAutofill: virtualId - $virtualId isVisible - $iv this - $this")
    return true;
  }

  override fun autofill(value: AutofillValue?) {
    Log.d(TAG, "autofill: value - $value")
    super.autofill(value)
  }

  override fun autofill(values: SparseArray<AutofillValue>) {
    Log.d(TAG, "autofill: values - $values")
    super.autofill(values)
  }

  override fun onProvideAutofillVirtualStructure(structure: ViewStructure?, flags: Int) {
    Log.d(
      TAG,
      "onProvideAutofillVirtualStructure: structure - $structure flags - $flags this - $this"
    )
    super.onProvideAutofillVirtualStructure(structure, flags)
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
      Log.d(
        TAG,
        "onProvideAutofillVirtualStructure: structure text - ${structure?.text} childCount - ${structure?.childCount} autoFill id - ${structure?.autofillId} extras - ${structure?.extras}" +
          "a - $structure.get"
      )
      structure?.setDimens(0, 0, 1, 1, 3, 3)
      structure?.setVisibility(VISIBLE)
      structure?.setClickable(true)
      structure?.setEnabled(true)
      structure?.setActivated(true)
      structure?.setOpaque(true)
    }
  }
}