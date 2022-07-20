package com.cathaybk.dbs.beanknowledge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cathaybk.dbs.beanknowledge.databinding.PairWaitingFragmentBinding

class WaitingFragment : Fragment()
{
    private lateinit var binding: PairWaitingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PairWaitingFragmentBinding.inflate(inflater)
        return binding.root
    }
}
