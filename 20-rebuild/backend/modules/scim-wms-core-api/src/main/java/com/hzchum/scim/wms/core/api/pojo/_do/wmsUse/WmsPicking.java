package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "WmsPicking对象", description = "")
@Entity
@TableName("wms_picking")
@Table(name = "wms_picking")
@org.hibernate.annotations.Table(appliesTo = "wms_picking")
public class WmsPicking extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "mesWorkshopId", value = "车间ID", notes = "车间ID")
   @TableField("mes_workshop_id")
   @Column(name = "mes_workshop_id", columnDefinition = "bigint(20)  COMMENT '车间ID'", nullable = true)
   private Long mesWorkshopId;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint(20)  COMMENT '申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "taskOrderNumber", value = "工单号", notes = "工单号")
   @TableField("task_order_number")
   @Column(name = "task_order_number", columnDefinition = "varchar(255)  COMMENT '工单号'", nullable = true)
   private String taskOrderNumber;
   @ApiModelProperty(name = "materialType", value = "物料种类", notes = "物料种类")
   @TableField("material_type")
   @Column(name = "material_type", columnDefinition = "varchar(255) COMMENT '物料种类'", nullable = true)
   private String materialType;
   @ApiModelProperty(name = "pickingMete", value = "领料量", notes = "领料量")
   @TableField("picking_mete")
   @Column(name = "picking_mete", columnDefinition = "decimal(32,8)  COMMENT '领料量'", nullable = true)
   private BigDecimal pickingMete;
   @ApiModelProperty(name = "outboundMete", value = "出库量", notes = "出库量")
   @TableField("outbound_mete")
   @Column(name = "outbound_mete", columnDefinition = "decimal(32,8)  COMMENT '出库量'", nullable = true)
   private BigDecimal outboundMete;
   @ApiModelProperty(name = "pickingArea", value = "领料面积(钢板适用)", notes = "领料面积(钢板适用)")
   @TableField("picking_area")
   @Column(name = "picking_area", columnDefinition = "decimal(32,8)  COMMENT '领料面积(钢板适用)'", nullable = true)
   private BigDecimal pickingArea;
   @ApiModelProperty(name = "handlingArea", value = "出库面积(钢板适用)", notes = "出库面积(钢板适用)")
   @TableField("handling_area")
   @Column(name = "handling_area", columnDefinition = "decimal(32,8)  COMMENT '出库面积(钢板适用)'", nullable = true)
   private BigDecimal handlingArea;
   @ApiModelProperty(name = "pickingLength", value = "领料长度(型材适用)", notes = "领料长度(型材适用)")
   @TableField("picking_length")
   @Column(name = "picking_length", columnDefinition = "decimal(32,8)  COMMENT '领料长度(型材适用)'", nullable = true)
   private BigDecimal pickingLength;
   @ApiModelProperty(name = "handlingLength", value = "出库长度(型材适用)", notes = "出库长度(型材适用)")
   @TableField("handling_length")
   @Column(name = "handling_length", columnDefinition = "decimal(32,8)  COMMENT '出库长度(型材适用)'", nullable = true)
   private BigDecimal handlingLength;
   @ApiModelProperty(name = "transactStatus", value = "办理状态 PickingStatusEnum", notes = "办理状态 PickingStatusEnum")
   @TableField("transact_status")
   @Column(name = "transact_status", columnDefinition = "int(11)  COMMENT '办理状态 PickingStatusEnum'", nullable = true)
   private Integer transactStatus;
   @ApiModelProperty(name = "taskOrderId", value = "工单ID", notes = "工单ID")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20)  COMMENT '工单ID'", nullable = true)
   private Long taskOrderId;
   @ApiModelProperty(name = "boolAuto", value = "是否数控", notes = "是否数控")
   @TableField("bool_auto")
   @Column(name = "bool_auto", columnDefinition = "tinyint(1) default '0'  COMMENT '是否数控'", nullable = false)
   private Boolean boolAuto;

   public static WmsPicking.WmsPickingBuilder builder() {
      return new WmsPicking.WmsPickingBuilder();
   }

   public WmsPicking() {
   }

   public WmsPicking(
      final Long id,
      final Long projectId,
      final Long mesWorkshopId,
      final Long applicantId,
      final String taskOrderNumber,
      final String materialType,
      final BigDecimal pickingMete,
      final BigDecimal outboundMete,
      final BigDecimal pickingArea,
      final BigDecimal handlingArea,
      final BigDecimal pickingLength,
      final BigDecimal handlingLength,
      final Integer transactStatus,
      final Long taskOrderId,
      final Boolean boolAuto
   ) {
      this.id = id;
      this.projectId = projectId;
      this.mesWorkshopId = mesWorkshopId;
      this.applicantId = applicantId;
      this.taskOrderNumber = taskOrderNumber;
      this.materialType = materialType;
      this.pickingMete = pickingMete;
      this.outboundMete = outboundMete;
      this.pickingArea = pickingArea;
      this.handlingArea = handlingArea;
      this.pickingLength = pickingLength;
      this.handlingLength = handlingLength;
      this.transactStatus = transactStatus;
      this.taskOrderId = taskOrderId;
      this.boolAuto = boolAuto;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMesWorkshopId() {
      return this.mesWorkshopId;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public String getMaterialType() {
      return this.materialType;
   }

   public BigDecimal getPickingMete() {
      return this.pickingMete;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getPickingArea() {
      return this.pickingArea;
   }

   public BigDecimal getHandlingArea() {
      return this.handlingArea;
   }

   public BigDecimal getPickingLength() {
      return this.pickingLength;
   }

   public BigDecimal getHandlingLength() {
      return this.handlingLength;
   }

   public Integer getTransactStatus() {
      return this.transactStatus;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Boolean getBoolAuto() {
      return this.boolAuto;
   }

   public WmsPicking setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsPicking setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public WmsPicking setMesWorkshopId(final Long mesWorkshopId) {
      this.mesWorkshopId = mesWorkshopId;
      return this;
   }

   public WmsPicking setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   public WmsPicking setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
      return this;
   }

   public WmsPicking setMaterialType(final String materialType) {
      this.materialType = materialType;
      return this;
   }

   public WmsPicking setPickingMete(final BigDecimal pickingMete) {
      this.pickingMete = pickingMete;
      return this;
   }

   public WmsPicking setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
      return this;
   }

   public WmsPicking setPickingArea(final BigDecimal pickingArea) {
      this.pickingArea = pickingArea;
      return this;
   }

   public WmsPicking setHandlingArea(final BigDecimal handlingArea) {
      this.handlingArea = handlingArea;
      return this;
   }

   public WmsPicking setPickingLength(final BigDecimal pickingLength) {
      this.pickingLength = pickingLength;
      return this;
   }

   public WmsPicking setHandlingLength(final BigDecimal handlingLength) {
      this.handlingLength = handlingLength;
      return this;
   }

   public WmsPicking setTransactStatus(final Integer transactStatus) {
      this.transactStatus = transactStatus;
      return this;
   }

   public WmsPicking setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   public WmsPicking setBoolAuto(final Boolean boolAuto) {
      this.boolAuto = boolAuto;
      return this;
   }

   @Override
   public String toString() {
      return "WmsPicking(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", mesWorkshopId="
         + this.getMesWorkshopId()
         + ", applicantId="
         + this.getApplicantId()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", materialType="
         + this.getMaterialType()
         + ", pickingMete="
         + this.getPickingMete()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", pickingArea="
         + this.getPickingArea()
         + ", handlingArea="
         + this.getHandlingArea()
         + ", pickingLength="
         + this.getPickingLength()
         + ", handlingLength="
         + this.getHandlingLength()
         + ", transactStatus="
         + this.getTransactStatus()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", boolAuto="
         + this.getBoolAuto()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPicking)) {
         return false;
      }

      WmsPicking other = (WmsPicking)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$mesWorkshopId = this.getMesWorkshopId();
            Object other$mesWorkshopId = other.getMesWorkshopId();
            if (this$mesWorkshopId == null ? other$mesWorkshopId == null : this$mesWorkshopId.equals(other$mesWorkshopId)) {
               Object this$applicantId = this.getApplicantId();
               Object other$applicantId = other.getApplicantId();
               if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                  Object this$transactStatus = this.getTransactStatus();
                  Object other$transactStatus = other.getTransactStatus();
                  if (this$transactStatus == null ? other$transactStatus == null : this$transactStatus.equals(other$transactStatus)) {
                     Object this$taskOrderId = this.getTaskOrderId();
                     Object other$taskOrderId = other.getTaskOrderId();
                     if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                        Object this$boolAuto = this.getBoolAuto();
                        Object other$boolAuto = other.getBoolAuto();
                        if (this$boolAuto == null ? other$boolAuto == null : this$boolAuto.equals(other$boolAuto)) {
                           Object this$taskOrderNumber = this.getTaskOrderNumber();
                           Object other$taskOrderNumber = other.getTaskOrderNumber();
                           if (this$taskOrderNumber == null ? other$taskOrderNumber == null : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                              Object this$materialType = this.getMaterialType();
                              Object other$materialType = other.getMaterialType();
                              if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                                 Object this$pickingMete = this.getPickingMete();
                                 Object other$pickingMete = other.getPickingMete();
                                 if (this$pickingMete == null ? other$pickingMete == null : this$pickingMete.equals(other$pickingMete)) {
                                    Object this$outboundMete = this.getOutboundMete();
                                    Object other$outboundMete = other.getOutboundMete();
                                    if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                                       Object this$pickingArea = this.getPickingArea();
                                       Object other$pickingArea = other.getPickingArea();
                                       if (this$pickingArea == null ? other$pickingArea == null : this$pickingArea.equals(other$pickingArea)) {
                                          Object this$handlingArea = this.getHandlingArea();
                                          Object other$handlingArea = other.getHandlingArea();
                                          if (this$handlingArea == null ? other$handlingArea == null : this$handlingArea.equals(other$handlingArea)) {
                                             Object this$pickingLength = this.getPickingLength();
                                             Object other$pickingLength = other.getPickingLength();
                                             if (this$pickingLength == null ? other$pickingLength == null : this$pickingLength.equals(other$pickingLength)) {
                                                Object this$handlingLength = this.getHandlingLength();
                                                Object other$handlingLength = other.getHandlingLength();
                                                return this$handlingLength == null
                                                   ? other$handlingLength == null
                                                   : this$handlingLength.equals(other$handlingLength);
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof WmsPicking;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $mesWorkshopId = this.getMesWorkshopId();
      result = result * 59 + ($mesWorkshopId == null ? 43 : $mesWorkshopId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $transactStatus = this.getTransactStatus();
      result = result * 59 + ($transactStatus == null ? 43 : $transactStatus.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $boolAuto = this.getBoolAuto();
      result = result * 59 + ($boolAuto == null ? 43 : $boolAuto.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $pickingMete = this.getPickingMete();
      result = result * 59 + ($pickingMete == null ? 43 : $pickingMete.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $pickingArea = this.getPickingArea();
      result = result * 59 + ($pickingArea == null ? 43 : $pickingArea.hashCode());
      Object $handlingArea = this.getHandlingArea();
      result = result * 59 + ($handlingArea == null ? 43 : $handlingArea.hashCode());
      Object $pickingLength = this.getPickingLength();
      result = result * 59 + ($pickingLength == null ? 43 : $pickingLength.hashCode());
      Object $handlingLength = this.getHandlingLength();
      return result * 59 + ($handlingLength == null ? 43 : $handlingLength.hashCode());
   }

   public static class WmsPickingBuilder {
      private Long id;
      private Long projectId;
      private Long mesWorkshopId;
      private Long applicantId;
      private String taskOrderNumber;
      private String materialType;
      private BigDecimal pickingMete;
      private BigDecimal outboundMete;
      private BigDecimal pickingArea;
      private BigDecimal handlingArea;
      private BigDecimal pickingLength;
      private BigDecimal handlingLength;
      private Integer transactStatus;
      private Long taskOrderId;
      private Boolean boolAuto;

      WmsPickingBuilder() {
      }

      public WmsPicking.WmsPickingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsPicking.WmsPickingBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WmsPicking.WmsPickingBuilder mesWorkshopId(final Long mesWorkshopId) {
         this.mesWorkshopId = mesWorkshopId;
         return this;
      }

      public WmsPicking.WmsPickingBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public WmsPicking.WmsPickingBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      public WmsPicking.WmsPickingBuilder materialType(final String materialType) {
         this.materialType = materialType;
         return this;
      }

      public WmsPicking.WmsPickingBuilder pickingMete(final BigDecimal pickingMete) {
         this.pickingMete = pickingMete;
         return this;
      }

      public WmsPicking.WmsPickingBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public WmsPicking.WmsPickingBuilder pickingArea(final BigDecimal pickingArea) {
         this.pickingArea = pickingArea;
         return this;
      }

      public WmsPicking.WmsPickingBuilder handlingArea(final BigDecimal handlingArea) {
         this.handlingArea = handlingArea;
         return this;
      }

      public WmsPicking.WmsPickingBuilder pickingLength(final BigDecimal pickingLength) {
         this.pickingLength = pickingLength;
         return this;
      }

      public WmsPicking.WmsPickingBuilder handlingLength(final BigDecimal handlingLength) {
         this.handlingLength = handlingLength;
         return this;
      }

      public WmsPicking.WmsPickingBuilder transactStatus(final Integer transactStatus) {
         this.transactStatus = transactStatus;
         return this;
      }

      public WmsPicking.WmsPickingBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public WmsPicking.WmsPickingBuilder boolAuto(final Boolean boolAuto) {
         this.boolAuto = boolAuto;
         return this;
      }

      public WmsPicking build() {
         return new WmsPicking(
            this.id,
            this.projectId,
            this.mesWorkshopId,
            this.applicantId,
            this.taskOrderNumber,
            this.materialType,
            this.pickingMete,
            this.outboundMete,
            this.pickingArea,
            this.handlingArea,
            this.pickingLength,
            this.handlingLength,
            this.transactStatus,
            this.taskOrderId,
            this.boolAuto
         );
      }

      @Override
      public String toString() {
         return "WmsPicking.WmsPickingBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", mesWorkshopId="
            + this.mesWorkshopId
            + ", applicantId="
            + this.applicantId
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", materialType="
            + this.materialType
            + ", pickingMete="
            + this.pickingMete
            + ", outboundMete="
            + this.outboundMete
            + ", pickingArea="
            + this.pickingArea
            + ", handlingArea="
            + this.handlingArea
            + ", pickingLength="
            + this.pickingLength
            + ", handlingLength="
            + this.handlingLength
            + ", transactStatus="
            + this.transactStatus
            + ", taskOrderId="
            + this.taskOrderId
            + ", boolAuto="
            + this.boolAuto
            + ")";
      }
   }
}
