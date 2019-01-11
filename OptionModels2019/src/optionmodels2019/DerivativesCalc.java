/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optionmodels2019;

/**
 *
 * @author pauli
 */
interface DerivativesCalc {
    void runModel();
    void CalcImpliedVlt();
    void fillDerivativesArray();
    String getModelName();
    double getPrima();
    double getDelta();
    double getGamma();
    double getVega();
    double getTheta();
    double getRho();
    double getImpliedVlt();
}
