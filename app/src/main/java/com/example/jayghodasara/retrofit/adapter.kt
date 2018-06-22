package com.example.jayghodasara.retrofit
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class adapter(var context: Context, var arrayList: List<Pojo>) : RecyclerView.Adapter<adapter.viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var v: View = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)

        return viewholder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var p: Pojo = arrayList[position]

        var name = p.name


        holder.text.text = name

    }


    class viewholder(view: View) : RecyclerView.ViewHolder(view) {

      var text=view.findViewById<TextView>(R.id.text)

    }
}