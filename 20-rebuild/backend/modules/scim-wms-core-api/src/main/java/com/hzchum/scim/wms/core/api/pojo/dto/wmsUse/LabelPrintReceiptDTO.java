package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.time.LocalDateTime;
import java.util.List;

public class LabelPrintReceiptDTO {
   private Long id;
   private Integer basicClass;
   private String serialNumber;
   private Long receiptId;
   private Integer receiptType;
   private BriefIdAndSNDTO receipt;
   private List<ProjectInfo> projects;
   private Integer pendingPrintedMaterialNumber;
   private String reviewerName;
   private LocalDateTime createTime;
   @JsonInclude(Include.NON_NULL)
   private List<LabelPrintMaterialDTO> materialList;

   public static LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder builder() {
      return new LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getReceiptId() {
      return this.receiptId;
   }

   public Integer getReceiptType() {
      return this.receiptType;
   }

   public BriefIdAndSNDTO getReceipt() {
      return this.receipt;
   }

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public Integer getPendingPrintedMaterialNumber() {
      return this.pendingPrintedMaterialNumber;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public List<LabelPrintMaterialDTO> getMaterialList() {
      return this.materialList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setReceiptId(final Long receiptId) {
      this.receiptId = receiptId;
   }

   public void setReceiptType(final Integer receiptType) {
      this.receiptType = receiptType;
   }

   public void setReceipt(final BriefIdAndSNDTO receipt) {
      this.receipt = receipt;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setPendingPrintedMaterialNumber(final Integer pendingPrintedMaterialNumber) {
      this.pendingPrintedMaterialNumber = pendingPrintedMaterialNumber;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setMaterialList(final List<LabelPrintMaterialDTO> materialList) {
      this.materialList = materialList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LabelPrintReceiptDTO)) {
         return false;
      }

      LabelPrintReceiptDTO other = (LabelPrintReceiptDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$receiptId = this.getReceiptId();
            Object other$receiptId = other.getReceiptId();
            if (this$receiptId == null ? other$receiptId == null : this$receiptId.equals(other$receiptId)) {
               Object this$receiptType = this.getReceiptType();
               Object other$receiptType = other.getReceiptType();
               if (this$receiptType == null ? other$receiptType == null : this$receiptType.equals(other$receiptType)) {
                  Object this$pendingPrintedMaterialNumber = this.getPendingPrintedMaterialNumber();
                  Object other$pendingPrintedMaterialNumber = other.getPendingPrintedMaterialNumber();
                  if (this$pendingPrintedMaterialNumber == null
                     ? other$pendingPrintedMaterialNumber == null
                     : this$pendingPrintedMaterialNumber.equals(other$pendingPrintedMaterialNumber)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$receipt = this.getReceipt();
                        Object other$receipt = other.getReceipt();
                        if (this$receipt == null ? other$receipt == null : this$receipt.equals(other$receipt)) {
                           Object this$projects = this.getProjects();
                           Object other$projects = other.getProjects();
                           if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                              Object this$reviewerName = this.getReviewerName();
                              Object other$reviewerName = other.getReviewerName();
                              if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                 Object this$createTime = this.getCreateTime();
                                 Object other$createTime = other.getCreateTime();
                                 if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                    Object this$materialList = this.getMaterialList();
                                    Object other$materialList = other.getMaterialList();
                                    return this$materialList == null ? other$materialList == null : this$materialList.equals(other$materialList);
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
      return other instanceof LabelPrintReceiptDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $receiptId = this.getReceiptId();
      result = result * 59 + ($receiptId == null ? 43 : $receiptId.hashCode());
      Object $receiptType = this.getReceiptType();
      result = result * 59 + ($receiptType == null ? 43 : $receiptType.hashCode());
      Object $pendingPrintedMaterialNumber = this.getPendingPrintedMaterialNumber();
      result = result * 59 + ($pendingPrintedMaterialNumber == null ? 43 : $pendingPrintedMaterialNumber.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $receipt = this.getReceipt();
      result = result * 59 + ($receipt == null ? 43 : $receipt.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $materialList = this.getMaterialList();
      return result * 59 + ($materialList == null ? 43 : $materialList.hashCode());
   }

   @Override
   public String toString() {
      return "LabelPrintReceiptDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", receiptId="
         + this.getReceiptId()
         + ", receiptType="
         + this.getReceiptType()
         + ", receipt="
         + this.getReceipt()
         + ", projects="
         + this.getProjects()
         + ", pendingPrintedMaterialNumber="
         + this.getPendingPrintedMaterialNumber()
         + ", reviewerName="
         + this.getReviewerName()
         + ", createTime="
         + this.getCreateTime()
         + ", materialList="
         + this.getMaterialList()
         + ")";
   }

   public LabelPrintReceiptDTO(
      final Long id,
      final Integer basicClass,
      final String serialNumber,
      final Long receiptId,
      final Integer receiptType,
      final BriefIdAndSNDTO receipt,
      final List<ProjectInfo> projects,
      final Integer pendingPrintedMaterialNumber,
      final String reviewerName,
      final LocalDateTime createTime,
      final List<LabelPrintMaterialDTO> materialList
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.receiptId = receiptId;
      this.receiptType = receiptType;
      this.receipt = receipt;
      this.projects = projects;
      this.pendingPrintedMaterialNumber = pendingPrintedMaterialNumber;
      this.reviewerName = reviewerName;
      this.createTime = createTime;
      this.materialList = materialList;
   }

   public LabelPrintReceiptDTO() {
   }

   public static class LabelPrintReceiptDTOBuilder {
      private Long id;
      private Integer basicClass;
      private String serialNumber;
      private Long receiptId;
      private Integer receiptType;
      private BriefIdAndSNDTO receipt;
      private List<ProjectInfo> projects;
      private Integer pendingPrintedMaterialNumber;
      private String reviewerName;
      private LocalDateTime createTime;
      private List<LabelPrintMaterialDTO> materialList;

      LabelPrintReceiptDTOBuilder() {
      }

      public LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder receiptId(final Long receiptId) {
         this.receiptId = receiptId;
         return this;
      }

      public LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder receiptType(final Integer receiptType) {
         this.receiptType = receiptType;
         return this;
      }

      public LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder receipt(final BriefIdAndSNDTO receipt) {
         this.receipt = receipt;
         return this;
      }

      public LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder pendingPrintedMaterialNumber(final Integer pendingPrintedMaterialNumber) {
         this.pendingPrintedMaterialNumber = pendingPrintedMaterialNumber;
         return this;
      }

      public LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder materialList(final List<LabelPrintMaterialDTO> materialList) {
         this.materialList = materialList;
         return this;
      }

      public LabelPrintReceiptDTO build() {
         return new LabelPrintReceiptDTO(
            this.id,
            this.basicClass,
            this.serialNumber,
            this.receiptId,
            this.receiptType,
            this.receipt,
            this.projects,
            this.pendingPrintedMaterialNumber,
            this.reviewerName,
            this.createTime,
            this.materialList
         );
      }

      @Override
      public String toString() {
         return "LabelPrintReceiptDTO.LabelPrintReceiptDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", receiptId="
            + this.receiptId
            + ", receiptType="
            + this.receiptType
            + ", receipt="
            + this.receipt
            + ", projects="
            + this.projects
            + ", pendingPrintedMaterialNumber="
            + this.pendingPrintedMaterialNumber
            + ", reviewerName="
            + this.reviewerName
            + ", createTime="
            + this.createTime
            + ", materialList="
            + this.materialList
            + ")";
      }
   }
}
