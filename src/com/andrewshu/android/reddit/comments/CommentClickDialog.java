package com.andrewshu.android.reddit.comments;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

import com.andrewshu.android.reddit.R;

public class CommentClickDialog extends Dialog {

	private int layout;
	
	public CommentClickDialog(Context context, int theme, boolean leftHanded) {
		super(context, theme);

		if (leftHanded) this.layout = R.layout.comment_click_dialog_lefth;
		else this.layout = R.layout.comment_click_dialog;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	
		setContentView(this.layout);

		Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

		LayoutParams params = getWindow().getAttributes();
		params.width = LayoutParams.FILL_PARENT;
		if (display.getOrientation() == Configuration.ORIENTATION_LANDSCAPE)
			params.height = LayoutParams.FILL_PARENT;
		getWindow().setAttributes((android.view.WindowManager.LayoutParams) params); 
	}
}
