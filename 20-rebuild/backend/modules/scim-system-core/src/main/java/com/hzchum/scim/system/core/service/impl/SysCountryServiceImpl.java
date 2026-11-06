package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.pojo._do.SysCity;
import com.hzchum.scim.system.core.api.pojo._do.SysCountry;
import com.hzchum.scim.system.core.api.pojo._do.SysLocation;
import com.hzchum.scim.system.core.api.pojo._do.SysProvince;
import com.hzchum.scim.system.core.api.pojo._do.SysProvinceNew;
import com.hzchum.scim.system.core.api.pojo._do.SysRegion;
import com.hzchum.scim.system.core.api.pojo.dto.AddressResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.AddressSimpleInfoDTO;
import com.hzchum.scim.system.core.api.service.SysCityService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.SysProvinceService;
import com.hzchum.scim.system.core.api.service.SysRegionService;
import com.hzchum.scim.system.core.mapper.SysCityMapper;
import com.hzchum.scim.system.core.mapper.SysCountryMapper;
import com.hzchum.scim.system.core.mapper.SysLocationMapper;
import com.hzchum.scim.system.core.mapper.SysProvinceMapper;
import com.hzchum.scim.system.core.mapper.SysProvinceNewMapper;
import com.hzchum.scim.system.core.mapper.SysRegionMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SysCountryServiceImpl extends ServiceImpl<SysCountryMapper, SysCountry> implements SysCountryService {
   private final SysCountryMapper countryMapper;
   private final SysProvinceMapper provinceMapper;
   private final SysCityMapper cityMapper;
   private final SysRegionMapper regionMapper;
   private final RedisUtils redisUtils;
   @Resource
   private SysProvinceService sysProvinceService;
   @Resource
   private SysCityService sysCityService;
   @Resource
   private SysRegionService sysRegionService;
   @Resource
   private SysProvinceNewMapper provinceNewMapper;
   @Resource
   private SysLocationMapper locationMapper;

   @Override
   public List<AddressResponseVO> listAll() {
      String worldAddress = "world-address";
      Object object = this.redisUtils.get(worldAddress);
      if (object != null) {
         return (List<AddressResponseVO>)object;
      }

      List<AddressResponseVO> responses = this.countryMapper.listAllCountry();

      for (AddressResponseVO responseVO : responses) {
         List<AddressResponseVO> addressResponseVOS = this.provinceMapper.listProvinceByCountryId(responseVO.getId());
         if (!addressResponseVOS.isEmpty()) {
            for (AddressResponseVO provinceVO : addressResponseVOS) {
               List<AddressResponseVO> cityVOS = this.cityMapper.findByProvinceId(provinceVO.getId());

               for (AddressResponseVO cityVO : cityVOS) {
                  List<AddressResponseVO> regionVOS = this.regionMapper.listByCityId(cityVO.getId());
                  cityVO.setChildren(regionVOS);
               }

               provinceVO.setChildren(cityVOS);
            }

            responseVO.setChildren(addressResponseVOS);
         }
      }

      this.redisUtils.set(worldAddress, responses);
      return responses;
   }

   @Override
   public AddressSimpleInfoDTO regionalCascadeSplit(List<Long> regionalIds) {
      AddressSimpleInfoDTO addressSimpleInfoDTO = AddressSimpleInfoDTO.builder().build();
      if (CollectionUtils.isNotEmpty(regionalIds)) {
         AtomicInteger flag = new AtomicInteger();
         regionalIds.forEach(item -> {
            if (flag.get() == 0 && item != null) {
               SysCountry sysCountry = this.getById(item);
               addressSimpleInfoDTO.setCountryId(sysCountry.getId());
               addressSimpleInfoDTO.setCountryName(sysCountry.getName());
            }

            if (flag.get() == 1 && item != null) {
               SysProvince sysProvince = this.sysProvinceService.getById(item);
               addressSimpleInfoDTO.setProvinceId(sysProvince.getId());
               addressSimpleInfoDTO.setProvinceName(sysProvince.getName());
            }

            if (flag.get() == 2 && item != null) {
               SysCity sysCity = this.sysCityService.getById(item);
               addressSimpleInfoDTO.setCityId(sysCity.getId());
               addressSimpleInfoDTO.setCityName(sysCity.getName());
            }

            if (flag.get() == 3 && item != null) {
               SysRegion sysRegion = this.sysRegionService.getById(item);
               addressSimpleInfoDTO.setRegionId(sysRegion.getId());
               addressSimpleInfoDTO.setRegionName(sysRegion.getName());
            }

            flag.getAndIncrement();
         });
      }

      return addressSimpleInfoDTO;
   }

   @Override
   public List<AddressResponseVO> listAllNew() {
      String worldAddress = "world-address-new";
      Object object = this.redisUtils.get(worldAddress);
      if (object != null) {
         return (List<AddressResponseVO>)object;
      }

      List<AddressResponseVO> responses = this.countryMapper.listAllCountry();
      Map<Long, String> locationMap = this.locationMapper.selectList(null).stream().collect(Collectors.toMap(SysLocation::getId, SysLocation::getName));
      SysLocation sysLocation = this.locationMapper.selectOne((Wrapper<SysLocation>)new LambdaQueryWrapper<SysLocation>().eq(SysLocation::getName, "境外"));

      for (AddressResponseVO responseVO : responses) {
         List<SysProvinceNew> sysProvinceNews = this.provinceNewMapper
            .selectList((Wrapper<SysProvinceNew>)new LambdaQueryWrapper<SysProvinceNew>().eq(SysProvinceNew::getCountryId, responseVO.getId()));
         if (!responseVO.getName().equals("中国")) {
            responseVO.setLocationId(sysLocation.getId());
            responseVO.setLocationName(sysLocation.getName());
         }

         if (!sysProvinceNews.isEmpty()) {
            List<AddressResponseVO> addressResponseVOS = sysProvinceNews.stream().map(s -> {
               AddressResponseVO addressResponseVO = new AddressResponseVO();
               addressResponseVO.setId(s.getId());
               addressResponseVO.setName(s.getName());
               addressResponseVO.setLocationId(s.getLocationId());
               addressResponseVO.setLocationName(locationMap.get(s.getLocationId()));
               return addressResponseVO;
            }).collect(Collectors.toList());

            for (AddressResponseVO provinceVO : addressResponseVOS) {
               List<AddressResponseVO> cityVOS = this.cityMapper.findByProvinceId(provinceVO.getId());
               cityVOS.stream().forEach(i -> {
                  i.setLocationId(provinceVO.getLocationId());
                  i.setLocationName(locationMap.get(provinceVO.getLocationId()));
               });

               for (AddressResponseVO cityVO : cityVOS) {
                  List<AddressResponseVO> regionVOS = this.regionMapper.listByCityId(cityVO.getId());
                  regionVOS.forEach(i -> {
                     i.setLocationId(provinceVO.getLocationId());
                     i.setLocationName(locationMap.get(provinceVO.getLocationId()));
                  });
                  cityVO.setChildren(regionVOS);
               }

               provinceVO.setChildren(cityVOS);
            }

            responseVO.setChildren(addressResponseVOS);
         }
      }

      this.redisUtils.set(worldAddress, responses);
      return responses;
   }

   @Override
   public Map<Long, SysCountry> listMapByIds(List<Long> countryIds) {
      return CollectionUtils.isEmpty(countryIds)
         ? new HashMap<>()
         : this.countryMapper.selectBatchIds(countryIds).stream().collect(Collectors.toMap(SysCountry::getId, item -> (SysCountry)item));
   }

   public SysCountryServiceImpl(
      final SysCountryMapper countryMapper,
      final SysProvinceMapper provinceMapper,
      final SysCityMapper cityMapper,
      final SysRegionMapper regionMapper,
      final RedisUtils redisUtils,
      final SysProvinceService sysProvinceService,
      final SysCityService sysCityService,
      final SysRegionService sysRegionService,
      final SysProvinceNewMapper provinceNewMapper,
      final SysLocationMapper locationMapper
   ) {
      this.countryMapper = countryMapper;
      this.provinceMapper = provinceMapper;
      this.cityMapper = cityMapper;
      this.regionMapper = regionMapper;
      this.redisUtils = redisUtils;
      this.sysProvinceService = sysProvinceService;
      this.sysCityService = sysCityService;
      this.sysRegionService = sysRegionService;
      this.provinceNewMapper = provinceNewMapper;
      this.locationMapper = locationMapper;
   }
}
