package fr.msg.simbaste.testtechniqueleboncoinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import fr.msg.simbaste.testtechniqueleboncoinandroid.data.model.Post
import fr.msg.simbaste.testtechniqueleboncoinandroid.databinding.ActivityMainBinding
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.Injector
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.post.PostAdapter
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.post.PostViewModel
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.post.PostViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PostAdapter

    @Inject
    lateinit var factory: PostViewModelFactory
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as Injector).createPostSubComponent()
                .inject(this)

        postViewModel = ViewModelProvider(this, factory)
                .get(PostViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.postRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PostAdapter()
        binding.postRecyclerView.adapter = adapter
        displayPosts()
    }

    private fun displayPosts() {
        binding.postProgressBar.visibility = View.VISIBLE

        val responseLiveData = postViewModel.getPosts()
        responseLiveData.observe(this, Observer {
            Log.i("MyTag", it.toString())
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.postProgressBar.visibility = View.GONE
            } else {
                binding.postProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return  when (item.itemId) {
            R.id.action_update -> {
                updatePosts()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updatePosts() {
        binding.postProgressBar.visibility = View.VISIBLE
        val response = postViewModel.updatePosts()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.postProgressBar.visibility = View.GONE
            } else {
                binding.postProgressBar.visibility = View.GONE
            }
        })
    }
}