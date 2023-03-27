package one.nem.hideprivacydotmodule;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;

public class HidePrivacyDotModule implements IXposedHookInitPackageResources {

    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam resparam) throws Throwable {
        if (!resparam.packageName.equals("com.android.systemui")) {
            return;
        }

        resparam.res.setReplacement("com.android.systemui", "bool", "config_enablePrivacyDot", false);
        resparam.res.setReplacement("com.android.systemui", "dimens", "dimen.ongoing_appops_dot_min_padding", 0);
    }
}



