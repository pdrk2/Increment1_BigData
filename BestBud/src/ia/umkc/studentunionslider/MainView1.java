package ia.umkc.studentunionslider;

import com.actionbarsherlock.app.SherlockFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * @author ruf25
 * Class for Home Screen for tablet .
 *
 */
public class MainView1 extends SherlockFragment{
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);
	}
    @Override	
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {	
    	return inflater.inflate(R.layout.activity_main, container, false);
    }
 
}
