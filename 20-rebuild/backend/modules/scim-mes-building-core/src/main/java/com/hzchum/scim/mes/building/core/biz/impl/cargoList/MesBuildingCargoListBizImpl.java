package com.hzchum.scim.mes.building.core.biz.impl.cargoList;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.NumberUtil;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.business.core.api.enums.EnclosurePricingMannerEnum;
import com.hzchum.scim.business.core.api.enums.PricingUnitTypeEnum;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessMachinePart;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import com.hzchum.scim.business.core.api.service.BusinessMachinePartService;
import com.hzchum.scim.business.core.api.service.BusinessStandardPartService;
import com.hzchum.scim.business.core.api.utils.BusinessPriceUtils;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.WeightTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.common.core.api.pojo.common.CargoListProductLinkPriceDTO;
import com.hzchum.scim.common.core.api.pojo.common.EnclosureBaseInfo;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.TechStandardPartBaseInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.CheckDTOParam;
import com.hzchum.scim.common.core.api.pojo.dto.MesBuildingLinkCommonDTOParam;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.common.AddressUtil;
import com.hzchum.scim.contract.core.api.enums.EnclosureMeasureModeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectAddressTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectBoolArrearsEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.enums.StructureMeasureModeEnum;
import com.hzchum.scim.contract.core.api.enums.TransportTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractTech;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.mes.building.core.api.biz._package.MesBuildingPackageBiz;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz;
import com.hzchum.scim.mes.building.core.api.biz.product.MesProductBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.PricingMannerEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListReceiptTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListShipEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ChangeFreightEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.PackageStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.ShipmentStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.SupplierPriceTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.manager.MesBuildingCalcMaxNumManager;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.PackageDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.TechStandardPartDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactShipMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.CargoListDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.EnclosureShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.EnclosureShipMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.PartSendShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.PartShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ProjectCargoListEnclosureMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.SupplierPriceInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.TechStandardPartShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.YearCargoListMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.ArtifactStockNumberDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackage;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListAddress;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListChange;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingSupplierPrice;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingSupplierPriceCarLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWarehouse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseStorageProduct;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.cargoList.CargoListDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ArtifactByCargoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.AuditInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoDayOrMonthSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListArtifactTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListDetailsCommonDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListEnclosureTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListLogisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListMeteByMonomerAndAreaDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListMeteGroupMonthDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListProductLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListReceiptDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListReviewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListShipDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListSupplierDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoLogisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.MesBuildingCargoListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.OverweightSMSUserDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProductSumInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListAuxiliaryDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListEnclosureDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListEnclosureMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListMeteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListSumDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListSumEnclosureDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.UserCheckDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.YearCargoListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.YearCargoListMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.ArtNotRectifiedInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.AppCargoListDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListCheckDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListLogisticsDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListLogisticsInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListPriceChangeDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListReceiptDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListReviewDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListShipDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListStatisticsQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListWeighSMSDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.MesBuildingCalcuDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.AppEmptyCarsWeighingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.CargoListPackConcertDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.CargoListProductConcertDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.CargoListProductDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListLogisticsUpdateDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListReceiptUpdateDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListUpdateConcertDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update.CargoListUpdateDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageLinkService;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListAddressService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListChangeService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingSupplierPriceCarLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingSupplierPriceService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWarehouseService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseStorageProductService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.biz.ProductBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.pojo.dto.product.TechProductDTO;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.project.core.api.biz.ProjectReceivingBiz;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.SmsUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import com.hzchum.scim.system.core.api.pojo.dto.UserCheckVO;
import com.hzchum.scim.system.core.api.pojo.dto.WeighSMSConfigDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.manager.OutboundManufacturedMesManager;
import com.hzchum.scim.wms.core.api.manager.ReturnManufacturedMesManager;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.manager.OutboundManufacturedVORequest;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.manager.ReturnManufacturedVORequest;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesBuildingCargoListBizImpl implements MesBuildingCargoListBiz {
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private ProjectUserLinkService projectUserLinkService;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Autowired
   private WarehouseBiz warehouseBiz;
   @Autowired
   private MesBuildingCargoListService cargoListService;
   @Autowired
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Autowired
   private MesBuildingPackageService packageService;
   @Autowired
   private MesBuildingPackageLinkService packageLinkService;
   @Autowired
   private MesBuildingSupplierPriceService supplierPriceService;
   @Autowired
   private MesProductBiz mesProductBiz;
   @Autowired
   private ConfigService configService;
   @Autowired
   private RedisUtils redisUtils;
   @Resource
   private SupplierService supplierService;
   @Autowired
   private MesBuildingPackageBiz packageBiz;
   @Autowired
   private ContractCollectionService collectionService;
   @Autowired
   private ContractInvoiceService invoiceService;
   @Autowired
   private SmsUtils smsUtils;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingSupplierPriceCarLinkService carLinkService;
   @Autowired
   private MesBuildingCargoListChangeService cargoListChangeService;
   @Autowired
   private UserService userService;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private MesBuildingPackageService mesBuildingPackageService;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private BusinessArtifactService businessArtifactService;
   @Resource
   private BusinessEnclosureService businessEnclosureService;
   @Resource
   private ProductBiz productBiz;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ProjectReceivingBiz projectReceivingBiz;
   @Resource
   private MesBuildingPackageNumberLinkService packageNumberLinkService;
   @Resource
   private MesBuildingCargoListProductNumberLinkService cargoListProductNumberLinkService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesBuildingWarehouseRecordService mesBuildingWarehouseRecordService;
   @Resource
   private MesBuildingWarehouseStorageProductService warehouseStorageProductService;
   @Resource
   private MesBuildingCargoListService mesBuildingCargoListService;
   @Resource
   private MesBuildingWorkshopService mesBuildingWorkshopService;
   @Resource
   private MesBuildingWarehouseService mesBuildingWarehouseService;
   @Resource
   private BusinessStandardPartService businessStandardPartService;
   @Resource
   private ContractProjectContentService projectContentService;
   @Resource
   private TechArtifactService techArtifactService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private BusinessMachinePartService businessMachinePartService;
   @Resource
   private TechStandardPartService techStandardPartService;
   @Resource
   private MesBuildingCalcMaxNumManager mesBuildingCalcMaxNumManager;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private MesBuildingQhseService qhseService;
   @Resource
   private MesBuildingCargoListAddressService cargoListAddressService;
   @Resource
   private OutboundManufacturedMesManager manufacturedMesManager;
   @Resource
   private ReturnManufacturedMesManager returnManufacturedMesManager;
   @Resource
   private BusinessPriceUtils businessPriceUtils;

   @Override
   public List<CargoListSupplierDTO> listSupplier(Long supplierPriceId) {
      MesBuildingSupplierPrice supplierPrice = this.supplierPriceService.getById(supplierPriceId);
      Preconditions.checkArgument(supplierPrice != null, "物流价格记录不存在");
      List<MesBuildingCargoList> cargoLists = this.cargoListService
         .list((Wrapper<MesBuildingCargoList>)Wrappers.<MesBuildingCargoList>lambdaQuery().eq(MesBuildingCargoList::getSupplierPriceId, supplierPriceId));
      return cargoLists.stream()
         .map(
            e -> CargoListSupplierDTO.builder()
               .auditTime(e.getAuditTime())
               .licensePlate(e.getLicensePlate())
               .productType(e.getProductType())
               .actualWeight(e.getActualWeight())
               .fare(
                  supplierPrice.getPriceType().equals(SupplierPriceTypeEnum.WEIGHT.getType())
                     ? supplierPrice.getPrice().multiply(e.getActualWeight()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
                     : supplierPrice.getPrice()
               )
               .build()
         )
         .collect(Collectors.toList());
   }

   @Override
   public BigDecimal getFareBySupplierId(Long supplierId) {
      return null;
   }

   @Override
   public CargoListDetailsDTO getDetailById(Long id) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(id);
      Preconditions.checkArgument(cargoList != null, "未查询到相关装车信息");
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new CargoListDetailsDTO();
      }

      if (!projectIds.contains(cargoList.getProjectId())) {
         return new CargoListDetailsDTO();
      }

      ContractProject project = this.contractProjectService.getById(cargoList.getProjectId());
      CargoListDetailsDTO cargoListDetail = BeanUtil.copy(cargoList, CargoListDetailsDTO.class);
      ProjectInfo projectInfo = BeanUtil.copy(project, ProjectInfo.class);
      cargoListDetail.setProject(projectInfo);
      List<Long> packageIds = this.cargoListProductLinkService
         .list(
            (Wrapper<MesBuildingCargoListProductLink>)(Wrappers.<MesBuildingCargoListProductLink>lambdaQuery().eq(MesBuildingCargoListProductLink::getCargoListId, id))
               .isNotNull(MesBuildingCargoListProductLink::getPackageId)
         )
         .stream()
         .map(MesBuildingCargoListProductLink::getPackageId)
         .collect(Collectors.toList());
      List<PackageDetailDO> packageDetails = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(packageIds)) {
         packageDetails = this.packageService.listByPackageIds(packageIds);
         if (CollectionUtils.isNotEmpty(packageDetails)) {
            Map<Long, List<MesBuildingPackageLink>> packageLinkMap = this.packageLinkService
               .list((Wrapper<MesBuildingPackageLink>)new LambdaQueryWrapper<MesBuildingPackageLink>().in(MesBuildingPackageLink::getPackageId, packageIds))
               .stream()
               .collect(Collectors.groupingBy(MesBuildingPackageLink::getPackageId));

            for (PackageDetailDO packageDetail : packageDetails) {
               List<MesBuildingPackageLink> packageLinks = packageLinkMap.getOrDefault(packageDetail.getId(), new ArrayList<>());
               packageDetail.setQuantity(packageLinks.stream().map(MesBuildingPackageLink::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add));
            }
         }
      }

      List<ArtifactDetailDO> artifacts = this.cargoListProductLinkService.listArtifactNotPackById(id);
      if (CollectionUtils.isNotEmpty(artifacts)) {
         List<Long> linkIdList = artifacts.stream().map(ArtifactBaseInfo::getLinkId).collect(Collectors.toList());
         Map<Long, List<MesBuildingCargoListProductNumberLink>> productNumberLinkMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(linkIdList)) {
            List<MesBuildingCargoListProductNumberLink> productNumberLinkList = this.cargoListProductNumberLinkService
               .list(
                  (Wrapper<MesBuildingCargoListProductNumberLink>)Wrappers.<MesBuildingCargoListProductNumberLink>lambdaQuery()
                     .in(MesBuildingCargoListProductNumberLink::getCargoListLinkId, linkIdList)
               );
            if (CollectionUtils.isNotEmpty(productNumberLinkList)) {
               productNumberLinkMap = productNumberLinkList.stream().collect(Collectors.groupingBy(MesBuildingCargoListProductNumberLink::getCargoListLinkId));
            }
         }

         List<Long> productIds = artifacts.stream().map(ArtifactDetailDO::getProductId).collect(Collectors.toList());
         Map<Long, List<MesBuildingWarehouseRecord>> inWarehouseRecordMap = this.mesBuildingWarehouseRecordService
            .list(
               (Wrapper<MesBuildingWarehouseRecord>)((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                        .in(MesBuildingWarehouseRecord::getProductId, productIds))
                     .eq(MesBuildingWarehouseRecord::getType, 1))
                  .eq(MesBuildingWarehouseRecord::getProductType, 2)
            )
            .stream()
            .collect(Collectors.groupingBy(MesBuildingWarehouseRecord::getProductId));
         Map<Long, List<MesBuildingCargoListProductNumberLink>> finalProductNumberLinkMap = productNumberLinkMap;
         artifacts.forEach(
            e -> {
               if (CodingTypeEnum.SINGLE.getType().equals(e.getCodingType())
                  && !e.getWarehouseType().equals(WarehouseTypeProductReturnEnum.SUBSCRIBE.getType())) {
                  e.setBoolOneCode(Boolean.TRUE);
                  List<MesBuildingCargoListProductNumberLink> numberLinks = finalProductNumberLinkMap.get(e.getLinkId());
                  List<ArtifactStockNumberDO> numberDOS = numberLinks.stream()
                     .map(item -> ArtifactStockNumberDO.builder().number(item.getNumber()).boolPackage(Boolean.TRUE).build())
                     .collect(Collectors.toList());
                  List<MesBuildingWarehouseRecord> warehouseRecords = inWarehouseRecordMap.get(e.getProductId());
                  List<Integer> numbers = numberDOS.stream().map(ArtifactStockNumberDO::getNumber).collect(Collectors.toList());
                  List<MesBuildingWarehouseRecord> warehouseRecordList = warehouseRecords.stream()
                     .filter(w -> !numbers.contains(w.getNumber()))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(warehouseRecordList)) {
                     List<ArtifactStockNumberDO> numberList = warehouseRecordList.stream()
                        .map(
                           item -> ArtifactStockNumberDO.builder()
                              .number(item.getNumber())
                              .boolPackage(WarehouseRecordStatusTypeEnum.INTO.getType() != item.getStatus())
                              .build()
                        )
                        .collect(Collectors.toList());
                     numberDOS.addAll(numberList.stream().filter(number -> !number.getBoolPackage()).collect(Collectors.toList()));
                  }

                  e.setNumberList(numberDOS);
               }
            }
         );
      }

      List<SendDirectlyDetailDO> sendDirectlyDetailDOS = this.cargoListProductLinkService.listPartNotPackById(id);
      List<SendDirectlyDetailDO> assembleDetailDOS = this.cargoListProductLinkService.listAssembleNotPackById(id);
      List<EnclosureDetailDO> enclosures = this.cargoListProductLinkService.listEnclosureNotPackById(id);
      List<TechStandardPartDetailDO> auxiliaryMaterial = this.cargoListProductLinkService.listAuxiliaryMaterialNotPackById(id);
      cargoListDetail.setArtifactList(artifacts);
      cargoListDetail.setPartList(sendDirectlyDetailDOS);
      cargoListDetail.setAssembleList(assembleDetailDOS);
      cargoListDetail.setEnclosureList(enclosures);
      cargoListDetail.setAuxiliaryMaterialList(auxiliaryMaterial);
      packageDetails.forEach(item -> {
         ProductSumInfoDTO info = this.packageBiz.getInfoByPackageId(item.getId());
         BeanUtil.copy(info, item);
      });
      cargoListDetail.setPackageList(packageDetails);
      List<AttachmentDTO> attachmentDTOS = new ArrayList<>();
      if (StringUtils.isNotBlank(cargoList.getAttachmentIds())) {
         List<Long> attachmentIds = Arrays.stream(cargoList.getAttachmentIds().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
         attachmentIds.forEach(e -> attachmentDTOS.add(this.attachmentService.getById(e)));
      }

      cargoListDetail.setAttachmentDTOS(attachmentDTOS);
      cargoListDetail.setVersion(cargoList.getVersion());
      return cargoListDetail;
   }

   @Override
   public ListVO<SendDirectlyDetailDO> getDirectlyNoCartList(Long id, Long productId) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(id);
      Preconditions.checkArgument(cargoList != null, "未查询到相关装车信息");
      List<SendDirectlyDetailDO> detailDOList = new ArrayList<>();
      Set<Long> artifactIds = new HashSet<>();
      if (productId != null) {
         artifactIds.add(productId);
      } else {
         List<ArtifactDetailDO> artifactDetailDOS = this.cargoListProductLinkService.listArtifactNotPackById(id);
         artifactIds = artifactDetailDOS.stream().map(ArtifactDetailDO::getProductId).collect(Collectors.toSet());
      }

      if (CollectionUtils.isNotEmpty(artifactIds)) {
         detailDOList.addAll(this.cargoListProductLinkService.listAssembleNotCargoListByIds(artifactIds));
         detailDOList.addAll(this.cargoListProductLinkService.listAssembleNotLoadedByIds(artifactIds));
         detailDOList.addAll(this.cargoListProductLinkService.listAssembleNotShippedLoadedByIds(artifactIds));
      }

      return new ListVO<>(detailDOList.stream().filter(e -> e.getUnPackageQuantity().compareTo(BigDecimal.ZERO) > 0).collect(Collectors.toList()));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateCargoList(CargoListUpdateDTOParam param) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(param.getId());
      Preconditions.checkArgument(cargoList != null, "发运记录不存在!!!");
      if (param.getVersion() != null) {
         Preconditions.checkArgument(param.getVersion().equals(cargoList.getVersion()), "操作失败,数据已过期,如果是多人装车,请切换自动保存模式!");
      }

      Preconditions.checkArgument(
         CargoListStatusEnum.LOADING_NO.getType().equals(cargoList.getStatus()) || CargoListStatusEnum.LOADING.getType().equals(cargoList.getStatus()),
         "只可修改未过磅前的发运记录!!!"
      );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(param.getPackageIds()) || CollectionUtils.isNotEmpty(param.getProducts()), "修改失败，未传入包id或产品id");
      List<ArtNotRectifiedInfo> notRectifiedInfo = Collections.emptyList();
      if (CollectionUtils.isNotEmpty(param.getPackageIds())) {
         notRectifiedInfo = this.qhseService.findInPackageNotRectifiedInfo(param.getPackageIds());
      }

      if (CollectionUtils.isNotEmpty(param.getProducts())) {
         HashMap<Long, List<Integer>> productMap = new HashMap<>();
         param.getProducts().forEach(e -> {
            List var10000 = productMap.put(e.getId(), e.getNumberList());
         });
         notRectifiedInfo = this.qhseService.findProductNotRectifiedInfo(productMap);
      }

      if (CollectionUtils.isNotEmpty(notRectifiedInfo)) {
         StringBuilder builder = new StringBuilder();
         notRectifiedInfo.stream().forEach(e -> builder.append("[编号" + e.getSerialNumber() + ",码号:" + e.getNumber() + "]"));
         Preconditions.checkArgument(false, "构件" + builder.toString() + "存在特殊质量问题，无法装车");
      }

      ContractProject project = this.contractProjectService.checkProjectStatus(param.getProjectId());
      this.projectUserLinkService.checkProjectUser(param.getProjectId());
      BeanUtil.copy(param, cargoList);
      this.updateCargoList(cargoList, project);
      List<ProductSumInfoDTO> infos = new ArrayList<>();
      List<MesBuildingCargoListProductLink> links = this.cargoListProductLinkService
         .list((Wrapper<MesBuildingCargoListProductLink>)Wrappers.<MesBuildingCargoListProductLink>lambdaQuery().eq(MesBuildingCargoListProductLink::getCargoListId, cargoList.getId()));
      List<MesBuildingCargoListProductLink> packLinks = links.stream().filter(e -> e.getPackageId() != null).collect(Collectors.toList());
      List<MesBuildingCargoListProductLink> productLinks = links.stream().filter(e -> e.getPackageId() == null).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(param.getPackageIds())) {
         Set<Long> saveBagIds = param.getPackageIds();
         Set<Long> oldPackIds = packLinks.stream().map(MesBuildingCargoListProductLink::getPackageId).collect(Collectors.toSet());
         List<MesBuildingCargoListProductLink> deleteLink = packLinks.stream().filter(e -> !saveBagIds.contains(e.getPackageId())).collect(Collectors.toList());
         this.remove(deleteLink, cargoList.getId());
         Set<Long> newBagIds = saveBagIds.stream().filter(id -> !oldPackIds.contains(id)).collect(Collectors.toSet());
         infos.addAll(this.savePack(newBagIds, cargoList.getId(), param.getProjectId()));
         List<MesBuildingCargoListProductLink> notChangLink = packLinks.stream()
            .filter(link -> saveBagIds.contains(link.getPackageId()))
            .collect(Collectors.toList());
         notChangLink.forEach(bag -> infos.add(this.mesProductBiz.getInfoByProduct(bag.getProductId(), bag.getProductType(), bag.getQuantity())));
      } else {
         this.remove(packLinks, cargoList.getId());
      }

      if (CollectionUtils.isNotEmpty(param.getProducts())) {
         List<CargoListProductDTOParam> saveProducts = param.getProducts();
         Set<Long> oldIds = productLinks.stream().map(MesBuildingCargoListProductLink::getWarehouseRecordId).collect(Collectors.toSet());
         List<MesBuildingCargoListProductLink> deleteLink = productLinks.stream()
            .filter(link -> saveProducts.stream().noneMatch(e -> e.getId().equals(link.getWarehouseRecordId())))
            .collect(Collectors.toList());
         this.remove(deleteLink, cargoList.getId());
         List<CargoListProductDTOParam> newProducts = saveProducts.stream().filter(product -> !oldIds.contains(product.getId())).collect(Collectors.toList());
         List<CargoListProductDTOParam> oldProducts = saveProducts.stream().filter(product -> oldIds.contains(product.getId())).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(newProducts)) {
            infos.addAll(this.saveProduct(newProducts, cargoList.getId(), param.getProjectId()));
         }

         if (CollectionUtils.isNotEmpty(oldProducts)) {
            Map<Long, MesBuildingCargoListProductLink> cargoListProductLinkMap = this.cargoListProductLinkService
               .list(
                  (Wrapper<MesBuildingCargoListProductLink>)(((Wrappers.<MesBuildingCargoListProductLink>lambdaQuery()
                              .eq(MesBuildingCargoListProductLink::getCargoListId, cargoList.getId()))
                           .eq(MesBuildingCargoListProductLink::getBoolCancelShip, Boolean.FALSE))
                        .in(
                           MesBuildingCargoListProductLink::getWarehouseRecordId,
                           oldProducts.stream().map(MesBuildingLinkCommonDTOParam::getId).collect(Collectors.toList())
                        ))
                     .isNull(MesBuildingCargoListProductLink::getPackageId)
               )
               .stream()
               .collect(Collectors.toMap(MesBuildingCargoListProductLink::getWarehouseRecordId, Function.identity()));
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(cargoListProductLinkMap) && cargoListProductLinkMap.size() == oldProducts.size());
            List<MesBuildingCargoListProductNumberLink> numberLinkList = this.cargoListProductNumberLinkService
               .list(
                  (Wrapper<MesBuildingCargoListProductNumberLink>)new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                     .in(
                        MesBuildingCargoListProductNumberLink::getCargoListLinkId,
                        cargoListProductLinkMap.values().stream().map(MesBuildingCargoListProductLink::getId).collect(Collectors.toList())
                     )
               );
            List<MesBuildingCargoListProductNumberLink> listProductNumberLinks = numberLinkList.stream()
               .filter(e -> (e.getProductType() & (ProductTypeEnum.ASSEMBLE.getType() | ProductTypeEnum.ARTIFACT.getType())) > 0)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(listProductNumberLinks)) {
               Map<Long, MesBuildingCargoListProductLink> cargoListProductLinkTwoMap = cargoListProductLinkMap.values()
                  .stream()
                  .collect(Collectors.toMap(MesBuildingCargoListProductLink::getId, Function.identity()));

               for (MesBuildingCargoListProductNumberLink numberLink : listProductNumberLinks) {
                  MesBuildingCargoListProductLink productLink = cargoListProductLinkTwoMap.get(numberLink.getCargoListLinkId());
                  this.cargoListProductNumberLinkService.removeById(numberLink.getId());
                  this.warehouseRecordService
                     .update(
                        (Wrapper<MesBuildingWarehouseRecord>)(((((Wrappers.<MesBuildingWarehouseRecord>lambdaUpdate()
                                          .eq(MesBuildingWarehouseRecord::getProductType, numberLink.getProductType()))
                                       .eq(MesBuildingWarehouseRecord::getProductId, numberLink.getProductId()))
                                    .eq(MesBuildingWarehouseRecord::getNumber, numberLink.getNumber()))
                                 .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType()))
                              .eq(MesBuildingWarehouseRecord::getWarehouseType, productLink.getWarehouseType()))
                           .set(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
                     );
               }
            }

            List<Long> warehouseSummaryIds = oldProducts.stream().map(MesBuildingLinkCommonDTOParam::getId).collect(Collectors.toList());
            List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService.listByIds(warehouseSummaryIds);
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(summaryList) && summaryList.size() == warehouseSummaryIds.size(), "入库记录不存在!!!");
            Preconditions.checkArgument(summaryList.stream().allMatch(e -> WarehouseTypeEnum.INTO.getType().equals(e.getType())), "入库记录不存在");
            Map<Integer, List<MesBuildingWarehouseSummary>> productTypeSummaryMap = summaryList.stream()
               .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProductType));
            oldProducts = this.mesBuildingCalcMaxNumManager.checkPackNumberAndBuild(oldProducts, productTypeSummaryMap);
            oldProducts.forEach(
               product -> {
                  MesBuildingCargoListProductLink link = cargoListProductLinkMap.get(product.getId());
                  if (ProductTypeEnum.ARTIFACT.getType().equals(link.getProductType()) || ProductTypeEnum.ASSEMBLE.getType().equals(link.getProductType())) {
                     product.getNumberList()
                        .forEach(
                           number -> {
                              this.cargoListProductNumberLinkService
                                 .save(
                                    MesBuildingCargoListProductNumberLink.builder()
                                       .cargoListId(cargoList.getId())
                                       .cargoListLinkId(link.getId())
                                       .productId(link.getProductId())
                                       .productType(link.getProductType())
                                       .number(number)
                                       .userName(UserUtil.getCurrentName())
                                       .build()
                                 );
                              this.warehouseRecordService
                                 .update(
                                    (Wrapper<MesBuildingWarehouseRecord>)(((((Wrappers.<MesBuildingWarehouseRecord>lambdaUpdate()
                                                      .eq(MesBuildingWarehouseRecord::getProductType, link.getProductType()))
                                                   .eq(MesBuildingWarehouseRecord::getProductId, link.getProductId()))
                                                .eq(MesBuildingWarehouseRecord::getNumber, number))
                                             .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType()))
                                          .eq(MesBuildingWarehouseRecord::getWarehouseType, link.getWarehouseType()))
                                       .set(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.CARGOLIST.getType())
                                 );
                           }
                        );
                  }

                  if (!link.getQuantity().equals(product.getQuantity())) {
                     this.warehouseSummaryService.updateQuantity(product.getId(), product.getQuantity().subtract(link.getQuantity()), link.getProductType(), 2);
                     link.setQuantity(product.getQuantity());
                     this.cargoListProductLinkService.updateById(link);
                  }

                  infos.add(this.mesProductBiz.getInfoByProduct(link.getProductId(), link.getProductType(), product.getQuantity()));
               }
            );
         }

         this.mesBuildingCalcMaxNumManager
            .calculateMaximumCars(param.getProducts().stream().map(e -> BeanUtil.copy(e, MesBuildingCalcuDTOParam.class)).collect(Collectors.toList()));
      } else {
         this.remove(productLinks, cargoList.getId());
      }

      Integer reduce = infos.stream().map(ProductSumInfoDTO::getProductType).reduce(0, (a, b) -> a | b);
      Integer relationType = infos.stream().map(ProductSumInfoDTO::getRelationType).reduce(0, (a, b) -> a | b);
      if ((reduce & ProductTypeEnum.ENCLOSURE.getType()) > 0 && (reduce & ProductTypeEnum.ARTIFACT.getType()) > 0) {
         Preconditions.checkArgument(
            cargoList.getTransportMode() != null
               && cargoList.getEnclosureTransportMode() != null
               && cargoList.getEnclosureTransportMode().equals(cargoList.getTransportMode()),
            "装车失败,围护和构件同时存在时，运输方式需一致!!!"
         );
      }

      cargoList.setProductType(reduce);
      cargoList.setRelationType(relationType);
      cargoList.setCategory(infos.stream().filter(e -> e.getCategory() != null).map(ProductSumInfoDTO::getCategory).reduce(0, (a, b) -> a | b));
      cargoList.setQuantity(infos.stream().map(ProductSumInfoDTO::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add));
      cargoList.setTotalNetWeight(infos.stream().map(ProductSumInfoDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
      cargoList.setTotalGrossWeight(infos.stream().map(ProductSumInfoDTO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
      this.cargoListService.updateById(cargoList);
      return true;
   }

   private void updateCargoList(MesBuildingCargoList cargoList, ContractProject project) {
      cargoList.setUserId(UserUtil.getCurrentUserId());
      cargoList.setUserName(UserUtil.getCurrentName());
      cargoList.setEnclosureTransportMode(project.getEnclosureTransportMode());
      cargoList.setTransportMode(project.getTransportMode());
      cargoList.setStructureMeasureMode(project.getStructureMeasureMode());
      cargoList.setEnclosureMeasureMode(project.getEnclosureMeasureMode());
      cargoList.setStatus(CargoListStatusEnum.LOADING.getType());
      cargoList.setCreateTime(LocalDateTime.now());
      String userIds = cargoList.getUserIds();
      String userNames = cargoList.getUserNames();
      if (StringUtils.isBlank(userIds)) {
         cargoList.setUserIds(UserUtil.getCurrentUserId().toString());
      } else {
         Set<String> userIdList = new HashSet<>(Arrays.asList(StringUtils.split(userIds, ",")));
         userIdList.add(UserUtil.getCurrentUserId().toString());
         cargoList.setUserIds(userIdList.stream().collect(Collectors.joining(",")));
      }

      if (StringUtils.isBlank(userNames)) {
         cargoList.setUserNames(UserUtil.getCurrentName());
      } else {
         Set<String> userNameList = new HashSet<>(Arrays.asList(StringUtils.split(userNames, ",")));
         userNameList.add(UserUtil.getCurrentName());
         cargoList.setUserNames(userNameList.stream().collect(Collectors.joining(",")));
      }

      MesBuildingCargoListAddress address = this.cargoListAddressService
         .getOne((Wrapper<MesBuildingCargoListAddress>)new LambdaQueryWrapper<MesBuildingCargoListAddress>().eq(MesBuildingCargoListAddress::getCargoListId, cargoList.getId()));
      if (address == null && (StringUtils.isNotBlank(project.getAddress()) || project.getCityId() != null)) {
         MesBuildingCargoListAddress copy = BeanUtil.copy(project, MesBuildingCargoListAddress.class);
         copy.setCargoListId(cargoList.getId());
         copy.setRegionalFullName(AddressUtil.getAddress(project, ProjectAddressTypeEnum.PROJECT_ADDRESS.getType()));
         this.cargoListAddressService.save(copy);
      }
   }

   @Override
   public Boolean updateCargoListLogistics(CargoListLogisticsUpdateDTOParam param) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(param.getId());
      this.contractProjectService.checkProjectStatus(cargoList.getProjectId());
      this.projectUserLinkService.checkProjectUser(cargoList.getProjectId());
      this.checkLogistics(param, cargoList.getTransportMode(), cargoList.getEnclosureTransportMode(), cargoList.getProductType(), cargoList.getRelationType());
      cargoList.setSupplierPriceId(param.getSupplierPriceId());
      cargoList.setCarModel(param.getCarModel());
      cargoList.setReceiptName(param.getReceiptName());
      cargoList.setReceiptPhone(param.getReceiptPhone());
      this.cargoListService.updateById(cargoList);
      return true;
   }

   private void checkLogistics(
      CargoListLogisticsInfo param, Integer artifactTransportMode, Integer enclosureTransportMode, Integer productType, Integer relationType
   ) {
      Preconditions.checkArgument(artifactTransportMode != null || enclosureTransportMode != null, "运输方式不能为空!!!");
      Integer transportMode = artifactTransportMode;
      if ((productType & ProductTypeEnum.ENCLOSURE.getType()) > 0 && (productType & ProductTypeEnum.ARTIFACT.getType()) > 0) {
         Preconditions.checkArgument(
            artifactTransportMode != null && enclosureTransportMode != null && artifactTransportMode.equals(enclosureTransportMode), "围护和构件同时装车时,运输方式不能不同!!!"
         );
      } else if ((productType & ProductTypeEnum.ENCLOSURE.getType()) > 0) {
         transportMode = enclosureTransportMode;
      } else if (productType.equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         if ((relationType & ProductTypeEnum.ENCLOSURE.getType()) > 0 && (relationType & ProductTypeEnum.ARTIFACT.getType()) > 0) {
            if (!TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(transportMode)
               && !TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(enclosureTransportMode)) {
               transportMode = TransportTypeEnum.PUBLIC_TRANSFER.getType();
            } else {
               transportMode = TransportTypeEnum.PRIVATE_TRANSFER.getType();
            }
         } else if ((relationType & ProductTypeEnum.ENCLOSURE.getType()) > 0) {
            transportMode = enclosureTransportMode;
         }
      }

      Preconditions.checkArgument(transportMode != null, "运输方式不能为空!!!");
      if (transportMode.equals(TransportTypeEnum.PRIVATE_TRANSFER.getType())) {
         Preconditions.checkArgument(param.getSupplierPriceId() != null, "未设置物流单位");
         MesBuildingSupplierPrice supplierPrice = this.supplierPriceService.getById(param.getSupplierPriceId());
         Preconditions.checkArgument(supplierPrice != null, "添加失败:传入物流单位id有误");
         Preconditions.checkArgument(StringUtils.isNotEmpty(param.getCarModel()), "未设置车型");
      }

      Preconditions.checkArgument(StringUtils.isNotEmpty(param.getReceiptName()), "未设置收货人姓名");
      Preconditions.checkArgument(StringUtils.isNotEmpty(param.getReceiptPhone()), "未设置收货人电话");
   }

   private List<ProductSumInfoDTO> saveProduct(List<CargoListProductDTOParam> newProducts, Long cargoListId, Long projectId) {
      List<ProductSumInfoDTO> infos = new ArrayList<>();
      Map<Integer, ContractTech> contractTechMap = this.contractTechService
         .list(Wrappers.lambdaQuery(ContractTech.builder().projectId(projectId).build()))
         .stream()
         .collect(Collectors.toMap(ContractTech::getType, Function.identity()));
      List<Long> warehouseSummaryIds = newProducts.stream().map(MesBuildingLinkCommonDTOParam::getId).collect(Collectors.toList());
      List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService.listByIds(warehouseSummaryIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(summaryList) && summaryList.size() == warehouseSummaryIds.size(), "入库记录不存在!!!");
      Preconditions.checkArgument(summaryList.stream().allMatch(e -> WarehouseTypeEnum.INTO.getType().equals(e.getType())), "入库记录不存在");
      Map<Integer, List<MesBuildingWarehouseSummary>> productTypeSummaryMap = summaryList.stream()
         .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProductType));
      this.checkCargoArtifactProduct(projectId, newProducts, productTypeSummaryMap);
      if (CollectionUtils.isNotEmpty(newProducts)) {
         newProducts = this.mesBuildingCalcMaxNumManager.checkPackNumberAndBuild(newProducts, productTypeSummaryMap);
         List<ArtNotRectifiedInfo> notRectifiedInfo = Collections.emptyList();
         List<CargoListProductDTOParam> cargoListProductDTOParams = newProducts.stream()
            .filter(e -> ProductTypeEnum.ARTIFACT.getType().equals(e.getProductType()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(cargoListProductDTOParams)) {
            HashMap<Long, List<Integer>> productMap = new HashMap<>();
            cargoListProductDTOParams.forEach(e -> {
               List var10000 = productMap.put(e.getId(), e.getNumberList());
            });
            notRectifiedInfo = this.qhseService.findProductNotRectifiedInfo(productMap);
            if (CollectionUtils.isNotEmpty(notRectifiedInfo)) {
               StringBuilder builder = new StringBuilder();
               notRectifiedInfo.stream().forEach(e -> builder.append("[编号" + e.getSerialNumber() + ",码号:" + e.getNumber() + "]"));
               Preconditions.checkArgument(false, "构件" + builder.toString() + "存在特殊质量问题，无法装车");
            }
         }

         newProducts.forEach(
            product -> {
               MesBuildingWarehouseSummary record = this.warehouseSummaryService.updateQuantity(product.getId(), product.getQuantity(), null, 2);
               this.utilsBiz.checkProductAbnormalstatus(record.getProductType(), record.getProductId());
               ProductSumInfoDTO productInfo = this.mesProductBiz.getInfoByProduct(record.getProductId(), record.getProductType(), product.getQuantity());
               infos.add(productInfo);
               MesBuildingCargoListProductLink productLink = MesBuildingCargoListProductLink.builder()
                  .cargoListId(cargoListId)
                  .warehouseRecordId(record.getId())
                  .productId(record.getProductId())
                  .productType(record.getProductType())
                  .quantity(product.getQuantity())
                  .netWeight(productInfo.getNetWeight())
                  .grossWeight(productInfo.getGrossWeight())
                  .weight(productInfo.getNetWeight())
                  .length(productInfo.getLength())
                  .surfaceArea(productInfo.getSurfaceArea())
                  .category(productInfo.getCategory())
                  .warehouseType(record.getWarehouseType())
                  .build();
               if (record.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               }

               if (record.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                  productLink.setMeasureMode(
                     contractTechMap.get(productInfo.getCategory()) != null ? contractTechMap.get(productInfo.getCategory()).getMeasureMode() : null
                  );
               }

               this.cargoListProductLinkService.save(productLink);
               if (ProductTypeEnum.ARTIFACT.getType().equals(record.getProductType()) || ProductTypeEnum.ASSEMBLE.getType().equals(record.getProductType())) {
                  product.getNumberList()
                     .forEach(
                        e -> {
                           this.cargoListProductNumberLinkService
                              .save(
                                 MesBuildingCargoListProductNumberLink.builder()
                                    .cargoListId(cargoListId)
                                    .cargoListLinkId(productLink.getId())
                                    .productId(productLink.getProductId())
                                    .productType(record.getProductType())
                                    .number(e)
                                    .userName(UserUtil.getCurrentName())
                                    .build()
                              );
                           this.warehouseRecordService
                              .update(
                                 (Wrapper<MesBuildingWarehouseRecord>)(((((Wrappers.<MesBuildingWarehouseRecord>lambdaUpdate()
                                                   .eq(MesBuildingWarehouseRecord::getProductType, record.getProductType()))
                                                .eq(MesBuildingWarehouseRecord::getProductId, record.getProductId()))
                                             .eq(MesBuildingWarehouseRecord::getNumber, e))
                                          .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType()))
                                       .eq(MesBuildingWarehouseRecord::getWarehouseType, record.getWarehouseType()))
                                    .set(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.CARGOLIST.getType())
                              );
                        }
                     );
               }
            }
         );
      }

      return infos;
   }

   private void checkCargoArtifactProduct(
      Long projectId, List<CargoListProductDTOParam> newProducts, Map<Integer, List<MesBuildingWarehouseSummary>> productTypeSummaryMap
   ) {
      ContractProject project = this.projectService.getById(projectId);
      if (project.getBoolRequiredWarehouse()) {
         List<MesBuildingWarehouseSummary> warehouseSummaryList = productTypeSummaryMap.getOrDefault(
            ProductTypeEnum.ARTIFACT.getType(), Collections.emptyList()
         );
         Map<Long, MesBuildingWarehouseSummary> artifactSummaryMap = warehouseSummaryList.stream()
            .collect(Collectors.toMap(MesBuildingWarehouseSummary::getId, Function.identity()));
         List<CargoListProductDTOParam> newArtifactProducts = newProducts.stream()
            .filter(s -> artifactSummaryMap.containsKey(s.getId()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(newArtifactProducts)) {
            List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = this.warehouseStorageProductService
               .listByWarehouseSummaryIds(newArtifactProducts.stream().map(MesBuildingLinkCommonDTOParam::getId).collect(Collectors.toList()));
            Set<Long> warehouseRecordIds = warehouseStorageProductList.stream()
               .map(MesBuildingWarehouseStorageProduct::getWarehouseRecordId)
               .collect(Collectors.toSet());
            Map<Integer, MesBuildingWarehouseRecord> map = warehouseRecordIds.isEmpty()
               ? Collections.emptyMap()
               : this.warehouseRecordService
                  .listByIds(warehouseRecordIds)
                  .stream()
                  .collect(Collectors.toMap(MesBuildingWarehouseRecord::getNumber, Function.identity()));
            Map<Long, Integer> summaryIdSavedQuantityMap = warehouseStorageProductList.stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingWarehouseStorageProduct::getWarehouseSummaryId, Collectors.summingInt(MesBuildingWarehouseStorageProduct::getQuantity)
                  )
               );
            Map<Long, List<Integer>> summaryIdSavedNumberListMap = warehouseStorageProductList.stream()
               .filter(s -> s.getNumber() != null)
               .collect(
                  Collectors.groupingBy(
                     MesBuildingWarehouseStorageProduct::getWarehouseSummaryId,
                     Collectors.mapping(MesBuildingWarehouseStorageProduct::getNumber, Collectors.toList())
                  )
               );
            newProducts.forEach(
               newProduct -> {
                  MesBuildingWarehouseSummary summary = artifactSummaryMap.get(newProduct.getId());
                  Integer savedQuantity = summaryIdSavedQuantityMap.getOrDefault(newProduct.getId(), 0);
                  Preconditions.checkArgument(
                     savedQuantity - summary.getPackageQuantity().intValue() - summary.getCargoQuantity().intValue() >= newProduct.getQuantity().intValue(),
                     "库位库存数量不足!!"
                  );
                  if (CollectionUtils.isNotEmpty(newProduct.getNumberList())) {
                     List<Integer> saveNumberList = summaryIdSavedNumberListMap.get(newProduct.getId());
                     Preconditions.checkArgument(saveNumberList.containsAll(newProduct.getNumberList()), "库位内未保存该构件码号!!!");
                     newProduct.getNumberList().forEach(number -> {
                        MesBuildingWarehouseRecord warehouseRecord = map.get(number);
                        Preconditions.checkArgument(warehouseRecord.getStatus().equals(WarehouseRecordStatusTypeEnum.INTO.getType()), "库位内该构件码号已出库!!!");
                     });
                  }
               }
            );
         }
      }
   }

   private List<ProductSumInfoDTO> savePack(Set<Long> packageIds, Long cargoListId, Long projectId) {
      List<ProductSumInfoDTO> infos = new ArrayList<>();
      Map<Integer, ContractTech> contractTechMap = this.contractTechService
         .list(Wrappers.lambdaQuery(ContractTech.builder().projectId(projectId).build()))
         .stream()
         .collect(Collectors.toMap(ContractTech::getType, Function.identity()));
      if (CollectionUtils.isNotEmpty(packageIds)) {
         Map<String, List<Integer>> productNumberMap = new HashMap<>();
         packageIds.forEach(
            packageId -> {
               this.packageService.setStatus(packageId, PackageStatusEnum.LOADING.getType());
               this.packageLinkService
                  .list((Wrapper<MesBuildingPackageLink>)Wrappers.<MesBuildingPackageLink>lambdaQuery().eq(MesBuildingPackageLink::getPackageId, packageId))
                  .forEach(
                     link -> {
                        this.utilsBiz.checkProductAbnormalstatus(link.getProductType(), link.getProductId());
                        ProductSumInfoDTO productInfo = this.mesProductBiz.getInfoByProduct(link.getProductId(), link.getProductType(), link.getQuantity());
                        infos.add(productInfo);
                        MesBuildingCargoListProductLink productLink = MesBuildingCargoListProductLink.builder()
                           .cargoListId(cargoListId)
                           .packageId(packageId)
                           .warehouseRecordId(link.getWarehouseRecordId())
                           .productId(link.getProductId())
                           .productType(link.getProductType())
                           .quantity(link.getQuantity())
                           .netWeight(productInfo.getNetWeight())
                           .grossWeight(productInfo.getGrossWeight())
                           .weight(productInfo.getNetWeight())
                           .length(productInfo.getLength())
                           .surfaceArea(productInfo.getSurfaceArea())
                           .category(productInfo.getCategory())
                           .warehouseType(link.getWarehouseType())
                           .build();
                        if (link.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                        }

                        this.cargoListProductLinkService.save(productLink);
                        List<MesBuildingPackageNumberLink> packageNumberLinks = this.packageNumberLinkService
                           .list(
                              (Wrapper<MesBuildingPackageNumberLink>)(Wrappers.<MesBuildingPackageNumberLink>lambdaQuery()
                                    .eq(MesBuildingPackageNumberLink::getPackageId, packageId))
                                 .eq(MesBuildingPackageNumberLink::getProductId, link.getProductId())
                           );
                        if (CollectionUtils.isNotEmpty(packageNumberLinks)) {
                           for (MesBuildingPackageNumberLink item : packageNumberLinks) {
                              List<Integer> numberList = productNumberMap.getOrDefault(link.getProductId() + "-" + link.getProductType(), new ArrayList<>());
                              if (!CollectionUtils.isNotEmpty(numberList) || !numberList.contains(item.getNumber())) {
                                 this.cargoListProductNumberLinkService
                                    .save(
                                       MesBuildingCargoListProductNumberLink.builder()
                                          .cargoListId(cargoListId)
                                          .packageId(packageId)
                                          .cargoListLinkId(productLink.getId())
                                          .productId(productLink.getProductId())
                                          .number(item.getNumber())
                                          .productType(item.getProductType())
                                          .userName(UserUtil.getCurrentName())
                                          .build()
                                    );
                                 this.warehouseRecordService
                                    .update(
                                       (Wrapper<MesBuildingWarehouseRecord>)(((((Wrappers.<MesBuildingWarehouseRecord>lambdaUpdate()
                                                         .eq(MesBuildingWarehouseRecord::getProductType, item.getProductType()))
                                                      .eq(MesBuildingWarehouseRecord::getProductId, item.getProductId()))
                                                   .eq(MesBuildingWarehouseRecord::getNumber, item.getNumber()))
                                                .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType()))
                                             .eq(MesBuildingWarehouseRecord::getWarehouseType, item.getWarehouseType()))
                                          .set(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.CARGOLIST.getType())
                                    );
                                 numberList.add(item.getNumber());
                                 productNumberMap.put(link.getProductId() + "-" + link.getProductType(), numberList);
                              }
                           }
                        }
                     }
                  );
            }
         );
      }

      return infos;
   }

   private void remove(List<MesBuildingCargoListProductLink> productLinks, Long cargoListId) {
      if (CollectionUtils.isNotEmpty(productLinks)) {
         Set<Long> packIds = new HashSet<>();
         productLinks.forEach(link -> {
            if (link.getPackageId() != null) {
               packIds.add(link.getPackageId());
            } else {
               this.warehouseSummaryService.updateQuantity(link.getWarehouseRecordId(), link.getQuantity().negate(), null, 2);
            }
         });
         if (CollectionUtils.isNotEmpty(packIds)) {
            packIds.forEach(packId -> this.packageService.setStatus(packId, PackageStatusEnum.UNLOADING.getType()));
            this.cargoListProductLinkService
               .remove(
                  (Wrapper<MesBuildingCargoListProductLink>)(Wrappers.<MesBuildingCargoListProductLink>lambdaQuery()
                        .eq(MesBuildingCargoListProductLink::getCargoListId, cargoListId))
                     .in(MesBuildingCargoListProductLink::getPackageId, packIds)
               );
         }

         if (packIds.size() != productLinks.size()) {
            this.cargoListProductLinkService
               .remove(
                  (Wrapper<MesBuildingCargoListProductLink>)((Wrappers.<MesBuildingCargoListProductLink>lambdaQuery()
                           .eq(MesBuildingCargoListProductLink::getCargoListId, cargoListId))
                        .isNull(MesBuildingCargoListProductLink::getPackageId))
                     .in(MesBuildingCargoListProductLink::getId, productLinks.stream().map(MesBuildingCargoListProductLink::getId).collect(Collectors.toList()))
               );
         }

         List<MesBuildingCargoListProductNumberLink> numberLinks = this.cargoListProductNumberLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductNumberLink>)Wrappers.<MesBuildingCargoListProductNumberLink>lambdaQuery()
                  .in(
                     MesBuildingCargoListProductNumberLink::getCargoListLinkId,
                     productLinks.stream().map(MesBuildingCargoListProductLink::getId).collect(Collectors.toList())
                  )
            );
         if (CollectionUtils.isNotEmpty(numberLinks)) {
            Map<Long, MesBuildingCargoListProductLink> cargoListProductLinkMap = productLinks.stream()
               .collect(Collectors.toMap(MesBuildingCargoListProductLink::getId, Function.identity()));
            numberLinks.forEach(
               e -> {
                  MesBuildingCargoListProductLink cargoListProductLink = cargoListProductLinkMap.get(e.getCargoListLinkId());
                  this.warehouseRecordService
                     .update(
                        (Wrapper<MesBuildingWarehouseRecord>)(((((Wrappers.<MesBuildingWarehouseRecord>lambdaUpdate()
                                          .eq(MesBuildingWarehouseRecord::getProductId, e.getProductId()))
                                       .eq(MesBuildingWarehouseRecord::getNumber, e.getNumber()))
                                    .eq(MesBuildingWarehouseRecord::getProductType, e.getProductType()))
                                 .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType()))
                              .eq(MesBuildingWarehouseRecord::getWarehouseType, cargoListProductLink.getWarehouseType()))
                           .set(
                              MesBuildingWarehouseRecord::getStatus,
                              e.getPackageId() == null ? WarehouseRecordStatusTypeEnum.INTO.getType() : WarehouseRecordStatusTypeEnum.PACKAGING.getType()
                           )
                     );
               }
            );
            this.cargoListProductNumberLinkService
               .removeByIds(numberLinks.stream().map(MesBuildingCargoListProductNumberLink::getId).collect(Collectors.toList()));
         }
      }
   }

   @Override
   public boolean deleteByIds(List<Long> ids) {
      ids.forEach(
         id -> {
            MesBuildingCargoList cargoList = this.cargoListService.getById(id);
            Preconditions.checkArgument(cargoList != null, "该发运清单不存在");
            Preconditions.checkArgument(
               cargoList.getStatus().equals(CargoListStatusEnum.LOADING.getType()) || cargoList.getStatus().equals(CargoListStatusEnum.LOADING_NO.getType()),
               "该发运清单已发运"
            );
            if (!CargoListStatusEnum.LOADING_NO.getType().equals(cargoList.getStatus())) {
               ContractProject project = this.contractProjectService.checkProjectStatus(cargoList.getProjectId());
               this.projectUserLinkService.checkProjectUser(cargoList.getProjectId());
               LambdaQueryWrapper<MesBuildingCargoListProductLink> wrapper = (LambdaQueryWrapper<MesBuildingCargoListProductLink>)Wrappers.<MesBuildingCargoListProductLink>lambdaQuery()
                  .eq(MesBuildingCargoListProductLink::getCargoListId, cargoList.getId());
               List<MesBuildingCargoListProductLink> links = this.cargoListProductLinkService.list(wrapper);
               this.remove(links, cargoList.getId());
               AppEmptyCarsWeighingDTOParam copy = BeanUtil.copy(cargoList, AppEmptyCarsWeighingDTOParam.class);
               MesBuildingCargoList cargoListCopy = BeanUtil.copy(copy, MesBuildingCargoList.class);
               cargoListCopy.setStatus(CargoListStatusEnum.LOADING_NO.getType());
               this.cargoListService.save(cargoListCopy);
               project.setHappenedAmount(this.getProjectShipAmount(cargoList.getProjectId(), null));
               project.setBoolArrears(
                  project.getCollectionAmount().compareTo(project.getHappenedAmount()) < 0
                     ? ProjectBoolArrearsEnum.TRUE.getType()
                     : ProjectBoolArrearsEnum.FALSE.getType()
               );
               this.contractProjectService.updateById(project);
            }

            this.cargoListService.removeById(cargoList.getId());
         }
      );
      return true;
   }

   @Override
   public OverweightSMSUserDTO checkCargoList(CargoListCheckDTOParam requestVO) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(requestVO.getId());
      Preconditions.checkArgument(cargoList != null, "传入发货清单id不正确");
      this.contractProjectService.checkProjectStatus(cargoList.getProjectId());
      this.projectUserLinkService.checkProjectUser(cargoList.getProjectId());
      Preconditions.checkArgument(CargoListStatusEnum.LOADING.getType().equals(cargoList.getStatus()), "该发货清单审核过发货");
      Preconditions.checkArgument(requestVO.getActualWeight().compareTo(BigDecimal.ZERO) > 0, "操作失败，过磅重量必须大于0");
      if ((cargoList.getProductType() & ProductTypeEnum.ARTIFACT.getType()) > 0) {
         List<MesBuildingCargoListProductLink> productLinks = this.cargoListProductLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductLink>)(new LambdaQueryWrapper<MesBuildingCargoListProductLink>()
                     .eq(MesBuildingCargoListProductLink::getCargoListId, cargoList.getId()))
                  .eq(MesBuildingCargoListProductLink::getProductType, ProductTypeEnum.ARTIFACT.getType())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(productLinks), "构件装车过磅记录不存在!!!");
         List<TechArtifact> techArtifacts = this.techArtifactService
            .list(
               (Wrapper<TechArtifact>)(new LambdaQueryWrapper<TechArtifact>()
                     .and(
                        e -> {
                           LambdaQueryWrapper var10000 = ((e.eq(
                                    TechArtifact::getBoolAbnormalEnum, Boolean.TRUE
                                 ))
                                 .or())
                              .eq(TechArtifact::getBoolStatusEnum, Boolean.FALSE);
                        }
                     ))
                  .in(TechArtifact::getId, productLinks.stream().map(MesBuildingCargoListProductLink::getProductId).collect(Collectors.toList()))
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(techArtifacts), "操作失败,存在异常状态或已暂停的构件清单!!!");
      }

      this.checkLogistics(
         requestVO, cargoList.getTransportMode(), cargoList.getEnclosureTransportMode(), cargoList.getProductType(), cargoList.getRelationType()
      );
      cargoList.setCarModel(requestVO.getCarModel());
      cargoList.setReceiptName(requestVO.getReceiptName());
      cargoList.setReceiptPhone(requestVO.getReceiptPhone());
      cargoList.setSupplierPriceId(requestVO.getSupplierPriceId());
      cargoList.setActualUserId(UserUtil.getCurrentUserId());
      cargoList.setActualUserName(UserUtil.getCurrentName());
      cargoList.setActualTime(LocalDateTime.now());
      cargoList.setActualWeight(requestVO.getActualWeight());
      cargoList.setRemark(requestVO.getRemark());
      cargoList.setActualGrossWeight(requestVO.getActualGrossWeight());
      if (CollectionUtils.isNotEmpty(requestVO.getAttachmentIds())) {
         Preconditions.checkArgument(requestVO.getAttachmentIds().size() <= 3, "图片数量最大为3张");
         cargoList.setAttachmentIds(org.apache.commons.lang3.StringUtils.join(requestVO.getAttachmentIds().toArray(), ","));
      }

      BigDecimal theoreticalWeight = BigDecimal.ZERO;
      WeighSMSConfigDTO weighSMSConfigDTO = this.configService.getOverweightSMSRecipientInfo();
      Preconditions.checkArgument(weighSMSConfigDTO != null, "过磅配置未配置!");
      if (WeightTypeEnum.GROSS_WEIGHT.getType().equals(weighSMSConfigDTO.getWeightTypeEnum())) {
         theoreticalWeight = theoreticalWeight.add(cargoList.getTotalGrossWeight().multiply(BigDecimal.valueOf(1.0 + weighSMSConfigDTO.getMaxWeight() / 100.0)));
      } else {
         theoreticalWeight = theoreticalWeight.add(cargoList.getTotalNetWeight().multiply(BigDecimal.valueOf(1.0 + weighSMSConfigDTO.getMaxWeight() / 100.0)));
      }

      List<MesBuildingCargoListProductLink> productLinkList = this.cargoListProductLinkService
         .list(Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class).eq(MesBuildingCargoListProductLink::getCargoListId, cargoList.getId()));
      Set<Long> warehouseRecordIds = productLinkList.stream().map(MesBuildingCargoListProductLink::getWarehouseRecordId).collect(Collectors.toSet());
      Set<Long> workshopIds = this.warehouseSummaryService
         .list(Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class).in(MesBuildingWarehouseSummary::getId, warehouseRecordIds))
         .stream()
         .map(MesBuildingWarehouseSummary::getWorkshopId)
         .filter(workshopId -> workshopId != 0L)
         .collect(Collectors.toSet());
      if (requestVO.getActualWeight().compareTo(theoreticalWeight) > 0 && CollectionUtils.isNotEmpty(workshopIds)) {
         this.cargoListService.updateById(cargoList);
         Set<Integer> productTypes = productLinkList.stream().map(MesBuildingCargoListProductLink::getProductType).collect(Collectors.toSet());
         List<UserCheckDTO> userCheckDTOS = CollUtil.newArrayList();
         if (productTypes.size() == 1 && productTypes.contains(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
            for (UserCheckVO userCheckVO : weighSMSConfigDTO.getUserChecks()) {
               userCheckDTOS.add(UserCheckDTO.builder().name(userCheckVO.getName()).phone(userCheckVO.getPhone()).build());
            }
         } else {
            Set<Long> matchWorkshopIds = CollUtil.newHashSet();
            int emptyConfigWorkshopCount = 0;

            for (UserCheckVO userCheckVO : weighSMSConfigDTO.getUserChecks()) {
               List<IdAndNameDTO> configWorkshopIdAndNames = userCheckVO.getWorkshops();
               UserCheckDTO userCheckDTO = UserCheckDTO.builder().name(userCheckVO.getName()).phone(userCheckVO.getPhone()).build();
               if (CollUtil.isNotEmpty(configWorkshopIdAndNames)) {
                  Set<Long> configWorkshopIds = configWorkshopIdAndNames.stream().map(IdAndNameDTO::getId).collect(Collectors.toSet());
                  Collection<Long> intersection = CollUtil.intersection(workshopIds, configWorkshopIds);
                  if (CollUtil.isNotEmpty(intersection)) {
                     matchWorkshopIds.addAll(intersection);
                     userCheckDTOS.add(userCheckDTO);
                  }
               } else {
                  userCheckDTOS.add(userCheckDTO);
                  emptyConfigWorkshopCount++;
               }
            }

            if (emptyConfigWorkshopCount == 0) {
               Collection<Long> disjunction = CollUtil.disjunction(workshopIds, matchWorkshopIds);
               if (CollUtil.isNotEmpty(disjunction)) {
                  List<MesBuildingWorkshop> workshops = this.mesBuildingWorkshopService.listByIds(disjunction);
                  Preconditions.checkArgument(workshops.size() == disjunction.size(), "车间不存在");
                  List<String> names = workshops.stream().map(MesBuildingWorkshop::getName).collect(Collectors.toList());
                  throw new BusinessException("车间（" + StrUtil.join("、", names) + "）尚未配置过磅短信联系人");
               }
            }
         }

         Preconditions.checkArgument(CollUtil.isNotEmpty(userCheckDTOS), "尚未配置过磅短信联系人");
         return OverweightSMSUserDTO.builder().isPass(false).userChecks(userCheckDTOS).build();
      } else {
         cargoList.setStatus(CargoListStatusEnum.WEIGH.getType());
         Integer transportMode = this.getTransportMode(cargoList);
         if (TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(transportMode)) {
            cargoList = this.calculationTotalPrice(cargoList);
         } else {
            cargoList.setTotalPrice(BigDecimal.ZERO);
         }

         this.cargoListService.updateById(cargoList);
         this.buildWeight(cargoList);
         return OverweightSMSUserDTO.builder().isPass(true).build();
      }
   }

   private void buildWeight(MesBuildingCargoList cargoList) {
      if (cargoList.getStructureMeasureMode() != null
         && cargoList.getStructureMeasureMode() == 2
         && (
            (cargoList.getProductType() & ProductTypeEnum.ARTIFACT.getType()) > 0
               || cargoList.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
         )) {
         Map<Long, TechStandardPart> standardPartMap = new HashMap<>();
         List<MesBuildingCargoListProductLink> links = this.cargoListProductLinkService
            .list((Wrapper<MesBuildingCargoListProductLink>)Wrappers.<MesBuildingCargoListProductLink>lambdaQuery().eq(MesBuildingCargoListProductLink::getCargoListId, cargoList.getId()));
         List<MesBuildingCargoListProductLink> standardPartList = links.stream()
            .filter(e -> e.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(standardPartList)) {
            List<TechStandardPart> techStandardParts = this.techStandardPartService
               .listByIds(standardPartList.stream().map(MesBuildingCargoListProductLink::getProductId).collect(Collectors.toList()));
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(techStandardParts), "配套件发运记录不存在!!");
            standardPartMap = techStandardParts.stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
         }

         BigDecimal totalMete = cargoList.getTotalNetWeight();

         for (MesBuildingCargoListProductLink cargoListRecordLink : links) {
            if (!cargoListRecordLink.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
               || standardPartMap.get(cargoListRecordLink.getProductId()).getBoolWeightTypeEnum()) {
               BigDecimal divide = cargoListRecordLink.getNetWeight().divide(totalMete, 8, RoundingMode.HALF_UP);
               cargoListRecordLink.setWeight(cargoList.getActualWeight().multiply(divide));
               if (cargoListRecordLink.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                  TechStandardPart standardPart = standardPartMap.get(cargoListRecordLink.getProductId());
                  Preconditions.checkArgument(standardPart != null, "配套件清单不存在!!!");
                  if (standardPart.getAccountingUnit().equals("吨") && standardPart.getBoolWeightTypeEnum()) {
                     cargoListRecordLink.setWeight(cargoList.getActualWeight().multiply(divide));
                  }
               }

               this.cargoListProductLinkService.updateById(cargoListRecordLink);
            }
         }
      }
   }

   @Override
   public Boolean sendWeighSms(CargoListWeighSMSDTOParam dtoParam) {
      JSONObject message = new JSONObject();
      String verifyCode = RandomStringUtils.randomNumeric(6);
      message.put("code", verifyCode);
      this.redisUtils.set("overweight:" + dtoParam.getId(), verifyCode, 300L);

      for (UserCheckDTO userCheckDTO : dtoParam.getUserChecks()) {
         Preconditions.checkArgument(
            Pattern.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", userCheckDTO.getPhone()), "手机格式错误"
         );
         this.smsUtils.sendSms(userCheckDTO.getPhone(), message.toJSONString(), "SMS_170181398");
      }

      return Boolean.TRUE;
   }

   private Integer getTransportMode(MesBuildingCargoList cargoList) {
      Integer transportMode = cargoList.getTransportMode();
      if ((cargoList.getProductType() & ProductTypeEnum.ENCLOSURE.getType()) > 0 && (cargoList.getProductType() & ProductTypeEnum.ARTIFACT.getType()) > 0) {
         Preconditions.checkArgument(
            cargoList.getTransportMode() != null
               && cargoList.getEnclosureTransportMode() != null
               && cargoList.getTransportMode().equals(cargoList.getEnclosureTransportMode()),
            "围护和构件同时装车时,运输方式不能不同!!!"
         );
      } else if ((cargoList.getProductType() & ProductTypeEnum.ENCLOSURE.getType()) > 0) {
         Preconditions.checkArgument(cargoList.getEnclosureTransportMode() != null, "围护运输方式不能为空!!!");
         transportMode = cargoList.getEnclosureTransportMode();
      } else if (cargoList.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
         if ((cargoList.getRelationType() & ProductTypeEnum.ENCLOSURE.getType()) > 0 && (cargoList.getRelationType() & ProductTypeEnum.ARTIFACT.getType()) > 0) {
            if (!TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(transportMode)
               && !TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(cargoList.getEnclosureTransportMode())) {
               transportMode = TransportTypeEnum.PUBLIC_TRANSFER.getType();
            } else {
               transportMode = TransportTypeEnum.PRIVATE_TRANSFER.getType();
            }
         } else if ((cargoList.getRelationType() & ProductTypeEnum.ENCLOSURE.getType()) > 0) {
            Preconditions.checkArgument(cargoList.getEnclosureTransportMode() != null, "围护运输方式不能为空!!!");
            transportMode = cargoList.getEnclosureTransportMode();
         }
      }

      return transportMode;
   }

   private MesBuildingCargoList calculationTotalPrice(MesBuildingCargoList cargoList) {
      MesBuildingSupplierPrice supplierPrice = this.supplierPriceService.getById(cargoList.getSupplierPriceId());
      MesBuildingSupplierPriceCarLink carLink = this.carLinkService
         .getOne(
            (Wrapper<MesBuildingSupplierPriceCarLink>)((Wrappers.<MesBuildingSupplierPriceCarLink>lambdaQuery()
                     .eq(MesBuildingSupplierPriceCarLink::getSupplierPriceId, cargoList.getSupplierPriceId()))
                  .eq(MesBuildingSupplierPriceCarLink::getProjectId, cargoList.getProjectId()))
               .eq(MesBuildingSupplierPriceCarLink::getCarModel, cargoList.getCarModel())
         );
      if (carLink == null) {
         cargoList.setPrice(supplierPrice.getPrice());
         cargoList.setPriceType(supplierPrice.getPriceType());
         if (supplierPrice.getPriceType().equals(SupplierPriceTypeEnum.WEIGHT.getType())) {
            cargoList.setTotalPrice(cargoList.getActualWeight().divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP).multiply(supplierPrice.getPrice()));
         } else {
            cargoList.setTotalPrice(supplierPrice.getPrice().setScale(2, RoundingMode.HALF_UP));
         }
      } else {
         cargoList.setPrice(carLink.getPrice());
         cargoList.setPriceType(carLink.getPriceType());
         if (carLink.getPriceType().equals(SupplierPriceTypeEnum.WEIGHT.getType())) {
            cargoList.setTotalPrice(cargoList.getActualWeight().divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP).multiply(carLink.getPrice()));
         } else {
            cargoList.setTotalPrice(carLink.getPrice().setScale(2, RoundingMode.HALF_UP));
         }
      }

      return cargoList;
   }

   @Override
   public Boolean checkCaptcha(Long id, String verifyCode) {
      String code = (String)this.redisUtils.get("overweight:" + id);
      Preconditions.checkArgument(code != null, "验证失败，验证码不存在或已失效");
      Preconditions.checkArgument(code.equals(verifyCode), "验证失败，验证码错误");
      MesBuildingCargoList cargoList = this.cargoListService.getById(id);
      Preconditions.checkArgument(cargoList != null, "发货清单不存在");
      this.contractProjectService.checkProjectStatus(cargoList.getProjectId());
      this.projectUserLinkService.checkProjectUser(cargoList.getProjectId());
      Preconditions.checkArgument(CargoListStatusEnum.LOADING.getType().equals(cargoList.getStatus()), "该发货清单已发货");
      cargoList.setStatus(CargoListStatusEnum.WEIGH.getType());
      this.cargoListService.updateById(cargoList);
      this.buildWeight(cargoList);
      Integer transportMode = this.getTransportMode(cargoList);
      if (TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(transportMode)) {
         cargoList = this.calculationTotalPrice(cargoList);
      } else {
         cargoList.setTotalPrice(BigDecimal.ZERO);
      }

      this.cargoListService.updateById(cargoList);
      this.redisUtils.del("overweight:" + id);
      return true;
   }

   @Override
   public AuditInfoDTO getAuditInfo(Long cargoListId) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(cargoListId);
      Preconditions.checkArgument(cargoList != null, "查询失败，发货清单不存在");
      ContractProject project = this.contractProjectService.getById(cargoList.getProjectId());
      BigDecimal managementFeeRate = project.getManagementFeeRate() == null
         ? BigDecimal.ZERO
         : project.getManagementFeeRate().divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP);
      BigDecimal managementFee = project.getContractAmount().multiply(managementFeeRate);
      BigDecimal sum = this.getProjectShipAmountMap(Collections.singletonList(project.getId())).get(project.getId());
      BigDecimal totalDeliveryAmount = sum == null ? BigDecimal.ZERO : sum;
      BigDecimal totalCollectionAmount = this.collectionService.getCollectionAmount(project.getId());
      BigDecimal availableAmount = totalCollectionAmount.subtract(managementFee).subtract(totalDeliveryAmount).setScale(3, RoundingMode.HALF_UP);
      Map<String, Object> map = this.getShipAmountByCargoListId(
         cargoList.getId(), cargoList.getStructureMeasureMode(), cargoList.getEnclosureMeasureMode(), cargoList.getProjectId()
      );
      BigDecimal safetyFactor = BigDecimal.ZERO;
      if (project.getBusinessType().equals(ProjectBusinessTypeEnum.PROCESS.getType())) {
         safetyFactor = this.configService.getSafetyFactorConfig().getSafetyFactor().divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP);
      }

      BigDecimal safeAmount = project.getContractAmount().subtract(totalDeliveryAmount).multiply(safetyFactor.add(managementFeeRate));
      BigDecimal contractReceivableAmount = project.getContractAmount().subtract(totalCollectionAmount);
      BigDecimal billingReceivableAmount = this.invoiceService.getInvoiceAmount(project.getId()).subtract(totalCollectionAmount);
      List<AttachmentDTO> attachmentDTOS = new ArrayList<>();
      if (StringUtils.isNotBlank(cargoList.getAttachmentIds())) {
         List<Long> attachmentIds = Arrays.stream(cargoList.getAttachmentIds().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
         attachmentIds.forEach(e -> attachmentDTOS.add(this.attachmentService.getById(e)));
      }

      MesBuildingCargoListAddress cargoListAddress = this.cargoListAddressService
         .getOne((Wrapper<MesBuildingCargoListAddress>)new LambdaQueryWrapper<MesBuildingCargoListAddress>().eq(MesBuildingCargoListAddress::getCargoListId, cargoList.getId()));
      return AuditInfoDTO.builder()
         .serialNumber(project.getSerialNumber())
         .name(project.getName())
         .shortName(project.getShortName())
         .contractAmount(project.getContractAmount())
         .businessType(project.getBusinessType())
         .structureMeasureMode(cargoList.getStructureMeasureMode())
         .enclosureMeasureMode(cargoList.getEnclosureMeasureMode())
         .managementFee(managementFee)
         .totalDeliveryAmount(totalDeliveryAmount)
         .totalCollectionAmount(totalCollectionAmount)
         .availableAmount(availableAmount)
         .safeAmount(safeAmount)
         .deliveryAmount(new BigDecimal(map.get("shipAmount").toString()))
         .contractReceivableAmount(contractReceivableAmount)
         .billingReceivableAmount(billingReceivableAmount)
         .licensePlate(cargoList.getLicensePlate())
         .loadUserName(StringUtils.isBlank(cargoList.getUserNames()) ? cargoList.getUserName() : cargoList.getUserNames())
         .loadTime(cargoList.getCreateTime())
         .actualUserName(cargoList.getActualUserName())
         .auditUserName(cargoList.getAuditUserName())
         .actualTime(cargoList.getActualTime())
         .actualWeight(cargoList.getActualWeight())
         .projectId(project.getId())
         .attachmentDTOS(attachmentDTOS)
         .addressRegionalFullName(cargoListAddress == null ? "" : cargoListAddress.getRegionalFullName() + cargoListAddress.getAddress())
         .build();
   }

   @Override
   public AuditInfoDTO getAuditInfoV2(Long cargoListId) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(cargoListId);
      Preconditions.checkArgument(cargoList != null, "查询失败，发货清单不存在");
      ContractProject project = this.contractProjectService.getById(cargoList.getProjectId());
      BigDecimal managementFeeRate = project.getManagementFeeRate() == null
         ? BigDecimal.ZERO
         : project.getManagementFeeRate().divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP);
      BigDecimal managementFee = project.getContractAmount().multiply(managementFeeRate);
      List<MesBuildingCargoList> cargoListList = this.cargoListService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoList.class)
               .eq(MesBuildingCargoList::getProjectId, cargoList.getProjectId())
               .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType())
               .eq(MesBuildingCargoList::getDeliveryStatus, ShipmentStatusEnum.DELIVERY.getType())
         );
      List<CargoListProductLinkPriceDTO> productLinkPriceDTOList = this.businessPriceUtils
         .getCargoLinkPrice(cargoListList.stream().map(MesBuildingCargoList::getId).collect(Collectors.toList()));
      BigDecimal totalDeliveryAmount = productLinkPriceDTOList.stream()
         .map(CargoListProductLinkPriceDTO::getTotalPrice)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .setScale(2, RoundingMode.HALF_UP);
      BigDecimal totalCollectionAmount = this.collectionService.getCollectionAmount(project.getId());
      BigDecimal availableAmount = totalCollectionAmount.subtract(managementFee).subtract(totalDeliveryAmount).setScale(3, RoundingMode.HALF_UP);
      BigDecimal deliveryAmount = this.businessPriceUtils
         .getCargoLinkPrice((Collection<Long>)Collections.singletonList(cargoListId))
         .stream()
         .map(CargoListProductLinkPriceDTO::getTotalPrice)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal safetyFactor = BigDecimal.ZERO;
      if (project.getBusinessType().equals(ProjectBusinessTypeEnum.PROCESS.getType())) {
         safetyFactor = this.configService.getSafetyFactorConfig().getSafetyFactor().divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP);
      }

      BigDecimal safeAmount = project.getContractAmount().subtract(totalDeliveryAmount).multiply(safetyFactor.add(managementFeeRate));
      BigDecimal contractReceivableAmount = project.getContractAmount().subtract(totalCollectionAmount);
      BigDecimal billingReceivableAmount = this.invoiceService.getInvoiceAmount(project.getId()).subtract(totalCollectionAmount);
      List<AttachmentDTO> attachmentDTOS = new ArrayList<>();
      if (StringUtils.isNotBlank(cargoList.getAttachmentIds())) {
         List<Long> attachmentIds = Arrays.stream(cargoList.getAttachmentIds().split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
         attachmentIds.forEach(e -> attachmentDTOS.add(this.attachmentService.getById(e)));
      }

      MesBuildingCargoListAddress cargoListAddress = this.cargoListAddressService
         .getOne((Wrapper<MesBuildingCargoListAddress>)new LambdaQueryWrapper<MesBuildingCargoListAddress>().eq(MesBuildingCargoListAddress::getCargoListId, cargoList.getId()));
      MesBuildingSupplierPrice supplierPrice = this.supplierPriceService.getById(cargoList.getSupplierPriceId());
      SupplierPriceInfo supplierInfo = null;
      if (supplierPrice != null) {
         Supplier supplier = this.supplierService.getById(supplierPrice.getSupplierId());
         if (supplier != null) {
            supplierInfo = SupplierPriceInfo.builder()
               .id(supplier.getId())
               .name(supplier.getName())
               .priceType(supplierPrice.getPriceType())
               .price(supplierPrice.getPrice())
               .build();
         }
      }

      return AuditInfoDTO.builder()
         .project(
            ProjectInfo.builder().id(project.getId()).name(project.getName()).shortName(project.getShortName()).serialNumber(project.getShortName()).build()
         )
         .supplier(supplierInfo)
         .supplierName(supplierInfo != null ? supplierInfo.getName() : null)
         .serialNumber(project.getSerialNumber())
         .name(project.getName())
         .shortName(project.getShortName())
         .contractAmount(project.getContractAmount())
         .businessType(project.getBusinessType())
         .structureMeasureMode(cargoList.getStructureMeasureMode())
         .enclosureMeasureMode(cargoList.getEnclosureMeasureMode())
         .managementFee(managementFee)
         .totalDeliveryAmount(totalDeliveryAmount)
         .totalCollectionAmount(totalCollectionAmount)
         .availableAmount(availableAmount)
         .safeAmount(safeAmount)
         .deliveryAmount(deliveryAmount)
         .contractReceivableAmount(contractReceivableAmount)
         .billingReceivableAmount(billingReceivableAmount)
         .licensePlate(cargoList.getLicensePlate())
         .loadUserName(StringUtils.isBlank(cargoList.getUserNames()) ? cargoList.getUserName() : cargoList.getUserNames())
         .loadTime(cargoList.getCreateTime())
         .actualUserName(cargoList.getActualUserName())
         .auditUserName(cargoList.getAuditUserName())
         .actualTime(cargoList.getActualTime())
         .actualWeight(cargoList.getActualWeight())
         .driverName(cargoList.getDriverName())
         .driverPhone(cargoList.getDriverPhone())
         .projectId(project.getId())
         .attachmentDTOS(attachmentDTOS)
         .addressRegionalFullName(cargoListAddress == null ? "" : cargoListAddress.getRegionalFullName() + cargoListAddress.getAddress())
         .meansConveyanceEnum(cargoList.getMeansConveyanceEnum())
         .remark(cargoList.getRemark())
         .build();
   }

   @Override
   public boolean review(CheckDTOParam param) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(param.getId());
      Preconditions.checkArgument(cargoList != null, "发运记录不存在");
      Preconditions.checkArgument(CargoListStatusEnum.WEIGH.getType().equals(cargoList.getStatus()), "仅可审核未发运状态");
      ContractProject project = this.contractProjectService.checkProjectStatus(cargoList.getProjectId());
      this.projectUserLinkService.checkProjectUser(cargoList.getProjectId());
      cargoList.setAuditUserId(UserUtil.getCurrentUserId());
      cargoList.setAuditUserName(UserUtil.getCurrentName());
      if (param.getStatus().equals(CheckStatusEnum.PASS.getType())) {
         if ((cargoList.getProductType() & ProductTypeEnum.ARTIFACT.getType()) > 0) {
            List<MesBuildingCargoListProductLink> productLinks = this.cargoListProductLinkService
               .list(
                  (Wrapper<MesBuildingCargoListProductLink>)(new LambdaQueryWrapper<MesBuildingCargoListProductLink>()
                        .eq(MesBuildingCargoListProductLink::getCargoListId, cargoList.getId()))
                     .eq(MesBuildingCargoListProductLink::getProductType, ProductTypeEnum.ARTIFACT.getType())
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(productLinks), "构件装车过磅记录不存在!!!");
            List<TechArtifact> techArtifacts = this.techArtifactService
               .list(
                  (Wrapper<TechArtifact>)(new LambdaQueryWrapper<TechArtifact>()
                        .and(
                           e -> {
                              LambdaQueryWrapper var10000 = ((e.eq(
                                       TechArtifact::getBoolAbnormalEnum, Boolean.TRUE
                                    ))
                                    .or())
                                 .eq(TechArtifact::getBoolStatusEnum, Boolean.FALSE);
                           }
                        ))
                     .in(TechArtifact::getId, productLinks.stream().map(MesBuildingCargoListProductLink::getProductId).collect(Collectors.toList()))
               );
            Preconditions.checkArgument(CollectionUtils.isEmpty(techArtifacts), "操作失败,存在异常状态或已暂停的构件清单!!!");
         }

         cargoList.setStatus(CargoListStatusEnum.SHIPMENT.getType());
         cargoList.setAuditTime(LocalDateTime.now());
         Integer count = 0;
         List<String> serialNumbers = this.cargoListService.countShipByProjectIdV2(cargoList.getProjectId());
         if (CollectionUtils.isNotEmpty(serialNumbers)) {
            count = serialNumbers.stream().map(serial -> serial.split("-")).filter(parts -> parts.length > 2).mapToInt(parts -> {
               try {
                  return Integer.parseInt(parts[2].trim());
               } catch (NumberFormatException e) {
                  throw new NumberFormatException(e.getMessage());
               }
            }).max().orElseThrow(() -> new IllegalStateException("无有效数字"));
         }

         String tripNumber = LocalDate.now().getYear() % 100
            + NumberUtil.getDigitsNumber(LocalDate.now().getMonthValue(), 2)
            + NumberUtil.getDigitsNumber(LocalDate.now().getDayOfMonth(), 2)
            + "-"
            + cargoList.getProjectId()
            + "-"
            + (count + 1);
         cargoList.setSerialNumber(tripNumber);
         List<MesBuildingCargoListProductLink> links = this.cargoListProductLinkService
            .list((Wrapper<MesBuildingCargoListProductLink>)Wrappers.<MesBuildingCargoListProductLink>lambdaQuery().eq(MesBuildingCargoListProductLink::getCargoListId, cargoList.getId()));
         List<Long> packageIds = links.stream()
            .map(MesBuildingCargoListProductLink::getPackageId)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(packageIds)) {
            packageIds.forEach(packageId -> this.packageService.setStatus(packageId, PackageStatusEnum.SHIPMENT.getType()));
         }

         List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
            .list(
               (Wrapper<MesBuildingWarehouseSummary>)new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                  .in(
                     MesBuildingWarehouseSummary::getId, links.stream().map(MesBuildingCargoListProductLink::getWarehouseRecordId).collect(Collectors.toList())
                  )
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(summaryList), "发运失败,入库记录不存在!!!");
         Map<Long, MesBuildingWarehouseSummary> summaryMap = summaryList.stream()
            .collect(Collectors.toMap(MesBuildingWarehouseSummary::getId, Function.identity()));
         new ArrayList();

         for (MesBuildingCargoListProductLink link : links) {
            MesBuildingWarehouseSummary record = summaryMap.get(link.getWarehouseRecordId());
            Preconditions.checkArgument(record != null, "发运失败,入库记录不存在!!!");
            WarehouseSaveDTOParam dtoParam = WarehouseSaveDTOParam.builder()
               .projectId(record.getProjectId())
               .monomerId(record.getMonomerId())
               .areaId(record.getAreaId())
               .areaBatchId(record.getAreaBatchId())
               .planId(record.getPlanId())
               .factoryId(record.getFactoryId())
               .productId(record.getProductId())
               .productType(record.getProductType())
               .workshopId(record.getWorkshopId())
               .type(WarehouseTypeEnum.OUT.getType())
               .warehouseType(record.getWarehouseType())
               .build();
            if (!ProductTypeEnum.ARTIFACT.getType().equals(record.getProductType()) && !ProductTypeEnum.ASSEMBLE.getType().equals(record.getProductType())) {
               dtoParam.setQuantity(link.getQuantity());
               this.warehouseBiz.setStockQuantity(dtoParam);
            } else {
               List<MesBuildingCargoListProductNumberLink> numberLinks = this.cargoListProductNumberLinkService
                  .list(
                     (Wrapper<MesBuildingCargoListProductNumberLink>)new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                        .eq(MesBuildingCargoListProductNumberLink::getCargoListLinkId, link.getId())
                  );
               numberLinks.forEach(numberLink -> {
                  dtoParam.setNumber(numberLink.getNumber());
                  dtoParam.setQuantity(BigDecimal.ONE);
                  this.warehouseBiz.setStockQuantity(dtoParam);
               });
            }
         }

         this.buildOutManufactured(links, summaryMap);
         JSONObject message = new JSONObject();
         message.put("licensePlate", cargoList.getLicensePlate());
         message.put("name", cargoList.getDriverName());
         message.put("phone", cargoList.getDriverPhone());
         this.smsUtils.sendSms(cargoList.getReceiptPhone(), message.toJSONString(), "SMS_195585812");
      } else {
         cargoList.setStatus(CargoListStatusEnum.LOADING.getType());
         cargoList.setActualUserId(null);
         cargoList.setActualUserName(null);
         cargoList.setActualTime(null);
         cargoList.setActualWeight(null);
      }

      this.cargoListService.updateById(cargoList);
      project.setHappenedAmount(this.getProjectShipAmount(cargoList.getProjectId(), null));
      project.setBoolArrears(
         project.getCollectionAmount().compareTo(project.getHappenedAmount()) < 0
            ? ProjectBoolArrearsEnum.TRUE.getType()
            : ProjectBoolArrearsEnum.FALSE.getType()
      );
      this.contractProjectService.updateById(project);
      return true;
   }

   private void buildOutManufactured(List<MesBuildingCargoListProductLink> allProductLinks, Map<Long, MesBuildingWarehouseSummary> summaryMap) {
      List<MesBuildingCargoListProductLink> productLinkList = allProductLinks.stream()
         .filter(e -> e.getWarehouseType().equals(WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()))
         .filter(e -> !e.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(productLinkList)) {
         List<OutboundManufacturedVORequest> outboundManufacturedVORequests = new ArrayList<>();

         for (MesBuildingCargoListProductLink link : productLinkList) {
            MesBuildingWarehouseSummary record = summaryMap.get(link.getWarehouseRecordId());
            Integer basicClass = null;
            if (record.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               basicClass = BasicClassEnum.STRUC_MANUFACTURED.getType();
            }

            if (record.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               basicClass = BasicClassEnum.ENCL_MANUFACTURED.getType();
            }

            Preconditions.checkArgument(basicClass != null, "操作失败,暂只支持构件/围护申购出库!");
            OutboundManufacturedVORequest outboundManufacturedVORequest = OutboundManufacturedVORequest.builder()
               .materialInventoryId(record.getMaterialInventoryId())
               .productId(record.getProductId())
               .quantity(link.getQuantity())
               .userId(UserUtil.getCurrentUserId())
               .outboundTime(LocalDateTime.now())
               .basicClass(basicClass)
               .build();
            outboundManufacturedVORequests.add(outboundManufacturedVORequest);
         }

         if (CollectionUtils.isNotEmpty(outboundManufacturedVORequests)) {
            this.manufacturedMesManager.insertOutManufactured(outboundManufacturedVORequests);
         }
      }
   }

   @Override
   public PageVO pageAppCargoList(AppCargoListDTOParam param) {
      PageVO<CargoListDO> cargoLists = this.cargoListService.pageByCondition(BeanUtil.copy(param, CargoListDOParam.class));
      PageVO<CargoListRecordDTO> result = new PageVO<>();
      result.setContent(
         cargoLists.getContent()
            .stream()
            .sorted(Comparator.comparing(CargoListDO::getLoadingTime).reversed())
            .filter(e -> !ShipmentStatusEnum.ABOLISH_DELIVERY.getType().equals(e.getShipmentStatus()))
            .map(e -> BeanUtil.copy(e, CargoListRecordDTO.class))
            .collect(Collectors.toList())
      );
      result.setHasNextPage(cargoLists.isHasNextPage());
      result.setHasPreviousPage(cargoLists.isHasPreviousPage());
      result.setTotalElements(cargoLists.getTotalElements());
      return result;
   }

   @Override
   public PageVO<CargoListShipDTO> pageShip(CargoListShipDTOParam param) {
      CargoListDOParam copy = BeanUtil.copy(param, CargoListDOParam.class);
      copy.setStatus(
         CargoListStatusEnum.LOADING.getType()
            | CargoListStatusEnum.SHIPMENT.getType()
            | CargoListStatusEnum.RECEIPT.getType()
            | CargoListStatusEnum.WEIGH.getType()
      );
      if (!param.getBoolContainUnShip()) {
         copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType());
      }

      if (StringUtils.isNotEmpty(param.getBlurry()) || param.getMonomerId() != null) {
         copy.setIds(
            this.cargoListProductLinkService
               .listCargoListIdByCondition(param.getProjectId(), param.getBlurry(), param.getBoolAccurateQuery(), param.getMonomerId())
         );
      }

      if (copy.getIds() != null && copy.getIds().size() == 0) {
         return new PageVO<>();
      }

      PageVO<CargoListDO> cargoLists = this.cargoListService.pageByCondition(copy);
      if (CollectionUtils.isNotEmpty(cargoLists.getContent())) {
         cargoLists.getContent().forEach(e -> {
            if (StringUtils.isNotBlank(e.getSerialNumber())) {
               String[] split = e.getSerialNumber().split("-");
               e.setEmissionQuantity(Integer.valueOf(split[split.length - 1]));
            }
         });
      }

      PageVO<CargoListShipDTO> result = new PageVO<>();
      result.setContent(
         cargoLists.getContent()
            .stream()
            .filter(
               e -> copy.getMinNum() != null
                  ? e.getTotalNetWeight()
                        .subtract(e.getActualWeight())
                        .divide(e.getTotalNetWeight(), 4, RoundingMode.HALF_UP)
                        .multiply(new BigDecimal(100))
                        .compareTo(new BigDecimal(copy.getMinNum()))
                     >= 0
                  : e.getId() != null
            )
            .filter(
               e -> copy.getMaxNum() != null
                  ? e.getTotalNetWeight()
                        .subtract(e.getActualWeight())
                        .divide(e.getTotalNetWeight(), 4, RoundingMode.HALF_UP)
                        .multiply(new BigDecimal(100))
                        .compareTo(new BigDecimal(copy.getMaxNum()))
                     <= 0
                  : e.getId() != null
            )
            .map(e -> {
               CargoListShipDTO cargoListShipDTO = BeanUtil.copy(e, CargoListShipDTO.class);
               cargoListShipDTO.setCheckStatus((e.getStatus() & (CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType())) > 0 ? 1 : 2);
               CargoLogisticsDTO logisticsDTO = BeanUtil.copy(e, CargoLogisticsDTO.class);
               logisticsDTO.setPrice(e.getSupplier() == null ? null : e.getSupplier().getPrice());
               logisticsDTO.setPriceType(e.getPriceType());
               cargoListShipDTO.setReceiptStatus((e.getStatus() & CargoListStatusEnum.RECEIPT.getType()) > 0 ? 1 : 2);
               cargoListShipDTO.setLogisticsDTO(logisticsDTO);
               cargoListShipDTO.setAttachmentList(this.attachmentService.listByIds(e.getAttachmentIds()));
               return cargoListShipDTO;
            })
            .collect(Collectors.toList())
      );
      result.setHasNextPage(cargoLists.isHasNextPage());
      result.setHasPreviousPage(cargoLists.isHasPreviousPage());
      result.setTotalElements(cargoLists.getTotalElements());
      return result;
   }

   @Override
   public Map cargoListMeteSummary(LocalDateTime dateTime, Long projectId, Integer projectType, LocalDateTime auditStartDate, LocalDateTime auditEndDate) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      Map map = new HashMap();
      if (CollectionUtils.isNotEmpty(projectIds)) {
         map.put("yearQuantity", this.cargoListService.cargoListMeteSumQuantity(dateTime, projectId, 1, projectIds, auditStartDate, auditEndDate));
         map.put("yearMete", this.cargoListService.cargoListMeteSumMete(dateTime, projectId, 1, projectIds, auditStartDate, auditEndDate));
         map.put("monthMete", this.cargoListService.cargoListMeteSumMete(dateTime, projectId, 2, projectIds, null, null));
         map.put("monthQuantity", this.cargoListService.cargoListMeteSumQuantity(dateTime, projectId, 2, projectIds, null, null));
      }

      return map;
   }

   @Override
   public Map<String, Object> getShipDetail(Long id) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(id);
      Preconditions.checkArgument(cargoList != null, "未查询到相关发运信息");
      Map<String, Object> result = new HashMap<>();
      List<ArtifactShipDO> artifactShipDOList = this.listShipArtifactAndPartSend(id);
      result.put("artifactList", artifactShipDOList);
      List<PartShipDO> partShipDOS = this.cargoListProductLinkService.listPartAllById(id);
      List<PartShipDO> partShipDOS1 = this.cargoListProductLinkService.listAssembleAllById(id);
      partShipDOS.addAll(partShipDOS1);
      result.put("partList", partShipDOS);
      List<EnclosureShipDO> enclosureShipDOList = this.cargoListProductLinkService.listEnclosureAllById(id);
      result.put("enclosureList", enclosureShipDOList);
      List<TechStandardPartShipDO> standardPartShipDOList = this.cargoListProductLinkService.listAuxiliaryMaterialAllById(id);
      result.put("auxiliaryMaterialList", standardPartShipDOList);
      this.handlePrice(id, artifactShipDOList, enclosureShipDOList, standardPartShipDOList);
      List<CargoListDetailsCommonDTO> detailsCommonDTOList = this.getCommonList(artifactShipDOList, partShipDOS, enclosureShipDOList, standardPartShipDOList);
      result.put("detailsList", detailsCommonDTOList);
      if (cargoList.getReceiveAttachmentId() != null) {
         AttachmentDTO attachmentDTO = this.attachmentService.getById(cargoList.getReceiveAttachmentId());
         result.put("receiveAttachment", attachmentDTO);
      }

      return result;
   }

   private List<CargoListDetailsCommonDTO> getCommonList(
      List<ArtifactShipDO> artifactShipDOS,
      List<PartShipDO> partShipDOS,
      List<EnclosureShipDO> enclosureShipDOS,
      List<TechStandardPartShipDO> standardPartShipDOS
   ) {
      List<CargoListDetailsCommonDTO> detailsList = new ArrayList<>();
      artifactShipDOS.forEach(artifactShipDO -> {
         CargoListDetailsCommonDTO commonDTO = BeanUtil.copy(artifactShipDO, CargoListDetailsCommonDTO.class);
         commonDTO.setProductType(ProductTypeEnum.ARTIFACT.getType());
         commonDTO.setProductId(artifactShipDO.getCargoProductId());
         commonDTO.setMeasureUnit("件");
         commonDTO.setAccountingUnit(artifactShipDO.getUnit());
         detailsList.add(commonDTO);
      });
      partShipDOS.forEach(partShipDO -> {
         CargoListDetailsCommonDTO commonDTO = BeanUtil.copy(partShipDO, CargoListDetailsCommonDTO.class);
         commonDTO.setProductId(partShipDO.getCargoProductId());
         commonDTO.setMeasureUnit("件");
         commonDTO.setAccountingUnit(partShipDO.getUnit());
         detailsList.add(commonDTO);
      });
      if (CollectionUtils.isNotEmpty(enclosureShipDOS)) {
         enclosureShipDOS.forEach(enclosureShipDO -> {
            CargoListDetailsCommonDTO commonDTO = BeanUtil.copy(enclosureShipDO, CargoListDetailsCommonDTO.class);
            commonDTO.setProductId(enclosureShipDO.getCargoProductId());
            commonDTO.setMeasureUnit("张");
            commonDTO.setAccountingUnit(enclosureShipDO.getUnit());
            detailsList.add(commonDTO);
         });
      }

      standardPartShipDOS.forEach(standardPartShipDO -> {
         CargoListDetailsCommonDTO commonDTO = BeanUtil.copy(standardPartShipDO, CargoListDetailsCommonDTO.class);
         commonDTO.setProductId(standardPartShipDO.getCargoProductId());
         detailsList.add(commonDTO);
      });
      return detailsList;
   }

   @Override
   public PrintVO printShip(CargoListShipDTOParam param) {
      PrintVO printVO = new PrintVO();
      Map header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("statisticsDate", System.currentTimeMillis());
      header.put("totalActualWeight", BigDecimal.ZERO);
      List<Map<String, Object>> table = new ArrayList<>();
      CargoListDOParam copy = BeanUtil.copy(param, CargoListDOParam.class);
      copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType());
      if (StringUtils.isNotEmpty(param.getBlurry())) {
         copy.setIds(this.cargoListProductLinkService.listCargoListIdByCondition(param.getProjectId(), param.getBlurry(), param.getBoolAccurateQuery(), null));
      }

      if (copy.getIds() == null || copy.getIds().size() != 0) {
         List<CargoListDO> cargoLinks = this.cargoListService.listByCondition(copy);
         cargoLinks.forEach(cargoLink -> {
            CargoListShipDTO shipDTO = BeanUtil.copy(cargoLink, CargoListShipDTO.class);
            table.add(BeanUtil.beanToMap(shipDTO));
         });
         BigDecimal totalActualWeight = cargoLinks.stream().map(CargoListDO::getActualWeight).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("totalActualWeight", totalActualWeight);
      }

      printVO.setHeader(header);
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public PrintVO printShipDetail(Long id) {
      PrintVO printVO = new PrintVO();
      Map header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("statisticsDate", System.currentTimeMillis());
      MesBuildingCargoList cargoList = this.cargoListService.getById(id);
      Preconditions.checkArgument(cargoList != null, "导出失败，发货清单不存在");
      ContractProject project = this.contractProjectService.getById(cargoList.getProjectId());
      header.put("project", BeanUtil.copy(project, ProjectInfo.class));
      StringBuffer address = new StringBuffer("");
      address.append(project.getCountryName() != null ? project.getCountryName() : "");
      address.append(project.getProvinceName() != null ? project.getProvinceName() : "");
      address.append(project.getCityName() != null ? project.getCityName() : "");
      address.append(project.getRegionName() != null ? project.getRegionName() : "");
      address.append(project.getAddress() != null ? project.getAddress() : "");
      header.put("address", address);
      header.put("customerUnit", project.getCustomerUnit());
      header.put("serialNumber", cargoList.getSerialNumber());
      header.put("licensePlate", cargoList.getLicensePlate());
      if (cargoList.getStatus().equals(4) || cargoList.getStatus().equals(8)) {
         header.put("actualTime", cargoList.getActualTime());
      }

      header.put("receiptName", cargoList.getReceiptName());
      header.put("receiptPhone", cargoList.getReceiptPhone());
      header.put("driverName", cargoList.getDriverName());
      header.put("driverPhone", cargoList.getDriverPhone());
      header.put("carModel", cargoList.getCarModel());
      header.put("actualGrossWeight", 0);
      header.put("actualWeight", 0);
      header.put("emptyCars", 0);
      if (cargoList.getActualGrossWeight() != null && cargoList.getActualGrossWeight().compareTo(BigDecimal.ZERO) != 0) {
         header.put("actualGrossWeight", cargoList.getActualGrossWeight().divide(BigDecimal.valueOf(1000L), 3));
      }

      if (cargoList.getActualWeight() != null && cargoList.getActualWeight().compareTo(BigDecimal.ZERO) != 0) {
         header.put("actualWeight", cargoList.getActualWeight().divide(BigDecimal.valueOf(1000L), 3));
      }

      if (cargoList.getEmptyCars() != null && cargoList.getEmptyCars().compareTo(BigDecimal.ZERO) != 0) {
         header.put("emptyCars", cargoList.getEmptyCars().divide(BigDecimal.valueOf(1000L), 3));
      }

      if (StringUtils.isNotBlank(cargoList.getSerialNumber())) {
         String[] split = cargoList.getSerialNumber().split("-");
         header.put("emissionQuantity", Integer.valueOf(split[split.length - 1]));
      }

      header.put("emissionQuantity", cargoList.getCarModel());
      if (cargoList.getSupplierPriceId() != null) {
         MesBuildingSupplierPrice supplierPrice = this.supplierPriceService.getById(cargoList.getSupplierPriceId());
         Supplier supplier = this.supplierService.getById(supplierPrice.getSupplierId());
         header.put("supplierName", supplier == null ? "" : supplier.getName());
      } else {
         header.put("supplierName", TransportTypeEnum.PUBLIC_TRANSFER.getName());
      }

      printVO.setHeader(header);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("id", id);
      jsonObject.put("type", 2);
      jsonObject.put("ftype", 2);
      printVO.setQrCode(jsonObject.toString());
      List<Map<String, Object>> table = new ArrayList<>();
      List<ArtifactShipDO> artifacts = this.listShipArtifactAndPartSend(id);
      List<EnclosureShipDO> enclosures = this.cargoListProductLinkService.listEnclosureAllById(id);
      List<TechStandardPartShipDO> auxiliaryMaterials = this.cargoListProductLinkService.listAuxiliaryMaterialAllById(id);
      List<PartShipDO> partShipDOS = this.cargoListProductLinkService.listPartAllById(id);
      List<PartShipDO> assembleShipDOS = this.cargoListProductLinkService.listAssembleAllById(id);
      partShipDOS.addAll(assembleShipDOS);
      if (CollectionUtils.isNotEmpty(artifacts)) {
         artifacts.forEach(artifact -> {
            Map<String, Object> item = BeanUtil.beanToMap(artifact);
            item.put("unit", "件");
            table.add(item);
         });
      }

      if (CollectionUtils.isNotEmpty(partShipDOS)) {
         partShipDOS.forEach(ship -> {
            Map<String, Object> item = BeanUtil.beanToMap(ship);
            item.put("unit", "件");
            table.add(item);
         });
      }

      if (CollectionUtils.isNotEmpty(enclosures)) {
         enclosures.forEach(enclosure -> {
            Map<String, Object> item = BeanUtil.beanToMap(enclosure);
            item.put("unit", "张");
            table.add(item);
         });
      }

      if (CollectionUtils.isNotEmpty(auxiliaryMaterials)) {
         auxiliaryMaterials.forEach(auxiliaryMaterial -> {
            Map<String, Object> item = BeanUtil.beanToMap(auxiliaryMaterial);
            item.put("unit", auxiliaryMaterial.getMeasureUnit());
            table.add(item);
         });
      }

      printVO.setTable(table);
      Map<String, Object> footer = new HashMap<>(16);
      footer.put("userName", StringUtils.isBlank(cargoList.getUserNames()) ? cargoList.getUserName() : cargoList.getUserNames());
      footer.put("auditUserName", StringUtils.isBlank(cargoList.getAuditUserName()) ? "" : cargoList.getAuditUserName());
      footer.put("actualUserName", StringUtils.isBlank(cargoList.getActualUserName()) ? "" : cargoList.getActualUserName());
      printVO.setFooter(footer);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printShipDayOrMonthSummary(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer type) {
      PrintVO printVO = new PrintVO();
      List<CargoDayOrMonthSummaryDTO> dtos = this.cargoListService.printShipDayOrMonthSummary(projectId, startDate, endDate, type);
      if (type == 2) {
         if (startDate != null && endDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            dtos.forEach(s -> s.setDate(formatter.format(startDate) + "~" + formatter.format(endDate)));
         } else {
            dtos.forEach(s -> s.setDate("ALL"));
         }
      }

      printVO.setTable(dtos.stream().map(s -> BeanUtil.beanToMap(s)).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public CargoListMeteDTO getShipMeteByCondition(CargoListShipDTOParam param) {
      CargoListDOParam copy = BeanUtil.copy(param, CargoListDOParam.class);
      copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType());
      List<Long> projectIds = this.projectService
         .listSimpleProject(param.getProjectType(), null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (StringUtils.isNotEmpty(param.getBlurry())) {
         copy.setIds(this.cargoListProductLinkService.listCargoListIdByCondition(param.getProjectId(), param.getBlurry(), param.getBoolAccurateQuery(), null));
      }

      if ((copy.getIds() == null || copy.getIds().size() != 0) && !CollectionUtils.isEmpty(projectIds)) {
         copy.setProjectIds(projectIds);
         List<CargoListDO> cargoListDOS = this.cargoListService.listByCondition(copy);
         return CargoListMeteDTO.builder()
            .weight(
               cargoListDOS.stream()
                  .filter(e -> !ShipmentStatusEnum.ABOLISH_DELIVERY.getType().equals(e.getShipmentStatus()))
                  .filter(e -> CargoListStatusEnum.SHIPMENT.getType().equals(e.getStatus()) || CargoListStatusEnum.RECEIPT.getType().equals(e.getStatus()))
                  .filter(
                     e -> copy.getMinNum() != null
                        ? e.getTotalNetWeight()
                              .subtract(e.getActualWeight())
                              .divide(e.getTotalNetWeight(), 4, RoundingMode.HALF_UP)
                              .multiply(new BigDecimal(100))
                              .compareTo(new BigDecimal(copy.getMinNum()))
                           >= 0
                        : e.getId() != null
                  )
                  .filter(
                     e -> copy.getMaxNum() != null
                        ? e.getTotalNetWeight()
                              .subtract(e.getActualWeight())
                              .divide(e.getTotalNetWeight(), 4, RoundingMode.HALF_UP)
                              .multiply(new BigDecimal(100))
                              .compareTo(new BigDecimal(copy.getMaxNum()))
                           <= 0
                        : e.getId() != null
                  )
                  .map(CargoListDO::getTotalNetWeight)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .actualWeight(
               cargoListDOS.stream()
                  .filter(e -> !ShipmentStatusEnum.ABOLISH_DELIVERY.getType().equals(e.getShipmentStatus()))
                  .filter(e -> CargoListStatusEnum.SHIPMENT.getType().equals(e.getStatus()) || CargoListStatusEnum.RECEIPT.getType().equals(e.getStatus()))
                  .filter(
                     e -> copy.getMinNum() != null
                        ? e.getTotalNetWeight()
                              .subtract(e.getActualWeight())
                              .divide(e.getTotalNetWeight(), 4, RoundingMode.HALF_UP)
                              .multiply(new BigDecimal(100))
                              .compareTo(new BigDecimal(copy.getMinNum()))
                           >= 0
                        : e.getId() != null
                  )
                  .filter(
                     e -> copy.getMaxNum() != null
                        ? e.getTotalNetWeight()
                              .subtract(e.getActualWeight())
                              .divide(e.getTotalNetWeight(), 4, RoundingMode.HALF_UP)
                              .multiply(new BigDecimal(100))
                              .compareTo(new BigDecimal(copy.getMaxNum()))
                           <= 0
                        : e.getId() != null
                  )
                  .map(CargoListDO::getActualWeight)
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
            )
            .build();
      } else {
         return CargoListMeteDTO.builder().weight(BigDecimal.ZERO).build();
      }
   }

   @Override
   public PageVO<CargoListReceiptDTO> pageReceipt(CargoListReceiptDTOParam param) {
      CargoListDOParam copy = BeanUtil.copy(param, CargoListDOParam.class);
      if (param.getReceiptStatus() != null) {
         copy.setStatus(param.getReceiptStatus() == 1 ? CargoListStatusEnum.RECEIPT.getType() : CargoListStatusEnum.SHIPMENT.getType());
      } else {
         copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType());
      }

      if (StringUtils.isNotEmpty(param.getBlurry())) {
         copy.setIds(this.cargoListProductLinkService.listCargoListIdByCondition(param.getProjectId(), param.getBlurry(), Boolean.FALSE, null));
      }

      if (copy.getIds() != null && copy.getIds().size() == 0) {
         return new PageVO<>();
      }

      PageVO<CargoListDO> cargoLists = this.cargoListService.pageByCondition(copy);
      PageVO<CargoListReceiptDTO> result = new PageVO<>();
      result.setContent(cargoLists.getContent().stream().map(e -> {
         CargoListReceiptDTO review = BeanUtil.copy(e, CargoListReceiptDTO.class);
         CargoLogisticsDTO logisticsDTO = BeanUtil.copy(e, CargoLogisticsDTO.class);
         logisticsDTO.setPrice(e.getSupplier() == null ? null : e.getSupplier().getPrice());
         logisticsDTO.setPriceType(e.getPriceType());
         review.setReceiptStatus((e.getStatus() & CargoListStatusEnum.RECEIPT.getType()) > 0 ? 1 : 2);
         review.setLogisticsDTO(logisticsDTO);
         return review;
      }).collect(Collectors.toList()));
      result.setHasNextPage(cargoLists.isHasNextPage());
      result.setHasPreviousPage(cargoLists.isHasPreviousPage());
      result.setTotalElements(cargoLists.getTotalElements());
      return result;
   }

   @Override
   public PrintVO printReceipt(CargoListReceiptDTOParam param) {
      PrintVO printVO = new PrintVO();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("statisticsDate", System.currentTimeMillis());
      printVO.setHeader(header);
      List<Map<String, Object>> table = new ArrayList<>();
      CargoListDOParam copy = BeanUtil.copy(param, CargoListDOParam.class);
      if (param.getReceiptStatus() != null) {
         copy.setStatus(param.getReceiptStatus() == 1 ? CargoListStatusEnum.RECEIPT.getType() : CargoListStatusEnum.SHIPMENT.getType());
      } else {
         copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType());
      }

      if (copy.getIds() == null || copy.getIds().size() != 0) {
         PageHelper.startPage(param.getPageNumber(), param.getPageSize());
         List<CargoListDO> cargoLinks = this.cargoListService.listByCondition(copy);
         cargoLinks.forEach(cargoLink -> {
            CargoListReceiptDTO receipt = BeanUtil.copy(cargoLink, CargoListReceiptDTO.class);
            receipt.setReceiptStatus((cargoLink.getStatus() & CargoListStatusEnum.RECEIPT.getType()) > 0 ? 1 : 2);
            table.add(BeanUtil.beanToMap(receipt));
         });
      }

      printVO.setTable(table);
      return printVO;
   }

   @Override
   public PageVO<CargoListLogisticsDTO> pageLogistics(CargoListLogisticsDTOParam param) {
      CargoListDOParam copy = BeanUtil.copy(param, CargoListDOParam.class);
      copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType());
      if (param.getTransportMode() != null) {
         copy.setProjectIds(
            this.contractProjectService
               .list(
                  (Wrappers.<ContractProject>lambdaQuery().eq(ContractProject::getTransportMode, param.getTransportMode()))
                     .eq(param.getProjectId() != null, ContractProject::getId, param.getProjectId())
               )
               .stream()
               .map(ContractProject::getId)
               .collect(Collectors.toList())
         );
      }

      PageVO<CargoListDO> cargoLists = this.cargoListService.pageByCondition(copy);
      PageVO<CargoListLogisticsDTO> result = new PageVO<>();
      result.setContent(cargoLists.getContent().stream().map(cargoList -> {
         CargoListLogisticsDTO logisticsDTO = BeanUtil.copy(cargoList, CargoListLogisticsDTO.class);
         logisticsDTO.setShipmentStatus(ShipmentStatusEnum.getName(cargoList.getShipmentStatus()));
         logisticsDTO.setUserNames(StringUtils.isNotBlank(logisticsDTO.getUserNames()) ? logisticsDTO.getUserNames() : logisticsDTO.getUserName());
         return logisticsDTO;
      }).collect(Collectors.toList()));
      result.setHasNextPage(cargoLists.isHasNextPage());
      result.setHasPreviousPage(cargoLists.isHasPreviousPage());
      result.setTotalElements(cargoLists.getTotalElements());
      return result;
   }

   @Override
   public Boolean cargoListPriceChange(CargoListPriceChangeDTOParam param) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(param.getId());
      Preconditions.checkArgument(cargoList != null, "操作失败：id不正确");
      Preconditions.checkArgument(!ChangeFreightEnum.FREIGHT_INVALID.getType().equals(cargoList.getChangeFreight()), "操作失败,运费已作废不支持修改价格");
      if ((cargoList.getProductType() & ProductTypeEnum.ARTIFACT.getType()) > 0) {
         Preconditions.checkArgument(TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(cargoList.getTransportMode()), "操作失败：客户自提(构件)不支持修改价格");
      }

      if ((cargoList.getProductType() & ProductTypeEnum.ENCLOSURE.getType()) > 0) {
         Preconditions.checkArgument(TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(cargoList.getEnclosureTransportMode()), "操作失败：客户自提(围护)不支持修改价格");
      }

      if ((cargoList.getProductType() & ProductTypeEnum.AUXILIARY_MATERIAL.getType()) > 0) {
         Preconditions.checkArgument(
            TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(cargoList.getEnclosureTransportMode())
               || TransportTypeEnum.PRIVATE_TRANSFER.getType().equals(cargoList.getTransportMode()),
            "操作失败：客户自提(辅材)不支持修改价格"
         );
      }

      if (this.cargoListChangeService
            .count((Wrapper<MesBuildingCargoListChange>)Wrappers.<MesBuildingCargoListChange>lambdaQuery().eq(MesBuildingCargoListChange::getCargoListId, param.getId()))
         == 0) {
         MesBuildingCargoListChange change = MesBuildingCargoListChange.builder()
            .cargoListId(cargoList.getId())
            .price(cargoList.getPrice())
            .changeUserId(cargoList.getUserId())
            .totalPrice(cargoList.getTotalPrice())
            .priceType(cargoList.getPriceType())
            .build();
         change.setUpdateTime(cargoList.getCreateTime());
         change.setChangeUserName(this.userService.getNameById(change.getChangeUserId()));
         this.cargoListChangeService.save(change);
      }

      cargoList.setPriceType(param.getPriceType());
      cargoList.setPrice(param.getPrice());
      if (param.getPriceType().equals(SupplierPriceTypeEnum.WEIGHT.getType())) {
         cargoList.setTotalPrice(cargoList.getActualWeight().divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP).multiply(param.getPrice()));
      } else {
         cargoList.setTotalPrice(param.getPrice().setScale(2, RoundingMode.HALF_UP));
      }

      this.cargoListService.updateById(cargoList);
      MesBuildingCargoListChange newChange = MesBuildingCargoListChange.builder()
         .cargoListId(cargoList.getId())
         .price(cargoList.getPrice())
         .changeUserId(UserUtil.getCurrentUserId())
         .totalPrice(cargoList.getTotalPrice())
         .priceType(cargoList.getPriceType())
         .build();
      newChange.setUpdateTime(LocalDateTime.now());
      newChange.setChangeUserName(this.userService.getNameById(newChange.getChangeUserId()));
      this.cargoListChangeService.save(newChange);
      return true;
   }

   @Override
   public Object cargoListPriceChangeLog(Long id) {
      return this.cargoListChangeService
         .list(
            (Wrapper<MesBuildingCargoListChange>)(Wrappers.<MesBuildingCargoListChange>lambdaQuery().eq(MesBuildingCargoListChange::getCargoListId, id))
               .orderByDesc(BaseEntity::getCreateTime)
         );
   }

   @Override
   public ListVO listLogistics(CargoListLogisticsDTOParam param) {
      CargoListDOParam copy = BeanUtil.copy(param, CargoListDOParam.class);
      copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType());
      if (param.getTransportMode() != null) {
         copy.setProjectIds(
            this.contractProjectService
               .list(
                  (Wrappers.<ContractProject>lambdaQuery().eq(ContractProject::getTransportMode, param.getTransportMode()))
                     .eq(param.getProjectId() != null, ContractProject::getId, param.getProjectId())
               )
               .stream()
               .map(ContractProject::getId)
               .collect(Collectors.toList())
         );
      }

      return copy.getIds() != null && copy.getIds().size() == 0
         ? new ListVO()
         : new ListVO(
            this.cargoListService
               .listByCondition(copy)
               .stream()
               .map(cargoList -> BeanUtil.copy(cargoList, CargoListLogisticsDTO.class))
               .collect(Collectors.toList())
         );
   }

   @Override
   public PrintVO printLogistics(CargoListLogisticsDTOParam param) {
      PrintVO printVO = new PrintVO();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("statisticsDate", System.currentTimeMillis());
      printVO.setHeader(header);
      List<Map<String, Object>> table = new ArrayList<>();
      CargoListDOParam copy = BeanUtil.copy(param, CargoListDOParam.class);
      copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType());
      if (param.getTransportMode() != null) {
         copy.setProjectIds(
            this.contractProjectService
               .list(
                  (Wrappers.<ContractProject>lambdaQuery().eq(ContractProject::getTransportMode, param.getTransportMode()))
                     .eq(param.getProjectId() != null, ContractProject::getId, param.getProjectId())
               )
               .stream()
               .map(ContractProject::getId)
               .collect(Collectors.toList())
         );
      }

      if (copy.getIds() == null || copy.getIds().size() != 0) {
         List<CargoListDO> cargoLists = this.cargoListService.listByCondition(copy);
         if (CollectionUtils.isNotEmpty(cargoLists)) {
            List<CargoListDO> collect = cargoLists.stream().sorted(Comparator.comparing(CargoListDO::getLoadingTime)).collect(Collectors.toList());
            collect.forEach(cargoList -> {
               CargoListLogisticsDTO review = BeanUtil.copy(cargoList, CargoListLogisticsDTO.class);
               review.setShipmentStatus(ShipmentStatusEnum.getName(cargoList.getShipmentStatus()));
               Map<String, Object> item = BeanUtil.beanToMap(review);
               table.add(item);
            });
         }
      }

      printVO.setTable(table);
      return printVO;
   }

   @Override
   public PageVO<CargoListReviewDTO> pageReview(CargoListReviewDTOParam param) {
      CargoListDOParam copy = BeanUtil.copy(param, CargoListDOParam.class);
      if (param.getCheckStatus() != null) {
         copy.setStatus(
            param.getCheckStatus() == 1 ? CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType() : CargoListStatusEnum.WEIGH.getType()
         );
      } else {
         copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType() | CargoListStatusEnum.WEIGH.getType());
      }

      PageVO<CargoListDO> cargoLists = this.cargoListService.pageByCondition(copy);
      PageVO<CargoListReviewDTO> result = new PageVO<>();
      List<CargoListReviewDTO> collect = cargoLists.getContent().stream().map(e -> {
         CargoListReviewDTO review = BeanUtil.copy(e, CargoListReviewDTO.class);
         if (StringUtils.isNotBlank(review.getUserNames())) {
            review.setUserName(review.getUserNames());
         }

         review.setCheckStatus((e.getStatus() & (CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType())) > 0 ? 1 : 2);
         review.setShipmentStatus(ShipmentStatusEnum.getName(e.getShipmentStatus()));
         if (StringUtils.isNotBlank(review.getSerialNumber())) {
            String[] split = review.getSerialNumber().split("-");
            review.setEmissionQuantity(Integer.valueOf(split[split.length - 1]));
         }

         return review;
      }).collect(Collectors.toList());
      this.handleListPrice(collect);
      result.setContent(collect.stream().sorted(Comparator.comparing(CargoListReviewDTO::getCheckStatus)).collect(Collectors.toList()));
      result.setHasNextPage(cargoLists.isHasNextPage());
      result.setHasPreviousPage(cargoLists.isHasPreviousPage());
      result.setTotalElements(cargoLists.getTotalElements());
      return result;
   }

   private void handleListPrice(List<CargoListReviewDTO> collect) {
      if (CollectionUtils.isNotEmpty(collect)) {
         List<MesBuildingCargoListProductLink> cargoListProductLinks = this.cargoListProductLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingCargoListProductLink.class)
                  .in(MesBuildingCargoListProductLink::getCargoListId, collect.stream().map(CargoListReviewDTO::getId).collect(Collectors.toList()))
            );
         List<CargoListProductLinkPriceDTO> cargoLinkPriceList = this.businessPriceUtils.getCargoLinkPrice(cargoListProductLinks);
         Map<Long, List<BigDecimal>> cargoListIdLinkUnitPriceMap = cargoLinkPriceList.stream()
            .collect(
               Collectors.groupingBy(
                  CargoListProductLinkPriceDTO::getCargoListId, Collectors.mapping(CargoListProductLinkPriceDTO::getUnitPrice, Collectors.toList())
               )
            );
         Map<Long, BigDecimal> cargoListIdTotalPriceMap = cargoLinkPriceList.stream()
            .filter(c -> c.getTotalPrice() != null)
            .collect(
               Collectors.groupingBy(
                  CargoListProductLinkPriceDTO::getCargoListId,
                  Collectors.reducing(BigDecimal.ZERO, CargoListProductLinkPriceDTO::getTotalPrice, BigDecimal::add)
               )
            );
         collect.forEach(review -> {
            List<BigDecimal> decimalList = cargoListIdLinkUnitPriceMap.get(review.getId());
            review.setBoolUnallocatedPrice(decimalList != null && decimalList.stream().anyMatch(Objects::isNull));
            review.setShipAmount(cargoListIdTotalPriceMap.get(review.getId()));
         });
      }
   }

   @Override
   public PrintVO printReview(CargoListReviewDTOParam param) {
      PrintVO printVO = new PrintVO();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("statisticsDate", System.currentTimeMillis());
      printVO.setHeader(header);
      List<Map<String, Object>> table = new ArrayList<>();
      CargoListDOParam copy = BeanUtil.copy(param, CargoListDOParam.class);
      copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType());
      if (param.getCheckStatus() != null) {
         copy.setStatus(
            param.getCheckStatus() == 1 ? CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType() : CargoListStatusEnum.WEIGH.getType()
         );
      } else {
         copy.setStatus(CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType() | CargoListStatusEnum.WEIGH.getType());
      }

      List<CargoListReviewDTO> collect = this.cargoListService.listByCondition(copy).stream().map(e -> {
         CargoListReviewDTO review = BeanUtil.copy(e, CargoListReviewDTO.class);
         review.setCheckStatus((e.getStatus() & (CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType())) > 0 ? 1 : 2);
         review.setShipmentStatus(ShipmentStatusEnum.getName(e.getShipmentStatus()));
         return review;
      }).collect(Collectors.toList());
      this.handleListPrice(collect);
      collect.forEach(e -> {
         if (StringUtils.isNotBlank(e.getUserNames())) {
            e.setUserName(e.getUserNames());
         }

         Map<String, Object> item = BeanUtil.beanToMap(e);
         table.add(item);
      });
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public Boolean reviewDetailDownload(Long id, HttpServletResponse response) {
      Map<String, Object> result = new HashMap<>();
      String resourcePath = "files/CargoReviewDetails.xls";
      String tempFileName = "CargoReviewDetails";
      String exportFileName = "发运审核详情.xls";
      AuditInfoDTO auditInfo = this.getAuditInfo(id);
      auditInfo.setDeliveryAmount(auditInfo.getDeliveryAmount().setScale(2, 4));
      auditInfo.setTotalDeliveryAmount(auditInfo.getTotalDeliveryAmount().setScale(4, 4));
      auditInfo.setSafeAmount(auditInfo.getSafeAmount().setScale(2, 4));
      auditInfo.setContractReceivableAmount(auditInfo.getContractReceivableAmount().setScale(2, 4));
      auditInfo.setContractAmount(auditInfo.getContractAmount().setScale(2, 4));
      ContractProject contractProject = this.contractProjectService.getById(auditInfo.getProjectId());
      MesBuildingCargoList cargoList = this.cargoListService.getById(id);
      List<ArtifactShipDO> artifacts = this.listShipArtifactAndPartSend(id);

      for (int i = 0; i < artifacts.size(); i++) {
         ArtifactShipDO artifactShipDO = artifacts.get(i);
         artifactShipDO.setPid(i + 1);
         artifactShipDO.setLength(artifactShipDO.getLength().setScale(0, 1));
         artifactShipDO.setNetWeight(artifactShipDO.getNetWeight().setScale(2, 4));
         artifactShipDO.setTotalWeight(artifactShipDO.getTotalWeight().stripTrailingZeros());
         artifactShipDO.setTotalWeight(artifactShipDO.getTotalWeight());
         if (!artifactShipDO.getBoolAllPartSendDirectly()) {
            if (PricingMannerEnum.WEIGHT.getType().equals(artifactShipDO.getPricingManner())) {
               artifactShipDO.setTotalPrice(
                  cargoList.getStructureMeasureMode().equals(StructureMeasureModeEnum.THEORY.getType())
                     ? artifactShipDO.getUnitPrice().multiply(artifactShipDO.getTotalNetWeight()).divide(new BigDecimal(1000), 4, 4)
                     : artifactShipDO.getUnitPrice().multiply(artifactShipDO.getTotalWeight()).divide(new BigDecimal(1000), 4, 4)
               );
            }

            if (PricingMannerEnum.LENGTH.getType().equals(artifactShipDO.getPricingManner())) {
               artifactShipDO.setTotalPrice(
                  artifactShipDO.getTotalLength().multiply(artifactShipDO.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
               );
            }
         }

         artifactShipDO.setTotalWeight(artifactShipDO.getTotalWeight().divide(new BigDecimal(1000)));
         artifactShipDO.setUnitPrice(artifactShipDO.getUnitPrice().setScale(2, 4));
         artifactShipDO.setTotalLength(artifactShipDO.getLength().multiply(artifactShipDO.getShipQuantity()).divide(new BigDecimal(1000)).setScale(4, 4));
         artifactShipDO.setAllWeight(
            cargoList.getStructureMeasureMode().equals(StructureMeasureModeEnum.THEORY.getType())
               ? artifactShipDO.getTotalNetWeight()
               : artifactShipDO.getTotalWeight()
         );
         if (PricingMannerEnum.WEIGHT.getType().equals(artifactShipDO.getPricingManner())) {
            artifactShipDO.setUnit("吨");
         }

         if (PricingMannerEnum.LENGTH.getType().equals(artifactShipDO.getPricingManner())) {
            artifactShipDO.setUnit("米");
         }
      }

      List<PartShipDO> parts = this.cargoListProductLinkService.listPartAllById(id);
      parts = parts.stream().peek(e -> {
         if (e.getBoolAllPartSendDirectly() != null && e.getBoolAllPartSendDirectly()) {
            if (com.hzchum.scim.business.core.api.enums.PricingMannerEnum.WEIGHT.getType().equals(e.getPricingManner())) {
               e.setTotalPrice(e.getTotalNetWeight().multiply(e.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP));
               e.setUnit("吨");
            }

            if (com.hzchum.scim.business.core.api.enums.PricingMannerEnum.LENGTH.getType().equals(e.getPricingManner())) {
               e.setTotalPrice(e.getTotalLength().multiply(e.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP));
               e.setUnit("米");
            }
         }
      }).collect(Collectors.toList());
      List<PartShipDO> assembles = this.cargoListProductLinkService.listAssembleAllById(id);
      assembles = assembles.stream().peek(e -> {
         if (e.getBoolAllPartSendDirectly() != null && e.getBoolAllPartSendDirectly()) {
            if (com.hzchum.scim.business.core.api.enums.PricingMannerEnum.WEIGHT.getType().equals(e.getPricingManner())) {
               e.setTotalPrice(e.getTotalNetWeight().multiply(e.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP));
               e.setUnit("吨");
            }

            if (com.hzchum.scim.business.core.api.enums.PricingMannerEnum.LENGTH.getType().equals(e.getPricingManner())) {
               e.setTotalPrice(e.getTotalLength().multiply(e.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP));
               e.setUnit("米");
            }
         }
      }).collect(Collectors.toList());
      parts.addAll(assembles);

      for (int i = 0; i < parts.size(); i++) {
         PartShipDO partShipDO = parts.get(i);
         partShipDO.setPid(i + 1);
         partShipDO.setLength(partShipDO.getLength().setScale(0, 1));
         partShipDO.setNetWeight(partShipDO.getNetWeight().setScale(2, 4));
         partShipDO.setTotalWeight(partShipDO.getTotalNetWeight().divide(new BigDecimal(1000).stripTrailingZeros()));
         partShipDO.setTotalLength(partShipDO.getLength().multiply(partShipDO.getShipQuantity()).divide(new BigDecimal(1000)).setScale(2, 4));
         partShipDO.setAllWeight(partShipDO.getTotalWeight());
      }

      List<EnclosureShipDO> enclosures = this.cargoListProductLinkService.listEnclosureAllById(id);

      for (int i = 0; i < enclosures.size(); i++) {
         Map<Integer, Integer> priceMap = this.utilsBiz.listEnclosureMeasureMode(contractProject.getId());
         EnclosureShipDO enclosureShipDO = enclosures.get(i);
         enclosureShipDO.setPid(i + 1);
         enclosureShipDO.setThickness(enclosureShipDO.getThickness() == null ? BigDecimal.ZERO : enclosureShipDO.getThickness().setScale(8, 4));
         enclosureShipDO.setWidth(enclosureShipDO.getWidth().setScale(8, 4));
         enclosureShipDO.setLength(enclosureShipDO.getLength().setScale(8, 4));
         enclosureShipDO.setTotalLength(enclosureShipDO.getTotalLength().divide(new BigDecimal(1000)).setScale(8, 4));
         enclosureShipDO.setMete(
            priceMap.get(enclosureShipDO.getCategory()).equals(EnclosureMeasureModeEnum.LENGTH_MODE.getType())
               ? enclosureShipDO.getTotalLength()
               : enclosureShipDO.getTotalArea()
         );
         if (EnclosurePricingMannerEnum.AREA.getType().equals(enclosureShipDO.getPricingManner())) {
            enclosureShipDO.setTotalPrice(enclosureShipDO.getTotalArea().multiply(enclosureShipDO.getUnitPrice()));
            enclosureShipDO.setUnit("平方米");
         }

         if (EnclosurePricingMannerEnum.LENGTH.getType().equals(enclosureShipDO.getPricingManner())) {
            enclosureShipDO.setTotalPrice(
               enclosureShipDO.getTotalLength().multiply(enclosureShipDO.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP)
            );
            enclosureShipDO.setUnit("米");
         }

         enclosureShipDO.setUnitPrice(enclosureShipDO.getUnitPrice().setScale(8, 4));
         enclosureShipDO.setUnitPrice(new BigDecimal(cn.hutool.core.util.NumberUtil.toStr(enclosureShipDO.getUnitPrice())));
         enclosureShipDO.setTotalPrice(new BigDecimal(cn.hutool.core.util.NumberUtil.toStr(enclosureShipDO.getTotalPrice())));
      }

      List<TechStandardPartShipDO> auxiliaryMaterials = this.cargoListProductLinkService.listAuxiliaryMaterialAllById(id);

      for (int i = 0; i < auxiliaryMaterials.size(); i++) {
         TechStandardPartShipDO auxiliaryMaterialShipDO = auxiliaryMaterials.get(i);
         auxiliaryMaterialShipDO.setUnitPrice(auxiliaryMaterialShipDO.getUnitPrice() == null ? BigDecimal.ZERO : auxiliaryMaterialShipDO.getUnitPrice());
         auxiliaryMaterialShipDO.setPid(i + 1);
         BigDecimal totalPrice = auxiliaryMaterialShipDO.getUnitPrice().multiply(auxiliaryMaterialShipDO.getShipMete()).setScale(2, 4);
         auxiliaryMaterialShipDO.setTotalPrice(totalPrice);
         auxiliaryMaterialShipDO.setUnitPrice(auxiliaryMaterialShipDO.getUnitPrice().setScale(2, 4));
      }

      result.put("date", LocalDate.now());
      result.put("review", auditInfo);
      result.put("artifactList", artifacts);
      result.put("partList", parts);
      result.put("enclosureList", enclosures);
      result.put("auxiliaryMaterialList", auxiliaryMaterials);
      PoiUtils.mesDownLoadExcel(exportFileName, response, tempFileName, resourcePath, result);
      return Boolean.TRUE;
   }

   @Override
   public Boolean reviewDetailDownloadV2(Long id, HttpServletResponse response) {
      Map<String, Object> result = new HashMap<>();
      String resourcePath = "files/CargoReviewDetails.xls";
      String tempFileName = "CargoReviewDetails";
      String exportFileName = "发运审核详情.xls";
      AuditInfoDTO auditInfo = this.getAuditInfoV2(id);
      auditInfo.setDeliveryAmount(auditInfo.getDeliveryAmount().setScale(2, 4));
      auditInfo.setTotalDeliveryAmount(auditInfo.getTotalDeliveryAmount().setScale(4, 4));
      auditInfo.setSafeAmount(auditInfo.getSafeAmount().setScale(2, 4));
      auditInfo.setContractReceivableAmount(auditInfo.getContractReceivableAmount().setScale(2, 4));
      auditInfo.setContractAmount(auditInfo.getContractAmount().setScale(2, 4));
      List<ArtifactShipDO> artifacts = this.listShipArtifactAndPartSend(id);
      List<PartShipDO> parts = this.cargoListProductLinkService.listPartAllById(id);
      List<PartShipDO> assembles = this.cargoListProductLinkService.listAssembleAllById(id);
      parts.addAll(assembles);

      for (int i = 0; i < parts.size(); i++) {
         PartShipDO partShipDO = parts.get(i);
         partShipDO.setPid(i + 1);
         partShipDO.setLength(partShipDO.getLength().setScale(0, 1));
         partShipDO.setNetWeight(partShipDO.getNetWeight().setScale(2, 4));
         partShipDO.setTotalWeight(partShipDO.getTotalNetWeight().divide(new BigDecimal(1000).stripTrailingZeros()));
         partShipDO.setTotalLength(partShipDO.getLength().multiply(partShipDO.getShipQuantity()).divide(new BigDecimal(1000)).setScale(2, 4));
         partShipDO.setAllWeight(partShipDO.getTotalWeight());
      }

      List<EnclosureShipDO> enclosures = this.cargoListProductLinkService.listEnclosureAllById(id);
      List<TechStandardPartShipDO> auxiliaryMaterials = this.cargoListProductLinkService.listAuxiliaryMaterialAllById(id);
      this.handlePrice(id, artifacts, enclosures, auxiliaryMaterials);
      this.handlePrint(artifacts, enclosures, auxiliaryMaterials);
      result.put("date", LocalDate.now());
      result.put("review", auditInfo);
      result.put("artifactList", artifacts);
      result.put("partList", parts);
      result.put("enclosureList", enclosures);
      result.put("auxiliaryMaterialList", auxiliaryMaterials);
      PoiUtils.mesDownLoadExcel(exportFileName, response, tempFileName, resourcePath, result);
      return Boolean.TRUE;
   }

   private void handlePrint(List<ArtifactShipDO> artifacts, List<EnclosureShipDO> enclosures, List<TechStandardPartShipDO> auxiliaryMaterials) {
      AtomicInteger artifactSort = new AtomicInteger(1);
      artifacts.forEach(artifactShipDO -> {
         artifactShipDO.setPid(artifactSort.getAndIncrement());
         artifactShipDO.setTotalLength(artifactShipDO.getTotalLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
         artifactShipDO.setTotalWeight(artifactShipDO.getTotalWeight().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
      });
      AtomicInteger enclosureSort = new AtomicInteger(1);
      enclosures.forEach(enclosureShipDO -> {
         enclosureShipDO.setPid(enclosureSort.getAndIncrement());
         enclosureShipDO.setTotalLength(enclosureShipDO.getTotalLength().divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP));
         enclosureShipDO.setTotalArea(enclosureShipDO.getTotalArea().setScale(3, RoundingMode.HALF_UP));
      });
      AtomicInteger standardPartSort = new AtomicInteger(1);
      auxiliaryMaterials.forEach(standardPartShipDO -> standardPartShipDO.setPid(standardPartSort.getAndIncrement()));
   }

   @Override
   public Map<String, Object> getShipAmountByCargoListId(Long cargoListId, Integer structureMeasureMode, Integer enclosureMeasureMode, Long projectId) {
      Map<Integer, Integer> enclosureMeasureModeMap = this.utilsBiz.listEnclosureMeasureMode(projectId);
      AtomicReference<BigDecimal> shipAmount = new AtomicReference<>(BigDecimal.ZERO);
      AtomicReference<Boolean> boolUnallocatedPrice = new AtomicReference<>(Boolean.FALSE);
      HashMap<String, Object> map = new HashMap<>();
      List<ArtifactShipDO> artifacts = this.cargoListProductLinkService.listArtifactAllById(cargoListId);
      Map<Long, List<ArtifactShipDO>> artifactShipDOMap = artifacts.stream().collect(Collectors.groupingBy(ArtifactBaseInfo::getCargoProductId));
      if (CollectionUtils.isNotEmpty(artifacts)) {
         artifacts.forEach(
            artifact -> {
               if (artifact.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
                  shipAmount.set(BigDecimal.ZERO);
               } else {
                  if (!artifact.getBoolAllPartSendDirectly()) {
                     if (artifact.getUnitPrice() == null) {
                        boolUnallocatedPrice.set(Boolean.TRUE);
                        artifact.setUnitPrice(BigDecimal.ZERO);
                     }

                     if (PricingMannerEnum.WEIGHT.getType().equals(artifact.getPricingManner())) {
                        BigDecimal mete = structureMeasureMode.equals(1) ? artifact.getTotalNetWeight() : artifact.getTotalWeight();
                        shipAmount.set(shipAmount.get().add(mete.multiply(artifact.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)));
                     }

                     if (PricingMannerEnum.LENGTH.getType().equals(artifact.getPricingManner())) {
                        shipAmount.set(
                           shipAmount.get()
                              .add(artifact.getTotalLength().multiply(artifact.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP))
                        );
                     }
                  }
               }
            }
         );
      }

      List<PartSendShipDO> sendShipDOS = this.cargoListProductLinkService.listPartSendAllById(cargoListId);
      if (CollectionUtils.isNotEmpty(sendShipDOS)) {
         sendShipDOS.forEach(
            part -> {
               if (part.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
                  shipAmount.set(BigDecimal.ZERO);
               } else {
                  if (part.getUnitPrice() == null) {
                     part.setUnitPrice(BigDecimal.ZERO);
                  }

                  if (PricingMannerEnum.WEIGHT.getType().equals(part.getPricingManner())) {
                     shipAmount.set(
                        shipAmount.get().add(part.getTotalWeight().multiply(part.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP))
                     );
                  }

                  if (PricingMannerEnum.LENGTH.getType().equals(part.getPricingManner())) {
                     shipAmount.set(
                        shipAmount.get().add(part.getTotalLength().multiply(part.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP))
                     );
                  }
               }
            }
         );
      }

      List<EnclosureShipDO> enclosures = this.cargoListProductLinkService.listEnclosureAllById(cargoListId);
      if (CollectionUtils.isNotEmpty(enclosures)) {
         enclosures.forEach(
            enclosure -> {
               if (enclosure.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
                  shipAmount.set(BigDecimal.ZERO);
               } else {
                  if (EnclosurePricingMannerEnum.LENGTH.getType().equals(enclosure.getPricingManner())) {
                     shipAmount.set(
                        shipAmount.get()
                           .add(enclosure.getTotalLength().multiply(enclosure.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP))
                     );
                  }

                  if (EnclosurePricingMannerEnum.AREA.getType().equals(enclosure.getPricingManner())) {
                     shipAmount.set(shipAmount.get().add(enclosure.getTotalArea().multiply(enclosure.getUnitPrice())));
                  }
               }
            }
         );
      }

      List<TechStandardPartShipDO> auxiliaryMaterials = this.cargoListProductLinkService.listAuxiliaryMaterialAllById(cargoListId);
      if (CollectionUtils.isNotEmpty(auxiliaryMaterials)) {
         auxiliaryMaterials.forEach(
            auxiliaryMaterial -> {
               if (auxiliaryMaterial.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
                  shipAmount.set(BigDecimal.ZERO);
               } else {
                  if (auxiliaryMaterial.getUnitPrice() == null) {
                     boolUnallocatedPrice.set(Boolean.TRUE);
                     auxiliaryMaterial.setUnitPrice(BigDecimal.ZERO);
                  }

                  if (!auxiliaryMaterial.getBoolWeightTypeEnum()
                     || auxiliaryMaterial.getBoolWeightTypeEnum() && "千克".equals(auxiliaryMaterial.getAccountingUnit())) {
                     shipAmount.set(shipAmount.get().add(auxiliaryMaterial.getUnitPrice().multiply(auxiliaryMaterial.getShipMete())));
                  }

                  if (auxiliaryMaterial.getBoolWeightTypeEnum() && "吨".equals(auxiliaryMaterial.getAccountingUnit())) {
                     shipAmount.set(
                        shipAmount.get()
                           .add(
                              auxiliaryMaterial.getUnitPrice()
                                 .multiply(auxiliaryMaterial.getShipMete())
                                 .divide(new BigDecimal(1000))
                                 .setScale(5, RoundingMode.HALF_UP)
                           )
                     );
                  }
               }
            }
         );
      }

      map.put("shipAmount", shipAmount.get());
      map.put("boolUnallocatedPrice", boolUnallocatedPrice.get());
      return map;
   }

   @Override
   public void setShipAmountByProjectId(Long projectId) {
      ContractProject project = this.contractProjectService.getById(projectId);
      if (project.getBusinessType().equals(ProjectBusinessTypeEnum.PROCESS.getType())) {
         Integer structureMeasureMode = project.getStructureMeasureMode();
         Integer enclosureMeasureMode = project.getEnclosureMeasureMode();
         AtomicReference<BigDecimal> shipAmount = new AtomicReference<>(BigDecimal.ZERO);
         List<ArtifactShipMeteDO> artifacts = this.cargoListProductLinkService.listArtifactShipByProjectId(projectId);
         if (CollectionUtils.isNotEmpty(artifacts)) {
            artifacts.forEach(
               artifact -> {
                  if (null != artifact.getWarehouseType() && artifact.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
                     shipAmount.set(BigDecimal.ZERO);
                  } else {
                     if (PricingMannerEnum.WEIGHT.getType().equals(artifact.getPricingManner())) {
                        BigDecimal weight = structureMeasureMode.equals(1) ? artifact.getTotalNetWeight() : artifact.getTotalWeight();
                        shipAmount.set(
                           shipAmount.get().add(weight.multiply(artifact.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP))
                        );
                     }

                     if (PricingMannerEnum.LENGTH.getType().equals(artifact.getPricingManner())) {
                        shipAmount.set(
                           shipAmount.get()
                              .add(artifact.getTotalLength().multiply(artifact.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP))
                        );
                     }
                  }
               }
            );
         }

         List<PartSendShipDO> sendShipDOS = this.cargoListProductLinkService.listPartSendShipByProjectId(projectId);
         if (CollectionUtils.isNotEmpty(sendShipDOS)) {
            sendShipDOS.forEach(
               part -> {
                  if (null != part.getWarehouseType() && part.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
                     shipAmount.set(BigDecimal.ZERO);
                  } else {
                     if (PricingMannerEnum.WEIGHT.getType().equals(part.getPricingManner())) {
                        shipAmount.set(
                           shipAmount.get().add(part.getTotalWeight().multiply(part.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP))
                        );
                     }

                     if (PricingMannerEnum.LENGTH.getType().equals(part.getPricingManner())) {
                        shipAmount.set(
                           shipAmount.get().add(part.getTotalLength().multiply(part.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP))
                        );
                     }
                  }
               }
            );
         }

         if (enclosureMeasureMode != null) {
            List<EnclosureShipMeteDO> enclosures = this.cargoListProductLinkService.listEnclosureShipByProjectId(projectId);
            if (CollectionUtils.isNotEmpty(enclosures)) {
               enclosures.forEach(
                  enclosure -> {
                     if (null != enclosure.getWarehouseType() && enclosure.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
                        shipAmount.set(BigDecimal.ZERO);
                     } else {
                        BigDecimal mete = enclosureMeasureMode.equals(1)
                           ? enclosure.getTotalLength().divide(BigDecimal.valueOf(1000L))
                           : enclosure.getTotalArea().divide(BigDecimal.valueOf(1000000L));
                        shipAmount.set(shipAmount.get().add(mete.multiply(enclosure.getUnitPrice())));
                     }
                  }
               );
            }
         }

         List<TechStandardPartShipDO> auxiliaryMaterials = this.cargoListProductLinkService.listAuxiliaryMaterialShipByProjectId(projectId);
         if (CollectionUtils.isNotEmpty(auxiliaryMaterials)) {
            auxiliaryMaterials.forEach(
               auxiliaryMaterial -> {
                  if (null != auxiliaryMaterial.getWarehouseType()
                     && auxiliaryMaterial.getWarehouseType().equals(WarehouseTypeProductReturnEnum.REPAIR.getType())) {
                     shipAmount.set(BigDecimal.ZERO);
                  } else {
                     shipAmount.set(shipAmount.get().add(auxiliaryMaterial.getUnitPrice().multiply(auxiliaryMaterial.getShipQuantity())));
                  }
               }
            );
         }

         project.setHappenedAmount(shipAmount.get());
         project.setBoolArrears(
            project.getCollectionAmount().compareTo(project.getHappenedAmount()) < 0
               ? ProjectBoolArrearsEnum.TRUE.getType()
               : ProjectBoolArrearsEnum.FALSE.getType()
         );
         this.contractProjectService.updateById(project);
      }
   }

   @Override
   public Map<String, Object> reviewDetail(Long id) {
      Map<String, Object> result = new HashMap<>();
      AuditInfoDTO auditInfo = this.getAuditInfo(id);
      List<ArtifactShipDO> artifacts = this.listShipArtifactAndPartSend(id);
      List<PartShipDO> partShipDOS = this.cargoListProductLinkService.listPartAllById(id);
      List<PartShipDO> assembleShipDOS = this.cargoListProductLinkService.listAssembleAllById(id);
      partShipDOS.addAll(assembleShipDOS);
      if (CollectionUtils.isNotEmpty(partShipDOS)) {
         partShipDOS.forEach(part -> {
            if (PricingMannerEnum.WEIGHT.getType().equals(part.getPricingManner())) {
               part.setTotalPrice(part.getTotalNetWeight().multiply(part.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP));
            }

            if (PricingMannerEnum.LENGTH.getType().equals(part.getPricingManner())) {
               part.setTotalPrice(part.getTotalLength().multiply(part.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP));
            }
         });
      }

      List<EnclosureShipDO> enclosures = this.cargoListProductLinkService.listEnclosureAllById(id);
      List<TechStandardPartShipDO> auxiliaryMaterials = this.cargoListProductLinkService.listAuxiliaryMaterialAllById(id);
      result.put("review", auditInfo);
      result.put("artifactList", artifacts);
      result.put("partList", partShipDOS);
      result.put("enclosureList", enclosures);
      result.put("auxiliaryMaterialList", auxiliaryMaterials);
      List<CargoListDetailsCommonDTO> detailsCommonDTOList = this.getCommonList(artifacts, partShipDOS, enclosures, auxiliaryMaterials);
      result.put("detailsList", detailsCommonDTOList);
      return result;
   }

   @Override
   public Map<String, Object> reviewDetailV2(Long id) {
      Map<String, Object> result = new HashMap<>();
      AuditInfoDTO auditInfo = this.getAuditInfoV2(id);
      List<ArtifactShipDO> artifacts = this.listShipArtifactAndPartSend(id);
      List<PartShipDO> partShipDOS = this.cargoListProductLinkService.listPartAllById(id);
      List<PartShipDO> assembleShipDOS = this.cargoListProductLinkService.listAssembleAllById(id);
      partShipDOS.addAll(assembleShipDOS);
      List<EnclosureShipDO> enclosures = this.cargoListProductLinkService.listEnclosureAllById(id);
      List<TechStandardPartShipDO> auxiliaryMaterials = this.cargoListProductLinkService.listAuxiliaryMaterialAllById(id);
      this.handlePrice(id, artifacts, enclosures, auxiliaryMaterials);
      result.put("review", auditInfo);
      result.put("artifactList", artifacts);
      result.put("partList", partShipDOS);
      result.put("enclosureList", enclosures);
      result.put("auxiliaryMaterialList", auxiliaryMaterials);
      List<CargoListDetailsCommonDTO> detailsCommonDTOList = this.getCommonList(artifacts, partShipDOS, enclosures, auxiliaryMaterials);
      result.put("detailsList", detailsCommonDTOList);
      return result;
   }

   private void handlePrice(Long id, List<ArtifactShipDO> artifacts, List<EnclosureShipDO> enclosures, List<TechStandardPartShipDO> auxiliaryMaterials) {
      List<CargoListProductLinkPriceDTO> cargoLinkPriceList = this.businessPriceUtils.getCargoLinkPrice((Collection<Long>)Collections.singletonList(id));
      Map<Long, List<CargoListProductLinkPriceDTO>> cargoLinkPriceMap = cargoLinkPriceList.stream()
         .collect(Collectors.groupingBy(CargoListProductLinkPriceDTO::getId));
      Map<Long, ArtifactShipDO> artifactShipDOMap = artifacts.stream().collect(Collectors.toMap(ArtifactBaseInfo::getLinkId, Function.identity()));
      Map<Long, EnclosureShipDO> enclosureShipDOMap = enclosures.stream().collect(Collectors.toMap(EnclosureBaseInfo::getLinkId, Function.identity()));
      Map<Long, TechStandardPartShipDO> auxiliaryShipDOMap = auxiliaryMaterials.stream()
         .collect(Collectors.toMap(TechStandardPartBaseInfo::getLinkId, Function.identity()));
      List<ArtifactShipDO> artifactShipList = new ArrayList<>(artifacts.size() * 2);
      List<EnclosureShipDO> enclosureShipList = new ArrayList<>(enclosures.size() * 2);
      List<TechStandardPartShipDO> standardPartShipList = new ArrayList<>(auxiliaryMaterials.size() * 2);
      cargoLinkPriceMap.forEach((linkId, list) -> {
         if (artifactShipDOMap.containsKey(linkId)) {
            ArtifactShipDO artifactShipDO = artifactShipDOMap.get(linkId);
            list.forEach(linkPrice -> {
               ArtifactShipDO shipDO = BeanUtil.copy(artifactShipDO, ArtifactShipDO.class);
               shipDO.setShipQuantity(linkPrice.getQuantity());
               shipDO.setUnit(PricingUnitTypeEnum.getNameByType(linkPrice.getPricingUnitTypeEnum()));
               shipDO.setTotalLength(artifactShipDO.getLength().multiply(linkPrice.getQuantity()));
               shipDO.setTotalNetWeight(artifactShipDO.getNetWeight().multiply(linkPrice.getQuantity()));
               shipDO.setTotalGrossWeight(artifactShipDO.getGrossWeight().multiply(linkPrice.getQuantity()));
               shipDO.setTotalWeight(artifactShipDO.getWeight().multiply(linkPrice.getQuantity()));
               shipDO.setMete(linkPrice.getMete() != null && linkPrice.getMete().compareTo(BigDecimal.ZERO) != 0 ? linkPrice.getMete() : null);
               shipDO.setUnitPrice(linkPrice.getUnitPrice());
               shipDO.setTotalPrice(linkPrice.getTotalPrice() != null ? linkPrice.getTotalPrice().setScale(3, RoundingMode.HALF_UP) : null);
               artifactShipList.add(shipDO);
            });
         }

         if (enclosureShipDOMap.containsKey(linkId)) {
            EnclosureShipDO enclosureShipDO = enclosureShipDOMap.get(linkId);
            list.forEach(linkPrice -> {
               EnclosureShipDO shipDO = BeanUtil.copy(enclosureShipDO, EnclosureShipDO.class);
               shipDO.setUnit(PricingUnitTypeEnum.getNameByType(linkPrice.getPricingUnitTypeEnum()));
               shipDO.setTotalLength(enclosureShipDO.getLength().multiply(linkPrice.getQuantity()));
               shipDO.setTotalArea(enclosureShipDO.getSurfaceArea().multiply(linkPrice.getQuantity()).setScale(3, RoundingMode.HALF_UP));
               shipDO.setTotalWeight(enclosureShipDO.getWeight().multiply(linkPrice.getQuantity()).setScale(4, RoundingMode.HALF_UP));
               shipDO.setMete(linkPrice.getMete() != null && linkPrice.getMete().compareTo(BigDecimal.ZERO) != 0 ? linkPrice.getMete() : null);
               shipDO.setUnitPrice(linkPrice.getUnitPrice());
               shipDO.setTotalPrice(linkPrice.getTotalPrice() != null ? linkPrice.getTotalPrice().setScale(3, RoundingMode.HALF_UP) : null);
               enclosureShipList.add(shipDO);
            });
         }

         if (auxiliaryShipDOMap.containsKey(linkId)) {
            TechStandardPartShipDO standardPartShipDO = auxiliaryShipDOMap.get(linkId);
            list.forEach(linkPrice -> {
               TechStandardPartShipDO shipDO = BeanUtil.copy(standardPartShipDO, TechStandardPartShipDO.class);
               shipDO.setQuantity(linkPrice.getQuantity());
               shipDO.setMete(standardPartShipDO.getMete().multiply(linkPrice.getQuantity()).divide(standardPartShipDO.getQuantity(), 3, RoundingMode.HALF_UP));
               shipDO.setUnitPrice(linkPrice.getUnitPrice());
               shipDO.setTotalPrice(linkPrice.getTotalPrice() != null ? linkPrice.getTotalPrice().setScale(3, RoundingMode.HALF_UP) : null);
               standardPartShipList.add(shipDO);
            });
         }
      });
      artifacts.clear();
      artifacts.addAll(artifactShipList);
      enclosures.clear();
      enclosures.addAll(enclosureShipList);
      auxiliaryMaterials.clear();
      auxiliaryMaterials.addAll(standardPartShipList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> reviewDetailPrint(Long id) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("statisticsDate", System.currentTimeMillis());
      Map<String, Object> reviewDetail = this.reviewDetailV2(id);
      Object review = reviewDetail.get("review");
      Map<String, Object> map = BeanUtil.beanToMap(review);
      header.putAll(map);
      printVO.setHeader(header);
      List<Map<String, Object>> detailsList = (List<Map<String, Object>>)reviewDetail.get("detailsList");
      printVO.setTable(detailsList);
      return printVO;
   }

   @Override
   public Boolean cancelReceiving(CargoListReceiptUpdateDTOParam param) {
      if (param.getCargoListReceiptTypeEnum() == null) {
         Preconditions.checkArgument(param.getChangeFreight() != null, "操作失败,参数有误,请刷新页面重试!");
         param.setCargoListReceiptTypeEnum(CargoListReceiptTypeEnum.NO_RESERVED_LOADING.getType());
      } else if (param.getCargoListReceiptTypeEnum().equals(CargoListReceiptTypeEnum.RESERVED_LOADING.getType())) {
         Preconditions.checkArgument(param.getChangeFreight() == null, "操作失败,参数有误,请刷新页面重试!");
         param.setChangeFreight(ChangeFreightEnum.FREIGHT_INVALID.getType());
      }

      MesBuildingCargoList cargoList = this.cargoListService.getById(param.getId());
      Preconditions.checkArgument(cargoList != null, "发运记录不存在");
      Preconditions.checkArgument(CargoListStatusEnum.SHIPMENT.getType().equals(cargoList.getStatus()), "不是发运状态，无法取消");
      Preconditions.checkArgument(ShipmentStatusEnum.DELIVERY.getType().equals(cargoList.getShipmentStatus()), "不是送货状态，无法取消");
      cargoList.setStatusUpdateDate(LocalDateTime.now());
      if (param.getCargoListReceiptTypeEnum().equals(CargoListReceiptTypeEnum.NO_RESERVED_LOADING.getType())) {
         cargoList.setShipmentStatus(ShipmentStatusEnum.ABOLISH_DELIVERY.getType());
         cargoList.setDeliveryStatus(ShipmentStatusEnum.ABOLISH_DELIVERY.getType());
         cargoList.setChangeFreight(param.getChangeFreight());
         cargoList.setChangeFreightReason(param.getChangeFreightReason());
         cargoList.setCancelDeliveryReason(param.getCancelDeliveryReason());
      } else {
         cargoList.setStatus(CargoListStatusEnum.LOADING.getType());
         cargoList.setCarModel(null);
         cargoList.setReceiptName(null);
         cargoList.setReceiptPhone(null);
         cargoList.setSupplierPriceId(null);
         cargoList.setActualUserId(null);
         cargoList.setActualUserName(null);
         cargoList.setActualTime(null);
         cargoList.setAuditTime(null);
         cargoList.setAuditReceiptTime(null);
         cargoList.setActualWeight(BigDecimal.ZERO);
         cargoList.setActualGrossWeight(BigDecimal.ZERO);
         cargoList.setTotalPrice(BigDecimal.ZERO);
         cargoList.setPrice(BigDecimal.ZERO);
         cargoList.setAuditUserId(null);
         cargoList.setAuditUserName(null);
         cargoList.setSerialNumber(null);
      }

      if (param.getChangeFreight().equals(ChangeFreightEnum.FREIGHT_INVALID.getType())) {
         cargoList.setTotalPrice(BigDecimal.ZERO);
      }

      this.cargoListService.updateById(cargoList);
      if (param.getChangeFreight().equals(ChangeFreightEnum.FREIGHT_CHANGES.getType())) {
         CargoListPriceChangeDTOParam changeDTOParam = new CargoListPriceChangeDTOParam();
         changeDTOParam.setId(cargoList.getId());
         changeDTOParam.setPrice(param.getPrice());
         changeDTOParam.setRemark(param.getChangeFreightReason());
         changeDTOParam.setPriceType(param.getPriceType());
         this.cargoListPriceChange(changeDTOParam);
      }

      if ((ProductTypeEnum.ARTIFACT.getType() & cargoList.getProductType()) > 0) {
         List<MesBuildingCargoListProductLink> productLinks = this.cargoListProductLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductLink>)(new LambdaQueryWrapper<MesBuildingCargoListProductLink>()
                     .eq(MesBuildingCargoListProductLink::getCargoListId, cargoList.getId()))
                  .eq(MesBuildingCargoListProductLink::getProductType, ProductTypeEnum.ARTIFACT.getType())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(productLinks), "构件装车过磅记录不存在!!!");
         List<MesBuildingCargoListProductNumberLink> numberLinks = this.cargoListProductNumberLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductNumberLink>)(new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                     .eq(MesBuildingCargoListProductNumberLink::getCargoListId, cargoList.getId()))
                  .eq(MesBuildingCargoListProductNumberLink::getProductType, ProductTypeEnum.ARTIFACT.getType())
            );
         List<TechArtifact> techArtifacts = this.techArtifactService
            .list(
               (Wrapper<TechArtifact>)(new LambdaQueryWrapper<TechArtifact>()
                     .and(
                        e -> {
                           LambdaQueryWrapper var10000 = ((e.eq(
                                    TechArtifact::getBoolAbnormalEnum, Boolean.TRUE
                                 ))
                                 .or())
                              .eq(TechArtifact::getBoolStatusEnum, Boolean.FALSE);
                        }
                     ))
                  .in(TechArtifact::getId, productLinks.stream().map(MesBuildingCargoListProductLink::getProductId).collect(Collectors.toList()))
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(techArtifacts), "操作失败,存在异常状态或已暂停的构件清单!!!");
         List<ArtifactShipDO> artifactShipDOS = this.cargoListProductLinkService.listArtifactAllById(cargoList.getId());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactShipDOS), "发运列表为空,无法取消发运");

         for (ArtifactShipDO shipDO : artifactShipDOS) {
            this.amendMesBuildingWarehouse(
               shipDO.getLinkId(),
               shipDO.getWarehouseRecordId(),
               cargoList.getId(),
               shipDO.getProject().getId(),
               shipDO.getArea().getId(),
               shipDO.getCargoProductId(),
               shipDO.getPackageId(),
               shipDO.getShipQuantity(),
               param.getCargoListReceiptTypeEnum()
            );
         }

         if (CollectionUtils.isNotEmpty(numberLinks) && CargoListReceiptTypeEnum.NO_RESERVED_LOADING.getType().equals(param.getCargoListReceiptTypeEnum())) {
            numberLinks.forEach(link -> link.setBoolCancelShip(Boolean.TRUE));
            this.cargoListProductNumberLinkService.updateBatchById(numberLinks);
         }
      }

      if ((ProductTypeEnum.AUXILIARY_MATERIAL.getType() & cargoList.getProductType()) > 0) {
         List<TechStandardPartShipDO> techStandardPartShipDOS = this.cargoListProductLinkService.listAuxiliaryMaterialAllById(cargoList.getId());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(techStandardPartShipDOS), "发运列表为空,无法取消发运");

         for (TechStandardPartShipDO shipDO : techStandardPartShipDOS) {
            this.amendMesBuildingWarehouse(
               shipDO.getLinkId(),
               shipDO.getWarehouseRecordId(),
               cargoList.getId(),
               shipDO.getProject().getId(),
               shipDO.getArea() == null ? 0L : shipDO.getArea().getId(),
               shipDO.getCargoProductId(),
               shipDO.getPackageId(),
               shipDO.getShipQuantity(),
               param.getCargoListReceiptTypeEnum()
            );
         }
      }

      if ((ProductTypeEnum.MACHINE_PART.getType() & cargoList.getProductType()) > 0) {
         List<PartShipDO> partShipDOS = this.cargoListProductLinkService.listPartAllById(cargoList.getId());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(partShipDOS), "发运列表为空,无法取消发运");

         for (PartShipDO shipDO : partShipDOS) {
            this.amendMesBuildingWarehouse(
               shipDO.getLinkId(),
               shipDO.getWarehouseRecordId(),
               cargoList.getId(),
               shipDO.getProject().getId(),
               shipDO.getArea().getId(),
               shipDO.getCargoProductId(),
               shipDO.getPackageId(),
               shipDO.getShipQuantity(),
               param.getCargoListReceiptTypeEnum()
            );
         }
      }

      if ((ProductTypeEnum.ASSEMBLE.getType() & cargoList.getProductType()) > 0) {
         List<PartShipDO> partShipDOS = this.cargoListProductLinkService.listAssembleAllById(cargoList.getId());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(partShipDOS), "发运列表为空,无法取消发运");

         for (PartShipDO shipDO : partShipDOS) {
            this.amendMesBuildingWarehouse(
               shipDO.getLinkId(),
               shipDO.getWarehouseRecordId(),
               cargoList.getId(),
               shipDO.getProject().getId(),
               shipDO.getArea().getId(),
               shipDO.getCargoProductId(),
               shipDO.getPackageId(),
               shipDO.getShipQuantity(),
               param.getCargoListReceiptTypeEnum()
            );
         }
      }

      if ((ProductTypeEnum.ENCLOSURE.getType() & cargoList.getProductType()) > 0) {
         List<EnclosureShipDO> enclosureShipDOS = this.cargoListProductLinkService.listEnclosureAllById(cargoList.getId());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(enclosureShipDOS), "发运列表为空,无法取消发运");

         for (EnclosureShipDO shipDO : enclosureShipDOS) {
            this.amendMesBuildingWarehouse(
               shipDO.getLinkId(),
               shipDO.getWarehouseRecordId(),
               cargoList.getId(),
               shipDO.getProject().getId(),
               shipDO.getArea().getId(),
               shipDO.getCargoProductId(),
               shipDO.getPackageId(),
               shipDO.getShipQuantity(),
               param.getCargoListReceiptTypeEnum()
            );
         }
      }

      if (CargoListReceiptTypeEnum.NO_RESERVED_LOADING.getType().equals(param.getCargoListReceiptTypeEnum())) {
         List<MesBuildingCargoListProductLink> allProductLinks = this.cargoListProductLinkService
            .list((Wrapper<MesBuildingCargoListProductLink>)new LambdaQueryWrapper<MesBuildingCargoListProductLink>().eq(MesBuildingCargoListProductLink::getCargoListId, cargoList.getId()));
         allProductLinks.forEach(link -> link.setBoolCancelShip(Boolean.TRUE));
         this.cargoListProductLinkService.updateBatchById(allProductLinks);
         this.buildReturnManufactured(allProductLinks);
      }

      ContractProject project = this.contractProjectService.getById(cargoList.getProjectId());
      project.setHappenedAmount(this.getProjectShipAmount(cargoList.getProjectId(), null));
      project.setBoolArrears(
         project.getCollectionAmount().compareTo(project.getHappenedAmount()) < 0
            ? ProjectBoolArrearsEnum.TRUE.getType()
            : ProjectBoolArrearsEnum.FALSE.getType()
      );
      this.contractProjectService.updateById(project);
      return true;
   }

   private void buildReturnManufactured(List<MesBuildingCargoListProductLink> allProductLinks) {
      List<MesBuildingCargoListProductLink> productLinkList = allProductLinks.stream()
         .filter(e -> e.getWarehouseType().equals(WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()))
         .filter(e -> !e.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(productLinkList)) {
         List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
            .list(
               (Wrapper<MesBuildingWarehouseSummary>)new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                  .in(
                     MesBuildingWarehouseSummary::getId,
                     productLinkList.stream().map(MesBuildingCargoListProductLink::getWarehouseRecordId).collect(Collectors.toList())
                  )
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(summaryList), "发运失败,入库记录不存在!!!");
         Map<Long, MesBuildingWarehouseSummary> summaryMap = summaryList.stream()
            .collect(Collectors.toMap(MesBuildingWarehouseSummary::getId, Function.identity()));
         List<ReturnManufacturedVORequest> returnManufacturedVORequests = new ArrayList<>();

         for (MesBuildingCargoListProductLink link : productLinkList) {
            MesBuildingWarehouseSummary record = summaryMap.get(link.getWarehouseRecordId());
            Integer basicClass = null;
            if (record.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               basicClass = BasicClassEnum.STRUC_MANUFACTURED.getType();
            }

            if (record.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
               basicClass = BasicClassEnum.ENCL_MANUFACTURED.getType();
            }

            Preconditions.checkArgument(basicClass != null, "操作失败,暂只支持构件/围护申购退库!");
            ReturnManufacturedVORequest outboundManufacturedVORequest = ReturnManufacturedVORequest.builder()
               .materialInventoryId(record.getMaterialInventoryId())
               .productId(record.getProductId())
               .quantity(link.getQuantity())
               .userId(UserUtil.getCurrentUserId())
               .returnTime(LocalDateTime.now())
               .basicClass(basicClass)
               .build();
            returnManufacturedVORequests.add(outboundManufacturedVORequest);
         }

         if (CollectionUtils.isNotEmpty(returnManufacturedVORequests)) {
            this.returnManufacturedMesManager.insertReturnManufactured(returnManufacturedVORequests);
         }
      }
   }

   @Override
   public Boolean signIn(Long id, Long attachmentId) {
      if (attachmentId != null) {
         AttachmentDTO attachmentDTO = this.attachmentService.getById(attachmentId);
         Preconditions.checkArgument(attachmentDTO != null, "操作失败,上传的附件不存在!");
      }

      MesBuildingCargoList cargoList = this.cargoListService.getById(id);
      Preconditions.checkArgument(cargoList != null, "发运记录不存在");
      Preconditions.checkArgument(CargoListStatusEnum.SHIPMENT.getType().equals(cargoList.getStatus()), "不是发运状态，无法签收");
      Preconditions.checkArgument(ShipmentStatusEnum.DELIVERY.getType().equals(cargoList.getShipmentStatus()), "不是送货状态，无法签收");
      ContractProject project = this.contractProjectService.checkProjectStatus(cargoList.getProjectId());
      cargoList.setShipmentStatus(ShipmentStatusEnum.SIGN_IN.getType());
      cargoList.setStatus(CargoListStatusEnum.RECEIPT.getType());
      cargoList.setStatusUpdateDate(LocalDateTime.now());
      cargoList.setAuditReceiptId(UserUtil.getCurrentUserId());
      cargoList.setAuditReceiptName(UserUtil.getCurrentName());
      cargoList.setAuditReceiptTime(LocalDateTime.now());
      cargoList.setBoolProblemReceiving(false);
      cargoList.setReceiveAttachmentId(attachmentId);
      this.cargoListService.updateById(cargoList);
      if (ProjectBusinessTypeEnum.JOB.getType().equals(project.getBusinessType())) {
         this.projectReceivingBiz.saveReceiving(id, project.getProjectType());
      }

      return true;
   }

   private void amendMesBuildingWarehouse(
      Long linkId,
      Long warehouseRecordId,
      Long id,
      Long projectId,
      Long areaId,
      Long cargoProductId,
      Long packageId,
      BigDecimal shipQuantity,
      Integer cargoListReceiptTypeEnum
   ) {
      MesBuildingWarehouseSummary record = this.warehouseSummaryService.getById(warehouseRecordId);
      Preconditions.checkArgument(record != null, "出入库汇总表不存在");
      if (packageId == null && cargoListReceiptTypeEnum.equals(CargoListReceiptTypeEnum.NO_RESERVED_LOADING.getType())) {
         record.setCargoQuantity(record.getCargoQuantity().compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : record.getCargoQuantity().subtract(shipQuantity));
         this.warehouseSummaryService.updateById(record);
      }

      if (packageId != null && cargoListReceiptTypeEnum.equals(CargoListReceiptTypeEnum.NO_RESERVED_LOADING.getType())) {
         MesBuildingPackage buildingPackage = this.mesBuildingPackageService.getById(packageId);
         Preconditions.checkArgument(buildingPackage != null, "包不存在");
         if (PackageStatusEnum.SHIPMENT.getType().equals(buildingPackage.getStatus())) {
            buildingPackage.setStatus(PackageStatusEnum.UNLOADING.getType());
            this.mesBuildingPackageService.updateById(buildingPackage);
         }
      }

      MesBuildingWarehouseSummary summary = null;
      LambdaQueryWrapper<MesBuildingWarehouseSummary> summaryLambdaQueryWrapper = (LambdaQueryWrapper<MesBuildingWarehouseSummary>)(((((Wrappers.<MesBuildingWarehouseSummary>lambdaQuery()
                        .eq(MesBuildingWarehouseSummary::getProjectId, projectId))
                     .eq(MesBuildingWarehouseSummary::getFactoryId, record.getFactoryId()))
                  .eq(MesBuildingWarehouseSummary::getProductId, cargoProductId))
               .eq(MesBuildingWarehouseSummary::getProductType, record.getProductType()))
            .eq(MesBuildingWarehouseSummary::getWorkshopId, record.getWorkshopId()))
         .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.OUT.getType());
      if (record.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         summary = this.warehouseSummaryService.getOne(summaryLambdaQueryWrapper);
      } else {
         LambdaQueryWrapper<MesBuildingWarehouseSummary> eq = summaryLambdaQueryWrapper.eq(MesBuildingWarehouseSummary::getAreaId, areaId);
         summary = this.warehouseSummaryService.getOne(eq);
      }

      Preconditions.checkArgument(summary != null, "出库汇总记录不存在!!!");
      Preconditions.checkArgument(summary.getQuantity().compareTo(shipQuantity) >= 0, "取消发运的发运数量不能大于出库汇总的数量");
      summary.setQuantity(summary.getQuantity().subtract(shipQuantity));
      LambdaQueryWrapper<MesBuildingWarehouseRecord> wrapper = (LambdaQueryWrapper<MesBuildingWarehouseRecord>)(((Wrappers.<MesBuildingWarehouseRecord>lambdaQuery()
                  .eq(MesBuildingWarehouseRecord::getProjectId, projectId))
               .eq(MesBuildingWarehouseRecord::getFactoryId, record.getFactoryId()))
            .eq(MesBuildingWarehouseRecord::getProductId, cargoProductId))
         .eq(MesBuildingWarehouseRecord::getProductType, record.getProductType());
      if (!record.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         wrapper = wrapper.eq(MesBuildingWarehouseRecord::getAreaId, areaId);
      }

      if (!ProductTypeEnum.ARTIFACT.getType().equals(record.getProductType()) && !ProductTypeEnum.ASSEMBLE.getType().equals(record.getProductType())) {
         LambdaQueryWrapper<MesBuildingWarehouseRecord> recordWrapper = wrapper.eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.OUT.getType())
            .eq(MesBuildingWarehouseRecord::getQuantity, shipQuantity);
         List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService.list(recordWrapper);
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(warehouseRecordList), "出入库记录不存在!!!");
         MesBuildingWarehouseRecord warehouseRecord = warehouseRecordList.get(0);
         this.warehouseRecordService.removeById(warehouseRecord.getId());
      } else {
         Preconditions.checkArgument(id != null, "发运产品关联id不能为空");
         List<MesBuildingCargoListProductNumberLink> numberLinks = this.cargoListProductNumberLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductNumberLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                        .eq(MesBuildingCargoListProductNumberLink::getCargoListId, id))
                     .eq(MesBuildingCargoListProductNumberLink::getCargoListLinkId, linkId))
                  .eq(MesBuildingCargoListProductNumberLink::getProductId, cargoProductId)
            );
         Preconditions.checkArgument(numberLinks != null, "发运产品关联不能为空");
         List<Integer> numbers = numberLinks.stream().map(MesBuildingCargoListProductNumberLink::getNumber).collect(Collectors.toList());
         LambdaQueryWrapper<MesBuildingWarehouseRecord> out = wrapper.in(MesBuildingWarehouseRecord::getNumber, numbers)
            .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.OUT.getType());
         List<MesBuildingWarehouseRecord> outList = this.warehouseRecordService.list(out);
         Preconditions.checkArgument(outList.size() == numbers.size(), "出库记录不存在");
         this.warehouseRecordService.removeByIds(outList.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList()));
         LambdaQueryWrapper<MesBuildingWarehouseRecord> infoWrapper = (LambdaQueryWrapper<MesBuildingWarehouseRecord>)((((((Wrappers.<MesBuildingWarehouseRecord>lambdaQuery()
                              .eq(MesBuildingWarehouseRecord::getProjectId, projectId))
                           .eq(MesBuildingWarehouseRecord::getAreaId, areaId))
                        .eq(MesBuildingWarehouseRecord::getFactoryId, record.getFactoryId()))
                     .eq(MesBuildingWarehouseRecord::getProductId, cargoProductId))
                  .eq(MesBuildingWarehouseRecord::getProductType, record.getProductType()))
               .in(MesBuildingWarehouseRecord::getNumber, numbers))
            .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType());
         List<MesBuildingWarehouseRecord> infoList = this.warehouseRecordService.list(infoWrapper);
         Preconditions.checkArgument(infoList.size() == numbers.size(), "入库记录不存在");
         Map<Long, List<MesBuildingCargoListProductNumberLink>> cargoListProductNumberLinkMap = numberLinks.stream()
            .collect(Collectors.groupingBy(MesBuildingCargoListProductNumberLink::getProductId));
         infoList.forEach(
            info -> {
               List<MesBuildingCargoListProductNumberLink> numberLinkList = cargoListProductNumberLinkMap.get(info.getProductId());
               Map<Integer, MesBuildingCargoListProductNumberLink> productNumberLinkMap = numberLinkList.stream()
                  .collect(Collectors.toMap(MesBuildingCargoListProductNumberLink::getNumber, Function.identity()));
               MesBuildingCargoListProductNumberLink productNumberLink = productNumberLinkMap.get(info.getNumber());
               info.setStatus(
                  CargoListReceiptTypeEnum.RESERVED_LOADING.getType().equals(cargoListReceiptTypeEnum)
                     ? WarehouseRecordStatusTypeEnum.CARGOLIST.getType()
                     : WarehouseRecordStatusTypeEnum.INTO.getType()
               );
               if (productNumberLink.getPackageId() != null) {
                  info.setStatus(
                     CargoListReceiptTypeEnum.RESERVED_LOADING.getType().equals(cargoListReceiptTypeEnum)
                        ? WarehouseRecordStatusTypeEnum.CARGOLIST.getType()
                        : WarehouseRecordStatusTypeEnum.PACKAGING.getType()
                  );
               }
            }
         );
         this.warehouseRecordService.updateBatchById(infoList);
         if (CargoListReceiptTypeEnum.NO_RESERVED_LOADING.getType().equals(cargoListReceiptTypeEnum)) {
            this.cargoListProductNumberLinkService
               .removeByIds(numberLinks.stream().map(MesBuildingCargoListProductNumberLink::getId).collect(Collectors.toList()));
         }
      }

      if (summary.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
         this.warehouseSummaryService.removeById(summary.getId());
      } else {
         this.warehouseSummaryService.updateById(summary);
      }
   }

   @Override
   public BigDecimal getProjectShipAmount(Long projectId, Long cargoListId) {
      List<MesBuildingCargoList> cargoLists;
      if (cargoListId != null) {
         cargoLists = this.cargoListService
            .list(
               (Wrapper<MesBuildingCargoList>)(new LambdaQueryWrapper<MesBuildingCargoList>().eq(MesBuildingCargoList::getId, cargoListId))
                  .eq(MesBuildingCargoList::getProjectId, projectId)
            );
      } else {
         cargoLists = this.cargoListService
            .list(
               Wrappers.lambdaQuery(MesBuildingCargoList.class)
                  .eq(MesBuildingCargoList::getProjectId, projectId)
                  .ge(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType())
                  .ne(MesBuildingCargoList::getShipmentStatus, ShipmentStatusEnum.ABOLISH_DELIVERY.getType())
            );
      }

      return cargoLists.stream()
         .map(
            cargoList -> {
               Map<Long, List<PartSendShipDO>> partSendMap = null;
               if ((cargoList.getProductType() & ProductTypeEnum.ARTIFACT.getType()) > 0) {
                  List<PartSendShipDO> partSendShipDOS = this.cargoListProductLinkService.listPartSendAllById(cargoList.getId());
                  if (CollectionUtils.isNotEmpty(partSendShipDOS)) {
                     partSendMap = partSendShipDOS.stream().collect(Collectors.groupingBy(PartSendShipDO::getArtifactId));
                  }
               }

               List<MesBuildingCargoListProductLink> productLinkList = this.cargoListProductLinkService
                  .list(Wrappers.lambdaQuery(MesBuildingCargoListProductLink.builder().cargoListId(cargoList.getId()).build()));
               Map<Long, List<PartSendShipDO>> finalPartSendMap = partSendMap;
               return productLinkList.stream()
                  .filter(e -> e.getWarehouseType().equals(WarehouseTypeProductReturnEnum.NORMAL.getType()))
                  .map(
                     ship -> {
                        BigDecimal mete = BigDecimal.ZERO;
                        BigDecimal unitPrice = BigDecimal.ZERO;
                        TechProductDTO productDTO = this.productBiz.getProductInfoBy(ship.getProductId(), ship.getProductType());
                        if (ship.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                           if (!productDTO.getBoolAllPartSendDirectly()) {
                              BusinessArtifact businessArtifact = this.businessArtifactService.getById(productDTO.getBusinessId());
                              unitPrice = businessArtifact.getUnitPrice() != null ? businessArtifact.getUnitPrice() : BigDecimal.ZERO;
                              if (businessArtifact.getPricingManner().equals(PricingMannerEnum.WEIGHT.getType())) {
                                 mete = ship.getMeasureMode().equals(StructureMeasureModeEnum.THEORY.getType())
                                    ? ship.getNetWeight().multiply(ship.getQuantity())
                                    : ship.getWeight().multiply(ship.getQuantity());
                              } else {
                                 mete = productDTO.getLength().multiply(ship.getQuantity()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                              }

                              mete = mete.divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                           }

                           if (productDTO.getBoolAllPartSendDirectly() && finalPartSendMap != null) {
                              List<PartSendShipDO> sendShipDOS = finalPartSendMap.get(ship.getProductId());
                              if (CollectionUtils.isNotEmpty(sendShipDOS)) {
                                 AtomicReference<BigDecimal> shipAmount = new AtomicReference<>(BigDecimal.ZERO);
                                 sendShipDOS.forEach(
                                    part -> {
                                       part.setUnitPrice(part.getUnitPrice() == null ? BigDecimal.ZERO : part.getUnitPrice());
                                       if (PricingMannerEnum.WEIGHT.getType().equals(part.getPricingManner())) {
                                          shipAmount.set(
                                             shipAmount.get()
                                                .add(part.getWeight().multiply(part.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP))
                                          );
                                       }

                                       if (PricingMannerEnum.LENGTH.getType().equals(part.getPricingManner())) {
                                          shipAmount.set(
                                             shipAmount.get()
                                                .add(part.getLength().multiply(part.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP))
                                          );
                                       }
                                    }
                                 );
                                 unitPrice = shipAmount.get();
                                 mete = ship.getQuantity();
                              }
                           }
                        } else if (ship.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                           BusinessEnclosure businessEnclosure = this.businessEnclosureService.getById(productDTO.getBusinessId());
                           mete = ship.getMeasureMode() != null && ship.getMeasureMode().equals(EnclosureMeasureModeEnum.LENGTH_MODE.getType())
                              ? ship.getLength().multiply(ship.getQuantity()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP)
                              : ship.getSurfaceArea().multiply(ship.getQuantity()).divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP);
                           unitPrice = businessEnclosure.getUnitPrice() != null ? businessEnclosure.getUnitPrice() : BigDecimal.ZERO;
                        } else if (ship.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                           BusinessStandardPart businessAuxiliaryMaterial = this.businessStandardPartService.getById(productDTO.getBusinessId());
                           mete = ship.getQuantity();
                           unitPrice = businessAuxiliaryMaterial.getUnitPrice() != null ? businessAuxiliaryMaterial.getUnitPrice() : BigDecimal.ZERO;
                        }

                        return mete.multiply(unitPrice);
                     }
                  )
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
            }
         )
         .reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public List<ProjectCargoListMeteDTO> projectCargoListMeteSummary(
      LocalDateTime dateTime,
      Integer sendStatus,
      Boolean settled,
      Long workshopId,
      String projectName,
      Integer productionLineTypeEnum,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer projectStatus
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.STRUCTURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      return CollectionUtils.isEmpty(projectIds)
         ? new ArrayList<>()
         : this.cargoListService
            .projectCargoListMeteSummary(dateTime, sendStatus, settled, workshopId, productionLineTypeEnum, projectIds, 1, projectName, projectStatus)
            .stream()
            .map(e -> BeanUtil.copy(e, ProjectCargoListMeteDTO.class))
            .collect(Collectors.toList());
   }

   @Override
   public List<ProjectCargoListMeteDTO> projectCargoListMeteSummaryV2(CargoListStatisticsQueryParam param) {
      return this.cargoListService
         .projectCargoListMeteSummaryV2(param)
         .stream()
         .map(
            e -> {
               ProjectCargoListMeteDTO dto = BeanUtil.copy(e, ProjectCargoListMeteDTO.class);
               dto.setSendInventoryQuantityRatio(
                  e.getQuantity() == 0 ? BigDecimal.ZERO : BigDecimal.valueOf(e.getSendQuantity() * 100).divide(BigDecimal.valueOf(e.getQuantity().intValue()), 2, RoundingMode.DOWN)
               );
               dto.setSendWarehouseQuantityRatio(
                  e.getWarehouseQuantity() == 0 ? BigDecimal.ZERO : BigDecimal.valueOf(e.getSendQuantity() * 100).divide(BigDecimal.valueOf(e.getWarehouseQuantity().intValue()), 2, RoundingMode.DOWN)
               );
               if (param.getWeightStatus().equals(0)) {
                  dto.setSendInventoryWeightRatio(e.getMete().signum() == 0 ? BigDecimal.ZERO : e.getSendMete().multiply(BigDecimal.valueOf(100L)).divide(e.getMete(), 2, RoundingMode.DOWN));
                  dto.setSendWarehouseWeightRatio(e.getWarehouseMete().signum() == 0 ? BigDecimal.ZERO : e.getSendMete().multiply(BigDecimal.valueOf(100L)).divide(e.getWarehouseMete(), 2, RoundingMode.DOWN));
               } else {
                  dto.setSendInventoryWeightRatio(e.getGrossMete().signum() == 0 ? BigDecimal.ZERO : e.getSendGrossMete().multiply(BigDecimal.valueOf(100L)).divide(e.getGrossMete(), 2, RoundingMode.DOWN));
                  dto.setSendWarehouseWeightRatio(
                     e.getWarehouseGrossMete().signum() == 0 ? BigDecimal.ZERO : e.getSendGrossMete().multiply(BigDecimal.valueOf(100L)).divide(e.getWarehouseGrossMete(), 2, RoundingMode.DOWN)
                  );
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectCargoListEnclosureMeteDTO> projectCargoListEnclosureProjectSummary(
      LocalDateTime dateTime, Integer sendStatus, Boolean settled, Long workshopId, String projectName, Integer projectStatus
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.ENCLOSURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new ArrayList<>();
      } else {
         List<ProjectCargoListEnclosureMeteDO> enclosureMeteDOS = this.cargoListService
            .projectCargoListEnclosureProjectSummary(dateTime, sendStatus, settled, workshopId, projectIds, 1, projectName, projectStatus);
         if (CollectionUtils.isNotEmpty(enclosureMeteDOS)) {
            enclosureMeteDOS.forEach(e -> e.getProject().setProjectContentList(this.projectContentService.listByContentStr(e.getProject().getProjectContent())));
            return enclosureMeteDOS.stream().map(e -> BeanUtil.copy(e, ProjectCargoListEnclosureMeteDTO.class)).collect(Collectors.toList());
         } else {
            return new ArrayList<>();
         }
      }
   }

   @Override
   public List<ProjectCargoListEnclosureMeteDTO> projectCargoListEnclosureProjectSummaryV2(CargoListStatisticsQueryParam param) {
      List<ProjectCargoListEnclosureMeteDO> projectCargoListEnclosureMeteDOList = this.cargoListService.projectCargoListEnclosureProjectSummaryV2(param);
      return projectCargoListEnclosureMeteDOList.stream().map(e -> {
         ProjectCargoListEnclosureMeteDTO dto = BeanUtil.copy(e, ProjectCargoListEnclosureMeteDTO.class);
         dto.setRatio(e.getRatio().setScale(2, RoundingMode.DOWN));
         return dto;
      }).collect(Collectors.toList());
   }

   @Override
   public PageVO<ProjectCargoListMeteDTO> projectCargoListMeteSummaryPage(
      LocalDateTime dateTime,
      Integer sendStatus,
      Boolean settled,
      Long workshopId,
      String projectName,
      Integer productionLineTypeEnum,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer projectStatus,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.projectCargoListMeteSummary(
            dateTime, sendStatus, settled, workshopId, projectName, productionLineTypeEnum, projectType, lumpSumSystemType, projectStatus
         )
      );
   }

   @Override
   public PageVO<ProjectCargoListEnclosureMeteDTO> projectCargoListEnclosureSummaryPage(
      LocalDateTime dateTime,
      Integer sendStatus,
      Boolean settled,
      Long workshopId,
      String projectName,
      Integer projectStatus,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.projectCargoListEnclosureProjectSummary(dateTime, sendStatus, settled, workshopId, projectName, projectStatus)
      );
   }

   @Override
   public ProjectCargoListSumDetailDTO projectDetailSummary(Long projectId, Long monomerId, Long areaId, Long workshopId, LocalDateTime dateTime) {
      ContractProject project = this.contractProjectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!!!");
      ProjectCargoListSumDetailDTO detailDTO = this.cargoListService
         .projectDetailSummary(projectId, monomerId, areaId, workshopId, dateTime, LocalDateTime.now());
      if (detailDTO != null && workshopId != null) {
         MesBuildingWorkshop workshop = this.mesBuildingWorkshopService.getById(workshopId);
         Preconditions.checkArgument(workshop != null, "车间信息不存在!!!");
         detailDTO.setWorkshop(WorkshopDetailDO.builder().id(workshopId).name(workshop.getName()).build());
      }

      return detailDTO;
   }

   private void setSummaryPackageInfo(ProjectCargoListSumDetailDTO detailDTO, Long projectId, Long monomerId, Long areaId, Integer productType) {
      List<MesBuildingPackage> packageList = this.packageService
         .list(
            Wrappers.lambdaQuery(MesBuildingPackage.class)
               .eq(projectId != null, MesBuildingPackage::getProjectId, projectId)
               .apply("product_type & {0} > 0", productType)
         );
      detailDTO.setPackageQuantity(packageList.size());
      detailDTO.setPackageMete(BigDecimal.ZERO);
      detailDTO.setPackageGrossMete(BigDecimal.ZERO);
      if (!packageList.isEmpty()) {
         Set<Long> packageIds = packageList.stream().map(MesBuildingPackage::getId).collect(Collectors.toSet());
         List<MesBuildingPackageLink> packageLinkList = this.packageLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingPackageLink.class)
                  .in(MesBuildingPackageLink::getPackageId, packageIds)
                  .eq(monomerId != null, MesBuildingPackageLink::getMonomerId, monomerId)
                  .eq(areaId != null, MesBuildingPackageLink::getAreaId, areaId)
                  .eq(MesBuildingPackageLink::getProductType, productType)
            );
         if (!packageLinkList.isEmpty()) {
            if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
               Map<Long, TechMachinePart> machinePartMap = this.machinePartService
                  .listByIds(packageLinkList.stream().map(MesBuildingPackageLink::getProductId).collect(Collectors.toSet()))
                  .stream()
                  .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
               BigDecimal totalNetWeight = packageLinkList.stream()
                  .filter(link -> machinePartMap.containsKey(link.getProductId()))
                  .map(link -> machinePartMap.get(link.getProductId()).getNetWeight().multiply(link.getQuantity()))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal totalGrossWeight = packageLinkList.stream()
                  .filter(link -> machinePartMap.containsKey(link.getProductId()))
                  .map(link -> machinePartMap.get(link.getProductId()).getGrossWeight().multiply(link.getQuantity()))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               detailDTO.setPackageMete(totalNetWeight);
               detailDTO.setPackageGrossMete(totalGrossWeight);
            }

            if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
               Map<Long, TechArtifact> artifactMap = this.artifactService
                  .listByIds(packageLinkList.stream().map(MesBuildingPackageLink::getProductId).collect(Collectors.toSet()))
                  .stream()
                  .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
               BigDecimal totalNetWeight = packageLinkList.stream()
                  .filter(link -> artifactMap.containsKey(link.getProductId()))
                  .map(link -> artifactMap.get(link.getProductId()).getNetWeight().multiply(link.getQuantity()))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               BigDecimal totalGrossWeight = packageLinkList.stream()
                  .filter(link -> artifactMap.containsKey(link.getProductId()))
                  .map(link -> artifactMap.get(link.getProductId()).getGrossWeight().multiply(link.getQuantity()))
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
               detailDTO.setPackageMete(totalNetWeight);
               detailDTO.setPackageGrossMete(totalGrossWeight);
            }
         }
      }
   }

   @Override
   public ProjectCargoListSumDetailDTO directShipmentProjectDetailSummary(Long projectId, Long monomerId, Long areaId, Long workshopId, LocalDateTime dateTime) {
      ContractProject project = this.contractProjectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!!!");
      List<Integer> productTypeList = Arrays.asList(ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.MACHINE_PART.getType());
      ProjectCargoListSumDetailDTO detailDTO = this.cargoListService
         .directShipmentProjectDetailSummary(projectId, monomerId, areaId, workshopId, dateTime, LocalDateTime.now(), productTypeList);
      if (detailDTO != null && workshopId != null) {
         MesBuildingWorkshop workshop = this.mesBuildingWorkshopService.getById(workshopId);
         Preconditions.checkArgument(workshop != null, "车间信息不存在!!!");
         detailDTO.setWorkshop(WorkshopDetailDO.builder().id(workshopId).name(workshop.getName()).build());
      }

      return detailDTO;
   }

   @Override
   public ProjectCargoListSumEnclosureDetailDTO projectEnclosureDetailSummary(
      Long projectId, Integer category, Long enclosurePlanId, Long workshopId, LocalDateTime dateTime
   ) {
      ContractProject project = this.contractProjectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!!!");
      ProjectCargoListSumEnclosureDetailDTO detailDTO = this.cargoListService
         .projectEnclosureDetailSummary(projectId, category, enclosurePlanId, workshopId, dateTime, LocalDateTime.now());
      this.setEnclosureSummaryPackageInfo(detailDTO, projectId, enclosurePlanId, category);
      if (detailDTO != null && workshopId != null) {
         MesBuildingWorkshop workshop = this.mesBuildingWorkshopService.getById(workshopId);
         Preconditions.checkArgument(workshop != null, "车间信息不存在!!!");
         detailDTO.setWorkshop(WorkshopDetailDO.builder().id(workshopId).name(workshop.getName()).build());
      }

      return detailDTO;
   }

   private void setEnclosureSummaryPackageInfo(ProjectCargoListSumEnclosureDetailDTO detailDTO, Long projectId, Long enclosurePlanId, Integer category) {
      List<MesBuildingPackage> packageList = this.packageService
         .list(
            Wrappers.lambdaQuery(MesBuildingPackage.class)
               .eq(projectId != null, MesBuildingPackage::getProjectId, projectId)
               .apply("product_type & {0} > 0", ProductTypeEnum.ENCLOSURE.getType())
         );
      detailDTO.setPackageQuantity(packageList.size());
      detailDTO.setPackageTotalLength(BigDecimal.ZERO);
      detailDTO.setPackageTotalArea(BigDecimal.ZERO);
      if (!packageList.isEmpty()) {
         Set<Long> packageIds = packageList.stream().map(MesBuildingPackage::getId).collect(Collectors.toSet());
         List<MesBuildingPackageLink> packageLinkList = this.packageLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingPackageLink.class)
                  .in(MesBuildingPackageLink::getPackageId, packageIds)
                  .eq(enclosurePlanId != null, MesBuildingPackageLink::getPlanId, enclosurePlanId)
                  .eq(MesBuildingPackageLink::getProductType, ProductTypeEnum.ENCLOSURE.getType())
            );
         Set<Long> enclosureIds = packageLinkList.stream().map(MesBuildingPackageLink::getProductId).collect(Collectors.toSet());
         Map<Long, TechEnclosure> enclosureMap = this.enclosureService
            .listByIds(enclosureIds)
            .stream()
            .filter(e -> category == null || e.getCategory().equals(category))
            .collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
         BigDecimal totalLength = packageLinkList.stream()
            .filter(link -> enclosureMap.containsKey(link.getProductId()))
            .map(link -> enclosureMap.get(link.getProductId()).getLength().multiply(link.getQuantity()))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal totalArea = packageLinkList.stream()
            .filter(link -> enclosureMap.containsKey(link.getProductId()))
            .map(link -> enclosureMap.get(link.getProductId()).getSurfaceArea().multiply(link.getQuantity()))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         detailDTO.setPackageTotalLength(totalLength);
         detailDTO.setPackageTotalArea(totalArea);
      }
   }

   @Override
   public PageVO projectDetailType(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      Integer pageNumber,
      Integer pageSize
   ) {
      ContractProject project = this.contractProjectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!!!");
      PageHelper.startPage(pageNumber, pageSize);
      return !CargoListShipEnum.ACCUMULATED_NUMBER.getType().equals(shipEnumType)
         ? new PageVO<>(
            this.cargoListService
               .projectDetailType(projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, LocalDateTime.now(), shipEnumType)
         )
         : new PageVO();
   }

   @Override
   public PageVO directShipmentProjectDetailType(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      Integer pageNumber,
      Integer pageSize
   ) {
      ContractProject project = this.contractProjectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!!!");
      if (CargoListShipEnum.ASSIGNMENT.getType().equals(shipEnumType)) {
         return new PageVO<>();
      }
      PageHelper.startPage(pageNumber, pageSize);
      return !CargoListShipEnum.ACCUMULATED_NUMBER.getType().equals(shipEnumType)
         ? new PageVO<>(
            this.cargoListService
               .directShipmentProjectDetailTypeV2(
                  projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, LocalDateTime.now(), shipEnumType
               )
         )
         : new PageVO();
   }

   @Override
   public PageVO projectEnclosureDetailType(
      Long projectId,
      Integer category,
      Long enclosurePlanId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      Integer pageNumber,
      Integer pageSize
   ) {
      ContractProject project = this.contractProjectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!!!");
      PageHelper.startPage(pageNumber, pageSize);
      return !CargoListShipEnum.ACCUMULATED_NUMBER.getType().equals(shipEnumType)
         ? new PageVO<>(
            this.cargoListService
               .projectEnclosureDetailType(
                  projectId, category, enclosurePlanId, serialNumber, productSourceType, workshopId, dateTime, LocalDateTime.now(), shipEnumType
               )
         )
         : new PageVO();
   }

   @Override
   public PrintVO<List<Map<String, Object>>> projectDetailTypePrint(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      Integer weightStatus,
      HttpServletResponse response
   ) {
      try {
         ContractProject project = this.contractProjectService.getById(projectId);
         Preconditions.checkArgument(project != null, "项目不存在!!!");
         PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
         Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
         header.put("projectName", project.getShortName());
         header.put("projectSerialNumber()", project.getSerialNumber());
         header.put("year", "所有");
         header.put("weightStatus", weightStatus);
         if (dateTime != null) {
            header.put("year", dateTime.get(ChronoField.YEAR));
         }

         printVO.setHeader(header);
         List<CargoListArtifactTypeDTO> typeDTOS = this.cargoListService
            .projectDetailType(projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, LocalDateTime.now(), shipEnumType);
         List<Map<String, Object>> mapList = typeDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
         printVO.setTable(mapList);
         return printVO;
      } catch (Throwable $ex) {
         throw MesBuildingCargoListBizImpl.<RuntimeException>rethrow($ex);
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> directShipmentProjectDetailTypePrint(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      HttpServletResponse response
   ) {
      try {
         ContractProject project = this.contractProjectService.getById(projectId);
         Preconditions.checkArgument(project != null, "项目不存在!!!");
         PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
         Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
         header.put("projectName", project.getShortName());
         header.put("projectSerialNumber()", project.getSerialNumber());
         header.put("year", "所有");
         if (dateTime != null) {
            header.put("year", dateTime.get(ChronoField.YEAR));
         }

         printVO.setHeader(header);
         if (CargoListShipEnum.ASSIGNMENT.getType().equals(shipEnumType)) {
            printVO.setTable(Collections.emptyList());
            return printVO;
         }
         List<Integer> productTypeList = Arrays.asList(ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.MACHINE_PART.getType());
         List<CargoListArtifactTypeDTO> typeDTOS = this.cargoListService
            .directShipmentProjectDetailTypeV2(
               projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, LocalDateTime.now(), shipEnumType
            );
         List<Map<String, Object>> mapList = typeDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
         printVO.setTable(mapList);
         return printVO;
      } catch (Throwable $ex) {
         throw MesBuildingCargoListBizImpl.<RuntimeException>rethrow($ex);
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> projectEnclosureDetailTypePrint(
      Long projectId,
      Integer category,
      Long enclosurePlanId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      HttpServletResponse response
   ) {
      ContractProject project = this.contractProjectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!!!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectName", project.getShortName());
      header.put("projectSerialNumber()", project.getSerialNumber());
      header.put("year", "所有");
      if (dateTime != null) {
         header.put("year", dateTime.get(ChronoField.YEAR));
      }

      printVO.setHeader(header);
      List<CargoListEnclosureTypeDTO> enclosureTypeDTOS = this.cargoListService
         .projectEnclosureDetailType(
            projectId, category, enclosurePlanId, serialNumber, productSourceType, workshopId, dateTime, LocalDateTime.now(), shipEnumType
         );
      List<Map<String, Object>> mapList = enclosureTypeDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public void projectDetailTypeDown(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      Integer shipEnumType,
      HttpServletResponse response
   ) {
      try {
         Map<String, Object> exportMap = new HashMap<>();
         ContractProject project = this.contractProjectService.getById(projectId);
         Preconditions.checkArgument(project != null, "项目不存在!!!");
         exportMap.put("projectSerialNumber", project.getSerialNumber());
         exportMap.put("projectShortName", project.getShortName());
         exportMap.put("year", "所有");
         if (dateTime != null) {
            exportMap.put("year", dateTime.get(ChronoField.YEAR));
         }

         if (!CargoListShipEnum.ACCUMULATED_NUMBER.getType().equals(shipEnumType)) {
            List<Map<String, Object>> cargoList = new ArrayList<>();
            exportMap.put("typeName", CargoListShipEnum.getNameByType(shipEnumType));
            List<CargoListArtifactTypeDTO> typeDTOS = this.cargoListService
               .projectDetailType(projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, LocalDateTime.now(), shipEnumType);
            if (CollectionUtils.isNotEmpty(typeDTOS)) {
               int number = 1;

               for (CargoListArtifactTypeDTO typeDTO : typeDTOS) {
                  Map<String, Object> cargoListMap = BeanUtil.beanToMap(typeDTO);
                  cargoListMap.put("orderNumber", number++);
                  cargoListMap.put("workShopName", typeDTO.getWorkshop() == null ? "/" : typeDTO.getWorkshop().getName());
                  cargoListMap.put("monomerName", typeDTO.getMonomer().getName());
                  cargoListMap.put("areaName", typeDTO.getArea().getName());
                  cargoList.add(cargoListMap);
               }

               exportMap.put("cargoList", cargoList);
            }

            String tempFileName = "projectCargoDetail";
            String resourcePath = "files/projectCargoDetail.xlsx";
            String exportFileName = "发运统计(" + CargoListShipEnum.getNameByType(shipEnumType) + ").xlsx";
            org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
            InputStream inputStream = resource.getInputStream();
            File file = File.createTempFile(tempFileName, "xlsx");
            FileUtil.copyInputStreamToFile(inputStream, file);
            TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
            Workbook workbook = ExcelExportUtil.exportExcel(params, exportMap);
            PoiUtils.downLoadExcel(exportFileName, response, workbook);
         }
      } catch (Throwable $ex) {
         throw MesBuildingCargoListBizImpl.<RuntimeException>rethrow($ex);
      }
   }

   @Override
   public YearCargoListMeteDTO getYearCargoListMeteSummary(
      LocalDateTime dateTime, Long workshopId, Integer productionLineTypeEnum, Integer projectType, Integer lumpSumSystemType, Integer projectStatus
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.STRUCTURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      return YearCargoListMeteDTO.builder()
         .mete(this.cargoListService.getYearCargoListMeteSummary(dateTime, workshopId, productionLineTypeEnum, projectIds, projectStatus).getMete())
         .quantity(
            this.cargoListService.getYearCargoListNumberSummary(dateTime, workshopId, productionLineTypeEnum, projectIds, null, null, null, projectStatus)
         )
         .build();
   }

   @Override
   public YearCargoListMeteDTO getYearCargoListEnclosureSummary(
      LocalDateTime dateTime, Long workshopId, Integer projectType, Integer lumpSumSystemType, Integer projectStatus
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .filter(e -> (ProjectContentCategoryEnum.ENCLOSURE.getType() & e.getProductCategory()) > 0)
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      YearCargoListMeteDO meteDO = this.cargoListService.getYearCargoListEnclosureMeteSummary(dateTime, workshopId, projectIds, projectStatus);
      return YearCargoListMeteDTO.builder()
         .totalLength(meteDO.getTotalLength())
         .totalArea(meteDO.getTotalArea())
         .quantity(this.cargoListService.getYearCargoListEnclosureNumberSummary(dateTime, workshopId, projectIds, null, null, null, projectStatus))
         .build();
   }

   @Override
   public List<ProjectCargoListMeteDetailDTO> projectCargoListMeteDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      String serialNumber,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      List<ProjectCargoListMeteDetailDTO> projectCargoListMeteDetailDTOS = this.cargoListService
         .projectCargoListMeteDetail(projectId, monomerId, areaId, workshopId, serialNumber, productionLineTypeEnum, startDate, endDate);

      for (ProjectCargoListMeteDetailDTO detail : projectCargoListMeteDetailDTOS) {
         detail.setInventory(detail.getInboundQuantity() - detail.getCargoQuantity());
         BigDecimal netweightinstorage = BigDecimal.valueOf(detail.getInboundQuantity().intValue()).multiply(detail.getNetWeight());
         BigDecimal grossweightinstorage = BigDecimal.valueOf(detail.getInboundQuantity().intValue()).multiply(detail.getGrossWeight());
         detail.setInventoryNetWeight(netweightinstorage.subtract(detail.getCargoNetWeight()));
         detail.setInventoryGrossWeight(grossweightinstorage.subtract(detail.getCargoGrossWeight()));
      }

      return projectCargoListMeteDetailDTOS;
   }

   @Override
   public List<ProjectCargoListMeteDetailDTO> directShipmentProjectCargoListMeteDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      String serialNumber,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      List<Integer> productTypeList = Arrays.asList(ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.MACHINE_PART.getType());
      List<ProjectCargoListMeteDetailDTO> details = this.cargoListService
         .directShipmentProjectCargoListMeteDetail(
            projectId, monomerId, areaId, workshopId, serialNumber, productionLineTypeEnum, productTypeList, startDate, endDate
         );
      for (ProjectCargoListMeteDetailDTO detail : details) {
         detail.setInventory(detail.getInboundQuantity() - detail.getCargoQuantity());
         BigDecimal inboundQuantity = BigDecimal.valueOf(detail.getInboundQuantity());
         detail.setInventoryNetWeight(inboundQuantity.multiply(detail.getNetWeight()).subtract(detail.getCargoNetWeight()));
         detail.setInventoryGrossWeight(inboundQuantity.multiply(detail.getGrossWeight()).subtract(detail.getCargoGrossWeight()));
      }
      return details;
   }

   @Override
   public List<ProjectCargoListEnclosureDetailDTO> projectCargoListEnclosureDetail(
      Long projectId, Integer category, Long enclosurePlanId, Long workshopId, String serialNumber
   ) {
      return this.cargoListService.projectCargoListEnclosureDetail(projectId, category, enclosurePlanId, workshopId, serialNumber);
   }

   @Override
   public List<ProjectCargoListAuxiliaryDetailDTO> projectCargoListAuxiliaryDetail(
      Long projectId, Long monomerId, Long areaId, Integer category, Long enclosurePlanId, String serialNumber, Integer relationType, Integer projectStatus
   ) {
      List<ProjectCargoListAuxiliaryDetailDTO> auxiliaryDetailDTOList = this.cargoListService
         .projectCargoListAuxiliaryDetail(projectId, monomerId, areaId, category, enclosurePlanId, serialNumber, relationType, projectStatus);
      if (CollectionUtils.isNotEmpty(auxiliaryDetailDTOList)) {
         List<Long> auxiliaryIds = auxiliaryDetailDTOList.stream().map(ProjectCargoListAuxiliaryDetailDTO::getId).collect(Collectors.toList());
         List<MesBuildingPackageLink> packageLinkList = this.packageLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingPackageLink.class)
                  .in(
                     MesBuildingPackageLink::getWarehouseType,
                     WarehouseTypeProductReturnEnum.NORMAL.getType(),
                     WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
                  )
                  .eq(MesBuildingPackageLink::getProductType, ProductTypeEnum.AUXILIARY_MATERIAL.getType())
                  .in(MesBuildingPackageLink::getProductId, auxiliaryIds)
            );
         if (packageLinkList.isEmpty()) {
            auxiliaryDetailDTOList.forEach(a -> a.setPackageList(Collections.emptyList()));
         } else {
            Map<Long, MesBuildingPackage> packageMap = this.packageService
               .listByIds(packageLinkList.stream().map(MesBuildingPackageLink::getPackageId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(MesBuildingPackage::getId, Function.identity()));
            Map<Long, List<MesBuildingPackage>> productIdPackageListMap = packageLinkList.stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingPackageLink::getProductId, Collectors.mapping(link -> packageMap.get(link.getPackageId()), Collectors.toList())
                  )
               );
            auxiliaryDetailDTOList.forEach(a -> a.setPackageList(productIdPackageListMap.getOrDefault(a.getId(), Collections.emptyList())));
         }
      }

      return auxiliaryDetailDTOList;
   }

   @Override
   public PageVO<ProjectCargoListMeteDetailDTO> projectCargoListMeteDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.projectCargoListMeteDetail(projectId, monomerId, areaId, workshopId, null, productionLineTypeEnum, startDate, endDate)
      );
   }

   @Override
   public PageVO<ProjectCargoListMeteDetailDTO> directShipmentProjectCargoListMeteDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.directShipmentProjectCargoListMeteDetail(projectId, monomerId, areaId, workshopId, null, productionLineTypeEnum, startDate, endDate)
      );
   }

   @Override
   public PageVO<ProjectCargoListEnclosureDetailDTO> projectCargoListEnclosureDetailPage(
      Long projectId, Integer category, Long enclosurePlanId, Long workshopId, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize), this.projectCargoListEnclosureDetail(projectId, category, enclosurePlanId, workshopId, null)
      );
   }

   @Override
   public PageVO<ProjectCargoListAuxiliaryDetailDTO> projectCargoListAuxiliaryDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer category,
      Long enclosurePlanId,
      String serialNumber,
      Integer relationType,
      Integer projectStatus,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.projectCargoListAuxiliaryDetail(projectId, monomerId, areaId, category, enclosurePlanId, serialNumber, relationType, projectStatus)
      );
   }

   @Override
   public PrintVO<List<Map<String, Object>>> projectCargoListMeteDetailPrint(
      Long projectId, Long monomerId, Long areaId, Long workshopId, Integer productionLineTypeEnum, LocalDateTime startDate, LocalDateTime endDate
   ) {
      ContractProject project = this.contractProjectService.getById(projectId);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectName", project.getName());
      printVO.setHeader(header);
      printVO.setTable(
         this.projectCargoListMeteDetail(projectId, monomerId, areaId, workshopId, null, productionLineTypeEnum, startDate, endDate)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> directShipmentProjectCargoListMeteDetailPrint(
      Long projectId, Long monomerId, Long areaId, Long workshopId, Integer productionLineTypeEnum, LocalDateTime startDate, LocalDateTime endDate
   ) {
      ContractProject project = this.contractProjectService.getById(projectId);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectName", project.getName());
      printVO.setHeader(header);
      printVO.setTable(
         this.directShipmentProjectCargoListMeteDetail(projectId, monomerId, areaId, workshopId, null, productionLineTypeEnum, startDate, endDate)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> projectCargoListEnclosureDetailPrint(Long projectId, Integer category, Long enclosurePlanId, Long workshopId) {
      ContractProject project = this.contractProjectService.getById(projectId);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectName", project.getName());
      printVO.setHeader(header);
      printVO.setTable(
         this.projectCargoListEnclosureDetail(projectId, category, enclosurePlanId, workshopId, null)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> projectCargoListAuxiliaryDetailPrint(
      Long projectId, Long monomerId, Long areaId, Integer category, Long enclosurePlanId, String serialNumber, Integer relationType, Integer projectStatus
   ) {
      ContractProject project = this.contractProjectService.getById(projectId);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("projectName", project.getName());
      printVO.setHeader(header);
      printVO.setTable(
         this.projectCargoListAuxiliaryDetail(projectId, monomerId, areaId, category, enclosurePlanId, serialNumber, relationType, projectStatus)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public YearCargoListDTO getYearCargoListSummary(LocalDateTime dateTime, Integer projectStatus) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      return YearCargoListDTO.builder()
         .cargoQuantity(this.cargoListService.getYearCargoListNumberSummary(dateTime, null, null, projectIds, null, null, null, projectStatus))
         .cargoMete(this.cargoListService.getYearCargoListMeteSummary(dateTime, null, null, projectIds, projectStatus).getMete())
         .stockMete(
            this.warehouseBiz
               .finishedWarehouseSummary(null, dateTime, null, null, ProductTypeEnum.ARTIFACT.getType(), null, projectIds, projectStatus)
               .getStockNetWeight()
         )
         .build();
   }

   @Override
   public List<CargoListMeteGroupMonthDTO> getCargoListGroupMonth(LocalDateTime dateTime) {
      return this.cargoListService.getCargoListGroupMonth(dateTime);
   }

   @Override
   public List<ProjectCargoListMeteDTO> projectCargoListSummaryList(LocalDateTime dateTime, Integer projectStatus) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new ArrayList<>();
      }

      List<ProjectCargoListMeteDTO> list1 = this.cargoListService
         .projectCargoListMeteSummary(dateTime, null, null, null, null, projectIds, 2, null, projectStatus)
         .stream()
         .map(e -> BeanUtil.copy(e, ProjectCargoListMeteDTO.class))
         .collect(Collectors.toList());
      List<ProjectCargoListMeteDTO> list2 = this.cargoListService.getYearCargoListQuantity(dateTime, null);
      return list1.stream().map(m -> {
         list2.stream().filter(m2 -> Objects.equals(m.getProject().getId(), m2.getProject().getId())).forEach(m2 -> m.setCargoQuantity(m2.getCargoQuantity()));
         return (ProjectCargoListMeteDTO)m;
      }).filter(e -> e.getSendQuantity() > 0).collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingCargoListDTO> shipmentByProject(Long id) {
      List<MesBuildingCargoListDTO> dtos = new ArrayList<>();
      List<MesBuildingCargoList> all = this.mesBuildingCargoListService
         .list(Wrappers.lambdaQuery(MesBuildingCargoList.class).eq(MesBuildingCargoList::getProjectId, id));
      if (CollectionUtils.isEmpty(all)) {
         return new ArrayList<>();
      }

      List<MesBuildingCargoList> sendList = all.stream()
         .filter(s -> (s.getStatus() & (CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType())) > 0)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(sendList)) {
         return new ArrayList<>();
      }

      for (MesBuildingCargoList cargo : sendList) {
         MesBuildingCargoListDTO dto = BeanUtil.copy(cargo, MesBuildingCargoListDTO.class);
         // Original response DTO represents piece count as Integer; BeanUtil skips BigDecimal -> Integer.
         dto.setQuantity(cargo.getQuantity().intValue());
         dtos.add(dto);
      }

      return dtos;
   }

   @Override
   public Map shipmentSummary(Long id) {
      List<MesBuildingCargoListDTO> mesBuildingCargoListDTOS = this.shipmentByProject(id);
      int quantity = mesBuildingCargoListDTOS.stream().mapToInt(MesBuildingCargoListDTO::getQuantity).sum();
      BigDecimal totalNetWeight = mesBuildingCargoListDTOS.stream().map(MesBuildingCargoListDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalGrossWeight = mesBuildingCargoListDTOS.stream()
         .map(MesBuildingCargoListDTO::getTotalGrossWeight)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal actualWeight = mesBuildingCargoListDTOS.stream().map(MesBuildingCargoListDTO::getActualWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal actualGrossWeight = mesBuildingCargoListDTOS.stream()
         .map(MesBuildingCargoListDTO::getActualGrossWeight)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalPrice = mesBuildingCargoListDTOS.stream().map(MesBuildingCargoListDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
      HashMap<String, Object> map = new HashMap<>();
      map.put("quantity", quantity);
      map.put("totalNetWeight", totalNetWeight);
      map.put("totalGrossWeight", totalGrossWeight);
      map.put("actualWeight", actualWeight);
      map.put("actualGrossWeight", actualGrossWeight);
      map.put("totalPrice", totalPrice);
      return map;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> shipmentByProjectPrint(Long id) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (id != null) {
         ProjectInfo projectInfo = this.projectService.getSimpleById(id);
         header.put("project", projectInfo);
      }

      printVO.setHeader(header);
      List<MesBuildingCargoListDTO> mesBuildingCargoListDTOS = this.shipmentByProject(id);
      List<Map<String, Object>> mapList = mesBuildingCargoListDTOS.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PageVO shipmentByProjectPage(Long projectId, Integer pageNumber, Integer pageSize) {
      List<MesBuildingCargoListDTO> dtos = new ArrayList<>();
      PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingCargoList> all = this.mesBuildingCargoListService
         .list(
            Wrappers.lambdaQuery(MesBuildingCargoList.class)
               .eq(MesBuildingCargoList::getProjectId, projectId)
               .and(
                  item -> {
                     LambdaQueryWrapper var10000 = item.eq(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType())
                        .or()
                        .eq(MesBuildingCargoList::getStatus, CargoListStatusEnum.RECEIPT.getType());
                  }
               )
         );
      if (CollectionUtils.isEmpty(all)) {
         return new PageVO();
      }

      if (CollectionUtils.isEmpty(all)) {
         return new PageVO();
      }

      PageVO pageVO = new PageVO<>(all);

      for (MesBuildingCargoList cargo : all) {
         MesBuildingCargoListDTO dto = BeanUtil.copy(cargo, MesBuildingCargoListDTO.class);
         // Original response DTO represents piece count as Integer; BeanUtil skips BigDecimal -> Integer.
         dto.setQuantity(cargo.getQuantity().intValue());
         dtos.add(dto);
      }

      pageVO.setContent(dtos);
      return pageVO;
   }

   @Override
   public List<CargoListMeteByMonomerAndAreaDTO> projectByMonomerCargoList(Long projectId) {
      List<CargoListMeteByMonomerAndAreaDTO> dtoList = new ArrayList<>();
      List<ProjectCargoListMeteDetailDTO> projectCargoListMeteDetailDTOS = this.projectCargoListMeteDetail(projectId, null, null, null, null, null, null, null);
      Map<Long, List<ProjectCargoListMeteDetailDTO>> listMap = projectCargoListMeteDetailDTOS.stream().collect(Collectors.groupingBy(s -> s.getMonomerId()));

      for (Long monomerId : listMap.keySet()) {
         String monomerName = listMap.get(monomerId).stream().map(ProjectCargoListMeteDetailDTO::getMonomerName).findFirst().get();
         Integer quantity = listMap.get(monomerId).stream().mapToInt(ProjectCargoListMeteDetailDTO::getQuantity).sum();
         Integer cargoQuantity = listMap.get(monomerId).stream().mapToInt(ProjectCargoListMeteDetailDTO::getCargoQuantity).sum();
         Integer unCargoQuantity = quantity - cargoQuantity;
         BigDecimal totalNetWeight = listMap.get(monomerId)
            .stream()
            .map(ProjectCargoListMeteDetailDTO::getTotalNetWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal cargoNetWeight = listMap.get(monomerId)
            .stream()
            .map(ProjectCargoListMeteDetailDTO::getCargoNetWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal unCargoNetWeight = totalNetWeight.subtract(cargoNetWeight);
         CargoListMeteByMonomerAndAreaDTO build = CargoListMeteByMonomerAndAreaDTO.builder()
            .monomerId(monomerId)
            .monomerName(monomerName)
            .quantity(quantity)
            .cargoQuantity(cargoQuantity)
            .unCargoQuantity(unCargoQuantity)
            .totalNetWeight(totalNetWeight)
            .cargoNetWeight(cargoNetWeight)
            .unCargoNetWeight(unCargoNetWeight)
            .build();
         dtoList.add(build);
      }

      return dtoList;
   }

   @Override
   public List<CargoListDO> cargoListShipByProject(Long projectId) {
      CargoListDOParam copy = new CargoListDOParam();
      copy.setProjectId(projectId);
      return this.cargoListService.pageByCondition(copy).getContent();
   }

   @Override
   public YearCargoListDTO projectCargoListSummary(Long projectId) {
      List<CargoListMeteByMonomerAndAreaDTO> dtoList = this.projectByMonomerCargoList(projectId);
      return YearCargoListDTO.builder()
         .cargoQuantity(this.cargoListService.getYearCargoListQuantity(null, projectId).stream().mapToInt(ProjectCargoListMeteDTO::getCargoQuantity).sum())
         .totalNetWeight(dtoList.stream().map(CargoListMeteByMonomerAndAreaDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .cargoMete(dtoList.stream().map(CargoListMeteByMonomerAndAreaDTO::getCargoNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .build();
   }

   @Override
   public List<CargoListMeteByMonomerAndAreaDTO> projectByAreaCargoList(Long projectId, Long monomerId) {
      List<CargoListMeteByMonomerAndAreaDTO> dtoList = new ArrayList<>();
      List<ProjectCargoListMeteDetailDTO> projectCargoListMeteDetailDTOS = this.projectCargoListMeteDetail(
         projectId, monomerId, null, null, null, null, null, null
      );
      Map<Long, List<ProjectCargoListMeteDetailDTO>> listMap = projectCargoListMeteDetailDTOS.stream().collect(Collectors.groupingBy(s -> s.getAreaId()));

      for (Long areaId : listMap.keySet()) {
         String areaName = listMap.get(areaId).stream().map(ProjectCargoListMeteDetailDTO::getAreaName).findFirst().get();
         Integer quantity = listMap.get(areaId).stream().mapToInt(ProjectCargoListMeteDetailDTO::getQuantity).sum();
         Integer cargoQuantity = listMap.get(areaId).stream().mapToInt(ProjectCargoListMeteDetailDTO::getCargoQuantity).sum();
         Integer unCargoQuantity = quantity - cargoQuantity;
         BigDecimal totalNetWeight = listMap.get(areaId)
            .stream()
            .map(ProjectCargoListMeteDetailDTO::getTotalNetWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal cargoNetWeight = listMap.get(areaId)
            .stream()
            .map(ProjectCargoListMeteDetailDTO::getCargoNetWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal unCargoNetWeight = totalNetWeight.subtract(cargoNetWeight);
         CargoListMeteByMonomerAndAreaDTO build = CargoListMeteByMonomerAndAreaDTO.builder()
            .areaId(areaId)
            .areaName(areaName)
            .quantity(quantity)
            .cargoQuantity(cargoQuantity)
            .unCargoQuantity(unCargoQuantity)
            .totalNetWeight(totalNetWeight)
            .cargoNetWeight(cargoNetWeight)
            .unCargoNetWeight(unCargoNetWeight)
            .build();
         dtoList.add(build);
      }

      return dtoList;
   }

   @Override
   public List<ArtifactByCargoDTO> projectByAreaProductCargoList(Long projectId, Long monomerId, Long areaId, String serialNumber, Integer type) {
      List<ArtifactByCargoDTO> dtoList = this.projectCargoListMeteDetail(projectId, monomerId, areaId, null, serialNumber, null, null, null)
         .stream()
         .map(e -> BeanUtil.copy(e, ArtifactByCargoDTO.class))
         .collect(Collectors.toList());
      this.setWarehouse(projectId, monomerId, areaId, serialNumber, dtoList);
      dtoList.forEach(e -> {
         if (e.getCargoQuantity() != 0 && e.getCargoQuantity() != null) {
            if (e.getCargoQuantity() > 0 && e.getCargoQuantity() < e.getQuantity()) {
               e.setType(2);
            } else {
               e.setType(4);
            }
         } else {
            e.setType(1);
         }
      });
      return dtoList.stream()
         .filter(e -> type == null || e.getType().equals(type))
         .sorted(Comparator.comparing(ArtifactByCargoDTO::getId))
         .collect(Collectors.toList());
   }

   private void setWarehouse(Long projectId, Long monomerId, Long areaId, String serialNumber, List<ArtifactByCargoDTO> dtoList) {
      if (StringUtils.isNotBlank(serialNumber)) {
         List<ArtifactByCargoDTO> dtoList2 = this.projectCargoListMeteDetail(projectId, monomerId, areaId, null, null, null, null, null)
            .stream()
            .map(e -> BeanUtil.copy(e, ArtifactByCargoDTO.class))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(dtoList2)) {
            List<MesBuildingWarehouse> warehouseList = this.mesBuildingWarehouseService
               .list(Wrappers.lambdaQuery(MesBuildingWarehouse.class).like(MesBuildingWarehouse::getName, serialNumber));
            if (CollectionUtils.isNotEmpty(warehouseList)) {
               List<MesBuildingWarehouseRecord> warehouseRecordList = this.mesBuildingWarehouseRecordService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                        .eq(projectId != null, MesBuildingWarehouseRecord::getProjectId, projectId)
                        .eq(monomerId != null, MesBuildingWarehouseRecord::getMonomerId, monomerId)
                        .eq(areaId != null, MesBuildingWarehouseRecord::getAreaId, areaId)
                        .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
                        .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
                        .in(
                           MesBuildingWarehouseRecord::getWarehouseType,
                           WarehouseTypeProductReturnEnum.NORMAL.getType(),
                           WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
                        )
                        .eq(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
                  );
               if (CollectionUtils.isNotEmpty(warehouseRecordList)) {
                  List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = this.warehouseStorageProductService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class)
                           .in(
                              MesBuildingWarehouseStorageProduct::getWarehouseId,
                              warehouseList.stream().map(MesBuildingWarehouse::getId).collect(Collectors.toList())
                           )
                           .in(
                              MesBuildingWarehouseStorageProduct::getWarehouseRecordId,
                              warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList())
                           )
                     );
                  if (CollectionUtils.isNotEmpty(warehouseStorageProductList)) {
                     List<TechArtifact> artifactList = this.artifactService
                        .listByIds(warehouseStorageProductList.stream().map(MesBuildingWarehouseStorageProduct::getProductId).collect(Collectors.toSet()));
                     Map<Long, ArtifactByCargoDTO> artifactByCargoDTOMap = dtoList.stream()
                        .collect(Collectors.toMap(ArtifactByCargoDTO::getId, Function.identity()));
                     artifactList = artifactList.stream().filter(a -> !artifactByCargoDTOMap.containsKey(a.getId())).collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(artifactList)) {
                        Map<Long, BigDecimal> productIdQuantityMap = this.mesBuildingWarehouseRecordService
                           .list(
                              Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                                 .eq(projectId != null, MesBuildingWarehouseRecord::getProjectId, projectId)
                                 .eq(monomerId != null, MesBuildingWarehouseRecord::getMonomerId, monomerId)
                                 .eq(areaId != null, MesBuildingWarehouseRecord::getAreaId, areaId)
                                 .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
                                 .in(MesBuildingWarehouseRecord::getProductId, artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
                                 .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.OUT.getType())
                                 .in(
                                    MesBuildingWarehouseRecord::getWarehouseType,
                                    WarehouseTypeProductReturnEnum.NORMAL.getType(),
                                    WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
                                 )
                           )
                           .stream()
                           .collect(
                              Collectors.groupingBy(
                                 MesBuildingWarehouseRecord::getProductId,
                                 Collectors.reducing(BigDecimal.ZERO, MesBuildingWarehouseRecord::getQuantity, BigDecimal::add)
                              )
                           );
                        List<ArtifactByCargoDTO> collect = artifactList.stream().map(s -> {
                           ArtifactByCargoDTO dto = BeanUtil.copy(s, ArtifactByCargoDTO.class);
                           dto.setCargoQuantity(productIdQuantityMap.getOrDefault(s.getId(), BigDecimal.valueOf(0L)).intValue());
                           return dto;
                        }).collect(Collectors.toList());
                        dtoList.addAll(collect);
                     }
                  }
               }
            }
         }
      }

      if (CollectionUtils.isNotEmpty(dtoList)) {
         dtoList.forEach(dto -> dto.setWarehouseList(Collections.emptyList()));
         List<MesBuildingWarehouseRecord> warehouseRecordList = this.mesBuildingWarehouseRecordService
            .list(
               Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                  .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
                  .in(MesBuildingWarehouseRecord::getProductId, dtoList.stream().map(ArtifactByCargoDTO::getId).collect(Collectors.toList()))
                  .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
                  .in(
                     MesBuildingWarehouseRecord::getWarehouseType,
                     WarehouseTypeProductReturnEnum.NORMAL.getType(),
                     WarehouseTypeProductReturnEnum.SUBSCRIBE.getType()
                  )
                  .eq(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
            );
         if (CollectionUtils.isNotEmpty(warehouseRecordList)) {
            List<MesBuildingWarehouseStorageProduct> warehouseStorageProductList = this.warehouseStorageProductService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseStorageProduct.class)
                     .in(
                        MesBuildingWarehouseStorageProduct::getWarehouseRecordId,
                        warehouseRecordList.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList())
                     )
               );
            Map<Long, Map<Long, Integer>> productIdWarehouseIdQuantityMap = warehouseStorageProductList.stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingWarehouseStorageProduct::getProductId,
                     Collectors.groupingBy(
                        MesBuildingWarehouseStorageProduct::getWarehouseId, Collectors.summingInt(MesBuildingWarehouseStorageProduct::getQuantity)
                     )
                  )
               );
            Map<Long, MesBuildingWarehouse> warehouseMap = this.mesBuildingWarehouseService
               .list()
               .stream()
               .collect(Collectors.toMap(MesBuildingWarehouse::getId, Function.identity()));
            Map<Long, MesBuildingWorkshop> workshopMap = this.mesBuildingWorkshopService
               .list()
               .stream()
               .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
            dtoList.forEach(dto -> {
               Map<Long, Integer> warehouseIdQuantityMap = productIdWarehouseIdQuantityMap.get(dto.getId());
               if (warehouseIdQuantityMap != null) {
                  List<Map<String, Object>> warehouseList = new ArrayList<>(16);
                  warehouseIdQuantityMap.forEach((warehouseId, quantity) -> {
                     MesBuildingWarehouse warehouse = warehouseMap.get(warehouseId);
                     MesBuildingWorkshop workshop = workshopMap.get(warehouse.getWorkshopId());
                     Map<String, Object> map = new LinkedHashMap<>();
                     map.put("workshop", NameInfo.builder().id(workshop.getId()).name(workshop.getName()).build());
                     map.put("warehouse", NameInfo.builder().id(warehouseId).name(warehouse.getName()).build());
                     map.put("stockQuantity", quantity);
                     warehouseList.add(map);
                  });
                  dto.setWarehouseList(warehouseList);
               }
            });
         }
      }
   }

   @Override
   public PageVO<ArtifactByCargoDTO> projectByAreaProductCargoPage(
      Long projectId, Long monomerId, Long areaId, String serialNumber, Integer type, Integer pageNumber, Integer pageSize
   ) {
      return PageUtil.listPage(pageNumber, pageSize, this.projectByAreaProductCargoList(projectId, monomerId, areaId, serialNumber, type));
   }

   @Override
   public List<ArtifactShipDO> listShipArtifactAndPartSend(Long id) {
      List<ArtifactShipDO> artifactShipDOS = this.cargoListProductLinkService.listArtifactAllById(id);
      if (CollectionUtils.isNotEmpty(artifactShipDOS)) {
         List<PartSendShipDO> partSendShipDOS = this.cargoListProductLinkService.listPartSendAllById(id);
         if (CollectionUtils.isNotEmpty(partSendShipDOS)) {
            Map<Long, List<PartSendShipDO>> listMap = partSendShipDOS.stream().collect(Collectors.groupingBy(PartSendShipDO::getArtifactId));
            artifactShipDOS.forEach(
               e -> {
                  List<PartSendShipDO> sendShipDOS = listMap.get(e.getCargoProductId());
                  if (CollectionUtils.isNotEmpty(sendShipDOS)) {
                     AtomicReference<BigDecimal> shipAmount = new AtomicReference<>(BigDecimal.ZERO);
                     AtomicReference<BigDecimal> totalShipAmount = new AtomicReference<>(BigDecimal.ZERO);
                     sendShipDOS.forEach(
                        part -> {
                           part.setUnitPrice(part.getUnitPrice() == null ? BigDecimal.ZERO : part.getUnitPrice());
                           if (PricingMannerEnum.WEIGHT.getType().equals(part.getPricingManner())) {
                              totalShipAmount.set(
                                 totalShipAmount.get()
                                    .add(
                                       part.getTotalWeight()
                                          .multiply(part.getUnitPrice())
                                          .divide(BigDecimal.valueOf(1000L))
                                          .multiply(e.getNetWeight())
                                          .divide(e.getWeight(), 4, RoundingMode.HALF_UP)
                                    )
                              );
                              shipAmount.set(
                                 shipAmount.get()
                                    .add(
                                       part.getWeight()
                                          .multiply(part.getUnitPrice())
                                          .divide(BigDecimal.valueOf(1000L))
                                          .multiply(e.getNetWeight())
                                          .divide(e.getWeight(), 4, RoundingMode.HALF_UP)
                                    )
                              );
                           }

                           if (PricingMannerEnum.LENGTH.getType().equals(part.getPricingManner())) {
                              totalShipAmount.set(
                                 totalShipAmount.get()
                                    .add(part.getTotalLength().multiply(part.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP))
                              );
                              shipAmount.set(
                                 shipAmount.get()
                                    .add(part.getLength().multiply(part.getUnitPrice()).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP))
                              );
                           }
                        }
                     );
                     e.setTotalPrice(totalShipAmount.get());
                     e.setUnitPrice(shipAmount.get());
                  }
               }
            );
         }
      }

      return artifactShipDOS;
   }

   @Override
   public Map<Long, BigDecimal> getProjectShipAmountMap(List<Long> projectIds) {
      Map<Long, BigDecimal> projectShipAmountMap = new HashMap<>(32);
      List<CargoListProductLinkDTO> productLinkDTOList = this.cargoListProductLinkService.listShipProductRecord(projectIds, null, null, null, null, null, null);
      List<Long> artifactIds = new ArrayList<>(1024);
      List<Long> assembleIds = new ArrayList<>(1024);
      List<Long> machinePartIds = new ArrayList<>(1024);
      List<Long> enclosureIds = new ArrayList<>(256);
      List<Long> standardIds = new ArrayList<>(128);
      productLinkDTOList.forEach(link -> {
         if (link.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            artifactIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            enclosureIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
            assembleIds.add(link.getProductId());
         } else if (link.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
            machinePartIds.add(link.getProductId());
         } else {
            standardIds.add(link.getProductId());
         }
      });
      Map<Long, TechArtifact> allArtifactMap = Collections.emptyMap();
      Map<Long, BusinessArtifact> businessArtifactMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(artifactIds)) {
         List<TechArtifact> allArtifactList = this.artifactService.listByIds(artifactIds);
         allArtifactMap = allArtifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         List<TechArtifact> artifactList = allArtifactList.stream().filter(a -> !a.getBoolAllPartSendDirectly()).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(artifactList)) {
            businessArtifactMap = this.businessArtifactService
               .listByIds(artifactList.stream().map(TechArtifact::getBusinessId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(BusinessArtifact::getId, Function.identity()));
         }
      }

      Map<Long, TechArtifact> finalAllArtifactMap = allArtifactMap;
      Map<Long, BusinessArtifact> finalBusinessArtifactMap = businessArtifactMap;
      Map<Long, TechEnclosure> enclosureMap = Collections.emptyMap();
      Map<Long, BusinessEnclosure> businessEnclosureMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(enclosureIds)) {
         List<TechEnclosure> enclosureList = this.enclosureService.listByIds(enclosureIds);
         enclosureMap = enclosureList.stream().collect(Collectors.toMap(TechEnclosure::getId, Function.identity()));
         List<BusinessEnclosure> businessEnclosureList = this.businessEnclosureService
            .listByIds(enclosureList.stream().map(TechEnclosure::getBusinessId).collect(Collectors.toSet()));
         businessEnclosureMap = businessEnclosureList.stream().collect(Collectors.toMap(BusinessEnclosure::getId, Function.identity()));
      }

      Map<Long, TechEnclosure> finalEnclosureMap = enclosureMap;
      Map<Long, BusinessEnclosure> finalBusinessEnclosureMap = businessEnclosureMap;
      Map<Long, TechStandardPart> standardPartMap = Collections.emptyMap();
      Map<Long, BusinessStandardPart> businessStandardPartMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(standardIds)) {
         List<TechStandardPart> standardPartList = this.techStandardPartService.listByIds(standardIds);
         standardPartMap = standardPartList.stream().collect(Collectors.toMap(TechStandardPart::getId, Function.identity()));
         List<BusinessStandardPart> businessStandardPartList = this.businessStandardPartService
            .listByIds(standardPartList.stream().map(TechStandardPart::getBusinessId).collect(Collectors.toSet()));
         businessStandardPartMap = businessStandardPartList.stream().collect(Collectors.toMap(BusinessStandardPart::getId, Function.identity()));
      }

      Map<Long, TechStandardPart> finalStandardPartMap = standardPartMap;
      Map<Long, BusinessStandardPart> finalBusinessStandardPartMap = businessStandardPartMap;
      Map<Long, TechAssemble> assembleMap = Collections.emptyMap();
      Map<Long, BusinessMachinePart> businessAssembleMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(assembleIds)) {
         List<TechAssemble> assemblesList = this.assembleService.listByIds(assembleIds);
         assembleMap = assemblesList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         List<BusinessMachinePart> businessEnclosureList = this.businessMachinePartService
            .listByIds(assemblesList.stream().map(TechAssemble::getBusinessId).collect(Collectors.toSet()));
         businessAssembleMap = businessEnclosureList.stream().collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
      }

      Map<Long, TechAssemble> finalAssMap = assembleMap;
      Map<Long, BusinessMachinePart> finalBusinessAssembleMap = businessAssembleMap;
      Map<Long, TechMachinePart> partMap = Collections.emptyMap();
      Map<Long, BusinessMachinePart> businessPartMap = Collections.emptyMap();
      if (CollectionUtils.isNotEmpty(machinePartIds)) {
         List<TechMachinePart> partList = this.machinePartService.listByIds(machinePartIds);
         partMap = partList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         List<BusinessMachinePart> businessEnclosureList = this.businessMachinePartService
            .listByIds(partList.stream().map(TechMachinePart::getBusinessId).collect(Collectors.toSet()));
         businessPartMap = businessEnclosureList.stream().collect(Collectors.toMap(BusinessMachinePart::getId, Function.identity()));
      }

      Map<Long, TechMachinePart> finalPartMap = partMap;
      Map<Long, BusinessMachinePart> finalBusinessPartMap = businessPartMap;
      Map<Long, List<CargoListProductLinkDTO>> projectProductLinkMap = productLinkDTOList.stream()
         .collect(Collectors.groupingBy(CargoListProductLinkDTO::getProjectId));
      projectProductLinkMap.forEach(
         (projectId, list) -> {
            List<BigDecimal> productAmountList = new ArrayList<>(128);
            list.forEach(
               product -> {
                  BigDecimal productAmount = BigDecimal.ZERO;
                  if (product.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                     TechArtifact artifact = finalAllArtifactMap.get(product.getProductId());
                     if (!artifact.getBoolAllPartSendDirectly()) {
                        BusinessArtifact businessArtifact = finalBusinessArtifactMap.get(artifact.getBusinessId());
                        if (businessArtifact.getUnitPrice() != null) {
                           productAmount = businessArtifact.getPricingManner()
                                 .equals(com.hzchum.scim.business.core.api.enums.PricingMannerEnum.WEIGHT.getType())
                              ? product.getWeight()
                                 .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                                 .multiply(businessArtifact.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
                              : artifact.getLength()
                                 .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                                 .multiply(businessArtifact.getUnitPrice())
                                 .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP);
                        }
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
                     TechEnclosure enclosure = finalEnclosureMap.get(product.getProductId());
                     BusinessEnclosure businessEnclosure = finalBusinessEnclosureMap.get(enclosure.getBusinessId());
                     if (businessEnclosure.getUnitPrice() != null) {
                        productAmount = businessEnclosure.getPricingManner().equals(EnclosurePricingMannerEnum.LENGTH.getType())
                           ? enclosure.getLength()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessEnclosure.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L))
                           : enclosure.getSurfaceArea()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessEnclosure.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000000L));
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.AUXILIARY_MATERIAL.getType())) {
                     TechStandardPart standardPart = finalStandardPartMap.get(product.getProductId());
                     BusinessStandardPart businessStandardPart = finalBusinessStandardPartMap.get(standardPart.getBusinessId());
                     if (businessStandardPart.getUnitPrice() == null || businessStandardPart.getUnitPrice().compareTo(BigDecimal.ZERO) == 0) {
                        productAmount = BigDecimal.ZERO;
                     }

                     if (!standardPart.getBoolWeightTypeEnum() || standardPart.getBoolWeightTypeEnum() && "千克".equals(businessStandardPart.getAccountingUnit())
                        )
                      {
                        productAmount = businessStandardPart.getUnitPrice() == null
                           ? BigDecimal.ZERO
                           : businessStandardPart.getUnitPrice().multiply(standardPart.getMete());
                     }

                     if (standardPart.getBoolWeightTypeEnum() && "吨".equals(businessStandardPart.getAccountingUnit())) {
                        productAmount = businessStandardPart.getUnitPrice() == null
                           ? BigDecimal.ZERO
                           : businessStandardPart.getUnitPrice().multiply(standardPart.getMete());
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                     TechAssemble assemble = finalAssMap.get(product.getProductId());
                     BusinessMachinePart businessAssemble = finalBusinessAssembleMap.get(assemble.getBusinessId());
                     if (businessAssemble != null && businessAssemble.getUnitPrice() != null) {
                        productAmount = businessAssemble.getPricingManner().equals(PricingMannerEnum.LENGTH.getType())
                           ? assemble.getLength()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessAssemble.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L))
                           : assemble.getNetWeight()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessAssemble.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L));
                     }
                  }

                  if (product.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
                     TechMachinePart part = finalPartMap.get(product.getProductId());
                     BusinessMachinePart businessPart = finalBusinessPartMap.get(part.getBusinessId());
                     if (businessPart != null && businessPart.getUnitPrice() != null) {
                        productAmount = businessPart.getPricingManner().equals(PricingMannerEnum.LENGTH.getType())
                           ? part.getLength()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessPart.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L))
                           : part.getNetWeight()
                              .multiply(BigDecimal.valueOf(product.getQuantity().intValue()))
                              .multiply(businessPart.getUnitPrice())
                              .divide(BigDecimal.valueOf(1000L));
                     }
                  }

                  productAmountList.add(productAmount);
               }
            );
            BigDecimal projectShipAmount = productAmountList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            projectShipAmountMap.put(projectId, projectShipAmount);
         }
      );
      return projectShipAmountMap;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateConcertCargoList(CargoListUpdateConcertDTOParam param) {
      MesBuildingCargoList cargoList = this.cargoListService.getById(param.getId());
      Preconditions.checkArgument(cargoList != null, "发运记录不存在!!!");
      Preconditions.checkArgument(
         CargoListStatusEnum.LOADING_NO.getType().equals(cargoList.getStatus()) || CargoListStatusEnum.LOADING.getType().equals(cargoList.getStatus()),
         "只可修改未过磅前的发运记录!"
      );
      Preconditions.checkArgument(param.getPackDTOParam() != null || param.getProductDTOParam() != null, "修改失败，未传入包id或产品id");
      Preconditions.checkArgument(param.getPackDTOParam() == null || param.getProductDTOParam() == null, "修改失败，包id和产品id不可同时保存!");
      ContractProject project = this.contractProjectService.checkProjectStatus(param.getProjectId());
      this.projectUserLinkService.checkProjectUser(param.getProjectId());
      BeanUtil.copy(param, cargoList);
      this.updateCargoList(cargoList, project);
      if (param.getPackDTOParam() != null) {
         CargoListPackConcertDTOParam packDTOParam = param.getPackDTOParam();
         List<MesBuildingCargoListProductLink> deleteLink = this.cargoListProductLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductLink>()
                        .eq(MesBuildingCargoListProductLink::getCargoListId, param.getId()))
                     .eq(MesBuildingCargoListProductLink::getPackageId, packDTOParam.getPackageId()))
                  .eq(MesBuildingCargoListProductLink::getBoolCancelShip, Boolean.FALSE)
            );
         if (packDTOParam.getQuantity() == -1) {
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(deleteLink), "删除失败,该包未装车!");
            this.remove(deleteLink, cargoList.getId());
         }

         if (packDTOParam.getQuantity() == 1) {
            Preconditions.checkArgument(CollectionUtils.isEmpty(deleteLink), "新增失败,该包已装车!");
            this.savePack(Collections.singleton(packDTOParam.getPackageId()), cargoList.getId(), param.getProjectId());
         }
      }

      if (param.getProductDTOParam() != null) {
         CargoListProductConcertDTOParam productDTOParam = param.getProductDTOParam();
         MesBuildingWarehouseSummary warehouseSummary = this.warehouseSummaryService.getById(productDTOParam.getId());
         Preconditions.checkArgument(warehouseSummary != null && warehouseSummary.getType().equals(1), "操作失败,入库记录不存在!");
         MesBuildingCargoListProductLink cargoListProductLink = this.cargoListProductLinkService
            .getOne(
               (Wrapper<MesBuildingCargoListProductLink>)(((new LambdaQueryWrapper<MesBuildingCargoListProductLink>()
                           .eq(MesBuildingCargoListProductLink::getWarehouseRecordId, productDTOParam.getId()))
                        .eq(MesBuildingCargoListProductLink::getCargoListId, param.getId()))
                     .eq(MesBuildingCargoListProductLink::getBoolCancelShip, Boolean.FALSE))
                  .isNull(MesBuildingCargoListProductLink::getPackageId)
            );
         if (productDTOParam.getQuantity().compareTo(BigDecimal.ZERO) < 0) {
            Preconditions.checkArgument(cargoListProductLink != null, "删除失败,该产品装车信息不存在!");
            cargoListProductLink.setQuantity(cargoListProductLink.getQuantity().add(productDTOParam.getQuantity()));
            Preconditions.checkArgument(cargoListProductLink.getQuantity().compareTo(BigDecimal.ZERO) >= 0, "操作失败,更新后该产品装车记录不可为负数!");
            this.warehouseSummaryService.updateQuantity(productDTOParam.getId(), productDTOParam.getQuantity(), null, 2);
            if (CollectionUtils.isNotEmpty(productDTOParam.getNumberList())) {
               Preconditions.checkArgument(productDTOParam.getNumberList().size() == productDTOParam.getQuantity().abs().intValue(), "操作失败,码号列表和数量不一致!");
               List<MesBuildingCargoListProductNumberLink> numberLinkList = this.cargoListProductNumberLinkService
                  .list(
                     (Wrapper<MesBuildingCargoListProductNumberLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                              .eq(MesBuildingCargoListProductNumberLink::getCargoListLinkId, cargoListProductLink.getId()))
                           .in(MesBuildingCargoListProductNumberLink::getNumber, productDTOParam.getNumberList()))
                        .in(MesBuildingCargoListProductNumberLink::getProductType, ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.ARTIFACT.getType())
                  );
               if (CollectionUtils.isNotEmpty(numberLinkList)) {
                  for (MesBuildingCargoListProductNumberLink numberLink : numberLinkList) {
                     this.cargoListProductNumberLinkService.removeById(numberLink.getId());
                     this.warehouseRecordService
                        .update(
                           (Wrapper<MesBuildingWarehouseRecord>)(((((Wrappers.<MesBuildingWarehouseRecord>lambdaUpdate()
                                             .eq(MesBuildingWarehouseRecord::getProductType, numberLink.getProductType()))
                                          .eq(MesBuildingWarehouseRecord::getProductId, numberLink.getProductId()))
                                       .eq(MesBuildingWarehouseRecord::getNumber, numberLink.getNumber()))
                                    .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType()))
                                 .eq(MesBuildingWarehouseRecord::getWarehouseType, cargoListProductLink.getWarehouseType()))
                              .set(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
                        );
                  }

                  this.cargoListProductNumberLinkService
                     .removeByIds(numberLinkList.stream().map(MesBuildingCargoListProductNumberLink::getId).collect(Collectors.toList()));
               }
            }

            if (CollectionUtils.isEmpty(productDTOParam.getNumberList())) {
               List<MesBuildingCargoListProductNumberLink> numberLinkList = this.cargoListProductNumberLinkService
                  .list(
                     (Wrapper<MesBuildingCargoListProductNumberLink>)(new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                           .eq(MesBuildingCargoListProductNumberLink::getCargoListLinkId, cargoListProductLink.getId()))
                        .in(MesBuildingCargoListProductNumberLink::getProductType, ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.ARTIFACT.getType())
                  );
               if (CollectionUtils.isNotEmpty(numberLinkList)) {
                  Preconditions.checkArgument(numberLinkList.size() >= productDTOParam.getQuantity().abs().intValue(), "操作失败,产品剩余可操作码号与数量不一致!");
                  List<MesBuildingCargoListProductNumberLink> removeCargoListProductNumberLink = numberLinkList.stream()
                     .limit(productDTOParam.getQuantity().abs().longValue())
                     .collect(Collectors.toList());

                  for (MesBuildingCargoListProductNumberLink numberLink : removeCargoListProductNumberLink) {
                     this.cargoListProductNumberLinkService.removeById(numberLink.getId());
                     this.warehouseRecordService
                        .update(
                           (Wrapper<MesBuildingWarehouseRecord>)(((((Wrappers.<MesBuildingWarehouseRecord>lambdaUpdate()
                                             .eq(MesBuildingWarehouseRecord::getProductType, numberLink.getProductType()))
                                          .eq(MesBuildingWarehouseRecord::getProductId, numberLink.getProductId()))
                                       .eq(MesBuildingWarehouseRecord::getNumber, numberLink.getNumber()))
                                    .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType()))
                                 .eq(MesBuildingWarehouseRecord::getWarehouseType, cargoListProductLink.getWarehouseType()))
                              .set(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.INTO.getType())
                        );
                  }

                  this.cargoListProductNumberLinkService
                     .removeByIds(removeCargoListProductNumberLink.stream().map(MesBuildingCargoListProductNumberLink::getId).collect(Collectors.toList()));
               }
            }

            this.cargoListProductLinkService.updateById(cargoListProductLink);
            if (cargoListProductLink.getQuantity().compareTo(BigDecimal.ZERO) == 0) {
               this.cargoListProductLinkService.removeById(cargoListProductLink);
            }
         }

         if (productDTOParam.getQuantity().compareTo(BigDecimal.ZERO) > 0) {
            if (cargoListProductLink == null) {
               CargoListProductDTOParam dtoParam = BeanUtil.copy(productDTOParam, CargoListProductDTOParam.class);
               this.saveProduct(Collections.singletonList(dtoParam), cargoList.getId(), param.getProjectId());
            }

            if (cargoListProductLink != null) {
               List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService.listByIds(Collections.singletonList(productDTOParam.getId()));
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(summaryList) && summaryList.size() == 1, "入库记录不存在!!!");
               Preconditions.checkArgument(summaryList.stream().allMatch(e -> WarehouseTypeEnum.INTO.getType().equals(e.getType())), "入库记录不存在");
               Map<Integer, List<MesBuildingWarehouseSummary>> productTypeSummaryMap = summaryList.stream()
                  .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProductType));
               CargoListProductDTOParam dtoParam = BeanUtil.copy(productDTOParam, CargoListProductDTOParam.class);
               List<CargoListProductDTOParam> cargoListProductDTOParams = this.mesBuildingCalcMaxNumManager
                  .checkPackNumberAndBuild(Arrays.asList(dtoParam), productTypeSummaryMap);
               Preconditions.checkArgument(CollectionUtils.isNotEmpty(cargoListProductDTOParams) && cargoListProductDTOParams.size() == 1, "操作失败,数据异常!");
               CargoListProductDTOParam product = cargoListProductDTOParams.get(0);
               List<MesBuildingCargoListProductNumberLink> numberLinkList = this.cargoListProductNumberLinkService
                  .list(
                     (Wrapper<MesBuildingCargoListProductNumberLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                              .eq(MesBuildingCargoListProductNumberLink::getCargoListLinkId, cargoListProductLink.getId()))
                           .in(MesBuildingCargoListProductNumberLink::getNumber, product.getNumberList()))
                        .in(MesBuildingCargoListProductNumberLink::getProductType, ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.ARTIFACT.getType())
                  );
               Preconditions.checkArgument(CollectionUtils.isEmpty(numberLinkList), "操作失败,新增的产品码号已装车!");
               if (ProductTypeEnum.ARTIFACT.getType().equals(cargoListProductLink.getProductType())
                  || ProductTypeEnum.ASSEMBLE.getType().equals(cargoListProductLink.getProductType())) {
                  product.getNumberList()
                     .forEach(
                        number -> {
                           this.cargoListProductNumberLinkService
                              .save(
                                 MesBuildingCargoListProductNumberLink.builder()
                                    .cargoListId(cargoList.getId())
                                    .cargoListLinkId(cargoListProductLink.getId())
                                    .productId(cargoListProductLink.getProductId())
                                    .productType(cargoListProductLink.getProductType())
                                    .number(number)
                                    .userName(UserUtil.getCurrentName())
                                    .build()
                              );
                           this.warehouseRecordService
                              .update(
                                 (Wrapper<MesBuildingWarehouseRecord>)(((((Wrappers.<MesBuildingWarehouseRecord>lambdaUpdate()
                                                   .eq(MesBuildingWarehouseRecord::getProductType, cargoListProductLink.getProductType()))
                                                .eq(MesBuildingWarehouseRecord::getProductId, cargoListProductLink.getProductId()))
                                             .eq(MesBuildingWarehouseRecord::getNumber, number))
                                          .eq(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType()))
                                       .eq(MesBuildingWarehouseRecord::getWarehouseType, cargoListProductLink.getWarehouseType()))
                                    .set(MesBuildingWarehouseRecord::getStatus, WarehouseRecordStatusTypeEnum.CARGOLIST.getType())
                              );
                        }
                     );
               }

               cargoListProductLink.setQuantity(cargoListProductLink.getQuantity().add(product.getQuantity()));
               this.warehouseSummaryService.updateQuantity(product.getId(), product.getQuantity(), cargoListProductLink.getProductType(), 2);
               this.cargoListProductLinkService.updateById(cargoListProductLink);
            }

            this.mesBuildingCalcMaxNumManager.calculateMaximumCars(Collections.singletonList(BeanUtil.copy(productDTOParam, MesBuildingCalcuDTOParam.class)));
         }
      }

      ProductSumInfoDTO info = this.mesProductBiz.getInfoByCargoListId(cargoList.getId());
      Integer reduce = info.getProductType();
      if ((reduce & ProductTypeEnum.ENCLOSURE.getType()) > 0 && (reduce & ProductTypeEnum.ARTIFACT.getType()) > 0) {
         Preconditions.checkArgument(
            cargoList.getTransportMode() != null
               && cargoList.getEnclosureTransportMode() != null
               && cargoList.getEnclosureTransportMode().equals(cargoList.getTransportMode()),
            "装车失败,围护和构件同时存在时，运输方式需一致!!!"
         );
      }

      cargoList.setProductType(reduce);
      cargoList.setRelationType(info.getRelationType());
      cargoList.setCategory(info.getCategory());
      cargoList.setQuantity(info.getQuantity());
      cargoList.setTotalNetWeight(info.getTotalNetWeight());
      cargoList.setTotalGrossWeight(info.getTotalGrossWeight());
      this.cargoListService.updateById(cargoList);
      return true;
   }

   @Override
   public Map<String, Number> projectCargoListAuxiliaryDetailSum(Long projectId, Long monomerId, Long areaId, Integer relationType, Integer projectStatus) {
      int totalQuantity = 0;
      BigDecimal totalMete = BigDecimal.ZERO;
      Map<String, Number> map = new HashMap<>();
      List<ProjectCargoListAuxiliaryDetailDTO> auxiliaryDetailDTOS = this.projectCargoListAuxiliaryDetail(
         projectId, monomerId, areaId, null, null, null, relationType, projectStatus
      );
      if (CollectionUtils.isNotEmpty(auxiliaryDetailDTOS)) {
         totalQuantity = auxiliaryDetailDTOS.stream().mapToInt(ProjectCargoListAuxiliaryDetailDTO::getQuantity).sum();
         List<ProjectCargoListAuxiliaryDetailDTO> auxiliaryDetailDTOList = auxiliaryDetailDTOS.stream()
            .filter(ProjectCargoListAuxiliaryDetailDTO::getBoolWeightTypeEnum)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(auxiliaryDetailDTOS)) {
            totalMete = auxiliaryDetailDTOList.stream()
               .map(e -> e.getAccountingUnit().equals("吨") ? e.getMete().multiply(BigDecimal.valueOf(1000L)) : e.getMete())
               .reduce(BigDecimal.ZERO, BigDecimal::add);
         }
      }

      map.put("totalQuantity", totalQuantity);
      map.put("totalMete", totalMete);
      return map;
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
