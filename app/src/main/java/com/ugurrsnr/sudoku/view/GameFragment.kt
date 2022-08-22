package com.ugurrsnr.sudoku.view

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ugurrsnr.sudoku.R
import com.ugurrsnr.sudoku.databinding.FragmentGameBinding
import com.ugurrsnr.sudoku.game.Cell
import com.ugurrsnr.sudoku.view.custom.SudokuBoardView
import com.ugurrsnr.sudoku.viewmodel.PlaySudokuViewModel


class GameFragment : Fragment() , SudokuBoardView.OnTouchListener {
    private var _binding : FragmentGameBinding? = null
    private val binding get() = _binding!!
    private lateinit var buttons : List<Button>
    private lateinit var viewModel : PlaySudokuViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[PlaySudokuViewModel::class.java]

        binding.sudokuBoardView.registerListener(this)

        viewModel.sudokuGame.selectedCellLiveData.observe(viewLifecycleOwner, Observer { updateSelectedCellUI(it) })
        viewModel.sudokuGame.cellsLiveData.observe(viewLifecycleOwner, Observer { updateCells(it) })
        viewModel.sudokuGame.isTakingNotesLiveData.observe(viewLifecycleOwner, Observer { updateNoteTakingUI(it) })
        viewModel.sudokuGame.highlightedKeysLiveData.observe(viewLifecycleOwner, Observer { updateHighlightedKeys(it) })

        val buttons = listOf(binding.oneButton,binding.twoButton, binding.threeButton, binding.fourButton, binding.fiveButton, binding.sixButton,
            binding.sevenButton, binding.eightButton, binding.nineButton)

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener { viewModel.sudokuGame.handleInput(index + 1) }
        }

        binding.notesButton.setOnClickListener { viewModel.sudokuGame.changeNoteTakingState() }
        binding.deleteButton.setOnClickListener { viewModel.sudokuGame.delete() }



    }

    private fun updateCells(cells: List<Cell>?) = cells?.let {
        binding.sudokuBoardView.updateCells(cells)
    }

    private fun updateSelectedCellUI(cell: Pair<Int, Int>?) = cell?.let {
        binding.sudokuBoardView.updateSelectedCellUI(cell.first, cell.second)
    }


    private fun updateNoteTakingUI(isNoteTaking: Boolean?) = isNoteTaking?.let {
        val color = if (it) ContextCompat.getColor(requireContext(), R.color.teal_200) else Color.LTGRAY
        binding.notesButton.background.setColorFilter(color, PorterDuff.Mode.MULTIPLY)
    }

    private fun updateHighlightedKeys(set: Set<Int>?) = set?.let {
        buttons.forEachIndexed { index, button ->
            val color = if (set.contains(index + 1)) ContextCompat.getColor(requireContext(), R.color.teal_200) else Color.LTGRAY
            button.background.setColorFilter(color, PorterDuff.Mode.MULTIPLY)
        }
    }
    override fun onCellTouched(row: Int, col: Int) {
        viewModel.sudokuGame.updateSelectedCell(row, col)
    }

}