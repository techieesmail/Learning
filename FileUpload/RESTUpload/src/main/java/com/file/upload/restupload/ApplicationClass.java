/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.file.upload.restupload;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

//@ApplicationPath("/app")
public class ApplicationClass extends ResourceConfig{

    public ApplicationClass() {
        super(MultiPartFeature.class,FileUploadedResource.class);
    }
    
}
