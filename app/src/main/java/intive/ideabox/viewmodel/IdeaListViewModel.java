package intive.ideabox.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import intive.ideabox.model.FirebaseProvider;
import intive.ideabox.model.IdeaData;
import intive.ideabox.utility.FragmentState;
import intive.ideabox.utility.NavigationUtils;

public class IdeaListViewModel extends ViewModel {

    public IdeaListViewModel() {}

    public LiveData<List<IdeaData>> getIdeas() {
        DetailIdeaViewModel.statuses = FirebaseProvider.getInstance().getStatuses();
        return FirebaseProvider.getInstance().getIdeas();

    }

    public void onFabClick() {
        NavigationUtils.getInstance().setState(FragmentState.AddIdea);
    }

    public void addVote(IdeaData ideaData) {
        FirebaseProvider.getInstance().addVoteForIdea(ideaData);
    }
    public void goToIdeaDetails(IdeaData choosenIdea){
        DetailIdeaViewModel.choosenIdea.set(choosenIdea);
        NavigationUtils.getInstance().setState(FragmentState.DetailIdea);
    }
}
