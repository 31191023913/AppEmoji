package com.example.appemojigame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    GridView mygridview;
    TextView emojiF;
    int wrong = 2;

    static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mygridview = findViewById(R.id.mygridview);
        emojiF = findViewById(R.id.emojiF);

        runGame(mygridview,emojiF);

        mygridview.setOnItemClickListener((adapterView, view, i, l) -> {
            TextView click = (TextView) view;
            if(emojiF.getText().hashCode() == click.getText().hashCode()){
                Intent win = new Intent(view.getContext(), YWinActivity.class);
                startActivity(win);
            }else{
                wrong--;
                if(wrong<0){
                    Intent lose = new Intent(view.getContext(), YLoseActivity.class);
                    startActivity(lose);
                }else{
                    Toast.makeText(getApplicationContext(), "You only have "+ wrong +" live left.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void runGame(GridView mygridview, TextView emojiF){
        int[] emoji = { 0x1F600, 0x1F601, 0x1F605,0x1F606,0x1F923, 0x1F971,
                0x1F607, 0x1F970, 0x1F60D, 0x1F929, 0x1F973, 0x1F619,
                0x1F911, 0x1F912, 0x1F60E, 0x1F92A, 0x1F917, 0x1F914,
                0x1F910, 0x1F60B, 0x1F644, 0x1F634, 0x1F614, 0x1F62A};


        List<String> data = new ArrayList();
        shuffleArray(emoji);

        for (int a =0 ; a<20; a++){
            data.add(new String(Character.toChars(emoji[a])));
        }
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(),R.layout.items, data);
        mygridview.setAdapter(myAdapter);
        Random random = new Random();
        emojiF.setText(data.get(random.nextInt(30)));
    }


}