
package com.google.api.ads.adwords.jaxws.v201402.video;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * 
 *       A service to view performance reports aggregated by video.
 *       Can also be used to make certain modifications to videos
 *       and their metadata, for instance, adding call-to-action overlays.
 *       <p class="note"><b>Note:</b> This is a Beta feature.</p>
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.1
 * 
 */
@WebService(name = "VideoServiceInterface", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
@XmlSeeAlso({
    com.google.api.ads.adwords.jaxws.v201402.cm.ObjectFactory.class,
    com.google.api.ads.adwords.jaxws.v201402.video.ObjectFactory.class
})
public interface VideoServiceInterface {


    /**
     * 
     *         Returns the list of videos that have been used in ads by the current
     *         customer, the match the filters given by the selector.
     *         
     *         @param selector Determines which videos to return.
     *         @return A list of videos.
     *         @throws ApiException if problems occurred while fetching videos.
     *       
     * 
     * @param selector
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201402.video.VideoPage
     * @throws ApiException
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
    @RequestWrapper(localName = "get", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402", className = "com.google.api.ads.adwords.jaxws.v201402.video.VideoServiceInterfaceget")
    @ResponseWrapper(localName = "getResponse", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402", className = "com.google.api.ads.adwords.jaxws.v201402.video.VideoServiceInterfacegetResponse")
    public VideoPage get(
        @WebParam(name = "selector", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
        VideoSelector selector)
        throws ApiException
    ;

    /**
     * 
     *         Updates existing call-to-action overlays.
     *       
     * 
     * @param operations
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201402.video.VideoReturnValue
     * @throws ApiException
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
    @RequestWrapper(localName = "mutateCallToAction", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402", className = "com.google.api.ads.adwords.jaxws.v201402.video.VideoServiceInterfacemutateCallToAction")
    @ResponseWrapper(localName = "mutateCallToActionResponse", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402", className = "com.google.api.ads.adwords.jaxws.v201402.video.VideoServiceInterfacemutateCallToActionResponse")
    public VideoReturnValue mutateCallToAction(
        @WebParam(name = "operations", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
        List<VideoCallToActionOperation> operations)
        throws ApiException
    ;

    /**
     * 
     *         Searches YouTube for videos that match the given query.
     *         
     *         @param selector Determines which videos to search for.
     *         @return A list of videos.
     *         @throws ApiException if problems occurred while searching for videos.
     *       
     * 
     * @param selector
     * @return
     *     returns com.google.api.ads.adwords.jaxws.v201402.video.VideoSearchPage
     * @throws ApiException
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
    @RequestWrapper(localName = "search", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402", className = "com.google.api.ads.adwords.jaxws.v201402.video.VideoServiceInterfacesearch")
    @ResponseWrapper(localName = "searchResponse", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402", className = "com.google.api.ads.adwords.jaxws.v201402.video.VideoServiceInterfacesearchResponse")
    public VideoSearchPage search(
        @WebParam(name = "selector", targetNamespace = "https://adwords.google.com/api/adwords/video/v201402")
        VideoSearchSelector selector)
        throws ApiException
    ;

}
