package com.example.recyclerapi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.recyclerapi.R
import com.example.recyclerapi.adapters.PlanesAdapter
import com.example.recyclerapi.models.AircraftModel
import com.example.recyclerapi.models.AircraftResponse
import com.example.recyclerapi.services.PostApi
import kotlinx.android.synthetic.main.fragment_planes.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PlanesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.schiphol.nl")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val planesApi = retrofit.create(PostApi::class.java)

        progressBar3?.visibility = View.VISIBLE

        planesApi.getPlanes(0).enqueue(object : Callback<AircraftResponse> {
            override fun onFailure(call: Call<AircraftResponse>, t: Throwable) {
                println("404 Fatal Error")
            }

            override fun onResponse(
                call: Call<AircraftResponse>,
                response: Response<AircraftResponse>
            ) {

                if (response.isSuccessful) {
                    progressBar3?.visibility = View.GONE
                    showPlanes(response.body()!!.aircraftTypes)
                } else println("Error")

            }
        })

        return inflater.inflate(R.layout.fragment_planes, container, false)
    }

    fun showPlanes(planes: List<AircraftModel>) {
        recyclerPlanes.apply {
            adapter = PlanesAdapter(planes)
            layoutManager = LinearLayoutManager(this.context)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PlanesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlanesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
