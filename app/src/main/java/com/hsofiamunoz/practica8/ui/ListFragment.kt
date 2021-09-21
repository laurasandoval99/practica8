package com.hsofiamunoz.practica8.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hsofiamunoz.practica8.R
import com.hsofiamunoz.practica8.databinding.FragmentListBinding
import com.hsofiamunoz.practica8.model.Cat
import com.hsofiamunoz.practica8.model.CatItem
import com.hsofiamunoz.practica8.server.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListFragment : Fragment() {

    private  var _binding: FragmentListBinding?= null
    private val binding get() = _binding!!

    private lateinit var catAdapter: catAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val root :View = binding.root

        // Codigo
        catAdapter = catAdapter (onITemClicked = {onCatItemClicked(it)})

        binding.catRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.context)
            adapter = catAdapter
            setHasFixedSize(false)
        }

        loadCats()

        return root
    }

    private fun loadCats() {
        val apikey = "5936ba53-545b-49e4-953f-21e3ca9666ee"
        ApiService.create()
            .getTopRated(apikey)
            .enqueue(object: Callback<Cat> {
                override fun onFailure(call: Call<Cat>, t: Throwable) {
                    Log.d("Error",t.message.toString())
                }

                override fun onResponse(call: Call<Cat>, response: Response<Cat>) {
                    if (response.isSuccessful){
                        var listcat : MutableList<CatItem> = response.body()?.cats as MutableList<CatItem>
                        catAdapter.appendItems(listcat)
                    }
                }
            })
    }

    private fun onCatItemClicked(cat: CatItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(cat=cat))
    }

}