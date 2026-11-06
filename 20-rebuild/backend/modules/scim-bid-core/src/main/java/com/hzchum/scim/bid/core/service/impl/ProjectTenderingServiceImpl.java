package com.hzchum.scim.bid.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtils;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.bid.core.api.biz.MessageTemplateBiz;
import com.hzchum.scim.bid.core.api.biz.ProjectTenderingSupplierBiz;
import com.hzchum.scim.bid.core.api.enums.BiddingTypeEnum;
import com.hzchum.scim.bid.core.api.enums.CommonEnum;
import com.hzchum.scim.bid.core.api.enums.OperationOuThErEnum;
import com.hzchum.scim.bid.core.api.enums.OrderTransportTypeEnum;
import com.hzchum.scim.bid.core.api.enums.ProjectBidStatusEnum;
import com.hzchum.scim.bid.core.api.enums.ProjectProgressEnum;
import com.hzchum.scim.bid.core.api.enums.RespondEnums;
import com.hzchum.scim.bid.core.api.pojo._do.BiddingRounds;
import com.hzchum.scim.bid.core.api.pojo._do.BiddingSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSubject;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSubjectRound;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTendering;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTenderingSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.Subject;
import com.hzchum.scim.bid.core.api.pojo._do.SubjectConfig;
import com.hzchum.scim.bid.core.api.pojo._do.SupplierSubject;
import com.hzchum.scim.bid.core.api.pojo.dto.ProjectTenderingDTO;
import com.hzchum.scim.bid.core.api.pojo.dto.SubjectProjectDTO;
import com.hzchum.scim.bid.core.api.pojo.dto.TendQueryConditionsDTO;
import com.hzchum.scim.bid.core.api.pojo.dto.TenderNoticeDTO;
import com.hzchum.scim.bid.core.api.pojo.vo.BiddingOverviewVO;
import com.hzchum.scim.bid.core.api.pojo.vo.ProjectTenderingVO;
import com.hzchum.scim.bid.core.api.service.ProjectTenderingService;
import com.hzchum.scim.bid.core.api.service.SubjectConfigService;
import com.hzchum.scim.bid.core.mapper.BiddingRoundsMapper;
import com.hzchum.scim.bid.core.mapper.BiddingSupplierMapper;
import com.hzchum.scim.bid.core.mapper.ProjectSubjectMapper;
import com.hzchum.scim.bid.core.mapper.ProjectSubjectRoundMapper;
import com.hzchum.scim.bid.core.mapper.ProjectSupplierMapper;
import com.hzchum.scim.bid.core.mapper.ProjectTenderingMapper;
import com.hzchum.scim.bid.core.mapper.ProjectTenderingSupplierMapper;
import com.hzchum.scim.bid.core.mapper.SubjectMapper;
import com.hzchum.scim.bid.core.mapper.SupplierSubjectMapper;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.system.core.api.common.utils.NumberUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.CompanyConfigVO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@DS("bidding")
@Service
public class ProjectTenderingServiceImpl extends ServiceImpl<ProjectTenderingMapper, ProjectTendering> implements ProjectTenderingService {
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ConfigService configService;
   @Resource
   private SubjectMapper subjectMapper;
   @Resource
   private BiddingSupplierMapper biddingSupplierMapper;
   @Resource
   private ProjectTenderingSupplierMapper projectTenderingSupplierMapper;
   @Resource
   private BiddingRoundsMapper biddingRoundsMapper;
   @Resource
   private ProjectSubjectMapper projectSubjectMapper;
   @Resource
   private ProjectSubjectRoundMapper projectSubjectRoundMapper;
   @Resource
   private SupplierSubjectMapper supplierSubjectMapper;
   @Resource
   private SubjectConfigService subjectConfigService;
   @Resource
   private ProjectSupplierMapper projectSupplierMapper;
   @Resource
   private MessageTemplateBiz messageTemplateBiz;
   @Resource
   private ProjectTenderingSupplierBiz projectTenderingSupplierBiz;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Long saveInstance(ProjectTenderingDTO dto) {
      this.toExamine(dto);
      ProjectTendering projectTendering = BeanUtil.copy(dto, ProjectTendering.class);
      projectTendering.setUserId(UserUtil.getCurrentUserId());
      projectTendering.setUserName(UserUtil.getCurrentName());
      if (!projectTendering.getBiddingType().equals(BiddingTypeEnum.OPEN_TENDERING.getType())) {
         projectTendering.setInvitingNum(dto.getSupplierIds().size());
      }

      CompanyConfigVO companyConfig = this.configService.getCompanyConfig();
      Preconditions.checkArgument(companyConfig != null, "未设置公司信息，请联系管理员");
      projectTendering.setCompanyName(companyConfig.getCompanyName());
      projectTendering.setUUID(companyConfig.getUUID());
      String contractNo = this.itemNumber(dto.getProjectType());
      Preconditions.checkArgument(
         this.baseMapper.selectOne((Wrapper<ProjectTendering>)new LambdaQueryWrapper<ProjectTendering>().eq(ProjectTendering::getContractNo, contractNo)) == null, "项目编号重复"
      );
      projectTendering.setContractNo(contractNo);
      if (!dto.getBiddingType().equals(BiddingTypeEnum.ENQUIRY.getType())) {
         TenderNoticeDTO tenderNoticeDTO = dto.getTenderNoticeDTO();
         tenderNoticeDTO.setCreateDate(new Date());
         projectTendering.setTenderValue(JSON.toJSONString(dto.getTenderNoticeDTO()));
      }

      this.baseMapper.insert(projectTendering);
      this.projectTenderingSupplierBiz.saveSubjectAndSupplier(dto.getSupplierIds(), dto, projectTendering);
      return projectTendering.getId();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public PageVO<ProjectTenderingVO> getPageAll(TendQueryConditionsDTO dto, Integer page, Integer size, List<String> sort, Integer menu) {
      CompanyConfigVO companyConfig = this.configService.getCompanyConfig();
      this.setTendering(companyConfig.getUUID());
      String orderBy = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(page, size, orderBy);
      Date startDateVerifier = DateTimeUtils.longToDate(dto.getStartDateVerifier());
      Date endDateVerifier = DateTimeUtils.longToDate(dto.getEndDateVerifier());
      Date startDate = DateTimeUtils.longToDate(dto.getStartDate());
      Date endDate = DateTimeUtils.longToDate(dto.getEndDate());
      List<ProjectTenderingVO> projectTenderingVOS = this.baseMapper
         .selectListByValue(dto, startDateVerifier, endDateVerifier, startDate, endDate, menu, companyConfig.getUUID());
      return new PageVO<>(projectTenderingVOS);
   }

   @Override
   public ProjectTendering getById(Long projectId) {
      return this.baseMapper.selectById(projectId);
   }

   @Override
   public List<ProjectTendering> getProject(String uuid) {
      return this.baseMapper.getProject(uuid);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Long updateProject(ProjectTenderingDTO dto) {
      ProjectTendering projectTendering = this.baseMapper.selectById(dto.getId());
      Preconditions.checkArgument(projectTendering != null, "该招采项目不存在");
      Preconditions.checkArgument(!projectTendering.getStatus().equals(ProjectBidStatusEnum.RELEASED.getType()), "已通过审核的项目无法编辑");
      this.toExamine(dto);
      Long currentUserId = UserUtil.getCurrentUserId();
      CompanyConfigVO companyConfig = this.configService.getCompanyConfig();
      if (projectTendering.getStatus() >= ProjectBidStatusEnum.RELEASED.getType()) {
         Preconditions.checkArgument(currentUserId.equals(projectTendering.getUserId()), "项目发布前，只有创建人可以修改");
      }

      if (!projectTendering.getProjectType().equals(dto.getProjectType())) {
         String contractNo = this.itemNumber(dto.getProjectType());
         Preconditions.checkArgument(
            this.baseMapper
                  .selectOne(
                     (Wrapper<ProjectTendering>)(new LambdaQueryWrapper<ProjectTendering>().eq(ProjectTendering::getUUID, companyConfig.getUUID()))
                        .eq(ProjectTendering::getContractNo, contractNo)
                  )
               == null,
            "项目编号重复"
         );
         dto.setContractNo(contractNo);
      }

      BeanUtil.copy(dto, projectTendering);
      if (projectTendering.getStatus().equals(ProjectBidStatusEnum.NOT_PASS.getType())) {
         projectTendering.setStatus(ProjectBidStatusEnum.UNAUDITED.getType());
         projectTendering.setProjectProgress(ProjectProgressEnum.UNAUDITED.getType());
      }

      if (!projectTendering.getBiddingType().equals(BiddingTypeEnum.OPEN_TENDERING.getType())) {
         projectTendering.setInvitingNum(dto.getSupplierIds().size());
      }

      if (!dto.getBiddingType().equals(BiddingTypeEnum.ENQUIRY.getType())) {
         dto.getTenderNoticeDTO().setCreateDate(new Date());
         projectTendering.setTenderValue(JSON.toJSONString(dto.getTenderNoticeDTO()));
      }

      Preconditions.checkArgument(this.baseMapper.updateById(projectTendering) == 1, "更新失败，请刷新重试");
      List<ProjectTenderingSupplier> suppliers = this.projectTenderingSupplierMapper
         .selectList((Wrapper<ProjectTenderingSupplier>)new LambdaQueryWrapper<ProjectTenderingSupplier>().eq(ProjectTenderingSupplier::getProjectTenderingId, dto.getId()));
      suppliers.forEach(item -> {
         if (item != null) {
            this.projectTenderingSupplierMapper.deleteById(item.getId());
         }
      });
      this.biddingRoundsMapper.selectList((Wrapper<BiddingRounds>)new LambdaQueryWrapper<BiddingRounds>().eq(BiddingRounds::getProjectId, dto.getId())).forEach(item -> {
         if (item != null) {
            this.biddingRoundsMapper.deleteById(item.getId());
         }
      });
      this.projectSubjectMapper.selectList((Wrapper<ProjectSubject>)new LambdaQueryWrapper<ProjectSubject>().eq(ProjectSubject::getProjectId, dto.getId())).forEach(item -> {
         if (item != null) {
            this.projectSubjectMapper.deleteById(item.getId());
         }
      });
      this.projectSubjectRoundMapper
         .selectList((Wrapper<ProjectSubjectRound>)new LambdaQueryWrapper<ProjectSubjectRound>().eq(ProjectSubjectRound::getProjectId, dto.getId()))
         .forEach(item -> {
            if (item != null) {
               this.projectSubjectRoundMapper.deleteById(item.getId());
            }
         });
      this.projectTenderingSupplierBiz.saveSubjectAndSupplier(dto.getSupplierIds(), dto, projectTendering);
      return projectTendering.getId();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Integer checkProjectProgress(Long id, Integer projectProgress, Long bidDeadline, Long bidOpeningTime) {
      ProjectTendering projectTendering = this.baseMapper.selectById(id);
      Preconditions.checkArgument(projectTendering != null, "该招采项目不存在");
      Preconditions.checkArgument(projectTendering.getStatus().equals(ProjectBidStatusEnum.RELEASED.getType()), "该项目还未通过审核");
      Preconditions.checkArgument(!projectTendering.getProjectProgress().equals(ProjectProgressEnum.OBSOLETE.getType()), "该项目已结束，无法修改进度");
      Preconditions.checkArgument(!projectTendering.getProjectProgress().equals(ProjectProgressEnum.PAUSED.getType()), "该项目已废标，无法修改进度");
      if (OperationOuThErEnum.PAUSED.getType().equals(projectProgress)) {
         projectTendering.setProjectProgress(ProjectProgressEnum.PAUSED.getType());
         List<ProjectTenderingSupplier> suppliers = this.projectTenderingSupplierMapper
            .selectList((Wrapper<ProjectTenderingSupplier>)new LambdaQueryWrapper<ProjectTenderingSupplier>().eq(ProjectTenderingSupplier::getProjectTenderingId, id));
         suppliers.forEach(e -> {
            if (e.getBidStatus().equals(RespondEnums.RESPOND.getType())) {
               e.setResult(CommonEnum.TRUE.getType());
               Preconditions.checkArgument(this.projectTenderingSupplierMapper.updateById(e) == 1, "修改失败,请刷新后重试");
            }
         });
      }

      if (OperationOuThErEnum.IS_START.getType().equals(projectProgress)) {
         projectTendering.setProjectProgress(ProjectProgressEnum.IS_START.getType());
      }

      if (OperationOuThErEnum.GO.getType().equals(projectProgress)) {
         Preconditions.checkArgument(bidDeadline > System.currentTimeMillis(), "投标截止时间必须是未来的时间");
         Preconditions.checkArgument(bidOpeningTime >= bidDeadline, "开标时间必须大于等于投标截止时间");
         Preconditions.checkArgument(bidDeadline < projectTendering.getDeliveryTime().getTime(), "投标截止时间不得大于交货时间");
         Preconditions.checkArgument(bidOpeningTime < projectTendering.getDeliveryTime().getTime(), "开标时间不得大于交货时间");
         Integer round = this.biddingRoundsMapper.selectOne(((QueryWrapper)new QueryWrapper().eq("project_id", id)).select("max(round) as round")).getRound();
         BiddingRounds biddingRounds = this.biddingRoundsMapper
            .selectOne(
               (Wrapper<BiddingRounds>)(new LambdaQueryWrapper<BiddingRounds>().eq(BiddingRounds::getRound, round)).eq(BiddingRounds::getProjectId, id)
            );
         biddingRounds.setBidOpeningTime(DateTimeUtil.longToDate(bidOpeningTime));
         biddingRounds.setBidDeadline(DateTimeUtil.longToDate(bidDeadline));
         Preconditions.checkArgument(this.biddingRoundsMapper.updateById(biddingRounds) == 1, "更新失败，请刷新重试");
         projectTendering.setProjectProgress(ProjectProgressEnum.RELEASED.getType());
         if (biddingRounds.getBidOpeningTime().getTime() <= System.currentTimeMillis()) {
            projectTendering.setProjectProgress(ProjectProgressEnum.NOT_START.getType());
         }
      }

      int updateById = this.baseMapper.updateById(projectTendering);
      Preconditions.checkArgument(updateById == 1, "修改失败,请刷新后重试");
      return updateById;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Future<Integer> checkProject(Long id, Integer status) {
      ProjectTendering projectTendering = this.baseMapper.selectById(id);
      BiddingRounds biddingRounds = this.biddingRoundsMapper
         .selectOne(
            (Wrapper<BiddingRounds>)(new LambdaQueryWrapper<BiddingRounds>().isNull(BiddingRounds::getReleaseDate)).eq(BiddingRounds::getProjectId, id)
         );
      Preconditions.checkArgument(projectTendering != null, "该招采项目不存在");
      Preconditions.checkArgument(biddingRounds != null, "招标轮次异常");
      Preconditions.checkArgument(
         !projectTendering.getStatus().equals(ProjectBidStatusEnum.RELEASED.getType())
            || !projectTendering.getStatus().equals(ProjectBidStatusEnum.NOT_PASS.getType()),
         "该招采项目已被审核"
      );
      if (ProjectBidStatusEnum.RELEASED.getType().equals(status) && biddingRounds.getBidDeadline().getTime() <= System.currentTimeMillis()) {
         throw new IllegalArgumentException(String.valueOf("当前时间已超过投标截止时间，请重新编辑"));
      }

      projectTendering.setVerifierId(UserUtil.getCurrentUserId());
      projectTendering.setVerifierTime(new Date());
      projectTendering.setStatus(status);
      if (ProjectBidStatusEnum.RELEASED.getType().equals(status)) {
         biddingRounds.setReleaseDate(new Date());
         this.biddingRoundsMapper.updateById(biddingRounds);
         projectTendering.setProjectProgress(ProjectProgressEnum.RELEASED.getType());
         this.saveSupplierStatus(projectTendering);
      }

      if (ProjectBidStatusEnum.NOT_PASS.getType().equals(status)) {
         projectTendering.setProjectProgress(ProjectProgressEnum.NOT_PASS.getType());
      }

      Integer update = this.baseMapper.updateById(projectTendering);
      Preconditions.checkArgument(update == 1, "保存失败，请重试");
      if (projectTendering.getStatus().equals(ProjectBidStatusEnum.RELEASED.getType())) {
         this.messageTemplateBiz.sendSupplier(projectTendering, null, biddingRounds.getBidDeadline());
      }

      return new AsyncResult<>(update);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean modifyTime(Long id, Long bidDeadline, Long bidOpeningTime) {
      Preconditions.checkArgument(bidDeadline > System.currentTimeMillis(), "投标截止时间必须是未来的时间");
      Preconditions.checkArgument(bidOpeningTime >= bidDeadline, "开标时间必须大于等于投标截止时间");
      ProjectTendering projectTendering = this.baseMapper.selectById(id);
      Preconditions.checkArgument(projectTendering != null, "招标项目不存在");
      Preconditions.checkArgument(bidDeadline < projectTendering.getDeliveryTime().getTime(), "投标截止时间不得大于交货时间");
      Preconditions.checkArgument(bidOpeningTime < projectTendering.getDeliveryTime().getTime(), "开标时间不得大于交货时间");
      ProjectTenderingVO projectTenderingVO = this.baseMapper.selectByProjectId(id);
      Preconditions.checkArgument(projectTenderingVO.getBidDeadline().getTime() > System.currentTimeMillis(), "投标截止时间已过，无法修改时间");
      BiddingRounds biddingRounds = this.biddingRoundsMapper
         .selectOne(
            (Wrapper<BiddingRounds>)(new LambdaQueryWrapper<BiddingRounds>().eq(BiddingRounds::getId, projectTenderingVO.getRoundId()))
               .eq(BiddingRounds::getProjectId, id)
         );
      Preconditions.checkArgument(biddingRounds != null, "招标轮次异常");
      biddingRounds.setBidDeadline(DateTimeUtil.longToDate(bidDeadline));
      biddingRounds.setBidOpeningTime(DateTimeUtil.longToDate(bidOpeningTime));
      Preconditions.checkArgument(this.biddingRoundsMapper.updateById(biddingRounds) == 1, "更新失败，请刷新重试");
      return true;
   }

   @Override
   public ListVO getOverview(Long startTime, Long endTime) {
      String uuid = this.configService.getCompanyConfig().getUUID();
      Date startDate = DateTimeUtil.longToDate(startTime);
      Date endDate = DateTimeUtil.longToDate(endTime);
      List<BiddingOverviewVO> overview = this.baseMapper.getOverview(startDate, endDate, uuid);
      return CollectionUtils.isEmpty(overview) ? new ListVO() : new ListVO<>(overview);
   }

   @Override
   public ListVO getBidType(Long startTime, Long endTime, Long projectType) {
      String uuid = this.configService.getCompanyConfig().getUUID();
      Date startDate = DateTimeUtil.longToDate(startTime);
      Date endDate = DateTimeUtil.longToDate(endTime);
      List<BiddingOverviewVO> overview = this.baseMapper.getBidType(startDate, endDate, projectType, uuid);
      if (CollectionUtils.isEmpty(overview)) {
         return new ListVO();
      }

      overview.forEach(e -> {
         String nameByType = BiddingTypeEnum.getNameByType(Math.toIntExact(e.getProjectType()));
         e.setTypeName(nameByType);
      });
      return new ListVO<>(overview);
   }

   @Override
   public ProjectTenderingVO selectByProjectId(Long id) {
      return this.baseMapper.selectByProjectId(id);
   }

   private void saveSupplierStatus(ProjectTendering projectTendering) {
      if (projectTendering.getBiddingType().equals(BiddingTypeEnum.OPEN_TENDERING.getType())) {
         List<BiddingSupplier> biddingSuppliers = this.biddingSupplierMapper
            .selectList(
               (Wrapper<BiddingSupplier>)(new LambdaQueryWrapper<BiddingSupplier>().eq(BiddingSupplier::getIsBlock, CommonEnum.FALSE.getType()))
                  .eq(BiddingSupplier::getUUID, projectTendering.getUUID())
            );
         biddingSuppliers.forEach(
            e -> {
               ProjectSupplier build = ProjectSupplier.builder()
                  .projectId(projectTendering.getId())
                  .supplierId(e.getSupplierId())
                  .UUID(projectTendering.getUUID())
                  .build();
               this.projectSupplierMapper.insert(build);
            }
         );
      } else {
         List<Long> supplierList = this.projectTenderingSupplierMapper
            .selectList(
               (Wrapper<ProjectTenderingSupplier>)new LambdaQueryWrapper<ProjectTenderingSupplier>().eq(ProjectTenderingSupplier::getProjectTenderingId, projectTendering.getId())
            )
            .stream()
            .map(ProjectTenderingSupplier::getBidSupplierId)
            .collect(Collectors.toList());
         List<BiddingSupplier> biddingSuppliers = this.biddingSupplierMapper
            .selectList(
               (Wrapper<BiddingSupplier>)(new LambdaQueryWrapper<BiddingSupplier>().in(BiddingSupplier::getSupplierId, supplierList))
                  .eq(BiddingSupplier::getUUID, projectTendering.getUUID())
            );
         biddingSuppliers.forEach(
            e -> {
               ProjectSupplier build = ProjectSupplier.builder()
                  .projectId(projectTendering.getId())
                  .supplierId(e.getSupplierId())
                  .UUID(projectTendering.getUUID())
                  .build();
               this.projectSupplierMapper.insert(build);
            }
         );
      }
   }

   private String itemNumber(Integer subjectId) {
      Subject subject = this.subjectMapper.selectById(subjectId);
      Preconditions.checkArgument(subject != null, "科目不能为空");
      SubjectConfig subjectConfig = this.subjectConfigService
         .getOne(
            (Wrapper<SubjectConfig>)(new LambdaQueryWrapper<SubjectConfig>().eq(SubjectConfig::getSubjectId, subjectId))
               .eq(SubjectConfig::getUUID, this.configService.getCompanyConfig().getUUID())
         );
      Preconditions.checkArgument(subjectConfig != null, subject.getName() + "未配置");
      String codeFirst = subjectConfig.getCode();
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(codeFirst), "未配置" + subject.getName() + "科目的代号");
      Integer number = subjectConfig.getNumber();
      Preconditions.checkArgument(number != null, "未配置" + subject.getName() + "科目的流水");
      Integer contractNumber = Math.toIntExact(this.redisUtils.incr(codeFirst + DateTimeUtils.getCurrentYearOfYY(), 1L));
      this.redisUtils.expire(codeFirst + DateTimeUtils.getCurrentYearOfYY(), DateTimeUtils.getExpirationTime());
      String contractNo = codeFirst + DateTimeUtils.getCurrentYearOfYY() + NumberUtils.getDigitsNumber(contractNumber, number);
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(contractNo), "自动生成项目编号失败,请重试");
      return contractNo;
   }

   private void toExamine(ProjectTenderingDTO dto) {
      if (!dto.getBiddingType().equals(BiddingTypeEnum.OPEN_TENDERING.getType())) {
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(dto.getSupplierIds()), "非公开招标方式时供应商不能为空");
         List<BiddingSupplier> biddingSuppliers = this.biddingSupplierMapper
            .selectList((Wrapper<BiddingSupplier>)new LambdaQueryWrapper<BiddingSupplier>().in(BiddingSupplier::getSupplierId, dto.getSupplierIds()));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(biddingSuppliers) || biddingSuppliers.size() == dto.getSupplierIds().size(), "供应商不存在，请刷新重试");
      }

      if (dto.getBiddingType().equals(BiddingTypeEnum.OPEN_TENDERING.getType())) {
         Preconditions.checkArgument(CollectionUtils.isEmpty(dto.getSupplierIds()), "公开招标方式时没有邀请的供应商，请刷新页面重试");
      }

      if (dto.getBiddingType().equals(BiddingTypeEnum.ENQUIRY.getType())) {
         Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(dto.getRemark()), "询价方式，描述不能为空");
         Preconditions.checkArgument(BeanUtil.checkObjAllFieldsIsNull(dto.getTenderNoticeDTO()), "询价方式没有公告文件");
      }

      if (!dto.getBiddingType().equals(BiddingTypeEnum.ENQUIRY.getType())) {
         Preconditions.checkArgument(dto.getTenderNoticeDTO() != null, "非询价方式招标公告不能为空");
      }

      if (dto.getDeliveryType().equals(OrderTransportTypeEnum.TO_FACTORY.getType())) {
         Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(dto.getDeliveryAddress()), "到厂方式，交货地点不能为空");
      }

      Preconditions.checkArgument(dto.getDeliveryTime().getTime() > dto.getBidOpeningTime().getTime(), "交货时间不得早于开标时间");
      Preconditions.checkArgument(dto.getBidOpeningTime().getTime() >= dto.getBidDeadline().getTime(), "开标时间不能小于投标截止时间");
      Preconditions.checkArgument(
         this.subjectMapper.selectOne((Wrapper<Subject>)new LambdaQueryWrapper<Subject>().eq(Subject::getId, dto.getProjectType())).getLevel().equals(1),
         "项目类型只能为一级科目属性"
      );
      List<Long> subjects = dto.getSubjectProjectDTOS().stream().map(SubjectProjectDTO::getSubjectId).collect(Collectors.toList());
      this.subjectMapper
         .selectList((Wrapper<Subject>)new LambdaQueryWrapper<Subject>().in(Subject::getId, subjects))
         .forEach(e -> Preconditions.checkArgument(e.getLevel() == 3, "招采科目只能为三级科目"));
      Set<String> stringSet = new HashSet<>();
      dto.getSubjectProjectDTOS().forEach(e -> {
         boolean bool = stringSet.add(e.getSubjectId() + e.getSpecification().trim());
         Preconditions.checkArgument(bool, "科目+规格不能重复");
      });
   }

   @Override
   public void setTendering(String uuid) {
      List<ProjectTendering> projectTenderingList = this.baseMapper
         .selectList(
            (Wrapper<ProjectTendering>)((((new LambdaQueryWrapper<ProjectTendering>()
                           .ne(ProjectTendering::getProjectProgress, ProjectProgressEnum.IS_START.getType()))
                        .ne(ProjectTendering::getProjectProgress, ProjectProgressEnum.OBSOLETE.getType()))
                     .ne(ProjectTendering::getProjectProgress, ProjectProgressEnum.PAUSED.getType()))
                  .eq(ProjectTendering::getStatus, ProjectBidStatusEnum.RELEASED.getType()))
               .eq(ProjectTendering::getUUID, uuid)
         );
      if (!CollectionUtils.isEmpty(projectTenderingList)) {
         List<Long> projectIds = projectTenderingList.stream().map(ProjectTendering::getId).collect(Collectors.toList());
         Map<Long, ProjectTenderingVO> ProjectTenderingVOMap = this.baseMapper
            .getProjectAll(uuid)
            .stream()
            .collect(Collectors.toMap(ProjectTenderingVO::getId, e -> (ProjectTenderingVO)e));
         Map<Long, List<SupplierSubject>> supplierSubjectMap = this.supplierSubjectMapper
            .selectList(
               (Wrapper<SupplierSubject>)(new LambdaQueryWrapper<SupplierSubject>().eq(SupplierSubject::getIsFollow, CommonEnum.TRUE.getType()))
                  .in(SupplierSubject::getProjectId, projectIds)
            )
            .stream()
            .collect(Collectors.toMap(SupplierSubject::getProjectId, e -> new ArrayList<>(Collections.singleton((SupplierSubject)e)), (oldList, newList) -> {
               oldList.addAll(newList);
               return oldList;
            }));

         for (ProjectTendering projectTendering : projectTenderingList) {
            Boolean bool = true;
            ProjectTenderingVO vo = ProjectTenderingVOMap.get(projectTendering.getId());
            if (vo.getRound() == 1
               && projectTendering.getIsOpen().equals(CommonEnum.FALSE.getType())
               && vo.getBidOpeningTime().getTime() <= System.currentTimeMillis()) {
               projectTendering.setIsOpen(CommonEnum.TRUE.getType());
               bool = false;
            }

            if (!projectTendering.getProjectProgress().equals(ProjectProgressEnum.PAUSED.getType())
               && vo.getBidOpeningTime().getTime() <= System.currentTimeMillis()
               && vo.getTickSizeNum() == 0) {
               if (vo.getRound().equals(1)) {
                  projectTendering.setProjectProgress(ProjectProgressEnum.PAUSED.getType());
                  bool = false;
               } else {
                  List<SupplierSubject> supplierSubjects = supplierSubjectMap.get(projectTendering.getId());
                  if (CollectionUtils.isNotEmpty(supplierSubjects)) {
                     projectTendering.setProjectProgress(ProjectProgressEnum.OBSOLETE.getType());
                     bool = false;
                  } else {
                     projectTendering.setProjectProgress(ProjectProgressEnum.PAUSED.getType());
                     bool = false;
                  }
               }
            }

            if (projectTendering.getProjectProgress().equals(ProjectProgressEnum.RELEASED.getType())
               || projectTendering.getProjectProgress().equals(ProjectProgressEnum.NOT_START.getType())) {
               if (vo.getBidOpeningTime().getTime() <= System.currentTimeMillis()) {
                  if (!projectTendering.getProjectProgress().equals(ProjectProgressEnum.NOT_START.getType())) {
                     projectTendering.setProjectProgress(ProjectProgressEnum.NOT_START.getType());
                     bool = false;
                  }
               } else if (!projectTendering.getProjectProgress().equals(ProjectProgressEnum.RELEASED.getType())) {
                  projectTendering.setProjectProgress(ProjectProgressEnum.RELEASED.getType());
                  bool = false;
               }
            }

            if (vo.getRound() > 1 && projectTendering.getIsOpen().equals(CommonEnum.FALSE.getType())) {
               projectTendering.setIsOpen(CommonEnum.TRUE.getType());
               bool = false;
            }

            if (!bool) {
               Preconditions.checkArgument(this.baseMapper.updateById(projectTendering) == 1, "自动更新失败，请刷新重试");
            }
         }
      }
   }
}
