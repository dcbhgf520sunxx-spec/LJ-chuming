package com.hzchum.scim.mes.building.core.service.impl.wage_manage;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesContractProjectAssemblingWeldingConfigReview;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesContractProjectAssemblingWeldingConfigReviewRecord;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.MesContractProjectAssemblingWeldingConfigReviewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesContractProjectAssemblingWeldingConfigReviewQueryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesContractProjectAssemblingWeldingConfigReviewRecordService;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesContractProjectAssemblingWeldingConfigReviewService;
import com.hzchum.scim.mes.building.core.mapper.wage_manage.MesContractProjectAssemblingWeldingConfigReviewMapper;
import com.hzchum.scim.system.core.api.common.enums.AssemblingWeldingConfigPricingMannerEnum;
import com.hzchum.scim.system.core.api.common.enums.ComparisonOperatorEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectAssemblingWeldingConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectAssemblingWeldingConfigLinkDetail;
import com.hzchum.scim.system.core.api.service.MesContractProjectAssemblingWeldingConfigLinkDetailService;
import com.hzchum.scim.system.core.api.service.MesContractProjectAssemblingWeldingConfigLinkService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesContractProjectAssemblingWeldingConfigReviewServiceImpl
   extends ServiceImpl<MesContractProjectAssemblingWeldingConfigReviewMapper, MesContractProjectAssemblingWeldingConfigReview>
   implements MesContractProjectAssemblingWeldingConfigReviewService {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesContractProjectAssemblingWeldingConfigLinkService assemblingWeldingConfigLinkService;
   @Autowired
   private MesContractProjectAssemblingWeldingConfigLinkDetailService assemblingWeldingConfigLinkDetailService;
   @Autowired
   private MesContractProjectAssemblingWeldingConfigReviewRecordService reviewRecordService;

   @Override
   public PageVO<MesContractProjectAssemblingWeldingConfigReviewDTO> pageInfo(
      MesContractProjectAssemblingWeldingConfigReviewQueryDTOParam queryDTOParam, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<MesContractProjectAssemblingWeldingConfigReviewDTO> dtoList = this.baseMapper.listInfo(queryDTOParam);
      return new PageVO<>(new PageInfo<>(dtoList));
   }

   @Override
   public MesContractProjectAssemblingWeldingConfigReviewDTO detailById(Long id) {
      return this.baseMapper.detailById(id);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveData(MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam saveDTOParam) {
      ContractProject project = this.projectService.getById(saveDTOParam.getContractProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      MesContractProjectAssemblingWeldingConfigLink assemblingWeldingConfigLink = this.assemblingWeldingConfigLinkService
         .getById(saveDTOParam.getContractProjectAssemblingWeldingConfigId());
      Preconditions.checkArgument(assemblingWeldingConfigLink != null, "项目装焊配置不存在");
      MesContractProjectAssemblingWeldingConfigLinkDetail assemblingWeldingConfigLinkDetail = this.assemblingWeldingConfigLinkDetailService
         .getById(saveDTOParam.getContractProjectAssemblingWeldingConfigDetailId());
      Preconditions.checkArgument(assemblingWeldingConfigLinkDetail != null, "项目装焊配置不存在");
      saveDTOParam.setReviewStatus(AuditStatusEnum.AUDITING.getType());
      MesContractProjectAssemblingWeldingConfigReview review = BeanUtil.toBean(saveDTOParam, MesContractProjectAssemblingWeldingConfigReview.class);
      this.baseMapper.insert(review);
      MesContractProjectAssemblingWeldingConfigReviewDTO dto = this.baseMapper.detailById(review.getId());
      MesContractProjectAssemblingWeldingConfigReviewRecord reviewRecord = this.getMesContractProjectAssemblingWeldingConfigReviewRecord(dto);
      this.reviewRecordService.save(reviewRecord);
      return Boolean.TRUE;
   }

   private MesContractProjectAssemblingWeldingConfigReviewRecord getMesContractProjectAssemblingWeldingConfigReviewRecord(
      MesContractProjectAssemblingWeldingConfigReviewDTO dto
   ) {
      MesContractProjectAssemblingWeldingConfigReviewRecord reviewRecord = BeanUtil.toBean(dto, MesContractProjectAssemblingWeldingConfigReviewRecord.class);
      reviewRecord.setContractProjectAssemblingWeldingConfigReviewId(dto.getId());
      String process = dto.getProcessList().stream().map(NameInfo::getName).collect(Collectors.joining(","));
      reviewRecord.setProcess(process);
      String pricingMannerName = AssemblingWeldingConfigPricingMannerEnum.getNameByType(dto.getPricingManner());
      reviewRecord.setPricingMannerName(pricingMannerName);
      reviewRecord.setComparisonOperatorOneSymbol(ComparisonOperatorEnum.getSymbolByType(dto.getComparisonOperatorOne()));
      reviewRecord.setComparisonOperatorTwoSymbol(ComparisonOperatorEnum.getSymbolByType(dto.getComparisonOperatorTwo()));
      reviewRecord.setNewOrganizationInsidePrice(dto.getOrganizationInsidePrice());
      reviewRecord.setNewOrganizationOutsidePrice(dto.getOrganizationOutsidePrice());
      reviewRecord.setReviewStatusName(AuditStatusEnum.getNameByType(dto.getReviewStatus()));
      return reviewRecord;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean changeReviewStatus(MesContractProjectAssemblingWeldingConfigReviewSaveDTOParam saveDTOParam) {
      MesContractProjectAssemblingWeldingConfigReview oldReview = this.baseMapper.selectById(saveDTOParam.getId());
      Preconditions.checkArgument(oldReview != null, "项目装焊配置工价修改审批不存在");
      MesContractProjectAssemblingWeldingConfigReview review = BeanUtil.toBean(saveDTOParam, MesContractProjectAssemblingWeldingConfigReview.class);
      this.baseMapper.updateById(review);
      MesContractProjectAssemblingWeldingConfigReviewDTO reviewDTO = this.baseMapper.detailById(saveDTOParam.getId());
      MesContractProjectAssemblingWeldingConfigReviewRecord reviewRecord = this.getMesContractProjectAssemblingWeldingConfigReviewRecord(reviewDTO);
      this.reviewRecordService.save(reviewRecord);
      if (AuditStatusEnum.SUCCEED.getType().equals(reviewDTO.getReviewStatus())) {
         MesContractProjectAssemblingWeldingConfigLinkDetail assemblingWeldingConfigLinkDetail = MesContractProjectAssemblingWeldingConfigLinkDetail.builder()
            .id(reviewDTO.getContractProjectAssemblingWeldingConfigDetailId())
            .organizationInsidePrice(reviewDTO.getOrganizationInsidePrice())
            .organizationOutsidePrice(reviewDTO.getOrganizationOutsidePrice())
            .build();
         this.assemblingWeldingConfigLinkDetailService.updateById(assemblingWeldingConfigLinkDetail);
      }

      return Boolean.TRUE;
   }
}
