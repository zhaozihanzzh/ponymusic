package me.wcy.music.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

import me.wcy.music.BuildConfig;
import me.wcy.music.R;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportFragmentManager().beginTransaction().replace(R.id.ll_fragment_container, new AboutFragment()).commit();
    }

    public static class AboutFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceClickListener {
        private Preference mVersion;
        private Preference mShare;
        private Preference mStar;
        private Preference mWeibo;
        private Preference mJianshu;
        private Preference mGithub;
        private Preference mPort;

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            addPreferencesFromResource(R.xml.preference_about);

            mVersion = findPreference("version");
            mShare = findPreference("share");
            mStar = findPreference("star");
            mWeibo = findPreference("weibo");
            mJianshu = findPreference("jianshu");
            mGithub = findPreference("github");
            mPort = findPreference("port");
            mVersion.setSummary("v " + BuildConfig.VERSION_NAME);
            setListener();
        }

        private void setListener() {
            mShare.setOnPreferenceClickListener(this);
            mStar.setOnPreferenceClickListener(this);
            mWeibo.setOnPreferenceClickListener(this);
            mJianshu.setOnPreferenceClickListener(this);
            mGithub.setOnPreferenceClickListener(this);
            mPort.setOnPreferenceClickListener(this);
        }

        @Override
        public boolean onPreferenceClick(Preference preference) {
            if (preference == mShare) {
                share();
                return true;
            } else if (preference == mStar) {
                openUrl(getString(R.string.about_project_url));
                return true;
            } else if (preference == mWeibo || preference == mJianshu || preference == mGithub) {
                openUrl(preference.getSummary().toString());
                return true;
            } else if (preference == mPort) {
                openUrl(mPort.getSummary().toString());
                return true;
            }
            return false;
        }

        private void share() {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_app, getString(R.string.app_name)));
            startActivity(Intent.createChooser(intent, getString(R.string.share)));
        }

        private void openUrl(String url) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
    }
}
