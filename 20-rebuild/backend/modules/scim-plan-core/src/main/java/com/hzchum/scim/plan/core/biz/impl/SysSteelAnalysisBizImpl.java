package com.hzchum.scim.plan.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.plan.core.api.biz.SysSteelAnalysisBiz;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.steel.SteelAnalysisDTO;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.biz.SysSteelClassificationBiz;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassLinkDTO;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryProjectPickingDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysSteelAnalysisBizImpl implements SysSteelAnalysisBiz {
   @Autowired
   private SysSteelClassificationService steelClassificationService;
   @Autowired
   private MesBuildingNestCutPlatePartService mesBuildingNestCutPlatePartService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private OutboundService outboundService;
   @Autowired
   private MaterialInventoryService materialInventoryService;
   @Autowired
   private TechAssembleService techAssembleService;
   @Autowired
   private SysAssembleConfigService sysAssembleConfigService;
   @Autowired
   private SysSteelClassificationBiz steelClassificationBiz;
   @Autowired
   private ContractProjectService projectService;

   @Override
   public PageVO<SteelAnalysisDTO> analysis(Long projectId, List<Long> monomerIds, Integer pageNumber, Integer pageSize) {
      List<SteelAnalysisDTO> steelAnalysisDTOS = new ArrayList<>();
      Map<Long, List<SteelClassLinkDTO>> machinePartMap = this.steelClassificationService
         .listSteelAndClassify()
         .stream()
         .collect(Collectors.groupingBy(SteelClassLinkDTO::getSteelId));
      Map<Long, List<SteelClassLinkDTO>> assmbleMap = this.sysAssembleConfigService
         .listConfigIdAndClassifyV2()
         .stream()
         .collect(Collectors.groupingBy(s -> s.getSteelId()));
      List<Integer> relationTypes = new ArrayList<Integer>() {
         {
            this.add(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType());
         }
      };
      List<TechMachinePart> machineParts = this.machinePartService
         .list(
            (Wrapper<TechMachinePart>)(((((Wrappers.<TechMachinePart>lambdaQuery()
                              .eq(projectId != null, TechMachinePart::getProjectId, projectId))
                           .ne(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECTIONSTEEL.getType()))
                        .in(TechMachinePart::getRelationType, relationTypes))
                     .ne(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECTIONSTEEL.getType()))
                  .in(CollectionUtils.isNotEmpty(monomerIds), TechMachinePart::getMonomerId, monomerIds))
               .orderByDesc(TechMachinePart::getThick)
         );
      List<TechMachinePart> assembles = this.machinePartService
         .list(
            (Wrapper<TechMachinePart>)(((Wrappers.<TechMachinePart>lambdaQuery()
                        .eq(projectId != null, TechMachinePart::getProjectId, projectId))
                     .eq(TechMachinePart::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECTIONSTEEL.getType()))
                  .in(CollectionUtils.isNotEmpty(monomerIds), TechMachinePart::getMonomerId, monomerIds))
               .orderByAsc(TechMachinePart::getSpecification)
         );
      Map<String, List<TechMachinePart>> steelAndMachineParts = machineParts.stream()
         .collect(Collectors.groupingBy(e -> e.getSteelId() + "/" + e.getSteelSpec() + "/" + e.getMaterial()));
      Map<String, List<TechMachinePart>> steelAndAssembles = assembles.stream()
         .collect(Collectors.groupingBy(e -> e.getSteelId() + "/" + e.getSpecification() + "/" + e.getMaterial()));

      for (String key : steelAndMachineParts.keySet()) {
         List<TechMachinePart> techMachineParts = steelAndMachineParts.get(key);
         TechMachinePart part = techMachineParts.get(0);
         BigDecimal listMete = BigDecimal.ZERO;
         BigDecimal productMete = BigDecimal.ZERO;

         for (TechMachinePart techMachinePart : techMachineParts) {
            listMete = listMete.add(techMachinePart.getNetWeight().multiply(BigDecimal.valueOf(techMachinePart.getQuantity().intValue())));
            productMete = productMete.add(techMachinePart.getNetWeight().multiply(BigDecimal.valueOf(techMachinePart.getProducedQuantity().intValue())));
         }

         String[] split = key.split("/");
         String steelId = split[0];
         String steelSpec = split[1];
         String material = split[2];
         SteelClassLinkDTO steelClassLinkDTO = machinePartMap.get(Long.valueOf(steelId)).get(0);
         String steelName = steelClassLinkDTO.getSteelName();
         Long basicId = steelClassLinkDTO.getBasicClassId();
         Integer steelPlateTypeEnum = part.getSteelPlateTypeEnum();
         long type = SteelPlateTypeEnum.SECTIONSTEEL.getType().equals(steelPlateTypeEnum)
            ? BasicClassEnum.SECTION_STEEL.getType().longValue()
            : BasicClassEnum.STEEL_PLATE.getType().longValue();
         List<OutboundDetailDTO> useDetailDTOS = this.useDetail(projectId, steelSpec, material, Long.valueOf(steelId), type, null, null).getContent();
         List<MaterialInventoryDTO> inventoryDetailDTOS = this.inventoryDetails(
               projectId, this.changeString(steelSpec), material, Long.valueOf(steelId), type, null, null
            )
            .getContent();
         SteelAnalysisDTO build = SteelAnalysisDTO.builder()
            .name(steelName)
            .material(material)
            .configId(steelId)
            .thickness(steelSpec)
            .listMete(listMete)
            .basicId(basicId)
            .stockMete(inventoryDetailDTOS.stream().map(MaterialInventoryDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(1000)))
            .useMete(useDetailDTOS.stream().map(OutboundDetailDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(1000)))
            .productMete(productMete)
            .build();
         build.setDiff(build.getListMete().subtract(build.getUseMete()));
         if (listMete.compareTo(BigDecimal.ZERO) != 0) {
            build.setDiffRate(build.getDiff().divide(listMete, 5, 4).multiply(new BigDecimal(100)).setScale(5, 4));
         } else {
            build.setDiffRate(BigDecimal.ZERO);
         }

         steelAnalysisDTOS.add(build);
      }

      steelAnalysisDTOS = steelAnalysisDTOS.stream().sorted(Comparator.comparing(s -> Double.valueOf(s.getThickness()))).collect(Collectors.toList());
      List<SteelAnalysisDTO> assSteelAnalysisDTOS = new ArrayList<>();

      for (String key : steelAndAssembles.keySet()) {
         List<TechMachinePart> techAssembles = steelAndAssembles.get(key);
         BigDecimal listMete = BigDecimal.ZERO;
         BigDecimal productMete = BigDecimal.ZERO;

         for (TechMachinePart techAssemble : techAssembles) {
            listMete = listMete.add(techAssemble.getNetWeight().multiply(BigDecimal.valueOf(techAssemble.getQuantity().intValue())));
            productMete = productMete.add(techAssemble.getNetWeight().multiply(BigDecimal.valueOf(techAssemble.getProducedQuantity().intValue())));
         }

         String[] split = key.split("/");
         String steelId = split[0];
         String steelSpec = split[1];
         String material = split[2];
         List<Long> classifyIds = assmbleMap.get(Long.valueOf(steelId)).stream().map(SteelClassLinkDTO::getClassifyId).collect(Collectors.toList());
         SteelClassLinkDTO steelClassLinkDTO = assmbleMap.get(Long.valueOf(steelId)).get(0);
         String steelName = steelClassLinkDTO.getSteelName();
         Long basicId = steelClassLinkDTO.getBasicClassId();
         new HashMap();
         List<OutboundDetailDTO> useDetailDTOS = this.useDetail(
               projectId, steelSpec, material, Long.valueOf(steelId), BasicClassEnum.SECTION_STEEL.getType().longValue(), null, null
            )
            .getContent();
         List<MaterialInventoryDTO> inventoryDetailDTOS = this.inventoryDetails(
               projectId, this.assChangeString(steelSpec), material, Long.valueOf(steelId), BasicClassEnum.SECTION_STEEL.getType().longValue(), null, null
            )
            .getContent();
         SteelAnalysisDTO build = SteelAnalysisDTO.builder()
            .name(steelName)
            .material(material)
            .thickness(steelSpec)
            .configId(steelId)
            .listMete(listMete)
            .basicId(basicId)
            .stockMete(inventoryDetailDTOS.stream().map(MaterialInventoryDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(1000)))
            .useMete(useDetailDTOS.stream().map(OutboundDetailDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(1000)))
            .productMete(productMete)
            .build();
         build.setDiff(build.getListMete().subtract(build.getUseMete()));
         if (listMete.compareTo(BigDecimal.ZERO) != 0) {
            build.setDiffRate(build.getDiff().divide(listMete, 5, 4).multiply(new BigDecimal(100)).setScale(5, 4));
         } else {
            build.setDiffRate(BigDecimal.ZERO);
         }

         assSteelAnalysisDTOS.add(build);
      }

      assSteelAnalysisDTOS = assSteelAnalysisDTOS.stream()
         .sorted(Comparator.comparing(SteelAnalysisDTO::getConfigId).thenComparing(SteelAnalysisDTO::getMaterial).thenComparing(SteelAnalysisDTO::getThickness))
         .collect(Collectors.toList());
      steelAnalysisDTOS.addAll(assSteelAnalysisDTOS);
      return pageNumber != null && pageSize != null ? this.getPages(pageNumber, pageSize, steelAnalysisDTOS) : new PageVO<>(steelAnalysisDTOS);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> analysisPrint(Long projectId, List<Long> monomerIds) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         header.put("project", this.projectService.getSimpleById(projectId));
      }

      header.put("userId", UserUtil.getCurrentUser().getId());
      header.put("userName", UserUtil.getCurrentUser().getName());
      header.put("phone", UserUtil.getCurrentUser().getPhone());
      printVO.setHeader(header);
      printVO.setTable(this.analysis(projectId, null, null, null).getContent().stream().map(e -> BeanUtil.beanToMap(e)).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO<MaterialInventoryDTO> inventoryDetails(
      Long projectId, String thickness, String material, Long configId, Long basicId, Integer pageNumber, Integer pageSize
   ) {
      new HashMap();
      if (Integer.valueOf(basicId + "").equals(BasicClassEnum.STEEL_PLATE.getType())) {
         Map<Long, List<SteelClassLinkDTO>> var10 = this.steelClassificationService
            .listSteelAndClassify()
            .stream()
            .collect(Collectors.groupingBy(SteelClassLinkDTO::getSteelId));
         List<Long> classifyIds = var10.get(configId).stream().map(SteelClassLinkDTO::getClassifyId).collect(Collectors.toList());
         if (pageNumber != null && pageSize != null) {
            PageHelper.startPage(pageNumber, pageSize);
         }

         return this.materialInventoryService.getInventoryDetails(projectId, classifyIds, new BigDecimal(thickness), material);
      } else {
         Map<Long, List<SteelClassLinkDTO>> configMap = this.sysAssembleConfigService
            .listConfigIdAndClassifyV2()
            .stream()
            .collect(Collectors.groupingBy(SteelClassLinkDTO::getSteelId));
         List<Long> classifyIds = configMap.get(configId).stream().map(SteelClassLinkDTO::getClassifyId).collect(Collectors.toList());
         if (pageNumber != null && pageSize != null) {
            PageHelper.startPage(pageNumber, pageSize);
         }

         return this.materialInventoryService.getInventoryDetails(projectId, classifyIds, null, thickness + " * " + material);
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> inventoryDetailsPrint(Long projectId, String thickness, String material, Long configId, Long basicId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         header.put("project", this.projectService.getSimpleById(projectId));
      }

      header.put("userId", UserUtil.getCurrentUser().getId());
      header.put("userName", UserUtil.getCurrentUser().getName());
      header.put("phone", UserUtil.getCurrentUser().getPhone());
      header.put("thickness", thickness);
      header.put("material", material);
      header.put("basicName", BasicClassEnum.getNameByType(basicId.intValue()));
      printVO.setHeader(header);
      printVO.setTable(
         this.inventoryDetails(projectId, thickness, material, configId, basicId, null, null)
            .getContent()
            .stream()
            .map(e -> BeanUtil.beanToMap(e))
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public PageVO<OutboundDetailDTO> useDetail(
      Long projectId, String thickness, String material, Long configId, Long basicId, Integer pageNumber, Integer pageSize
   ) {
      new HashMap();
      new PageVO();
      int basicClass = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.SECTION_STEEL.getType() | BasicClassEnum.COLOR_ROLL.getType();
      PageVO useDetail;
      if (Integer.valueOf(basicId + "").equals(BasicClassEnum.STEEL_PLATE.getType())) {
         Map<Long, List<SteelClassLinkDTO>> configMap = this.steelClassificationService
            .listSteelAndClassify()
            .stream()
            .collect(Collectors.groupingBy(SteelClassLinkDTO::getSteelId));
         QueryProjectPickingDTOParam build = QueryProjectPickingDTOParam.builder()
            .projectId(projectId)
            .basicClass(Integer.valueOf(basicId + ""))
            .material(material)
            .thickness(new BigDecimal(thickness))
            .build();
         useDetail = this.outboundService.getAppProjectPicking(build, pageNumber, pageSize);
      } else {
         Map<Long, List<SteelClassLinkDTO>> var13 = this.sysAssembleConfigService
            .listConfigIdAndClassifyV2()
            .stream()
            .collect(Collectors.groupingBy(SteelClassLinkDTO::getSteelId));
         QueryProjectPickingDTOParam build = QueryProjectPickingDTOParam.builder()
            .projectId(projectId)
            .basicClass(Integer.valueOf(basicId + ""))
            .material(material)
            .specification(thickness)
            .build();
         useDetail = this.outboundService.getAppProjectPicking(build, pageNumber, pageSize);
      }

      return useDetail.getContent().size() == 0 ? new PageVO<>(new ArrayList<>()) : useDetail;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> useDetailPrint(Long projectId, String thickness, String material, Long configId, Long basicId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         header.put("project", this.projectService.getSimpleById(projectId));
      }

      header.put("userId", UserUtil.getCurrentUser().getId());
      header.put("userName", UserUtil.getCurrentUser().getName());
      header.put("phone", UserUtil.getCurrentUser().getPhone());
      header.put("thickness", thickness);
      header.put("material", material);
      header.put("basicName", BasicClassEnum.getNameByType(basicId.intValue()));
      printVO.setHeader(header);
      printVO.setTable(
         this.useDetail(projectId, thickness, material, configId, basicId, null, null)
            .getContent()
            .stream()
            .map(e -> BeanUtil.beanToMap(e))
            .collect(Collectors.toList())
      );
      return printVO;
   }

   private String changeString(String s) {
      String s1 = s;
      s1 = s1.replaceAll("[a-zA-Z]", "");
      if (s.contains("*")) {
         s1 = s.substring(0, s.indexOf("*"));
      }

      if (s.contains("x")) {
         s1 = s.substring(0, s.indexOf("x"));
      }

      return s1;
   }

   public String assChangeString(String str) {
      int i = -1;
      Matcher matcher = Pattern.compile("[0-9]").matcher(str);
      if (matcher.find()) {
         i = matcher.start();
      }

      if (i != -1) {
         str = str.substring(i);
      }

      return str;
   }

   private PageVO getPages(Integer pageNumber, Integer pageSize, List list) {
      PageVO page = new PageVO();
      if (list == null) {
         return null;
      }

      int size = list.size();
      if (pageSize > size) {
         pageSize = size;
      }

      if (pageSize != 0) {
         int maxPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;
         if (pageNumber > maxPage) {
            pageNumber = maxPage;
         }

         page.setHasNextPage(pageNumber < maxPage);
      }

      int curIdx = pageNumber > 1 ? (pageNumber - 1) * pageSize : 0;
      List pageList = new ArrayList();

      for (int i = 0; i < pageSize && curIdx + i < size; i++) {
         pageList.add(list.get(curIdx + i));
      }

      page.setHasPreviousPage(pageNumber > 1);
      page.setContent(pageList);
      page.setTotalElements(list.size());
      return page;
   }
}
