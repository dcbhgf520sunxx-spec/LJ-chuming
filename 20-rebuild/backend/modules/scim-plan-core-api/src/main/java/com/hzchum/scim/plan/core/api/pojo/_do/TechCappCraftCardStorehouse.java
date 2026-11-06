package com.hzchum.scim.plan.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TechCappCraftCardStorehouse对象", description = "工艺库")
@Entity
@TableName("tech_capp_craft_card_storehouse")
@Table(name = "tech_capp_craft_card_storehouse")
@org.hibernate.annotations.Table(appliesTo = "tech_capp_craft_card_storehouse", comment = "工艺库")
public class TechCappCraftCardStorehouse extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "工艺编号", notes = "工艺编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(100)  COMMENT '工艺编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "craftType", value = "工艺类型参考枚举 CappCraftTypeEnum", notes = "工艺类型参考枚举 CappCraftTypeEnum")
   @TableField("craft_type")
   @Column(name = "craft_type", columnDefinition = "int(11)  COMMENT '工艺类型参考枚举 CappCraftTypeEnum'", nullable = false)
   private Integer craftType;
   @ApiModelProperty(name = "processAttributes", value = "工艺属性参考枚举 CAPPProcessAttributesEnum", notes = "工艺属性参考枚举 CAPPProcessAttributesEnum")
   @TableField("process_attributes")
   @Column(name = "process_attributes", columnDefinition = "int(11)  COMMENT '工艺属性参考枚举 CAPPProcessAttributesEnum'", nullable = false)
   private Integer processAttributes;
   @ApiModelProperty(name = "projectId", value = "工程项目(关联工艺属性，如工艺属性为项目专属，则必填)", notes = "工程项目(关联工艺属性，如工艺属性为项目专属，则必填)")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(11)  COMMENT '工程项目(关联工艺属性，如工艺属性为项目专属，则必填)'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "weldingBaseJointType", value = "接头形式", notes = "接头形式")
   @TableField("welding_base_joint_type")
   @Column(name = "welding_base_joint_type", columnDefinition = "varchar(255)  COMMENT '接头形式'", nullable = false)
   private String weldingBaseJointType;
   @ApiModelProperty(name = "weldingBaseParentMaterialSteelGrade", value = "母材钢号", notes = "母材钢号")
   @TableField("welding_base_parent_material_steel_grade")
   @Column(name = "welding_base_parent_material_steel_grade", columnDefinition = "varchar(255)  COMMENT '母材钢号'", nullable = true)
   private String weldingBaseParentMaterialSteelGrade;
   @ApiModelProperty(name = "weldingBasePlateThicknessOrPipeDiameter", value = "板厚或管径X壁厚", notes = "板厚或管径X壁厚")
   @TableField("welding_base_plate_thickness_or_pipe_diameter")
   @Column(name = "welding_base_plate_thickness_or_pipe_diameter", columnDefinition = "varchar(255)  COMMENT '板厚或管径X壁厚'", nullable = true)
   private String weldingBasePlateThicknessOrPipeDiameter;
   @ApiModelProperty(name = "weldingBaseHotRollingOrHeatTreatmentStatus", value = "轧制或热处理状态", notes = "轧制或热处理状态")
   @TableField("welding_base_hot_rolling_or_heat_treatment_status")
   @Column(name = "welding_base_hot_rolling_or_heat_treatment_status", columnDefinition = "varchar(255)  COMMENT '轧制或热处理状态'", nullable = true)
   private String weldingBaseHotRollingOrHeatTreatmentStatus;
   @ApiModelProperty(name = "processId", value = "关联工序", notes = "关联工序")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '关联工序'", nullable = true)
   private Long processId;
   @ApiModelProperty(name = "weldingBaseWeldingMethod", value = "焊接方法", notes = "焊接方法")
   @TableField("welding_base_welding_method")
   @Column(name = "welding_base_welding_method", columnDefinition = "varchar(255)  COMMENT '焊接方法'", nullable = false)
   private String weldingBaseWeldingMethod;
   @ApiModelProperty(name = "weldingBaseWeldingPosition", value = "焊接位置", notes = "焊接位置")
   @TableField("welding_base_welding_position")
   @Column(name = "welding_base_welding_position", columnDefinition = "varchar(255)  COMMENT '焊接位置'", nullable = true)
   private String weldingBaseWeldingPosition;
   @ApiModelProperty(name = "weldingBaseWeldingDeviceType", value = "焊接设备型号", notes = "焊接设备型号")
   @TableField("welding_base_welding_device_type")
   @Column(name = "welding_base_welding_device_type", columnDefinition = "varchar(255)  COMMENT '焊接设备型号'", nullable = true)
   private String weldingBaseWeldingDeviceType;
   @ApiModelProperty(name = "weldingBasePowerSupplyAndPolarity", value = "电源及极性", notes = "电源及极性")
   @TableField("welding_base_power_supply_and_polarity")
   @Column(name = "welding_base_power_supply_and_polarity", columnDefinition = "varchar(255)  COMMENT '电源及极性'", nullable = true)
   private String weldingBasePowerSupplyAndPolarity;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(255)  COMMENT '创建人名称'", nullable = false)
   private String createUserName;
   @ApiModelProperty(name = "operatorUserId", value = "编制人id", notes = "编制人id")
   @TableField("operator_user_id")
   @Column(name = "operator_user_id", columnDefinition = "bigint(20)  COMMENT '编制人id'", nullable = true)
   private Long operatorUserId;
   @ApiModelProperty(name = "operatorUserName", value = "编制人名称", notes = "编制人名称")
   @TableField("operator_user_name")
   @Column(name = "operator_user_name", columnDefinition = "varchar(255)  COMMENT '编制人名称'", nullable = true)
   private String operatorUserName;
   @ApiModelProperty(name = "operatorDateTime", value = "编制日期", notes = "编制日期")
   @TableField("operator_date_time")
   @Column(name = "operator_date_time", columnDefinition = "datetime  COMMENT '编制日期'", nullable = true)
   private LocalDateTime operatorDateTime;
   @ApiModelProperty(name = "auditorUserId", value = "审核人id", notes = "审核人id")
   @TableField("auditor_user_id")
   @Column(name = "auditor_user_id", columnDefinition = "bigint(20)  COMMENT '审核人id'", nullable = true)
   private Long auditorUserId;
   @ApiModelProperty(name = "auditorUserName", value = "审核人名称", notes = "审核人名称")
   @TableField("auditor_user_name")
   @Column(name = "auditor_user_name", columnDefinition = "varchar(255)  COMMENT '审核人名称'", nullable = true)
   private String auditorUserName;
   @ApiModelProperty(name = "auditDateTime", value = "审核日期", notes = "审核日期")
   @TableField("audit_date_time")
   @Column(name = "audit_date_time", columnDefinition = "datetime  COMMENT '审核日期'", nullable = true)
   private LocalDateTime auditDateTime;
   @ApiModelProperty(name = "jointSchematicDiagramAttachmentId", value = "接头示意图附件信息", notes = "接头示意图附件信息")
   @TableField("joint_schematic_diagram_attachment_id")
   @Column(name = "joint_schematic_diagram_attachment_id", columnDefinition = "bigint(20)  COMMENT '接头示意图附件信息'", nullable = true)
   private Long jointSchematicDiagramAttachmentId;
   @ApiModelProperty(name = "weldingSchematicDiagramAttachmentId", value = "焊接顺序示意图附件信息", notes = "焊接顺序示意图附件信息")
   @TableField("welding_schematic_diagram_attachment_id")
   @Column(name = "welding_schematic_diagram_attachment_id", columnDefinition = "bigint(20)  COMMENT '焊接顺序示意图附件信息'", nullable = true)
   private Long weldingSchematicDiagramAttachmentId;
   @ApiModelProperty(name = "weldingTechnicalMeasurePreWeldCleaning", value = "焊前清理", notes = "焊前清理")
   @TableField("welding_technical_measure_pre_weld_cleaning")
   @Column(name = "welding_technical_measure_pre_weld_cleaning", columnDefinition = "varchar(255)  COMMENT '焊前清理'", nullable = true)
   private String weldingTechnicalMeasurePreWeldCleaning;
   @ApiModelProperty(name = "weldingTechnicalMeasureRoadCleaning", value = "道间清理", notes = "道间清理")
   @TableField("welding_technical_measure_road_cleaning")
   @Column(name = "welding_technical_measure_road_cleaning", columnDefinition = "varchar(255)  COMMENT '道间清理'", nullable = true)
   private String weldingTechnicalMeasureRoadCleaning;
   @ApiModelProperty(name = "weldingTechnicalMeasureBackCleaning", value = "背面清理", notes = "背面清理")
   @TableField("welding_technical_measure_back_cleaning")
   @Column(name = "welding_technical_measure_back_cleaning", columnDefinition = "varchar(255)  COMMENT '背面清理'", nullable = true)
   private String weldingTechnicalMeasureBackCleaning;
   @ApiModelProperty(name = "weldingTechnicalMeasureOther", value = "其他清理措施", notes = "其他清理措施")
   @TableField("welding_technical_measure_other")
   @Column(name = "welding_technical_measure_other", columnDefinition = "varchar(255)  COMMENT '其他清理措施'", nullable = true)
   private String weldingTechnicalMeasureOther;
   @ApiModelProperty(name = "processStatus", value = "工艺状态 1正常状态 2草稿状态 参考枚举CAPPProcessStatusEnum", notes = "工艺状态 1正常状态 2草稿状态 参考枚举CAPPProcessStatusEnum")
   @TableField("process_status")
   @Column(name = "process_status", columnDefinition = "int(11)  COMMENT '工艺状态 1正常状态 2草稿状态 参考枚举CAPPProcessStatusEnum'", nullable = false)
   private Integer processStatus;
   @ApiModelProperty(name = "enabledFlag", value = "是否启用：0 未启用；1 启用", notes = "是否启用：0 未启用；1 启用")
   @TableField("enabled_flag")
   @Column(name = "enabled_flag", columnDefinition = "tinyint(1) default '1' COMMENT '是否启用：0 未启用；1 启用'", nullable = false)
   private Boolean enabledFlag;
   @ApiModelProperty(name = "versionNumber", value = "字母版本号A~Z(暂不考虑超出如何处理)", notes = "字母版本号A~Z(暂不考虑超出如何处理)")
   @TableField("version_number")
   @Column(name = "version_number", columnDefinition = "varchar(255)  COMMENT '字母版本号A~Z(暂不考虑超出如何处理)'", nullable = true)
   private String versionNumber;

   public static TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder builder() {
      return new TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder();
   }

   public TechCappCraftCardStorehouse() {
   }

   public TechCappCraftCardStorehouse(
      final Long id,
      final String serialNumber,
      final Integer craftType,
      final Integer processAttributes,
      final Long projectId,
      final String weldingBaseJointType,
      final String weldingBaseParentMaterialSteelGrade,
      final String weldingBasePlateThicknessOrPipeDiameter,
      final String weldingBaseHotRollingOrHeatTreatmentStatus,
      final Long processId,
      final String weldingBaseWeldingMethod,
      final String weldingBaseWeldingPosition,
      final String weldingBaseWeldingDeviceType,
      final String weldingBasePowerSupplyAndPolarity,
      final Long createUserId,
      final String createUserName,
      final Long operatorUserId,
      final String operatorUserName,
      final LocalDateTime operatorDateTime,
      final Long auditorUserId,
      final String auditorUserName,
      final LocalDateTime auditDateTime,
      final Long jointSchematicDiagramAttachmentId,
      final Long weldingSchematicDiagramAttachmentId,
      final String weldingTechnicalMeasurePreWeldCleaning,
      final String weldingTechnicalMeasureRoadCleaning,
      final String weldingTechnicalMeasureBackCleaning,
      final String weldingTechnicalMeasureOther,
      final Integer processStatus,
      final Boolean enabledFlag,
      final String versionNumber
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.craftType = craftType;
      this.processAttributes = processAttributes;
      this.projectId = projectId;
      this.weldingBaseJointType = weldingBaseJointType;
      this.weldingBaseParentMaterialSteelGrade = weldingBaseParentMaterialSteelGrade;
      this.weldingBasePlateThicknessOrPipeDiameter = weldingBasePlateThicknessOrPipeDiameter;
      this.weldingBaseHotRollingOrHeatTreatmentStatus = weldingBaseHotRollingOrHeatTreatmentStatus;
      this.processId = processId;
      this.weldingBaseWeldingMethod = weldingBaseWeldingMethod;
      this.weldingBaseWeldingPosition = weldingBaseWeldingPosition;
      this.weldingBaseWeldingDeviceType = weldingBaseWeldingDeviceType;
      this.weldingBasePowerSupplyAndPolarity = weldingBasePowerSupplyAndPolarity;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.operatorUserId = operatorUserId;
      this.operatorUserName = operatorUserName;
      this.operatorDateTime = operatorDateTime;
      this.auditorUserId = auditorUserId;
      this.auditorUserName = auditorUserName;
      this.auditDateTime = auditDateTime;
      this.jointSchematicDiagramAttachmentId = jointSchematicDiagramAttachmentId;
      this.weldingSchematicDiagramAttachmentId = weldingSchematicDiagramAttachmentId;
      this.weldingTechnicalMeasurePreWeldCleaning = weldingTechnicalMeasurePreWeldCleaning;
      this.weldingTechnicalMeasureRoadCleaning = weldingTechnicalMeasureRoadCleaning;
      this.weldingTechnicalMeasureBackCleaning = weldingTechnicalMeasureBackCleaning;
      this.weldingTechnicalMeasureOther = weldingTechnicalMeasureOther;
      this.processStatus = processStatus;
      this.enabledFlag = enabledFlag;
      this.versionNumber = versionNumber;
   }

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

   public Long getWeldingSchematicDiagramAttachmentId() {
      return this.weldingSchematicDiagramAttachmentId;
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

   public TechCappCraftCardStorehouse setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechCappCraftCardStorehouse setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechCappCraftCardStorehouse setCraftType(final Integer craftType) {
      this.craftType = craftType;
      return this;
   }

   public TechCappCraftCardStorehouse setProcessAttributes(final Integer processAttributes) {
      this.processAttributes = processAttributes;
      return this;
   }

   public TechCappCraftCardStorehouse setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingBaseJointType(final String weldingBaseJointType) {
      this.weldingBaseJointType = weldingBaseJointType;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingBaseParentMaterialSteelGrade(final String weldingBaseParentMaterialSteelGrade) {
      this.weldingBaseParentMaterialSteelGrade = weldingBaseParentMaterialSteelGrade;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingBasePlateThicknessOrPipeDiameter(final String weldingBasePlateThicknessOrPipeDiameter) {
      this.weldingBasePlateThicknessOrPipeDiameter = weldingBasePlateThicknessOrPipeDiameter;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingBaseHotRollingOrHeatTreatmentStatus(final String weldingBaseHotRollingOrHeatTreatmentStatus) {
      this.weldingBaseHotRollingOrHeatTreatmentStatus = weldingBaseHotRollingOrHeatTreatmentStatus;
      return this;
   }

   public TechCappCraftCardStorehouse setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingBaseWeldingMethod(final String weldingBaseWeldingMethod) {
      this.weldingBaseWeldingMethod = weldingBaseWeldingMethod;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingBaseWeldingPosition(final String weldingBaseWeldingPosition) {
      this.weldingBaseWeldingPosition = weldingBaseWeldingPosition;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingBaseWeldingDeviceType(final String weldingBaseWeldingDeviceType) {
      this.weldingBaseWeldingDeviceType = weldingBaseWeldingDeviceType;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingBasePowerSupplyAndPolarity(final String weldingBasePowerSupplyAndPolarity) {
      this.weldingBasePowerSupplyAndPolarity = weldingBasePowerSupplyAndPolarity;
      return this;
   }

   public TechCappCraftCardStorehouse setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public TechCappCraftCardStorehouse setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public TechCappCraftCardStorehouse setOperatorUserId(final Long operatorUserId) {
      this.operatorUserId = operatorUserId;
      return this;
   }

   public TechCappCraftCardStorehouse setOperatorUserName(final String operatorUserName) {
      this.operatorUserName = operatorUserName;
      return this;
   }

   public TechCappCraftCardStorehouse setOperatorDateTime(final LocalDateTime operatorDateTime) {
      this.operatorDateTime = operatorDateTime;
      return this;
   }

   public TechCappCraftCardStorehouse setAuditorUserId(final Long auditorUserId) {
      this.auditorUserId = auditorUserId;
      return this;
   }

   public TechCappCraftCardStorehouse setAuditorUserName(final String auditorUserName) {
      this.auditorUserName = auditorUserName;
      return this;
   }

   public TechCappCraftCardStorehouse setAuditDateTime(final LocalDateTime auditDateTime) {
      this.auditDateTime = auditDateTime;
      return this;
   }

   public TechCappCraftCardStorehouse setJointSchematicDiagramAttachmentId(final Long jointSchematicDiagramAttachmentId) {
      this.jointSchematicDiagramAttachmentId = jointSchematicDiagramAttachmentId;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingSchematicDiagramAttachmentId(final Long weldingSchematicDiagramAttachmentId) {
      this.weldingSchematicDiagramAttachmentId = weldingSchematicDiagramAttachmentId;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingTechnicalMeasurePreWeldCleaning(final String weldingTechnicalMeasurePreWeldCleaning) {
      this.weldingTechnicalMeasurePreWeldCleaning = weldingTechnicalMeasurePreWeldCleaning;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingTechnicalMeasureRoadCleaning(final String weldingTechnicalMeasureRoadCleaning) {
      this.weldingTechnicalMeasureRoadCleaning = weldingTechnicalMeasureRoadCleaning;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingTechnicalMeasureBackCleaning(final String weldingTechnicalMeasureBackCleaning) {
      this.weldingTechnicalMeasureBackCleaning = weldingTechnicalMeasureBackCleaning;
      return this;
   }

   public TechCappCraftCardStorehouse setWeldingTechnicalMeasureOther(final String weldingTechnicalMeasureOther) {
      this.weldingTechnicalMeasureOther = weldingTechnicalMeasureOther;
      return this;
   }

   public TechCappCraftCardStorehouse setProcessStatus(final Integer processStatus) {
      this.processStatus = processStatus;
      return this;
   }

   public TechCappCraftCardStorehouse setEnabledFlag(final Boolean enabledFlag) {
      this.enabledFlag = enabledFlag;
      return this;
   }

   public TechCappCraftCardStorehouse setVersionNumber(final String versionNumber) {
      this.versionNumber = versionNumber;
      return this;
   }

   @Override
   public String toString() {
      return "TechCappCraftCardStorehouse(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", craftType="
         + this.getCraftType()
         + ", processAttributes="
         + this.getProcessAttributes()
         + ", projectId="
         + this.getProjectId()
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
         + ", weldingSchematicDiagramAttachmentId="
         + this.getWeldingSchematicDiagramAttachmentId()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechCappCraftCardStorehouse)) {
         return false;
      }

      TechCappCraftCardStorehouse other = (TechCappCraftCardStorehouse)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                                                                     : this$weldingBasePowerSupplyAndPolarity.equals(other$weldingBasePowerSupplyAndPolarity)) {
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
                                                                                                return this$versionNumber == null
                                                                                                   ? other$versionNumber == null
                                                                                                   : this$versionNumber.equals(other$versionNumber);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechCappCraftCardStorehouse;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      Object $weldingBaseJointType = this.getWeldingBaseJointType();
      result = result * 59 + ($weldingBaseJointType == null ? 43 : $weldingBaseJointType.hashCode());
      Object $weldingBaseParentMaterialSteelGrade = this.getWeldingBaseParentMaterialSteelGrade();
      result = result * 59 + ($weldingBaseParentMaterialSteelGrade == null ? 43 : $weldingBaseParentMaterialSteelGrade.hashCode());
      Object $weldingBasePlateThicknessOrPipeDiameter = this.getWeldingBasePlateThicknessOrPipeDiameter();
      result = result * 59 + ($weldingBasePlateThicknessOrPipeDiameter == null ? 43 : $weldingBasePlateThicknessOrPipeDiameter.hashCode());
      Object $weldingBaseHotRollingOrHeatTreatmentStatus = this.getWeldingBaseHotRollingOrHeatTreatmentStatus();
      result = result * 59 + ($weldingBaseHotRollingOrHeatTreatmentStatus == null ? 43 : $weldingBaseHotRollingOrHeatTreatmentStatus.hashCode());
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
      Object $weldingTechnicalMeasurePreWeldCleaning = this.getWeldingTechnicalMeasurePreWeldCleaning();
      result = result * 59 + ($weldingTechnicalMeasurePreWeldCleaning == null ? 43 : $weldingTechnicalMeasurePreWeldCleaning.hashCode());
      Object $weldingTechnicalMeasureRoadCleaning = this.getWeldingTechnicalMeasureRoadCleaning();
      result = result * 59 + ($weldingTechnicalMeasureRoadCleaning == null ? 43 : $weldingTechnicalMeasureRoadCleaning.hashCode());
      Object $weldingTechnicalMeasureBackCleaning = this.getWeldingTechnicalMeasureBackCleaning();
      result = result * 59 + ($weldingTechnicalMeasureBackCleaning == null ? 43 : $weldingTechnicalMeasureBackCleaning.hashCode());
      Object $weldingTechnicalMeasureOther = this.getWeldingTechnicalMeasureOther();
      result = result * 59 + ($weldingTechnicalMeasureOther == null ? 43 : $weldingTechnicalMeasureOther.hashCode());
      Object $versionNumber = this.getVersionNumber();
      return result * 59 + ($versionNumber == null ? 43 : $versionNumber.hashCode());
   }

   public static class TechCappCraftCardStorehouseBuilder {
      private Long id;
      private String serialNumber;
      private Integer craftType;
      private Integer processAttributes;
      private Long projectId;
      private String weldingBaseJointType;
      private String weldingBaseParentMaterialSteelGrade;
      private String weldingBasePlateThicknessOrPipeDiameter;
      private String weldingBaseHotRollingOrHeatTreatmentStatus;
      private Long processId;
      private String weldingBaseWeldingMethod;
      private String weldingBaseWeldingPosition;
      private String weldingBaseWeldingDeviceType;
      private String weldingBasePowerSupplyAndPolarity;
      private Long createUserId;
      private String createUserName;
      private Long operatorUserId;
      private String operatorUserName;
      private LocalDateTime operatorDateTime;
      private Long auditorUserId;
      private String auditorUserName;
      private LocalDateTime auditDateTime;
      private Long jointSchematicDiagramAttachmentId;
      private Long weldingSchematicDiagramAttachmentId;
      private String weldingTechnicalMeasurePreWeldCleaning;
      private String weldingTechnicalMeasureRoadCleaning;
      private String weldingTechnicalMeasureBackCleaning;
      private String weldingTechnicalMeasureOther;
      private Integer processStatus;
      private Boolean enabledFlag;
      private String versionNumber;

      TechCappCraftCardStorehouseBuilder() {
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder craftType(final Integer craftType) {
         this.craftType = craftType;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder processAttributes(final Integer processAttributes) {
         this.processAttributes = processAttributes;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingBaseJointType(final String weldingBaseJointType) {
         this.weldingBaseJointType = weldingBaseJointType;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingBaseParentMaterialSteelGrade(
         final String weldingBaseParentMaterialSteelGrade
      ) {
         this.weldingBaseParentMaterialSteelGrade = weldingBaseParentMaterialSteelGrade;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingBasePlateThicknessOrPipeDiameter(
         final String weldingBasePlateThicknessOrPipeDiameter
      ) {
         this.weldingBasePlateThicknessOrPipeDiameter = weldingBasePlateThicknessOrPipeDiameter;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingBaseHotRollingOrHeatTreatmentStatus(
         final String weldingBaseHotRollingOrHeatTreatmentStatus
      ) {
         this.weldingBaseHotRollingOrHeatTreatmentStatus = weldingBaseHotRollingOrHeatTreatmentStatus;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingBaseWeldingMethod(final String weldingBaseWeldingMethod) {
         this.weldingBaseWeldingMethod = weldingBaseWeldingMethod;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingBaseWeldingPosition(final String weldingBaseWeldingPosition) {
         this.weldingBaseWeldingPosition = weldingBaseWeldingPosition;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingBaseWeldingDeviceType(final String weldingBaseWeldingDeviceType) {
         this.weldingBaseWeldingDeviceType = weldingBaseWeldingDeviceType;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingBasePowerSupplyAndPolarity(final String weldingBasePowerSupplyAndPolarity) {
         this.weldingBasePowerSupplyAndPolarity = weldingBasePowerSupplyAndPolarity;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder operatorUserId(final Long operatorUserId) {
         this.operatorUserId = operatorUserId;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder operatorUserName(final String operatorUserName) {
         this.operatorUserName = operatorUserName;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder operatorDateTime(final LocalDateTime operatorDateTime) {
         this.operatorDateTime = operatorDateTime;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder auditorUserId(final Long auditorUserId) {
         this.auditorUserId = auditorUserId;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder auditorUserName(final String auditorUserName) {
         this.auditorUserName = auditorUserName;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder auditDateTime(final LocalDateTime auditDateTime) {
         this.auditDateTime = auditDateTime;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder jointSchematicDiagramAttachmentId(final Long jointSchematicDiagramAttachmentId) {
         this.jointSchematicDiagramAttachmentId = jointSchematicDiagramAttachmentId;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingSchematicDiagramAttachmentId(final Long weldingSchematicDiagramAttachmentId) {
         this.weldingSchematicDiagramAttachmentId = weldingSchematicDiagramAttachmentId;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingTechnicalMeasurePreWeldCleaning(
         final String weldingTechnicalMeasurePreWeldCleaning
      ) {
         this.weldingTechnicalMeasurePreWeldCleaning = weldingTechnicalMeasurePreWeldCleaning;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingTechnicalMeasureRoadCleaning(
         final String weldingTechnicalMeasureRoadCleaning
      ) {
         this.weldingTechnicalMeasureRoadCleaning = weldingTechnicalMeasureRoadCleaning;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingTechnicalMeasureBackCleaning(
         final String weldingTechnicalMeasureBackCleaning
      ) {
         this.weldingTechnicalMeasureBackCleaning = weldingTechnicalMeasureBackCleaning;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder weldingTechnicalMeasureOther(final String weldingTechnicalMeasureOther) {
         this.weldingTechnicalMeasureOther = weldingTechnicalMeasureOther;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder processStatus(final Integer processStatus) {
         this.processStatus = processStatus;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder enabledFlag(final Boolean enabledFlag) {
         this.enabledFlag = enabledFlag;
         return this;
      }

      public TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder versionNumber(final String versionNumber) {
         this.versionNumber = versionNumber;
         return this;
      }

      public TechCappCraftCardStorehouse build() {
         return new TechCappCraftCardStorehouse(
            this.id,
            this.serialNumber,
            this.craftType,
            this.processAttributes,
            this.projectId,
            this.weldingBaseJointType,
            this.weldingBaseParentMaterialSteelGrade,
            this.weldingBasePlateThicknessOrPipeDiameter,
            this.weldingBaseHotRollingOrHeatTreatmentStatus,
            this.processId,
            this.weldingBaseWeldingMethod,
            this.weldingBaseWeldingPosition,
            this.weldingBaseWeldingDeviceType,
            this.weldingBasePowerSupplyAndPolarity,
            this.createUserId,
            this.createUserName,
            this.operatorUserId,
            this.operatorUserName,
            this.operatorDateTime,
            this.auditorUserId,
            this.auditorUserName,
            this.auditDateTime,
            this.jointSchematicDiagramAttachmentId,
            this.weldingSchematicDiagramAttachmentId,
            this.weldingTechnicalMeasurePreWeldCleaning,
            this.weldingTechnicalMeasureRoadCleaning,
            this.weldingTechnicalMeasureBackCleaning,
            this.weldingTechnicalMeasureOther,
            this.processStatus,
            this.enabledFlag,
            this.versionNumber
         );
      }

      @Override
      public String toString() {
         return "TechCappCraftCardStorehouse.TechCappCraftCardStorehouseBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", craftType="
            + this.craftType
            + ", processAttributes="
            + this.processAttributes
            + ", projectId="
            + this.projectId
            + ", weldingBaseJointType="
            + this.weldingBaseJointType
            + ", weldingBaseParentMaterialSteelGrade="
            + this.weldingBaseParentMaterialSteelGrade
            + ", weldingBasePlateThicknessOrPipeDiameter="
            + this.weldingBasePlateThicknessOrPipeDiameter
            + ", weldingBaseHotRollingOrHeatTreatmentStatus="
            + this.weldingBaseHotRollingOrHeatTreatmentStatus
            + ", processId="
            + this.processId
            + ", weldingBaseWeldingMethod="
            + this.weldingBaseWeldingMethod
            + ", weldingBaseWeldingPosition="
            + this.weldingBaseWeldingPosition
            + ", weldingBaseWeldingDeviceType="
            + this.weldingBaseWeldingDeviceType
            + ", weldingBasePowerSupplyAndPolarity="
            + this.weldingBasePowerSupplyAndPolarity
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", operatorUserId="
            + this.operatorUserId
            + ", operatorUserName="
            + this.operatorUserName
            + ", operatorDateTime="
            + this.operatorDateTime
            + ", auditorUserId="
            + this.auditorUserId
            + ", auditorUserName="
            + this.auditorUserName
            + ", auditDateTime="
            + this.auditDateTime
            + ", jointSchematicDiagramAttachmentId="
            + this.jointSchematicDiagramAttachmentId
            + ", weldingSchematicDiagramAttachmentId="
            + this.weldingSchematicDiagramAttachmentId
            + ", weldingTechnicalMeasurePreWeldCleaning="
            + this.weldingTechnicalMeasurePreWeldCleaning
            + ", weldingTechnicalMeasureRoadCleaning="
            + this.weldingTechnicalMeasureRoadCleaning
            + ", weldingTechnicalMeasureBackCleaning="
            + this.weldingTechnicalMeasureBackCleaning
            + ", weldingTechnicalMeasureOther="
            + this.weldingTechnicalMeasureOther
            + ", processStatus="
            + this.processStatus
            + ", enabledFlag="
            + this.enabledFlag
            + ", versionNumber="
            + this.versionNumber
            + ")";
      }
   }
}
