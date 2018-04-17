package intive.ideabox.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import intive.ideabox.R;
import intive.ideabox.activity.MainActivity;
import intive.ideabox.databinding.FragmentQuitAddIdeaBinding;
import intive.ideabox.viewmodel.QuitAddIdeaViewModel;

public class QuitAddIdeaDialogFragment  extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FragmentQuitAddIdeaBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.fragment_quit_add_idea, null, false);
        Dialog dialog  = new AlertDialog.Builder(getActivity())
                .setView(binding.getRoot())
                .create();
        QuitAddIdeaViewModel quitAddIdeaViewModel = new QuitAddIdeaViewModel(((MainActivity)getActivity()),dialog);
        binding.setDialogViewModel(quitAddIdeaViewModel);
        return dialog;

    }
}
