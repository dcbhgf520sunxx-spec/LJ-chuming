package com.hzchum.scim.mes.building.core.api.pojo._doModel.wages;

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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingProduceTeamReportPrice对象", description = "班组生产上报记录表 ")
@Entity
@TableName("mes_building_produce_team_report_price")
@Table(name = "mes_building_produce_team_report_price")
public class MesBuildingProduceTeamReportPrice extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20)  COMMENT '任务工单id'", nullable = false)
   private Long taskOrderId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id", notes = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   @TableField("task_process_id")
   @Column(name = "task_process_id", columnDefinition = "bigint(20)  COMMENT '任务工序id'", nullable = false)
   private Long taskProcessId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", value = "生产数量", notes = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '生产数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "inspectionQuantity", value = "生产数量", notes = "生产数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   @TableField("inspection_quantity")
   @Column(name = "inspection_quantity", columnDefinition = "int(11) default '0' COMMENT '生产数量'", nullable = false)
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "teamReoprtId", value = "班组上报记录id", notes = "班组上报记录id")
   @JsonProperty("teamReoprtId")
   @JSONField(name = "teamReoprtId")
   @TableField("team_reoprt_id")
   @Column(name = "team_reoprt_id", columnDefinition = "bigint(20)  COMMENT '班组上报记录id'", nullable = false)
   private Long teamReoprtId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "reportType", value = "上报类型 [0 正常上报, 1 异常上报]", notes = "上报类型 [0 正常上报, 1 异常上报]")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   @TableField("report_type")
   @Column(name = "report_type", columnDefinition = "int(11) default '0' COMMENT '上报类型 [0 正常上报, 1 异常上报]'", nullable = false)
   private Integer reportType;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式", notes = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   @TableField("wage_quota_type")
   @Column(name = "wage_quota_type", columnDefinition = "int(11)  COMMENT '计价方式'", nullable = false)
   private Integer wageQuotaType;
   @ApiModelProperty(name = "radiusQuantity", value = "孔个数", notes = "孔个数")
   @JsonProperty("radiusQuantity")
   @JSONField(name = "radiusQuantity")
   @TableField("radius_quantity")
   @Column(name = "radius_quantity", columnDefinition = "int(11) default '0' COMMENT '孔个数'", nullable = false)
   private Integer radiusQuantity;
   @ApiModelProperty(name = "wage", value = "单价", notes = "单价")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   @TableField("wage")
   @Column(name = "wage", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单价'", nullable = false)
   private BigDecimal wage;
   @ApiModelProperty(name = "price", value = "总工价", notes = "总工价")
   @JsonProperty("price")
   @JSONField(name = "price")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总工价'", nullable = false)
   private BigDecimal price;
   @ApiModelProperty(name = "paintingTypeEnum", value = "油漆类别")
   @JsonProperty("paintingTypeEnum")
   @JSONField(name = "paintingTypeEnum")
   @TableField("painting_type_enum")
   @Column(name = "painting_type_enum", columnDefinition = "int(2)  COMMENT '油漆类别'")
   private Integer paintingTypeEnum;
   @ApiModelProperty(name = "radius", value = "孔径", notes = "孔径")
   @JsonProperty("radius")
   @JSONField(name = "radius")
   @TableField("radius")
   @Column(name = "radius", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '孔径'")
   private BigDecimal radius;
   @ApiModelProperty(name = "paintingThickness", value = "涂装后端", notes = "涂装后端")
   @JsonProperty("paintingThickness")
   @JSONField(name = "paintingThickness")
   @TableField("painting_thickness")
   @Column(name = "painting_thickness", columnDefinition = "decimal(32,6)  COMMENT '干膜厚度(um)'", nullable = true)
   private BigDecimal paintingThickness;
   @ApiModelProperty(name = "thickness", value = "标准厚度(微米)")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "int(11) COMMENT '计量单位'")
   private BigDecimal thickness;
   @ApiModelProperty(name = "outThickness", value = "超标厚度(微米)")
   @JsonProperty("outThickness")
   @JSONField(name = "outThickness")
   @TableField("out_thickness")
   @Column(name = "out_thickness", columnDefinition = "int(11) COMMENT '超标厚度'")
   private BigDecimal outThickness;
   @ApiModelProperty(name = "unitPrice", value = "标准单价(元)")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(10,2)  default '0.00000000' COMMENT '单价(元)'")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "outUnitPrice", value = "超标单价(元)")
   @JsonProperty("outUnitPrice")
   @JSONField(name = "outUnitPrice")
   @TableField("out_unit_price")
   @Column(name = "out_unit_price", columnDefinition = "decimal(10,2) default '0.00000000' COMMENT '单价(元)'")
   private BigDecimal outUnitPrice;

   public static MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder builder() {
      return new MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder();
   }

   public MesBuildingProduceTeamReportPrice() {
   }

   public MesBuildingProduceTeamReportPrice(
      final Long id,
      final Long taskId,
      final Long taskOrderId,
      final Long taskProcessId,
      final Long processId,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final Integer inspectionQuantity,
      final Long teamReoprtId,
      final Long teamId,
      final Long userId,
      final Integer reportType,
      final Integer wageQuotaType,
      final Integer radiusQuantity,
      final BigDecimal wage,
      final BigDecimal price,
      final Integer paintingTypeEnum,
      final BigDecimal radius,
      final BigDecimal paintingThickness,
      final BigDecimal thickness,
      final BigDecimal outThickness,
      final BigDecimal unitPrice,
      final BigDecimal outUnitPrice
   ) {
      this.id = id;
      this.taskId = taskId;
      this.taskOrderId = taskOrderId;
      this.taskProcessId = taskProcessId;
      this.processId = processId;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.inspectionQuantity = inspectionQuantity;
      this.teamReoprtId = teamReoprtId;
      this.teamId = teamId;
      this.userId = userId;
      this.reportType = reportType;
      this.wageQuotaType = wageQuotaType;
      this.radiusQuantity = radiusQuantity;
      this.wage = wage;
      this.price = price;
      this.paintingTypeEnum = paintingTypeEnum;
      this.radius = radius;
      this.paintingThickness = paintingThickness;
      this.thickness = thickness;
      this.outThickness = outThickness;
      this.unitPrice = unitPrice;
      this.outUnitPrice = outUnitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Long getTeamReoprtId() {
      return this.teamReoprtId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Integer getRadiusQuantity() {
      return this.radiusQuantity;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Integer getPaintingTypeEnum() {
      return this.paintingTypeEnum;
   }

   public BigDecimal getRadius() {
      return this.radius;
   }

   public BigDecimal getPaintingThickness() {
      return this.paintingThickness;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getOutThickness() {
      return this.outThickness;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getOutUnitPrice() {
      return this.outUnitPrice;
   }

   @JsonProperty("id")
   public MesBuildingProduceTeamReportPrice setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingProduceTeamReportPrice setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingProduceTeamReportPrice setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingProduceTeamReportPrice setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProduceTeamReportPrice setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingProduceTeamReportPrice setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingProduceTeamReportPrice setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingProduceTeamReportPrice setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public MesBuildingProduceTeamReportPrice setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("teamReoprtId")
   public MesBuildingProduceTeamReportPrice setTeamReoprtId(final Long teamReoprtId) {
      this.teamReoprtId = teamReoprtId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingProduceTeamReportPrice setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProduceTeamReportPrice setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("reportType")
   public MesBuildingProduceTeamReportPrice setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesBuildingProduceTeamReportPrice setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("radiusQuantity")
   public MesBuildingProduceTeamReportPrice setRadiusQuantity(final Integer radiusQuantity) {
      this.radiusQuantity = radiusQuantity;
      return this;
   }

   @JsonProperty("wage")
   public MesBuildingProduceTeamReportPrice setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   @JsonProperty("price")
   public MesBuildingProduceTeamReportPrice setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("paintingTypeEnum")
   public MesBuildingProduceTeamReportPrice setPaintingTypeEnum(final Integer paintingTypeEnum) {
      this.paintingTypeEnum = paintingTypeEnum;
      return this;
   }

   @JsonProperty("radius")
   public MesBuildingProduceTeamReportPrice setRadius(final BigDecimal radius) {
      this.radius = radius;
      return this;
   }

   @JsonProperty("paintingThickness")
   public MesBuildingProduceTeamReportPrice setPaintingThickness(final BigDecimal paintingThickness) {
      this.paintingThickness = paintingThickness;
      return this;
   }

   @JsonProperty("thickness")
   public MesBuildingProduceTeamReportPrice setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("outThickness")
   public MesBuildingProduceTeamReportPrice setOutThickness(final BigDecimal outThickness) {
      this.outThickness = outThickness;
      return this;
   }

   @JsonProperty("unitPrice")
   public MesBuildingProduceTeamReportPrice setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("outUnitPrice")
   public MesBuildingProduceTeamReportPrice setOutUnitPrice(final BigDecimal outUnitPrice) {
      this.outUnitPrice = outUnitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProduceTeamReportPrice(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", processId="
         + this.getProcessId()
         + ", productId="
         + this.getProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", teamReoprtId="
         + this.getTeamReoprtId()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ", reportType="
         + this.getReportType()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", radiusQuantity="
         + this.getRadiusQuantity()
         + ", wage="
         + this.getWage()
         + ", price="
         + this.getPrice()
         + ", paintingTypeEnum="
         + this.getPaintingTypeEnum()
         + ", radius="
         + this.getRadius()
         + ", paintingThickness="
         + this.getPaintingThickness()
         + ", thickness="
         + this.getThickness()
         + ", outThickness="
         + this.getOutThickness()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", outUnitPrice="
         + this.getOutUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProduceTeamReportPrice)) {
         return false;
      }

      MesBuildingProduceTeamReportPrice other = (MesBuildingProduceTeamReportPrice)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$taskOrderId = this.getTaskOrderId();
            Object other$taskOrderId = other.getTaskOrderId();
            if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
               Object this$taskProcessId = this.getTaskProcessId();
               Object other$taskProcessId = other.getTaskProcessId();
               if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$taskTypeEnum = this.getTaskTypeEnum();
                        Object other$taskTypeEnum = other.getTaskTypeEnum();
                        if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$inspectionQuantity = this.getInspectionQuantity();
                              Object other$inspectionQuantity = other.getInspectionQuantity();
                              if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)
                                 )
                               {
                                 Object this$teamReoprtId = this.getTeamReoprtId();
                                 Object other$teamReoprtId = other.getTeamReoprtId();
                                 if (this$teamReoprtId == null ? other$teamReoprtId == null : this$teamReoprtId.equals(other$teamReoprtId)) {
                                    Object this$teamId = this.getTeamId();
                                    Object other$teamId = other.getTeamId();
                                    if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                       Object this$userId = this.getUserId();
                                       Object other$userId = other.getUserId();
                                       if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                          Object this$reportType = this.getReportType();
                                          Object other$reportType = other.getReportType();
                                          if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                                             Object this$wageQuotaType = this.getWageQuotaType();
                                             Object other$wageQuotaType = other.getWageQuotaType();
                                             if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                                                Object this$radiusQuantity = this.getRadiusQuantity();
                                                Object other$radiusQuantity = other.getRadiusQuantity();
                                                if (this$radiusQuantity == null
                                                   ? other$radiusQuantity == null
                                                   : this$radiusQuantity.equals(other$radiusQuantity)) {
                                                   Object this$paintingTypeEnum = this.getPaintingTypeEnum();
                                                   Object other$paintingTypeEnum = other.getPaintingTypeEnum();
                                                   if (this$paintingTypeEnum == null
                                                      ? other$paintingTypeEnum == null
                                                      : this$paintingTypeEnum.equals(other$paintingTypeEnum)) {
                                                      Object this$wage = this.getWage();
                                                      Object other$wage = other.getWage();
                                                      if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                                         Object this$price = this.getPrice();
                                                         Object other$price = other.getPrice();
                                                         if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                            Object this$radius = this.getRadius();
                                                            Object other$radius = other.getRadius();
                                                            if (this$radius == null ? other$radius == null : this$radius.equals(other$radius)) {
                                                               Object this$paintingThickness = this.getPaintingThickness();
                                                               Object other$paintingThickness = other.getPaintingThickness();
                                                               if (this$paintingThickness == null
                                                                  ? other$paintingThickness == null
                                                                  : this$paintingThickness.equals(other$paintingThickness)) {
                                                                  Object this$thickness = this.getThickness();
                                                                  Object other$thickness = other.getThickness();
                                                                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)
                                                                     )
                                                                   {
                                                                     Object this$outThickness = this.getOutThickness();
                                                                     Object other$outThickness = other.getOutThickness();
                                                                     if (this$outThickness == null
                                                                        ? other$outThickness == null
                                                                        : this$outThickness.equals(other$outThickness)) {
                                                                        Object this$unitPrice = this.getUnitPrice();
                                                                        Object other$unitPrice = other.getUnitPrice();
                                                                        if (this$unitPrice == null
                                                                           ? other$unitPrice == null
                                                                           : this$unitPrice.equals(other$unitPrice)) {
                                                                           Object this$outUnitPrice = this.getOutUnitPrice();
                                                                           Object other$outUnitPrice = other.getOutUnitPrice();
                                                                           return this$outUnitPrice == null
                                                                              ? other$outUnitPrice == null
                                                                              : this$outUnitPrice.equals(other$outUnitPrice);
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingProduceTeamReportPrice;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $teamReoprtId = this.getTeamReoprtId();
      result = result * 59 + ($teamReoprtId == null ? 43 : $teamReoprtId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $radiusQuantity = this.getRadiusQuantity();
      result = result * 59 + ($radiusQuantity == null ? 43 : $radiusQuantity.hashCode());
      Object $paintingTypeEnum = this.getPaintingTypeEnum();
      result = result * 59 + ($paintingTypeEnum == null ? 43 : $paintingTypeEnum.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $radius = this.getRadius();
      result = result * 59 + ($radius == null ? 43 : $radius.hashCode());
      Object $paintingThickness = this.getPaintingThickness();
      result = result * 59 + ($paintingThickness == null ? 43 : $paintingThickness.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $outThickness = this.getOutThickness();
      result = result * 59 + ($outThickness == null ? 43 : $outThickness.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $outUnitPrice = this.getOutUnitPrice();
      return result * 59 + ($outUnitPrice == null ? 43 : $outUnitPrice.hashCode());
   }

   public static class MesBuildingProduceTeamReportPriceBuilder {
      private Long id;
      private Long taskId;
      private Long taskOrderId;
      private Long taskProcessId;
      private Long processId;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private Integer inspectionQuantity;
      private Long teamReoprtId;
      private Long teamId;
      private Long userId;
      private Integer reportType;
      private Integer wageQuotaType;
      private Integer radiusQuantity;
      private BigDecimal wage;
      private BigDecimal price;
      private Integer paintingTypeEnum;
      private BigDecimal radius;
      private BigDecimal paintingThickness;
      private BigDecimal thickness;
      private BigDecimal outThickness;
      private BigDecimal unitPrice;
      private BigDecimal outUnitPrice;

      MesBuildingProduceTeamReportPriceBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("teamReoprtId")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder teamReoprtId(final Long teamReoprtId) {
         this.teamReoprtId = teamReoprtId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("reportType")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("radiusQuantity")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder radiusQuantity(final Integer radiusQuantity) {
         this.radiusQuantity = radiusQuantity;
         return this;
      }

      @JsonProperty("wage")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      @JsonProperty("price")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("paintingTypeEnum")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder paintingTypeEnum(final Integer paintingTypeEnum) {
         this.paintingTypeEnum = paintingTypeEnum;
         return this;
      }

      @JsonProperty("radius")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder radius(final BigDecimal radius) {
         this.radius = radius;
         return this;
      }

      @JsonProperty("paintingThickness")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder paintingThickness(final BigDecimal paintingThickness) {
         this.paintingThickness = paintingThickness;
         return this;
      }

      @JsonProperty("thickness")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("outThickness")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder outThickness(final BigDecimal outThickness) {
         this.outThickness = outThickness;
         return this;
      }

      @JsonProperty("unitPrice")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("outUnitPrice")
      public MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder outUnitPrice(final BigDecimal outUnitPrice) {
         this.outUnitPrice = outUnitPrice;
         return this;
      }

      public MesBuildingProduceTeamReportPrice build() {
         return new MesBuildingProduceTeamReportPrice(
            this.id,
            this.taskId,
            this.taskOrderId,
            this.taskProcessId,
            this.processId,
            this.productId,
            this.taskTypeEnum,
            this.quantity,
            this.inspectionQuantity,
            this.teamReoprtId,
            this.teamId,
            this.userId,
            this.reportType,
            this.wageQuotaType,
            this.radiusQuantity,
            this.wage,
            this.price,
            this.paintingTypeEnum,
            this.radius,
            this.paintingThickness,
            this.thickness,
            this.outThickness,
            this.unitPrice,
            this.outUnitPrice
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProduceTeamReportPrice.MesBuildingProduceTeamReportPriceBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", taskOrderId="
            + this.taskOrderId
            + ", taskProcessId="
            + this.taskProcessId
            + ", processId="
            + this.processId
            + ", productId="
            + this.productId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", teamReoprtId="
            + this.teamReoprtId
            + ", teamId="
            + this.teamId
            + ", userId="
            + this.userId
            + ", reportType="
            + this.reportType
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", radiusQuantity="
            + this.radiusQuantity
            + ", wage="
            + this.wage
            + ", price="
            + this.price
            + ", paintingTypeEnum="
            + this.paintingTypeEnum
            + ", radius="
            + this.radius
            + ", paintingThickness="
            + this.paintingThickness
            + ", thickness="
            + this.thickness
            + ", outThickness="
            + this.outThickness
            + ", unitPrice="
            + this.unitPrice
            + ", outUnitPrice="
            + this.outUnitPrice
            + ")";
      }
   }
}
