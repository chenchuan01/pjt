/**
 * ifenduo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yidingliu.pjt.api.swagger;

import com.google.common.collect.Ordering;
import com.mangofactory.swagger.models.dto.ApiListingReference;

/**
 *                       
 * @Filename APIListingLexicographicalOrdering.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author edyang
 *
 * @Email edyang123@gmail.com
 *       
 * @History
 *<li>Author: edyang</li>
 *<li>Date: 2015年12月18日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class APIListingLexicographicalOrdering extends Ordering<ApiListingReference>{

	@Override
	public int compare(ApiListingReference first, ApiListingReference second) {
		return first.getPosition()-(second.getPosition());
	}

}
