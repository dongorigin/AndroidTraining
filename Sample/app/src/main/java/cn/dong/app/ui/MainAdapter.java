package cn.dong.app.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cn.dong.app.R;
import cn.dong.app.model.MainResponseInfo;

/**
 * @author dong on 15/5/15.
 */
class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemViewHolder> {
    List<MainResponseInfo.Blog> mData = new ArrayList<>();

    public void addData(List<MainResponseInfo.Blog> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        MainResponseInfo.Blog item = mData.get(position);
        holder.textView.setText(item.msg);
        // 图片加载
        Picasso.with(holder.itemView.getContext()).load(item.isrc).into(holder.imageView);
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
