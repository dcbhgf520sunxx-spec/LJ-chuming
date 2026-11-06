package com.hzchum.scim.iot.core.api.pojo._doModel.equipment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "EquipmentInfo对象", description = "设备信息表")
@Entity
@TableName("equipment_info")
@Table(name = "equipment_info")
@org.hibernate.annotations.Table(appliesTo = "equipment_info", comment = "设备信息表")
public class EquipmentInfo extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "业务主键", notes = "业务主键")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "iotId", value = "物联主键", notes = "物联主键")
   @TableField("iot_id")
   @Column(name = "iot_id", columnDefinition = "bigint(20)  COMMENT '物联主键'", nullable = true)
   private Long iotId;
   @ApiModelProperty(name = "equipmentCode", value = "设备编码", notes = "设备编码")
   @TableField("equipment_code")
   @Column(name = "equipment_code", columnDefinition = "varchar(255)  COMMENT '设备编码'", nullable = true)
   private String equipmentCode;
   @ApiModelProperty(name = "equipmentName", value = "设备名称", notes = "设备名称")
   @TableField("equipment_name")
   @Column(name = "equipment_name", columnDefinition = "varchar(255)  COMMENT '设备名称'", nullable = false)
   private String equipmentName;
   @ApiModelProperty(name = "equipmentTypeId", value = "设备类别id", notes = "设备类别id")
   @TableField("equipment_type_id")
   @Column(name = "equipment_type_id", columnDefinition = "bigint(20)  COMMENT '设备类别id'", nullable = true)
   private Long equipmentTypeId;
   @ApiModelProperty(name = "equipmentStorageApplyId", value = "设备入库申请单id", notes = "设备入库申请单id")
   @TableField("equipment_storage_apply_id")
   @Column(name = "equipment_storage_apply_id", columnDefinition = "bigint(20)  COMMENT '设备入库申请单id'", nullable = true)
   private Long equipmentStorageApplyId;
   @ApiModelProperty(name = "equipmentSerialNumber", value = "设备序列号", notes = "设备序列号")
   @TableField("equipment_serial_number")
   @Column(name = "equipment_serial_number", columnDefinition = "varchar(255)  COMMENT '设备序列号'", nullable = true)
   private String equipmentSerialNumber;
   @ApiModelProperty(name = "equipmentModelNumber", value = "设备型号", notes = "设备型号")
   @TableField("equipment_model_number")
   @Column(name = "equipment_model_number", columnDefinition = "varchar(255)  COMMENT '设备型号'", nullable = true)
   private String equipmentModelNumber;
   @ApiModelProperty(name = "equipmentSpec", value = "设备规格", notes = "设备规格")
   @TableField("equipment_spec")
   @Column(name = "equipment_spec", columnDefinition = "varchar(255)  COMMENT '设备规格'", nullable = true)
   private String equipmentSpec;
   @ApiModelProperty(name = "status", value = "设备状态枚举", notes = "设备状态枚举")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11)  COMMENT '设备状态枚举'", nullable = true)
   private Integer status;
   @ApiModelProperty(name = "useStatus", value = "使用状态枚举", notes = "使用状态枚举")
   @TableField("use_status")
   @Column(name = "use_status", columnDefinition = "int(11)  COMMENT '使用状态枚举'", nullable = true)
   private Integer useStatus;
   @ApiModelProperty(name = "auditStatus", value = "设备审核状态枚举,冗余该字段方便检索", notes = "设备审核状态枚举,冗余该字段方便检索")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11)  COMMENT '设备审核状态枚举,冗余该字段方便检索'", nullable = true)
   private Integer auditStatus;
   @ApiModelProperty(name = "managerBy", value = "管理人id", notes = "管理人id")
   @TableField("manager_by")
   @Column(name = "manager_by", columnDefinition = "bigint(20)  COMMENT '管理人id'", nullable = true)
   private Long managerBy;
   @ApiModelProperty(name = "receiveBy", value = "领用人id", notes = "领用人id")
   @TableField("receive_by")
   @Column(name = "receive_by", columnDefinition = "bigint(20)  COMMENT '领用人id'", nullable = true)
   private Long receiveBy;
   @ApiModelProperty(name = "receiveDepartmentId", value = "领用部门id", notes = "领用部门id")
   @TableField("receive_department_id")
   @Column(name = "receive_department_id", columnDefinition = "bigint(20)  COMMENT '领用部门id'", nullable = true)
   private Long receiveDepartmentId;
   @ApiModelProperty(name = "areaId", value = "所在区域id", notes = "所在区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '所在区域id'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "buyTime", value = "购置日期", notes = "购置日期")
   @TableField("buy_time")
   @Column(name = "buy_time", columnDefinition = "datetime  COMMENT '购置日期'", nullable = true)
   private LocalDateTime buyTime;
   @ApiModelProperty(name = "suppliers", value = "供应商", notes = "供应商")
   @TableField("suppliers")
   @Column(name = "suppliers", columnDefinition = "varchar(255)  COMMENT '供应商'", nullable = true)
   private String suppliers;
   @ApiModelProperty(name = "manufacturer", value = "制造商", notes = "制造商")
   @TableField("manufacturer")
   @Column(name = "manufacturer", columnDefinition = "varchar(255)  COMMENT '制造商'", nullable = true)
   private String manufacturer;
   @ApiModelProperty(name = "originalPrice", value = "原始价格(元) ", notes = "原始价格(元) ")
   @TableField("original_price")
   @Column(name = "original_price", columnDefinition = "decimal(10,2)  COMMENT '原始价格(元) '", nullable = true)
   private BigDecimal originalPrice;
   @ApiModelProperty(name = "useLife", value = "使用期限(月)", notes = "使用期限(月)")
   @TableField("use_life")
   @Column(name = "use_life", columnDefinition = "int(11)  COMMENT '使用期限(月)'", nullable = true)
   private Integer useLife;
   @ApiModelProperty(name = "alreadyUsedLife", value = "已经使用期限(月),暂不确定是否随时间自动增加", notes = "已经使用期限(月),暂不确定是否随时间自动增加")
   @TableField("already_used_life")
   @Column(name = "already_used_life", columnDefinition = "int(11)  COMMENT '已经使用期限(月),暂不确定是否随时间自动增加'", nullable = true)
   private Integer alreadyUsedLife;
   @ApiModelProperty(name = "depreciationId", value = "折旧方式id", notes = "折旧方式id")
   @TableField("depreciation_id")
   @Column(name = "depreciation_id", columnDefinition = "int(11)  COMMENT '折旧方式id'", nullable = true)
   private Integer depreciationId;
   @ApiModelProperty(name = "depreciationAmount", value = "累计折旧额", notes = "累计折旧额")
   @TableField("depreciation_amount")
   @Column(name = "depreciation_amount", columnDefinition = "decimal(10,2)  COMMENT '累计折旧额'", nullable = true)
   private BigDecimal depreciationAmount;
   @ApiModelProperty(name = "currentPrice", value = "现价(元)", notes = "现价(元)")
   @TableField("current_price")
   @Column(name = "current_price", columnDefinition = "decimal(10,2)  COMMENT '现价(元)'", nullable = true)
   private BigDecimal currentPrice;
   @ApiModelProperty(name = "createBy", value = "创建人标识", notes = "创建人标识")
   @TableField("create_by")
   @Column(name = "create_by", columnDefinition = "bigint(20)  COMMENT '创建人标识'", nullable = true)
   private Long createBy;
   @ApiModelProperty(name = "updateBy", value = "更新人标识", notes = "更新人标识")
   @TableField("update_by")
   @Column(name = "update_by", columnDefinition = "bigint(20)  COMMENT '更新人标识'", nullable = true)
   private Long updateBy;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "insideCode", value = "本部编号", notes = "本部编号")
   @TableField("inside_code")
   @Column(name = "inside_code", columnDefinition = "varchar(255)  COMMENT '本部编号'", nullable = true)
   private String insideCode;
   @ApiModelProperty(name = "concreteArea", value = "具体位置", notes = "具体位置")
   @TableField("concrete_area")
   @Column(name = "concrete_area", columnDefinition = "varchar(255)  COMMENT '具体位置'", nullable = true)
   private String concreteArea;
   @ApiModelProperty(name = "mid", value = "mid", notes = "mid")
   @TableField("mid")
   @Column(name = "mid", columnDefinition = "int(11)  COMMENT 'mid'", nullable = true)
   private Integer mid;
   @ApiModelProperty(name = "fixedAssetsCode", value = "固定资产编号", notes = "固定资产编号")
   @TableField("fixed_assets_code")
   @Column(name = "fixed_assets_code", columnDefinition = "varchar(255)  COMMENT '固定资产编号'", nullable = true)
   private String fixedAssetsCode;
   @ApiModelProperty(name = "outCode", value = "出厂编号", notes = "出厂编号")
   @TableField("out_code")
   @Column(name = "out_code", columnDefinition = "varchar(255)  COMMENT '出厂编号'", nullable = true)
   private String outCode;
   @ApiModelProperty(name = "enterTime", value = "入库时间", notes = "入库时间")
   @TableField("enter_time")
   @Column(name = "enter_time", columnDefinition = "datetime  COMMENT '入库时间'", nullable = true)
   private LocalDateTime enterTime;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "prodLineId", value = "产线id", notes = "产线id")
   @TableField("prod_line_id")
   @Column(name = "prod_line_id", columnDefinition = "bigint(20)  COMMENT '产线id'", nullable = true)
   private Long prodLineId;
   @ApiModelProperty(name = "stationId", value = "工位id", notes = "工位id")
   @TableField("station_id")
   @Column(name = "station_id", columnDefinition = "bigint(20)  COMMENT '工位id'", nullable = true)
   private Long stationId;
   @ApiModelProperty(name = "isNetworking", value = "是否联网(1是，2否)", notes = "是否联网(1是，2否)")
   @TableField("is_networking")
   @Column(name = "is_networking", columnDefinition = "int(11)  COMMENT '是否联网(1是，2否)'", nullable = true)
   private Integer isNetworking;
   @ApiModelProperty(name = "ameterId", value = "电表mid", notes = "电表mid")
   @TableField("ameter_id")
   @Column(name = "ameter_id", columnDefinition = "int(11)  COMMENT '电表mid'", nullable = true)
   private Integer ameterId;
   @ApiModelProperty(name = "gasMeterId", value = "气表mid", notes = "气表mid")
   @TableField("gas_meter_id")
   @Column(name = "gas_meter_id", columnDefinition = "int(11)  COMMENT '气表mid'", nullable = true)
   private Integer gasMeterId;
   @ApiModelProperty(name = "runType", value = "运行状态1、关机|2、运行|3、调试|4、空闲|5、报警", notes = "运行状态1、关机|2、运行|3、调试|4、空闲|5、报警")
   @TableField("run_type")
   @Column(name = "run_type", columnDefinition = "int(11)  COMMENT '运行状态1、关机|2、运行|3、调试|4、空闲|5、报警'", nullable = true)
   private Integer runType;
   @ApiModelProperty(name = "maintenanceType", value = "维修状态", notes = "维修状态")
   @TableField("maintenance_type")
   @Column(name = "maintenance_type", columnDefinition = "int(11)  COMMENT '维修状态'", nullable = true)
   private Integer maintenanceType;

   public static EquipmentInfo.EquipmentInfoBuilder builder() {
      return new EquipmentInfo.EquipmentInfoBuilder();
   }

   public EquipmentInfo() {
   }

   public EquipmentInfo(
      final Long id,
      final Long iotId,
      final String equipmentCode,
      final String equipmentName,
      final Long equipmentTypeId,
      final Long equipmentStorageApplyId,
      final String equipmentSerialNumber,
      final String equipmentModelNumber,
      final String equipmentSpec,
      final Integer status,
      final Integer useStatus,
      final Integer auditStatus,
      final Long managerBy,
      final Long receiveBy,
      final Long receiveDepartmentId,
      final Long areaId,
      final LocalDateTime buyTime,
      final String suppliers,
      final String manufacturer,
      final BigDecimal originalPrice,
      final Integer useLife,
      final Integer alreadyUsedLife,
      final Integer depreciationId,
      final BigDecimal depreciationAmount,
      final BigDecimal currentPrice,
      final Long createBy,
      final Long updateBy,
      final String remark,
      final String insideCode,
      final String concreteArea,
      final Integer mid,
      final String fixedAssetsCode,
      final String outCode,
      final LocalDateTime enterTime,
      final Long workshopId,
      final Long prodLineId,
      final Long stationId,
      final Integer isNetworking,
      final Integer ameterId,
      final Integer gasMeterId,
      final Integer runType,
      final Integer maintenanceType
   ) {
      this.id = id;
      this.iotId = iotId;
      this.equipmentCode = equipmentCode;
      this.equipmentName = equipmentName;
      this.equipmentTypeId = equipmentTypeId;
      this.equipmentStorageApplyId = equipmentStorageApplyId;
      this.equipmentSerialNumber = equipmentSerialNumber;
      this.equipmentModelNumber = equipmentModelNumber;
      this.equipmentSpec = equipmentSpec;
      this.status = status;
      this.useStatus = useStatus;
      this.auditStatus = auditStatus;
      this.managerBy = managerBy;
      this.receiveBy = receiveBy;
      this.receiveDepartmentId = receiveDepartmentId;
      this.areaId = areaId;
      this.buyTime = buyTime;
      this.suppliers = suppliers;
      this.manufacturer = manufacturer;
      this.originalPrice = originalPrice;
      this.useLife = useLife;
      this.alreadyUsedLife = alreadyUsedLife;
      this.depreciationId = depreciationId;
      this.depreciationAmount = depreciationAmount;
      this.currentPrice = currentPrice;
      this.createBy = createBy;
      this.updateBy = updateBy;
      this.remark = remark;
      this.insideCode = insideCode;
      this.concreteArea = concreteArea;
      this.mid = mid;
      this.fixedAssetsCode = fixedAssetsCode;
      this.outCode = outCode;
      this.enterTime = enterTime;
      this.workshopId = workshopId;
      this.prodLineId = prodLineId;
      this.stationId = stationId;
      this.isNetworking = isNetworking;
      this.ameterId = ameterId;
      this.gasMeterId = gasMeterId;
      this.runType = runType;
      this.maintenanceType = maintenanceType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getIotId() {
      return this.iotId;
   }

   public String getEquipmentCode() {
      return this.equipmentCode;
   }

   public String getEquipmentName() {
      return this.equipmentName;
   }

   public Long getEquipmentTypeId() {
      return this.equipmentTypeId;
   }

   public Long getEquipmentStorageApplyId() {
      return this.equipmentStorageApplyId;
   }

   public String getEquipmentSerialNumber() {
      return this.equipmentSerialNumber;
   }

   public String getEquipmentModelNumber() {
      return this.equipmentModelNumber;
   }

   public String getEquipmentSpec() {
      return this.equipmentSpec;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getUseStatus() {
      return this.useStatus;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getManagerBy() {
      return this.managerBy;
   }

   public Long getReceiveBy() {
      return this.receiveBy;
   }

   public Long getReceiveDepartmentId() {
      return this.receiveDepartmentId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public LocalDateTime getBuyTime() {
      return this.buyTime;
   }

   public String getSuppliers() {
      return this.suppliers;
   }

   public String getManufacturer() {
      return this.manufacturer;
   }

   public BigDecimal getOriginalPrice() {
      return this.originalPrice;
   }

   public Integer getUseLife() {
      return this.useLife;
   }

   public Integer getAlreadyUsedLife() {
      return this.alreadyUsedLife;
   }

   public Integer getDepreciationId() {
      return this.depreciationId;
   }

   public BigDecimal getDepreciationAmount() {
      return this.depreciationAmount;
   }

   public BigDecimal getCurrentPrice() {
      return this.currentPrice;
   }

   public Long getCreateBy() {
      return this.createBy;
   }

   public Long getUpdateBy() {
      return this.updateBy;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getInsideCode() {
      return this.insideCode;
   }

   public String getConcreteArea() {
      return this.concreteArea;
   }

   public Integer getMid() {
      return this.mid;
   }

   public String getFixedAssetsCode() {
      return this.fixedAssetsCode;
   }

   public String getOutCode() {
      return this.outCode;
   }

   public LocalDateTime getEnterTime() {
      return this.enterTime;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProdLineId() {
      return this.prodLineId;
   }

   public Long getStationId() {
      return this.stationId;
   }

   public Integer getIsNetworking() {
      return this.isNetworking;
   }

   public Integer getAmeterId() {
      return this.ameterId;
   }

   public Integer getGasMeterId() {
      return this.gasMeterId;
   }

   public Integer getRunType() {
      return this.runType;
   }

   public Integer getMaintenanceType() {
      return this.maintenanceType;
   }

   public EquipmentInfo setId(final Long id) {
      this.id = id;
      return this;
   }

   public EquipmentInfo setIotId(final Long iotId) {
      this.iotId = iotId;
      return this;
   }

   public EquipmentInfo setEquipmentCode(final String equipmentCode) {
      this.equipmentCode = equipmentCode;
      return this;
   }

   public EquipmentInfo setEquipmentName(final String equipmentName) {
      this.equipmentName = equipmentName;
      return this;
   }

   public EquipmentInfo setEquipmentTypeId(final Long equipmentTypeId) {
      this.equipmentTypeId = equipmentTypeId;
      return this;
   }

   public EquipmentInfo setEquipmentStorageApplyId(final Long equipmentStorageApplyId) {
      this.equipmentStorageApplyId = equipmentStorageApplyId;
      return this;
   }

   public EquipmentInfo setEquipmentSerialNumber(final String equipmentSerialNumber) {
      this.equipmentSerialNumber = equipmentSerialNumber;
      return this;
   }

   public EquipmentInfo setEquipmentModelNumber(final String equipmentModelNumber) {
      this.equipmentModelNumber = equipmentModelNumber;
      return this;
   }

   public EquipmentInfo setEquipmentSpec(final String equipmentSpec) {
      this.equipmentSpec = equipmentSpec;
      return this;
   }

   public EquipmentInfo setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public EquipmentInfo setUseStatus(final Integer useStatus) {
      this.useStatus = useStatus;
      return this;
   }

   public EquipmentInfo setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public EquipmentInfo setManagerBy(final Long managerBy) {
      this.managerBy = managerBy;
      return this;
   }

   public EquipmentInfo setReceiveBy(final Long receiveBy) {
      this.receiveBy = receiveBy;
      return this;
   }

   public EquipmentInfo setReceiveDepartmentId(final Long receiveDepartmentId) {
      this.receiveDepartmentId = receiveDepartmentId;
      return this;
   }

   public EquipmentInfo setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public EquipmentInfo setBuyTime(final LocalDateTime buyTime) {
      this.buyTime = buyTime;
      return this;
   }

   public EquipmentInfo setSuppliers(final String suppliers) {
      this.suppliers = suppliers;
      return this;
   }

   public EquipmentInfo setManufacturer(final String manufacturer) {
      this.manufacturer = manufacturer;
      return this;
   }

   public EquipmentInfo setOriginalPrice(final BigDecimal originalPrice) {
      this.originalPrice = originalPrice;
      return this;
   }

   public EquipmentInfo setUseLife(final Integer useLife) {
      this.useLife = useLife;
      return this;
   }

   public EquipmentInfo setAlreadyUsedLife(final Integer alreadyUsedLife) {
      this.alreadyUsedLife = alreadyUsedLife;
      return this;
   }

   public EquipmentInfo setDepreciationId(final Integer depreciationId) {
      this.depreciationId = depreciationId;
      return this;
   }

   public EquipmentInfo setDepreciationAmount(final BigDecimal depreciationAmount) {
      this.depreciationAmount = depreciationAmount;
      return this;
   }

   public EquipmentInfo setCurrentPrice(final BigDecimal currentPrice) {
      this.currentPrice = currentPrice;
      return this;
   }

   public EquipmentInfo setCreateBy(final Long createBy) {
      this.createBy = createBy;
      return this;
   }

   public EquipmentInfo setUpdateBy(final Long updateBy) {
      this.updateBy = updateBy;
      return this;
   }

   public EquipmentInfo setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public EquipmentInfo setInsideCode(final String insideCode) {
      this.insideCode = insideCode;
      return this;
   }

   public EquipmentInfo setConcreteArea(final String concreteArea) {
      this.concreteArea = concreteArea;
      return this;
   }

   public EquipmentInfo setMid(final Integer mid) {
      this.mid = mid;
      return this;
   }

   public EquipmentInfo setFixedAssetsCode(final String fixedAssetsCode) {
      this.fixedAssetsCode = fixedAssetsCode;
      return this;
   }

   public EquipmentInfo setOutCode(final String outCode) {
      this.outCode = outCode;
      return this;
   }

   public EquipmentInfo setEnterTime(final LocalDateTime enterTime) {
      this.enterTime = enterTime;
      return this;
   }

   public EquipmentInfo setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public EquipmentInfo setProdLineId(final Long prodLineId) {
      this.prodLineId = prodLineId;
      return this;
   }

   public EquipmentInfo setStationId(final Long stationId) {
      this.stationId = stationId;
      return this;
   }

   public EquipmentInfo setIsNetworking(final Integer isNetworking) {
      this.isNetworking = isNetworking;
      return this;
   }

   public EquipmentInfo setAmeterId(final Integer ameterId) {
      this.ameterId = ameterId;
      return this;
   }

   public EquipmentInfo setGasMeterId(final Integer gasMeterId) {
      this.gasMeterId = gasMeterId;
      return this;
   }

   public EquipmentInfo setRunType(final Integer runType) {
      this.runType = runType;
      return this;
   }

   public EquipmentInfo setMaintenanceType(final Integer maintenanceType) {
      this.maintenanceType = maintenanceType;
      return this;
   }

   @Override
   public String toString() {
      return "EquipmentInfo(id="
         + this.getId()
         + ", iotId="
         + this.getIotId()
         + ", equipmentCode="
         + this.getEquipmentCode()
         + ", equipmentName="
         + this.getEquipmentName()
         + ", equipmentTypeId="
         + this.getEquipmentTypeId()
         + ", equipmentStorageApplyId="
         + this.getEquipmentStorageApplyId()
         + ", equipmentSerialNumber="
         + this.getEquipmentSerialNumber()
         + ", equipmentModelNumber="
         + this.getEquipmentModelNumber()
         + ", equipmentSpec="
         + this.getEquipmentSpec()
         + ", status="
         + this.getStatus()
         + ", useStatus="
         + this.getUseStatus()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", managerBy="
         + this.getManagerBy()
         + ", receiveBy="
         + this.getReceiveBy()
         + ", receiveDepartmentId="
         + this.getReceiveDepartmentId()
         + ", areaId="
         + this.getAreaId()
         + ", buyTime="
         + this.getBuyTime()
         + ", suppliers="
         + this.getSuppliers()
         + ", manufacturer="
         + this.getManufacturer()
         + ", originalPrice="
         + this.getOriginalPrice()
         + ", useLife="
         + this.getUseLife()
         + ", alreadyUsedLife="
         + this.getAlreadyUsedLife()
         + ", depreciationId="
         + this.getDepreciationId()
         + ", depreciationAmount="
         + this.getDepreciationAmount()
         + ", currentPrice="
         + this.getCurrentPrice()
         + ", createBy="
         + this.getCreateBy()
         + ", updateBy="
         + this.getUpdateBy()
         + ", remark="
         + this.getRemark()
         + ", insideCode="
         + this.getInsideCode()
         + ", concreteArea="
         + this.getConcreteArea()
         + ", mid="
         + this.getMid()
         + ", fixedAssetsCode="
         + this.getFixedAssetsCode()
         + ", outCode="
         + this.getOutCode()
         + ", enterTime="
         + this.getEnterTime()
         + ", workshopId="
         + this.getWorkshopId()
         + ", prodLineId="
         + this.getProdLineId()
         + ", stationId="
         + this.getStationId()
         + ", isNetworking="
         + this.getIsNetworking()
         + ", ameterId="
         + this.getAmeterId()
         + ", gasMeterId="
         + this.getGasMeterId()
         + ", runType="
         + this.getRunType()
         + ", maintenanceType="
         + this.getMaintenanceType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EquipmentInfo)) {
         return false;
      }

      EquipmentInfo other = (EquipmentInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$iotId = this.getIotId();
         Object other$iotId = other.getIotId();
         if (this$iotId == null ? other$iotId == null : this$iotId.equals(other$iotId)) {
            Object this$equipmentTypeId = this.getEquipmentTypeId();
            Object other$equipmentTypeId = other.getEquipmentTypeId();
            if (this$equipmentTypeId == null ? other$equipmentTypeId == null : this$equipmentTypeId.equals(other$equipmentTypeId)) {
               Object this$equipmentStorageApplyId = this.getEquipmentStorageApplyId();
               Object other$equipmentStorageApplyId = other.getEquipmentStorageApplyId();
               if (this$equipmentStorageApplyId == null
                  ? other$equipmentStorageApplyId == null
                  : this$equipmentStorageApplyId.equals(other$equipmentStorageApplyId)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$useStatus = this.getUseStatus();
                     Object other$useStatus = other.getUseStatus();
                     if (this$useStatus == null ? other$useStatus == null : this$useStatus.equals(other$useStatus)) {
                        Object this$auditStatus = this.getAuditStatus();
                        Object other$auditStatus = other.getAuditStatus();
                        if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                           Object this$managerBy = this.getManagerBy();
                           Object other$managerBy = other.getManagerBy();
                           if (this$managerBy == null ? other$managerBy == null : this$managerBy.equals(other$managerBy)) {
                              Object this$receiveBy = this.getReceiveBy();
                              Object other$receiveBy = other.getReceiveBy();
                              if (this$receiveBy == null ? other$receiveBy == null : this$receiveBy.equals(other$receiveBy)) {
                                 Object this$receiveDepartmentId = this.getReceiveDepartmentId();
                                 Object other$receiveDepartmentId = other.getReceiveDepartmentId();
                                 if (this$receiveDepartmentId == null
                                    ? other$receiveDepartmentId == null
                                    : this$receiveDepartmentId.equals(other$receiveDepartmentId)) {
                                    Object this$areaId = this.getAreaId();
                                    Object other$areaId = other.getAreaId();
                                    if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                       Object this$useLife = this.getUseLife();
                                       Object other$useLife = other.getUseLife();
                                       if (this$useLife == null ? other$useLife == null : this$useLife.equals(other$useLife)) {
                                          Object this$alreadyUsedLife = this.getAlreadyUsedLife();
                                          Object other$alreadyUsedLife = other.getAlreadyUsedLife();
                                          if (this$alreadyUsedLife == null ? other$alreadyUsedLife == null : this$alreadyUsedLife.equals(other$alreadyUsedLife)
                                             )
                                           {
                                             Object this$depreciationId = this.getDepreciationId();
                                             Object other$depreciationId = other.getDepreciationId();
                                             if (this$depreciationId == null ? other$depreciationId == null : this$depreciationId.equals(other$depreciationId)) {
                                                Object this$createBy = this.getCreateBy();
                                                Object other$createBy = other.getCreateBy();
                                                if (this$createBy == null ? other$createBy == null : this$createBy.equals(other$createBy)) {
                                                   Object this$updateBy = this.getUpdateBy();
                                                   Object other$updateBy = other.getUpdateBy();
                                                   if (this$updateBy == null ? other$updateBy == null : this$updateBy.equals(other$updateBy)) {
                                                      Object this$mid = this.getMid();
                                                      Object other$mid = other.getMid();
                                                      if (this$mid == null ? other$mid == null : this$mid.equals(other$mid)) {
                                                         Object this$workshopId = this.getWorkshopId();
                                                         Object other$workshopId = other.getWorkshopId();
                                                         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                            Object this$prodLineId = this.getProdLineId();
                                                            Object other$prodLineId = other.getProdLineId();
                                                            if (this$prodLineId == null ? other$prodLineId == null : this$prodLineId.equals(other$prodLineId)) {
                                                               Object this$stationId = this.getStationId();
                                                               Object other$stationId = other.getStationId();
                                                               if (this$stationId == null ? other$stationId == null : this$stationId.equals(other$stationId)) {
                                                                  Object this$isNetworking = this.getIsNetworking();
                                                                  Object other$isNetworking = other.getIsNetworking();
                                                                  if (this$isNetworking == null
                                                                     ? other$isNetworking == null
                                                                     : this$isNetworking.equals(other$isNetworking)) {
                                                                     Object this$ameterId = this.getAmeterId();
                                                                     Object other$ameterId = other.getAmeterId();
                                                                     if (this$ameterId == null ? other$ameterId == null : this$ameterId.equals(other$ameterId)) {
                                                                        Object this$gasMeterId = this.getGasMeterId();
                                                                        Object other$gasMeterId = other.getGasMeterId();
                                                                        if (this$gasMeterId == null
                                                                           ? other$gasMeterId == null
                                                                           : this$gasMeterId.equals(other$gasMeterId)) {
                                                                           Object this$runType = this.getRunType();
                                                                           Object other$runType = other.getRunType();
                                                                           if (this$runType == null
                                                                              ? other$runType == null
                                                                              : this$runType.equals(other$runType)) {
                                                                              Object this$maintenanceType = this.getMaintenanceType();
                                                                              Object other$maintenanceType = other.getMaintenanceType();
                                                                              if (this$maintenanceType == null
                                                                                 ? other$maintenanceType == null
                                                                                 : this$maintenanceType.equals(other$maintenanceType)) {
                                                                                 Object this$equipmentCode = this.getEquipmentCode();
                                                                                 Object other$equipmentCode = other.getEquipmentCode();
                                                                                 if (this$equipmentCode == null
                                                                                    ? other$equipmentCode == null
                                                                                    : this$equipmentCode.equals(other$equipmentCode)) {
                                                                                    Object this$equipmentName = this.getEquipmentName();
                                                                                    Object other$equipmentName = other.getEquipmentName();
                                                                                    if (this$equipmentName == null
                                                                                       ? other$equipmentName == null
                                                                                       : this$equipmentName.equals(other$equipmentName)) {
                                                                                       Object this$equipmentSerialNumber = this.getEquipmentSerialNumber();
                                                                                       Object other$equipmentSerialNumber = other.getEquipmentSerialNumber();
                                                                                       if (this$equipmentSerialNumber == null
                                                                                          ? other$equipmentSerialNumber == null
                                                                                          : this$equipmentSerialNumber.equals(other$equipmentSerialNumber)) {
                                                                                          Object this$equipmentModelNumber = this.getEquipmentModelNumber();
                                                                                          Object other$equipmentModelNumber = other.getEquipmentModelNumber();
                                                                                          if (this$equipmentModelNumber == null
                                                                                             ? other$equipmentModelNumber == null
                                                                                             : this$equipmentModelNumber.equals(other$equipmentModelNumber)) {
                                                                                             Object this$equipmentSpec = this.getEquipmentSpec();
                                                                                             Object other$equipmentSpec = other.getEquipmentSpec();
                                                                                             if (this$equipmentSpec == null
                                                                                                ? other$equipmentSpec == null
                                                                                                : this$equipmentSpec.equals(other$equipmentSpec)) {
                                                                                                Object this$buyTime = this.getBuyTime();
                                                                                                Object other$buyTime = other.getBuyTime();
                                                                                                if (this$buyTime == null
                                                                                                   ? other$buyTime == null
                                                                                                   : this$buyTime.equals(other$buyTime)) {
                                                                                                   Object this$suppliers = this.getSuppliers();
                                                                                                   Object other$suppliers = other.getSuppliers();
                                                                                                   if (this$suppliers == null
                                                                                                      ? other$suppliers == null
                                                                                                      : this$suppliers.equals(other$suppliers)) {
                                                                                                      Object this$manufacturer = this.getManufacturer();
                                                                                                      Object other$manufacturer = other.getManufacturer();
                                                                                                      if (this$manufacturer == null
                                                                                                         ? other$manufacturer == null
                                                                                                         : this$manufacturer.equals(other$manufacturer)) {
                                                                                                         Object this$originalPrice = this.getOriginalPrice();
                                                                                                         Object other$originalPrice = other.getOriginalPrice();
                                                                                                         if (this$originalPrice == null
                                                                                                            ? other$originalPrice == null
                                                                                                            : this$originalPrice.equals(other$originalPrice)) {
                                                                                                            Object this$depreciationAmount = this.getDepreciationAmount();
                                                                                                            Object other$depreciationAmount = other.getDepreciationAmount();
                                                                                                            if (this$depreciationAmount == null
                                                                                                               ? other$depreciationAmount == null
                                                                                                               : this$depreciationAmount.equals(
                                                                                                                  other$depreciationAmount
                                                                                                               )) {
                                                                                                               Object this$currentPrice = this.getCurrentPrice();
                                                                                                               Object other$currentPrice = other.getCurrentPrice();
                                                                                                               if (this$currentPrice == null
                                                                                                                  ? other$currentPrice == null
                                                                                                                  : this$currentPrice.equals(other$currentPrice)
                                                                                                                  )
                                                                                                                {
                                                                                                                  Object this$remark = this.getRemark();
                                                                                                                  Object other$remark = other.getRemark();
                                                                                                                  if (this$remark == null
                                                                                                                     ? other$remark == null
                                                                                                                     : this$remark.equals(other$remark)) {
                                                                                                                     Object this$insideCode = this.getInsideCode();
                                                                                                                     Object other$insideCode = other.getInsideCode();
                                                                                                                     if (this$insideCode == null
                                                                                                                        ? other$insideCode == null
                                                                                                                        : this$insideCode.equals(
                                                                                                                           other$insideCode
                                                                                                                        )) {
                                                                                                                        Object this$concreteArea = this.getConcreteArea();
                                                                                                                        Object other$concreteArea = other.getConcreteArea();
                                                                                                                        if (this$concreteArea == null
                                                                                                                           ? other$concreteArea == null
                                                                                                                           : this$concreteArea.equals(
                                                                                                                              other$concreteArea
                                                                                                                           )) {
                                                                                                                           Object this$fixedAssetsCode = this.getFixedAssetsCode();
                                                                                                                           Object other$fixedAssetsCode = other.getFixedAssetsCode();
                                                                                                                           if (this$fixedAssetsCode == null
                                                                                                                              ? other$fixedAssetsCode == null
                                                                                                                              : this$fixedAssetsCode.equals(
                                                                                                                                 other$fixedAssetsCode
                                                                                                                              )) {
                                                                                                                              Object this$outCode = this.getOutCode();
                                                                                                                              Object other$outCode = other.getOutCode();
                                                                                                                              if (this$outCode == null
                                                                                                                                 ? other$outCode == null
                                                                                                                                 : this$outCode.equals(
                                                                                                                                    other$outCode
                                                                                                                                 )) {
                                                                                                                                 Object this$enterTime = this.getEnterTime();
                                                                                                                                 Object other$enterTime = other.getEnterTime();
                                                                                                                                 return this$enterTime == null
                                                                                                                                    ? other$enterTime == null
                                                                                                                                    : this$enterTime.equals(
                                                                                                                                       other$enterTime
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof EquipmentInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $iotId = this.getIotId();
      result = result * 59 + ($iotId == null ? 43 : $iotId.hashCode());
      Object $equipmentTypeId = this.getEquipmentTypeId();
      result = result * 59 + ($equipmentTypeId == null ? 43 : $equipmentTypeId.hashCode());
      Object $equipmentStorageApplyId = this.getEquipmentStorageApplyId();
      result = result * 59 + ($equipmentStorageApplyId == null ? 43 : $equipmentStorageApplyId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $useStatus = this.getUseStatus();
      result = result * 59 + ($useStatus == null ? 43 : $useStatus.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $managerBy = this.getManagerBy();
      result = result * 59 + ($managerBy == null ? 43 : $managerBy.hashCode());
      Object $receiveBy = this.getReceiveBy();
      result = result * 59 + ($receiveBy == null ? 43 : $receiveBy.hashCode());
      Object $receiveDepartmentId = this.getReceiveDepartmentId();
      result = result * 59 + ($receiveDepartmentId == null ? 43 : $receiveDepartmentId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $useLife = this.getUseLife();
      result = result * 59 + ($useLife == null ? 43 : $useLife.hashCode());
      Object $alreadyUsedLife = this.getAlreadyUsedLife();
      result = result * 59 + ($alreadyUsedLife == null ? 43 : $alreadyUsedLife.hashCode());
      Object $depreciationId = this.getDepreciationId();
      result = result * 59 + ($depreciationId == null ? 43 : $depreciationId.hashCode());
      Object $createBy = this.getCreateBy();
      result = result * 59 + ($createBy == null ? 43 : $createBy.hashCode());
      Object $updateBy = this.getUpdateBy();
      result = result * 59 + ($updateBy == null ? 43 : $updateBy.hashCode());
      Object $mid = this.getMid();
      result = result * 59 + ($mid == null ? 43 : $mid.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $prodLineId = this.getProdLineId();
      result = result * 59 + ($prodLineId == null ? 43 : $prodLineId.hashCode());
      Object $stationId = this.getStationId();
      result = result * 59 + ($stationId == null ? 43 : $stationId.hashCode());
      Object $isNetworking = this.getIsNetworking();
      result = result * 59 + ($isNetworking == null ? 43 : $isNetworking.hashCode());
      Object $ameterId = this.getAmeterId();
      result = result * 59 + ($ameterId == null ? 43 : $ameterId.hashCode());
      Object $gasMeterId = this.getGasMeterId();
      result = result * 59 + ($gasMeterId == null ? 43 : $gasMeterId.hashCode());
      Object $runType = this.getRunType();
      result = result * 59 + ($runType == null ? 43 : $runType.hashCode());
      Object $maintenanceType = this.getMaintenanceType();
      result = result * 59 + ($maintenanceType == null ? 43 : $maintenanceType.hashCode());
      Object $equipmentCode = this.getEquipmentCode();
      result = result * 59 + ($equipmentCode == null ? 43 : $equipmentCode.hashCode());
      Object $equipmentName = this.getEquipmentName();
      result = result * 59 + ($equipmentName == null ? 43 : $equipmentName.hashCode());
      Object $equipmentSerialNumber = this.getEquipmentSerialNumber();
      result = result * 59 + ($equipmentSerialNumber == null ? 43 : $equipmentSerialNumber.hashCode());
      Object $equipmentModelNumber = this.getEquipmentModelNumber();
      result = result * 59 + ($equipmentModelNumber == null ? 43 : $equipmentModelNumber.hashCode());
      Object $equipmentSpec = this.getEquipmentSpec();
      result = result * 59 + ($equipmentSpec == null ? 43 : $equipmentSpec.hashCode());
      Object $buyTime = this.getBuyTime();
      result = result * 59 + ($buyTime == null ? 43 : $buyTime.hashCode());
      Object $suppliers = this.getSuppliers();
      result = result * 59 + ($suppliers == null ? 43 : $suppliers.hashCode());
      Object $manufacturer = this.getManufacturer();
      result = result * 59 + ($manufacturer == null ? 43 : $manufacturer.hashCode());
      Object $originalPrice = this.getOriginalPrice();
      result = result * 59 + ($originalPrice == null ? 43 : $originalPrice.hashCode());
      Object $depreciationAmount = this.getDepreciationAmount();
      result = result * 59 + ($depreciationAmount == null ? 43 : $depreciationAmount.hashCode());
      Object $currentPrice = this.getCurrentPrice();
      result = result * 59 + ($currentPrice == null ? 43 : $currentPrice.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $insideCode = this.getInsideCode();
      result = result * 59 + ($insideCode == null ? 43 : $insideCode.hashCode());
      Object $concreteArea = this.getConcreteArea();
      result = result * 59 + ($concreteArea == null ? 43 : $concreteArea.hashCode());
      Object $fixedAssetsCode = this.getFixedAssetsCode();
      result = result * 59 + ($fixedAssetsCode == null ? 43 : $fixedAssetsCode.hashCode());
      Object $outCode = this.getOutCode();
      result = result * 59 + ($outCode == null ? 43 : $outCode.hashCode());
      Object $enterTime = this.getEnterTime();
      return result * 59 + ($enterTime == null ? 43 : $enterTime.hashCode());
   }

   public static class EquipmentInfoBuilder {
      private Long id;
      private Long iotId;
      private String equipmentCode;
      private String equipmentName;
      private Long equipmentTypeId;
      private Long equipmentStorageApplyId;
      private String equipmentSerialNumber;
      private String equipmentModelNumber;
      private String equipmentSpec;
      private Integer status;
      private Integer useStatus;
      private Integer auditStatus;
      private Long managerBy;
      private Long receiveBy;
      private Long receiveDepartmentId;
      private Long areaId;
      private LocalDateTime buyTime;
      private String suppliers;
      private String manufacturer;
      private BigDecimal originalPrice;
      private Integer useLife;
      private Integer alreadyUsedLife;
      private Integer depreciationId;
      private BigDecimal depreciationAmount;
      private BigDecimal currentPrice;
      private Long createBy;
      private Long updateBy;
      private String remark;
      private String insideCode;
      private String concreteArea;
      private Integer mid;
      private String fixedAssetsCode;
      private String outCode;
      private LocalDateTime enterTime;
      private Long workshopId;
      private Long prodLineId;
      private Long stationId;
      private Integer isNetworking;
      private Integer ameterId;
      private Integer gasMeterId;
      private Integer runType;
      private Integer maintenanceType;

      EquipmentInfoBuilder() {
      }

      public EquipmentInfo.EquipmentInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder iotId(final Long iotId) {
         this.iotId = iotId;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder equipmentCode(final String equipmentCode) {
         this.equipmentCode = equipmentCode;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder equipmentName(final String equipmentName) {
         this.equipmentName = equipmentName;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder equipmentTypeId(final Long equipmentTypeId) {
         this.equipmentTypeId = equipmentTypeId;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder equipmentStorageApplyId(final Long equipmentStorageApplyId) {
         this.equipmentStorageApplyId = equipmentStorageApplyId;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder equipmentSerialNumber(final String equipmentSerialNumber) {
         this.equipmentSerialNumber = equipmentSerialNumber;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder equipmentModelNumber(final String equipmentModelNumber) {
         this.equipmentModelNumber = equipmentModelNumber;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder equipmentSpec(final String equipmentSpec) {
         this.equipmentSpec = equipmentSpec;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder useStatus(final Integer useStatus) {
         this.useStatus = useStatus;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder managerBy(final Long managerBy) {
         this.managerBy = managerBy;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder receiveBy(final Long receiveBy) {
         this.receiveBy = receiveBy;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder receiveDepartmentId(final Long receiveDepartmentId) {
         this.receiveDepartmentId = receiveDepartmentId;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder buyTime(final LocalDateTime buyTime) {
         this.buyTime = buyTime;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder suppliers(final String suppliers) {
         this.suppliers = suppliers;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder manufacturer(final String manufacturer) {
         this.manufacturer = manufacturer;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder originalPrice(final BigDecimal originalPrice) {
         this.originalPrice = originalPrice;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder useLife(final Integer useLife) {
         this.useLife = useLife;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder alreadyUsedLife(final Integer alreadyUsedLife) {
         this.alreadyUsedLife = alreadyUsedLife;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder depreciationId(final Integer depreciationId) {
         this.depreciationId = depreciationId;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder depreciationAmount(final BigDecimal depreciationAmount) {
         this.depreciationAmount = depreciationAmount;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder currentPrice(final BigDecimal currentPrice) {
         this.currentPrice = currentPrice;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder createBy(final Long createBy) {
         this.createBy = createBy;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder updateBy(final Long updateBy) {
         this.updateBy = updateBy;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder insideCode(final String insideCode) {
         this.insideCode = insideCode;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder concreteArea(final String concreteArea) {
         this.concreteArea = concreteArea;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder mid(final Integer mid) {
         this.mid = mid;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder fixedAssetsCode(final String fixedAssetsCode) {
         this.fixedAssetsCode = fixedAssetsCode;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder outCode(final String outCode) {
         this.outCode = outCode;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder enterTime(final LocalDateTime enterTime) {
         this.enterTime = enterTime;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder prodLineId(final Long prodLineId) {
         this.prodLineId = prodLineId;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder stationId(final Long stationId) {
         this.stationId = stationId;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder isNetworking(final Integer isNetworking) {
         this.isNetworking = isNetworking;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder ameterId(final Integer ameterId) {
         this.ameterId = ameterId;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder gasMeterId(final Integer gasMeterId) {
         this.gasMeterId = gasMeterId;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder runType(final Integer runType) {
         this.runType = runType;
         return this;
      }

      public EquipmentInfo.EquipmentInfoBuilder maintenanceType(final Integer maintenanceType) {
         this.maintenanceType = maintenanceType;
         return this;
      }

      public EquipmentInfo build() {
         return new EquipmentInfo(
            this.id,
            this.iotId,
            this.equipmentCode,
            this.equipmentName,
            this.equipmentTypeId,
            this.equipmentStorageApplyId,
            this.equipmentSerialNumber,
            this.equipmentModelNumber,
            this.equipmentSpec,
            this.status,
            this.useStatus,
            this.auditStatus,
            this.managerBy,
            this.receiveBy,
            this.receiveDepartmentId,
            this.areaId,
            this.buyTime,
            this.suppliers,
            this.manufacturer,
            this.originalPrice,
            this.useLife,
            this.alreadyUsedLife,
            this.depreciationId,
            this.depreciationAmount,
            this.currentPrice,
            this.createBy,
            this.updateBy,
            this.remark,
            this.insideCode,
            this.concreteArea,
            this.mid,
            this.fixedAssetsCode,
            this.outCode,
            this.enterTime,
            this.workshopId,
            this.prodLineId,
            this.stationId,
            this.isNetworking,
            this.ameterId,
            this.gasMeterId,
            this.runType,
            this.maintenanceType
         );
      }

      @Override
      public String toString() {
         return "EquipmentInfo.EquipmentInfoBuilder(id="
            + this.id
            + ", iotId="
            + this.iotId
            + ", equipmentCode="
            + this.equipmentCode
            + ", equipmentName="
            + this.equipmentName
            + ", equipmentTypeId="
            + this.equipmentTypeId
            + ", equipmentStorageApplyId="
            + this.equipmentStorageApplyId
            + ", equipmentSerialNumber="
            + this.equipmentSerialNumber
            + ", equipmentModelNumber="
            + this.equipmentModelNumber
            + ", equipmentSpec="
            + this.equipmentSpec
            + ", status="
            + this.status
            + ", useStatus="
            + this.useStatus
            + ", auditStatus="
            + this.auditStatus
            + ", managerBy="
            + this.managerBy
            + ", receiveBy="
            + this.receiveBy
            + ", receiveDepartmentId="
            + this.receiveDepartmentId
            + ", areaId="
            + this.areaId
            + ", buyTime="
            + this.buyTime
            + ", suppliers="
            + this.suppliers
            + ", manufacturer="
            + this.manufacturer
            + ", originalPrice="
            + this.originalPrice
            + ", useLife="
            + this.useLife
            + ", alreadyUsedLife="
            + this.alreadyUsedLife
            + ", depreciationId="
            + this.depreciationId
            + ", depreciationAmount="
            + this.depreciationAmount
            + ", currentPrice="
            + this.currentPrice
            + ", createBy="
            + this.createBy
            + ", updateBy="
            + this.updateBy
            + ", remark="
            + this.remark
            + ", insideCode="
            + this.insideCode
            + ", concreteArea="
            + this.concreteArea
            + ", mid="
            + this.mid
            + ", fixedAssetsCode="
            + this.fixedAssetsCode
            + ", outCode="
            + this.outCode
            + ", enterTime="
            + this.enterTime
            + ", workshopId="
            + this.workshopId
            + ", prodLineId="
            + this.prodLineId
            + ", stationId="
            + this.stationId
            + ", isNetworking="
            + this.isNetworking
            + ", ameterId="
            + this.ameterId
            + ", gasMeterId="
            + this.gasMeterId
            + ", runType="
            + this.runType
            + ", maintenanceType="
            + this.maintenanceType
            + ")";
      }
   }
}
