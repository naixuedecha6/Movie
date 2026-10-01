package com.zrkworld.cinema.service.impl;

import com.zrkworld.cinema.mapper.ManagerMapper;
import com.zrkworld.cinema.pojo.Manager;
import com.zrkworld.cinema.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author zrk
 * @version 1.0
 * @date 2020/5/1 0001 11:45
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    ManagerMapper managerMapper;
    @Override
    public Manager selectByManagerId(String managerId) {
       return managerMapper.selectByManagerId(managerId);
    }

    @Override
    public Manager managerLogin(String managerId, String password) {

        Manager manager = managerMapper.managerLogin(managerId,password);
        if(manager!=null){
            managerMapper.updateManagerTime(manager.getManagerId());
            return manager;
        }
        return null;
    }

}
