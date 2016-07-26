package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class HistoryAdapter extends BaseAdapter {
    private Context context;
    private String[] Ref, IDUser, Date, Name, Surname, Address, Product, Price,
            Piece, Total, Status;

    public HistoryAdapter(Context context,
                          String[] Ref,
                          String[] IDUser,
                          String[] Date,
                          String[] Name,
                          String[] Surname,
                          String[] Address,
                          String[] Product,
                          String[] Price,
                          String[] Piece,
                          String[] Total,
                          String[] Status) {
        this.context = context;
        this.Ref = Ref;
        this.IDUser = IDUser;
        this.Date = Date;
        this.Name = Name;
        this.Surname = Surname;
        this.Address = Address;
        this.Product = Product;
        this.Price = Price;
        this.Piece = Piece;
        this.Total = Total;
        this.Status = Status;

    }
    @Override
    public int getCount() {
        return Ref.length;
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
        View view1 = layoutInflater.inflate(R.layout.history_listview, viewGroup, false);

        TextView dateTextView = (TextView) view1.findViewById(R.id.textView30);
        dateTextView.setText(Date[i]);

        TextView refTextView = (TextView) view1.findViewById(R.id.textView32);
        refTextView.setText(Ref[i]);

        TextView totalTextView = (TextView) view1.findViewById(R.id.textView34);
        totalTextView.setText(Total[i]);

        TextView statusTextView = (TextView) view1.findViewById(R.id.textView36);
        statusTextView.setText(Status[i]);

        return view1;
    }
}
