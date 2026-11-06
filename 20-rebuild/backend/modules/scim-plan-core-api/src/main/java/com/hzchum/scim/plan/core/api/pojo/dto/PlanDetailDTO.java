package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel(value = "PlanDetail对象", description = " 计划详情表")
public class PlanDetailDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "type", value = "类型    1 - 深化计划  2 - 加工计划   4 - 安装计划  ")
   private Integer type;
   @ApiModelProperty(name = "areaProductType", value = "区域产品类型  1结构件 2压型彩板 4夹芯板  8桁架楼承板 16压型楼承板  32折边件 ")
   private Integer areaProductType;
   @ApiModelProperty(name = "startDate", value = "计划开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "计划结束日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "completeDate", value = "完成日期")
   private LocalDate completeDate;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "completedMete", value = "已完成量")
   private BigDecimal completedMete;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "mete", value = "总量")
   private BigDecimal mete;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "supplierId", value = "供应商id")
   private Long supplierId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "supplierName", value = "供应商名称")
   private String supplierName;

   public static PlanDetailDTO.PlanDetailDTOBuilder builder() {
      return new PlanDetailDTO.PlanDetailDTOBuilder();
   }

   public PlanDetailDTO() {
   }

   public PlanDetailDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer type,
      final Integer areaProductType,
      final LocalDate startDate,
      final LocalDate endDate,
      final LocalDate completeDate,
      final String remark,
      final BigDecimal completedMete,
      final BigDecimal mete,
      final Long supplierId,
      final String supplierName
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.type = type;
      this.areaProductType = areaProductType;
      this.startDate = startDate;
      this.endDate = endDate;
      this.completeDate = completeDate;
      this.remark = remark;
      this.completedMete = completedMete;
      this.mete = mete;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getAreaProductType() {
      return this.areaProductType;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public LocalDate getCompleteDate() {
      return this.completeDate;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getCompletedMete() {
      return this.completedMete;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setAreaProductType(final Integer areaProductType) {
      this.areaProductType = areaProductType;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setCompleteDate(final LocalDate completeDate) {
      this.completeDate = completeDate;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCompletedMete(final BigDecimal completedMete) {
      this.completedMete = completedMete;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanDetailDTO)) {
         return false;
      }

      PlanDetailDTO other = (PlanDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$type = this.getType();
                  Object other$type = other.getType();
                  if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                     Object this$areaProductType = this.getAreaProductType();
                     Object other$areaProductType = other.getAreaProductType();
                     if (this$areaProductType == null ? other$areaProductType == null : this$areaProductType.equals(other$areaProductType)) {
                        Object this$supplierId = this.getSupplierId();
                        Object other$supplierId = other.getSupplierId();
                        if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                           Object this$startDate = this.getStartDate();
                           Object other$startDate = other.getStartDate();
                           if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                              Object this$endDate = this.getEndDate();
                              Object other$endDate = other.getEndDate();
                              if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                 Object this$completeDate = this.getCompleteDate();
                                 Object other$completeDate = other.getCompleteDate();
                                 if (this$completeDate == null ? other$completeDate == null : this$completeDate.equals(other$completeDate)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                       Object this$completedMete = this.getCompletedMete();
                                       Object other$completedMete = other.getCompletedMete();
                                       if (this$completedMete == null ? other$completedMete == null : this$completedMete.equals(other$completedMete)) {
                                          Object this$mete = this.getMete();
                                          Object other$mete = other.getMete();
                                          if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                             Object this$supplierName = this.getSupplierName();
                                             Object other$supplierName = other.getSupplierName();
                                             return this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName);
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

   protected boolean canEqual(final Object other) {
      return other instanceof PlanDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $areaProductType = this.getAreaProductType();
      result = result * 59 + ($areaProductType == null ? 43 : $areaProductType.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $completeDate = this.getCompleteDate();
      result = result * 59 + ($completeDate == null ? 43 : $completeDate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $completedMete = this.getCompletedMete();
      result = result * 59 + ($completedMete == null ? 43 : $completedMete.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $supplierName = this.getSupplierName();
      return result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
   }

   @Override
   public String toString() {
      return "PlanDetailDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", type="
         + this.getType()
         + ", areaProductType="
         + this.getAreaProductType()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", completeDate="
         + this.getCompleteDate()
         + ", remark="
         + this.getRemark()
         + ", completedMete="
         + this.getCompletedMete()
         + ", mete="
         + this.getMete()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ")";
   }

   public static class PlanDetailDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer type;
      private Integer areaProductType;
      private LocalDate startDate;
      private LocalDate endDate;
      private LocalDate completeDate;
      private String remark;
      private BigDecimal completedMete;
      private BigDecimal mete;
      private Long supplierId;
      private String supplierName;

      PlanDetailDTOBuilder() {
      }

      public PlanDetailDTO.PlanDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder areaProductType(final Integer areaProductType) {
         this.areaProductType = areaProductType;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder completeDate(final LocalDate completeDate) {
         this.completeDate = completeDate;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder completedMete(final BigDecimal completedMete) {
         this.completedMete = completedMete;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public PlanDetailDTO.PlanDetailDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public PlanDetailDTO build() {
         return new PlanDetailDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.type,
            this.areaProductType,
            this.startDate,
            this.endDate,
            this.completeDate,
            this.remark,
            this.completedMete,
            this.mete,
            this.supplierId,
            this.supplierName
         );
      }

      @Override
      public String toString() {
         return "PlanDetailDTO.PlanDetailDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", type="
            + this.type
            + ", areaProductType="
            + this.areaProductType
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", completeDate="
            + this.completeDate
            + ", remark="
            + this.remark
            + ", completedMete="
            + this.completedMete
            + ", mete="
            + this.mete
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ")";
      }
   }
}
