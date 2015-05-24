/**
 * 
 */

package com.my373.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my373.core.base.BaseController;

/**
 * IndexController
 * 
 * @author QQ:1219331697
 *
 */
@Controller
public class IndexController extends BaseController {

	@RequestMapping(value = { "", "/index" })
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) {

		return "index.html";
	}

}
