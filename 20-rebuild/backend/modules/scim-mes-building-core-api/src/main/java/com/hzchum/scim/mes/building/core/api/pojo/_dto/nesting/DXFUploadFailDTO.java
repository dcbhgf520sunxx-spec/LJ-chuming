package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ExcelTarget("DXFUploadFailDTO")
@ApiModel(value = "dxf图片上传信息", description = "dxf图片上传信息")
public class DXFUploadFailDTO {
   @ApiModelProperty(name = "dxfName", value = "dxf图片名称", notes = "dxf图片名称")
   @JsonProperty("dxfName")
   @JSONField(name = "dxfName")
   @Excel(name = "dxf图片名称", orderNum = "0", width = 20.0)
   private String dxfName;
   @ApiModelProperty(name = "errorMsg", value = "失败原因", notes = "失败原因")
   @JsonProperty("errorMsg")
   @JSONField(name = "errorMsg")
   @Excel(name = "导入失败原因", orderNum = "1", width = 100.0)
   private String errorMsg;

   public static DXFUploadFailDTO.DXFUploadFailDTOBuilder builder() {
      return new DXFUploadFailDTO.DXFUploadFailDTOBuilder();
   }

   public DXFUploadFailDTO(final String dxfName, final String errorMsg) {
      this.dxfName = dxfName;
      this.errorMsg = errorMsg;
   }

   public DXFUploadFailDTO() {
   }

   public String getDxfName() {
      return this.dxfName;
   }

   public String getErrorMsg() {
      return this.errorMsg;
   }

   @JsonProperty("dxfName")
   public DXFUploadFailDTO setDxfName(final String dxfName) {
      this.dxfName = dxfName;
      return this;
   }

   @JsonProperty("errorMsg")
   public DXFUploadFailDTO setErrorMsg(final String errorMsg) {
      this.errorMsg = errorMsg;
      return this;
   }

   @Override
   public String toString() {
      return "DXFUploadFailDTO(dxfName=" + this.getDxfName() + ", errorMsg=" + this.getErrorMsg() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DXFUploadFailDTO)) {
         return false;
      } else {
         DXFUploadFailDTO other = (DXFUploadFailDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$dxfName = this.getDxfName();
            Object other$dxfName = other.getDxfName();
            if (this$dxfName == null ? other$dxfName == null : this$dxfName.equals(other$dxfName)) {
               Object this$errorMsg = this.getErrorMsg();
               Object other$errorMsg = other.getErrorMsg();
               return this$errorMsg == null ? other$errorMsg == null : this$errorMsg.equals(other$errorMsg);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DXFUploadFailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dxfName = this.getDxfName();
      result = result * 59 + ($dxfName == null ? 43 : $dxfName.hashCode());
      Object $errorMsg = this.getErrorMsg();
      return result * 59 + ($errorMsg == null ? 43 : $errorMsg.hashCode());
   }

   public static class DXFUploadFailDTOBuilder {
      private String dxfName;
      private String errorMsg;

      DXFUploadFailDTOBuilder() {
      }

      @JsonProperty("dxfName")
      public DXFUploadFailDTO.DXFUploadFailDTOBuilder dxfName(final String dxfName) {
         this.dxfName = dxfName;
         return this;
      }

      @JsonProperty("errorMsg")
      public DXFUploadFailDTO.DXFUploadFailDTOBuilder errorMsg(final String errorMsg) {
         this.errorMsg = errorMsg;
         return this;
      }

      public DXFUploadFailDTO build() {
         return new DXFUploadFailDTO(this.dxfName, this.errorMsg);
      }

      @Override
      public String toString() {
         return "DXFUploadFailDTO.DXFUploadFailDTOBuilder(dxfName=" + this.dxfName + ", errorMsg=" + this.errorMsg + ")";
      }
   }
}
