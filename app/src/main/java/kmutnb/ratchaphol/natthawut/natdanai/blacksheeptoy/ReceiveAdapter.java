package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ReceiveAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] productStrings, priceStrings, amountStrings;

    public ReceiveAdapter(Context context,
                          String[] productStrings,
                          String[] priceStrings,
                          String[] amountStrings) {
        this.context = context;
        this.productStrings = productStrings;
        this.priceStrings = priceStrings;
        this.amountStrings = amountStrings;
    }

    @Override
    public int getCount() {
        return productStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.
                LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.receive_listview, viewGroup, false);

        TextView productTextView = (TextView) view1.findViewById(R.id.textView20);
        productTextView.setText(productStrings[i]);

        TextView priceTextView = (TextView) view1.findViewById(R.id.textView21);
        priceTextView.setText(priceStrings[i]);

        TextView amountTextview = (TextView) view1.findViewById(R.id.textView38);
        amountTextview.setText(amountStrings[i]);

        return view1;
    }
} //Main Class
