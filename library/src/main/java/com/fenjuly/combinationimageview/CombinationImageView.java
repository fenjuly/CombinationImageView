package com.fenjuly.combinationimageview;

import android.content.Context;
import android.content.res.TypedArray;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liurongchan on 15/3/17.
 */
public class CombinationImageView extends View {


    private Drawable first_drawable;
    private Drawable second_drawable;
    private Drawable third_drawable;
    private Drawable fourth_drawable;


    private static List<Bitmap> bitmaps = new ArrayList<Bitmap>();



    public CombinationImageView(Context context) {
        super(context);
    }

    public CombinationImageView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.combinationImageView);
    }

    public CombinationImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CombinationImageView,
                defStyleAttr, 0);
         first_drawable = attributes.getDrawable(R.styleable.CombinationImageView_first_image_src);
         second_drawable = attributes.getDrawable(R.styleable.CombinationImageView_second_image_src);
         third_drawable = attributes.getDrawable(R.styleable.CombinationImageView_third_image_src);
         fourth_drawable = attributes.getDrawable(R.styleable.CombinationImageView_fourth_image_src);
        if (first_drawable != null) {
            Bitmap bitmap = drawableToBitmap(first_drawable);
            addImageView(bitmap);
        }
        if (second_drawable != null) {
            Bitmap bitmap = drawableToBitmap(second_drawable);
            addImageView(bitmap);
        }
        if (third_drawable != null) {
            Bitmap bitmap = drawableToBitmap(third_drawable);
            addImageView(bitmap);
        }
        if (fourth_drawable != null) {
            Bitmap bitmap = drawableToBitmap(fourth_drawable);
            addImageView(bitmap);
        }

        attributes.recycle();
    }

    public void addImageView(String path) {
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        if (bitmap != null) {
            bitmaps.add(bitmap);
        }
    }

    public void addImageView(int resId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
        if (bitmap != null) {
            bitmaps.add(bitmap);
        }
    }

    public void addImageView(Bitmap bitmap) {
        if (bitmap != null) {
            bitmaps.add(bitmap);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measure(widthMeasureSpec,true), measure(heightMeasureSpec,false));
    }

    private int measure(int measureSpec,boolean isWidth){
        int result;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        int padding = isWidth?getPaddingLeft()+getPaddingRight():getPaddingTop()+getPaddingBottom();
        if(mode == MeasureSpec.EXACTLY){
            result = size;
        }else{
            result = isWidth ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight();
            result += padding;
            if(mode == MeasureSpec.AT_MOST){
                if(isWidth) {
                    result = Math.max(result, size);
                }
                else{
                    result = Math.min(result, size);
                }
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float total_width = getWidth();
        float total_height = getHeight();
        int total_bitmap_size = bitmaps.size();
        adjustBitmapsSize(total_width, total_height);
        switch (total_bitmap_size) {
            case 2:
                Log.e("2", "invoked");
                canvas.drawBitmap(bitmaps.get(0), getPaddingLeft(), getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(1), getPaddingLeft() + total_width / 2, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
            break;
            case 3:
                Log.e("3", "invoked");
                canvas.drawBitmap(bitmaps.get(0), getPaddingLeft(), getPaddingTop() + total_height / 2, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(1), getPaddingLeft() + total_width / 2, getPaddingTop() + total_height / 2, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(2), getPaddingLeft() + total_width / 4, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
            break;
            case 4:
                Log.e("4", "invoked");
                canvas.drawBitmap(bitmaps.get(0), getPaddingLeft(), getPaddingTop() + total_height / 2, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(1), getPaddingLeft() + total_width / 2, getPaddingTop() + total_height /2, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(2), getPaddingLeft(), getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(3), getPaddingLeft() + total_width / 2, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
            break;
            case 5:
                Log.e("5", "invoked");
                canvas.drawBitmap(bitmaps.get(0), getPaddingLeft(), getPaddingTop() + total_height / 2, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(1), getPaddingLeft() + total_width / 3, getPaddingTop() + total_height / 2, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(2), getPaddingLeft() + total_width * 2 / 3, getPaddingTop() + total_height / 2, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(3), getPaddingLeft() + total_width / 6, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(4), getPaddingLeft() + total_width / 2, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
            break;
            case 6:
                Log.e("6", "invoked");
                canvas.drawBitmap(bitmaps.get(0), getPaddingLeft(), getPaddingTop() + total_height / 2, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(1), getPaddingLeft() + total_width / 3, getPaddingTop() + total_height / 2, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(2), getPaddingLeft() + total_width * 2 / 3, getPaddingTop() + total_height / 2, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(3), getPaddingLeft(), getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(4), getPaddingLeft() + total_width / 3, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(5), getPaddingLeft() + total_width * 2 / 3, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
            break;
            case 7:
                Log.e("7", "invoked");
                canvas.drawBitmap(bitmaps.get(0), getPaddingLeft(), getPaddingTop() + total_height * 2 / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(1), getPaddingLeft() + total_width / 3, getPaddingTop() + total_height * 2 / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(2), getPaddingLeft() + total_width * 2 / 3, getPaddingTop() + total_height * 2 / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(3), getPaddingLeft(), getPaddingTop() + total_height / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(4), getPaddingLeft() + total_width / 3, getPaddingTop() + total_height / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(5), getPaddingLeft() + total_width * 2 / 3, getPaddingTop() + total_height / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(6), getPaddingLeft() + total_width / 3, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
                break;
            case 8:
                Log.e("8", "invoked");
                canvas.drawBitmap(bitmaps.get(0), getPaddingLeft(), getPaddingTop() + total_height * 2 / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(1), getPaddingLeft() + total_width / 3, getPaddingTop() + total_height * 2 / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(2), getPaddingLeft() + total_width * 2 / 3, getPaddingTop() + total_height * 2 / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(3), getPaddingLeft(), getPaddingTop() + total_height / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(4), getPaddingLeft() + total_width / 3, getPaddingTop() + total_height / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(5), getPaddingLeft() + total_width * 2 / 3, getPaddingTop() + total_height / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(6), getPaddingLeft() + total_width / 6, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(7), getPaddingLeft() + total_width / 2, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
            break;
            case 9:
                Log.e("9", "invoked");
                canvas.drawBitmap(bitmaps.get(0), getPaddingLeft(), getPaddingTop() + total_height * 2 / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(1), getPaddingLeft() + total_width / 3, getPaddingTop() + total_height * 2 / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(2), getPaddingLeft() + total_width * 2 / 3, getPaddingTop() + total_height * 2 / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(3), getPaddingLeft(), getPaddingTop() + total_height / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(4), getPaddingLeft() + total_width / 3, getPaddingTop() + total_height / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(5), getPaddingLeft() + total_width * 2 / 3, getPaddingTop() + total_height / 3, new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(6), getPaddingLeft() , getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(7), getPaddingLeft() + total_width / 3, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
                canvas.drawBitmap(bitmaps.get(8), getPaddingLeft() + total_width * 2 / 3, getPaddingTop(), new Paint(Paint.ANTI_ALIAS_FLAG));
            default:
                break;
        }

    }


    private static void adjustBitmapsSize(float totalWidth, float totalHeight) {
        switch (bitmaps.size()) {
            case 2:
                for (int i = 0; i < bitmaps.size(); i++) {
                    Bitmap b = bitmaps.get(i);
                    bitmaps.set(i, Bitmap.createBitmap(b, 0, 0, finalWidth(totalWidth / 2, b.getWidth()), finalHeight(totalWidth, totalHeight, b.getWidth(), b.getHeight())));
                }
                break;
            case 3:
            case 4:
                for (int i = 0; i < bitmaps.size(); i++) {
                    Bitmap b = bitmaps.get(i);
                    bitmaps.set(i, Bitmap.createBitmap(b, 0, 0, finalWidth(totalWidth / 2, b.getWidth()), finalHeight(totalWidth / 2, totalHeight / 2, b.getWidth(), b.getHeight())));
                }
                break;
            case 5:
            case 6:
                for (int i = 0; i < bitmaps.size(); i++) {
                    Bitmap b = bitmaps.get(i);
                    bitmaps.set(i, Bitmap.createBitmap(b, 0, 0, finalWidth(totalWidth / 3, b.getWidth()), finalHeight(totalWidth / 3, totalHeight / 2, b.getWidth(), b.getHeight())));
                }
                break;
            case 7:
            case 8:
            case 9:
                default:
                    for (int i = 0; i < bitmaps.size(); i++) {
                        Bitmap b = bitmaps.get(i);
                        bitmaps.set(i, Bitmap.createBitmap(b, 0, 0, finalWidth(totalWidth / 3, b.getWidth()), finalHeight(totalWidth / 3, totalHeight / 3, b.getWidth(), b.getHeight())));
                    }
                    break;

        }
    }

    public int getNumbersOfView() {
        return bitmaps.size();
    }

    public void removeView(int position) {
        if (position >= 0 && position < bitmaps.size()) {
            bitmaps.remove(position);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void removeAllView() {
        bitmaps.clear();
    }

    private static int finalWidth(float viewWidth, float selfWidth) {
        int width;

        if (viewWidth < selfWidth) {
           width = (int)viewWidth;
       } else {
            width = (int)selfWidth;
        }
       return  width;
    }

    private static int finalHeight(float viewWidth, float viewHeight, float selfWidth, float selfHeight) {
        int width;
        int height;
        float ratio = selfHeight / selfWidth;
        if (viewWidth < selfWidth) {
            width = (int)viewWidth;
        } else {
            width = (int)selfWidth;
        }
        if (width * ratio > viewHeight) {
            height = (int)viewHeight;
        } else {
            height = (int) (width * ratio);
        }
        return height;
    }

    private static Bitmap drawableToBitmap(Drawable drawable) {
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }


}
