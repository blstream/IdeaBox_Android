package ideabox.intive.mvvm;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;

/**
 * Created by Artur on 16.03.2018.
 * Basic Model for application
 */

public class IdeaModel {
    public Boolean IdeaItem;

    public IdeaModel(boolean ideaItem) {
        this.IdeaItem = ideaItem;
    }

}
