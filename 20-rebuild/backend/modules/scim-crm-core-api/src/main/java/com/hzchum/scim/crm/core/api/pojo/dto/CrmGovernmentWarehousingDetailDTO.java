package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CrmGovernmentWarehousingDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "informantUserId", value = "填报人id", notes = "填报人id")
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   private String informantUserName;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "crm审核状态", notes = "crm审核状态")
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案名称", notes = "企业备案名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "departmentId", value = "所属部门id", notes = "所属部门id")
   private Long departmentId;
   @ApiModelProperty(name = "departmentName", value = "所属部门", notes = "所属部门")
   private String departmentName;
   @ApiModelProperty(name = "unitPropertyAllocationConfigId", value = "单位类别id  参考crm_basics_config", notes = "单位类别id  参考crm_basics_config")
   private Long unitPropertyAllocationConfigId;
   @ApiModelProperty(name = "unitPropertyAllocationConfigName", value = "单位类别名称  unitPropertyAllocationConfigName", notes = "单位类别名称  参考crm_basics_config")
   private String unitPropertyAllocationConfigName;
   @ApiModelProperty(name = "unitClassConfigurationId", value = "单位性质id  参考crm_basics_config", notes = "单位性质id  参考crm_basics_config")
   private Long unitClassConfigurationId;
   @ApiModelProperty(name = "unitClassConfigurationName", value = "单位性质名称  参考crm_basics_config", notes = "单位性质名称  参考crm_basics_config")
   private String unitClassConfigurationName;
   @ApiModelProperty(name = "regionNameList", value = "国省市区名称", notes = "国省市区名称")
   private String regionNameList;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   private String address;
   @ApiModelProperty(name = "regionList", value = "地区id列表", notes = "地区id列表")
   private List<Long> regionList;
   @ApiModelProperty(name = "attachmentIds", value = "附件集合", notes = "附件集合")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "attachmentDTOList", value = "附件集合", notes = "附件集合")
   private List<AttachmentDTO> attachmentDTOList;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "受理截至日期", notes = "受理截至日期")
   private LocalDateTime deadlineForAcceptanceTime;
   @ApiModelProperty(name = "acceptanceAddress", value = "受理地址", notes = "受理地址")
   private String acceptanceAddress;
   @ApiModelProperty(name = "cost", value = "费用", notes = "费用")
   private BigDecimal cost;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", value = "项目备案名称", notes = "项目备案名称")
   private String crmProjectInformationWarehousingName;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   private Long approveRecordId;
   @ApiModelProperty(name = "serialNumber", value = "备案编号", notes = "备案编号")
   private String serialNumber;
   @ApiModelProperty(name = "recordBindProject", value = "是否绑定项目", notes = "是否绑定项目")
   private Boolean recordBindProject;
   @ApiModelProperty(name = "CALockDate", value = "锁定日期", notes = "锁定日期")
   private LocalDate caLockDate;

   public static CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder builder() {
      return new CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder();
   }

   public CrmGovernmentWarehousingDetailDTO() {
   }

   public CrmGovernmentWarehousingDetailDTO(
      final Long id,
      final Long informantUserId,
      final String informantUserName,
      final LocalDateTime informantDateTime,
      final Long createUserId,
      final String createUserName,
      final Integer crmCheckStatusEnum,
      final Long crmEnterpriseWarehousingId,
      final String crmEnterpriseWarehousingName,
      final Long departmentId,
      final String departmentName,
      final Long unitPropertyAllocationConfigId,
      final String unitPropertyAllocationConfigName,
      final Long unitClassConfigurationId,
      final String unitClassConfigurationName,
      final String regionNameList,
      final String address,
      final List<Long> regionList,
      final List<AttachmentDTO> attachmentIds,
      final List<AttachmentDTO> attachmentDTOList,
      final LocalDateTime deadlineForAcceptanceTime,
      final String acceptanceAddress,
      final BigDecimal cost,
      final String remark,
      final Long crmProjectInformationWarehousingId,
      final String crmProjectInformationWarehousingName,
      final Long approveRecordId,
      final String serialNumber,
      final Boolean recordBindProject,
      final LocalDate caLockDate
   ) {
      this.id = id;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.informantDateTime = informantDateTime;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.departmentId = departmentId;
      this.departmentName = departmentName;
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      this.unitClassConfigurationId = unitClassConfigurationId;
      this.unitClassConfigurationName = unitClassConfigurationName;
      this.regionNameList = regionNameList;
      this.address = address;
      this.regionList = regionList;
      this.attachmentIds = attachmentIds;
      this.attachmentDTOList = attachmentDTOList;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.acceptanceAddress = acceptanceAddress;
      this.cost = cost;
      this.remark = remark;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      this.approveRecordId = approveRecordId;
      this.serialNumber = serialNumber;
      this.recordBindProject = recordBindProject;
      this.caLockDate = caLockDate;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public Long getUnitPropertyAllocationConfigId() {
      return this.unitPropertyAllocationConfigId;
   }

   public String getUnitPropertyAllocationConfigName() {
      return this.unitPropertyAllocationConfigName;
   }

   public Long getUnitClassConfigurationId() {
      return this.unitClassConfigurationId;
   }

   public String getUnitClassConfigurationName() {
      return this.unitClassConfigurationName;
   }

   public String getRegionNameList() {
      return this.regionNameList;
   }

   public String getAddress() {
      return this.address;
   }

   public List<Long> getRegionList() {
      return this.regionList;
   }

   public List<AttachmentDTO> getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public LocalDateTime getDeadlineForAcceptanceTime() {
      return this.deadlineForAcceptanceTime;
   }

   public String getAcceptanceAddress() {
      return this.acceptanceAddress;
   }

   public BigDecimal getCost() {
      return this.cost;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public String getCrmProjectInformationWarehousingName() {
      return this.crmProjectInformationWarehousingName;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Boolean getRecordBindProject() {
      return this.recordBindProject;
   }

   public LocalDate getCaLockDate() {
      return this.caLockDate;
   }

   public CrmGovernmentWarehousingDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setUnitPropertyAllocationConfigId(final Long unitPropertyAllocationConfigId) {
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setUnitPropertyAllocationConfigName(final String unitPropertyAllocationConfigName) {
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setUnitClassConfigurationId(final Long unitClassConfigurationId) {
      this.unitClassConfigurationId = unitClassConfigurationId;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setUnitClassConfigurationName(final String unitClassConfigurationName) {
      this.unitClassConfigurationName = unitClassConfigurationName;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setDeadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setAcceptanceAddress(final String acceptanceAddress) {
      this.acceptanceAddress = acceptanceAddress;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setCost(final BigDecimal cost) {
      this.cost = cost;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setRecordBindProject(final Boolean recordBindProject) {
      this.recordBindProject = recordBindProject;
      return this;
   }

   public CrmGovernmentWarehousingDetailDTO setCaLockDate(final LocalDate caLockDate) {
      this.caLockDate = caLockDate;
      return this;
   }

   @Override
   public String toString() {
      return "CrmGovernmentWarehousingDetailDTO(id="
         + this.getId()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", departmentName="
         + this.getDepartmentName()
         + ", unitPropertyAllocationConfigId="
         + this.getUnitPropertyAllocationConfigId()
         + ", unitPropertyAllocationConfigName="
         + this.getUnitPropertyAllocationConfigName()
         + ", unitClassConfigurationId="
         + this.getUnitClassConfigurationId()
         + ", unitClassConfigurationName="
         + this.getUnitClassConfigurationName()
         + ", regionNameList="
         + this.getRegionNameList()
         + ", address="
         + this.getAddress()
         + ", regionList="
         + this.getRegionList()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ", deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", acceptanceAddress="
         + this.getAcceptanceAddress()
         + ", cost="
         + this.getCost()
         + ", remark="
         + this.getRemark()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", recordBindProject="
         + this.getRecordBindProject()
         + ", caLockDate="
         + this.getCaLockDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmGovernmentWarehousingDetailDTO)) {
         return false;
      }

      CrmGovernmentWarehousingDetailDTO other = (CrmGovernmentWarehousingDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$informantUserId = this.getInformantUserId();
         Object other$informantUserId = other.getInformantUserId();
         if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
               Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
               if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                  Object this$crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
                  Object other$crmEnterpriseWarehousingId = other.getCrmEnterpriseWarehousingId();
                  if (this$crmEnterpriseWarehousingId == null
                     ? other$crmEnterpriseWarehousingId == null
                     : this$crmEnterpriseWarehousingId.equals(other$crmEnterpriseWarehousingId)) {
                     Object this$departmentId = this.getDepartmentId();
                     Object other$departmentId = other.getDepartmentId();
                     if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
                        Object this$unitPropertyAllocationConfigId = this.getUnitPropertyAllocationConfigId();
                        Object other$unitPropertyAllocationConfigId = other.getUnitPropertyAllocationConfigId();
                        if (this$unitPropertyAllocationConfigId == null
                           ? other$unitPropertyAllocationConfigId == null
                           : this$unitPropertyAllocationConfigId.equals(other$unitPropertyAllocationConfigId)) {
                           Object this$unitClassConfigurationId = this.getUnitClassConfigurationId();
                           Object other$unitClassConfigurationId = other.getUnitClassConfigurationId();
                           if (this$unitClassConfigurationId == null
                              ? other$unitClassConfigurationId == null
                              : this$unitClassConfigurationId.equals(other$unitClassConfigurationId)) {
                              Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
                              Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
                              if (this$crmProjectInformationWarehousingId == null
                                 ? other$crmProjectInformationWarehousingId == null
                                 : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
                                 Object this$approveRecordId = this.getApproveRecordId();
                                 Object other$approveRecordId = other.getApproveRecordId();
                                 if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                                    Object this$recordBindProject = this.getRecordBindProject();
                                    Object other$recordBindProject = other.getRecordBindProject();
                                    if (this$recordBindProject == null
                                       ? other$recordBindProject == null
                                       : this$recordBindProject.equals(other$recordBindProject)) {
                                       Object this$informantUserName = this.getInformantUserName();
                                       Object other$informantUserName = other.getInformantUserName();
                                       if (this$informantUserName == null
                                          ? other$informantUserName == null
                                          : this$informantUserName.equals(other$informantUserName)) {
                                          Object this$informantDateTime = this.getInformantDateTime();
                                          Object other$informantDateTime = other.getInformantDateTime();
                                          if (this$informantDateTime == null
                                             ? other$informantDateTime == null
                                             : this$informantDateTime.equals(other$informantDateTime)) {
                                             Object this$createUserName = this.getCreateUserName();
                                             Object other$createUserName = other.getCreateUserName();
                                             if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                                Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                                                Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                                                if (this$crmEnterpriseWarehousingName == null
                                                   ? other$crmEnterpriseWarehousingName == null
                                                   : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                                                   Object this$departmentName = this.getDepartmentName();
                                                   Object other$departmentName = other.getDepartmentName();
                                                   if (this$departmentName == null
                                                      ? other$departmentName == null
                                                      : this$departmentName.equals(other$departmentName)) {
                                                      Object this$unitPropertyAllocationConfigName = this.getUnitPropertyAllocationConfigName();
                                                      Object other$unitPropertyAllocationConfigName = other.getUnitPropertyAllocationConfigName();
                                                      if (this$unitPropertyAllocationConfigName == null
                                                         ? other$unitPropertyAllocationConfigName == null
                                                         : this$unitPropertyAllocationConfigName.equals(other$unitPropertyAllocationConfigName)) {
                                                         Object this$unitClassConfigurationName = this.getUnitClassConfigurationName();
                                                         Object other$unitClassConfigurationName = other.getUnitClassConfigurationName();
                                                         if (this$unitClassConfigurationName == null
                                                            ? other$unitClassConfigurationName == null
                                                            : this$unitClassConfigurationName.equals(other$unitClassConfigurationName)) {
                                                            Object this$regionNameList = this.getRegionNameList();
                                                            Object other$regionNameList = other.getRegionNameList();
                                                            if (this$regionNameList == null
                                                               ? other$regionNameList == null
                                                               : this$regionNameList.equals(other$regionNameList)) {
                                                               Object this$address = this.getAddress();
                                                               Object other$address = other.getAddress();
                                                               if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                                  Object this$regionList = this.getRegionList();
                                                                  Object other$regionList = other.getRegionList();
                                                                  if (this$regionList == null
                                                                     ? other$regionList == null
                                                                     : this$regionList.equals(other$regionList)) {
                                                                     Object this$attachmentIds = this.getAttachmentIds();
                                                                     Object other$attachmentIds = other.getAttachmentIds();
                                                                     if (this$attachmentIds == null
                                                                        ? other$attachmentIds == null
                                                                        : this$attachmentIds.equals(other$attachmentIds)) {
                                                                        Object this$attachmentDTOList = this.getAttachmentDTOList();
                                                                        Object other$attachmentDTOList = other.getAttachmentDTOList();
                                                                        if (this$attachmentDTOList == null
                                                                           ? other$attachmentDTOList == null
                                                                           : this$attachmentDTOList.equals(other$attachmentDTOList)) {
                                                                           Object this$deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
                                                                           Object other$deadlineForAcceptanceTime = other.getDeadlineForAcceptanceTime();
                                                                           if (this$deadlineForAcceptanceTime == null
                                                                              ? other$deadlineForAcceptanceTime == null
                                                                              : this$deadlineForAcceptanceTime.equals(other$deadlineForAcceptanceTime)) {
                                                                              Object this$acceptanceAddress = this.getAcceptanceAddress();
                                                                              Object other$acceptanceAddress = other.getAcceptanceAddress();
                                                                              if (this$acceptanceAddress == null
                                                                                 ? other$acceptanceAddress == null
                                                                                 : this$acceptanceAddress.equals(other$acceptanceAddress)) {
                                                                                 Object this$cost = this.getCost();
                                                                                 Object other$cost = other.getCost();
                                                                                 if (this$cost == null ? other$cost == null : this$cost.equals(other$cost)) {
                                                                                    Object this$remark = this.getRemark();
                                                                                    Object other$remark = other.getRemark();
                                                                                    if (this$remark == null
                                                                                       ? other$remark == null
                                                                                       : this$remark.equals(other$remark)) {
                                                                                       Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
                                                                                       Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
                                                                                       if (this$crmProjectInformationWarehousingName == null
                                                                                          ? other$crmProjectInformationWarehousingName == null
                                                                                          : this$crmProjectInformationWarehousingName.equals(
                                                                                             other$crmProjectInformationWarehousingName
                                                                                          )) {
                                                                                          Object this$serialNumber = this.getSerialNumber();
                                                                                          Object other$serialNumber = other.getSerialNumber();
                                                                                          if (this$serialNumber == null
                                                                                             ? other$serialNumber == null
                                                                                             : this$serialNumber.equals(other$serialNumber)) {
                                                                                             Object this$caLockDate = this.getCaLockDate();
                                                                                             Object other$caLockDate = other.getCaLockDate();
                                                                                             return this$caLockDate == null
                                                                                                ? other$caLockDate == null
                                                                                                : this$caLockDate.equals(other$caLockDate);
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
      return other instanceof CrmGovernmentWarehousingDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $unitPropertyAllocationConfigId = this.getUnitPropertyAllocationConfigId();
      result = result * 59 + ($unitPropertyAllocationConfigId == null ? 43 : $unitPropertyAllocationConfigId.hashCode());
      Object $unitClassConfigurationId = this.getUnitClassConfigurationId();
      result = result * 59 + ($unitClassConfigurationId == null ? 43 : $unitClassConfigurationId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $recordBindProject = this.getRecordBindProject();
      result = result * 59 + ($recordBindProject == null ? 43 : $recordBindProject.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $unitPropertyAllocationConfigName = this.getUnitPropertyAllocationConfigName();
      result = result * 59 + ($unitPropertyAllocationConfigName == null ? 43 : $unitPropertyAllocationConfigName.hashCode());
      Object $unitClassConfigurationName = this.getUnitClassConfigurationName();
      result = result * 59 + ($unitClassConfigurationName == null ? 43 : $unitClassConfigurationName.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $regionList = this.getRegionList();
      result = result * 59 + ($regionList == null ? 43 : $regionList.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      result = result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $acceptanceAddress = this.getAcceptanceAddress();
      result = result * 59 + ($acceptanceAddress == null ? 43 : $acceptanceAddress.hashCode());
      Object $cost = this.getCost();
      result = result * 59 + ($cost == null ? 43 : $cost.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      result = result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $caLockDate = this.getCaLockDate();
      return result * 59 + ($caLockDate == null ? 43 : $caLockDate.hashCode());
   }

   public static class CrmGovernmentWarehousingDetailDTOBuilder {
      private Long id;
      private Long informantUserId;
      private String informantUserName;
      private LocalDateTime informantDateTime;
      private Long createUserId;
      private String createUserName;
      private Integer crmCheckStatusEnum;
      private Long crmEnterpriseWarehousingId;
      private String crmEnterpriseWarehousingName;
      private Long departmentId;
      private String departmentName;
      private Long unitPropertyAllocationConfigId;
      private String unitPropertyAllocationConfigName;
      private Long unitClassConfigurationId;
      private String unitClassConfigurationName;
      private String regionNameList;
      private String address;
      private List<Long> regionList;
      private List<AttachmentDTO> attachmentIds;
      private List<AttachmentDTO> attachmentDTOList;
      private LocalDateTime deadlineForAcceptanceTime;
      private String acceptanceAddress;
      private BigDecimal cost;
      private String remark;
      private Long crmProjectInformationWarehousingId;
      private String crmProjectInformationWarehousingName;
      private Long approveRecordId;
      private String serialNumber;
      private Boolean recordBindProject;
      private LocalDate caLockDate;

      CrmGovernmentWarehousingDetailDTOBuilder() {
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder crmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
         this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder crmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder unitPropertyAllocationConfigId(
         final Long unitPropertyAllocationConfigId
      ) {
         this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder unitPropertyAllocationConfigName(
         final String unitPropertyAllocationConfigName
      ) {
         this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder unitClassConfigurationId(final Long unitClassConfigurationId) {
         this.unitClassConfigurationId = unitClassConfigurationId;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder unitClassConfigurationName(final String unitClassConfigurationName) {
         this.unitClassConfigurationName = unitClassConfigurationName;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder regionList(final List<Long> regionList) {
         this.regionList = regionList;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder attachmentIds(final List<AttachmentDTO> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder deadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
         this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder acceptanceAddress(final String acceptanceAddress) {
         this.acceptanceAddress = acceptanceAddress;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder cost(final BigDecimal cost) {
         this.cost = cost;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder crmProjectInformationWarehousingName(
         final String crmProjectInformationWarehousingName
      ) {
         this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder recordBindProject(final Boolean recordBindProject) {
         this.recordBindProject = recordBindProject;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder caLockDate(final LocalDate caLockDate) {
         this.caLockDate = caLockDate;
         return this;
      }

      public CrmGovernmentWarehousingDetailDTO build() {
         return new CrmGovernmentWarehousingDetailDTO(
            this.id,
            this.informantUserId,
            this.informantUserName,
            this.informantDateTime,
            this.createUserId,
            this.createUserName,
            this.crmCheckStatusEnum,
            this.crmEnterpriseWarehousingId,
            this.crmEnterpriseWarehousingName,
            this.departmentId,
            this.departmentName,
            this.unitPropertyAllocationConfigId,
            this.unitPropertyAllocationConfigName,
            this.unitClassConfigurationId,
            this.unitClassConfigurationName,
            this.regionNameList,
            this.address,
            this.regionList,
            this.attachmentIds,
            this.attachmentDTOList,
            this.deadlineForAcceptanceTime,
            this.acceptanceAddress,
            this.cost,
            this.remark,
            this.crmProjectInformationWarehousingId,
            this.crmProjectInformationWarehousingName,
            this.approveRecordId,
            this.serialNumber,
            this.recordBindProject,
            this.caLockDate
         );
      }

      @Override
      public String toString() {
         return "CrmGovernmentWarehousingDetailDTO.CrmGovernmentWarehousingDetailDTOBuilder(id="
            + this.id
            + ", informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", informantDateTime="
            + this.informantDateTime
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", crmEnterpriseWarehousingId="
            + this.crmEnterpriseWarehousingId
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", departmentId="
            + this.departmentId
            + ", departmentName="
            + this.departmentName
            + ", unitPropertyAllocationConfigId="
            + this.unitPropertyAllocationConfigId
            + ", unitPropertyAllocationConfigName="
            + this.unitPropertyAllocationConfigName
            + ", unitClassConfigurationId="
            + this.unitClassConfigurationId
            + ", unitClassConfigurationName="
            + this.unitClassConfigurationName
            + ", regionNameList="
            + this.regionNameList
            + ", address="
            + this.address
            + ", regionList="
            + this.regionList
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentDTOList="
            + this.attachmentDTOList
            + ", deadlineForAcceptanceTime="
            + this.deadlineForAcceptanceTime
            + ", acceptanceAddress="
            + this.acceptanceAddress
            + ", cost="
            + this.cost
            + ", remark="
            + this.remark
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", crmProjectInformationWarehousingName="
            + this.crmProjectInformationWarehousingName
            + ", approveRecordId="
            + this.approveRecordId
            + ", serialNumber="
            + this.serialNumber
            + ", recordBindProject="
            + this.recordBindProject
            + ", caLockDate="
            + this.caLockDate
            + ")";
      }
   }
}
