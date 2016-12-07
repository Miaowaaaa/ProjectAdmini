package cn.scrovor.admini;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import cn.scrovor.admini.Fragments.FindFragment;
import cn.scrovor.admini.Fragments.GroupFragment;
import cn.scrovor.admini.Fragments.ScheduleFragment;
import cn.scrovor.admini.Fragments.UserFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imSchedule;
    private ImageView imGroup;
    private ImageView imFind;
    private ImageView imUser;

    private Fragment frgSchedule;
    private Fragment frgGroup;
    private Fragment frgFind;
    private Fragment frgUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWindow();
    }
    private void initWindow(){
        imFind = (ImageView)findViewById(R.id.imFind);
        imGroup = (ImageView)findViewById(R.id.imGroup);
        imSchedule = (ImageView)findViewById(R.id.imSchedule);
        imUser = (ImageView)findViewById(R.id.imUser);
    }
    @Override
    public void onClick(View v) {
        resetImages();
        switch (v.getId()){
            case R.id.find:
                imFind.setImageResource(R.drawable.around_push);
                setSelect(0);
                break;
            case R.id.group:
                imGroup.setImageResource(R.drawable.message_push);
                setSelect(1);
                break;
            case R.id.schedule:
                imSchedule.setImageResource(R.drawable.calendar_push);
                setSelect(2);
                break;
            case R.id.user:
                imUser.setImageResource(R.drawable.user_push);
                setSelect(3);
                break;
            default:break;
        }
    }
    private void resetImages(){
        imFind.setImageResource(R.drawable.around);
        imUser.setImageResource(R.drawable.user);
        imSchedule.setImageResource(R.drawable.calendar);
        imGroup.setImageResource(R.drawable.message);
    }
    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        // 把图片设置为亮的
        // 设置内容区域
        switch (i) {
            case 0:
                if (frgSchedule == null) {
                    frgSchedule = new ScheduleFragment();
                    transaction.add(R.id.content, frgSchedule);
                } else {
                    transaction.show(frgSchedule);
                }
                imSchedule.setImageResource(R.drawable.calendar_push);
                break;
            case 1:
                if (frgGroup == null) {
                    frgGroup = new GroupFragment();
                    transaction.add(R.id.content, frgGroup);
                } else {
                    transaction.show(frgGroup);
                }
                imGroup.setImageResource(R.drawable.message_push);
                break;
            case 2:
                if (frgFind == null) {
                    frgFind = new FindFragment();
                    transaction.add(R.id.content, frgFind);
                } else {
                    transaction.show(frgFind);
                }
                imFind.setImageResource(R.drawable.around_push);
                break;
            case 3:
                if (frgUser == null) {
                    frgUser = new UserFragment();
                    transaction.add(R.id.content, frgUser);
                } else {
                    transaction.show(frgUser);
                }
                imUser.setImageResource(R.drawable.user_push);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (frgSchedule != null) {
            transaction.hide(frgSchedule);
        }
        if (frgGroup != null) {
            transaction.hide(frgGroup);
        }
        if (frgFind != null) {
            transaction.hide(frgFind);
        }
        if (frgUser != null) {
            transaction.hide(frgUser);
        }
    }
}
