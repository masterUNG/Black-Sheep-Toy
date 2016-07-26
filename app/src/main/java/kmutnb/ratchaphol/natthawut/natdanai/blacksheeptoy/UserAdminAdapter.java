package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by teay on 7/7/2016.
 */
public class UserAdminAdapter extends BaseAdapter {
    //Explicit
    private Context context;
    private String[] userStrings, nameStrings, surnameStrings, emailStrings, phoneStrings;

    public UserAdminAdapter(Context context,
                      String[] userStrings,
                      String[] nameStrings,
                      String[] surnameStrings,
                      String[] emailStrings,
                      String[] phoneStrings
    ) {
        this.context = context;
        this.userStrings = userStrings;
        this.nameStrings = nameStrings;
        this.surnameStrings = surnameStrings;
        this.emailStrings = emailStrings;
        this.phoneStrings = phoneStrings;


    }
    @Override
    public int getCount() {
        return userStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.
                LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.user_listview, parent, false);

        TextView userTextView = (TextView) view1.findViewById(R.id.user);
        TextView nameTextView = (TextView) view1.findViewById(R.id.name);
        TextView surnameTextView = (TextView) view1.findViewById(R.id.surname);
        TextView emailTextView = (TextView) view1.findViewById(R.id.email);
        TextView phoneTextView = (TextView) view1.findViewById(R.id.phone);

        userTextView.setText("User : " + userStrings[position]);
        nameTextView.setText("Name : " + nameStrings[position]);
        surnameTextView.setText(surnameStrings[position] );
        emailTextView.setText("E-mail : " + emailStrings[position]);
        phoneTextView.setText("Phone : " + phoneStrings[position]);

        return view1;


    }
}
