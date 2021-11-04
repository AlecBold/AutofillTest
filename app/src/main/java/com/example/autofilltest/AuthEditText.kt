package com.example.autofilltest

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.ViewStructure
import androidx.appcompat.widget.AppCompatEditText

class AuthEditText: AppCompatEditText {

  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  )

  override fun onProvideAutofillVirtualStructure(structure: ViewStructure?, flags: Int) {
    super.onProvideAutofillVirtualStructure(structure, flags)
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
//      structure?.let {
//        it.setVisibility(VISIBLE)
//        it.setDimens(0, 0, 0,0, 1, 1)
//        it.setOpaque(true)
//        it.setActivated(true)
//        it.setEnabled(true)
//      }
    }
  }

  override fun onProvideAutofillStructure(structure: ViewStructure?, flags: Int) {
    super.onProvideAutofillStructure(structure, flags)
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
//      structure?.let {
//        it.setVisibility(VISIBLE)
//        it.setDimens(0, 0, 0,0, 300, 900)
//        it.setOpaque(true)
//        it.setActivated(true)
//        it.setEnabled(true)
//      }
    }
  }

  override fun dispatchProvideAutofillStructure(structure: ViewStructure, flags: Int) {
    super.dispatchProvideAutofillStructure(structure, flags)
//    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
//      structure?.let {
//        it.setVisibility(VISIBLE)
//        it.setDimens(0, 0, 0,0, 1, 1)
//        it.setOpaque(true)
//        it.setActivated(true)
//        it.setEnabled(true)
//      }
//    }
  }

//  override fun dispatchProvideStructure(structure: ViewStructure?) {
//    super.dispatchProvideStructure(structure)
//    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
//      structure?.let {
//        it.setVisibility(VISIBLE)
//        it.setDimens(0, 0, 0,0, 1, 1)
//        it.setOpaque(true)
//        it.setActivated(true)
//        it.setEnabled(true)
//      }
//    }
//  }
}