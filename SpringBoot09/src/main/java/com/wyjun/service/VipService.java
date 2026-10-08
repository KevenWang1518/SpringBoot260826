package com.wyjun.service;

import com.wyjun.entity.Vip;

import java.util.List;

public interface VipService {
    List<Vip> getAllVips();

    Vip selectVipById(Long id);

    int deleteVipById(Long id);

    int updateVip(Vip vip);

    int insertVip(Vip vip);
}
