/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optionmodels2019;

import Underlyings.Underlying;

/**
 *
 * @author pauli
 */
public abstract class AbstractModel extends Underlying implements DerivativesCalc{
    enum TipoOpcion {CALL,PUT}
    enum eDerivatives{PRIMA, DELTA, GAMMA, VEGA,THETA,RHO,IV}
    enum TipoEjercicio {AMERICAN,EUROPEAN}
    
    public final static char CALL='C';
    public final static char PUT='P';
             
    public final static char EUROPEAN='E';
    public final static char AMERICAN='A';
    
    //Greeks
    public final static int PRIMA=0,DELTA=1,GAMMA=2,VEGA=3,THETA=4,RHO=5,IV=6;
    protected double[][] DerivativesArray = new double[1][10];
}
