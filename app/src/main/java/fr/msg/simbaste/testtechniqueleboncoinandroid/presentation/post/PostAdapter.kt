package fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.msg.simbaste.testtechniqueleboncoinandroid.R
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import fr.msg.simbaste.testtechniqueleboncoinandroid.databinding.ListItemBinding

class PostAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private val postList = ArrayList<Post>()

    fun setList(posts: List<Post>) {
        postList.clear()
        postList.addAll(posts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(postList[position])
    }
}


class MyViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.titleTextView.text = "Album ID : ${post.albumId}"
        binding.descriptionTextView.text = post.title

        val thumbnailUrl = post.thumbnailUrl
        Glide.with(binding.imageView.context)
            .load(thumbnailUrl)
            .placeholder(R.drawable.icn_placeholder_image)
            .error(R.drawable.icn_warning)
            .into(binding.imageView)
    }
}