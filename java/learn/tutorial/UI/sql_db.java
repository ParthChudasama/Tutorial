package learn.tutorial.UI;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import learn.tutorial.Data.DBmanager;
import learn.tutorial.Data.DatabaseHelper;
import learn.tutorial.R;


// Android SQLite is the mostly preferred way to store data for android applications.
// For many applications, SQLite is the apps backbone w
// hether it’s used directly or via some third-party wrapper.

//****************Android SQLite***********************
//Android SQLite is a very lightweight database which comes with Android OS.
// Android SQLite combines a clean SQL interface with a very small memory footprint and decent speed.
// For Android, SQLite is “baked into” the Android runtime,
// so every Android application can create its own SQLite databases.
//Android SQLite native API is not JDBC, as JDBC might be too much overhead for a memory-limited smartphone.
// Once a database is created successfully its located in data/data//databases/ accessible from Android Device Monitor.

//SQLite is a typical relational database, containing tables (which consists of rows and columns), indexes etc.
// We can create our own tables to hold the data accordingly. This structure is referred to as a schema.

//*************Android SQLite SQLiteOpenHelper************************
//
//        Android has features available to handle changing database schemas,
// which mostly depend on using the SQLiteOpenHelper class.

//SQLiteOpenHelper is designed to get rid of two very common problems.
//
//   1.   When the application runs the first time – At this point, we do not yet have a database.
// So we will have to create the tables, indexes, starter data, and so on.
//   2.   When the application is upgraded to a newer schema –
// Our database will still be on the old schema from the older edition of the app.
//          We will have option to alter the database schema to match the needs of the rest of the app.

//SQLiteOpenHelper wraps up these logic to create and upgrade a database as per our specifications.
// For that we’ll need to create a custom subclass of SQLiteOpenHelper implementing at least the following three methods.

//  1.Constructor : This takes the Context (e.g., an Activity), the name of the database, an optional cursor factory,
//              and an integer representing the version of the database schema you are using (typically starting from 1 and increment later).
//      public DatabaseHelper(Context context) {
//        super(context, DB_NAME, null, DB_VERSION);
//        }
//  2. onCreate(SQLiteDatabase db) : It’s called when there is no database and the app needs one.
//      It passes us a SQLiteDatabase object, pointing to a newly-created database, that we can populate with tables and initial data.
//  3. onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) :
// It’s called when the schema version we need does not match the schema version of the database,
//      It passes us a SQLiteDatabase object and the old and new version numbers.
// Hence we can figure out the best way to convert the database from the old schema to the new one.
//        We define a DBManager class to perform all database CRUD(Create, Read, Update and Delete) operations.

//*********************Opening and Closing Android SQLite Database Connection*******************************

//Before performing any database operations like insert, update, delete records in a table,
// first open the database connection by calling getWritableDatabase() method as shown below:
//
//public DBManager open() throws SQLException {
//        dbHelper = new DatabaseHelper(context);
//        database = dbHelper.getWritableDatabase();
//        return this;
//        }
//        The dbHelper is an instance of the subclass of SQLiteOpenHelper.
//
//        To close a database connection the following method is invoked.
//
//public void close() {
//        dbHelper.close();
//        }

//**************************Inserting new Record into Android SQLite database table****************************
//
//        The following code snippet shows how to insert a new record in the android SQLite database.
//
//public void insert(String name, String desc) {
//        ContentValues contentValue = new ContentValues();
//        contentValue.put(DatabaseHelper.SUBJECT, name);
//        contentValue.put(DatabaseHelper.DESC, desc);
//        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
//        }
//        Content Values creates an empty set of values using the given initial size.
//
//****************Updating Record in Android SQLite database table*********************************
//
//        The following snippet shows how to update a single record.
//
//public int update(long _id, String name, String desc) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHelper.SUBJECT, name);
//        contentValues.put(DatabaseHelper.DESC, desc);
//        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
//        return i;
//        }
// ********************************Android SQLite – Deleting a Record**************************
//
//        We just need to pass the id of the record to be deleted as shown below.
//
//public void delete(long _id) {
//        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
//        }

//************************** Android SQLite Cursor ************************************
//
//        A Cursor represents the entire result set of the query.
// Once the query is fetched a call to cursor.moveToFirst() is made.
// Calling moveToFirst() does two things:
//
//     1.   It allows us to test whether the query returned an empty set (by testing the return value)
//     2.   It moves the cursor to the first result (when the set is not empty)
//
// The following code is used to fetch all records:
//
//public Cursor fetch() {
//        String[] columns = new String[] {
// DatabaseHelper._ID, DatabaseHelper.SUBJECT, DatabaseHelper.DESC };
//        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
//        if (cursor != null) {
//        cursor.moveToFirst();
//        }
//        return cursor;
//        }
//        Another way to use a Cursor is to wrap it in a CursorAdapter.
// Just as ArrayAdapter adapts arrays, CursorAdapter adapts Cursor objects,
//          making their data available to an AdapterView like a ListView.

// create records that store Country names and their respective currencies in the form of a ListView.

public class sql_db extends AppCompatActivity {
    private DBmanager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[]
            { DatabaseHelper._ID,
                    DatabaseHelper.SUBJECT, DatabaseHelper.DESC };

    final int[] to = new int[]
            { R.id.idViewRecord,
                    R.id.titleViewRecord,
                    R.id.descViewRecord };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_db);
        dbManager = new DBmanager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = (ListView) findViewById(R.id.list_view);
        TextView txtVwEmpty = (TextView) findViewById(R.id.empty);
        listView.setEmptyView(txtVwEmpty);

        adapter = new SimpleCursorAdapter(this, R.layout.view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.idViewRecord);
                TextView titleTextView = (TextView) view.findViewById(R.id.titleViewRecord);
                TextView descTextView = (TextView) view.findViewById(R.id.descViewRecord);

                String id = idTextView.getText().toString();
                String title = titleTextView.getText().toString();
                String desc = descTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), modify_country.class);
                modify_intent.putExtra("title", title);
                modify_intent.putExtra("desc", desc);
                modify_intent.putExtra("id", id);

                startActivity(modify_intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_db, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_record_menu) {

            Intent add_mem = new Intent(this, add_country.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }

}

