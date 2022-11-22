package com.example.viewpagercustom

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.view.animation.AnimationUtils
import com.example.viewpagercustom.databinding.FragmentThirdBinding
import java.util.Collections.rotate

class ThirdFragment : Fragment() {
    init {
        println("FRAGMENT 3 CREATED")
    }

    companion object {
        fun newInstance() = ThirdFragment()
    }

    lateinit var binding: FragmentThirdBinding
    private lateinit var viewModel: ThirdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(layoutInflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fadein()
        fadeOut()
        zoomIn()
        zoomOut()
        slideDown()
        slideUp()
        bounce()
        rotateMutate()

    }

    private fun rotateMutate() {
        with(binding){
            rotate.setOnClickListener {
                val animation =AnimationUtils.loadAnimation(requireContext(),R.anim.rotate)
                textView.startAnimation(animation)
            }
        }
    }

    private fun bounce() {
        with(binding){
            bounce.setOnClickListener {
                val animation=AnimationUtils.loadAnimation(requireContext(),R.anim.bounce)
                textView.startAnimation(animation)
            }
        }
    }

    private fun slideUp() {
        with(binding){
            slideUp.setOnClickListener {
                val animation =AnimationUtils.loadAnimation(requireContext(),R.anim.slide_up)
                textView.startAnimation(animation)
            }
        }
    }

    private fun slideDown() {
        with(binding){
            slideDown.setOnClickListener {
                val animation = AnimationUtils.loadAnimation(requireContext(),R.anim.slide_down)
                textView.startAnimation(animation)
            }
        }
    }

    private fun zoomOut() {
        with(binding) {
            zoomOut.setOnClickListener {
                val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_out)
                textView.startAnimation(animation)
            }
        }
    }

    private fun zoomIn() {
        with(binding) {
            zoomIn.setOnClickListener {
                val animationZoomIn = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_in)
                textView.startAnimation(animationZoomIn)
            }
        }
    }

    private fun fadeOut() {
        with(binding) {
            fadeOut.setOnClickListener {
                val animtionFadeOut =
                    AnimationUtils.loadAnimation(requireContext(), R.anim.fade_out)
                textView.startAnimation(animtionFadeOut)
                Handler().postDelayed(
                    {
                        textView.visibility = View.GONE

                    }, 1000
                )
            }
        }
    }

    fun fadein() {
        binding.fadeIn.setOnClickListener {
            println("binding.fadeIn.setOnClickListener")
            binding.textView.visibility = View.VISIBLE
            val animationFadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
            println("binding.fadeIn.setOnClickListener")
            binding.textView.startAnimation(animationFadeIn)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThirdViewModel::class.java)
        // TODO: Use the ViewModel
    }

}