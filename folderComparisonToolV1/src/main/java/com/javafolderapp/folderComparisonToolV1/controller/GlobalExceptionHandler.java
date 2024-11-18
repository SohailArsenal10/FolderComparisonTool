package com.javafolderapp.folderComparisonToolV1.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    //StandardServletMultipartResolver
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {//Model model

        //redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        //model.addAttribute("message", "Error occured MultipartException");
        System.out.println(e.getCause().getMessage());
        return "redirect:/error";
        //return "UploadFiles";

    }

    //CommonsMultipartResolver
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleError2(MaxUploadSizeExceededException e, RedirectAttributes redirectAttributes) {//Model model

        redirectAttributes.addFlashAttribute("message", "Max input file(s) size exceeded");
        //model.addAttribute("message", "Error occured MaxUploadSizeExceededException");
        System.out.println(e.getCause().getMessage());
        return "redirect:/UploadFiles";
        //return "UploadFiles";

    }

}
