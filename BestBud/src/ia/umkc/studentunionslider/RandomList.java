package ia.umkc.studentunionslider;

//import ia.umkc.studentunionslider.LinksFragment.OnLinkSelectedListener;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.internal.widget.IcsAdapterView;
import com.actionbarsherlock.internal.widget.IcsAdapterView.OnItemSelectedListener;

/**
 * @author ruf25
 * Class for Main List .
 *
 */
public class RandomList extends SherlockListFragment //implements
	//	LinksFragment.OnLinkSelectedListener, OnItemSelectedListener
{
	public ListView lv;
	public Fragment f;
	public MainActivity m;
	//OnLinkSelectedListener radio;
	private double latitudeE51 = 39.034474;
	private double longitudeE51 =-94.580972;
	boolean isNetworkEnabled= false;
	private View currentSelectedView;
	private Boolean firstTimeStartup = true;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		List<String> items = new ArrayList<String>();
		items.add("Event Finder");
		items.add("Work Stats");
		items.add("Awards");
		items.add("Videos");
		items.add("Game");
		items.add("Weather");
		items.add("Friends");
		items.add("Feedback");

		setListAdapter(new MainAdapter(getActivity(), items));
		lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parentView, View childView,
					int position, long id) {
				if (firstTimeStartup) {// first time  highlight first row
					currentSelectedView = lv.getChildAt(0);
					}
					firstTimeStartup = false; 
					if (currentSelectedView != null && currentSelectedView != childView) {
					       unhighlightCurrentRow(currentSelectedView);
					   }
					 
					currentSelectedView = childView;
					   highlightCurrentRow(currentSelectedView);
				getNextPage(position);
			}

		});
	}
	 public void disableItemSelection() {
	        ListView lv = getListView();
	        for (int i = 0; i < lv.getChildCount(); i++){
	            View v = lv.getChildAt(i);
	            v.setEnabled(false);
	        }
	    }
	private void unhighlightCurrentRow(View rowView) {
		   rowView.setBackgroundColor(Color.TRANSPARENT);
		   
		}

		private void highlightCurrentRow(View rowView) {
		   rowView.setBackgroundColor(getResources().getColor(
		         R.color.focus));
		   

		} 
	public void getNextPage(int index) {
		Context context = getActivity();
		String item = (String) getListAdapter().getItem(index);}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK) {
	        onBackPressed();
	        return true;
	    }
	    return false;
	}

	private void onBackPressed() {
		Fragment frag1 = new Fragment();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction t = fm.beginTransaction();
		t.replace(R.id.content_frame, frag1);
		t.commit(); 
	}

	

}
