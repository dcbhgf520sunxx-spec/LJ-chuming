package com.hzchum.pangu.common.nesting.pojo;

import java.util.List;

public class ProfileNestingInfo {
   public Long projectId;
   public String material;
   public String crossSectionType;
   public String specifications;
   public Integer baseMetalLength;
   public Integer kerfLength;
   public Integer nestingModeEnum;
   public String outputDirectoryPath;
   public Integer count;
   public List<Assemble> assembleList;

   public ProfileNestingInfo() {
   }

   public ProfileNestingInfo(
      Long projectId,
      List<Assemble> assembleList,
      String material,
      String crossSectionType,
      String specifications,
      Integer baseMetalLength,
      Integer kerfLength,
      Integer nestingModeEnum,
      String outputDirectoryPath,
      Integer count
   ) {
      this.projectId = projectId;
      this.assembleList = assembleList;
      this.material = material;
      this.crossSectionType = crossSectionType;
      this.specifications = specifications;
      this.baseMetalLength = baseMetalLength;
      this.kerfLength = kerfLength;
      this.nestingModeEnum = nestingModeEnum;
      this.outputDirectoryPath = outputDirectoryPath;
      this.count = count;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public void setProjectId(Long projectId) {
      this.projectId = projectId;
   }

   public List<Assemble> getAssembleList() {
      return this.assembleList;
   }

   public void setAssembleList(List<Assemble> assembleList) {
      this.assembleList = assembleList;
   }

   public String getMaterial() {
      return this.material;
   }

   public void setMaterial(String material) {
      this.material = material;
   }

   public String getCrossSectionType() {
      return this.crossSectionType;
   }

   public void setCrossSectionType(String crossSectionType) {
      this.crossSectionType = crossSectionType;
   }

   public String getSpecifications() {
      return this.specifications;
   }

   public void setSpecifications(String specifications) {
      this.specifications = specifications;
   }

   public Integer getBaseMetalLength() {
      return this.baseMetalLength;
   }

   public void setBaseMetalLength(Integer baseMetalLength) {
      this.baseMetalLength = baseMetalLength;
   }

   public Integer getKerfLength() {
      return this.kerfLength;
   }

   public void setKerfLength(Integer kerfLength) {
      this.kerfLength = kerfLength;
   }

   public Integer getNestingMode() {
      return this.nestingModeEnum;
   }

   public void setNestingModeEnum(Integer nestingModeEnum) {
      this.nestingModeEnum = nestingModeEnum;
   }

   public void setOutputDirectoryPath(String outputDirectoryPath) {
      this.outputDirectoryPath = outputDirectoryPath;
   }

   public void setCount(Integer count) {
      this.count = count;
   }
}
