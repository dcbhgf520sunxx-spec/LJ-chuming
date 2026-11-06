package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsSectionSteelControlTable;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelControlTableDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SectionSteelControlTableDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WmsSectionSteelControlTableService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WmsSectionSteelControlTableMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsSectionSteelControlTableServiceImpl
   extends ServiceImpl<WmsSectionSteelControlTableMapper, WmsSectionSteelControlTable>
   implements WmsSectionSteelControlTableService {
   @Resource
   ClassificationService classificationService;
   @Resource
   ContractProjectService projectService;
   @Resource
   TechMachinePartService partService;
   @Value("${chum.config.url}")
   private String ip;
   @Value("${chum.config.filePath}")
   private String files;

   @Override
   public List<SectionSteelControlTableDTO> SectionSteelControlList(Integer mesProductEnum) {
      List<WmsSectionSteelControlTable> sectionSteelControlTableList = this.list(
         (Wrapper<WmsSectionSteelControlTable>)new LambdaQueryWrapper<WmsSectionSteelControlTable>().eq(WmsSectionSteelControlTable::getMesProductEnum, mesProductEnum)
      );
      if (CollectionUtil.isEmpty(sectionSteelControlTableList) || sectionSteelControlTableList.get(0).getBasicClass() == null) {
         List<WmsSectionSteelControlTable> wmsSectionSteelControlTables = new ArrayList<>();
         WmsSectionSteelControlTable wmsSectionSteelControlTable = WmsSectionSteelControlTable.builder()
            .mesProductEnum(mesProductEnum)
            .basicClass(2)
            .name("H型钢")
            .image("https://static-assets.hzchum.com/plm7/img/MemberSectionImg/H-beam.jpg")
            .errorBigH(new BigDecimal(0))
            .errorB(new BigDecimal(0))
            .errorT(new BigDecimal(0))
            .errorBigS(new BigDecimal(0))
            .errorType("H,b,t,S")
            .build();
         wmsSectionSteelControlTables.add(wmsSectionSteelControlTable);
         WmsSectionSteelControlTable wmsSectionSteelControlTable1 = WmsSectionSteelControlTable.builder()
            .mesProductEnum(mesProductEnum)
            .basicClass(2)
            .name("槽钢")
            .image("https://static-assets.hzchum.com/plm7/img/MemberSectionImg/channel.jpg")
            .errorH(new BigDecimal(0))
            .errorType("h")
            .build();
         wmsSectionSteelControlTables.add(wmsSectionSteelControlTable1);
         WmsSectionSteelControlTable wmsSectionSteelControlTable2 = WmsSectionSteelControlTable.builder()
            .mesProductEnum(mesProductEnum)
            .basicClass(2)
            .name("圆钢")
            .image("https://static-assets.hzchum.com/plm7/img/MemberSectionImg/round.jpg")
            .errorBigD(new BigDecimal(0))
            .errorType("D")
            .build();
         wmsSectionSteelControlTables.add(wmsSectionSteelControlTable2);
         WmsSectionSteelControlTable wmsSectionSteelControlTable3 = WmsSectionSteelControlTable.builder()
            .mesProductEnum(mesProductEnum)
            .basicClass(2)
            .name("圆管钢")
            .image("https://static-assets.hzchum.com/plm7/img/MemberSectionImg/round-tubes.jpg")
            .errorBigD(new BigDecimal(0))
            .errorBigS(new BigDecimal(0))
            .errorType("D,S")
            .build();
         wmsSectionSteelControlTables.add(wmsSectionSteelControlTable3);
         WmsSectionSteelControlTable wmsSectionSteelControlTable4 = WmsSectionSteelControlTable.builder()
            .mesProductEnum(mesProductEnum)
            .basicClass(2)
            .name("等边角钢")
            .image("https://static-assets.hzchum.com/plm7/img/MemberSectionImg/equilateral-angles.jpg")
            .errorB(new BigDecimal(0))
            .errorD(new BigDecimal(0))
            .errorType("b,d")
            .build();
         wmsSectionSteelControlTables.add(wmsSectionSteelControlTable4);
         WmsSectionSteelControlTable wmsSectionSteelControlTable5 = WmsSectionSteelControlTable.builder()
            .mesProductEnum(mesProductEnum)
            .basicClass(2)
            .name("不等边角钢")
            .image("https://static-assets.hzchum.com/plm7/img/MemberSectionImg/unequal-angles.jpg")
            .errorBigB(new BigDecimal(0))
            .errorB(new BigDecimal(0))
            .errorD(new BigDecimal(0))
            .errorType("B,b,d")
            .build();
         wmsSectionSteelControlTables.add(wmsSectionSteelControlTable5);
         WmsSectionSteelControlTable wmsSectionSteelControlTable6 = WmsSectionSteelControlTable.builder()
            .mesProductEnum(mesProductEnum)
            .basicClass(2)
            .name("矩形管")
            .image("https://static-assets.hzchum.com/plm7/img/MemberSectionImg/rectangular-tubes.jpg")
            .errorA(new BigDecimal(0))
            .errorB(new BigDecimal(0))
            .errorBigS(new BigDecimal(0))
            .errorType("a,b,S")
            .build();
         wmsSectionSteelControlTables.add(wmsSectionSteelControlTable6);
         WmsSectionSteelControlTable wmsSectionSteelControlTable7 = WmsSectionSteelControlTable.builder()
            .mesProductEnum(mesProductEnum)
            .basicClass(2)
            .name("T型钢")
            .image("https://static-assets.hzchum.com/plm7/img/MemberSectionImg/T-beam.jpg")
            .errorBigT(new BigDecimal(0))
            .errorB(new BigDecimal(0))
            .errorS(new BigDecimal(0))
            .errorType("T,b,S")
            .build();
         wmsSectionSteelControlTables.add(wmsSectionSteelControlTable7);
         WmsSectionSteelControlTable wmsSectionSteelControlTable8 = WmsSectionSteelControlTable.builder()
            .mesProductEnum(mesProductEnum)
            .basicClass(1)
            .name("钢板")
            .image("https://static-assets.hzchum.com/plm7/img/MemberSectionImg/steel-plate.jpg")
            .errorD(new BigDecimal(0))
            .errorType("d")
            .build();
         wmsSectionSteelControlTables.add(wmsSectionSteelControlTable8);
         WmsSectionSteelControlTable wmsSectionSteelControlTable9 = WmsSectionSteelControlTable.builder()
            .mesProductEnum(mesProductEnum)
            .basicClass(2)
            .name("方管")
            .image("https://static-assets.hzchum.com/plm7/img/MemberSectionImg/square-tube.jpg")
            .errorA(new BigDecimal(0))
            .errorBigS(new BigDecimal(0))
            .errorType("a,S")
            .build();
         wmsSectionSteelControlTables.add(wmsSectionSteelControlTable9);
         WmsSectionSteelControlTable wmsSectionSteelControlTable10 = WmsSectionSteelControlTable.builder()
            .mesProductEnum(mesProductEnum)
            .basicClass(2)
            .name("工字钢")
            .image("https://static-assets.hzchum.com/plm7/img/MemberSectionImg/I-beams.jpg")
            .errorBigH(new BigDecimal(0))
            .errorType("H")
            .build();
         wmsSectionSteelControlTables.add(wmsSectionSteelControlTable10);
         this.saveOrUpdateBatch(wmsSectionSteelControlTables);
      }

      List<WmsSectionSteelControlTable> sectionSteelControlTables = this.list(
         (Wrapper<WmsSectionSteelControlTable>)new LambdaQueryWrapper<WmsSectionSteelControlTable>().eq(WmsSectionSteelControlTable::getMesProductEnum, mesProductEnum)
      );
      Map<String, List<WmsSectionSteelControlTable>> sectionSteelControlMap = sectionSteelControlTables.stream()
         .collect(Collectors.groupingBy(WmsSectionSteelControlTable::getName));
      List<SectionSteelControlTableDTO> sectionSteelControlTableDTOS = new ArrayList<>();
      sectionSteelControlMap.forEach(
         (k, v) -> {
            SectionSteelControlTableDTO sectionSteelControlTableDTO = SectionSteelControlTableDTO.builder()
               .mesProductEnum(v.get(0).getMesProductEnum())
               .basicClass(v.get(0).getBasicClass())
               .name(k)
               .image(v.get(0).getImage())
               .build();
            Map<String, BigDecimal> map = new HashMap<>();
            if (v.get(0).getErrorA() != null) {
               map.put("a", v.get(0).getErrorA());
            }

            if (v.get(0).getErrorB() != null) {
               map.put("b", v.get(0).getErrorB());
            }

            if (v.get(0).getErrorD() != null) {
               map.put("d", v.get(0).getErrorD());
            }

            if (v.get(0).getErrorH() != null) {
               map.put("h", v.get(0).getErrorH());
            }

            if (v.get(0).getErrorT() != null) {
               map.put("t", v.get(0).getErrorT());
            }

            if (v.get(0).getErrorS() != null) {
               map.put("s", v.get(0).getErrorS());
            }

            if (v.get(0).getErrorBigB() != null) {
               map.put("B", v.get(0).getErrorBigB());
            }

            if (v.get(0).getErrorBigD() != null) {
               map.put("D", v.get(0).getErrorBigD());
            }

            if (v.get(0).getErrorBigT() != null) {
               map.put("T", v.get(0).getErrorBigT());
            }

            if (v.get(0).getErrorBigH() != null) {
               map.put("H", v.get(0).getErrorBigH());
            }

            if (v.get(0).getErrorBigS() != null) {
               map.put("S", v.get(0).getErrorBigS());
            }

            sectionSteelControlTableDTO.setMap(map);
            Set<Long> classifyIds = new HashSet<>();
            Set<String> specifications = new HashSet<>();

            for (WmsSectionSteelControlTable w : v) {
               if (w.getMesSectionSpecification() != null) {
                  specifications.add(w.getMesSectionSpecification());
               }

               if (w.getWmsClassifyId() != null) {
                  classifyIds.add(w.getWmsClassifyId());
               }
            }

            sectionSteelControlTableDTO.setMesSectionSpecifications(specifications);
            sectionSteelControlTableDTO.setWmsClassifyIds(classifyIds);
            sectionSteelControlTableDTO.setErrorType(v.get(0).getErrorType());
            sectionSteelControlTableDTOS.add(sectionSteelControlTableDTO);
         }
      );
      return sectionSteelControlTableDTOS;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean saveSectionSteelControl(SectionSteelControlTableDTOParam param) {
      List<WmsSectionSteelControlTable> list = new ArrayList<>();

      for (String spec : param.getMesSectionSpecification()) {
         for (Long wmsClassifyId : param.getWmsClassifyIds()) {
            WmsSectionSteelControlTable wmsSectionSteelControlTable = WmsSectionSteelControlTable.builder()
               .mesProductEnum(param.getMesProductEnum())
               .basicClass(param.getBasicClass())
               .name(param.getName())
               .mesSectionSpecification(spec)
               .wmsClassifyId(wmsClassifyId)
               .image(param.getImage())
               .errorType(param.getErrorType())
               .build();
            if (param.getErrorA() != null) {
               wmsSectionSteelControlTable.setErrorA(param.getErrorA());
            }

            if (param.getErrorB() != null) {
               wmsSectionSteelControlTable.setErrorB(param.getErrorB());
            }

            if (param.getErrorD() != null) {
               wmsSectionSteelControlTable.setErrorD(param.getErrorD());
            }

            if (param.getErrorH() != null) {
               wmsSectionSteelControlTable.setErrorH(param.getErrorH());
            }

            if (param.getErrorT() != null) {
               wmsSectionSteelControlTable.setErrorT(param.getErrorT());
            }

            if (param.getErrorS() != null) {
               wmsSectionSteelControlTable.setErrorS(param.getErrorS());
            }

            if (param.getErrorBigB() != null) {
               wmsSectionSteelControlTable.setErrorBigB(param.getErrorBigB());
            }

            if (param.getErrorBigD() != null) {
               wmsSectionSteelControlTable.setErrorBigD(param.getErrorBigD());
            }

            if (param.getErrorBigH() != null) {
               wmsSectionSteelControlTable.setErrorBigH(param.getErrorBigH());
            }

            if (param.getErrorBigT() != null) {
               wmsSectionSteelControlTable.setErrorBigT(param.getErrorBigT());
            }

            if (param.getErrorBigS() != null) {
               wmsSectionSteelControlTable.setErrorBigS(param.getErrorBigS());
            }

            list.add(wmsSectionSteelControlTable);
         }
      }

      this.remove(
         (Wrapper<WmsSectionSteelControlTable>)(new LambdaQueryWrapper<WmsSectionSteelControlTable>().eq(WmsSectionSteelControlTable::getName, param.getName()))
            .eq(WmsSectionSteelControlTable::getMesProductEnum, param.getMesProductEnum())
      );
      return this.saveBatch(list);
   }

   @Override
   public List<Classification> getSectionSteelLastSubjects() {
      return this.classificationService
         .list(
            (Wrapper<Classification>)(new LambdaQueryWrapper<Classification>().eq(Classification::getBoolLastEnum, 1))
               .in(Classification::getBasicClass, BasicClassEnum.SECTION_STEEL.getType(), BasicClassEnum.STEEL_PLATE.getType())
         );
   }

   @Override
   public Map<String, BigDecimal> getPartDeepMete(Long projectId, Long classifyId) {
      Map<String, BigDecimal> deepMateMap = new HashMap<>();
      deepMateMap.put("totalNetWeight", BigDecimal.ZERO);
      deepMateMap.put("totalGrossWeight", BigDecimal.ZERO);
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "操作失败，未获取到项目信息！");
      List<SectionSteelControlTableDTO> dtoList = this.SectionSteelControlList(project.getProjectType());
      List<SectionSteelControlTableDTO> hasClassifyIdList = dtoList.stream()
         .filter(e -> e.getWmsClassifyIds().contains(classifyId))
         .collect(Collectors.toList());
      if (CollectionUtil.isEmpty(hasClassifyIdList)) {
         return deepMateMap;
      }

      if (hasClassifyIdList.size() > 1) {
         throw new BusinessException("原材料对照表配置错误！，同一物料科目对应了多组零件截面规格");
      }

      SectionSteelControlTableDTO controlTableDTO = hasClassifyIdList.get(0);
      Set<String> sectionSpecificationList = controlTableDTO.getMesSectionSpecifications();
      List<TechMachinePart> partList = this.partService
         .list(
            Wrappers.lambdaQuery(TechMachinePart.class)
               .eq(TechMachinePart::getProjectId, projectId)
               .in(TechMachinePart::getSpecPrefix, sectionSpecificationList)
               .select(TechMachinePart::getQuantity, TechMachinePart::getNetWeight, TechMachinePart::getGrossWeight)
         );
      BigDecimal totalNetWeight = partList.stream()
         .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalGrossWeight = partList.stream()
         .map(e -> e.getGrossWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      deepMateMap.put("totalNetWeight", totalNetWeight.multiply(BigDecimal.valueOf(1000L)));
      deepMateMap.put("totalGrossWeight", totalGrossWeight.multiply(BigDecimal.valueOf(1000L)));
      return deepMateMap;
   }
}
