package com.hzchum.scim.cut.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CutPlate对象", description = "")
@Entity
@TableName("cut_plate")
@Table(name = "cut_plate")
public class CutPlate extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "allocateTime")
   @JsonProperty("allocateTime")
   @JSONField(name = "allocateTime")
   @TableField("allocate_time")
   @Column(name = "allocate_time", columnDefinition = "datetime(6)  COMMENT ''", nullable = true)
   private LocalDateTime allocateTime;
   @ApiModelProperty(name = "cutTaskId")
   @JsonProperty("cutTaskId")
   @JSONField(name = "cutTaskId")
   @TableField("cut_task_id")
   @Column(name = "cut_task_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String cutTaskId;
   @ApiModelProperty(name = "figureUrl")
   @JsonProperty("figureUrl")
   @JSONField(name = "figureUrl")
   @TableField("figure_url")
   @Column(name = "figure_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String figureUrl;
   @ApiModelProperty(name = "furnaceNo")
   @JsonProperty("furnaceNo")
   @JSONField(name = "furnaceNo")
   @TableField("furnace_no")
   @Column(name = "furnace_no", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String furnaceNo;
   @ApiModelProperty(name = "importTime")
   @JsonProperty("importTime")
   @JSONField(name = "importTime")
   @TableField("import_time")
   @Column(name = "import_time", columnDefinition = "datetime(6)  COMMENT ''", nullable = true)
   private String importTime;
   @ApiModelProperty(name = "length")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "mac")
   @JsonProperty("mac")
   @JSONField(name = "mac")
   @TableField("mac")
   @Column(name = "mac", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String mac;
   @ApiModelProperty(name = "material")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String material;
   @ApiModelProperty(name = "monomer")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   @TableField("monomer")
   @Column(name = "monomer", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String monomer;
   @ApiModelProperty(name = "ncName")
   @JsonProperty("ncName")
   @JSONField(name = "ncName")
   @TableField("nc_name")
   @Column(name = "nc_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String ncName;
   @ApiModelProperty(name = "ncUrl")
   @JsonProperty("ncUrl")
   @JSONField(name = "ncUrl")
   @TableField("nc_url")
   @Column(name = "nc_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String ncUrl;
   @ApiModelProperty(name = "plateNo")
   @JsonProperty("plateNo")
   @JSONField(name = "plateNo")
   @TableField("plate_no")
   @Column(name = "plate_no", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String plateNo;
   @ApiModelProperty(name = "plateState")
   @JsonProperty("plateState")
   @JSONField(name = "plateState")
   @TableField("plate_state")
   @Column(name = "plate_state", columnDefinition = "varchar(255) default '0' COMMENT ''", nullable = true)
   private String plateState;
   @ApiModelProperty(name = "plateType")
   @JsonProperty("plateType")
   @JSONField(name = "plateType")
   @TableField("plate_type")
   @Column(name = "plate_type", columnDefinition = "varchar(255) default '0' COMMENT ''", nullable = true)
   private String plateType;
   @ApiModelProperty(name = "projectName")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   @TableField("project_name")
   @Column(name = "project_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String projectName;
   @ApiModelProperty(name = "projectNo")
   @JsonProperty("projectNo")
   @JSONField(name = "projectNo")
   @TableField("project_no")
   @Column(name = "project_no", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String projectNo;
   @ApiModelProperty(name = "region")
   @JsonProperty("region")
   @JSONField(name = "region")
   @TableField("region")
   @Column(name = "region", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String region;
   @ApiModelProperty(name = "sendTime")
   @JsonProperty("sendTime")
   @JSONField(name = "sendTime")
   @TableField("send_time")
   @Column(name = "send_time", columnDefinition = "datetime(6)  COMMENT ''", nullable = true)
   private LocalDateTime sendTime;
   @ApiModelProperty(name = "source")
   @JsonProperty("source")
   @JSONField(name = "source")
   @TableField("source")
   @Column(name = "source", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String source;
   @ApiModelProperty(name = "state")
   @JsonProperty("state")
   @JSONField(name = "state")
   @TableField("state")
   @Column(name = "state", columnDefinition = "varchar(255) default '0' COMMENT ''", nullable = true)
   private String state;
   @ApiModelProperty(name = "surplusName")
   @JsonProperty("surplusName")
   @JSONField(name = "surplusName")
   @TableField("surplus_name")
   @Column(name = "surplus_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String surplusName;
   @ApiModelProperty(name = "taskId")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String taskId;
   @ApiModelProperty(name = "taskSendState")
   @JsonProperty("taskSendState")
   @JSONField(name = "taskSendState")
   @TableField("task_send_state")
   @Column(name = "task_send_state", columnDefinition = "varchar(255) default '0' COMMENT ''", nullable = true)
   private String taskSendState;
   @ApiModelProperty(name = "thick")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @TableField("thick")
   @Column(name = "thick", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal thick;
   @ApiModelProperty(name = "uploadName")
   @JsonProperty("uploadName")
   @JSONField(name = "uploadName")
   @TableField("upload_name")
   @Column(name = "upload_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String uploadName;
   @ApiModelProperty(name = "cutInstructionId")
   @JsonProperty("cutInstructionId")
   @JSONField(name = "cutInstructionId")
   @TableField("cut_instruction_id")
   @Column(name = "cut_instruction_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String cutInstructionId;
   @ApiModelProperty(name = "cutTime")
   @JsonProperty("cutTime")
   @JSONField(name = "cutTime")
   @TableField("cut_time")
   @Column(name = "cut_time", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String cutTime;
   @ApiModelProperty(name = "nestingReportName")
   @JsonProperty("nestingReportName")
   @JSONField(name = "nestingReportName")
   @TableField("nesting_report_name")
   @Column(name = "nesting_report_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String nestingReportName;
   @ApiModelProperty(name = "nestingReportUrl")
   @JsonProperty("nestingReportUrl")
   @JSONField(name = "nestingReportUrl")
   @TableField("nesting_report_url")
   @Column(name = "nesting_report_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String nestingReportUrl;
   @ApiModelProperty(name = "num")
   @JsonProperty("num")
   @JSONField(name = "num")
   @TableField("num")
   @Column(name = "num", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String num;
   @ApiModelProperty(name = "platePictureName")
   @JsonProperty("platePictureName")
   @JSONField(name = "platePictureName")
   @TableField("plate_picture_name")
   @Column(name = "plate_picture_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String platePictureName;
   @ApiModelProperty(name = "platePictureReportName")
   @JsonProperty("platePictureReportName")
   @JSONField(name = "platePictureReportName")
   @TableField("plate_picture_report_name")
   @Column(name = "plate_picture_report_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String platePictureReportName;
   @ApiModelProperty(name = "platePictureReportUrl")
   @JsonProperty("platePictureReportUrl")
   @JSONField(name = "platePictureReportUrl")
   @TableField("plate_picture_report_url")
   @Column(name = "plate_picture_report_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String platePictureReportUrl;
   @ApiModelProperty(name = "platePictureUrl")
   @JsonProperty("platePictureUrl")
   @JSONField(name = "platePictureUrl")
   @TableField("plate_picture_url")
   @Column(name = "plate_picture_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String platePictureUrl;
   @ApiModelProperty(name = "plateReportUrl")
   @JsonProperty("plateReportUrl")
   @JSONField(name = "plateReportUrl")
   @TableField("plate_report_url")
   @Column(name = "plate_report_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String plateReportUrl;
   @ApiModelProperty(name = "width")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "machineName")
   @JsonProperty("machineName")
   @JSONField(name = "machineName")
   @TableField("machine_name")
   @Column(name = "machine_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String machineName;
   @ApiModelProperty(name = "weight")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal weight;
   @ApiModelProperty(name = "sendState")
   @JsonProperty("sendState")
   @JSONField(name = "sendState")
   @TableField("send_state")
   @Column(name = "send_state", columnDefinition = "varchar(255) default '0' COMMENT ''", nullable = true)
   private String sendState;
   @ApiModelProperty(name = "plateAllReportUrl")
   @JsonProperty("plateAllReportUrl")
   @JSONField(name = "plateAllReportUrl")
   @TableField("plate_all_report_url")
   @Column(name = "plate_all_report_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String plateAllReportUrl;
   @ApiModelProperty(name = "dwgReportName")
   @JsonProperty("dwgReportName")
   @JSONField(name = "dwgReportName")
   @TableField("dwg_report_name")
   @Column(name = "dwg_report_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String dwgReportName;
   @ApiModelProperty(name = "dwgReportUrl")
   @JsonProperty("dwgReportUrl")
   @JSONField(name = "dwgReportUrl")
   @TableField("dwg_report_url")
   @Column(name = "dwg_report_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String dwgReportUrl;
   @ApiModelProperty(name = "boolHaveSurplus")
   @JsonProperty("boolHaveSurplus")
   @JSONField(name = "boolHaveSurplus")
   @TableField("bool_have_surplus")
   @Column(name = "bool_have_surplus", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String boolHaveSurplus;
   @ApiModelProperty(name = "materialId")
   @JsonProperty("materialId")
   @JSONField(name = "materialId")
   @TableField("material_id")
   @Column(name = "material_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String materialId;
   @ApiModelProperty(name = "endTime")
   @JsonProperty("endTime")
   @JSONField(name = "endTime")
   @TableField("end_time")
   @Column(name = "end_time", columnDefinition = "datetime  COMMENT ''", nullable = true)
   private LocalDateTime endTime;
   @ApiModelProperty(name = "startTime")
   @JsonProperty("startTime")
   @JSONField(name = "startTime")
   @TableField("start_time")
   @Column(name = "start_time", columnDefinition = "datetime  COMMENT ''", nullable = true)
   private LocalDateTime startTime;

   public static CutPlate.CutPlateBuilder builder() {
      return new CutPlate.CutPlateBuilder();
   }

   public CutPlate() {
   }

   public CutPlate(
      final Long id,
      final LocalDateTime allocateTime,
      final String cutTaskId,
      final String figureUrl,
      final String furnaceNo,
      final String importTime,
      final BigDecimal length,
      final String mac,
      final String material,
      final String monomer,
      final String ncName,
      final String ncUrl,
      final String plateNo,
      final String plateState,
      final String plateType,
      final String projectName,
      final String projectNo,
      final String region,
      final LocalDateTime sendTime,
      final String source,
      final String state,
      final String surplusName,
      final String taskId,
      final String taskSendState,
      final BigDecimal thick,
      final String uploadName,
      final String cutInstructionId,
      final String cutTime,
      final String nestingReportName,
      final String nestingReportUrl,
      final String num,
      final String platePictureName,
      final String platePictureReportName,
      final String platePictureReportUrl,
      final String platePictureUrl,
      final String plateReportUrl,
      final BigDecimal width,
      final String machineName,
      final BigDecimal weight,
      final String sendState,
      final String plateAllReportUrl,
      final String dwgReportName,
      final String dwgReportUrl,
      final String boolHaveSurplus,
      final String materialId,
      final LocalDateTime endTime,
      final LocalDateTime startTime
   ) {
      this.id = id;
      this.allocateTime = allocateTime;
      this.cutTaskId = cutTaskId;
      this.figureUrl = figureUrl;
      this.furnaceNo = furnaceNo;
      this.importTime = importTime;
      this.length = length;
      this.mac = mac;
      this.material = material;
      this.monomer = monomer;
      this.ncName = ncName;
      this.ncUrl = ncUrl;
      this.plateNo = plateNo;
      this.plateState = plateState;
      this.plateType = plateType;
      this.projectName = projectName;
      this.projectNo = projectNo;
      this.region = region;
      this.sendTime = sendTime;
      this.source = source;
      this.state = state;
      this.surplusName = surplusName;
      this.taskId = taskId;
      this.taskSendState = taskSendState;
      this.thick = thick;
      this.uploadName = uploadName;
      this.cutInstructionId = cutInstructionId;
      this.cutTime = cutTime;
      this.nestingReportName = nestingReportName;
      this.nestingReportUrl = nestingReportUrl;
      this.num = num;
      this.platePictureName = platePictureName;
      this.platePictureReportName = platePictureReportName;
      this.platePictureReportUrl = platePictureReportUrl;
      this.platePictureUrl = platePictureUrl;
      this.plateReportUrl = plateReportUrl;
      this.width = width;
      this.machineName = machineName;
      this.weight = weight;
      this.sendState = sendState;
      this.plateAllReportUrl = plateAllReportUrl;
      this.dwgReportName = dwgReportName;
      this.dwgReportUrl = dwgReportUrl;
      this.boolHaveSurplus = boolHaveSurplus;
      this.materialId = materialId;
      this.endTime = endTime;
      this.startTime = startTime;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getAllocateTime() {
      return this.allocateTime;
   }

   public String getCutTaskId() {
      return this.cutTaskId;
   }

   public String getFigureUrl() {
      return this.figureUrl;
   }

   public String getFurnaceNo() {
      return this.furnaceNo;
   }

   public String getImportTime() {
      return this.importTime;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMac() {
      return this.mac;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getMonomer() {
      return this.monomer;
   }

   public String getNcName() {
      return this.ncName;
   }

   public String getNcUrl() {
      return this.ncUrl;
   }

   public String getPlateNo() {
      return this.plateNo;
   }

   public String getPlateState() {
      return this.plateState;
   }

   public String getPlateType() {
      return this.plateType;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectNo() {
      return this.projectNo;
   }

   public String getRegion() {
      return this.region;
   }

   public LocalDateTime getSendTime() {
      return this.sendTime;
   }

   public String getSource() {
      return this.source;
   }

   public String getState() {
      return this.state;
   }

   public String getSurplusName() {
      return this.surplusName;
   }

   public String getTaskId() {
      return this.taskId;
   }

   public String getTaskSendState() {
      return this.taskSendState;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public String getUploadName() {
      return this.uploadName;
   }

   public String getCutInstructionId() {
      return this.cutInstructionId;
   }

   public String getCutTime() {
      return this.cutTime;
   }

   public String getNestingReportName() {
      return this.nestingReportName;
   }

   public String getNestingReportUrl() {
      return this.nestingReportUrl;
   }

   public String getNum() {
      return this.num;
   }

   public String getPlatePictureName() {
      return this.platePictureName;
   }

   public String getPlatePictureReportName() {
      return this.platePictureReportName;
   }

   public String getPlatePictureReportUrl() {
      return this.platePictureReportUrl;
   }

   public String getPlatePictureUrl() {
      return this.platePictureUrl;
   }

   public String getPlateReportUrl() {
      return this.plateReportUrl;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getMachineName() {
      return this.machineName;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public String getSendState() {
      return this.sendState;
   }

   public String getPlateAllReportUrl() {
      return this.plateAllReportUrl;
   }

   public String getDwgReportName() {
      return this.dwgReportName;
   }

   public String getDwgReportUrl() {
      return this.dwgReportUrl;
   }

   public String getBoolHaveSurplus() {
      return this.boolHaveSurplus;
   }

   public String getMaterialId() {
      return this.materialId;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   @JsonProperty("id")
   public CutPlate setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("allocateTime")
   public CutPlate setAllocateTime(final LocalDateTime allocateTime) {
      this.allocateTime = allocateTime;
      return this;
   }

   @JsonProperty("cutTaskId")
   public CutPlate setCutTaskId(final String cutTaskId) {
      this.cutTaskId = cutTaskId;
      return this;
   }

   @JsonProperty("figureUrl")
   public CutPlate setFigureUrl(final String figureUrl) {
      this.figureUrl = figureUrl;
      return this;
   }

   @JsonProperty("furnaceNo")
   public CutPlate setFurnaceNo(final String furnaceNo) {
      this.furnaceNo = furnaceNo;
      return this;
   }

   @JsonProperty("importTime")
   public CutPlate setImportTime(final String importTime) {
      this.importTime = importTime;
      return this;
   }

   @JsonProperty("length")
   public CutPlate setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("mac")
   public CutPlate setMac(final String mac) {
      this.mac = mac;
      return this;
   }

   @JsonProperty("material")
   public CutPlate setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("monomer")
   public CutPlate setMonomer(final String monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("ncName")
   public CutPlate setNcName(final String ncName) {
      this.ncName = ncName;
      return this;
   }

   @JsonProperty("ncUrl")
   public CutPlate setNcUrl(final String ncUrl) {
      this.ncUrl = ncUrl;
      return this;
   }

   @JsonProperty("plateNo")
   public CutPlate setPlateNo(final String plateNo) {
      this.plateNo = plateNo;
      return this;
   }

   @JsonProperty("plateState")
   public CutPlate setPlateState(final String plateState) {
      this.plateState = plateState;
      return this;
   }

   @JsonProperty("plateType")
   public CutPlate setPlateType(final String plateType) {
      this.plateType = plateType;
      return this;
   }

   @JsonProperty("projectName")
   public CutPlate setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("projectNo")
   public CutPlate setProjectNo(final String projectNo) {
      this.projectNo = projectNo;
      return this;
   }

   @JsonProperty("region")
   public CutPlate setRegion(final String region) {
      this.region = region;
      return this;
   }

   @JsonProperty("sendTime")
   public CutPlate setSendTime(final LocalDateTime sendTime) {
      this.sendTime = sendTime;
      return this;
   }

   @JsonProperty("source")
   public CutPlate setSource(final String source) {
      this.source = source;
      return this;
   }

   @JsonProperty("state")
   public CutPlate setState(final String state) {
      this.state = state;
      return this;
   }

   @JsonProperty("surplusName")
   public CutPlate setSurplusName(final String surplusName) {
      this.surplusName = surplusName;
      return this;
   }

   @JsonProperty("taskId")
   public CutPlate setTaskId(final String taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskSendState")
   public CutPlate setTaskSendState(final String taskSendState) {
      this.taskSendState = taskSendState;
      return this;
   }

   @JsonProperty("thick")
   public CutPlate setThick(final BigDecimal thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("uploadName")
   public CutPlate setUploadName(final String uploadName) {
      this.uploadName = uploadName;
      return this;
   }

   @JsonProperty("cutInstructionId")
   public CutPlate setCutInstructionId(final String cutInstructionId) {
      this.cutInstructionId = cutInstructionId;
      return this;
   }

   @JsonProperty("cutTime")
   public CutPlate setCutTime(final String cutTime) {
      this.cutTime = cutTime;
      return this;
   }

   @JsonProperty("nestingReportName")
   public CutPlate setNestingReportName(final String nestingReportName) {
      this.nestingReportName = nestingReportName;
      return this;
   }

   @JsonProperty("nestingReportUrl")
   public CutPlate setNestingReportUrl(final String nestingReportUrl) {
      this.nestingReportUrl = nestingReportUrl;
      return this;
   }

   @JsonProperty("num")
   public CutPlate setNum(final String num) {
      this.num = num;
      return this;
   }

   @JsonProperty("platePictureName")
   public CutPlate setPlatePictureName(final String platePictureName) {
      this.platePictureName = platePictureName;
      return this;
   }

   @JsonProperty("platePictureReportName")
   public CutPlate setPlatePictureReportName(final String platePictureReportName) {
      this.platePictureReportName = platePictureReportName;
      return this;
   }

   @JsonProperty("platePictureReportUrl")
   public CutPlate setPlatePictureReportUrl(final String platePictureReportUrl) {
      this.platePictureReportUrl = platePictureReportUrl;
      return this;
   }

   @JsonProperty("platePictureUrl")
   public CutPlate setPlatePictureUrl(final String platePictureUrl) {
      this.platePictureUrl = platePictureUrl;
      return this;
   }

   @JsonProperty("plateReportUrl")
   public CutPlate setPlateReportUrl(final String plateReportUrl) {
      this.plateReportUrl = plateReportUrl;
      return this;
   }

   @JsonProperty("width")
   public CutPlate setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("machineName")
   public CutPlate setMachineName(final String machineName) {
      this.machineName = machineName;
      return this;
   }

   @JsonProperty("weight")
   public CutPlate setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("sendState")
   public CutPlate setSendState(final String sendState) {
      this.sendState = sendState;
      return this;
   }

   @JsonProperty("plateAllReportUrl")
   public CutPlate setPlateAllReportUrl(final String plateAllReportUrl) {
      this.plateAllReportUrl = plateAllReportUrl;
      return this;
   }

   @JsonProperty("dwgReportName")
   public CutPlate setDwgReportName(final String dwgReportName) {
      this.dwgReportName = dwgReportName;
      return this;
   }

   @JsonProperty("dwgReportUrl")
   public CutPlate setDwgReportUrl(final String dwgReportUrl) {
      this.dwgReportUrl = dwgReportUrl;
      return this;
   }

   @JsonProperty("boolHaveSurplus")
   public CutPlate setBoolHaveSurplus(final String boolHaveSurplus) {
      this.boolHaveSurplus = boolHaveSurplus;
      return this;
   }

   @JsonProperty("materialId")
   public CutPlate setMaterialId(final String materialId) {
      this.materialId = materialId;
      return this;
   }

   @JsonProperty("endTime")
   public CutPlate setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   @JsonProperty("startTime")
   public CutPlate setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   @Override
   public String toString() {
      return "CutPlate(id="
         + this.getId()
         + ", allocateTime="
         + this.getAllocateTime()
         + ", cutTaskId="
         + this.getCutTaskId()
         + ", figureUrl="
         + this.getFigureUrl()
         + ", furnaceNo="
         + this.getFurnaceNo()
         + ", importTime="
         + this.getImportTime()
         + ", length="
         + this.getLength()
         + ", mac="
         + this.getMac()
         + ", material="
         + this.getMaterial()
         + ", monomer="
         + this.getMonomer()
         + ", ncName="
         + this.getNcName()
         + ", ncUrl="
         + this.getNcUrl()
         + ", plateNo="
         + this.getPlateNo()
         + ", plateState="
         + this.getPlateState()
         + ", plateType="
         + this.getPlateType()
         + ", projectName="
         + this.getProjectName()
         + ", projectNo="
         + this.getProjectNo()
         + ", region="
         + this.getRegion()
         + ", sendTime="
         + this.getSendTime()
         + ", source="
         + this.getSource()
         + ", state="
         + this.getState()
         + ", surplusName="
         + this.getSurplusName()
         + ", taskId="
         + this.getTaskId()
         + ", taskSendState="
         + this.getTaskSendState()
         + ", thick="
         + this.getThick()
         + ", uploadName="
         + this.getUploadName()
         + ", cutInstructionId="
         + this.getCutInstructionId()
         + ", cutTime="
         + this.getCutTime()
         + ", nestingReportName="
         + this.getNestingReportName()
         + ", nestingReportUrl="
         + this.getNestingReportUrl()
         + ", num="
         + this.getNum()
         + ", platePictureName="
         + this.getPlatePictureName()
         + ", platePictureReportName="
         + this.getPlatePictureReportName()
         + ", platePictureReportUrl="
         + this.getPlatePictureReportUrl()
         + ", platePictureUrl="
         + this.getPlatePictureUrl()
         + ", plateReportUrl="
         + this.getPlateReportUrl()
         + ", width="
         + this.getWidth()
         + ", machineName="
         + this.getMachineName()
         + ", weight="
         + this.getWeight()
         + ", sendState="
         + this.getSendState()
         + ", plateAllReportUrl="
         + this.getPlateAllReportUrl()
         + ", dwgReportName="
         + this.getDwgReportName()
         + ", dwgReportUrl="
         + this.getDwgReportUrl()
         + ", boolHaveSurplus="
         + this.getBoolHaveSurplus()
         + ", materialId="
         + this.getMaterialId()
         + ", endTime="
         + this.getEndTime()
         + ", startTime="
         + this.getStartTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutPlate)) {
         return false;
      }

      CutPlate other = (CutPlate)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$allocateTime = this.getAllocateTime();
         Object other$allocateTime = other.getAllocateTime();
         if (this$allocateTime == null ? other$allocateTime == null : this$allocateTime.equals(other$allocateTime)) {
            Object this$cutTaskId = this.getCutTaskId();
            Object other$cutTaskId = other.getCutTaskId();
            if (this$cutTaskId == null ? other$cutTaskId == null : this$cutTaskId.equals(other$cutTaskId)) {
               Object this$figureUrl = this.getFigureUrl();
               Object other$figureUrl = other.getFigureUrl();
               if (this$figureUrl == null ? other$figureUrl == null : this$figureUrl.equals(other$figureUrl)) {
                  Object this$furnaceNo = this.getFurnaceNo();
                  Object other$furnaceNo = other.getFurnaceNo();
                  if (this$furnaceNo == null ? other$furnaceNo == null : this$furnaceNo.equals(other$furnaceNo)) {
                     Object this$importTime = this.getImportTime();
                     Object other$importTime = other.getImportTime();
                     if (this$importTime == null ? other$importTime == null : this$importTime.equals(other$importTime)) {
                        Object this$length = this.getLength();
                        Object other$length = other.getLength();
                        if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                           Object this$mac = this.getMac();
                           Object other$mac = other.getMac();
                           if (this$mac == null ? other$mac == null : this$mac.equals(other$mac)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$monomer = this.getMonomer();
                                 Object other$monomer = other.getMonomer();
                                 if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                    Object this$ncName = this.getNcName();
                                    Object other$ncName = other.getNcName();
                                    if (this$ncName == null ? other$ncName == null : this$ncName.equals(other$ncName)) {
                                       Object this$ncUrl = this.getNcUrl();
                                       Object other$ncUrl = other.getNcUrl();
                                       if (this$ncUrl == null ? other$ncUrl == null : this$ncUrl.equals(other$ncUrl)) {
                                          Object this$plateNo = this.getPlateNo();
                                          Object other$plateNo = other.getPlateNo();
                                          if (this$plateNo == null ? other$plateNo == null : this$plateNo.equals(other$plateNo)) {
                                             Object this$plateState = this.getPlateState();
                                             Object other$plateState = other.getPlateState();
                                             if (this$plateState == null ? other$plateState == null : this$plateState.equals(other$plateState)) {
                                                Object this$plateType = this.getPlateType();
                                                Object other$plateType = other.getPlateType();
                                                if (this$plateType == null ? other$plateType == null : this$plateType.equals(other$plateType)) {
                                                   Object this$projectName = this.getProjectName();
                                                   Object other$projectName = other.getProjectName();
                                                   if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                      Object this$projectNo = this.getProjectNo();
                                                      Object other$projectNo = other.getProjectNo();
                                                      if (this$projectNo == null ? other$projectNo == null : this$projectNo.equals(other$projectNo)) {
                                                         Object this$region = this.getRegion();
                                                         Object other$region = other.getRegion();
                                                         if (this$region == null ? other$region == null : this$region.equals(other$region)) {
                                                            Object this$sendTime = this.getSendTime();
                                                            Object other$sendTime = other.getSendTime();
                                                            if (this$sendTime == null ? other$sendTime == null : this$sendTime.equals(other$sendTime)) {
                                                               Object this$source = this.getSource();
                                                               Object other$source = other.getSource();
                                                               if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                                                                  Object this$state = this.getState();
                                                                  Object other$state = other.getState();
                                                                  if (this$state == null ? other$state == null : this$state.equals(other$state)) {
                                                                     Object this$surplusName = this.getSurplusName();
                                                                     Object other$surplusName = other.getSurplusName();
                                                                     if (this$surplusName == null
                                                                        ? other$surplusName == null
                                                                        : this$surplusName.equals(other$surplusName)) {
                                                                        Object this$taskId = this.getTaskId();
                                                                        Object other$taskId = other.getTaskId();
                                                                        if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                                                                           Object this$taskSendState = this.getTaskSendState();
                                                                           Object other$taskSendState = other.getTaskSendState();
                                                                           if (this$taskSendState == null
                                                                              ? other$taskSendState == null
                                                                              : this$taskSendState.equals(other$taskSendState)) {
                                                                              Object this$thick = this.getThick();
                                                                              Object other$thick = other.getThick();
                                                                              if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                                                 Object this$uploadName = this.getUploadName();
                                                                                 Object other$uploadName = other.getUploadName();
                                                                                 if (this$uploadName == null
                                                                                    ? other$uploadName == null
                                                                                    : this$uploadName.equals(other$uploadName)) {
                                                                                    Object this$cutInstructionId = this.getCutInstructionId();
                                                                                    Object other$cutInstructionId = other.getCutInstructionId();
                                                                                    if (this$cutInstructionId == null
                                                                                       ? other$cutInstructionId == null
                                                                                       : this$cutInstructionId.equals(other$cutInstructionId)) {
                                                                                       Object this$cutTime = this.getCutTime();
                                                                                       Object other$cutTime = other.getCutTime();
                                                                                       if (this$cutTime == null
                                                                                          ? other$cutTime == null
                                                                                          : this$cutTime.equals(other$cutTime)) {
                                                                                          Object this$nestingReportName = this.getNestingReportName();
                                                                                          Object other$nestingReportName = other.getNestingReportName();
                                                                                          if (this$nestingReportName == null
                                                                                             ? other$nestingReportName == null
                                                                                             : this$nestingReportName.equals(other$nestingReportName)) {
                                                                                             Object this$nestingReportUrl = this.getNestingReportUrl();
                                                                                             Object other$nestingReportUrl = other.getNestingReportUrl();
                                                                                             if (this$nestingReportUrl == null
                                                                                                ? other$nestingReportUrl == null
                                                                                                : this$nestingReportUrl.equals(other$nestingReportUrl)) {
                                                                                                Object this$num = this.getNum();
                                                                                                Object other$num = other.getNum();
                                                                                                if (this$num == null
                                                                                                   ? other$num == null
                                                                                                   : this$num.equals(other$num)) {
                                                                                                   Object this$platePictureName = this.getPlatePictureName();
                                                                                                   Object other$platePictureName = other.getPlatePictureName();
                                                                                                   if (this$platePictureName == null
                                                                                                      ? other$platePictureName == null
                                                                                                      : this$platePictureName.equals(other$platePictureName)) {
                                                                                                      Object this$platePictureReportName = this.getPlatePictureReportName();
                                                                                                      Object other$platePictureReportName = other.getPlatePictureReportName();
                                                                                                      if (this$platePictureReportName == null
                                                                                                         ? other$platePictureReportName == null
                                                                                                         : this$platePictureReportName.equals(
                                                                                                            other$platePictureReportName
                                                                                                         )) {
                                                                                                         Object this$platePictureReportUrl = this.getPlatePictureReportUrl();
                                                                                                         Object other$platePictureReportUrl = other.getPlatePictureReportUrl();
                                                                                                         if (this$platePictureReportUrl == null
                                                                                                            ? other$platePictureReportUrl == null
                                                                                                            : this$platePictureReportUrl.equals(
                                                                                                               other$platePictureReportUrl
                                                                                                            )) {
                                                                                                            Object this$platePictureUrl = this.getPlatePictureUrl();
                                                                                                            Object other$platePictureUrl = other.getPlatePictureUrl();
                                                                                                            if (this$platePictureUrl == null
                                                                                                               ? other$platePictureUrl == null
                                                                                                               : this$platePictureUrl.equals(
                                                                                                                  other$platePictureUrl
                                                                                                               )) {
                                                                                                               Object this$plateReportUrl = this.getPlateReportUrl();
                                                                                                               Object other$plateReportUrl = other.getPlateReportUrl();
                                                                                                               if (this$plateReportUrl == null
                                                                                                                  ? other$plateReportUrl == null
                                                                                                                  : this$plateReportUrl.equals(
                                                                                                                     other$plateReportUrl
                                                                                                                  )) {
                                                                                                                  Object this$width = this.getWidth();
                                                                                                                  Object other$width = other.getWidth();
                                                                                                                  if (this$width == null
                                                                                                                     ? other$width == null
                                                                                                                     : this$width.equals(other$width)) {
                                                                                                                     Object this$machineName = this.getMachineName();
                                                                                                                     Object other$machineName = other.getMachineName();
                                                                                                                     if (this$machineName == null
                                                                                                                        ? other$machineName == null
                                                                                                                        : this$machineName.equals(
                                                                                                                           other$machineName
                                                                                                                        )) {
                                                                                                                        Object this$weight = this.getWeight();
                                                                                                                        Object other$weight = other.getWeight();
                                                                                                                        if (this$weight == null
                                                                                                                           ? other$weight == null
                                                                                                                           : this$weight.equals(other$weight)) {
                                                                                                                           Object this$sendState = this.getSendState();
                                                                                                                           Object other$sendState = other.getSendState();
                                                                                                                           if (this$sendState == null
                                                                                                                              ? other$sendState == null
                                                                                                                              : this$sendState.equals(
                                                                                                                                 other$sendState
                                                                                                                              )) {
                                                                                                                              Object this$plateAllReportUrl = this.getPlateAllReportUrl();
                                                                                                                              Object other$plateAllReportUrl = other.getPlateAllReportUrl();
                                                                                                                              if (this$plateAllReportUrl
                                                                                                                                    == null
                                                                                                                                 ? other$plateAllReportUrl
                                                                                                                                    == null
                                                                                                                                 : this$plateAllReportUrl.equals(
                                                                                                                                    other$plateAllReportUrl
                                                                                                                                 )) {
                                                                                                                                 Object this$dwgReportName = this.getDwgReportName();
                                                                                                                                 Object other$dwgReportName = other.getDwgReportName();
                                                                                                                                 if (this$dwgReportName == null
                                                                                                                                    ? other$dwgReportName
                                                                                                                                       == null
                                                                                                                                    : this$dwgReportName.equals(
                                                                                                                                       other$dwgReportName
                                                                                                                                    )) {
                                                                                                                                    Object this$dwgReportUrl = this.getDwgReportUrl();
                                                                                                                                    Object other$dwgReportUrl = other.getDwgReportUrl();
                                                                                                                                    if (this$dwgReportUrl
                                                                                                                                          == null
                                                                                                                                       ? other$dwgReportUrl
                                                                                                                                          == null
                                                                                                                                       : this$dwgReportUrl.equals(
                                                                                                                                          other$dwgReportUrl
                                                                                                                                       )) {
                                                                                                                                       Object this$boolHaveSurplus = this.getBoolHaveSurplus();
                                                                                                                                       Object other$boolHaveSurplus = other.getBoolHaveSurplus();
                                                                                                                                       if (this$boolHaveSurplus
                                                                                                                                             == null
                                                                                                                                          ? other$boolHaveSurplus
                                                                                                                                             == null
                                                                                                                                          : this$boolHaveSurplus.equals(
                                                                                                                                             other$boolHaveSurplus
                                                                                                                                          )) {
                                                                                                                                          Object this$materialId = this.getMaterialId();
                                                                                                                                          Object other$materialId = other.getMaterialId();
                                                                                                                                          if (this$materialId
                                                                                                                                                == null
                                                                                                                                             ? other$materialId
                                                                                                                                                == null
                                                                                                                                             : this$materialId.equals(
                                                                                                                                                other$materialId
                                                                                                                                             )) {
                                                                                                                                             Object this$endTime = this.getEndTime();
                                                                                                                                             Object other$endTime = other.getEndTime();
                                                                                                                                             if (this$endTime
                                                                                                                                                   == null
                                                                                                                                                ? other$endTime
                                                                                                                                                   == null
                                                                                                                                                : this$endTime.equals(
                                                                                                                                                   other$endTime
                                                                                                                                                )) {
                                                                                                                                                Object this$startTime = this.getStartTime();
                                                                                                                                                Object other$startTime = other.getStartTime();
                                                                                                                                                return this$startTime
                                                                                                                                                      == null
                                                                                                                                                   ? other$startTime
                                                                                                                                                      == null
                                                                                                                                                   : this$startTime.equals(
                                                                                                                                                      other$startTime
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CutPlate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $allocateTime = this.getAllocateTime();
      result = result * 59 + ($allocateTime == null ? 43 : $allocateTime.hashCode());
      Object $cutTaskId = this.getCutTaskId();
      result = result * 59 + ($cutTaskId == null ? 43 : $cutTaskId.hashCode());
      Object $figureUrl = this.getFigureUrl();
      result = result * 59 + ($figureUrl == null ? 43 : $figureUrl.hashCode());
      Object $furnaceNo = this.getFurnaceNo();
      result = result * 59 + ($furnaceNo == null ? 43 : $furnaceNo.hashCode());
      Object $importTime = this.getImportTime();
      result = result * 59 + ($importTime == null ? 43 : $importTime.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $mac = this.getMac();
      result = result * 59 + ($mac == null ? 43 : $mac.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $ncName = this.getNcName();
      result = result * 59 + ($ncName == null ? 43 : $ncName.hashCode());
      Object $ncUrl = this.getNcUrl();
      result = result * 59 + ($ncUrl == null ? 43 : $ncUrl.hashCode());
      Object $plateNo = this.getPlateNo();
      result = result * 59 + ($plateNo == null ? 43 : $plateNo.hashCode());
      Object $plateState = this.getPlateState();
      result = result * 59 + ($plateState == null ? 43 : $plateState.hashCode());
      Object $plateType = this.getPlateType();
      result = result * 59 + ($plateType == null ? 43 : $plateType.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectNo = this.getProjectNo();
      result = result * 59 + ($projectNo == null ? 43 : $projectNo.hashCode());
      Object $region = this.getRegion();
      result = result * 59 + ($region == null ? 43 : $region.hashCode());
      Object $sendTime = this.getSendTime();
      result = result * 59 + ($sendTime == null ? 43 : $sendTime.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $state = this.getState();
      result = result * 59 + ($state == null ? 43 : $state.hashCode());
      Object $surplusName = this.getSurplusName();
      result = result * 59 + ($surplusName == null ? 43 : $surplusName.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskSendState = this.getTaskSendState();
      result = result * 59 + ($taskSendState == null ? 43 : $taskSendState.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $uploadName = this.getUploadName();
      result = result * 59 + ($uploadName == null ? 43 : $uploadName.hashCode());
      Object $cutInstructionId = this.getCutInstructionId();
      result = result * 59 + ($cutInstructionId == null ? 43 : $cutInstructionId.hashCode());
      Object $cutTime = this.getCutTime();
      result = result * 59 + ($cutTime == null ? 43 : $cutTime.hashCode());
      Object $nestingReportName = this.getNestingReportName();
      result = result * 59 + ($nestingReportName == null ? 43 : $nestingReportName.hashCode());
      Object $nestingReportUrl = this.getNestingReportUrl();
      result = result * 59 + ($nestingReportUrl == null ? 43 : $nestingReportUrl.hashCode());
      Object $num = this.getNum();
      result = result * 59 + ($num == null ? 43 : $num.hashCode());
      Object $platePictureName = this.getPlatePictureName();
      result = result * 59 + ($platePictureName == null ? 43 : $platePictureName.hashCode());
      Object $platePictureReportName = this.getPlatePictureReportName();
      result = result * 59 + ($platePictureReportName == null ? 43 : $platePictureReportName.hashCode());
      Object $platePictureReportUrl = this.getPlatePictureReportUrl();
      result = result * 59 + ($platePictureReportUrl == null ? 43 : $platePictureReportUrl.hashCode());
      Object $platePictureUrl = this.getPlatePictureUrl();
      result = result * 59 + ($platePictureUrl == null ? 43 : $platePictureUrl.hashCode());
      Object $plateReportUrl = this.getPlateReportUrl();
      result = result * 59 + ($plateReportUrl == null ? 43 : $plateReportUrl.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $machineName = this.getMachineName();
      result = result * 59 + ($machineName == null ? 43 : $machineName.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $sendState = this.getSendState();
      result = result * 59 + ($sendState == null ? 43 : $sendState.hashCode());
      Object $plateAllReportUrl = this.getPlateAllReportUrl();
      result = result * 59 + ($plateAllReportUrl == null ? 43 : $plateAllReportUrl.hashCode());
      Object $dwgReportName = this.getDwgReportName();
      result = result * 59 + ($dwgReportName == null ? 43 : $dwgReportName.hashCode());
      Object $dwgReportUrl = this.getDwgReportUrl();
      result = result * 59 + ($dwgReportUrl == null ? 43 : $dwgReportUrl.hashCode());
      Object $boolHaveSurplus = this.getBoolHaveSurplus();
      result = result * 59 + ($boolHaveSurplus == null ? 43 : $boolHaveSurplus.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $startTime = this.getStartTime();
      return result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
   }

   public static class CutPlateBuilder {
      private Long id;
      private LocalDateTime allocateTime;
      private String cutTaskId;
      private String figureUrl;
      private String furnaceNo;
      private String importTime;
      private BigDecimal length;
      private String mac;
      private String material;
      private String monomer;
      private String ncName;
      private String ncUrl;
      private String plateNo;
      private String plateState;
      private String plateType;
      private String projectName;
      private String projectNo;
      private String region;
      private LocalDateTime sendTime;
      private String source;
      private String state;
      private String surplusName;
      private String taskId;
      private String taskSendState;
      private BigDecimal thick;
      private String uploadName;
      private String cutInstructionId;
      private String cutTime;
      private String nestingReportName;
      private String nestingReportUrl;
      private String num;
      private String platePictureName;
      private String platePictureReportName;
      private String platePictureReportUrl;
      private String platePictureUrl;
      private String plateReportUrl;
      private BigDecimal width;
      private String machineName;
      private BigDecimal weight;
      private String sendState;
      private String plateAllReportUrl;
      private String dwgReportName;
      private String dwgReportUrl;
      private String boolHaveSurplus;
      private String materialId;
      private LocalDateTime endTime;
      private LocalDateTime startTime;

      CutPlateBuilder() {
      }

      @JsonProperty("id")
      public CutPlate.CutPlateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("allocateTime")
      public CutPlate.CutPlateBuilder allocateTime(final LocalDateTime allocateTime) {
         this.allocateTime = allocateTime;
         return this;
      }

      @JsonProperty("cutTaskId")
      public CutPlate.CutPlateBuilder cutTaskId(final String cutTaskId) {
         this.cutTaskId = cutTaskId;
         return this;
      }

      @JsonProperty("figureUrl")
      public CutPlate.CutPlateBuilder figureUrl(final String figureUrl) {
         this.figureUrl = figureUrl;
         return this;
      }

      @JsonProperty("furnaceNo")
      public CutPlate.CutPlateBuilder furnaceNo(final String furnaceNo) {
         this.furnaceNo = furnaceNo;
         return this;
      }

      @JsonProperty("importTime")
      public CutPlate.CutPlateBuilder importTime(final String importTime) {
         this.importTime = importTime;
         return this;
      }

      @JsonProperty("length")
      public CutPlate.CutPlateBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("mac")
      public CutPlate.CutPlateBuilder mac(final String mac) {
         this.mac = mac;
         return this;
      }

      @JsonProperty("material")
      public CutPlate.CutPlateBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("monomer")
      public CutPlate.CutPlateBuilder monomer(final String monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("ncName")
      public CutPlate.CutPlateBuilder ncName(final String ncName) {
         this.ncName = ncName;
         return this;
      }

      @JsonProperty("ncUrl")
      public CutPlate.CutPlateBuilder ncUrl(final String ncUrl) {
         this.ncUrl = ncUrl;
         return this;
      }

      @JsonProperty("plateNo")
      public CutPlate.CutPlateBuilder plateNo(final String plateNo) {
         this.plateNo = plateNo;
         return this;
      }

      @JsonProperty("plateState")
      public CutPlate.CutPlateBuilder plateState(final String plateState) {
         this.plateState = plateState;
         return this;
      }

      @JsonProperty("plateType")
      public CutPlate.CutPlateBuilder plateType(final String plateType) {
         this.plateType = plateType;
         return this;
      }

      @JsonProperty("projectName")
      public CutPlate.CutPlateBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("projectNo")
      public CutPlate.CutPlateBuilder projectNo(final String projectNo) {
         this.projectNo = projectNo;
         return this;
      }

      @JsonProperty("region")
      public CutPlate.CutPlateBuilder region(final String region) {
         this.region = region;
         return this;
      }

      @JsonProperty("sendTime")
      public CutPlate.CutPlateBuilder sendTime(final LocalDateTime sendTime) {
         this.sendTime = sendTime;
         return this;
      }

      @JsonProperty("source")
      public CutPlate.CutPlateBuilder source(final String source) {
         this.source = source;
         return this;
      }

      @JsonProperty("state")
      public CutPlate.CutPlateBuilder state(final String state) {
         this.state = state;
         return this;
      }

      @JsonProperty("surplusName")
      public CutPlate.CutPlateBuilder surplusName(final String surplusName) {
         this.surplusName = surplusName;
         return this;
      }

      @JsonProperty("taskId")
      public CutPlate.CutPlateBuilder taskId(final String taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskSendState")
      public CutPlate.CutPlateBuilder taskSendState(final String taskSendState) {
         this.taskSendState = taskSendState;
         return this;
      }

      @JsonProperty("thick")
      public CutPlate.CutPlateBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("uploadName")
      public CutPlate.CutPlateBuilder uploadName(final String uploadName) {
         this.uploadName = uploadName;
         return this;
      }

      @JsonProperty("cutInstructionId")
      public CutPlate.CutPlateBuilder cutInstructionId(final String cutInstructionId) {
         this.cutInstructionId = cutInstructionId;
         return this;
      }

      @JsonProperty("cutTime")
      public CutPlate.CutPlateBuilder cutTime(final String cutTime) {
         this.cutTime = cutTime;
         return this;
      }

      @JsonProperty("nestingReportName")
      public CutPlate.CutPlateBuilder nestingReportName(final String nestingReportName) {
         this.nestingReportName = nestingReportName;
         return this;
      }

      @JsonProperty("nestingReportUrl")
      public CutPlate.CutPlateBuilder nestingReportUrl(final String nestingReportUrl) {
         this.nestingReportUrl = nestingReportUrl;
         return this;
      }

      @JsonProperty("num")
      public CutPlate.CutPlateBuilder num(final String num) {
         this.num = num;
         return this;
      }

      @JsonProperty("platePictureName")
      public CutPlate.CutPlateBuilder platePictureName(final String platePictureName) {
         this.platePictureName = platePictureName;
         return this;
      }

      @JsonProperty("platePictureReportName")
      public CutPlate.CutPlateBuilder platePictureReportName(final String platePictureReportName) {
         this.platePictureReportName = platePictureReportName;
         return this;
      }

      @JsonProperty("platePictureReportUrl")
      public CutPlate.CutPlateBuilder platePictureReportUrl(final String platePictureReportUrl) {
         this.platePictureReportUrl = platePictureReportUrl;
         return this;
      }

      @JsonProperty("platePictureUrl")
      public CutPlate.CutPlateBuilder platePictureUrl(final String platePictureUrl) {
         this.platePictureUrl = platePictureUrl;
         return this;
      }

      @JsonProperty("plateReportUrl")
      public CutPlate.CutPlateBuilder plateReportUrl(final String plateReportUrl) {
         this.plateReportUrl = plateReportUrl;
         return this;
      }

      @JsonProperty("width")
      public CutPlate.CutPlateBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("machineName")
      public CutPlate.CutPlateBuilder machineName(final String machineName) {
         this.machineName = machineName;
         return this;
      }

      @JsonProperty("weight")
      public CutPlate.CutPlateBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("sendState")
      public CutPlate.CutPlateBuilder sendState(final String sendState) {
         this.sendState = sendState;
         return this;
      }

      @JsonProperty("plateAllReportUrl")
      public CutPlate.CutPlateBuilder plateAllReportUrl(final String plateAllReportUrl) {
         this.plateAllReportUrl = plateAllReportUrl;
         return this;
      }

      @JsonProperty("dwgReportName")
      public CutPlate.CutPlateBuilder dwgReportName(final String dwgReportName) {
         this.dwgReportName = dwgReportName;
         return this;
      }

      @JsonProperty("dwgReportUrl")
      public CutPlate.CutPlateBuilder dwgReportUrl(final String dwgReportUrl) {
         this.dwgReportUrl = dwgReportUrl;
         return this;
      }

      @JsonProperty("boolHaveSurplus")
      public CutPlate.CutPlateBuilder boolHaveSurplus(final String boolHaveSurplus) {
         this.boolHaveSurplus = boolHaveSurplus;
         return this;
      }

      @JsonProperty("materialId")
      public CutPlate.CutPlateBuilder materialId(final String materialId) {
         this.materialId = materialId;
         return this;
      }

      @JsonProperty("endTime")
      public CutPlate.CutPlateBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      @JsonProperty("startTime")
      public CutPlate.CutPlateBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public CutPlate build() {
         return new CutPlate(
            this.id,
            this.allocateTime,
            this.cutTaskId,
            this.figureUrl,
            this.furnaceNo,
            this.importTime,
            this.length,
            this.mac,
            this.material,
            this.monomer,
            this.ncName,
            this.ncUrl,
            this.plateNo,
            this.plateState,
            this.plateType,
            this.projectName,
            this.projectNo,
            this.region,
            this.sendTime,
            this.source,
            this.state,
            this.surplusName,
            this.taskId,
            this.taskSendState,
            this.thick,
            this.uploadName,
            this.cutInstructionId,
            this.cutTime,
            this.nestingReportName,
            this.nestingReportUrl,
            this.num,
            this.platePictureName,
            this.platePictureReportName,
            this.platePictureReportUrl,
            this.platePictureUrl,
            this.plateReportUrl,
            this.width,
            this.machineName,
            this.weight,
            this.sendState,
            this.plateAllReportUrl,
            this.dwgReportName,
            this.dwgReportUrl,
            this.boolHaveSurplus,
            this.materialId,
            this.endTime,
            this.startTime
         );
      }

      @Override
      public String toString() {
         return "CutPlate.CutPlateBuilder(id="
            + this.id
            + ", allocateTime="
            + this.allocateTime
            + ", cutTaskId="
            + this.cutTaskId
            + ", figureUrl="
            + this.figureUrl
            + ", furnaceNo="
            + this.furnaceNo
            + ", importTime="
            + this.importTime
            + ", length="
            + this.length
            + ", mac="
            + this.mac
            + ", material="
            + this.material
            + ", monomer="
            + this.monomer
            + ", ncName="
            + this.ncName
            + ", ncUrl="
            + this.ncUrl
            + ", plateNo="
            + this.plateNo
            + ", plateState="
            + this.plateState
            + ", plateType="
            + this.plateType
            + ", projectName="
            + this.projectName
            + ", projectNo="
            + this.projectNo
            + ", region="
            + this.region
            + ", sendTime="
            + this.sendTime
            + ", source="
            + this.source
            + ", state="
            + this.state
            + ", surplusName="
            + this.surplusName
            + ", taskId="
            + this.taskId
            + ", taskSendState="
            + this.taskSendState
            + ", thick="
            + this.thick
            + ", uploadName="
            + this.uploadName
            + ", cutInstructionId="
            + this.cutInstructionId
            + ", cutTime="
            + this.cutTime
            + ", nestingReportName="
            + this.nestingReportName
            + ", nestingReportUrl="
            + this.nestingReportUrl
            + ", num="
            + this.num
            + ", platePictureName="
            + this.platePictureName
            + ", platePictureReportName="
            + this.platePictureReportName
            + ", platePictureReportUrl="
            + this.platePictureReportUrl
            + ", platePictureUrl="
            + this.platePictureUrl
            + ", plateReportUrl="
            + this.plateReportUrl
            + ", width="
            + this.width
            + ", machineName="
            + this.machineName
            + ", weight="
            + this.weight
            + ", sendState="
            + this.sendState
            + ", plateAllReportUrl="
            + this.plateAllReportUrl
            + ", dwgReportName="
            + this.dwgReportName
            + ", dwgReportUrl="
            + this.dwgReportUrl
            + ", boolHaveSurplus="
            + this.boolHaveSurplus
            + ", materialId="
            + this.materialId
            + ", endTime="
            + this.endTime
            + ", startTime="
            + this.startTime
            + ")";
      }
   }
}
