package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.io.Serializable;
import java.util.List;

public class SubjectTreeImportDTO implements Serializable {
   @Excel(name = "序号")
   private Integer orderNo;
   @Excel(name = "一级科目名称", width = 15.0)
   private String nameA;
   @Excel(name = "一级科目代码", width = 15.0)
   private String codeA;
   @Excel(name = "一级科目类型", width = 15.0)
   private String basicClass;
   @Excel(name = "二级科目编码", width = 15.0)
   private String serialNumberA;
   @Excel(name = "二级科目名称", width = 15.0)
   private String nameB;
   @Excel(name = "二级科目代码", width = 15.0)
   private String codeB;
   @Excel(name = "三级科目编码", width = 15.0)
   private String serialNumberB;
   @Excel(name = "三级科目名称", width = 15.0)
   private String nameC;
   @Excel(name = "三级科目代码", width = 15.0)
   private String codeC;
   private List<SubjectTreeDTO> children;

   public static SubjectTreeImportDTO.SubjectTreeImportDTOBuilder builder() {
      return new SubjectTreeImportDTO.SubjectTreeImportDTOBuilder();
   }

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getNameA() {
      return this.nameA;
   }

   public String getCodeA() {
      return this.codeA;
   }

   public String getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumberA() {
      return this.serialNumberA;
   }

   public String getNameB() {
      return this.nameB;
   }

   public String getCodeB() {
      return this.codeB;
   }

   public String getSerialNumberB() {
      return this.serialNumberB;
   }

   public String getNameC() {
      return this.nameC;
   }

   public String getCodeC() {
      return this.codeC;
   }

   public List<SubjectTreeDTO> getChildren() {
      return this.children;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setNameA(final String nameA) {
      this.nameA = nameA;
   }

   public void setCodeA(final String codeA) {
      this.codeA = codeA;
   }

   public void setBasicClass(final String basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumberA(final String serialNumberA) {
      this.serialNumberA = serialNumberA;
   }

   public void setNameB(final String nameB) {
      this.nameB = nameB;
   }

   public void setCodeB(final String codeB) {
      this.codeB = codeB;
   }

   public void setSerialNumberB(final String serialNumberB) {
      this.serialNumberB = serialNumberB;
   }

   public void setNameC(final String nameC) {
      this.nameC = nameC;
   }

   public void setCodeC(final String codeC) {
      this.codeC = codeC;
   }

   public void setChildren(final List<SubjectTreeDTO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectTreeImportDTO)) {
         return false;
      }

      SubjectTreeImportDTO other = (SubjectTreeImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$nameA = this.getNameA();
         Object other$nameA = other.getNameA();
         if (this$nameA == null ? other$nameA == null : this$nameA.equals(other$nameA)) {
            Object this$codeA = this.getCodeA();
            Object other$codeA = other.getCodeA();
            if (this$codeA == null ? other$codeA == null : this$codeA.equals(other$codeA)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$serialNumberA = this.getSerialNumberA();
                  Object other$serialNumberA = other.getSerialNumberA();
                  if (this$serialNumberA == null ? other$serialNumberA == null : this$serialNumberA.equals(other$serialNumberA)) {
                     Object this$nameB = this.getNameB();
                     Object other$nameB = other.getNameB();
                     if (this$nameB == null ? other$nameB == null : this$nameB.equals(other$nameB)) {
                        Object this$codeB = this.getCodeB();
                        Object other$codeB = other.getCodeB();
                        if (this$codeB == null ? other$codeB == null : this$codeB.equals(other$codeB)) {
                           Object this$serialNumberB = this.getSerialNumberB();
                           Object other$serialNumberB = other.getSerialNumberB();
                           if (this$serialNumberB == null ? other$serialNumberB == null : this$serialNumberB.equals(other$serialNumberB)) {
                              Object this$nameC = this.getNameC();
                              Object other$nameC = other.getNameC();
                              if (this$nameC == null ? other$nameC == null : this$nameC.equals(other$nameC)) {
                                 Object this$codeC = this.getCodeC();
                                 Object other$codeC = other.getCodeC();
                                 if (this$codeC == null ? other$codeC == null : this$codeC.equals(other$codeC)) {
                                    Object this$children = this.getChildren();
                                    Object other$children = other.getChildren();
                                    return this$children == null ? other$children == null : this$children.equals(other$children);
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
      return other instanceof SubjectTreeImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $nameA = this.getNameA();
      result = result * 59 + ($nameA == null ? 43 : $nameA.hashCode());
      Object $codeA = this.getCodeA();
      result = result * 59 + ($codeA == null ? 43 : $codeA.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $serialNumberA = this.getSerialNumberA();
      result = result * 59 + ($serialNumberA == null ? 43 : $serialNumberA.hashCode());
      Object $nameB = this.getNameB();
      result = result * 59 + ($nameB == null ? 43 : $nameB.hashCode());
      Object $codeB = this.getCodeB();
      result = result * 59 + ($codeB == null ? 43 : $codeB.hashCode());
      Object $serialNumberB = this.getSerialNumberB();
      result = result * 59 + ($serialNumberB == null ? 43 : $serialNumberB.hashCode());
      Object $nameC = this.getNameC();
      result = result * 59 + ($nameC == null ? 43 : $nameC.hashCode());
      Object $codeC = this.getCodeC();
      result = result * 59 + ($codeC == null ? 43 : $codeC.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "SubjectTreeImportDTO(orderNo="
         + this.getOrderNo()
         + ", nameA="
         + this.getNameA()
         + ", codeA="
         + this.getCodeA()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumberA="
         + this.getSerialNumberA()
         + ", nameB="
         + this.getNameB()
         + ", codeB="
         + this.getCodeB()
         + ", serialNumberB="
         + this.getSerialNumberB()
         + ", nameC="
         + this.getNameC()
         + ", codeC="
         + this.getCodeC()
         + ", children="
         + this.getChildren()
         + ")";
   }

   public SubjectTreeImportDTO(
      final Integer orderNo,
      final String nameA,
      final String codeA,
      final String basicClass,
      final String serialNumberA,
      final String nameB,
      final String codeB,
      final String serialNumberB,
      final String nameC,
      final String codeC,
      final List<SubjectTreeDTO> children
   ) {
      this.orderNo = orderNo;
      this.nameA = nameA;
      this.codeA = codeA;
      this.basicClass = basicClass;
      this.serialNumberA = serialNumberA;
      this.nameB = nameB;
      this.codeB = codeB;
      this.serialNumberB = serialNumberB;
      this.nameC = nameC;
      this.codeC = codeC;
      this.children = children;
   }

   public SubjectTreeImportDTO() {
   }

   public static class SubjectTreeImportDTOBuilder {
      private Integer orderNo;
      private String nameA;
      private String codeA;
      private String basicClass;
      private String serialNumberA;
      private String nameB;
      private String codeB;
      private String serialNumberB;
      private String nameC;
      private String codeC;
      private List<SubjectTreeDTO> children;

      SubjectTreeImportDTOBuilder() {
      }

      public SubjectTreeImportDTO.SubjectTreeImportDTOBuilder orderNo(final Integer orderNo) {
         this.orderNo = orderNo;
         return this;
      }

      public SubjectTreeImportDTO.SubjectTreeImportDTOBuilder nameA(final String nameA) {
         this.nameA = nameA;
         return this;
      }

      public SubjectTreeImportDTO.SubjectTreeImportDTOBuilder codeA(final String codeA) {
         this.codeA = codeA;
         return this;
      }

      public SubjectTreeImportDTO.SubjectTreeImportDTOBuilder basicClass(final String basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SubjectTreeImportDTO.SubjectTreeImportDTOBuilder serialNumberA(final String serialNumberA) {
         this.serialNumberA = serialNumberA;
         return this;
      }

      public SubjectTreeImportDTO.SubjectTreeImportDTOBuilder nameB(final String nameB) {
         this.nameB = nameB;
         return this;
      }

      public SubjectTreeImportDTO.SubjectTreeImportDTOBuilder codeB(final String codeB) {
         this.codeB = codeB;
         return this;
      }

      public SubjectTreeImportDTO.SubjectTreeImportDTOBuilder serialNumberB(final String serialNumberB) {
         this.serialNumberB = serialNumberB;
         return this;
      }

      public SubjectTreeImportDTO.SubjectTreeImportDTOBuilder nameC(final String nameC) {
         this.nameC = nameC;
         return this;
      }

      public SubjectTreeImportDTO.SubjectTreeImportDTOBuilder codeC(final String codeC) {
         this.codeC = codeC;
         return this;
      }

      public SubjectTreeImportDTO.SubjectTreeImportDTOBuilder children(final List<SubjectTreeDTO> children) {
         this.children = children;
         return this;
      }

      public SubjectTreeImportDTO build() {
         return new SubjectTreeImportDTO(
            this.orderNo,
            this.nameA,
            this.codeA,
            this.basicClass,
            this.serialNumberA,
            this.nameB,
            this.codeB,
            this.serialNumberB,
            this.nameC,
            this.codeC,
            this.children
         );
      }

      @Override
      public String toString() {
         return "SubjectTreeImportDTO.SubjectTreeImportDTOBuilder(orderNo="
            + this.orderNo
            + ", nameA="
            + this.nameA
            + ", codeA="
            + this.codeA
            + ", basicClass="
            + this.basicClass
            + ", serialNumberA="
            + this.serialNumberA
            + ", nameB="
            + this.nameB
            + ", codeB="
            + this.codeB
            + ", serialNumberB="
            + this.serialNumberB
            + ", nameC="
            + this.nameC
            + ", codeC="
            + this.codeC
            + ", children="
            + this.children
            + ")";
      }
   }
}
