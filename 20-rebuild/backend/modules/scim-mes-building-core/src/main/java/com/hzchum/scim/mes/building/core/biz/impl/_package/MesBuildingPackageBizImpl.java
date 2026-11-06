package com.hzchum.scim.mes.building.core.biz.impl._package;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.NumberUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.MesBuildingLinkCommonDTOParam;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.mes.building.core.api.biz._package.MesBuildingPackageBiz;
import com.hzchum.scim.mes.building.core.api.biz._package.MesBuildingPackageNumberLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.product.MesProductBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.PackageStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.manager.MesBuildingCalcMaxNumManager;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.PackageDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.ArtifactStockNumberDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackage;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseStorageProduct;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam._package.MesBuildingPackageDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto._package.PackageDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto._package.PackageLinkDetailsCommonDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto._package.PackageLinkDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProductSumInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.ArtNotRectifiedInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package.MesBuildingLinkDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package.MesBuildingPackageAddDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package.MesBuildingPackageDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package.MesBuildingPackageUpdateDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.MesBuildingCalcuDTOParam;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageLinkService;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWarehouseService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseStorageProductService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesBuildingPackageBizImpl implements MesBuildingPackageBiz {
   @Resource
   private MesBuildingPackageService packageService;
   @Resource
   private MesBuildingPackageLinkService packageLinkService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private MesBuildingWarehouseService warehouseService;
   @Resource
   private MesProductBiz mesProductBiz;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private ProjectUserLinkService projectUserLinkService;
   @Resource
   private MesBuildingUtilsBiz utilsBiz;
   @Resource
   private MesBuildingPackageNumberLinkBiz packageNumberLinkBiz;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private MesBuildingWarehouseStorageProductService warehouseStorageProductService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesBuildingCalcMaxNumManager mesBuildingCalcMaxNumManager;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechArtifactExtService artifactExtService;
   @Resource
   private TechAssembleService techAssembleService;
   @Resource
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Resource
   private TechAssembleExtService techAssembleExtService;
   @Resource
   private MesBuildingQhseService qhseService;
   @Resource
   private AttachmentService attachmentService;

   @Override
   public PageVO<PackageDTO> packagePage(MesBuildingPackageDOParam request) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(request.getProjectType(), null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      request.setProjectIds(projectIds);
      PageVO<PackageDO> packages = this.packageService.packagePage(request);
      PageVO<PackageDTO> pageResult = BeanUtil.copy(packages, PageVO.class);
      List<PackageDTO> content = packages.getContent().stream().map(item -> {
         PackageDTO packageDTO = BeanUtil.copy(item, PackageDTO.class);
         ProductSumInfoDTO sumInfoDTO = this.getInfoByPackageId(item.getId());
         BeanUtil.copy(sumInfoDTO, packageDTO);
         packageDTO.setBoolShip(packageDTO.getStatus().equals(PackageStatusEnum.SHIPMENT.getType()));
         return packageDTO;
      }).collect(Collectors.toList());
      pageResult.setContent(content);
      return pageResult;
   }

   @Override
   public PackageLinkDetailsDTO getDetailById(Long id) {
      PackageDTO pack = this.getPackageInfo(id);
      PackageLinkDetailsDTO result = BeanUtil.copy(pack, PackageLinkDetailsDTO.class);
      if ((pack.getProductType() & ProductTypeEnum.ARTIFACT.getType()) > 0) {
         result.setArtifactList(
            this.packageLinkService
               .listArtifactDetailsByPackageId(id)
               .stream()
               .peek(
                  e -> {
                     e.setBoolOneCode(this.utilsBiz.getBoolOneCode(e.getProductId()));
                     if (e.getBoolOneCode() && !e.getWarehouseType().equals(WarehouseTypeProductReturnEnum.SUBSCRIBE.getType())) {
                        List<Integer> packageNumberList = this.packageNumberLinkBiz
                           .list(
                              (Wrapper<MesBuildingPackageNumberLink>)((Wrappers.<MesBuildingPackageNumberLink>lambdaQuery()
                                       .eq(MesBuildingPackageNumberLink::getPackageId, id))
                                    .eq(MesBuildingPackageNumberLink::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                                 .eq(MesBuildingPackageNumberLink::getProductId, e.getProductId())
                           )
                           .stream()
                           .map(MesBuildingPackageNumberLink::getNumber)
                           .collect(Collectors.toList());
                        e.setNumberList(
                           this.warehouseRecordService
                              .list(
                                 (Wrapper<MesBuildingWarehouseRecord>)(((Wrappers.<MesBuildingWarehouseRecord>lambdaQuery()
                                             .eq(MesBuildingWarehouseRecord::getProductId, e.getProductId()))
                                          .eq(MesBuildingWarehouseRecord::getFactoryId, e.getFactory().getId()))
                                       .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                                    .and(
                                       item -> {
                                          LambdaQueryWrapper var10000 = ((item.eq(
                                                   MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType()
                                                ))
                                                .or())
                                             .in(packageNumberList.size() > 0, MesBuildingWarehouseRecord::getNumber, packageNumberList);
                                       }
                                    )
                              )
                              .stream()
                              .map(
                                 item -> ArtifactStockNumberDO.builder()
                                    .number(item.getNumber())
                                    .boolPackage(packageNumberList.contains(item.getNumber()))
                                    .build()
                              )
                              .collect(Collectors.toList())
                        );
                     }
                  }
               )
               .collect(Collectors.toList())
         );
      }

      if ((pack.getProductType() & (ProductTypeEnum.MACHINE_PART.getType() | ProductTypeEnum.ASSEMBLE.getType())) > 0) {
         List<SendDirectlyDetailDO> partSendDirectlyDetailDOS = this.packageLinkService.listPartDetailsByPackageId(id);
         List<SendDirectlyDetailDO> assembleSendDirectlyDetailDOS = this.packageLinkService.listAssembleDetailsByPackageId(id);
         partSendDirectlyDetailDOS.addAll(assembleSendDirectlyDetailDOS);
         result.setPartList(partSendDirectlyDetailDOS);
      }

      if ((pack.getProductType() & ProductTypeEnum.ENCLOSURE.getType()) > 0) {
         result.setEnclosureList(this.packageLinkService.listEnclosureDetailsByPackageId(id));
      }

      if ((pack.getProductType() & ProductTypeEnum.AUXILIARY_MATERIAL.getType()) > 0) {
         result.setAuxiliaryMaterialList(this.packageLinkService.listAuxiliaryMaterialDetailsByPackageId(id));
      }

      if (StringUtils.isNotBlank(pack.getAttachmentIds())) {
         result.setAttachmentDTOS(this.attachmentService.listByIds(pack.getAttachmentIds()));
      }

      this.handleResult(result);
      return result;
   }

   private void handleResult(PackageLinkDetailsDTO result) {
      List<PackageLinkDetailsCommonDTO> detailsList = new ArrayList<>();
      if (result.getArtifactList() != null) {
         result.getArtifactList().forEach(artifactDetailDO -> {
            PackageLinkDetailsCommonDTO commonDTO = BeanUtil.copy(artifactDetailDO, PackageLinkDetailsCommonDTO.class);
            commonDTO.setQuantity(artifactDetailDO.getQuantity());
            commonDTO.setMeasureUnit("件");
            commonDTO.setMete(artifactDetailDO.getTotalGrossWeight());
            commonDTO.setAccountingUnit("千克");
            detailsList.add(commonDTO);
         });
      }

      if (result.getPartList() != null) {
         result.getPartList().forEach(artifactDetailDO -> {
            PackageLinkDetailsCommonDTO commonDTO = BeanUtil.copy(artifactDetailDO, PackageLinkDetailsCommonDTO.class);
            commonDTO.setQuantity(artifactDetailDO.getQuantity());
            commonDTO.setMeasureUnit("件");
            commonDTO.setMete(artifactDetailDO.getTotalGrossWeight());
            commonDTO.setAccountingUnit("千克");
            detailsList.add(commonDTO);
         });
      }

      if (result.getEnclosureList() != null) {
         result.getEnclosureList()
            .forEach(
               enclosureDetailDO -> {
                  PackageLinkDetailsCommonDTO commonDTO = BeanUtil.copy(enclosureDetailDO, PackageLinkDetailsCommonDTO.class);
                  commonDTO.setSpecification(enclosureDetailDO.getPlate());
                  commonDTO.setQuantity(enclosureDetailDO.getQuantity());
                  commonDTO.setMeasureUnit("张");
                  commonDTO.setMete(
                     enclosureDetailDO.getLength().multiply(enclosureDetailDO.getPackageQuantity()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
                  );
                  commonDTO.setAccountingUnit("米");
                  detailsList.add(commonDTO);
               }
            );
      }

      if (result.getAuxiliaryMaterialList() != null) {
         result.getAuxiliaryMaterialList().forEach(auxiliary -> {
            PackageLinkDetailsCommonDTO commonDTO = BeanUtil.copy(auxiliary, PackageLinkDetailsCommonDTO.class);
            commonDTO.setPackageId(result.getId());
            commonDTO.setPackageSerialNumber(result.getSerialNumber());
            commonDTO.setMete(auxiliary.getPackageMete());
            detailsList.add(commonDTO);
         });
      }

      result.setDetailsList(detailsList);
   }

   @Override
   public ListVO<PackageLinkDetailsDTO> getDetailByProjectId(Long projectId, Integer productType) {
      List<MesBuildingPackage> list = this.packageService
         .list(
            (Wrappers.<MesBuildingPackage>lambdaQuery().eq(MesBuildingPackage::getProjectId, projectId))
               .apply(productType != null, "product_type & {0} > 0", productType)
         );
      return new ListVO<>(list.stream().map(item -> {
         ContractProject project = this.contractProjectService.getById(item.getProjectId());
         ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
         PackageDTO packageDTO = BeanUtil.copy(item, PackageDTO.class);
         BeanUtil.copy(this.getInfoByPackageId(item.getId()), packageDTO);
         packageDTO.setProject(projectInfo);
         PackageLinkDetailsDTO result = BeanUtil.copy(packageDTO, PackageLinkDetailsDTO.class);
         if (item.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            result.setArtifactList(this.packageLinkService.listArtifactDetailsByPackageId(item.getId()));
         } else if (item.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            result.setEnclosureList(this.packageLinkService.listEnclosureDetailsByPackageId(item.getId()));
         } else if (item.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            result.setAuxiliaryMaterialList(this.packageLinkService.listAuxiliaryMaterialDetailsByPackageId(item.getId()));
         }

         return result;
      }).collect(Collectors.toList()));
   }

   @Override
   public PrintVO printDetailById(Long id) {
      PrintVO printVO = new PrintVO();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      MesBuildingPackage pack = this.packageService.getById(id);
      ContractProject project = this.contractProjectService.getById(pack.getProjectId());
      header.put("project", BeanUtil.copy(project, ProjectInfo.class));
      header.put("serialNumber", pack.getSerialNumber());
      header.put("packDate", pack.getCreateTime());
      header.put("userName", pack.getUserName());
      printVO.setHeader(header);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("id", id);
      jsonObject.put("type", 1);
      jsonObject.put("ftype", 2);
      printVO.setQrCode(jsonObject.toJSONString());
      List<Map<String, Object>> table = new ArrayList<>();
      PackageLinkDetailsDTO details = this.getDetailById(id);
      details.getDetailsList().forEach(de -> {
         Map<String, Object> map = BeanUtil.beanToMap(de);
         table.add(map);
      });
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public PackageDTO getPackageInfo(Long packageId) {
      MesBuildingPackage packageInfo = this.packageService.getById(packageId);
      Preconditions.checkArgument(packageInfo != null, "包信息不存在!!!");
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(projectIds), "操作失败,当前登陆人未配置可见项目!");
      Preconditions.checkArgument(projectIds.contains(packageInfo.getProjectId()), "操作失败,当前登陆人可见项目未包含该包所在项目!");
      ContractProject project = this.contractProjectService.getById(packageInfo.getProjectId());
      ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
      PackageDTO packageDTO = BeanUtil.copy(packageInfo, PackageDTO.class);
      BeanUtil.copy(this.getInfoByPackageId(packageId), packageDTO);
      packageDTO.setProject(projectInfo);
      return packageDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean savePackage(MesBuildingPackageDTOParam param) {
      ContractProject project = this.contractProjectService.packageAndCargoListcheckProjectStatus(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在!");
      this.projectUserLinkService.checkProjectUser(param.getProjectId());
      List<Long> warehouseSummaryIds = param.getPackageLinks().stream().map(MesBuildingLinkCommonDTOParam::getId).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(warehouseSummaryIds.size() == param.getPackageLinks().size(), "操作失败,数据有误!!!");
      Set<Long> warehouseIds = param.getPackageLinks().stream().map(MesBuildingLinkCommonDTOParam::getId).collect(Collectors.toSet());
      List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService.listByIds(warehouseIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(summaryList) && summaryList.size() == warehouseIds.size(), "入库记录不存在!!!");
      Preconditions.checkArgument(summaryList.stream().allMatch(e -> WarehouseTypeEnum.INTO.getType().equals(e.getType())), "入库记录不存在");
      Preconditions.checkArgument(summaryList.stream().allMatch(e -> e.getProjectId().equals(param.getProjectId())), "所选产品和当前项目不一致!!!");
      Map<Integer, List<MesBuildingWarehouseSummary>> productTypeSummaryMap = summaryList.stream()
         .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProductType));
      MesBuildingPackage pack = BeanUtil.copy(param, MesBuildingPackage.class);
      if (StrUtil.isBlank(param.getSerialNumber())) {
         Integer sum = this.packageService.countByDate(pack.getProjectId(), LocalDateTime.now());
         String number = LocalDate.now() + "-" + NumberUtil.getDigitsNumber(sum + 1, 2);
         pack.setSerialNumber(number);
      } else {
         int count = this.packageService.count(Wrappers.lambdaQuery(MesBuildingPackage.class).eq(MesBuildingPackage::getSerialNumber, param.getSerialNumber()));
         Preconditions.checkArgument(count == 0, "包单号已存在");
         pack.setSerialNumber(param.getSerialNumber());
      }

      Preconditions.checkArgument(param.getWarehouseId() == null || this.warehouseService.getById(param.getWarehouseId()) != null, "仓库不存在!");
      pack.setProductType(summaryList.stream().map(MesBuildingWarehouseSummary::getProductType).distinct().mapToInt(Integer::intValue).sum());
      pack.setProjectId(param.getProjectId());
      pack.setUserId(UserUtil.getCurrentUserId());
      pack.setUserName(UserUtil.getCurrentName());
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         List<Attachment> attachments = this.attachmentService.listByIds(param.getAttachmentIds());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(attachments) && param.getAttachmentIds().size() == attachments.size(), "操作失败,附件不存在");
         pack.setAttachmentIds(param.getAttachmentIds().stream().map(Object::toString).collect(Collectors.joining(",")));
      }

      this.packageService.save(pack);
      this.checkSavedWarehouse(project.getBoolRequiredWarehouse(), param.getPackageLinks(), productTypeSummaryMap);
      this.setPackageLink(pack.getId(), null, param.getPackageLinks(), productTypeSummaryMap);
      this.mesBuildingCalcMaxNumManager
         .calculateMaximumCars(param.getPackageLinks().stream().map(e -> BeanUtil.copy(e, MesBuildingCalcuDTOParam.class)).collect(Collectors.toList()));
      return true;
   }

   private void checkSavedWarehouse(
      Boolean boolRequiredWarehouse, List<MesBuildingLinkDTOParam> packageLinks, Map<Integer, List<MesBuildingWarehouseSummary>> productTypeSummaryMap
   ) {
      if (boolRequiredWarehouse) {
         List<Long> artifactWareSummaryIds = packageLinks.stream()
            .filter(s -> s.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()))
            .map(MesBuildingLinkCommonDTOParam::getId)
            .collect(Collectors.toList());
         if (!artifactWareSummaryIds.isEmpty()) {
            Map<Long, Integer> wareSummaryIdSavedQuantityMap = this.warehouseStorageProductService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class)
                     .in(MesBuildingWarehouseStorageProduct::getWarehouseSummaryId, artifactWareSummaryIds)
               )
               .stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingWarehouseStorageProduct::getWarehouseSummaryId, Collectors.summingInt(MesBuildingWarehouseStorageProduct::getQuantity)
                  )
               );
            Map<Long, MesBuildingWarehouseSummary> artifactWarehouseSummaryMap = productTypeSummaryMap.getOrDefault(
                  ProductTypeEnum.ARTIFACT.getType(), Collections.emptyList()
               )
               .stream()
               .collect(Collectors.toMap(MesBuildingWarehouseSummary::getId, Function.identity()));
            packageLinks.forEach(
               param -> {
                  if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     MesBuildingWarehouseSummary summary = artifactWarehouseSummaryMap.get(param.getId());
                     Preconditions.checkArgument(summary != null, "构件入库记录不存在!!");
                     Integer savedQuantity = wareSummaryIdSavedQuantityMap.getOrDefault(param.getId(), 0);
                     Preconditions.checkArgument(
                        summary.getPackageQuantity().intValue() + summary.getCargoQuantity().intValue() + param.getQuantity().intValue() <= savedQuantity,
                        "构件打包数超出库位库存数!"
                     );
                  }
               }
            );
         }
      }
   }

   private void setPackageLink(
      Long packageId, Integer productType, List<MesBuildingLinkDTOParam> packageLinks, Map<Integer, List<MesBuildingWarehouseSummary>> productTypeSummaryMap
   ) {
      packageLinks = this.mesBuildingCalcMaxNumManager.checkPackNumberAndBuild(packageLinks, productTypeSummaryMap);
      List<MesBuildingLinkDTOParam> linkDTOParamList = packageLinks.stream()
         .filter(e -> ProductTypeEnum.ARTIFACT.getType().equals(e.getProductType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(linkDTOParamList)) {
         HashMap<Long, List<Integer>> productMap = new HashMap<>();
         linkDTOParamList.forEach(s -> {
            List var10000 = productMap.put(s.getId(), s.getNumberList());
         });
         List<ArtNotRectifiedInfo> notRectifiedInfo = this.qhseService.findProductNotRectifiedInfo(productMap);
         if (CollectionUtils.isNotEmpty(notRectifiedInfo)) {
            StringBuilder builder = new StringBuilder();
            notRectifiedInfo.stream().forEach(e -> builder.append("[编号" + e.getSerialNumber() + ",码号:" + e.getNumber() + "]"));
            Preconditions.checkArgument(false, "构件" + builder.toString() + "存在特殊质量问题，无法装车");
         }
      }

      packageLinks.forEach(
         item -> {
            Preconditions.checkArgument(
               CollectionUtils.isEmpty(item.getNumberList()) || item.getNumberList().size() == item.getQuantity().intValue(), "一物一码号出现错误!"
            );
            MesBuildingWarehouseSummary summary = this.warehouseSummaryService.updateQuantity(item.getId(), item.getQuantity(), item.getProductType(), 1);
            this.utilsBiz.checkProductAbnormalstatus(summary.getProductType(), summary.getProductId());
            MesBuildingPackageLink packageLink = this.packageLinkService
               .getOne(
                  (Wrapper<MesBuildingPackageLink>)(Wrappers.<MesBuildingPackageLink>lambdaQuery().eq(MesBuildingPackageLink::getPackageId, packageId))
                     .eq(MesBuildingPackageLink::getWarehouseRecordId, item.getId())
               );
            if (packageLink == null) {
               packageLink = MesBuildingPackageLink.builder()
                  .packageId(packageId)
                  .productType(summary.getProductType())
                  .productId(summary.getProductId())
                  .quantity(item.getQuantity())
                  .warehouseRecordId(summary.getId())
                  .warehouseType(summary.getWarehouseType())
                  .monomerId(summary.getMonomerId())
                  .projectId(summary.getProjectId())
                  .areaId(summary.getAreaId())
                  .areaBatchId(summary.getAreaBatchId())
                  .workshopId(summary.getWorkshopId())
                  .planId(summary.getPlanId())
                  .createUserNames(UserUtil.getCurrentName())
                  .build();
               this.packageLinkService.save(packageLink);
               if (CollectionUtils.isNotEmpty(item.getNumberList())
                  && ((ProductTypeEnum.ARTIFACT.getType() | ProductTypeEnum.ASSEMBLE.getType()) & summary.getProductType()) > 0) {
                  this.savePackageLinkNumber(packageId, packageLink, summary.getProductId(), summary.getProductType(), item.getNumberList());
               }
            } else {
               String createUserNames = packageLink.getCreateUserNames();
               Set<String> newCreateUserNameList = new HashSet<>(Collections.singletonList(UserUtil.getCurrentName()));
               if (StringUtils.isNotBlank(createUserNames)) {
                  List<String> createUserNameList = Arrays.asList(createUserNames.split(","));
                  newCreateUserNameList.addAll(createUserNameList);
               }

               packageLink.setCreateUserNames(newCreateUserNameList.stream().map(Object::toString).collect(Collectors.joining(",")));
               packageLink.setQuantity(packageLink.getQuantity().add(item.getQuantity()));
               this.packageLinkService.updateById(packageLink);
               if (CollectionUtils.isNotEmpty(item.getNumberList())
                  && ((ProductTypeEnum.ARTIFACT.getType() | ProductTypeEnum.ASSEMBLE.getType()) & summary.getProductType()) > 0) {
                  this.savePackageLinkNumber(packageId, packageLink, summary.getProductId(), summary.getProductType(), item.getNumberList());
               }
            }
         }
      );
   }

   private void savePackageLinkNumber(Long packageId, MesBuildingPackageLink packageLink, Long productId, Integer productType, List<Integer> numberList) {
      numberList.forEach(
         e -> {
            this.packageNumberLinkBiz
               .save(
                  MesBuildingPackageNumberLink.builder()
                     .packageLinkId(packageLink.getId())
                     .packageId(packageId)
                     .productId(productId)
                     .productType(productType)
                     .number(e)
                     .warehouseType(packageLink.getWarehouseType())
                     .userName(UserUtil.getCurrentName())
                     .build()
               );
            this.warehouseRecordService
               .update(
                  (Wrapper<MesBuildingWarehouseRecord>)(((((Wrappers.<MesBuildingWarehouseRecord>lambdaUpdate()
                                    .eq(MesBuildingWarehouseRecord::getProductId, packageLink.getProductId()))
                                 .eq(MesBuildingWarehouseRecord::getProductType, productType))
                              .eq(MesBuildingWarehouseRecord::getNumber, e))
                           .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType()))
                        .eq(MesBuildingWarehouseRecord::getWarehouseType, packageLink.getWarehouseType()))
                     .set(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.PACKAGING.getType())
               );
         }
      );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addPackage(MesBuildingPackageAddDTOParam param) {
      AtomicReference<Integer> productType = new AtomicReference<>(0);
      MesBuildingPackage pack = this.packageService.getById(param.getId());
      Preconditions.checkArgument(pack != null, "操作失败：未查询到相关包记录");
      ContractProject project = this.contractProjectService.checkProjectStatus(pack.getProjectId());
      this.projectUserLinkService.checkProjectUser(pack.getProjectId());
      Preconditions.checkArgument(pack.getStatus().equals(PackageStatusEnum.UNLOADING.getType()), "已装车，无法操作该包");
      Set<Long> warehouseIds = param.getPackageLinks().stream().map(MesBuildingLinkCommonDTOParam::getId).collect(Collectors.toSet());
      List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService.listByIds(warehouseIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(summaryList) && summaryList.size() == warehouseIds.size(), "入库记录不存在!!!");
      summaryList.forEach(e -> {
         Preconditions.checkArgument(e.getProjectId().equals(pack.getProjectId()), "所选产品和当前项目不一致!!!");
         productType.updateAndGet(v -> v | e.getProductType());
      });
      Preconditions.checkArgument(param.getWarehouseId() == null || this.warehouseService.getById(param.getWarehouseId()) != null, "仓库不存在!");
      pack.setProductType(pack.getProductType() | productType.get());
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         List<Attachment> attachments = this.attachmentService.listByIds(param.getAttachmentIds());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(attachments) && param.getAttachmentIds().size() == attachments.size(), "操作失败,附件不存在");
         pack.setAttachmentIds(param.getAttachmentIds().stream().map(Object::toString).collect(Collectors.joining(",")));
      }

      this.packageService.updateById(pack);
      Map<Integer, List<MesBuildingWarehouseSummary>> productTypeSummaryMap = summaryList.stream()
         .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProductType));
      this.checkSavedWarehouse(project.getBoolRequiredWarehouse(), param.getPackageLinks(), productTypeSummaryMap);
      this.setPackageLink(pack.getId(), productType.get(), param.getPackageLinks(), productTypeSummaryMap);
      this.mesBuildingCalcMaxNumManager
         .calculateMaximumCars(param.getPackageLinks().stream().map(e -> BeanUtil.copy(e, MesBuildingCalcuDTOParam.class)).collect(Collectors.toList()));
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updatePackage(MesBuildingPackageUpdateDTOParam param) {
      AtomicReference<Integer> productType = new AtomicReference<>(0);
      MesBuildingPackage pack = this.packageService.getById(param.getId());
      Preconditions.checkArgument(pack != null, "无该包记录");
      ContractProject project = this.contractProjectService.checkProjectStatus(pack.getProjectId());
      this.projectUserLinkService.checkProjectUser(pack.getProjectId());
      Preconditions.checkArgument(pack.getStatus().equals(PackageStatusEnum.UNLOADING.getType()), "已装车，无法操作该包");
      Set<Long> warehouseIds = param.getPackageLinks().stream().map(MesBuildingLinkCommonDTOParam::getId).collect(Collectors.toSet());
      List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService.listByIds(warehouseIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(summaryList) && summaryList.size() == warehouseIds.size(), "入库记录不存在!!!");
      summaryList.forEach(e -> {
         Preconditions.checkArgument(e.getProjectId().equals(pack.getProjectId()), "所选产品和当前项目不一致!!!");
         productType.updateAndGet(v -> v | e.getProductType());
      });
      Preconditions.checkArgument((pack.getProductType() & productType.get()) > 0, "操作失败,追加的产品类型不一致!!!");
      Preconditions.checkArgument(param.getWarehouseId() == null || this.warehouseService.getById(param.getWarehouseId()) != null, "仓库不存在!");
      pack.setWarehouseId(param.getWarehouseId());
      pack.setRemark(param.getRemark());
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         List<Attachment> attachments = this.attachmentService.listByIds(param.getAttachmentIds());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(attachments) && param.getAttachmentIds().size() == attachments.size(), "操作失败,附件不存在");
         pack.setAttachmentIds(param.getAttachmentIds().stream().map(Object::toString).collect(Collectors.joining(",")));
      }

      this.packageService.updateById(pack);
      this.removePackLink(param.getId());
      Map<Integer, List<MesBuildingWarehouseSummary>> productTypeSummaryMap = summaryList.stream()
         .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProductType));
      this.checkSavedWarehouse(project.getBoolRequiredWarehouse(), param.getPackageLinks(), productTypeSummaryMap);
      this.setPackageLink(pack.getId(), productType.get(), param.getPackageLinks(), productTypeSummaryMap);
      return true;
   }

   private void removePackLink(Long packId) {
      List<MesBuildingPackageLink> packageLinkList = this.packageLinkService
         .list((Wrapper<MesBuildingPackageLink>)Wrappers.<MesBuildingPackageLink>lambdaQuery().eq(MesBuildingPackageLink::getPackageId, packId));
      packageLinkList.forEach(
         e -> {
            this.warehouseSummaryService.updateQuantity(e.getWarehouseRecordId(), e.getQuantity().negate(), null, 1);
            this.packageNumberLinkBiz
               .list((Wrapper<MesBuildingPackageNumberLink>)Wrappers.<MesBuildingPackageNumberLink>lambdaQuery().eq(MesBuildingPackageNumberLink::getPackageId, packId))
               .forEach(
                  item -> {
                     MesBuildingPackageLink packageLink = this.packageLinkService.getById(item.getPackageLinkId());
                     this.warehouseRecordService
                        .update(
                           (Wrapper<MesBuildingWarehouseRecord>)((((Wrappers.<MesBuildingWarehouseRecord>lambdaUpdate()
                                          .eq(MesBuildingWarehouseRecord::getProductId, packageLink.getProductId()))
                                       .eq(MesBuildingWarehouseRecord::getProductType, item.getProductType()))
                                    .eq(MesBuildingWarehouseRecord::getNumber, item.getNumber()))
                                 .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType()))
                              .set(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
                        );
                     this.packageNumberLinkBiz.removeById(item.getId());
                  }
               );
            this.packageLinkService.removeById(e.getId());
         }
      );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deletePackage(List<Long> ids) {
      ids.forEach(id -> {
         MesBuildingPackage pack = this.packageService.getById(id);
         Preconditions.checkArgument(pack != null, "删除失败，该包不存在");
         this.contractProjectService.checkProjectStatus(pack.getProjectId());
         this.projectUserLinkService.checkProjectUser(pack.getProjectId());
         Preconditions.checkArgument(pack.getStatus().equals(PackageStatusEnum.UNLOADING.getType()), "已装车，无法操作该包");
         if (StringUtils.isNotBlank(pack.getAttachmentIds())) {
            this.attachmentService.deleteIds(pack.getAttachmentIds());
         }

         this.packageService.removeById(id);
         this.removePackLink(id);
      });
      return Boolean.TRUE;
   }

   @Override
   public ProductSumInfoDTO getInfoByPackageId(Long packageId) {
      List<MesBuildingPackageLink> links = this.packageLinkService
         .list((Wrapper<MesBuildingPackageLink>)Wrappers.<MesBuildingPackageLink>lambdaQuery().eq(MesBuildingPackageLink::getPackageId, packageId));
      List<ProductSumInfoDTO> collect = links.stream()
         .map(link -> this.mesProductBiz.getInfoByProduct(link.getProductId(), link.getProductType(), link.getQuantity()))
         .collect(Collectors.toList());
      return ProductSumInfoDTO.builder()
         .mete(collect.stream().map(ProductSumInfoDTO::getMete).reduce(BigDecimal.ZERO, BigDecimal::add))
         .productType(collect.stream().map(ProductSumInfoDTO::getProductType).reduce(0, (a, b) -> a | b))
         .quantity(collect.stream().map(ProductSumInfoDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add))
         .totalNetWeight(collect.stream().map(ProductSumInfoDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .totalGrossWeight(collect.stream().map(ProductSumInfoDTO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .enclLength(collect.stream().map(ProductSumInfoDTO::getEnclLength).reduce(BigDecimal.ZERO, BigDecimal::add))
         .build();
   }
}
