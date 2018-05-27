package deasmp.com.football_v2.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import deasmp.com.football_v2.DetailMatch
import deasmp.com.football_v2.R
import deasmp.com.football_v2.model.FootballMatch

class MatchAdapter(private val context : Context) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>(){

    private val match : MutableList<FootballMatch> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_football_match, parent, false))
    }

    override fun getItemCount(): Int {
        return match.size
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bindModel(match[position]) }

    fun setMatch(data : List<FootballMatch>){
        match.addAll(data)
        notifyDataSetChanged()
    }


    class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val matchscheduleTxt : TextView = itemView.findViewById(R.id.match_schedule_tv)
        val matchresultText : TextView = itemView.findViewById(R.id.match_result_tv)
        fun bindModel(match : FootballMatch){
            itemView.setOnClickListener(){
                val context = itemView.context
                val intent = Intent(context, DetailMatch::class.java)
                intent.putExtra("idEvent", match.idEvent)
                context.startActivity(intent)
            }
            matchscheduleTxt.text = match.dateEvent
            matchresultText.text = match.strEvent



        }
    }


}