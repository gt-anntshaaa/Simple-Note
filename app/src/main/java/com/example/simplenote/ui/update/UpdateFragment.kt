package com.example.simplenote.ui.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.simplenote.R
import com.example.simplenote.data.local.entity.NoteEntity
import com.example.simplenote.databinding.FragmentUpdateBinding
import com.example.simplenote.ui.home.HomeViewModel
import com.example.simplenote.ui.home.HomeViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UpdateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpdateFragment : Fragment() {
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

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateBinding.inflate(inflater,container,false)
        return binding.root
    }

    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.let { UpdateFragmentArgs.fromBundle(it).myNote.title.toString() }
        val desc = arguments?.let { UpdateFragmentArgs.fromBundle(it).myNote.description.toString() }
        val id = arguments?.let { UpdateFragmentArgs.fromBundle(it).myNote.id}

        binding.etTitle.setText(title)
        binding.etDescription.setText(desc)

        binding.btnUpdate.setOnClickListener {
            val newTitle = binding.etTitle.text.toString()
            val newDesc = binding.etDescription.text.toString()
            val note = NoteEntity(newTitle, newDesc)
            note.id = id?: -1
            viewModel.doUpdate(note)

            val action = UpdateFragmentDirections.actionUpdateFragmentToHomeFragment()
            it.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UpdateFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UpdateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}