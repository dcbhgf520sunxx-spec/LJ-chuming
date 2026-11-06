package com.hzchum.scim.crm.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CrmGovernmentWarehousing对象", description = "政府备案")
@Entity
@TableName("crm_government_warehousing")
@Table(name = "crm_government_warehousing")
@org.hibernate.annotations.Table(appliesTo = "crm_government_warehousing")
public class CrmGovernmentWarehousing extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "informantUserId", value = "填报人id", notes = "填报人id")
   @TableField("informant_user_id")
   @Column(name = "informant_user_id", columnDefinition = "bigint(20)  COMMENT '填报人id'", nullable = true)
   private Long informantUserId;
   @ApiModelProperty(name = "informantUserName", value = "填报人名称", notes = "填报人名称")
   @TableField("informant_user_name")
   @Column(name = "informant_user_name", columnDefinition = "varchar(255)  COMMENT '填报人名称'", nullable = true)
   private String informantUserName;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   @TableField("informant_date_time")
   @Column(name = "informant_date_time", columnDefinition = "datetime  COMMENT '填报日期'", nullable = true)
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = true)
   private Long createUserId;
   @ApiModelProperty(name = "departmentId", value = "部门id", notes = "部门id")
   @TableField("department_id")
   @Column(name = "department_id", columnDefinition = "bigint  COMMENT '部门id'", nullable = true)
   private Long departmentId;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "crm审核状态", notes = "crm审核状态")
   @TableField("crm_check_status_enum")
   @Column(name = "crm_check_status_enum", columnDefinition = "int(11)  COMMENT 'crm审核状态'", nullable = true)
   private Integer crmCheckStatusEnum;
   @ApiModelProperty(name = "crmEnterpriseWarehousingId", value = "企业备案id", notes = "企业备案id")
   @TableField("crm_enterprise_warehousing_id")
   @Column(name = "crm_enterprise_warehousing_id", columnDefinition = "bigint(20)  COMMENT '企业备案id'", nullable = true)
   private Long crmEnterpriseWarehousingId;
   @ApiModelProperty(name = "countryId", value = "国家id", notes = "国家id")
   @TableField("country_id")
   @Column(name = "country_id", columnDefinition = "bigint(20)  COMMENT '国家id'", nullable = true)
   private Long countryId;
   @ApiModelProperty(name = "countryName", value = "国家名称", notes = "国家名称")
   @TableField("country_name")
   @Column(name = "country_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '国家名称'", nullable = true)
   private String countryName;
   @ApiModelProperty(name = "provinceId", value = "省份id", notes = "省份id")
   @TableField("province_id")
   @Column(name = "province_id", columnDefinition = "bigint(20)  COMMENT '省份id'", nullable = true)
   private Long provinceId;
   @ApiModelProperty(name = "provinceName", value = "省份名称", notes = "省份名称")
   @TableField("province_name")
   @Column(name = "province_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '省份名称'", nullable = true)
   private String provinceName;
   @ApiModelProperty(name = "cityId", value = "城市id", notes = "城市id")
   @TableField("city_id")
   @Column(name = "city_id", columnDefinition = "bigint(20)  COMMENT '城市id'", nullable = true)
   private Long cityId;
   @ApiModelProperty(name = "cityName", value = "城市名称", notes = "城市名称")
   @TableField("city_name")
   @Column(name = "city_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '城市名称'", nullable = true)
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "地区id", notes = "地区id")
   @TableField("region_id")
   @Column(name = "region_id", columnDefinition = "bigint(20)  COMMENT '地区id'", nullable = true)
   private Long regionId;
   @ApiModelProperty(name = "regionName", value = "地区名称", notes = "地区名称")
   @TableField("region_name")
   @Column(name = "region_name", columnDefinition = "varchar(255) DEFAULT '' COMMENT '地区名称'", nullable = true)
   private String regionName;
   @ApiModelProperty(name = "attachmentIds", value = "附件id集合", notes = "附件id集合")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '附件id集合'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "deadlineForAcceptanceTime", value = "受理截至日期", notes = "受理截至日期")
   @TableField("deadline_for_acceptance_time")
   @Column(name = "deadline_for_acceptance_time", columnDefinition = "datetime  COMMENT '受理截至日期'", nullable = true)
   private LocalDateTime deadlineForAcceptanceTime;
   @ApiModelProperty(name = "acceptanceAddress", value = "受理地址", notes = "受理地址")
   @TableField("acceptance_address")
   @Column(name = "acceptance_address", columnDefinition = "varchar(255)  COMMENT '受理地址'", nullable = true)
   private String acceptanceAddress;
   @ApiModelProperty(name = "cost", value = "费用", notes = "费用")
   @TableField("cost")
   @Column(name = "cost", columnDefinition = "decimal(10,2)  COMMENT '费用'", nullable = true)
   private BigDecimal cost;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "approveRecordId", value = "审批id", notes = "审批id")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint(20)  COMMENT '审批id'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "serialNumber", value = "备案编号", notes = "备案编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '备案编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   @TableField("crm_project_information_warehousing_id")
   @Column(name = "crm_project_information_warehousing_id", columnDefinition = "bigint(20)  COMMENT '项目备案id'", nullable = true)
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "overruleUserName", value = "驳回人名称", notes = "驳回人名称")
   @TableField("overrule_user_name")
   @Column(name = "overrule_user_name", columnDefinition = "varchar(255)  COMMENT '驳回人名称'", nullable = true)
   private String overruleUserName;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(255)  COMMENT '创建人名称'", nullable = true)
   private String createUserName;
   @ApiModelProperty(name = "crmRecordTypeEnum", value = "备案状态", notes = "备案状态")
   @TableField("crm_record_type_enum")
   @Column(name = "crm_record_type_enum", columnDefinition = "int(11)  COMMENT '备案状态'", nullable = true)
   private Integer crmRecordTypeEnum;
   @ApiModelProperty(name = "CALockDate", value = "锁定日期", notes = "锁定日期")
   @TableField("ca_lock_date")
   @Column(name = "ca_lock_date", columnDefinition = "date  COMMENT '锁定日期'", nullable = true)
   private LocalDate caLockDate;

   public static CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder builder() {
      return new CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder();
   }

   public CrmGovernmentWarehousing() {
   }

   public CrmGovernmentWarehousing(
      final Long id,
      final Long informantUserId,
      final String informantUserName,
      final LocalDateTime informantDateTime,
      final Long createUserId,
      final Long departmentId,
      final Integer crmCheckStatusEnum,
      final Long crmEnterpriseWarehousingId,
      final Long countryId,
      final String countryName,
      final Long provinceId,
      final String provinceName,
      final Long cityId,
      final String cityName,
      final Long regionId,
      final String regionName,
      final String attachmentIds,
      final LocalDateTime deadlineForAcceptanceTime,
      final String acceptanceAddress,
      final BigDecimal cost,
      final String remark,
      final Long approveRecordId,
      final String serialNumber,
      final Long crmProjectInformationWarehousingId,
      final String overruleUserName,
      final String createUserName,
      final Integer crmRecordTypeEnum,
      final LocalDate caLockDate
   ) {
      this.id = id;
      this.informantUserId = informantUserId;
      this.informantUserName = informantUserName;
      this.informantDateTime = informantDateTime;
      this.createUserId = createUserId;
      this.departmentId = departmentId;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      this.countryId = countryId;
      this.countryName = countryName;
      this.provinceId = provinceId;
      this.provinceName = provinceName;
      this.cityId = cityId;
      this.cityName = cityName;
      this.regionId = regionId;
      this.regionName = regionName;
      this.attachmentIds = attachmentIds;
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      this.acceptanceAddress = acceptanceAddress;
      this.cost = cost;
      this.remark = remark;
      this.approveRecordId = approveRecordId;
      this.serialNumber = serialNumber;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.overruleUserName = overruleUserName;
      this.createUserName = createUserName;
      this.crmRecordTypeEnum = crmRecordTypeEnum;
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

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public Long getCrmEnterpriseWarehousingId() {
      return this.crmEnterpriseWarehousingId;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getProvinceName() {
      return this.provinceName;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getCityName() {
      return this.cityName;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
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

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public String getOverruleUserName() {
      return this.overruleUserName;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getCrmRecordTypeEnum() {
      return this.crmRecordTypeEnum;
   }

   public LocalDate getCaLockDate() {
      return this.caLockDate;
   }

   public CrmGovernmentWarehousing setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmGovernmentWarehousing setInformantUserId(final Long informantUserId) {
      this.informantUserId = informantUserId;
      return this;
   }

   public CrmGovernmentWarehousing setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmGovernmentWarehousing setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmGovernmentWarehousing setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmGovernmentWarehousing setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public CrmGovernmentWarehousing setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   public CrmGovernmentWarehousing setCrmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
      this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
      return this;
   }

   public CrmGovernmentWarehousing setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmGovernmentWarehousing setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmGovernmentWarehousing setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmGovernmentWarehousing setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmGovernmentWarehousing setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmGovernmentWarehousing setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmGovernmentWarehousing setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   public CrmGovernmentWarehousing setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmGovernmentWarehousing setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public CrmGovernmentWarehousing setDeadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
      this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
      return this;
   }

   public CrmGovernmentWarehousing setAcceptanceAddress(final String acceptanceAddress) {
      this.acceptanceAddress = acceptanceAddress;
      return this;
   }

   public CrmGovernmentWarehousing setCost(final BigDecimal cost) {
      this.cost = cost;
      return this;
   }

   public CrmGovernmentWarehousing setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public CrmGovernmentWarehousing setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmGovernmentWarehousing setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmGovernmentWarehousing setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmGovernmentWarehousing setOverruleUserName(final String overruleUserName) {
      this.overruleUserName = overruleUserName;
      return this;
   }

   public CrmGovernmentWarehousing setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmGovernmentWarehousing setCrmRecordTypeEnum(final Integer crmRecordTypeEnum) {
      this.crmRecordTypeEnum = crmRecordTypeEnum;
      return this;
   }

   public CrmGovernmentWarehousing setCaLockDate(final LocalDate caLockDate) {
      this.caLockDate = caLockDate;
      return this;
   }

   @Override
   public String toString() {
      return "CrmGovernmentWarehousing(id="
         + this.getId()
         + ", informantUserId="
         + this.getInformantUserId()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", createUserId="
         + this.getCreateUserId()
         + ", departmentId="
         + this.getDepartmentId()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ", crmEnterpriseWarehousingId="
         + this.getCrmEnterpriseWarehousingId()
         + ", countryId="
         + this.getCountryId()
         + ", countryName="
         + this.getCountryName()
         + ", provinceId="
         + this.getProvinceId()
         + ", provinceName="
         + this.getProvinceName()
         + ", cityId="
         + this.getCityId()
         + ", cityName="
         + this.getCityName()
         + ", regionId="
         + this.getRegionId()
         + ", regionName="
         + this.getRegionName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", deadlineForAcceptanceTime="
         + this.getDeadlineForAcceptanceTime()
         + ", acceptanceAddress="
         + this.getAcceptanceAddress()
         + ", cost="
         + this.getCost()
         + ", remark="
         + this.getRemark()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", overruleUserName="
         + this.getOverruleUserName()
         + ", createUserName="
         + this.getCreateUserName()
         + ", crmRecordTypeEnum="
         + this.getCrmRecordTypeEnum()
         + ", caLockDate="
         + this.getCaLockDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmGovernmentWarehousing)) {
         return false;
      }

      CrmGovernmentWarehousing other = (CrmGovernmentWarehousing)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
               Object this$departmentId = this.getDepartmentId();
               Object other$departmentId = other.getDepartmentId();
               if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
                  Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
                  Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
                  if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
                     Object this$crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
                     Object other$crmEnterpriseWarehousingId = other.getCrmEnterpriseWarehousingId();
                     if (this$crmEnterpriseWarehousingId == null
                        ? other$crmEnterpriseWarehousingId == null
                        : this$crmEnterpriseWarehousingId.equals(other$crmEnterpriseWarehousingId)) {
                        Object this$countryId = this.getCountryId();
                        Object other$countryId = other.getCountryId();
                        if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
                           Object this$provinceId = this.getProvinceId();
                           Object other$provinceId = other.getProvinceId();
                           if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
                              Object this$cityId = this.getCityId();
                              Object other$cityId = other.getCityId();
                              if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
                                 Object this$regionId = this.getRegionId();
                                 Object other$regionId = other.getRegionId();
                                 if (this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId)) {
                                    Object this$approveRecordId = this.getApproveRecordId();
                                    Object other$approveRecordId = other.getApproveRecordId();
                                    if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                                       Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
                                       Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
                                       if (this$crmProjectInformationWarehousingId == null
                                          ? other$crmProjectInformationWarehousingId == null
                                          : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
                                          Object this$crmRecordTypeEnum = this.getCrmRecordTypeEnum();
                                          Object other$crmRecordTypeEnum = other.getCrmRecordTypeEnum();
                                          if (this$crmRecordTypeEnum == null
                                             ? other$crmRecordTypeEnum == null
                                             : this$crmRecordTypeEnum.equals(other$crmRecordTypeEnum)) {
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
                                                   Object this$countryName = this.getCountryName();
                                                   Object other$countryName = other.getCountryName();
                                                   if (this$countryName == null ? other$countryName == null : this$countryName.equals(other$countryName)) {
                                                      Object this$provinceName = this.getProvinceName();
                                                      Object other$provinceName = other.getProvinceName();
                                                      if (this$provinceName == null ? other$provinceName == null : this$provinceName.equals(other$provinceName)
                                                         )
                                                       {
                                                         Object this$cityName = this.getCityName();
                                                         Object other$cityName = other.getCityName();
                                                         if (this$cityName == null ? other$cityName == null : this$cityName.equals(other$cityName)) {
                                                            Object this$regionName = this.getRegionName();
                                                            Object other$regionName = other.getRegionName();
                                                            if (this$regionName == null ? other$regionName == null : this$regionName.equals(other$regionName)) {
                                                               Object this$attachmentIds = this.getAttachmentIds();
                                                               Object other$attachmentIds = other.getAttachmentIds();
                                                               if (this$attachmentIds == null
                                                                  ? other$attachmentIds == null
                                                                  : this$attachmentIds.equals(other$attachmentIds)) {
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
                                                                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                              Object this$serialNumber = this.getSerialNumber();
                                                                              Object other$serialNumber = other.getSerialNumber();
                                                                              if (this$serialNumber == null
                                                                                 ? other$serialNumber == null
                                                                                 : this$serialNumber.equals(other$serialNumber)) {
                                                                                 Object this$overruleUserName = this.getOverruleUserName();
                                                                                 Object other$overruleUserName = other.getOverruleUserName();
                                                                                 if (this$overruleUserName == null
                                                                                    ? other$overruleUserName == null
                                                                                    : this$overruleUserName.equals(other$overruleUserName)) {
                                                                                    Object this$createUserName = this.getCreateUserName();
                                                                                    Object other$createUserName = other.getCreateUserName();
                                                                                    if (this$createUserName == null
                                                                                       ? other$createUserName == null
                                                                                       : this$createUserName.equals(other$createUserName)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CrmGovernmentWarehousing;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantUserId = this.getInformantUserId();
      result = result * 59 + ($informantUserId == null ? 43 : $informantUserId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $crmEnterpriseWarehousingId = this.getCrmEnterpriseWarehousingId();
      result = result * 59 + ($crmEnterpriseWarehousingId == null ? 43 : $crmEnterpriseWarehousingId.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $crmRecordTypeEnum = this.getCrmRecordTypeEnum();
      result = result * 59 + ($crmRecordTypeEnum == null ? 43 : $crmRecordTypeEnum.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $deadlineForAcceptanceTime = this.getDeadlineForAcceptanceTime();
      result = result * 59 + ($deadlineForAcceptanceTime == null ? 43 : $deadlineForAcceptanceTime.hashCode());
      Object $acceptanceAddress = this.getAcceptanceAddress();
      result = result * 59 + ($acceptanceAddress == null ? 43 : $acceptanceAddress.hashCode());
      Object $cost = this.getCost();
      result = result * 59 + ($cost == null ? 43 : $cost.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $overruleUserName = this.getOverruleUserName();
      result = result * 59 + ($overruleUserName == null ? 43 : $overruleUserName.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $caLockDate = this.getCaLockDate();
      return result * 59 + ($caLockDate == null ? 43 : $caLockDate.hashCode());
   }

   public static class CrmGovernmentWarehousingBuilder {
      private Long id;
      private Long informantUserId;
      private String informantUserName;
      private LocalDateTime informantDateTime;
      private Long createUserId;
      private Long departmentId;
      private Integer crmCheckStatusEnum;
      private Long crmEnterpriseWarehousingId;
      private Long countryId;
      private String countryName;
      private Long provinceId;
      private String provinceName;
      private Long cityId;
      private String cityName;
      private Long regionId;
      private String regionName;
      private String attachmentIds;
      private LocalDateTime deadlineForAcceptanceTime;
      private String acceptanceAddress;
      private BigDecimal cost;
      private String remark;
      private Long approveRecordId;
      private String serialNumber;
      private Long crmProjectInformationWarehousingId;
      private String overruleUserName;
      private String createUserName;
      private Integer crmRecordTypeEnum;
      private LocalDate caLockDate;

      CrmGovernmentWarehousingBuilder() {
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder informantUserId(final Long informantUserId) {
         this.informantUserId = informantUserId;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder crmEnterpriseWarehousingId(final Long crmEnterpriseWarehousingId) {
         this.crmEnterpriseWarehousingId = crmEnterpriseWarehousingId;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder deadlineForAcceptanceTime(final LocalDateTime deadlineForAcceptanceTime) {
         this.deadlineForAcceptanceTime = deadlineForAcceptanceTime;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder acceptanceAddress(final String acceptanceAddress) {
         this.acceptanceAddress = acceptanceAddress;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder cost(final BigDecimal cost) {
         this.cost = cost;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder crmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder overruleUserName(final String overruleUserName) {
         this.overruleUserName = overruleUserName;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder crmRecordTypeEnum(final Integer crmRecordTypeEnum) {
         this.crmRecordTypeEnum = crmRecordTypeEnum;
         return this;
      }

      public CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder caLockDate(final LocalDate caLockDate) {
         this.caLockDate = caLockDate;
         return this;
      }

      public CrmGovernmentWarehousing build() {
         return new CrmGovernmentWarehousing(
            this.id,
            this.informantUserId,
            this.informantUserName,
            this.informantDateTime,
            this.createUserId,
            this.departmentId,
            this.crmCheckStatusEnum,
            this.crmEnterpriseWarehousingId,
            this.countryId,
            this.countryName,
            this.provinceId,
            this.provinceName,
            this.cityId,
            this.cityName,
            this.regionId,
            this.regionName,
            this.attachmentIds,
            this.deadlineForAcceptanceTime,
            this.acceptanceAddress,
            this.cost,
            this.remark,
            this.approveRecordId,
            this.serialNumber,
            this.crmProjectInformationWarehousingId,
            this.overruleUserName,
            this.createUserName,
            this.crmRecordTypeEnum,
            this.caLockDate
         );
      }

      @Override
      public String toString() {
         return "CrmGovernmentWarehousing.CrmGovernmentWarehousingBuilder(id="
            + this.id
            + ", informantUserId="
            + this.informantUserId
            + ", informantUserName="
            + this.informantUserName
            + ", informantDateTime="
            + this.informantDateTime
            + ", createUserId="
            + this.createUserId
            + ", departmentId="
            + this.departmentId
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ", crmEnterpriseWarehousingId="
            + this.crmEnterpriseWarehousingId
            + ", countryId="
            + this.countryId
            + ", countryName="
            + this.countryName
            + ", provinceId="
            + this.provinceId
            + ", provinceName="
            + this.provinceName
            + ", cityId="
            + this.cityId
            + ", cityName="
            + this.cityName
            + ", regionId="
            + this.regionId
            + ", regionName="
            + this.regionName
            + ", attachmentIds="
            + this.attachmentIds
            + ", deadlineForAcceptanceTime="
            + this.deadlineForAcceptanceTime
            + ", acceptanceAddress="
            + this.acceptanceAddress
            + ", cost="
            + this.cost
            + ", remark="
            + this.remark
            + ", approveRecordId="
            + this.approveRecordId
            + ", serialNumber="
            + this.serialNumber
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", overruleUserName="
            + this.overruleUserName
            + ", createUserName="
            + this.createUserName
            + ", crmRecordTypeEnum="
            + this.crmRecordTypeEnum
            + ", caLockDate="
            + this.caLockDate
            + ")";
      }
   }
}
