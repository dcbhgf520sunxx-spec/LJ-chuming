package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysCity;
import com.hzchum.scim.system.core.api.pojo._do.SysProvince;
import com.hzchum.scim.system.core.api.pojo._do.SysRegion;
import com.hzchum.scim.system.core.api.pojo.dto.SysAreaDTO;
import com.hzchum.scim.system.core.api.service.SysCityService;
import com.hzchum.scim.system.core.api.service.SysProvinceService;
import com.hzchum.scim.system.core.api.service.SysRegionService;
import com.hzchum.scim.system.core.mapper.SysCityMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysCityServiceImpl extends ServiceImpl<SysCityMapper, SysCity> implements SysCityService {
   @Resource
   private SysCityService cityService;
   @Resource
   private SysProvinceService provinceService;
   @Resource
   private SysRegionService regionService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saves(List<SysAreaDTO> areaDTOList) {
      for (SysAreaDTO a : areaDTOList) {
         if (a.getLevel().equals("province")) {
            SysProvince province = this.provinceService.getOne(Wrappers.lambdaQuery(SysProvince.class).eq(SysProvince::getCode, a.getAdcode()));
            if (province == null) {
               province = new SysProvince();
               province.setCode(String.valueOf(a.getAdcode()));
               province.setCountryId(1L);
               province.setName(a.getName());
               this.provinceService.save(province);
            }
         }

         if (a.getLevel().equals("city")) {
            SysCity city = this.cityService.getOne(Wrappers.lambdaQuery(SysCity.class).eq(SysCity::getCode, a.getAdcode()));
            if (city == null) {
               city = new SysCity();
               city.setCode(String.valueOf(a.getAdcode()));
               city.setName(a.getName());
               SysProvince province = this.provinceService.getOne(Wrappers.lambdaQuery(SysProvince.class).eq(SysProvince::getCode, a.getParent()));
               if (province == null) {
                  continue;
               }

               city.setProvinceId(province.getId());
               this.cityService.save(city);
            }
         }

         if (a.getLevel().equals("district")) {
            SysRegion sysRegion = this.regionService.getOne(Wrappers.lambdaQuery(SysRegion.class).eq(SysRegion::getCode, a.getAdcode()));
            SysCity city = this.cityService.getOne(Wrappers.lambdaQuery(SysCity.class).eq(SysCity::getCode, a.getAdcode()));
            if (sysRegion == null && city == null) {
               SysCity sysCity = this.cityService.getOne(Wrappers.lambdaQuery(SysCity.class).eq(SysCity::getCode, a.getParent()));
               SysProvince province = this.provinceService.getOne(Wrappers.lambdaQuery(SysProvince.class).eq(SysProvince::getCode, a.getParent()));
               if (sysCity != null) {
                  SysRegion region = new SysRegion();
                  region.setCode(a.getAdcode());
                  region.setName(a.getName());
                  region.setCityId(sysCity.getId());
                  region.setProvinceId(sysCity.getProvinceId());
                  this.regionService.save(region);
               } else if (province != null) {
                  SysCity city1 = new SysCity();
                  city1.setCode(a.getAdcode());
                  city1.setName(a.getName());
                  city1.setProvinceId(province.getId());
                  this.cityService.save(city1);
               }
            }
         }
      }

      return Boolean.TRUE;
   }

   @Override
   public Map<Long, SysCity> listMapByIds(List<Long> cityIds) {
      return CollectionUtils.isEmpty(cityIds)
         ? new HashMap<>()
         : this.baseMapper.selectBatchIds(cityIds).stream().collect(Collectors.toMap(SysCity::getId, item -> (SysCity)item));
   }
}
