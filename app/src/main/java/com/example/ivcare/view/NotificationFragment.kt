package com.example.ivcare.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ivcare.R
import com.example.ivcare.view.notification.NotificationContent

/**
 * A fragment representing a list of Items.
 */
class NotificationFragment : Fragment() {

    private var columnCount = 1
    private var columnText = String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
            columnText = it.getString(ARG_COLUMN_TEXT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyNotificationRecyclerViewAdapter(NotificationContent.ITEMS)
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"
        const val ARG_COLUMN_TEXT = "column-text"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int, columnText: String) =
            NotificationFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                    putString(ARG_COLUMN_TEXT, columnText)
                }
            }
    }
}