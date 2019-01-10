package com.example;
//
import Option2017Interface.*;

import com.sun.star.uno.XComponentContext;
import com.sun.star.lib.uno.helper.Factory;
import com.sun.star.lang.XSingleComponentFactory;
import com.sun.star.registry.XRegistryKey;
import com.sun.star.lib.uno.helper.WeakBase;


public final class Options2019AddinImpl extends WeakBase
   implements com.sun.star.lang.XServiceInfo,
              com.example.XOptions2019Addin,
              com.sun.star.lang.XLocalizable
{
    private final XComponentContext m_xContext;
    private static final String m_implementationName = Options2019AddinImpl.class.getName();
    private static final String[] m_serviceNames = {
        "com.example.Options2019Addin" };

    private com.sun.star.lang.Locale m_locale = new com.sun.star.lang.Locale();

    public Options2019AddinImpl( XComponentContext context )
    {
        m_xContext = context;
    }

    public static XSingleComponentFactory __getComponentFactory( String sImplementationName ) {
        XSingleComponentFactory xFactory = null;

        if ( sImplementationName.equals( m_implementationName ) )
            xFactory = Factory.createComponentFactory(Options2019AddinImpl.class, m_serviceNames);
        return xFactory;
    }

    public static boolean __writeRegistryServiceInfo( XRegistryKey xRegistryKey ) {
        return Factory.writeRegistryServiceInfo(m_implementationName,
                                                m_serviceNames,
                                                xRegistryKey);
    }

    // com.sun.star.lang.XServiceInfo:
    public String getImplementationName() {
         return m_implementationName;
    }

    public boolean supportsService( String sService ) {
        int len = m_serviceNames.length;

        for( int i=0; i < len; i++) {
            if (sService.equals(m_serviceNames[i]))
                return true;
        }
        return false;
    }

    public String[] getSupportedServiceNames() {
        return m_serviceNames;
    }

    // com.example.XOptions2019Addin:
    public double[][] PJSoptionDerivatives(double[][] inputs)
    
    {
        // TODO: Exchange the default return implementation for "OptionDerivatives" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        
        //fila a fila de la planilla, es mas rapido pq no recalcula todo el panel
        
        int         code             =(int)inputs  [0][0];
        double      underlyingValue  =inputs       [0][1];
        double      divRate          =inputs       [0][2];
        double      vHist            =inputs       [0][3];
        double      optionValue      =inputs       [0][4];
        double      strike           =inputs       [0][5];
        double      daysToExpiration =inputs       [0][6];
        double      tasa             =inputs       [0][7];
     //   int         flag             =(int)inputs  [0][8];     
     //   double      vltChart         =inputs       [0][9];
     //   double      desvStd          =inputs       [0][10];
     //   double      diasProy         =inputs       [0][11];
     //   int         codeGraph        =(int)inputs  [0][12];
     //   double      lotPrime         =inputs       [0][13];
     //   double      daysFrom1stVcto  =inputs       [0][14];
     //   double      multiplicador    =inputs       [0][15];
     //   String      ticker           ="No ticker"; //[0][16]            
         
         CodeBreaker code2=new CodeBreaker(code);
          int modelo            =code2.Modelo;
          int valueToFind       =code2.ValueToFind;
          int steps             =code2.Steps;    
        
        char callPut            =code2.CP; //Call o Put
        char tipoContrato       =code2.TC; //Stock Future
        char tipoEjercicio      =code2.TE; //European American
        
         
         Underlying und2=new Underlying("TICKER",tipoContrato,underlyingValue,vHist,divRate);
         
         AbstractOptionClass2017 Option;
         //Option=new WhaleyV2(Und,callPut,strike,daysToExpiration,tasa,vHist,optionValue);
         
          switch(modelo){
              case 1:
                  Option =new BlackScholesModel (und2,callPut,strike,daysToExpiration,tasa,vHist,optionValue);
                  break;
              case 2:
                  //si el Ej es European devuelve el BS sino el W.
                  if (tipoEjercicio=='E'){
                    Option=new BlackScholesModel (und2,callPut,strike,daysToExpiration,tasa,vHist,optionValue);
                  
                  }else{
                    Option=new WhaleyV2          (und2,callPut,strike,daysToExpiration,tasa,vHist,optionValue);
                  }
                    //El modelo Whaley ya esta calculado arriba
                  break;
              case 3://Binomial
                  Option=new BinomialModel2017(tipoEjercicio,und2,callPut,strike,daysToExpiration,tasa,vHist,optionValue,steps);
                  break;
              case 4://EF Wilmott
                  Option=new EFWilmott2017(tipoEjercicio,und2,callPut,strike,daysToExpiration,tasa,vHist,optionValue,steps);
                  break;
              case 5: //EF Hull
                  Option=new EFHull2017(tipoEjercicio,und2,callPut,strike,daysToExpiration,tasa,vHist,optionValue,steps);
                  break;
              case 6://Binomial Control Variate, solo para american options
                  Option=new BinomialControlVariate(und2,callPut,strike,daysToExpiration,tasa,vHist,optionValue,steps);
                  break;
               case 7://Control Variate, solo para american options   
                  Option=new EFControlVariate(und2,callPut,strike,daysToExpiration,tasa,vHist,optionValue,steps);
                  break;
                   
              default:
                  Option=new WhaleyV2(und2,callPut,strike,daysToExpiration,tasa,vHist,optionValue);
                  break;
            }
        
      
    return Option.getDerivativesArray();
    }

    public double[][] PJSplOutput(double[][] inputs, int daysType)
    {
        // TODO: Exchange the default return implementation for "PLOutput" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        
        int elements    =61;
        double[][] PLArray          = new double[1][elements];
        
        //double[]    precios          =new double[61];
        int         Code             =(int)inputs  [0][0];
        double      UnderlyingValue  =inputs       [0][1];
        double      divRate          =inputs       [0][2];
        double      vHist            =inputs       [0][3];
        double      optionValue      =inputs       [0][4];
        double      strike           =inputs       [0][5];
        double      daysToExpiration =inputs       [0][6];
        double      Tasa             =inputs       [0][7];
        int         flag             =(int)inputs  [0][8];     
        double      vltChart         =inputs       [0][9];
        double      desvStd          =inputs       [0][10];
        double      diasProy         =inputs       [0][11];
        int         CodeGraph        =(int)inputs  [0][12];
        double      lotPrime         =inputs       [0][13];
        double      daysFrom1stVcto  =inputs       [0][14];
        double      multiplicador    =inputs       [0][15];
        String      ticker           ="No ticker";
        
        double daysToShow =(daysType==0) ? daysFrom1stVcto:daysToExpiration;
        
        CodeBreaker code2=new CodeBreaker(Code);
          int Modelo            =code2.Modelo;
          char TipoEjercicio    =code2.TE;
          char TipoContrato     =code2.TC;
          char CP               =code2.CP;
          int ValueToFind       =code2.ValueToFind;
          int Steps             =code2.Steps;
          
        
        double coef             =Math.sqrt(diasProy/365)*vltChart;
        double precioMin        =UnderlyingValue*Math.exp(coef*-desvStd);
        double precioMax        =UnderlyingValue*Math.exp(coef*desvStd);
        double ratioLog         =Math.exp(Math.log(precioMax/precioMin)/(elements-1));
        
        /*
        poner precios en pos[0]
        switch flag
                :0 posicion anulada
                :1 activa calcular
        */
        switch (flag)
        {
            case 0: //Devuelve el array en cero
                 for (int i=0;i<elements;i++){
                    PLArray[0][i]=0;
                 }
                 break;
            
            case 1: //Devuelve el PL
                 for (int i=0; i<elements;i++) {
                      //Aca va todo el calculo del P & L
                      
                    Underlying Und=new Underlying(ticker,TipoContrato,precioMin*Math.pow(ratioLog,i),vHist,divRate);
                    WhaleyV2 Option=new WhaleyV2(Und,CP,strike,daysToShow,Tasa,vHist,0);
                    PLArray[0][i]=(Option.getPrima()-lotPrime)*multiplicador;
                 }
                 break;
            
            case 2: //Devuelve los precios
                 for (int i=0;i<elements;i++){
                    PLArray[0][i]=precioMin*Math.pow(ratioLog,i);
                    }
                 break;
            case 3: //Devuelve el delta
                 for (int i=0; i<elements;i++) {
                      //Aca va todo el calculo del P & L
                      
                    Underlying Und=new Underlying(ticker,TipoContrato,precioMin*Math.pow(ratioLog,i),vHist,divRate);
                    WhaleyV2 Option=new WhaleyV2(Und,CP,strike,daysToShow,Tasa,vHist,0);
                    PLArray[0][i]=Option.getDelta()*multiplicador;
                 }
            break;
            case 4://Devuelve el gamma
                 for (int i=0; i<elements;i++) {
                      
                    Underlying Und=new Underlying(ticker,TipoContrato,precioMin*Math.pow(ratioLog,i),vHist,divRate);
                    WhaleyV2 Option=new WhaleyV2(Und,CP,strike,daysToShow,Tasa,vHist,0);
                    PLArray[0][i]=Option.getGamma()*multiplicador;
                 }
            break;
                   
        }
            
        return PLArray;
    }

    public double[][] PJS1(double[][] parameter0, double[][] parameter1, double flag1, double flag2)
    {
        // TODO: Exchange the default return implementation for "PJS1" !!!
        // NOTE: Default initialized polymorphic structs can cause problems
        // because of missing default initialization of primitive types of
        // some C++ compilers or different Any initialization in Java and C++
        // polymorphic structs.
        return new double[0][0];
    }

    // com.sun.star.lang.XLocalizable:
    public void setLocale(com.sun.star.lang.Locale eLocale)
    {
        m_locale = eLocale;
    }

    public com.sun.star.lang.Locale getLocale()
    {
        return m_locale;
    }

}
