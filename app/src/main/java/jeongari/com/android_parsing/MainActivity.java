package jeongari.com.android_parsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;


public class MainActivity extends AppCompatActivity {

    TextView textview;
    Button getActionBtn;
    Runnable task;
    String html;

    String givenUrl = "http://news.joins.com/article/22123706";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        textview = (TextView) findViewById(R.id.textview);
        getActionBtn = (Button) findViewById(R.id.getActionBtn);
        getActionBtn.setOnClickListener(mClickListener);


        task = new Runnable(){

            public void run(){

                html = getHtmltoText(givenUrl);

            }

        };

    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {

            Thread thread = new Thread(task);
            thread.start();

            try{

                thread.join();  // 쓰레드 작업 끝날때까지 다른 작업들은 대기

            }catch(Exception e){



            }

            textview.setText(html);


        }
    };

    public String getHtmltoText(String sourceUrlString) {
        List<Element> contents = null;
        String content ="";

        try {

             URL sUrl = new URL(sourceUrlString);
             InputStream is = sUrl.openStream();
             Source source= new Source(new InputStreamReader(is,"utf-8"));

            // 전체 소스 구문을 분석한다.
            source.fullSequentialParse();
            // HTML markup에서 text contents만 가져와서 스트링으로 변환한다.
            contents=source.getAllElements(HTMLElementName.BODY);
            content = source.getAllElements(HTMLElementName.BODY).toString();


//            for(int i =0; i<contents.size();i++)
//            {
//                Element element = (Element)contents.get(i);
//                String txt = element.getAttributes().toString();
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }


}
