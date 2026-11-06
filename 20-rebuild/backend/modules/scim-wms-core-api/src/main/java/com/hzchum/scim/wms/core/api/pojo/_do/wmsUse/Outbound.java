package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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

@ApiModel(value = "Outbound对象", description = "出库表 ")
@Entity
@TableName("wms_outbound")
@Table(name = "wms_outbound")
public class Outbound extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "审核出库单编号", notes = "审核出库单编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '审核出库单编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(128)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID", notes = "审核人ID")
   @JsonProperty("reviewerId")
   @JSONField(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id", columnDefinition = "bigint  COMMENT '审核人ID'", nullable = true)
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称", notes = "审核人名称")
   @JsonProperty("reviewerName")
   @JSONField(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name", columnDefinition = "varchar(128)  COMMENT '审核人名称'", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "recipients", value = "领用人名称集", notes = "领用人名称集")
   @JsonProperty("recipients")
   @JSONField(name = "recipients")
   @TableField("recipients")
   @Column(name = "recipients", columnDefinition = "text  COMMENT '领用人名称集'", nullable = true)
   private String recipients;
   @ApiModelProperty(name = "outboundTime", value = "出库时间", notes = "出库时间")
   @JsonProperty("outboundTime")
   @JSONField(name = "outboundTime")
   @TableField("outbound_time")
   @Column(name = "outbound_time", columnDefinition = "datetime  COMMENT '出库时间'", nullable = true)
   private LocalDateTime outboundTime;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态", notes = "审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "userUpdateTime", value = "用户修改时间", notes = "用户修改时间")
   @JsonProperty("userUpdateTime")
   @JSONField(name = "userUpdateTime")
   @TableField("user_update_time")
   @Column(name = "user_update_time", columnDefinition = "datetime  COMMENT '用户修改时间'", nullable = true)
   private LocalDateTime userUpdateTime;
   @ApiModelProperty(name = "applicationSn", value = "申请出库单编号", notes = "申请出库单编号")
   @JsonProperty("applicationSn")
   @JSONField(name = "applicationSn")
   @TableField("application_SN")
   @Column(name = "application_SN", columnDefinition = "varchar(255)  COMMENT '申请出库单编号'", nullable = true)
   private String applicationSn;
   @ApiModelProperty(name = "boolPrinted", value = "是否打印", notes = "是否打印")
   @JsonProperty("boolPrinted")
   @JSONField(name = "boolPrinted")
   @TableField("bool_printed")
   @Column(name = "bool_printed", columnDefinition = "tinyint(1)  COMMENT '是否打印'", nullable = true)
   private Boolean boolPrinted;
   @ApiModelProperty(name = "containBasicClass", value = "出库单包含基础类型", notes = "出库单包含基础类型")
   @JsonProperty("containBasicClass")
   @JSONField(name = "containBasicClass")
   @TableField("contain_basic_class")
   @Column(name = "contain_basic_class", columnDefinition = "int  COMMENT '出库单包含基础类型'", nullable = true)
   private Integer containBasicClass;
   @ApiModelProperty(name = "outboundEndTime", value = "出库结束时间", notes = "出库结束时间")
   @JsonProperty("outboundEndTime")
   @JSONField(name = "outboundEndTime")
   @TableField("outbound_end_time")
   @Column(name = "outbound_end_time", columnDefinition = "datetime  COMMENT '出库结束时间'", nullable = true)
   private LocalDateTime outboundEndTime;
   @ApiModelProperty(name = "outboundStartTime", value = "出库开始时间", notes = "出库开始时间")
   @JsonProperty("outboundStartTime")
   @JSONField(name = "outboundStartTime")
   @TableField("outbound_start_time")
   @Column(name = "outbound_start_time", columnDefinition = "datetime  COMMENT '出库开始时间'", nullable = true)
   private LocalDateTime outboundStartTime;
   @ApiModelProperty(name = "projectIds", value = "出库项目ID集", notes = "出库项目ID集")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT '出库项目ID集'", nullable = true)
   private String projectIds;
   @ApiModelProperty(name = "cutPlateId")
   @JsonProperty("cutPlateId")
   @JSONField(name = "cutPlateId")
   @TableField("cut_plate_id")
   @Column(name = "cut_plate_id", columnDefinition = "bigint  COMMENT '切割指令id(mes零件套料)'", nullable = true)
   private Long cutPlateId;
   @ApiModelProperty(name = "boolCross")
   @JsonProperty("boolCross")
   @JSONField(name = "boolCross")
   @TableField("bool_cross")
   @Column(name = "bool_cross", columnDefinition = "tinyint(1) default '0' COMMENT '是否跨组织（经典数据打通）'", nullable = true)
   private Boolean boolCross;
   @ApiModelProperty(name = "outboundLength", value = "条板实际出库长度", notes = "条板实际出库长度")
   @JsonProperty("outboundLength")
   @JSONField(name = "outboundLength")
   @TableField("outbound_length")
   @Column(name = "outbound_length", columnDefinition = "decimal(32,2)  COMMENT '条板实际出库长度'", nullable = true)
   private BigDecimal outboundLength;
   @ApiModelProperty(name = "outboundMete", value = "条板实际出库核算量", notes = "条板实际出库核算量")
   @JsonProperty("outboundMete")
   @JSONField(name = "outboundMete")
   @TableField("outbound_mete")
   @Column(name = "outbound_mete", columnDefinition = "decimal(32,2)  COMMENT '条板实际出库核算量'", nullable = true)
   private BigDecimal outboundMete;
   @ApiModelProperty(name = "convertId", value = "转换单id")
   @JsonProperty("convertId")
   @JSONField(name = "convertId")
   @TableField("convert_id")
   @Column(name = "convert_id")
   private Long convertId;
   @ApiModelProperty(name = "boolPartyA")
   @JsonProperty("boolPartyA")
   @JSONField(name = "boolPartyA")
   @TableField("bool_party_a")
   @Column(name = "bool_party_a", columnDefinition = "tinyint(1) default '0' COMMENT '是否甲供（1 甲供 ,2 自采）'", nullable = true)
   private Boolean boolPartyA;
   @ApiModelProperty(name = "outboundTypeSelection")
   @JsonProperty("outboundTypeSelection")
   @JSONField(name = "outboundTypeSelection")
   @TableField("outbound_type_selection")
   @Column(name = "outbound_type_selection", columnDefinition = "int default '1' COMMENT '出库类型 枚举类[OutboundTypeEnum]'", nullable = false)
   private Integer outboundTypeSelection;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "boolScheduling", value = "是否排产出库")
   @JsonProperty("boolScheduling")
   @JSONField(name = "boolScheduling")
   @TableField("bool_scheduling")
   @Column(name = "bool_scheduling", columnDefinition = "tinyint(1) default '0' COMMENT '是否排产出库'", nullable = true)
   private Boolean boolScheduling;
   @ApiModelProperty(name = "taskOrderId", value = "工单id(排产出库使用)")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20) COMMENT '工单id(排产出库使用)'", nullable = true)
   private Long taskOrderId;
   @ApiModelProperty(name = "taskOrderNumber", value = "排产工单号(排产出库使用)")
   @JsonProperty("taskOrderNumber")
   @JSONField(name = "taskOrderNumber")
   @TableField("task_order_number")
   @Column(name = "task_order_number", columnDefinition = "varchar(255)  COMMENT '排产工单号(排产出库使用)'", nullable = true)
   private String taskOrderNumber;
   @ApiModelProperty(name = "mesWorkshopId", value = "车间id(排产出库使用)")
   @JsonProperty("mesWorkshopId")
   @JSONField(name = "mesWorkshopId")
   @TableField("mes_workshop_id")
   @Column(name = "mes_workshop_id", columnDefinition = "bigint(20) COMMENT '车间id(排产出库使用)'", nullable = true)
   private Long mesWorkshopId;
   @ApiModelProperty(name = "schedulingDataSource", value = "排产数据来源 SchedulingDataTypeEnum[1 mes数据,2 APP数据]")
   @JsonProperty("schedulingDataSource")
   @JSONField(name = "schedulingDataSource")
   @TableField("scheduling_data_source")
   @Column(name = "scheduling_data_source")
   private Integer schedulingDataSource;
   @ApiModelProperty(name = "schedulingId", value = "排产id(排产出库使用)")
   @JsonProperty("schedulingId")
   @JSONField(name = "taskOrderId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20) COMMENT '排产id(排产出库使用)'", nullable = true)
   private Long schedulingId;
   @ApiModelProperty(name = "receiveId", value = "物联设备配件领料id(物联设备配件领料)")
   @JsonProperty("receiveId")
   @JSONField(name = "receiveId")
   @TableField("receive_id")
   @Column(name = "receive_id", columnDefinition = "bigint(20) COMMENT '物联设备配件领料(物联设备配件领料)'", nullable = true)
   private Long receiveId;
   @ApiModelProperty(name = "stockGuid", value = "柏楚排样图guid(后期做数据查询,修复的时候使用)", notes = "柏楚排样图guid")
   @JsonProperty("stockGuid")
   @JSONField(name = "stockGuid")
   @TableField("stock_guid")
   @Column(name = "stock_guid", columnDefinition = "varchar(255)  COMMENT '柏楚板材guid'", nullable = true)
   private String stockGuid;
   @ApiModelProperty(name = "stockCutGuid", value = "切割任务guid(mes会生成子的如：切0001-01)", notes = "切割任务guid")
   @JsonProperty("stockCutGuid")
   @JSONField(name = "stockCutGuid")
   @TableField("stock_cut_guid")
   @Column(name = "stock_cut_guid", columnDefinition = "varchar(255)  COMMENT '切割任务guid'", nullable = true)
   private String stockCutGuid;
   @ApiModelProperty(name = "childOrderNumber")
   @JsonProperty("childOrderNumber")
   @TableField("child_order_number")
   @Column(name = "child_order_number", columnDefinition = "varchar(255)  COMMENT '工单任务号'", nullable = true)
   private String childOrderNumber;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static Outbound.OutboundBuilder builder() {
      return new Outbound.OutboundBuilder();
   }

   public Outbound() {
   }

   public Outbound(
      final Long id,
      final String serialNumber,
      final Long applicantId,
      final String applicantName,
      final Long reviewerId,
      final String reviewerName,
      final String recipients,
      final LocalDateTime outboundTime,
      final LocalDateTime reviewTime,
      final Integer reviewStatus,
      final LocalDateTime userUpdateTime,
      final String applicationSn,
      final Boolean boolPrinted,
      final Integer containBasicClass,
      final LocalDateTime outboundEndTime,
      final LocalDateTime outboundStartTime,
      final String projectIds,
      final Long cutPlateId,
      final Boolean boolCross,
      final BigDecimal outboundLength,
      final BigDecimal outboundMete,
      final Long convertId,
      final Boolean boolPartyA,
      final Integer outboundTypeSelection,
      final Long approveRecordId,
      final Boolean boolScheduling,
      final Long taskOrderId,
      final String taskOrderNumber,
      final Long mesWorkshopId,
      final Integer schedulingDataSource,
      final Long schedulingId,
      final Long receiveId,
      final String stockGuid,
      final String stockCutGuid,
      final String childOrderNumber,
      final String remark
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.recipients = recipients;
      this.outboundTime = outboundTime;
      this.reviewTime = reviewTime;
      this.reviewStatus = reviewStatus;
      this.userUpdateTime = userUpdateTime;
      this.applicationSn = applicationSn;
      this.boolPrinted = boolPrinted;
      this.containBasicClass = containBasicClass;
      this.outboundEndTime = outboundEndTime;
      this.outboundStartTime = outboundStartTime;
      this.projectIds = projectIds;
      this.cutPlateId = cutPlateId;
      this.boolCross = boolCross;
      this.outboundLength = outboundLength;
      this.outboundMete = outboundMete;
      this.convertId = convertId;
      this.boolPartyA = boolPartyA;
      this.outboundTypeSelection = outboundTypeSelection;
      this.approveRecordId = approveRecordId;
      this.boolScheduling = boolScheduling;
      this.taskOrderId = taskOrderId;
      this.taskOrderNumber = taskOrderNumber;
      this.mesWorkshopId = mesWorkshopId;
      this.schedulingDataSource = schedulingDataSource;
      this.schedulingId = schedulingId;
      this.receiveId = receiveId;
      this.stockGuid = stockGuid;
      this.stockCutGuid = stockCutGuid;
      this.childOrderNumber = childOrderNumber;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public String getRecipients() {
      return this.recipients;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public String getApplicationSn() {
      return this.applicationSn;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   public Integer getContainBasicClass() {
      return this.containBasicClass;
   }

   public LocalDateTime getOutboundEndTime() {
      return this.outboundEndTime;
   }

   public LocalDateTime getOutboundStartTime() {
      return this.outboundStartTime;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public Long getCutPlateId() {
      return this.cutPlateId;
   }

   public Boolean getBoolCross() {
      return this.boolCross;
   }

   public BigDecimal getOutboundLength() {
      return this.outboundLength;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public Long getConvertId() {
      return this.convertId;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Boolean getBoolScheduling() {
      return this.boolScheduling;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public Long getMesWorkshopId() {
      return this.mesWorkshopId;
   }

   public Integer getSchedulingDataSource() {
      return this.schedulingDataSource;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getReceiveId() {
      return this.receiveId;
   }

   public String getStockGuid() {
      return this.stockGuid;
   }

   public String getStockCutGuid() {
      return this.stockCutGuid;
   }

   public String getChildOrderNumber() {
      return this.childOrderNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public Outbound setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public Outbound setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("applicantId")
   public Outbound setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public Outbound setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("reviewerId")
   public Outbound setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("reviewerName")
   public Outbound setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("recipients")
   public Outbound setRecipients(final String recipients) {
      this.recipients = recipients;
      return this;
   }

   @JsonProperty("outboundTime")
   public Outbound setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
      return this;
   }

   @JsonProperty("reviewTime")
   public Outbound setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("reviewStatus")
   public Outbound setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("userUpdateTime")
   public Outbound setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
      return this;
   }

   @JsonProperty("applicationSn")
   public Outbound setApplicationSn(final String applicationSn) {
      this.applicationSn = applicationSn;
      return this;
   }

   @JsonProperty("boolPrinted")
   public Outbound setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
      return this;
   }

   @JsonProperty("containBasicClass")
   public Outbound setContainBasicClass(final Integer containBasicClass) {
      this.containBasicClass = containBasicClass;
      return this;
   }

   @JsonProperty("outboundEndTime")
   public Outbound setOutboundEndTime(final LocalDateTime outboundEndTime) {
      this.outboundEndTime = outboundEndTime;
      return this;
   }

   @JsonProperty("outboundStartTime")
   public Outbound setOutboundStartTime(final LocalDateTime outboundStartTime) {
      this.outboundStartTime = outboundStartTime;
      return this;
   }

   @JsonProperty("projectIds")
   public Outbound setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("cutPlateId")
   public Outbound setCutPlateId(final Long cutPlateId) {
      this.cutPlateId = cutPlateId;
      return this;
   }

   @JsonProperty("boolCross")
   public Outbound setBoolCross(final Boolean boolCross) {
      this.boolCross = boolCross;
      return this;
   }

   @JsonProperty("outboundLength")
   public Outbound setOutboundLength(final BigDecimal outboundLength) {
      this.outboundLength = outboundLength;
      return this;
   }

   @JsonProperty("outboundMete")
   public Outbound setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
      return this;
   }

   @JsonProperty("convertId")
   public Outbound setConvertId(final Long convertId) {
      this.convertId = convertId;
      return this;
   }

   @JsonProperty("boolPartyA")
   public Outbound setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
      return this;
   }

   @JsonProperty("outboundTypeSelection")
   public Outbound setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
      return this;
   }

   @JsonProperty("approveRecordId")
   public Outbound setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @JsonProperty("boolScheduling")
   public Outbound setBoolScheduling(final Boolean boolScheduling) {
      this.boolScheduling = boolScheduling;
      return this;
   }

   @JsonProperty("taskOrderId")
   public Outbound setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("taskOrderNumber")
   public Outbound setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
      return this;
   }

   @JsonProperty("mesWorkshopId")
   public Outbound setMesWorkshopId(final Long mesWorkshopId) {
      this.mesWorkshopId = mesWorkshopId;
      return this;
   }

   @JsonProperty("schedulingDataSource")
   public Outbound setSchedulingDataSource(final Integer schedulingDataSource) {
      this.schedulingDataSource = schedulingDataSource;
      return this;
   }

   @JsonProperty("schedulingId")
   public Outbound setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("receiveId")
   public Outbound setReceiveId(final Long receiveId) {
      this.receiveId = receiveId;
      return this;
   }

   @JsonProperty("stockGuid")
   public Outbound setStockGuid(final String stockGuid) {
      this.stockGuid = stockGuid;
      return this;
   }

   @JsonProperty("stockCutGuid")
   public Outbound setStockCutGuid(final String stockCutGuid) {
      this.stockCutGuid = stockCutGuid;
      return this;
   }

   @JsonProperty("childOrderNumber")
   public Outbound setChildOrderNumber(final String childOrderNumber) {
      this.childOrderNumber = childOrderNumber;
      return this;
   }

   @JsonProperty("remark")
   public Outbound setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "Outbound(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", recipients="
         + this.getRecipients()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", applicationSn="
         + this.getApplicationSn()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ", containBasicClass="
         + this.getContainBasicClass()
         + ", outboundEndTime="
         + this.getOutboundEndTime()
         + ", outboundStartTime="
         + this.getOutboundStartTime()
         + ", projectIds="
         + this.getProjectIds()
         + ", cutPlateId="
         + this.getCutPlateId()
         + ", boolCross="
         + this.getBoolCross()
         + ", outboundLength="
         + this.getOutboundLength()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", convertId="
         + this.getConvertId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", boolScheduling="
         + this.getBoolScheduling()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", mesWorkshopId="
         + this.getMesWorkshopId()
         + ", schedulingDataSource="
         + this.getSchedulingDataSource()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", receiveId="
         + this.getReceiveId()
         + ", stockGuid="
         + this.getStockGuid()
         + ", stockCutGuid="
         + this.getStockCutGuid()
         + ", childOrderNumber="
         + this.getChildOrderNumber()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Outbound)) {
         return false;
      }

      Outbound other = (Outbound)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$applicantId = this.getApplicantId();
         Object other$applicantId = other.getApplicantId();
         if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
            Object this$reviewerId = this.getReviewerId();
            Object other$reviewerId = other.getReviewerId();
            if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$boolPrinted = this.getBoolPrinted();
                  Object other$boolPrinted = other.getBoolPrinted();
                  if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                     Object this$containBasicClass = this.getContainBasicClass();
                     Object other$containBasicClass = other.getContainBasicClass();
                     if (this$containBasicClass == null ? other$containBasicClass == null : this$containBasicClass.equals(other$containBasicClass)) {
                        Object this$cutPlateId = this.getCutPlateId();
                        Object other$cutPlateId = other.getCutPlateId();
                        if (this$cutPlateId == null ? other$cutPlateId == null : this$cutPlateId.equals(other$cutPlateId)) {
                           Object this$boolCross = this.getBoolCross();
                           Object other$boolCross = other.getBoolCross();
                           if (this$boolCross == null ? other$boolCross == null : this$boolCross.equals(other$boolCross)) {
                              Object this$convertId = this.getConvertId();
                              Object other$convertId = other.getConvertId();
                              if (this$convertId == null ? other$convertId == null : this$convertId.equals(other$convertId)) {
                                 Object this$boolPartyA = this.getBoolPartyA();
                                 Object other$boolPartyA = other.getBoolPartyA();
                                 if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                    Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                                    Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                                    if (this$outboundTypeSelection == null
                                       ? other$outboundTypeSelection == null
                                       : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                                       Object this$approveRecordId = this.getApproveRecordId();
                                       Object other$approveRecordId = other.getApproveRecordId();
                                       if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                                          Object this$boolScheduling = this.getBoolScheduling();
                                          Object other$boolScheduling = other.getBoolScheduling();
                                          if (this$boolScheduling == null ? other$boolScheduling == null : this$boolScheduling.equals(other$boolScheduling)) {
                                             Object this$taskOrderId = this.getTaskOrderId();
                                             Object other$taskOrderId = other.getTaskOrderId();
                                             if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                                                Object this$mesWorkshopId = this.getMesWorkshopId();
                                                Object other$mesWorkshopId = other.getMesWorkshopId();
                                                if (this$mesWorkshopId == null ? other$mesWorkshopId == null : this$mesWorkshopId.equals(other$mesWorkshopId)) {
                                                   Object this$schedulingDataSource = this.getSchedulingDataSource();
                                                   Object other$schedulingDataSource = other.getSchedulingDataSource();
                                                   if (this$schedulingDataSource == null
                                                      ? other$schedulingDataSource == null
                                                      : this$schedulingDataSource.equals(other$schedulingDataSource)) {
                                                      Object this$schedulingId = this.getSchedulingId();
                                                      Object other$schedulingId = other.getSchedulingId();
                                                      if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)
                                                         )
                                                       {
                                                         Object this$receiveId = this.getReceiveId();
                                                         Object other$receiveId = other.getReceiveId();
                                                         if (this$receiveId == null ? other$receiveId == null : this$receiveId.equals(other$receiveId)) {
                                                            Object this$serialNumber = this.getSerialNumber();
                                                            Object other$serialNumber = other.getSerialNumber();
                                                            if (this$serialNumber == null
                                                               ? other$serialNumber == null
                                                               : this$serialNumber.equals(other$serialNumber)) {
                                                               Object this$applicantName = this.getApplicantName();
                                                               Object other$applicantName = other.getApplicantName();
                                                               if (this$applicantName == null
                                                                  ? other$applicantName == null
                                                                  : this$applicantName.equals(other$applicantName)) {
                                                                  Object this$reviewerName = this.getReviewerName();
                                                                  Object other$reviewerName = other.getReviewerName();
                                                                  if (this$reviewerName == null
                                                                     ? other$reviewerName == null
                                                                     : this$reviewerName.equals(other$reviewerName)) {
                                                                     Object this$recipients = this.getRecipients();
                                                                     Object other$recipients = other.getRecipients();
                                                                     if (this$recipients == null
                                                                        ? other$recipients == null
                                                                        : this$recipients.equals(other$recipients)) {
                                                                        Object this$outboundTime = this.getOutboundTime();
                                                                        Object other$outboundTime = other.getOutboundTime();
                                                                        if (this$outboundTime == null
                                                                           ? other$outboundTime == null
                                                                           : this$outboundTime.equals(other$outboundTime)) {
                                                                           Object this$reviewTime = this.getReviewTime();
                                                                           Object other$reviewTime = other.getReviewTime();
                                                                           if (this$reviewTime == null
                                                                              ? other$reviewTime == null
                                                                              : this$reviewTime.equals(other$reviewTime)) {
                                                                              Object this$userUpdateTime = this.getUserUpdateTime();
                                                                              Object other$userUpdateTime = other.getUserUpdateTime();
                                                                              if (this$userUpdateTime == null
                                                                                 ? other$userUpdateTime == null
                                                                                 : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                                 Object this$applicationSn = this.getApplicationSn();
                                                                                 Object other$applicationSn = other.getApplicationSn();
                                                                                 if (this$applicationSn == null
                                                                                    ? other$applicationSn == null
                                                                                    : this$applicationSn.equals(other$applicationSn)) {
                                                                                    Object this$outboundEndTime = this.getOutboundEndTime();
                                                                                    Object other$outboundEndTime = other.getOutboundEndTime();
                                                                                    if (this$outboundEndTime == null
                                                                                       ? other$outboundEndTime == null
                                                                                       : this$outboundEndTime.equals(other$outboundEndTime)) {
                                                                                       Object this$outboundStartTime = this.getOutboundStartTime();
                                                                                       Object other$outboundStartTime = other.getOutboundStartTime();
                                                                                       if (this$outboundStartTime == null
                                                                                          ? other$outboundStartTime == null
                                                                                          : this$outboundStartTime.equals(other$outboundStartTime)) {
                                                                                          Object this$projectIds = this.getProjectIds();
                                                                                          Object other$projectIds = other.getProjectIds();
                                                                                          if (this$projectIds == null
                                                                                             ? other$projectIds == null
                                                                                             : this$projectIds.equals(other$projectIds)) {
                                                                                             Object this$outboundLength = this.getOutboundLength();
                                                                                             Object other$outboundLength = other.getOutboundLength();
                                                                                             if (this$outboundLength == null
                                                                                                ? other$outboundLength == null
                                                                                                : this$outboundLength.equals(other$outboundLength)) {
                                                                                                Object this$outboundMete = this.getOutboundMete();
                                                                                                Object other$outboundMete = other.getOutboundMete();
                                                                                                if (this$outboundMete == null
                                                                                                   ? other$outboundMete == null
                                                                                                   : this$outboundMete.equals(other$outboundMete)) {
                                                                                                   Object this$taskOrderNumber = this.getTaskOrderNumber();
                                                                                                   Object other$taskOrderNumber = other.getTaskOrderNumber();
                                                                                                   if (this$taskOrderNumber == null
                                                                                                      ? other$taskOrderNumber == null
                                                                                                      : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                                                                                                      Object this$stockGuid = this.getStockGuid();
                                                                                                      Object other$stockGuid = other.getStockGuid();
                                                                                                      if (this$stockGuid == null
                                                                                                         ? other$stockGuid == null
                                                                                                         : this$stockGuid.equals(other$stockGuid)) {
                                                                                                         Object this$stockCutGuid = this.getStockCutGuid();
                                                                                                         Object other$stockCutGuid = other.getStockCutGuid();
                                                                                                         if (this$stockCutGuid == null
                                                                                                            ? other$stockCutGuid == null
                                                                                                            : this$stockCutGuid.equals(other$stockCutGuid)) {
                                                                                                            Object this$childOrderNumber = this.getChildOrderNumber();
                                                                                                            Object other$childOrderNumber = other.getChildOrderNumber();
                                                                                                            if (this$childOrderNumber == null
                                                                                                               ? other$childOrderNumber == null
                                                                                                               : this$childOrderNumber.equals(
                                                                                                                  other$childOrderNumber
                                                                                                               )) {
                                                                                                               Object this$remark = this.getRemark();
                                                                                                               Object other$remark = other.getRemark();
                                                                                                               return this$remark == null
                                                                                                                  ? other$remark == null
                                                                                                                  : this$remark.equals(other$remark);
                                                                                                            } else {
                                                                                                               return false;
                                                                                                            }
                                                                                                         } else {
                                                                                                            return false;
                                                                                                         }
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof Outbound;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $containBasicClass = this.getContainBasicClass();
      result = result * 59 + ($containBasicClass == null ? 43 : $containBasicClass.hashCode());
      Object $cutPlateId = this.getCutPlateId();
      result = result * 59 + ($cutPlateId == null ? 43 : $cutPlateId.hashCode());
      Object $boolCross = this.getBoolCross();
      result = result * 59 + ($boolCross == null ? 43 : $boolCross.hashCode());
      Object $convertId = this.getConvertId();
      result = result * 59 + ($convertId == null ? 43 : $convertId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $boolScheduling = this.getBoolScheduling();
      result = result * 59 + ($boolScheduling == null ? 43 : $boolScheduling.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $mesWorkshopId = this.getMesWorkshopId();
      result = result * 59 + ($mesWorkshopId == null ? 43 : $mesWorkshopId.hashCode());
      Object $schedulingDataSource = this.getSchedulingDataSource();
      result = result * 59 + ($schedulingDataSource == null ? 43 : $schedulingDataSource.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $receiveId = this.getReceiveId();
      result = result * 59 + ($receiveId == null ? 43 : $receiveId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $recipients = this.getRecipients();
      result = result * 59 + ($recipients == null ? 43 : $recipients.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $applicationSn = this.getApplicationSn();
      result = result * 59 + ($applicationSn == null ? 43 : $applicationSn.hashCode());
      Object $outboundEndTime = this.getOutboundEndTime();
      result = result * 59 + ($outboundEndTime == null ? 43 : $outboundEndTime.hashCode());
      Object $outboundStartTime = this.getOutboundStartTime();
      result = result * 59 + ($outboundStartTime == null ? 43 : $outboundStartTime.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $outboundLength = this.getOutboundLength();
      result = result * 59 + ($outboundLength == null ? 43 : $outboundLength.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $stockGuid = this.getStockGuid();
      result = result * 59 + ($stockGuid == null ? 43 : $stockGuid.hashCode());
      Object $stockCutGuid = this.getStockCutGuid();
      result = result * 59 + ($stockCutGuid == null ? 43 : $stockCutGuid.hashCode());
      Object $childOrderNumber = this.getChildOrderNumber();
      result = result * 59 + ($childOrderNumber == null ? 43 : $childOrderNumber.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class OutboundBuilder {
      private Long id;
      private String serialNumber;
      private Long applicantId;
      private String applicantName;
      private Long reviewerId;
      private String reviewerName;
      private String recipients;
      private LocalDateTime outboundTime;
      private LocalDateTime reviewTime;
      private Integer reviewStatus;
      private LocalDateTime userUpdateTime;
      private String applicationSn;
      private Boolean boolPrinted;
      private Integer containBasicClass;
      private LocalDateTime outboundEndTime;
      private LocalDateTime outboundStartTime;
      private String projectIds;
      private Long cutPlateId;
      private Boolean boolCross;
      private BigDecimal outboundLength;
      private BigDecimal outboundMete;
      private Long convertId;
      private Boolean boolPartyA;
      private Integer outboundTypeSelection;
      private Long approveRecordId;
      private Boolean boolScheduling;
      private Long taskOrderId;
      private String taskOrderNumber;
      private Long mesWorkshopId;
      private Integer schedulingDataSource;
      private Long schedulingId;
      private Long receiveId;
      private String stockGuid;
      private String stockCutGuid;
      private String childOrderNumber;
      private String remark;

      OutboundBuilder() {
      }

      @JsonProperty("id")
      public Outbound.OutboundBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public Outbound.OutboundBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("applicantId")
      public Outbound.OutboundBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public Outbound.OutboundBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("reviewerId")
      public Outbound.OutboundBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("reviewerName")
      public Outbound.OutboundBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("recipients")
      public Outbound.OutboundBuilder recipients(final String recipients) {
         this.recipients = recipients;
         return this;
      }

      @JsonProperty("outboundTime")
      public Outbound.OutboundBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      @JsonProperty("reviewTime")
      public Outbound.OutboundBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("reviewStatus")
      public Outbound.OutboundBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("userUpdateTime")
      public Outbound.OutboundBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      @JsonProperty("applicationSn")
      public Outbound.OutboundBuilder applicationSn(final String applicationSn) {
         this.applicationSn = applicationSn;
         return this;
      }

      @JsonProperty("boolPrinted")
      public Outbound.OutboundBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      @JsonProperty("containBasicClass")
      public Outbound.OutboundBuilder containBasicClass(final Integer containBasicClass) {
         this.containBasicClass = containBasicClass;
         return this;
      }

      @JsonProperty("outboundEndTime")
      public Outbound.OutboundBuilder outboundEndTime(final LocalDateTime outboundEndTime) {
         this.outboundEndTime = outboundEndTime;
         return this;
      }

      @JsonProperty("outboundStartTime")
      public Outbound.OutboundBuilder outboundStartTime(final LocalDateTime outboundStartTime) {
         this.outboundStartTime = outboundStartTime;
         return this;
      }

      @JsonProperty("projectIds")
      public Outbound.OutboundBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("cutPlateId")
      public Outbound.OutboundBuilder cutPlateId(final Long cutPlateId) {
         this.cutPlateId = cutPlateId;
         return this;
      }

      @JsonProperty("boolCross")
      public Outbound.OutboundBuilder boolCross(final Boolean boolCross) {
         this.boolCross = boolCross;
         return this;
      }

      @JsonProperty("outboundLength")
      public Outbound.OutboundBuilder outboundLength(final BigDecimal outboundLength) {
         this.outboundLength = outboundLength;
         return this;
      }

      @JsonProperty("outboundMete")
      public Outbound.OutboundBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      @JsonProperty("convertId")
      public Outbound.OutboundBuilder convertId(final Long convertId) {
         this.convertId = convertId;
         return this;
      }

      @JsonProperty("boolPartyA")
      public Outbound.OutboundBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      @JsonProperty("outboundTypeSelection")
      public Outbound.OutboundBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      @JsonProperty("approveRecordId")
      public Outbound.OutboundBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      @JsonProperty("boolScheduling")
      public Outbound.OutboundBuilder boolScheduling(final Boolean boolScheduling) {
         this.boolScheduling = boolScheduling;
         return this;
      }

      @JsonProperty("taskOrderId")
      public Outbound.OutboundBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("taskOrderNumber")
      public Outbound.OutboundBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      @JsonProperty("mesWorkshopId")
      public Outbound.OutboundBuilder mesWorkshopId(final Long mesWorkshopId) {
         this.mesWorkshopId = mesWorkshopId;
         return this;
      }

      @JsonProperty("schedulingDataSource")
      public Outbound.OutboundBuilder schedulingDataSource(final Integer schedulingDataSource) {
         this.schedulingDataSource = schedulingDataSource;
         return this;
      }

      @JsonProperty("schedulingId")
      public Outbound.OutboundBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("receiveId")
      public Outbound.OutboundBuilder receiveId(final Long receiveId) {
         this.receiveId = receiveId;
         return this;
      }

      @JsonProperty("stockGuid")
      public Outbound.OutboundBuilder stockGuid(final String stockGuid) {
         this.stockGuid = stockGuid;
         return this;
      }

      @JsonProperty("stockCutGuid")
      public Outbound.OutboundBuilder stockCutGuid(final String stockCutGuid) {
         this.stockCutGuid = stockCutGuid;
         return this;
      }

      @JsonProperty("childOrderNumber")
      public Outbound.OutboundBuilder childOrderNumber(final String childOrderNumber) {
         this.childOrderNumber = childOrderNumber;
         return this;
      }

      @JsonProperty("remark")
      public Outbound.OutboundBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public Outbound build() {
         return new Outbound(
            this.id,
            this.serialNumber,
            this.applicantId,
            this.applicantName,
            this.reviewerId,
            this.reviewerName,
            this.recipients,
            this.outboundTime,
            this.reviewTime,
            this.reviewStatus,
            this.userUpdateTime,
            this.applicationSn,
            this.boolPrinted,
            this.containBasicClass,
            this.outboundEndTime,
            this.outboundStartTime,
            this.projectIds,
            this.cutPlateId,
            this.boolCross,
            this.outboundLength,
            this.outboundMete,
            this.convertId,
            this.boolPartyA,
            this.outboundTypeSelection,
            this.approveRecordId,
            this.boolScheduling,
            this.taskOrderId,
            this.taskOrderNumber,
            this.mesWorkshopId,
            this.schedulingDataSource,
            this.schedulingId,
            this.receiveId,
            this.stockGuid,
            this.stockCutGuid,
            this.childOrderNumber,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "Outbound.OutboundBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", recipients="
            + this.recipients
            + ", outboundTime="
            + this.outboundTime
            + ", reviewTime="
            + this.reviewTime
            + ", reviewStatus="
            + this.reviewStatus
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", applicationSn="
            + this.applicationSn
            + ", boolPrinted="
            + this.boolPrinted
            + ", containBasicClass="
            + this.containBasicClass
            + ", outboundEndTime="
            + this.outboundEndTime
            + ", outboundStartTime="
            + this.outboundStartTime
            + ", projectIds="
            + this.projectIds
            + ", cutPlateId="
            + this.cutPlateId
            + ", boolCross="
            + this.boolCross
            + ", outboundLength="
            + this.outboundLength
            + ", outboundMete="
            + this.outboundMete
            + ", convertId="
            + this.convertId
            + ", boolPartyA="
            + this.boolPartyA
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", approveRecordId="
            + this.approveRecordId
            + ", boolScheduling="
            + this.boolScheduling
            + ", taskOrderId="
            + this.taskOrderId
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", mesWorkshopId="
            + this.mesWorkshopId
            + ", schedulingDataSource="
            + this.schedulingDataSource
            + ", schedulingId="
            + this.schedulingId
            + ", receiveId="
            + this.receiveId
            + ", stockGuid="
            + this.stockGuid
            + ", stockCutGuid="
            + this.stockCutGuid
            + ", childOrderNumber="
            + this.childOrderNumber
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
