package com.guddu.fragmentdemoone

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private var TEXT :String = "text"


class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mText: String? = null
    private lateinit var editTextFragment: EditText
    private lateinit var buttonFragment: Button
//    private lateinit var mListner : OnFragmentInteractionListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {

            mText = arguments?.getString(TEXT);
            println("\n happy in frag TEXT $TEXT")
            println("\n happy in frag mText = $mText")
        }
//        arguments?.let {
//            mText = it.getString(TEXT)
//        }
    }


    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var vie: View = inflater.inflate(R.layout.fragment_blank, container, false)
        buttonFragment = vie.findViewById(R.id.btn_frag_two)
        editTextFragment = vie.findViewById(R.id.edit_txt_frag)
        editTextFragment.setText(mText)
        editTextFragment.requestFocus()


        buttonFragment.setOnClickListener() {
            var text = editTextFragment.toString()
            editTextFragment.setBackgroundColor(R.color.colorPrimary)

//            sendBack(text)

        }

        return vie
    }

//    fun sendBack(sendBackText: String?) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(sendBackText)
//        }
//    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String): BlankFragment {
            val fragment = BlankFragment()
            val args = Bundle()
            args.putString(TEXT, param1)
            fragment.arguments = args
            return fragment
        }
    }
}