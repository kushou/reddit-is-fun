package com.andrewshu.android.reddit.comments;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

import com.andrewshu.android.reddit.R;
import com.andrewshu.android.reddit.settings.RedditSettings;;

public class CommentClickDialog extends Dialog {

	private Context mContext = null;
	private RedditSettings mSettings = null;
	
	public CommentClickDialog(Context context, int theme) {
		super(context, theme);
		this.mContext = context;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		if (mSettings == null)
		{
			mSettings = new RedditSettings();
			mSettings.loadRedditPreferences(this.mContext, null);
		}
		
		if (!mSettings.isLeftHanded())
			setContentView(R.layout.comment_click_dialog);
		else
			setContentView(R.layout.comment_click_dialog_lefth);

		Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

		LayoutParams params = getWindow().getAttributes();
		params.width = LayoutParams.FILL_PARENT;
		if (display.getOrientation() == Configuration.ORIENTATION_LANDSCAPE)
			params.height = LayoutParams.FILL_PARENT;
		getWindow().setAttributes((android.view.WindowManager.LayoutParams) params); 
	}

}
