package com.hzchum.scim.cut.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.cut.core.api.enums.DetailEnum;
import com.hzchum.scim.cut.core.api.pojo._do.CutMachine;
import com.hzchum.scim.cut.core.api.pojo._do.CutPlate;
import com.hzchum.scim.cut.core.api.request.CutMachineDTO;
import com.hzchum.scim.cut.core.api.service.CutMachineService;
import com.hzchum.scim.cut.core.api.service.CutPlateService;
import com.hzchum.scim.cut.core.mapper.CutMachineMapper;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CutMachineServiceImpl extends ServiceImpl<CutMachineMapper, CutMachine> implements CutMachineService {
   @Resource
   private CutMachineService machineService;
   @Resource
   private CutPlateService plateService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO getMachine(
      Integer pageNumber,
      Integer pageSize,
      String machineNumber,
      String machineName,
      Integer state,
      String machineType,
      Long factoryId,
      Long workshopInfId,
      List<String> sort,
      String online
   ) {
      if (pageNumber == null) {
         pageNumber = 1;
      }

      if (pageSize == null) {
         pageSize = 50;
      }

      String s = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, s);
      List<CutMachine> list = this.machineService
         .list(
            ((((((new LambdaQueryWrapper<CutMachine>()
                                 .like(StrUtil.isNotBlank(machineName), CutMachine::getMachineName, machineName))
                              .eq(state != null, CutMachine::getState, state))
                           .eq(StrUtil.isNotBlank(machineType), CutMachine::getMachineType, machineType))
                        .like(StrUtil.isNotBlank(machineNumber), CutMachine::getMachineNumber, machineNumber))
                     .eq(StrUtil.isNotBlank(online), CutMachine::getOnline, online))
                  .eq(factoryId != null, CutMachine::getFactoryId, factoryId))
               .eq(workshopInfId != null, CutMachine::getWorkshopInfId, workshopInfId)
         );
      list.forEach(
         cutMachine -> {
            CutMachineDTO build = CutMachineDTO.builder().build();
            BeanUtil.copyProperties(cutMachine, build);
            List<CutPlate> list1 = this.plateService
               .list(
                  (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getMac, cutMachine.getMac()))
                     .eq(CutPlate::getPlateState, DetailEnum.ASSIGNED.getCode())
               );
            List<CutPlate> list2 = this.plateService
               .list(
                  (Wrapper<CutPlate>)(new LambdaQueryWrapper<CutPlate>().eq(CutPlate::getMac, cutMachine.getMac()))
                     .eq(CutPlate::getPlateState, DetailEnum.ISSUED.getCode())
               );
            if (CollUtil.isNotEmpty(list1)) {
               BigDecimal reduce = list1.stream().map(CutPlate::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
               build.setAssignWeight(reduce);
               build.setAssignNum(list1.size());
            }

            if (CollUtil.isNotEmpty(list2)) {
               BigDecimal reduce = list2.stream().map(CutPlate::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
               build.setSentWeight(reduce);
               build.setSentNum(list2.size());
            }
         }
      );
      return ResultBuilder.success(new PageVO<>(list));
   }
}
