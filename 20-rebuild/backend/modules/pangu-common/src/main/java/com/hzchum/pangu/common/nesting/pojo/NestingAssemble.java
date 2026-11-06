package com.hzchum.pangu.common.nesting.pojo;

public class NestingAssemble {
   public Long id;
   public Long assembleDetailId;
   public Long projectId;
   public Long monomerId;
   public String serialNumber;
   public String material;
   public String crossSectionType;
   public String specifications;
   public Integer length;
   public Integer fullLength;
   public String nc1Path;
   public Long artifactId;
   public String artifactSerialNumber;

   public NestingAssemble(Assemble assemble) {
      this.id = assemble.id;
      this.assembleDetailId = assemble.assembleDetailId;
      this.projectId = assemble.projectId;
      this.monomerId = assemble.monomerId;
      this.serialNumber = assemble.serialNumber;
      this.material = assemble.material;
      this.crossSectionType = assemble.crossSectionType;
      this.specifications = assemble.specifications;
      this.length = assemble.length;
      this.fullLength = assemble.fullLength;
      this.nc1Path = assemble.nc1Path;
      this.artifactSerialNumber = assemble.artifactSerialNumber;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public void setArtifactId(Long artifactId) {
      this.artifactId = artifactId;
   }

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
   }

   public void setArtifactSerialNumber(String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
   }

   public Integer getLength() {
      return this.length;
   }

   @Override
   public String toString() {
      return "部件id" + this.id + " 编号 " + this.serialNumber + " 的长度：" + this.length + "  ;  完整长度：" + this.fullLength;
   }
}
