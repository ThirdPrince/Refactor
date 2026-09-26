package com.refactor.xml

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.refactor.databinding.FragmentVehiclesBinding
import com.refactor.databinding.ItemVehicleBinding
import kotlinx.coroutines.launch

class VehiclesFragment : Fragment() {

    var binding: FragmentVehiclesBinding? = null
    var adapter = VehiclesRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVehiclesBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.recyclerView.adapter = adapter
        lifecycleScope.launch {
            try {
                adapter.vehicles = DependencyContainer.vehiclesService.getVehicles()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    inner class VehiclesRecyclerViewAdapter :
        RecyclerView.Adapter<VehiclesRecyclerViewAdapter.ViewHolder>() {

        var vehicles: List<Vehicle> = emptyList()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(ItemVehicleBinding.inflate(LayoutInflater.from(parent.context))).apply {
                itemView.setOnClickListener {
                    Toast
                        .makeText(
                            requireContext(),
                            vehicles[adapterPosition].model + " by " + vehicles[adapterPosition].brand,
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
            }
        }

        override fun getItemCount(): Int = vehicles.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val vehicle = vehicles[position]
            holder.binding.vehicleModel.text = vehicle.model
            holder.binding.vehicleBrand.text = vehicle.brand
            holder.binding.vehicleDescription.text = vehicle.description
            holder.binding.vehicleCover.load(vehicle.images)
        }

        inner class ViewHolder(val binding: ItemVehicleBinding) :
            RecyclerView.ViewHolder(binding.root)
    }
}
