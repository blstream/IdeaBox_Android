package intive.ideabox.fragment;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import intive.ideabox.R;
import intive.ideabox.adapter.IdeaListAdapter;
import intive.ideabox.databinding.FragmentIdeaListBinding;
import intive.ideabox.viewmodel.IdeaListViewModel;

public class IdeaListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private RecyclerView mRecyclerView;
    private IdeaListAdapter mIdeaListAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public IdeaListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_idea_list, container, false);

        FragmentIdeaListBinding fragmentIdeaListBinding = FragmentIdeaListBinding.bind(view);
        IdeaListViewModel ideaListViewModel = new IdeaListViewModel();
        fragmentIdeaListBinding.setViewModel(ideaListViewModel);

        mRecyclerView = view.findViewById(R.id.idea_recycler);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mIdeaListAdapter = new IdeaListAdapter();
        mRecyclerView.setAdapter(mIdeaListAdapter);

        return fragmentIdeaListBinding.getRoot();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        //Update this later
        return new CursorLoader(getContext(), null, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if(cursor != null){
            mIdeaListAdapter.setCursor(cursor);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mIdeaListAdapter.setCursor(null);
    }
}
