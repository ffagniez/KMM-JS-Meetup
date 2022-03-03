package org.ippon.rickandmorty.android.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.ippon.rickandmorty.android.R
import org.ippon.rickandmorty.models.RickAndMortyCharacter
import org.ippon.rickandmorty.android.databinding.ActivityMainBinding
import org.ippon.rickandmorty.service.models.Response
import org.ippon.rickandmorty.viewmodels.CharactersViewModel

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyCharactersViewModel by viewModels()
    private val myAdapter = CharactersRecyclerViewAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        viewModel.getFirstPage()
    }

    private fun initRecyclerView() {
        with(binding.charactersList) {
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

        viewModel.characters.observe(this, { characters ->
            when(characters) {
                is Response.Loading -> {
                    displayLoading()
                }
                is Response.Success -> {
                    displaySuccess(characters.result)
                }
                is Response.CustomError -> {
                    displayError(characters.error)
                }
            }
        })
    }

    private fun displayError(error: Throwable) {
        binding.textView.text = getString(R.string.error, error.message)
    }

    private fun displaySuccess(characters: List<RickAndMortyCharacter>) {
        binding.textView.visibility = View.INVISIBLE
        binding.charactersList.visibility = View.VISIBLE
        myAdapter.addItems(characters)
    }

    private fun displayLoading() {
        binding.textView.text = getString(R.string.loading)
    }
}
