package com.hzchum.scim.scm.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ApplyPurchaseDTO {
   private Long id;
   private String serialNumber;
   private Integer type;
   private Integer materialType;
   private ProjectInfo project;
   private String projectIds;
   private List<ProjectInfo> projectInfos;
   private Long applicantId;
   private String applicantName;
   private Long editorId;
   private String editorName;
   private Integer reviewStatus;
   @JsonInclude(Include.NON_NULL)
   private Long approveProcessId;
   @JsonInclude(Include.NON_NULL)
   private Integer finishedProductType;
   private String approveInfoName;
   private BigDecimal inboundMete;
   private BigDecimal totalMete;
   private Boolean enabled;
   private LocalDateTime reviewTime;
   private String remark;
   private LocalDateTime createTime;
   private String reviewerIds;
   private Integer purchaseCreationState;
   private Boolean boolInitiateApprove;
   private List<ApplyPurchaseDetailDTO> detailList;
   private List<ApplyPurchaseDetailDTO> inboundList;
   private LocalDateTime updateTime;
   private String departmentName;
   private String projectName;
   private Integer level;
   private List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS;
   private String tsData;
   private Boolean boolTemporaryStorage;
   private Boolean editable;
   private Long approveRecordIdNow;
   private String approveRecordIds;
   private Integer dataStatus;
   @ApiModelProperty("申购单父级编号 存储申购单父级编号 本身是父级时就存储本身编号")
   private String serialNumberParent;
   @ApiModelProperty(name = "branchCompanyId ", value = "签订主体公司信息ID")
   private Long branchCompanyId;
   @ApiModelProperty(name = "branchCompanyId ", value = "签订主体公司信息")
   private com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO branchCompany;
   @ApiModelProperty(name = "delButtonType ", value = "删除按钮展示类型 1撤销 2删除 3撤销删除 4撤销编辑")
   private Integer delButtonType;
   private List<AttachmentDTO> attachments;
   private Boolean boolUsed;
   private BigDecimal havePurchasedMete;
   private BigDecimal unPurchaseMete;
   private String meteUnit;
   private Integer branchAttributeEnum;

   public static ApplyPurchaseDTO.ApplyPurchaseDTOBuilder builder() {
      return new ApplyPurchaseDTO.ApplyPurchaseDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public List<ProjectInfo> getProjectInfos() {
      return this.projectInfos;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getEditorId() {
      return this.editorId;
   }

   public String getEditorName() {
      return this.editorName;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getApproveProcessId() {
      return this.approveProcessId;
   }

   public Integer getFinishedProductType() {
      return this.finishedProductType;
   }

   public String getApproveInfoName() {
      return this.approveInfoName;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getReviewerIds() {
      return this.reviewerIds;
   }

   public Integer getPurchaseCreationState() {
      return this.purchaseCreationState;
   }

   public Boolean getBoolInitiateApprove() {
      return this.boolInitiateApprove;
   }

   public List<ApplyPurchaseDetailDTO> getDetailList() {
      return this.detailList;
   }

   public List<ApplyPurchaseDetailDTO> getInboundList() {
      return this.inboundList;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Integer getLevel() {
      return this.level;
   }

   public List<WmsApproveRecordFlowDTO> getWmsApproveRecordFlowDTOS() {
      return this.wmsApproveRecordFlowDTOS;
   }

   public String getTsData() {
      return this.tsData;
   }

   public Boolean getBoolTemporaryStorage() {
      return this.boolTemporaryStorage;
   }

   public Boolean getEditable() {
      return this.editable;
   }

   public Long getApproveRecordIdNow() {
      return this.approveRecordIdNow;
   }

   public String getApproveRecordIds() {
      return this.approveRecordIds;
   }

   public Integer getDataStatus() {
      return this.dataStatus;
   }

   public String getSerialNumberParent() {
      return this.serialNumberParent;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO getBranchCompany() {
      return this.branchCompany;
   }

   public Integer getDelButtonType() {
      return this.delButtonType;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public Boolean getBoolUsed() {
      return this.boolUsed;
   }

   public BigDecimal getHavePurchasedMete() {
      return this.havePurchasedMete;
   }

   public BigDecimal getUnPurchaseMete() {
      return this.unPurchaseMete;
   }

   public String getMeteUnit() {
      return this.meteUnit;
   }

   public Integer getBranchAttributeEnum() {
      return this.branchAttributeEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   public void setProjectInfos(final List<ProjectInfo> projectInfos) {
      this.projectInfos = projectInfos;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setEditorId(final Long editorId) {
      this.editorId = editorId;
   }

   public void setEditorName(final String editorName) {
      this.editorName = editorName;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setApproveProcessId(final Long approveProcessId) {
      this.approveProcessId = approveProcessId;
   }

   public void setFinishedProductType(final Integer finishedProductType) {
      this.finishedProductType = finishedProductType;
   }

   public void setApproveInfoName(final String approveInfoName) {
      this.approveInfoName = approveInfoName;
   }

   public void setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
   }

   public void setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
   }

   public void setEnabled(final Boolean enabled) {
      this.enabled = enabled;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setReviewerIds(final String reviewerIds) {
      this.reviewerIds = reviewerIds;
   }

   public void setPurchaseCreationState(final Integer purchaseCreationState) {
      this.purchaseCreationState = purchaseCreationState;
   }

   public void setBoolInitiateApprove(final Boolean boolInitiateApprove) {
      this.boolInitiateApprove = boolInitiateApprove;
   }

   public void setDetailList(final List<ApplyPurchaseDetailDTO> detailList) {
      this.detailList = detailList;
   }

   public void setInboundList(final List<ApplyPurchaseDetailDTO> inboundList) {
      this.inboundList = inboundList;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   public void setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setWmsApproveRecordFlowDTOS(final List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS) {
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
   }

   public void setTsData(final String tsData) {
      this.tsData = tsData;
   }

   public void setBoolTemporaryStorage(final Boolean boolTemporaryStorage) {
      this.boolTemporaryStorage = boolTemporaryStorage;
   }

   public void setEditable(final Boolean editable) {
      this.editable = editable;
   }

   public void setApproveRecordIdNow(final Long approveRecordIdNow) {
      this.approveRecordIdNow = approveRecordIdNow;
   }

   public void setApproveRecordIds(final String approveRecordIds) {
      this.approveRecordIds = approveRecordIds;
   }

   public void setDataStatus(final Integer dataStatus) {
      this.dataStatus = dataStatus;
   }

   public void setSerialNumberParent(final String serialNumberParent) {
      this.serialNumberParent = serialNumberParent;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompany(final com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO branchCompany) {
      this.branchCompany = branchCompany;
   }

   public void setDelButtonType(final Integer delButtonType) {
      this.delButtonType = delButtonType;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setBoolUsed(final Boolean boolUsed) {
      this.boolUsed = boolUsed;
   }

   public void setHavePurchasedMete(final BigDecimal havePurchasedMete) {
      this.havePurchasedMete = havePurchasedMete;
   }

   public void setUnPurchaseMete(final BigDecimal unPurchaseMete) {
      this.unPurchaseMete = unPurchaseMete;
   }

   public void setMeteUnit(final String meteUnit) {
      this.meteUnit = meteUnit;
   }

   public void setBranchAttributeEnum(final Integer branchAttributeEnum) {
      this.branchAttributeEnum = branchAttributeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApplyPurchaseDTO)) {
         return false;
      }

      ApplyPurchaseDTO other = (ApplyPurchaseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$materialType = this.getMaterialType();
            Object other$materialType = other.getMaterialType();
            if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
               Object this$applicantId = this.getApplicantId();
               Object other$applicantId = other.getApplicantId();
               if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                  Object this$editorId = this.getEditorId();
                  Object other$editorId = other.getEditorId();
                  if (this$editorId == null ? other$editorId == null : this$editorId.equals(other$editorId)) {
                     Object this$reviewStatus = this.getReviewStatus();
                     Object other$reviewStatus = other.getReviewStatus();
                     if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                        Object this$approveProcessId = this.getApproveProcessId();
                        Object other$approveProcessId = other.getApproveProcessId();
                        if (this$approveProcessId == null ? other$approveProcessId == null : this$approveProcessId.equals(other$approveProcessId)) {
                           Object this$finishedProductType = this.getFinishedProductType();
                           Object other$finishedProductType = other.getFinishedProductType();
                           if (this$finishedProductType == null
                              ? other$finishedProductType == null
                              : this$finishedProductType.equals(other$finishedProductType)) {
                              Object this$enabled = this.getEnabled();
                              Object other$enabled = other.getEnabled();
                              if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
                                 Object this$purchaseCreationState = this.getPurchaseCreationState();
                                 Object other$purchaseCreationState = other.getPurchaseCreationState();
                                 if (this$purchaseCreationState == null
                                    ? other$purchaseCreationState == null
                                    : this$purchaseCreationState.equals(other$purchaseCreationState)) {
                                    Object this$boolInitiateApprove = this.getBoolInitiateApprove();
                                    Object other$boolInitiateApprove = other.getBoolInitiateApprove();
                                    if (this$boolInitiateApprove == null
                                       ? other$boolInitiateApprove == null
                                       : this$boolInitiateApprove.equals(other$boolInitiateApprove)) {
                                       Object this$level = this.getLevel();
                                       Object other$level = other.getLevel();
                                       if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                                          Object this$boolTemporaryStorage = this.getBoolTemporaryStorage();
                                          Object other$boolTemporaryStorage = other.getBoolTemporaryStorage();
                                          if (this$boolTemporaryStorage == null
                                             ? other$boolTemporaryStorage == null
                                             : this$boolTemporaryStorage.equals(other$boolTemporaryStorage)) {
                                             Object this$editable = this.getEditable();
                                             Object other$editable = other.getEditable();
                                             if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                                                Object this$approveRecordIdNow = this.getApproveRecordIdNow();
                                                Object other$approveRecordIdNow = other.getApproveRecordIdNow();
                                                if (this$approveRecordIdNow == null
                                                   ? other$approveRecordIdNow == null
                                                   : this$approveRecordIdNow.equals(other$approveRecordIdNow)) {
                                                   Object this$dataStatus = this.getDataStatus();
                                                   Object other$dataStatus = other.getDataStatus();
                                                   if (this$dataStatus == null ? other$dataStatus == null : this$dataStatus.equals(other$dataStatus)) {
                                                      Object this$branchCompanyId = this.getBranchCompanyId();
                                                      Object other$branchCompanyId = other.getBranchCompanyId();
                                                      if (this$branchCompanyId == null
                                                         ? other$branchCompanyId == null
                                                         : this$branchCompanyId.equals(other$branchCompanyId)) {
                                                         Object this$delButtonType = this.getDelButtonType();
                                                         Object other$delButtonType = other.getDelButtonType();
                                                         if (this$delButtonType == null
                                                            ? other$delButtonType == null
                                                            : this$delButtonType.equals(other$delButtonType)) {
                                                            Object this$boolUsed = this.getBoolUsed();
                                                            Object other$boolUsed = other.getBoolUsed();
                                                            if (this$boolUsed == null ? other$boolUsed == null : this$boolUsed.equals(other$boolUsed)) {
                                                               Object this$branchAttributeEnum = this.getBranchAttributeEnum();
                                                               Object other$branchAttributeEnum = other.getBranchAttributeEnum();
                                                               if (this$branchAttributeEnum == null
                                                                  ? other$branchAttributeEnum == null
                                                                  : this$branchAttributeEnum.equals(other$branchAttributeEnum)) {
                                                                  Object this$serialNumber = this.getSerialNumber();
                                                                  Object other$serialNumber = other.getSerialNumber();
                                                                  if (this$serialNumber == null
                                                                     ? other$serialNumber == null
                                                                     : this$serialNumber.equals(other$serialNumber)) {
                                                                     Object this$project = this.getProject();
                                                                     Object other$project = other.getProject();
                                                                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                        Object this$projectIds = this.getProjectIds();
                                                                        Object other$projectIds = other.getProjectIds();
                                                                        if (this$projectIds == null
                                                                           ? other$projectIds == null
                                                                           : this$projectIds.equals(other$projectIds)) {
                                                                           Object this$projectInfos = this.getProjectInfos();
                                                                           Object other$projectInfos = other.getProjectInfos();
                                                                           if (this$projectInfos == null
                                                                              ? other$projectInfos == null
                                                                              : this$projectInfos.equals(other$projectInfos)) {
                                                                              Object this$applicantName = this.getApplicantName();
                                                                              Object other$applicantName = other.getApplicantName();
                                                                              if (this$applicantName == null
                                                                                 ? other$applicantName == null
                                                                                 : this$applicantName.equals(other$applicantName)) {
                                                                                 Object this$editorName = this.getEditorName();
                                                                                 Object other$editorName = other.getEditorName();
                                                                                 if (this$editorName == null
                                                                                    ? other$editorName == null
                                                                                    : this$editorName.equals(other$editorName)) {
                                                                                    Object this$approveInfoName = this.getApproveInfoName();
                                                                                    Object other$approveInfoName = other.getApproveInfoName();
                                                                                    if (this$approveInfoName == null
                                                                                       ? other$approveInfoName == null
                                                                                       : this$approveInfoName.equals(other$approveInfoName)) {
                                                                                       Object this$inboundMete = this.getInboundMete();
                                                                                       Object other$inboundMete = other.getInboundMete();
                                                                                       if (this$inboundMete == null
                                                                                          ? other$inboundMete == null
                                                                                          : this$inboundMete.equals(other$inboundMete)) {
                                                                                          Object this$totalMete = this.getTotalMete();
                                                                                          Object other$totalMete = other.getTotalMete();
                                                                                          if (this$totalMete == null
                                                                                             ? other$totalMete == null
                                                                                             : this$totalMete.equals(other$totalMete)) {
                                                                                             Object this$reviewTime = this.getReviewTime();
                                                                                             Object other$reviewTime = other.getReviewTime();
                                                                                             if (this$reviewTime == null
                                                                                                ? other$reviewTime == null
                                                                                                : this$reviewTime.equals(other$reviewTime)) {
                                                                                                Object this$remark = this.getRemark();
                                                                                                Object other$remark = other.getRemark();
                                                                                                if (this$remark == null
                                                                                                   ? other$remark == null
                                                                                                   : this$remark.equals(other$remark)) {
                                                                                                   Object this$createTime = this.getCreateTime();
                                                                                                   Object other$createTime = other.getCreateTime();
                                                                                                   if (this$createTime == null
                                                                                                      ? other$createTime == null
                                                                                                      : this$createTime.equals(other$createTime)) {
                                                                                                      Object this$reviewerIds = this.getReviewerIds();
                                                                                                      Object other$reviewerIds = other.getReviewerIds();
                                                                                                      if (this$reviewerIds == null
                                                                                                         ? other$reviewerIds == null
                                                                                                         : this$reviewerIds.equals(other$reviewerIds)) {
                                                                                                         Object this$detailList = this.getDetailList();
                                                                                                         Object other$detailList = other.getDetailList();
                                                                                                         if (this$detailList == null
                                                                                                            ? other$detailList == null
                                                                                                            : this$detailList.equals(other$detailList)) {
                                                                                                            Object this$inboundList = this.getInboundList();
                                                                                                            Object other$inboundList = other.getInboundList();
                                                                                                            if (this$inboundList == null
                                                                                                               ? other$inboundList == null
                                                                                                               : this$inboundList.equals(other$inboundList)) {
                                                                                                               Object this$updateTime = this.getUpdateTime();
                                                                                                               Object other$updateTime = other.getUpdateTime();
                                                                                                               if (this$updateTime == null
                                                                                                                  ? other$updateTime == null
                                                                                                                  : this$updateTime.equals(other$updateTime)) {
                                                                                                                  Object this$departmentName = this.getDepartmentName();
                                                                                                                  Object other$departmentName = other.getDepartmentName();
                                                                                                                  if (this$departmentName == null
                                                                                                                     ? other$departmentName == null
                                                                                                                     : this$departmentName.equals(
                                                                                                                        other$departmentName
                                                                                                                     )) {
                                                                                                                     Object this$projectName = this.getProjectName();
                                                                                                                     Object other$projectName = other.getProjectName();
                                                                                                                     if (this$projectName == null
                                                                                                                        ? other$projectName == null
                                                                                                                        : this$projectName.equals(
                                                                                                                           other$projectName
                                                                                                                        )) {
                                                                                                                        Object this$wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
                                                                                                                        Object other$wmsApproveRecordFlowDTOS = other.getWmsApproveRecordFlowDTOS();
                                                                                                                        if (this$wmsApproveRecordFlowDTOS
                                                                                                                              == null
                                                                                                                           ? other$wmsApproveRecordFlowDTOS
                                                                                                                              == null
                                                                                                                           : this$wmsApproveRecordFlowDTOS.equals(
                                                                                                                              other$wmsApproveRecordFlowDTOS
                                                                                                                           )) {
                                                                                                                           Object this$tsData = this.getTsData();
                                                                                                                           Object other$tsData = other.getTsData();
                                                                                                                           if (this$tsData == null
                                                                                                                              ? other$tsData == null
                                                                                                                              : this$tsData.equals(other$tsData)
                                                                                                                              )
                                                                                                                            {
                                                                                                                              Object this$approveRecordIds = this.getApproveRecordIds();
                                                                                                                              Object other$approveRecordIds = other.getApproveRecordIds();
                                                                                                                              if (this$approveRecordIds == null
                                                                                                                                 ? other$approveRecordIds
                                                                                                                                    == null
                                                                                                                                 : this$approveRecordIds.equals(
                                                                                                                                    other$approveRecordIds
                                                                                                                                 )) {
                                                                                                                                 Object this$serialNumberParent = this.getSerialNumberParent();
                                                                                                                                 Object other$serialNumberParent = other.getSerialNumberParent();
                                                                                                                                 if (this$serialNumberParent
                                                                                                                                       == null
                                                                                                                                    ? other$serialNumberParent
                                                                                                                                       == null
                                                                                                                                    : this$serialNumberParent.equals(
                                                                                                                                       other$serialNumberParent
                                                                                                                                    )) {
                                                                                                                                    Object this$branchCompany = this.getBranchCompany();
                                                                                                                                    Object other$branchCompany = other.getBranchCompany();
                                                                                                                                    if (this$branchCompany
                                                                                                                                          == null
                                                                                                                                       ? other$branchCompany
                                                                                                                                          == null
                                                                                                                                       : this$branchCompany.equals(
                                                                                                                                          other$branchCompany
                                                                                                                                       )) {
                                                                                                                                       Object this$attachments = this.getAttachments();
                                                                                                                                       Object other$attachments = other.getAttachments();
                                                                                                                                       if (this$attachments
                                                                                                                                             == null
                                                                                                                                          ? other$attachments
                                                                                                                                             == null
                                                                                                                                          : this$attachments.equals(
                                                                                                                                             other$attachments
                                                                                                                                          )) {
                                                                                                                                          Object this$havePurchasedMete = this.getHavePurchasedMete();
                                                                                                                                          Object other$havePurchasedMete = other.getHavePurchasedMete();
                                                                                                                                          if (this$havePurchasedMete
                                                                                                                                                == null
                                                                                                                                             ? other$havePurchasedMete
                                                                                                                                                == null
                                                                                                                                             : this$havePurchasedMete.equals(
                                                                                                                                                other$havePurchasedMete
                                                                                                                                             )) {
                                                                                                                                             Object this$unPurchaseMete = this.getUnPurchaseMete();
                                                                                                                                             Object other$unPurchaseMete = other.getUnPurchaseMete();
                                                                                                                                             if (this$unPurchaseMete
                                                                                                                                                   == null
                                                                                                                                                ? other$unPurchaseMete
                                                                                                                                                   == null
                                                                                                                                                : this$unPurchaseMete.equals(
                                                                                                                                                   other$unPurchaseMete
                                                                                                                                                )) {
                                                                                                                                                Object this$meteUnit = this.getMeteUnit();
                                                                                                                                                Object other$meteUnit = other.getMeteUnit();
                                                                                                                                                return this$meteUnit
                                                                                                                                                      == null
                                                                                                                                                   ? other$meteUnit
                                                                                                                                                      == null
                                                                                                                                                   : this$meteUnit.equals(
                                                                                                                                                      other$meteUnit
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ApplyPurchaseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $editorId = this.getEditorId();
      result = result * 59 + ($editorId == null ? 43 : $editorId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $approveProcessId = this.getApproveProcessId();
      result = result * 59 + ($approveProcessId == null ? 43 : $approveProcessId.hashCode());
      Object $finishedProductType = this.getFinishedProductType();
      result = result * 59 + ($finishedProductType == null ? 43 : $finishedProductType.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $purchaseCreationState = this.getPurchaseCreationState();
      result = result * 59 + ($purchaseCreationState == null ? 43 : $purchaseCreationState.hashCode());
      Object $boolInitiateApprove = this.getBoolInitiateApprove();
      result = result * 59 + ($boolInitiateApprove == null ? 43 : $boolInitiateApprove.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $boolTemporaryStorage = this.getBoolTemporaryStorage();
      result = result * 59 + ($boolTemporaryStorage == null ? 43 : $boolTemporaryStorage.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $delButtonType = this.getDelButtonType();
      result = result * 59 + ($delButtonType == null ? 43 : $delButtonType.hashCode());
      Object $boolUsed = this.getBoolUsed();
      result = result * 59 + ($boolUsed == null ? 43 : $boolUsed.hashCode());
      Object $branchAttributeEnum = this.getBranchAttributeEnum();
      result = result * 59 + ($branchAttributeEnum == null ? 43 : $branchAttributeEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $projectInfos = this.getProjectInfos();
      result = result * 59 + ($projectInfos == null ? 43 : $projectInfos.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $approveInfoName = this.getApproveInfoName();
      result = result * 59 + ($approveInfoName == null ? 43 : $approveInfoName.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewerIds = this.getReviewerIds();
      result = result * 59 + ($reviewerIds == null ? 43 : $reviewerIds.hashCode());
      Object $detailList = this.getDetailList();
      result = result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
      Object $inboundList = this.getInboundList();
      result = result * 59 + ($inboundList == null ? 43 : $inboundList.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
      result = result * 59 + ($wmsApproveRecordFlowDTOS == null ? 43 : $wmsApproveRecordFlowDTOS.hashCode());
      Object $tsData = this.getTsData();
      result = result * 59 + ($tsData == null ? 43 : $tsData.hashCode());
      Object $approveRecordIds = this.getApproveRecordIds();
      result = result * 59 + ($approveRecordIds == null ? 43 : $approveRecordIds.hashCode());
      Object $serialNumberParent = this.getSerialNumberParent();
      result = result * 59 + ($serialNumberParent == null ? 43 : $serialNumberParent.hashCode());
      Object $branchCompany = this.getBranchCompany();
      result = result * 59 + ($branchCompany == null ? 43 : $branchCompany.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $havePurchasedMete = this.getHavePurchasedMete();
      result = result * 59 + ($havePurchasedMete == null ? 43 : $havePurchasedMete.hashCode());
      Object $unPurchaseMete = this.getUnPurchaseMete();
      result = result * 59 + ($unPurchaseMete == null ? 43 : $unPurchaseMete.hashCode());
      Object $meteUnit = this.getMeteUnit();
      return result * 59 + ($meteUnit == null ? 43 : $meteUnit.hashCode());
   }

   @Override
   public String toString() {
      return "ApplyPurchaseDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", type="
         + this.getType()
         + ", materialType="
         + this.getMaterialType()
         + ", project="
         + this.getProject()
         + ", projectIds="
         + this.getProjectIds()
         + ", projectInfos="
         + this.getProjectInfos()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", editorId="
         + this.getEditorId()
         + ", editorName="
         + this.getEditorName()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", approveProcessId="
         + this.getApproveProcessId()
         + ", finishedProductType="
         + this.getFinishedProductType()
         + ", approveInfoName="
         + this.getApproveInfoName()
         + ", inboundMete="
         + this.getInboundMete()
         + ", totalMete="
         + this.getTotalMete()
         + ", enabled="
         + this.getEnabled()
         + ", reviewTime="
         + this.getReviewTime()
         + ", remark="
         + this.getRemark()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewerIds="
         + this.getReviewerIds()
         + ", purchaseCreationState="
         + this.getPurchaseCreationState()
         + ", boolInitiateApprove="
         + this.getBoolInitiateApprove()
         + ", detailList="
         + this.getDetailList()
         + ", inboundList="
         + this.getInboundList()
         + ", updateTime="
         + this.getUpdateTime()
         + ", departmentName="
         + this.getDepartmentName()
         + ", projectName="
         + this.getProjectName()
         + ", level="
         + this.getLevel()
         + ", wmsApproveRecordFlowDTOS="
         + this.getWmsApproveRecordFlowDTOS()
         + ", tsData="
         + this.getTsData()
         + ", boolTemporaryStorage="
         + this.getBoolTemporaryStorage()
         + ", editable="
         + this.getEditable()
         + ", approveRecordIdNow="
         + this.getApproveRecordIdNow()
         + ", approveRecordIds="
         + this.getApproveRecordIds()
         + ", dataStatus="
         + this.getDataStatus()
         + ", serialNumberParent="
         + this.getSerialNumberParent()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompany="
         + this.getBranchCompany()
         + ", delButtonType="
         + this.getDelButtonType()
         + ", attachments="
         + this.getAttachments()
         + ", boolUsed="
         + this.getBoolUsed()
         + ", havePurchasedMete="
         + this.getHavePurchasedMete()
         + ", unPurchaseMete="
         + this.getUnPurchaseMete()
         + ", meteUnit="
         + this.getMeteUnit()
         + ", branchAttributeEnum="
         + this.getBranchAttributeEnum()
         + ")";
   }

   public ApplyPurchaseDTO(
      final Long id,
      final String serialNumber,
      final Integer type,
      final Integer materialType,
      final ProjectInfo project,
      final String projectIds,
      final List<ProjectInfo> projectInfos,
      final Long applicantId,
      final String applicantName,
      final Long editorId,
      final String editorName,
      final Integer reviewStatus,
      final Long approveProcessId,
      final Integer finishedProductType,
      final String approveInfoName,
      final BigDecimal inboundMete,
      final BigDecimal totalMete,
      final Boolean enabled,
      final LocalDateTime reviewTime,
      final String remark,
      final LocalDateTime createTime,
      final String reviewerIds,
      final Integer purchaseCreationState,
      final Boolean boolInitiateApprove,
      final List<ApplyPurchaseDetailDTO> detailList,
      final List<ApplyPurchaseDetailDTO> inboundList,
      final LocalDateTime updateTime,
      final String departmentName,
      final String projectName,
      final Integer level,
      final List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS,
      final String tsData,
      final Boolean boolTemporaryStorage,
      final Boolean editable,
      final Long approveRecordIdNow,
      final String approveRecordIds,
      final Integer dataStatus,
      final String serialNumberParent,
      final Long branchCompanyId,
      final com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO branchCompany,
      final Integer delButtonType,
      final List<AttachmentDTO> attachments,
      final Boolean boolUsed,
      final BigDecimal havePurchasedMete,
      final BigDecimal unPurchaseMete,
      final String meteUnit,
      final Integer branchAttributeEnum
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.type = type;
      this.materialType = materialType;
      this.project = project;
      this.projectIds = projectIds;
      this.projectInfos = projectInfos;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.editorId = editorId;
      this.editorName = editorName;
      this.reviewStatus = reviewStatus;
      this.approveProcessId = approveProcessId;
      this.finishedProductType = finishedProductType;
      this.approveInfoName = approveInfoName;
      this.inboundMete = inboundMete;
      this.totalMete = totalMete;
      this.enabled = enabled;
      this.reviewTime = reviewTime;
      this.remark = remark;
      this.createTime = createTime;
      this.reviewerIds = reviewerIds;
      this.purchaseCreationState = purchaseCreationState;
      this.boolInitiateApprove = boolInitiateApprove;
      this.detailList = detailList;
      this.inboundList = inboundList;
      this.updateTime = updateTime;
      this.departmentName = departmentName;
      this.projectName = projectName;
      this.level = level;
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
      this.tsData = tsData;
      this.boolTemporaryStorage = boolTemporaryStorage;
      this.editable = editable;
      this.approveRecordIdNow = approveRecordIdNow;
      this.approveRecordIds = approveRecordIds;
      this.dataStatus = dataStatus;
      this.serialNumberParent = serialNumberParent;
      this.branchCompanyId = branchCompanyId;
      this.branchCompany = branchCompany;
      this.delButtonType = delButtonType;
      this.attachments = attachments;
      this.boolUsed = boolUsed;
      this.havePurchasedMete = havePurchasedMete;
      this.unPurchaseMete = unPurchaseMete;
      this.meteUnit = meteUnit;
      this.branchAttributeEnum = branchAttributeEnum;
   }

   public ApplyPurchaseDTO() {
   }

   public static class ApplyPurchaseDTOBuilder {
      private Long id;
      private String serialNumber;
      private Integer type;
      private Integer materialType;
      private ProjectInfo project;
      private String projectIds;
      private List<ProjectInfo> projectInfos;
      private Long applicantId;
      private String applicantName;
      private Long editorId;
      private String editorName;
      private Integer reviewStatus;
      private Long approveProcessId;
      private Integer finishedProductType;
      private String approveInfoName;
      private BigDecimal inboundMete;
      private BigDecimal totalMete;
      private Boolean enabled;
      private LocalDateTime reviewTime;
      private String remark;
      private LocalDateTime createTime;
      private String reviewerIds;
      private Integer purchaseCreationState;
      private Boolean boolInitiateApprove;
      private List<ApplyPurchaseDetailDTO> detailList;
      private List<ApplyPurchaseDetailDTO> inboundList;
      private LocalDateTime updateTime;
      private String departmentName;
      private String projectName;
      private Integer level;
      private List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS;
      private String tsData;
      private Boolean boolTemporaryStorage;
      private Boolean editable;
      private Long approveRecordIdNow;
      private String approveRecordIds;
      private Integer dataStatus;
      private String serialNumberParent;
      private Long branchCompanyId;
      private com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO branchCompany;
      private Integer delButtonType;
      private List<AttachmentDTO> attachments;
      private Boolean boolUsed;
      private BigDecimal havePurchasedMete;
      private BigDecimal unPurchaseMete;
      private String meteUnit;
      private Integer branchAttributeEnum;

      ApplyPurchaseDTOBuilder() {
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder projectInfos(final List<ProjectInfo> projectInfos) {
         this.projectInfos = projectInfos;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder editorId(final Long editorId) {
         this.editorId = editorId;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder approveProcessId(final Long approveProcessId) {
         this.approveProcessId = approveProcessId;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder finishedProductType(final Integer finishedProductType) {
         this.finishedProductType = finishedProductType;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder approveInfoName(final String approveInfoName) {
         this.approveInfoName = approveInfoName;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder enabled(final Boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder reviewerIds(final String reviewerIds) {
         this.reviewerIds = reviewerIds;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder purchaseCreationState(final Integer purchaseCreationState) {
         this.purchaseCreationState = purchaseCreationState;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder boolInitiateApprove(final Boolean boolInitiateApprove) {
         this.boolInitiateApprove = boolInitiateApprove;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder detailList(final List<ApplyPurchaseDetailDTO> detailList) {
         this.detailList = detailList;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder inboundList(final List<ApplyPurchaseDetailDTO> inboundList) {
         this.inboundList = inboundList;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder wmsApproveRecordFlowDTOS(final List<WmsApproveRecordFlowDTO> wmsApproveRecordFlowDTOS) {
         this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder tsData(final String tsData) {
         this.tsData = tsData;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder boolTemporaryStorage(final Boolean boolTemporaryStorage) {
         this.boolTemporaryStorage = boolTemporaryStorage;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder approveRecordIdNow(final Long approveRecordIdNow) {
         this.approveRecordIdNow = approveRecordIdNow;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder approveRecordIds(final String approveRecordIds) {
         this.approveRecordIds = approveRecordIds;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder dataStatus(final Integer dataStatus) {
         this.dataStatus = dataStatus;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder serialNumberParent(final String serialNumberParent) {
         this.serialNumberParent = serialNumberParent;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder branchCompany(final com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO branchCompany) {
         this.branchCompany = branchCompany;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder delButtonType(final Integer delButtonType) {
         this.delButtonType = delButtonType;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder boolUsed(final Boolean boolUsed) {
         this.boolUsed = boolUsed;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder havePurchasedMete(final BigDecimal havePurchasedMete) {
         this.havePurchasedMete = havePurchasedMete;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder unPurchaseMete(final BigDecimal unPurchaseMete) {
         this.unPurchaseMete = unPurchaseMete;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder meteUnit(final String meteUnit) {
         this.meteUnit = meteUnit;
         return this;
      }

      public ApplyPurchaseDTO.ApplyPurchaseDTOBuilder branchAttributeEnum(final Integer branchAttributeEnum) {
         this.branchAttributeEnum = branchAttributeEnum;
         return this;
      }

      public ApplyPurchaseDTO build() {
         return new ApplyPurchaseDTO(
            this.id,
            this.serialNumber,
            this.type,
            this.materialType,
            this.project,
            this.projectIds,
            this.projectInfos,
            this.applicantId,
            this.applicantName,
            this.editorId,
            this.editorName,
            this.reviewStatus,
            this.approveProcessId,
            this.finishedProductType,
            this.approveInfoName,
            this.inboundMete,
            this.totalMete,
            this.enabled,
            this.reviewTime,
            this.remark,
            this.createTime,
            this.reviewerIds,
            this.purchaseCreationState,
            this.boolInitiateApprove,
            this.detailList,
            this.inboundList,
            this.updateTime,
            this.departmentName,
            this.projectName,
            this.level,
            this.wmsApproveRecordFlowDTOS,
            this.tsData,
            this.boolTemporaryStorage,
            this.editable,
            this.approveRecordIdNow,
            this.approveRecordIds,
            this.dataStatus,
            this.serialNumberParent,
            this.branchCompanyId,
            this.branchCompany,
            this.delButtonType,
            this.attachments,
            this.boolUsed,
            this.havePurchasedMete,
            this.unPurchaseMete,
            this.meteUnit,
            this.branchAttributeEnum
         );
      }

      @Override
      public String toString() {
         return "ApplyPurchaseDTO.ApplyPurchaseDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", type="
            + this.type
            + ", materialType="
            + this.materialType
            + ", project="
            + this.project
            + ", projectIds="
            + this.projectIds
            + ", projectInfos="
            + this.projectInfos
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", editorId="
            + this.editorId
            + ", editorName="
            + this.editorName
            + ", reviewStatus="
            + this.reviewStatus
            + ", approveProcessId="
            + this.approveProcessId
            + ", finishedProductType="
            + this.finishedProductType
            + ", approveInfoName="
            + this.approveInfoName
            + ", inboundMete="
            + this.inboundMete
            + ", totalMete="
            + this.totalMete
            + ", enabled="
            + this.enabled
            + ", reviewTime="
            + this.reviewTime
            + ", remark="
            + this.remark
            + ", createTime="
            + this.createTime
            + ", reviewerIds="
            + this.reviewerIds
            + ", purchaseCreationState="
            + this.purchaseCreationState
            + ", boolInitiateApprove="
            + this.boolInitiateApprove
            + ", detailList="
            + this.detailList
            + ", inboundList="
            + this.inboundList
            + ", updateTime="
            + this.updateTime
            + ", departmentName="
            + this.departmentName
            + ", projectName="
            + this.projectName
            + ", level="
            + this.level
            + ", wmsApproveRecordFlowDTOS="
            + this.wmsApproveRecordFlowDTOS
            + ", tsData="
            + this.tsData
            + ", boolTemporaryStorage="
            + this.boolTemporaryStorage
            + ", editable="
            + this.editable
            + ", approveRecordIdNow="
            + this.approveRecordIdNow
            + ", approveRecordIds="
            + this.approveRecordIds
            + ", dataStatus="
            + this.dataStatus
            + ", serialNumberParent="
            + this.serialNumberParent
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompany="
            + this.branchCompany
            + ", delButtonType="
            + this.delButtonType
            + ", attachments="
            + this.attachments
            + ", boolUsed="
            + this.boolUsed
            + ", havePurchasedMete="
            + this.havePurchasedMete
            + ", unPurchaseMete="
            + this.unPurchaseMete
            + ", meteUnit="
            + this.meteUnit
            + ", branchAttributeEnum="
            + this.branchAttributeEnum
            + ")";
      }
   }
}
