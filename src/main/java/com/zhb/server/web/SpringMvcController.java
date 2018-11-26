package com.zhb.server.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zhb.server.bean.User;

@Controller
public class SpringMvcController {

	@ResponseBody
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public Map<String, String> fileUpload(@RequestParam(value="fileName", required = true)  MultipartFile fileName) throws IllegalStateException, IOException {
		Map<String, String> map = new HashMap<>();
		System.out.println(fileName.getOriginalFilename());
		fileName.transferTo(new File("d:/" + fileName.getOriginalFilename()));
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping(value="/jspTest")
	public String jspTest(Model model) {
		List<User> list = new ArrayList<>();
		list.add(new User(1, "aaa", 111));
		list.add(new User(2, "bbb", 222));
		list.add(new User(3, "ccc", 333));
		model.addAttribute("userList", list);
		return "jspTest";
	}
	
}
