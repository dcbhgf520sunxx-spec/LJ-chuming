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
import com.hzchum.scim.mes.building.core.api.pojo._do.statistica.MesBuildingStructureClassificationTypeLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingArtifactTypeConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingStructureClassificationTypeLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingStructureProcessPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingStructureClassificationTypeLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingStructureProcessPriceDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingArtifactTypeConfigService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingStructureClassificationTypeLinkService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingStructureProcessPriceService;
import com.hzchum.scim.mes.building.core.mapper.statistica.MesBuildingStructureClassificationTypeLinkMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
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
public class MesBuildingStructureClassificationTypeLinkServiceImpl
   extends ServiceImpl<MesBuildingStructureClassificationTypeLinkMapper, MesBuildingStructureClassificationTypeLink>
   implements MesBuildingStructureClassificationTypeLinkService {
   @Resource
   private MesBuildingArtifactTypeConfigService mesBuildingArtifactTypeConfigService;
   @Resource
   private SysStructureClassificationService sysStructureClassificationService;
   @Resource
   private MesBuildingProductProcessLinkService mesBuildingProductProcessLinkService;
   @Resource
   private MesBuildingStructureProcessPriceService mesBuildingStructureProcessPriceService;
   @Resource
   private MesBuildingProcessService processService;

   @Override
   public ListVO getArtifactRivetWeldConfig(Long id) {
      MesBuildingArtifactTypeConfig artifactTypeConfig = this.mesBuildingArtifactTypeConfigService.getById(id);
      Preconditions.checkArgument(artifactTypeConfig != null, "构件种类不存在");
      List<MesBuildingStructureClassificationTypeLinkDO> rivetWeldConfigs = this.baseMapper.getArtifactRivetWeldConfig(id);
      List<MesBuildingStructureClassificationTypeLinkDTO> classificationTypeLinkDTOS = new ArrayList<>();
      rivetWeldConfigs.forEach(
         config -> {
            MesBuildingStructureClassificationTypeLinkDTO copy = BeanUtil.copy(config, MesBuildingStructureClassificationTypeLinkDTO.class);
            List<MesBuildingStructureProcessPriceDTO> collect = config.getStructureProcessPriceList()
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
   public Boolean saveRivetWeldConfig(List<MesBuildingStructureClassificationTypeLinkDTO> linkDTOS) {
      linkDTOS.forEach(
         linkDTO -> {
            MesBuildingArtifactTypeConfig artifactTypeConfig = this.mesBuildingArtifactTypeConfigService.getById(linkDTO.getArtifactTypeId());
            Preconditions.checkArgument(artifactTypeConfig != null, "构件种类不存在");
            Preconditions.checkArgument(linkDTO.getMaxNumerical().compareTo(linkDTO.getMinNumerical()) >= 0, "最小数值不能大于最大数值");
            List<MesBuildingStructureClassificationTypeLink> mesBuildingStructureClassificationTypeLinks = this.baseMapper
               .selectList(
                  (Wrapper<MesBuildingStructureClassificationTypeLink>)(new LambdaQueryWrapper<MesBuildingStructureClassificationTypeLink>()
                        .eq(MesBuildingStructureClassificationTypeLink::getArtifactTypeId, linkDTO.getArtifactTypeId()))
                     .eq(MesBuildingStructureClassificationTypeLink::getStructureClassificationId, linkDTO.getClassificationId())
               );
            if (CollectionUtils.isNotEmpty(mesBuildingStructureClassificationTypeLinks)) {
               mesBuildingStructureClassificationTypeLinks.forEach(
                  typeLink -> Preconditions.checkArgument(
                     NumberUtil.rangeInDefined(linkDTO.getMinNumerical(), linkDTO.getMaxNumerical(), typeLink.getMinNumerical(), typeLink.getMaxNumerical()),
                     "数值范围已存在!!!"
                  )
               );
            }

            SysStructureClassification classification = this.sysStructureClassificationService.getById(linkDTO.getClassificationId());
            Preconditions.checkArgument(classification != null, "构件类型不存在");
            MesBuildingStructureClassificationTypeLink classificationTypeLink = MesBuildingStructureClassificationTypeLink.builder()
               .artifactTypeId(linkDTO.getArtifactTypeId())
               .structureClassificationId(linkDTO.getClassificationId())
               .minNumerical(linkDTO.getMinNumerical())
               .maxNumerical(linkDTO.getMaxNumerical())
               .build();
            this.baseMapper.insert(classificationTypeLink);
            List<MesBuildingStructureProcessPriceDTO> structureProcessPriceList = linkDTO.getStructureProcessPriceList();
            if (CollectionUtils.isNotEmpty(structureProcessPriceList)) {
               structureProcessPriceList.forEach(
                  process -> {
                     MesBuildingProductProcessLink productProcessLink = this.mesBuildingProductProcessLinkService.getById(process.getProcessLinkId());
                     Preconditions.checkArgument(productProcessLink != null, "工序关联数据不存在!!!");
                     MesBuildingProcess buildingProcess = this.processService.getById(productProcessLink.getProcessId());
                     Preconditions.checkArgument(buildingProcess != null, "工序不存在!!!");
                     Preconditions.checkArgument(productProcessLink.getProcessId().equals(process.getProcessId()), "工序错误!!!");
                     Preconditions.checkArgument(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType().equals(buildingProcess.getType()), "工序非组铆焊类");
                     MesBuildingStructureProcessPrice processPrice = MesBuildingStructureProcessPrice.builder()
                        .price(process.getPrice())
                        .processId(process.getProcessId())
                        .wageQuotaType(process.getWageQuotaType())
                        .structureTypeLinkId(classificationTypeLink.getId())
                        .build();
                     this.mesBuildingStructureProcessPriceService.save(processPrice);
                  }
               );
            }
         }
      );
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateRivetWeldConfig(MesBuildingStructureClassificationTypeLinkDTO linkDTO) {
      MesBuildingStructureClassificationTypeLink classificationTypeLink = this.baseMapper.selectById(linkDTO.getId());
      Preconditions.checkArgument(classificationTypeLink != null, "修改失败，记录不存在!!!");
      if (!linkDTO.getMinNumerical().equals(classificationTypeLink.getMinNumerical())
         || !linkDTO.getMaxNumerical().equals(classificationTypeLink.getMaxNumerical())) {
         Preconditions.checkArgument(linkDTO.getMaxNumerical().compareTo(linkDTO.getMinNumerical()) >= 0, "最小数值不能大于最大数值");
         List<MesBuildingStructureClassificationTypeLink> mesBuildingStructureClassificationTypeLinks = this.baseMapper
            .selectList(
               (Wrapper<MesBuildingStructureClassificationTypeLink>)((new LambdaQueryWrapper<MesBuildingStructureClassificationTypeLink>()
                        .eq(MesBuildingStructureClassificationTypeLink::getArtifactTypeId, classificationTypeLink.getArtifactTypeId()))
                     .eq(MesBuildingStructureClassificationTypeLink::getStructureClassificationId, classificationTypeLink.getStructureClassificationId()))
                  .ne(MesBuildingStructureClassificationTypeLink::getId, classificationTypeLink.getId())
            );
         if (CollectionUtils.isNotEmpty(mesBuildingStructureClassificationTypeLinks)) {
            mesBuildingStructureClassificationTypeLinks.forEach(
               typeLink -> Preconditions.checkArgument(
                  NumberUtil.rangeInDefined(linkDTO.getMinNumerical(), linkDTO.getMaxNumerical(), typeLink.getMinNumerical(), typeLink.getMaxNumerical()),
                  "数值范围已存在!!!"
               )
            );
         }

         classificationTypeLink.setMinNumerical(linkDTO.getMinNumerical());
         classificationTypeLink.setMaxNumerical(linkDTO.getMaxNumerical());
      }

      this.baseMapper.updateById(classificationTypeLink);
      if (CollectionUtils.isNotEmpty(linkDTO.getStructureProcessPriceList())) {
         List<MesBuildingStructureProcessPriceDTO> structureProcessPriceList = linkDTO.getStructureProcessPriceList();
         Map<Long, MesBuildingStructureProcessPrice> processPriceMap = this.mesBuildingStructureProcessPriceService
            .list(
               (Wrapper<MesBuildingStructureProcessPrice>)new LambdaQueryWrapper<MesBuildingStructureProcessPrice>()
                  .eq(MesBuildingStructureProcessPrice::getStructureTypeLinkId, linkDTO.getId())
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingStructureProcessPrice::getProcessId, e -> (MesBuildingStructureProcessPrice)e));
         structureProcessPriceList.forEach(
            price -> {
               Preconditions.checkArgument(price.getProcessLinkId() != null, "工序关联id不能为空!!!");
               MesBuildingStructureProcessPrice processPrice = processPriceMap.get(price.getProcessId());
               if (processPrice != null
                  && price.getWageQuotaType() != null
                  && price.getPrice() != null
                  && (price.getPrice().compareTo(processPrice.getPrice()) != 0 || !price.getWageQuotaType().equals(processPrice.getWageQuotaType()))) {
                  processPrice.setPrice(price.getPrice());
                  processPrice.setWageQuotaType(price.getWageQuotaType());
                  this.mesBuildingStructureProcessPriceService.updateById(processPrice);
               }

               if (processPrice != null && price.getWageQuotaType() == null && price.getPrice() == null) {
                  processPrice.setPrice(BigDecimal.ZERO);
                  processPrice.setWageQuotaType(WageQuotaTypeEnum.WEIGHT_PRICE.getType());
                  this.mesBuildingStructureProcessPriceService.updateById(processPrice);
               }

               if (processPrice == null && price.getWageQuotaType() != null && price.getPrice() != null) {
                  MesBuildingProductProcessLink productProcessLink = this.mesBuildingProductProcessLinkService.getById(price.getProcessLinkId());
                  Preconditions.checkArgument(productProcessLink != null, "工序关联数据不存在!!!");
                  MesBuildingProcess buildingProcess = this.processService.getById(productProcessLink.getProcessId());
                  Preconditions.checkArgument(buildingProcess != null, "工序不存在!!!");
                  Preconditions.checkArgument(productProcessLink.getProcessId().equals(price.getProcessId()), "工序错误!!!");
                  Preconditions.checkArgument(
                     ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType() == buildingProcess.getType(), buildingProcess.getName() + "工序非组铆焊类"
                  );
                  processPrice = MesBuildingStructureProcessPrice.builder()
                     .price(price.getPrice())
                     .processId(price.getProcessId())
                     .wageQuotaType(price.getWageQuotaType())
                     .structureTypeLinkId(linkDTO.getId())
                     .build();
                  this.mesBuildingStructureProcessPriceService.save(processPrice);
               }
            }
         );
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean removeRivetWeldConfig(Set<Long> ids) {
      ids.forEach(
         id -> {
            MesBuildingStructureClassificationTypeLink classificationTypeLink = this.baseMapper.selectById(id);
            Preconditions.checkArgument(classificationTypeLink != null, "删除失败，记录不存在!!!");
            List<MesBuildingStructureProcessPrice> processPriceList = this.mesBuildingStructureProcessPriceService
               .list(
                  (Wrapper<MesBuildingStructureProcessPrice>)new LambdaQueryWrapper<MesBuildingStructureProcessPrice>()
                     .eq(MesBuildingStructureProcessPrice::getStructureTypeLinkId, classificationTypeLink.getId())
               );
            if (CollectionUtils.isNotEmpty(processPriceList)) {
               this.mesBuildingStructureProcessPriceService
                  .removeByIds(processPriceList.stream().map(MesBuildingStructureProcessPrice::getId).collect(Collectors.toList()));
            }

            this.baseMapper.deleteById(id);
         }
      );
      return Boolean.TRUE;
   }
}
