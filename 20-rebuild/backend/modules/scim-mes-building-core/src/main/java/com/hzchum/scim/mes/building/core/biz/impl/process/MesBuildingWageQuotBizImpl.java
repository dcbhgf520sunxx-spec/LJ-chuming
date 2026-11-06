package com.hzchum.scim.mes.building.core.biz.impl.process;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.biz.process.MesBuildingWageQuotaBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingWageQuota;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingMachinePartProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingWageQuotaDTOParam;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingWageQuotaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingWageQuotBizImpl implements MesBuildingWageQuotaBiz {
   @Autowired
   private MesBuildingProductProcessService productProcessService;
   @Autowired
   private MesBuildingWageQuotaService wageQuotaService;
   @Autowired
   private MesBuildingProcessService processService;

   @Override
   public Boolean saveWageQuot(MesBuildingWageQuotaDTOParam dtoParam) {
      if (dtoParam.getProductProcessId() != 0L) {
         MesBuildingProductProcess productProcess = this.productProcessService.getById(dtoParam.getProductProcessId());
         Preconditions.checkArgument(productProcess != null, "修改失败，未查询到相对应总工序");
      }

      MesBuildingWageQuota wageQuota = MesBuildingWageQuota.builder().build();
      BeanUtils.copyProperties(dtoParam, wageQuota);
      LambdaQueryWrapper<MesBuildingWageQuota> wrapper = (LambdaQueryWrapper<MesBuildingWageQuota>)(new LambdaQueryWrapper<MesBuildingWageQuota>()
            .eq(MesBuildingWageQuota::getProductProcessId, dtoParam.getProductProcessId()))
         .eq(MesBuildingWageQuota::getProcessId, dtoParam.getProcessId());
      if (this.wageQuotaService.getOne(wrapper) == null) {
         this.wageQuotaService.save(wageQuota);
      } else {
         Long id = this.wageQuotaService.getOne(wrapper).getId();
         wageQuota.setId(id);
         this.wageQuotaService.updateById(wageQuota);
      }

      return true;
   }

   @Override
   public List<MesBuildingMachinePartProcessDTO> machinePartProcessWage(String name) {
      List<MesBuildingMachinePartProcessDTO> dtoList = this.processService
         .list(
            (Wrappers.<MesBuildingProcess>lambdaQuery().eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType()))
               .like(name != null, MesBuildingProcess::getName, name)
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingMachinePartProcessDTO.class))
         .collect(Collectors.toList());
      dtoList.forEach(
         e -> {
            MesBuildingWageQuota wageQuota = this.wageQuotaService
               .getOne(
                  (Wrapper<MesBuildingWageQuota>)(Wrappers.<MesBuildingWageQuota>lambdaQuery().eq(MesBuildingWageQuota::getProcessId, e.getId()))
                     .eq(MesBuildingWageQuota::getProductProcessId, 0)
               );
            if (wageQuota != null) {
               e.setPrice(wageQuota.getPrice());
            }
         }
      );
      return dtoList;
   }

   @Override
   public PageVO<MesBuildingMachinePartProcessDTO> machinePartProcessWagePage(String name, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(page, this.machinePartProcessWage(name));
   }
}
