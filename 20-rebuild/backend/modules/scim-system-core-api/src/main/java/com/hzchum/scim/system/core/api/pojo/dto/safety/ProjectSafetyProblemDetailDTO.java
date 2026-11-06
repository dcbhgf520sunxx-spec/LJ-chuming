package com.hzchum.scim.system.core.api.pojo.dto.safety;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AreaInfoDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.MonomerInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("问题详情返回类")
@JsonInclude(Include.NON_NULL)
public class ProjectSafetyProblemDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "number", notes = "流水编号")
   private String number;
   @ApiModelProperty(name = "siteId", notes = "问题id")
   private Long siteId;
   @ApiModelProperty(name = "remark", notes = "问题详情")
   private String remark;
   @ApiModelProperty(name = "artifactSerialNumber", notes = "构件编号")
   private String artifactSerialNumber;
   @ApiModelProperty(name = "siteName", notes = "问题名称")
   private String siteName;
   @ApiModelProperty(name = "siteQualityOrSafetyEnum", notes = "问题类型")
   private Integer siteQualityOrSafetyEnum;
   @ApiModelProperty(name = "description", notes = "问题描述")
   private String description;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectName", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "projectShortName", notes = "项目简称")
   private String projectShortName;
   @ApiModelProperty(name = "projectSerialNumber", notes = "项目流水号")
   private String projectSerialNumber;
   @ApiModelProperty(name = "supplierName", notes = "供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "overseerUserId", value = "督办人", notes = "督办人")
   private Long overseerUserId;
   @ApiModelProperty(name = "overseerUserName", value = "督办人名称", notes = "督办人名称")
   private String overseerUserName;
   @ApiModelProperty(name = "problemStatus", value = "整改状态 ", notes = "整改状态 参考枚举ProblemStatusEnum ")
   private Integer problemStatus;
   @ApiModelProperty(name = "dutyId", value = "责任人id", notes = "责任人id")
   private Long dutyId;
   @ApiModelProperty(name = "dutyName", value = "责任人名称", notes = "责任人名称")
   private String dutyName;
   @ApiModelProperty("是否回复 true回复 false不回复")
   private Boolean boolReply;
   @ApiModelProperty(name = "problemDate", value = "问题发生日期", notes = "问题发生日期")
   private LocalDateTime problemDate;
   @ApiModelProperty(name = "promoterId", value = "发起人id", notes = "发起人id")
   private Long promoterId;
   @ApiModelProperty(name = "promoterName", value = "发起人", notes = "发起人")
   private String promoterName;
   @ApiModelProperty(name = "problemTypeName", value = "问题类型", notes = "问题类型")
   private String problemTypeName;
   @ApiModelProperty(name = "beforeChangeImgs", value = "整改前图片", notes = "整改前图片")
   private String beforeChangeImgs;
   @ApiModelProperty(name = "beforeChangeImgs", value = "整改前图片列表", notes = "整改前图片列表")
   private List<AttachmentDTO> beforeChangeAttachmentDTO;
   @ApiModelProperty(name = "penalty", value = "罚金", notes = "罚金")
   private BigDecimal penalty;
   @ApiModelProperty(name = "projectSafetyProblemRectifies", value = "整改信息列表", notes = "整改信息列表")
   private List<ProjectSafetyProblemRectifyDTO> projectSafetyProblemRectifies;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   private MonomerInfoDTO monomerInfoDTO;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   private AreaInfoDTO areaInfoDTO;
   @ApiModelProperty(name = "informantUserName", notes = "安装上报人")
   private String informantUserName;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   private String productSerialNumber;
   @ApiModelProperty(name = "productQuantity", notes = "产品问题数量")
   private Integer productQuantity;
   @ApiModelProperty(name = "projectManageInstallRecordId", value = "安装记录表id", notes = "安装记录表id")
   private Long projectManageInstallRecordId;
   @ApiModelProperty(name = "lastTaskId", value = "最后任务id", notes = "最后任务id")
   private Long lastTaskId;
   @ApiModelProperty(name = "siteDTO", value = "", notes = "站点信息")
   private SiteDTO siteDTO;

   public static ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder builder() {
      return new ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder();
   }

   public ProjectSafetyProblemDetailDTO() {
   }

   public ProjectSafetyProblemDetailDTO(
      final Long id,
      final String number,
      final Long siteId,
      final String remark,
      final String artifactSerialNumber,
      final String siteName,
      final Integer siteQualityOrSafetyEnum,
      final String description,
      final Long projectId,
      final String projectName,
      final String projectShortName,
      final String projectSerialNumber,
      final String supplierName,
      final Long overseerUserId,
      final String overseerUserName,
      final Integer problemStatus,
      final Long dutyId,
      final String dutyName,
      final Boolean boolReply,
      final LocalDateTime problemDate,
      final Long promoterId,
      final String promoterName,
      final String problemTypeName,
      final String beforeChangeImgs,
      final List<AttachmentDTO> beforeChangeAttachmentDTO,
      final BigDecimal penalty,
      final List<ProjectSafetyProblemRectifyDTO> projectSafetyProblemRectifies,
      final MonomerInfoDTO monomerInfoDTO,
      final AreaInfoDTO areaInfoDTO,
      final String informantUserName,
      final String productSerialNumber,
      final Integer productQuantity,
      final Long projectManageInstallRecordId,
      final Long lastTaskId,
      final SiteDTO siteDTO
   ) {
      this.id = id;
      this.number = number;
      this.siteId = siteId;
      this.remark = remark;
      this.artifactSerialNumber = artifactSerialNumber;
      this.siteName = siteName;
      this.siteQualityOrSafetyEnum = siteQualityOrSafetyEnum;
      this.description = description;
      this.projectId = projectId;
      this.projectName = projectName;
      this.projectShortName = projectShortName;
      this.projectSerialNumber = projectSerialNumber;
      this.supplierName = supplierName;
      this.overseerUserId = overseerUserId;
      this.overseerUserName = overseerUserName;
      this.problemStatus = problemStatus;
      this.dutyId = dutyId;
      this.dutyName = dutyName;
      this.boolReply = boolReply;
      this.problemDate = problemDate;
      this.promoterId = promoterId;
      this.promoterName = promoterName;
      this.problemTypeName = problemTypeName;
      this.beforeChangeImgs = beforeChangeImgs;
      this.beforeChangeAttachmentDTO = beforeChangeAttachmentDTO;
      this.penalty = penalty;
      this.projectSafetyProblemRectifies = projectSafetyProblemRectifies;
      this.monomerInfoDTO = monomerInfoDTO;
      this.areaInfoDTO = areaInfoDTO;
      this.informantUserName = informantUserName;
      this.productSerialNumber = productSerialNumber;
      this.productQuantity = productQuantity;
      this.projectManageInstallRecordId = projectManageInstallRecordId;
      this.lastTaskId = lastTaskId;
      this.siteDTO = siteDTO;
   }

   public Long getId() {
      return this.id;
   }

   public String getNumber() {
      return this.number;
   }

   public Long getSiteId() {
      return this.siteId;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
   }

   public String getSiteName() {
      return this.siteName;
   }

   public Integer getSiteQualityOrSafetyEnum() {
      return this.siteQualityOrSafetyEnum;
   }

   public String getDescription() {
      return this.description;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectShortName() {
      return this.projectShortName;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getOverseerUserId() {
      return this.overseerUserId;
   }

   public String getOverseerUserName() {
      return this.overseerUserName;
   }

   public Integer getProblemStatus() {
      return this.problemStatus;
   }

   public Long getDutyId() {
      return this.dutyId;
   }

   public String getDutyName() {
      return this.dutyName;
   }

   public Boolean getBoolReply() {
      return this.boolReply;
   }

   public LocalDateTime getProblemDate() {
      return this.problemDate;
   }

   public Long getPromoterId() {
      return this.promoterId;
   }

   public String getPromoterName() {
      return this.promoterName;
   }

   public String getProblemTypeName() {
      return this.problemTypeName;
   }

   public String getBeforeChangeImgs() {
      return this.beforeChangeImgs;
   }

   public List<AttachmentDTO> getBeforeChangeAttachmentDTO() {
      return this.beforeChangeAttachmentDTO;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public List<ProjectSafetyProblemRectifyDTO> getProjectSafetyProblemRectifies() {
      return this.projectSafetyProblemRectifies;
   }

   public MonomerInfoDTO getMonomerInfoDTO() {
      return this.monomerInfoDTO;
   }

   public AreaInfoDTO getAreaInfoDTO() {
      return this.areaInfoDTO;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Integer getProductQuantity() {
      return this.productQuantity;
   }

   public Long getProjectManageInstallRecordId() {
      return this.projectManageInstallRecordId;
   }

   public Long getLastTaskId() {
      return this.lastTaskId;
   }

   public SiteDTO getSiteDTO() {
      return this.siteDTO;
   }

   public ProjectSafetyProblemDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setNumber(final String number) {
      this.number = number;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setSiteId(final Long siteId) {
      this.siteId = siteId;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setArtifactSerialNumber(final String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setSiteName(final String siteName) {
      this.siteName = siteName;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setSiteQualityOrSafetyEnum(final Integer siteQualityOrSafetyEnum) {
      this.siteQualityOrSafetyEnum = siteQualityOrSafetyEnum;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setDescription(final String description) {
      this.description = description;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setProjectShortName(final String projectShortName) {
      this.projectShortName = projectShortName;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setOverseerUserId(final Long overseerUserId) {
      this.overseerUserId = overseerUserId;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setOverseerUserName(final String overseerUserName) {
      this.overseerUserName = overseerUserName;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setProblemStatus(final Integer problemStatus) {
      this.problemStatus = problemStatus;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setDutyId(final Long dutyId) {
      this.dutyId = dutyId;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setDutyName(final String dutyName) {
      this.dutyName = dutyName;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setBoolReply(final Boolean boolReply) {
      this.boolReply = boolReply;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setProblemDate(final LocalDateTime problemDate) {
      this.problemDate = problemDate;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setPromoterId(final Long promoterId) {
      this.promoterId = promoterId;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setPromoterName(final String promoterName) {
      this.promoterName = promoterName;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setProblemTypeName(final String problemTypeName) {
      this.problemTypeName = problemTypeName;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setBeforeChangeImgs(final String beforeChangeImgs) {
      this.beforeChangeImgs = beforeChangeImgs;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setBeforeChangeAttachmentDTO(final List<AttachmentDTO> beforeChangeAttachmentDTO) {
      this.beforeChangeAttachmentDTO = beforeChangeAttachmentDTO;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setProjectSafetyProblemRectifies(final List<ProjectSafetyProblemRectifyDTO> projectSafetyProblemRectifies) {
      this.projectSafetyProblemRectifies = projectSafetyProblemRectifies;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setMonomerInfoDTO(final MonomerInfoDTO monomerInfoDTO) {
      this.monomerInfoDTO = monomerInfoDTO;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setAreaInfoDTO(final AreaInfoDTO areaInfoDTO) {
      this.areaInfoDTO = areaInfoDTO;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setProductQuantity(final Integer productQuantity) {
      this.productQuantity = productQuantity;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setProjectManageInstallRecordId(final Long projectManageInstallRecordId) {
      this.projectManageInstallRecordId = projectManageInstallRecordId;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setLastTaskId(final Long lastTaskId) {
      this.lastTaskId = lastTaskId;
      return this;
   }

   public ProjectSafetyProblemDetailDTO setSiteDTO(final SiteDTO siteDTO) {
      this.siteDTO = siteDTO;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSafetyProblemDetailDTO(id="
         + this.getId()
         + ", number="
         + this.getNumber()
         + ", siteId="
         + this.getSiteId()
         + ", remark="
         + this.getRemark()
         + ", artifactSerialNumber="
         + this.getArtifactSerialNumber()
         + ", siteName="
         + this.getSiteName()
         + ", siteQualityOrSafetyEnum="
         + this.getSiteQualityOrSafetyEnum()
         + ", description="
         + this.getDescription()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", supplierName="
         + this.getSupplierName()
         + ", overseerUserId="
         + this.getOverseerUserId()
         + ", overseerUserName="
         + this.getOverseerUserName()
         + ", problemStatus="
         + this.getProblemStatus()
         + ", dutyId="
         + this.getDutyId()
         + ", dutyName="
         + this.getDutyName()
         + ", boolReply="
         + this.getBoolReply()
         + ", problemDate="
         + this.getProblemDate()
         + ", promoterId="
         + this.getPromoterId()
         + ", promoterName="
         + this.getPromoterName()
         + ", problemTypeName="
         + this.getProblemTypeName()
         + ", beforeChangeImgs="
         + this.getBeforeChangeImgs()
         + ", beforeChangeAttachmentDTO="
         + this.getBeforeChangeAttachmentDTO()
         + ", penalty="
         + this.getPenalty()
         + ", projectSafetyProblemRectifies="
         + this.getProjectSafetyProblemRectifies()
         + ", monomerInfoDTO="
         + this.getMonomerInfoDTO()
         + ", areaInfoDTO="
         + this.getAreaInfoDTO()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productQuantity="
         + this.getProductQuantity()
         + ", projectManageInstallRecordId="
         + this.getProjectManageInstallRecordId()
         + ", lastTaskId="
         + this.getLastTaskId()
         + ", siteDTO="
         + this.getSiteDTO()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSafetyProblemDetailDTO)) {
         return false;
      }

      ProjectSafetyProblemDetailDTO other = (ProjectSafetyProblemDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$siteId = this.getSiteId();
         Object other$siteId = other.getSiteId();
         if (this$siteId == null ? other$siteId == null : this$siteId.equals(other$siteId)) {
            Object this$siteQualityOrSafetyEnum = this.getSiteQualityOrSafetyEnum();
            Object other$siteQualityOrSafetyEnum = other.getSiteQualityOrSafetyEnum();
            if (this$siteQualityOrSafetyEnum == null
               ? other$siteQualityOrSafetyEnum == null
               : this$siteQualityOrSafetyEnum.equals(other$siteQualityOrSafetyEnum)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$overseerUserId = this.getOverseerUserId();
                  Object other$overseerUserId = other.getOverseerUserId();
                  if (this$overseerUserId == null ? other$overseerUserId == null : this$overseerUserId.equals(other$overseerUserId)) {
                     Object this$problemStatus = this.getProblemStatus();
                     Object other$problemStatus = other.getProblemStatus();
                     if (this$problemStatus == null ? other$problemStatus == null : this$problemStatus.equals(other$problemStatus)) {
                        Object this$dutyId = this.getDutyId();
                        Object other$dutyId = other.getDutyId();
                        if (this$dutyId == null ? other$dutyId == null : this$dutyId.equals(other$dutyId)) {
                           Object this$boolReply = this.getBoolReply();
                           Object other$boolReply = other.getBoolReply();
                           if (this$boolReply == null ? other$boolReply == null : this$boolReply.equals(other$boolReply)) {
                              Object this$promoterId = this.getPromoterId();
                              Object other$promoterId = other.getPromoterId();
                              if (this$promoterId == null ? other$promoterId == null : this$promoterId.equals(other$promoterId)) {
                                 Object this$productQuantity = this.getProductQuantity();
                                 Object other$productQuantity = other.getProductQuantity();
                                 if (this$productQuantity == null ? other$productQuantity == null : this$productQuantity.equals(other$productQuantity)) {
                                    Object this$projectManageInstallRecordId = this.getProjectManageInstallRecordId();
                                    Object other$projectManageInstallRecordId = other.getProjectManageInstallRecordId();
                                    if (this$projectManageInstallRecordId == null
                                       ? other$projectManageInstallRecordId == null
                                       : this$projectManageInstallRecordId.equals(other$projectManageInstallRecordId)) {
                                       Object this$lastTaskId = this.getLastTaskId();
                                       Object other$lastTaskId = other.getLastTaskId();
                                       if (this$lastTaskId == null ? other$lastTaskId == null : this$lastTaskId.equals(other$lastTaskId)) {
                                          Object this$number = this.getNumber();
                                          Object other$number = other.getNumber();
                                          if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                             Object this$remark = this.getRemark();
                                             Object other$remark = other.getRemark();
                                             if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                                                Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                                                if (this$artifactSerialNumber == null
                                                   ? other$artifactSerialNumber == null
                                                   : this$artifactSerialNumber.equals(other$artifactSerialNumber)) {
                                                   Object this$siteName = this.getSiteName();
                                                   Object other$siteName = other.getSiteName();
                                                   if (this$siteName == null ? other$siteName == null : this$siteName.equals(other$siteName)) {
                                                      Object this$description = this.getDescription();
                                                      Object other$description = other.getDescription();
                                                      if (this$description == null ? other$description == null : this$description.equals(other$description)) {
                                                         Object this$projectName = this.getProjectName();
                                                         Object other$projectName = other.getProjectName();
                                                         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                            Object this$projectShortName = this.getProjectShortName();
                                                            Object other$projectShortName = other.getProjectShortName();
                                                            if (this$projectShortName == null
                                                               ? other$projectShortName == null
                                                               : this$projectShortName.equals(other$projectShortName)) {
                                                               Object this$projectSerialNumber = this.getProjectSerialNumber();
                                                               Object other$projectSerialNumber = other.getProjectSerialNumber();
                                                               if (this$projectSerialNumber == null
                                                                  ? other$projectSerialNumber == null
                                                                  : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                                                                  Object this$supplierName = this.getSupplierName();
                                                                  Object other$supplierName = other.getSupplierName();
                                                                  if (this$supplierName == null
                                                                     ? other$supplierName == null
                                                                     : this$supplierName.equals(other$supplierName)) {
                                                                     Object this$overseerUserName = this.getOverseerUserName();
                                                                     Object other$overseerUserName = other.getOverseerUserName();
                                                                     if (this$overseerUserName == null
                                                                        ? other$overseerUserName == null
                                                                        : this$overseerUserName.equals(other$overseerUserName)) {
                                                                        Object this$dutyName = this.getDutyName();
                                                                        Object other$dutyName = other.getDutyName();
                                                                        if (this$dutyName == null
                                                                           ? other$dutyName == null
                                                                           : this$dutyName.equals(other$dutyName)) {
                                                                           Object this$problemDate = this.getProblemDate();
                                                                           Object other$problemDate = other.getProblemDate();
                                                                           if (this$problemDate == null
                                                                              ? other$problemDate == null
                                                                              : this$problemDate.equals(other$problemDate)) {
                                                                              Object this$promoterName = this.getPromoterName();
                                                                              Object other$promoterName = other.getPromoterName();
                                                                              if (this$promoterName == null
                                                                                 ? other$promoterName == null
                                                                                 : this$promoterName.equals(other$promoterName)) {
                                                                                 Object this$problemTypeName = this.getProblemTypeName();
                                                                                 Object other$problemTypeName = other.getProblemTypeName();
                                                                                 if (this$problemTypeName == null
                                                                                    ? other$problemTypeName == null
                                                                                    : this$problemTypeName.equals(other$problemTypeName)) {
                                                                                    Object this$beforeChangeImgs = this.getBeforeChangeImgs();
                                                                                    Object other$beforeChangeImgs = other.getBeforeChangeImgs();
                                                                                    if (this$beforeChangeImgs == null
                                                                                       ? other$beforeChangeImgs == null
                                                                                       : this$beforeChangeImgs.equals(other$beforeChangeImgs)) {
                                                                                       Object this$beforeChangeAttachmentDTO = this.getBeforeChangeAttachmentDTO();
                                                                                       Object other$beforeChangeAttachmentDTO = other.getBeforeChangeAttachmentDTO();
                                                                                       if (this$beforeChangeAttachmentDTO == null
                                                                                          ? other$beforeChangeAttachmentDTO == null
                                                                                          : this$beforeChangeAttachmentDTO.equals(
                                                                                             other$beforeChangeAttachmentDTO
                                                                                          )) {
                                                                                          Object this$penalty = this.getPenalty();
                                                                                          Object other$penalty = other.getPenalty();
                                                                                          if (this$penalty == null
                                                                                             ? other$penalty == null
                                                                                             : this$penalty.equals(other$penalty)) {
                                                                                             Object this$projectSafetyProblemRectifies = this.getProjectSafetyProblemRectifies();
                                                                                             Object other$projectSafetyProblemRectifies = other.getProjectSafetyProblemRectifies();
                                                                                             if (this$projectSafetyProblemRectifies == null
                                                                                                ? other$projectSafetyProblemRectifies == null
                                                                                                : this$projectSafetyProblemRectifies.equals(
                                                                                                   other$projectSafetyProblemRectifies
                                                                                                )) {
                                                                                                Object this$monomerInfoDTO = this.getMonomerInfoDTO();
                                                                                                Object other$monomerInfoDTO = other.getMonomerInfoDTO();
                                                                                                if (this$monomerInfoDTO == null
                                                                                                   ? other$monomerInfoDTO == null
                                                                                                   : this$monomerInfoDTO.equals(other$monomerInfoDTO)) {
                                                                                                   Object this$areaInfoDTO = this.getAreaInfoDTO();
                                                                                                   Object other$areaInfoDTO = other.getAreaInfoDTO();
                                                                                                   if (this$areaInfoDTO == null
                                                                                                      ? other$areaInfoDTO == null
                                                                                                      : this$areaInfoDTO.equals(other$areaInfoDTO)) {
                                                                                                      Object this$informantUserName = this.getInformantUserName();
                                                                                                      Object other$informantUserName = other.getInformantUserName();
                                                                                                      if (this$informantUserName == null
                                                                                                         ? other$informantUserName == null
                                                                                                         : this$informantUserName.equals(
                                                                                                            other$informantUserName
                                                                                                         )) {
                                                                                                         Object this$productSerialNumber = this.getProductSerialNumber();
                                                                                                         Object other$productSerialNumber = other.getProductSerialNumber();
                                                                                                         if (this$productSerialNumber == null
                                                                                                            ? other$productSerialNumber == null
                                                                                                            : this$productSerialNumber.equals(
                                                                                                               other$productSerialNumber
                                                                                                            )) {
                                                                                                            Object this$siteDTO = this.getSiteDTO();
                                                                                                            Object other$siteDTO = other.getSiteDTO();
                                                                                                            return this$siteDTO == null
                                                                                                               ? other$siteDTO == null
                                                                                                               : this$siteDTO.equals(other$siteDTO);
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
      return other instanceof ProjectSafetyProblemDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $siteId = this.getSiteId();
      result = result * 59 + ($siteId == null ? 43 : $siteId.hashCode());
      Object $siteQualityOrSafetyEnum = this.getSiteQualityOrSafetyEnum();
      result = result * 59 + ($siteQualityOrSafetyEnum == null ? 43 : $siteQualityOrSafetyEnum.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $overseerUserId = this.getOverseerUserId();
      result = result * 59 + ($overseerUserId == null ? 43 : $overseerUserId.hashCode());
      Object $problemStatus = this.getProblemStatus();
      result = result * 59 + ($problemStatus == null ? 43 : $problemStatus.hashCode());
      Object $dutyId = this.getDutyId();
      result = result * 59 + ($dutyId == null ? 43 : $dutyId.hashCode());
      Object $boolReply = this.getBoolReply();
      result = result * 59 + ($boolReply == null ? 43 : $boolReply.hashCode());
      Object $promoterId = this.getPromoterId();
      result = result * 59 + ($promoterId == null ? 43 : $promoterId.hashCode());
      Object $productQuantity = this.getProductQuantity();
      result = result * 59 + ($productQuantity == null ? 43 : $productQuantity.hashCode());
      Object $projectManageInstallRecordId = this.getProjectManageInstallRecordId();
      result = result * 59 + ($projectManageInstallRecordId == null ? 43 : $projectManageInstallRecordId.hashCode());
      Object $lastTaskId = this.getLastTaskId();
      result = result * 59 + ($lastTaskId == null ? 43 : $lastTaskId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $artifactSerialNumber = this.getArtifactSerialNumber();
      result = result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
      Object $siteName = this.getSiteName();
      result = result * 59 + ($siteName == null ? 43 : $siteName.hashCode());
      Object $description = this.getDescription();
      result = result * 59 + ($description == null ? 43 : $description.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectShortName = this.getProjectShortName();
      result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $overseerUserName = this.getOverseerUserName();
      result = result * 59 + ($overseerUserName == null ? 43 : $overseerUserName.hashCode());
      Object $dutyName = this.getDutyName();
      result = result * 59 + ($dutyName == null ? 43 : $dutyName.hashCode());
      Object $problemDate = this.getProblemDate();
      result = result * 59 + ($problemDate == null ? 43 : $problemDate.hashCode());
      Object $promoterName = this.getPromoterName();
      result = result * 59 + ($promoterName == null ? 43 : $promoterName.hashCode());
      Object $problemTypeName = this.getProblemTypeName();
      result = result * 59 + ($problemTypeName == null ? 43 : $problemTypeName.hashCode());
      Object $beforeChangeImgs = this.getBeforeChangeImgs();
      result = result * 59 + ($beforeChangeImgs == null ? 43 : $beforeChangeImgs.hashCode());
      Object $beforeChangeAttachmentDTO = this.getBeforeChangeAttachmentDTO();
      result = result * 59 + ($beforeChangeAttachmentDTO == null ? 43 : $beforeChangeAttachmentDTO.hashCode());
      Object $penalty = this.getPenalty();
      result = result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
      Object $projectSafetyProblemRectifies = this.getProjectSafetyProblemRectifies();
      result = result * 59 + ($projectSafetyProblemRectifies == null ? 43 : $projectSafetyProblemRectifies.hashCode());
      Object $monomerInfoDTO = this.getMonomerInfoDTO();
      result = result * 59 + ($monomerInfoDTO == null ? 43 : $monomerInfoDTO.hashCode());
      Object $areaInfoDTO = this.getAreaInfoDTO();
      result = result * 59 + ($areaInfoDTO == null ? 43 : $areaInfoDTO.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $siteDTO = this.getSiteDTO();
      return result * 59 + ($siteDTO == null ? 43 : $siteDTO.hashCode());
   }

   public static class ProjectSafetyProblemDetailDTOBuilder {
      private Long id;
      private String number;
      private Long siteId;
      private String remark;
      private String artifactSerialNumber;
      private String siteName;
      private Integer siteQualityOrSafetyEnum;
      private String description;
      private Long projectId;
      private String projectName;
      private String projectShortName;
      private String projectSerialNumber;
      private String supplierName;
      private Long overseerUserId;
      private String overseerUserName;
      private Integer problemStatus;
      private Long dutyId;
      private String dutyName;
      private Boolean boolReply;
      private LocalDateTime problemDate;
      private Long promoterId;
      private String promoterName;
      private String problemTypeName;
      private String beforeChangeImgs;
      private List<AttachmentDTO> beforeChangeAttachmentDTO;
      private BigDecimal penalty;
      private List<ProjectSafetyProblemRectifyDTO> projectSafetyProblemRectifies;
      private MonomerInfoDTO monomerInfoDTO;
      private AreaInfoDTO areaInfoDTO;
      private String informantUserName;
      private String productSerialNumber;
      private Integer productQuantity;
      private Long projectManageInstallRecordId;
      private Long lastTaskId;
      private SiteDTO siteDTO;

      ProjectSafetyProblemDetailDTOBuilder() {
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder number(final String number) {
         this.number = number;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder siteId(final Long siteId) {
         this.siteId = siteId;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder artifactSerialNumber(final String artifactSerialNumber) {
         this.artifactSerialNumber = artifactSerialNumber;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder siteName(final String siteName) {
         this.siteName = siteName;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder siteQualityOrSafetyEnum(final Integer siteQualityOrSafetyEnum) {
         this.siteQualityOrSafetyEnum = siteQualityOrSafetyEnum;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder description(final String description) {
         this.description = description;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder projectShortName(final String projectShortName) {
         this.projectShortName = projectShortName;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder projectSerialNumber(final String projectSerialNumber) {
         this.projectSerialNumber = projectSerialNumber;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder overseerUserId(final Long overseerUserId) {
         this.overseerUserId = overseerUserId;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder overseerUserName(final String overseerUserName) {
         this.overseerUserName = overseerUserName;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder problemStatus(final Integer problemStatus) {
         this.problemStatus = problemStatus;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder dutyId(final Long dutyId) {
         this.dutyId = dutyId;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder dutyName(final String dutyName) {
         this.dutyName = dutyName;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder boolReply(final Boolean boolReply) {
         this.boolReply = boolReply;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder problemDate(final LocalDateTime problemDate) {
         this.problemDate = problemDate;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder promoterId(final Long promoterId) {
         this.promoterId = promoterId;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder promoterName(final String promoterName) {
         this.promoterName = promoterName;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder problemTypeName(final String problemTypeName) {
         this.problemTypeName = problemTypeName;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder beforeChangeImgs(final String beforeChangeImgs) {
         this.beforeChangeImgs = beforeChangeImgs;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder beforeChangeAttachmentDTO(final List<AttachmentDTO> beforeChangeAttachmentDTO) {
         this.beforeChangeAttachmentDTO = beforeChangeAttachmentDTO;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder projectSafetyProblemRectifies(
         final List<ProjectSafetyProblemRectifyDTO> projectSafetyProblemRectifies
      ) {
         this.projectSafetyProblemRectifies = projectSafetyProblemRectifies;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder monomerInfoDTO(final MonomerInfoDTO monomerInfoDTO) {
         this.monomerInfoDTO = monomerInfoDTO;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder areaInfoDTO(final AreaInfoDTO areaInfoDTO) {
         this.areaInfoDTO = areaInfoDTO;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder productQuantity(final Integer productQuantity) {
         this.productQuantity = productQuantity;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder projectManageInstallRecordId(final Long projectManageInstallRecordId) {
         this.projectManageInstallRecordId = projectManageInstallRecordId;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder lastTaskId(final Long lastTaskId) {
         this.lastTaskId = lastTaskId;
         return this;
      }

      public ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder siteDTO(final SiteDTO siteDTO) {
         this.siteDTO = siteDTO;
         return this;
      }

      public ProjectSafetyProblemDetailDTO build() {
         return new ProjectSafetyProblemDetailDTO(
            this.id,
            this.number,
            this.siteId,
            this.remark,
            this.artifactSerialNumber,
            this.siteName,
            this.siteQualityOrSafetyEnum,
            this.description,
            this.projectId,
            this.projectName,
            this.projectShortName,
            this.projectSerialNumber,
            this.supplierName,
            this.overseerUserId,
            this.overseerUserName,
            this.problemStatus,
            this.dutyId,
            this.dutyName,
            this.boolReply,
            this.problemDate,
            this.promoterId,
            this.promoterName,
            this.problemTypeName,
            this.beforeChangeImgs,
            this.beforeChangeAttachmentDTO,
            this.penalty,
            this.projectSafetyProblemRectifies,
            this.monomerInfoDTO,
            this.areaInfoDTO,
            this.informantUserName,
            this.productSerialNumber,
            this.productQuantity,
            this.projectManageInstallRecordId,
            this.lastTaskId,
            this.siteDTO
         );
      }

      @Override
      public String toString() {
         return "ProjectSafetyProblemDetailDTO.ProjectSafetyProblemDetailDTOBuilder(id="
            + this.id
            + ", number="
            + this.number
            + ", siteId="
            + this.siteId
            + ", remark="
            + this.remark
            + ", artifactSerialNumber="
            + this.artifactSerialNumber
            + ", siteName="
            + this.siteName
            + ", siteQualityOrSafetyEnum="
            + this.siteQualityOrSafetyEnum
            + ", description="
            + this.description
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", projectShortName="
            + this.projectShortName
            + ", projectSerialNumber="
            + this.projectSerialNumber
            + ", supplierName="
            + this.supplierName
            + ", overseerUserId="
            + this.overseerUserId
            + ", overseerUserName="
            + this.overseerUserName
            + ", problemStatus="
            + this.problemStatus
            + ", dutyId="
            + this.dutyId
            + ", dutyName="
            + this.dutyName
            + ", boolReply="
            + this.boolReply
            + ", problemDate="
            + this.problemDate
            + ", promoterId="
            + this.promoterId
            + ", promoterName="
            + this.promoterName
            + ", problemTypeName="
            + this.problemTypeName
            + ", beforeChangeImgs="
            + this.beforeChangeImgs
            + ", beforeChangeAttachmentDTO="
            + this.beforeChangeAttachmentDTO
            + ", penalty="
            + this.penalty
            + ", projectSafetyProblemRectifies="
            + this.projectSafetyProblemRectifies
            + ", monomerInfoDTO="
            + this.monomerInfoDTO
            + ", areaInfoDTO="
            + this.areaInfoDTO
            + ", informantUserName="
            + this.informantUserName
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", productQuantity="
            + this.productQuantity
            + ", projectManageInstallRecordId="
            + this.projectManageInstallRecordId
            + ", lastTaskId="
            + this.lastTaskId
            + ", siteDTO="
            + this.siteDTO
            + ")";
      }
   }
}
