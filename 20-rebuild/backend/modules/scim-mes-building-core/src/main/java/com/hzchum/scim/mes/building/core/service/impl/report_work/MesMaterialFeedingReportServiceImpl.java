package com.hzchum.scim.mes.building.core.service.impl.report_work;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReportDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportArtifactClassDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportDetailParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportQuery;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesMaterialFeedingReportDetailService;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesMaterialFeedingReportService;
import com.hzchum.scim.mes.building.core.mapper.report_work.MesMaterialFeedingReportMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesMaterialFeedingReportServiceImpl
   extends ServiceImpl<MesMaterialFeedingReportMapper, MesMaterialFeedingReport>
   implements MesMaterialFeedingReportService {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesMaterialFeedingReportDetailService detailService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private Validator validator;

   @Override
   public List<MesMaterialFeedingReportDTO> listInfo(MesMaterialFeedingReportQuery query) {
      List<MesMaterialFeedingReportDTO> list = this.baseMapper.listInfo(query);
      if (CollUtil.isNotEmpty(list)) {
         List<Long> workshopIdList = list.stream()
            .peek(i -> i.setWorkshopIdList(Convert.toList(Long.class, StrUtil.split(i.getWorkshopIds(), ","))))
            .map(MesMaterialFeedingReportDTO::getWorkshopIdList)
            .flatMap(Collection::stream)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
         List<MesBuildingWorkshop> workshopList = CollUtil.isNotEmpty(workshopIdList)
            ? this.workshopService.listByIds(workshopIdList)
            : Collections.emptyList();
         list.forEach(
            i -> {
               List<String> workshopNameList = workshopList.stream()
                  .filter(w -> i.getWorkshopIdList().contains(w.getId()))
                  .map(MesBuildingWorkshop::getName)
                  .distinct()
                  .collect(Collectors.toList());
               i.setWorkshopNameList(workshopNameList);
            }
         );
      }

      return list;
   }

   @Override
   public MesMaterialFeedingReportDTO detail(Long id) {
      MesMaterialFeedingReportDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(dto), "当前数据不存在, 请刷新后重试");
      if (StrUtil.isNotBlank(dto.getWorkshopIds())) {
         List<String> workshopNameList = this.workshopService
            .listByIds(Convert.toList(Long.class, StrUtil.split(dto.getWorkshopIds(), ",")))
            .stream()
            .map(MesBuildingWorkshop::getName)
            .distinct()
            .collect(Collectors.toList());
         dto.setWorkshopNameList(workshopNameList);
      }

      List<MesMaterialFeedingReportDetailDTO> detailList = this.detailService.listByMaterialFeedingReportIdList(CollUtil.newArrayList(id));
      dto.setDetailList(detailList);
      return dto;
   }

   private void verifyParam(MesMaterialFeedingReportParam param) {
      Set<ConstraintViolation<MesMaterialFeedingReportParam>> violations = this.validator.validate(param, Add.class);
      Preconditions.checkArgument(violations.isEmpty(), violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n")));
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(project), "项目不存在, 请刷新后重试");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesMaterialFeedingReportParam param) {
      this.verifyParam(param);
      List<Long> workshopIdList = param.getDetailParamList()
         .stream()
         .map(MesMaterialFeedingReportDetailParam::getWorkshopId)
         .distinct()
         .collect(Collectors.toList());
      BigDecimal feedingQuantity = param.getDetailParamList()
         .stream()
         .map(MesMaterialFeedingReportDetailParam::getFeedingQuantity)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(new BigDecimal(1000), 8, RoundingMode.HALF_UP);
      MesMaterialFeedingReport materialFeedingReport = BeanUtil.toBean(param, MesMaterialFeedingReport.class);
      materialFeedingReport.setUserId(UserUtil.getCurrentUserId());
      materialFeedingReport.setWorkshopIds(StrUtil.join(",", workshopIdList));
      materialFeedingReport.setFeedingQuantity(feedingQuantity);
      this.save(materialFeedingReport);
      List<MesMaterialFeedingReportDetail> detailList = param.getDetailParamList().stream().map(detailParam -> {
         MesMaterialFeedingReportDetail detail = BeanUtil.toBean(detailParam, MesMaterialFeedingReportDetail.class);
         detail.setMaterialFeedingReportId(materialFeedingReport.getId());
         return detail;
      }).collect(Collectors.toList());
      this.detailService.saveBatch(detailList);
      return true;
   }

   @Override
   public List<MesMaterialFeedingReportArtifactClassDTO> artifactClassList(Long projectId, Long monomerId, Long areaBatchId, String structureType) {
      return this.baseMapper.artifactClassList(projectId, monomerId, areaBatchId, structureType);
   }
}
