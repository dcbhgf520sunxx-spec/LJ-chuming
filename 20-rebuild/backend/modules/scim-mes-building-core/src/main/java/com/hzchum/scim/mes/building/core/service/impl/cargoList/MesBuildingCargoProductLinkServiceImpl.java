package com.hzchum.scim.mes.building.core.service.impl.cargoList;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.ArtifactDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.EnclosureDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.SendDirectlyDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do._package.TechStandardPartDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactBasicsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ArtifactShipMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.EnclosureShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.EnclosureShipMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.PartSendShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.PartShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.ProductShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.TechStandardPartShipDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductProjectSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductLink;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.cargoList.TrackingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.AppShipTimeDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.CargoListProductLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.TechMachinePartShipDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.CarGoQuantityPackageQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.AppShipDTOParam;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.mapper.cargoList.MesBuildingCargoListProductLinkMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesBuildingCargoProductLinkServiceImpl
   extends ServiceImpl<MesBuildingCargoListProductLinkMapper, MesBuildingCargoListProductLink>
   implements MesBuildingCargoListProductLinkService {
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;

   @Override
   public List<ArtifactDetailDO> listArtifactNotPackById(Long cargoListId) {
      return this.baseMapper.listArtifactNotPackById(cargoListId);
   }

   @Override
   public List<SendDirectlyDetailDO> listPartNotPackById(Long cargoListId) {
      return this.baseMapper.listPartNotPackById(cargoListId);
   }

   @Override
   public List<SendDirectlyDetailDO> listAssembleNotPackById(Long cargoListId) {
      return this.baseMapper.listAssembleNotPackById(cargoListId);
   }

   @Override
   public List<EnclosureDetailDO> listEnclosureNotPackById(Long cargoListId) {
      return this.baseMapper.listEnclosureNotPackById(cargoListId);
   }

   @Override
   public List<TechStandardPartDetailDO> listAuxiliaryMaterialNotPackById(Long cargoListId) {
      return this.baseMapper.listAuxiliaryMaterialNotPackById(cargoListId);
   }

   @Override
   public List<ArtifactShipDO> listArtifactAllById(Long cargoListId) {
      return this.baseMapper.listArtifactAllById(cargoListId);
   }

   @Override
   public List<PartSendShipDO> listPartSendAllById(Long cargoListId) {
      return this.baseMapper.listPartSendAllById(cargoListId);
   }

   @Override
   public List<EnclosureShipDO> listEnclosureAllById(Long cargoListId) {
      return this.baseMapper.listEnclosureAllById(cargoListId);
   }

   @Override
   public List<TechStandardPartShipDO> listAuxiliaryMaterialAllById(Long cargoListId) {
      return this.baseMapper.listAuxiliaryMaterialAllById(cargoListId);
   }

   @Override
   public List<ProductShipDO> listShipByCondition(TrackingDOParam param) {
      return this.baseMapper.listShipByCondition(param);
   }

   @Override
   public List<ProductShipDO> listShipByProjectId(Long projectId) {
      return this.baseMapper.listShipByProjectId(projectId);
   }

   @Override
   public List<ArtifactShipMeteDO> listArtifactShipByProjectId(Long projectId) {
      return this.baseMapper.listArtifactShipByProjectId(projectId);
   }

   @Override
   public List<PartSendShipDO> listPartSendShipByProjectId(Long projectId) {
      return this.baseMapper.listPartSendShipByProjectId(projectId);
   }

   @Override
   public List<EnclosureShipMeteDO> listEnclosureShipByProjectId(Long projectId) {
      return this.baseMapper.listEnclosureShipByProjectId(projectId);
   }

   @Override
   public List<TechStandardPartShipDO> listAuxiliaryMaterialShipByProjectId(Long projectId) {
      return this.baseMapper.listAuxiliaryMaterialShipByProjectId(projectId);
   }

   @Override
   public List<Long> listCargoListIdByCondition(Long projectId, String blurry, Boolean boolAccurateQuery, Long monomerId) {
      return this.baseMapper.listCargoListIdByCondition(projectId, blurry, boolAccurateQuery, monomerId);
   }

   @Override
   public ListVO<ProductProjectSumDO> sumShipmentGroupByProject(AppShipTimeDOParam param) {
      return new ListVO<>(this.baseMapper.sumShipmentGroupByProject(param));
   }

   @Override
   public PageVO pageArtifactShipment(AppShipDTOParam param) {
      PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      return new PageVO<>(this.baseMapper.listArtifactShipment(param));
   }

   @Override
   public PageVO pageEnclosureShipment(AppShipDTOParam param) {
      PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      return new PageVO<>(this.baseMapper.listEnclosureShipment(param));
   }

   @Override
   public Integer getShipQuantityByProduct(Long productId, Integer productType) {
      Integer count = this.baseMapper.sumShipQuantityByProduct(productId, productType);
      return count == null ? 0 : count;
   }

   @Override
   public List<PartShipDO> listPartAllById(Long cargoListId) {
      return this.baseMapper.listPartAllById(cargoListId);
   }

   @Override
   public List<PartShipDO> listAssembleAllById(Long cargoListId) {
      return this.baseMapper.listAssembleAllById(cargoListId);
   }

   @Override
   public List<SendDirectlyDetailDO> listAssembleNotCargoListByIds(Set<Long> artifactIds) {
      return this.baseMapper.listAssembleNotCargoListByIds(artifactIds);
   }

   @Override
   public List<SendDirectlyDetailDO> listAssembleNotLoadedByIds(Set<Long> artifactIds) {
      return this.baseMapper.listAssembleNotLoadedByIds(artifactIds);
   }

   @Override
   public List<SendDirectlyDetailDO> listAssembleNotShippedLoadedByIds(Set<Long> artifactIds) {
      return this.baseMapper.listAssembleNotShippedLoadedByIds(artifactIds);
   }

   @Override
   public List<CargoListDetailsDTO> artifactSourceReportCargoList(Long productId, Integer number, Integer taskId) {
      return this.baseMapper.artifactSourceReportCargoList(productId, number, taskId);
   }

   @Override
   public List<ArtifactBasicsDO> artifactCargoShipDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer handleMethod,
      String specification,
      String material,
      String serialNumber,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String name
   ) {
      return this.baseMapper
         .artifactCargoShipDetail(projectId, monomerId, areaId, handleMethod, specification, material, serialNumber, monomerName, areaName, startDate, endDate, name);
   }

   @Override
   public List<EnclosureShipDO> enclosureCargoShipDetail(
      Long projectId, Long enclosurePlanId, String plate, String serialNumber, String planName, LocalDateTime startDate, LocalDateTime endDate, String name
   ) {
      return this.baseMapper.enclosureCargoShipDetail(projectId, enclosurePlanId, plate, serialNumber, planName, startDate, endDate, name);
   }

   @Override
   public List<TechMachinePartShipDTO> partSendCargoShipDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      String specification,
      String material,
      String serialNumber,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      return this.baseMapper
         .partSendCargoShipDetail(projectId, monomerId, areaId, specification, material, serialNumber, monomerName, areaName, startDate, endDate);
   }

   @Override
   public List<TechStandardPartShipDO> listStandardPartCargoShipDetail(
      Long projectId, Long monomerId, Long areaId, String specification, String name, LocalDateTime startDate, LocalDateTime endDate
   ) {
      return this.baseMapper.listStandardPartCargoShipDetail(projectId, monomerId, areaId, specification, name, startDate, endDate);
   }

   @Override
   public List<CargoListProductLinkDTO> listShipProductRecord(
      List<Long> projectIds, Long monomerId, Integer productType, String name, String serialNumber, LocalDateTime auditStartDate, LocalDateTime auditEndDate
   ) {
      return this.baseMapper.selectShipProductRecord(projectIds, monomerId, productType, name, serialNumber, auditStartDate, auditEndDate);
   }

   @Override
   public List<CargoListProductLinkDTO> listAllProductRecord(
      List<Long> projectIds, Long monomerId, Integer productType, String name, String serialNumber, LocalDateTime auditStartDate, LocalDateTime auditEndDate
   ) {
      return this.baseMapper.selectAllProductRecord(projectIds, monomerId, productType, name, serialNumber, auditStartDate, auditEndDate);
   }

   @Override
   public List<CarGoQuantityPackageQuantityDTO> listQuantity(Integer taskType, Long productId, Long shopId) {
      return this.baseMapper.listQuantity(taskType, productId, shopId);
   }

   @Override
   public List<PartShipDO> listPurlinPartAllById(Long cargoListId) {
      return this.baseMapper.listPurlinPartAllById(cargoListId);
   }

   @Override
   public List<TechMachinePartShipDTO> partPurLineSendCargoShipDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      String specification,
      String material,
      String serialNumber,
      String monomerName,
      String areaName,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      return this.baseMapper
         .partPurLineSendCargoShipDetail(projectId, monomerId, areaId, specification, material, serialNumber, monomerName, areaName, startDate, endDate);
   }

   @Override
   public ArtifactBasicsDO artifactCargoShipSum(Long projectId, LocalDateTime startDate, LocalDateTime endDate) {
      return this.baseMapper.artifactCargoShipSum(projectId, startDate, endDate);
   }
}
