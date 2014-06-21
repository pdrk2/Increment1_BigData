package ia.umkc.studentunionslider;



import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
	EditText password, username;
	Button login;
	String user,pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.login);

		//getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
			//	R.layout.activity_login);
		
		TextView title = (TextView) findViewById(R.id.title);
		title.setText("Welcome to Let's Chat :)");
		
		final Context context = this;
		

		username = (EditText) findViewById(R.id.editText1);
		password = (EditText) findViewById(R.id.editText2);
		
		
		login = (Button)findViewById(R.id.button1);
		login.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				user = username.getText().toString();
				pass = password.getText().toString();

				System.out.println("the values of the login are "+user+" "+pass);
				if(user.equalsIgnoreCase("test1")&& pass.equalsIgnoreCase("test1"))
				{
							
					System.out.println("I am in the login");
					Intent intent = new Intent(getApplicationContext(),
							MainActivity.class);
					startActivity(intent);
				}
				else
				{
					username.setText("");
					password.setText("");
					Toast.makeText(getBaseContext(), "Inavlid Username/Password", Toast.LENGTH_SHORT).show();
				}
			}
			
			
		});
		
	}


}



