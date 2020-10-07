package com.frfefreiefdrrefdre.jfrdofrdkfrefrr.bgfkjmrktlfnvblkjernfkvjnrekjfvbhkrjfbvkjrfnked.gfblrntkjbnkvrtnbkjrtnfkbvjnerkjfvnerkjlnvclkerlds;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.frfefreiefdrrefdre.jfrdofrdkfrefrr.R;

public class DvkgfrnjgkfvgfFtfrjnvgrlfvgf extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    public GestureDetectorCompat gd;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE);
        setContentView(R.layout.rfvnrjfrkvbgrf_tvgfrnkjrgfv);
        ((FrameLayout) findViewById(R.id.idFlame)).addView(new FfvgrnjkFhvffnjrtv(this));

        gd = new GestureDetectorCompat(this, this);
        gd.setOnDoubleTapListener(this);
    }

    static int maxScore = 2;
    static String SAVED_NUM = "NUMBER";
    static SharedPreferences sharedPreferences;

    static void saveData(Context context) {
        sharedPreferences = context.getSharedPreferences(SAVED_NUM, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SAVED_NUM, Integer.parseInt(String.valueOf(maxScore)));
        editor.apply();
    }

    static void loadData(Context context) {
        sharedPreferences = context.getSharedPreferences(SAVED_NUM, MODE_PRIVATE);
        maxScore = sharedPreferences.getInt(SAVED_NUM, 2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gd.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        boolean result = false;
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        if (FfvgrnjkFhvffnjrtv.activeVx != -1) {
                            FfvgrnjkFhvffnjrtv.vx = 1;
                            FfvgrnjkFhvffnjrtv.vy = 0;
                        }
                    } else {
                        if (FfvgrnjkFhvffnjrtv.activeVx != 1) {
                            FfvgrnjkFhvffnjrtv.vx = -1;
                            FfvgrnjkFhvffnjrtv.vy = 0;
                        }
                    }
                    result = true;
                }
            } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    if (FfvgrnjkFhvffnjrtv.activeVy != -1) {
                        FfvgrnjkFhvffnjrtv.vx = 0;
                        FfvgrnjkFhvffnjrtv.vy = 1;
                    }
                } else {
                    if (FfvgrnjkFhvffnjrtv.activeVy != 1) {
                        FfvgrnjkFhvffnjrtv.vx = 0;
                        FfvgrnjkFhvffnjrtv.vy = -1;
                    }
                }
                result = true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
}
