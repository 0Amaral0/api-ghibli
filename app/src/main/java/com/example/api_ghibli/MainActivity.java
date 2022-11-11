package com.example.api_ghibli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.api_ghibli.telas.f1;
import com.example.api_ghibli.telas.f2;
import com.example.api_ghibli.telas.f3;
import com.example.api_ghibli.telas.f4;
import com.example.api_ghibli.telas.f5;
import com.example.api_ghibli.telas.f6;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int poster[] = {
            R.drawable.spirited_away,
            R.drawable.howls_moving_castle,
            R.drawable.the_cat_returns,
            R.drawable.princess_mononoke,
            R.drawable.kikis_delivery_service,
            R.drawable.my_neighbor_totoro
    };

    String titulo[] = {
            "Spirited Away",
            "Howl's Moving Castle",
            "The Cat Returns",
            "Princess Mononoke",
            "Kiki's Delivery Service",
            "My Neighbor Totoro"
    };

    String dataLancamento[] = {
            "2001",
            "2004",
            "2002",
            "1997",
            "1989",
            "1988"
    };

    GridView gridView;
    private List<ItemsModel> itemsList = new ArrayList<>();
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid_view_home);

        for (int i = 0; i < titulo.length; i++){
            ItemsModel itemsModel = new ItemsModel(titulo[i], dataLancamento[i], poster[i]);
            itemsList.add(itemsModel);
            //Log.e("TAG", "new text ==> " + titulo[i]);
        }

        customAdapter = new CustomAdapter(itemsList, this);
        gridView.setAdapter(customAdapter);
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<ItemsModel> itemsModelList;
        private List<ItemsModel> itemsModelListFiltro;
        private Context context;

        public CustomAdapter(List<ItemsModel> itemsModelList, Context context) {
            this.itemsModelList = itemsModelList;
            this.itemsModelListFiltro = itemsModelList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemsModelListFiltro.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.row_items, null);

            TextView tvTitulo = view.findViewById(R.id.textViewTitulo);
            TextView tvDataLanc = view.findViewById(R.id.textViewDataLanc);
            ImageView imageView = view.findViewById(R.id.imageViewPoster);

            tvTitulo.setText(itemsModelListFiltro.get(position).getTitulo());
            tvDataLanc.setText(itemsModelListFiltro.get(position).getDataLancamento());
            imageView.setImageResource(itemsModelListFiltro.get(position).getPoster());

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();

                    if (constraint == null || constraint.length() == 0){
                        filterResults.count = itemsModelList.size();
                        filterResults.values = itemsModelList;

                    } else {
                        String searchStr = constraint.toString().toLowerCase().trim();
                        List<ItemsModel> resultData = new ArrayList<>();

                        for (ItemsModel itemsModel:itemsModelList){
                            if (itemsModel.getTitulo().toLowerCase().contains(searchStr) ||
                                    itemsModel.getDataLancamento().contains(searchStr)){

                                resultData.add(itemsModel);
                            }

                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }

                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    itemsModelListFiltro = (List<ItemsModel>) results.values;
                    notifyDataSetChanged();
                }
            };

            return filter;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e("TAG", "new text ==> " + newText);
                customAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search_view){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}