// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PageProperty.java

package net.intellizone.coupon.util.web;

import java.util.*;

public class PageProperty
{

	private int npage;
	private int nfirstindex;
	private int npagesize;
	private String searchString;
	private String orderString;
	private List parameterList;
	private HashMap paramMap;

	public PageProperty(int page, int pagesize, String searchString, String orderString)
	{
		npagesize = pagesize;
		npage = page;
		this.searchString = searchString;
		this.orderString = orderString;
	}

	public PageProperty()
	{
		npage = 1;
		npagesize = 0;
		nfirstindex = 0;
		searchString = "";
		orderString = "";
	}

	public int getNfirstindex()
	{
		nfirstindex = (npage - 1) * npagesize;
		return nfirstindex;
	}

	public void setNfirstindex(int nfirstindex)
	{
		this.nfirstindex = nfirstindex;
	}

	public int getNpagesize()
	{
		return npagesize;
	}

	public void setNpagesize(int npagesize)
	{
		this.npagesize = npagesize;
	}

	public String getOrderString()
	{
		return orderString;
	}

	public void setOrderString(String orderString)
	{
		this.orderString = orderString;
	}

	public String getSearchString()
	{
		return searchString;
	}

	public void setSearchString(String searchString)
	{
		this.searchString = searchString;
	}

	public List getParameterList()
	{
		return parameterList;
	}

	public void setParameterList(List parameterList)
	{
		this.parameterList = parameterList;
	}

	public void addParamter(Object o)
	{
		initParameterList();
		parameterList.add(o);
	}

	public void addParamter(int index, Object o)
	{
		initParameterList();
		parameterList.add(index, o);
	}

	public void clearParamter()
	{
		initParameterList();
		parameterList.clear();
	}

	public void initParameterList()
	{
		if (parameterList == null)
			parameterList = new ArrayList();
	}

	public int getNpage()
	{
		return npage;
	}

	public void setNpage(int page)
	{
		npage = page;
	}

	public HashMap getParamMap()
	{
		initParamMap();
		return paramMap;
	}

	public void putParamMap(String name, Object o)
	{
		initParamMap();
		paramMap.put(name, o);
	}

	public void clearParamMap()
	{
		initParamMap();
		paramMap.clear();
	}

	public void initParamMap()
	{
		if (paramMap == null)
			paramMap = new HashMap();
	}
}
