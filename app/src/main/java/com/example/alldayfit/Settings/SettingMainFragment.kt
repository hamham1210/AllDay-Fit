package com.example.alldayfit.Settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alldayfit.R
import com.example.alldayfit.databinding.SettingMainFragmentBinding

class SettingMainFragment : Fragment() {
    private var _binding: SettingMainFragmentBinding? = null
    private val binding get() = _binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.setting_main_fragment, container, false)
    }
}