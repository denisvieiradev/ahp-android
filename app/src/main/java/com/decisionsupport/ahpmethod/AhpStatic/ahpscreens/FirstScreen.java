package com.decisionsupport.ahpmethod.AhpStatic.ahpscreens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.SeekBar;

import com.decisionsupport.R;
import com.decisionsupport.ahpmethod.AhpStatic.AhpMethod;

/**
 * Created by gabrielrosa on 21/02/17.
 */

public class FirstScreen extends Activity{


    private SeekBar seekBar1, seekBar2, seekBar3, seekBar4, seekBar5, seekBar6;
    private float[][] matriz;
    private AhpMethod ahp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        initializeVariables();




        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                verificaSeekBar(seekBar, 0,1);

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                verificaSeekBar(seekBar,0,2);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                verificaSeekBar(seekBar,0,3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                verificaSeekBar(seekBar,1,2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                verificaSeekBar(seekBar,1,3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                verificaSeekBar(seekBar,2,3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void initializeVariables() {

        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        seekBar5 = (SeekBar) findViewById(R.id.seekBar5);
        seekBar6 = (SeekBar) findViewById(R.id.seekBar6);
        matriz = inicializaMatriz(4,4);
        ahp = new AhpMethod();



    }

    public void proximaTela(View view) {

        Intent secondActivity = new Intent(this, Segunda.class);
        secondActivity.putExtra("matriz1", ahp.matrizMedia(ahp.nomaliza(matriz)));
        // Bundle bundle = new Bundle();
        // bundle.putFloatArray("matriz1", matriz);
        // secondActivity.putExtra("matriz1", ahp.matrizMedia(ahp.nomaliza(matriz)));

        startActivity(secondActivity);
    }

    private int verificaSeekBar(SeekBar seekbar, int i, int j) {



        switch (seekbar.getProgress()) {

            case 0:

                Snackbar.make(findViewById(android.R.id.content), "Localização Absolutamente Inferior", Snackbar.LENGTH_LONG).show();
                matriz[i][j] = 1/9.2f;
                matriz[j][i] = 9;

                break;

            case 1:

                Snackbar.make(findViewById(android.R.id.content), "Localização Muito Inferior", Snackbar.LENGTH_LONG).show();
                matriz[i][j] = 1/7.2f;
                matriz[j][i] = 7;
                break;

            case 2:
                Snackbar.make(findViewById(android.R.id.content), "Localização com Grande Inferioridade", Snackbar.LENGTH_LONG).show();
                matriz[i][j] = 1/5.2f;
                matriz[j][i] = 5;
                break;
            case 3:
                Snackbar.make(findViewById(android.R.id.content), "Localização com Pequena Inferioridade", Snackbar.LENGTH_LONG).show();
                matriz[i][j] = 1/3.2f;
                matriz[j][i] = 3;
                break;
            case 4:
                Snackbar.make(findViewById(android.R.id.content), "Igual Importância", Snackbar.LENGTH_LONG).show();
                matriz[i][j] = 1;
                matriz[j][i] = 1;
                break;
            case 5:
                Snackbar.make(findViewById(android.R.id.content), "Localização com Pequena Superioridade", Snackbar.LENGTH_LONG).show();
                matriz[i][j] = 3;
                matriz[j][i] = 1/3.2f;
                break;
            case 6:
                Snackbar.make(findViewById(android.R.id.content), "Localização com Grande Superioridade", Snackbar.LENGTH_LONG).show();
                matriz[i][j] = 5;
                matriz[j][i] = 1/5.2f;
                break;
            case 7:
                Snackbar.make(findViewById(android.R.id.content), "Localização Muito Superior", Snackbar.LENGTH_LONG).show();
                matriz[i][j] = 7;
                matriz[j][i] = 1/7.2f;
                break;
            case 8:
                Snackbar.make(findViewById(android.R.id.content), "Localização Absolutamente Superior", Snackbar.LENGTH_LONG).show();
                matriz[i][j] = 9;
                matriz[j][i] = 1/9.2f;
                break;



        }

        matriz[0][0]=1;
        matriz[1][1]=1;
        matriz[2][2]=1;
        matriz[3][3]=1;

        System.out.println("\nMatriz");
        imprimeMatriz(matriz);
        System.out.println("\nMatriz normalizada:");
        float[][] matriz2;
        AhpMethod ahp = new AhpMethod();
        matriz2 = ahp.nomaliza(matriz);
        imprimeMatriz(matriz2);
        System.out.println("\nMatriz Media:");
        //imprimeMatriz(ahp.matrizMedia(matriz2));

        return seekbar.getProgress();


    }

    public void imprimeMatriz(float [][] matriz3){



        for(float[] c : matriz3){

            for(float elemento : c)
                System.out.printf(" %.2f ", elemento);
            System.out.printf("\n");
        }



    }

    public static float[][] inicializaMatriz(int l, int c ) {

        float [][] matrizNull = new float[l][c];
        for (int linha = 0; linha<matrizNull.length; linha++){
            for (int coluna =0; coluna<matrizNull.length; coluna++) {
                if(linha==coluna)
                    matrizNull[linha][coluna]=1;
                else
                    matrizNull[linha][coluna] =1/9;
            }
        }


        return matrizNull;
    }
}
