package com.example.tictactoe.binding

import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment
import com.example.tictactoe.binding.FragmentBindingAdapters

class FragmentDataBindingComponent(fragment: Fragment) : DataBindingComponent {
    private val adapter =
        FragmentBindingAdapters(fragment)

    override fun getFragmentBindingAdapters() = adapter
}