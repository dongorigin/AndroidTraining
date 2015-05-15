package cn.dong.app.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

import cn.dong.app.R;
import cn.dong.app.model.MainResponseInfo;

public class MainActivity extends ActionBarActivity {
    RecyclerView mRecyclerView;
    MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new MainAdapter();
        mRecyclerView.setAdapter(mAdapter);

        fetchData();
    }

    // 网络访问
    private void fetchData() {
        String url = "http://www.duitang.com/album/1733789/masn/p/0/24/";
        new AsyncHttpClient().get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                parseData(responseString);
            }
        });
    }

    // 数据解析
    private void parseData(String responseString) {
        MainResponseInfo response = new Gson().fromJson(responseString, MainResponseInfo.class);
        mAdapter.addData(response.data.blogs);
    }

}
