package josedacosta541.gmail.com;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private TextView gestureText;
    RelativeLayout layout ;
    private GestureDetectorCompat gDetector;
    public static final  int SWIPE_THRESHOLD = 100;
    public static final  int SWIPE_VELOCITY_THRESHOLD = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (RelativeLayout) findViewById(R.id.activity_main);
        layout.setBackgroundColor(Color.WHITE);
        gestureText = (TextView)findViewById(R.id.gestureStatusText);
        this.gDetector = new GestureDetectorCompat(this,this);
        gDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        gestureText.setText ("onDown");
        layout.setBackgroundColor(Color.RED);
        return true;
    }
    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        boolean result = false;
        float diffY = event2.getY() - event1.getY();
        float diffX = event2.getY() - event1.getX();
        if (Math.abs(diffX) > Math.abs(diffY)) {
            if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    gestureText.setText("onSwipeRight");
                    layout.setBackgroundColor(Color.YELLOW);
                } else {
                    gestureText.setText("onSwipeLeft");
                    layout.setBackgroundColor(Color.BLUE);
                }
                result = true;
            }
        } else {
            if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    gestureText.setText("onSwipeBottom");
                    layout.setBackgroundColor(Color.GRAY);
                } else {
                    gestureText.setText("onSwipeTop");
                    layout.setBackgroundColor(Color.GREEN);
                }
                result = true;
            }
        }
        return result;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        gestureText.setText("onLongPress");
        layout.setBackgroundColor(Color.MAGENTA);
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        gestureText.setText("onScroll");
        layout.setBackgroundColor(Color.DKGRAY);
        return true;
    }
    @Override
    public void onShowPress(MotionEvent event) {
        gestureText.setText("onShowPress");
        layout.setBackgroundColor(Color.LTGRAY);
    }
    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        gestureText.setText("onSingleTapUp");
        layout.setBackgroundColor(Color.CYAN);
        return true;
    }
    @Override
    public boolean onDoubleTap(MotionEvent event) {
        gestureText.setText("onDoubleTap");
        layout.setBackgroundColor(Color.BLUE);
        return true;
    }
    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        gestureText.setText("onDoubleTapEvent");
        layout.setBackgroundColor(Color.GREEN);
        return true;
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        gestureText.setText("onSingleTapConfirmed");
        layout.setBackgroundColor(Color.YELLOW);
        return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}