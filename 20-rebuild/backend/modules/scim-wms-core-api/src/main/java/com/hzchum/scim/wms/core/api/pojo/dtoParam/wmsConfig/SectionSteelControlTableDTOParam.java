package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import java.math.BigDecimal;
import java.util.List;

public class SectionSteelControlTableDTOParam {
   private Long id;
   private Integer basicClass;
   private Integer mesProductEnum;
   private String name;
   private List<String> mesSectionSpecification;
   private List<Long> wmsClassifyIds;
   private BigDecimal errorA;
   private BigDecimal errorB;
   private BigDecimal errorD;
   private BigDecimal errorH;
   private BigDecimal errorT;
   private BigDecimal errorS;
   private BigDecimal errorBigB;
   private BigDecimal errorBigD;
   private BigDecimal errorBigH;
   private BigDecimal errorBigT;
   private BigDecimal errorBigS;
   private String image;
   private String errorType;

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public String getName() {
      return this.name;
   }

   public List<String> getMesSectionSpecification() {
      return this.mesSectionSpecification;
   }

   public List<Long> getWmsClassifyIds() {
      return this.wmsClassifyIds;
   }

   public BigDecimal getErrorA() {
      return this.errorA;
   }

   public BigDecimal getErrorB() {
      return this.errorB;
   }

   public BigDecimal getErrorD() {
      return this.errorD;
   }

   public BigDecimal getErrorH() {
      return this.errorH;
   }

   public BigDecimal getErrorT() {
      return this.errorT;
   }

   public BigDecimal getErrorS() {
      return this.errorS;
   }

   public BigDecimal getErrorBigB() {
      return this.errorBigB;
   }

   public BigDecimal getErrorBigD() {
      return this.errorBigD;
   }

   public BigDecimal getErrorBigH() {
      return this.errorBigH;
   }

   public BigDecimal getErrorBigT() {
      return this.errorBigT;
   }

   public BigDecimal getErrorBigS() {
      return this.errorBigS;
   }

   public String getImage() {
      return this.image;
   }

   public String getErrorType() {
      return this.errorType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMesSectionSpecification(final List<String> mesSectionSpecification) {
      this.mesSectionSpecification = mesSectionSpecification;
   }

   public void setWmsClassifyIds(final List<Long> wmsClassifyIds) {
      this.wmsClassifyIds = wmsClassifyIds;
   }

   public void setErrorA(final BigDecimal errorA) {
      this.errorA = errorA;
   }

   public void setErrorB(final BigDecimal errorB) {
      this.errorB = errorB;
   }

   public void setErrorD(final BigDecimal errorD) {
      this.errorD = errorD;
   }

   public void setErrorH(final BigDecimal errorH) {
      this.errorH = errorH;
   }

   public void setErrorT(final BigDecimal errorT) {
      this.errorT = errorT;
   }

   public void setErrorS(final BigDecimal errorS) {
      this.errorS = errorS;
   }

   public void setErrorBigB(final BigDecimal errorBigB) {
      this.errorBigB = errorBigB;
   }

   public void setErrorBigD(final BigDecimal errorBigD) {
      this.errorBigD = errorBigD;
   }

   public void setErrorBigH(final BigDecimal errorBigH) {
      this.errorBigH = errorBigH;
   }

   public void setErrorBigT(final BigDecimal errorBigT) {
      this.errorBigT = errorBigT;
   }

   public void setErrorBigS(final BigDecimal errorBigS) {
      this.errorBigS = errorBigS;
   }

   public void setImage(final String image) {
      this.image = image;
   }

   public void setErrorType(final String errorType) {
      this.errorType = errorType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SectionSteelControlTableDTOParam)) {
         return false;
      }

      SectionSteelControlTableDTOParam other = (SectionSteelControlTableDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$mesProductEnum = this.getMesProductEnum();
            Object other$mesProductEnum = other.getMesProductEnum();
            if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$mesSectionSpecification = this.getMesSectionSpecification();
                  Object other$mesSectionSpecification = other.getMesSectionSpecification();
                  if (this$mesSectionSpecification == null
                     ? other$mesSectionSpecification == null
                     : this$mesSectionSpecification.equals(other$mesSectionSpecification)) {
                     Object this$wmsClassifyIds = this.getWmsClassifyIds();
                     Object other$wmsClassifyIds = other.getWmsClassifyIds();
                     if (this$wmsClassifyIds == null ? other$wmsClassifyIds == null : this$wmsClassifyIds.equals(other$wmsClassifyIds)) {
                        Object this$errorA = this.getErrorA();
                        Object other$errorA = other.getErrorA();
                        if (this$errorA == null ? other$errorA == null : this$errorA.equals(other$errorA)) {
                           Object this$errorB = this.getErrorB();
                           Object other$errorB = other.getErrorB();
                           if (this$errorB == null ? other$errorB == null : this$errorB.equals(other$errorB)) {
                              Object this$errorD = this.getErrorD();
                              Object other$errorD = other.getErrorD();
                              if (this$errorD == null ? other$errorD == null : this$errorD.equals(other$errorD)) {
                                 Object this$errorH = this.getErrorH();
                                 Object other$errorH = other.getErrorH();
                                 if (this$errorH == null ? other$errorH == null : this$errorH.equals(other$errorH)) {
                                    Object this$errorT = this.getErrorT();
                                    Object other$errorT = other.getErrorT();
                                    if (this$errorT == null ? other$errorT == null : this$errorT.equals(other$errorT)) {
                                       Object this$errorS = this.getErrorS();
                                       Object other$errorS = other.getErrorS();
                                       if (this$errorS == null ? other$errorS == null : this$errorS.equals(other$errorS)) {
                                          Object this$errorBigB = this.getErrorBigB();
                                          Object other$errorBigB = other.getErrorBigB();
                                          if (this$errorBigB == null ? other$errorBigB == null : this$errorBigB.equals(other$errorBigB)) {
                                             Object this$errorBigD = this.getErrorBigD();
                                             Object other$errorBigD = other.getErrorBigD();
                                             if (this$errorBigD == null ? other$errorBigD == null : this$errorBigD.equals(other$errorBigD)) {
                                                Object this$errorBigH = this.getErrorBigH();
                                                Object other$errorBigH = other.getErrorBigH();
                                                if (this$errorBigH == null ? other$errorBigH == null : this$errorBigH.equals(other$errorBigH)) {
                                                   Object this$errorBigT = this.getErrorBigT();
                                                   Object other$errorBigT = other.getErrorBigT();
                                                   if (this$errorBigT == null ? other$errorBigT == null : this$errorBigT.equals(other$errorBigT)) {
                                                      Object this$errorBigS = this.getErrorBigS();
                                                      Object other$errorBigS = other.getErrorBigS();
                                                      if (this$errorBigS == null ? other$errorBigS == null : this$errorBigS.equals(other$errorBigS)) {
                                                         Object this$image = this.getImage();
                                                         Object other$image = other.getImage();
                                                         if (this$image == null ? other$image == null : this$image.equals(other$image)) {
                                                            Object this$errorType = this.getErrorType();
                                                            Object other$errorType = other.getErrorType();
                                                            return this$errorType == null ? other$errorType == null : this$errorType.equals(other$errorType);
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

   protected boolean canEqual(final Object other) {
      return other instanceof SectionSteelControlTableDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $mesSectionSpecification = this.getMesSectionSpecification();
      result = result * 59 + ($mesSectionSpecification == null ? 43 : $mesSectionSpecification.hashCode());
      Object $wmsClassifyIds = this.getWmsClassifyIds();
      result = result * 59 + ($wmsClassifyIds == null ? 43 : $wmsClassifyIds.hashCode());
      Object $errorA = this.getErrorA();
      result = result * 59 + ($errorA == null ? 43 : $errorA.hashCode());
      Object $errorB = this.getErrorB();
      result = result * 59 + ($errorB == null ? 43 : $errorB.hashCode());
      Object $errorD = this.getErrorD();
      result = result * 59 + ($errorD == null ? 43 : $errorD.hashCode());
      Object $errorH = this.getErrorH();
      result = result * 59 + ($errorH == null ? 43 : $errorH.hashCode());
      Object $errorT = this.getErrorT();
      result = result * 59 + ($errorT == null ? 43 : $errorT.hashCode());
      Object $errorS = this.getErrorS();
      result = result * 59 + ($errorS == null ? 43 : $errorS.hashCode());
      Object $errorBigB = this.getErrorBigB();
      result = result * 59 + ($errorBigB == null ? 43 : $errorBigB.hashCode());
      Object $errorBigD = this.getErrorBigD();
      result = result * 59 + ($errorBigD == null ? 43 : $errorBigD.hashCode());
      Object $errorBigH = this.getErrorBigH();
      result = result * 59 + ($errorBigH == null ? 43 : $errorBigH.hashCode());
      Object $errorBigT = this.getErrorBigT();
      result = result * 59 + ($errorBigT == null ? 43 : $errorBigT.hashCode());
      Object $errorBigS = this.getErrorBigS();
      result = result * 59 + ($errorBigS == null ? 43 : $errorBigS.hashCode());
      Object $image = this.getImage();
      result = result * 59 + ($image == null ? 43 : $image.hashCode());
      Object $errorType = this.getErrorType();
      return result * 59 + ($errorType == null ? 43 : $errorType.hashCode());
   }

   @Override
   public String toString() {
      return "SectionSteelControlTableDTOParam(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ", name="
         + this.getName()
         + ", mesSectionSpecification="
         + this.getMesSectionSpecification()
         + ", wmsClassifyIds="
         + this.getWmsClassifyIds()
         + ", errorA="
         + this.getErrorA()
         + ", errorB="
         + this.getErrorB()
         + ", errorD="
         + this.getErrorD()
         + ", errorH="
         + this.getErrorH()
         + ", errorT="
         + this.getErrorT()
         + ", errorS="
         + this.getErrorS()
         + ", errorBigB="
         + this.getErrorBigB()
         + ", errorBigD="
         + this.getErrorBigD()
         + ", errorBigH="
         + this.getErrorBigH()
         + ", errorBigT="
         + this.getErrorBigT()
         + ", errorBigS="
         + this.getErrorBigS()
         + ", image="
         + this.getImage()
         + ", errorType="
         + this.getErrorType()
         + ")";
   }
}
