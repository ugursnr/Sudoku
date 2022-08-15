package com.ugurrsnr.sudoku.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugurrsnr.sudoku.databinding.GameLevelRowBinding
import com.ugurrsnr.sudoku.model.GameLevel

class GameLevelAdapter(val gameLeveList : ArrayList<GameLevel>) : RecyclerView.Adapter<GameLevelAdapter.GameLevelViewHolder>() {

    class GameLevelViewHolder(val binding : GameLevelRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameLevelViewHolder {
        TODO("Not yet implemented")
    }




    override fun onBindViewHolder(holder: GameLevelViewHolder, position: Int) {
        holder.binding.gameLevelTV.text = gameLeveList.get(position).gameLevelInt.toString()
    }

    override fun getItemCount(): Int {
        return gameLeveList.size
    }
}