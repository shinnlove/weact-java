/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.controller;

import java.util.List;

import com.shinnlove.util.log.ExceptionUtil;
import com.shinnlove.util.log.LoggerUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinnlove.dal.dao.RandomTeamDao;
import com.shinnlove.dal.model.RandomTeam;

/**
 * 主页测试控制器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: IndexController.java, v 0.1 2017-12-31 上午12:14 shinnlove.jinsheng Exp $$
 */
@Controller
public class IndexController {

    /** 日志 */
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private RandomTeamDao randomTeamDao;

    @RequestMapping("/home/index")
    public String index(ModelMap modelMap) {
        LoggerUtil.info(logger, "进入了当前控制器/home/index");
        ExceptionUtil.error(new RuntimeException("自定义错误"), "验证util的bundle中的类");
        List<RandomTeam> randomTeamList = randomTeamDao.queryTeam();
        modelMap.addAttribute("randomTeamList", randomTeamList);
        return "index";
    }

    @RequestMapping("/home/uploadPage")
    public String uploadPage() {
        return "uploadPage";
    }

}