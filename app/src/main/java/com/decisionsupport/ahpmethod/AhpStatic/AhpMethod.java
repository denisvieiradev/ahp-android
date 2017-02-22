package com.decisionsupport.ahpmethod.AhpStatic;

/**
 * Created by gabrielrosa on 21/02/17.
 */

public class AhpMethod {
    private float[][] matriz;

    public AhpMethod(){
    }

    public float[][] nomaliza (float[][] matriz){

        float[][] matrizNormalizada=null;

        if(matriz.length==4) {
            matrizNormalizada = new float[4][4];
            //primeira coluna normalizada
            matrizNormalizada[0][0] = matriz[0][0] / (matriz[0][0] + matriz[1][0] + matriz[2][0] + matriz[3][0]);
            matrizNormalizada[1][0] = matriz[1][0] / (matriz[0][0] + matriz[1][0] + matriz[2][0] + matriz[3][0]);
            matrizNormalizada[2][0] = matriz[2][0] / (matriz[0][0] + matriz[1][0] + matriz[2][0] + matriz[3][0]);
            matrizNormalizada[3][0] = matriz[3][0] / (matriz[0][0] + matriz[1][0] + matriz[2][0] + matriz[3][0]);
            //seguda coluna normalizada
            matrizNormalizada[0][1] = matriz[0][1] / (matriz[0][1] + matriz[1][1] + matriz[2][1] + matriz[3][1]);
            matrizNormalizada[1][1] = matriz[1][1] / (matriz[0][1] + matriz[1][1] + matriz[2][1] + matriz[3][1]);
            matrizNormalizada[2][1] = matriz[2][1] / (matriz[0][1] + matriz[1][1] + matriz[2][1] + matriz[3][1]);
            matrizNormalizada[3][1] = matriz[3][1] / (matriz[0][1] + matriz[1][1] + matriz[2][1] + matriz[3][1]);
            //terceira coluna normalizaa
            matrizNormalizada[0][2] = matriz[0][2] / (matriz[0][2] + matriz[1][2] + matriz[2][2] + matriz[3][2]);
            matrizNormalizada[1][2] = matriz[1][2] / (matriz[0][2] + matriz[1][2] + matriz[2][2] + matriz[3][2]);
            matrizNormalizada[2][2] = matriz[2][2] / (matriz[0][2] + matriz[1][2] + matriz[2][2] + matriz[3][2]);
            matrizNormalizada[3][2] = matriz[3][2] / (matriz[0][2] + matriz[1][2] + matriz[2][2] + matriz[3][2]);
            //quarta coluna normalizada
            matrizNormalizada[0][3] = matriz[0][3] / (matriz[0][3] + matriz[1][3] + matriz[2][3] + matriz[3][3]);
            matrizNormalizada[1][3] = matriz[1][3] / (matriz[0][3] + matriz[1][3] + matriz[2][3] + matriz[3][3]);
            matrizNormalizada[2][3] = matriz[2][3] / (matriz[0][3] + matriz[1][3] + matriz[2][3] + matriz[3][3]);
            matrizNormalizada[3][3] = matriz[3][3] / (matriz[0][3] + matriz[1][3] + matriz[2][3] + matriz[3][3]);
        }
        if (matriz.length==3){

            matrizNormalizada = new float[3][3];
            //primeira coluna normalizada
            matrizNormalizada[0][0] = matriz[0][0] / (matriz[0][0] + matriz[1][0] + matriz[2][0] );
            matrizNormalizada[1][0] = matriz[1][0] / (matriz[0][0] + matriz[1][0] + matriz[2][0] );
            matrizNormalizada[2][0] = matriz[2][0] / (matriz[0][0] + matriz[1][0] + matriz[2][0] );

            //seguda coluna normalizada
            matrizNormalizada[0][1] = matriz[0][1] / (matriz[0][1] + matriz[1][1] + matriz[2][1] );
            matrizNormalizada[1][1] = matriz[1][1] / (matriz[0][1] + matriz[1][1] + matriz[2][1] );
            matrizNormalizada[2][1] = matriz[2][1] / (matriz[0][1] + matriz[1][1] + matriz[2][1] );
            //terceira coluna normalizaa
            matrizNormalizada[0][2] = matriz[0][2] / (matriz[0][2] + matriz[1][2] + matriz[2][2] );
            matrizNormalizada[1][2] = matriz[1][2] / (matriz[0][2] + matriz[1][2] + matriz[2][2] );
            matrizNormalizada[2][2] = matriz[2][2] / (matriz[0][2] + matriz[1][2] + matriz[2][2] );

        }



        return matrizNormalizada;

    }

    public float[] matrizMedia (float[][] matrizNormalizada){


        int cont=0;   float soma =0;


        float[] matrizMedia = new float[matrizNormalizada.length];

        //  matriz[0][0] = (matrizNormalizada[0][0] +  matrizNormalizada[0][1] +  matrizNormalizada[0][2] +  matrizNormalizada[0][3])/4;
        //  matriz[1][0] = (matrizNormalizada[1][0] +  matrizNormalizada[1][1] +  matrizNormalizada[1][2] +  matrizNormalizada[1][3])/4;
        //  matriz[2][0] = (matrizNormalizada[2][0] +  matrizNormalizada[2][1] +  matrizNormalizada[2][2] +  matrizNormalizada[2][3])/4;
        //  matriz[3][0] = (matrizNormalizada[3][0] +  matrizNormalizada[3][1] +  matrizNormalizada[3][2] +  matrizNormalizada[3][3])/4;

        // //preenche a matrizB com números randomicos
        // for(int i = 0; i < matrizB.length; i++)
        // {
        //     for(int j = 0; j < matrizB[i].length; j++)
        //         matrizB[i][j] = (new Integer(gerador.nextInt(9)));
        // }


        for (float[] x: matrizNormalizada ) { //iteracao matriz normalizada

            for (float y: x) { // y = cada elemento
                soma = (soma + y);
            }

            matrizMedia[cont]=(soma/matrizNormalizada.length);
            soma=0;
            cont++;

        }


        return matrizMedia;

    }

    public int verificaConsistencia(float[][] matrizPesos, float [] matrizMedia){

        float [][] matrizProduto;
        float soma=0;
        float media=0;
        double CI,CR,RI;

        matrizProduto = multiplicaMatrizes(matrizPesos,matrizMedia);

        for (int i=0; i<matrizProduto.length; i++){
            matrizProduto[i][0] = matrizProduto[i][0]/matrizMedia[i];
        }




        for (int i=0; i<matrizProduto.length; i++){
            soma = soma + matrizProduto[i][0];
        }
        media = soma/matrizProduto.length;
        //RI = INDICE DE CONSISTENCIA ALEATORIA
        //CR = RELACAO DE CONSISTENCIA
        //CI = INDICE DE CONSISTENIA
        CI = (media - matrizProduto.length)/(matrizProduto.length -1);
        RI = 1.98*(matrizProduto.length-2)/matrizProduto.length;
        CR = CI/RI;
        System.out.println("\n\nVALOR DE matrizProduto.length:"+matrizProduto.length);
        System.out.println("\n\nVALOR DE y max"+media);
        System.out.println("\n\nVALOR DE CR:"+CR);
        if(CR<0.1)
            return 1;
        else
            return 0;
    }

    public float [][] multiplicaMatrizes (float [][] m1, float [] m2){

        float [][] m3 = new float[3][1];
        m3[0][0] = m2[0];
        m3[1][0] = m2[1];
        m3[2][0] = m2[2];

        if (m1[0].length != m3.length) throw new RuntimeException("Dimensões inconsistentes. Impossível multiplicar as matrizes");

        float[][] result = new float[ m1.length ][ m3[0].length ];

        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m3[0].length; j++) {
                float somatoria = 0;
                for (int k = 0; k < m1[0].length; k++) {
                    float produto = m1[i][k] * m3[k][j];
                    somatoria += produto;
                }
                result[i][j] = somatoria ;
            }
        return result ;
    }

}

