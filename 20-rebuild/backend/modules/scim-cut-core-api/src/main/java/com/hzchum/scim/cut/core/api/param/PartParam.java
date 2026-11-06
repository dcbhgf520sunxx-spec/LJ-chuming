package com.hzchum.scim.cut.core.api.param;

public class PartParam {
   private String prdRefDst;
   private String prdName;
   private String machine;
   private String material;
   private Double thickness;
   private Integer quantity;
   private String downloadUrl;
   private String objectName;
   private String userdata1;
   private String userdata2;
   private String userdata3;
   private String userdata4;
   private String userdata5;
   private String userdata6;

   PartParam(
      final String prdRefDst,
      final String prdName,
      final String machine,
      final String material,
      final Double thickness,
      final Integer quantity,
      final String downloadUrl,
      final String objectName,
      final String userdata1,
      final String userdata2,
      final String userdata3,
      final String userdata4,
      final String userdata5,
      final String userdata6
   ) {
      this.prdRefDst = prdRefDst;
      this.prdName = prdName;
      this.machine = machine;
      this.material = material;
      this.thickness = thickness;
      this.quantity = quantity;
      this.downloadUrl = downloadUrl;
      this.objectName = objectName;
      this.userdata1 = userdata1;
      this.userdata2 = userdata2;
      this.userdata3 = userdata3;
      this.userdata4 = userdata4;
      this.userdata5 = userdata5;
      this.userdata6 = userdata6;
   }

   public static PartParam.PartParamBuilder builder() {
      return new PartParam.PartParamBuilder();
   }

   public String getPrdRefDst() {
      return this.prdRefDst;
   }

   public String getPrdName() {
      return this.prdName;
   }

   public String getMachine() {
      return this.machine;
   }

   public String getMaterial() {
      return this.material;
   }

   public Double getThickness() {
      return this.thickness;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getDownloadUrl() {
      return this.downloadUrl;
   }

   public String getObjectName() {
      return this.objectName;
   }

   public String getUserdata1() {
      return this.userdata1;
   }

   public String getUserdata2() {
      return this.userdata2;
   }

   public String getUserdata3() {
      return this.userdata3;
   }

   public String getUserdata4() {
      return this.userdata4;
   }

   public String getUserdata5() {
      return this.userdata5;
   }

   public String getUserdata6() {
      return this.userdata6;
   }

   public void setPrdRefDst(final String prdRefDst) {
      this.prdRefDst = prdRefDst;
   }

   public void setPrdName(final String prdName) {
      this.prdName = prdName;
   }

   public void setMachine(final String machine) {
      this.machine = machine;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThickness(final Double thickness) {
      this.thickness = thickness;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setDownloadUrl(final String downloadUrl) {
      this.downloadUrl = downloadUrl;
   }

   public void setObjectName(final String objectName) {
      this.objectName = objectName;
   }

   public void setUserdata1(final String userdata1) {
      this.userdata1 = userdata1;
   }

   public void setUserdata2(final String userdata2) {
      this.userdata2 = userdata2;
   }

   public void setUserdata3(final String userdata3) {
      this.userdata3 = userdata3;
   }

   public void setUserdata4(final String userdata4) {
      this.userdata4 = userdata4;
   }

   public void setUserdata5(final String userdata5) {
      this.userdata5 = userdata5;
   }

   public void setUserdata6(final String userdata6) {
      this.userdata6 = userdata6;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartParam)) {
         return false;
      }

      PartParam other = (PartParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$thickness = this.getThickness();
      Object other$thickness = other.getThickness();
      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$prdRefDst = this.getPrdRefDst();
            Object other$prdRefDst = other.getPrdRefDst();
            if (this$prdRefDst == null ? other$prdRefDst == null : this$prdRefDst.equals(other$prdRefDst)) {
               Object this$prdName = this.getPrdName();
               Object other$prdName = other.getPrdName();
               if (this$prdName == null ? other$prdName == null : this$prdName.equals(other$prdName)) {
                  Object this$machine = this.getMachine();
                  Object other$machine = other.getMachine();
                  if (this$machine == null ? other$machine == null : this$machine.equals(other$machine)) {
                     Object this$material = this.getMaterial();
                     Object other$material = other.getMaterial();
                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                        Object this$downloadUrl = this.getDownloadUrl();
                        Object other$downloadUrl = other.getDownloadUrl();
                        if (this$downloadUrl == null ? other$downloadUrl == null : this$downloadUrl.equals(other$downloadUrl)) {
                           Object this$objectName = this.getObjectName();
                           Object other$objectName = other.getObjectName();
                           if (this$objectName == null ? other$objectName == null : this$objectName.equals(other$objectName)) {
                              Object this$userdata1 = this.getUserdata1();
                              Object other$userdata1 = other.getUserdata1();
                              if (this$userdata1 == null ? other$userdata1 == null : this$userdata1.equals(other$userdata1)) {
                                 Object this$userdata2 = this.getUserdata2();
                                 Object other$userdata2 = other.getUserdata2();
                                 if (this$userdata2 == null ? other$userdata2 == null : this$userdata2.equals(other$userdata2)) {
                                    Object this$userdata3 = this.getUserdata3();
                                    Object other$userdata3 = other.getUserdata3();
                                    if (this$userdata3 == null ? other$userdata3 == null : this$userdata3.equals(other$userdata3)) {
                                       Object this$userdata4 = this.getUserdata4();
                                       Object other$userdata4 = other.getUserdata4();
                                       if (this$userdata4 == null ? other$userdata4 == null : this$userdata4.equals(other$userdata4)) {
                                          Object this$userdata5 = this.getUserdata5();
                                          Object other$userdata5 = other.getUserdata5();
                                          if (this$userdata5 == null ? other$userdata5 == null : this$userdata5.equals(other$userdata5)) {
                                             Object this$userdata6 = this.getUserdata6();
                                             Object other$userdata6 = other.getUserdata6();
                                             return this$userdata6 == null ? other$userdata6 == null : this$userdata6.equals(other$userdata6);
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
      return other instanceof PartParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $prdRefDst = this.getPrdRefDst();
      result = result * 59 + ($prdRefDst == null ? 43 : $prdRefDst.hashCode());
      Object $prdName = this.getPrdName();
      result = result * 59 + ($prdName == null ? 43 : $prdName.hashCode());
      Object $machine = this.getMachine();
      result = result * 59 + ($machine == null ? 43 : $machine.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $downloadUrl = this.getDownloadUrl();
      result = result * 59 + ($downloadUrl == null ? 43 : $downloadUrl.hashCode());
      Object $objectName = this.getObjectName();
      result = result * 59 + ($objectName == null ? 43 : $objectName.hashCode());
      Object $userdata1 = this.getUserdata1();
      result = result * 59 + ($userdata1 == null ? 43 : $userdata1.hashCode());
      Object $userdata2 = this.getUserdata2();
      result = result * 59 + ($userdata2 == null ? 43 : $userdata2.hashCode());
      Object $userdata3 = this.getUserdata3();
      result = result * 59 + ($userdata3 == null ? 43 : $userdata3.hashCode());
      Object $userdata4 = this.getUserdata4();
      result = result * 59 + ($userdata4 == null ? 43 : $userdata4.hashCode());
      Object $userdata5 = this.getUserdata5();
      result = result * 59 + ($userdata5 == null ? 43 : $userdata5.hashCode());
      Object $userdata6 = this.getUserdata6();
      return result * 59 + ($userdata6 == null ? 43 : $userdata6.hashCode());
   }

   @Override
   public String toString() {
      return "PartParam(prdRefDst="
         + this.getPrdRefDst()
         + ", prdName="
         + this.getPrdName()
         + ", machine="
         + this.getMachine()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", quantity="
         + this.getQuantity()
         + ", downloadUrl="
         + this.getDownloadUrl()
         + ", objectName="
         + this.getObjectName()
         + ", userdata1="
         + this.getUserdata1()
         + ", userdata2="
         + this.getUserdata2()
         + ", userdata3="
         + this.getUserdata3()
         + ", userdata4="
         + this.getUserdata4()
         + ", userdata5="
         + this.getUserdata5()
         + ", userdata6="
         + this.getUserdata6()
         + ")";
   }

   public static class PartParamBuilder {
      private String prdRefDst;
      private String prdName;
      private String machine;
      private String material;
      private Double thickness;
      private Integer quantity;
      private String downloadUrl;
      private String objectName;
      private String userdata1;
      private String userdata2;
      private String userdata3;
      private String userdata4;
      private String userdata5;
      private String userdata6;

      PartParamBuilder() {
      }

      public PartParam.PartParamBuilder prdRefDst(final String prdRefDst) {
         this.prdRefDst = prdRefDst;
         return this;
      }

      public PartParam.PartParamBuilder prdName(final String prdName) {
         this.prdName = prdName;
         return this;
      }

      public PartParam.PartParamBuilder machine(final String machine) {
         this.machine = machine;
         return this;
      }

      public PartParam.PartParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public PartParam.PartParamBuilder thickness(final Double thickness) {
         this.thickness = thickness;
         return this;
      }

      public PartParam.PartParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public PartParam.PartParamBuilder downloadUrl(final String downloadUrl) {
         this.downloadUrl = downloadUrl;
         return this;
      }

      public PartParam.PartParamBuilder objectName(final String objectName) {
         this.objectName = objectName;
         return this;
      }

      public PartParam.PartParamBuilder userdata1(final String userdata1) {
         this.userdata1 = userdata1;
         return this;
      }

      public PartParam.PartParamBuilder userdata2(final String userdata2) {
         this.userdata2 = userdata2;
         return this;
      }

      public PartParam.PartParamBuilder userdata3(final String userdata3) {
         this.userdata3 = userdata3;
         return this;
      }

      public PartParam.PartParamBuilder userdata4(final String userdata4) {
         this.userdata4 = userdata4;
         return this;
      }

      public PartParam.PartParamBuilder userdata5(final String userdata5) {
         this.userdata5 = userdata5;
         return this;
      }

      public PartParam.PartParamBuilder userdata6(final String userdata6) {
         this.userdata6 = userdata6;
         return this;
      }

      public PartParam build() {
         return new PartParam(
            this.prdRefDst,
            this.prdName,
            this.machine,
            this.material,
            this.thickness,
            this.quantity,
            this.downloadUrl,
            this.objectName,
            this.userdata1,
            this.userdata2,
            this.userdata3,
            this.userdata4,
            this.userdata5,
            this.userdata6
         );
      }

      @Override
      public String toString() {
         return "PartParam.PartParamBuilder(prdRefDst="
            + this.prdRefDst
            + ", prdName="
            + this.prdName
            + ", machine="
            + this.machine
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", quantity="
            + this.quantity
            + ", downloadUrl="
            + this.downloadUrl
            + ", objectName="
            + this.objectName
            + ", userdata1="
            + this.userdata1
            + ", userdata2="
            + this.userdata2
            + ", userdata3="
            + this.userdata3
            + ", userdata4="
            + this.userdata4
            + ", userdata5="
            + this.userdata5
            + ", userdata6="
            + this.userdata6
            + ")";
      }
   }
}
