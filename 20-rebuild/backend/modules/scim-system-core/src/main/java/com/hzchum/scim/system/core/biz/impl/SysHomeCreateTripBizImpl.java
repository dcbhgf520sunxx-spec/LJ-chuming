package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.SysHomeCreateTripBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysHomeCreateTrip;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.SysHomeCreateTripPageDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysHomeCreateTripSaveParam;
import com.hzchum.scim.system.core.api.service.SysHomeCreateTripService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.mapper.SysHomeCreateTripMapper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysHomeCreateTripBizImpl extends IBizImpl<SysHomeCreateTripService, SysHomeCreateTripMapper, SysHomeCreateTrip> implements SysHomeCreateTripBiz {
   @Resource
   private UserService userService;

   @Transactional
   @Override
   public Boolean saveSysHomeCreateTrip(SysHomeCreateTripSaveParam param) {
      SysHomeCreateTrip sysHomeCreateTrip = BeanUtil.copy(param, SysHomeCreateTrip.class);
      sysHomeCreateTrip.setCreateUserId(UserUtil.getCurrentUserId());
      sysHomeCreateTrip.setCreateUserName(UserUtil.getCurrentName());
      this.baseService.save(sysHomeCreateTrip);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean deleteSysHomeCreateTrip(Long id) {
      SysHomeCreateTrip sysHomeCreateTrip = this.baseService.getById(id);
      Preconditions.checkArgument(id != null, "行程不存在");
      this.baseService.removeById(id);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public List<SysHomeCreateTripPageDTO> getSysHomeCreateTripPage(String createUserName, String title, LocalDate startTime) {
      List<SysHomeCreateTrip> sysHomeCreateTrips = this.baseService
         .list(
            Wrappers.lambdaQuery(SysHomeCreateTrip.class)
               .apply(startTime != null, "date_format(set_time, '%Y-%m') = {0}", startTime.format(DateTimeFormatter.ofPattern("yyyy-MM")))
               .eq(SysHomeCreateTrip::getCreateUserId, UserUtil.getCurrentUserId())
               .eq(title != null, SysHomeCreateTrip::getTitle, title)
               .eq(createUserName != null, SysHomeCreateTrip::getCreateUserName, createUserName)
               .orderByAsc(SysHomeCreateTrip::getSetTime)
         );
      List<SysHomeCreateTripPageDTO> sysHomeCreateTripPageDTOS = new ArrayList<>();
      Map<Object, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      sysHomeCreateTrips.forEach(item -> {
         SysHomeCreateTripPageDTO sysHomeCreateTripPageDTO = BeanUtil.copy(item, SysHomeCreateTripPageDTO.class);
         if (item.getCreateUserId() != null) {
            sysHomeCreateTripPageDTO.setCreateUserName(userMap.get(item.getCreateUserId()) != null ? userMap.get(item.getCreateUserId()).getName() : null);
         }

         if (item.getTitle() != null) {
            sysHomeCreateTripPageDTO.setDay((long)item.getSetTime().getDayOfMonth());
         }

         sysHomeCreateTripPageDTOS.add(sysHomeCreateTripPageDTO);
      });
      return sysHomeCreateTripPageDTOS;
   }
}
