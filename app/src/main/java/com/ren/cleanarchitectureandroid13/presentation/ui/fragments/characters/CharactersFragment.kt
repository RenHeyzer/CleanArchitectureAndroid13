package com.ren.cleanarchitectureandroid13.presentation.ui.fragments.characters

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ren.cleanarchitectureandroid13.R
import com.ren.cleanarchitectureandroid13.databinding.FragmentCharactersBinding
import com.ren.cleanarchitectureandroid13.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private val binding by viewBinding(FragmentCharactersBinding::bind)
    private val viewModel by viewModels<CharactersViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSubscribes()
    }

    private fun setupSubscribes() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.charactersState.collect {
                    when (it) {
                        is UIState.Error -> {
                            Log.e("error", it.error)
                        }
                        is UIState.Loading -> {
                            Log.e("loading", "loading...")
                        }
                        is UIState.Success -> {
                            Log.e("data", it.data.toString())
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.localState.collect {
                    when (it) {
                        is UIState.Error -> {
                            Log.e("error", it.error)
                        }
                        is UIState.Loading -> {
                            Log.e("loading", "loading...")
                        }
                        is UIState.Success -> {
                            Log.e("data", it.data.toString())
                        }
                    }
                }
            }
        }
    }
}