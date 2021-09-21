package com.hsofiamunoz.practica8.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.hsofiamunoz.practica8.R
import com.hsofiamunoz.practica8.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root :View = binding.root

        // Procedimiento
        with(binding){
            val cat = args.cat
            catTitleTextView.text = cat.name
            razaDescriptionTextView.text = cat.description
            //if(movie.posterPath!=null){
                //Picasso.get().load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
              //      .into(imageView)
            //}

        }
        return root

    }

}