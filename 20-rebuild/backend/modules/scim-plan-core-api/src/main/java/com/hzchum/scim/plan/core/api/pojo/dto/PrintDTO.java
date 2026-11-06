package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApiModel("打印返回数据")
public class PrintDTO {
   @ApiModelProperty(name = "header", notes = "表头")
   private Map<String, Object> header;
   @ApiModelProperty(name = "qrCode", notes = "二维码")
   private String qrCode;
   @ApiModelProperty(name = "table", notes = "下载的表数据")
   private List<Map<String, Object>> table;
   @ApiModelProperty(name = "footer", notes = "表尾")
   private Map<String, Object> footer;

   public Map<String, Object> initHeader(String name) {
      Map<String, Object> header = new HashMap<>();
      header.put("printDate", LocalDateTime.now());
      header.put("printer", name);
      return header;
   }

   public Map<String, Object> getHeader() {
      return this.header;
   }

   public String getQrCode() {
      return this.qrCode;
   }

   public List<Map<String, Object>> getTable() {
      return this.table;
   }

   public Map<String, Object> getFooter() {
      return this.footer;
   }

   public void setHeader(final Map<String, Object> header) {
      this.header = header;
   }

   public void setQrCode(final String qrCode) {
      this.qrCode = qrCode;
   }

   public void setTable(final List<Map<String, Object>> table) {
      this.table = table;
   }

   public void setFooter(final Map<String, Object> footer) {
      this.footer = footer;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PrintDTO)) {
         return false;
      }

      PrintDTO other = (PrintDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$header = this.getHeader();
      Object other$header = other.getHeader();
      if (this$header == null ? other$header == null : this$header.equals(other$header)) {
         Object this$qrCode = this.getQrCode();
         Object other$qrCode = other.getQrCode();
         if (this$qrCode == null ? other$qrCode == null : this$qrCode.equals(other$qrCode)) {
            Object this$table = this.getTable();
            Object other$table = other.getTable();
            if (this$table == null ? other$table == null : this$table.equals(other$table)) {
               Object this$footer = this.getFooter();
               Object other$footer = other.getFooter();
               return this$footer == null ? other$footer == null : this$footer.equals(other$footer);
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
      return other instanceof PrintDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $header = this.getHeader();
      result = result * 59 + ($header == null ? 43 : $header.hashCode());
      Object $qrCode = this.getQrCode();
      result = result * 59 + ($qrCode == null ? 43 : $qrCode.hashCode());
      Object $table = this.getTable();
      result = result * 59 + ($table == null ? 43 : $table.hashCode());
      Object $footer = this.getFooter();
      return result * 59 + ($footer == null ? 43 : $footer.hashCode());
   }

   @Override
   public String toString() {
      return "PrintDTO(header=" + this.getHeader() + ", qrCode=" + this.getQrCode() + ", table=" + this.getTable() + ", footer=" + this.getFooter() + ")";
   }
}
