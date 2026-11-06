package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;

@ApiModel(value = "CreateDto", description = "切割任务创建信息 ")
public class CreateDto {
   @ApiModelProperty("宽度")
   private String breadth;
   @ApiModelProperty("切割方式")
   private String cuttingWay;
   @ApiModelProperty("id号")
   private String idNumber;
   @ApiModelProperty("长度")
   private String length;
   @ApiModelProperty("数量")
   private Integer num;
   @ApiModelProperty("零件数量")
   private Integer partNum;
   @ApiModelProperty("材质")
   private String texture;
   @ApiModelProperty("厚度")
   private String thickness;
   @ApiModelProperty("文件名称")
   private String fileName;
   @ApiModelProperty("文件流")
   private byte[] file;

   public static CreateDto.CreateDtoBuilder builder() {
      return new CreateDto.CreateDtoBuilder();
   }

   public CreateDto() {
   }

   public CreateDto(
      final String breadth,
      final String cuttingWay,
      final String idNumber,
      final String length,
      final Integer num,
      final Integer partNum,
      final String texture,
      final String thickness,
      final String fileName,
      final byte[] file
   ) {
      this.breadth = breadth;
      this.cuttingWay = cuttingWay;
      this.idNumber = idNumber;
      this.length = length;
      this.num = num;
      this.partNum = partNum;
      this.texture = texture;
      this.thickness = thickness;
      this.fileName = fileName;
      this.file = file;
   }

   public String getBreadth() {
      return this.breadth;
   }

   public String getCuttingWay() {
      return this.cuttingWay;
   }

   public String getIdNumber() {
      return this.idNumber;
   }

   public String getLength() {
      return this.length;
   }

   public Integer getNum() {
      return this.num;
   }

   public Integer getPartNum() {
      return this.partNum;
   }

   public String getTexture() {
      return this.texture;
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getFileName() {
      return this.fileName;
   }

   public byte[] getFile() {
      return this.file;
   }

   public CreateDto setBreadth(final String breadth) {
      this.breadth = breadth;
      return this;
   }

   public CreateDto setCuttingWay(final String cuttingWay) {
      this.cuttingWay = cuttingWay;
      return this;
   }

   public CreateDto setIdNumber(final String idNumber) {
      this.idNumber = idNumber;
      return this;
   }

   public CreateDto setLength(final String length) {
      this.length = length;
      return this;
   }

   public CreateDto setNum(final Integer num) {
      this.num = num;
      return this;
   }

   public CreateDto setPartNum(final Integer partNum) {
      this.partNum = partNum;
      return this;
   }

   public CreateDto setTexture(final String texture) {
      this.texture = texture;
      return this;
   }

   public CreateDto setThickness(final String thickness) {
      this.thickness = thickness;
      return this;
   }

   public CreateDto setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   public CreateDto setFile(final byte[] file) {
      this.file = file;
      return this;
   }

   @Override
   public String toString() {
      return "CreateDto(breadth="
         + this.getBreadth()
         + ", cuttingWay="
         + this.getCuttingWay()
         + ", idNumber="
         + this.getIdNumber()
         + ", length="
         + this.getLength()
         + ", num="
         + this.getNum()
         + ", partNum="
         + this.getPartNum()
         + ", texture="
         + this.getTexture()
         + ", thickness="
         + this.getThickness()
         + ", fileName="
         + this.getFileName()
         + ", file="
         + Arrays.toString(this.getFile())
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CreateDto)) {
         return false;
      }

      CreateDto other = (CreateDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$num = this.getNum();
      Object other$num = other.getNum();
      if (this$num == null ? other$num == null : this$num.equals(other$num)) {
         Object this$partNum = this.getPartNum();
         Object other$partNum = other.getPartNum();
         if (this$partNum == null ? other$partNum == null : this$partNum.equals(other$partNum)) {
            Object this$breadth = this.getBreadth();
            Object other$breadth = other.getBreadth();
            if (this$breadth == null ? other$breadth == null : this$breadth.equals(other$breadth)) {
               Object this$cuttingWay = this.getCuttingWay();
               Object other$cuttingWay = other.getCuttingWay();
               if (this$cuttingWay == null ? other$cuttingWay == null : this$cuttingWay.equals(other$cuttingWay)) {
                  Object this$idNumber = this.getIdNumber();
                  Object other$idNumber = other.getIdNumber();
                  if (this$idNumber == null ? other$idNumber == null : this$idNumber.equals(other$idNumber)) {
                     Object this$length = this.getLength();
                     Object other$length = other.getLength();
                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                        Object this$texture = this.getTexture();
                        Object other$texture = other.getTexture();
                        if (this$texture == null ? other$texture == null : this$texture.equals(other$texture)) {
                           Object this$thickness = this.getThickness();
                           Object other$thickness = other.getThickness();
                           if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                              Object this$fileName = this.getFileName();
                              Object other$fileName = other.getFileName();
                              return (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName))
                                 ? Arrays.equals(this.getFile(), other.getFile())
                                 : false;
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
      return other instanceof CreateDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $num = this.getNum();
      result = result * 59 + ($num == null ? 43 : $num.hashCode());
      Object $partNum = this.getPartNum();
      result = result * 59 + ($partNum == null ? 43 : $partNum.hashCode());
      Object $breadth = this.getBreadth();
      result = result * 59 + ($breadth == null ? 43 : $breadth.hashCode());
      Object $cuttingWay = this.getCuttingWay();
      result = result * 59 + ($cuttingWay == null ? 43 : $cuttingWay.hashCode());
      Object $idNumber = this.getIdNumber();
      result = result * 59 + ($idNumber == null ? 43 : $idNumber.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $texture = this.getTexture();
      result = result * 59 + ($texture == null ? 43 : $texture.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      return result * 59 + Arrays.hashCode(this.getFile());
   }

   public static class CreateDtoBuilder {
      private String breadth;
      private String cuttingWay;
      private String idNumber;
      private String length;
      private Integer num;
      private Integer partNum;
      private String texture;
      private String thickness;
      private String fileName;
      private byte[] file;

      CreateDtoBuilder() {
      }

      public CreateDto.CreateDtoBuilder breadth(final String breadth) {
         this.breadth = breadth;
         return this;
      }

      public CreateDto.CreateDtoBuilder cuttingWay(final String cuttingWay) {
         this.cuttingWay = cuttingWay;
         return this;
      }

      public CreateDto.CreateDtoBuilder idNumber(final String idNumber) {
         this.idNumber = idNumber;
         return this;
      }

      public CreateDto.CreateDtoBuilder length(final String length) {
         this.length = length;
         return this;
      }

      public CreateDto.CreateDtoBuilder num(final Integer num) {
         this.num = num;
         return this;
      }

      public CreateDto.CreateDtoBuilder partNum(final Integer partNum) {
         this.partNum = partNum;
         return this;
      }

      public CreateDto.CreateDtoBuilder texture(final String texture) {
         this.texture = texture;
         return this;
      }

      public CreateDto.CreateDtoBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public CreateDto.CreateDtoBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public CreateDto.CreateDtoBuilder file(final byte[] file) {
         this.file = file;
         return this;
      }

      public CreateDto build() {
         return new CreateDto(
            this.breadth, this.cuttingWay, this.idNumber, this.length, this.num, this.partNum, this.texture, this.thickness, this.fileName, this.file
         );
      }

      @Override
      public String toString() {
         return "CreateDto.CreateDtoBuilder(breadth="
            + this.breadth
            + ", cuttingWay="
            + this.cuttingWay
            + ", idNumber="
            + this.idNumber
            + ", length="
            + this.length
            + ", num="
            + this.num
            + ", partNum="
            + this.partNum
            + ", texture="
            + this.texture
            + ", thickness="
            + this.thickness
            + ", fileName="
            + this.fileName
            + ", file="
            + Arrays.toString(this.file)
            + ")";
      }
   }
}
