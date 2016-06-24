package compoundview.customview.android.vogella.com.compoundview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mittal.banker on 22/06/16.
 */
public class LovelyView extends View {
    private int circleCol, labelCol;
    private Paint _paintDoodle = new Paint();

    //label text
    private String circleText;
    //paint for drawing custom view
    public LovelyView(Context context) {
        super(context);
    }

    public LovelyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LovelyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.LovelyView, 0, 0);
        try{
            circleText = a.getString(R.styleable.LovelyView_circleLabel);
            circleCol = a.getInteger(R.styleable.LovelyView_circleColor,0);
            labelCol = a.getInteger(R.styleable.LovelyView_labelColor,0);
        }finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;
        int radius = 0;
        if(viewWidthHalf>viewHeightHalf)
            radius=viewHeightHalf-10;
        else
            radius=viewWidthHalf-10;
        _paintDoodle.setColor(circleCol);
        _paintDoodle.setAntiAlias(true);
        _paintDoodle.setStyle(Paint.Style.FILL);
        canvas.drawCircle(viewWidthHalf,viewHeightHalf,radius,_paintDoodle);
        _paintDoodle.setColor(labelCol);
        _paintDoodle.setTextAlign(Paint.Align.CENTER);
        _paintDoodle.setTextSize(50);
        canvas.drawText(circleText,viewWidthHalf,viewHeightHalf,_paintDoodle);
    }



    public int getCircleColor(){
        return circleCol;
    }
    public int getLabelColor(){
        return labelCol;
    }
    public String getLabelText(){
        return circleText;
    }

    public void setCircleColor(int circleCol) {
        this.circleCol = circleCol;
        invalidate();
        requestLayout();
    }
    public void setLabelColor(int labelCol) {
        this.labelCol = labelCol;
        invalidate();
        requestLayout();
    }
    public void setLabelText(String circleText) {
        this.circleText = circleText;
        invalidate();
        requestLayout();
    }

}
