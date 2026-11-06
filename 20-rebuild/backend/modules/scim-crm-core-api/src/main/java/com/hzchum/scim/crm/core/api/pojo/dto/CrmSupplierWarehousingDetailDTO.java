package com.hzchum.scim.crm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CrmSupplierWarehousingDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "businessName", value = "企业名称", notes = "企业名称")
   private String businessName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案单位id", notes = "企业备案单位id")
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案单位名称", notes = "企业备案单位名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "unitClassConfigurationId", value = "单位性质id  参考crm_basics_config", notes = "单位性质id  参考crm_basics_config")
   private Long unitClassConfigurationId;
   @ApiModelProperty(name = "unitClassConfigurationName", value = "单位性质id  参考crm_basics_config", notes = "单位性质id  参考crm_basics_config")
   private String unitClassConfigurationName;
   @ApiModelProperty(name = "regionList", value = "地区id列表", notes = "地区id列表")
   private List<Long> regionList;
   @ApiModelProperty(name = "regionNameList", value = "地区名称列表", notes = "地区名称列表")
   private String regionNameList;
   @ApiModelProperty(name = "creditCode", value = "社会统一信用代码", notes = "社会统一信用代码")
   private String creditCode;
   @ApiModelProperty(name = "industryConfigurationId", value = "所属行业 CrmBasicsConfig", notes = "所属行业 CrmBasicsConfig")
   private Long industryConfigurationId;
   @ApiModelProperty(name = "industryConfigurationName", value = "所属行业 CrmBasicsConfig", notes = "所属行业 CrmBasicsConfig")
   private String industryConfigurationName;
   @ApiModelProperty(name = "unitPropertyAllocationConfigId", value = "单位类别id  参考crm_basics_config", notes = "单位类别id  参考crm_basics_config")
   private Long unitPropertyAllocationConfigId;
   @ApiModelProperty(name = "unitPropertyAllocationConfigName", value = "单位类别id  参考crm_basics_config", notes = "单位类别id  参考crm_basics_config")
   private String unitPropertyAllocationConfigName;
   @ApiModelProperty(name = "qualificationAndAbility", value = "资质能力", notes = "资质能力")
   private String qualificationAndAbility;
   @ApiModelProperty(name = "businessPhone", value = "单位电话", notes = "单位电话")
   private String businessPhone;
   @ApiModelProperty(name = "businessEmail", value = "单位邮箱", notes = "单位邮箱")
   private String businessEmail;
   @ApiModelProperty(name = "address", value = "详细地址", notes = "详细地址")
   private String address;
   @ApiModelProperty(name = "liaisons", value = "联系人", notes = "联系人")
   private String liaisons;
   @ApiModelProperty(name = "serial_number", notes = "备案编号")
   private String serialNumber;
   @ApiModelProperty(name = "informantUserId", value = "填报人", notes = "填报人")
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   private String informantUserName;
   @ApiModelProperty(name = "departmentId", value = "所属部门", notes = "所属部门")
   private Long departmentId;
   @ApiModelProperty(name = "departmentName", value = "所属部门名称", notes = "所属部门名称")
   private String departmentName;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "attachmentIds", value = "入库附件列表", notes = "入库附件列表")
   private List<AttachmentDTO> attachmentIds;
   @ApiModelProperty(name = "attachmentDTOList", value = "入库附件列表", notes = "入库附件列表")
   private List<AttachmentDTO> attachmentDTOList;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "受理截至日期", notes = "受理截至日期")
   private LocalDateTime deadlineForAcceptanceTime;
   @ApiModelProperty(name = "acceptanceAddress", value = "受理地址", notes = "受理地址")
   private String acceptanceAddress;
   @ApiModelProperty(name = "cost", value = "费用", notes = "费用")
   private BigDecimal cost;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "CALockDate", value = "锁定日期", notes = "锁定日期")
   private LocalDate caLockDate;

   public static CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder builder() {
      return new CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder();
   }

   public CrmSupplierWarehousingDetailDTO() {
   }

   public CrmSupplierWarehousingDetailDTO(
      final Long id,
      final String businessName,
      final Long crmEnterpriseWarehousingId,
      final String crmEnterpriseWarehousingName,
      final Long unitClassConfigurationId,
      final String unitClassConfigurationName,
      final List<Long> regionList,
      final String regionNameList,
      final String creditCode,
      final Long industryConfigurationId,
      final String industryConfigurationName,
      final Long unitPropertyAllocationConfigId,
      final String unitPropertyAllocationConfigName,
      final String qualificationAndAbility,
      final String businessPhone,
      final String businessEmail,
      final String address,
      final String liaisons,
      final String serialNumber,
      final Long informantUserId,
      final String informantUserName,
      final Long departmentId,
      final String departmentName,
      final LocalDateTime informantDateTime,
      final List<AttachmentDTO> attachmentIds,
      final List<AttachmentDTO> attachmentDTOList,
      final LocalDateTime deadlineForAcceptanceTime,
      final String acceptanceAddress,
      final BigDecimal cost,
      final String remark,
      final LocalDate caLockDate
   ) {
      this.id = id;
      this.businessName = businessName;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.unitClassConfigurationId = unitClassConfigurationId;
      this.unitClassConfigurationName = unitClassConfigurationName;
      this.regionList = regionList;
      this.regionNameList = regionNameList;
      this.creditCode = creditCode;
      this.industryConfigurationId = industryConfigurationId;
      this.industryConfigurationName = industryConfigurationName;
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      this.qualificationAndAbility = qualificationAndAbility;
      this.businessPhone = businessPhone;
      this.businessEmail = businessEmail;
      this.address = address;
      this.liaisons = liaisons;
      this.serialNumber = serialNumber;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.departmentId = departmentId;
      this.departmentName = departmentName;
      this.informantDateTime = informantDateTime;
      this.attachmentIds = attachmentIds;
      this.attachmentDTOList = attachmentDTOList;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.acceptanceAddress = acceptanceAddress;
      this.cost = cost;
      this.remark = remark;
      this.caLockDate = caLockDate;
   }

   public Long getId() {
      return this.id;
   }

   public String getBusinessName() {
      return this.businessName;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public Long getUnitClassConfigurationId() {
      return this.unitClassConfigurationId;
   }

   public String getUnitClassConfigurationName() {
      return this.unitClassConfigurationName;
   }

   public List<Long> getRegionList() {
      return this.regionList;
   }

   public String getRegionNameList() {
      return this.regionNameList;
   }

   public String getCreditCode() {
      return this.creditCode;
   }

   public Long getIndustryConfigurationId() {
      return this.industryConfigurationId;
   }

   public String getIndustryConfigurationName() {
      return this.industryConfigurationName;
   }

   public Long getUnitPropertyAllocationConfigId() {
      return this.unitPropertyAllocationConfigId;
   }

   public String getUnitPropertyAllocationConfigName() {
      return this.unitPropertyAllocationConfigName;
   }

   public String getQualificationAndAbility() {
      return this.qualificationAndAbility;
   }

   public String getBusinessPhone() {
      return this.businessPhone;
   }

   public String getBusinessEmail() {
      return this.businessEmail;
   }

   public String getAddress() {
      return this.address;
   }

   public String getLiaisons() {
      return this.liaisons;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getInformantUserId() {
      return this.informantUserId;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
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

   public LocalDate getCaLockDate() {
      return this.caLockDate;
   }

   public CrmSupplierWarehousingDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setBusinessName(final String businessName) {
      this.businessName = businessName;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setUnitClassConfigurationId(final Long unitClassConfigurationId) {
      this.unitClassConfigurationId = unitClassConfigurationId;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setUnitClassConfigurationName(final String unitClassConfigurationName) {
      this.unitClassConfigurationName = unitClassConfigurationName;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setRegionList(final List<Long> regionList) {
      this.regionList = regionList;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setCreditCode(final String creditCode) {
      this.creditCode = creditCode;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setIndustryConfigurationId(final Long industryConfigurationId) {
      this.industryConfigurationId = industryConfigurationId;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setIndustryConfigurationName(final String industryConfigurationName) {
      this.industryConfigurationName = industryConfigurationName;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setUnitPropertyAllocationConfigId(final Long unitPropertyAllocationConfigId) {
      this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setUnitPropertyAllocationConfigName(final String unitPropertyAllocationConfigName) {
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setQualificationAndAbility(final String qualificationAndAbility) {
      this.qualificationAndAbility = qualificationAndAbility;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setBusinessPhone(final String businessPhone) {
      this.businessPhone = businessPhone;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setBusinessEmail(final String businessEmail) {
      this.businessEmail = businessEmail;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setAddress(final String address) {
      this.address = address;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setLiaisons(final String liaisons) {
      this.liaisons = liaisons;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setAttachmentIds(final List<AttachmentDTO> attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setAttachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setDeadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setAcceptanceAddress(final String acceptanceAddress) {
      this.acceptanceAddress = acceptanceAddress;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setCost(final BigDecimal cost) {
      this.cost = cost;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmSupplierWarehousingDetailDTO setCaLockDate(final LocalDate caLockDate) {
      this.caLockDate = caLockDate;
      return this;
   }

   @Override
   public String toString() {
      return "CrmSupplierWarehousingDetailDTO(id="
         + this.getId()
         + ", businessName="
         + this.getBusinessName()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", unitClassConfigurationId="
         + this.getUnitClassConfigurationId()
         + ", unitClassConfigurationName="
         + this.getUnitClassConfigurationName()
         + ", regionList="
         + this.getRegionList()
         + ", regionNameList="
         + this.getRegionNameList()
         + ", creditCode="
         + this.getCreditCode()
         + ", industryConfigurationId="
         + this.getIndustryConfigurationId()
         + ", industryConfigurationName="
         + this.getIndustryConfigurationName()
         + ", unitPropertyAllocationConfigId="
         + this.getUnitPropertyAllocationConfigId()
         + ", unitPropertyAllocationConfigName="
         + this.getUnitPropertyAllocationConfigName()
         + ", qualificationAndAbility="
         + this.getQualificationAndAbility()
         + ", businessPhone="
         + this.getBusinessPhone()
         + ", businessEmail="
         + this.getBusinessEmail()
         + ", address="
         + this.getAddress()
         + ", liaisons="
         + this.getLiaisons()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", departmentId="
         + this.getDepartmentId()
         + ", departmentName="
         + this.getDepartmentName()
         + ", informantDateTime="
         + this.getInformantDateTime()
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
         + ", caLockDate="
         + this.getCaLockDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmSupplierWarehousingDetailDTO)) {
         return false;
      }

      CrmSupplierWarehousingDetailDTO other = (CrmSupplierWarehousingDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
         Object other$crmEnterpriseWarehousingId = other.getCrmEnterpriseWarehousingId();
         if (this$crmEnterpriseWarehousingId == null
            ? other$crmEnterpriseWarehousingId == null
            : this$crmEnterpriseWarehousingId.equals(other$crmEnterpriseWarehousingId)) {
            Object this$unitClassConfigurationId = this.getUnitClassConfigurationId();
            Object other$unitClassConfigurationId = other.getUnitClassConfigurationId();
            if (this$unitClassConfigurationId == null
               ? other$unitClassConfigurationId == null
               : this$unitClassConfigurationId.equals(other$unitClassConfigurationId)) {
               Object this$industryConfigurationId = this.getIndustryConfigurationId();
               Object other$industryConfigurationId = other.getIndustryConfigurationId();
               if (this$industryConfigurationId == null
                  ? other$industryConfigurationId == null
                  : this$industryConfigurationId.equals(other$industryConfigurationId)) {
                  Object this$unitPropertyAllocationConfigId = this.getUnitPropertyAllocationConfigId();
                  Object other$unitPropertyAllocationConfigId = other.getUnitPropertyAllocationConfigId();
                  if (this$unitPropertyAllocationConfigId == null
                     ? other$unitPropertyAllocationConfigId == null
                     : this$unitPropertyAllocationConfigId.equals(other$unitPropertyAllocationConfigId)) {
                     Object this$informantUserId = this.getInformantUserId();
                     Object other$informantUserId = other.getInformantUserId();
                     if (this$informantUserId == null ? other$informantUserId == null : this$informantUserId.equals(other$informantUserId)) {
                        Object this$departmentId = this.getDepartmentId();
                        Object other$departmentId = other.getDepartmentId();
                        if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
                           Object this$businessName = this.getBusinessName();
                           Object other$businessName = other.getBusinessName();
                           if (this$businessName == null ? other$businessName == null : this$businessName.equals(other$businessName)) {
                              Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                              Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                              if (this$crmEnterpriseWarehousingName == null
                                 ? other$crmEnterpriseWarehousingName == null
                                 : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                                 Object this$unitClassConfigurationName = this.getUnitClassConfigurationName();
                                 Object other$unitClassConfigurationName = other.getUnitClassConfigurationName();
                                 if (this$unitClassConfigurationName == null
                                    ? other$unitClassConfigurationName == null
                                    : this$unitClassConfigurationName.equals(other$unitClassConfigurationName)) {
                                    Object this$regionList = this.getRegionList();
                                    Object other$regionList = other.getRegionList();
                                    if (this$regionList == null ? other$regionList == null : this$regionList.equals(other$regionList)) {
                                       Object this$regionNameList = this.getRegionNameList();
                                       Object other$regionNameList = other.getRegionNameList();
                                       if (this$regionNameList == null ? other$regionNameList == null : this$regionNameList.equals(other$regionNameList)) {
                                          Object this$creditCode = this.getCreditCode();
                                          Object other$creditCode = other.getCreditCode();
                                          if (this$creditCode == null ? other$creditCode == null : this$creditCode.equals(other$creditCode)) {
                                             Object this$industryConfigurationName = this.getIndustryConfigurationName();
                                             Object other$industryConfigurationName = other.getIndustryConfigurationName();
                                             if (this$industryConfigurationName == null
                                                ? other$industryConfigurationName == null
                                                : this$industryConfigurationName.equals(other$industryConfigurationName)) {
                                                Object this$unitPropertyAllocationConfigName = this.getUnitPropertyAllocationConfigName();
                                                Object other$unitPropertyAllocationConfigName = other.getUnitPropertyAllocationConfigName();
                                                if (this$unitPropertyAllocationConfigName == null
                                                   ? other$unitPropertyAllocationConfigName == null
                                                   : this$unitPropertyAllocationConfigName.equals(other$unitPropertyAllocationConfigName)) {
                                                   Object this$qualificationAndAbility = this.getQualificationAndAbility();
                                                   Object other$qualificationAndAbility = other.getQualificationAndAbility();
                                                   if (this$qualificationAndAbility == null
                                                      ? other$qualificationAndAbility == null
                                                      : this$qualificationAndAbility.equals(other$qualificationAndAbility)) {
                                                      Object this$businessPhone = this.getBusinessPhone();
                                                      Object other$businessPhone = other.getBusinessPhone();
                                                      if (this$businessPhone == null
                                                         ? other$businessPhone == null
                                                         : this$businessPhone.equals(other$businessPhone)) {
                                                         Object this$businessEmail = this.getBusinessEmail();
                                                         Object other$businessEmail = other.getBusinessEmail();
                                                         if (this$businessEmail == null
                                                            ? other$businessEmail == null
                                                            : this$businessEmail.equals(other$businessEmail)) {
                                                            Object this$address = this.getAddress();
                                                            Object other$address = other.getAddress();
                                                            if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                               Object this$liaisons = this.getLiaisons();
                                                               Object other$liaisons = other.getLiaisons();
                                                               if (this$liaisons == null ? other$liaisons == null : this$liaisons.equals(other$liaisons)) {
                                                                  Object this$serialNumber = this.getSerialNumber();
                                                                  Object other$serialNumber = other.getSerialNumber();
                                                                  if (this$serialNumber == null
                                                                     ? other$serialNumber == null
                                                                     : this$serialNumber.equals(other$serialNumber)) {
                                                                     Object this$informantUserName = this.getInformantUserName();
                                                                     Object other$informantUserName = other.getInformantUserName();
                                                                     if (this$informantUserName == null
                                                                        ? other$informantUserName == null
                                                                        : this$informantUserName.equals(other$informantUserName)) {
                                                                        Object this$departmentName = this.getDepartmentName();
                                                                        Object other$departmentName = other.getDepartmentName();
                                                                        if (this$departmentName == null
                                                                           ? other$departmentName == null
                                                                           : this$departmentName.equals(other$departmentName)) {
                                                                           Object this$informantDateTime = this.getInformantDateTime();
                                                                           Object other$informantDateTime = other.getInformantDateTime();
                                                                           if (this$informantDateTime == null
                                                                              ? other$informantDateTime == null
                                                                              : this$informantDateTime.equals(other$informantDateTime)) {
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
                                                                                       : this$deadlineForAcceptanceTime.equals(other$deadlineForAcceptanceTime)
                                                                                       )
                                                                                     {
                                                                                       Object this$acceptanceAddress = this.getAcceptanceAddress();
                                                                                       Object other$acceptanceAddress = other.getAcceptanceAddress();
                                                                                       if (this$acceptanceAddress == null
                                                                                          ? other$acceptanceAddress == null
                                                                                          : this$acceptanceAddress.equals(other$acceptanceAddress)) {
                                                                                          Object this$cost = this.getCost();
                                                                                          Object other$cost = other.getCost();
                                                                                          if (this$cost == null
                                                                                             ? other$cost == null
                                                                                             : this$cost.equals(other$cost)) {
                                                                                             Object this$remark = this.getRemark();
                                                                                             Object other$remark = other.getRemark();
                                                                                             if (this$remark == null
                                                                                                ? other$remark == null
                                                                                                : this$remark.equals(other$remark)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmSupplierWarehousingDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $unitClassConfigurationId = this.getUnitClassConfigurationId();
      result = result * 59 + ($unitClassConfigurationId == null ? 43 : $unitClassConfigurationId.hashCode());
      Object $industryConfigurationId = this.getIndustryConfigurationId();
      result = result * 59 + ($industryConfigurationId == null ? 43 : $industryConfigurationId.hashCode());
      Object $unitPropertyAllocationConfigId = this.getUnitPropertyAllocationConfigId();
      result = result * 59 + ($unitPropertyAllocationConfigId == null ? 43 : $unitPropertyAllocationConfigId.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $businessName = this.getBusinessName();
      result = result * 59 + ($businessName == null ? 43 : $businessName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $unitClassConfigurationName = this.getUnitClassConfigurationName();
      result = result * 59 + ($unitClassConfigurationName == null ? 43 : $unitClassConfigurationName.hashCode());
      Object $regionList = this.getRegionList();
      result = result * 59 + ($regionList == null ? 43 : $regionList.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
      Object $creditCode = this.getCreditCode();
      result = result * 59 + ($creditCode == null ? 43 : $creditCode.hashCode());
      Object $industryConfigurationName = this.getIndustryConfigurationName();
      result = result * 59 + ($industryConfigurationName == null ? 43 : $industryConfigurationName.hashCode());
      Object $unitPropertyAllocationConfigName = this.getUnitPropertyAllocationConfigName();
      result = result * 59 + ($unitPropertyAllocationConfigName == null ? 43 : $unitPropertyAllocationConfigName.hashCode());
      Object $qualificationAndAbility = this.getQualificationAndAbility();
      result = result * 59 + ($qualificationAndAbility == null ? 43 : $qualificationAndAbility.hashCode());
      Object $businessPhone = this.getBusinessPhone();
      result = result * 59 + ($businessPhone == null ? 43 : $businessPhone.hashCode());
      Object $businessEmail = this.getBusinessEmail();
      result = result * 59 + ($businessEmail == null ? 43 : $businessEmail.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $liaisons = this.getLiaisons();
      result = result * 59 + ($liaisons == null ? 43 : $liaisons.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
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
      Object $caLockDate = this.getCaLockDate();
      return result * 59 + ($caLockDate == null ? 43 : $caLockDate.hashCode());
   }

   public static class CrmSupplierWarehousingDetailDTOBuilder {
      private Long id;
      private String businessName;
      private Long crmEnterpriseWarehousingId;
      private String crmEnterpriseWarehousingName;
      private Long unitClassConfigurationId;
      private String unitClassConfigurationName;
      private List<Long> regionList;
      private String regionNameList;
      private String creditCode;
      private Long industryConfigurationId;
      private String industryConfigurationName;
      private Long unitPropertyAllocationConfigId;
      private String unitPropertyAllocationConfigName;
      private String qualificationAndAbility;
      private String businessPhone;
      private String businessEmail;
      private String address;
      private String liaisons;
      private String serialNumber;
      private Long informantUserId;
      private String informantUserName;
      private Long departmentId;
      private String departmentName;
      private LocalDateTime informantDateTime;
      private List<AttachmentDTO> attachmentIds;
      private List<AttachmentDTO> attachmentDTOList;
      private LocalDateTime deadlineForAcceptanceTime;
      private String acceptanceAddress;
      private BigDecimal cost;
      private String remark;
      private LocalDate caLockDate;

      CrmSupplierWarehousingDetailDTOBuilder() {
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder businessName(final String businessName) {
         this.businessName = businessName;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder crmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
         this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder crmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder unitClassConfigurationId(final Long unitClassConfigurationId) {
         this.unitClassConfigurationId = unitClassConfigurationId;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder unitClassConfigurationName(final String unitClassConfigurationName) {
         this.unitClassConfigurationName = unitClassConfigurationName;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder regionList(final List<Long> regionList) {
         this.regionList = regionList;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder creditCode(final String creditCode) {
         this.creditCode = creditCode;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder industryConfigurationId(final Long industryConfigurationId) {
         this.industryConfigurationId = industryConfigurationId;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder industryConfigurationName(final String industryConfigurationName) {
         this.industryConfigurationName = industryConfigurationName;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder unitPropertyAllocationConfigId(final Long unitPropertyAllocationConfigId) {
         this.unitPropertyAllocationConfigId = unitPropertyAllocationConfigId;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder unitPropertyAllocationConfigName(
         final String unitPropertyAllocationConfigName
      ) {
         this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder qualificationAndAbility(final String qualificationAndAbility) {
         this.qualificationAndAbility = qualificationAndAbility;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder businessPhone(final String businessPhone) {
         this.businessPhone = businessPhone;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder businessEmail(final String businessEmail) {
         this.businessEmail = businessEmail;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder address(final String address) {
         this.address = address;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder liaisons(final String liaisons) {
         this.liaisons = liaisons;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder attachmentIds(final List<AttachmentDTO> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder attachmentDTOList(final List<AttachmentDTO> attachmentDTOList) {
         this.attachmentDTOList = attachmentDTOList;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder deadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
         this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder acceptanceAddress(final String acceptanceAddress) {
         this.acceptanceAddress = acceptanceAddress;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder cost(final BigDecimal cost) {
         this.cost = cost;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder caLockDate(final LocalDate caLockDate) {
         this.caLockDate = caLockDate;
         return this;
      }

      public CrmSupplierWarehousingDetailDTO build() {
         return new CrmSupplierWarehousingDetailDTO(
            this.id,
            this.businessName,
            this.crmEnterpriseWarehousingId,
            this.crmEnterpriseWarehousingName,
            this.unitClassConfigurationId,
            this.unitClassConfigurationName,
            this.regionList,
            this.regionNameList,
            this.creditCode,
            this.industryConfigurationId,
            this.industryConfigurationName,
            this.unitPropertyAllocationConfigId,
            this.unitPropertyAllocationConfigName,
            this.qualificationAndAbility,
            this.businessPhone,
            this.businessEmail,
            this.address,
            this.liaisons,
            this.serialNumber,
            this.informantUserId,
            this.informantUserName,
            this.departmentId,
            this.departmentName,
            this.informantDateTime,
            this.attachmentIds,
            this.attachmentDTOList,
            this.deadlineForAcceptanceTime,
            this.acceptanceAddress,
            this.cost,
            this.remark,
            this.caLockDate
         );
      }

      @Override
      public String toString() {
         return "CrmSupplierWarehousingDetailDTO.CrmSupplierWarehousingDetailDTOBuilder(id="
            + this.id
            + ", businessName="
            + this.businessName
            + ", crmEnterpriseWarehousingId="
            + this.crmEnterpriseWarehousingId
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", unitClassConfigurationId="
            + this.unitClassConfigurationId
            + ", unitClassConfigurationName="
            + this.unitClassConfigurationName
            + ", regionList="
            + this.regionList
            + ", regionNameList="
            + this.regionNameList
            + ", creditCode="
            + this.creditCode
            + ", industryConfigurationId="
            + this.industryConfigurationId
            + ", industryConfigurationName="
            + this.industryConfigurationName
            + ", unitPropertyAllocationConfigId="
            + this.unitPropertyAllocationConfigId
            + ", unitPropertyAllocationConfigName="
            + this.unitPropertyAllocationConfigName
            + ", qualificationAndAbility="
            + this.qualificationAndAbility
            + ", businessPhone="
            + this.businessPhone
            + ", businessEmail="
            + this.businessEmail
            + ", address="
            + this.address
            + ", liaisons="
            + this.liaisons
            + ", serialNumber="
            + this.serialNumber
            + ", informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", departmentId="
            + this.departmentId
            + ", departmentName="
            + this.departmentName
            + ", informantDateTime="
            + this.informantDateTime
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
            + ", caLockDate="
            + this.caLockDate
            + ")";
      }
   }
}
