package com.hzchum.scim.mes.building.core.biz.impl.laborManagement;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.NationEnum;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.mes.building.core.api.biz.laborManagement.MesRosterBiz;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendance;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfigUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRosterCert;
import com.hzchum.scim.mes.building.core.api.pojo._dto.laborManagement.MesRosterDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesRosterQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesRosterSaveParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.laborManagement.MesRosterSaveParam.CertSaveParam;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceStandConfigService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesBehaviorTotalScoreService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterCertService;
import com.hzchum.scim.mes.building.core.api.service.laborManagement.MesRosterService;
import com.hzchum.scim.mes.building.core.mapper.laborManagement.MesRosterMapper;
import com.hzchum.scim.system.core.api.biz.UserBiz;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.UserSaveRequestVO;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
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
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesRosterBizImpl extends IBizImpl<MesRosterService, MesRosterMapper, MesRoster> implements MesRosterBiz {
   @Autowired
   private AttachmentService attachmentService;
   @Autowired
   private SysDictionaryService dictionaryService;
   @Autowired
   private MesRosterCertService rosterCertService;
   @Autowired
   private UserService userService;
   @Autowired
   private UserBiz userBiz;
   @Autowired
   private MesBehaviorTotalScoreService behaviorTotalScoreService;
   @Autowired
   private MesBuildingAttendanceStandConfigService standConfigService;
   @Autowired
   private MesBuildingAttendanceService attendanceService;
   @Autowired
   private MesBuildingAttendanceOverConfigService overConfigService;
   @Autowired
   private MesBuildingAttendanceOverConfigUserLinkService overConfigUserLinkService;

   @Override
   public PageVO<MesRosterDTO> rosterPage(MesRosterQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesRosterDTO> list = this.baseService.rosterList(query);
      return new PageVO<>(page, list);
   }

   @Override
   public void rosterDownload(MesRosterQuery query, HttpServletResponse response) {
      List<MesRosterDTO> list = this.baseService.rosterList(query);
      list.sort(Comparator.<MesRosterDTO, Long>comparing(MesRoster::getId).reversed());
      if (!CollectionUtils.isEmpty(list)) {
         AtomicInteger index = new AtomicInteger(0);
         List<List<String>> headList = new ArrayList<>();
         headList.add(Arrays.asList("序号"));
         headList.add(Arrays.asList("入职时间"));
         headList.add(Arrays.asList("编号"));
         headList.add(Arrays.asList("姓名"));
         headList.add(Arrays.asList("年龄"));
         headList.add(Arrays.asList("性别"));
         headList.add(Arrays.asList("民族"));
         headList.add(Arrays.asList("身份证号"));
         headList.add(Arrays.asList("家庭住址"));
         headList.add(Arrays.asList("联系方式"));
         headList.add(Arrays.asList("剩余行为分"));
         headList.add(Arrays.asList("累计处罚（元）"));
         headList.add(Arrays.asList("所属单位"));
         headList.add(Arrays.asList("状态"));
         List<List<Object>> dataList = new ArrayList<>();
         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         list.forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(index.incrementAndGet());
            LocalDateTime createTime = ex.getCreateTime();
            data.add(createTime != null ? createTime.format(formatter2) : "-");
            data.add(ex.getUsername());
            data.add(ex.getName());
            data.add(ex.getAge());
            data.add(ex.getSex().equals(0) ? "男" : "女");
            data.add(ex.getNation());
            data.add(ex.getIdNumber());
            data.add(ex.getHomeAddress());
            data.add(ex.getPhone());
            data.add(ex.getRemainingBehaviorScore());
            data.add(ex.getCumulativePenalty());
            data.add(ex.getSupplierName());
            data.add(ex.getStatus().equals(1) ? "在职" : "离职");
            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "花名册人员信息.xlsx");
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
               .sheet("花名册人员信息")
               .doWrite(dataList);
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   @Override
   public List<String> nationList() {
      return this.baseService.nationList();
   }

   @Override
   public Map<String, Integer> ageStatistics() {
      List<MesRoster> list = this.baseService.list();
      List<Integer> knownAges = list.stream().map(MesRoster::getAge).filter(age -> age != null).collect(Collectors.toList());
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
   public MesRosterDTO getRosterInfo(Long id) {
      List<MesRosterDTO> list = this.baseService.rosterList(MesRosterQuery.builder().id(id).build());
      Preconditions.checkArgument(CollUtil.isNotEmpty(list) && list.size() == 1, "当前花名册人员不存在, 请刷新后重试");
      return list.get(0);
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

   @Override
   public MesRosterDTO getWxAppRosterInfo() {
      MesRoster roster = this.baseService.getOne(Wrappers.lambdaQuery(MesRoster.class).eq(MesRoster::getUserId, UserUtil.getCurrentUserId()));
      return BeanUtil.toBean(roster, MesRosterDTO.class);
   }

   private void verifyParams(MesRosterSaveParam param) {
      Preconditions.checkArgument(CollUtil.newArrayList(0, 1).contains(param.getSex()), "性别不存在");
      Preconditions.checkArgument(0 <= param.getAge() && 130 >= param.getAge(), "出生日期不在有效范围内");
      Preconditions.checkArgument(NationEnum.exists(param.getNation()), "民族不存在");
      if (param.getBoolCert()) {
         Preconditions.checkArgument(CollUtil.isNotEmpty(param.getCerts()), "证书信息不能为空");
         Preconditions.checkArgument(StrUtil.isNotEmpty(param.getCertAttachmentIds()), "证书附件不能为空");
      }

      SysDictionary workTypeDict = this.dictionaryService.getByNameAndValue(DictionaryEnum.WORK_TYPE.getName(), param.getWorkType());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(workTypeDict), "工种不存在");
      if (CollUtil.isNotEmpty(param.getCerts())) {
         List<String> certTypes = param.getCerts().stream().map(CertSaveParam::getCertType).collect(Collectors.toList());
         Map<String, List<SysDictionary>> certTypeDictGroup = this.dictionaryService
            .list(
               Wrappers.lambdaQuery(SysDictionary.class).eq(SysDictionary::getName, DictionaryEnum.CERT_TYPE.getName()).in(SysDictionary::getValue, certTypes)
            )
            .stream()
            .collect(Collectors.groupingBy(SysDictionary::getValue));
         param.getCerts().forEach(cert -> {
            List<SysDictionary> certTypeDict = certTypeDictGroup.get(cert.getCertType());
            Preconditions.checkArgument(BeanUtil.isNotEmpty(certTypeDict), "证书类型不存在");
         });
      }

      int count = this.baseService
         .count(Wrappers.lambdaQuery(MesRoster.class).eq(MesRoster::getUserId, param.getUserId()).ne(param.getId() != null, MesRoster::getId, param.getId()));
      Preconditions.checkArgument(count == 0, "当前用户已存在花名册人员");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveRoster(MesRosterSaveParam param) {
      if (param.getUserId() == null) {
         UserSaveRequestVO userSaveRequestVO = param.getUserSaveRequestVO();
         Preconditions.checkArgument(userSaveRequestVO.getPhone() != null, "手机号不能为空");
         Preconditions.checkArgument(userSaveRequestVO.getUsername() != null, "员工编号不能为空");
         Preconditions.checkArgument(userSaveRequestVO.getDeptId() != null, "部门编号不能为空");
         Preconditions.checkArgument(Pattern.matches("[A-Za-z0-9]{4,16}", userSaveRequestVO.getUsername()), "员工编号不符合规范");
         userSaveRequestVO.setName(param.getName());
         userSaveRequestVO.setSex(param.getSex());
         this.userBiz.register(userSaveRequestVO);
         User user = this.userService.getByPhone(param.getUserSaveRequestVO().getPhone());
         param.setUserId(user.getId());
      } else {
         User user = this.userService.getById(param.getUserId());
         Preconditions.checkArgument(UserTypeEnum.COMMON_USER.getType().equals(user.getUserType()), "操作失败，该手机号已注册为现场劳务！");
         user.setIsEnabled(Boolean.TRUE);
         this.userService.updateById(user);
      }

      LocalDate now = LocalDate.now();
      Long age = ChronoUnit.YEARS.between(LocalDate.parse(param.getBirthDate()), now);
      param.setAge(age.intValue());
      this.verifyParams(param);
      MesRoster roster = BeanUtil.toBean(param, MesRoster.class);
      Integer behaviorTotalScore = this.behaviorTotalScoreService.getTotalScore(null, param.getEntryDate(), now.getYear());
      roster.setBehaviorTotalScore(behaviorTotalScore);
      this.baseService.save(roster);
      this.standConfigService.saveRosterAttendanceInfo(roster);
      if (CollUtil.isNotEmpty(param.getCerts())) {
         List<MesRosterCert> rosterCertList = param.getCerts().stream().map(cert -> {
            MesRosterCert rosterCert = BeanUtil.toBean(cert, MesRosterCert.class);
            rosterCert.setRosterId(roster.getId());
            return rosterCert;
         }).collect(Collectors.toList());
         this.rosterCertService.saveBatch(rosterCertList);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateRoster(MesRosterSaveParam param) {
      MesRoster oldRoster = this.baseService.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldRoster), "当前数据不存在, 请刷新后重试");
      Long age = ChronoUnit.YEARS.between(LocalDate.parse(param.getBirthDate()), LocalDate.now());
      param.setAge(age.intValue());
      this.verifyParams(param);
      MesRoster roster = BeanUtil.toBean(param, MesRoster.class);
      this.baseService.updateById(roster);
      this.rosterCertService.remove(Wrappers.lambdaQuery(MesRosterCert.class).eq(MesRosterCert::getRosterId, roster.getId()));
      if (CollUtil.isNotEmpty(param.getCerts())) {
         List<MesRosterCert> rosterCertList = param.getCerts().stream().map(cert -> {
            MesRosterCert rosterCert = BeanUtil.toBean(cert, MesRosterCert.class);
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
      MesRoster oldRoster = this.baseService.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldRoster), "当前数据不存在, 请刷新后重试");
      this.baseService.update(Wrappers.lambdaUpdate(MesRoster.class).eq(MesRoster::getId, id).set(MesRoster::getStatus, status));
      if (EmployeeStatusEnum.DIMISSION.getType().equals(status)) {
         this.userService.update(Wrappers.lambdaUpdate(User.class).eq(User::getId, oldRoster.getUserId()).set(User::getIsEnabled, false));
      }

      if (EmployeeStatusEnum.ON_JOB.getType().equals(status)) {
         this.userService.update(Wrappers.lambdaUpdate(User.class).eq(User::getId, oldRoster.getUserId()).set(User::getIsEnabled, true));
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteRoster(Long id) {
      MesRoster oldRoster = this.baseService.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldRoster), "当前数据不存在, 请刷新后重试");
      if (EmployeeStatusEnum.ON_JOB.getType().equals(oldRoster.getStatus())) {
         this.userService.update(Wrappers.lambdaUpdate(User.class).eq(User::getId, oldRoster.getUserId()).set(User::getIsEnabled, false));
      }

      this.baseService.removeById(id);
      this.rosterCertService.remove(Wrappers.lambdaQuery(MesRosterCert.class).eq(MesRosterCert::getRosterId, id));
      this.attendanceService.remove(Wrappers.lambdaQuery(MesBuildingAttendance.class).eq(MesBuildingAttendance::getRosterId, id));
      List<MesBuildingAttendanceOverConfigUserLink> overConfigUserLinkList = this.overConfigUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class).eq(MesBuildingAttendanceOverConfigUserLink::getRosterId, id));
      if (CollUtil.isNotEmpty(overConfigUserLinkList)) {
         List<Long> overConfigIds = overConfigUserLinkList.stream().map(MesBuildingAttendanceOverConfigUserLink::getOverConfigId).collect(Collectors.toList());
         Map<Long, List<Long>> configRosterMap = this.overConfigUserLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class).in(MesBuildingAttendanceOverConfigUserLink::getOverConfigId, overConfigIds)
            )
            .stream()
            .collect(
               Collectors.groupingBy(
                  MesBuildingAttendanceOverConfigUserLink::getOverConfigId,
                  Collectors.mapping(MesBuildingAttendanceOverConfigUserLink::getRosterId, Collectors.toList())
               )
            );
         Map<Long, List<Long>> filteredMap = configRosterMap.entrySet()
            .stream()
            .filter(entry -> entry.getValue().size() == 1)
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         if (CollUtil.isNotEmpty(filteredMap.keySet())) {
            this.overConfigService.removeByIds(filteredMap.keySet());
         }

         this.overConfigUserLinkService
            .remove(Wrappers.lambdaQuery(MesBuildingAttendanceOverConfigUserLink.class).eq(MesBuildingAttendanceOverConfigUserLink::getRosterId, id));
      }

      return true;
   }
}
