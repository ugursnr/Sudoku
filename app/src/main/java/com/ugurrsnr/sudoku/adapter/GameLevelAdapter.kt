package com.ugurrsnr.sudoku.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ugurrsnr.sudoku.databinding.GameLevelRowBinding
import com.ugurrsnr.sudoku.model.GameLevel
import com.ugurrsnr.sudoku.view.GameFragment
import com.ugurrsnr.sudoku.view.HomeFragmentDirections

class GameLevelAdapter(val gameLeveList : ArrayList<GameLevel>) : RecyclerView.Adapter<GameLevelAdapter.GameLevelViewHolder>() {

    class GameLevelViewHolder(val binding : GameLevelRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameLevelViewHolder {
        val binding = GameLevelRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GameLevelViewHolder(binding)
    }


    override fun onBindViewHolder(holder: GameLevelViewHolder, position: Int) {
        holder.binding.gameLevelTV.text = gameLeveList.get(position).gameLevelInt.toString()


        holder.itemView.setOnClickListener {
            val navigateToGameFragment = HomeFragmentDirections.actionHomeFragmentToGameFragment()
            Navigation.findNavController(it).navigate(navigateToGameFragment)
        }

    }

    override fun getItemCount(): Int {
        return gameLeveList.size
    }
}