package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ClassificationCheckDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.WmsApproveOpinionDTOParam;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.biz.SectionSteelSpecService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialLabelPrintTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpec;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpecStandardDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Standard;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplus;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplusDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SectionSteelSpecDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsSurplusDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsSurplusDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportSurplusDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SurplusDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.SurplusDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SectionSteelSpecStandardDetailService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.StandardService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsSurplusDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsSurplusService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import com.hzchum.scim.wms.core.mapper.wmsUse.ScrapMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsSurplusMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsSurplusServiceImpl extends ServiceImpl<WmsSurplusMapper, WmsSurplus> implements WmsSurplusService {
   private static final BigDecimal THOUSAND = new BigDecimal("1000");
   private static final BigDecimal HUNDRED = new BigDecimal("100");
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private ClassificationService classificationService;
   @Resource
   private WmsSurplusDetailService wmsSurplusDetailService;
   @Resource
   private ScrapMapper scrapMapper;
   @Resource
   private MaterialInventoryService materialInventoryService;
   @Resource
   private BasicConfigService basicConfigService;
   @Resource
   private WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   private NumberConfigService numberConfigService;
   @Resource
   private WarningService warningService;
   @Resource
   private PrintService printService;
   @Resource
   private SpecificationService specificationService;
   @Resource
   private MeasureService measureService;
   @Resource
   private QueryUtilImpl queryUtil;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private StandardService standardService;
   @Resource
   private SectionSteelSpecService sectionSteelSpecService;
   @Resource
   private SectionSteelSpecStandardDetailService sectionSteelSpecStandardDetailService;
   @Resource
   private WmsUtil wmsUtil;

   @Transactional
   @Override
   public Boolean saveSurplusToList(SurplusDTOParam param) {
      WmsSurplus wmsSurplus = this.saveSurplus(param, false);
      this.updateById(wmsSurplus);
      return Boolean.TRUE;
   }

   @Override
   public WmsSurplusDTO getByCurrentUser() {
      WmsSurplus wmsSurplus = this.getOne(
         (Wrapper<WmsSurplus>)(Wrappers.<WmsSurplus>lambdaQuery().eq(WmsSurplus::getApplicantId, UserUtil.getCurrentUserId()))
            .eq(WmsSurplus::getReviewStatus, OutboundStatusEnum.UN_REVIEWED.getType())
      );
      if (wmsSurplus == null) {
         return null;
      }

      WmsSurplusDTO surplusDTO = BeanUtil.copy(wmsSurplus, WmsSurplusDTO.class);
      List<WmsSurplusDetail> surplusDetailList = this.wmsSurplusDetailService
         .list(Wrappers.lambdaQuery(WmsSurplusDetail.class).eq(WmsSurplusDetail::getSurplusId, wmsSurplus.getId()));
      List<WmsSurplusDetailDTO> detailDTOList = this.convertToDetailDTOList(surplusDetailList);
      surplusDTO.setDetailDTOList(detailDTOList);
      return surplusDTO;
   }

   @Override
   public int getByCurrentUserNumber() {
      WmsSurplus wmsSurplus = this.getOne(
         (Wrapper<WmsSurplus>)(Wrappers.<WmsSurplus>lambdaQuery().eq(WmsSurplus::getApplicantId, UserUtil.getCurrentUserId()))
            .eq(WmsSurplus::getReviewStatus, OutboundStatusEnum.UN_REVIEWED.getType())
      );
      return wmsSurplus != null
         ? this.wmsSurplusDetailService.count(Wrappers.lambdaQuery(WmsSurplusDetail.class).eq(WmsSurplusDetail::getSurplusId, wmsSurplus.getId()))
         : 0;
   }

   @Override
   public Boolean deleteDetailByList(List<Long> ids) {
      WmsSurplusDTO surplusDTO = this.getByCurrentUser();
      Preconditions.checkArgument(surplusDTO != null, "盘盈单据已不存在！");
      List<WmsSurplusDetailDTO> detailDTOList = surplusDTO.getDetailDTOList();
      Preconditions.checkArgument(detailDTOList.stream().map(WmsSurplusDetail::getId).collect(Collectors.toList()).containsAll(ids), "盘盈详情已不存在！");
      this.wmsSurplusDetailService.removeByIds(ids);
      WmsSurplusDTO upadtedDTO = this.getByCurrentUser();
      if (upadtedDTO != null) {
         List<WmsSurplusDetailDTO> upadtedDTOList = upadtedDTO.getDetailDTOList();
         Integer basicClass = 0;
         String projectIds = null;
         String classifyIds = null;
         if (CollectionUtil.isNotEmpty(upadtedDTOList)) {
            for (WmsSurplusDetailDTO detailDTO : upadtedDTOList) {
               if (detailDTO.getProjectId() != null) {
                  if (StrUtil.isNotBlank(projectIds)) {
                     List<Long> list = CommonUtil.spilt(projectIds, ",");
                     if (!list.contains(detailDTO.getProjectId())) {
                        projectIds = projectIds + "," + detailDTO.getProjectId();
                     }
                  } else {
                     projectIds = detailDTO.getProjectId() + "";
                  }
               }

               if (detailDTO.getClassifyId() != null) {
                  if (StrUtil.isNotBlank(classifyIds)) {
                     List<Long> list = CommonUtil.spilt(classifyIds, ",");
                     if (!list.contains(detailDTO.getClassifyId())) {
                        classifyIds = classifyIds + "," + detailDTO.getClassifyId();
                     }
                  } else {
                     classifyIds = detailDTO.getClassifyId() + "";
                  }
               }

               basicClass = basicClass | detailDTO.getBasicClass();
            }

            this.update(
               null,
               (Wrapper<WmsSurplus>)((((new LambdaUpdateWrapper<WmsSurplus>()
                              .eq(WmsSurplus::getId, upadtedDTO.getId()))
                           .set(BaseEntity::getUpdateTime, LocalDateTime.now()))
                        .set(WmsSurplus::getBasicClass, basicClass))
                     .set(WmsSurplus::getProjectIds, projectIds))
                  .set(WmsSurplus::getClassifyIds, classifyIds)
            );
         } else {
            this.removeById(upadtedDTO.getId());
         }
      }

      return Boolean.TRUE;
   }

   @Override
   public Boolean clearDetailList() {
      WmsSurplus wmsSurplus = this.getOne(
         (Wrapper<WmsSurplus>)(Wrappers.<WmsSurplus>lambdaQuery().eq(WmsSurplus::getApplicantId, UserUtil.getCurrentUserId()))
            .eq(WmsSurplus::getReviewStatus, OutboundStatusEnum.UN_REVIEWED.getType())
      );
      if (wmsSurplus == null) {
         return true;
      }

      this.wmsSurplusDetailService.remove(Wrappers.lambdaQuery(WmsSurplusDetail.class).eq(WmsSurplusDetail::getSurplusId, wmsSurplus.getId()));
      this.removeById(wmsSurplus.getId());
      return true;
   }

   @Transactional
   @Override
   public Boolean submitReview(SurplusDTOParam param) {
      WmsSurplus wmsSurplus = null;
      if (param.getId() != null) {
         wmsSurplus = this.getById(param.getId());
      } else {
         wmsSurplus = this.saveSurplus(param, true);
      }

      Preconditions.checkArgument(wmsSurplus != null, "盘盈单不存在！请刷新重试！");
      this.wmsSurplusDetailService
         .update(
            null,
            (Wrapper<WmsSurplusDetail>)(new LambdaUpdateWrapper<WmsSurplusDetail>().eq(WmsSurplusDetail::getSurplusId, wmsSurplus.getId()))
               .set(BaseEntity::getCreateTime, LocalDateTime.now())
         );
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            wmsSurplus.getId(), wmsSurplus.getApplicationSn(), ApproveProcessTypeEnumV2.WMS_SURPLUS.getType(), null, null, null, false, null, null, null
         );
      wmsSurplus.setApproveRecordIdNow(wmsApproveRecord.getId());
      wmsSurplus.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passedSurplus(wmsSurplus);
         wmsSurplus.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      }

      return this.baseMapper.updateById(wmsSurplus) == 1;
   }

   @Transactional
   @Override
   public Boolean check(WmsApproveOpinionDTOParam param) {
      WmsSurplus surplus = this.getById(param.getDataId());
      Preconditions.checkArgument(surplus != null, "盘盈单不存在!");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(surplus.getReviewStatus()), "盘盈单状态已改变!");
      Preconditions.checkArgument(
         ReviewStatusEnum.REVIEWED.getType().equals(param.getDecision()) || ReviewStatusEnum.RETURNED.getType().equals(param.getDecision()), "审核类型不正确！"
      );
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(param.getApproveRecordId());
      Boolean isEnd = this.wmsApproveRecordService
         .commonApproveStep(param.getDataId(), param.getDecision(), param.getOpinion(), wmsApproveRecord.getSerialNumber(), null);
      Integer approveStatus;
      if (isEnd) {
         if (ReviewStatusEnum.REVIEWED.getType().equals(param.getDecision())) {
            this.passedSurplus(surplus);
         } else {
            this.wmsSurplusDetailService
               .update(
                  null,
                  (Wrapper<WmsSurplusDetail>)((new LambdaUpdateWrapper<WmsSurplusDetail>()
                           .eq(WmsSurplusDetail::getSurplusId, surplus.getId()))
                        .set(WmsSurplusDetail::getReviewStatus, ReviewStatusEnum.RETURNED.getType()))
                     .set(BaseEntity::getUpdateTime, LocalDateTime.now())
               );
         }

         approveStatus = param.getDecision();
      } else {
         approveStatus = ReviewStatusEnum.AUDITING.getType();
      }

      surplus.setReviewStatus(approveStatus);
      this.updateById(surplus);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public boolean cancelApproveDetail(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsSurplus record = this.getById(id);
      Preconditions.checkArgument(record != null, "操作失败！，操作信息已不存在");
      Preconditions.checkArgument(currentUser.getId().equals(record.getApplicantId()), "操作失败！，仅创建人可以进行撤销");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(record.getReviewStatus()), "操作失败！，仅审核中可以撤销申请");
      record.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      if (ObjectUtil.isNotEmpty(record.getApproveRecordIdNow())) {
         this.wmsApproveRecordService.revocation(record.getApproveRecordIdNow());
      }

      this.updateById(record);
      return true;
   }

   private WmsSurplus saveSurplus(SurplusDTOParam param, Boolean submit) {
      WmsSurplus wmsSurplus = this.baseMapper
         .selectOne(
            (Wrapper<WmsSurplus>)(Wrappers.<WmsSurplus>lambdaQuery().eq(WmsSurplus::getApplicantId, UserUtil.getCurrentUserId()))
               .eq(WmsSurplus::getReviewStatus, ReviewStatusEnum.UN_REVIEWED.getType())
         );
      if (wmsSurplus == null || submit) {
         wmsSurplus = WmsSurplus.builder()
            .basicClass(param.getBasicClass())
            .reviewStatus(ReviewStatusEnum.UN_REVIEWED.getType())
            .applicantId(UserUtil.getCurrentUserId())
            .applicantName(UserUtil.getCurrentName())
            .build();
         String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.MANUFACTURES_SURPLUS, this.baseMapper.getCount(LocalDateTime.now()));
         wmsSurplus.setApplicationSn(serviceNumber);
         this.baseMapper.insert(wmsSurplus);
      }

      Integer basicClass = 0;
      new TreeSet();
      Map<Long, Classification> classificationMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(param.getList())) {
         List<ClassificationCheckDTO> classificationCheckDTOS = param.getList()
            .stream()
            .map(d -> cn.hutool.core.bean.BeanUtil.toBean(d, ClassificationCheckDTO.class))
            .collect(Collectors.toList());
         classificationMap = this.classificationService.checkClassification(classificationCheckDTOS, param.getClickTime());
      }

      List<WmsSurplusDetail> saveDetailList = new ArrayList<>();
      List<WmsSurplusDetail> updateDetailList = new ArrayList<>();
      List<WmsSurplusDetail> hasList = this.wmsSurplusDetailService
         .list(Wrappers.lambdaQuery(WmsSurplusDetail.class).eq(WmsSurplusDetail::getSurplusId, wmsSurplus.getId()));

      for (SurplusDetailDTOParam detailParam : param.getList()) {
         Classification classification = classificationMap.get(detailParam.getClassifyId());
         WmsSurplusDetail surplusDetail = BeanUtil.copy(detailParam, WmsSurplusDetail.class);
         surplusDetail.setBoolPartyA(param.getBoolPartyA());
         surplusDetail.setInvoiceType(param.getInvoiceType());
         surplusDetail.setTaxRate(param.getTaxRate());
         surplusDetail.setSurplusId(wmsSurplus.getId());
         surplusDetail.setApplicantName(UserUtil.getCurrentName());
         surplusDetail.setReviewStatus(OutboundStatusEnum.UN_REVIEWED.getType());
         if (BasicClassEnum.checkIsSteel(detailParam.getBasicClass())) {
            Preconditions.checkArgument(detailParam.getMaterialIsWhole() != null, "是否整料余料不能为空！");
         }

         if (!param.getBoolPartyA()) {
            Preconditions.checkArgument(detailParam.getUnitPrice() != null, "物料单价不能为空！");
            Preconditions.checkArgument(detailParam.getAmount() != null, "物料总价不能为空！");
            Preconditions.checkArgument(BigDecimal.ZERO.compareTo(detailParam.getUnitPrice()) <= 0, "物料单价填写有误！");
            Preconditions.checkArgument(BigDecimal.ZERO.compareTo(detailParam.getAmount()) <= 0, "物料总价填写有误！");
            surplusDetail.setUnitPrice(detailParam.getUnitPrice());
            surplusDetail.setUnitPriceNoFreight(detailParam.getUnitPrice());
            surplusDetail.setAmount(detailParam.getAmount());
            surplusDetail.setAmountNoFreight(detailParam.getAmount());
            if (InvoiceTypeEnum.SPECIAL.getType().equals(param.getInvoiceType())) {
               BigDecimal value = param.getTaxRate().divide(HUNDRED).add(BigDecimal.ONE);
               if (surplusDetail.getAmount() != null) {
                  surplusDetail.setAmountExcludingVat(surplusDetail.getAmount().divide(value, 2, RoundingMode.HALF_UP));
                  surplusDetail.setAmountExcludingVatNoFreight(surplusDetail.getAmount().divide(value, 2, RoundingMode.HALF_UP));
                  surplusDetail.setUnitPriceExcludingVat(surplusDetail.getAmountExcludingVat().divide(surplusDetail.getMete(), 12, RoundingMode.HALF_UP));
                  surplusDetail.setUnitPriceExcludingVatNoFreight(
                     surplusDetail.getAmountExcludingVat().divide(surplusDetail.getMete(), 12, RoundingMode.HALF_UP)
                  );
                  surplusDetail.setInputVat(surplusDetail.getAmount().subtract(surplusDetail.getAmountExcludingVat()));
                  surplusDetail.setInputVatNoFreight(surplusDetail.getAmount().subtract(surplusDetail.getAmountExcludingVat()));
               }
            } else {
               surplusDetail.setAmountExcludingVat(surplusDetail.getAmount());
               surplusDetail.setAmountExcludingVatNoFreight(surplusDetail.getAmount());
               surplusDetail.setUnitPriceExcludingVat(surplusDetail.getUnitPrice());
               surplusDetail.setUnitPriceExcludingVatNoFreight(surplusDetail.getUnitPrice());
            }
         }

         if (param.getBoolPartyA()) {
            Preconditions.checkArgument(detailParam.getProjectId() != null, "甲供物料项目不能为空！");
            surplusDetail.setAmount(BigDecimal.ZERO);
            surplusDetail.setAmountNoFreight(BigDecimal.ZERO);
            surplusDetail.setAmountExcludingVat(BigDecimal.ZERO);
            surplusDetail.setAmountExcludingVatNoFreight(BigDecimal.ZERO);
            surplusDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
            surplusDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            surplusDetail.setUnitPrice(BigDecimal.ZERO);
            surplusDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
         }

         StringBuilder specification = new StringBuilder();
         if (BasicClassEnum.SECTION_STEEL.getType().equals(detailParam.getBasicClass())) {
            String sn = "";
            String specCode = "";
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(detailParam.getSectionSteelSpec()), "该型材未配置国标规格");
            SectionSteelSpec sectionSteelSpec = this.sectionSteelSpecService
               .getOne(
                  (Wrapper<SectionSteelSpec>)(Wrappers.<SectionSteelSpec>lambdaQuery().eq(SectionSteelSpec::getClassificationId, classification.getId()))
                     .eq(SectionSteelSpec::getSpecification, detailParam.getSectionSteelSpec())
               );
            Preconditions.checkArgument(sectionSteelSpec != null, "当前型材库规格为[" + detailParam.getSectionSteelSpec() + "]的型材不存在.");
            Preconditions.checkArgument(sectionSteelSpec.getStatus(), "当前型材库规格为[" + detailParam.getSectionSteelSpec() + "]的型材已禁用.");
            SectionSteelSpecStandardDetail standardDetail = this.sectionSteelSpecStandardDetailService
               .getOne(
                  (Wrapper<SectionSteelSpecStandardDetail>)((Wrappers.<SectionSteelSpecStandardDetail>lambdaQuery()
                           .eq(SectionSteelSpecStandardDetail::getSpecId, sectionSteelSpec.getId()))
                        .eq(SectionSteelSpecStandardDetail::getStandardId, detailParam.getStandardId()))
                     .eq(SectionSteelSpecStandardDetail::getSectionSteelId, sectionSteelSpec.getSectionSteelId())
               );
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(standardDetail), "入库失败," + classification.getName() + "未查询到型材规格国标重量");
            Preconditions.checkArgument(standardDetail.getUnitNet() != null && standardDetail.getUnitNet().compareTo(BigDecimal.ZERO) > 0, "入库失败,当前型材规格未配置国标重量");
            Standard standard = this.standardService.getById(standardDetail.getStandardId());
            sn = standard.getCode() + "-" + standardDetail.getCode();
            SectionSteelSpecDTO weightByClassifyId = this.sectionSteelSpecService
               .getWeightByClassifyId(detailParam.getClassifyId(), detailParam.getSectionSteelSpec());
            BigDecimal oneMete = CommonUtil.getTheoryMete(
               null, surplusDetail.getLength(), null, null, weightByClassifyId.getDetail().getUnitNet(), surplusDetail.getClassifyId()
            );
            BigDecimal theoryWeight = oneMete.multiply(detailParam.getQuantity()).setScale(0, RoundingMode.HALF_UP);
            surplusDetail.setSectionSteelWeight(weightByClassifyId.getDetail().getUnitNet());
            surplusDetail.setOneTheoryWeight(oneMete);
            surplusDetail.setTheoryWeight(theoryWeight);
            surplusDetail.setStandardId(standard.getId());
            surplusDetail.setStandardName(standard.getName());
            surplusDetail.setSectionSteelSpecId(sectionSteelSpec.getId());
            surplusDetail.setSectionSteelSpec(sectionSteelSpec.getSpecification());
            surplusDetail.setDoNotSectionSteelSpec(detailParam.getDoNotSectionSteelSpec());
            if (ObjectUtil.isNotEmpty(detailParam.getDoNotSectionSteelSpec())) {
               Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getDoNotSectionSteelSpec());
               specCode = map.get("code");
               specification.append(map.get("ids"));
            }

            surplusDetail.setSerialNumber(classification.getSerialNumber() + "-" + sn + specCode);
         } else if (BasicClassEnum.STEEL_PLATE.getType().equals(detailParam.getBasicClass())) {
            Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
            String specCode = map.get("code");
            specification.append(map.get("ids"));
            surplusDetail.setSerialNumber(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
            surplusDetail.setTheoryThickness(detailParam.getThickness().setScale(0, RoundingMode.HALF_UP));
            BigDecimal oneTheoryMete = CommonUtil.getTheoryMete(
               classification.getName(), surplusDetail.getLength(), surplusDetail.getWidth(), surplusDetail.getThickness(), null, surplusDetail.getClassifyId()
            );
            BigDecimal theoryWeight = oneTheoryMete.multiply(
                  BasicClassEnum.COLOR_ROLL.getType().equals(detailParam.getBasicClass()) ? BigDecimal.ONE : detailParam.getQuantity()
               )
               .setScale(0, RoundingMode.HALF_UP);
            surplusDetail.setOneTheoryWeight(oneTheoryMete);
            surplusDetail.setTheoryWeight(theoryWeight);
         } else if (BasicClassEnum.COLOR_ROLL.getType().equals(detailParam.getBasicClass())) {
            Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
            String specCode = map.get("code");
            specification.append(map.get("ids"));
            surplusDetail.setSerialNumber(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
            BigDecimal inboundMete = detailParam.getMete().divide(THOUSAND, 0, RoundingMode.HALF_UP);
            surplusDetail.setOneTheoryWeight(inboundMete);
         } else if (BasicClassEnum.checkNotSteel(detailParam.getBasicClass())) {
            Map<String, String> map = this.specificationService.checkClassifySpec(detailParam.getClassifyId(), detailParam.getSpecification());
            String specCode = map.get("code");
            specification.append(map.get("ids"));
            surplusDetail.setSerialNumber(classification.getSerialNumber() + (StrUtil.isNotBlank(specCode) ? "-" + specCode : ""));
            surplusDetail.setUnitNet(
               detailParam.getQuantity() != null ? detailParam.getMete().divide(detailParam.getQuantity(), 8, RoundingMode.HALF_UP) : BigDecimal.ONE
            );
         }

         Measure measure1 = this.getMeasure(classification.getId());
         if (measure1.getOutboundUnitType().equals(MeasureTypeEnum.MEASURE.getType())) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(surplusDetail.getQuantity()), classification.getName() + "为计量方式，但未提交数量，请检查该科目计量配置！！！");
         }

         if (measure1.getOutboundUnitType().equals(MeasureTypeEnum.ACCOUNTING.getType())) {
            Preconditions.checkArgument(ObjectUtil.isEmpty(surplusDetail.getQuantity()), classification.getName() + "为核算方式，但提交了数量，请检查该科目计量配置！！！");
         }

         surplusDetail.setSpecificationIds(specification.toString());
         if (StrUtil.isEmpty(surplusDetail.getSpecification())) {
            surplusDetail.setSpecification(null);
         }

         Measure measure = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, detailParam.getClassifyId()));
         surplusDetail.setMeasureUnit(measure.getMeasureUnit());
         surplusDetail.setMeasurePrecision(measure.getMeasurePrecision());
         surplusDetail.setAccountingUnit(measure.getAccountingUnit());
         surplusDetail.setAccountingPrecision(measure.getAccountingPrecision());
         if (!submit) {
            WmsSurplusDetail hasSurplusDetail = null;

            for (WmsSurplusDetail hasDetail : hasList) {
               if (hasDetail.equals(surplusDetail)) {
                  hasSurplusDetail = hasDetail;
                  break;
               }
            }

            if (hasSurplusDetail != null) {
               hasSurplusDetail.setQuantity(hasSurplusDetail.getQuantity().add(surplusDetail.getQuantity()));
               hasSurplusDetail.setMete(hasSurplusDetail.getMete().add(surplusDetail.getMete()));
               hasSurplusDetail.setAmount(hasSurplusDetail.getAmount().add(surplusDetail.getAmount()));
               hasSurplusDetail.setAmountNoFreight(hasSurplusDetail.getAmountNoFreight().add(surplusDetail.getAmountNoFreight()));
               hasSurplusDetail.setAmountExcludingVat(hasSurplusDetail.getAmountExcludingVat().add(surplusDetail.getAmountExcludingVat()));
               hasSurplusDetail.setAmountExcludingVatNoFreight(
                  hasSurplusDetail.getAmountExcludingVatNoFreight().add(surplusDetail.getAmountExcludingVatNoFreight())
               );
               updateDetailList.add(hasSurplusDetail);
               continue;
            }
         }

         if (surplusDetail.getProjectId() != null) {
            if (StrUtil.isNotBlank(wmsSurplus.getProjectIds())) {
               List<Long> list = CommonUtil.spilt(wmsSurplus.getProjectIds(), ",");
               if (!list.contains(surplusDetail.getProjectId())) {
                  wmsSurplus.setProjectIds(wmsSurplus.getProjectIds() + "," + surplusDetail.getProjectId());
               }
            } else {
               wmsSurplus.setProjectIds(surplusDetail.getProjectId() + "");
            }
         }

         if (surplusDetail.getClassifyId() != null) {
            if (StrUtil.isNotBlank(wmsSurplus.getClassifyIds())) {
               List<Long> list = CommonUtil.spilt(wmsSurplus.getClassifyIds(), ",");
               if (!list.contains(surplusDetail.getClassifyId())) {
                  wmsSurplus.setClassifyIds(wmsSurplus.getClassifyIds() + "," + surplusDetail.getClassifyId());
               }
            } else {
               wmsSurplus.setClassifyIds(surplusDetail.getClassifyId() + "");
            }
         }

         basicClass = basicClass | detailParam.getBasicClass();
         saveDetailList.add(surplusDetail);
      }

      if (CollectionUtil.isNotEmpty(saveDetailList)) {
         this.wmsSurplusDetailService.saveBatch(saveDetailList);
      }

      if (CollectionUtil.isNotEmpty(updateDetailList)) {
         this.wmsSurplusDetailService.updateBatchById(updateDetailList);
      }

      wmsSurplus.setBasicClass(basicClass);
      return wmsSurplus;
   }

   private void passedSurplus(WmsSurplus wmsSurplus) {
      wmsSurplus.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      wmsSurplus.setReviewTime(LocalDateTime.now());
      wmsSurplus.setReviewerId(UserUtil.getCurrentUserId());
      wmsSurplus.setReviewerName(UserUtil.getCurrentName());
      BigDecimal amount = BigDecimal.ZERO;
      BigDecimal amountNoFreight = BigDecimal.ZERO;
      BigDecimal amountExcludingVAT = BigDecimal.ZERO;
      BigDecimal amountExcludingVATNoFreight = BigDecimal.ZERO;
      List<WmsSurplusDetail> surplusDetailList = this.wmsSurplusDetailService
         .list((Wrapper<WmsSurplusDetail>)new LambdaUpdateWrapper<WmsSurplusDetail>().eq(WmsSurplusDetail::getSurplusId, wmsSurplus.getId()));
      Print print = null;
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.MANUFACTURES_SURPLUS, this.baseMapper.getCount(LocalDateTime.now()));
      wmsSurplus.setSerialNumber(serviceNumber);

      for (WmsSurplusDetail surplusDetail : surplusDetailList) {
         WasteConfig scrapDefinitionConf = this.basicConfigService.getSteelScrapDefinitionConf();
         boolean isScrap = false;
         if (BasicClassEnum.STEEL_PLATE.getType().equals(surplusDetail.getBasicClass())) {
            isScrap = surplusDetail.getLength().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0
               || surplusDetail.getWidth().compareTo(scrapDefinitionConf.getSteelPlateShortestSideMinLength()) <= 0;
         }

         if (BasicClassEnum.SECTION_STEEL.getType().equals(surplusDetail.getBasicClass())) {
            isScrap = surplusDetail.getLength().compareTo(scrapDefinitionConf.getSectionSteelMinLength()) <= 0;
         }

         if (BasicClassEnum.COLOR_ROLL.getType().equals(surplusDetail.getBasicClass())) {
            isScrap = surplusDetail.getQuantity().compareTo(scrapDefinitionConf.getSteelCoilMinLength()) <= 0;
         }

         if (isScrap) {
            Scrap scrap = BeanUtil.copy(surplusDetail, Scrap.class, "createTime");
            scrap.setWarehouseType(surplusDetail.getProjectId() != null ? 2 : 1);
            scrap.setAmount(surplusDetail.getAmount());
            scrap.setAmountExcludingVat(surplusDetail.getAmountExcludingVat());
            scrap.setAmountNoFreight(surplusDetail.getAmountNoFreight());
            scrap.setAmountExcludingVatNoFreight(surplusDetail.getAmountExcludingVatNoFreight());
            scrap.setCreateTime(LocalDateTime.now());
            this.scrapMapper.insert(scrap);
         } else {
            MaterialInventory materialInventory = null;
            if (!BasicClassEnum.COLOR_ROLL.getType().equals(surplusDetail.getBasicClass())) {
               materialInventory = this.materialInventoryService.getBySurplusDetail(surplusDetail);
            }

            MaterialInventory newMaterialInventory = this.setMaterialInventoryV2(surplusDetail, materialInventory);
            newMaterialInventory.setUseStatus(false);
            if (materialInventory != null) {
               newMaterialInventory.setUpdateTime(LocalDateTime.now());
               this.materialInventoryService.updateById(newMaterialInventory);
            } else {
               this.materialInventoryService.save(newMaterialInventory);
            }

            this.wmsUtil
               .setInventoryUse(
                  newMaterialInventory,
                  surplusDetail.getQuantity(),
                  surplusDetail.getMete(),
                  ReceiptTypeEnum.SURPLUS,
                  wmsSurplus.getId(),
                  wmsSurplus.getSerialNumber(),
                  1,
                  true
               );
            InboundDetail inboundDetail = BeanUtil.copy(surplusDetail, InboundDetail.class);
            inboundDetail.setRealTime(LocalDateTime.now());
            this.weightedAveragePriceService
               .createMonthWAP(inboundDetail, newMaterialInventory, wmsSurplus.getId(), wmsSurplus.getSerialNumber(), ReceiptTypeEnum.SURPLUS.getType());
            this.warningService.updateStatus(newMaterialInventory, 1);
         }

         amount = amount.add(surplusDetail.getAmount());
         amountNoFreight = amountNoFreight.add(surplusDetail.getAmountNoFreight());
         amountExcludingVAT = amountExcludingVAT.add(surplusDetail.getAmountExcludingVat());
         amountExcludingVATNoFreight = amountExcludingVATNoFreight.add(surplusDetail.getAmountExcludingVatNoFreight());
         surplusDetail.setInboundTime(LocalDateTime.now());
         surplusDetail.setReviewerId(UserUtil.getCurrentUserId());
         surplusDetail.setReviewerName(UserUtil.getCurrentName());
         surplusDetail.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         surplusDetail.setSurplusSerialNumber(serviceNumber);
         print = this.setBarcode(wmsSurplus, surplusDetail, print);
         this.wmsSurplusDetailService.updateById(surplusDetail);
      }

      wmsSurplus.setAmount(amount);
      wmsSurplus.setAmountNoFreight(amountNoFreight);
      wmsSurplus.setAmountExcludingVat(amountExcludingVAT);
      wmsSurplus.setAmountExcludingVatNoFreight(amountExcludingVATNoFreight);
      this.updateById(wmsSurplus);
      if (print != null) {
         print.setReceiptReviewer(wmsSurplus.getReviewerName());
         print.setReceiptReviewTime(wmsSurplus.getReviewTime());
         print.setProjectIds(wmsSurplus.getProjectIds());
         print.setContainBasicClass(wmsSurplus.getBasicClass());
         this.printService.updateById(print);
      }
   }

   private MaterialInventory setMaterialInventoryV2(WmsSurplusDetail surplusDetail, MaterialInventory materialInventory) {
      if (materialInventory == null) {
         MaterialInventory mi = BeanUtil.copy(surplusDetail, MaterialInventory.class, "createTime");
         if (mi.getProjectId() != null) {
            mi.setWarehouseType(2);
         } else {
            mi.setWarehouseType(1);
         }

         mi.setSerialNumber(surplusDetail.getSerialNumber());
         mi.setMaterialIsWhole(surplusDetail.getMaterialIsWhole());
         mi.setInventoryStartTime(LocalDateTime.now());
         if (BasicClassEnum.SECTION_STEEL.getType().equals(mi.getBasicClass())) {
            String[] split = mi.getSpecification().split(" \\* ");
            if (split.length > 1 && StrUtil.isNotBlank(split[1])) {
               String spec = this.specificationService.getJoinSpec(surplusDetail.getClassifyId(), surplusDetail.getDoNotSectionSteelSpec());
               if (StrUtil.isNotBlank(spec)) {
                  mi.setWeightedAverageSpec(split[0] + "*" + spec);
               } else {
                  mi.setWeightedAverageSpec(split[0]);
               }
            } else {
               mi.setWeightedAverageSpec(split[0]);
            }
         } else if (StrUtil.isNotBlank(surplusDetail.getSpecification())) {
            String spec = this.specificationService.getJoinSpec(surplusDetail.getClassifyId(), surplusDetail.getSpecification());
            mi.setWeightedAverageSpec(spec);
         }

         return mi;
      } else {
         if (surplusDetail.getQuantity() != null) {
            materialInventory.setQuantity(materialInventory.getQuantity().add(surplusDetail.getQuantity()));
         }

         materialInventory.setMete(materialInventory.getMete().add(surplusDetail.getMete()));
         materialInventory.setInventoryEndTime(LocalDateTime.now());
         return materialInventory;
      }
   }

   @Override
   public PageVO<WmsSurplusDTO> getWmsSurplus(QueryReportSurplusDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<WmsSurplusDTO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<WmsSurplus> list = this.baseMapper.getSurplusList(param);
      List<WmsSurplusDTO> listDto = list.stream()
         .map(
            e -> {
               WmsSurplusDTO dto = BeanUtil.copy(e, WmsSurplusDTO.class);
               if (StrUtil.isNotBlank(e.getProjectIds())) {
                  dto.setProjects(
                     this.projectService
                        .listByIds(e.getProjectIds())
                        .stream()
                        .map(pro -> BeanUtil.copy(pro, ProjectInfoDTO.class))
                        .collect(Collectors.toList())
                  );
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(page, listDto);
   }

   @Override
   public WmsSurplusDTO getSurplusById(Long id) {
      WmsSurplus surplus = this.getById(id);
      Preconditions.checkArgument(surplus != null, "单据不存在");
      WmsSurplusDTO surplusDTO = BeanUtil.copy(surplus, WmsSurplusDTO.class);
      List<WmsSurplusDetail> surplusDetailList = this.wmsSurplusDetailService
         .list(Wrappers.lambdaQuery(WmsSurplusDetail.class).eq(WmsSurplusDetail::getSurplusId, surplus.getId()));
      List<WmsSurplusDetailDTO> surplusDetailDTOList = this.convertToDetailDTOList(surplusDetailList);
      surplusDTO.setDetailDTOList(surplusDetailDTOList);
      return surplusDTO;
   }

   public List<WmsSurplusDetailDTO> convertToDetailDTOList(List<WmsSurplusDetail> surplusDetailList) {
      if (CollectionUtil.isEmpty(surplusDetailList)) {
         return new ArrayList<>();
      }

      Map<Long, Warehouse> warehouseMap = this.queryUtil.getWarehouseMap(null);
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
      Map<Long, Supplier> supplierMap = this.queryUtil.getSupplierMap(null);
      return surplusDetailList.stream()
         .map(
            e -> {
               WmsSurplusDetailDTO dto = BeanUtil.copy(e, WmsSurplusDetailDTO.class);
               dto.setInputVAT(e.getInputVat());
               dto.setAmountExcludingVAT(e.getAmountExcludingVat());
               dto.setUnitPriceExcludingVAT(e.getUnitPriceExcludingVat());
               if (e.getWarehouseId() != null) {
                  Warehouse warehouse = warehouseMap.get(e.getWarehouseId());
                  dto.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
               }

               if (e.getProjectId() != null) {
                  ContractProject project = projectMap.get(e.getProjectId());
                  dto.setProject(
                     ProjectInfoDTO.builder()
                        .id(project.getId())
                        .serialNumber(project.getSerialNumber())
                        .shortName(project.getShortName())
                        .name(project.getName())
                        .build()
                  );
               }

               if (Objects.nonNull(e.getSupplierId())) {
                  Supplier supplier = supplierMap.get(e.getSupplierId());
                  dto.setSupplier(BriefIdAndNameDTO.builder().id(supplier.getId()).name(supplier.getName()).build());
               }

               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<WmsSurplusDetailDTO> getSurplusDetailPage(QueryReportSurplusDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      param.setClassifyIds(this.queryUtil.getLateClassificationList(param.getClassifyId()));
      String s = StringUtils.analyzeSortConditions(sort);
      Page<WmsSurplusDetailDTO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<WmsSurplusDetail> list = this.getSurplusDetailList(param);
      List<WmsSurplusDetailDTO> detailDTOList = this.convertToDetailDTOList(list);
      return new PageVO<>(page, detailDTOList);
   }

   @Override
   public List<WmsSurplusDetail> getSurplusDetailList(QueryReportSurplusDTOParam param) {
      LambdaQueryWrapper<WmsSurplusDetail> queryWrapper = new LambdaQueryWrapper<>();
      queryWrapper.eq(param.getBasicClass() != null, WmsSurplusDetail::getBasicClass, param.getBasicClass())
         .eq(WmsSurplusDetail::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         .in(CollectionUtil.isNotEmpty(param.getSourceWorkshopIds()), WmsSurplusDetail::getWorkshopId, param.getSourceWorkshopIds())
         .in(CollectionUtil.isNotEmpty(param.getClassifyIds()), WmsSurplusDetail::getClassifyId, param.getClassifyIds())
         .eq(param.getWarehouseId() != null, WmsSurplusDetail::getWarehouseId, param.getWarehouseId())
         .eq(param.getBoolPartyA() != null, WmsSurplusDetail::getBoolPartyA, param.getBoolPartyA())
         .eq(param.getProjectId() != null, WmsSurplusDetail::getProjectId, param.getProjectId())
         .eq(StrUtil.isNotEmpty(param.getSerialNumber()), WmsSurplusDetail::getSurplusSerialNumber, param.getSerialNumber())
         .eq(param.getReviewStatus() != null, WmsSurplusDetail::getReviewStatus, param.getReviewStatus())
         .like(param.getSpecification() != null, WmsSurplusDetail::getSpecification, param.getSpecification())
         .like(param.getBrand() != null, WmsSurplusDetail::getBrand, param.getBrand())
         .and(
            StrUtil.isNotBlank(param.getApplicantName()),
            qw -> {
               LambdaQueryWrapper var10000 = qw.like(WmsSurplusDetail::getApplicantName, param.getApplicantName())
                  .or()
                  .like(WmsSurplusDetail::getReviewerName, param.getApplicantName());
            }
         )
         .orderByDesc(WmsSurplusDetail::getInboundTime);
      if (CollectionUtil.isNotEmpty(param.getReviewTime())) {
         queryWrapper.apply("DATE_FORMAT(inbound_time, '%Y-%m-%d') >= DATE_FORMAT({0}, '%Y-%m-%d')", param.getReviewTime().get(0));
         queryWrapper.apply("DATE_FORMAT(inbound_time, '%Y-%m-%d') <= DATE_FORMAT({0}, '%Y-%m-%d')", param.getReviewTime().get(1));
      }

      if (StrUtil.isNotBlank(param.getOperatorName())) {
         queryWrapper.apply("(applicant_name like '%" + param.getOperatorName() + "%' or reviewer_name like '%" + param.getOperatorName() + "%')");
      }

      return this.wmsSurplusDetailService.list(queryWrapper);
   }

   private Measure getMeasure(Long pid) {
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      if (m.getOutboundUnitType() != null) {
         return m;
      }

      Classification classification = this.classificationService.getById(pid);
      return classification.getLevel() != 1 ? this.getMeasure(classification.getParentId()) : m;
   }

   private Print setBarcode(WmsSurplus surplus, WmsSurplusDetail surplusDetail, Print print) {
      if (BasicClassEnum.checkIsSteel(surplusDetail.getBasicClass())) {
         if (print == null) {
            print = Print.builder()
               .receiptId(surplus.getId())
               .receiptSerialNumber(surplus.getSerialNumber())
               .receiptReviewer(surplus.getReviewerName())
               .receiptReviewTime(surplus.getReviewTime())
               .receiptType(ReceiptTypeEnum.SURPLUS.getType())
               .type(MaterialLabelPrintTypeEnum.SURPLUS.getType())
               .build();
            this.printService.save(print);
         }

         this.setPrintDetail(print, surplusDetail);
      }

      return print;
   }

   private void setPrintDetail(Print print, WmsSurplusDetail surplusDetail) {
      int printNumber = BasicClassEnum.COLOR_ROLL.getType().equals(surplusDetail.getBasicClass()) ? 1 : surplusDetail.getQuantity().intValue();
      String barcode = this.printService
         .savePrint(
            PrintDetail.builder()
               .printId(print.getId())
               .receiptDetailId(surplusDetail.getId())
               .basicClass(surplusDetail.getBasicClass())
               .classifyId(surplusDetail.getClassifyId())
               .classifyName(surplusDetail.getClassifyName())
               .specification(surplusDetail.getSpecification())
               .mete(surplusDetail.getMete())
               .quantity(surplusDetail.getQuantity())
               .brand(surplusDetail.getBrand())
               .heatNoAndBatchNo(surplusDetail.getHeatNoAndBatchNo())
               .workshopId(surplusDetail.getWorkshopId())
               .warehouseId(surplusDetail.getWarehouseId())
               .projectId(surplusDetail.getProjectId())
               .type(MaterialLabelPrintTypeEnum.SURPLUS.getType())
               .boolPartyA(surplusDetail.getBoolPartyA())
               .length(surplusDetail.getLength())
               .width(surplusDetail.getWidth())
               .thickness(surplusDetail.getThickness())
               .color(surplusDetail.getColor())
               .notPrintNumber(printNumber)
               .standardId(surplusDetail.getStandardId())
               .standardName(surplusDetail.getStandardName())
               .materialIsWhole(surplusDetail.getMaterialIsWhole())
               .monomerId(surplusDetail.getMonomerId())
               .areaId(surplusDetail.getAreaId())
               .build()
         );
      surplusDetail.setBarcode(barcode);
      print.setTotalNotPrintNumber(print.getTotalNotPrintNumber() != null ? print.getTotalNotPrintNumber() + printNumber : printNumber);
   }
}
