package com.android.playground.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.playground.R
import com.android.playground.view.presenters.AdminPanelPresenter
import com.android.playground.view.presenters.AdminPanelViewController
import com.android.playground.view.viewmodels.AdminPanelViewModel
import com.android.playground.view.viewmodels.ViewModelFactory

class AdminPanelFragment : Fragment(), AdminPanelViewController {
    private val viewModel: AdminPanelViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelFactory()
        )[AdminPanelViewModel::class.java]
    }

    private val presenter: AdminPanelPresenter by lazy { AdminPanelPresenter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_admin_panel, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this, lifecycle)
        bindUI()
    }

    private fun bindUI() {
        // TODO
    }
}
