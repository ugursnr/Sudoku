package com.ugurrsnr.sudoku.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ugurrsnr.sudoku.R
import com.ugurrsnr.sudoku.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    private var _binding : FragmentGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


}