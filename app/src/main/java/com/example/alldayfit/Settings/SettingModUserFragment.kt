package com.example.alldayfit.Settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alldayfit.R
import com.example.alldayfit.databinding.SettingModUserFragmentBinding

class SettingModUserFragment : Fragment() {
    private var _binding: SettingModUserFragmentBinding? = null
    private val binding get() = _binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.setting_mod_user_fragment, container, false)
    }
}