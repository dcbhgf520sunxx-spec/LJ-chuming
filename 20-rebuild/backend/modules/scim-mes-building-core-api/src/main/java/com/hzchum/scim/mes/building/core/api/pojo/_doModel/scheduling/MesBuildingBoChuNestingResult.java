package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingBoChuNestingResult对象", description = "柏楚作业下的排版列表")
@Entity
@TableName("mes_building_bo_chu_nesting_result")
@Table(name = "mes_building_bo_chu_nesting_result", indexes = @Index(name = "index_file_name", unique = true, columnList = "file_name"))
public class MesBuildingBoChuNestingResult extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "jobId")
   @JsonProperty("jobId")
   @JSONField(name = "jobId")
   @TableField("job_id")
   @Column(name = "job_id", columnDefinition = "int(11)  COMMENT 'jobid'", nullable = false)
   private Integer jobId;
   @ApiModelProperty(name = "realJobId")
   @JsonProperty("realJobId")
   @JSONField(name = "realJobId")
   @TableField("real_job_id")
   @Column(name = "real_job_id", columnDefinition = "int(11)  COMMENT 'realJobId'", nullable = false)
   private Integer realJobId;
   @ApiModelProperty(name = "guid")
   @JsonProperty("guid")
   @JSONField(name = "guid")
   @TableField("guid")
   @Column(name = "guid", columnDefinition = "varchar(255)  COMMENT '排版唯一标识符'", nullable = false)
   private String guid;
   @ApiModelProperty(name = "resultName")
   @JsonProperty("resultName")
   @JSONField(name = "resultName")
   @TableField("result_name")
   @Column(name = "result_name", columnDefinition = "varchar(255)  COMMENT '排版结果名称'", nullable = false)
   private String resultName;
   @ApiModelProperty(name = "material")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '材质'", nullable = false)
   private String material;
   @ApiModelProperty(name = "thickness")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '厚度'", nullable = false)
   private BigDecimal thickness;
   @ApiModelProperty(name = "gas")
   @JsonProperty("gas")
   @JSONField(name = "gas")
   @TableField("gas")
   @Column(name = "gas", columnDefinition = "varchar(255)  COMMENT '气体'", nullable = false)
   private String gas;
   @ApiModelProperty(name = "amount")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8)  COMMENT '计划切割数量'", nullable = false)
   private BigDecimal amount;
   @ApiModelProperty(name = "utilization")
   @JsonProperty("utilization")
   @JSONField(name = "utilization")
   @TableField("utilization")
   @Column(name = "utilization", columnDefinition = "decimal(32,8)  COMMENT '利用率'", nullable = false)
   private BigDecimal utilization;
   @ApiModelProperty(name = "partAmount")
   @JsonProperty("partAmount")
   @JSONField(name = "partAmount")
   @TableField("part_amount")
   @Column(name = "part_amount", columnDefinition = "decimal(32,8)  COMMENT '零件总数量'", nullable = false)
   private BigDecimal partAmount;
   @ApiModelProperty(name = "plateHeight")
   @JsonProperty("plateHeight")
   @TableField("plate_height")
   @Column(name = "plate_height", columnDefinition = "decimal(32,8)  COMMENT '排版尺寸长度'", nullable = false)
   private BigDecimal plateHeight;
   @ApiModelProperty(name = "plateWidth")
   @JsonProperty("plateWidth")
   @TableField("plate_width")
   @Column(name = "plate_width", columnDefinition = "decimal(32,8)  COMMENT '排版尺寸宽度'", nullable = false)
   private BigDecimal plateWidth;
   @ApiModelProperty(name = "nspfUrl")
   @JsonProperty("nspfUrl")
   @TableField("nspf_url")
   @Column(name = "nspf_url", columnDefinition = "varchar(1000)  COMMENT 'nspf下载地址'", nullable = false)
   private String nspfUrl;
   @ApiModelProperty(name = "nspfPath")
   @JsonProperty("nspfPath")
   @TableField("nspf_path")
   @Column(name = "nspf_path", columnDefinition = "varchar(1000)  COMMENT 'nspf下载地址'", nullable = false)
   private String nspfPath;
   @ApiModelProperty(name = "thumbnailUrl")
   @JsonProperty("thumbnailUrl")
   @TableField("thumbnail_url")
   @Column(name = "thumbnail_url", columnDefinition = "varchar(1000)  COMMENT '缩略图下载地址'", nullable = false)
   private String thumbnailUrl;
   @ApiModelProperty(name = "thumbnailPath")
   @JsonProperty("thumbnailPath")
   @TableField("thumbnail_path")
   @Column(name = "thumbnail_path", columnDefinition = "varchar(1000)  COMMENT '缩略图下载地址'", nullable = false)
   private String thumbnailPath;
   @ApiModelProperty(name = "plateGuid")
   @JsonProperty("plateGuid")
   @TableField("plate_guid")
   @Column(name = "plate_guid", columnDefinition = "varchar(255)  COMMENT '使用板材的guid'", nullable = false)
   private String plateGuid;
   @ApiModelProperty(name = "plateName")
   @JsonProperty("plateName")
   @TableField("plate_name")
   @Column(name = "plate_name", columnDefinition = "varchar(255)  COMMENT '使用板材名称'", nullable = true)
   private String plateName;
   @ApiModelProperty(name = "cutSendStatus")
   @JsonProperty("cutSendStatus")
   @TableField("cut_send_status")
   @Column(name = "cut_send_status", columnDefinition = "int(11)  COMMENT '下发状态'", nullable = false)
   private Integer cutSendStatus;
   @ApiModelProperty(name = "cutSendTime")
   @JsonProperty("cutSendTime")
   @TableField("cut_send_time")
   @Column(name = "cut_send_time", columnDefinition = "datetime  COMMENT '下发时间'", nullable = true)
   private LocalDateTime cutSendTime;
   @ApiModelProperty(name = "cutSendUserId")
   @JsonProperty("cutSendUserId")
   @TableField("cut_send_user_id")
   @Column(name = "cut_send_user_id", columnDefinition = "varchar(255)  COMMENT '下发人id'", nullable = true)
   private Long cutSendUserId;
   @ApiModelProperty(name = "cutSendUserName")
   @JsonProperty("cutSendUserName")
   @TableField("cut_send_user_name")
   @Column(name = "cut_send_user_name", columnDefinition = "varchar(255)  COMMENT '下发人姓名'", nullable = true)
   private String cutSendUserName;
   @ApiModelProperty(name = "cutStatus")
   @JsonProperty("cutStatus")
   @TableField("cut_status")
   @Column(name = "cut_status", columnDefinition = "int(11)  COMMENT '切割任务状态'", nullable = false)
   private Integer cutStatus;
   @ApiModelProperty(name = "machineToolId")
   @JsonProperty("machineToolId")
   @TableField("machine_tool_id")
   @Column(name = "machine_tool_id", columnDefinition = "varchar(255)  COMMENT '机床ID'", nullable = true)
   private Long machineToolId;
   @ApiModelProperty(name = "taskRate")
   @JsonProperty("taskRate")
   @TableField("task_rate")
   @Column(name = "task_rate", columnDefinition = "decimal(32,8)  COMMENT '进度'", nullable = true)
   private BigDecimal taskRate;
   @ApiModelProperty(name = "childGuid", value = "柏楚子guid", notes = "柏楚子guid")
   @JsonProperty("childGuid")
   @JSONField(name = "childGuid")
   @TableField("child_guid")
   @Column(name = "child_guid", columnDefinition = "varchar(50) comment '柏楚子guid'", nullable = true, unique = true)
   private String childGuid;
   @ApiModelProperty(name = "childOrderNumber")
   @JsonProperty("childOrderNumber")
   @TableField("child_order_number")
   @Column(name = "child_order_number", columnDefinition = "varchar(255)  COMMENT '工单任务号'", nullable = true)
   private String childOrderNumber;
   @ApiModelProperty(name = "nestUserId")
   @JsonProperty("nestUserId")
   @TableField("nest_user_id")
   @Column(name = "nest_user_id", columnDefinition = "varchar(255)  COMMENT '套料人'", nullable = true)
   private String nestUserId;
   @ApiModelProperty(name = "fileName")
   @JsonProperty("fileName")
   @TableField("file_name")
   @Column(name = "file_name", columnDefinition = "varchar(255)  COMMENT '下发物联切割文件名'", nullable = true)
   private String fileName;
   @ApiModelProperty(name = "fileNameNest")
   @JsonProperty("fileNameNest")
   @TableField("file_name_nest")
   @Column(name = "file_name_nest", columnDefinition = "varchar(255)  COMMENT '柏楚套料切割文件名'", nullable = true)
   private String fileNameNest;
   @ApiModelProperty("混套jobIds")
   @TableField("mixed_job_ids")
   @Column(name = "mixed_job_ids", columnDefinition = "text COMMENT '混套jobIds'", nullable = true)
   private String mixedJobIds;
   @ApiModelProperty("物料使用类型(1:物料仓物料, 2:本地物料)")
   @TableField("inventory_gain_type")
   @Column(name = "inventory_gain_type", columnDefinition = "int(11) default 1 COMMENT '物料使用类型(1:物料仓物料, 2:本地物料)'", nullable = true)
   private Integer inventoryGainType;

   public static MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder builder() {
      return new MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder();
   }

   public MesBuildingBoChuNestingResult() {
   }

   public MesBuildingBoChuNestingResult(
      final Long id,
      final Integer jobId,
      final Integer realJobId,
      final String guid,
      final String resultName,
      final String material,
      final BigDecimal thickness,
      final String gas,
      final BigDecimal amount,
      final BigDecimal utilization,
      final BigDecimal partAmount,
      final BigDecimal plateHeight,
      final BigDecimal plateWidth,
      final String nspfUrl,
      final String nspfPath,
      final String thumbnailUrl,
      final String thumbnailPath,
      final String plateGuid,
      final String plateName,
      final Integer cutSendStatus,
      final LocalDateTime cutSendTime,
      final Long cutSendUserId,
      final String cutSendUserName,
      final Integer cutStatus,
      final Long machineToolId,
      final BigDecimal taskRate,
      final String childGuid,
      final String childOrderNumber,
      final String nestUserId,
      final String fileName,
      final String fileNameNest,
      final String mixedJobIds,
      final Integer inventoryGainType
   ) {
      this.id = id;
      this.jobId = jobId;
      this.realJobId = realJobId;
      this.guid = guid;
      this.resultName = resultName;
      this.material = material;
      this.thickness = thickness;
      this.gas = gas;
      this.amount = amount;
      this.utilization = utilization;
      this.partAmount = partAmount;
      this.plateHeight = plateHeight;
      this.plateWidth = plateWidth;
      this.nspfUrl = nspfUrl;
      this.nspfPath = nspfPath;
      this.thumbnailUrl = thumbnailUrl;
      this.thumbnailPath = thumbnailPath;
      this.plateGuid = plateGuid;
      this.plateName = plateName;
      this.cutSendStatus = cutSendStatus;
      this.cutSendTime = cutSendTime;
      this.cutSendUserId = cutSendUserId;
      this.cutSendUserName = cutSendUserName;
      this.cutStatus = cutStatus;
      this.machineToolId = machineToolId;
      this.taskRate = taskRate;
      this.childGuid = childGuid;
      this.childOrderNumber = childOrderNumber;
      this.nestUserId = nestUserId;
      this.fileName = fileName;
      this.fileNameNest = fileNameNest;
      this.mixedJobIds = mixedJobIds;
      this.inventoryGainType = inventoryGainType;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public Integer getRealJobId() {
      return this.realJobId;
   }

   public String getGuid() {
      return this.guid;
   }

   public String getResultName() {
      return this.resultName;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getGas() {
      return this.gas;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getUtilization() {
      return this.utilization;
   }

   public BigDecimal getPartAmount() {
      return this.partAmount;
   }

   public BigDecimal getPlateHeight() {
      return this.plateHeight;
   }

   public BigDecimal getPlateWidth() {
      return this.plateWidth;
   }

   public String getNspfUrl() {
      return this.nspfUrl;
   }

   public String getNspfPath() {
      return this.nspfPath;
   }

   public String getThumbnailUrl() {
      return this.thumbnailUrl;
   }

   public String getThumbnailPath() {
      return this.thumbnailPath;
   }

   public String getPlateGuid() {
      return this.plateGuid;
   }

   public String getPlateName() {
      return this.plateName;
   }

   public Integer getCutSendStatus() {
      return this.cutSendStatus;
   }

   public LocalDateTime getCutSendTime() {
      return this.cutSendTime;
   }

   public Long getCutSendUserId() {
      return this.cutSendUserId;
   }

   public String getCutSendUserName() {
      return this.cutSendUserName;
   }

   public Integer getCutStatus() {
      return this.cutStatus;
   }

   public Long getMachineToolId() {
      return this.machineToolId;
   }

   public BigDecimal getTaskRate() {
      return this.taskRate;
   }

   public String getChildGuid() {
      return this.childGuid;
   }

   public String getChildOrderNumber() {
      return this.childOrderNumber;
   }

   public String getNestUserId() {
      return this.nestUserId;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getFileNameNest() {
      return this.fileNameNest;
   }

   public String getMixedJobIds() {
      return this.mixedJobIds;
   }

   public Integer getInventoryGainType() {
      return this.inventoryGainType;
   }

   @JsonProperty("id")
   public MesBuildingBoChuNestingResult setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("jobId")
   public MesBuildingBoChuNestingResult setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   @JsonProperty("realJobId")
   public MesBuildingBoChuNestingResult setRealJobId(final Integer realJobId) {
      this.realJobId = realJobId;
      return this;
   }

   @JsonProperty("guid")
   public MesBuildingBoChuNestingResult setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   @JsonProperty("resultName")
   public MesBuildingBoChuNestingResult setResultName(final String resultName) {
      this.resultName = resultName;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingBoChuNestingResult setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("thickness")
   public MesBuildingBoChuNestingResult setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("gas")
   public MesBuildingBoChuNestingResult setGas(final String gas) {
      this.gas = gas;
      return this;
   }

   @JsonProperty("amount")
   public MesBuildingBoChuNestingResult setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("utilization")
   public MesBuildingBoChuNestingResult setUtilization(final BigDecimal utilization) {
      this.utilization = utilization;
      return this;
   }

   @JsonProperty("partAmount")
   public MesBuildingBoChuNestingResult setPartAmount(final BigDecimal partAmount) {
      this.partAmount = partAmount;
      return this;
   }

   @JsonProperty("plateHeight")
   public MesBuildingBoChuNestingResult setPlateHeight(final BigDecimal plateHeight) {
      this.plateHeight = plateHeight;
      return this;
   }

   @JsonProperty("plateWidth")
   public MesBuildingBoChuNestingResult setPlateWidth(final BigDecimal plateWidth) {
      this.plateWidth = plateWidth;
      return this;
   }

   @JsonProperty("nspfUrl")
   public MesBuildingBoChuNestingResult setNspfUrl(final String nspfUrl) {
      this.nspfUrl = nspfUrl;
      return this;
   }

   @JsonProperty("nspfPath")
   public MesBuildingBoChuNestingResult setNspfPath(final String nspfPath) {
      this.nspfPath = nspfPath;
      return this;
   }

   @JsonProperty("thumbnailUrl")
   public MesBuildingBoChuNestingResult setThumbnailUrl(final String thumbnailUrl) {
      this.thumbnailUrl = thumbnailUrl;
      return this;
   }

   @JsonProperty("thumbnailPath")
   public MesBuildingBoChuNestingResult setThumbnailPath(final String thumbnailPath) {
      this.thumbnailPath = thumbnailPath;
      return this;
   }

   @JsonProperty("plateGuid")
   public MesBuildingBoChuNestingResult setPlateGuid(final String plateGuid) {
      this.plateGuid = plateGuid;
      return this;
   }

   @JsonProperty("plateName")
   public MesBuildingBoChuNestingResult setPlateName(final String plateName) {
      this.plateName = plateName;
      return this;
   }

   @JsonProperty("cutSendStatus")
   public MesBuildingBoChuNestingResult setCutSendStatus(final Integer cutSendStatus) {
      this.cutSendStatus = cutSendStatus;
      return this;
   }

   @JsonProperty("cutSendTime")
   public MesBuildingBoChuNestingResult setCutSendTime(final LocalDateTime cutSendTime) {
      this.cutSendTime = cutSendTime;
      return this;
   }

   @JsonProperty("cutSendUserId")
   public MesBuildingBoChuNestingResult setCutSendUserId(final Long cutSendUserId) {
      this.cutSendUserId = cutSendUserId;
      return this;
   }

   @JsonProperty("cutSendUserName")
   public MesBuildingBoChuNestingResult setCutSendUserName(final String cutSendUserName) {
      this.cutSendUserName = cutSendUserName;
      return this;
   }

   @JsonProperty("cutStatus")
   public MesBuildingBoChuNestingResult setCutStatus(final Integer cutStatus) {
      this.cutStatus = cutStatus;
      return this;
   }

   @JsonProperty("machineToolId")
   public MesBuildingBoChuNestingResult setMachineToolId(final Long machineToolId) {
      this.machineToolId = machineToolId;
      return this;
   }

   @JsonProperty("taskRate")
   public MesBuildingBoChuNestingResult setTaskRate(final BigDecimal taskRate) {
      this.taskRate = taskRate;
      return this;
   }

   @JsonProperty("childGuid")
   public MesBuildingBoChuNestingResult setChildGuid(final String childGuid) {
      this.childGuid = childGuid;
      return this;
   }

   @JsonProperty("childOrderNumber")
   public MesBuildingBoChuNestingResult setChildOrderNumber(final String childOrderNumber) {
      this.childOrderNumber = childOrderNumber;
      return this;
   }

   @JsonProperty("nestUserId")
   public MesBuildingBoChuNestingResult setNestUserId(final String nestUserId) {
      this.nestUserId = nestUserId;
      return this;
   }

   @JsonProperty("fileName")
   public MesBuildingBoChuNestingResult setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   @JsonProperty("fileNameNest")
   public MesBuildingBoChuNestingResult setFileNameNest(final String fileNameNest) {
      this.fileNameNest = fileNameNest;
      return this;
   }

   public MesBuildingBoChuNestingResult setMixedJobIds(final String mixedJobIds) {
      this.mixedJobIds = mixedJobIds;
      return this;
   }

   public MesBuildingBoChuNestingResult setInventoryGainType(final Integer inventoryGainType) {
      this.inventoryGainType = inventoryGainType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingBoChuNestingResult(id="
         + this.getId()
         + ", jobId="
         + this.getJobId()
         + ", realJobId="
         + this.getRealJobId()
         + ", guid="
         + this.getGuid()
         + ", resultName="
         + this.getResultName()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", gas="
         + this.getGas()
         + ", amount="
         + this.getAmount()
         + ", utilization="
         + this.getUtilization()
         + ", partAmount="
         + this.getPartAmount()
         + ", plateHeight="
         + this.getPlateHeight()
         + ", plateWidth="
         + this.getPlateWidth()
         + ", nspfUrl="
         + this.getNspfUrl()
         + ", nspfPath="
         + this.getNspfPath()
         + ", thumbnailUrl="
         + this.getThumbnailUrl()
         + ", thumbnailPath="
         + this.getThumbnailPath()
         + ", plateGuid="
         + this.getPlateGuid()
         + ", plateName="
         + this.getPlateName()
         + ", cutSendStatus="
         + this.getCutSendStatus()
         + ", cutSendTime="
         + this.getCutSendTime()
         + ", cutSendUserId="
         + this.getCutSendUserId()
         + ", cutSendUserName="
         + this.getCutSendUserName()
         + ", cutStatus="
         + this.getCutStatus()
         + ", machineToolId="
         + this.getMachineToolId()
         + ", taskRate="
         + this.getTaskRate()
         + ", childGuid="
         + this.getChildGuid()
         + ", childOrderNumber="
         + this.getChildOrderNumber()
         + ", nestUserId="
         + this.getNestUserId()
         + ", fileName="
         + this.getFileName()
         + ", fileNameNest="
         + this.getFileNameNest()
         + ", mixedJobIds="
         + this.getMixedJobIds()
         + ", inventoryGainType="
         + this.getInventoryGainType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoChuNestingResult)) {
         return false;
      }

      MesBuildingBoChuNestingResult other = (MesBuildingBoChuNestingResult)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$jobId = this.getJobId();
         Object other$jobId = other.getJobId();
         if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
            Object this$realJobId = this.getRealJobId();
            Object other$realJobId = other.getRealJobId();
            if (this$realJobId == null ? other$realJobId == null : this$realJobId.equals(other$realJobId)) {
               Object this$cutSendStatus = this.getCutSendStatus();
               Object other$cutSendStatus = other.getCutSendStatus();
               if (this$cutSendStatus == null ? other$cutSendStatus == null : this$cutSendStatus.equals(other$cutSendStatus)) {
                  Object this$cutSendUserId = this.getCutSendUserId();
                  Object other$cutSendUserId = other.getCutSendUserId();
                  if (this$cutSendUserId == null ? other$cutSendUserId == null : this$cutSendUserId.equals(other$cutSendUserId)) {
                     Object this$cutStatus = this.getCutStatus();
                     Object other$cutStatus = other.getCutStatus();
                     if (this$cutStatus == null ? other$cutStatus == null : this$cutStatus.equals(other$cutStatus)) {
                        Object this$machineToolId = this.getMachineToolId();
                        Object other$machineToolId = other.getMachineToolId();
                        if (this$machineToolId == null ? other$machineToolId == null : this$machineToolId.equals(other$machineToolId)) {
                           Object this$inventoryGainType = this.getInventoryGainType();
                           Object other$inventoryGainType = other.getInventoryGainType();
                           if (this$inventoryGainType == null ? other$inventoryGainType == null : this$inventoryGainType.equals(other$inventoryGainType)) {
                              Object this$guid = this.getGuid();
                              Object other$guid = other.getGuid();
                              if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                                 Object this$resultName = this.getResultName();
                                 Object other$resultName = other.getResultName();
                                 if (this$resultName == null ? other$resultName == null : this$resultName.equals(other$resultName)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                       Object this$thickness = this.getThickness();
                                       Object other$thickness = other.getThickness();
                                       if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                          Object this$gas = this.getGas();
                                          Object other$gas = other.getGas();
                                          if (this$gas == null ? other$gas == null : this$gas.equals(other$gas)) {
                                             Object this$amount = this.getAmount();
                                             Object other$amount = other.getAmount();
                                             if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                Object this$utilization = this.getUtilization();
                                                Object other$utilization = other.getUtilization();
                                                if (this$utilization == null ? other$utilization == null : this$utilization.equals(other$utilization)) {
                                                   Object this$partAmount = this.getPartAmount();
                                                   Object other$partAmount = other.getPartAmount();
                                                   if (this$partAmount == null ? other$partAmount == null : this$partAmount.equals(other$partAmount)) {
                                                      Object this$plateHeight = this.getPlateHeight();
                                                      Object other$plateHeight = other.getPlateHeight();
                                                      if (this$plateHeight == null ? other$plateHeight == null : this$plateHeight.equals(other$plateHeight)) {
                                                         Object this$plateWidth = this.getPlateWidth();
                                                         Object other$plateWidth = other.getPlateWidth();
                                                         if (this$plateWidth == null ? other$plateWidth == null : this$plateWidth.equals(other$plateWidth)) {
                                                            Object this$nspfUrl = this.getNspfUrl();
                                                            Object other$nspfUrl = other.getNspfUrl();
                                                            if (this$nspfUrl == null ? other$nspfUrl == null : this$nspfUrl.equals(other$nspfUrl)) {
                                                               Object this$nspfPath = this.getNspfPath();
                                                               Object other$nspfPath = other.getNspfPath();
                                                               if (this$nspfPath == null ? other$nspfPath == null : this$nspfPath.equals(other$nspfPath)) {
                                                                  Object this$thumbnailUrl = this.getThumbnailUrl();
                                                                  Object other$thumbnailUrl = other.getThumbnailUrl();
                                                                  if (this$thumbnailUrl == null
                                                                     ? other$thumbnailUrl == null
                                                                     : this$thumbnailUrl.equals(other$thumbnailUrl)) {
                                                                     Object this$thumbnailPath = this.getThumbnailPath();
                                                                     Object other$thumbnailPath = other.getThumbnailPath();
                                                                     if (this$thumbnailPath == null
                                                                        ? other$thumbnailPath == null
                                                                        : this$thumbnailPath.equals(other$thumbnailPath)) {
                                                                        Object this$plateGuid = this.getPlateGuid();
                                                                        Object other$plateGuid = other.getPlateGuid();
                                                                        if (this$plateGuid == null
                                                                           ? other$plateGuid == null
                                                                           : this$plateGuid.equals(other$plateGuid)) {
                                                                           Object this$plateName = this.getPlateName();
                                                                           Object other$plateName = other.getPlateName();
                                                                           if (this$plateName == null
                                                                              ? other$plateName == null
                                                                              : this$plateName.equals(other$plateName)) {
                                                                              Object this$cutSendTime = this.getCutSendTime();
                                                                              Object other$cutSendTime = other.getCutSendTime();
                                                                              if (this$cutSendTime == null
                                                                                 ? other$cutSendTime == null
                                                                                 : this$cutSendTime.equals(other$cutSendTime)) {
                                                                                 Object this$cutSendUserName = this.getCutSendUserName();
                                                                                 Object other$cutSendUserName = other.getCutSendUserName();
                                                                                 if (this$cutSendUserName == null
                                                                                    ? other$cutSendUserName == null
                                                                                    : this$cutSendUserName.equals(other$cutSendUserName)) {
                                                                                    Object this$taskRate = this.getTaskRate();
                                                                                    Object other$taskRate = other.getTaskRate();
                                                                                    if (this$taskRate == null
                                                                                       ? other$taskRate == null
                                                                                       : this$taskRate.equals(other$taskRate)) {
                                                                                       Object this$childGuid = this.getChildGuid();
                                                                                       Object other$childGuid = other.getChildGuid();
                                                                                       if (this$childGuid == null
                                                                                          ? other$childGuid == null
                                                                                          : this$childGuid.equals(other$childGuid)) {
                                                                                          Object this$childOrderNumber = this.getChildOrderNumber();
                                                                                          Object other$childOrderNumber = other.getChildOrderNumber();
                                                                                          if (this$childOrderNumber == null
                                                                                             ? other$childOrderNumber == null
                                                                                             : this$childOrderNumber.equals(other$childOrderNumber)) {
                                                                                             Object this$nestUserId = this.getNestUserId();
                                                                                             Object other$nestUserId = other.getNestUserId();
                                                                                             if (this$nestUserId == null
                                                                                                ? other$nestUserId == null
                                                                                                : this$nestUserId.equals(other$nestUserId)) {
                                                                                                Object this$fileName = this.getFileName();
                                                                                                Object other$fileName = other.getFileName();
                                                                                                if (this$fileName == null
                                                                                                   ? other$fileName == null
                                                                                                   : this$fileName.equals(other$fileName)) {
                                                                                                   Object this$fileNameNest = this.getFileNameNest();
                                                                                                   Object other$fileNameNest = other.getFileNameNest();
                                                                                                   if (this$fileNameNest == null
                                                                                                      ? other$fileNameNest == null
                                                                                                      : this$fileNameNest.equals(other$fileNameNest)) {
                                                                                                      Object this$mixedJobIds = this.getMixedJobIds();
                                                                                                      Object other$mixedJobIds = other.getMixedJobIds();
                                                                                                      return this$mixedJobIds == null
                                                                                                         ? other$mixedJobIds == null
                                                                                                         : this$mixedJobIds.equals(other$mixedJobIds);
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingBoChuNestingResult;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $realJobId = this.getRealJobId();
      result = result * 59 + ($realJobId == null ? 43 : $realJobId.hashCode());
      Object $cutSendStatus = this.getCutSendStatus();
      result = result * 59 + ($cutSendStatus == null ? 43 : $cutSendStatus.hashCode());
      Object $cutSendUserId = this.getCutSendUserId();
      result = result * 59 + ($cutSendUserId == null ? 43 : $cutSendUserId.hashCode());
      Object $cutStatus = this.getCutStatus();
      result = result * 59 + ($cutStatus == null ? 43 : $cutStatus.hashCode());
      Object $machineToolId = this.getMachineToolId();
      result = result * 59 + ($machineToolId == null ? 43 : $machineToolId.hashCode());
      Object $inventoryGainType = this.getInventoryGainType();
      result = result * 59 + ($inventoryGainType == null ? 43 : $inventoryGainType.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $resultName = this.getResultName();
      result = result * 59 + ($resultName == null ? 43 : $resultName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $gas = this.getGas();
      result = result * 59 + ($gas == null ? 43 : $gas.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $utilization = this.getUtilization();
      result = result * 59 + ($utilization == null ? 43 : $utilization.hashCode());
      Object $partAmount = this.getPartAmount();
      result = result * 59 + ($partAmount == null ? 43 : $partAmount.hashCode());
      Object $plateHeight = this.getPlateHeight();
      result = result * 59 + ($plateHeight == null ? 43 : $plateHeight.hashCode());
      Object $plateWidth = this.getPlateWidth();
      result = result * 59 + ($plateWidth == null ? 43 : $plateWidth.hashCode());
      Object $nspfUrl = this.getNspfUrl();
      result = result * 59 + ($nspfUrl == null ? 43 : $nspfUrl.hashCode());
      Object $nspfPath = this.getNspfPath();
      result = result * 59 + ($nspfPath == null ? 43 : $nspfPath.hashCode());
      Object $thumbnailUrl = this.getThumbnailUrl();
      result = result * 59 + ($thumbnailUrl == null ? 43 : $thumbnailUrl.hashCode());
      Object $thumbnailPath = this.getThumbnailPath();
      result = result * 59 + ($thumbnailPath == null ? 43 : $thumbnailPath.hashCode());
      Object $plateGuid = this.getPlateGuid();
      result = result * 59 + ($plateGuid == null ? 43 : $plateGuid.hashCode());
      Object $plateName = this.getPlateName();
      result = result * 59 + ($plateName == null ? 43 : $plateName.hashCode());
      Object $cutSendTime = this.getCutSendTime();
      result = result * 59 + ($cutSendTime == null ? 43 : $cutSendTime.hashCode());
      Object $cutSendUserName = this.getCutSendUserName();
      result = result * 59 + ($cutSendUserName == null ? 43 : $cutSendUserName.hashCode());
      Object $taskRate = this.getTaskRate();
      result = result * 59 + ($taskRate == null ? 43 : $taskRate.hashCode());
      Object $childGuid = this.getChildGuid();
      result = result * 59 + ($childGuid == null ? 43 : $childGuid.hashCode());
      Object $childOrderNumber = this.getChildOrderNumber();
      result = result * 59 + ($childOrderNumber == null ? 43 : $childOrderNumber.hashCode());
      Object $nestUserId = this.getNestUserId();
      result = result * 59 + ($nestUserId == null ? 43 : $nestUserId.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $fileNameNest = this.getFileNameNest();
      result = result * 59 + ($fileNameNest == null ? 43 : $fileNameNest.hashCode());
      Object $mixedJobIds = this.getMixedJobIds();
      return result * 59 + ($mixedJobIds == null ? 43 : $mixedJobIds.hashCode());
   }

   public static class MesBuildingBoChuNestingResultBuilder {
      private Long id;
      private Integer jobId;
      private Integer realJobId;
      private String guid;
      private String resultName;
      private String material;
      private BigDecimal thickness;
      private String gas;
      private BigDecimal amount;
      private BigDecimal utilization;
      private BigDecimal partAmount;
      private BigDecimal plateHeight;
      private BigDecimal plateWidth;
      private String nspfUrl;
      private String nspfPath;
      private String thumbnailUrl;
      private String thumbnailPath;
      private String plateGuid;
      private String plateName;
      private Integer cutSendStatus;
      private LocalDateTime cutSendTime;
      private Long cutSendUserId;
      private String cutSendUserName;
      private Integer cutStatus;
      private Long machineToolId;
      private BigDecimal taskRate;
      private String childGuid;
      private String childOrderNumber;
      private String nestUserId;
      private String fileName;
      private String fileNameNest;
      private String mixedJobIds;
      private Integer inventoryGainType;

      MesBuildingBoChuNestingResultBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("jobId")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      @JsonProperty("realJobId")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder realJobId(final Integer realJobId) {
         this.realJobId = realJobId;
         return this;
      }

      @JsonProperty("guid")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      @JsonProperty("resultName")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder resultName(final String resultName) {
         this.resultName = resultName;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("thickness")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("gas")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder gas(final String gas) {
         this.gas = gas;
         return this;
      }

      @JsonProperty("amount")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("utilization")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder utilization(final BigDecimal utilization) {
         this.utilization = utilization;
         return this;
      }

      @JsonProperty("partAmount")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder partAmount(final BigDecimal partAmount) {
         this.partAmount = partAmount;
         return this;
      }

      @JsonProperty("plateHeight")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder plateHeight(final BigDecimal plateHeight) {
         this.plateHeight = plateHeight;
         return this;
      }

      @JsonProperty("plateWidth")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder plateWidth(final BigDecimal plateWidth) {
         this.plateWidth = plateWidth;
         return this;
      }

      @JsonProperty("nspfUrl")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder nspfUrl(final String nspfUrl) {
         this.nspfUrl = nspfUrl;
         return this;
      }

      @JsonProperty("nspfPath")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder nspfPath(final String nspfPath) {
         this.nspfPath = nspfPath;
         return this;
      }

      @JsonProperty("thumbnailUrl")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder thumbnailUrl(final String thumbnailUrl) {
         this.thumbnailUrl = thumbnailUrl;
         return this;
      }

      @JsonProperty("thumbnailPath")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder thumbnailPath(final String thumbnailPath) {
         this.thumbnailPath = thumbnailPath;
         return this;
      }

      @JsonProperty("plateGuid")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder plateGuid(final String plateGuid) {
         this.plateGuid = plateGuid;
         return this;
      }

      @JsonProperty("plateName")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder plateName(final String plateName) {
         this.plateName = plateName;
         return this;
      }

      @JsonProperty("cutSendStatus")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder cutSendStatus(final Integer cutSendStatus) {
         this.cutSendStatus = cutSendStatus;
         return this;
      }

      @JsonProperty("cutSendTime")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder cutSendTime(final LocalDateTime cutSendTime) {
         this.cutSendTime = cutSendTime;
         return this;
      }

      @JsonProperty("cutSendUserId")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder cutSendUserId(final Long cutSendUserId) {
         this.cutSendUserId = cutSendUserId;
         return this;
      }

      @JsonProperty("cutSendUserName")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder cutSendUserName(final String cutSendUserName) {
         this.cutSendUserName = cutSendUserName;
         return this;
      }

      @JsonProperty("cutStatus")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder cutStatus(final Integer cutStatus) {
         this.cutStatus = cutStatus;
         return this;
      }

      @JsonProperty("machineToolId")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder machineToolId(final Long machineToolId) {
         this.machineToolId = machineToolId;
         return this;
      }

      @JsonProperty("taskRate")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder taskRate(final BigDecimal taskRate) {
         this.taskRate = taskRate;
         return this;
      }

      @JsonProperty("childGuid")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder childGuid(final String childGuid) {
         this.childGuid = childGuid;
         return this;
      }

      @JsonProperty("childOrderNumber")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder childOrderNumber(final String childOrderNumber) {
         this.childOrderNumber = childOrderNumber;
         return this;
      }

      @JsonProperty("nestUserId")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder nestUserId(final String nestUserId) {
         this.nestUserId = nestUserId;
         return this;
      }

      @JsonProperty("fileName")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      @JsonProperty("fileNameNest")
      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder fileNameNest(final String fileNameNest) {
         this.fileNameNest = fileNameNest;
         return this;
      }

      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder mixedJobIds(final String mixedJobIds) {
         this.mixedJobIds = mixedJobIds;
         return this;
      }

      public MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder inventoryGainType(final Integer inventoryGainType) {
         this.inventoryGainType = inventoryGainType;
         return this;
      }

      public MesBuildingBoChuNestingResult build() {
         return new MesBuildingBoChuNestingResult(
            this.id,
            this.jobId,
            this.realJobId,
            this.guid,
            this.resultName,
            this.material,
            this.thickness,
            this.gas,
            this.amount,
            this.utilization,
            this.partAmount,
            this.plateHeight,
            this.plateWidth,
            this.nspfUrl,
            this.nspfPath,
            this.thumbnailUrl,
            this.thumbnailPath,
            this.plateGuid,
            this.plateName,
            this.cutSendStatus,
            this.cutSendTime,
            this.cutSendUserId,
            this.cutSendUserName,
            this.cutStatus,
            this.machineToolId,
            this.taskRate,
            this.childGuid,
            this.childOrderNumber,
            this.nestUserId,
            this.fileName,
            this.fileNameNest,
            this.mixedJobIds,
            this.inventoryGainType
         );
      }

      @Override
      public String toString() {
         return "MesBuildingBoChuNestingResult.MesBuildingBoChuNestingResultBuilder(id="
            + this.id
            + ", jobId="
            + this.jobId
            + ", realJobId="
            + this.realJobId
            + ", guid="
            + this.guid
            + ", resultName="
            + this.resultName
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", gas="
            + this.gas
            + ", amount="
            + this.amount
            + ", utilization="
            + this.utilization
            + ", partAmount="
            + this.partAmount
            + ", plateHeight="
            + this.plateHeight
            + ", plateWidth="
            + this.plateWidth
            + ", nspfUrl="
            + this.nspfUrl
            + ", nspfPath="
            + this.nspfPath
            + ", thumbnailUrl="
            + this.thumbnailUrl
            + ", thumbnailPath="
            + this.thumbnailPath
            + ", plateGuid="
            + this.plateGuid
            + ", plateName="
            + this.plateName
            + ", cutSendStatus="
            + this.cutSendStatus
            + ", cutSendTime="
            + this.cutSendTime
            + ", cutSendUserId="
            + this.cutSendUserId
            + ", cutSendUserName="
            + this.cutSendUserName
            + ", cutStatus="
            + this.cutStatus
            + ", machineToolId="
            + this.machineToolId
            + ", taskRate="
            + this.taskRate
            + ", childGuid="
            + this.childGuid
            + ", childOrderNumber="
            + this.childOrderNumber
            + ", nestUserId="
            + this.nestUserId
            + ", fileName="
            + this.fileName
            + ", fileNameNest="
            + this.fileNameNest
            + ", mixedJobIds="
            + this.mixedJobIds
            + ", inventoryGainType="
            + this.inventoryGainType
            + ")";
      }
   }
}
