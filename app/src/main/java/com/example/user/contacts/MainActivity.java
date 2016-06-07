package com.example.user.contacts;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    static  public ContactListAdapter mAdapter;
    static  ListView lstv;
    static ArrayList<contactWrapper> contactList;
    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstv=(ListView)findViewById(R.id.listView);
         context=this;
        contactList = new ArrayList<contactWrapper>();

        ContentResolver resolver = getContentResolver();
        Cursor cursor=resolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);


        while(cursor.moveToNext()){

            contactWrapper contactInstance=new contactWrapper();


            String id= cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            Cursor phCursor=resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?", new String[]{id}, null);

            String phNumber="";
            while(phCursor.moveToNext()){
                 String Number=phCursor.getString(phCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                  phNumber=Number+"   "+phNumber;
            }

            contactInstance.set_id(id);
            contactInstance.set_name(name);
            contactInstance.set_numbers(phNumber);

             contactList.add(contactInstance);

        }


        setContactAdapter(contactList);

    }



    static	private void setContactAdapter(ArrayList<contactWrapper> List) {
        // TODO Auto-generated method stub
        mAdapter = new ContactListAdapter(context, List);
        lstv.setAdapter(mAdapter);

        Collections.sort(List, new Comparator<contactWrapper>() {

            @Override
            public int compare(contactWrapper lhs, contactWrapper rhs) {
                // TODO Auto-generated method stub
                return Integer.parseInt(rhs.get_id())  - Integer.parseInt(lhs.get_id());
            }

        });


    }




}
