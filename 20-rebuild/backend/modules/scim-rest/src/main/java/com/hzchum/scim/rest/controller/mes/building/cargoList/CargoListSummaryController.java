package com.hzchum.scim.rest.controller.mes.building.cargoList;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz._package.MesBuildingPackageBiz;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz;
import com.hzchum.scim.mes.building.core.api.biz.product.MesProductBiz;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.PackageDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.pojo._doParam._package.MesBuildingPackageDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto._package.PackageDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto._package.PackageLinkDetailsCommonDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto._package.PackageLinkDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListShipDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProductSumInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListShipDTOParam;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES发运-装车-发运统计")
@RestController
@RequestMapping("/api/mes/building/cargo")
public class CargoListSummaryController {
   private static final Logger log = LoggerFactory.getLogger(CargoListSummaryController.class);
   @Autowired
   private MesBuildingCargoListBiz cargoListBiz;
   @Autowired
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingPackageLinkService packageLinkService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private MesProductBiz mesProductBiz;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private MesBuildingPackageBiz packageBiz;

   @ApiOperation("(构件)发运统计-查询项目打包列表")
   @GetMapping("/project/detail/artifact/package")
   public ResultVO<PageVO<PackageDTO>> listProjectArtifactPackage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Boolean boolShip,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:查看项目打包列表");
      MesBuildingPackageDOParam param = MesBuildingPackageDOParam.builder()
         .projectId(projectId)
         .monomerId(monomerId)
         .areaId(areaId)
         .serialNumber(serialNumber)
         .productType(ProductTypeEnum.ARTIFACT.getType())
         .boolShip(boolShip)
         .warehouseTypeList(Arrays.asList(WarehouseTypeProductReturnEnum.NORMAL.getType(), WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()))
         .pageNumber(pageNumber)
         .pageSize(pageSize)
         .build();
      PageVO<PackageDTO> pageVO = this.packageBiz.packagePage(param);
      this.setPackage(pageVO.getContent(), ProductTypeEnum.ARTIFACT.getType());
      return ResultBuilder.success(pageVO);
   }

   private void setPackage(List<PackageDTO> packageDTOList, Integer productType) {
      if (CollectionUtils.isNotEmpty(packageDTOList)) {
         List<Long> packageIds = packageDTOList.stream().map(PackageDO::getId).collect(Collectors.toList());
         List<MesBuildingPackageLink> packageLinkList = this.packageLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingPackageLink.class)
                  .in(MesBuildingPackageLink::getPackageId, packageIds)
                  .eq(MesBuildingPackageLink::getProductType, productType)
            );
         Map<Long, BigDecimal> packageIdProductQuantityMap = packageLinkList.stream()
            .collect(
               Collectors.groupingBy(
                  MesBuildingPackageLink::getPackageId, Collectors.reducing(BigDecimal.ZERO, MesBuildingPackageLink::getQuantity, BigDecimal::add)
               )
            );
         if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
            Map<Long, TechArtifact> artifactMap = this.artifactService
               .listByIds(packageLinkList.stream().map(MesBuildingPackageLink::getProductId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
            Map<Long, BigDecimal> packageIdTotalNetWeightMap = packageLinkList.stream()
               .filter(link -> artifactMap.containsKey(link.getProductId()))
               .collect(
                  Collectors.groupingBy(
                     MesBuildingPackageLink::getPackageId,
                     Collectors.mapping(
                        s -> artifactMap.get(s.getProductId()).getNetWeight().multiply(s.getQuantity()), Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                     )
                  )
               );
            Map<Long, BigDecimal> packageIdTotalGrossWeightMap = packageLinkList.stream()
               .filter(link -> artifactMap.containsKey(link.getProductId()))
               .collect(
                  Collectors.groupingBy(
                     MesBuildingPackageLink::getPackageId,
                     Collectors.mapping(
                        s -> artifactMap.get(s.getProductId()).getGrossWeight().multiply(s.getQuantity()),
                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                     )
                  )
               );
            packageDTOList.forEach(pck -> {
               pck.setQuantity(packageIdProductQuantityMap.get(pck.getId()));
               pck.setTotalNetWeight(packageIdTotalNetWeightMap.get(pck.getId()));
               pck.setTotalGrossWeight(packageIdTotalGrossWeightMap.get(pck.getId()));
            });
         }

         if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
            Map<Long, TechEnclosure> enclosureMap = this.enclosureService
               .listByIds(packageLinkList.stream().map(MesBuildingPackageLink::getProductId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
            Map<Long, BigDecimal> packageIdTotalLengthMap = packageLinkList.stream()
               .filter(link -> enclosureMap.containsKey(link.getProductId()))
               .collect(
                  Collectors.groupingBy(
                     MesBuildingPackageLink::getPackageId,
                     Collectors.mapping(
                        s -> enclosureMap.get(s.getProductId()).getLength().multiply(s.getQuantity()), Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                     )
                  )
               );
            packageDTOList.forEach(pck -> {
               pck.setQuantity(packageIdProductQuantityMap.get(pck.getId()));
               pck.setEnclLength(packageIdTotalLengthMap.get(pck.getId()));
               pck.setTotalLength(packageIdTotalLengthMap.get(pck.getId()));
            });
         }
      }
   }

   @ApiOperation("(构件)发运统计-查询项目打包列表-打印")
   @GetMapping("/project/detail/artifact/package/print")
   public ResultVO<PrintVO<List<PackageDTO>>> listProjectArtifactPackagePrint(Long projectId, String serialNumber, Boolean boolShip) {
      log.info("Api调用:查看项目打包列表");
      MesBuildingPackageDOParam param = MesBuildingPackageDOParam.builder()
         .projectId(projectId)
         .serialNumber(serialNumber)
         .productType(ProductTypeEnum.ARTIFACT.getType())
         .boolShip(boolShip)
         .warehouseTypeList(Arrays.asList(WarehouseTypeProductReturnEnum.NORMAL.getType(), WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()))
         .pageNumber(1)
         .pageSize(1)
         .build();
      PageVO<PackageDTO> pageVO = this.packageBiz.packagePage(param);
      param.setPageSize(Math.toIntExact(pageVO.getTotalElements()));
      pageVO = this.packageBiz.packagePage(param);
      this.setPackage(pageVO.getContent(), ProductTypeEnum.ARTIFACT.getType());
      PrintVO<List<PackageDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
         Preconditions.checkArgument(projectInfo != null, "项目不存在!");
         header.put("projectName", projectInfo.getName());
         header.put("projectSerialNumber", projectInfo.getSerialNumber());
      }

      printVO.setHeader(header);
      printVO.setTable(pageVO.getContent());
      return ResultBuilder.success(printVO);
   }

   @ApiOperation("(构件)发运统计-查询项目打包-产品详情列表")
   @GetMapping("/project/detail/artifact/package/details")
   public ResultVO<PageVO<ArtifactDetailDO>> listProjectArtifactPackageDetails(
      Long packageId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:查看包内构件列表");
      return ResultBuilder.success(PageUtil.listPage(pageNumber, pageSize, this.packageBiz.getDetailById(packageId).getArtifactList()));
   }

   @ApiOperation("(构件)发运统计-项目车次记录列表")
   @GetMapping("/project/detail/artifact/trainNumber")
   public ResultVO<PageVO<CargoListShipDTO>> listProjectArtifactTrainNumber(
      Long projectId, String licensePlate, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:发运统计-项目发运记录-列表");
      CargoListShipDTOParam param = new CargoListShipDTOParam();
      param.setProjectId(projectId);
      param.setProductType(ProductTypeEnum.ARTIFACT.getType());
      param.setLicensePlate(licensePlate);
      param.setBoolContainUnShip(false);
      param.setPageNumber(pageNumber);
      param.setPageSize(pageSize);
      return ResultBuilder.success(this.cargoListBiz.pageShip(param));
   }

   @ApiOperation("(构件)发运统计-项目车次记录列表-打印")
   @GetMapping("/project/detail/artifact/trainNumber/print")
   public ResultVO<PrintVO<List<CargoListShipDTO>>> listProjectArtifactTrainNumberPrint(Long projectId, String licensePlate) {
      log.info("API调用:发运统计-项目车次记录列表-打印");
      CargoListShipDTOParam param = new CargoListShipDTOParam();
      param.setProjectId(projectId);
      param.setProductType(ProductTypeEnum.ARTIFACT.getType());
      param.setLicensePlate(licensePlate);
      param.setBoolContainUnShip(false);
      param.setPageNumber(1);
      param.setPageSize(1);
      PageVO<CargoListShipDTO> pageVO = this.cargoListBiz.pageShip(param);
      param.setPageSize(Math.toIntExact(pageVO.getTotalElements()));
      pageVO = this.cargoListBiz.pageShip(param);
      List<CargoListShipDTO> cargoListShipDTOList = pageVO.getContent();
      PrintVO<List<CargoListShipDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
         Preconditions.checkArgument(projectInfo != null, "项目不存在!");
         header.put("projectName", projectInfo.getName());
         header.put("projectSerialNumber", projectInfo.getSerialNumber());
      }

      printVO.setHeader(header);
      printVO.setTable(cargoListShipDTOList);
      return ResultBuilder.success(printVO);
   }

   private void setDirectPackageTotals(List<PackageDTO> packages) {
      if (CollectionUtils.isEmpty(packages)) {
         return;
      }

      int partType = ProductTypeEnum.MACHINE_PART.getType();
      int assembleType = ProductTypeEnum.ASSEMBLE.getType();
      int directMask = partType | assembleType;
      // The package service already totals every product in each package. Only mixed packages need a narrower total.
      List<PackageDTO> mixed = packages.stream()
         .filter(pack -> pack.getProductType() != null && (pack.getProductType() & ~directMask) != 0)
         .collect(Collectors.toList());
      if (mixed.isEmpty()) {
         return;
      }

      List<Long> ids = mixed.stream().map(PackageDO::getId).collect(Collectors.toList());
      Map<Long, List<ProductSumInfoDTO>> directProducts = this.packageLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingPackageLink.class)
               .in(MesBuildingPackageLink::getPackageId, ids)
               .in(MesBuildingPackageLink::getProductType, partType, assembleType)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingPackageLink::getPackageId,
               Collectors.mapping(link -> this.mesProductBiz.getInfoByProduct(link.getProductId(), link.getProductType(), link.getQuantity()),
                  Collectors.toList())
            )
         );
      mixed.forEach(pack -> {
         List<ProductSumInfoDTO> totals = directProducts.getOrDefault(pack.getId(), Collections.emptyList());
         pack.setQuantity(totals.stream().map(ProductSumInfoDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add));
         pack.setTotalNetWeight(totals.stream().map(ProductSumInfoDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
         pack.setTotalGrossWeight(totals.stream().map(ProductSumInfoDTO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
      });
   }

   @ApiOperation("(直发件)发运统计-查询项目打包列表")
   @GetMapping("/project/detail/directShipment/package")
   public ResultVO<PageVO<PackageDTO>> listProjectPartPackage(
      Long projectId,
      String serialNumber,
      Boolean boolShip,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:查看项目打包列表");
      MesBuildingPackageDOParam param = MesBuildingPackageDOParam.builder()
         .projectId(projectId)
         .serialNumber(serialNumber)
         .productType(ProductTypeEnum.MACHINE_PART.getType())
         .boolShip(boolShip)
         .pageNumber(pageNumber)
         .pageSize(pageSize)
         .build();
      PageVO<PackageDTO> pageVO = this.packageBiz.packagePage(param);
      this.setDirectPackageTotals(pageVO.getContent());
      return ResultBuilder.success(pageVO);
   }

   @ApiOperation("(直发件)发运统计-查询项目打包列表-打印")
   @GetMapping("/project/detail/directShipment/package/print")
   public ResultVO<PrintVO<List<PackageDTO>>> listProjectPartPackagePrint(Long projectId, String serialNumber, Boolean boolShip) {
      log.info("Api调用:(直发件)发运统计-查询项目打包列表-打印");
      MesBuildingPackageDOParam param = MesBuildingPackageDOParam.builder()
         .projectId(projectId)
         .serialNumber(serialNumber)
         .productType(ProductTypeEnum.MACHINE_PART.getType())
         .boolShip(boolShip)
         .pageNumber(1)
         .pageSize(1)
         .build();
      PageVO<PackageDTO> pageVO = this.packageBiz.packagePage(param);
      param.setPageSize(Math.toIntExact(pageVO.getTotalElements()));
      pageVO = this.packageBiz.packagePage(param);
      List<PackageDTO> packageDTOList = pageVO.getContent();
      this.setDirectPackageTotals(pageVO.getContent());
      PrintVO<List<PackageDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
         Preconditions.checkArgument(projectInfo != null, "项目不存在!");
         header.put("projectName", projectInfo.getName());
         header.put("projectSerialNumber", projectInfo.getSerialNumber());
      }

      printVO.setHeader(header);
      printVO.setTable(packageDTOList);
      return ResultBuilder.success(printVO);
   }

   @ApiOperation("(直发件)发运统计-查询项目打包-产品详情列表")
   @GetMapping("/project/detail/directShipment/package/details")
   public ResultVO<ListVO<SendDirectlyDetailDO>> listProjectPartPackageDetails(Long packageId) {
      log.info("Api调用:查看包内构件列表");
      return ResultBuilder.success(new ListVO<>(this.packageBiz.getDetailById(packageId).getPartList()));
   }

   @ApiOperation("(直发件)发运统计-项目车次记录列表")
   @GetMapping("/project/detail/directShipment/trainNumber")
   public ResultVO<PageVO<CargoListShipDTO>> listProjectPartTrainNumber(
      Long projectId, String licensePlate, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      CargoListShipDTOParam param = new CargoListShipDTOParam();
      param.setProjectId(projectId);
      param.setProductType(ProductTypeEnum.MACHINE_PART.getType());
      param.setLicensePlate(licensePlate);
      param.setBoolContainUnShip(false);
      param.setPageNumber(pageNumber);
      param.setPageSize(pageSize);
      log.info("API 调用 ：发运记录-列表");
      return ResultBuilder.success(this.cargoListBiz.pageShip(param));
   }

   @ApiOperation("(直发件)发运统计-项目车次记录列表")
   @GetMapping("/project/detail/directShipment/trainNumber/print")
   public ResultVO<PrintVO<List<CargoListShipDTO>>> listProjectPartTrainNumber(Long projectId, String licensePlate) {
      log.info("API调用:(直发件)发运统计-项目车次记录列表-打印");
      CargoListShipDTOParam param = new CargoListShipDTOParam();
      param.setProjectId(projectId);
      param.setProductType(ProductTypeEnum.MACHINE_PART.getType());
      param.setLicensePlate(licensePlate);
      param.setBoolContainUnShip(false);
      param.setPageNumber(1);
      param.setPageSize(1);
      PageVO<CargoListShipDTO> pageVO = this.cargoListBiz.pageShip(param);
      param.setPageSize(Math.toIntExact(pageVO.getTotalElements()));
      pageVO = this.cargoListBiz.pageShip(param);
      List<CargoListShipDTO> cargoListShipDTOList = pageVO.getContent();
      PrintVO<List<CargoListShipDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
         Preconditions.checkArgument(projectInfo != null, "项目不存在!");
         header.put("projectName", projectInfo.getName());
         header.put("projectSerialNumber", projectInfo.getSerialNumber());
      }

      printVO.setHeader(header);
      printVO.setTable(cargoListShipDTOList);
      return ResultBuilder.success(printVO);
   }

   @ApiOperation("(围护)发运统计-查询项目打包列表")
   @GetMapping("/project/detail/enclosure/package")
   public ResultVO<PageVO<PackageDTO>> listProjectEnclosurePackage(
      Long projectId,
      String serialNumber,
      Boolean boolShip,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:查看项目打包列表");
      MesBuildingPackageDOParam param = MesBuildingPackageDOParam.builder()
         .projectId(projectId)
         .serialNumber(serialNumber)
         .productType(ProductTypeEnum.ENCLOSURE.getType())
         .boolShip(boolShip)
         .pageNumber(pageNumber)
         .pageSize(pageSize)
         .build();
      PageVO<PackageDTO> pageVO = this.packageBiz.packagePage(param);
      this.setPackage(pageVO.getContent(), ProductTypeEnum.ENCLOSURE.getType());
      return ResultBuilder.success(pageVO);
   }

   @ApiOperation("(围护)发运统计-查询项目打包列表-打印")
   @GetMapping("/project/detail/enclosure/package/print")
   public ResultVO<PrintVO<List<PackageDTO>>> listProjectEnclosurePackagePrint(Long projectId, String serialNumber, Boolean boolShip) {
      log.info("Api调用:(围护)发运统计-查询项目打包列表-打印");
      MesBuildingPackageDOParam param = MesBuildingPackageDOParam.builder()
         .projectId(projectId)
         .serialNumber(serialNumber)
         .productType(ProductTypeEnum.ENCLOSURE.getType())
         .boolShip(boolShip)
         .pageNumber(1)
         .pageSize(1)
         .build();
      PageVO<PackageDTO> pageVO = this.packageBiz.packagePage(param);
      param.setPageSize(Math.toIntExact(pageVO.getTotalElements()));
      pageVO = this.packageBiz.packagePage(param);
      this.setPackage(pageVO.getContent(), ProductTypeEnum.ENCLOSURE.getType());
      PrintVO<List<PackageDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
         Preconditions.checkArgument(projectInfo != null, "项目不存在!");
         header.put("projectName", projectInfo.getName());
         header.put("projectSerialNumber", projectInfo.getSerialNumber());
      }

      printVO.setHeader(header);
      printVO.setTable(pageVO.getContent());
      return ResultBuilder.success(printVO);
   }

   @ApiOperation("(围护)发运统计-查询项目打包-产品详情列表")
   @GetMapping("/project/detail/enclosure/package/details")
   public ResultVO<PageVO<EnclosureDetailDO>> listProjectEnclosurePackageDetails(
      Long packageId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:查看包内构件列表");
      List<EnclosureDetailDO> enclosureList = this.packageBiz.getDetailById(packageId).getEnclosureList();
      return ResultBuilder.success(PageUtil.listPage(pageNumber, pageSize, enclosureList));
   }

   @ApiOperation("(围护)发运统计-项目车次记录列表")
   @GetMapping("/project/detail/enclosure/trainNumber")
   public ResultVO<PageVO<CargoListShipDTO>> listProjectEnclosureTrainNumber(
      Long projectId, String licensePlate, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      CargoListShipDTOParam param = new CargoListShipDTOParam();
      param.setProjectId(projectId);
      param.setProductType(ProductTypeEnum.ENCLOSURE.getType());
      param.setLicensePlate(licensePlate);
      param.setBoolContainUnShip(false);
      param.setPageNumber(pageNumber);
      param.setPageSize(pageSize);
      log.info("API 调用 ：发运记录-列表");
      PageVO<CargoListShipDTO> shipDTOPageVO = this.cargoListBiz.pageShip(param);
      this.setCargoListInfo(shipDTOPageVO.getContent(), ProductTypeEnum.ENCLOSURE.getType());
      return ResultBuilder.success(shipDTOPageVO);
   }

   private void setCargoListInfo(List<CargoListShipDTO> cargoListShipDTOList, Integer productType) {
      if (CollectionUtils.isNotEmpty(cargoListShipDTOList)) {
         List<Long> cargoIds = cargoListShipDTOList.stream().map(CargoListShipDTO::getId).collect(Collectors.toList());
         List<MesBuildingCargoListProductLink> cargoListProductLinks = this.cargoListProductLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class)
                  .in(MesBuildingCargoListProductLink::getCargoListId, cargoIds)
                  .eq(MesBuildingCargoListProductLink::getProductType, productType)
            );
         Map<Long, TechEnclosure> enclosureMap = this.enclosureService
            .listByIds(cargoListProductLinks.stream().map(MesBuildingCargoListProductLink::getProductId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
         Map<Long, BigDecimal> cargoListIdTotalLengthMap = cargoListProductLinks.stream()
            .filter(link -> enclosureMap.containsKey(link.getProductId()))
            .collect(
               Collectors.groupingBy(
                  MesBuildingCargoListProductLink::getCargoListId,
                  Collectors.mapping(
                     s -> enclosureMap.get(s.getProductId()).getLength().multiply(s.getQuantity()), Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                  )
               )
            );
         cargoListShipDTOList.forEach(s -> s.setTotalLength(cargoListIdTotalLengthMap.get(s.getId())));
      }
   }

   @ApiOperation("(围护)发运统计-项目车次记录列表-打印")
   @GetMapping("/project/detail/enclosure/trainNumber/print")
   public ResultVO<PrintVO<List<CargoListShipDTO>>> listProjectEnclosureTrainNumberPrint(Long projectId, String licensePlate) {
      log.info("API调用:(围护)发运统计-项目车次记录列表-打印");
      CargoListShipDTOParam param = new CargoListShipDTOParam();
      param.setProjectId(projectId);
      param.setProductType(ProductTypeEnum.ENCLOSURE.getType());
      param.setLicensePlate(licensePlate);
      param.setBoolContainUnShip(false);
      param.setPageNumber(1);
      param.setPageSize(1);
      PageVO<CargoListShipDTO> pageVO = this.cargoListBiz.pageShip(param);
      param.setPageSize(Math.toIntExact(pageVO.getTotalElements()));
      pageVO = this.cargoListBiz.pageShip(param);
      PrintVO<List<CargoListShipDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
         Preconditions.checkArgument(projectInfo != null, "项目不存在!");
         header.put("projectName", projectInfo.getName());
         header.put("projectSerialNumber", projectInfo.getSerialNumber());
      }

      printVO.setHeader(header);
      this.setCargoListInfo(pageVO.getContent(), ProductTypeEnum.ENCLOSURE.getType());
      printVO.setTable(pageVO.getContent());
      return ResultBuilder.success(printVO);
   }

   @ApiOperation("(配套件)发运统计-打包产品明细")
   @GetMapping("/project/cargoList/auxiliary/package/details")
   @PreAuthorize("@permission.check('aux_ship_summary:get')")
   public ResultVO<ListVO<PackageLinkDetailsCommonDTO>> getAuxiliaryPackageList(@RequestParam(required = false) List<Long> packageIdList) {
      if (CollectionUtils.isEmpty(packageIdList)) {
         return ResultBuilder.success(new ListVO<>());
      }

      List<PackageLinkDetailsCommonDTO> packageLinkDetailsCommonDTOList = new ArrayList<>();
      packageIdList.forEach(packageId -> {
         PackageLinkDetailsDTO packageLinkDetailsDTO = this.packageBiz.getDetailById(packageId);
         packageLinkDetailsCommonDTOList.addAll(packageLinkDetailsDTO.getDetailsList());
      });
      return ResultBuilder.success(new ListVO<>(packageLinkDetailsCommonDTOList));
   }
}
