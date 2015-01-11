package com.github.polok.taggerstring.demo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvExampleOne = (TextView) findViewById(R.id.tv_example_one);

        TaggerString taggerString = TaggerString.from(getString(R.string.example_one));
        taggerString.with("user_name", "Marcin", TaggerStyleType.BOLD);
        taggerString.with("developer_role", "Android Software Developer", TaggerStyleType.UNDERLINE);

        tvExampleOne.setText(taggerString.formatCustom());

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_name", "Marcin");
        map.put("developer_role", "Android Software Developer");

        TaggerString taggerStringMap = TaggerString.from(getString(R.string.example_one));
        taggerStringMap.with(map);

        TextView tvExampleMap = (TextView) findViewById(R.id.tv_example_map);
        tvExampleMap.setText(taggerStringMap.format());

        TaggerString taggerStringMultipleStyle = TaggerString.from(getString(R.string.example_one));
        taggerStringMultipleStyle.with("user_name", "Marcin", TaggerStyleType.BOLD, TaggerStyleType.ITALIC);
        taggerStringMultipleStyle.with("developer_role", "Android Software Developer", TaggerStyleType.UNDERLINE, TaggerStyleType.BOLD, TaggerStyleType.ITALIC);

        TextView tvExampleMultipleStyle = (TextView) findViewById(R.id.tv_example_multiple_style);
        tvExampleMultipleStyle.setText(taggerStringMultipleStyle.formatCustom());
    }
}
