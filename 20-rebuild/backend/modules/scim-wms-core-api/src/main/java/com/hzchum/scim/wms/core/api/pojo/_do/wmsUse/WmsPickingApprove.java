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

@ApiModel(value = "WmsPickingApprove对象", description = "领料排产出库审核对象")
@Entity
@TableName("wms_picking_approve")
@Table(name = "wms_picking_approve")
@org.hibernate.annotations.Table(appliesTo = "wms_picking_approve")
public class WmsPickingApprove extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "materialType", value = "领料类型", notes = "领料类型")
   @TableField("material_type")
   @Column(name = "material_type", columnDefinition = "varchar(50)  COMMENT '领料类型'", nullable = true)
   private String materialType;
   @ApiModelProperty(name = "pickingIds", value = "领料单ID集合", notes = "领料单ID集合")
   @TableField("picking_ids")
   @Column(name = "picking_ids", columnDefinition = "varchar(1000)  COMMENT '领料单ID集合'", nullable = true)
   private String pickingIds;
   @ApiModelProperty(name = "pickingDetailIds", value = "关联的领料单明细ID集合", notes = "关联的领料单明细ID集合")
   @TableField("picking_detail_ids")
   @Column(name = "picking_detail_ids", columnDefinition = "varchar(1000)  COMMENT '关联的领料单明细ID集合'", nullable = true)
   private String pickingDetailIds;
   @ApiModelProperty(name = "taskOrderIds", value = "工单ID集合", notes = "工单ID集合")
   @TableField("task_order_ids")
   @Column(name = "task_order_ids", columnDefinition = "varchar(255)  COMMENT '工单ID集合'", nullable = true)
   private String taskOrderIds;
   @ApiModelProperty(name = "taskOrderNumbers", value = "工单编号集合", notes = "工单编号集合")
   @TableField("task_order_numbers")
   @Column(name = "task_order_numbers", columnDefinition = "text  COMMENT '工单编号集合'", nullable = true)
   private String taskOrderNumbers;
   @ApiModelProperty(name = "serialNumber", value = "领料单编号", notes = "领料单编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '领料单编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "completePickingDetailIds", value = "齐套领料明细Id集合", notes = "齐套领料明细Id集合")
   @TableField("complete_picking_detail_ids")
   @Column(name = "complete_picking_detail_ids", columnDefinition = "varchar(1000)  COMMENT '齐套领料明细Id集合'", nullable = true)
   private String completePickingDetailIds;
   @ApiModelProperty(name = "outboundIds", value = "出库单ID集合", notes = "出库单ID集合")
   @TableField("outbound_ids")
   @Column(name = "outbound_ids", columnDefinition = "varchar(255)  COMMENT '出库单ID集合'", nullable = true)
   private String outboundIds;
   @ApiModelProperty(name = "projectIds", value = "领料项目ID集合", notes = "领料项目ID集合")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT '领料项目ID集合'", nullable = true)
   private String projectIds;
   @ApiModelProperty(name = "mesWorkshopIds", value = "领料车间ID集合", notes = "领料车间ID集合")
   @TableField("mes_workshop_ids")
   @Column(name = "mes_workshop_ids", columnDefinition = "varchar(255)  COMMENT '领料车间ID集合'", nullable = true)
   private String mesWorkshopIds;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint(20)  COMMENT '申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(50)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "outboundQuantity", value = "出库总量", notes = "出库总量")
   @TableField("outbound_quantity")
   @Column(name = "outbound_quantity", columnDefinition = "decimal(32,8)  COMMENT '出库总量'", nullable = true)
   private BigDecimal outboundQuantity;
   @ApiModelProperty(name = "outboundMete", value = "出库总量", notes = "出库总量")
   @TableField("outbound_mete")
   @Column(name = "outbound_mete", columnDefinition = "decimal(32,8)  COMMENT '出库总量'", nullable = true)
   private BigDecimal outboundMete;
   @ApiModelProperty(name = "outboundArea", value = "出库总面积(钢板适用)", notes = "出库总面积(钢板适用)")
   @TableField("outbound_area")
   @Column(name = "outbound_area", columnDefinition = "decimal(32,8)  COMMENT '出库总面积(钢板适用)'", nullable = true)
   private BigDecimal outboundArea;
   @ApiModelProperty(name = "outboundLength", value = "出库总长度(型材适用)", notes = "出库总长度(型材适用)")
   @TableField("outbound_length")
   @Column(name = "outbound_length", columnDefinition = "decimal(32,8)  COMMENT '出库总长度(型材适用)'", nullable = true)
   private BigDecimal outboundLength;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 ReviewStatusEnum", notes = "审核状态 ReviewStatusEnum")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int(11)  COMMENT '审核状态 ReviewStatusEnum'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "splitMaterialStr", value = "该次拆板的数据 SplitMaterialDTO", notes = "该次拆板的数据 SplitMaterialDTO")
   @TableField("split_material_str")
   @Column(name = "split_material_str", columnDefinition = "text  COMMENT '该次拆板的数据 SplitMaterialDTO'", nullable = true)
   private String splitMaterialStr;

   public static WmsPickingApprove.WmsPickingApproveBuilder builder() {
      return new WmsPickingApprove.WmsPickingApproveBuilder();
   }

   public WmsPickingApprove() {
   }

   public WmsPickingApprove(
      final Long id,
      final String materialType,
      final String pickingIds,
      final String pickingDetailIds,
      final String taskOrderIds,
      final String taskOrderNumbers,
      final String serialNumber,
      final String completePickingDetailIds,
      final String outboundIds,
      final String projectIds,
      final String mesWorkshopIds,
      final Long applicantId,
      final String applicantName,
      final BigDecimal outboundQuantity,
      final BigDecimal outboundMete,
      final BigDecimal outboundArea,
      final BigDecimal outboundLength,
      final Integer reviewStatus,
      final Long approveRecordId,
      final String splitMaterialStr
   ) {
      this.id = id;
      this.materialType = materialType;
      this.pickingIds = pickingIds;
      this.pickingDetailIds = pickingDetailIds;
      this.taskOrderIds = taskOrderIds;
      this.taskOrderNumbers = taskOrderNumbers;
      this.serialNumber = serialNumber;
      this.completePickingDetailIds = completePickingDetailIds;
      this.outboundIds = outboundIds;
      this.projectIds = projectIds;
      this.mesWorkshopIds = mesWorkshopIds;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.outboundQuantity = outboundQuantity;
      this.outboundMete = outboundMete;
      this.outboundArea = outboundArea;
      this.outboundLength = outboundLength;
      this.reviewStatus = reviewStatus;
      this.approveRecordId = approveRecordId;
      this.splitMaterialStr = splitMaterialStr;
   }

   public Long getId() {
      return this.id;
   }

   public String getMaterialType() {
      return this.materialType;
   }

   public String getPickingIds() {
      return this.pickingIds;
   }

   public String getPickingDetailIds() {
      return this.pickingDetailIds;
   }

   public String getTaskOrderIds() {
      return this.taskOrderIds;
   }

   public String getTaskOrderNumbers() {
      return this.taskOrderNumbers;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getCompletePickingDetailIds() {
      return this.completePickingDetailIds;
   }

   public String getOutboundIds() {
      return this.outboundIds;
   }

   public String getProjectIds() {
      return this.projectIds;
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

   public BigDecimal getOutboundQuantity() {
      return this.outboundQuantity;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getOutboundArea() {
      return this.outboundArea;
   }

   public BigDecimal getOutboundLength() {
      return this.outboundLength;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public String getSplitMaterialStr() {
      return this.splitMaterialStr;
   }

   public WmsPickingApprove setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsPickingApprove setMaterialType(final String materialType) {
      this.materialType = materialType;
      return this;
   }

   public WmsPickingApprove setPickingIds(final String pickingIds) {
      this.pickingIds = pickingIds;
      return this;
   }

   public WmsPickingApprove setPickingDetailIds(final String pickingDetailIds) {
      this.pickingDetailIds = pickingDetailIds;
      return this;
   }

   public WmsPickingApprove setTaskOrderIds(final String taskOrderIds) {
      this.taskOrderIds = taskOrderIds;
      return this;
   }

   public WmsPickingApprove setTaskOrderNumbers(final String taskOrderNumbers) {
      this.taskOrderNumbers = taskOrderNumbers;
      return this;
   }

   public WmsPickingApprove setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public WmsPickingApprove setCompletePickingDetailIds(final String completePickingDetailIds) {
      this.completePickingDetailIds = completePickingDetailIds;
      return this;
   }

   public WmsPickingApprove setOutboundIds(final String outboundIds) {
      this.outboundIds = outboundIds;
      return this;
   }

   public WmsPickingApprove setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   public WmsPickingApprove setMesWorkshopIds(final String mesWorkshopIds) {
      this.mesWorkshopIds = mesWorkshopIds;
      return this;
   }

   public WmsPickingApprove setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   public WmsPickingApprove setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   public WmsPickingApprove setOutboundQuantity(final BigDecimal outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
      return this;
   }

   public WmsPickingApprove setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
      return this;
   }

   public WmsPickingApprove setOutboundArea(final BigDecimal outboundArea) {
      this.outboundArea = outboundArea;
      return this;
   }

   public WmsPickingApprove setOutboundLength(final BigDecimal outboundLength) {
      this.outboundLength = outboundLength;
      return this;
   }

   public WmsPickingApprove setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   public WmsPickingApprove setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public WmsPickingApprove setSplitMaterialStr(final String splitMaterialStr) {
      this.splitMaterialStr = splitMaterialStr;
      return this;
   }

   @Override
   public String toString() {
      return "WmsPickingApprove(id="
         + this.getId()
         + ", materialType="
         + this.getMaterialType()
         + ", pickingIds="
         + this.getPickingIds()
         + ", pickingDetailIds="
         + this.getPickingDetailIds()
         + ", taskOrderIds="
         + this.getTaskOrderIds()
         + ", taskOrderNumbers="
         + this.getTaskOrderNumbers()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", completePickingDetailIds="
         + this.getCompletePickingDetailIds()
         + ", outboundIds="
         + this.getOutboundIds()
         + ", projectIds="
         + this.getProjectIds()
         + ", mesWorkshopIds="
         + this.getMesWorkshopIds()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", outboundArea="
         + this.getOutboundArea()
         + ", outboundLength="
         + this.getOutboundLength()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", splitMaterialStr="
         + this.getSplitMaterialStr()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPickingApprove)) {
         return false;
      }

      WmsPickingApprove other = (WmsPickingApprove)o;
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
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$approveRecordId = this.getApproveRecordId();
               Object other$approveRecordId = other.getApproveRecordId();
               if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                  Object this$materialType = this.getMaterialType();
                  Object other$materialType = other.getMaterialType();
                  if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                     Object this$pickingIds = this.getPickingIds();
                     Object other$pickingIds = other.getPickingIds();
                     if (this$pickingIds == null ? other$pickingIds == null : this$pickingIds.equals(other$pickingIds)) {
                        Object this$pickingDetailIds = this.getPickingDetailIds();
                        Object other$pickingDetailIds = other.getPickingDetailIds();
                        if (this$pickingDetailIds == null ? other$pickingDetailIds == null : this$pickingDetailIds.equals(other$pickingDetailIds)) {
                           Object this$taskOrderIds = this.getTaskOrderIds();
                           Object other$taskOrderIds = other.getTaskOrderIds();
                           if (this$taskOrderIds == null ? other$taskOrderIds == null : this$taskOrderIds.equals(other$taskOrderIds)) {
                              Object this$taskOrderNumbers = this.getTaskOrderNumbers();
                              Object other$taskOrderNumbers = other.getTaskOrderNumbers();
                              if (this$taskOrderNumbers == null ? other$taskOrderNumbers == null : this$taskOrderNumbers.equals(other$taskOrderNumbers)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$completePickingDetailIds = this.getCompletePickingDetailIds();
                                    Object other$completePickingDetailIds = other.getCompletePickingDetailIds();
                                    if (this$completePickingDetailIds == null
                                       ? other$completePickingDetailIds == null
                                       : this$completePickingDetailIds.equals(other$completePickingDetailIds)) {
                                       Object this$outboundIds = this.getOutboundIds();
                                       Object other$outboundIds = other.getOutboundIds();
                                       if (this$outboundIds == null ? other$outboundIds == null : this$outboundIds.equals(other$outboundIds)) {
                                          Object this$projectIds = this.getProjectIds();
                                          Object other$projectIds = other.getProjectIds();
                                          if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                             Object this$mesWorkshopIds = this.getMesWorkshopIds();
                                             Object other$mesWorkshopIds = other.getMesWorkshopIds();
                                             if (this$mesWorkshopIds == null ? other$mesWorkshopIds == null : this$mesWorkshopIds.equals(other$mesWorkshopIds)) {
                                                Object this$applicantName = this.getApplicantName();
                                                Object other$applicantName = other.getApplicantName();
                                                if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                                   Object this$outboundQuantity = this.getOutboundQuantity();
                                                   Object other$outboundQuantity = other.getOutboundQuantity();
                                                   if (this$outboundQuantity == null
                                                      ? other$outboundQuantity == null
                                                      : this$outboundQuantity.equals(other$outboundQuantity)) {
                                                      Object this$outboundMete = this.getOutboundMete();
                                                      Object other$outboundMete = other.getOutboundMete();
                                                      if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)
                                                         )
                                                       {
                                                         Object this$outboundArea = this.getOutboundArea();
                                                         Object other$outboundArea = other.getOutboundArea();
                                                         if (this$outboundArea == null
                                                            ? other$outboundArea == null
                                                            : this$outboundArea.equals(other$outboundArea)) {
                                                            Object this$outboundLength = this.getOutboundLength();
                                                            Object other$outboundLength = other.getOutboundLength();
                                                            if (this$outboundLength == null
                                                               ? other$outboundLength == null
                                                               : this$outboundLength.equals(other$outboundLength)) {
                                                               Object this$splitMaterialStr = this.getSplitMaterialStr();
                                                               Object other$splitMaterialStr = other.getSplitMaterialStr();
                                                               return this$splitMaterialStr == null
                                                                  ? other$splitMaterialStr == null
                                                                  : this$splitMaterialStr.equals(other$splitMaterialStr);
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof WmsPickingApprove;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $pickingIds = this.getPickingIds();
      result = result * 59 + ($pickingIds == null ? 43 : $pickingIds.hashCode());
      Object $pickingDetailIds = this.getPickingDetailIds();
      result = result * 59 + ($pickingDetailIds == null ? 43 : $pickingDetailIds.hashCode());
      Object $taskOrderIds = this.getTaskOrderIds();
      result = result * 59 + ($taskOrderIds == null ? 43 : $taskOrderIds.hashCode());
      Object $taskOrderNumbers = this.getTaskOrderNumbers();
      result = result * 59 + ($taskOrderNumbers == null ? 43 : $taskOrderNumbers.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $completePickingDetailIds = this.getCompletePickingDetailIds();
      result = result * 59 + ($completePickingDetailIds == null ? 43 : $completePickingDetailIds.hashCode());
      Object $outboundIds = this.getOutboundIds();
      result = result * 59 + ($outboundIds == null ? 43 : $outboundIds.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $mesWorkshopIds = this.getMesWorkshopIds();
      result = result * 59 + ($mesWorkshopIds == null ? 43 : $mesWorkshopIds.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $outboundArea = this.getOutboundArea();
      result = result * 59 + ($outboundArea == null ? 43 : $outboundArea.hashCode());
      Object $outboundLength = this.getOutboundLength();
      result = result * 59 + ($outboundLength == null ? 43 : $outboundLength.hashCode());
      Object $splitMaterialStr = this.getSplitMaterialStr();
      return result * 59 + ($splitMaterialStr == null ? 43 : $splitMaterialStr.hashCode());
   }

   public static class WmsPickingApproveBuilder {
      private Long id;
      private String materialType;
      private String pickingIds;
      private String pickingDetailIds;
      private String taskOrderIds;
      private String taskOrderNumbers;
      private String serialNumber;
      private String completePickingDetailIds;
      private String outboundIds;
      private String projectIds;
      private String mesWorkshopIds;
      private Long applicantId;
      private String applicantName;
      private BigDecimal outboundQuantity;
      private BigDecimal outboundMete;
      private BigDecimal outboundArea;
      private BigDecimal outboundLength;
      private Integer reviewStatus;
      private Long approveRecordId;
      private String splitMaterialStr;

      WmsPickingApproveBuilder() {
      }

      public WmsPickingApprove.WmsPickingApproveBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder materialType(final String materialType) {
         this.materialType = materialType;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder pickingIds(final String pickingIds) {
         this.pickingIds = pickingIds;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder pickingDetailIds(final String pickingDetailIds) {
         this.pickingDetailIds = pickingDetailIds;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder taskOrderIds(final String taskOrderIds) {
         this.taskOrderIds = taskOrderIds;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder taskOrderNumbers(final String taskOrderNumbers) {
         this.taskOrderNumbers = taskOrderNumbers;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder completePickingDetailIds(final String completePickingDetailIds) {
         this.completePickingDetailIds = completePickingDetailIds;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder outboundIds(final String outboundIds) {
         this.outboundIds = outboundIds;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder mesWorkshopIds(final String mesWorkshopIds) {
         this.mesWorkshopIds = mesWorkshopIds;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder outboundQuantity(final BigDecimal outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder outboundArea(final BigDecimal outboundArea) {
         this.outboundArea = outboundArea;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder outboundLength(final BigDecimal outboundLength) {
         this.outboundLength = outboundLength;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public WmsPickingApprove.WmsPickingApproveBuilder splitMaterialStr(final String splitMaterialStr) {
         this.splitMaterialStr = splitMaterialStr;
         return this;
      }

      public WmsPickingApprove build() {
         return new WmsPickingApprove(
            this.id,
            this.materialType,
            this.pickingIds,
            this.pickingDetailIds,
            this.taskOrderIds,
            this.taskOrderNumbers,
            this.serialNumber,
            this.completePickingDetailIds,
            this.outboundIds,
            this.projectIds,
            this.mesWorkshopIds,
            this.applicantId,
            this.applicantName,
            this.outboundQuantity,
            this.outboundMete,
            this.outboundArea,
            this.outboundLength,
            this.reviewStatus,
            this.approveRecordId,
            this.splitMaterialStr
         );
      }

      @Override
      public String toString() {
         return "WmsPickingApprove.WmsPickingApproveBuilder(id="
            + this.id
            + ", materialType="
            + this.materialType
            + ", pickingIds="
            + this.pickingIds
            + ", pickingDetailIds="
            + this.pickingDetailIds
            + ", taskOrderIds="
            + this.taskOrderIds
            + ", taskOrderNumbers="
            + this.taskOrderNumbers
            + ", serialNumber="
            + this.serialNumber
            + ", completePickingDetailIds="
            + this.completePickingDetailIds
            + ", outboundIds="
            + this.outboundIds
            + ", projectIds="
            + this.projectIds
            + ", mesWorkshopIds="
            + this.mesWorkshopIds
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", outboundQuantity="
            + this.outboundQuantity
            + ", outboundMete="
            + this.outboundMete
            + ", outboundArea="
            + this.outboundArea
            + ", outboundLength="
            + this.outboundLength
            + ", reviewStatus="
            + this.reviewStatus
            + ", approveRecordId="
            + this.approveRecordId
            + ", splitMaterialStr="
            + this.splitMaterialStr
            + ")";
      }
   }
}
