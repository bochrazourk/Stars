package ma.emsi.second_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import ma.emsi.second_app.classes.Star;
import ma.emsi.second_app.service.StarService;

public class MainActivity extends AppCompatActivity {
    private static String TAG="MainActivity";

    private List<Star> stars;
    private RecyclerView recycleView;
    private StarAdapter starAdapter;
    private StarService service ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        stars = new ArrayList<Star>();
        service = StarService.getInstance();
        init();
        stars.addAll(service.findAll());
        recycleView =findViewById(R.id.recycle);
        starAdapter = new StarAdapter(this, stars);
        recycleView.setAdapter(starAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recycleView);


    }
    public void init(){
        service.create(new Star("deepika padukone", "https://cdn.pixabay.com/photo/2017/09/23/17/29/deepika-padukone-2779557_960_720.jpg", 5f));
        service.create(new Star("aditi rao hydari", "https://cdn.pixabay.com/photo/2016/10/17/19/25/aditi-rao-hydari-1748439_960_720.jpg", 3));
        service.create(new Star("jackie chan",
                "https://cdn.pixabay.com/photo/2017/08/28/10/47/jackie-chan-2689112_960_720.jpg", 5));
        service.create(new Star("Will Smith", "https://media1.woopic.com/api/v1/images/174%2Fwebedia-cine-news%2F580%2Fba6%2Fb2317de84b54672baa9676b082%2Funivers-dc-quels-sont-les-acteurs-les-plus-riches%7C1287202-will-smith-a-l-avant-premiere-de-suicid-orig-1.jpg?facedetect=1&quality=85", 1));
        service.create(new Star("Sarah ", "https://cdn.pixabay.com/photo/2017/07/25/21/47/woman-2539676_960_720.jpg", 5));
        service.create(new Star("grace kelly", "https://cdn.pixabay.com/photo/2013/03/06/01/01/grace-kelly-90774_960_720.jpg", 1));
        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView)
                MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (starAdapter != null){
                    starAdapter.getFilter().filter(newText);
                }
                return true; }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.share){
            String txt = "Doctors";
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Doctors")
                    .setText(txt)
                    .startChooser();
        }
        return super.onOptionsItemSelected(item);
    }
    ItemTouchHelper.SimpleCallback itemTouchHelperCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            stars.remove(position);
            starAdapter.notifyItemRemoved(position);
        }
    };




}