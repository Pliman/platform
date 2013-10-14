// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   PageList.java

package net.intellizone.coupon.util.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


//			PageProperty

public class PageList
	implements Serializable
{

	private int page;
	private int totalRecords;
	private int totalPages;
	private int pageSize;
	private int numbersPerBlock;
	private List records;

	public PageList()
	{
		page = 1;
		pageSize = 20;
		numbersPerBlock = 10;
		records = new ArrayList();
	}

	public PageList(PageProperty pp, int allCount, List list)
	{
		page = 1;
		pageSize = 20;
		numbersPerBlock = 10;
		records = new ArrayList();
		if (pp.getNpage() > 0)
			page = pp.getNpage();
		if (pp.getNpagesize() > 0)
			pageSize = pp.getNpagesize();
		totalRecords = allCount;
		if (totalRecords % pageSize > 0)
			totalPages = totalRecords / pageSize + 1;
		else
			totalPages = totalRecords / pageSize;
		setRecords(list);
	}

	public List getRecords()
	{
		return records;
	}

	public void setRecords(List records)
	{
		this.records = records;
	}

	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		if (page < 1)
			page = 1;
		this.page = page;
	}

	public int getPageNumber()
	{
		int pageNumber = 0;
		if (totalRecords % pageSize == 0)
			pageNumber = totalRecords / pageSize;
		else
			pageNumber = 1 + totalRecords / pageSize;
		return pageNumber;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getTotalRecords()
	{
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords)
	{
		this.totalRecords = totalRecords;
	}

	public int getFirstRow()
	{
		return (page - 1) * pageSize + 1;
	}

	public int getLastRow()
	{
		return page != getPageNumber() ? page * pageSize : getTotalRecords();
	}

	public int getPreviousPage()
	{
		return page <= 1 ? page : page - 1;
	}

	public int getNextPage()
	{
		return page >= getPageNumber() ? page : page + 1;
	}

	public int getBlocks()
	{
		if (getPageNumber() % numbersPerBlock == 0)
			return getPageNumber() / numbersPerBlock;
		else
			return 1 + getPageNumber() / numbersPerBlock;
	}

	public int getBlock()
	{
		if (getPage() % numbersPerBlock == 0)
			return getPage() / numbersPerBlock;
		else
			return 1 + getPage() / numbersPerBlock;
	}

	public int getNumbersPerBlock()
	{
		return numbersPerBlock;
	}

	public void setNumbersPerBlock(int numberPerBlock)
	{
		numbersPerBlock = numberPerBlock;
	}

	public int getPageOfPrevBlock()
	{
		if (getBlock() > 1)
			return (getBlock() - 1) * getNumbersPerBlock();
		else
			return 1;
	}

	public int getPageOfNextBlock()
	{
		if (getBlock() < getBlocks())
			return getBlock() * getNumbersPerBlock() + 1;
		else
			return getTotalRecords();
	}

	public int getTotalPages()
	{
		return totalPages;
	}

	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}
}
