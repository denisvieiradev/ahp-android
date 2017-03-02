package com.ahpandroid.domain.entity;

import java.io.Serializable;

/**
 * Created by denisvieira on 26/02/17.
 */

public class AhpMatrices implements Serializable {

    private float[][] criterionOneMatrix;
    private float[][] criterionTwoMatrix;
    private float[][] criterionThreeMatrix;
    private float[][] criterionFourMatrix;

    public AhpMatrices(){

    }

    public AhpMatrices(float[][] criterionOneMatrix, float[][] criterionTwoMatrix, float[][] criterionThreeMatrix, float[][] criterionFourMatrix) {
        this.criterionOneMatrix = criterionOneMatrix;
        this.criterionTwoMatrix = criterionTwoMatrix;
        this.criterionThreeMatrix = criterionThreeMatrix;
        this.criterionFourMatrix = criterionFourMatrix;
    }

    public float[][] getCriterionOneMatrix() {
        return criterionOneMatrix;
    }

    public void setCriterionOneMatrix(float[][] criterionOneMatrix) {
        this.criterionOneMatrix = criterionOneMatrix;
    }

    public float[][] getCriterionTwoMatrix() {
        return criterionTwoMatrix;
    }

    public void setCriterionTwoMatrix(float[][] criterionTwoMatrix) {
        this.criterionTwoMatrix = criterionTwoMatrix;
    }

    public float[][] getCriterionThreeMatrix() {
        return criterionThreeMatrix;
    }

    public void setCriterionThreeMatrix(float[][] criterionThreeMatrix) {
        this.criterionThreeMatrix = criterionThreeMatrix;
    }

    public float[][] getCriterionFourMatrix() {
        return criterionFourMatrix;
    }

    public void setCriterionFourMatrix(float[][] criterionFourMatrix) {
        this.criterionFourMatrix = criterionFourMatrix;
    }

    private void normalizeMatrices(){
        this.criterionOneMatrix = normalize(criterionOneMatrix);
        this.criterionTwoMatrix = normalize(criterionTwoMatrix);
        this.criterionThreeMatrix = normalize(criterionThreeMatrix);
        this.criterionFourMatrix = normalize(criterionFourMatrix);
    }

    public float[][] normalize(float[][] matrix){

        float[][] normalizedMatrix = null;

        if(matrix.length==4) {
            normalizedMatrix = new float[4][4];
            //first column
            normalizedMatrix[0][0] = matrix[0][0] / (matrix[0][0] + matrix[1][0] + matrix[2][0] + matrix[3][0]);
            normalizedMatrix[1][0] = matrix[1][0] / (matrix[0][0] + matrix[1][0] + matrix[2][0] + matrix[3][0]);
            normalizedMatrix[2][0] = matrix[2][0] / (matrix[0][0] + matrix[1][0] + matrix[2][0] + matrix[3][0]);
            normalizedMatrix[3][0] = matrix[3][0] / (matrix[0][0] + matrix[1][0] + matrix[2][0] + matrix[3][0]);
            //second column
            normalizedMatrix[0][1] = matrix[0][1] / (matrix[0][1] + matrix[1][1] + matrix[2][1] + matrix[3][1]);
            normalizedMatrix[1][1] = matrix[1][1] / (matrix[0][1] + matrix[1][1] + matrix[2][1] + matrix[3][1]);
            normalizedMatrix[2][1] = matrix[2][1] / (matrix[0][1] + matrix[1][1] + matrix[2][1] + matrix[3][1]);
            normalizedMatrix[3][1] = matrix[3][1] / (matrix[0][1] + matrix[1][1] + matrix[2][1] + matrix[3][1]);
            //third column
            normalizedMatrix[0][2] = matrix[0][2] / (matrix[0][2] + matrix[1][2] + matrix[2][2] + matrix[3][2]);
            normalizedMatrix[1][2] = matrix[1][2] / (matrix[0][2] + matrix[1][2] + matrix[2][2] + matrix[3][2]);
            normalizedMatrix[2][2] = matrix[2][2] / (matrix[0][2] + matrix[1][2] + matrix[2][2] + matrix[3][2]);
            normalizedMatrix[3][2] = matrix[3][2] / (matrix[0][2] + matrix[1][2] + matrix[2][2] + matrix[3][2]);
            //fourth column
            normalizedMatrix[0][3] = matrix[0][3] / (matrix[0][3] + matrix[1][3] + matrix[2][3] + matrix[3][3]);
            normalizedMatrix[1][3] = matrix[1][3] / (matrix[0][3] + matrix[1][3] + matrix[2][3] + matrix[3][3]);
            normalizedMatrix[2][3] = matrix[2][3] / (matrix[0][3] + matrix[1][3] + matrix[2][3] + matrix[3][3]);
            normalizedMatrix[3][3] = matrix[3][3] / (matrix[0][3] + matrix[1][3] + matrix[2][3] + matrix[3][3]);
        }
        if (matrix.length==3){

            normalizedMatrix = new float[3][3];
            //first column
            normalizedMatrix[0][0] = matrix[0][0] / (matrix[0][0] + matrix[1][0] + matrix[2][0] );
            normalizedMatrix[1][0] = matrix[1][0] / (matrix[0][0] + matrix[1][0] + matrix[2][0] );
            normalizedMatrix[2][0] = matrix[2][0] / (matrix[0][0] + matrix[1][0] + matrix[2][0] );
            //second column
            normalizedMatrix[0][1] = matrix[0][1] / (matrix[0][1] + matrix[1][1] + matrix[2][1] );
            normalizedMatrix[1][1] = matrix[1][1] / (matrix[0][1] + matrix[1][1] + matrix[2][1] );
            normalizedMatrix[2][1] = matrix[2][1] / (matrix[0][1] + matrix[1][1] + matrix[2][1] );
            //third column
            normalizedMatrix[0][2] = matrix[0][2] / (matrix[0][2] + matrix[1][2] + matrix[2][2] );
            normalizedMatrix[1][2] = matrix[1][2] / (matrix[0][2] + matrix[1][2] + matrix[2][2] );
            normalizedMatrix[2][2] = matrix[2][2] / (matrix[0][2] + matrix[1][2] + matrix[2][2] );

        }

        return normalizedMatrix;
    }

    public float[] calculateAverageMatrix(float[][] matrizNormalizada){
        int cont=0;   float soma =0;

        float[] matrixAverage = new float[matrizNormalizada.length];

        for (float[] x: matrizNormalizada ) { //iteracao matriz normalizada
            for (float y: x) { // y = cada elemento
                soma = (soma + y);
            }
            matrixAverage[cont]=(soma/matrizNormalizada.length);
            soma=0;
            cont++;
        }

        return matrixAverage;
    }

    public float [][] generateResultMatrix(){

        normalizeMatrices();

        float [] criterionOneMedia = calculateAverageMatrix(criterionOneMatrix);
        float [] criterionTwoMedia = calculateAverageMatrix(criterionTwoMatrix);
        float [] criterionThreeMedia = calculateAverageMatrix(criterionThreeMatrix);
        float [] criterionFourMedia = calculateAverageMatrix(criterionFourMatrix);

        float[][] preferenceMatrix = {
                {criterionOneMedia[0], criterionTwoMedia[0], criterionThreeMedia[0], criterionFourMedia[0]},
                {criterionOneMedia[1], criterionTwoMedia[1], criterionThreeMedia[1], criterionFourMedia[1]},
                {criterionOneMedia[2], criterionTwoMedia[2], criterionThreeMedia[2], criterionFourMedia[2]},
                {criterionOneMedia[3], criterionTwoMedia[3], criterionThreeMedia[3], criterionFourMedia[3]}
        };

        return preferenceMatrix;
    }
}
