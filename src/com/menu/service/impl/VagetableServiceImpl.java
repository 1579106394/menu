package com.menu.service.impl;

import com.menu.mapper.VagetableMapper;
import com.menu.pojo.Vagetable;
import com.menu.service.VagetableService;
import com.menu.utils.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class VagetableServiceImpl implements VagetableService {

    @Autowired
    private VagetableMapper vagetableMapper;

    @Override
    public List<Vagetable> getVageList(Vagetable vage) {
        return vagetableMapper.getVageList(vage);
    }

    @Override
    public void addVage(Vagetable vage) {
        // 补充部分属性
        vage.setVageId(UUID.randomUUID().toString());
        vage.setVageDelete(1);
        vagetableMapper.addVage(vage);
    }

    @Override
    public void deleteVage(String vageId) {
        vagetableMapper.deleteVage(vageId);
    }

    @Override
    public Vagetable getVageById(String vageId) {
        return vagetableMapper.getVageById(vageId);
    }

    @Override
    public void editVage(Vagetable vage) {
        vagetableMapper.editVage(vage);
    }

    @Override
    public Double priceSum(OrderVo orderVo) {
        return vagetableMapper.priceSum(orderVo);
    }

    @Override
    public List<Vagetable> getVageListByOrder(String orderId) {
        return vagetableMapper.getVageListByOrder(orderId);
    }

}
