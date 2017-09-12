package com.pritz.sikkimuniversity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class handwriting extends AppCompatActivity {

    FrameLayout layout;
    RadioGroup color;
    SeekBar stroke;

    Board board;

    int opt_brush_color = Color.BLACK;
    float opt_brush_width = 10f;

    Bitmap captured = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_handwriting);
        Toast.makeText(getApplicationContext(), "Take ScreenShot for Saving...", Toast.LENGTH_SHORT).show();

        layout = (FrameLayout) findViewById(R.id.layout);

        color = (RadioGroup) findViewById(R.id.color);
        color.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rdBlack:
                        setBrushColor(Color.BLACK);
                        break;

                    case R.id.rdGreen:
                        setBrushColor(Color.GREEN);
                        break;
                    case R.id.rdRed:
                        setBrushColor(Color.RED);
                        break;
                    case R.id.rdWhite:
                        setBrushColor(Color.WHITE);
                        break;
                }
            }
        });


        stroke = (SeekBar) findViewById(R.id.stroke);
        stroke.setProgress(10);
        stroke.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                opt_brush_width = progress + 1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }


            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                setBrushStroke(opt_brush_width);
            }
        });

        board = new Board(getBaseContext());

        layout.addView(board);

        setBrush();
    }


    private void setBrushColor(int colorType){
        opt_brush_color = colorType;
        setBrush();
    }

    private void setBrushStroke(float width){
        opt_brush_width = width;
        setBrush();
    }


    private void setBrush(){
        Brush brush = new Brush();
        brush.color = opt_brush_color;
        brush.stroke = opt_brush_width;
        board.setBrush(brush);
    }


    class Board extends View {
        Paint paint;
        List<Brush> brushes;
        Brush current_brush;
        Path current_path;


        boolean newBrush = true;

        public Board(Context context) {
            super(context);
            setPaint();
            brushes = new ArrayList<>();
        }

        private void setPaint(){

            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setDither(true);
        }

        public void setBrush(Brush brush) {
            current_brush = brush;
            newBrush = true;
        }

        private void createPath(){
            if(newBrush) {
                current_path = new Path();
                newBrush = false;
                current_brush.addPath(current_path);
                brushes.add(current_brush);
            }
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            for(Brush brush : brushes) {
                // 브러쉬에서 속성값을 꺼내서 Paint 에 반영한다.
                paint.setStrokeWidth(brush.stroke);
                paint.setColor(brush.color);
                // 속성값이 반영된 Paint 와 Path를 화면에 그려준다.
                canvas.drawPath(brush.path, paint);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // 내가 터치한 좌표를 꺼낸다
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()){
                // 터치가 시작되면 Path 를 생성하고 현재 지정된 브러쉬와 함께 저장소에 담아둔다.
                case MotionEvent.ACTION_DOWN :
                    createPath();
                    current_path.moveTo(x,y); // 이전점과 현재점 사이를 그리지 않고 이동한다.
                    break;
                case MotionEvent.ACTION_MOVE :
                    current_path.lineTo(x,y);
                    break;
                case MotionEvent.ACTION_UP :

                    break;
            }


            invalidate();


            return true;
        }
    }


    class Brush {
        Path path;
        int color;
        float stroke;

        public void addPath(Path path){
            this.path = path;
        }
    }
}