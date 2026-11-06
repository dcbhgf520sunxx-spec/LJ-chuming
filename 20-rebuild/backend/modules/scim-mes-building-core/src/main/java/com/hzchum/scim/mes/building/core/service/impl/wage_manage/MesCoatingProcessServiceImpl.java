package com.hzchum.scim.mes.building.core.service.impl.wage_manage;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesCoatingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesCoatingProcessDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesCoatingProcessArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesCoatingProcessArtifactTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesCoatingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesCoatingProcessPrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesCoatingProcessSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesCoatingProcessDetailService;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesCoatingProcessService;
import com.hzchum.scim.mes.building.core.mapper.wage_manage.MesCoatingProcessMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesCoatingProcessServiceImpl extends ServiceImpl<MesCoatingProcessMapper, MesCoatingProcess> implements MesCoatingProcessService {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesCoatingProcessDetailService coatingProcessDetailService;
   @Autowired
   private TechArtifactExtService artifactExtService;

   private String getNextSerialNumber() {
      String prefix = "TZ";
      String nowDate = DateUtil.format(new Date(), "yyyyMMdd");
      Integer maxSerialNumber = this.baseMapper.getMaxSerialNumber();
      return prefix + nowDate + "-" + String.format("%02d", maxSerialNumber + 1);
   }

   @Override
   public List<MesCoatingProcessArtifactTypeDTO> artifactTypeList(Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.artifactTypeList(projectId, monomerId, areaId);
   }

   @Override
   public PageVO<MesCoatingProcessArtifactDTO> artifactList(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long artifactTypeId,
      String name,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize
   ) {
      Page<MesCoatingProcessArtifactDTO> page = PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(page, this.baseMapper.artifactList(projectId, monomerId, areaId, artifactTypeId, name, serialNumber, specification, material));
   }

   @Override
   public List<MesCoatingProcessDTO> listInfo(Long contractProjectId) {
      List<MesCoatingProcessDTO> dtoList = this.baseMapper.listInfo(contractProjectId);
      dtoList.forEach(e -> e.getDetailList().forEach(d -> {
         String paintInfo;
         if (StrUtil.isAllBlank(d.getPaintCategory(), d.getPaintBrand()) && d.getThickness() == null) {
            paintInfo = "-";
         } else {
            paintInfo = StrUtil.nullToDefault(d.getPaintCategory(), "-") + "/" + d.getPaintBrand() + "【" + d.getThickness() + "μm】";
         }

         switch (d.getPaintType()) {
            case 1:
               e.setPrimer(paintInfo);
               break;
            case 2:
               e.setIntermediatePaint(paintInfo);
            case 3:
            default:
               break;
            case 4:
               e.setTopcoat(paintInfo);
         }
      }));
      return dtoList;
   }

   @Override
   public List<MesCoatingProcessDTO> listInfoByContractProjectIds(List<Long> contractProjectIds) {
      return this.baseMapper.listInfoByContractProjectIds(contractProjectIds);
   }

   @Override
   public PrintVO listPrint(Long contractProjectId) {
      PrintVO printVO = new PrintVO();
      Map header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("statisticsDate", System.currentTimeMillis());
      printVO.setHeader(header);
      List<Map<String, Object>> table = new ArrayList<>();
      List<MesCoatingProcessDTO> dtoList = this.baseMapper.listInfo(contractProjectId);
      dtoList.forEach(coatingProcessDTO -> {
         coatingProcessDTO.getDetailList().forEach(d -> {
            String paintInfo;
            if (StrUtil.isAllBlank(d.getPaintCategory(), d.getPaintBrand()) && d.getThickness() == null) {
               paintInfo = "-";
            } else {
               paintInfo = StrUtil.nullToDefault(d.getPaintCategory(), "-") + "/" + d.getPaintBrand() + "【" + d.getThickness() + "μm】";
            }

            switch (d.getPaintType()) {
               case 1:
                  coatingProcessDTO.setPrimer(paintInfo);
                  break;
               case 2:
                  coatingProcessDTO.setIntermediatePaint(paintInfo);
               case 3:
               default:
                  break;
               case 4:
                  coatingProcessDTO.setTopcoat(paintInfo);
            }
         });
         MesCoatingProcessPrintDTO printDTO = BeanUtil.toBean(coatingProcessDTO, MesCoatingProcessPrintDTO.class);
         table.add(BeanUtil.beanToMap(printDTO));
      });
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public MesCoatingProcessDTO detailById(Long id) {
      return this.baseMapper.detailById(id);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveCoatingProcess(MesCoatingProcessSaveDTOParam saveDTOParam) {
      ContractProject project = this.projectService.getById(saveDTOParam.getContractProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      int artifactQuantity = saveDTOParam.getArtifactList().stream().mapToInt(TechArtifact::getQuantity).sum();
      Preconditions.checkArgument(artifactQuantity == saveDTOParam.getArtifactQuantity(), "构件数量有误");
      BigDecimal totalArea = saveDTOParam.getArtifactList()
         .stream()
         .map(a -> BigDecimal.valueOf(a.getQuantity().intValue()).multiply(a.getSurfaceArea()))
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP);
      Preconditions.checkArgument(totalArea.compareTo(saveDTOParam.getTotalArea()) == 0, "总面积有误");
      saveDTOParam.setSerialNumber(this.getNextSerialNumber());
      saveDTOParam.setCreateUserId(UserUtil.getCurrentUserId());
      MesCoatingProcess coatingProcess = BeanUtil.toBean(saveDTOParam, MesCoatingProcess.class);
      this.baseMapper.insert(coatingProcess);
      List<MesCoatingProcessDetail> coatingProcessDetailList = saveDTOParam.getDetailList()
         .stream()
         .map(
            d -> {
               Preconditions.checkArgument(
                  CollUtil.newArrayList(PaintingTypeEnum.PRIMER.getType(), PaintingTypeEnum.INTERMEDIATE_PAINT.getType(), PaintingTypeEnum.TOPCOAT.getType())
                     .contains(d.getPaintType()),
                  "油漆类型不存在"
               );
               MesCoatingProcessDetail coatingProcessDetail = BeanUtil.toBean(d, MesCoatingProcessDetail.class);
               coatingProcessDetail.setCoatingProcessId(coatingProcess.getId());
               return coatingProcessDetail;
            }
         )
         .collect(Collectors.toList());
      this.coatingProcessDetailService.saveBatch(coatingProcessDetailList, coatingProcessDetailList.size());
      Map<Long, List<TechArtifactExt>> artifactExtByArtifactIdMap = this.artifactExtService
         .list(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .in(TechArtifactExt::getArtifactId, saveDTOParam.getArtifactList().stream().map(TechArtifact::getId).collect(Collectors.toList()))
               .isNull(TechArtifactExt::getBooleanPainting)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      Map<TechArtifact, Integer> quantityByArtifactIdMap = saveDTOParam.getArtifactList()
         .stream()
         .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(TechArtifact::getQuantity)));
      quantityByArtifactIdMap.forEach((artifact, quantity) -> {
         int artifactExtQuantity = Optional.ofNullable(artifactExtByArtifactIdMap.get(artifact.getId())).map(List::size).orElse(0);
         Preconditions.checkArgument(quantity <= artifactExtQuantity, "构件: " + artifact.getName() + ", 数量总和已超出清单数量");
      });
      List<TechArtifactExt> updateArtifactExtList = new ArrayList<>();
      Set<Long> associatedArtifactExtIdSet = new HashSet<>();
      saveDTOParam.getArtifactList()
         .forEach(
            artifact -> {
               List<TechArtifactExt> artifactExtList = artifactExtByArtifactIdMap.get(artifact.getId())
                  .stream()
                  .filter(ae -> !associatedArtifactExtIdSet.contains(ae.getId()))
                  .collect(Collectors.toList());

               for (int i = 0; i < artifact.getQuantity(); i++) {
                  TechArtifactExt artifactExt = TechArtifactExt.builder()
                     .id(artifactExtList.get(i).getId())
                     .booleanPainting(Boolean.TRUE)
                     .area(artifact.getSurfaceArea())
                     .coatingProcessId(coatingProcess.getId())
                     .build();
                  updateArtifactExtList.add(artifactExt);
                  associatedArtifactExtIdSet.add(artifactExt.getId());
               }
            }
         );
      this.artifactExtService.updateBatchById(updateArtifactExtList, updateArtifactExtList.size());
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateCoatingProcess(MesCoatingProcessSaveDTOParam saveDTOParam) {
      Preconditions.checkArgument(CollUtil.isNotEmpty(saveDTOParam.getDetailList()), "油漆类型不能为空");
      int count = this.artifactExtService
         .count(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .eq(TechArtifactExt::getCoatingProcessId, saveDTOParam.getId())
               .eq(TechArtifactExt::getBoolTask, Boolean.TRUE)
         );
      MesCoatingProcess coatingProcess = this.baseMapper.selectById(saveDTOParam.getId());
      Preconditions.checkArgument(coatingProcess != null, "当前涂装工艺不存在");
      this.coatingProcessDetailService
         .remove(Wrappers.lambdaQuery(MesCoatingProcessDetail.class).eq(MesCoatingProcessDetail::getCoatingProcessId, saveDTOParam.getId()));
      List<MesCoatingProcessDetail> coatingProcessDetailList = saveDTOParam.getDetailList()
         .stream()
         .map(
            d -> {
               Preconditions.checkArgument(
                  CollUtil.newArrayList(PaintingTypeEnum.PRIMER.getType(), PaintingTypeEnum.INTERMEDIATE_PAINT.getType(), PaintingTypeEnum.TOPCOAT.getType())
                     .contains(d.getPaintType()),
                  "油漆类型不存在"
               );
               MesCoatingProcessDetail coatingProcessDetail = BeanUtil.toBean(d, MesCoatingProcessDetail.class);
               coatingProcessDetail.setCoatingProcessId(coatingProcess.getId());
               return coatingProcessDetail;
            }
         )
         .collect(Collectors.toList());
      this.coatingProcessDetailService.saveBatch(coatingProcessDetailList, coatingProcessDetailList.size());
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesCoatingProcess coatingProcess = this.baseMapper.selectById(id);
      Preconditions.checkArgument(coatingProcess != null, "当前涂装工艺不存在");
      int count = this.artifactExtService
         .count(Wrappers.lambdaQuery(TechArtifactExt.class).eq(TechArtifactExt::getCoatingProcessId, id).eq(TechArtifactExt::getBoolTask, Boolean.TRUE));
      this.baseMapper.deleteById(id);
      this.coatingProcessDetailService.remove(Wrappers.lambdaQuery(MesCoatingProcessDetail.class).eq(MesCoatingProcessDetail::getCoatingProcessId, id));
      this.artifactExtService
         .update(
            Wrappers.lambdaUpdate(TechArtifactExt.class)
               .set(TechArtifactExt::getCoatingProcessId, null)
               .set(TechArtifactExt::getArea, null)
               .set(TechArtifactExt::getBooleanPainting, null)
               .eq(TechArtifactExt::getCoatingProcessId, id)
         );
      return Boolean.TRUE;
   }

   @Override
   public List<MesCoatingProcessArtifactDTO> coatingProcessArtifactList(Long id, String name, String serialNumber, String specification, String material) {
      return this.baseMapper.coatingProcessArtifactList(id, name, serialNumber, specification, material);
   }

   @Override
   public List<MesCoatingProcessArtifactDTO> coatingProcessArtifactDetailList(Long id, Long artifactId, BigDecimal area, Boolean boolProduced) {
      return this.baseMapper.coatingProcessArtifactDetailList(id, artifactId, area, boolProduced);
   }

   @Override
   public PageVO<MesCoatingProcessArtifactDTO> coatingProcessArtifactDetailPage(
      Long id, Long artifactId, BigDecimal area, Boolean boolProduced, Integer pageNumber, Integer pageSize
   ) {
      Page<MesCoatingProcessArtifactDTO> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesCoatingProcessArtifactDTO> dtoList = this.baseMapper.coatingProcessArtifactDetailList(id, artifactId, area, boolProduced);
      return new PageVO<>(page, dtoList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean coatingProcessArtifactDetailDelete(Long coatingProcessId, List<Long> ids) {
      MesCoatingProcess coatingProcess = this.baseMapper.selectById(coatingProcessId);
      Preconditions.checkArgument(coatingProcess != null, "当前涂装工艺不存在");
      List<TechArtifactExt> artifactExtList = this.artifactExtService.listByIds(ids);
      Integer artifactQuantity = coatingProcess.getArtifactQuantity() - artifactExtList.stream().mapToInt(TechArtifactExt::getQuantity).sum();
      BigDecimal totalArea = coatingProcess.getTotalArea()
         .subtract(
            artifactExtList.stream()
               .map(ae -> BigDecimal.valueOf(ae.getQuantity().intValue()).multiply(ae.getArea()))
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP)
         );
      this.baseMapper.updateById(MesCoatingProcess.builder().id(coatingProcessId).artifactQuantity(artifactQuantity).totalArea(totalArea).build());
      this.artifactExtService
         .update(
            Wrappers.lambdaUpdate(TechArtifactExt.class)
               .set(TechArtifactExt::getCoatingProcessId, null)
               .set(TechArtifactExt::getArea, null)
               .set(TechArtifactExt::getBooleanPainting, null)
               .in(TechArtifactExt::getId, ids)
         );
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addArtifactList(MesCoatingProcessSaveDTOParam saveDTOParam) {
      Preconditions.checkArgument(CollUtil.isNotEmpty(saveDTOParam.getArtifactList()), "清单列表不能为空");
      MesCoatingProcess coatingProcess = this.baseMapper.selectById(saveDTOParam.getId());
      Preconditions.checkArgument(coatingProcess != null, "当前涂装工艺不存在");
      int quantity = saveDTOParam.getArtifactList().stream().mapToInt(TechArtifact::getQuantity).sum();
      Preconditions.checkArgument(quantity == saveDTOParam.getArtifactQuantity(), "构件数量有误");
      BigDecimal area = saveDTOParam.getArtifactList()
         .stream()
         .map(a -> BigDecimal.valueOf(a.getQuantity().intValue()).multiply(a.getSurfaceArea()))
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP);
      Preconditions.checkArgument(area.compareTo(saveDTOParam.getTotalArea()) == 0, "总面积有误");
      Integer artifactQuantity = saveDTOParam.getArtifactQuantity() + coatingProcess.getArtifactQuantity();
      BigDecimal totalArea = saveDTOParam.getTotalArea().add(coatingProcess.getTotalArea());
      this.baseMapper.updateById(MesCoatingProcess.builder().id(saveDTOParam.getId()).artifactQuantity(artifactQuantity).totalArea(totalArea).build());
      Map<Long, List<TechArtifactExt>> artifactExtByArtifactIdMap = this.artifactExtService
         .list(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .in(TechArtifactExt::getArtifactId, saveDTOParam.getArtifactList().stream().map(TechArtifact::getId).collect(Collectors.toList()))
               .isNull(TechArtifactExt::getBooleanPainting)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      List<TechArtifactExt> updateArtifactExtList = new ArrayList<>();
      Set<Long> associatedArtifactExtIdSet = new HashSet<>();
      saveDTOParam.getArtifactList()
         .forEach(
            artifact -> {
               List<TechArtifactExt> artifactExtList = artifactExtByArtifactIdMap.get(artifact.getId())
                  .stream()
                  .filter(ae -> !associatedArtifactExtIdSet.contains(ae.getId()))
                  .collect(Collectors.toList());

               for (int i = 0; i < artifact.getQuantity(); i++) {
                  TechArtifactExt artifactExt = TechArtifactExt.builder()
                     .id(artifactExtList.get(i).getId())
                     .booleanPainting(Boolean.TRUE)
                     .area(artifact.getSurfaceArea())
                     .coatingProcessId(coatingProcess.getId())
                     .build();
                  updateArtifactExtList.add(artifactExt);
                  associatedArtifactExtIdSet.add(artifactExt.getId());
               }
            }
         );
      this.artifactExtService.updateBatchById(updateArtifactExtList, updateArtifactExtList.size());
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editArtifactList(MesCoatingProcessSaveDTOParam saveDTOParam) {
      Preconditions.checkArgument(CollUtil.isNotEmpty(saveDTOParam.getArtifactList()), "清单列表不能为空");
      MesCoatingProcess coatingProcess = this.baseMapper.selectById(saveDTOParam.getId());
      Preconditions.checkArgument(coatingProcess != null, "当前涂装工艺不存在");
      int count = this.artifactExtService
         .count(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .eq(TechArtifactExt::getCoatingProcessId, saveDTOParam.getId())
               .eq(TechArtifactExt::getBoolTask, Boolean.TRUE)
         );
      Integer artifactQuantity = saveDTOParam.getArtifactList().stream().mapToInt(TechArtifact::getQuantity).sum();
      BigDecimal totalArea = saveDTOParam.getArtifactList()
         .stream()
         .map(a -> BigDecimal.valueOf(a.getQuantity().intValue()).multiply(a.getSurfaceArea()))
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP);
      this.baseMapper.updateById(MesCoatingProcess.builder().id(saveDTOParam.getId()).artifactQuantity(artifactQuantity).totalArea(totalArea).build());
      this.artifactExtService
         .update(
            Wrappers.lambdaUpdate(TechArtifactExt.class)
               .set(TechArtifactExt::getCoatingProcessId, null)
               .set(TechArtifactExt::getArea, null)
               .set(TechArtifactExt::getBooleanPainting, null)
               .eq(TechArtifactExt::getCoatingProcessId, saveDTOParam.getId())
         );
      Map<Long, List<TechArtifactExt>> artifactExtByArtifactIdMap = this.artifactExtService
         .list(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .in(TechArtifactExt::getArtifactId, saveDTOParam.getArtifactList().stream().map(TechArtifact::getId).collect(Collectors.toList()))
               .isNull(TechArtifactExt::getBooleanPainting)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      List<TechArtifactExt> updateArtifactExtList = new ArrayList<>();
      Set<Long> associatedArtifactExtIdSet = new HashSet<>();
      saveDTOParam.getArtifactList()
         .forEach(
            artifact -> {
               List<TechArtifactExt> artifactExtList = artifactExtByArtifactIdMap.get(artifact.getId())
                  .stream()
                  .filter(ae -> !associatedArtifactExtIdSet.contains(ae.getId()))
                  .collect(Collectors.toList());

               for (int i = 0; i < artifact.getQuantity(); i++) {
                  TechArtifactExt artifactExt = TechArtifactExt.builder()
                     .id(artifactExtList.get(i).getId())
                     .booleanPainting(Boolean.TRUE)
                     .area(artifact.getSurfaceArea())
                     .coatingProcessId(coatingProcess.getId())
                     .build();
                  updateArtifactExtList.add(artifactExt);
                  associatedArtifactExtIdSet.add(artifactExt.getId());
               }
            }
         );
      this.artifactExtService.updateBatchById(updateArtifactExtList, updateArtifactExtList.size());
      return Boolean.TRUE;
   }

   @Override
   public Boolean deleteArtifact(MesCoatingProcessSaveDTOParam saveDTOParam) {
      Preconditions.checkArgument(CollUtil.isNotEmpty(saveDTOParam.getArtifactList()), "清单不能为空");
      MesCoatingProcess coatingProcess = this.baseMapper.selectById(saveDTOParam.getId());
      Preconditions.checkArgument(coatingProcess != null, "当前涂装工艺不存在");
      int count = this.artifactExtService
         .count(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .eq(TechArtifactExt::getCoatingProcessId, saveDTOParam.getId())
               .eq(TechArtifactExt::getBoolTask, Boolean.TRUE)
         );
      Integer artifactQuantity = coatingProcess.getArtifactQuantity() - saveDTOParam.getArtifactList().stream().mapToInt(TechArtifact::getQuantity).sum();
      BigDecimal totalArea = coatingProcess.getTotalArea()
         .subtract(
            saveDTOParam.getArtifactList()
               .stream()
               .map(a -> BigDecimal.valueOf(a.getQuantity().intValue()).multiply(a.getSurfaceArea()))
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(BigDecimal.valueOf(1000000L), 8, RoundingMode.HALF_UP)
         );
      this.baseMapper.updateById(MesCoatingProcess.builder().id(saveDTOParam.getId()).artifactQuantity(artifactQuantity).totalArea(totalArea).build());
      List<Long> artifactIdList = saveDTOParam.getArtifactList().stream().map(TechArtifact::getId).collect(Collectors.toList());
      List<TechArtifactExt> artifactExtList = this.artifactExtService
         .list(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .in(TechArtifactExt::getArtifactId, artifactIdList)
               .eq(TechArtifactExt::getCoatingProcessId, saveDTOParam.getId())
               .eq(TechArtifactExt::getBooleanPainting, Boolean.TRUE)
         );
      Map<Long, Map<BigDecimal, List<TechArtifactExt>>> artifactExtMap = artifactExtList.stream()
         .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId, Collectors.groupingBy(TechArtifactExt::getArea)));
      Set<Long> associatedArtifactExtIdSet = new HashSet<>();
      saveDTOParam.getArtifactList()
         .forEach(
            a -> {
               List<TechArtifactExt> artifactExts = artifactExtMap.getOrDefault(a.getId(), new HashMap<>())
                  .getOrDefault(a.getSurfaceArea().setScale(8, RoundingMode.HALF_UP), new ArrayList<>())
                  .stream()
                  .filter(ae -> !associatedArtifactExtIdSet.contains(ae.getId()))
                  .collect(Collectors.toList());
               if (CollUtil.isNotEmpty(artifactExts)) {
                  for (int i = 0; i < a.getQuantity(); i++) {
                     Long artifactExtId = artifactExts.get(i).getId();
                     this.artifactExtService
                        .update(
                           Wrappers.lambdaUpdate(TechArtifactExt.class)
                              .set(TechArtifactExt::getCoatingProcessId, null)
                              .set(TechArtifactExt::getArea, null)
                              .set(TechArtifactExt::getBooleanPainting, null)
                              .eq(TechArtifactExt::getId, artifactExtId)
                        );
                     associatedArtifactExtIdSet.add(artifactExtId);
                  }
               }
            }
         );
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean noPaintingRequired(List<TechArtifact> artifactList) {
      Map<Long, List<TechArtifactExt>> artifactExtByArtifactIdMap = this.artifactExtService
         .list(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .in(TechArtifactExt::getArtifactId, artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
               .isNull(TechArtifactExt::getBooleanPainting)
         )
         .stream()
         .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      List<TechArtifactExt> updateArtifactExtList = new ArrayList<>();
      Set<Long> associatedArtifactExtIdSet = new HashSet<>();
      artifactList.forEach(
         artifact -> {
            List<TechArtifactExt> artifactExtList = artifactExtByArtifactIdMap.get(artifact.getId())
               .stream()
               .filter(ae -> !associatedArtifactExtIdSet.contains(ae.getId()))
               .collect(Collectors.toList());

            for (int i = 0; i < artifact.getQuantity(); i++) {
               TechArtifactExt artifactExt = TechArtifactExt.builder().id(artifactExtList.get(i).getId()).booleanPainting(Boolean.FALSE).build();
               updateArtifactExtList.add(artifactExt);
               associatedArtifactExtIdSet.add(artifactExt.getId());
            }
         }
      );
      this.artifactExtService.updateBatchById(updateArtifactExtList, updateArtifactExtList.size());
      return Boolean.TRUE;
   }
}
