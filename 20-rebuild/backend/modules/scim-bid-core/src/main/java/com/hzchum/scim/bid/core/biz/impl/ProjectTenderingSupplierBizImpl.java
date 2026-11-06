package com.hzchum.scim.bid.core.biz.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.bid.core.api.biz.ProjectTenderingSupplierBiz;
import com.hzchum.scim.bid.core.api.pojo._do.BiddingRounds;
import com.hzchum.scim.bid.core.api.pojo._do.BiddingSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSubject;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSubjectRound;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTendering;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTenderingSupplier;
import com.hzchum.scim.bid.core.api.pojo.dto.ProjectTenderingDTO;
import com.hzchum.scim.bid.core.api.service.BiddingRoundsService;
import com.hzchum.scim.bid.core.api.service.BiddingSupplierService;
import com.hzchum.scim.bid.core.api.service.ProjectSubjectRoundService;
import com.hzchum.scim.bid.core.api.service.ProjectSubjectService;
import com.hzchum.scim.bid.core.api.service.ProjectTenderingSupplierService;
import com.hzchum.scim.bid.core.api.service.SubjectService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@DS("bidding")
public class ProjectTenderingSupplierBizImpl implements ProjectTenderingSupplierBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectTenderingSupplierBizImpl.class);
   @Resource
   private ProjectTenderingSupplierService projectTenderingSupplierService;
   @Resource
   private BiddingRoundsService biddingRoundsService;
   @Resource
   private ProjectSubjectService projectSubjectService;
   @Resource
   private ProjectSubjectRoundService projectSubjectRoundService;
   @Resource
   private BiddingSupplierService biddingSupplierService;
   @Resource
   private SubjectService subjectService;

   @Override
   public void saveSubjectAndSupplier(List<Long> supplierIds, ProjectTenderingDTO dto, ProjectTendering projectTendering) {
      if (CollectionUtils.isNotEmpty(supplierIds)) {
         List<BiddingSupplier> biddingSuppliers = this.biddingSupplierService
            .list((Wrapper<BiddingSupplier>)new LambdaQueryWrapper<BiddingSupplier>().in(BiddingSupplier::getSupplierId, supplierIds));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(biddingSuppliers), "供应商不存在");
         Map<Long, BiddingSupplier> biddingSupplierMap = biddingSuppliers.stream()
            .collect(Collectors.toMap(BiddingSupplier::getSupplierId, e -> (BiddingSupplier)e));
         supplierIds.forEach(
            supplierId -> {
               BiddingSupplier biddingSupplier = biddingSupplierMap.get(supplierId);
               ProjectTenderingSupplier projectTenderingSupplier = ProjectTenderingSupplier.builder()
                  .UUID(projectTendering.getUUID())
                  .supplierId(biddingSupplier.getId())
                  .projectTenderingId(projectTendering.getId())
                  .bidSupplierId(biddingSupplier.getSupplierId())
                  .build();
               this.projectTenderingSupplierService.save(projectTenderingSupplier);
            }
         );
      }

      if (dto != null) {
         BiddingRounds biddingRounds = BeanUtil.copy(dto, BiddingRounds.class);
         biddingRounds.setProjectId(dto.getId());
         biddingRounds.setRound(1);
         this.biddingRoundsService.save(biddingRounds);
         if (CollectionUtils.isNotEmpty(dto.getSubjectProjectDTOS())) {
            dto.getSubjectProjectDTOS()
               .forEach(
                  subject -> {
                     ProjectSubject projectSubject = ProjectSubject.builder()
                        .projectId(projectTendering.getId())
                        .subjectId(subject.getSubjectId())
                        .mete(subject.getMete())
                        .remark(subject.getRemark())
                        .unitName(subject.getUnitName())
                        .specification(subject.getSpecification())
                        .modelNumber(subject.getModelNumber())
                        .subjectNames(this.subjectService.getFullNameBySubjectId(subject.getSubjectId()))
                        .build();
                     this.projectSubjectService.save(projectSubject);
                  }
               );
         }

         List<ProjectSubject> projectSubjects = this.projectSubjectService
            .list((Wrapper<ProjectSubject>)new LambdaQueryWrapper<ProjectSubject>().eq(ProjectSubject::getProjectId, dto.getId()));
         projectSubjects.forEach(e -> {
            ProjectSubjectRound projectSubjectRound = ProjectSubjectRound.builder().round(1).projectSubjectId(e.getId()).projectId(dto.getId()).build();
            this.projectSubjectRoundService.save(projectSubjectRound);
         });
      }
   }
}
