package amirz.shade;

import android.app.Activity;

import com.android.launcher3.R;
import com.android.launcher3.Utilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShadeStyle {
    public static final String KEY_THEME = "pref_theme";

    private static final Map<String, Integer> sThemes;

    static {
        Map<String, Integer> themes = new HashMap<>();
        themes.put("sunset", R.style.ShadeOverride_Sunset);
        themes.put("ocean", R.style.ShadeOverride_Ocean);
        themes.put("twilight", R.style.ShadeOverride_Twilight);
        sThemes = Collections.unmodifiableMap(themes);
    }

    public static void override(Activity activity) {
        String theme = Utilities.getPrefs(activity).getString(KEY_THEME, "");
        //noinspection ConstantConditions
        int override = sThemes.getOrDefault(theme, R.style.ShadeOverride);
        activity.getTheme().applyStyle(override, true);
    }
}