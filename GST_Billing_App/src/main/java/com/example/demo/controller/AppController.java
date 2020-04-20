package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.MysqlModel.product_info;
import com.example.demo.PRepository.PService;
import com.example.demo.PRepository.ProductRepository;
import com.example.demo.Search.CalForm;
import com.example.demo.Search.SName;
import com.example.demo.form.SubmitForm;



@Controller
public class AppController {
	
	@Autowired
	private PService service;
	
	/*@RequestMapping(value="/pro",method=RequestMethod.GET)
	public String getLoginForm()
	{
		return "ProductEntry";//return html page name
	}*/
	
	@RequestMapping(value="/pro")
	public String veiwList(Model m1)
	{
		List<product_info>lp=service.listAll();
		m1.addAttribute("listProduct", lp);
		return "ProductEntry";
	}
	
	@RequestMapping(value="/sub",method=RequestMethod.POST)
	public String login(@ModelAttribute(name="SubmitForm")product_info product,Model model) {
		
		String product_code=product.getProduct_code();
		String product_name=product.getProduct_name(); 
		String product_price=product.getProduct_price(); 
		String product_GST=product.getProduct_GST();
		
		if(product_code.length()>0 && product_name.length()>0 && product_price.length()>0 && product_GST.length()>0)
		{
			service.save(product);
			return "redirect:/pro";
		}
		else
		{
			model.addAttribute("invalidCredentials",true);
			return "redirect:/pro";
		}
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name="id") Long id) {
		ModelAndView mav=new ModelAndView("edit_product");
		
		product_info pro=service.get(id);
		mav.addObject("product_info", pro);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") Long id)
	{
		service.delete(id);
		return "redirect:/pro";
	}
	
	@RequestMapping(value="/billing")
	public String BillPage(Model m2)
	{
		m2.addAttribute("SearchedProduct", CalList);
		return ("Billing");
	}
	
	List<product_info>SearchedList=new ArrayList<>();
	List<CalForm>CalList=new ArrayList<>();
	List<String> pro=new ArrayList<>();
	//List<Long>price=new ArrayList<>();
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String Searching(@ModelAttribute(name="SearchedForm")SName sname,Model m2) {
		String toSearch=sname.getToSearch();
		System.out.println(toSearch);
		List<product_info>lp=service.listAll();
		
		int j=-1;
		for(int i=0;i<lp.size();i++)
		{
			product_info temp=lp.get(i);
			System.out.println(temp.getProduct_name()+"  "+toSearch+" "+i);
			if((temp.getProduct_code()).equalsIgnoreCase(toSearch)==true  || (temp.getProduct_name()).equalsIgnoreCase(toSearch)==true )
			{
				j=i;
				break;
			}
		}
		if(j!=-1)
		{
			System.out.println(lp.get(j).getProduct_name()+"  "+toSearch+" "+j);
			product_info tt=lp.get(j);
			if(pro.contains(lp.get(j).getProduct_code())==false)
			{
			SearchedList.add(lp.get(j));
			pro.add(lp.get(j).getProduct_code());
			CalList.add(new CalForm(tt.getProduct_code(),tt.getProduct_name(),tt.getProduct_price(),tt.getProduct_GST(),"0",tt.getId(),"0","0"));
			//m2.addAttribute("SearchedProduct", SearchedList);
			}
		}
		return ("redirect:/billing");
	}
	
	@RequestMapping(value="/cal")
	public String Cal(@ModelAttribute(name="CalForm")CalForm calform,Model m1)
	{
		System.out.println(calform.getQuantity()+"***");
		if(calform.getQuantity()!=null)
		{
			String[] arr=calform.getQuantity().split(",");
			double p=0;
			for(int i=0;i<arr.length;i++)
			{
				CalForm temp=CalList.get(i);
				double pricee=Double.parseDouble(arr[i])*(Double.parseDouble(temp.getProduct_price()) +( (Double.parseDouble(temp.getProduct_GST())/100)*Double.parseDouble(temp.getProduct_price())));
				temp.setQuantity(arr[i]);
				temp.setTotalPrice(Double.toString(pricee));
				p=p+pricee;
				//price.add(pricee);
			}
			
			for(int i=0;i<arr.length;i++)
			{
				CalForm temp=CalList.get(i);
				temp.setGross(Double.toString(p));
			}
		}
		return "redirect:/billing";
	}
}
