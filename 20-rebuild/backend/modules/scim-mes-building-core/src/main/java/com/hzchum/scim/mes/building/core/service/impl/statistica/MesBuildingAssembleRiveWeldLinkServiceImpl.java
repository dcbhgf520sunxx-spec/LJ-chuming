package com.hzchum.scim.mes.building.core.service.impl.statistica;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.NumberUtil;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.statistica.MesBuildingAssembleLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingAssembleProcessPrice;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingAssembleRiveWeldLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingAssembleLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingStructureProcessPriceDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingAssembleProcessPriceService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingAssembleRiveWeldLinkService;
import com.hzchum.scim.mes.building.core.mapper.statistica.MesBuildingAssembleRiveWeldLinkMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingAssembleRiveWeldLinkServiceImpl
   extends ServiceImpl<MesBuildingAssembleRiveWeldLinkMapper, MesBuildingAssembleRiveWeldLink>
   implements MesBuildingAssembleRiveWeldLinkService {
   @Resource
   private SysAssembleConfigService sysAssembleConfigService;
   @Resource
   private MesBuildingProductProcessLinkService mesBuildingProductProcessLinkService;
   @Resource
   private MesBuildingProcessService processService;
   @Resource
   private MesBuildingAssembleProcessPriceService mesBuildingAssembleProcessPriceService;

   @Override
   public ListVO getAssembleRivetWeldConfig() {
      List<MesBuildingAssembleLinkDO> assembleRivetWeldConfig = this.baseMapper.getAssembleRivetWeldConfig();
      List<MesBuildingAssembleLinkDTO> classificationTypeLinkDTOS = new ArrayList<>();
      assembleRivetWeldConfig.forEach(
         config -> {
            MesBuildingAssembleLinkDTO copy = BeanUtil.copy(config, MesBuildingAssembleLinkDTO.class);
            List<MesBuildingStructureProcessPriceDTO> collect = config.getAssembleProcessPriceList()
               .stream()
               .map(e -> BeanUtil.copy(e, MesBuildingStructureProcessPriceDTO.class))
               .collect(Collectors.toList());
            copy.setStructureProcessPriceList(collect);
            classificationTypeLinkDTOS.add(copy);
         }
      );
      return new ListVO<>(classificationTypeLinkDTOS);
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean saveAssembleRivetWeldConfig(List<MesBuildingAssembleLinkDTO> dtoList) {
      dtoList.forEach(
         dto -> {
            SysAssembleConfig sysAssembleConfig = this.sysAssembleConfigService.getById(dto.getSysAssembleId());
            Preconditions.checkArgument(sysAssembleConfig != null, "部件类型不存在");
            Preconditions.checkArgument(dto.getMaxNumerical().compareTo(dto.getMinNumerical()) >= 0, "最小数值不能大于最大数值");
            List<MesBuildingAssembleRiveWeldLink> assembleRiveWeldLinks = this.baseMapper
               .selectList(
                  (Wrapper<MesBuildingAssembleRiveWeldLink>)new LambdaQueryWrapper<MesBuildingAssembleRiveWeldLink>()
                     .eq(MesBuildingAssembleRiveWeldLink::getSysAssembleId, dto.getSysAssembleId())
               );
            if (CollectionUtils.isNotEmpty(assembleRiveWeldLinks)) {
               assembleRiveWeldLinks.forEach(
                  riveWeldLink -> Preconditions.checkArgument(
                     NumberUtil.rangeInDefined(dto.getMinNumerical(), dto.getMaxNumerical(), riveWeldLink.getMinNumerical(), riveWeldLink.getMaxNumerical()),
                     "数值范围已存在!!!"
                  )
               );
            }

            MesBuildingAssembleRiveWeldLink copy = BeanUtil.copy(dto, MesBuildingAssembleRiveWeldLink.class);
            this.baseMapper.insert(copy);
            if (CollectionUtils.isNotEmpty(dto.getStructureProcessPriceList())) {
               dto.getStructureProcessPriceList().forEach(process -> {
                  MesBuildingProductProcessLink productProcessLink = this.mesBuildingProductProcessLinkService.getById(process.getProcessLinkId());
                  Preconditions.checkArgument(productProcessLink != null, "工序关联数据不存在!!!");
                  MesBuildingProcess buildingProcess = this.processService.getById(productProcessLink.getProcessId());
                  Preconditions.checkArgument(buildingProcess != null, "工序不存在!!!");
                  Preconditions.checkArgument(productProcessLink.getProcessId().equals(process.getProcessId()), "工序错误!!!");
                  Preconditions.checkArgument(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType().equals(buildingProcess.getType()), "工序非组铆焊类");
                  MesBuildingAssembleProcessPrice processPrice = BeanUtil.copy(process, MesBuildingAssembleProcessPrice.class);
                  processPrice.setAssembleLinkId(copy.getId());
                  this.mesBuildingAssembleProcessPriceService.save(processPrice);
               });
            }
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public Boolean updateAssembleRivetWeldConfig(MesBuildingAssembleLinkDTO dto) {
      MesBuildingAssembleRiveWeldLink assembleRiveWeldLink = this.baseMapper.selectById(dto.getId());
      Preconditions.checkArgument(assembleRiveWeldLink != null, "修改失败，记录不存在");
      if (!dto.getMinNumerical().equals(assembleRiveWeldLink.getMinNumerical()) || !dto.getMaxNumerical().equals(assembleRiveWeldLink.getMaxNumerical())) {
         Preconditions.checkArgument(dto.getMaxNumerical().compareTo(dto.getMinNumerical()) >= 0, "最小数值不能大于最大数值");
         List<MesBuildingAssembleRiveWeldLink> assembleRiveWeldLinks = this.baseMapper
            .selectList(
               (Wrapper<MesBuildingAssembleRiveWeldLink>)(new LambdaQueryWrapper<MesBuildingAssembleRiveWeldLink>()
                     .eq(MesBuildingAssembleRiveWeldLink::getSysAssembleId, assembleRiveWeldLink.getSysAssembleId()))
                  .ne(MesBuildingAssembleRiveWeldLink::getId, assembleRiveWeldLink.getId())
            );
         if (CollectionUtils.isNotEmpty(assembleRiveWeldLinks)) {
            assembleRiveWeldLinks.forEach(
               typeLink -> Preconditions.checkArgument(
                  NumberUtil.rangeInDefined(dto.getMinNumerical(), dto.getMaxNumerical(), typeLink.getMinNumerical(), typeLink.getMaxNumerical()), "数值范围已存在!!!"
               )
            );
         }

         assembleRiveWeldLink.setMinNumerical(dto.getMinNumerical());
         assembleRiveWeldLink.setMaxNumerical(dto.getMaxNumerical());
      }

      this.baseMapper.updateById(assembleRiveWeldLink);
      if (CollectionUtils.isNotEmpty(dto.getStructureProcessPriceList())) {
         List<MesBuildingStructureProcessPriceDTO> structureProcessPriceList = dto.getStructureProcessPriceList();
         Map<Long, MesBuildingAssembleProcessPrice> processPriceMap = this.mesBuildingAssembleProcessPriceService
            .list((Wrapper<MesBuildingAssembleProcessPrice>)new LambdaQueryWrapper<MesBuildingAssembleProcessPrice>().eq(MesBuildingAssembleProcessPrice::getAssembleLinkId, dto.getId()))
            .stream()
            .collect(Collectors.toMap(MesBuildingAssembleProcessPrice::getProcessId, e -> (MesBuildingAssembleProcessPrice)e));
         structureProcessPriceList.forEach(
            price -> {
               Preconditions.checkArgument(price.getProcessLinkId() != null, "工序关联id不能为空!!!");
               MesBuildingAssembleProcessPrice assembleProcessPrice = processPriceMap.get(price.getProcessId());
               if (assembleProcessPrice != null
                  && price.getWageQuotaType() != null
                  && price.getPrice() != null
                  && (
                     !price.getWageQuotaType().equals(assembleProcessPrice.getWageQuotaType())
                        || price.getPrice().compareTo(assembleProcessPrice.getPrice()) != 0
                  )) {
                  assembleProcessPrice.setPrice(price.getPrice());
                  assembleProcessPrice.setWageQuotaType(price.getWageQuotaType());
                  this.mesBuildingAssembleProcessPriceService.updateById(assembleProcessPrice);
               }

               if (assembleProcessPrice != null && price.getWageQuotaType() == null && price.getPrice() == null) {
                  assembleProcessPrice.setPrice(BigDecimal.ZERO);
                  assembleProcessPrice.setWageQuotaType(WageQuotaTypeEnum.WEIGHT_PRICE.getType());
                  this.mesBuildingAssembleProcessPriceService.updateById(assembleProcessPrice);
               }

               if (assembleProcessPrice == null && price.getWageQuotaType() != null && price.getPrice() != null) {
                  MesBuildingProductProcessLink productProcessLink = this.mesBuildingProductProcessLinkService.getById(price.getProcessLinkId());
                  Preconditions.checkArgument(productProcessLink != null, "工序关联数据不存在!!!");
                  MesBuildingProcess buildingProcess = this.processService.getById(productProcessLink.getProcessId());
                  Preconditions.checkArgument(buildingProcess != null, "工序不存在!!!");
                  Preconditions.checkArgument(productProcessLink.getProcessId().equals(price.getProcessId()), "工序错误!!!");
                  Preconditions.checkArgument(
                     ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType() == buildingProcess.getType(), buildingProcess.getName() + "工序非组铆焊类"
                  );
                  assembleProcessPrice = MesBuildingAssembleProcessPrice.builder()
                     .price(price.getPrice())
                     .processId(price.getProcessId())
                     .wageQuotaType(price.getWageQuotaType())
                     .assembleLinkId(dto.getId())
                     .build();
                  this.mesBuildingAssembleProcessPriceService.save(assembleProcessPrice);
               }
            }
         );
      }

      return Boolean.TRUE;
   }

   @Override
   public Boolean removeAssembleRivetWeldConfig(Set<Long> ids) {
      ids.forEach(
         id -> {
            MesBuildingAssembleRiveWeldLink assembleRiveWeldLink = this.baseMapper.selectById(id);
            Preconditions.checkArgument(assembleRiveWeldLink != null, "删除失败，记录不存在!!!");
            List<MesBuildingAssembleProcessPrice> processPriceList = this.mesBuildingAssembleProcessPriceService
               .list(
                  (Wrapper<MesBuildingAssembleProcessPrice>)new LambdaQueryWrapper<MesBuildingAssembleProcessPrice>()
                     .eq(MesBuildingAssembleProcessPrice::getAssembleLinkId, assembleRiveWeldLink.getId())
               );
            if (CollectionUtils.isNotEmpty(processPriceList)) {
               this.mesBuildingAssembleProcessPriceService
                  .removeByIds(processPriceList.stream().map(MesBuildingAssembleProcessPrice::getId).collect(Collectors.toList()));
            }

            this.baseMapper.deleteById(id);
         }
      );
      return Boolean.TRUE;
   }
}
