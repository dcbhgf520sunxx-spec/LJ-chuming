package com.hzchum.pangu.common.nesting.pojo;

public class Assemble implements Cloneable {
   public Long id;
   public Long assembleDetailId;
   public Long projectId;
   public Long monomerId;
   public Long areaId;
   public String serialNumber;
   public String material;
   public String crossSectionType;
   public String specifications;
   public String nc1Path;
   public Integer length;
   public String artifactSerialNumber;
   public Integer fullLength;
   public Integer quantity;

   public Assemble(
      Long id,
      Long assembleDetailId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      String material,
      String crossSectionType,
      String specifications,
      Integer length,
      Integer quantity,
      String nc1Path,
      String artifactSerialNumber
   ) {
      this.id = id;
      this.assembleDetailId = assembleDetailId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.serialNumber = serialNumber;
      this.material = material;
      this.crossSectionType = crossSectionType;
      this.specifications = specifications;
      this.nc1Path = nc1Path;
      this.length = length;
      this.quantity = quantity;
      this.artifactSerialNumber = artifactSerialNumber;
   }

   public void setFullLength(Integer fullLength) {
      this.fullLength = fullLength;
   }

   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }

   public Assemble clone() {
      Assemble obj = null;

      try {
         obj = (Assemble)super.clone();
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }

      return obj;
   }

   @Override
   public String toString() {
      return "Assemble{id="
         + this.id
         + ", projectId="
         + this.projectId
         + ", monomerId="
         + this.monomerId
         + ", areaId="
         + this.areaId
         + ", serialNumber='"
         + this.serialNumber
         + '\''
         + ", material='"
         + this.material
         + '\''
         + ", crossSectionType='"
         + this.crossSectionType
         + '\''
         + ", specifications='"
         + this.specifications
         + '\''
         + ", nc1Path='"
         + this.nc1Path
         + '\''
         + ", nc1Path='"
         + this.artifactSerialNumber
         + '\''
         + ", length="
         + this.length
         + ", fullLength="
         + this.fullLength
         + ", quantity="
         + this.quantity
         + '}';
   }
}
