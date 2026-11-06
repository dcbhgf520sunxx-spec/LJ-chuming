package com.hzchum.pangu.common.nesting.pojo;

import java.util.Arrays;
import java.util.List;

public class ProfileNestingResult {
   public String serialNumber;
   public Integer nestingLength;
   public Integer roundNestingLength;
   public int[] resultOrderGroup;
   public String filepathPNC;
   public List<NestingAssemble> assembleList;
   public Long projectId;
   public String material;
   public String crossSectionType;
   public String specifications;
   public Integer baseMetalLength;
   public Integer kerfLength;
   public Integer nestingModeEnum;

   public ProfileNestingResult(
      String serialNumber,
      Integer nestingLength,
      Integer roundNestingLength,
      int[] resultOrderGroup,
      List<NestingAssemble> assembleList,
      ProfileNestingInfo profileNestingInfo
   ) {
      this.serialNumber = serialNumber;
      this.nestingLength = nestingLength;
      this.roundNestingLength = roundNestingLength;
      this.resultOrderGroup = resultOrderGroup;
      this.assembleList = assembleList;
      this.projectId = profileNestingInfo.projectId;
      this.material = profileNestingInfo.material;
      this.crossSectionType = profileNestingInfo.crossSectionType;
      this.specifications = profileNestingInfo.specifications;
      this.baseMetalLength = profileNestingInfo.baseMetalLength;
      this.kerfLength = profileNestingInfo.kerfLength;
      this.nestingModeEnum = profileNestingInfo.nestingModeEnum;
   }

   @Override
   public String toString() {
      return "ProfileNestingResult{serialNumber='"
         + this.serialNumber
         + '\''
         + ", nestingLength="
         + this.nestingLength
         + ", roundNestingLength="
         + this.roundNestingLength
         + ", resultOrderGroup="
         + Arrays.toString(this.resultOrderGroup)
         + ", assembleList="
         + this.assembleList
         + ", projectId="
         + this.projectId
         + ", material='"
         + this.material
         + '\''
         + ", crossSectionType='"
         + this.crossSectionType
         + '\''
         + ", specifications='"
         + this.specifications
         + '\''
         + ", baseMetalLength="
         + this.baseMetalLength
         + ", kerfLength="
         + this.kerfLength
         + ", nestingModeEnum="
         + this.nestingModeEnum
         + '}';
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getNestingLength() {
      return this.nestingLength;
   }

   public Integer getRoundNestingLength() {
      return this.roundNestingLength;
   }

   public int[] getResultOrderGroup() {
      return this.resultOrderGroup;
   }

   public String getFilepathPNC() {
      return this.filepathPNC;
   }

   public List<NestingAssemble> getAssembleList() {
      return this.assembleList;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getCrossSectionType() {
      return this.crossSectionType;
   }

   public String getSpecifications() {
      return this.specifications;
   }

   public Integer getBaseMetalLength() {
      return this.baseMetalLength;
   }

   public Integer getKerfLength() {
      return this.kerfLength;
   }

   public Integer getNestingModeEnum() {
      return this.nestingModeEnum;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setNestingLength(final Integer nestingLength) {
      this.nestingLength = nestingLength;
   }

   public void setRoundNestingLength(final Integer roundNestingLength) {
      this.roundNestingLength = roundNestingLength;
   }

   public void setResultOrderGroup(final int[] resultOrderGroup) {
      this.resultOrderGroup = resultOrderGroup;
   }

   public void setFilepathPNC(final String filepathPNC) {
      this.filepathPNC = filepathPNC;
   }

   public void setAssembleList(final List<NestingAssemble> assembleList) {
      this.assembleList = assembleList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setCrossSectionType(final String crossSectionType) {
      this.crossSectionType = crossSectionType;
   }

   public void setSpecifications(final String specifications) {
      this.specifications = specifications;
   }

   public void setBaseMetalLength(final Integer baseMetalLength) {
      this.baseMetalLength = baseMetalLength;
   }

   public void setKerfLength(final Integer kerfLength) {
      this.kerfLength = kerfLength;
   }

   public void setNestingModeEnum(final Integer nestingModeEnum) {
      this.nestingModeEnum = nestingModeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProfileNestingResult)) {
         return false;
      }

      ProfileNestingResult other = (ProfileNestingResult)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$nestingLength = this.getNestingLength();
      Object other$nestingLength = other.getNestingLength();
      if (this$nestingLength == null ? other$nestingLength == null : this$nestingLength.equals(other$nestingLength)) {
         Object this$roundNestingLength = this.getRoundNestingLength();
         Object other$roundNestingLength = other.getRoundNestingLength();
         if (this$roundNestingLength == null ? other$roundNestingLength == null : this$roundNestingLength.equals(other$roundNestingLength)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$baseMetalLength = this.getBaseMetalLength();
               Object other$baseMetalLength = other.getBaseMetalLength();
               if (this$baseMetalLength == null ? other$baseMetalLength == null : this$baseMetalLength.equals(other$baseMetalLength)) {
                  Object this$kerfLength = this.getKerfLength();
                  Object other$kerfLength = other.getKerfLength();
                  if (this$kerfLength == null ? other$kerfLength == null : this$kerfLength.equals(other$kerfLength)) {
                     Object this$nestingModeEnum = this.getNestingModeEnum();
                     Object other$nestingModeEnum = other.getNestingModeEnum();
                     if (this$nestingModeEnum == null ? other$nestingModeEnum == null : this$nestingModeEnum.equals(other$nestingModeEnum)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           if (!Arrays.equals(this.getResultOrderGroup(), other.getResultOrderGroup())) {
                              return false;
                           }

                           Object this$filepathPNC = this.getFilepathPNC();
                           Object other$filepathPNC = other.getFilepathPNC();
                           if (this$filepathPNC == null ? other$filepathPNC == null : this$filepathPNC.equals(other$filepathPNC)) {
                              Object this$assembleList = this.getAssembleList();
                              Object other$assembleList = other.getAssembleList();
                              if (this$assembleList == null ? other$assembleList == null : this$assembleList.equals(other$assembleList)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                    Object this$crossSectionType = this.getCrossSectionType();
                                    Object other$crossSectionType = other.getCrossSectionType();
                                    if (this$crossSectionType == null ? other$crossSectionType == null : this$crossSectionType.equals(other$crossSectionType)) {
                                       Object this$specifications = this.getSpecifications();
                                       Object other$specifications = other.getSpecifications();
                                       return this$specifications == null ? other$specifications == null : this$specifications.equals(other$specifications);
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
      return other instanceof ProfileNestingResult;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $nestingLength = this.getNestingLength();
      result = result * 59 + ($nestingLength == null ? 43 : $nestingLength.hashCode());
      Object $roundNestingLength = this.getRoundNestingLength();
      result = result * 59 + ($roundNestingLength == null ? 43 : $roundNestingLength.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $baseMetalLength = this.getBaseMetalLength();
      result = result * 59 + ($baseMetalLength == null ? 43 : $baseMetalLength.hashCode());
      Object $kerfLength = this.getKerfLength();
      result = result * 59 + ($kerfLength == null ? 43 : $kerfLength.hashCode());
      Object $nestingModeEnum = this.getNestingModeEnum();
      result = result * 59 + ($nestingModeEnum == null ? 43 : $nestingModeEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      result = result * 59 + Arrays.hashCode(this.getResultOrderGroup());
      Object $filepathPNC = this.getFilepathPNC();
      result = result * 59 + ($filepathPNC == null ? 43 : $filepathPNC.hashCode());
      Object $assembleList = this.getAssembleList();
      result = result * 59 + ($assembleList == null ? 43 : $assembleList.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $crossSectionType = this.getCrossSectionType();
      result = result * 59 + ($crossSectionType == null ? 43 : $crossSectionType.hashCode());
      Object $specifications = this.getSpecifications();
      return result * 59 + ($specifications == null ? 43 : $specifications.hashCode());
   }
}
