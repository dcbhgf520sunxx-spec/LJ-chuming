package com.hzchum.scim.system.core.api.common.utils.notification;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.CrudTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.ShrUserChangeRecord;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class NotificationTemplateDetailsUtils {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private UserService userService;

   public StringBuffer getUser() {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Department department = currentUser.getDepartment();
      Preconditions.checkArgument(department != null, "操作失败,当前登录人员未配置部门!");
      return new StringBuffer()
         .append("【")
         .append(UserUtil.getCurrentUser().getDepartment().getName())
         .append("-")
         .append(UserUtil.getCurrentName())
         .append("】");
   }

   public StringBuffer getProjectTemplateDetails(String serialNumber, String shortName, Boolean isCreate) {
      StringBuffer DEPA_USERNAME = this.getUser();
      return isCreate
         ? DEPA_USERNAME.append("创建了").append("《").append(serialNumber).append("+").append(shortName).append("》").append("项目，请关注!")
         : DEPA_USERNAME.append("修改了").append("《").append(serialNumber).append("+").append(shortName).append("》").append("项目信息，请关注！");
   }

   public StringBuffer getLogisticsSettingDetails(String serialNumber, String shortName) {
      return new StringBuffer().append("《").append(serialNumber).append("+").append(shortName).append("》已创建，请及时设置物流费用！");
   }

   public StringBuffer getAreaTemplateDetails(String serialNumber, String shortName, String argument) {
      return this.getUser()
         .append("创建了")
         .append("《")
         .append(serialNumber)
         .append("+")
         .append(shortName)
         .append("》")
         .append(" ")
         .append("[")
         .append(argument)
         .append("]")
         .append("区域，请关注！");
   }

   public StringBuffer getMonomerAreaTemplateDetails(String serialNumber, String shortName, String MonomerName, String AreaName) {
      return ObjectUtil.isEmpty(AreaName)
         ? this.getUser()
            .append("创建了")
            .append("《")
            .append(serialNumber)
            .append("+")
            .append(shortName)
            .append("》")
            .append(" ")
            .append("[")
            .append(MonomerName)
            .append("]")
            .append("单体，请关注！")
         : this.getUser()
            .append("创建了")
            .append("《")
            .append(serialNumber)
            .append("+")
            .append(shortName)
            .append("》")
            .append(" ")
            .append("[")
            .append(MonomerName)
            .append("-")
            .append(AreaName)
            .append("]")
            .append("区域，请关注！");
   }

   public StringBuffer getSubscribeTemplateDetails(String projectId, String argument) {
      ContractProject pro = this.projectService.getById(projectId);
      return this.getUser()
         .append("创建了")
         .append("[")
         .append(ObjectUtil.isNotEmpty(pro) ? pro.getSerialNumber() : "-")
         .append("+")
         .append(ObjectUtil.isNotEmpty(pro) ? pro.getShortName() : "-")
         .append("]")
         .append(" ")
         .append("[")
         .append(argument)
         .append("]")
         .append("的材料申购，请关注！");
   }

   public StringBuffer getPurchaseOrderDetails(String serialNumber, BigDecimal amount, String supplierName) {
      return this.getUser()
         .append("创建了")
         .append("[")
         .append(serialNumber)
         .append("]")
         .append("采购订单,")
         .append(" ")
         .append("合同额[")
         .append(amount)
         .append("],")
         .append("供应商")
         .append("[")
         .append(supplierName)
         .append("]。");
   }

   public StringBuffer getDetailedTemplateDetails(Object project, Object monomer, Object area, String argument, Boolean isImport) {
      ContractProject pro = this.projectService.getById((Long)project);
      String monomerName = this.monomerService.getMonomerById((Long)monomer).getName();
      PlanArea planArea = this.areaService.getById((Long)area);
      String areaName = "";
      if (planArea != null) {
         areaName = this.areaService.getById((Long)area).getName();
      }

      return isImport
         ? this.getUser()
            .append("导入了")
            .append("《")
            .append(ObjectUtil.isNotEmpty(pro) ? pro.getSerialNumber() : "-")
            .append("+")
            .append(ObjectUtil.isNotEmpty(pro) ? pro.getShortName() : "-")
            .append("》")
            .append(" ")
            .append("[")
            .append(monomerName)
            .append("-")
            .append(areaName)
            .append("]")
            .append(" ")
            .append("[")
            .append(argument)
            .append("]")
            .append("清单，请关注！")
         : this.getUser()
            .append("删除了")
            .append("《")
            .append(ObjectUtil.isNotEmpty(pro) ? pro.getSerialNumber() : "-")
            .append("+")
            .append(ObjectUtil.isNotEmpty(pro) ? pro.getShortName() : "-")
            .append("》")
            .append(" ")
            .append("[")
            .append(monomerName)
            .append("-")
            .append(areaName)
            .append("]")
            .append(" ")
            .append("[")
            .append(argument)
            .append("]")
            .append("清单，请关注！");
   }

   public StringBuffer getDetailedChangeTemplateDetails(Object project, Object monomer, Object area, String argument) {
      ContractProject pro = this.projectService.getById((Long)project);
      String monomerName = this.monomerService.getMonomerById((Long)monomer).getName();
      PlanArea planArea = this.areaService.getById((Long)area);
      String areaName = "";
      if (planArea != null) {
         areaName = this.areaService.getById((Long)area).getName();
      }

      return this.getUser()
         .append("变更了")
         .append("《")
         .append(ObjectUtil.isNotEmpty(pro) ? pro.getSerialNumber() : "-")
         .append("+")
         .append(ObjectUtil.isNotEmpty(pro) ? pro.getShortName() : "-")
         .append("》")
         .append(" ")
         .append("[")
         .append(monomerName)
         .append("-")
         .append(areaName)
         .append("]")
         .append(" ")
         .append("[")
         .append(argument)
         .append("]")
         .append("清单，请关注！");
   }

   public StringBuffer getSteelInventoryDetails(LocalDateTime date, BigDecimal storageQuantity, BigDecimal deliveryVolume, BigDecimal inventory) {
      return new StringBuffer()
         .append("【")
         .append(YearMonth.from(date))
         .append("】")
         .append(" ")
         .append("入库[")
         .append(storageQuantity.divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP))
         .append("]吨;")
         .append(" ")
         .append("出库[")
         .append(deliveryVolume.divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP))
         .append("]吨;")
         .append(" ")
         .append("期末库存[")
         .append(inventory.divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP))
         .append("]吨");
   }

   public StringBuffer getCoCueDetails(String serialNumber, String shortName) {
      return this.getUser().append("创建了").append("《").append(serialNumber).append("+").append(shortName).append("》").append(" ").append("计划，请熟知！");
   }

   public StringBuffer getProcessSlackDetails(Long projectId, String workshopName, String processName, String teamName, Integer unQuantity) {
      return new StringBuffer()
         .append("【")
         .append(workshopName)
         .append("+")
         .append(processName)
         .append("+")
         .append(teamName)
         .append("】")
         .append(" ")
         .append("呆滞数量为")
         .append("[" + unQuantity + "]")
         .append(" ")
         .append("请关注");
   }

   public StringBuffer getProcessLagDetails(Long projectId, String workshopName, String processName, String teamName, String orderNumber) {
      ContractProject pro = this.projectService.getById(projectId);
      return new StringBuffer()
         .append("【")
         .append(workshopName)
         .append("+")
         .append(processName)
         .append("+")
         .append(teamName)
         .append("】")
         .append(" ")
         .append("执行的")
         .append("《")
         .append(pro.getSerialNumber() + "+" + pro.getShortName() + "+" + orderNumber)
         .append("》")
         .append("滞后，请关注！");
   }

   public StringBuffer getCompletionNoticeDetails(Long projectId, String orderNumber) {
      ContractProject project = this.projectService.getById(projectId);
      return new StringBuffer()
         .append("《")
         .append(ObjectUtil.isNotEmpty(project) ? project.getSerialNumber() : "")
         .append("+")
         .append(ObjectUtil.isNotEmpty(project) ? project.getShortName() : "")
         .append("+")
         .append(orderNumber)
         .append("》")
         .append(" ")
         .append("该工单下的任务已完成！");
   }

   public StringBuffer getWeeklyProductionReportDetails(String workshopName, double weeksNetWeight) {
      LocalDateTime now = LocalDateTime.now();
      int year = now.getYear();
      int month = now.getMonthValue();
      int weekOfYear = now.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
      return new StringBuffer()
         .append("【")
         .append(year)
         .append("-")
         .append(month)
         .append("-第")
         .append(weekOfYear)
         .append("周】")
         .append(" ")
         .append("【")
         .append(workshopName)
         .append("】")
         .append(" ")
         .append("完成")
         .append("[")
         .append(String.format("%.2f", weeksNetWeight / 1000.0))
         .append("]吨！");
   }

   public StringBuffer getMonthProductionReportDetails(String workshopName, double monthNetWeight, double totalNetWeight) {
      LocalDateTime now = LocalDateTime.now();
      int year = now.getYear();
      int month = now.getMonthValue();
      return new StringBuffer()
         .append("【")
         .append(year)
         .append("-")
         .append(month)
         .append("】")
         .append(" ")
         .append("【")
         .append(workshopName)
         .append("】")
         .append(" ")
         .append("完成生产")
         .append("[")
         .append(new DecimalFormat("#.00").format(monthNetWeight / 1000.0))
         .append("]吨！")
         .append("全年累计完成生产")
         .append("[")
         .append(new DecimalFormat("#.00").format(totalNetWeight / 1000.0))
         .append("]吨！");
   }

   public StringBuffer getMonthlyDispatchReportDetails(String workshopName, double monthNetWeight, double totalNetWeight) {
      LocalDateTime now = LocalDateTime.now();
      int year = now.getYear();
      int month = now.getMonthValue();
      return new StringBuffer()
         .append("【")
         .append(year)
         .append("-")
         .append(month)
         .append("】")
         .append(" ")
         .append("【")
         .append(workshopName)
         .append("】")
         .append(" ")
         .append("完成发运")
         .append("[")
         .append(new DecimalFormat("#.00").format(monthNetWeight / 1000.0))
         .append("]吨！")
         .append("全年累计完成")
         .append("[")
         .append(new DecimalFormat("#.00").format(totalNetWeight / 1000.0))
         .append("]吨！");
   }

   public StringBuffer getRectificationTipsDetails(String type, String workshopName, Long teamId, Long dutyId, String remark) {
      Map<Long, List<User>> users = this.userService.list().stream().collect(Collectors.groupingBy(User::getId));
      return new StringBuffer()
         .append("【")
         .append(type)
         .append("】")
         .append(" ")
         .append("责任主体")
         .append("[")
         .append(workshopName)
         .append("-")
         .append(CollectionUtils.isNotEmpty(users.get(teamId)) ? users.get(teamId).get(0).getName() : "无")
         .append("];")
         .append(" ")
         .append("检查人")
         .append("[")
         .append(workshopName)
         .append("-")
         .append(CollectionUtils.isNotEmpty(users.get(dutyId)) ? users.get(dutyId).get(0).getName() : "无")
         .append("]")
         .append(" ")
         .append("[")
         .append(remark)
         .append("]")
         .append("未整改时长超过指定时间!");
   }

   public StringBuffer getBehindScheduleDetails(
      String workshopName, String teamName, String processName, String ProjectName, String taskCode, LocalDate completionDate
   ) {
      return new StringBuffer()
         .append("【")
         .append(workshopName)
         .append("-")
         .append(teamName)
         .append("-")
         .append("【工序:")
         .append(processName)
         .append("】")
         .append(" ")
         .append("《")
         .append(ProjectName)
         .append("》-工单：")
         .append(taskCode)
         .append(",完成日期：")
         .append(completionDate)
         .append(",现在已超出计划完成时间，请关注！");
   }

   public StringBuffer getProjectBalanceDetail(String projectName, BigDecimal balance) {
      return new StringBuffer().append("【").append(projectName).append("-").append("】").append("可用余额为").append("【").append(balance).append("】").append("，清关注");
   }

   public StringBuffer getQualityInspectionTimingDetails(
      String serialCode, String shortName, String processName, String userName, String inspectUserName, String serialNumber
   ) {
      return new StringBuffer()
         .append("[")
         .append(serialCode)
         .append("+")
         .append(shortName)
         .append("]")
         .append("-")
         .append("工序[")
         .append(processName)
         .append("]")
         .append("-")
         .append("编号[")
         .append(serialNumber)
         .append("]")
         .append("报检人")
         .append("[")
         .append(userName)
         .append("]")
         .append("-")
         .append("检验人")
         .append("[")
         .append(inspectUserName)
         .append("],")
         .append("超出规定的质检时长，请检验");
   }

   public StringBuffer getQualityInspectionDefiniteNumberDetails(String processName, String inspectUserName, Integer number) {
      return new StringBuffer()
         .append("【工序-")
         .append(processName)
         .append("】")
         .append(",")
         .append("【质检-")
         .append(inspectUserName)
         .append("】")
         .append(" ")
         .append("累计未质检数已经达到")
         .append(number)
         .append("件，请关注");
   }

   public StringBuffer getMaterialOutboundDetails(String createUserName, String outSerialNumber) {
      return new StringBuffer().append("【").append(createUserName).append("】发起了【").append(outSerialNumber).append("】出库申请，请关注！");
   }

   public StringBuffer getMaterialInboundDetails(String createUserName, String inSerialNumber) {
      return new StringBuffer().append("【").append(createUserName).append("】发起了【").append(inSerialNumber).append("】甲供入库申请，请关注！");
   }

   public StringBuffer getMaterialInboundDetails2(String createUserName, String inSerialNumber) {
      return new StringBuffer().append("【").append(createUserName).append("】发起了【").append(inSerialNumber).append("】自购入库申请，请关注！");
   }

   public StringBuffer getShrChangeDetails(ShrUserChangeRecord userChangeRecord) {
      return new StringBuffer()
         .append("SHR人员变动通知:【")
         .append(userChangeRecord.getName())
         .append("】,【")
         .append(userChangeRecord.getDeptName())
         .append("】，【")
         .append(userChangeRecord.getJobName())
         .append("】，【")
         .append(CrudTypeEnum.getNameByType(userChangeRecord.getCrudType()))
         .append("】,【")
         .append(userChangeRecord.getCreateTime())
         .append("】");
   }
}
