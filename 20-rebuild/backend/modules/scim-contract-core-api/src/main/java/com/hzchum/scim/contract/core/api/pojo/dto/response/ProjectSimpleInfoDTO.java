package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.MeasureModeDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("项目公共信息返回类")
public class ProjectSimpleInfoDTO {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "status", value = "项目状态 0：进行中，1：暂停，2：已完工")
   private Integer status;
   @ApiModelProperty(name = "serialNumber", value = "项目编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @ApiModelProperty(name = "shortName", value = "项目简称")
   private String shortName;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(notes = "项目内容id字符串")
   private String projectContent;
   @ApiModelProperty(notes = "项目内容名称字符串")
   private String projectContentNameStr;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(notes = "签订日期")
   private LocalDate signingDate;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(notes = "签约人id")
   private Long signerId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(notes = "签约人姓名")
   private String signerName;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢 2桥梁 4围护")
   private Integer projectType;
   @ApiModelProperty(name = "productCategory", notes = "项目产品类型")
   private Integer productCategory;
   @ApiModelProperty(name = "businessType", value = "业务类型 1加工承揽 2项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "orderSourceType", notes = "项目订单来源类型 1内部 2外部")
   private Integer orderSourceType;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "projectContentList", notes = "项目内容列表")
   private List<ProjectContentDTO> projectContentList;
   @ApiModelProperty(name = "transportMode", notes = "运输方式 1运送到场 2客户自提")
   private Integer transportMode;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "structureMeasureMode", notes = "结构计量方式  1理论计算 2磅记")
   private Integer structureMeasureMode;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "enclosureMeasureMode", notes = "围护计量方式 1 长度计量 2 面积计量")
   private Integer enclosureMeasureMode;
   @ApiModelProperty(name = "measureModeList", notes = "围护计量方式列表")
   private List<MeasureModeDTOParam> measureModeList;
   @ApiModelProperty(name = "createTime", notes = "立项时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "startDate", notes = "开工日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", notes = "(计划)完工时期")
   private LocalDate endDate;
   @ApiModelProperty(name = "havePlan", notes = "是否拥有计划 1.是 0.否")
   private Integer havePlan;
   @ApiModelProperty(notes = "实际完工时期")
   private LocalDate completeDate;
   @ApiModelProperty(name = "customerUnit", notes = "客户单位名称")
   private String customerUnit;
   @ApiModelProperty(name = "mode", notes = "项目模式")
   private Integer mode;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("填报方式: 1.app端填报 0.PC端填报")
   private Integer installReportMethod;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "mesStartDate", notes = "mes开始日期")
   private LocalDateTime mesStartDate;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "mesEndDate", notes = "mes结束日期")
   private LocalDateTime mesEndDate;
   @ApiModelProperty(name = "settlement_status", notes = "结算状态 0 未结算 1已结算")
   private Integer settlementStatus;
   @JsonInclude(Include.NON_NULL)
   private Long provinceId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "alreadyDays", notes = "已用天数")
   private Integer alreadyDays;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "allDays", notes = "全部天数")
   private Integer allDays;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   private Integer projectAttribute;
   @ApiModelProperty(name = "user_id", notes = "创建项目的用户id")
   private Long userId;
   @ApiModelProperty(name = "createName", notes = "创建人姓名")
   private String createName;
   @ApiModelProperty(name = "structureStatus", notes = "结构类型")
   private Long structureStatus;
   @ApiModelProperty(name = "structureStatus", notes = "结构类型名称")
   private String structureStatusName;
   @ApiModelProperty(name = "project_manager_id", notes = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", notes = "项目（销售）经理")
   private String projectManagerName;
   @ApiModelProperty(name = "salesLeaderId", value = "销售负责人id")
   private Long salesLeaderId;
   @ApiModelProperty(name = "salesLeaderName", notes = "销售负责人名字")
   private String salesLeaderName;
   @ApiModelProperty(name = "categorys", notes = "项目下围护类型")
   private List<Integer> categorys;
   @ApiModelProperty(name = "pId", notes = "父合同id")
   private Long pId;
   @ApiModelProperty("是否提交结算")
   private Boolean boolSubmitSettle;
   @ApiModelProperty(name = "contractSignBodyId", notes = "合同签订主体id")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "lumpSumSystemType", notes = "包干制项目管理类型")
   private Integer lumpSumSystemType;
   private Integer level;
   @ApiModelProperty(name = "installDivideMethod", notes = "项目安装划分方式")
   private Integer installDivideMethod;
   @ApiModelProperty(name = "hasEnclosure", notes = "存在围护")
   private Boolean hasEnclosure;

   public Long getId() {
      return this.id;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public String getProjectContent() {
      return this.projectContent;
   }

   public String getProjectContentNameStr() {
      return this.projectContentNameStr;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductCategory() {
      return this.productCategory;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getOrderSourceType() {
      return this.orderSourceType;
   }

   public List<ProjectContentDTO> getProjectContentList() {
      return this.projectContentList;
   }

   public Integer getTransportMode() {
      return this.transportMode;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public Integer getEnclosureMeasureMode() {
      return this.enclosureMeasureMode;
   }

   public List<MeasureModeDTOParam> getMeasureModeList() {
      return this.measureModeList;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getHavePlan() {
      return this.havePlan;
   }

   public LocalDate getCompleteDate() {
      return this.completeDate;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public Integer getMode() {
      return this.mode;
   }

   public Integer getInstallReportMethod() {
      return this.installReportMethod;
   }

   public LocalDateTime getMesStartDate() {
      return this.mesStartDate;
   }

   public LocalDateTime getMesEndDate() {
      return this.mesEndDate;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public Integer getAlreadyDays() {
      return this.alreadyDays;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getCreateName() {
      return this.createName;
   }

   public Long getStructureStatus() {
      return this.structureStatus;
   }

   public String getStructureStatusName() {
      return this.structureStatusName;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Long getSalesLeaderId() {
      return this.salesLeaderId;
   }

   public String getSalesLeaderName() {
      return this.salesLeaderName;
   }

   public List<Integer> getCategorys() {
      return this.categorys;
   }

   public Long getPId() {
      return this.pId;
   }

   public Boolean getBoolSubmitSettle() {
      return this.boolSubmitSettle;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public Integer getLumpSumSystemType() {
      return this.lumpSumSystemType;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Integer getInstallDivideMethod() {
      return this.installDivideMethod;
   }

   public Boolean getHasEnclosure() {
      return this.hasEnclosure;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setProjectContent(final String projectContent) {
      this.projectContent = projectContent;
   }

   public void setProjectContentNameStr(final String projectContentNameStr) {
      this.projectContentNameStr = projectContentNameStr;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProductCategory(final Integer productCategory) {
      this.productCategory = productCategory;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setOrderSourceType(final Integer orderSourceType) {
      this.orderSourceType = orderSourceType;
   }

   public void setProjectContentList(final List<ProjectContentDTO> projectContentList) {
      this.projectContentList = projectContentList;
   }

   public void setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
   }

   public void setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
   }

   public void setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
   }

   public void setMeasureModeList(final List<MeasureModeDTOParam> measureModeList) {
      this.measureModeList = measureModeList;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setHavePlan(final Integer havePlan) {
      this.havePlan = havePlan;
   }

   public void setCompleteDate(final LocalDate completeDate) {
      this.completeDate = completeDate;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setMode(final Integer mode) {
      this.mode = mode;
   }

   public void setInstallReportMethod(final Integer installReportMethod) {
      this.installReportMethod = installReportMethod;
   }

   public void setMesStartDate(final LocalDateTime mesStartDate) {
      this.mesStartDate = mesStartDate;
   }

   public void setMesEndDate(final LocalDateTime mesEndDate) {
      this.mesEndDate = mesEndDate;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setAlreadyDays(final Integer alreadyDays) {
      this.alreadyDays = alreadyDays;
   }

   public void setAllDays(final Integer allDays) {
      this.allDays = allDays;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setCreateName(final String createName) {
      this.createName = createName;
   }

   public void setStructureStatus(final Long structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setStructureStatusName(final String structureStatusName) {
      this.structureStatusName = structureStatusName;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setSalesLeaderId(final Long salesLeaderId) {
      this.salesLeaderId = salesLeaderId;
   }

   public void setSalesLeaderName(final String salesLeaderName) {
      this.salesLeaderName = salesLeaderName;
   }

   public void setCategorys(final List<Integer> categorys) {
      this.categorys = categorys;
   }

   public void setPId(final Long pId) {
      this.pId = pId;
   }

   public void setBoolSubmitSettle(final Boolean boolSubmitSettle) {
      this.boolSubmitSettle = boolSubmitSettle;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setLumpSumSystemType(final Integer lumpSumSystemType) {
      this.lumpSumSystemType = lumpSumSystemType;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setInstallDivideMethod(final Integer installDivideMethod) {
      this.installDivideMethod = installDivideMethod;
   }

   public void setHasEnclosure(final Boolean hasEnclosure) {
      this.hasEnclosure = hasEnclosure;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSimpleInfoDTO)) {
         return false;
      }

      ProjectSimpleInfoDTO other = (ProjectSimpleInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$signerId = this.getSignerId();
            Object other$signerId = other.getSignerId();
            if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
               Object this$projectType = this.getProjectType();
               Object other$projectType = other.getProjectType();
               if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                  Object this$productCategory = this.getProductCategory();
                  Object other$productCategory = other.getProductCategory();
                  if (this$productCategory == null ? other$productCategory == null : this$productCategory.equals(other$productCategory)) {
                     Object this$businessType = this.getBusinessType();
                     Object other$businessType = other.getBusinessType();
                     if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
                        Object this$orderSourceType = this.getOrderSourceType();
                        Object other$orderSourceType = other.getOrderSourceType();
                        if (this$orderSourceType == null ? other$orderSourceType == null : this$orderSourceType.equals(other$orderSourceType)) {
                           Object this$transportMode = this.getTransportMode();
                           Object other$transportMode = other.getTransportMode();
                           if (this$transportMode == null ? other$transportMode == null : this$transportMode.equals(other$transportMode)) {
                              Object this$structureMeasureMode = this.getStructureMeasureMode();
                              Object other$structureMeasureMode = other.getStructureMeasureMode();
                              if (this$structureMeasureMode == null
                                 ? other$structureMeasureMode == null
                                 : this$structureMeasureMode.equals(other$structureMeasureMode)) {
                                 Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
                                 Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
                                 if (this$enclosureMeasureMode == null
                                    ? other$enclosureMeasureMode == null
                                    : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
                                    Object this$havePlan = this.getHavePlan();
                                    Object other$havePlan = other.getHavePlan();
                                    if (this$havePlan == null ? other$havePlan == null : this$havePlan.equals(other$havePlan)) {
                                       Object this$mode = this.getMode();
                                       Object other$mode = other.getMode();
                                       if (this$mode == null ? other$mode == null : this$mode.equals(other$mode)) {
                                          Object this$installReportMethod = this.getInstallReportMethod();
                                          Object other$installReportMethod = other.getInstallReportMethod();
                                          if (this$installReportMethod == null
                                             ? other$installReportMethod == null
                                             : this$installReportMethod.equals(other$installReportMethod)) {
                                             Object this$settlementStatus = this.getSettlementStatus();
                                             Object other$settlementStatus = other.getSettlementStatus();
                                             if (this$settlementStatus == null
                                                ? other$settlementStatus == null
                                                : this$settlementStatus.equals(other$settlementStatus)) {
                                                Object this$provinceId = this.getProvinceId();
                                                Object other$provinceId = other.getProvinceId();
                                                if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
                                                   Object this$alreadyDays = this.getAlreadyDays();
                                                   Object other$alreadyDays = other.getAlreadyDays();
                                                   if (this$alreadyDays == null ? other$alreadyDays == null : this$alreadyDays.equals(other$alreadyDays)) {
                                                      Object this$allDays = this.getAllDays();
                                                      Object other$allDays = other.getAllDays();
                                                      if (this$allDays == null ? other$allDays == null : this$allDays.equals(other$allDays)) {
                                                         Object this$projectAttribute = this.getProjectAttribute();
                                                         Object other$projectAttribute = other.getProjectAttribute();
                                                         if (this$projectAttribute == null
                                                            ? other$projectAttribute == null
                                                            : this$projectAttribute.equals(other$projectAttribute)) {
                                                            Object this$userId = this.getUserId();
                                                            Object other$userId = other.getUserId();
                                                            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                               Object this$structureStatus = this.getStructureStatus();
                                                               Object other$structureStatus = other.getStructureStatus();
                                                               if (this$structureStatus == null
                                                                  ? other$structureStatus == null
                                                                  : this$structureStatus.equals(other$structureStatus)) {
                                                                  Object this$projectManagerId = this.getProjectManagerId();
                                                                  Object other$projectManagerId = other.getProjectManagerId();
                                                                  if (this$projectManagerId == null
                                                                     ? other$projectManagerId == null
                                                                     : this$projectManagerId.equals(other$projectManagerId)) {
                                                                     Object this$salesLeaderId = this.getSalesLeaderId();
                                                                     Object other$salesLeaderId = other.getSalesLeaderId();
                                                                     if (this$salesLeaderId == null
                                                                        ? other$salesLeaderId == null
                                                                        : this$salesLeaderId.equals(other$salesLeaderId)) {
                                                                        Object this$pId = this.getPId();
                                                                        Object other$pId = other.getPId();
                                                                        if (this$pId == null ? other$pId == null : this$pId.equals(other$pId)) {
                                                                           Object this$boolSubmitSettle = this.getBoolSubmitSettle();
                                                                           Object other$boolSubmitSettle = other.getBoolSubmitSettle();
                                                                           if (this$boolSubmitSettle == null
                                                                              ? other$boolSubmitSettle == null
                                                                              : this$boolSubmitSettle.equals(other$boolSubmitSettle)) {
                                                                              Object this$contractSignBodyId = this.getContractSignBodyId();
                                                                              Object other$contractSignBodyId = other.getContractSignBodyId();
                                                                              if (this$contractSignBodyId == null
                                                                                 ? other$contractSignBodyId == null
                                                                                 : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                                                                                 Object this$lumpSumSystemType = this.getLumpSumSystemType();
                                                                                 Object other$lumpSumSystemType = other.getLumpSumSystemType();
                                                                                 if (this$lumpSumSystemType == null
                                                                                    ? other$lumpSumSystemType == null
                                                                                    : this$lumpSumSystemType.equals(other$lumpSumSystemType)) {
                                                                                    Object this$level = this.getLevel();
                                                                                    Object other$level = other.getLevel();
                                                                                    if (this$level == null
                                                                                       ? other$level == null
                                                                                       : this$level.equals(other$level)) {
                                                                                       Object this$installDivideMethod = this.getInstallDivideMethod();
                                                                                       Object other$installDivideMethod = other.getInstallDivideMethod();
                                                                                       if (this$installDivideMethod == null
                                                                                          ? other$installDivideMethod == null
                                                                                          : this$installDivideMethod.equals(other$installDivideMethod)) {
                                                                                          Object this$hasEnclosure = this.getHasEnclosure();
                                                                                          Object other$hasEnclosure = other.getHasEnclosure();
                                                                                          if (this$hasEnclosure == null
                                                                                             ? other$hasEnclosure == null
                                                                                             : this$hasEnclosure.equals(other$hasEnclosure)) {
                                                                                             Object this$serialNumber = this.getSerialNumber();
                                                                                             Object other$serialNumber = other.getSerialNumber();
                                                                                             if (this$serialNumber == null
                                                                                                ? other$serialNumber == null
                                                                                                : this$serialNumber.equals(other$serialNumber)) {
                                                                                                Object this$name = this.getName();
                                                                                                Object other$name = other.getName();
                                                                                                if (this$name == null
                                                                                                   ? other$name == null
                                                                                                   : this$name.equals(other$name)) {
                                                                                                   Object this$shortName = this.getShortName();
                                                                                                   Object other$shortName = other.getShortName();
                                                                                                   if (this$shortName == null
                                                                                                      ? other$shortName == null
                                                                                                      : this$shortName.equals(other$shortName)) {
                                                                                                      Object this$contractAmount = this.getContractAmount();
                                                                                                      Object other$contractAmount = other.getContractAmount();
                                                                                                      if (this$contractAmount == null
                                                                                                         ? other$contractAmount == null
                                                                                                         : this$contractAmount.equals(other$contractAmount)) {
                                                                                                         Object this$projectContent = this.getProjectContent();
                                                                                                         Object other$projectContent = other.getProjectContent();
                                                                                                         if (this$projectContent == null
                                                                                                            ? other$projectContent == null
                                                                                                            : this$projectContent.equals(other$projectContent)) {
                                                                                                            Object this$projectContentNameStr = this.getProjectContentNameStr();
                                                                                                            Object other$projectContentNameStr = other.getProjectContentNameStr();
                                                                                                            if (this$projectContentNameStr == null
                                                                                                               ? other$projectContentNameStr == null
                                                                                                               : this$projectContentNameStr.equals(
                                                                                                                  other$projectContentNameStr
                                                                                                               )) {
                                                                                                               Object this$signingDate = this.getSigningDate();
                                                                                                               Object other$signingDate = other.getSigningDate();
                                                                                                               if (this$signingDate == null
                                                                                                                  ? other$signingDate == null
                                                                                                                  : this$signingDate.equals(other$signingDate)) {
                                                                                                                  Object this$signerName = this.getSignerName();
                                                                                                                  Object other$signerName = other.getSignerName();
                                                                                                                  if (this$signerName == null
                                                                                                                     ? other$signerName == null
                                                                                                                     : this$signerName.equals(other$signerName)
                                                                                                                     )
                                                                                                                   {
                                                                                                                     Object this$projectContentList = this.getProjectContentList();
                                                                                                                     Object other$projectContentList = other.getProjectContentList();
                                                                                                                     if (this$projectContentList == null
                                                                                                                        ? other$projectContentList == null
                                                                                                                        : this$projectContentList.equals(
                                                                                                                           other$projectContentList
                                                                                                                        )) {
                                                                                                                        Object this$measureModeList = this.getMeasureModeList();
                                                                                                                        Object other$measureModeList = other.getMeasureModeList();
                                                                                                                        if (this$measureModeList == null
                                                                                                                           ? other$measureModeList == null
                                                                                                                           : this$measureModeList.equals(
                                                                                                                              other$measureModeList
                                                                                                                           )) {
                                                                                                                           Object this$createTime = this.getCreateTime();
                                                                                                                           Object other$createTime = other.getCreateTime();
                                                                                                                           if (this$createTime == null
                                                                                                                              ? other$createTime == null
                                                                                                                              : this$createTime.equals(
                                                                                                                                 other$createTime
                                                                                                                              )) {
                                                                                                                              Object this$startDate = this.getStartDate();
                                                                                                                              Object other$startDate = other.getStartDate();
                                                                                                                              if (this$startDate == null
                                                                                                                                 ? other$startDate == null
                                                                                                                                 : this$startDate.equals(
                                                                                                                                    other$startDate
                                                                                                                                 )) {
                                                                                                                                 Object this$endDate = this.getEndDate();
                                                                                                                                 Object other$endDate = other.getEndDate();
                                                                                                                                 if (this$endDate == null
                                                                                                                                    ? other$endDate == null
                                                                                                                                    : this$endDate.equals(
                                                                                                                                       other$endDate
                                                                                                                                    )) {
                                                                                                                                    Object this$completeDate = this.getCompleteDate();
                                                                                                                                    Object other$completeDate = other.getCompleteDate();
                                                                                                                                    if (this$completeDate
                                                                                                                                          == null
                                                                                                                                       ? other$completeDate
                                                                                                                                          == null
                                                                                                                                       : this$completeDate.equals(
                                                                                                                                          other$completeDate
                                                                                                                                       )) {
                                                                                                                                       Object this$customerUnit = this.getCustomerUnit();
                                                                                                                                       Object other$customerUnit = other.getCustomerUnit();
                                                                                                                                       if (this$customerUnit
                                                                                                                                             == null
                                                                                                                                          ? other$customerUnit
                                                                                                                                             == null
                                                                                                                                          : this$customerUnit.equals(
                                                                                                                                             other$customerUnit
                                                                                                                                          )) {
                                                                                                                                          Object this$mesStartDate = this.getMesStartDate();
                                                                                                                                          Object other$mesStartDate = other.getMesStartDate();
                                                                                                                                          if (this$mesStartDate
                                                                                                                                                == null
                                                                                                                                             ? other$mesStartDate
                                                                                                                                                == null
                                                                                                                                             : this$mesStartDate.equals(
                                                                                                                                                other$mesStartDate
                                                                                                                                             )) {
                                                                                                                                             Object this$mesEndDate = this.getMesEndDate();
                                                                                                                                             Object other$mesEndDate = other.getMesEndDate();
                                                                                                                                             if (this$mesEndDate
                                                                                                                                                   == null
                                                                                                                                                ? other$mesEndDate
                                                                                                                                                   == null
                                                                                                                                                : this$mesEndDate.equals(
                                                                                                                                                   other$mesEndDate
                                                                                                                                                )) {
                                                                                                                                                Object this$createName = this.getCreateName();
                                                                                                                                                Object other$createName = other.getCreateName();
                                                                                                                                                if (this$createName
                                                                                                                                                      == null
                                                                                                                                                   ? other$createName
                                                                                                                                                      == null
                                                                                                                                                   : this$createName.equals(
                                                                                                                                                      other$createName
                                                                                                                                                   )) {
                                                                                                                                                   Object this$structureStatusName = this.getStructureStatusName();
                                                                                                                                                   Object other$structureStatusName = other.getStructureStatusName();
                                                                                                                                                   if (this$structureStatusName
                                                                                                                                                         == null
                                                                                                                                                      ? other$structureStatusName
                                                                                                                                                         == null
                                                                                                                                                      : this$structureStatusName.equals(
                                                                                                                                                         other$structureStatusName
                                                                                                                                                      )) {
                                                                                                                                                      Object this$projectManagerName = this.getProjectManagerName();
                                                                                                                                                      Object other$projectManagerName = other.getProjectManagerName();
                                                                                                                                                      if (this$projectManagerName
                                                                                                                                                            == null
                                                                                                                                                         ? other$projectManagerName
                                                                                                                                                            == null
                                                                                                                                                         : this$projectManagerName.equals(
                                                                                                                                                            other$projectManagerName
                                                                                                                                                         )) {
                                                                                                                                                         Object this$salesLeaderName = this.getSalesLeaderName();
                                                                                                                                                         Object other$salesLeaderName = other.getSalesLeaderName();
                                                                                                                                                         if (this$salesLeaderName
                                                                                                                                                               == null
                                                                                                                                                            ? other$salesLeaderName
                                                                                                                                                               == null
                                                                                                                                                            : this$salesLeaderName.equals(
                                                                                                                                                               other$salesLeaderName
                                                                                                                                                            )) {
                                                                                                                                                            Object this$categorys = this.getCategorys();
                                                                                                                                                            Object other$categorys = other.getCategorys();
                                                                                                                                                            return this$categorys
                                                                                                                                                                  == null
                                                                                                                                                               ? other$categorys
                                                                                                                                                                  == null
                                                                                                                                                               : this$categorys.equals(
                                                                                                                                                                  other$categorys
                                                                                                                                                               );
                                                                                                                                                         } else {
                                                                                                                                                            return false;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         return false;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      return false;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   return false;
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                return false;
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             return false;
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          return false;
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       return false;
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    return false;
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 return false;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              return false;
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           return false;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        return false;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     return false;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  return false;
                                                                                                               }
                                                                                                            } else {
                                                                                                               return false;
                                                                                                            }
                                                                                                         } else {
                                                                                                            return false;
                                                                                                         }
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSimpleInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productCategory = this.getProductCategory();
      result = result * 59 + ($productCategory == null ? 43 : $productCategory.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $orderSourceType = this.getOrderSourceType();
      result = result * 59 + ($orderSourceType == null ? 43 : $orderSourceType.hashCode());
      Object $transportMode = this.getTransportMode();
      result = result * 59 + ($transportMode == null ? 43 : $transportMode.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $havePlan = this.getHavePlan();
      result = result * 59 + ($havePlan == null ? 43 : $havePlan.hashCode());
      Object $mode = this.getMode();
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $installReportMethod = this.getInstallReportMethod();
      result = result * 59 + ($installReportMethod == null ? 43 : $installReportMethod.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $alreadyDays = this.getAlreadyDays();
      result = result * 59 + ($alreadyDays == null ? 43 : $alreadyDays.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $salesLeaderId = this.getSalesLeaderId();
      result = result * 59 + ($salesLeaderId == null ? 43 : $salesLeaderId.hashCode());
      Object $pId = this.getPId();
      result = result * 59 + ($pId == null ? 43 : $pId.hashCode());
      Object $boolSubmitSettle = this.getBoolSubmitSettle();
      result = result * 59 + ($boolSubmitSettle == null ? 43 : $boolSubmitSettle.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $lumpSumSystemType = this.getLumpSumSystemType();
      result = result * 59 + ($lumpSumSystemType == null ? 43 : $lumpSumSystemType.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $installDivideMethod = this.getInstallDivideMethod();
      result = result * 59 + ($installDivideMethod == null ? 43 : $installDivideMethod.hashCode());
      Object $hasEnclosure = this.getHasEnclosure();
      result = result * 59 + ($hasEnclosure == null ? 43 : $hasEnclosure.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $projectContent = this.getProjectContent();
      result = result * 59 + ($projectContent == null ? 43 : $projectContent.hashCode());
      Object $projectContentNameStr = this.getProjectContentNameStr();
      result = result * 59 + ($projectContentNameStr == null ? 43 : $projectContentNameStr.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $projectContentList = this.getProjectContentList();
      result = result * 59 + ($projectContentList == null ? 43 : $projectContentList.hashCode());
      Object $measureModeList = this.getMeasureModeList();
      result = result * 59 + ($measureModeList == null ? 43 : $measureModeList.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $completeDate = this.getCompleteDate();
      result = result * 59 + ($completeDate == null ? 43 : $completeDate.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $mesStartDate = this.getMesStartDate();
      result = result * 59 + ($mesStartDate == null ? 43 : $mesStartDate.hashCode());
      Object $mesEndDate = this.getMesEndDate();
      result = result * 59 + ($mesEndDate == null ? 43 : $mesEndDate.hashCode());
      Object $createName = this.getCreateName();
      result = result * 59 + ($createName == null ? 43 : $createName.hashCode());
      Object $structureStatusName = this.getStructureStatusName();
      result = result * 59 + ($structureStatusName == null ? 43 : $structureStatusName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $salesLeaderName = this.getSalesLeaderName();
      result = result * 59 + ($salesLeaderName == null ? 43 : $salesLeaderName.hashCode());
      Object $categorys = this.getCategorys();
      return result * 59 + ($categorys == null ? 43 : $categorys.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSimpleInfoDTO(id="
         + this.getId()
         + ", status="
         + this.getStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", projectContent="
         + this.getProjectContent()
         + ", projectContentNameStr="
         + this.getProjectContentNameStr()
         + ", signingDate="
         + this.getSigningDate()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", projectType="
         + this.getProjectType()
         + ", productCategory="
         + this.getProductCategory()
         + ", businessType="
         + this.getBusinessType()
         + ", orderSourceType="
         + this.getOrderSourceType()
         + ", projectContentList="
         + this.getProjectContentList()
         + ", transportMode="
         + this.getTransportMode()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", measureModeList="
         + this.getMeasureModeList()
         + ", createTime="
         + this.getCreateTime()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", havePlan="
         + this.getHavePlan()
         + ", completeDate="
         + this.getCompleteDate()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", mode="
         + this.getMode()
         + ", installReportMethod="
         + this.getInstallReportMethod()
         + ", mesStartDate="
         + this.getMesStartDate()
         + ", mesEndDate="
         + this.getMesEndDate()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", provinceId="
         + this.getProvinceId()
         + ", alreadyDays="
         + this.getAlreadyDays()
         + ", allDays="
         + this.getAllDays()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", userId="
         + this.getUserId()
         + ", createName="
         + this.getCreateName()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", structureStatusName="
         + this.getStructureStatusName()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", salesLeaderId="
         + this.getSalesLeaderId()
         + ", salesLeaderName="
         + this.getSalesLeaderName()
         + ", categorys="
         + this.getCategorys()
         + ", pId="
         + this.getPId()
         + ", boolSubmitSettle="
         + this.getBoolSubmitSettle()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", lumpSumSystemType="
         + this.getLumpSumSystemType()
         + ", level="
         + this.getLevel()
         + ", installDivideMethod="
         + this.getInstallDivideMethod()
         + ", hasEnclosure="
         + this.getHasEnclosure()
         + ")";
   }
}
