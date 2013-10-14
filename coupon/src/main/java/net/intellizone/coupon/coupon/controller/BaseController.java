package net.intellizone.coupon.coupon.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import net.intellizone.coupon.util.web.binder.CustDateEditor;

import org.springframework.web.bind.WebDataBinder;

public class BaseController
{

	public BaseController()
	{
	}

	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustDateEditor(dateFormat, true));
		/**binder.registerCustomEditor(Long.TYPE, new CustLongEditor());
		binder.registerCustomEditor(Integer.TYPE, new CustIntEditor());
		binder.registerCustomEditor(Float.TYPE, new CustFloatEditor());
		binder.registerCustomEditor(Double.TYPE, new CustDoubleEditor());
		binder.registerCustomEditor([B, new ByteArrayMultipartFileEditor());**/
	}
}
