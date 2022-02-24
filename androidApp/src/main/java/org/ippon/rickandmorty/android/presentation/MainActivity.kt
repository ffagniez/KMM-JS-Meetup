package org.ippon.rickandmorty.android.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.ippon.rickandmorty.models.RickAndMortyCharacter
import org.ippon.rickandmorty.android.databinding.ActivityMainBinding
import org.ippon.rickandmorty.service.models.Response
import org.ippon.rickandmorty.viewmodels.CharactersViewModel

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val mainScope = MainScope()
    private val myAdapter = CharactersRecyclerViewAdapter(listOf())

    private val onResult = fun(result: Response<List<RickAndMortyCharacter>>) {
        mainScope.launch {
            when (result) {
                is Response.Loading -> binding.textView.text = "Loading..."
                is Response.CustomError -> binding.textView.text = "Error: ${result.error.localizedMessage}"
                is Response.Success -> {
                    binding.textView.visibility = View.INVISIBLE
                    myAdapter.addItems(result.result)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = CharactersViewModel(onResult)
        with(binding.charactersList) {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context)
            adapter = myAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView.canScrollVertically(1)) {
                        viewModel.getMoreCharacters()
                    }
                }
            })
        }
        myAdapter.setItems(emptyList())
        viewModel.getFirstPage()
    }
}
