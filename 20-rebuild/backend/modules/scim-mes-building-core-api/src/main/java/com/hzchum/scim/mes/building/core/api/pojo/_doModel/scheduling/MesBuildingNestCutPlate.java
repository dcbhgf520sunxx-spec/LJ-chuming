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
import javax.persistence.Table;

@ApiModel(value = "MesBuildingNestCutPlate对象", description = "")
@Entity
@TableName("mes_building_nest_cut_plate")
@Table(name = "mes_building_nest_cut_plate")
public class MesBuildingNestCutPlate extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "machinePartSchedulingId", value = "零件工单id", notes = "零件工单id")
   @JsonProperty("machinePartSchedulingId")
   @JSONField(name = "machinePartSchedulingId")
   @TableField("machine_part_scheduling_id")
   @Column(name = "machine_part_scheduling_id", columnDefinition = "bigint(20)  COMMENT '零件工单id'", nullable = false)
   private Long machinePartSchedulingId;
   @ApiModelProperty(name = "nestCutPlateId", value = "切割指令id", notes = "切割指令id")
   @JsonProperty("nestCutPlateId")
   @JSONField(name = "nestCutPlateId")
   @TableField("nest_cut_plate_id")
   @Column(name = "nest_cut_plate_id", columnDefinition = "bigint(20)  COMMENT '切割指令id'", nullable = true)
   private Long nestCutPlateId;
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
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "ncName")
   @JsonProperty("ncName")
   @JSONField(name = "ncName")
   @TableField("nc_name")
   @Column(name = "nc_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String ncName;
   @ApiModelProperty(name = "ncCode", value = "nc文件编号==mes切割指令号", notes = "nc文件编号==mes切割指令号")
   @JsonProperty("ncCode")
   @JSONField(name = "ncCode")
   @TableField("nc_code")
   @Column(name = "nc_code", columnDefinition = "varchar(255)  COMMENT 'nc文件编号==mes切割指令号'", nullable = true)
   private String ncCode;
   @ApiModelProperty(name = "ncUrl", value = "nc文件地址", notes = "nc文件地址")
   @JsonProperty("ncUrl")
   @JSONField(name = "ncUrl")
   @TableField("nc_url")
   @Column(name = "nc_url", columnDefinition = "varchar(255)  COMMENT 'nc文件地址'", nullable = true)
   private String ncUrl;
   @ApiModelProperty(name = "ossKey", value = "oss地址", notes = "oss地址")
   @JsonProperty("ossKey")
   @JSONField(name = "ossKey")
   @TableField("oss_key")
   @Column(name = "oss_key", columnDefinition = "varchar(255)  COMMENT 'oss地址'", nullable = true)
   private String ossKey;
   @ApiModelProperty(name = "plateNo", value = "钢板编号", notes = "钢板编号")
   @JsonProperty("plateNo")
   @JSONField(name = "plateNo")
   @TableField("plate_no")
   @Column(name = "plate_no", columnDefinition = "varchar(255)  COMMENT '钢板编号'", nullable = true)
   private String plateNo;
   @ApiModelProperty(name = "allocateTime")
   @JsonProperty("allocateTime")
   @JSONField(name = "allocateTime")
   @TableField("allocate_time")
   @Column(name = "allocate_time", columnDefinition = "datetime(6)  COMMENT ''", nullable = true)
   private LocalDateTime allocateTime;
   @ApiModelProperty(name = "sendTime")
   @JsonProperty("sendTime")
   @JSONField(name = "sendTime")
   @TableField("send_time")
   @Column(name = "send_time", columnDefinition = "datetime(6)  COMMENT ''", nullable = true)
   private LocalDateTime sendTime;
   @ApiModelProperty(name = "source", value = "来源：0 本地 1 物料系统", notes = "来源：0 本地 1 物料系统")
   @JsonProperty("source")
   @JSONField(name = "source")
   @TableField("source")
   @Column(name = "source", columnDefinition = "varchar(255)  COMMENT '来源：0 本地 1 物料系统'", nullable = true)
   private String source;
   @ApiModelProperty(name = "thick", value = "厚", notes = "厚")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @TableField("thick")
   @Column(name = "thick", columnDefinition = "decimal(19,2)  COMMENT '厚'", nullable = true)
   private BigDecimal thick;
   @ApiModelProperty(name = "cutInstructionId", value = "切割指令号=nc文件编号", notes = "切割指令号=nc文件编号")
   @JsonProperty("cutInstructionId")
   @JSONField(name = "cutInstructionId")
   @TableField("cut_instruction_id")
   @Column(name = "cut_instruction_id", columnDefinition = "varchar(255)  COMMENT '切割指令号=nc文件编号'", nullable = true)
   private String cutInstructionId;
   @ApiModelProperty(name = "num")
   @JsonProperty("num")
   @JSONField(name = "num")
   @TableField("num")
   @Column(name = "num", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String num;
   @ApiModelProperty(name = "width")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal width;
   @ApiModelProperty(name = "weight")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(19,2)  COMMENT ''", nullable = true)
   private BigDecimal weight;
   @ApiModelProperty(name = "boolHaveSurplus")
   @JsonProperty("boolHaveSurplus")
   @JSONField(name = "boolHaveSurplus")
   @TableField("bool_have_surplus")
   @Column(name = "bool_have_surplus", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String boolHaveSurplus;
   @ApiModelProperty(name = "pdfName")
   @JsonProperty("pdfName")
   @JSONField(name = "pdfName")
   @TableField("pdf_name")
   @Column(name = "pdf_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String pdfName;
   @ApiModelProperty(name = "pdfUrl")
   @JsonProperty("pdfUrl")
   @JSONField(name = "pdfUrl")
   @TableField("pdf_url")
   @Column(name = "pdf_url", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String pdfUrl;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @TableField("ask_complete_time")
   @Column(name = "ask_complete_time", columnDefinition = "datetime  COMMENT '要求完成日期'", nullable = true)
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'")
   private Long productionLineId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "issueUserId", value = "下发操作人", notes = "下发操作人")
   @JsonProperty("issueUserId")
   @JSONField(name = "issueUserId")
   @TableField("issue_user_id")
   @Column(name = "issue_user_id", columnDefinition = "bigint(20)  COMMENT '下发操作人'")
   private Long issueUserId;
   @ApiModelProperty(name = "boolIssueEnum", value = "下发状态 [0 未下发 1 已下发]", notes = "下发状态 [0 未下发 1 已下发]")
   @JsonProperty("boolIssueEnum")
   @JSONField(name = "boolIssueEnum")
   @TableField("bool_issue_enum")
   @Column(name = "bool_issue_enum", columnDefinition = "tinyint(1) default '0' COMMENT '下发状态 [0 未下发 1 已下发]'", nullable = false)
   private Boolean boolIssueEnum;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20) default '0' COMMENT '任务工单id'")
   private Long taskOrderId;
   @ApiModelProperty(name = "cutNumber", value = "切割指令号")
   @JsonProperty("cutNumber")
   @JSONField(name = "cutNumber")
   @TableField("cut_number")
   @Column(name = "cut_number", columnDefinition = "varchar(255)  COMMENT '切割指令编号'")
   private String cutNumber;
   @ApiModelProperty(name = "boolProductionEunm", value = "切割指令号")
   @JsonProperty("boolProductionEunm")
   @JSONField(name = "boolProductionEunm")
   @TableField("bool_production_eunm")
   @Column(name = "bool_production_eunm", columnDefinition = "tinyint(1) default '0' COMMENT '下发状态 [0 未生产 1 已生产]'", nullable = false)
   private Boolean boolProductionEunm;
   @ApiModelProperty(name = "schedulingTime", value = "排产时间(本张钢板)", notes = "排产时间(本张钢板)")
   @JsonProperty("schedulingTime")
   @JSONField(name = "schedulingTime")
   @TableField("scheduling_time")
   @Column(name = "scheduling_time", columnDefinition = "datetime  COMMENT '排产时间(本张钢板)'")
   private LocalDateTime schedulingTime;
   @ApiModelProperty(name = "printQuantity", value = "切割打印次数", notes = "打印次数")
   @JsonProperty("cutPrintQuantity")
   @JSONField(name = "cutPrintQuantity")
   @TableField("cut_print_quantity")
   @Column(name = "cut_print_quantity", columnDefinition = "int(11) default '0' COMMENT '切割打印次数'", nullable = false)
   private Integer cutPrintQuantity;
   @ApiModelProperty(name = "holePrintQuantity", value = "钻孔打印次数", notes = "钻孔打印次数")
   @JsonProperty("holePrintQuantity")
   @JSONField(name = "holePrintQuantity")
   @TableField("hole_print_quantity")
   @Column(name = "hole_print_quantity", columnDefinition = "int(11) default '0' COMMENT '钻孔打印次数'", nullable = false)
   private Integer holePrintQuantity;
   @ApiModelProperty(name = "boolNestCutEnum", value = "是否是套料", notes = "是否是套料")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   @TableField("bool_nest_cut_enum")
   @Column(name = "bool_nest_cut_enum", columnDefinition = "tinyint(1) default '1' COMMENT '是否是套料' ", nullable = false)
   private Boolean boolNestCutEnum;
   @ApiModelProperty(name = "boolBindingEnum", value = "是否绑定钢板", notes = "是否绑定钢板")
   @JsonProperty("boolBindingEnum")
   @JSONField(name = "boolBindingEnum")
   @TableField("bool_binding_enum")
   @Column(name = "bool_binding_enum", columnDefinition = "tinyint(1) default '0' COMMENT '是否绑定钢板' ", nullable = false)
   private Boolean boolBindingEnum;
   @ApiModelProperty(name = "bool_off_line", value = "是否线下套料", notes = "是否线下套料")
   @JsonProperty("bool_off_line")
   @JSONField(name = "bool_off_line")
   @TableField("bool_off_line")
   @Column(name = "bool_off_line", columnDefinition = "tinyint(1) default 0  COMMENT '0:否,1:是'", nullable = false)
   private Boolean boolOffLine;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   @TableField("cut_config_id")
   @Column(name = "cut_config_id", columnDefinition = "bigint(20)  COMMENT '切割配置id'")
   private Long cutConfigId;
   @ApiModelProperty(name = "drillCutConfigId", value = "钻孔产线id", notes = "钻孔切割配置id")
   @JsonProperty("drillCutConfigId")
   @JSONField(name = "drillCutConfigId")
   @TableField("drill_cut_config_id")
   @Column(name = "drill_cut_config_id", columnDefinition = "bigint(20)  COMMENT '钻孔切割配置id'")
   private Long drillCutConfigId;

   public static MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder builder() {
      return new MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder();
   }

   public MesBuildingNestCutPlate() {
   }

   public MesBuildingNestCutPlate(
      final Long id,
      final Long machinePartSchedulingId,
      final Long nestCutPlateId,
      final BigDecimal length,
      final String mac,
      final String material,
      final String ncName,
      final String ncCode,
      final String ncUrl,
      final String ossKey,
      final String plateNo,
      final LocalDateTime allocateTime,
      final LocalDateTime sendTime,
      final String source,
      final BigDecimal thick,
      final String cutInstructionId,
      final String num,
      final BigDecimal width,
      final BigDecimal weight,
      final String boolHaveSurplus,
      final String pdfName,
      final String pdfUrl,
      final LocalDateTime askCompleteTime,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long groupsId,
      final Long userId,
      final Long issueUserId,
      final Boolean boolIssueEnum,
      final Long taskOrderId,
      final String cutNumber,
      final Boolean boolProductionEunm,
      final LocalDateTime schedulingTime,
      final Integer cutPrintQuantity,
      final Integer holePrintQuantity,
      final Boolean boolNestCutEnum,
      final Boolean boolBindingEnum,
      final Boolean boolOffLine,
      final Long cutConfigId,
      final Long drillCutConfigId
   ) {
      this.id = id;
      this.machinePartSchedulingId = machinePartSchedulingId;
      this.nestCutPlateId = nestCutPlateId;
      this.length = length;
      this.mac = mac;
      this.material = material;
      this.ncName = ncName;
      this.ncCode = ncCode;
      this.ncUrl = ncUrl;
      this.ossKey = ossKey;
      this.plateNo = plateNo;
      this.allocateTime = allocateTime;
      this.sendTime = sendTime;
      this.source = source;
      this.thick = thick;
      this.cutInstructionId = cutInstructionId;
      this.num = num;
      this.width = width;
      this.weight = weight;
      this.boolHaveSurplus = boolHaveSurplus;
      this.pdfName = pdfName;
      this.pdfUrl = pdfUrl;
      this.askCompleteTime = askCompleteTime;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.groupsId = groupsId;
      this.userId = userId;
      this.issueUserId = issueUserId;
      this.boolIssueEnum = boolIssueEnum;
      this.taskOrderId = taskOrderId;
      this.cutNumber = cutNumber;
      this.boolProductionEunm = boolProductionEunm;
      this.schedulingTime = schedulingTime;
      this.cutPrintQuantity = cutPrintQuantity;
      this.holePrintQuantity = holePrintQuantity;
      this.boolNestCutEnum = boolNestCutEnum;
      this.boolBindingEnum = boolBindingEnum;
      this.boolOffLine = boolOffLine;
      this.cutConfigId = cutConfigId;
      this.drillCutConfigId = drillCutConfigId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMachinePartSchedulingId() {
      return this.machinePartSchedulingId;
   }

   public Long getNestCutPlateId() {
      return this.nestCutPlateId;
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

   public String getNcName() {
      return this.ncName;
   }

   public String getNcCode() {
      return this.ncCode;
   }

   public String getNcUrl() {
      return this.ncUrl;
   }

   public String getOssKey() {
      return this.ossKey;
   }

   public String getPlateNo() {
      return this.plateNo;
   }

   public LocalDateTime getAllocateTime() {
      return this.allocateTime;
   }

   public LocalDateTime getSendTime() {
      return this.sendTime;
   }

   public String getSource() {
      return this.source;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public String getCutInstructionId() {
      return this.cutInstructionId;
   }

   public String getNum() {
      return this.num;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public String getBoolHaveSurplus() {
      return this.boolHaveSurplus;
   }

   public String getPdfName() {
      return this.pdfName;
   }

   public String getPdfUrl() {
      return this.pdfUrl;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getIssueUserId() {
      return this.issueUserId;
   }

   public Boolean getBoolIssueEnum() {
      return this.boolIssueEnum;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getCutNumber() {
      return this.cutNumber;
   }

   public Boolean getBoolProductionEunm() {
      return this.boolProductionEunm;
   }

   public LocalDateTime getSchedulingTime() {
      return this.schedulingTime;
   }

   public Integer getCutPrintQuantity() {
      return this.cutPrintQuantity;
   }

   public Integer getHolePrintQuantity() {
      return this.holePrintQuantity;
   }

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public Boolean getBoolBindingEnum() {
      return this.boolBindingEnum;
   }

   public Boolean getBoolOffLine() {
      return this.boolOffLine;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public Long getDrillCutConfigId() {
      return this.drillCutConfigId;
   }

   @JsonProperty("id")
   public MesBuildingNestCutPlate setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("machinePartSchedulingId")
   public MesBuildingNestCutPlate setMachinePartSchedulingId(final Long machinePartSchedulingId) {
      this.machinePartSchedulingId = machinePartSchedulingId;
      return this;
   }

   @JsonProperty("nestCutPlateId")
   public MesBuildingNestCutPlate setNestCutPlateId(final Long nestCutPlateId) {
      this.nestCutPlateId = nestCutPlateId;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingNestCutPlate setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("mac")
   public MesBuildingNestCutPlate setMac(final String mac) {
      this.mac = mac;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingNestCutPlate setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("ncName")
   public MesBuildingNestCutPlate setNcName(final String ncName) {
      this.ncName = ncName;
      return this;
   }

   @JsonProperty("ncCode")
   public MesBuildingNestCutPlate setNcCode(final String ncCode) {
      this.ncCode = ncCode;
      return this;
   }

   @JsonProperty("ncUrl")
   public MesBuildingNestCutPlate setNcUrl(final String ncUrl) {
      this.ncUrl = ncUrl;
      return this;
   }

   @JsonProperty("ossKey")
   public MesBuildingNestCutPlate setOssKey(final String ossKey) {
      this.ossKey = ossKey;
      return this;
   }

   @JsonProperty("plateNo")
   public MesBuildingNestCutPlate setPlateNo(final String plateNo) {
      this.plateNo = plateNo;
      return this;
   }

   @JsonProperty("allocateTime")
   public MesBuildingNestCutPlate setAllocateTime(final LocalDateTime allocateTime) {
      this.allocateTime = allocateTime;
      return this;
   }

   @JsonProperty("sendTime")
   public MesBuildingNestCutPlate setSendTime(final LocalDateTime sendTime) {
      this.sendTime = sendTime;
      return this;
   }

   @JsonProperty("source")
   public MesBuildingNestCutPlate setSource(final String source) {
      this.source = source;
      return this;
   }

   @JsonProperty("thick")
   public MesBuildingNestCutPlate setThick(final BigDecimal thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("cutInstructionId")
   public MesBuildingNestCutPlate setCutInstructionId(final String cutInstructionId) {
      this.cutInstructionId = cutInstructionId;
      return this;
   }

   @JsonProperty("num")
   public MesBuildingNestCutPlate setNum(final String num) {
      this.num = num;
      return this;
   }

   @JsonProperty("width")
   public MesBuildingNestCutPlate setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("weight")
   public MesBuildingNestCutPlate setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("boolHaveSurplus")
   public MesBuildingNestCutPlate setBoolHaveSurplus(final String boolHaveSurplus) {
      this.boolHaveSurplus = boolHaveSurplus;
      return this;
   }

   @JsonProperty("pdfName")
   public MesBuildingNestCutPlate setPdfName(final String pdfName) {
      this.pdfName = pdfName;
      return this;
   }

   @JsonProperty("pdfUrl")
   public MesBuildingNestCutPlate setPdfUrl(final String pdfUrl) {
      this.pdfUrl = pdfUrl;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingNestCutPlate setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingNestCutPlate setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingNestCutPlate setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingNestCutPlate setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingNestCutPlate setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingNestCutPlate setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("issueUserId")
   public MesBuildingNestCutPlate setIssueUserId(final Long issueUserId) {
      this.issueUserId = issueUserId;
      return this;
   }

   @JsonProperty("boolIssueEnum")
   public MesBuildingNestCutPlate setBoolIssueEnum(final Boolean boolIssueEnum) {
      this.boolIssueEnum = boolIssueEnum;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingNestCutPlate setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("cutNumber")
   public MesBuildingNestCutPlate setCutNumber(final String cutNumber) {
      this.cutNumber = cutNumber;
      return this;
   }

   @JsonProperty("boolProductionEunm")
   public MesBuildingNestCutPlate setBoolProductionEunm(final Boolean boolProductionEunm) {
      this.boolProductionEunm = boolProductionEunm;
      return this;
   }

   @JsonProperty("schedulingTime")
   public MesBuildingNestCutPlate setSchedulingTime(final LocalDateTime schedulingTime) {
      this.schedulingTime = schedulingTime;
      return this;
   }

   @JsonProperty("cutPrintQuantity")
   public MesBuildingNestCutPlate setCutPrintQuantity(final Integer cutPrintQuantity) {
      this.cutPrintQuantity = cutPrintQuantity;
      return this;
   }

   @JsonProperty("holePrintQuantity")
   public MesBuildingNestCutPlate setHolePrintQuantity(final Integer holePrintQuantity) {
      this.holePrintQuantity = holePrintQuantity;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public MesBuildingNestCutPlate setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   @JsonProperty("boolBindingEnum")
   public MesBuildingNestCutPlate setBoolBindingEnum(final Boolean boolBindingEnum) {
      this.boolBindingEnum = boolBindingEnum;
      return this;
   }

   @JsonProperty("bool_off_line")
   public MesBuildingNestCutPlate setBoolOffLine(final Boolean boolOffLine) {
      this.boolOffLine = boolOffLine;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingNestCutPlate setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("drillCutConfigId")
   public MesBuildingNestCutPlate setDrillCutConfigId(final Long drillCutConfigId) {
      this.drillCutConfigId = drillCutConfigId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestCutPlate(id="
         + this.getId()
         + ", machinePartSchedulingId="
         + this.getMachinePartSchedulingId()
         + ", nestCutPlateId="
         + this.getNestCutPlateId()
         + ", length="
         + this.getLength()
         + ", mac="
         + this.getMac()
         + ", material="
         + this.getMaterial()
         + ", ncName="
         + this.getNcName()
         + ", ncCode="
         + this.getNcCode()
         + ", ncUrl="
         + this.getNcUrl()
         + ", ossKey="
         + this.getOssKey()
         + ", plateNo="
         + this.getPlateNo()
         + ", allocateTime="
         + this.getAllocateTime()
         + ", sendTime="
         + this.getSendTime()
         + ", source="
         + this.getSource()
         + ", thick="
         + this.getThick()
         + ", cutInstructionId="
         + this.getCutInstructionId()
         + ", num="
         + this.getNum()
         + ", width="
         + this.getWidth()
         + ", weight="
         + this.getWeight()
         + ", boolHaveSurplus="
         + this.getBoolHaveSurplus()
         + ", pdfName="
         + this.getPdfName()
         + ", pdfUrl="
         + this.getPdfUrl()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", groupsId="
         + this.getGroupsId()
         + ", userId="
         + this.getUserId()
         + ", issueUserId="
         + this.getIssueUserId()
         + ", boolIssueEnum="
         + this.getBoolIssueEnum()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", cutNumber="
         + this.getCutNumber()
         + ", boolProductionEunm="
         + this.getBoolProductionEunm()
         + ", schedulingTime="
         + this.getSchedulingTime()
         + ", cutPrintQuantity="
         + this.getCutPrintQuantity()
         + ", holePrintQuantity="
         + this.getHolePrintQuantity()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", boolBindingEnum="
         + this.getBoolBindingEnum()
         + ", boolOffLine="
         + this.getBoolOffLine()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", drillCutConfigId="
         + this.getDrillCutConfigId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestCutPlate)) {
         return false;
      }

      MesBuildingNestCutPlate other = (MesBuildingNestCutPlate)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$machinePartSchedulingId = this.getMachinePartSchedulingId();
         Object other$machinePartSchedulingId = other.getMachinePartSchedulingId();
         if (this$machinePartSchedulingId == null ? other$machinePartSchedulingId == null : this$machinePartSchedulingId.equals(other$machinePartSchedulingId)) {
            Object this$nestCutPlateId = this.getNestCutPlateId();
            Object other$nestCutPlateId = other.getNestCutPlateId();
            if (this$nestCutPlateId == null ? other$nestCutPlateId == null : this$nestCutPlateId.equals(other$nestCutPlateId)) {
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$productionLineId = this.getProductionLineId();
                     Object other$productionLineId = other.getProductionLineId();
                     if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                        Object this$groupsId = this.getGroupsId();
                        Object other$groupsId = other.getGroupsId();
                        if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$issueUserId = this.getIssueUserId();
                              Object other$issueUserId = other.getIssueUserId();
                              if (this$issueUserId == null ? other$issueUserId == null : this$issueUserId.equals(other$issueUserId)) {
                                 Object this$boolIssueEnum = this.getBoolIssueEnum();
                                 Object other$boolIssueEnum = other.getBoolIssueEnum();
                                 if (this$boolIssueEnum == null ? other$boolIssueEnum == null : this$boolIssueEnum.equals(other$boolIssueEnum)) {
                                    Object this$taskOrderId = this.getTaskOrderId();
                                    Object other$taskOrderId = other.getTaskOrderId();
                                    if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                                       Object this$boolProductionEunm = this.getBoolProductionEunm();
                                       Object other$boolProductionEunm = other.getBoolProductionEunm();
                                       if (this$boolProductionEunm == null
                                          ? other$boolProductionEunm == null
                                          : this$boolProductionEunm.equals(other$boolProductionEunm)) {
                                          Object this$cutPrintQuantity = this.getCutPrintQuantity();
                                          Object other$cutPrintQuantity = other.getCutPrintQuantity();
                                          if (this$cutPrintQuantity == null
                                             ? other$cutPrintQuantity == null
                                             : this$cutPrintQuantity.equals(other$cutPrintQuantity)) {
                                             Object this$holePrintQuantity = this.getHolePrintQuantity();
                                             Object other$holePrintQuantity = other.getHolePrintQuantity();
                                             if (this$holePrintQuantity == null
                                                ? other$holePrintQuantity == null
                                                : this$holePrintQuantity.equals(other$holePrintQuantity)) {
                                                Object this$boolNestCutEnum = this.getBoolNestCutEnum();
                                                Object other$boolNestCutEnum = other.getBoolNestCutEnum();
                                                if (this$boolNestCutEnum == null
                                                   ? other$boolNestCutEnum == null
                                                   : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
                                                   Object this$boolBindingEnum = this.getBoolBindingEnum();
                                                   Object other$boolBindingEnum = other.getBoolBindingEnum();
                                                   if (this$boolBindingEnum == null
                                                      ? other$boolBindingEnum == null
                                                      : this$boolBindingEnum.equals(other$boolBindingEnum)) {
                                                      Object this$boolOffLine = this.getBoolOffLine();
                                                      Object other$boolOffLine = other.getBoolOffLine();
                                                      if (this$boolOffLine == null ? other$boolOffLine == null : this$boolOffLine.equals(other$boolOffLine)) {
                                                         Object this$cutConfigId = this.getCutConfigId();
                                                         Object other$cutConfigId = other.getCutConfigId();
                                                         if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
                                                            Object this$drillCutConfigId = this.getDrillCutConfigId();
                                                            Object other$drillCutConfigId = other.getDrillCutConfigId();
                                                            if (this$drillCutConfigId == null
                                                               ? other$drillCutConfigId == null
                                                               : this$drillCutConfigId.equals(other$drillCutConfigId)) {
                                                               Object this$length = this.getLength();
                                                               Object other$length = other.getLength();
                                                               if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                  Object this$mac = this.getMac();
                                                                  Object other$mac = other.getMac();
                                                                  if (this$mac == null ? other$mac == null : this$mac.equals(other$mac)) {
                                                                     Object this$material = this.getMaterial();
                                                                     Object other$material = other.getMaterial();
                                                                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                                        Object this$ncName = this.getNcName();
                                                                        Object other$ncName = other.getNcName();
                                                                        if (this$ncName == null ? other$ncName == null : this$ncName.equals(other$ncName)) {
                                                                           Object this$ncCode = this.getNcCode();
                                                                           Object other$ncCode = other.getNcCode();
                                                                           if (this$ncCode == null ? other$ncCode == null : this$ncCode.equals(other$ncCode)) {
                                                                              Object this$ncUrl = this.getNcUrl();
                                                                              Object other$ncUrl = other.getNcUrl();
                                                                              if (this$ncUrl == null ? other$ncUrl == null : this$ncUrl.equals(other$ncUrl)) {
                                                                                 Object this$ossKey = this.getOssKey();
                                                                                 Object other$ossKey = other.getOssKey();
                                                                                 if (this$ossKey == null
                                                                                    ? other$ossKey == null
                                                                                    : this$ossKey.equals(other$ossKey)) {
                                                                                    Object this$plateNo = this.getPlateNo();
                                                                                    Object other$plateNo = other.getPlateNo();
                                                                                    if (this$plateNo == null
                                                                                       ? other$plateNo == null
                                                                                       : this$plateNo.equals(other$plateNo)) {
                                                                                       Object this$allocateTime = this.getAllocateTime();
                                                                                       Object other$allocateTime = other.getAllocateTime();
                                                                                       if (this$allocateTime == null
                                                                                          ? other$allocateTime == null
                                                                                          : this$allocateTime.equals(other$allocateTime)) {
                                                                                          Object this$sendTime = this.getSendTime();
                                                                                          Object other$sendTime = other.getSendTime();
                                                                                          if (this$sendTime == null
                                                                                             ? other$sendTime == null
                                                                                             : this$sendTime.equals(other$sendTime)) {
                                                                                             Object this$source = this.getSource();
                                                                                             Object other$source = other.getSource();
                                                                                             if (this$source == null
                                                                                                ? other$source == null
                                                                                                : this$source.equals(other$source)) {
                                                                                                Object this$thick = this.getThick();
                                                                                                Object other$thick = other.getThick();
                                                                                                if (this$thick == null
                                                                                                   ? other$thick == null
                                                                                                   : this$thick.equals(other$thick)) {
                                                                                                   Object this$cutInstructionId = this.getCutInstructionId();
                                                                                                   Object other$cutInstructionId = other.getCutInstructionId();
                                                                                                   if (this$cutInstructionId == null
                                                                                                      ? other$cutInstructionId == null
                                                                                                      : this$cutInstructionId.equals(other$cutInstructionId)) {
                                                                                                      Object this$num = this.getNum();
                                                                                                      Object other$num = other.getNum();
                                                                                                      if (this$num == null
                                                                                                         ? other$num == null
                                                                                                         : this$num.equals(other$num)) {
                                                                                                         Object this$width = this.getWidth();
                                                                                                         Object other$width = other.getWidth();
                                                                                                         if (this$width == null
                                                                                                            ? other$width == null
                                                                                                            : this$width.equals(other$width)) {
                                                                                                            Object this$weight = this.getWeight();
                                                                                                            Object other$weight = other.getWeight();
                                                                                                            if (this$weight == null
                                                                                                               ? other$weight == null
                                                                                                               : this$weight.equals(other$weight)) {
                                                                                                               Object this$boolHaveSurplus = this.getBoolHaveSurplus();
                                                                                                               Object other$boolHaveSurplus = other.getBoolHaveSurplus();
                                                                                                               if (this$boolHaveSurplus == null
                                                                                                                  ? other$boolHaveSurplus == null
                                                                                                                  : this$boolHaveSurplus.equals(
                                                                                                                     other$boolHaveSurplus
                                                                                                                  )) {
                                                                                                                  Object this$pdfName = this.getPdfName();
                                                                                                                  Object other$pdfName = other.getPdfName();
                                                                                                                  if (this$pdfName == null
                                                                                                                     ? other$pdfName == null
                                                                                                                     : this$pdfName.equals(other$pdfName)) {
                                                                                                                     Object this$pdfUrl = this.getPdfUrl();
                                                                                                                     Object other$pdfUrl = other.getPdfUrl();
                                                                                                                     if (this$pdfUrl == null
                                                                                                                        ? other$pdfUrl == null
                                                                                                                        : this$pdfUrl.equals(other$pdfUrl)) {
                                                                                                                        Object this$askCompleteTime = this.getAskCompleteTime();
                                                                                                                        Object other$askCompleteTime = other.getAskCompleteTime();
                                                                                                                        if (this$askCompleteTime == null
                                                                                                                           ? other$askCompleteTime == null
                                                                                                                           : this$askCompleteTime.equals(
                                                                                                                              other$askCompleteTime
                                                                                                                           )) {
                                                                                                                           Object this$cutNumber = this.getCutNumber();
                                                                                                                           Object other$cutNumber = other.getCutNumber();
                                                                                                                           if (this$cutNumber == null
                                                                                                                              ? other$cutNumber == null
                                                                                                                              : this$cutNumber.equals(
                                                                                                                                 other$cutNumber
                                                                                                                              )) {
                                                                                                                              Object this$schedulingTime = this.getSchedulingTime();
                                                                                                                              Object other$schedulingTime = other.getSchedulingTime();
                                                                                                                              return this$schedulingTime
                                                                                                                                    == null
                                                                                                                                 ? other$schedulingTime == null
                                                                                                                                 : this$schedulingTime.equals(
                                                                                                                                    other$schedulingTime
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingNestCutPlate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $machinePartSchedulingId = this.getMachinePartSchedulingId();
      result = result * 59 + ($machinePartSchedulingId == null ? 43 : $machinePartSchedulingId.hashCode());
      Object $nestCutPlateId = this.getNestCutPlateId();
      result = result * 59 + ($nestCutPlateId == null ? 43 : $nestCutPlateId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $issueUserId = this.getIssueUserId();
      result = result * 59 + ($issueUserId == null ? 43 : $issueUserId.hashCode());
      Object $boolIssueEnum = this.getBoolIssueEnum();
      result = result * 59 + ($boolIssueEnum == null ? 43 : $boolIssueEnum.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $boolProductionEunm = this.getBoolProductionEunm();
      result = result * 59 + ($boolProductionEunm == null ? 43 : $boolProductionEunm.hashCode());
      Object $cutPrintQuantity = this.getCutPrintQuantity();
      result = result * 59 + ($cutPrintQuantity == null ? 43 : $cutPrintQuantity.hashCode());
      Object $holePrintQuantity = this.getHolePrintQuantity();
      result = result * 59 + ($holePrintQuantity == null ? 43 : $holePrintQuantity.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $boolBindingEnum = this.getBoolBindingEnum();
      result = result * 59 + ($boolBindingEnum == null ? 43 : $boolBindingEnum.hashCode());
      Object $boolOffLine = this.getBoolOffLine();
      result = result * 59 + ($boolOffLine == null ? 43 : $boolOffLine.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $drillCutConfigId = this.getDrillCutConfigId();
      result = result * 59 + ($drillCutConfigId == null ? 43 : $drillCutConfigId.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $mac = this.getMac();
      result = result * 59 + ($mac == null ? 43 : $mac.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $ncName = this.getNcName();
      result = result * 59 + ($ncName == null ? 43 : $ncName.hashCode());
      Object $ncCode = this.getNcCode();
      result = result * 59 + ($ncCode == null ? 43 : $ncCode.hashCode());
      Object $ncUrl = this.getNcUrl();
      result = result * 59 + ($ncUrl == null ? 43 : $ncUrl.hashCode());
      Object $ossKey = this.getOssKey();
      result = result * 59 + ($ossKey == null ? 43 : $ossKey.hashCode());
      Object $plateNo = this.getPlateNo();
      result = result * 59 + ($plateNo == null ? 43 : $plateNo.hashCode());
      Object $allocateTime = this.getAllocateTime();
      result = result * 59 + ($allocateTime == null ? 43 : $allocateTime.hashCode());
      Object $sendTime = this.getSendTime();
      result = result * 59 + ($sendTime == null ? 43 : $sendTime.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $cutInstructionId = this.getCutInstructionId();
      result = result * 59 + ($cutInstructionId == null ? 43 : $cutInstructionId.hashCode());
      Object $num = this.getNum();
      result = result * 59 + ($num == null ? 43 : $num.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $boolHaveSurplus = this.getBoolHaveSurplus();
      result = result * 59 + ($boolHaveSurplus == null ? 43 : $boolHaveSurplus.hashCode());
      Object $pdfName = this.getPdfName();
      result = result * 59 + ($pdfName == null ? 43 : $pdfName.hashCode());
      Object $pdfUrl = this.getPdfUrl();
      result = result * 59 + ($pdfUrl == null ? 43 : $pdfUrl.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $cutNumber = this.getCutNumber();
      result = result * 59 + ($cutNumber == null ? 43 : $cutNumber.hashCode());
      Object $schedulingTime = this.getSchedulingTime();
      return result * 59 + ($schedulingTime == null ? 43 : $schedulingTime.hashCode());
   }

   public static class MesBuildingNestCutPlateBuilder {
      private Long id;
      private Long machinePartSchedulingId;
      private Long nestCutPlateId;
      private BigDecimal length;
      private String mac;
      private String material;
      private String ncName;
      private String ncCode;
      private String ncUrl;
      private String ossKey;
      private String plateNo;
      private LocalDateTime allocateTime;
      private LocalDateTime sendTime;
      private String source;
      private BigDecimal thick;
      private String cutInstructionId;
      private String num;
      private BigDecimal width;
      private BigDecimal weight;
      private String boolHaveSurplus;
      private String pdfName;
      private String pdfUrl;
      private LocalDateTime askCompleteTime;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long groupsId;
      private Long userId;
      private Long issueUserId;
      private Boolean boolIssueEnum;
      private Long taskOrderId;
      private String cutNumber;
      private Boolean boolProductionEunm;
      private LocalDateTime schedulingTime;
      private Integer cutPrintQuantity;
      private Integer holePrintQuantity;
      private Boolean boolNestCutEnum;
      private Boolean boolBindingEnum;
      private Boolean boolOffLine;
      private Long cutConfigId;
      private Long drillCutConfigId;

      MesBuildingNestCutPlateBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("machinePartSchedulingId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder machinePartSchedulingId(final Long machinePartSchedulingId) {
         this.machinePartSchedulingId = machinePartSchedulingId;
         return this;
      }

      @JsonProperty("nestCutPlateId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder nestCutPlateId(final Long nestCutPlateId) {
         this.nestCutPlateId = nestCutPlateId;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("mac")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder mac(final String mac) {
         this.mac = mac;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("ncName")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder ncName(final String ncName) {
         this.ncName = ncName;
         return this;
      }

      @JsonProperty("ncCode")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder ncCode(final String ncCode) {
         this.ncCode = ncCode;
         return this;
      }

      @JsonProperty("ncUrl")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder ncUrl(final String ncUrl) {
         this.ncUrl = ncUrl;
         return this;
      }

      @JsonProperty("ossKey")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder ossKey(final String ossKey) {
         this.ossKey = ossKey;
         return this;
      }

      @JsonProperty("plateNo")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder plateNo(final String plateNo) {
         this.plateNo = plateNo;
         return this;
      }

      @JsonProperty("allocateTime")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder allocateTime(final LocalDateTime allocateTime) {
         this.allocateTime = allocateTime;
         return this;
      }

      @JsonProperty("sendTime")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder sendTime(final LocalDateTime sendTime) {
         this.sendTime = sendTime;
         return this;
      }

      @JsonProperty("source")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder source(final String source) {
         this.source = source;
         return this;
      }

      @JsonProperty("thick")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("cutInstructionId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder cutInstructionId(final String cutInstructionId) {
         this.cutInstructionId = cutInstructionId;
         return this;
      }

      @JsonProperty("num")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder num(final String num) {
         this.num = num;
         return this;
      }

      @JsonProperty("width")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("weight")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("boolHaveSurplus")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder boolHaveSurplus(final String boolHaveSurplus) {
         this.boolHaveSurplus = boolHaveSurplus;
         return this;
      }

      @JsonProperty("pdfName")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder pdfName(final String pdfName) {
         this.pdfName = pdfName;
         return this;
      }

      @JsonProperty("pdfUrl")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder pdfUrl(final String pdfUrl) {
         this.pdfUrl = pdfUrl;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("issueUserId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder issueUserId(final Long issueUserId) {
         this.issueUserId = issueUserId;
         return this;
      }

      @JsonProperty("boolIssueEnum")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder boolIssueEnum(final Boolean boolIssueEnum) {
         this.boolIssueEnum = boolIssueEnum;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("cutNumber")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder cutNumber(final String cutNumber) {
         this.cutNumber = cutNumber;
         return this;
      }

      @JsonProperty("boolProductionEunm")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder boolProductionEunm(final Boolean boolProductionEunm) {
         this.boolProductionEunm = boolProductionEunm;
         return this;
      }

      @JsonProperty("schedulingTime")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder schedulingTime(final LocalDateTime schedulingTime) {
         this.schedulingTime = schedulingTime;
         return this;
      }

      @JsonProperty("cutPrintQuantity")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder cutPrintQuantity(final Integer cutPrintQuantity) {
         this.cutPrintQuantity = cutPrintQuantity;
         return this;
      }

      @JsonProperty("holePrintQuantity")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder holePrintQuantity(final Integer holePrintQuantity) {
         this.holePrintQuantity = holePrintQuantity;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      @JsonProperty("boolBindingEnum")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder boolBindingEnum(final Boolean boolBindingEnum) {
         this.boolBindingEnum = boolBindingEnum;
         return this;
      }

      @JsonProperty("bool_off_line")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder boolOffLine(final Boolean boolOffLine) {
         this.boolOffLine = boolOffLine;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("drillCutConfigId")
      public MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder drillCutConfigId(final Long drillCutConfigId) {
         this.drillCutConfigId = drillCutConfigId;
         return this;
      }

      public MesBuildingNestCutPlate build() {
         return new MesBuildingNestCutPlate(
            this.id,
            this.machinePartSchedulingId,
            this.nestCutPlateId,
            this.length,
            this.mac,
            this.material,
            this.ncName,
            this.ncCode,
            this.ncUrl,
            this.ossKey,
            this.plateNo,
            this.allocateTime,
            this.sendTime,
            this.source,
            this.thick,
            this.cutInstructionId,
            this.num,
            this.width,
            this.weight,
            this.boolHaveSurplus,
            this.pdfName,
            this.pdfUrl,
            this.askCompleteTime,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.groupsId,
            this.userId,
            this.issueUserId,
            this.boolIssueEnum,
            this.taskOrderId,
            this.cutNumber,
            this.boolProductionEunm,
            this.schedulingTime,
            this.cutPrintQuantity,
            this.holePrintQuantity,
            this.boolNestCutEnum,
            this.boolBindingEnum,
            this.boolOffLine,
            this.cutConfigId,
            this.drillCutConfigId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNestCutPlate.MesBuildingNestCutPlateBuilder(id="
            + this.id
            + ", machinePartSchedulingId="
            + this.machinePartSchedulingId
            + ", nestCutPlateId="
            + this.nestCutPlateId
            + ", length="
            + this.length
            + ", mac="
            + this.mac
            + ", material="
            + this.material
            + ", ncName="
            + this.ncName
            + ", ncCode="
            + this.ncCode
            + ", ncUrl="
            + this.ncUrl
            + ", ossKey="
            + this.ossKey
            + ", plateNo="
            + this.plateNo
            + ", allocateTime="
            + this.allocateTime
            + ", sendTime="
            + this.sendTime
            + ", source="
            + this.source
            + ", thick="
            + this.thick
            + ", cutInstructionId="
            + this.cutInstructionId
            + ", num="
            + this.num
            + ", width="
            + this.width
            + ", weight="
            + this.weight
            + ", boolHaveSurplus="
            + this.boolHaveSurplus
            + ", pdfName="
            + this.pdfName
            + ", pdfUrl="
            + this.pdfUrl
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", groupsId="
            + this.groupsId
            + ", userId="
            + this.userId
            + ", issueUserId="
            + this.issueUserId
            + ", boolIssueEnum="
            + this.boolIssueEnum
            + ", taskOrderId="
            + this.taskOrderId
            + ", cutNumber="
            + this.cutNumber
            + ", boolProductionEunm="
            + this.boolProductionEunm
            + ", schedulingTime="
            + this.schedulingTime
            + ", cutPrintQuantity="
            + this.cutPrintQuantity
            + ", holePrintQuantity="
            + this.holePrintQuantity
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", boolBindingEnum="
            + this.boolBindingEnum
            + ", boolOffLine="
            + this.boolOffLine
            + ", cutConfigId="
            + this.cutConfigId
            + ", drillCutConfigId="
            + this.drillCutConfigId
            + ")";
      }
   }
}
