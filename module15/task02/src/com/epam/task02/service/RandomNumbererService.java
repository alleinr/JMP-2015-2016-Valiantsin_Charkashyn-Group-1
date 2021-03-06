
package com.epam.task02.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "RandomNumbererService", targetNamespace = "http://service.task02.epam.com/", wsdlLocation = "http://localhost:1234/ws/random?wsdl")
public class RandomNumbererService
    extends Service
{

    private final static URL RANDOMNUMBERERSERVICE_WSDL_LOCATION;
    private final static WebServiceException RANDOMNUMBERERSERVICE_EXCEPTION;
    private final static QName RANDOMNUMBERERSERVICE_QNAME = new QName("http://service.task02.epam.com/", "RandomNumbererService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:1234/ws/random?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RANDOMNUMBERERSERVICE_WSDL_LOCATION = url;
        RANDOMNUMBERERSERVICE_EXCEPTION = e;
    }

    public RandomNumbererService() {
        super(__getWsdlLocation(), RANDOMNUMBERERSERVICE_QNAME);
    }

    public RandomNumbererService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RANDOMNUMBERERSERVICE_QNAME, features);
    }

    public RandomNumbererService(URL wsdlLocation) {
        super(wsdlLocation, RANDOMNUMBERERSERVICE_QNAME);
    }

    public RandomNumbererService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RANDOMNUMBERERSERVICE_QNAME, features);
    }

    public RandomNumbererService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RandomNumbererService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IRandomNumberer
     */
    @WebEndpoint(name = "RandomNumbererPort")
    public IRandomNumberer getRandomNumbererPort() {
        return super.getPort(new QName("http://service.task02.epam.com/", "RandomNumbererPort"), IRandomNumberer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IRandomNumberer
     */
    @WebEndpoint(name = "RandomNumbererPort")
    public IRandomNumberer getRandomNumbererPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.task02.epam.com/", "RandomNumbererPort"), IRandomNumberer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RANDOMNUMBERERSERVICE_EXCEPTION!= null) {
            throw RANDOMNUMBERERSERVICE_EXCEPTION;
        }
        return RANDOMNUMBERERSERVICE_WSDL_LOCATION;
    }

}
