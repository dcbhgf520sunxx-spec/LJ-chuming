package com.hzchum.scim.bid.core.biz.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.bid.core.api.biz.MessageTemplateBiz;
import com.hzchum.scim.bid.core.api.biz.ProjectTenderingBiz;
import com.hzchum.scim.bid.core.api.biz.ProjectTenderingSupplierBiz;
import com.hzchum.scim.bid.core.api.enums.BiddingTypeEnum;
import com.hzchum.scim.bid.core.api.enums.CommonEnum;
import com.hzchum.scim.bid.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.bid.core.api.enums.OrderTransportTypeEnum;
import com.hzchum.scim.bid.core.api.enums.ProjectBidStatusEnum;
import com.hzchum.scim.bid.core.api.enums.ProjectProgressEnum;
import com.hzchum.scim.bid.core.api.enums.ProjectSubjectStatusEnum;
import com.hzchum.scim.bid.core.api.enums.RespondEnums;
import com.hzchum.scim.bid.core.api.pojo._do.BiddingRounds;
import com.hzchum.scim.bid.core.api.pojo._do.BiddingSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.OfferRoundDetail;
import com.hzchum.scim.bid.core.api.pojo._do.OfferRounds;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSubject;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSubjectRound;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTendering;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTenderingSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.Subject;
import com.hzchum.scim.bid.core.api.pojo._do.SupplierSubject;
import com.hzchum.scim.bid.core.api.pojo._do.SupplierSubjectRound;
import com.hzchum.scim.bid.core.api.pojo.dto.EvaluationBidDTO;
import com.hzchum.scim.bid.core.api.pojo.vo.BiddingRoundsVO;
import com.hzchum.scim.bid.core.api.pojo.vo.CommonVO;
import com.hzchum.scim.bid.core.api.pojo.vo.DetailVO;
import com.hzchum.scim.bid.core.api.pojo.vo.OfferRoundDetailVO;
import com.hzchum.scim.bid.core.api.pojo.vo.OfferRoundsVO;
import com.hzchum.scim.bid.core.api.pojo.vo.ProjectTenderingVO;
import com.hzchum.scim.bid.core.api.pojo.vo.SubjectProjectVO;
import com.hzchum.scim.bid.core.api.pojo.vo.SupplierAmountVO;
import com.hzchum.scim.bid.core.api.pojo.vo.TenderNoticeVO;
import com.hzchum.scim.bid.core.api.pojo.vo.TenderingSupplierVO;
import com.hzchum.scim.bid.core.api.service.BiddingRoundsService;
import com.hzchum.scim.bid.core.api.service.BiddingSupplierService;
import com.hzchum.scim.bid.core.api.service.OfferRoundDetailService;
import com.hzchum.scim.bid.core.api.service.OfferRoundsService;
import com.hzchum.scim.bid.core.api.service.ProjectSubjectRoundService;
import com.hzchum.scim.bid.core.api.service.ProjectSubjectService;
import com.hzchum.scim.bid.core.api.service.ProjectSupplierService;
import com.hzchum.scim.bid.core.api.service.ProjectTenderingService;
import com.hzchum.scim.bid.core.api.service.ProjectTenderingSupplierService;
import com.hzchum.scim.bid.core.api.service.SubjectService;
import com.hzchum.scim.bid.core.api.service.SupplierSubjectRoundService;
import com.hzchum.scim.bid.core.api.service.SupplierSubjectService;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.system.core.api.common.utils.NumberUtils;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@DS("bidding")
public class ProjectTenderingBizImpl implements ProjectTenderingBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectTenderingBizImpl.class);
   @Resource
   private ProjectTenderingService projectTenderingService;
   @Resource
   private ProjectTenderingSupplierService projectTenderingSupplierService;
   @Resource
   private BiddingSupplierService biddingSupplierService;
   @Resource
   private ProjectSupplierService projectSupplierService;
   @Resource
   private ProjectTenderingSupplierBiz projectTenderingSupplierBiz;
   @Resource
   private MessageTemplateBiz messageTemplateBiz;
   @Resource
   private ProjectSubjectService projectSubjectService;
   @Resource
   private OfferRoundDetailService offerRoundDetailService;
   @Resource
   private BiddingRoundsService biddingRoundsService;
   @Resource
   private SupplierSubjectService supplierSubjectService;
   @Resource
   private ProjectSubjectRoundService projectSubjectRoundService;
   @Resource
   private SupplierSubjectRoundService supplierSubjectRoundService;
   @Resource
   private ConfigService configService;
   @Resource
   private OfferRoundsService offerRoundsService;
   @Resource
   private SubjectService subjectService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public ProjectTenderingVO getDetail(Long id) {
      String uuid = this.configService.getCompanyConfig().getUUID();
      this.projectTenderingService.setTendering(uuid);
      ProjectTendering projectTendering = this.projectTenderingService.getById(id);
      Preconditions.checkArgument(projectTendering != null, "该招采项目不存在");
      ProjectTenderingVO projectTenderingVO = this.projectTenderingService.selectByProjectId(id);
      if (!projectTendering.getBiddingType().equals(BiddingTypeEnum.ENQUIRY.getType())) {
         projectTenderingVO.setTenderNoticeVO(JSON.parseObject(projectTendering.getTenderValue(), TenderNoticeVO.class));
      }

      List<ProjectSubject> projectSubjects = this.projectSubjectService
         .list((Wrapper<ProjectSubject>)new LambdaQueryWrapper<ProjectSubject>().eq(ProjectSubject::getProjectId, id));
      projectTenderingVO.setSubjectProjectVOS(projectSubjects.stream().map(item -> BeanUtil.copy(item, SubjectProjectVO.class)).collect(Collectors.toList()));
      if (!projectTendering.getBiddingType().equals(BiddingTypeEnum.OPEN_TENDERING.getType())) {
         List<TenderingSupplierVO> supplierList = this.projectTenderingSupplierService.getSupplierByProjectId(id, null);
         projectTenderingVO.setSupplierVOList(supplierList.stream().map(item -> BeanUtil.copy(item, TenderingSupplierVO.class)).collect(Collectors.toList()));
      }

      return projectTenderingVO;
   }

   @Override
   public ListVO getDetailSupplier(Long id, Long supplierId) {
      Preconditions.checkArgument(this.projectTenderingService.getById(id) != null, "招标信息不存在");
      Preconditions.checkArgument(this.projectTenderingSupplierService.getById(supplierId) != null, "供应商信息不存在");
      List<OfferRoundDetailVO> offerRoundDetail = this.projectTenderingSupplierService.getOfferRoundDetail(id, supplierId, CommonEnum.FALSE.getType());
      if (CollectionUtils.isEmpty(offerRoundDetail)) {
         return new ListVO();
      }

      offerRoundDetail.forEach(
         item -> {
            List<DetailVO> detailVOList = item.getDetailVOList();
            if (detailVOList.size() > 1) {
               for (int i = 0; i < detailVOList.size(); i++) {
                  if (i < detailVOList.size() - 1) {
                     DetailVO detailVO = detailVOList.get(i);
                     DetailVO detailVONext = detailVOList.get(i + 1);
                     if (detailVONext.getBidAmount() != null) {
                        BigDecimal subtract = detailVONext.getBidAmount()
                           .subtract(detailVO.getBidAmount() == null ? new BigDecimal("0") : detailVO.getBidAmount());
                        detailVONext.setContrastBidAmount(subtract);
                     }
                  }
               }
            }
         }
      );
      return new ListVO<>(offerRoundDetail);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Future<Boolean> saveSupplier(Long id, List<Long> ids) {
      ProjectTendering projectTendering = this.projectTenderingService.getById(id);
      Preconditions.checkArgument(projectTendering != null, "招标项目不存在");
      Preconditions.checkArgument(!projectTendering.getBiddingType().equals(BiddingTypeEnum.OPEN_TENDERING.getType()), "项目为公开招标，无法邀请供应商");
      Preconditions.checkArgument(projectTendering.getIsOpen().equals(CommonEnum.FALSE.getType()), "项目已开标，无法邀请供应商");
      Preconditions.checkArgument(
         !projectTendering.getProjectProgress().equals(ProjectProgressEnum.PAUSED.getType())
            || !projectTendering.getProjectProgress().equals(ProjectProgressEnum.IS_START.getType())
            || !projectTendering.getProjectProgress().equals(ProjectProgressEnum.OBSOLETE.getType()),
         "项目已废标/暂停/结束,无法邀请供应商"
      );
      Preconditions.checkArgument(projectTendering.getStatus().equals(ProjectBidStatusEnum.RELEASED.getType()), "项目尚未通过审核，无法邀请供应商");
      ProjectTenderingVO projectVO = this.projectTenderingService.selectByProjectId(id);
      Preconditions.checkArgument(projectVO.getRound() == 1, "不是第一轮，无法邀请供应商");
      Preconditions.checkArgument(projectVO.getBidDeadline().getTime() >= System.currentTimeMillis(), "投标截止时间已过，无法邀请供应商");
      List<ProjectTenderingSupplier> suppliers = this.projectTenderingSupplierService
         .list(
            (Wrapper<ProjectTenderingSupplier>)(new LambdaQueryWrapper<ProjectTenderingSupplier>().eq(ProjectTenderingSupplier::getProjectTenderingId, id))
               .in(ProjectTenderingSupplier::getBidSupplierId, ids)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(suppliers), "该供应商已被邀请，无法重复添加，请刷新页面");
      ids.removeAll(Collections.singleton(null));
      this.projectTenderingSupplierBiz.saveSubjectAndSupplier(ids, null, projectTendering);
      projectTendering.setInvitingNum(projectTendering.getInvitingNum() + ids.size());
      this.projectTenderingService.updateById(projectTendering);
      List<BiddingSupplier> biddingSuppliers = this.biddingSupplierService
         .list(
            (Wrapper<BiddingSupplier>)(new LambdaQueryWrapper<BiddingSupplier>().in(BiddingSupplier::getSupplierId, ids))
               .eq(BiddingSupplier::getUUID, projectTendering.getUUID())
         );
      biddingSuppliers.forEach(e -> {
         ProjectSupplier build = ProjectSupplier.builder().projectId(id).supplierId(e.getSupplierId()).UUID(projectTendering.getUUID()).build();
         this.projectSupplierService.save(build);
      });
      this.messageTemplateBiz.sendSupplier(projectTendering, ids, projectVO.getBidDeadline());
      return new AsyncResult<>(true);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Future<Boolean> evaluationBid(Long projectId, Long bidDeadline, Long bidOpeningTime, List<EvaluationBidDTO> evaluationBidDTOS) {
      ProjectTendering projectTendering = this.projectTenderingService.getById(projectId);
      Preconditions.checkArgument(projectTendering != null, "该招标项目不存在");
      Preconditions.checkArgument(projectTendering.getProjectProgress().equals(ProjectProgressEnum.NOT_START.getType()), "该招标项目进度不是开标中");
      Map<Long, ProjectSubject> projectSubjectMap = this.projectSubjectService
         .list((Wrapper<ProjectSubject>)new LambdaQueryWrapper<ProjectSubject>().eq(ProjectSubject::getProjectId, projectId))
         .stream()
         .collect(Collectors.toMap(ProjectSubject::getId, e -> (ProjectSubject)e));
      Map<Long, ProjectTenderingSupplier> tenderingSupplierMap = this.projectTenderingSupplierService
         .list((Wrapper<ProjectTenderingSupplier>)new LambdaQueryWrapper<ProjectTenderingSupplier>().eq(ProjectTenderingSupplier::getProjectTenderingId, projectId))
         .stream()
         .collect(Collectors.toMap(ProjectTenderingSupplier::getId, e -> (ProjectTenderingSupplier)e));
      Map<Long, OfferRoundDetail> offerRoundDetailMap = this.offerRoundDetailService
         .list((Wrapper<OfferRoundDetail>)new LambdaQueryWrapper<OfferRoundDetail>().eq(OfferRoundDetail::getProjectId, projectId))
         .stream()
         .collect(Collectors.toMap(OfferRoundDetail::getId, e -> (OfferRoundDetail)e));
      Integer round = this.biddingRoundsService.getOne(((QueryWrapper)new QueryWrapper().eq("project_id", projectId)).select("max(round) as round")).getRound();
      evaluationBidDTOS.forEach(
         e -> {
            ProjectSubject projectSubject = projectSubjectMap.get(e.getProjectSubjectId());
            Preconditions.checkArgument(projectSubject != null, "该招标科目不存在");
            Map<Long, SupplierSubject> supplierSubjectMapx = this.supplierSubjectService
               .list(
                  (Wrapper<SupplierSubject>)((new LambdaQueryWrapper<SupplierSubject>()
                           .eq(SupplierSubject::getProjectSubjectId, e.getProjectSubjectId()))
                        .eq(SupplierSubject::getProjectId, projectId))
                     .isNull(SupplierSubject::getIsFollow)
               )
               .stream()
               .collect(Collectors.toMap(SupplierSubject::getSupplierId, s -> (SupplierSubject)s));
            if (e.getSupplierId() == null && CollectionUtils.isEmpty(e.getNextRounds())) {
               projectSubject.setStatus(ProjectSubjectStatusEnum.ABANDON.getType());
               this.projectSubjectService.updateById(projectSubject);
               if (CollectionUtils.isNotEmpty(e.getWeedOuts())) {
                  this.setWeedOuts(e.getWeedOuts(), tenderingSupplierMap, supplierSubjectMapx, offerRoundDetailMap);
               }
            } else if (e.getSupplierId() != null) {
               ProjectTenderingSupplier supplier = tenderingSupplierMap.get(e.getSupplierId());
               Preconditions.checkArgument(supplier != null, "该供应商不存在");
               Preconditions.checkArgument(CollectionUtils.isEmpty(e.getNextRounds()), "拟中标时其他供应商无法进入下一轮");
               Preconditions.checkArgument(e.getOfferDetailId() != null, "报价详情id不能为空");
               SupplierSubject supplierSubject = supplierSubjectMapx.get(e.getSupplierId());
               Preconditions.checkArgument(supplierSubject != null, "供应商-招标科目信息不能为空");
               supplierSubject.setIsFollow(CommonEnum.TRUE.getType());
               supplierSubject.setOfferDetailId(e.getOfferDetailId());
               supplierSubject.setWinningTime(new Date());
               OfferRoundDetail offerRoundDetail = offerRoundDetailMap.get(e.getOfferDetailId());
               offerRoundDetail.setIsFollow(CommonEnum.TRUE.getType());
               offerRoundDetail.setWinningTime(new Date());
               projectSubject.setStatus(ProjectSubjectStatusEnum.COMPLETED.getType());
               this.supplierSubjectService.updateById(supplierSubject);
               this.offerRoundDetailService.updateById(offerRoundDetail);
               this.projectSubjectService.updateById(projectSubject);
               if (CollectionUtils.isNotEmpty(e.getWeedOuts())) {
                  supplierSubjectMapx.remove(e.getSupplierId());
                  this.setWeedOuts(e.getWeedOuts(), tenderingSupplierMap, supplierSubjectMapx, offerRoundDetailMap);
               }
            } else {
               Preconditions.checkArgument(e.getNextRounds() != null, "该科目进入下一轮供应商信息不能为空");
               if (CollectionUtils.isNotEmpty(e.getWeedOuts())) {
                  this.setWeedOuts(e.getWeedOuts(), tenderingSupplierMap, supplierSubjectMapx, offerRoundDetailMap);
               }
            }
         }
      );
      List<SupplierSubject> supplierSubjectList = this.projectTenderingSupplierService.getNotOffer(projectId);
      if (CollectionUtils.isNotEmpty(supplierSubjectList)) {
         for (SupplierSubject supplierSubject : supplierSubjectList) {
            supplierSubject.setIsFollow(CommonEnum.FALSE.getType());
            this.supplierSubjectService.updateById(supplierSubject);
         }
      }

      List<ProjectSubject> projectSubjects = this.projectSubjectService
         .list(
            (Wrapper<ProjectSubject>)(new LambdaQueryWrapper<ProjectSubject>().eq(ProjectSubject::getProjectId, projectId))
               .eq(ProjectSubject::getStatus, ProjectSubjectStatusEnum.UNDERWAY.getType())
         );
      projectSubjects.forEach(e -> {
         ProjectSubjectRound buildx = ProjectSubjectRound.builder().projectId(projectId).round(round + 1).projectSubjectId(e.getId()).build();
         this.projectSubjectRoundService.save(buildx);
      });
      List<SupplierSubject> subjectList = this.supplierSubjectService
         .list(
            (Wrapper<SupplierSubject>)(new LambdaQueryWrapper<SupplierSubject>().eq(SupplierSubject::getProjectId, projectId))
               .eq(SupplierSubject::getIsFollow, CommonEnum.TRUE.getType())
         );
      if (CollectionUtils.isEmpty(projectSubjects)) {
         if (CollectionUtils.isNotEmpty(subjectList)) {
            projectTendering.setProjectProgress(ProjectProgressEnum.OBSOLETE.getType());
         } else {
            projectTendering.setProjectProgress(ProjectProgressEnum.PAUSED.getType());
         }

         this.projectTenderingService.updateById(projectTendering);
         this.messageTemplateBiz.sendSupplierOffer(projectTendering, round, null);
         return new AsyncResult<>(true);
      } else {
         Map<Long, List<SupplierSubject>> supplierSubjectMap = this.supplierSubjectService
            .list(
               (Wrapper<SupplierSubject>)(new LambdaQueryWrapper<SupplierSubject>().eq(SupplierSubject::getProjectId, projectId))
                  .isNull(SupplierSubject::getIsFollow)
            )
            .stream()
            .collect(Collectors.toMap(SupplierSubject::getSupplierId, e -> new ArrayList<>(Collections.singleton((SupplierSubject)e)), (oldList, newList) -> {
               oldList.addAll(newList);
               return oldList;
            }));
         List<ProjectTenderingSupplier> suppliers = this.projectTenderingSupplierService
            .list(
               (Wrapper<ProjectTenderingSupplier>)(new LambdaQueryWrapper<ProjectTenderingSupplier>().eq(ProjectTenderingSupplier::getProjectTenderingId, projectId))
                  .eq(ProjectTenderingSupplier::getBidStatus, RespondEnums.RESPOND.getType())
            );
         suppliers.forEach(
            supplier -> {
               List<SupplierSubject> supplierSubjects = supplierSubjectMap.get(supplier.getId());
               if (CollectionUtils.isEmpty(supplierSubjects)) {
                  supplier.setResult(CommonEnum.TRUE.getType());
                  this.projectTenderingSupplierService.updateById(supplier);
               } else {
                  supplierSubjects.forEach(
                     supplierSubject -> {
                        SupplierSubjectRound buildx = SupplierSubjectRound.builder()
                           .supplierId(supplier.getId())
                           .projectSubjectId(supplierSubject.getProjectSubjectId())
                           .projectId(projectId)
                           .round(round + 1)
                           .build();
                        this.supplierSubjectRoundService.save(buildx);
                     }
                  );
               }
            }
         );
         Preconditions.checkArgument(bidDeadline > System.currentTimeMillis(), "投标截止时间必须是未来的时间");
         Preconditions.checkArgument(bidOpeningTime >= bidDeadline, "开标时间必须大于或等于投标截止时间");
         Preconditions.checkArgument(bidOpeningTime < projectTendering.getDeliveryTime().getTime(), "开标时间不得大于交货时间");
         Date bidDead = DateTimeUtil.longToDate(bidDeadline);
         Date bidOpen = DateTimeUtil.longToDate(bidOpeningTime);
         BiddingRounds build = BiddingRounds.builder()
            .bidDeadline(bidDead)
            .bidOpeningTime(bidOpen)
            .projectId(projectId)
            .releaseDate(new Date())
            .round(round + 1)
            .build();
         Preconditions.checkArgument(this.biddingRoundsService.save(build), "进入下一轮失败，请刷新重试");
         this.messageTemplateBiz.sendSupplierOffer(projectTendering, round, DateTimeUtil.dateToStringDd(bidDead));
         return new AsyncResult<>(true);
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public ProjectTenderingVO getManually(Long id) {
      String uuid = this.configService.getCompanyConfig().getUUID();
      this.projectTenderingService.setTendering(uuid);
      ProjectTendering projectTendering = this.projectTenderingService.getById(id);
      Preconditions.checkArgument(projectTendering != null, "招标信息不存在");
      Integer round = this.biddingRoundsService.getOne(((QueryWrapper)new QueryWrapper().eq("project_id", id)).select("max(round) as round")).getRound();
      BiddingRounds biddingRounds = this.biddingRoundsService
         .getOne((Wrapper<BiddingRounds>)(new LambdaQueryWrapper<BiddingRounds>().eq(BiddingRounds::getRound, round)).eq(BiddingRounds::getProjectId, id));
      Integer tickSizeNum = 0;
      List<OfferRounds> offerRoundsList = this.offerRoundsService
         .list(
            (Wrapper<OfferRounds>)(((new LambdaQueryWrapper<OfferRounds>().eq(OfferRounds::getOfferRound, round))
                     .eq(OfferRounds::getIsHold, CommonEnum.FALSE.getType()))
                  .eq(OfferRounds::getProjectTenderingId, id))
               .isNotNull(OfferRounds::getBidGrossAmount)
         );
      if (CollectionUtils.isNotEmpty(offerRoundsList)) {
         tickSizeNum = offerRoundsList.size();
      }

      ProjectTenderingVO projectTenderingVO = ProjectTenderingVO.builder()
         .round(round)
         .projectProgress(projectTendering.getProjectProgress())
         .name(projectTendering.getName())
         .id(projectTendering.getId())
         .isCashDeposit(projectTendering.getIsCashDeposit())
         .status(projectTendering.getStatus())
         .bidOpeningTime(biddingRounds.getBidOpeningTime())
         .bidDeadline(biddingRounds.getBidDeadline())
         .isOpen(projectTendering.getIsOpen())
         .tickSizeNum(tickSizeNum)
         .biddingType(projectTendering.getBiddingType())
         .build();
      List<TenderingSupplierVO> suppliers = this.projectTenderingSupplierService.getSupplierByProjectId(id, null);
      if (CollectionUtils.isNotEmpty(suppliers)) {
         projectTenderingVO.setSupplierVOList(suppliers);
         List<OfferRoundsVO> offerRounds = this.projectTenderingSupplierService.getOfferRounds(id);
         Map<Long, List<OfferRoundsVO>> OfferRoundsVOMap = offerRounds.stream()
            .collect(Collectors.toMap(OfferRoundsVO::getId, e -> new ArrayList<>(Collections.singleton((OfferRoundsVO)e)), (oldList, newList) -> {
               oldList.addAll(newList);
               return oldList;
            }));
         projectTenderingVO.getSupplierVOList().forEach(item -> {
            List<OfferRoundsVO> offerRoundsVOS = OfferRoundsVOMap.get(item.getId());
            if (projectTendering.getIsCashDeposit().equals(CommonEnum.TRUE.getType())) {
               offerRoundsVOS.forEach(e -> {
                  if (e.getRound() == 1) {
                     item.setDepositUrl(e.getDepositUrl());
                     item.setDepositName(e.getDepositName());
                  }
               });
            }

            item.setOfferRoundsVOS(offerRoundsVOS);
         });
      }

      List<BiddingRounds> biddingRoundList = this.biddingRoundsService
         .list((Wrapper<BiddingRounds>)new LambdaQueryWrapper<BiddingRounds>().eq(BiddingRounds::getProjectId, id));
      projectTenderingVO.setBiddingRoundsVOS(
         biddingRoundList.stream()
            .sorted(Comparator.comparing(BiddingRounds::getRound, Comparator.nullsFirst(Integer::compareTo)).reversed())
            .map(item -> BeanUtil.copy(item, BiddingRoundsVO.class))
            .collect(Collectors.toList())
      );
      List<SupplierAmountVO> supplierAmountVOS = new ArrayList<>();
      List<SubjectProjectVO> winBidding = this.projectTenderingSupplierService.getWinBidding(id);
      Long suId = -1L;

      for (SubjectProjectVO vo : winBidding) {
         if (vo.getSupplierId() == -1L) {
            suId = suId - 1L;
            vo.setSupplierId(suId);
         }
      }

      Map<Long, List<SubjectProjectVO>> winBidMap = winBidding.stream()
         .collect(Collectors.toMap(SubjectProjectVO::getSupplierId, e -> new ArrayList<>(Collections.singleton((SubjectProjectVO)e)), (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
         }));
      winBidMap.forEach(
         (supplierId, subjectProjectVOList) -> {
            List<BigDecimal> bigDecimalList = subjectProjectVOList.stream().map(SubjectProjectVO::getBidAmount).collect(Collectors.toList());
            bigDecimalList.removeAll(Collections.singleton(null));
            BigDecimal reduce = null;
            if (CollectionUtils.isNotEmpty(bigDecimalList)) {
               reduce = bigDecimalList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            }

            SupplierAmountVO build = SupplierAmountVO.builder()
               .supplierId(supplierId)
               .totalAmount(reduce)
               .winBidVOS((List<SubjectProjectVO>)subjectProjectVOList)
               .build();
            supplierAmountVOS.add(build);
         }
      );
      List<SupplierAmountVO> supplierAmountVOList = supplierAmountVOS.stream()
         .sorted(Comparator.comparing(SupplierAmountVO::getSupplierId, Comparator.nullsFirst(Long::compareTo)).reversed())
         .collect(Collectors.toList());
      projectTenderingVO.setSupplierAmountVOS(supplierAmountVOList);
      return projectTenderingVO;
   }

   @Override
   public ListVO getEvaluation(Long id) {
      String uuid = this.configService.getCompanyConfig().getUUID();
      this.projectTenderingService.setTendering(uuid);
      ProjectTendering projectTendering = this.projectTenderingService.getById(id);
      Preconditions.checkArgument(projectTendering != null, "招标项目存在");
      Integer round = this.biddingRoundsService.getOne(((QueryWrapper)new QueryWrapper().eq("project_id", id)).select("max(round) as round")).getRound();
      if (!projectTendering.getProjectProgress().equals(ProjectProgressEnum.NOT_START.getType())) {
         return null;
      }

      List<OfferRoundDetailVO> evaluationDetails = this.projectTenderingSupplierService.getEvaluationDetails(id, round);
      if (round > 1) {
         Map<Long, List<DetailVO>> evaluationMap = this.projectTenderingSupplierService
            .getEvaluationDetails(id, round - 1)
            .stream()
            .collect(Collectors.toMap(OfferRoundDetailVO::getProjectSubjectId, OfferRoundDetailVO::getDetailVOList));
         evaluationDetails.forEach(
            e -> {
               Map<Long, DetailVO> detailVOMap = evaluationMap.get(e.getProjectSubjectId())
                  .stream()
                  .collect(Collectors.toMap(DetailVO::getSupplierId, DetailVO -> (DetailVO)DetailVO));

               for (DetailVO detailVO : e.getDetailVOList()) {
                  DetailVO detailVO1 = detailVOMap.get(detailVO.getSupplierId());
                  if (detailVO.getBidAmount() != null) {
                     detailVO.setPreviousRoundUnitPrice(detailVO1.getUnitPrice());
                     detailVO.setPreviousRoundBidAmount(detailVO1.getBidAmount());
                     BigDecimal subtract = detailVO.getBidAmount().subtract(detailVO1.getBidAmount() == null ? new BigDecimal("0") : detailVO1.getBidAmount());
                     detailVO.setContrastBidAmount(subtract);
                  }
               }
            }
         );
      }

      evaluationDetails.forEach(e -> {
         List<DetailVO> detailVOList = e.getDetailVOList();
         List<BigDecimal> bigDecimalList = detailVOList.stream().map(DetailVO::getBidAmount).collect(Collectors.toList());
         bigDecimalList.removeAll(Collections.singleton(null));
         if (CollectionUtils.isNotEmpty(bigDecimalList)) {
            BigDecimal max = Collections.max(bigDecimalList);
            BigDecimal min = Collections.min(bigDecimalList);

            for (DetailVO detailVO : detailVOList) {
               if (detailVO.getBidAmount() != null) {
                  if (detailVO.getBidAmount().compareTo(max) == 0) {
                     detailVO.setExtremeValue(1);
                  }

                  if (detailVO.getBidAmount().compareTo(min) == 0) {
                     detailVO.setExtremeValue(0);
                  }
               }
            }
         }
      });
      List<Long> supplierList = evaluationDetails.get(0).getDetailVOList().stream().map(DetailVO::getSupplierId).collect(Collectors.toList());
      List<OfferRounds> offerRounds = this.offerRoundsService
         .list(
            (Wrapper<OfferRounds>)((new LambdaQueryWrapper<OfferRounds>().eq(OfferRounds::getProjectTenderingId, id))
                  .eq(OfferRounds::getOfferRound, round))
               .in(OfferRounds::getSupplierId, supplierList)
         );
      List<DetailVO> collect = new ArrayList<>();
      offerRounds.forEach(e -> collect.add(DetailVO.builder().unitPrice(e.getBidGrossAmount()).supplierId(e.getSupplierId()).build()));
      evaluationDetails.add(OfferRoundDetailVO.builder().subjectNames("合计").detailVOList(collect).build());
      return new ListVO<>(evaluationDetails);
   }

   @Override
   public void projectDetailExport(Long id, HttpServletResponse response) throws IOException {
      ProjectTendering projectTendering = this.projectTenderingService.getById(id);
      Preconditions.checkArgument(projectTendering != null, "该招采项目不存在");
      Map<String, Object> map = this.getProjectBasic(id, projectTendering);
      if (!projectTendering.getBiddingType().equals(BiddingTypeEnum.ENQUIRY.getType())) {
         TenderNoticeVO tenderNoticeVO = JSON.parseObject(projectTendering.getTenderValue(), TenderNoticeVO.class);
         Map<String, Object> tenderNoticeVOMap = BeanUtil.beanToMap(tenderNoticeVO);
         map.putAll(tenderNoticeVOMap);
      }

      String tempFileName = "BiddingBasicInformation";
      String resourcePath = "files/template/biding/BiddingBasicInformation.xlsx";
      String exportFileName = "招采项目基础表.xlsx";
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = resource.getInputStream();
      File file = File.createTempFile(tempFileName, "xlsx");
      FileUtil.copyInputStreamToFile(inputStream, file);
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
   }

   @Override
   public void projectExport(Long id, HttpServletResponse response) throws IOException {
      ProjectTendering projectTendering = this.projectTenderingService.getById(id);
      Preconditions.checkArgument(projectTendering != null, "该招采项目不存在");
      Integer roundMax = this.biddingRoundsService.getOne(((QueryWrapper)new QueryWrapper().eq("project_id", id)).select("max(round) as round")).getRound();
      BiddingRounds biddingRounds = this.biddingRoundsService
         .getOne(
            (Wrapper<BiddingRounds>)(new LambdaQueryWrapper<BiddingRounds>().eq(BiddingRounds::getRound, roundMax)).eq(BiddingRounds::getProjectId, id)
         );
      Map<String, Object> map = this.getProjectBasic(id, projectTendering);
      List<Map<String, Object>> supplierList = new ArrayList<>();
      int sid = 1;

      for (TenderingSupplierVO supplier : this.projectTenderingSupplierService.getSupplierByProjectId(id, null)) {
         Map<String, Object> sMap = BeanUtil.beanToMap(supplier);
         sMap.put("id", sid++);
         sMap.put("bidStatus", RespondEnums.getNameByType(supplier.getBidStatus()));
         if (supplier.getBiddingTime() != null) {
            sMap.put("biddingTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(supplier.getBiddingTime()));
         }

         supplierList.add(sMap);
      }

      map.put("supplierList", supplierList);
      List<OfferRoundDetailVO> evaluationDetailsAndRound = this.projectTenderingSupplierService.getEvaluationDetailsAndRound(id);
      List<Map<String, Object>> roundList = new ArrayList<>();
      Map<Integer, List<OfferRoundDetailVO>> integerListMap = evaluationDetailsAndRound.stream()
         .collect(
            Collectors.toMap(OfferRoundDetailVO::getOfferRound, e -> new ArrayList<>(Collections.singleton((OfferRoundDetailVO)e)), (oldList, newList) -> {
               oldList.addAll(newList);
               return oldList;
            })
         );
      integerListMap.forEach((round, offerRoundDetailVOS) -> {
         List<Map<String, Object>> subjectList = new ArrayList<>();
         int subjectId = 1;
         Map<String, Object> roundMap = new HashMap<>();
         roundMap.put("round", "第" + NumberUtils.convert(round) + "轮");

         for (OfferRoundDetailVO roundDetailVO : offerRoundDetailVOS) {
            List<Map<String, Object>> offerList = new ArrayList<>();
            Map<String, Object> subjectMap = BeanUtil.beanToMap(roundDetailVO);
            subjectMap.put("id", subjectId++);

            for (DetailVO detailVO : roundDetailVO.getDetailVOList()) {
               Map<String, Object> offerMap = BeanUtil.beanToMap(detailVO);
               if (round.equals(roundMax) && biddingRounds.getBidOpeningTime().getTime() > System.currentTimeMillis()) {
                  offerMap.put("unitPrice", "已隐藏");
                  offerMap.put("bidAmount", "已隐藏");
               }

               if (detailVO.getBidAmount() == null) {
                  offerMap.put("bidAmount", "未报价");
               }

               if (detailVO.getUnitPrice() == null) {
                  offerMap.put("unitPrice", "未报价");
               }

               offerList.add(offerMap);
            }

            subjectMap.put("offerList", offerList);
            subjectList.add(subjectMap);
         }

         roundMap.put("subjectList", subjectList);
         roundList.add(roundMap);
      });
      map.put("roundList", roundList);
      int wid = 1;
      List<Map<String, Object>> winBidList = new ArrayList<>();
      List<SubjectProjectVO> winBidding = this.projectTenderingSupplierService.getWinBidding(id);

      for (SubjectProjectVO subjectProjectVO : winBidding) {
         Map<String, Object> winMap = BeanUtil.beanToMap(subjectProjectVO);
         winMap.put("id", wid++);
         winBidList.add(winMap);
      }

      BigDecimal bidGrossAmount = winBidding.stream()
         .filter(e -> e.getBidAmount() != null)
         .map(SubjectProjectVO::getBidAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      map.put("winBidList", winBidList);
      map.put("bidGrossAmount", bidGrossAmount);
      String tempFileName = "BidTenderOffer";
      String resourcePath = "files/template/biding/BidTenderOffer.xlsx";
      String exportFileName = "招采项目详情表.xlsx";
      org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
      InputStream inputStream = resource.getInputStream();
      File file = File.createTempFile(tempFileName, "xlsx");
      FileUtil.copyInputStreamToFile(inputStream, file);
      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      params.setColForEach(true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
   }

   private Map<String, Object> getProjectBasic(Long id, ProjectTendering projectTendering) {
      ProjectTenderingVO projectTenderingVO = this.projectTenderingService.selectByProjectId(id);
      String subjectName = this.subjectService
         .getOne((Wrapper<Subject>)new LambdaQueryWrapper<Subject>().eq(Subject::getId, projectTenderingVO.getProjectType()))
         .getName();
      String supplierNameList = null;
      if (!projectTendering.getBiddingType().equals(BiddingTypeEnum.OPEN_TENDERING.getType())) {
         List<String> supplierNames = this.projectTenderingSupplierService
            .getSupplierByProjectId(id, null)
            .stream()
            .map(TenderingSupplierVO::getSupplierName)
            .collect(Collectors.toList());
         supplierNameList = StringUtils.join(supplierNames, '\\');
      }

      Map<String, Object> map = BeanUtil.beanToMap(projectTenderingVO);
      map.put("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(projectTenderingVO.getCreateTime()));
      map.put("releaseDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(projectTenderingVO.getReleaseDate()));
      map.put("bidOpeningTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(projectTenderingVO.getBidOpeningTime()));
      map.put("bidDeadline", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(projectTenderingVO.getBidDeadline()));
      map.put("deliveryTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(projectTenderingVO.getDeliveryTime()));
      map.put("projectTypeName", subjectName);
      map.put("biddingTypeName", BiddingTypeEnum.getNameByType(projectTenderingVO.getBiddingType()));
      map.put("invoiceTypeName", InvoiceTypeEnum.getNameByType(projectTenderingVO.getInvoiceType()));
      map.put("deliveryTypeName", OrderTransportTypeEnum.getNameByType(projectTenderingVO.getDeliveryType()));
      map.put("cashDepositProject", projectTenderingVO.getCashDeposit());
      map.put("supplierName", supplierNameList);
      String round = "(第" + NumberUtils.convert(projectTenderingVO.getRound()) + "轮)";
      map.put("progressName", ProjectProgressEnum.getNameByType(projectTenderingVO.getProjectProgress()) + round);
      List<Map<String, Object>> mapList = new ArrayList<>();
      int tid = 1;

      for (ProjectSubject projectSubject : this.projectSubjectService
         .list((Wrapper<ProjectSubject>)new LambdaQueryWrapper<ProjectSubject>().eq(ProjectSubject::getProjectId, id))) {
         String name = this.subjectService.getOne((Wrapper<Subject>)new LambdaQueryWrapper<Subject>().eq(Subject::getId, projectSubject.getSubjectId())).getName();
         Map<String, Object> summaryMap = BeanUtil.beanToMap(projectSubject);
         summaryMap.put("id", tid++);
         summaryMap.put("subjectName", name);
         mapList.add(summaryMap);
      }

      map.put("mapList", mapList);
      return map;
   }

   private void setWeedOuts(
      List<CommonVO> weedOuts,
      Map<Long, ProjectTenderingSupplier> tenderingSupplierMap,
      Map<Long, SupplierSubject> supplierSubjectMap,
      Map<Long, OfferRoundDetail> offerRoundDetailMap
   ) {
      weedOuts.forEach(out -> {
         ProjectTenderingSupplier tenderingSupplier = tenderingSupplierMap.get(out.getSupplierId());
         Preconditions.checkArgument(tenderingSupplier != null, "该供应商不存在");
         SupplierSubject supplierSubjectOut = supplierSubjectMap.get(out.getSupplierId());
         supplierSubjectOut.setIsFollow(CommonEnum.FALSE.getType());
         supplierSubjectOut.setOfferDetailId(out.getOfferDetailId());
         if (out.getOfferDetailId() != null) {
            OfferRoundDetail offerRoundDetailOut = offerRoundDetailMap.get(out.getOfferDetailId());
            offerRoundDetailOut.setIsFollow(CommonEnum.FALSE.getType());
            this.offerRoundDetailService.updateById(offerRoundDetailOut);
         }

         this.supplierSubjectService.updateById(supplierSubjectOut);
      });
   }
}
