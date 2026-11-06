package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.bid.core.api.enums.CommonEnum;
import com.hzchum.scim.bid.core.api.enums.ProjectProgressEnum;
import com.hzchum.scim.bid.core.api.enums.RespondEnums;
import com.hzchum.scim.bid.core.api.pojo._do.BiddingSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.CnaRegion;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSubject;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTendering;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTenderingSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.Subject;
import com.hzchum.scim.bid.core.api.pojo.dto.BiddingSupplierDTO;
import com.hzchum.scim.bid.core.api.pojo.vo.BiddingSupplierVO;
import com.hzchum.scim.bid.core.api.service.BiddingSupplierService;
import com.hzchum.scim.bid.core.api.service.CnaRegionService;
import com.hzchum.scim.bid.core.api.service.ProjectSubjectService;
import com.hzchum.scim.bid.core.api.service.ProjectSupplierService;
import com.hzchum.scim.bid.core.api.service.ProjectTenderingService;
import com.hzchum.scim.bid.core.api.service.ProjectTenderingSupplierService;
import com.hzchum.scim.bid.core.api.service.SubjectService;
import com.hzchum.scim.bid.core.mapper.BiddingSupplierMapper;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@DS("bidding")
@Service
public class BiddingSupplierServiceImpl extends ServiceImpl<BiddingSupplierMapper, BiddingSupplier> implements BiddingSupplierService {
   @Resource
   private CnaRegionService cnaRegionService;
   @Resource
   private SubjectService subjectService;
   @Resource
   private ConfigService configService;
   @Resource
   @org.springframework.context.annotation.Lazy
   private ProjectTenderingService projectTenderingService;
   @Resource
   private ProjectSupplierService projectSupplierService;
   @Resource
   private ProjectTenderingSupplierService projectTenderingSupplierService;
   @Resource
   private ProjectSubjectService projectSubjectService;

   @Override
   public PageVO<BiddingSupplierVO> getSupplierList(
      String name, String socialCreditCode, Set<Long> subjectIds, Set<Long> regionIds, Boolean boolEnableEnum, Integer page, Integer size
   ) {
      try {
         if (CollectionUtils.isNotEmpty(regionIds)) {
            regionIds = regionIds.stream()
               .flatMap(
                  regionId -> {
                     CnaRegion cnaRegion = this.cnaRegionService.getById(regionId);
                     return this.cnaRegionService
                        .list((Wrapper<CnaRegion>)new LambdaQueryWrapper<CnaRegion>().likeRight(CnaRegion::getPath, cnaRegion.getPath()))
                        .stream()
                        .map(CnaRegion::getId);
                  }
               )
               .collect(Collectors.toSet());
         }

         if (CollectionUtils.isNotEmpty(subjectIds)) {
            subjectIds = subjectIds.stream()
               .flatMap(
                  subjectId -> {
                     Subject subject = this.subjectService.getOne((Wrapper<Subject>)new LambdaQueryWrapper<Subject>().eq(Subject::getId, subjectId));
                     return this.subjectService
                        .list(
                           (Wrapper<Subject>)(new LambdaQueryWrapper<Subject>().likeRight(Subject::getPath, subject.getPath()))
                              .eq(Subject::getBoolLastEnum, true)
                        )
                        .stream()
                        .map(Subject::getId);
                  }
               )
               .collect(Collectors.toSet());
         }

         String uuid = this.configService.getCompanyConfig().getUUID();
         PageHelper.startPage(page, size);
         List<BiddingSupplierVO> biddingSupplierVOS = this.baseMapper.listByCondition(name, socialCreditCode, subjectIds, regionIds, boolEnableEnum, uuid);
         if (CollectionUtils.isEmpty(biddingSupplierVOS)) {
            return new PageVO<>();
         }

         Map<Long, Subject> subjectMap = this.subjectService.getSubject().stream().collect(Collectors.toMap(Subject::getId, e -> (Subject)e));

         for (BiddingSupplierVO supplierVO : biddingSupplierVOS) {
            Set<String> subjectNames = new HashSet<>();

            for (Long aLong : Arrays.stream(supplierVO.getSubjectIds().split(",")).map(Long::valueOf).collect(Collectors.toList())) {
               subjectNames.add(this.getSubjectName(aLong, subjectMap));
            }

            supplierVO.setFirstSubjectName(StringUtils.join(subjectNames, '\\'));
         }

         return new PageVO<>(biddingSupplierVOS);
      } catch (Throwable $ex) {
         throw $ex;
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveSupplier(List<BiddingSupplierDTO> dtOs) {
      List<Long> supplierIds = dtOs.stream().map(BiddingSupplierDTO::getSupplierId).collect(Collectors.toList());
      String uuid = this.configService.getCompanyConfig().getUUID();
      dtOs.forEach(item -> {
         BiddingSupplier copy = BeanUtil.copy(item, BiddingSupplier.class);
         copy.setSupplierId(item.getSupplierId());
         copy.setUUID(uuid);
         Preconditions.checkArgument(this.baseMapper.insert(copy) == 1, "新增失败，请重试");
      });
      List<BiddingSupplier> biddingSuppliers = this.baseMapper
         .selectList(
            (Wrapper<BiddingSupplier>)(new LambdaQueryWrapper<BiddingSupplier>().in(BiddingSupplier::getSupplierId, supplierIds))
               .eq(BiddingSupplier::getUUID, uuid)
         );
      this.saveSupplierProject(biddingSuppliers, uuid);
      return true;
   }

   @Override
   public PageVO<BiddingSupplierVO> querySupplier(
      String name, String code, Set<Long> subjectIds, Set<Long> regionIds, Integer black, Integer page, Integer size
   ) {
      if (CollectionUtils.isNotEmpty(regionIds)) {
         regionIds = regionIds.stream()
            .flatMap(
               regionId -> {
                  CnaRegion cnaRegion = this.cnaRegionService.getById(regionId);
                  return this.cnaRegionService
                     .list((Wrapper<CnaRegion>)new LambdaQueryWrapper<CnaRegion>().likeRight(CnaRegion::getPath, cnaRegion.getPath()))
                     .stream()
                     .map(CnaRegion::getId);
               }
            )
            .collect(Collectors.toSet());
      }

      if (CollectionUtils.isNotEmpty(subjectIds)) {
         subjectIds = subjectIds.stream()
            .flatMap(
               subjectId -> {
                  Subject subject = this.subjectService.getOne((Wrapper<Subject>)new LambdaQueryWrapper<Subject>().eq(Subject::getId, subjectId));
                  return this.subjectService
                     .list(
                        (Wrapper<Subject>)(new LambdaQueryWrapper<Subject>().likeRight(Subject::getPath, subject.getPath()))
                           .eq(Subject::getBoolLastEnum, true)
                     )
                     .stream()
                     .map(Subject::getId);
               }
            )
            .collect(Collectors.toSet());
      }

      String uuid = this.configService.getCompanyConfig().getUUID();
      PageHelper.startPage(page, size);
      List<BiddingSupplierVO> biddingSupplierList = this.getBiddingSuppliers(name, code, subjectIds, regionIds, black, uuid);
      if (CollectionUtils.isEmpty(biddingSupplierList)) {
         return new PageVO<>();
      }

      Map<Long, Subject> subjectMap = this.subjectService.getSubject().stream().collect(Collectors.toMap(Subject::getId, e -> (Subject)e));
      biddingSupplierList.forEach(e -> {
         Set<String> subjectNames = new HashSet<>();

         for (Long aLong : Arrays.stream(e.getSubjectIds().split(",")).map(Long::valueOf).collect(Collectors.toList())) {
            subjectNames.add(this.getSubjectName(aLong, subjectMap));
         }

         e.setFirstSubjectName(StringUtils.join(subjectNames, '\\'));
      });
      return new PageVO<>(biddingSupplierList);
   }

   @Override
   public List<BiddingSupplierVO> getInvite(Set<Long> subjectIds) {
      String uuid = this.configService.getCompanyConfig().getUUID();
      return this.getBiddingSuppliers(null, null, subjectIds, null, CommonEnum.FALSE.getType(), uuid);
   }

   @Override
   public BiddingSupplierVO getDetail(Long id) {
      String uuid = this.configService.getCompanyConfig().getUUID();
      BiddingSupplierVO biddingSupplierVO = this.baseMapper.getBiddingSupplierOne(id, uuid);
      Preconditions.checkArgument(biddingSupplierVO != null, "该供应商信息不存在");
      List<String> subjectNames = Arrays.asList(StringUtils.split(biddingSupplierVO.getSubjectName(), ","));
      List<String> regionNames = Arrays.asList(StringUtils.split(biddingSupplierVO.getRegionName(), ","));
      biddingSupplierVO.setSubjectNameList(subjectNames);
      biddingSupplierVO.setRegionNameList(regionNames);
      return biddingSupplierVO;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteSupplier(List<Long> ids) {
      String uuid = this.configService.getCompanyConfig().getUUID();
      List<BiddingSupplier> biddingSuppliers = this.baseMapper
         .selectList(
            (Wrapper<BiddingSupplier>)(new LambdaQueryWrapper<BiddingSupplier>().in(BiddingSupplier::getId, ids)).eq(BiddingSupplier::getUUID, uuid)
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(biddingSuppliers), "供应商不存在，(拉黑)删除失败");
      Preconditions.checkArgument(ids.size() == biddingSuppliers.size(), "供应商不存在，(拉黑)删除失败");
      List<Long> supplierIds = biddingSuppliers.stream().map(BiddingSupplier::getSupplierId).collect(Collectors.toList());
      this.toExamine(supplierIds, uuid);
      Preconditions.checkArgument(this.baseMapper.deleteBatchIds(ids) == ids.size(), "供应商删除失败");
      this.removeSupplierProject(biddingSuppliers, uuid);
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean setBlacklist(List<Long> ids, Integer black) {
      String uuid = this.configService.getCompanyConfig().getUUID();
      List<BiddingSupplier> biddingSuppliers = this.baseMapper
         .selectList(
            (Wrapper<BiddingSupplier>)(new LambdaQueryWrapper<BiddingSupplier>().in(BiddingSupplier::getId, ids)).eq(BiddingSupplier::getUUID, uuid)
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(biddingSuppliers), "供应商不存在，(拉黑)删除失败");
      Preconditions.checkArgument(ids.size() == biddingSuppliers.size(), "供应商不存在，(拉黑)删除失败");
      List<Long> supplierIds = biddingSuppliers.stream().map(BiddingSupplier::getSupplierId).collect(Collectors.toList());
      this.toExamine(supplierIds, uuid);
      biddingSuppliers.forEach(e -> {
         e.setIsBlock(black);
         Preconditions.checkArgument(this.baseMapper.updateById(e) == 1, "修改失败，请重试");
      });
      if (black.equals(CommonEnum.TRUE.getType())) {
         this.removeSupplierProject(biddingSuppliers, uuid);
      } else {
         this.saveSupplierProject(biddingSuppliers, uuid);
      }

      return true;
   }

   @Override
   public ListVO getSupplier(Long id) {
      String uuid = this.configService.getCompanyConfig().getUUID();
      List<Long> supplierIds = this.projectTenderingSupplierService
         .list(
            (Wrapper<ProjectTenderingSupplier>)(new LambdaQueryWrapper<ProjectTenderingSupplier>().eq(ProjectTenderingSupplier::getProjectTenderingId, id))
               .eq(ProjectTenderingSupplier::getUUID, uuid)
         )
         .stream()
         .map(ProjectTenderingSupplier::getBidSupplierId)
         .collect(Collectors.toList());
      supplierIds.removeAll(Collections.singleton(null));
      Set<Long> subjects = this.projectSubjectService
         .list((Wrapper<ProjectSubject>)new LambdaQueryWrapper<ProjectSubject>().eq(ProjectSubject::getProjectId, id))
         .stream()
         .map(ProjectSubject::getSubjectId)
         .collect(Collectors.toSet());
      List<BiddingSupplierVO> biddingSuppliers = this.baseMapper.getList(null, null, subjects, null, CommonEnum.FALSE.getType(), uuid);
      if (CollectionUtils.isNotEmpty(supplierIds)) {
         biddingSuppliers = biddingSuppliers.stream().filter(e -> {
            for (Long supplierId : supplierIds) {
               if (e.getSupplierId().equals(supplierId)) {
                  return false;
               }
            }

            return true;
         }).collect(Collectors.toList());
      }

      return CollectionUtils.isEmpty(biddingSuppliers) ? new ListVO() : new ListVO<>(biddingSuppliers);
   }

   @Override
   public List<BiddingSupplierVO> getList(String name, String code, Set<Long> subjectIds, Set<Long> regionIds, Integer black, String uuid) {
      return this.baseMapper.getList(name, code, subjectIds, regionIds, black, uuid);
   }

   private void toExamine(List<Long> supplierIds, String uuid) {
      Set<Long> projectList = this.projectTenderingSupplierService
         .list(
            (Wrapper<ProjectTenderingSupplier>)(new LambdaQueryWrapper<ProjectTenderingSupplier>().in(ProjectTenderingSupplier::getBidSupplierId, supplierIds))
               .eq(ProjectTenderingSupplier::getUUID, uuid)
         )
         .stream()
         .map(ProjectTenderingSupplier::getProjectTenderingId)
         .collect(Collectors.toSet());
      if (!CollectionUtils.isEmpty(projectList)) {
         for (ProjectTendering projectTendering : this.projectTenderingService.listByIds(projectList)) {
            Preconditions.checkArgument(
               projectTendering.getProjectProgress().equals(ProjectProgressEnum.OBSOLETE.getType())
                  || projectTendering.getProjectProgress().equals(ProjectProgressEnum.PAUSED.getType()),
               "该供应商作为项目邀请(投标)方暂时无法删除(拉黑)"
            );
         }
      }
   }

   private List<BiddingSupplierVO> getBiddingSuppliers(String name, String code, Set<Long> subjectIds, Set<Long> regionIds, Integer black, String uuid) {
      return this.baseMapper.getList(name, code, subjectIds, regionIds, black, uuid);
   }

   private void saveSupplierProject(List<BiddingSupplier> biddingSuppliers, String uuid) {
      List<ProjectTendering> project = this.projectTenderingService.getProject(uuid);
      if (!CollectionUtils.isEmpty(project)) {
         for (BiddingSupplier supplier : biddingSuppliers) {
            for (ProjectTendering projectTendering : project) {
               ProjectSupplier projectSupplier = this.projectSupplierService
                  .getOne(
                     (Wrapper<ProjectSupplier>)(new LambdaQueryWrapper<ProjectSupplier>().eq(ProjectSupplier::getSupplierId, supplier.getSupplierId()))
                        .eq(ProjectSupplier::getProjectId, projectTendering.getId())
                  );
               if (projectSupplier == null) {
                  ProjectSupplier build = ProjectSupplier.builder().supplierId(supplier.getSupplierId()).projectId(projectTendering.getId()).UUID(uuid).build();
                  this.projectSupplierService.save(build);
               }
            }
         }
      }
   }

   private String getSubjectName(Long subjectId, Map<Long, Subject> subjectMap) {
      Subject subject = subjectMap.get(subjectId);
      Preconditions.checkArgument(subject != null, "科目不存在");
      return subject.getLevel() == 1 ? subject.getName() : this.getSubjectName(subject.getPid(), subjectMap);
   }

   private void removeSupplierProject(List<BiddingSupplier> biddingSuppliers, String uuid) {
      List<Long> supplierIds = biddingSuppliers.stream().map(BiddingSupplier::getSupplierId).collect(Collectors.toList());
      List<ProjectSupplier> projectSuppliers = this.projectSupplierService
         .list(
            (Wrapper<ProjectSupplier>)((new LambdaQueryWrapper<ProjectSupplier>().eq(ProjectSupplier::getUUID, uuid))
                  .in(ProjectSupplier::getSupplierId, supplierIds))
               .eq(ProjectSupplier::getBidStatus, RespondEnums.NO_RESPOND.getType())
         );
      if (CollectionUtils.isNotEmpty(projectSuppliers)) {
         for (ProjectSupplier projectSupplier : projectSuppliers) {
            this.projectSupplierService.removeById(projectSupplier.getId());
         }
      }
   }
}
