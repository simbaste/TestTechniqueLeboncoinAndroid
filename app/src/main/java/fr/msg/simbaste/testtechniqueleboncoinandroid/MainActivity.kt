package fr.msg.simbaste.testtechniqueleboncoinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import fr.msg.simbaste.testtechniqueleboncoinandroid.databinding.ActivityMainBinding
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.di.Injector
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.post.PostViewModel
import fr.msg.simbaste.testtechniqueleboncoinandroid.presentation.post.PostViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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

        val responseLiveData = postViewModel.getPosts()
        responseLiveData.observe(this, Observer {
            Log.i("MyTag", it.toString())
        })
    }
}