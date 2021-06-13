package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import cat.copernic.raimonsellares.practica2_raimon_sellares.database.Musica
import cat.copernic.raimonsellares.practica2_raimon_sellares.databinding.ItemSongBinding

class SongsAdapter(
    var mSongs: List<Musica>,
    var cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<SongsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemSongBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(song: Musica) {
            binding.executePendingBindings()
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

        holder.itemView
        with(holder) {
            with(mSongs[position]) {
                binding.nameSong.text = this.song
                binding.artistSong.text = this.artista

                holder.bind(this)
            }

            holder.itemView.setOnClickListener {
                cellClickListener.onCellClickListener(mSongs[position])
            }

        }
    }

    override fun getItemCount(): Int {
        return mSongs.size
    }
}

open class CellClickListener(val clickListener: (name: String, aritsta: String, id: Int) -> Unit) {
    fun onCellClickListener(data: Musica) {
        clickListener(
            data.song,
            data.artista,
            data.id
        )
    }
}

@BindingAdapter("songQualityString")
fun TextView.setSleepQualityString(item: Musica?) {
    item?.let {
        text = item.song
    }
}





