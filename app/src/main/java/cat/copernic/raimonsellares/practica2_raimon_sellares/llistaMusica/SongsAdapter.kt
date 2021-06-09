package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import cat.copernic.raimonsellares.practica2_raimon_sellares.databinding.ItemSongBinding

class SongsAdapter(var mSongs: MutableList<Song>, var cellClickListener: CellClickListener) :
    RecyclerView.Adapter<SongsAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: ItemSongBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(song: Song) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //return ViewHolder(binding)
        return ViewHolder(
            ItemSongBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(mSongs[position]) {
                binding.nameSong.text = this.name
                binding.artistSong.text = this.artist

                holder.bind(mSongs[position])
                holder.itemView.setOnClickListener {
                    cellClickListener.onCellClickListener(mSongs[position])
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return mSongs.size
    }
}


open class CellClickListener(val clickListener: (name: String, artist: String) -> Unit) {
    fun onCellClickListener(data: Song) {
        clickListener(
            data.name,
            data.artist
        )
    }
}
@BindingAdapter("songQualityString")
fun TextView.setSleepQualityString(item: Song?) {
    item?.let {
        text = item.name
    }
}





