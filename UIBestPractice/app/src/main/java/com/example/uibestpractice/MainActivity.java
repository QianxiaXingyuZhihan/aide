package com.example.uibestpractice;

import android.app.*;
import android.os.*;
import java.util.*;
import android.support.v7.widget.*;
import android.widget.*;
import android.text.*;
import android.view.View.*;
import android.view.*;

public class MainActivity extends Activity {
	
	private List<Msg> msgList = new ArrayList<>();
	
	private EditText inputText;
	
	private Button send;
	
	private RecyclerView msgRecyclerView;
	
	private MsgAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		initMsgs();
		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.send);
		msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		msgRecyclerView.setLayoutManager(layoutManager);
		adapter = new MsgAdapter(msgList);
		msgRecyclerView.setAdapter(adapter);
		send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v){
				String content = inputText.getText().toString();
				if (!"".equals(content)) {
					Msg msg = new Msg(content, Msg.TYPE_SENT);
					msgList.add(msg);
					adapter.notifyItemInserted(msgList.size() - 1);
					msgRecyclerView.scrollToPosition(msgList.size() - 1);
					inputText.setText("");
				}
			}
		});
    }
	
	private void initMsgs() {
		Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
		msgList.add(msg1);
		Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
		msgList.add(msg2);
		Msg msg3 = new Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED);
		msgList.add(msg3);
	}
	
}
