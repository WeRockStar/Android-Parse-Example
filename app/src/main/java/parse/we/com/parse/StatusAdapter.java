package parse.we.com.parse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.List;

/**
 * Created by Kotchaphan Muangsan on 19/8/2558.
 */
public class StatusAdapter extends ArrayAdapter<ParseObject> {

    protected Context context;
    protected List<ParseObject> mStatus;

    public StatusAdapter(Context context, List<ParseObject> status) {
        super(context, R.layout.homepage_custom_layout);
        this.context = context;
        this.mStatus = status;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.homepage_custom_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.usernameHomepage = (TextView) convertView.findViewById(R.id.username);
            viewHolder.statusHomepage = (TextView) convertView.findViewById(R.id.comment);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ParseObject parseObject = mStatus.get(position);

        // title
        String username = parseObject.getString("username");
        viewHolder.usernameHomepage.setText(username);

        // comment status
        String status = parseObject.getString("status");
        viewHolder.statusHomepage.setText(status);

        return convertView;
    }

    public static class ViewHolder {
        TextView usernameHomepage;
        TextView statusHomepage;

    }
}
