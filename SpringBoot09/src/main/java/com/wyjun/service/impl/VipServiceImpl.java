package com.wyjun.service.impl;

import com.wyjun.entity.Vip;
import com.wyjun.mapper.VipMapper;
import com.wyjun.service.VipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VipServiceImpl implements VipService {

    private final VipMapper vipMapper;

    @Override
    public Vip selectVipById(Long id) {
        return vipMapper.selectById(id);
    }

    @Override
    public int deleteVipById(Long id) {
        return vipMapper.deleteById(id);
    }

    @Override
    public int updateVip(Vip vip) {
        return vipMapper.update(vip);
    }

    @Override
    public int insertVip(Vip vip) {
        return vipMapper.insert(vip);
    }

    @Override
    public List<Vip> getAllVips() {
        return vipMapper.selectAll();
    }
}
