package ru.otus.marketsample.promo.feature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.common.di.findDependencies
import ru.otus.marketsample.promo.feature.di.DaggerPromoComponent
import javax.inject.Inject

class PromoListFragment : Fragment() {


    @Inject
    lateinit var factory: PromoListViewModelFactory

    private val viewModel: PromoListViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerPromoComponent.factory()
            .create(dependencies = findDependencies())
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                PromoListScreen(viewModel)
            }
        }
    }

}
