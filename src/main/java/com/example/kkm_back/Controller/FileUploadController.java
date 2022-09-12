//package com.example.kkm_back.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//@Controller
//public class FileUploadController {
//    @Autowired
//    FileService fs;
//
//    @RequestMapping("form")
//    public String form() {
//        return "uploadForm";
//    }
//
//    @PostMapping("upload")
//    public String upload(MultipartHttpServletRequest mul) {
//        fs.fileProcess(mul);
//        return "redirect:form";
//    }
//}
