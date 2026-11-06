package com.hzchum.scim.project.core.biz.impl;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.NationEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.plan.core.api.pojo.dto.MistakeExportDTO;
import com.hzchum.scim.project.core.api.biz.ProjectManageRosterBiz;
import com.hzchum.scim.project.core.api.biz.ProjectSubcontractManageBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRosterCert;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendance;
import com.hzchum.scim.project.core.api.pojo.dto.labor.ProjectManageRosterDTO;
import com.hzchum.scim.project.core.api.pojo.dto.labor.ProjectManageRosterImportDTO;
import com.hzchum.scim.project.core.api.pojo.dto.labor.ProjectManageRosterSimpleDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectManageRosterQuery;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageRosterSaveParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectManageRosterSaveParam.CertSaveParam;
import com.hzchum.scim.project.core.api.service.ProjectManageBehaviorTotalScoreService;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterCertService;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceService;
import com.hzchum.scim.project.core.mapper.ProjectManageRosterMapper;
import com.hzchum.scim.system.core.api.biz.UserBiz;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.UserSaveRequestVO;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProjectManageRosterBizImpl
   extends IBizImpl<ProjectManageRosterService, ProjectManageRosterMapper, ProjectManageRoster>
   implements ProjectManageRosterBiz {
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private ProjectManageRosterCertService rosterCertService;
   @Resource
   private UserService userService;
   @Resource
   private ProjectManageBehaviorTotalScoreService behaviorTotalScoreService;
   @Resource
   private PasswordEncoder passwordEncoder;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ProjectManageAttendanceService attendanceService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private ProjectSubcontractManageBiz subcontractManageBiz;
   @Resource
   private UserBiz userBiz;

   @Override
   public PageVO<ProjectManageRosterDTO> rosterPage(ProjectManageRosterQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ProjectManageRosterDTO> list = this.baseService.rosterList(query);
      Map<String, String> wokeNameMap = this.dictionaryService
         .listByName(DictionaryEnum.SITE_WORK_TYPE.getName())
         .stream()
         .collect(Collectors.toMap(SysDictionary::getValue, SysDictionary::getLabel));
      list.forEach(e -> e.setWokeName(wokeNameMap.getOrDefault(e.getWorkType(), null)));
      return new PageVO<>(page, list);
   }

   @Override
   public List<ProjectManageRosterSimpleDTO> simpleInfoList(ProjectManageRosterQuery query) {
      List<ProjectManageRosterDTO> list = this.baseService.rosterList(query);
      Map<String, String> wokeNameMap = this.dictionaryService
         .listByName(DictionaryEnum.SITE_WORK_TYPE.getName())
         .stream()
         .collect(Collectors.toMap(SysDictionary::getValue, SysDictionary::getLabel));
      return list.stream().map(e -> {
         ProjectManageRosterSimpleDTO simpleDTO = BeanUtil.toBean(e, ProjectManageRosterSimpleDTO.class);
         simpleDTO.setWokeName(wokeNameMap.getOrDefault(e.getWorkType(), null));
         return simpleDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public Integer getRemainingBehaviorScore(Long projectId, Long userId) {
      List<ProjectManageRosterDTO> list = this.baseService.rosterList(ProjectManageRosterQuery.builder().projectId(projectId).userId(userId).build());
      Preconditions.checkArgument(CollUtil.isNotEmpty(list) && list.size() == 1, "当前花名册人员不存在, 请刷新后重试");
      return list.get(0).getRemainingBehaviorScore();
   }

   @Override
   public void rosterDownload(ProjectManageRosterQuery query, HttpServletResponse response) {
      ProjectInfo projectInfo = this.projectService.getSimpleById(query.getProjectId());
      List<ProjectManageRosterDTO> list = this.baseService.rosterList(query);
      list.sort(Comparator.<ProjectManageRosterDTO, Long>comparing(ProjectManageRoster::getId).reversed());
      Map<String, String> wokeNameMap = this.dictionaryService
         .listByName(DictionaryEnum.SITE_WORK_TYPE.getName())
         .stream()
         .collect(Collectors.toMap(SysDictionary::getValue, SysDictionary::getLabel));
      list.forEach(ex -> ex.setWokeName(wokeNameMap.getOrDefault(ex.getWorkType(), null)));
      if (!CollectionUtils.isEmpty(list)) {
         String title = projectInfo.getName();
         AtomicInteger index = new AtomicInteger(0);
         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList(title, "序号"));
         headList.add(Arrays.asList(title, "入职时间"));
         headList.add(Arrays.asList(title, "编号"));
         headList.add(Arrays.asList(title, "工种"));
         headList.add(Arrays.asList(title, "姓名"));
         headList.add(Arrays.asList(title, "年龄"));
         headList.add(Arrays.asList(title, "性别"));
         headList.add(Arrays.asList(title, "民族"));
         headList.add(Arrays.asList(title, "身份证号"));
         headList.add(Arrays.asList(title, "家庭住址"));
         headList.add(Arrays.asList(title, "联系方式"));
         headList.add(Arrays.asList(title, "累计处罚（元）"));
         headList.add(Arrays.asList(title, "所属单位"));
         headList.add(Arrays.asList(title, "状态"));
         List<List<Object>> dataList = new ArrayList<>();
         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         list.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            LocalDateTime createTime = ex.getCreateTime();
            data.add(createTime != null ? createTime.format(formatter2) : "-");
            data.add(ex.getRosterNumber());
            data.add(ex.getWokeName());
            data.add(ex.getName());
            data.add(ex.getAge());
            data.add(ex.getSex().equals(0) ? "男" : "女");
            data.add(ex.getNation());
            data.add(ex.getIdNumber());
            data.add(ex.getHomeAddress());
            data.add(ex.getPhone());
            data.add(ex.getCumulativePenalty());
            data.add(ex.getSupplierName());
            data.add(ex.getStatus().equals(1) ? "在职" : "离职");
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "实名制人员信息.xlsx");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
            EasyExcel.write(response.getOutputStream())
               .head(headList)
               .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
               .registerWriteHandler(
                  new CellWriteHandler() {
                     @Override
                     public void beforeCellCreate(
                        WriteSheetHolder writeSheetHolder,
                        WriteTableHolder writeTableHolder,
                        Row row,
                        Head head,
                        Integer columnIndex,
                        Integer relativeRowIndex,
                        Boolean isHead
                     ) {
                        if (isHead && relativeRowIndex == 0) {
                           row.setHeight((short)550);
                        }
                     }
                  }
               )
               .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setWriteFont(new WriteFont() {
                        {
                           this.setFontName("宋体");
                           this.setFontHeightInPoints((short)10);
                           this.setBold(true);
                        }
                     });
                     this.setWrapped(true);
                     this.setShrinkToFit(true);
                  }
               }, new WriteCellStyle() {
                  {
                     this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                     this.setVerticalAlignment(VerticalAlignment.CENTER);
                     this.setBorderBottom(BorderStyle.THIN);
                     this.setBorderLeft(BorderStyle.THIN);
                     this.setBorderRight(BorderStyle.THIN);
                     this.setBorderTop(BorderStyle.THIN);
                  }
               }))
               .sheet("实名制人员信息")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   @Override
   public ProjectManageRosterDTO getRosterInfo(Long id) {
      List<ProjectManageRosterDTO> list = this.baseService.rosterList(ProjectManageRosterQuery.builder().id(id).build());
      Preconditions.checkArgument(CollUtil.isNotEmpty(list) && list.size() == 1, "当前花名册人员不存在, 请刷新后重试");
      return list.get(0);
   }

   @Override
   public ProjectManageRosterDTO getBaseUserInfo() {
      Long currentUserId = UserUtil.getCurrentUserId();
      ProjectManageRoster roster = this.baseService
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getUserId, currentUserId)
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      Preconditions.checkArgument(roster != null, "项目管理人员信息获取失败！");
      ContractProject project = this.projectService.getById(roster.getProjectId());
      ProjectManageRosterDTO rosterDTO = BeanUtil.toBean(roster, ProjectManageRosterDTO.class);
      if (project != null) {
         rosterDTO.setProjectInfo(BeanUtil.toBean(project, ProjectInfo.class));
      }

      return rosterDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveRoster(ProjectManageRosterSaveParam param) {
      LocalDate now = LocalDate.now();
      Long age = ChronoUnit.YEARS.between(LocalDate.parse(param.getBirthDate()), now);
      param.setAge(age.intValue());
      if (param.getUserId() == null) {
         UserSaveRequestVO userSaveRequestVO = param.getUserSaveRequestVO();
         Preconditions.checkArgument(userSaveRequestVO.getPhone() != null, "手机号不能为空");
         userSaveRequestVO.setName(param.getName());
         userSaveRequestVO.setSex(param.getSex());
         User user = this.registerTempUser(userSaveRequestVO);
         param.setUserId(user.getId());
      } else {
         User user = this.userService.getById(param.getUserId());
         Preconditions.checkArgument(user != null, "未获取到账号信息！");
         Preconditions.checkArgument(UserTypeEnum.TEMP_USER.getType().equals(user.getUserType()), "操作失败，该手机号已注册为系统用户！");
         this.userBiz.changeUserDisable(user.getId(), Boolean.TRUE, null);
         param.setUserId(user.getId());
         if (!user.getName().equals(param.getName()) || !user.getSex().equals(param.getSex())) {
            this.userService
               .update(Wrappers.lambdaUpdate(User.class).eq(User::getId, user.getId()).set(User::getName, param.getName()).set(User::getSex, param.getSex()));
         }
      }

      this.verifyParams(param);
      ProjectManageRoster roster = BeanUtil.toBean(param, ProjectManageRoster.class);
      Integer behaviorTotalScore = this.behaviorTotalScoreService.getTotalScore(null, param.getEntryDate(), param.getProjectId(), now.getYear());
      roster.setBehaviorTotalScore(behaviorTotalScore);
      roster.setRosterNumber(this.generateRosterNumber("C", param.getProjectId()));
      this.baseService.save(roster);
      if (CollUtil.isNotEmpty(param.getCerts())) {
         List<ProjectManageRosterCert> rosterCertList = param.getCerts().stream().map(cert -> {
            ProjectManageRosterCert rosterCert = BeanUtil.toBean(cert, ProjectManageRosterCert.class);
            rosterCert.setRosterId(roster.getId());
            return rosterCert;
         }).collect(Collectors.toList());
         this.rosterCertService.saveBatch(rosterCertList);
      }

      this.attendanceService.saveRosterAttendanceInfo(roster);
      return true;
   }

   public String generateRosterNumber(String prefix, Long projectId) {
      List<ProjectManageRoster> projectManageRosters = this.baseService
         .list(Wrappers.lambdaQuery(ProjectManageRoster.class).eq(ProjectManageRoster::getProjectId, projectId))
         .stream()
         .filter(e -> e.getRosterNumber().contains(prefix))
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectManageRosters)) {
         return prefix + "0001";
      }

      List<String> existingCodes = projectManageRosters.stream().map(e -> e.getRosterNumber().substring(1)).sorted().collect(Collectors.toList());

      for (int i = 1; i <= 9999; i++) {
         String nextCode = String.format("%04d", i);
         if (!existingCodes.contains(nextCode)) {
            return prefix + nextCode;
         }
      }

      throw new BusinessException("操作失败！花名册人员数量已上限！");
   }

   private User registerTempUser(UserSaveRequestVO requestVO) {
      User user = this.userService.getOne(Wrappers.lambdaQuery(User.class).eq(User::getPhone, requestVO.getPhone()));
      if (user != null) {
         if (UserTypeEnum.COMMON_USER.getType().equals(user.getUserType())) {
            throw new BusinessException("该账号已注册为公司用户！");
         } else {
            throw new BusinessException("该账号已注册为劳务用户！");
         }
      } else {
         user = com.hzchum.pangu.common.util.BeanUtil.copy(requestVO, User.class);
         user.setUsername(requestVO.getPhone());
         user.setUserType(UserTypeEnum.TEMP_USER.getType());
         user.setPassword(this.passwordEncoder.encode(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required")));
         this.userService.save(user);
         return user;
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateRoster(ProjectManageRosterSaveParam param) {
      ProjectManageRoster oldRoster = this.baseService.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldRoster), "当前数据不存在, 请刷新后重试");
      Long age = ChronoUnit.YEARS.between(LocalDate.parse(param.getBirthDate()), LocalDate.now());
      param.setAge(age.intValue());
      this.verifyParams(param);
      User user = this.userService.getById(param.getUserId());
      Preconditions.checkArgument(user != null, "操作失败，账号信息不存在！");
      Preconditions.checkArgument(param.getUserSaveRequestVO() != null && param.getUserSaveRequestVO().getPhone() != null);
      String paramPhone = param.getUserSaveRequestVO().getPhone();
      if (!user.getPhone().equals(paramPhone)) {
         User otherUser = this.userService.getOne(Wrappers.lambdaQuery(User.class).eq(User::getPhone, paramPhone).ne(User::getId, user.getId()));
         if (otherUser != null) {
            if (UserTypeEnum.COMMON_USER.getType().equals(otherUser.getUserType())) {
               throw new BusinessException("目标账号已注册为公司用户！");
            }

            if (UserTypeEnum.TEMP_USER.getType().equals(otherUser.getUserType())) {
               ProjectManageRoster hasRoster = this.baseService
                  .getOne(
                     Wrappers.lambdaQuery(ProjectManageRoster.class)
                        .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
                        .eq(ProjectManageRoster::getUserId, otherUser.getId())
                  );
               if (hasRoster != null) {
                  throw new BusinessException("操作失败！该劳务在 " + this.projectService.getById(hasRoster.getProjectId()).getShortName() + " 项目中是在职状态！");
               }
            }

            if (!otherUser.getIsEnabled()) {
               this.userBiz.changeUserDisable(otherUser.getId(), Boolean.TRUE, null);
            }

            if (!otherUser.getName().equals(param.getName()) || !otherUser.getSex().equals(param.getSex())) {
               this.userService
                  .update(
                     Wrappers.lambdaUpdate(User.class).eq(User::getId, otherUser.getId()).set(User::getName, param.getName()).set(User::getSex, param.getSex())
                  );
            }

            param.setUserId(otherUser.getId());
         } else {
            List<ProjectManageRoster> rosterList = this.baseService
               .list(Wrappers.lambdaQuery(ProjectManageRoster.class).eq(ProjectManageRoster::getUserId, user.getId()));
            if (Integer.valueOf(1).equals(rosterList.size())) {
               user.setUsername(paramPhone);
               user.setSex(param.getSex());
               user.setPhone(paramPhone);
               this.userService.updateById(user);
               if (!user.getIsEnabled()) {
                  this.userBiz.changeUserDisable(user.getId(), Boolean.TRUE, null);
               }
            } else {
               User registerTempUser = new User();
               registerTempUser.setPhone(paramPhone);
               registerTempUser.setName(oldRoster.getName());
               registerTempUser.setSex(oldRoster.getSex());
               registerTempUser.setUsername(paramPhone);
               registerTempUser.setUserType(UserTypeEnum.TEMP_USER.getType());
               registerTempUser.setPassword(this.passwordEncoder.encode(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required")));
               this.userService.save(registerTempUser);
               param.setUserId(registerTempUser.getId());
            }
         }
      } else if (!user.getName().equals(param.getName()) || !user.getSex().equals(param.getSex())) {
         this.userService
            .update(Wrappers.lambdaUpdate(User.class).eq(User::getId, user.getId()).set(User::getName, param.getName()).set(User::getSex, param.getSex()));
      }

      ProjectManageRoster roster = BeanUtil.toBean(param, ProjectManageRoster.class);
      this.baseService.updateById(roster);
      LambdaUpdateWrapper<ProjectManageRoster> updateWrapper = new LambdaUpdateWrapper<>();
      updateWrapper.set(BaseEntity::getUpdateTime, LocalDateTime.now());
      updateWrapper.eq(ProjectManageRoster::getId, roster.getId());
      if (StrUtil.isBlank(param.getPhysicalExaminationAttachmentIds())) {
         updateWrapper.set(ProjectManageRoster::getPhysicalExaminationAttachmentIds, null);
      }

      if (StrUtil.isBlank(param.getCertAttachmentIds())) {
         updateWrapper.set(ProjectManageRoster::getCertAttachmentIds, null);
      }

      if (StrUtil.isBlank(param.getAvatarAttachmentId())) {
         updateWrapper.set(ProjectManageRoster::getAvatarAttachmentId, null);
      }

      this.baseService.update(updateWrapper);
      this.rosterCertService.remove(Wrappers.lambdaQuery(ProjectManageRosterCert.class).eq(ProjectManageRosterCert::getRosterId, roster.getId()));
      if (CollUtil.isNotEmpty(param.getCerts())) {
         List<ProjectManageRosterCert> rosterCertList = param.getCerts().stream().map(cert -> {
            ProjectManageRosterCert rosterCert = BeanUtil.toBean(cert, ProjectManageRosterCert.class);
            rosterCert.setRosterId(roster.getId());
            return rosterCert;
         }).collect(Collectors.toList());
         this.rosterCertService.saveBatch(rosterCertList);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatus(Long id, Integer status) {
      ProjectManageRoster oldRoster = this.baseService.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldRoster), "当前数据不存在, 请刷新后重试");
      this.baseService.update(Wrappers.lambdaUpdate(ProjectManageRoster.class).eq(ProjectManageRoster::getId, id).set(ProjectManageRoster::getStatus, status));
      if (EmployeeStatusEnum.ON_JOB.getType().equals(status)) {
         ProjectManageRoster hasRoster = this.baseService
            .getOne(
               Wrappers.lambdaQuery(ProjectManageRoster.class)
                  .ne(ProjectManageRoster::getProjectId, oldRoster.getProjectId())
                  .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
                  .and(
                     qw -> {
                        LambdaQueryWrapper var10000 = qw.eq(ProjectManageRoster::getUserId, oldRoster.getUserId())
                           .or()
                           .eq(ProjectManageRoster::getIdNumber, oldRoster.getIdNumber());
                     }
                  )
            );
         if (hasRoster != null) {
            throw new BusinessException("操作失败！该劳务在 " + this.projectService.getById(hasRoster.getProjectId()).getShortName() + " 项目中是在职状态！");
         }

         this.attendanceService.saveRosterAttendanceInfo(oldRoster);
      } else {
         this.attendanceService.removeRosterAttendanceInfo(oldRoster);
      }

      this.userBiz.changeUserDisable(oldRoster.getUserId(), EmployeeStatusEnum.ON_JOB.getType().equals(status), null);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteRoster(Long id) {
      ProjectManageRoster oldRoster = this.baseService.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldRoster), "当前数据不存在, 请刷新后重试");
      ProjectManageRoster roster = this.baseService
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .ne(ProjectManageRoster::getProjectId, oldRoster.getProjectId())
               .eq(ProjectManageRoster::getUserId, oldRoster.getUserId())
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      if (roster == null && EmployeeStatusEnum.ON_JOB.getType().equals(oldRoster.getStatus())) {
         this.userBiz.changeUserDisable(oldRoster.getUserId(), false, null);
      }

      this.baseService.removeById(id);
      this.attendanceService.remove(Wrappers.lambdaQuery(ProjectManageAttendance.class).eq(ProjectManageAttendance::getProjectManageRosterId, id));
      this.rosterCertService.remove(Wrappers.lambdaQuery(ProjectManageRosterCert.class).eq(ProjectManageRosterCert::getRosterId, id));
      return true;
   }

   @Override
   public Map<String, Integer> ageStatistics(Long projectId) {
      List<ProjectManageRoster> list = this.baseService.list(Wrappers.lambdaQuery(ProjectManageRoster.class).eq(ProjectManageRoster::getProjectId, projectId));
      List<Integer> knownAges = list.stream().map(ProjectManageRoster::getAge).filter(age -> age != null).collect(Collectors.toList());
      Long thirtyAgeUnder = knownAges.stream().filter(age -> age < 30).count();
      Long thirtyAgeToFortyFiveAge = knownAges.stream().filter(age -> age >= 30 && age < 45).count();
      Long fortyFiveAgeToSixtyAge = knownAges.stream().filter(age -> age >= 45 && age < 60).count();
      Long sixtyAgeAbove = knownAges.stream().filter(age -> age >= 60).count();
      return MapUtil.builder("all", list.size())
         .put("thirtyAgeUnder", thirtyAgeUnder.intValue())
         .put("thirtyAgeToFortyFiveAge", thirtyAgeToFortyFiveAge.intValue())
         .put("fortyFiveAgeToSixtyAge", fortyFiveAgeToSixtyAge.intValue())
         .put("sixtyAgeAbove", sixtyAgeAbove.intValue())
         .build();
   }

   @Override
   public void exportRosterTemplate(HttpServletResponse response) {
      String resourcePath = "files/RosterImportTemplate.xlsx";
      String exportFileName = "劳务人员导入模板.xlsx";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(exportFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         this.log.error("文件下载异常，请联系管理员, {}", e);
      }

      if (file != null) {
         FileUtil.downloadFile(file, exportFileName);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean importRoster(MultipartFile file, Long projectId, HttpServletResponse response) {
      List<ProjectManageRosterImportDTO> importDTOS = new ArrayList<>();
      Preconditions.checkArgument(projectId != null, "请先选择项目");
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      List<MistakeExportDTO> mistakeExportDTOList = new ArrayList<>(1024);
      int titleRows = 1;
      int headerRows = 1;
      Integer startSheetIndex = 0;

      try {
         importDTOS = PoiUtils.importExcel(file, titleRows, headerRows, startSheetIndex, ProjectManageRosterImportDTO.class);
      } catch (Exception e) {
         e.printStackTrace();
      }

      if (importDTOS.isEmpty()) {
         mistakeExportDTOList.add(this.getMistakeDTO(null, "劳务清单中无数据!!!"));
         this.exportMistakeList(response, mistakeExportDTOList);
      }

      if (!importDTOS.stream().allMatch(e -> e.getOrderNo() != null)) {
         mistakeExportDTOList.add(this.getMistakeDTO(null, "劳务清单序号不能为空!!!"));
         this.exportMistakeList(response, mistakeExportDTOList);
      }

      this.checkRepeat(importDTOS, mistakeExportDTOList);
      this.exportMistakeList(response, mistakeExportDTOList);
      this.checkImportData(importDTOS, mistakeExportDTOList, projectId);
      this.exportMistakeList(response, mistakeExportDTOList);
      this.checkRosterInfo(importDTOS, projectId, mistakeExportDTOList);
      this.exportMistakeList(response, mistakeExportDTOList);
      importDTOS.forEach(e -> {
         String idNumberTemp = e.getIdNumber();
         if (StrUtil.length(idNumberTemp) == 15) {
            idNumberTemp = IdcardUtil.convert15To18(idNumberTemp);
         }

         ProjectManageRosterSaveParam param = new ProjectManageRosterSaveParam();
         param.setProjectId(projectId);
         param.setHomeAddress(e.getAddress());
         param.setNation(e.getNation());
         param.setIdNumber(e.getIdNumber());
         param.setSupplierId(e.getSupplierId());
         param.setWorkType(e.getWorkTypValue());
         param.setSex(IdcardUtil.getGenderByIdCard(idNumberTemp) == 1 ? 0 : 1);
         param.setAge(IdcardUtil.getAgeByIdCard(idNumberTemp));
         param.setBirthDate(IdcardUtil.getBirthDate(idNumberTemp).toSqlDate().toString());
         param.setName(e.getName());
         param.setUserId(e.getUserId());
         param.setEntryDate(e.getStartDate());
         param.setBoolCert(false);
         param.setStatus(EmployeeStatusEnum.ON_JOB.getType());
         ProjectManageRoster roster = BeanUtil.toBean(param, ProjectManageRoster.class);
         roster.setRosterNumber(this.generateRosterNumber("C", param.getProjectId()));
         roster.setBoolCert(Boolean.FALSE);
         this.baseService.save(roster);
         this.attendanceService.saveRosterAttendanceInfo(roster);
      });
      return true;
   }

   @Override
   public void downloadRosterQR(ProjectManageRosterQuery query) {
      ContractProject project = this.projectService.getById(query.getProjectId());
      Preconditions.checkArgument(project != null, "操作失败！项目不存在！");
      List<ProjectManageRosterDTO> list = this.baseService.rosterList(query);
      Map<String, String> wokeNameMap = this.dictionaryService
         .listByName(DictionaryEnum.SITE_WORK_TYPE.getName())
         .stream()
         .collect(Collectors.toMap(SysDictionary::getValue, SysDictionary::getLabel));
      Map<Long, String> supplierNameMap = this.subcontractManageBiz
         .getInstallOrderSupplierInfoList(query.getProjectId())
         .stream()
         .collect(Collectors.toMap(SupplierInfo::getSupplierId, SupplierInfo::getSupplierName));
      String resourcePath = "files/LaborCodeTemplate.png";
      ClassPathResource resource = new ClassPathResource(resourcePath);
      String basePhotoUrl = null;

      try {
         basePhotoUrl = resource.getFile().getAbsolutePath();
      } catch (IOException e) {
         e.printStackTrace();
      }

      Preconditions.checkArgument(basePhotoUrl != null, "操作失败，基础照片不存在！");
      String packageUrl = this.configProperties.getFilePath() + project.getName() + "劳务二维码";
      File file = new File(packageUrl);
      if (!file.exists()) {
         FileUtil.mkdirs(packageUrl);
      }

      String finalBasePhotoUrl = basePhotoUrl;
      list.forEach(
         rosterDTO -> {
            rosterDTO.setWokeName(wokeNameMap.getOrDefault(rosterDTO.getWorkType(), null));
            rosterDTO.setSupplierName(supplierNameMap.getOrDefault(rosterDTO.getSupplierId(), null));
            String outImagePath = packageUrl
               + File.separator
               + rosterDTO.getSupplierName()
               + "-"
               + rosterDTO.getName()
               + "-"
               + rosterDTO.getRosterNumber()
               + ".png";
            this.drawCustomImage(rosterDTO, finalBasePhotoUrl, outImagePath);
         }
      );

      try {
         ZipUtil.zip(packageUrl);
         FileUtil.downloadFile(packageUrl + ".zip");
      } catch (Exception e1) {
         e1.printStackTrace();
      } finally {
         FileUtil.deleteFile(packageUrl);
         FileUtil.deleteFile(packageUrl + ".zip");
      }
   }

   private void drawCustomImage(ProjectManageRosterDTO rosterDTO, String sourceImagePath, String outImagePath) {
      try {
         File file = new File(sourceImagePath);
         Image srcImg = ImageIO.read(file);
         int srcImgWidth = srcImg.getWidth(null);
         int srcImgHeight = srcImg.getHeight(null);
         BufferedImage resultImage = new BufferedImage(srcImgWidth, srcImgHeight, 1);
         Graphics2D resultG2 = resultImage.createGraphics();
         resultG2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         resultG2.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
         QrConfig config = new QrConfig(130, 130);
         config.setMargin(0);
         BufferedImage qrCodeImage = QrCodeUtil.generate("128|1|99", config);
         int spacing = 16;
         BufferedImage backgroundImage = new BufferedImage(qrCodeImage.getWidth() + spacing, qrCodeImage.getHeight() + spacing, 2);
         Graphics2D backgroundG2 = backgroundImage.createGraphics();
         int radius = 20;
         backgroundG2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         backgroundG2.fillRoundRect(0, 0, qrCodeImage.getWidth() + spacing, qrCodeImage.getHeight() + spacing, radius, radius);
         backgroundG2.drawImage(qrCodeImage, spacing / 2, spacing / 2, null);
         backgroundG2.dispose();
         resultG2.drawImage(backgroundImage, 500, 27, null);
         Font font = new Font("SimHei", 0, 36);
         resultG2.setFont(font);
         resultG2.setColor(Color.WHITE);
         String name = rosterDTO.getName();
         int nameX = 130;
         int nameY = 197;
         resultG2.drawString(name, nameX, nameY);
         String workType = rosterDTO.getWokeName();
         int workTypeX = 130;
         int workTypeY = 245;
         resultG2.drawString(workType, workTypeX, workTypeY);
         String supplierName = rosterDTO.getSupplierName();
         int supplierNameX = 180;
         int supplierNameY = 293;
         resultG2.drawString(supplierName, supplierNameX, supplierNameY);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String entryDate = rosterDTO.getCreateTime().format(formatter);
         int entryDateX = 185;
         int entryDateY = 341;
         resultG2.drawString(entryDate, entryDateX, entryDateY);
         String phone = rosterDTO.getPhone();
         int phoneX = 290;
         int phoneY = 389;
         resultG2.drawString(phone, phoneX, phoneY);
         String number = rosterDTO.getRosterNumber();
         resultG2.dispose();
         BufferedImage newImage = (BufferedImage)ImgUtil.pressText(
            resultImage,
            number,
            Color.YELLOW,
            new Font("黑体", 1, resultImage.getWidth() / number.length()),
            0,
            resultImage.getHeight() / 2 - resultImage.getWidth() / number.length() / 2,
            0.4F
         );
         FileOutputStream outImgStream = new FileOutputStream(outImagePath);
         ImageIO.write(newImage, "png", outImgStream);
         outImgStream.flush();
         outImgStream.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public List<String> nationList() {
      return this.baseService.nationList();
   }

   @Override
   public PrintVO<List<Map<String, Object>>> qrCodePrint(Long id) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> headerMap = printVO.initHeader(UserUtil.getCurrentName());
      headerMap.put("title", "花名册人员信息二维码");
      printVO.setHeader(headerMap);
      printVO.setQrCode("128|2|" + id);
      return printVO;
   }

   private void checkImportData(List<ProjectManageRosterImportDTO> importDTOS, List<MistakeExportDTO> mistakeExportDTOList, Long projectId) {
      Map<String, String> wokeNameMap = this.dictionaryService
         .listByName(DictionaryEnum.SITE_WORK_TYPE.getName())
         .stream()
         .collect(Collectors.toMap(SysDictionary::getLabel, SysDictionary::getValue));
      Map<String, Long> supplierMap = this.subcontractManageBiz
         .getInstallOrderSupplierInfoList(projectId)
         .stream()
         .collect(Collectors.toMap(SupplierInfo::getSupplierName, SupplierInfo::getSupplierId));
      importDTOS.forEach(item -> {
         item.setNation(org.apache.commons.lang3.StringUtils.deleteWhitespace(item.getNation()));
         item.setSupplierName(org.apache.commons.lang3.StringUtils.deleteWhitespace(item.getSupplierName()));
         item.setAddress(org.apache.commons.lang3.StringUtils.deleteWhitespace(item.getAddress()));
         item.setPhone(org.apache.commons.lang3.StringUtils.deleteWhitespace(item.getPhone()));
         item.setIdNumber(org.apache.commons.lang3.StringUtils.deleteWhitespace(item.getIdNumber()));
         item.setWorkTypeName(org.apache.commons.lang3.StringUtils.deleteWhitespace(item.getWorkTypeName()));
         item.setName(org.apache.commons.lang3.StringUtils.deleteWhitespace(item.getName()));
         if (StrUtil.isBlank(item.getName())) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "名称未填写"));
         } else if (item.getName().length() > 64) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "名称超过64个字符"));
         }

         if (item.getStartDate() == null) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "入职日期未填写或是入职日期格式不为 yyyy/MM/dd"));
         }

         if (StrUtil.isBlank(item.getNation())) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "民族未填写！"));
         } else if (!NationEnum.exists(item.getNation())) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "民族不存在！"));
         }

         if (StrUtil.isBlank(item.getAddress())) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "地址未填写"));
         } else if (item.getAddress().length() > 128) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "地址超过128个字符"));
         }

         if (StrUtil.isBlank(item.getPhone())) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "联系方式未填写"));
         } else if (!Pattern.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", item.getPhone())) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "联系方式填写有误"));
         }

         if (StrUtil.isBlank(item.getIdNumber())) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "身份证号码未填写"));
         } else if (!IdcardUtil.isValidCard(item.getIdNumber())) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "身份证号码填写有误"));
         }

         if (StrUtil.isBlank(item.getWorkTypeName())) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "工种未填写！"));
         } else if (!wokeNameMap.containsKey(item.getWorkTypeName())) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "系统暂无该工种信息"));
         } else {
            item.setWorkTypValue(wokeNameMap.get(item.getWorkTypeName()));
         }

         if (StrUtil.isBlank(item.getSupplierName())) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "分供方未填写！"));
         } else if (supplierMap.get(item.getSupplierName()) == null) {
            mistakeExportDTOList.add(this.getMistakeDTO(item.getOrderNo(), "系统暂无该分供方信息！"));
         } else {
            item.setSupplierId(supplierMap.get(item.getSupplierName()));
         }
      });
   }

   private void checkRepeat(List<ProjectManageRosterImportDTO> importDTOS, List<MistakeExportDTO> mistakeExportDTOList) {
      Map<String, List<ProjectManageRosterImportDTO>> groupedByPhone = importDTOS.stream()
         .collect(Collectors.groupingBy(ProjectManageRosterImportDTO::getPhone));
      Map<String, List<ProjectManageRosterImportDTO>> groupedByIdNumber = importDTOS.stream()
         .collect(Collectors.groupingBy(ProjectManageRosterImportDTO::getIdNumber));
      if (groupedByPhone.keySet().size() != importDTOS.size()) {
         List<List<ProjectManageRosterImportDTO>> reiteratedPhoneList = groupedByPhone.values().stream().filter(e -> e.size() > 1).collect(Collectors.toList());
         reiteratedPhoneList.forEach(e -> mistakeExportDTOList.add(this.getMistakeDTO(e.get(0).getOrderNo(), "手机号存在重复请检查后重新导入")));
      }

      if (groupedByIdNumber.keySet().size() != importDTOS.size()) {
         List<List<ProjectManageRosterImportDTO>> reiteratedIdNumberList = groupedByIdNumber.values()
            .stream()
            .filter(e -> e.size() > 1)
            .collect(Collectors.toList());
         reiteratedIdNumberList.forEach(e -> mistakeExportDTOList.add(this.getMistakeDTO(e.get(0).getOrderNo(), "身份证存在重复请检查后重新导入")));
      }
   }

   private void checkRosterInfo(List<ProjectManageRosterImportDTO> importDTOS, Long projectId, List<MistakeExportDTO> mistakeExportDTOList) {
      List<String> phones = importDTOS.stream().map(ProjectManageRosterImportDTO::getPhone).collect(Collectors.toList());
      Map<String, User> userMap = this.userService
         .list(Wrappers.lambdaQuery(User.class).notLike(User::getUsername, "FBS").in(User::getPhone, phones))
         .stream()
         .collect(Collectors.toMap(User::getPhone, Function.identity()));
      importDTOS.forEach(e -> {
         User user = userMap.get(e.getPhone());
         if (user != null) {
            if (UserTypeEnum.COMMON_USER.getType().equals(user.getUserType())) {
               mistakeExportDTOList.add(this.getMistakeDTO(e.getOrderNo(), "该劳务账号已被系统用户占用！"));
            } else {
               this.exist(mistakeExportDTOList, e, projectId, user.getId());
            }
         } else {
            user = new User();
            user.setUsername(e.getPhone());
            user.setName(e.getName());
            user.setSex(IdcardUtil.getGenderByIdCard(e.getIdNumber()));
            user.setPhone(e.getPhone());
            user.setUserType(UserTypeEnum.TEMP_USER.getType());
            user.setPassword(this.passwordEncoder.encode(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required")));
            this.userService.save(user);
            this.exist(mistakeExportDTOList, e, projectId, user.getId());
         }

         e.setUserId(user.getId());
      });
   }

   private void exist(List<MistakeExportDTO> mistakeExportDTOList, ProjectManageRosterImportDTO importDTO, Long projectId, Long userId) {
      ProjectManageRoster otherProjectRoster = this.baseService
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .ne(ProjectManageRoster::getProjectId, projectId)
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
               .and(qw -> {
                  LambdaQueryWrapper var10000 = qw.eq(ProjectManageRoster::getUserId, userId)
                     .or()
                     .eq(ProjectManageRoster::getIdNumber, importDTO.getIdNumber());
               })
         );
      if (otherProjectRoster != null) {
         mistakeExportDTOList.add(
            this.getMistakeDTO(importDTO.getOrderNo(), this.projectService.getById(otherProjectRoster.getProjectId()).getShortName() + " 项目中是在职状态！")
         );
      }

      ProjectManageRoster projectRoster = this.baseService
         .getOne(Wrappers.lambdaQuery(ProjectManageRoster.class).eq(ProjectManageRoster::getProjectId, projectId).and(qw -> {
            LambdaQueryWrapper var10000 = qw.eq(ProjectManageRoster::getUserId, userId).or().eq(ProjectManageRoster::getIdNumber, importDTO.getIdNumber());
         }));
      if (projectRoster != null) {
         mistakeExportDTOList.add(this.getMistakeDTO(importDTO.getOrderNo(), "该劳务在当前项目中已存在！"));
      }
   }

   private MistakeExportDTO getMistakeDTO(Integer orderNo, String message) {
      MistakeExportDTO mistake = new MistakeExportDTO();
      mistake.setOrderNo(orderNo);
      mistake.setErrorMessage(message);
      return mistake;
   }

   private void exportMistakeList(HttpServletResponse response, List<MistakeExportDTO> mistakeExportDTOList) {
      if (CollectionUtils.isNotEmpty(mistakeExportDTOList)) {
         String title = "劳务人员信息导入出错表";
         String sheetName = "劳务人员信息导入出错表";
         String fileName = "劳务人员信息导入出错表.xlsx";

         try {
            response.setHeader("result", "code=50000;message=" + URLEncoder.encode("数据导入失败,具体信息请查看错误表格!", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         PoiUtils.exportExcel(mistakeExportDTOList, title, sheetName, MistakeExportDTO.class, fileName, ExcelType.XSSF, response);
         throw new BusinessException("导入失败,具体信息请查看错误表格!");
      } else {
         try {
            response.setHeader("result", "code=20000;message=" + URLEncoder.encode("导入成功", "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "result");
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }
      }
   }

   private void verifyParams(ProjectManageRosterSaveParam param) {
      Preconditions.checkArgument(CollUtil.newArrayList(0, 1).contains(param.getSex()), "性别不存在");
      Preconditions.checkArgument(0 <= param.getAge() && 130 >= param.getAge(), "出生日期不在有效范围内");
      Preconditions.checkArgument(NationEnum.exists(param.getNation()), "民族不存在");
      if (param.getBoolCert()) {
         Preconditions.checkArgument(CollUtil.isNotEmpty(param.getCerts()), "证书信息不能为空");
         Preconditions.checkArgument(StrUtil.isNotEmpty(param.getCertAttachmentIds()), "证书附件不能为空");
      }

      SysDictionary workTypeDict = this.dictionaryService.getByNameAndValue(DictionaryEnum.SITE_WORK_TYPE.getName(), param.getWorkType());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(workTypeDict), "工种不存在");
      if (CollUtil.isNotEmpty(param.getCerts())) {
         List<String> certTypes = param.getCerts().stream().map(CertSaveParam::getCertType).collect(Collectors.toList());
         Map<String, List<SysDictionary>> certTypeDictGroup = this.dictionaryService
            .list(
               Wrappers.lambdaQuery(SysDictionary.class)
                  .eq(SysDictionary::getName, DictionaryEnum.SITE_CERT_TYPE.getName())
                  .in(SysDictionary::getValue, certTypes)
            )
            .stream()
            .collect(Collectors.groupingBy(SysDictionary::getValue));
         param.getCerts().forEach(cert -> {
            List<SysDictionary> certTypeDict = certTypeDictGroup.get(cert.getCertType());
            Preconditions.checkArgument(BeanUtil.isNotEmpty(certTypeDict), "证书类型不存在");
         });
      }

      if (param.getId() == null) {
         ProjectManageRoster otherProjectRoster = this.baseService
            .getOne(
               Wrappers.lambdaQuery(ProjectManageRoster.class)
                  .ne(ProjectManageRoster::getProjectId, param.getProjectId())
                  .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
                  .and(
                     qw -> {
                        LambdaQueryWrapper var10000 = qw.eq(ProjectManageRoster::getUserId, param.getUserId())
                           .or()
                           .eq(ProjectManageRoster::getIdNumber, param.getIdNumber());
                     }
                  )
            );
         if (otherProjectRoster != null) {
            throw new BusinessException("操作失败！该劳务在 " + this.projectService.getById(otherProjectRoster.getProjectId()).getShortName() + " 项目中是在职状态！");
         }

         ProjectManageRoster projectRoster = this.baseService
            .getOne(
               Wrappers.lambdaQuery(ProjectManageRoster.class)
                  .eq(ProjectManageRoster::getProjectId, param.getProjectId())
                  .and(
                     qw -> {
                        LambdaQueryWrapper var10000 = qw.eq(ProjectManageRoster::getUserId, param.getUserId())
                           .or()
                           .eq(ProjectManageRoster::getIdNumber, param.getIdNumber());
                     }
                  )
            );
         if (projectRoster != null) {
            throw new BusinessException("操作失败！该劳务在当前项目中已存在！");
         }
      }

      if (param.getId() != null) {
         ProjectManageRoster roster = this.baseService.getById(param.getId());
         if (StrUtil.isNotBlank(param.getIdNumber()) && !param.getIdNumber().equals(roster.getIdNumber())) {
            ProjectManageRoster hasRoster = this.baseService
               .getOne(
                  Wrappers.lambdaQuery(ProjectManageRoster.class)
                     .ne(ProjectManageRoster::getProjectId, param.getProjectId())
                     .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
                     .eq(ProjectManageRoster::getIdNumber, param.getIdNumber())
               );
            if (hasRoster != null) {
               throw new BusinessException("操作失败！该劳务在 " + this.projectService.getById(hasRoster.getProjectId()).getShortName() + " 项目中是在职状态！");
            }

            ProjectManageRoster projectRoster = this.baseService
               .getOne(
                  Wrappers.lambdaQuery(ProjectManageRoster.class)
                     .eq(ProjectManageRoster::getProjectId, param.getProjectId())
                     .eq(ProjectManageRoster::getIdNumber, param.getIdNumber())
               );
            if (projectRoster != null) {
               throw new BusinessException("操作失败！该劳务在当前项目中已存在！");
            }
         }
      }
   }
}
