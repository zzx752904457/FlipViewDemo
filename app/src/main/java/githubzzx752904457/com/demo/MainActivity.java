package githubzzx752904457.com.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import githubzzx752904457.com.demo.adapters.FliperViewAdapter;
import se.emilsjolander.flipview.FlipView;

public class MainActivity extends AppCompatActivity {
    private FlipView flipview;
    private FliperViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipview = (FlipView) findViewById(R.id.flipview);
        mAdapter = new FliperViewAdapter(this);
        flipview.setAdapter(mAdapter);

    }
}
