package com.xuanwu.demo.web.controller.sys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuanwu.demo.common.entity.PageInfo;
import com.xuanwu.demo.common.entity.QueryParameters;
import com.xuanwu.demo.common.entity.User;
import com.xuanwu.demo.common.entity.json.JsonResp;
import com.xuanwu.demo.common.entity.json.PageReqt;
import com.xuanwu.demo.common.entity.json.PageResp;
import com.xuanwu.demo.common.service.UserService;

/**
 * @Description 
 * @author Beck Wu
 * @Data 2015年7月23日
 * @Version 1.0.0
 */
@Controller
@RequestMapping("sys/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;

	@RequestMapping(value = "index")
	public void index(){
		
	}
	
	@ResponseBody
	@RequestMapping(value = "query")
	public JsonResp query(Model model, @RequestBody PageReqt reqt){
		try {
			PageResp resp = null;
			QueryParameters param = new QueryParameters();
			param.addParams(reqt.getParams());
			param.addSorts(reqt.getSorts());
			int total = service.resultCount(param);
			if (total > 0) {
				param.setPage(new PageInfo(reqt.getPage(), reqt.getCount(),
						total));
				resp = PageResp.success(total, service.list(param));
			}
			return resp == null ? PageResp.emptyResult() : resp;
		} catch (Exception e) {
			logger.error("List apps failed: ", e);
			return JsonResp.fail(e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "{id}")
	public User getUserById(Model model, @PathVariable("id")int userId){
		return service.loadById(userId);
	}
	
	@RequestMapping(value = "editView")
	public String editView(Model model){
		return "sys/user/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "save")
	public JsonResp doSave(Model model, @RequestBody User user){
		try{
			service.save(user);
			return JsonResp.success();
		} catch (Exception e){
			logger.error("Save user failed: ", e);
			return JsonResp.fail("保存用户失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "del")
	public JsonResp doDel(Model model, @RequestBody int[] ids){
		try{
			for(int id : ids){
				service.removeById(id);
			}
			return JsonResp.success();
		} catch (Exception e){
			logger.error("Delete user failed: ", e);
			return JsonResp.fail("删除用户失败");
		}
	}
}
