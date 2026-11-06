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

@ApiModel(value = "WmsShipmentReceiveApprove对象", description = "配套件领用出库审核对象")
@Entity
@TableName("wms_shipment_receive_approve")
@Table(name = "wms_shipment_receive_approve")
@org.hibernate.annotations.Table(appliesTo = "wms_shipment_receive_approve")
public class WmsShipmentReceiveApprove extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "发运领用单编号", notes = "发运领用单编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '发运领用单编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "materialType", value = "材料类型", notes = "材料类型")
   @TableField("material_type")
   @Column(name = "material_type", columnDefinition = "int(11)  COMMENT '材料类型'", nullable = true)
   private Integer materialType;
   @ApiModelProperty(name = "detailIds", value = "发运明细ID集合", notes = "发运明细ID集合")
   @TableField("detail_ids")
   @Column(name = "detail_ids", columnDefinition = "varchar(1000)  COMMENT '发运明细ID集合'", nullable = true)
   private String detailIds;
   @ApiModelProperty(name = "outboundIds", value = "出库单ID集合", notes = "出库单ID集合")
   @TableField("outbound_ids")
   @Column(name = "outbound_ids", columnDefinition = "varchar(255)  COMMENT '出库单ID集合'", nullable = true)
   private String outboundIds;
   @ApiModelProperty(name = "outboundQuantity", value = "出库总量", notes = "出库总量")
   @TableField("outbound_quantity")
   @Column(name = "outbound_quantity", columnDefinition = "decimal(32,8)  COMMENT '出库总量'", nullable = true)
   private BigDecimal outboundQuantity;
   @ApiModelProperty(name = "outboundMete", value = "出库总量", notes = "出库总量")
   @TableField("outbound_mete")
   @Column(name = "outbound_mete", columnDefinition = "decimal(32,8)  COMMENT '出库总量'", nullable = true)
   private BigDecimal outboundMete;
   @ApiModelProperty(name = "projectIds", value = "发运领用项目ID", notes = "发运领用项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '发运领用项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "mesWorkshopIds", value = "发运领用车间ID集合", notes = "发运领用车间ID集合")
   @TableField("mes_workshop_ids")
   @Column(name = "mes_workshop_ids", columnDefinition = "varchar(255)  COMMENT '发运领用车间ID集合'", nullable = true)
   private String mesWorkshopIds;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint(20)  COMMENT '申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(50)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 ReviewStatusEnum", notes = "审核状态 ReviewStatusEnum")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int(11)  COMMENT '审核状态 ReviewStatusEnum'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;

   public static WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder builder() {
      return new WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder();
   }

   public WmsShipmentReceiveApprove() {
   }

   public WmsShipmentReceiveApprove(
      final Long id,
      final String serialNumber,
      final Integer materialType,
      final String detailIds,
      final String outboundIds,
      final BigDecimal outboundQuantity,
      final BigDecimal outboundMete,
      final Long projectId,
      final String mesWorkshopIds,
      final Long applicantId,
      final String applicantName,
      final Long approveRecordId,
      final Integer reviewStatus,
      final String remark
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.materialType = materialType;
      this.detailIds = detailIds;
      this.outboundIds = outboundIds;
      this.outboundQuantity = outboundQuantity;
      this.outboundMete = outboundMete;
      this.projectId = projectId;
      this.mesWorkshopIds = mesWorkshopIds;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.approveRecordId = approveRecordId;
      this.reviewStatus = reviewStatus;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public String getDetailIds() {
      return this.detailIds;
   }

   public String getOutboundIds() {
      return this.outboundIds;
   }

   public BigDecimal getOutboundQuantity() {
      return this.outboundQuantity;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getMesWorkshopIds() {
      return this.mesWorkshopIds;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getRemark() {
      return this.remark;
   }

   public WmsShipmentReceiveApprove setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsShipmentReceiveApprove setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public WmsShipmentReceiveApprove setMaterialType(final Integer materialType) {
      this.materialType = materialType;
      return this;
   }

   public WmsShipmentReceiveApprove setDetailIds(final String detailIds) {
      this.detailIds = detailIds;
      return this;
   }

   public WmsShipmentReceiveApprove setOutboundIds(final String outboundIds) {
      this.outboundIds = outboundIds;
      return this;
   }

   public WmsShipmentReceiveApprove setOutboundQuantity(final BigDecimal outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
      return this;
   }

   public WmsShipmentReceiveApprove setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
      return this;
   }

   public WmsShipmentReceiveApprove setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public WmsShipmentReceiveApprove setMesWorkshopIds(final String mesWorkshopIds) {
      this.mesWorkshopIds = mesWorkshopIds;
      return this;
   }

   public WmsShipmentReceiveApprove setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   public WmsShipmentReceiveApprove setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   public WmsShipmentReceiveApprove setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public WmsShipmentReceiveApprove setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   public WmsShipmentReceiveApprove setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "WmsShipmentReceiveApprove(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", materialType="
         + this.getMaterialType()
         + ", detailIds="
         + this.getDetailIds()
         + ", outboundIds="
         + this.getOutboundIds()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", projectId="
         + this.getProjectId()
         + ", mesWorkshopIds="
         + this.getMesWorkshopIds()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsShipmentReceiveApprove)) {
         return false;
      }

      WmsShipmentReceiveApprove other = (WmsShipmentReceiveApprove)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialType = this.getMaterialType();
         Object other$materialType = other.getMaterialType();
         if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$applicantId = this.getApplicantId();
               Object other$applicantId = other.getApplicantId();
               if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                  Object this$approveRecordId = this.getApproveRecordId();
                  Object other$approveRecordId = other.getApproveRecordId();
                  if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                     Object this$reviewStatus = this.getReviewStatus();
                     Object other$reviewStatus = other.getReviewStatus();
                     if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$detailIds = this.getDetailIds();
                           Object other$detailIds = other.getDetailIds();
                           if (this$detailIds == null ? other$detailIds == null : this$detailIds.equals(other$detailIds)) {
                              Object this$outboundIds = this.getOutboundIds();
                              Object other$outboundIds = other.getOutboundIds();
                              if (this$outboundIds == null ? other$outboundIds == null : this$outboundIds.equals(other$outboundIds)) {
                                 Object this$outboundQuantity = this.getOutboundQuantity();
                                 Object other$outboundQuantity = other.getOutboundQuantity();
                                 if (this$outboundQuantity == null ? other$outboundQuantity == null : this$outboundQuantity.equals(other$outboundQuantity)) {
                                    Object this$outboundMete = this.getOutboundMete();
                                    Object other$outboundMete = other.getOutboundMete();
                                    if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                                       Object this$mesWorkshopIds = this.getMesWorkshopIds();
                                       Object other$mesWorkshopIds = other.getMesWorkshopIds();
                                       if (this$mesWorkshopIds == null ? other$mesWorkshopIds == null : this$mesWorkshopIds.equals(other$mesWorkshopIds)) {
                                          Object this$applicantName = this.getApplicantName();
                                          Object other$applicantName = other.getApplicantName();
                                          if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                             Object this$remark = this.getRemark();
                                             Object other$remark = other.getRemark();
                                             return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof WmsShipmentReceiveApprove;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $detailIds = this.getDetailIds();
      result = result * 59 + ($detailIds == null ? 43 : $detailIds.hashCode());
      Object $outboundIds = this.getOutboundIds();
      result = result * 59 + ($outboundIds == null ? 43 : $outboundIds.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $mesWorkshopIds = this.getMesWorkshopIds();
      result = result * 59 + ($mesWorkshopIds == null ? 43 : $mesWorkshopIds.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class WmsShipmentReceiveApproveBuilder {
      private Long id;
      private String serialNumber;
      private Integer materialType;
      private String detailIds;
      private String outboundIds;
      private BigDecimal outboundQuantity;
      private BigDecimal outboundMete;
      private Long projectId;
      private String mesWorkshopIds;
      private Long applicantId;
      private String applicantName;
      private Long approveRecordId;
      private Integer reviewStatus;
      private String remark;

      WmsShipmentReceiveApproveBuilder() {
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder detailIds(final String detailIds) {
         this.detailIds = detailIds;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder outboundIds(final String outboundIds) {
         this.outboundIds = outboundIds;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder outboundQuantity(final BigDecimal outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder mesWorkshopIds(final String mesWorkshopIds) {
         this.mesWorkshopIds = mesWorkshopIds;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WmsShipmentReceiveApprove build() {
         return new WmsShipmentReceiveApprove(
            this.id,
            this.serialNumber,
            this.materialType,
            this.detailIds,
            this.outboundIds,
            this.outboundQuantity,
            this.outboundMete,
            this.projectId,
            this.mesWorkshopIds,
            this.applicantId,
            this.applicantName,
            this.approveRecordId,
            this.reviewStatus,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "WmsShipmentReceiveApprove.WmsShipmentReceiveApproveBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", materialType="
            + this.materialType
            + ", detailIds="
            + this.detailIds
            + ", outboundIds="
            + this.outboundIds
            + ", outboundQuantity="
            + this.outboundQuantity
            + ", outboundMete="
            + this.outboundMete
            + ", projectId="
            + this.projectId
            + ", mesWorkshopIds="
            + this.mesWorkshopIds
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", approveRecordId="
            + this.approveRecordId
            + ", reviewStatus="
            + this.reviewStatus
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
