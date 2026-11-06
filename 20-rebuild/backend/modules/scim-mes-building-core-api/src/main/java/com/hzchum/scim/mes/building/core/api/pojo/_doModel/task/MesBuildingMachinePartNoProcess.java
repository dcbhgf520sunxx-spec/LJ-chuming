package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "MesBuildingMachinePartNoProcess对象", description = "型材无工序排产")
@Entity
@TableName("mes_building_machine_part_no_process")
@Table(name = "mes_building_machine_part_no_process")
public class MesBuildingMachinePartNoProcess extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '排产数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   @TableField("order_number")
   @Column(name = "order_number", columnDefinition = "varchar(500)  COMMENT '任务工单号'", nullable = false)
   private String orderNumber;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "machinePartSchedulingId", value = "零件排产id", notes = "零件排产id")
   @JsonProperty("machinePartSchedulingId")
   @JSONField(name = "machinePartSchedulingId")
   @TableField("machine_part_scheduling_id")
   @Column(name = "machine_part_scheduling_id", columnDefinition = "bigint(20)  COMMENT '零件排产id'", nullable = false)
   private Long machinePartSchedulingId;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255)  COMMENT '规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "thick", value = "厚度", notes = "厚度")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @TableField("thick")
   @Column(name = "thick", columnDefinition = "varchar(255)  COMMENT '厚度'", nullable = false)
   private String thick;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255)  COMMENT '材质'", nullable = false)
   private String material;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @TableField("ask_complete_time")
   @Column(name = "ask_complete_time", columnDefinition = "datetime  COMMENT '要求完成日期'", nullable = false)
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "productClassificationEnum", value = "零件分类 4.成品型材 8.钢板", notes = "零件分类 4.成品型材 8.钢板")
   @JsonProperty("productClassificationEnum")
   @JSONField(name = "productClassificationEnum")
   @TableField("product_classification_enum")
   @Column(name = "product_classification_enum", columnDefinition = "int(11)  COMMENT '零件分类 4.成品型材 8.钢板'", nullable = false)
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "wastageRate", value = "损耗率", notes = "损耗率")
   @JsonProperty("wastageRate")
   @JSONField(name = "wastageRate")
   @TableField("wastage_rate")
   @Column(name = "wastage_rate", columnDefinition = "decimal(32,8)  COMMENT '损耗率'", nullable = false)
   private BigDecimal wastageRate;
   @ApiModelProperty(name = "singleWeight", value = "单重", notes = "单重")
   @JsonProperty("singleWeight")
   @JSONField(name = "singleWeight")
   @TableField("single_weight")
   @Column(name = "single_weight", columnDefinition = "decimal(32,8)  COMMENT '单重'", nullable = false)
   private BigDecimal singleWeight;
   @ApiModelProperty(name = "totalWeight", value = "总重", notes = "总重")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   @TableField("total_weight")
   @Column(name = "total_weight", columnDefinition = "decimal(32,8)  COMMENT '总重'", nullable = false)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "singleLength", value = "单长度", notes = "单长度")
   @JsonProperty("singleLength")
   @JSONField(name = "singleLength")
   @TableField("single_length")
   @Column(name = "single_length", columnDefinition = "decimal(32,8)  COMMENT '单长度'", nullable = false)
   private BigDecimal singleLength;
   @ApiModelProperty(name = "totalLength", value = "总长", notes = "总长")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   @TableField("total_length")
   @Column(name = "total_length", columnDefinition = "decimal(32,8)  COMMENT '总长'", nullable = false)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalRequestLength", value = "总长", notes = "总长")
   @JsonProperty("totalRequestLength")
   @JSONField(name = "totalRequestLength")
   @TableField("total_request_length")
   @Column(name = "total_request_length", columnDefinition = "decimal(32,8)  COMMENT '总长'", nullable = false)
   private BigDecimal totalRequestLength;
   @ApiModelProperty(name = "boolRequest", value = "是否领料", notes = "是否领料")
   @JsonProperty("boolRequest")
   @JSONField(name = "boolRequest")
   @TableField("bool_request")
   @Column(name = "bool_request", columnDefinition = "tinyint(1) COMMENT '是否领料'", nullable = false)
   private Boolean boolRequest;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   @JsonProperty("boolProcess")
   @JSONField(name = "boolProcess")
   @TableField("bool_process")
   @Column(name = "bool_process", columnDefinition = "tinyint(1) COMMENT '是否有工序 true是 false否'", nullable = false)
   private Boolean boolProcess;
   @ApiModelProperty(name = "schedulingUserId", value = "排产人", notes = "排产人")
   @JsonProperty("schedulingUserId")
   @JSONField(name = "schedulingUserId")
   @TableField(value = "scheduling_user_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "scheduling_user_id", columnDefinition = "bigint(20)  COMMENT '排产人'", nullable = true)
   private Long schedulingUserId;
   @ApiModelProperty(name = "transactVolume", value = "办理量", notes = "办理量")
   @JsonProperty("transactVolume")
   @JSONField(name = "transactVolume")
   @TableField("transact_volume")
   @Column(name = "transact_volume", columnDefinition = "decimal(32,8)  COMMENT '办理量'", nullable = true)
   private BigDecimal transactVolume;
   @ApiModelProperty(name = "togetherStatus", value = "齐套状态[0 未齐套;1 已齐套]", notes = "齐套状态[0 未齐套;1 已齐套]")
   @JsonProperty("togetherStatus")
   @JSONField(name = "togetherStatus")
   @TableField("together_status")
   @Column(name = "together_status", columnDefinition = "int(11) DEFAULT '0'  COMMENT '齐套状态[0 未齐套;1 已齐套]'", nullable = false)
   private Integer togetherStatus;

   public static MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder builder() {
      return new MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder();
   }

   public MesBuildingMachinePartNoProcess() {
   }

   public MesBuildingMachinePartNoProcess(
      final Long id,
      final Integer quantity,
      final Long productId,
      final String orderNumber,
      final Long teamId,
      final Long machinePartSchedulingId,
      final String specification,
      final String thick,
      final String material,
      final Long projectId,
      final LocalDateTime askCompleteTime,
      final Long productionLineId,
      final Integer productClassificationEnum,
      final BigDecimal wastageRate,
      final BigDecimal singleWeight,
      final BigDecimal totalWeight,
      final BigDecimal singleLength,
      final BigDecimal totalLength,
      final BigDecimal totalRequestLength,
      final Boolean boolRequest,
      final Boolean boolProcess,
      final Long schedulingUserId,
      final BigDecimal transactVolume,
      final Integer togetherStatus
   ) {
      this.id = id;
      this.quantity = quantity;
      this.productId = productId;
      this.orderNumber = orderNumber;
      this.teamId = teamId;
      this.machinePartSchedulingId = machinePartSchedulingId;
      this.specification = specification;
      this.thick = thick;
      this.material = material;
      this.projectId = projectId;
      this.askCompleteTime = askCompleteTime;
      this.productionLineId = productionLineId;
      this.productClassificationEnum = productClassificationEnum;
      this.wastageRate = wastageRate;
      this.singleWeight = singleWeight;
      this.totalWeight = totalWeight;
      this.singleLength = singleLength;
      this.totalLength = totalLength;
      this.totalRequestLength = totalRequestLength;
      this.boolRequest = boolRequest;
      this.boolProcess = boolProcess;
      this.schedulingUserId = schedulingUserId;
      this.transactVolume = transactVolume;
      this.togetherStatus = togetherStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getMachinePartSchedulingId() {
      return this.machinePartSchedulingId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getThick() {
      return this.thick;
   }

   public String getMaterial() {
      return this.material;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public BigDecimal getWastageRate() {
      return this.wastageRate;
   }

   public BigDecimal getSingleWeight() {
      return this.singleWeight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getSingleLength() {
      return this.singleLength;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalRequestLength() {
      return this.totalRequestLength;
   }

   public Boolean getBoolRequest() {
      return this.boolRequest;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Long getSchedulingUserId() {
      return this.schedulingUserId;
   }

   public BigDecimal getTransactVolume() {
      return this.transactVolume;
   }

   public Integer getTogetherStatus() {
      return this.togetherStatus;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartNoProcess setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartNoProcess setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingMachinePartNoProcess setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingMachinePartNoProcess setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingMachinePartNoProcess setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("machinePartSchedulingId")
   public MesBuildingMachinePartNoProcess setMachinePartSchedulingId(final Long machinePartSchedulingId) {
      this.machinePartSchedulingId = machinePartSchedulingId;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingMachinePartNoProcess setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("thick")
   public MesBuildingMachinePartNoProcess setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingMachinePartNoProcess setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingMachinePartNoProcess setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingMachinePartNoProcess setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingMachinePartNoProcess setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("productClassificationEnum")
   public MesBuildingMachinePartNoProcess setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   @JsonProperty("wastageRate")
   public MesBuildingMachinePartNoProcess setWastageRate(final BigDecimal wastageRate) {
      this.wastageRate = wastageRate;
      return this;
   }

   @JsonProperty("singleWeight")
   public MesBuildingMachinePartNoProcess setSingleWeight(final BigDecimal singleWeight) {
      this.singleWeight = singleWeight;
      return this;
   }

   @JsonProperty("totalWeight")
   public MesBuildingMachinePartNoProcess setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("singleLength")
   public MesBuildingMachinePartNoProcess setSingleLength(final BigDecimal singleLength) {
      this.singleLength = singleLength;
      return this;
   }

   @JsonProperty("totalLength")
   public MesBuildingMachinePartNoProcess setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalRequestLength")
   public MesBuildingMachinePartNoProcess setTotalRequestLength(final BigDecimal totalRequestLength) {
      this.totalRequestLength = totalRequestLength;
      return this;
   }

   @JsonProperty("boolRequest")
   public MesBuildingMachinePartNoProcess setBoolRequest(final Boolean boolRequest) {
      this.boolRequest = boolRequest;
      return this;
   }

   @JsonProperty("boolProcess")
   public MesBuildingMachinePartNoProcess setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
      return this;
   }

   @JsonProperty("schedulingUserId")
   public MesBuildingMachinePartNoProcess setSchedulingUserId(final Long schedulingUserId) {
      this.schedulingUserId = schedulingUserId;
      return this;
   }

   @JsonProperty("transactVolume")
   public MesBuildingMachinePartNoProcess setTransactVolume(final BigDecimal transactVolume) {
      this.transactVolume = transactVolume;
      return this;
   }

   @JsonProperty("togetherStatus")
   public MesBuildingMachinePartNoProcess setTogetherStatus(final Integer togetherStatus) {
      this.togetherStatus = togetherStatus;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartNoProcess(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", productId="
         + this.getProductId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", teamId="
         + this.getTeamId()
         + ", machinePartSchedulingId="
         + this.getMachinePartSchedulingId()
         + ", specification="
         + this.getSpecification()
         + ", thick="
         + this.getThick()
         + ", material="
         + this.getMaterial()
         + ", projectId="
         + this.getProjectId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", wastageRate="
         + this.getWastageRate()
         + ", singleWeight="
         + this.getSingleWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", singleLength="
         + this.getSingleLength()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalRequestLength="
         + this.getTotalRequestLength()
         + ", boolRequest="
         + this.getBoolRequest()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", schedulingUserId="
         + this.getSchedulingUserId()
         + ", transactVolume="
         + this.getTransactVolume()
         + ", togetherStatus="
         + this.getTogetherStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartNoProcess)) {
         return false;
      }

      MesBuildingMachinePartNoProcess other = (MesBuildingMachinePartNoProcess)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$machinePartSchedulingId = this.getMachinePartSchedulingId();
                  Object other$machinePartSchedulingId = other.getMachinePartSchedulingId();
                  if (this$machinePartSchedulingId == null
                     ? other$machinePartSchedulingId == null
                     : this$machinePartSchedulingId.equals(other$machinePartSchedulingId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$productionLineId = this.getProductionLineId();
                        Object other$productionLineId = other.getProductionLineId();
                        if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                           Object this$productClassificationEnum = this.getProductClassificationEnum();
                           Object other$productClassificationEnum = other.getProductClassificationEnum();
                           if (this$productClassificationEnum == null
                              ? other$productClassificationEnum == null
                              : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                              Object this$boolRequest = this.getBoolRequest();
                              Object other$boolRequest = other.getBoolRequest();
                              if (this$boolRequest == null ? other$boolRequest == null : this$boolRequest.equals(other$boolRequest)) {
                                 Object this$boolProcess = this.getBoolProcess();
                                 Object other$boolProcess = other.getBoolProcess();
                                 if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                                    Object this$schedulingUserId = this.getSchedulingUserId();
                                    Object other$schedulingUserId = other.getSchedulingUserId();
                                    if (this$schedulingUserId == null ? other$schedulingUserId == null : this$schedulingUserId.equals(other$schedulingUserId)) {
                                       Object this$togetherStatus = this.getTogetherStatus();
                                       Object other$togetherStatus = other.getTogetherStatus();
                                       if (this$togetherStatus == null ? other$togetherStatus == null : this$togetherStatus.equals(other$togetherStatus)) {
                                          Object this$orderNumber = this.getOrderNumber();
                                          Object other$orderNumber = other.getOrderNumber();
                                          if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$thick = this.getThick();
                                                Object other$thick = other.getThick();
                                                if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                   Object this$material = this.getMaterial();
                                                   Object other$material = other.getMaterial();
                                                   if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                      Object this$askCompleteTime = this.getAskCompleteTime();
                                                      Object other$askCompleteTime = other.getAskCompleteTime();
                                                      if (this$askCompleteTime == null
                                                         ? other$askCompleteTime == null
                                                         : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                         Object this$wastageRate = this.getWastageRate();
                                                         Object other$wastageRate = other.getWastageRate();
                                                         if (this$wastageRate == null ? other$wastageRate == null : this$wastageRate.equals(other$wastageRate)) {
                                                            Object this$singleWeight = this.getSingleWeight();
                                                            Object other$singleWeight = other.getSingleWeight();
                                                            if (this$singleWeight == null
                                                               ? other$singleWeight == null
                                                               : this$singleWeight.equals(other$singleWeight)) {
                                                               Object this$totalWeight = this.getTotalWeight();
                                                               Object other$totalWeight = other.getTotalWeight();
                                                               if (this$totalWeight == null
                                                                  ? other$totalWeight == null
                                                                  : this$totalWeight.equals(other$totalWeight)) {
                                                                  Object this$singleLength = this.getSingleLength();
                                                                  Object other$singleLength = other.getSingleLength();
                                                                  if (this$singleLength == null
                                                                     ? other$singleLength == null
                                                                     : this$singleLength.equals(other$singleLength)) {
                                                                     Object this$totalLength = this.getTotalLength();
                                                                     Object other$totalLength = other.getTotalLength();
                                                                     if (this$totalLength == null
                                                                        ? other$totalLength == null
                                                                        : this$totalLength.equals(other$totalLength)) {
                                                                        Object this$totalRequestLength = this.getTotalRequestLength();
                                                                        Object other$totalRequestLength = other.getTotalRequestLength();
                                                                        if (this$totalRequestLength == null
                                                                           ? other$totalRequestLength == null
                                                                           : this$totalRequestLength.equals(other$totalRequestLength)) {
                                                                           Object this$transactVolume = this.getTransactVolume();
                                                                           Object other$transactVolume = other.getTransactVolume();
                                                                           return this$transactVolume == null
                                                                              ? other$transactVolume == null
                                                                              : this$transactVolume.equals(other$transactVolume);
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingMachinePartNoProcess;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $machinePartSchedulingId = this.getMachinePartSchedulingId();
      result = result * 59 + ($machinePartSchedulingId == null ? 43 : $machinePartSchedulingId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $boolRequest = this.getBoolRequest();
      result = result * 59 + ($boolRequest == null ? 43 : $boolRequest.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $schedulingUserId = this.getSchedulingUserId();
      result = result * 59 + ($schedulingUserId == null ? 43 : $schedulingUserId.hashCode());
      Object $togetherStatus = this.getTogetherStatus();
      result = result * 59 + ($togetherStatus == null ? 43 : $togetherStatus.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $wastageRate = this.getWastageRate();
      result = result * 59 + ($wastageRate == null ? 43 : $wastageRate.hashCode());
      Object $singleWeight = this.getSingleWeight();
      result = result * 59 + ($singleWeight == null ? 43 : $singleWeight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $singleLength = this.getSingleLength();
      result = result * 59 + ($singleLength == null ? 43 : $singleLength.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalRequestLength = this.getTotalRequestLength();
      result = result * 59 + ($totalRequestLength == null ? 43 : $totalRequestLength.hashCode());
      Object $transactVolume = this.getTransactVolume();
      return result * 59 + ($transactVolume == null ? 43 : $transactVolume.hashCode());
   }

   public static class MesBuildingMachinePartNoProcessBuilder {
      private Long id;
      private Integer quantity;
      private Long productId;
      private String orderNumber;
      private Long teamId;
      private Long machinePartSchedulingId;
      private String specification;
      private String thick;
      private String material;
      private Long projectId;
      private LocalDateTime askCompleteTime;
      private Long productionLineId;
      private Integer productClassificationEnum;
      private BigDecimal wastageRate;
      private BigDecimal singleWeight;
      private BigDecimal totalWeight;
      private BigDecimal singleLength;
      private BigDecimal totalLength;
      private BigDecimal totalRequestLength;
      private Boolean boolRequest;
      private Boolean boolProcess;
      private Long schedulingUserId;
      private BigDecimal transactVolume;
      private Integer togetherStatus;

      MesBuildingMachinePartNoProcessBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("machinePartSchedulingId")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder machinePartSchedulingId(final Long machinePartSchedulingId) {
         this.machinePartSchedulingId = machinePartSchedulingId;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("thick")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productClassificationEnum")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      @JsonProperty("wastageRate")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder wastageRate(final BigDecimal wastageRate) {
         this.wastageRate = wastageRate;
         return this;
      }

      @JsonProperty("singleWeight")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder singleWeight(final BigDecimal singleWeight) {
         this.singleWeight = singleWeight;
         return this;
      }

      @JsonProperty("totalWeight")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("singleLength")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder singleLength(final BigDecimal singleLength) {
         this.singleLength = singleLength;
         return this;
      }

      @JsonProperty("totalLength")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalRequestLength")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder totalRequestLength(final BigDecimal totalRequestLength) {
         this.totalRequestLength = totalRequestLength;
         return this;
      }

      @JsonProperty("boolRequest")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder boolRequest(final Boolean boolRequest) {
         this.boolRequest = boolRequest;
         return this;
      }

      @JsonProperty("boolProcess")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      @JsonProperty("schedulingUserId")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder schedulingUserId(final Long schedulingUserId) {
         this.schedulingUserId = schedulingUserId;
         return this;
      }

      @JsonProperty("transactVolume")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder transactVolume(final BigDecimal transactVolume) {
         this.transactVolume = transactVolume;
         return this;
      }

      @JsonProperty("togetherStatus")
      public MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder togetherStatus(final Integer togetherStatus) {
         this.togetherStatus = togetherStatus;
         return this;
      }

      public MesBuildingMachinePartNoProcess build() {
         return new MesBuildingMachinePartNoProcess(
            this.id,
            this.quantity,
            this.productId,
            this.orderNumber,
            this.teamId,
            this.machinePartSchedulingId,
            this.specification,
            this.thick,
            this.material,
            this.projectId,
            this.askCompleteTime,
            this.productionLineId,
            this.productClassificationEnum,
            this.wastageRate,
            this.singleWeight,
            this.totalWeight,
            this.singleLength,
            this.totalLength,
            this.totalRequestLength,
            this.boolRequest,
            this.boolProcess,
            this.schedulingUserId,
            this.transactVolume,
            this.togetherStatus
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartNoProcess.MesBuildingMachinePartNoProcessBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", productId="
            + this.productId
            + ", orderNumber="
            + this.orderNumber
            + ", teamId="
            + this.teamId
            + ", machinePartSchedulingId="
            + this.machinePartSchedulingId
            + ", specification="
            + this.specification
            + ", thick="
            + this.thick
            + ", material="
            + this.material
            + ", projectId="
            + this.projectId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", productionLineId="
            + this.productionLineId
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", wastageRate="
            + this.wastageRate
            + ", singleWeight="
            + this.singleWeight
            + ", totalWeight="
            + this.totalWeight
            + ", singleLength="
            + this.singleLength
            + ", totalLength="
            + this.totalLength
            + ", totalRequestLength="
            + this.totalRequestLength
            + ", boolRequest="
            + this.boolRequest
            + ", boolProcess="
            + this.boolProcess
            + ", schedulingUserId="
            + this.schedulingUserId
            + ", transactVolume="
            + this.transactVolume
            + ", togetherStatus="
            + this.togetherStatus
            + ")";
      }
   }
}
