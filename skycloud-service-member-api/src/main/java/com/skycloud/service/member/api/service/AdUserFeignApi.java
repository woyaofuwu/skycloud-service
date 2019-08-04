/*
 * The MIT License (MIT)
 * Copyright © 2019 <sky>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the “Software”), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.skycloud.service.member.api.service;

import com.sky.framework.model.dto.MessageRes;
import com.skycloud.base.common.feign.CustomFeignAutoConfiguration;
import com.skycloud.service.common.constant.FeginConstants;
import com.skycloud.service.member.api.model.dto.CustomLoginDto;
import com.skycloud.service.member.api.service.factory.AdUserFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author
 */
@FeignClient(name = FeginConstants.MEMBER, configuration = CustomFeignAutoConfiguration.class, fallbackFactory = AdUserFeignFallbackFactory.class)
public interface AdUserFeignApi {

    /**
     * 登录
     *
     * @param customLoginDto
     * @return
     */
    @PostMapping(value = "/api/user/login")
    MessageRes<CustomLoginDto> login(@RequestBody CustomLoginDto customLoginDto);
}
