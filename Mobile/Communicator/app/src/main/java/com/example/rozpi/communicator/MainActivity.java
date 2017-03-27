package com.example.rozpi.communicator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView messageView;
    EditText messageBox;

    String name;
    String longName;
    String message;

    ArrayList<Message> messageList = new ArrayList<>();
    MessageAdapter messageAdapter;

    Socket socket;

    DateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageAdapter = new MessageAdapter(this, messageList);
        messageBox = (EditText)findViewById(R.id.messageBox);
        messageView = (ListView) findViewById(R.id.messageList);
        messageView.setAdapter(messageAdapter);


        dateFormat = new SimpleDateFormat("HH:mm:ss");

        Intent loginIntent = getIntent();
        name = loginIntent.getStringExtra(LoginActivity.NICK);
        if(name.length()>7) {
            longName = name.substring(0, 3)+"..."+name.charAt(name.length()-1);
        }
        registerForContextMenu(messageView);

        messageBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEND) {
                    onSend(v);
                    return true;
                }else
                return false;
            }
        });

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle(name);
        menu.add(Menu.NONE, v.getId(), 0, R.string.copy);
        menu.add(Menu.NONE, v.getId(), 0, R.string.delete);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        if(item.getTitle().equals(getString(R.string.copy))){

            ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("", messageList.get(info.position).message);
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(getApplicationContext(),R.string.copied,Toast.LENGTH_SHORT).show();
        } else if(item.getTitle().equals(getString(R.string.delete))) {
            messageList.remove(info.position);
            messageAdapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(),R.string.deleted,Toast.LENGTH_SHORT).show();
        } else return false;
        return true;
    }

    public void onSend(View v) {
        message = messageBox.getText().toString();
//        String date = dateFormat.format(Calendar.getInstance().getTime());
//        Message tempMessage = new Message(name, message, date);
//        new ServerConnect(true, message, null).execute();
//        messageList.add(tempMessage);
//        messageAdapter.notifyDataSetChanged();
        new ServerConnect(true,message,SocketHandler.getSocket()).execute();
        messageBox.setText("");

    }


}
