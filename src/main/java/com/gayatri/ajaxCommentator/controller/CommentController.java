package com.gayatri.ajaxCommentator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gayatri.ajaxCommentator.model.UserComment;


@RestController
public class CommentController {
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getAllComments/{count:.+}", method=RequestMethod.GET)
	public @ResponseBody JSONObject getCommentResponse(@PathVariable("count") int count,
			HttpServletRequest request, HttpServletResponse response){
		
		JSONObject jsonobj = new JSONObject();
		List<UserComment> list = new ArrayList<UserComment>();
		
		for(int i=0; i < count; i++){
			UserComment commentObj = new UserComment();
			commentObj.setComment("Comment"+i); 
			commentObj.setUserName("Helen"+i);
			list.add(commentObj);
		}
		
		jsonobj.put("listOfComments", list);
		jsonobj.put("status", HttpStatus.OK.value());
		return jsonobj;
	}

}
