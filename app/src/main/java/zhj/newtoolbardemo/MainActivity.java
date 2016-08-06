package zhj.newtoolbardemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolBar;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView nv_menu_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mToolBar = (Toolbar) findViewById(R.id.mToolBar);
        nv_menu_left= (NavigationView) findViewById(R.id.nv_menu_left);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        mToolBar.setTitle("标题");  //设置主标题
        setSupportActionBar(mToolBar); //设置actionbar


        getSupportActionBar().setHomeButtonEnabled(true);  //设置返回键可用

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //创建返回键，并实现打开关/闭监听

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.app_name, R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();  //初始化状态

        mDrawerLayout.addDrawerListener(mDrawerToggle); //将DrawerLayout与DrawerToggle绑定

//        mDrawerLayout.setScrimColor(Color.TRANSPARENT);   //去除侧边阴影

        //设置导航栏NavigationView的点击事件
        nv_menu_left.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item1:
                        mToolBar.setTitle("选项一");
                        break;
                    case R.id.navigation_item2:
                        mToolBar.setTitle("选项二");
                        break;
                    case R.id.navigation_item3:
                        mToolBar.setTitle("选项三");
                        break;
                    case R.id.navigation_sub_item1:
                        mToolBar.setTitle("简介");
                        break;
                    case R.id.navigation_sub_item2:
                        mToolBar.setTitle("详情");
                        break;
                    case R.id.navigation_sub_item3:
                        mToolBar.setTitle("更多");
                        break;
                }

                //将选中设为点击状态
                item.setChecked(true);
                //关闭抽屉
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
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
            if (!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };


    //设置右上角的填充菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
