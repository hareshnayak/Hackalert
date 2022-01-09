package com.example.hackio

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi


class DisplayFragment : Fragment() {

//    lateinit var webView: WebView
    var cont: ContestsItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cont = it.getSerializable("contest") as ContestsItem
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        webView = view.findViewById(R.id.myweb)

        var mWebView : WebView? = null
        mWebView = requireView().findViewById(R.id.myweb) as WebView?
        cont?.url?.let { mWebView?.loadUrl(it) }

//        val webSettings = mWebView?.getSettings()
//        webSettings?.setJavaScriptEnabled(true)
//        webSettings?.safeBrowsingEnabled = false
//
//        mWebView?.setWebViewClient(WebViewClient())

        mWebView?.canGoBack()
        mWebView?.setOnKeyListener( View.OnKeyListener{ v,keyCode,event ->
            if(keyCode == KeyEvent.KEYCODE_BACK && event.action == MotionEvent.ACTION_UP &&mWebView.canGoBack()){
                mWebView.goBack()
                return@OnKeyListener true
            }
            false
        } )
    }


}