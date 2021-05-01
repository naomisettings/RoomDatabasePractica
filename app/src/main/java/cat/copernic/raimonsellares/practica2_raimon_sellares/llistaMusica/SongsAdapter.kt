package cat.copernic.raimonsellares.practica2_raimon_sellares.llistaMusica


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import cat.copernic.raimonsellares.practica2_raimon_sellares.R
import cat.copernic.raimonsellares.practica2_raimon_sellares.databinding.ItemSongBinding
import java.util.*

class SongsAdapter(
    private val mSongs: ArrayList<Song>,
    private val cellClickListener: CellClickListener,
) : RecyclerView.Adapter<SongsAdapter.ViewHolder>() {

    private lateinit var binding: ItemSongBinding

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        private lateinit var binding: ItemSongBinding

        //inicialitzem les variables dels items
        val songTextView = itemView.findViewById<TextView>(R.id.nameSong)
        val artistTextView = itemView.findViewById<TextView>(R.id.artistSong)
        //val seleccioCheckBox = itemView.findViewById<CheckBox>(R.id.tiquetSeleccionat)
    }

    var checkedTiquets: ArrayList<Song> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // carreguem el layou del tiquet
        val tiquetView = inflater.inflate(R.layout.item_song, parent, false)
        // retorna una instancia del viewholder
        return ViewHolder(tiquetView)
    }

    @SuppressLint("LongLogTag")
    override fun onBindViewHolder(holder: SongsAdapter.ViewHolder, position: Int) {
        val song: Song = mSongs.get(position)
        val songTextView = holder.songTextView
        songTextView.setText(song.name)
        val artistTextView = holder.artistTextView
        artistTextView.setText(song.artist)
       // val chbx = holder.seleccioCheckBox
       // chbx.isChecked = tiquet.seleccionat

        val data = mSongs[position]
        holder.songTextView.text = data.name
        holder.artistTextView.text = data.artist
/*
        if (tiquet.respost) {
            holder.seleccioCheckBox.setBackgroundResource(R.drawable.borde_imatge)
        } else {
            holder.seleccioCheckBox.setBackgroundResource(R.drawable.borde_imatge_red)
        }

 */


        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data)
        }
        //seleccionar checkbox
        /*
        holder.seleccioCheckBox.setOnClickListener {
            if (chbx.isChecked) {
                song.seleccionat = true
                checkedTiquets.add(tiquet)
            }
        }

         */
    }

    override fun getItemCount(): Int {
        return mSongs.size
    }
}

//Veure si s'ha clicat en un tiquet
open class CellClickListener(val clickListener: (name: String, artist: String) -> Unit) {
    fun onCellClickListener(data: Song) {
        clickListener(data.name, data.artist)

    }
}

@BindingAdapter("songQualityString")
fun TextView.setSleepQualityString(item: Song?) {
    item?.let {
        text = item.name
    }
}





