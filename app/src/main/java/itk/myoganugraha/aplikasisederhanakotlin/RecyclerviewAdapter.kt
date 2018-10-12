package itk.myoganugraha.aplikasisederhanakotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerviewAdapter(context: Context, val listData: List<DataModel>) : RecyclerView.Adapter<RecyclerviewAdapter.CustomViewHolder>() {

    var mContext = context;

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CustomViewHolder {
        val v = LayoutInflater.from(viewGroup?.context).inflate(R.layout.cardview_news, viewGroup, false)
        return CustomViewHolder(v)
    }

    override fun onBindViewHolder(customViewHolder: CustomViewHolder, i: Int)   {
        val dataModel: DataModel = listData.get(i)

        Glide.with(mContext)
                .load(dataModel.thumbnail)
                .into(customViewHolder.ivThumbnail)

        Glide.with(mContext)
                .load(dataModel.userIcon)
                .into(customViewHolder.civProfile)

        customViewHolder.tvUsername.setText(dataModel.username)
        customViewHolder.tvNews.setText(dataModel.news)
    }

    override fun getItemCount(): Int{
        return listData.size
    }



    class CustomViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val tvUsername = itemView.findViewById<TextView>(R.id.usernamePost)
        val tvNews = itemView.findViewById<TextView>(R.id.tvNews)
        val ivThumbnail = itemView.findViewById<ImageView>(R.id.ivThumbnail)
        val civProfile = itemView.findViewById<CircleImageView>(R.id.civ_profpic)
    }
}