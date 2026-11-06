package com.hzchum.scim.mes.building.core.service.impl.cargoList;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.vo.BimLogisticsVO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.WeighingScaleEquipmentInfo;
import com.hzchum.scim.iot.core.api.service.equiment.WeighingScaleEquipmentInfoService;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.MeansConveyanceEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.CargoListDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ProjectCargoListEnclosureMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ProjectCargoListMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ShipQuantityGroupByDateDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.YearCargoListMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.CarModleKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.CargoListKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProjectCargoListKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.cargoList.CargoListDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.CargoRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.AppEmptyCarsWeighingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoDayOrMonthSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListArtifactTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListDriverDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListEnclosureTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListMaterialDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListMeteGroupMonthDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoWeightDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListAuxiliaryDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListEnclosureDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListMeteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListSumDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.ProjectCargoListSumEnclosureDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingWeeklyProductionReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListRecordDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListStatisticsQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.AppEmptyCarsWeighingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.carGoDetail.RecentlyDespatchVO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.mapper.cargoList.MesBuildingCargoListMapper;
import com.qiniu.util.Base64;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesBuildingCargoListServiceImpl extends ServiceImpl<MesBuildingCargoListMapper, MesBuildingCargoList> implements MesBuildingCargoListService {
   @Value("${cargo.connectionRequestTimeout}")
   Integer connectionRequestTimeout;
   @Value("${cargo.connectTimeout}")
   Integer connectTimeout;
   @Value("${cargo.readTimeout}")
   Integer readTimeout;
   @Resource
   private ContractProjectService projectService;
   @Value("${cargo.device_id}")
   Long deviceId;
   @Value("${cargo.ip}")
   String ip;
   @Value("${cargo.weight}")
   String weightUrl;
   @Resource
   private WeighingScaleEquipmentInfoService scaleEquipmentInfoService;
   public static final String secretKey = System.getenv("LJAPS_WEIGHING_SECRET_KEY");

   @Override
   public PageVO<CargoListDO> pageByCondition(CargoListDOParam param) {
      String order = null;
      if (CollectionUtils.isNotEmpty(param.getSort())) {
         String orderBy = StringUtils.analyzeSortConditions(param.getSort());
         order = "c." + orderBy;
      }

      List<Long> projectIds = this.projectService
         .listSimpleProject(param.getProjectType(), null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new PageVO<>();
      }

      param.setProjectIds(projectIds);
      PageHelper.startPage(param.getPageNumber(), param.getPageSize(), order);
      return new PageVO<>(this.baseMapper.listByCondition(param));
   }

   @Override
   public List<CargoListDO> listByCondition(CargoListDOParam param) {
      return this.baseMapper.listByCondition(param);
   }

   @Override
   public Integer countShipByProjectId(Long projectId) {
      return this.baseMapper.countShipByProjectId(projectId);
   }

   @Override
   public List<String> countShipByProjectIdV2(Long projectId) {
      return this.baseMapper.countShipByProjectIdV2(projectId);
   }

   @Override
   public void checkIsLoad(Long projectId, Boolean isModifyTransportMode, Boolean isModifyStructureMeasureMode, List<Integer> categoryList) {
      List<MesBuildingCargoList> cargoLists = this.baseMapper
         .selectList((Wrapper<MesBuildingCargoList>)Wrappers.<MesBuildingCargoList>lambdaQuery().eq(MesBuildingCargoList::getProjectId, projectId));
      if (isModifyTransportMode) {
         Preconditions.checkArgument(CollectionUtils.isEmpty(cargoLists), "项目存在发运，无法修改运输方式");
      }

      if (isModifyStructureMeasureMode) {
         Preconditions.checkArgument(
            CollectionUtils.isEmpty(cargoLists) || cargoLists.stream().allMatch(e -> (e.getProductType() & ProductTypeEnum.ARTIFACT.getType()) == 0),
            "构件已发货，无法修改构件计量方式"
         );
      }

      Preconditions.checkArgument(
         CollectionUtils.isEmpty(cargoLists)
            || CollectionUtils.isEmpty(categoryList)
            || cargoLists.stream().noneMatch(e -> categoryList.contains(e.getCategory())),
         "围护已发货，无法修改围护计量方式"
      );
   }

   @Override
   public List<ShipQuantityGroupByDateDO> sumShipmentQuantityGroupByDate(Long projectId, String month) {
      return this.baseMapper.sumShipmentQuantityGroupByDate(projectId, month);
   }

   @Override
   public List<MesBuildingCargoList> countByStatus(int status) {
      return this.baseMapper.selectList((Wrapper<MesBuildingCargoList>)Wrappers.<MesBuildingCargoList>lambdaQuery().eq(MesBuildingCargoList::getStatus, status));
   }

   @Override
   public List<ProjectCargoListDTO> getLogisticsFees(Long supplierId, Long branchCompanyId) {
      return this.baseMapper.selectCargoFeeList(supplierId, branchCompanyId);
   }

   @Override
   public BigDecimal getShipFeeSum(Long supplierId, Long projectId, LocalDate startDate, LocalDate endDate) {
      return this.baseMapper.selectFeeSum(supplierId, projectId, startDate, endDate);
   }

   @Override
   public List<BimLogisticsVO> getArtifactLogisticsByBim(Long projectId, Long monomerId, List<Long> areaIds, Integer productType, Integer status) {
      return this.baseMapper.getArtifactLogisticsByBim(projectId, monomerId, areaIds, productType, status);
   }

   @Override
   public List<CargoListKpiDO> cargoListGroupByMonth(LocalDateTime dateTime) {
      return this.baseMapper.cargoListGroupByMonth(dateTime);
   }

   @Override
   public BigDecimal cargoListAmountByYear(LocalDateTime dateTime, Integer productType) {
      return this.baseMapper.cargoListAmountByYear(dateTime, productType);
   }

   @Override
   public BigDecimal cargoListAmountByDay(LocalDateTime dateTime, Integer productType) {
      return this.baseMapper.cargoListAmountByDay(dateTime, productType);
   }

   @Override
   public Integer cargoListQuantityByDay(LocalDateTime dateTime, Integer productType) {
      return this.baseMapper.cargoListQuantityByDay(dateTime, productType);
   }

   @Override
   public BigDecimal stockByDay(LocalDateTime dateTime, Integer productType) {
      return this.baseMapper.stockByDay(dateTime, productType);
   }

   @Override
   public List<CargoListKpiDO> cargoListAmountGroupByMonth(LocalDateTime dateTime) {
      return this.baseMapper.cargoListAmountGroupByMonth(dateTime);
   }

   @Override
   public List<CarModleKpiDO> carModelByYear(LocalDateTime dateTime) {
      return this.baseMapper.carModelByYear(dateTime);
   }

   @Override
   public List<ProjectCargoListKpiDO> projectCargoListByYear(LocalDateTime dateTime) {
      return this.baseMapper.projectCargoListByYear(dateTime);
   }

   @Override
   public List<ProjectCargoListKpiDO> projectCargoListByDay(LocalDateTime dateTime) {
      return this.baseMapper.projectCargoListByDay(dateTime);
   }

   @Override
   public List<MesBuildingCargoList> listCargoRecord(CargoListRecordDTOParam param) {
      return this.baseMapper.selectCargoListRecord(param);
   }

   @Override
   public Boolean saveEmptyCargoList(AppEmptyCarsWeighingDTOParam param) {
      if (param.getMeansConveyanceEnum() == null) {
         param.setMeansConveyanceEnum(MeansConveyanceEnum.CAR.getType());
      }

      if (param.getMeansConveyanceEnum().equals(MeansConveyanceEnum.CAR.getType())) {
         Preconditions.checkArgument(param.getEmptyCars() != null, "操作失败，运输工具为车时，空车重量不可为空！");
      }

      List<MesBuildingCargoList> cargoLists = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingCargoList>)((new LambdaQueryWrapper<MesBuildingCargoList>()
                     .eq(MesBuildingCargoList::getLicensePlate, param.getLicensePlate()))
                  .ne(MesBuildingCargoList::getStatus, CargoListStatusEnum.RECEIPT.getType()))
               .ne(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(cargoLists), "该车牌/船号已存在!");
      MesBuildingCargoList cargoList = BeanUtil.copy(param, MesBuildingCargoList.class);
      cargoList.setStatus(CargoListStatusEnum.LOADING_NO.getType());
      this.baseMapper.insert(cargoList);
      return Boolean.TRUE;
   }

   @Override
   public Boolean updateEmptyCargoList(AppEmptyCarsWeighingDTOParam param) {
      MesBuildingCargoList cargoList = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(cargoList.getStatus().equals(CargoListStatusEnum.LOADING_NO.getType()), "修改失败,已装车!!!");
      if (param.getMeansConveyanceEnum() == null) {
         param.setMeansConveyanceEnum(MeansConveyanceEnum.CAR.getType());
      }

      Preconditions.checkArgument(cargoList.getMeansConveyanceEnum().equals(param.getMeansConveyanceEnum()), "操作失败,运输工具类型不可修改!");
      if (param.getMeansConveyanceEnum().equals(MeansConveyanceEnum.CAR.getType())) {
         Preconditions.checkArgument(param.getEmptyCars() != null, "操作失败，运输工具为车时，空车重量不可为空！");
      }

      if (!cargoList.getLicensePlate().equals(param.getLicensePlate())) {
         List<MesBuildingCargoList> cargoLists = this.baseMapper
            .selectList(
               (Wrapper<MesBuildingCargoList>)(((new LambdaQueryWrapper<MesBuildingCargoList>()
                           .eq(MesBuildingCargoList::getLicensePlate, param.getLicensePlate()))
                        .ne(MesBuildingCargoList::getStatus, CargoListStatusEnum.RECEIPT.getType()))
                     .ne(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType()))
                  .ne(MesBuildingCargoList::getId, cargoList.getId())
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(cargoLists), "该车牌已存在!!!");
      }

      BeanUtil.copy(param, cargoList);
      this.baseMapper.updateById(cargoList);
      return Boolean.TRUE;
   }

   @Override
   public ListVO<AppEmptyCarsWeighingDTO> getEmptyCargoList() {
      List<MesBuildingCargoList> cargoLists = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingCargoList>)(new LambdaQueryWrapper<MesBuildingCargoList>()
                  .eq(MesBuildingCargoList::getStatus, CargoListStatusEnum.LOADING_NO.getType()))
               .orderByDesc(BaseEntity::getCreateTime)
         );
      return new ListVO<>(cargoLists.stream().map(cargo -> {
         AppEmptyCarsWeighingDTO copy = BeanUtil.copy(cargo, AppEmptyCarsWeighingDTO.class);
         copy.setVersion(cargo.getVersion());
         return copy;
      }).collect(Collectors.toList()));
   }

   @Override
   public List<ProjectCargoListMeteDO> projectCargoListMeteSummary(
      LocalDateTime dateTime,
      Integer sendStatus,
      Boolean settled,
      Long workshopId,
      Integer productionLineTypeEnum,
      List<Long> projectIds,
      Integer type,
      String projectName,
      Integer projectStatus
   ) {
      return this.baseMapper
         .projectCargoListMeteSummary(dateTime, sendStatus, settled, workshopId, productionLineTypeEnum, projectIds, type, projectName, projectStatus);
   }

   @Override
   public List<ProjectCargoListMeteDO> projectCargoListMeteSummaryV2(CargoListStatisticsQueryParam param) {
      return this.baseMapper.projectCargoListMeteSummaryV2(param);
   }

   @Override
   public List<ProjectCargoListEnclosureMeteDO> projectCargoListEnclosureProjectSummary(
      LocalDateTime dateTime,
      Integer sendStatus,
      Boolean settled,
      Long workshopId,
      List<Long> projectIds,
      Integer type,
      String projectName,
      Integer projectStatus
   ) {
      return this.baseMapper.projectCargoListEnclosureProjectSummary(dateTime, sendStatus, settled, workshopId, projectIds, type, projectName, projectStatus);
   }

   @Override
   public List<ProjectCargoListEnclosureMeteDO> projectCargoListEnclosureProjectSummaryV2(CargoListStatisticsQueryParam param) {
      return this.baseMapper.projectCargoListEnclosureProjectSummaryV2(param);
   }

   @Override
   public ProjectCargoListSumDetailDTO projectDetailSummary(
      Long projectId, Long monomerId, Long areaId, Long workshopId, LocalDateTime dateTime, LocalDateTime dateMounthTime
   ) {
      return this.baseMapper.projectDetailSummary(projectId, monomerId, areaId, workshopId, dateTime, dateMounthTime);
   }

   @Override
   public ProjectCargoListSumDetailDTO directShipmentProjectDetailSummary(
      Long projectId, Long monomerId, Long areaId, Long workshopId, LocalDateTime dateTime, LocalDateTime dateMounthTime, List<Integer> productTypeList
   ) {
      return this.baseMapper.directShipmentProjectDetailSummary(projectId, monomerId, areaId, workshopId, dateTime, dateMounthTime, productTypeList);
   }

   @Override
   public ProjectCargoListSumEnclosureDetailDTO projectEnclosureDetailSummary(
      Long projectId, Integer category, Long enclosurePlanId, Long workshopId, LocalDateTime dateTime, LocalDateTime dateMounthTime
   ) {
      return this.baseMapper.projectEnclosureDetailSummary(projectId, category, enclosurePlanId, workshopId, dateTime, dateMounthTime);
   }

   @Override
   public YearCargoListMeteDO getYearCargoListMeteSummary(
      LocalDateTime dateTime, Long workshopId, Integer productionLineTypeEnum, List<Long> projectIds, Integer projectStatus
   ) {
      return this.baseMapper.getYearCargoListMeteSummary(dateTime, workshopId, productionLineTypeEnum, projectIds, projectStatus);
   }

   @Override
   public YearCargoListMeteDO getYearCargoListEnclosureMeteSummary(LocalDateTime dateTime, Long workshopId, List<Long> projectIds, Integer projectStatus) {
      return this.baseMapper.getYearCargoListEnclosureMeteSummary(dateTime, workshopId, projectIds, projectStatus);
   }

   @Override
   public Integer getYearCargoListNumberSummary(
      LocalDateTime dateTime,
      Long workshopId,
      Integer productionLineTypeEnum,
      List<Long> projectIds,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer projectStatus
   ) {
      return this.baseMapper
         .getYearCargoListNumberSummary(dateTime, workshopId, productionLineTypeEnum, projectIds, projectId, startDate, endDate, projectStatus);
   }

   @Override
   public Integer getYearCargoListEnclosureNumberSummary(
      LocalDateTime dateTime, Long workshopId, List<Long> projectIds, Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer projectStatus
   ) {
      return this.baseMapper.getYearCargoListEnclosureNumberSummary(dateTime, workshopId, projectIds, projectId, startDate, endDate, projectStatus);
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
      return this.baseMapper.projectCargoListMeteDetail(projectId, monomerId, areaId, workshopId, serialNumber, productionLineTypeEnum, startDate, endDate);
   }

   @Override
   public List<ProjectCargoListMeteDetailDTO> directShipmentProjectCargoListMeteDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      String serialNumber,
      Integer productionLineTypeEnum,
      List<Integer> productTypeList,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      return this.baseMapper
         .directShipProjectCargoListMeteDetail(
            projectId, monomerId, areaId, workshopId, serialNumber, productionLineTypeEnum, productTypeList, startDate, endDate
         );
   }

   @Override
   public List<ProjectCargoListEnclosureDetailDTO> projectCargoListEnclosureDetail(
      Long projectId, Integer category, Long enclosurePlanId, Long workshopId, String serialNumber
   ) {
      return this.baseMapper.projectCargoListEnclosureDetail(projectId, category, enclosurePlanId, workshopId, serialNumber);
   }

   @Override
   public List<ProjectCargoListAuxiliaryDetailDTO> projectCargoListAuxiliaryDetail(
      Long projectId, Long monomerId, Long areaId, Integer category, Long enclosurePlanId, String serialNumber, Integer relationType, Integer projectStatus
   ) {
      return this.baseMapper.projectCargoListAuxiliaryDetailV2(projectId, monomerId, areaId, category, enclosurePlanId, serialNumber, relationType);
   }

   @Override
   public BigDecimal cargoListMeteSumQuantity(
      LocalDateTime dateTime, Long projectId, Integer type, List<Long> projectIds, LocalDateTime auditStartDate, LocalDateTime auditEndDate
   ) {
      return this.baseMapper.cargoListMeteSumQuantity(dateTime, projectId, type, projectIds, auditStartDate, auditEndDate);
   }

   @Override
   public BigDecimal cargoListMeteSumMete(
      LocalDateTime dateTime, Long projectId, Integer type, List<Long> projectIds, LocalDateTime auditStartDate, LocalDateTime auditEndDate
   ) {
      return this.baseMapper.cargoListMeteSumMete(dateTime, projectId, type, projectIds, auditStartDate, auditEndDate);
   }

   @Override
   public List<ProjectCargoListMeteDTO> getYearCargoListQuantity(LocalDateTime dateTime, Long projectId) {
      return this.baseMapper.getYearCargoListQuantity(dateTime, projectId);
   }

   @Override
   public List<CargoListMeteGroupMonthDTO> getCargoListGroupMonth(LocalDateTime dateTime) {
      return this.baseMapper.getCargoListGroupMonth(dateTime);
   }

   @Override
   public List<CargoListArtifactTypeDTO> projectDetailType(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      LocalDateTime dateMounthTime,
      Integer shipEnumType
   ) {
      return this.baseMapper
         .getCargoDetailByshipEnumType(projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, dateMounthTime, shipEnumType);
   }

   @Override
   public List<CargoListArtifactTypeDTO> directShipmentProjectDetailType(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      LocalDateTime dateTime,
      LocalDateTime dateMounthTime,
      Integer shipEnumType,
      List<Integer> productTypeList
   ) {
      return this.baseMapper
         .getDirectShipmentCargoDetailByshipEnumType(projectId, monomerId, areaId, workshopId, dateTime, dateMounthTime, shipEnumType, productTypeList);
   }

   @Override
   public List<CargoListArtifactTypeDTO> directShipmentProjectDetailTypeV2(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      LocalDateTime dateMounthTime,
      Integer shipEnumType
   ) {
      return this.baseMapper
         .getDirectShipmentCargoDetailByShipEnumTypeV2(
            projectId, monomerId, areaId, serialNumber, productSourceType, workshopId, dateTime, dateMounthTime, shipEnumType
         );
   }

   @Override
   public List<CargoListEnclosureTypeDTO> projectEnclosureDetailType(
      Long projectId,
      Integer category,
      Long enclosurePlanId,
      String serialNumber,
      Integer productSourceType,
      Long workshopId,
      LocalDateTime dateTime,
      LocalDateTime dateMounthTime,
      Integer shipEnumType
   ) {
      return this.baseMapper
         .getCargoEnclosureDetailByshipEnumType(
            projectId, category, enclosurePlanId, serialNumber, productSourceType, workshopId, dateTime, dateMounthTime, shipEnumType
         );
   }

   @Override
   public ListVO<CargoListDriverDTO> getDriverCargoList(String licensePlate) {
      return new ListVO<>(this.baseMapper.getDriverCargoList(licensePlate));
   }

   @Override
   public List<String> carGoDetailWait() {
      return this.list((Wrapper<MesBuildingCargoList>)new LambdaQueryWrapper<MesBuildingCargoList>().eq(MesBuildingCargoList::getStatus, CargoListStatusEnum.LOADING_NO.getType()))
         .stream()
         .map(MesBuildingCargoList::getLicensePlate)
         .collect(Collectors.toList());
   }

   @Override
   public List<RecentlyDespatchVO> carGoDetailRecentlyDespatch(Integer size) {
      if (Objects.isNull(size)) {
         size = 20;
      }

      List<RecentlyDespatchVO> list = new ArrayList<>();
      List<Integer> statusVal = new ArrayList<>();
      statusVal.add(CargoListStatusEnum.SHIPMENT.getType());
      statusVal.add(CargoListStatusEnum.RECEIPT.getType());
      this.list(
            (Wrapper<MesBuildingCargoList>)((new LambdaQueryWrapper<MesBuildingCargoList>().in(MesBuildingCargoList::getStatus, statusVal))
                  .orderByDesc(MesBuildingCargoList::getAuditTime))
               .last("limit " + size)
         )
         .forEach(e -> list.add(cn.hutool.core.bean.BeanUtil.copyProperties(e, RecentlyDespatchVO.class)));
      return list;
   }

   @Override
   public Integer carGoDetailRecentlyCarCount() {
      return this.count(
         (Wrapper<MesBuildingCargoList>)(new LambdaQueryWrapper<MesBuildingCargoList>()
               .eq(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType()))
            .apply("date_format(actual_time,'%Y-%m-%d') = date_format(now(),'%Y-%m-%d')")
      );
   }

   @Override
   public BigDecimal getShipMete(Long monomerId, Long areaId) {
      return this.baseMapper.selectShipMete(monomerId, areaId);
   }

   @Override
   public BigDecimal getEnclosureShipMete(Long monomerId, Long areaId) {
      return this.baseMapper.selectEnclosureShipMete(monomerId, areaId);
   }

   @Override
   public CargoListMaterialDTO materialInput(Long deviceId) {
      CargoListMaterialDTO build = CargoListMaterialDTO.builder()
         .netWeight(BigDecimal.ZERO)
         .tareWeight(BigDecimal.ZERO)
         .roughWeight(BigDecimal.ZERO)
         .inOutType(0)
         .build();
      BigDecimal ret = BigDecimal.ZERO;

      try {
         ret = this.getWeight(deviceId);
      } catch (Exception e) {
         Preconditions.checkArgument(false, "获取地磅数据失败");
      }

      build.setRoughWeight(ret.divide(BigDecimal.valueOf(1000L), 5, RoundingMode.HALF_UP));
      build.setTareWeight(ret.divide(BigDecimal.valueOf(1000L), 5, RoundingMode.HALF_UP));
      return build;
   }

   public BigDecimal getWeight(Long deviceId) throws Exception {
      if (deviceId == null) {
         deviceId = this.deviceId;
      }

      WeighingScaleEquipmentInfo info = this.scaleEquipmentInfoService
         .getOne(Wrappers.lambdaQuery(WeighingScaleEquipmentInfo.class).eq(WeighingScaleEquipmentInfo::getDeviceId, deviceId));
      BigDecimal weight = BigDecimal.ZERO;

      try {
         SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
         requestFactory.setConnectTimeout(this.connectTimeout);
         requestFactory.setReadTimeout(this.readTimeout);
         RestTemplate client = new RestTemplate(requestFactory);
         String url = "";
         CargoWeightDTO dto = null;
         if (info == null) {
            url = "http://" + this.ip + this.weightUrl;
            dto = client.getForObject(url, CargoWeightDTO.class);
         } else {
            url = info.getUrl() + "?device_id=" + deviceId;
            String timestamp = String.valueOf(System.currentTimeMillis()).substring(0, 10);
            String hmacSha1 = HmacSha1(deviceId + timestamp, secretKey);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.add("timestamp", timestamp);
            headers.add("token", hmacSha1);
            HttpEntity<?> requestEntity = new HttpEntity(null, headers);
            ResponseEntity<CargoWeightDTO> response = client.exchange(url, HttpMethod.GET, requestEntity, CargoWeightDTO.class);
            dto = response.getBody();
         }

         if (dto.getCommandType().equals(3)) {
            weight = dto.getWeight();
         } else {
            Preconditions.checkArgument(false, "重量获取失败,请联系管理员");
         }
      } catch (Exception e) {
         Preconditions.checkArgument(false, "网络错误,请联系管理员");
      }

      return weight;
   }

   public static String HmacSha1(String base, String key) throws Exception {
      String type = "HmacSHA1";
      SecretKeySpec secret = new SecretKeySpec(key.getBytes(), type);
      Mac mac = Mac.getInstance(type);
      mac.init(secret);
      byte[] digest = mac.doFinal(base.getBytes("UTF-8"));
      return Base64.encodeToString(digest, 2);
   }

   @Override
   public Integer getYearCargoListAllSendSummary(
      LocalDateTime dateTime,
      Long workshopId,
      Integer productionLineTypeEnum,
      List<Long> projectIds,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      return this.baseMapper.getYearCargoListAllSendSummary(dateTime, workshopId, productionLineTypeEnum, projectIds, projectId, startDate, endDate);
   }

   @Override
   public List<CargoDayOrMonthSummaryDTO> printShipDayOrMonthSummary(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer type) {
      return this.baseMapper.printShipDayOrMonthSummary(projectId, startDate, endDate, type);
   }

   @Override
   public List<MesBuildingWeeklyProductionReportDTO> getMonthlyDispatchReportDetails() {
      List<MesBuildingWeeklyProductionReportDTO> monthlyDispatchReportDetails = this.baseMapper.getMonthlyDispatchReportDetails();
      Map<String, List<MesBuildingWeeklyProductionReportDTO>> dispatchReportDTOMap = this.baseMapper
         .getYearslyDispatchReportDetails()
         .stream()
         .collect(Collectors.groupingBy(MesBuildingWeeklyProductionReportDTO::getWorkShopName));
      monthlyDispatchReportDetails.forEach(e -> {
         if (dispatchReportDTOMap.containsKey(e.getWorkShopName())) {
            e.setTotalNetWeight(dispatchReportDTOMap.get(e.getWorkShopName()).get(0).getTotalNetWeight());
         }
      });
      return monthlyDispatchReportDetails;
   }

   @Override
   public List<CargoRealtimeInfoDTO> findCargoRealtimeInfo() {
      return this.baseMapper.findCargoRealtimeInfo();
   }
}
