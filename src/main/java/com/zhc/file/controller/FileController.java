package com.zhc.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhc.admin.pojo.User;
import com.zhc.file.dao.FileDao;
import com.zhc.file.pojo.FilePojo;
import com.zhc.file.service.FileService;
import com.zhc.util.Page;
/**
 * 文件上传下载
 * @author zxm
 *
 */
@Controller
@RequestMapping("admin/file")
public class FileController {
	/*
    自动注入userService
	 */
	@Autowired
	private FileService fileService;
	
	@RequestMapping("list")
	public ModelAndView fileList(
			Page page,
//			@RequestParam(required=true,defaultValue="1")Integer page,
//			@RequestParam(required=false,defaultValue="6")Integer pageSize,
			HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		
		//将路径放入map中
		//ServletContext sc = request.getSession().getServletContext();
		//String uploadFilePath =  sc.getRealPath("/upload")+"/";
		//Map<String,String> fileNameMap = new HashMap<>();
		//listfile(new File(uploadFilePath),fileNameMap);
		
		//分页
		PageHelper.offsetPage(page.getStart(),5);
		List<FilePojo> list = fileService.selectAll();
		int total = (int) new PageInfo<>(list).getTotal();
		page.caculateLast(total);
		//另一种分页
		//PageHelper.startPage(1,6);
		//PageInfo<FilePojo> p = new PageInfo<FilePojo>(list);
		// 放入转发参数
		mv.addObject("list", list);
		//mv.addObject("page", p);
		// 放入jsp路径
		mv.setViewName("blog/file");
		return mv;
	}
	public void listfile(File file,Map<String,String> map){
		if(!file.isFile()){
			File files[] = file.listFiles();
			for(File f:files){
				listfile(f,map);
			}
		}
		else{
			String realName = file.getName().substring(file.getName().indexOf("_")+1);
			map.put(file.getName(), realName);
		}
	}
	/**
	 * 一次上传多个文件
	 */
	@RequestMapping("Upload")
	public String FileUpload(@RequestParam("file") CommonsMultipartFile files[],Integer id,
			HttpServletRequest request, ModelMap model,HttpSession session){
		System.out.println(1 + " " + id);
		List<String> list = new ArrayList<String>();
		//获得项目的路径
		//ServletContext sc = request.getSession().getServletContext();
		//上传位置
		String path = request.getSession().getServletContext().getRealPath("upload");
		String path1 = path.substring(path.lastIndexOf("\\")+1); //设定文件保存的目录
		File f = new File(path1);
		if(!f.exists())
			f.mkdirs();
		
		for(int i = 0; i < files.length; i++){
			//获得原始文件名
			String fileName = files[i].getOriginalFilename();
			System.out.println("原始文件："+fileName);
			//新文件名
			String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ fileName;
			System.out.println(path);
			path1 = path+File.separator+newFileName;
			if(!files[i].isEmpty()){
				FilePojo file = new FilePojo();
				file.setName(newFileName);
				file.setPath("upload"+File.separator+newFileName);
				User user = (User) session.getAttribute("user");
				System.out.println(user.getId());
				file.setUid(user.getId());
				fileService.save(file);
				try {
					FileOutputStream fos = new FileOutputStream(path1);
					InputStream in = files[i].getInputStream();
					int b = 0;
					while((b=in.read())!=-1){
						fos.write(b);
					}
					fos.close();
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("上传文件到："+path1);
			list.add(fileName);
		}
		//保存文件地址，用于jsp页面显示
		request.setAttribute("fileList", list);
		//model.addAttribute("fileList",list);
		return "redirect:list";
	}
	
	@RequestMapping("down")
	public void downFile(HttpServletRequest request,HttpServletResponse response){
		String fileName = request.getParameter("filename");
		System.out.println(fileName);
		try {
			//fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
			ServletContext sc = request.getSession().getServletContext();
			String fileSaveRootPath = sc.getRealPath("/upload");
			System.out.println(fileSaveRootPath+File.separator+fileName);
			File file = new File(fileSaveRootPath+File.separator+fileName);
			if(!file.exists()){
				request.setAttribute("message", "您要下载的资源已被删除！");
				System.out.println("您要下载的资源已被删除！");
				return ;
			}
			String realname = fileName.substring(fileName.indexOf("_")+1);
			response.setHeader("content-disposition", "attachment;filename="
					+URLEncoder.encode(realname,"UTF-8"));
			response.setContentType("multipart/form-data");
			FileInputStream in =  new FileInputStream(fileSaveRootPath+File.separator+fileName);
			OutputStream out =  response.getOutputStream();
			byte buffer[] = new byte[1024];
			int len = 0;
			while((len=in.read(buffer))>0){
				out.write(buffer,0,len);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("delete")
	public String delete(@RequestParam("id") String id,HttpServletRequest request,HttpServletResponse response){
		fileService.delete(Integer.parseInt(id));
		
		return "redirect:list";
	}
}
