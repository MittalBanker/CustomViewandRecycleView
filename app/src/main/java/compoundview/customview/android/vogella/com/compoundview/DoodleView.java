package compoundview.customview.android.vogella.com.compoundview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by mittal.banker on 22/06/16.
 */
public class DoodleView extends View{
    private Paint _paintDoodle = new Paint();
    private Path _path = new Path();
    public DoodleView(Context context) {
        super(context);
    }

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(null,0);
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs,0);
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs,defStyleAttr);
    }
    private void  init(AttributeSet attrs, int defStyle){

        _paintDoodle.setColor(Color.RED);
        _paintDoodle.setAntiAlias(true);
        _paintDoodle.setStyle(Paint.Style.STROKE);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawLine(0,0,getWidth(),getHeight(),_paintDoodle);
        canvas.drawPath(_path,_paintDoodle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
                _path.lineTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_DOWN:
                _path.moveTo(touchX,touchY);
                break;

        }
        invalidate();
        return true;
    }
}
