package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class MaterialFreezeRecordDTO {
   private Long id;
   private Integer freezeType;
   private BriefIdAndSNDTO receipt;
   private BigDecimal quantity;
   private BigDecimal mete;
   private ProjectInfoDTO project;
   private String operatorName;
   private LocalDateTime frozenTime;
   private Boolean boolBatten;
   private String remark;
   private List<Long> idList;

   MaterialFreezeRecordDTO(
      final Long id,
      final Integer freezeType,
      final BriefIdAndSNDTO receipt,
      final BigDecimal quantity,
      final BigDecimal mete,
      final ProjectInfoDTO project,
      final String operatorName,
      final LocalDateTime frozenTime,
      final Boolean boolBatten,
      final String remark,
      final List<Long> idList
   ) {
      this.id = id;
      this.freezeType = freezeType;
      this.receipt = receipt;
      this.quantity = quantity;
      this.mete = mete;
      this.project = project;
      this.operatorName = operatorName;
      this.frozenTime = frozenTime;
      this.boolBatten = boolBatten;
      this.remark = remark;
      this.idList = idList;
   }

   public static MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder builder() {
      return new MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getFreezeType() {
      return this.freezeType;
   }

   public BriefIdAndSNDTO getReceipt() {
      return this.receipt;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public ProjectInfoDTO getProject() {
      return this.project;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public LocalDateTime getFrozenTime() {
      return this.frozenTime;
   }

   public Boolean getBoolBatten() {
      return this.boolBatten;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<Long> getIdList() {
      return this.idList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFreezeType(final Integer freezeType) {
      this.freezeType = freezeType;
   }

   public void setReceipt(final BriefIdAndSNDTO receipt) {
      this.receipt = receipt;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setProject(final ProjectInfoDTO project) {
      this.project = project;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setFrozenTime(final LocalDateTime frozenTime) {
      this.frozenTime = frozenTime;
   }

   public void setBoolBatten(final Boolean boolBatten) {
      this.boolBatten = boolBatten;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setIdList(final List<Long> idList) {
      this.idList = idList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MaterialFreezeRecordDTO)) {
         return false;
      }

      MaterialFreezeRecordDTO other = (MaterialFreezeRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$freezeType = this.getFreezeType();
         Object other$freezeType = other.getFreezeType();
         if (this$freezeType == null ? other$freezeType == null : this$freezeType.equals(other$freezeType)) {
            Object this$boolBatten = this.getBoolBatten();
            Object other$boolBatten = other.getBoolBatten();
            if (this$boolBatten == null ? other$boolBatten == null : this$boolBatten.equals(other$boolBatten)) {
               Object this$receipt = this.getReceipt();
               Object other$receipt = other.getReceipt();
               if (this$receipt == null ? other$receipt == null : this$receipt.equals(other$receipt)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$mete = this.getMete();
                     Object other$mete = other.getMete();
                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$operatorName = this.getOperatorName();
                           Object other$operatorName = other.getOperatorName();
                           if (this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName)) {
                              Object this$frozenTime = this.getFrozenTime();
                              Object other$frozenTime = other.getFrozenTime();
                              if (this$frozenTime == null ? other$frozenTime == null : this$frozenTime.equals(other$frozenTime)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$idList = this.getIdList();
                                    Object other$idList = other.getIdList();
                                    return this$idList == null ? other$idList == null : this$idList.equals(other$idList);
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
      return other instanceof MaterialFreezeRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $freezeType = this.getFreezeType();
      result = result * 59 + ($freezeType == null ? 43 : $freezeType.hashCode());
      Object $boolBatten = this.getBoolBatten();
      result = result * 59 + ($boolBatten == null ? 43 : $boolBatten.hashCode());
      Object $receipt = this.getReceipt();
      result = result * 59 + ($receipt == null ? 43 : $receipt.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $frozenTime = this.getFrozenTime();
      result = result * 59 + ($frozenTime == null ? 43 : $frozenTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $idList = this.getIdList();
      return result * 59 + ($idList == null ? 43 : $idList.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialFreezeRecordDTO(id="
         + this.getId()
         + ", freezeType="
         + this.getFreezeType()
         + ", receipt="
         + this.getReceipt()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", project="
         + this.getProject()
         + ", operatorName="
         + this.getOperatorName()
         + ", frozenTime="
         + this.getFrozenTime()
         + ", boolBatten="
         + this.getBoolBatten()
         + ", remark="
         + this.getRemark()
         + ", idList="
         + this.getIdList()
         + ")";
   }

   public static class MaterialFreezeRecordDTOBuilder {
      private Long id;
      private Integer freezeType;
      private BriefIdAndSNDTO receipt;
      private BigDecimal quantity;
      private BigDecimal mete;
      private ProjectInfoDTO project;
      private String operatorName;
      private LocalDateTime frozenTime;
      private Boolean boolBatten;
      private String remark;
      private List<Long> idList;

      MaterialFreezeRecordDTOBuilder() {
      }

      public MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder freezeType(final Integer freezeType) {
         this.freezeType = freezeType;
         return this;
      }

      public MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder receipt(final BriefIdAndSNDTO receipt) {
         this.receipt = receipt;
         return this;
      }

      public MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder project(final ProjectInfoDTO project) {
         this.project = project;
         return this;
      }

      public MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder frozenTime(final LocalDateTime frozenTime) {
         this.frozenTime = frozenTime;
         return this;
      }

      public MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder boolBatten(final Boolean boolBatten) {
         this.boolBatten = boolBatten;
         return this;
      }

      public MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder idList(final List<Long> idList) {
         this.idList = idList;
         return this;
      }

      public MaterialFreezeRecordDTO build() {
         return new MaterialFreezeRecordDTO(
            this.id,
            this.freezeType,
            this.receipt,
            this.quantity,
            this.mete,
            this.project,
            this.operatorName,
            this.frozenTime,
            this.boolBatten,
            this.remark,
            this.idList
         );
      }

      @Override
      public String toString() {
         return "MaterialFreezeRecordDTO.MaterialFreezeRecordDTOBuilder(id="
            + this.id
            + ", freezeType="
            + this.freezeType
            + ", receipt="
            + this.receipt
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", project="
            + this.project
            + ", operatorName="
            + this.operatorName
            + ", frozenTime="
            + this.frozenTime
            + ", boolBatten="
            + this.boolBatten
            + ", remark="
            + this.remark
            + ", idList="
            + this.idList
            + ")";
      }
   }
}
