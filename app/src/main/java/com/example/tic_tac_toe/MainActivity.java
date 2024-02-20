package com.example.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // 0- X
// 1- O
// 2- null
    boolean gameActive = true;
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};

    //    @SuppressLint("SetTextI18n")
    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImg = Integer.parseInt(img.getTag().toString());
        if (!gameActive) {
            gameReset(view);
        }
        if (gameState[tappedImg] == 2) {
            gameState[tappedImg] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
//        check if any player has won
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]]
                    && gameState[winPosition[1]] ==
                    gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
//         somebody has won - find out
                String winner;
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winner = "X has won";
                } else {
                    winner = "O has won";
                }
//                update status bar for winner
                TextView status = findViewById(R.id.status);
                status.setText(winner);


            }
        }
    }

    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
//
//package com.example.tic_tac_toe;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//    boolean gameActive = true;
//    // Player representation
//    // 0 - X
//    // 1 - O
//    int activePlayer = 0;
//    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
//    //    State meanings:
//    //    0 - X
//    //    1 - O
//    //    2 - Null
//    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
//            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
//            {0, 4, 8}, {2, 4, 6}};
//
//    public void playerTap(View view) {
//        ImageView img = (ImageView) view;
//        int tappedImage = Integer.parseInt(img.getTag().toString());
//        if (!gameActive) {
//            gameReset(view);
//        }
//        if (gameState[tappedImage] == 2) {
//            gameState[tappedImage] = activePlayer;
//            img.setTranslationY(-1000f);
//            if (activePlayer == 0) {
//                img.setImageResource(R.drawable.x);
//                activePlayer = 1;
//                TextView status = findViewById(R.id.status);
//                status.setText("O's Turn - Tap to play");
//            } else {
//                img.setImageResource(R.drawable.o);
//                activePlayer = 0;
//                TextView status = findViewById(R.id.status);
//                status.setText("X's Turn - Tap to play");
//            }
//            img.animate().translationYBy(1000f).setDuration(300);
//        }
//        // Check if any player has won
//        for (int[] winPosition : winPositions) {
//            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
//                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
//                    gameState[winPosition[0]] != 2) {
//                // Somebody has won! - Find out who!
//                String winnerStr;
//                gameActive = false;
//                if (gameState[winPosition[0]] == 0) {
//                    winnerStr = "X has won";
//                } else {
//                    winnerStr = "O has won";
//                }
//                // Update the status bar for winner announcement
//                TextView status = findViewById(R.id.status);
//                status.setText(winnerStr);
//
//            }
//        }
//    }
//
//    public void gameReset(View view) {
//        gameActive = true;
//        activePlayer = 0;
//        for (int i = 0; i < gameState.length; i++) {
//            gameState[i] = 2;
//        }
//        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
//
//        TextView status = findViewById(R.id.status);
//        status.setText("X's Turn - Tap to play");
//
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
//
