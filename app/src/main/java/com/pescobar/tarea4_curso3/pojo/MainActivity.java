package com.pescobar.tarea4_curso3.pojo;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.pescobar.tarea4_curso3.R;
import com.pescobar.tarea4_curso3.adaptadores.PageAdapter;
import com.pescobar.tarea4_curso3.fragmentos.PerfilFragment;
import com.pescobar.tarea4_curso3.fragmentos.RecyclerViewFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       toolbar= (Toolbar) findViewById(R.id.toolbar);
       tabLayout= (TabLayout) findViewById(R.id.tabLayout);
       viewPager= (ViewPager) findViewById(R.id.viewpager);

        setUpViewPager();

         //if (toolbar !=null){
          //  setSupportActionBar(toolbar);
       // }


    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments= new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        //Inicializar los fragments
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.tabprincipalmascotas);
        tabLayout.getTabAt(1).setIcon(R.drawable.tabperfilmascota);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuContacto:
                Intent intent= new Intent(this, Pantalla_SolicitudDatos.class);
                startActivity(intent);
                break;
            case R.id.menuAcercaDe:
                Intent intent2= new Intent(this, Pantalla_AcercaDe.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
