//package com.cloud.auth.core.execption;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
//import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
//
//    @Override
//    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
//
//        OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
//
//        return new ResponseEntity<OAuth2Exception>(new OAuth2Exception(oAuth2Exception.getMessage()),
//                HttpStatus.valueOf(oAuth2Exception.getHttpErrorCode()));
//
//
//    }
//}