package andy.restaurant;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import java.util.*;
import android.view.View;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button1;
    Button button2;

    ArrayList<String> Restaurant_ini(){
        ArrayList<String> initial = new ArrayList<>();
        initial.add("福鴻");
        initial.add("福鴻隔壁麵店");
        initial.add("燒肉飯");
        initial.add("紹興炒飯");
        initial.add("鴨媽");
        initial.add("羅師傅");
        initial.add("元福香菇肉羹");
        initial.add("吳記水餃");
        initial.add("阿木的店");
        initial.add("海灣拉麵");
        initial.add("鴨肉飯");
        initial.add("愛買");
        initial.add("相撲咖哩");
        initial.add("丹丹漢堡");
        initial.add("阿雪小吃");
        initial.add("湘園");
        initial.add("樓梯角");
        return initial;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        final ArrayList<String> Restaurant = Restaurant_ini();

        button1.setOnClickListener(new Button.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                count++;
                Random ran = new Random();
                int which = ran.nextInt(Restaurant.size());
                String S_which = Restaurant.get(which);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("今天吃什麼");
                if (count == 1) {
                    builder.setMessage("我們今天就去吃" + S_which + "吧!!");
                } else if (count == 2) {
                    builder.setMessage("第一個你不要喔，好吧給你第二次機會，我們去吃" + S_which + "吧!!");
                } else if (count == 3) {
                    builder.setMessage("怎麼還是不要啊，你真的很麻煩欸，給你最後一次機會，我們去吃" + S_which + "吧!!");
                } else if (count == 4) {
                    builder.setMessage("欸你不是有女友病啊，給你那麼多選擇你都不要，自己想辦法我不給你意見了");
                    count = 0;
                } else
                    builder.setMessage("Some error happened!!");
                builder.show();
            }
        });

        button2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                for(int i = 0; i < Restaurant.size(); i++){
                    textView.append(Restaurant.get(i));
                    textView.append("\r\n");
                }
            }
        });
    }
}
