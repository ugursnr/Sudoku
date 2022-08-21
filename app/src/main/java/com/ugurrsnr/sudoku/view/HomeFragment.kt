package com.ugurrsnr.sudoku.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.ugurrsnr.sudoku.R
import com.ugurrsnr.sudoku.adapter.GameLevelAdapter
import com.ugurrsnr.sudoku.databinding.FragmentHomeBinding
import com.ugurrsnr.sudoku.model.GameLevel


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var gameLevelList : ArrayList<GameLevel>
    private lateinit var gameLevelAdapter : GameLevelAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gameLevelList = arrayListOf()
        gameLevelListSetter() //gameLevelList initialize
        prepareRecyclerView() //recyclerView initialize

    }

    private fun prepareRecyclerView() {
        gameLevelAdapter = GameLevelAdapter(gameLevelList)
        binding.recyclerViewHome.apply {
            layoutManager = GridLayoutManager(context,5, GridLayoutManager.VERTICAL,false)
            adapter = gameLevelAdapter
        }
    }

    private fun gameLevelListSetter(){
        val level1 = GameLevel(1)
        val level2 = GameLevel(2)
        val level3 = GameLevel(3)
        val level4 = GameLevel(4)
        val level5 = GameLevel(5)

        gameLevelList.add(level1)
        gameLevelList.add(level2)
        gameLevelList.add(level3)
        gameLevelList.add(level4)
        gameLevelList.add(level5)


    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}