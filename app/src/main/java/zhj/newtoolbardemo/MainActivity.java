package zhj.newtoolbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mToolBar = (Toolbar) findViewById(R.id.mToolBar);

        mToolBar.setTitle("标题");  //设置主标题
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    //    mToolBar.setNavigationIcon(R.mipmap.ic_launcher);  //设置导航栏图标
        mToolBar.setLogo(R.mipmap.ic_launcher); //设置app logo
        mToolBar.setSubtitle("子标题"); //设置子标题

        // 设置菜单点击监听
        mToolBar.setOnMenuItemClickListener(onMenuItemClick);
    }
    // 菜单的点击回调
    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_1:
                    msg += "点击其他1";
                    break;
                case R.id.action_tip:
                    msg += "点击提醒";
                    break;
                case R.id.action_menu:
                    msg += "点击设置";
                    break;
            }
            if(!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };


    //设置右上角的填充菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
