package com.hzchum.scim.plan.core.api.pojo.vo;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(description = "CAPP 工艺库详情 响应参数")
public class CappCraftCardStorehouseDetailVO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "工艺编号", notes = "工艺编号")
   private String serialNumber;
   @ApiModelProperty(name = "craftType", value = "工艺类型参考枚举 CappCraftTypeEnum", notes = "工艺类型参考枚举 CappCraftTypeEnum")
   private Integer craftType;
   @ApiModelProperty(name = "processAttributes", value = "工艺属性参考枚举 CAPPProcessAttributesEnum", notes = "工艺属性参考枚举 CAPPProcessAttributesEnum")
   private Integer processAttributes;
   @ApiModelProperty(name = "projectId", value = "工程项目(关联工艺属性，如工艺属性为项目专属，则必填)", notes = "工程项目(关联工艺属性，如工艺属性为项目专属，则必填)")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "工程项目名称", notes = "工程项目名称")
   private String projectName;
   @ApiModelProperty(name = "weldingBaseJointType", value = "接头形式", notes = "接头形式")
   private String weldingBaseJointType;
   @ApiModelProperty(name = "weldingBaseParentMaterialSteelGrade", value = "母材钢号", notes = "母材钢号")
   private String weldingBaseParentMaterialSteelGrade;
   @ApiModelProperty(name = "weldingBasePlateThicknessOrPipeDiameter", value = "板厚或管径X壁厚", notes = "板厚或管径X壁厚")
   private String weldingBasePlateThicknessOrPipeDiameter;
   @ApiModelProperty(name = "weldingBaseHotRollingOrHeatTreatmentStatus", value = "轧制或热处理状态", notes = "轧制或热处理状态")
   private String weldingBaseHotRollingOrHeatTreatmentStatus;
   @ApiModelProperty(name = "processId", value = "关联工序", notes = "关联工序")
   private Long processId;
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   private String processName;
   @ApiModelProperty(name = "weldingBaseWeldingMethod", value = "焊接方法", notes = "焊接方法")
   private String weldingBaseWeldingMethod;
   @ApiModelProperty(name = "weldingBaseWeldingPosition", value = "焊接位置", notes = "焊接位置")
   private String weldingBaseWeldingPosition;
   @ApiModelProperty(name = "weldingBaseWeldingDeviceType", value = "焊接设备型号", notes = "焊接设备型号")
   private String weldingBaseWeldingDeviceType;
   @ApiModelProperty(name = "weldingBasePowerSupplyAndPolarity", value = "电源及极性", notes = "电源及极性")
   private String weldingBasePowerSupplyAndPolarity;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "operatorUserId", value = "编制人id", notes = "编制人id")
   private Long operatorUserId;
   @ApiModelProperty(name = "operatorUserName", value = "编制人名称", notes = "编制人名称")
   private String operatorUserName;
   @ApiModelProperty(name = "operatorDateTime", value = "编制日期", notes = "编制日期")
   private LocalDateTime operatorDateTime;
   @ApiModelProperty(name = "auditorUserId", value = "审核人id", notes = "审核人id")
   private Long auditorUserId;
   @ApiModelProperty(name = "auditorUserName", value = "审核人名称", notes = "审核人名称")
   private String auditorUserName;
   @ApiModelProperty(name = "auditDateTime", value = "审核日期", notes = "审核日期")
   private LocalDateTime auditDateTime;
   @ApiModelProperty(name = "jointSchematicDiagramAttachmentId", value = "接头示意图附件id", notes = "接头示意图附件id")
   private Long jointSchematicDiagramAttachmentId;
   @ApiModelProperty(name = "jointSchematicDiagramAttachmentDTO", value = "接头示意图附件信息", notes = "接头示意图附件信息")
   private AttachmentDTO jointSchematicDiagramAttachmentDTO;
   @ApiModelProperty(name = "weldingSchematicDiagramAttachmentId", value = "焊接顺序示意图附件id", notes = "焊接顺序示意图附件id")
   private Long weldingSchematicDiagramAttachmentId;
   @ApiModelProperty(name = "weldingSchematicDiagramAttachmentDTO", value = "焊接顺序示意图附件信息", notes = "焊接顺序示意图附件信息")
   private AttachmentDTO weldingSchematicDiagramAttachmentDTO;
   @ApiModelProperty(name = "weldingTechnicalMeasurePreWeldCleaning", value = "焊前清理", notes = "焊前清理")
   private String weldingTechnicalMeasurePreWeldCleaning;
   @ApiModelProperty(name = "weldingTechnicalMeasureRoadCleaning", value = "道间清理", notes = "道间清理")
   private String weldingTechnicalMeasureRoadCleaning;
   @ApiModelProperty(name = "weldingTechnicalMeasureBackCleaning", value = "背面清理", notes = "背面清理")
   private String weldingTechnicalMeasureBackCleaning;
   @ApiModelProperty(name = "weldingTechnicalMeasureOther", value = "其他清理措施", notes = "其他清理措施")
   private String weldingTechnicalMeasureOther;
   @ApiModelProperty(name = "processStatus", value = "工艺状态 1正常状态 2草稿状态 参考枚举CAPPProcessStatusEnum", notes = "工艺状态 1正常状态 2草稿状态 参考枚举CAPPProcessStatusEnum")
   private Integer processStatus;
   @ApiModelProperty(name = "enabledFlag", value = "是否启用：0 未启用；1 启用", notes = "是否启用：0 未启用；1 启用")
   private Boolean enabledFlag;
   @ApiModelProperty(name = "versionNumber", value = "字母版本号A~Z(暂不考虑超出如何处理)", notes = "字母版本号A~Z(暂不考虑超出如何处理)")
   private String versionNumber;
   @ApiModelProperty(name = "cappCraftCardStorehouseCraftParameterPassLinkDetailVOList", value = "工艺参数关联信息", notes = "工艺参数关联信息")
   private List<CappCraftCardStorehouseCraftParameterPassLinkDetailVO> cappCraftCardStorehouseCraftParameterPassLinkDetailVOList;
   @ApiModelProperty(name = "cappCraftCardStorehouseMaterialsLinkDetailVOList", value = "焊接材料关联信息", notes = "焊接材料关联信息")
   private List<CappCraftCardStorehouseMaterialsLinkDetailVO> cappCraftCardStorehouseMaterialsLinkDetailVOList;
   @ApiModelProperty(name = "cappCraftCardStorehouseTemperatureLinkDetailVOList", value = "温度关联信息", notes = "温度关联信息")
   private List<CappCraftCardStorehouseTemperatureLinkDetailVO> cappCraftCardStorehouseTemperatureLinkDetailVOList;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getCraftType() {
      return this.craftType;
   }

   public Integer getProcessAttributes() {
      return this.processAttributes;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getWeldingBaseJointType() {
      return this.weldingBaseJointType;
   }

   public String getWeldingBaseParentMaterialSteelGrade() {
      return this.weldingBaseParentMaterialSteelGrade;
   }

   public String getWeldingBasePlateThicknessOrPipeDiameter() {
      return this.weldingBasePlateThicknessOrPipeDiameter;
   }

   public String getWeldingBaseHotRollingOrHeatTreatmentStatus() {
      return this.weldingBaseHotRollingOrHeatTreatmentStatus;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getWeldingBaseWeldingMethod() {
      return this.weldingBaseWeldingMethod;
   }

   public String getWeldingBaseWeldingPosition() {
      return this.weldingBaseWeldingPosition;
   }

   public String getWeldingBaseWeldingDeviceType() {
      return this.weldingBaseWeldingDeviceType;
   }

   public String getWeldingBasePowerSupplyAndPolarity() {
      return this.weldingBasePowerSupplyAndPolarity;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getOperatorUserId() {
      return this.operatorUserId;
   }

   public String getOperatorUserName() {
      return this.operatorUserName;
   }

   public LocalDateTime getOperatorDateTime() {
      return this.operatorDateTime;
   }

   public Long getAuditorUserId() {
      return this.auditorUserId;
   }

   public String getAuditorUserName() {
      return this.auditorUserName;
   }

   public LocalDateTime getAuditDateTime() {
      return this.auditDateTime;
   }

   public Long getJointSchematicDiagramAttachmentId() {
      return this.jointSchematicDiagramAttachmentId;
   }

   public AttachmentDTO getJointSchematicDiagramAttachmentDTO() {
      return this.jointSchematicDiagramAttachmentDTO;
   }

   public Long getWeldingSchematicDiagramAttachmentId() {
      return this.weldingSchematicDiagramAttachmentId;
   }

   public AttachmentDTO getWeldingSchematicDiagramAttachmentDTO() {
      return this.weldingSchematicDiagramAttachmentDTO;
   }

   public String getWeldingTechnicalMeasurePreWeldCleaning() {
      return this.weldingTechnicalMeasurePreWeldCleaning;
   }

   public String getWeldingTechnicalMeasureRoadCleaning() {
      return this.weldingTechnicalMeasureRoadCleaning;
   }

   public String getWeldingTechnicalMeasureBackCleaning() {
      return this.weldingTechnicalMeasureBackCleaning;
   }

   public String getWeldingTechnicalMeasureOther() {
      return this.weldingTechnicalMeasureOther;
   }

   public Integer getProcessStatus() {
      return this.processStatus;
   }

   public Boolean getEnabledFlag() {
      return this.enabledFlag;
   }

   public String getVersionNumber() {
      return this.versionNumber;
   }

   public List<CappCraftCardStorehouseCraftParameterPassLinkDetailVO> getCappCraftCardStorehouseCraftParameterPassLinkDetailVOList() {
      return this.cappCraftCardStorehouseCraftParameterPassLinkDetailVOList;
   }

   public List<CappCraftCardStorehouseMaterialsLinkDetailVO> getCappCraftCardStorehouseMaterialsLinkDetailVOList() {
      return this.cappCraftCardStorehouseMaterialsLinkDetailVOList;
   }

   public List<CappCraftCardStorehouseTemperatureLinkDetailVO> getCappCraftCardStorehouseTemperatureLinkDetailVOList() {
      return this.cappCraftCardStorehouseTemperatureLinkDetailVOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setCraftType(final Integer craftType) {
      this.craftType = craftType;
   }

   public void setProcessAttributes(final Integer processAttributes) {
      this.processAttributes = processAttributes;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setWeldingBaseJointType(final String weldingBaseJointType) {
      this.weldingBaseJointType = weldingBaseJointType;
   }

   public void setWeldingBaseParentMaterialSteelGrade(final String weldingBaseParentMaterialSteelGrade) {
      this.weldingBaseParentMaterialSteelGrade = weldingBaseParentMaterialSteelGrade;
   }

   public void setWeldingBasePlateThicknessOrPipeDiameter(final String weldingBasePlateThicknessOrPipeDiameter) {
      this.weldingBasePlateThicknessOrPipeDiameter = weldingBasePlateThicknessOrPipeDiameter;
   }

   public void setWeldingBaseHotRollingOrHeatTreatmentStatus(final String weldingBaseHotRollingOrHeatTreatmentStatus) {
      this.weldingBaseHotRollingOrHeatTreatmentStatus = weldingBaseHotRollingOrHeatTreatmentStatus;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setWeldingBaseWeldingMethod(final String weldingBaseWeldingMethod) {
      this.weldingBaseWeldingMethod = weldingBaseWeldingMethod;
   }

   public void setWeldingBaseWeldingPosition(final String weldingBaseWeldingPosition) {
      this.weldingBaseWeldingPosition = weldingBaseWeldingPosition;
   }

   public void setWeldingBaseWeldingDeviceType(final String weldingBaseWeldingDeviceType) {
      this.weldingBaseWeldingDeviceType = weldingBaseWeldingDeviceType;
   }

   public void setWeldingBasePowerSupplyAndPolarity(final String weldingBasePowerSupplyAndPolarity) {
      this.weldingBasePowerSupplyAndPolarity = weldingBasePowerSupplyAndPolarity;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setOperatorUserId(final Long operatorUserId) {
      this.operatorUserId = operatorUserId;
   }

   public void setOperatorUserName(final String operatorUserName) {
      this.operatorUserName = operatorUserName;
   }

   public void setOperatorDateTime(final LocalDateTime operatorDateTime) {
      this.operatorDateTime = operatorDateTime;
   }

   public void setAuditorUserId(final Long auditorUserId) {
      this.auditorUserId = auditorUserId;
   }

   public void setAuditorUserName(final String auditorUserName) {
      this.auditorUserName = auditorUserName;
   }

   public void setAuditDateTime(final LocalDateTime auditDateTime) {
      this.auditDateTime = auditDateTime;
   }

   public void setJointSchematicDiagramAttachmentId(final Long jointSchematicDiagramAttachmentId) {
      this.jointSchematicDiagramAttachmentId = jointSchematicDiagramAttachmentId;
   }

   public void setJointSchematicDiagramAttachmentDTO(final AttachmentDTO jointSchematicDiagramAttachmentDTO) {
      this.jointSchematicDiagramAttachmentDTO = jointSchematicDiagramAttachmentDTO;
   }

   public void setWeldingSchematicDiagramAttachmentId(final Long weldingSchematicDiagramAttachmentId) {
      this.weldingSchematicDiagramAttachmentId = weldingSchematicDiagramAttachmentId;
   }

   public void setWeldingSchematicDiagramAttachmentDTO(final AttachmentDTO weldingSchematicDiagramAttachmentDTO) {
      this.weldingSchematicDiagramAttachmentDTO = weldingSchematicDiagramAttachmentDTO;
   }

   public void setWeldingTechnicalMeasurePreWeldCleaning(final String weldingTechnicalMeasurePreWeldCleaning) {
      this.weldingTechnicalMeasurePreWeldCleaning = weldingTechnicalMeasurePreWeldCleaning;
   }

   public void setWeldingTechnicalMeasureRoadCleaning(final String weldingTechnicalMeasureRoadCleaning) {
      this.weldingTechnicalMeasureRoadCleaning = weldingTechnicalMeasureRoadCleaning;
   }

   public void setWeldingTechnicalMeasureBackCleaning(final String weldingTechnicalMeasureBackCleaning) {
      this.weldingTechnicalMeasureBackCleaning = weldingTechnicalMeasureBackCleaning;
   }

   public void setWeldingTechnicalMeasureOther(final String weldingTechnicalMeasureOther) {
      this.weldingTechnicalMeasureOther = weldingTechnicalMeasureOther;
   }

   public void setProcessStatus(final Integer processStatus) {
      this.processStatus = processStatus;
   }

   public void setEnabledFlag(final Boolean enabledFlag) {
      this.enabledFlag = enabledFlag;
   }

   public void setVersionNumber(final String versionNumber) {
      this.versionNumber = versionNumber;
   }

   public void setCappCraftCardStorehouseCraftParameterPassLinkDetailVOList(
      final List<CappCraftCardStorehouseCraftParameterPassLinkDetailVO> cappCraftCardStorehouseCraftParameterPassLinkDetailVOList
   ) {
      this.cappCraftCardStorehouseCraftParameterPassLinkDetailVOList = cappCraftCardStorehouseCraftParameterPassLinkDetailVOList;
   }

   public void setCappCraftCardStorehouseMaterialsLinkDetailVOList(
      final List<CappCraftCardStorehouseMaterialsLinkDetailVO> cappCraftCardStorehouseMaterialsLinkDetailVOList
   ) {
      this.cappCraftCardStorehouseMaterialsLinkDetailVOList = cappCraftCardStorehouseMaterialsLinkDetailVOList;
   }

   public void setCappCraftCardStorehouseTemperatureLinkDetailVOList(
      final List<CappCraftCardStorehouseTemperatureLinkDetailVO> cappCraftCardStorehouseTemperatureLinkDetailVOList
   ) {
      this.cappCraftCardStorehouseTemperatureLinkDetailVOList = cappCraftCardStorehouseTemperatureLinkDetailVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardStorehouseDetailVO)) {
         return false;
      }

      CappCraftCardStorehouseDetailVO other = (CappCraftCardStorehouseDetailVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$craftType = this.getCraftType();
         Object other$craftType = other.getCraftType();
         if (this$craftType == null ? other$craftType == null : this$craftType.equals(other$craftType)) {
            Object this$processAttributes = this.getProcessAttributes();
            Object other$processAttributes = other.getProcessAttributes();
            if (this$processAttributes == null ? other$processAttributes == null : this$processAttributes.equals(other$processAttributes)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$createUserId = this.getCreateUserId();
                     Object other$createUserId = other.getCreateUserId();
                     if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                        Object this$operatorUserId = this.getOperatorUserId();
                        Object other$operatorUserId = other.getOperatorUserId();
                        if (this$operatorUserId == null ? other$operatorUserId == null : this$operatorUserId.equals(other$operatorUserId)) {
                           Object this$auditorUserId = this.getAuditorUserId();
                           Object other$auditorUserId = other.getAuditorUserId();
                           if (this$auditorUserId == null ? other$auditorUserId == null : this$auditorUserId.equals(other$auditorUserId)) {
                              Object this$jointSchematicDiagramAttachmentId = this.getJointSchematicDiagramAttachmentId();
                              Object other$jointSchematicDiagramAttachmentId = other.getJointSchematicDiagramAttachmentId();
                              if (this$jointSchematicDiagramAttachmentId == null
                                 ? other$jointSchematicDiagramAttachmentId == null
                                 : this$jointSchematicDiagramAttachmentId.equals(other$jointSchematicDiagramAttachmentId)) {
                                 Object this$weldingSchematicDiagramAttachmentId = this.getWeldingSchematicDiagramAttachmentId();
                                 Object other$weldingSchematicDiagramAttachmentId = other.getWeldingSchematicDiagramAttachmentId();
                                 if (this$weldingSchematicDiagramAttachmentId == null
                                    ? other$weldingSchematicDiagramAttachmentId == null
                                    : this$weldingSchematicDiagramAttachmentId.equals(other$weldingSchematicDiagramAttachmentId)) {
                                    Object this$processStatus = this.getProcessStatus();
                                    Object other$processStatus = other.getProcessStatus();
                                    if (this$processStatus == null ? other$processStatus == null : this$processStatus.equals(other$processStatus)) {
                                       Object this$enabledFlag = this.getEnabledFlag();
                                       Object other$enabledFlag = other.getEnabledFlag();
                                       if (this$enabledFlag == null ? other$enabledFlag == null : this$enabledFlag.equals(other$enabledFlag)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$projectName = this.getProjectName();
                                             Object other$projectName = other.getProjectName();
                                             if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                Object this$weldingBaseJointType = this.getWeldingBaseJointType();
                                                Object other$weldingBaseJointType = other.getWeldingBaseJointType();
                                                if (this$weldingBaseJointType == null
                                                   ? other$weldingBaseJointType == null
                                                   : this$weldingBaseJointType.equals(other$weldingBaseJointType)) {
                                                   Object this$weldingBaseParentMaterialSteelGrade = this.getWeldingBaseParentMaterialSteelGrade();
                                                   Object other$weldingBaseParentMaterialSteelGrade = other.getWeldingBaseParentMaterialSteelGrade();
                                                   if (this$weldingBaseParentMaterialSteelGrade == null
                                                      ? other$weldingBaseParentMaterialSteelGrade == null
                                                      : this$weldingBaseParentMaterialSteelGrade.equals(other$weldingBaseParentMaterialSteelGrade)) {
                                                      Object this$weldingBasePlateThicknessOrPipeDiameter = this.getWeldingBasePlateThicknessOrPipeDiameter();
                                                      Object other$weldingBasePlateThicknessOrPipeDiameter = other.getWeldingBasePlateThicknessOrPipeDiameter();
                                                      if (this$weldingBasePlateThicknessOrPipeDiameter == null
                                                         ? other$weldingBasePlateThicknessOrPipeDiameter == null
                                                         : this$weldingBasePlateThicknessOrPipeDiameter.equals(other$weldingBasePlateThicknessOrPipeDiameter)) {
                                                         Object this$weldingBaseHotRollingOrHeatTreatmentStatus = this.getWeldingBaseHotRollingOrHeatTreatmentStatus();
                                                         Object other$weldingBaseHotRollingOrHeatTreatmentStatus = other.getWeldingBaseHotRollingOrHeatTreatmentStatus();
                                                         if (this$weldingBaseHotRollingOrHeatTreatmentStatus == null
                                                            ? other$weldingBaseHotRollingOrHeatTreatmentStatus == null
                                                            : this$weldingBaseHotRollingOrHeatTreatmentStatus.equals(
                                                               other$weldingBaseHotRollingOrHeatTreatmentStatus
                                                            )) {
                                                            Object this$processName = this.getProcessName();
                                                            Object other$processName = other.getProcessName();
                                                            if (this$processName == null
                                                               ? other$processName == null
                                                               : this$processName.equals(other$processName)) {
                                                               Object this$weldingBaseWeldingMethod = this.getWeldingBaseWeldingMethod();
                                                               Object other$weldingBaseWeldingMethod = other.getWeldingBaseWeldingMethod();
                                                               if (this$weldingBaseWeldingMethod == null
                                                                  ? other$weldingBaseWeldingMethod == null
                                                                  : this$weldingBaseWeldingMethod.equals(other$weldingBaseWeldingMethod)) {
                                                                  Object this$weldingBaseWeldingPosition = this.getWeldingBaseWeldingPosition();
                                                                  Object other$weldingBaseWeldingPosition = other.getWeldingBaseWeldingPosition();
                                                                  if (this$weldingBaseWeldingPosition == null
                                                                     ? other$weldingBaseWeldingPosition == null
                                                                     : this$weldingBaseWeldingPosition.equals(other$weldingBaseWeldingPosition)) {
                                                                     Object this$weldingBaseWeldingDeviceType = this.getWeldingBaseWeldingDeviceType();
                                                                     Object other$weldingBaseWeldingDeviceType = other.getWeldingBaseWeldingDeviceType();
                                                                     if (this$weldingBaseWeldingDeviceType == null
                                                                        ? other$weldingBaseWeldingDeviceType == null
                                                                        : this$weldingBaseWeldingDeviceType.equals(other$weldingBaseWeldingDeviceType)) {
                                                                        Object this$weldingBasePowerSupplyAndPolarity = this.getWeldingBasePowerSupplyAndPolarity();
                                                                        Object other$weldingBasePowerSupplyAndPolarity = other.getWeldingBasePowerSupplyAndPolarity();
                                                                        if (this$weldingBasePowerSupplyAndPolarity == null
                                                                           ? other$weldingBasePowerSupplyAndPolarity == null
                                                                           : this$weldingBasePowerSupplyAndPolarity.equals(
                                                                              other$weldingBasePowerSupplyAndPolarity
                                                                           )) {
                                                                           Object this$createUserName = this.getCreateUserName();
                                                                           Object other$createUserName = other.getCreateUserName();
                                                                           if (this$createUserName == null
                                                                              ? other$createUserName == null
                                                                              : this$createUserName.equals(other$createUserName)) {
                                                                              Object this$operatorUserName = this.getOperatorUserName();
                                                                              Object other$operatorUserName = other.getOperatorUserName();
                                                                              if (this$operatorUserName == null
                                                                                 ? other$operatorUserName == null
                                                                                 : this$operatorUserName.equals(other$operatorUserName)) {
                                                                                 Object this$operatorDateTime = this.getOperatorDateTime();
                                                                                 Object other$operatorDateTime = other.getOperatorDateTime();
                                                                                 if (this$operatorDateTime == null
                                                                                    ? other$operatorDateTime == null
                                                                                    : this$operatorDateTime.equals(other$operatorDateTime)) {
                                                                                    Object this$auditorUserName = this.getAuditorUserName();
                                                                                    Object other$auditorUserName = other.getAuditorUserName();
                                                                                    if (this$auditorUserName == null
                                                                                       ? other$auditorUserName == null
                                                                                       : this$auditorUserName.equals(other$auditorUserName)) {
                                                                                       Object this$auditDateTime = this.getAuditDateTime();
                                                                                       Object other$auditDateTime = other.getAuditDateTime();
                                                                                       if (this$auditDateTime == null
                                                                                          ? other$auditDateTime == null
                                                                                          : this$auditDateTime.equals(other$auditDateTime)) {
                                                                                          Object this$jointSchematicDiagramAttachmentDTO = this.getJointSchematicDiagramAttachmentDTO();
                                                                                          Object other$jointSchematicDiagramAttachmentDTO = other.getJointSchematicDiagramAttachmentDTO();
                                                                                          if (this$jointSchematicDiagramAttachmentDTO == null
                                                                                             ? other$jointSchematicDiagramAttachmentDTO == null
                                                                                             : this$jointSchematicDiagramAttachmentDTO.equals(
                                                                                                other$jointSchematicDiagramAttachmentDTO
                                                                                             )) {
                                                                                             Object this$weldingSchematicDiagramAttachmentDTO = this.getWeldingSchematicDiagramAttachmentDTO();
                                                                                             Object other$weldingSchematicDiagramAttachmentDTO = other.getWeldingSchematicDiagramAttachmentDTO();
                                                                                             if (this$weldingSchematicDiagramAttachmentDTO == null
                                                                                                ? other$weldingSchematicDiagramAttachmentDTO == null
                                                                                                : this$weldingSchematicDiagramAttachmentDTO.equals(
                                                                                                   other$weldingSchematicDiagramAttachmentDTO
                                                                                                )) {
                                                                                                Object this$weldingTechnicalMeasurePreWeldCleaning = this.getWeldingTechnicalMeasurePreWeldCleaning();
                                                                                                Object other$weldingTechnicalMeasurePreWeldCleaning = other.getWeldingTechnicalMeasurePreWeldCleaning();
                                                                                                if (this$weldingTechnicalMeasurePreWeldCleaning == null
                                                                                                   ? other$weldingTechnicalMeasurePreWeldCleaning == null
                                                                                                   : this$weldingTechnicalMeasurePreWeldCleaning.equals(
                                                                                                      other$weldingTechnicalMeasurePreWeldCleaning
                                                                                                   )) {
                                                                                                   Object this$weldingTechnicalMeasureRoadCleaning = this.getWeldingTechnicalMeasureRoadCleaning();
                                                                                                   Object other$weldingTechnicalMeasureRoadCleaning = other.getWeldingTechnicalMeasureRoadCleaning();
                                                                                                   if (this$weldingTechnicalMeasureRoadCleaning == null
                                                                                                      ? other$weldingTechnicalMeasureRoadCleaning == null
                                                                                                      : this$weldingTechnicalMeasureRoadCleaning.equals(
                                                                                                         other$weldingTechnicalMeasureRoadCleaning
                                                                                                      )) {
                                                                                                      Object this$weldingTechnicalMeasureBackCleaning = this.getWeldingTechnicalMeasureBackCleaning();
                                                                                                      Object other$weldingTechnicalMeasureBackCleaning = other.getWeldingTechnicalMeasureBackCleaning();
                                                                                                      if (this$weldingTechnicalMeasureBackCleaning == null
                                                                                                         ? other$weldingTechnicalMeasureBackCleaning == null
                                                                                                         : this$weldingTechnicalMeasureBackCleaning.equals(
                                                                                                            other$weldingTechnicalMeasureBackCleaning
                                                                                                         )) {
                                                                                                         Object this$weldingTechnicalMeasureOther = this.getWeldingTechnicalMeasureOther();
                                                                                                         Object other$weldingTechnicalMeasureOther = other.getWeldingTechnicalMeasureOther();
                                                                                                         if (this$weldingTechnicalMeasureOther == null
                                                                                                            ? other$weldingTechnicalMeasureOther == null
                                                                                                            : this$weldingTechnicalMeasureOther.equals(
                                                                                                               other$weldingTechnicalMeasureOther
                                                                                                            )) {
                                                                                                            Object this$versionNumber = this.getVersionNumber();
                                                                                                            Object other$versionNumber = other.getVersionNumber();
                                                                                                            if (this$versionNumber == null
                                                                                                               ? other$versionNumber == null
                                                                                                               : this$versionNumber.equals(other$versionNumber)
                                                                                                               )
                                                                                                             {
                                                                                                               Object this$cappCraftCardStorehouseCraftParameterPassLinkDetailVOList = this.getCappCraftCardStorehouseCraftParameterPassLinkDetailVOList();
                                                                                                               Object other$cappCraftCardStorehouseCraftParameterPassLinkDetailVOList = other.getCappCraftCardStorehouseCraftParameterPassLinkDetailVOList();
                                                                                                               if (this$cappCraftCardStorehouseCraftParameterPassLinkDetailVOList
                                                                                                                     == null
                                                                                                                  ? other$cappCraftCardStorehouseCraftParameterPassLinkDetailVOList
                                                                                                                     == null
                                                                                                                  : this$cappCraftCardStorehouseCraftParameterPassLinkDetailVOList.equals(
                                                                                                                     other$cappCraftCardStorehouseCraftParameterPassLinkDetailVOList
                                                                                                                  )) {
                                                                                                                  Object this$cappCraftCardStorehouseMaterialsLinkDetailVOList = this.getCappCraftCardStorehouseMaterialsLinkDetailVOList();
                                                                                                                  Object other$cappCraftCardStorehouseMaterialsLinkDetailVOList = other.getCappCraftCardStorehouseMaterialsLinkDetailVOList();
                                                                                                                  if (this$cappCraftCardStorehouseMaterialsLinkDetailVOList
                                                                                                                        == null
                                                                                                                     ? other$cappCraftCardStorehouseMaterialsLinkDetailVOList
                                                                                                                        == null
                                                                                                                     : this$cappCraftCardStorehouseMaterialsLinkDetailVOList.equals(
                                                                                                                        other$cappCraftCardStorehouseMaterialsLinkDetailVOList
                                                                                                                     )) {
                                                                                                                     Object this$cappCraftCardStorehouseTemperatureLinkDetailVOList = this.getCappCraftCardStorehouseTemperatureLinkDetailVOList();
                                                                                                                     Object other$cappCraftCardStorehouseTemperatureLinkDetailVOList = other.getCappCraftCardStorehouseTemperatureLinkDetailVOList();
                                                                                                                     return this$cappCraftCardStorehouseTemperatureLinkDetailVOList
                                                                                                                           == null
                                                                                                                        ? other$cappCraftCardStorehouseTemperatureLinkDetailVOList
                                                                                                                           == null
                                                                                                                        : this$cappCraftCardStorehouseTemperatureLinkDetailVOList.equals(
                                                                                                                           other$cappCraftCardStorehouseTemperatureLinkDetailVOList
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardStorehouseDetailVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $craftType = this.getCraftType();
      result = result * 59 + ($craftType == null ? 43 : $craftType.hashCode());
      Object $processAttributes = this.getProcessAttributes();
      result = result * 59 + ($processAttributes == null ? 43 : $processAttributes.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $operatorUserId = this.getOperatorUserId();
      result = result * 59 + ($operatorUserId == null ? 43 : $operatorUserId.hashCode());
      Object $auditorUserId = this.getAuditorUserId();
      result = result * 59 + ($auditorUserId == null ? 43 : $auditorUserId.hashCode());
      Object $jointSchematicDiagramAttachmentId = this.getJointSchematicDiagramAttachmentId();
      result = result * 59 + ($jointSchematicDiagramAttachmentId == null ? 43 : $jointSchematicDiagramAttachmentId.hashCode());
      Object $weldingSchematicDiagramAttachmentId = this.getWeldingSchematicDiagramAttachmentId();
      result = result * 59 + ($weldingSchematicDiagramAttachmentId == null ? 43 : $weldingSchematicDiagramAttachmentId.hashCode());
      Object $processStatus = this.getProcessStatus();
      result = result * 59 + ($processStatus == null ? 43 : $processStatus.hashCode());
      Object $enabledFlag = this.getEnabledFlag();
      result = result * 59 + ($enabledFlag == null ? 43 : $enabledFlag.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $weldingBaseJointType = this.getWeldingBaseJointType();
      result = result * 59 + ($weldingBaseJointType == null ? 43 : $weldingBaseJointType.hashCode());
      Object $weldingBaseParentMaterialSteelGrade = this.getWeldingBaseParentMaterialSteelGrade();
      result = result * 59 + ($weldingBaseParentMaterialSteelGrade == null ? 43 : $weldingBaseParentMaterialSteelGrade.hashCode());
      Object $weldingBasePlateThicknessOrPipeDiameter = this.getWeldingBasePlateThicknessOrPipeDiameter();
      result = result * 59 + ($weldingBasePlateThicknessOrPipeDiameter == null ? 43 : $weldingBasePlateThicknessOrPipeDiameter.hashCode());
      Object $weldingBaseHotRollingOrHeatTreatmentStatus = this.getWeldingBaseHotRollingOrHeatTreatmentStatus();
      result = result * 59 + ($weldingBaseHotRollingOrHeatTreatmentStatus == null ? 43 : $weldingBaseHotRollingOrHeatTreatmentStatus.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $weldingBaseWeldingMethod = this.getWeldingBaseWeldingMethod();
      result = result * 59 + ($weldingBaseWeldingMethod == null ? 43 : $weldingBaseWeldingMethod.hashCode());
      Object $weldingBaseWeldingPosition = this.getWeldingBaseWeldingPosition();
      result = result * 59 + ($weldingBaseWeldingPosition == null ? 43 : $weldingBaseWeldingPosition.hashCode());
      Object $weldingBaseWeldingDeviceType = this.getWeldingBaseWeldingDeviceType();
      result = result * 59 + ($weldingBaseWeldingDeviceType == null ? 43 : $weldingBaseWeldingDeviceType.hashCode());
      Object $weldingBasePowerSupplyAndPolarity = this.getWeldingBasePowerSupplyAndPolarity();
      result = result * 59 + ($weldingBasePowerSupplyAndPolarity == null ? 43 : $weldingBasePowerSupplyAndPolarity.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $operatorUserName = this.getOperatorUserName();
      result = result * 59 + ($operatorUserName == null ? 43 : $operatorUserName.hashCode());
      Object $operatorDateTime = this.getOperatorDateTime();
      result = result * 59 + ($operatorDateTime == null ? 43 : $operatorDateTime.hashCode());
      Object $auditorUserName = this.getAuditorUserName();
      result = result * 59 + ($auditorUserName == null ? 43 : $auditorUserName.hashCode());
      Object $auditDateTime = this.getAuditDateTime();
      result = result * 59 + ($auditDateTime == null ? 43 : $auditDateTime.hashCode());
      Object $jointSchematicDiagramAttachmentDTO = this.getJointSchematicDiagramAttachmentDTO();
      result = result * 59 + ($jointSchematicDiagramAttachmentDTO == null ? 43 : $jointSchematicDiagramAttachmentDTO.hashCode());
      Object $weldingSchematicDiagramAttachmentDTO = this.getWeldingSchematicDiagramAttachmentDTO();
      result = result * 59 + ($weldingSchematicDiagramAttachmentDTO == null ? 43 : $weldingSchematicDiagramAttachmentDTO.hashCode());
      Object $weldingTechnicalMeasurePreWeldCleaning = this.getWeldingTechnicalMeasurePreWeldCleaning();
      result = result * 59 + ($weldingTechnicalMeasurePreWeldCleaning == null ? 43 : $weldingTechnicalMeasurePreWeldCleaning.hashCode());
      Object $weldingTechnicalMeasureRoadCleaning = this.getWeldingTechnicalMeasureRoadCleaning();
      result = result * 59 + ($weldingTechnicalMeasureRoadCleaning == null ? 43 : $weldingTechnicalMeasureRoadCleaning.hashCode());
      Object $weldingTechnicalMeasureBackCleaning = this.getWeldingTechnicalMeasureBackCleaning();
      result = result * 59 + ($weldingTechnicalMeasureBackCleaning == null ? 43 : $weldingTechnicalMeasureBackCleaning.hashCode());
      Object $weldingTechnicalMeasureOther = this.getWeldingTechnicalMeasureOther();
      result = result * 59 + ($weldingTechnicalMeasureOther == null ? 43 : $weldingTechnicalMeasureOther.hashCode());
      Object $versionNumber = this.getVersionNumber();
      result = result * 59 + ($versionNumber == null ? 43 : $versionNumber.hashCode());
      Object $cappCraftCardStorehouseCraftParameterPassLinkDetailVOList = this.getCappCraftCardStorehouseCraftParameterPassLinkDetailVOList();
      result = result * 59
         + ($cappCraftCardStorehouseCraftParameterPassLinkDetailVOList == null ? 43 : $cappCraftCardStorehouseCraftParameterPassLinkDetailVOList.hashCode());
      Object $cappCraftCardStorehouseMaterialsLinkDetailVOList = this.getCappCraftCardStorehouseMaterialsLinkDetailVOList();
      result = result * 59 + ($cappCraftCardStorehouseMaterialsLinkDetailVOList == null ? 43 : $cappCraftCardStorehouseMaterialsLinkDetailVOList.hashCode());
      Object $cappCraftCardStorehouseTemperatureLinkDetailVOList = this.getCappCraftCardStorehouseTemperatureLinkDetailVOList();
      return result * 59 + ($cappCraftCardStorehouseTemperatureLinkDetailVOList == null ? 43 : $cappCraftCardStorehouseTemperatureLinkDetailVOList.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardStorehouseDetailVO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", craftType="
         + this.getCraftType()
         + ", processAttributes="
         + this.getProcessAttributes()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", weldingBaseJointType="
         + this.getWeldingBaseJointType()
         + ", weldingBaseParentMaterialSteelGrade="
         + this.getWeldingBaseParentMaterialSteelGrade()
         + ", weldingBasePlateThicknessOrPipeDiameter="
         + this.getWeldingBasePlateThicknessOrPipeDiameter()
         + ", weldingBaseHotRollingOrHeatTreatmentStatus="
         + this.getWeldingBaseHotRollingOrHeatTreatmentStatus()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", weldingBaseWeldingMethod="
         + this.getWeldingBaseWeldingMethod()
         + ", weldingBaseWeldingPosition="
         + this.getWeldingBaseWeldingPosition()
         + ", weldingBaseWeldingDeviceType="
         + this.getWeldingBaseWeldingDeviceType()
         + ", weldingBasePowerSupplyAndPolarity="
         + this.getWeldingBasePowerSupplyAndPolarity()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", operatorUserId="
         + this.getOperatorUserId()
         + ", operatorUserName="
         + this.getOperatorUserName()
         + ", operatorDateTime="
         + this.getOperatorDateTime()
         + ", auditorUserId="
         + this.getAuditorUserId()
         + ", auditorUserName="
         + this.getAuditorUserName()
         + ", auditDateTime="
         + this.getAuditDateTime()
         + ", jointSchematicDiagramAttachmentId="
         + this.getJointSchematicDiagramAttachmentId()
         + ", jointSchematicDiagramAttachmentDTO="
         + this.getJointSchematicDiagramAttachmentDTO()
         + ", weldingSchematicDiagramAttachmentId="
         + this.getWeldingSchematicDiagramAttachmentId()
         + ", weldingSchematicDiagramAttachmentDTO="
         + this.getWeldingSchematicDiagramAttachmentDTO()
         + ", weldingTechnicalMeasurePreWeldCleaning="
         + this.getWeldingTechnicalMeasurePreWeldCleaning()
         + ", weldingTechnicalMeasureRoadCleaning="
         + this.getWeldingTechnicalMeasureRoadCleaning()
         + ", weldingTechnicalMeasureBackCleaning="
         + this.getWeldingTechnicalMeasureBackCleaning()
         + ", weldingTechnicalMeasureOther="
         + this.getWeldingTechnicalMeasureOther()
         + ", processStatus="
         + this.getProcessStatus()
         + ", enabledFlag="
         + this.getEnabledFlag()
         + ", versionNumber="
         + this.getVersionNumber()
         + ", cappCraftCardStorehouseCraftParameterPassLinkDetailVOList="
         + this.getCappCraftCardStorehouseCraftParameterPassLinkDetailVOList()
         + ", cappCraftCardStorehouseMaterialsLinkDetailVOList="
         + this.getCappCraftCardStorehouseMaterialsLinkDetailVOList()
         + ", cappCraftCardStorehouseTemperatureLinkDetailVOList="
         + this.getCappCraftCardStorehouseTemperatureLinkDetailVOList()
         + ")";
   }
}
