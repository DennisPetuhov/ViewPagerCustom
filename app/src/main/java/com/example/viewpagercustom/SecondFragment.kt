package com.example.viewpagercustom

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.viewpagercustom.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }


    private lateinit var viewModel: SecondViewModel
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       blink()
        rotateImage()
        fade()
        moveImage()
        slide()
        zoom()
        stop()

    }

    private fun stop() {
        with(binding) {
            BTNstop.setOnClickListener {

                imageview.clearAnimation()
            }
        }
    }

    private fun zoom() {
        with(binding) {
            BTNzoom.setOnClickListener {
                val animation = AnimationUtils.loadAnimation(requireContext(),R.anim.zoom_animation)
                imageview.startAnimation(animation)
            }
        }
    }

    private fun slide() {
        with(binding) {
            BTNslide.setOnClickListener {
                val animation = AnimationUtils.loadAnimation(requireContext(),R.anim.slide_animation)
                imageview.startAnimation(animation)
            }
        }
    }

    private fun moveImage() {
        with(binding) {
            BTNmove.setOnClickListener {
                val animation = AnimationUtils.loadAnimation(requireContext(),R.anim.move_animation)
                imageview.startAnimation(animation)
            }
        }
    }

    private fun fade() {
        with(binding) {
            BTNfade.setOnClickListener {
                val animation = AnimationUtils.loadAnimation(requireContext(),R.anim.fade_animation)
                imageview.startAnimation(animation)
            }
        }
    }

    private fun rotateImage() {
        with(binding) {
            BTNrotate.setOnClickListener {
                val animation = AnimationUtils.loadAnimation(requireContext(),R.anim.rotate)
                imageview.startAnimation(animation)
            }
        }
    }

    private fun blink() {
        with(binding) {
            BTNblink.setOnClickListener {
                val animation = AnimationUtils.loadAnimation(requireContext(),R.anim.blink)
                imageview.startAnimation(animation)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        // TODO: Use the ViewModel
    }

}