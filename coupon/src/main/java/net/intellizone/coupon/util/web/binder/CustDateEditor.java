// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CustDateEditor.java

package net.intellizone.coupon.util.web.binder;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import org.springframework.util.StringUtils;

public class CustDateEditor extends PropertyEditorSupport
{

	private final DateFormat dateFormat;
	private final boolean allowEmpty;
	private final int exactDateLength;

	public CustDateEditor(DateFormat dateFormat, boolean allowEmpty)
	{
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
		exactDateLength = -1;
	}

	public CustDateEditor(DateFormat dateFormat, boolean allowEmpty, int exactDateLength)
	{
		this.dateFormat = dateFormat;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = exactDateLength;
	}

	public void setAsText(String text)
		throws IllegalArgumentException
	{
		if (allowEmpty && !StringUtils.hasText(text))
		{
			setValue(null);
		} else
		{
			if (text != null && exactDateLength >= 0 && text.length() != exactDateLength)
				throw new IllegalArgumentException((new StringBuilder("Could not parse date: it is not exactly")).append(exactDateLength).append("characters long").toString());
			try
			{
				setValue(dateFormat.parse(text));
			}
			catch (ParseException ex)
			{
				setValue(new Date());
			}
		}
	}

	public String getAsText()
	{
		Date value = (Date)getValue();
		return value == null ? "" : dateFormat.format(value);
	}
}
