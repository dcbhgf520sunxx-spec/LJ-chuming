package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class OaDeepenDrawingDTOParam {
   @ApiModelProperty(name = "title ", value = "标题")
   private String title = "深化图纸文件盖章审批单";
   @ApiModelProperty(name = "requestName ", value = "OA审批流程")
   private String requestName = "深化图纸文件盖章审批流程（初鸣）";
   @ApiModelProperty(name = "sqr", value = "申请人")
   private String sqr;
   @ApiModelProperty(name = "sqrszgs ", value = "申请人所属公司")
   private String sqrszgs;
   @ApiModelProperty(name = "xmmc", value = "项目名称")
   private String xmmc;
   @ApiModelProperty(name = "yzlx", value = "用章类型")
   private String yzlx;
   @ApiModelProperty(name = "cplx", value = "产品类型")
   private String cplx;
   @ApiModelProperty(name = "jtjbr", value = "具体经办人")
   private String jtjbr;
   @ApiModelProperty(name = "sqrq", value = "申请日期")
   private String sqrq;
   @ApiModelProperty(name = "sqrszbm", value = "申请人所属部门")
   private String sqrszbm;
   @ApiModelProperty(name = "dtmc", value = "单体名称")
   private String dtmc;
   @ApiModelProperty(name = "yyfs", value = "用印份数")
   private String yyfs;
   @ApiModelProperty(name = "szxz", value = "所属小组 0：一组  1：二组  2：三组")
   private String szxz;
   @ApiModelProperty(name = "bz", value = "备注")
   private String bz;
   @ApiModelProperty(name = "fj", value = "附件")
   List<OaAttachmentsDTO> fj;

   public static OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder builder() {
      return new OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder();
   }

   public OaDeepenDrawingDTOParam(
      final String title,
      final String requestName,
      final String sqr,
      final String sqrszgs,
      final String xmmc,
      final String yzlx,
      final String cplx,
      final String jtjbr,
      final String sqrq,
      final String sqrszbm,
      final String dtmc,
      final String yyfs,
      final String szxz,
      final String bz,
      final List<OaAttachmentsDTO> fj
   ) {
      this.title = title;
      this.requestName = requestName;
      this.sqr = sqr;
      this.sqrszgs = sqrszgs;
      this.xmmc = xmmc;
      this.yzlx = yzlx;
      this.cplx = cplx;
      this.jtjbr = jtjbr;
      this.sqrq = sqrq;
      this.sqrszbm = sqrszbm;
      this.dtmc = dtmc;
      this.yyfs = yyfs;
      this.szxz = szxz;
      this.bz = bz;
      this.fj = fj;
   }

   public OaDeepenDrawingDTOParam() {
   }

   public String getTitle() {
      return this.title;
   }

   public String getRequestName() {
      return this.requestName;
   }

   public String getSqr() {
      return this.sqr;
   }

   public String getSqrszgs() {
      return this.sqrszgs;
   }

   public String getXmmc() {
      return this.xmmc;
   }

   public String getYzlx() {
      return this.yzlx;
   }

   public String getCplx() {
      return this.cplx;
   }

   public String getJtjbr() {
      return this.jtjbr;
   }

   public String getSqrq() {
      return this.sqrq;
   }

   public String getSqrszbm() {
      return this.sqrszbm;
   }

   public String getDtmc() {
      return this.dtmc;
   }

   public String getYyfs() {
      return this.yyfs;
   }

   public String getSzxz() {
      return this.szxz;
   }

   public String getBz() {
      return this.bz;
   }

   public List<OaAttachmentsDTO> getFj() {
      return this.fj;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public void setRequestName(final String requestName) {
      this.requestName = requestName;
   }

   public void setSqr(final String sqr) {
      this.sqr = sqr;
   }

   public void setSqrszgs(final String sqrszgs) {
      this.sqrszgs = sqrszgs;
   }

   public void setXmmc(final String xmmc) {
      this.xmmc = xmmc;
   }

   public void setYzlx(final String yzlx) {
      this.yzlx = yzlx;
   }

   public void setCplx(final String cplx) {
      this.cplx = cplx;
   }

   public void setJtjbr(final String jtjbr) {
      this.jtjbr = jtjbr;
   }

   public void setSqrq(final String sqrq) {
      this.sqrq = sqrq;
   }

   public void setSqrszbm(final String sqrszbm) {
      this.sqrszbm = sqrszbm;
   }

   public void setDtmc(final String dtmc) {
      this.dtmc = dtmc;
   }

   public void setYyfs(final String yyfs) {
      this.yyfs = yyfs;
   }

   public void setSzxz(final String szxz) {
      this.szxz = szxz;
   }

   public void setBz(final String bz) {
      this.bz = bz;
   }

   public void setFj(final List<OaAttachmentsDTO> fj) {
      this.fj = fj;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaDeepenDrawingDTOParam)) {
         return false;
      }

      OaDeepenDrawingDTOParam other = (OaDeepenDrawingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$title = this.getTitle();
      Object other$title = other.getTitle();
      if (this$title == null ? other$title == null : this$title.equals(other$title)) {
         Object this$requestName = this.getRequestName();
         Object other$requestName = other.getRequestName();
         if (this$requestName == null ? other$requestName == null : this$requestName.equals(other$requestName)) {
            Object this$sqr = this.getSqr();
            Object other$sqr = other.getSqr();
            if (this$sqr == null ? other$sqr == null : this$sqr.equals(other$sqr)) {
               Object this$sqrszgs = this.getSqrszgs();
               Object other$sqrszgs = other.getSqrszgs();
               if (this$sqrszgs == null ? other$sqrszgs == null : this$sqrszgs.equals(other$sqrszgs)) {
                  Object this$xmmc = this.getXmmc();
                  Object other$xmmc = other.getXmmc();
                  if (this$xmmc == null ? other$xmmc == null : this$xmmc.equals(other$xmmc)) {
                     Object this$yzlx = this.getYzlx();
                     Object other$yzlx = other.getYzlx();
                     if (this$yzlx == null ? other$yzlx == null : this$yzlx.equals(other$yzlx)) {
                        Object this$cplx = this.getCplx();
                        Object other$cplx = other.getCplx();
                        if (this$cplx == null ? other$cplx == null : this$cplx.equals(other$cplx)) {
                           Object this$jtjbr = this.getJtjbr();
                           Object other$jtjbr = other.getJtjbr();
                           if (this$jtjbr == null ? other$jtjbr == null : this$jtjbr.equals(other$jtjbr)) {
                              Object this$sqrq = this.getSqrq();
                              Object other$sqrq = other.getSqrq();
                              if (this$sqrq == null ? other$sqrq == null : this$sqrq.equals(other$sqrq)) {
                                 Object this$sqrszbm = this.getSqrszbm();
                                 Object other$sqrszbm = other.getSqrszbm();
                                 if (this$sqrszbm == null ? other$sqrszbm == null : this$sqrszbm.equals(other$sqrszbm)) {
                                    Object this$dtmc = this.getDtmc();
                                    Object other$dtmc = other.getDtmc();
                                    if (this$dtmc == null ? other$dtmc == null : this$dtmc.equals(other$dtmc)) {
                                       Object this$yyfs = this.getYyfs();
                                       Object other$yyfs = other.getYyfs();
                                       if (this$yyfs == null ? other$yyfs == null : this$yyfs.equals(other$yyfs)) {
                                          Object this$szxz = this.getSzxz();
                                          Object other$szxz = other.getSzxz();
                                          if (this$szxz == null ? other$szxz == null : this$szxz.equals(other$szxz)) {
                                             Object this$bz = this.getBz();
                                             Object other$bz = other.getBz();
                                             if (this$bz == null ? other$bz == null : this$bz.equals(other$bz)) {
                                                Object this$fj = this.getFj();
                                                Object other$fj = other.getFj();
                                                return this$fj == null ? other$fj == null : this$fj.equals(other$fj);
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
      return other instanceof OaDeepenDrawingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $requestName = this.getRequestName();
      result = result * 59 + ($requestName == null ? 43 : $requestName.hashCode());
      Object $sqr = this.getSqr();
      result = result * 59 + ($sqr == null ? 43 : $sqr.hashCode());
      Object $sqrszgs = this.getSqrszgs();
      result = result * 59 + ($sqrszgs == null ? 43 : $sqrszgs.hashCode());
      Object $xmmc = this.getXmmc();
      result = result * 59 + ($xmmc == null ? 43 : $xmmc.hashCode());
      Object $yzlx = this.getYzlx();
      result = result * 59 + ($yzlx == null ? 43 : $yzlx.hashCode());
      Object $cplx = this.getCplx();
      result = result * 59 + ($cplx == null ? 43 : $cplx.hashCode());
      Object $jtjbr = this.getJtjbr();
      result = result * 59 + ($jtjbr == null ? 43 : $jtjbr.hashCode());
      Object $sqrq = this.getSqrq();
      result = result * 59 + ($sqrq == null ? 43 : $sqrq.hashCode());
      Object $sqrszbm = this.getSqrszbm();
      result = result * 59 + ($sqrszbm == null ? 43 : $sqrszbm.hashCode());
      Object $dtmc = this.getDtmc();
      result = result * 59 + ($dtmc == null ? 43 : $dtmc.hashCode());
      Object $yyfs = this.getYyfs();
      result = result * 59 + ($yyfs == null ? 43 : $yyfs.hashCode());
      Object $szxz = this.getSzxz();
      result = result * 59 + ($szxz == null ? 43 : $szxz.hashCode());
      Object $bz = this.getBz();
      result = result * 59 + ($bz == null ? 43 : $bz.hashCode());
      Object $fj = this.getFj();
      return result * 59 + ($fj == null ? 43 : $fj.hashCode());
   }

   @Override
   public String toString() {
      return "OaDeepenDrawingDTOParam(title="
         + this.getTitle()
         + ", requestName="
         + this.getRequestName()
         + ", sqr="
         + this.getSqr()
         + ", sqrszgs="
         + this.getSqrszgs()
         + ", xmmc="
         + this.getXmmc()
         + ", yzlx="
         + this.getYzlx()
         + ", cplx="
         + this.getCplx()
         + ", jtjbr="
         + this.getJtjbr()
         + ", sqrq="
         + this.getSqrq()
         + ", sqrszbm="
         + this.getSqrszbm()
         + ", dtmc="
         + this.getDtmc()
         + ", yyfs="
         + this.getYyfs()
         + ", szxz="
         + this.getSzxz()
         + ", bz="
         + this.getBz()
         + ", fj="
         + this.getFj()
         + ")";
   }

   public static class OaDeepenDrawingDTOParamBuilder {
      private String title;
      private String requestName;
      private String sqr;
      private String sqrszgs;
      private String xmmc;
      private String yzlx;
      private String cplx;
      private String jtjbr;
      private String sqrq;
      private String sqrszbm;
      private String dtmc;
      private String yyfs;
      private String szxz;
      private String bz;
      private List<OaAttachmentsDTO> fj;

      OaDeepenDrawingDTOParamBuilder() {
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder sqr(final String sqr) {
         this.sqr = sqr;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder sqrszgs(final String sqrszgs) {
         this.sqrszgs = sqrszgs;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder xmmc(final String xmmc) {
         this.xmmc = xmmc;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder yzlx(final String yzlx) {
         this.yzlx = yzlx;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder cplx(final String cplx) {
         this.cplx = cplx;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder jtjbr(final String jtjbr) {
         this.jtjbr = jtjbr;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder sqrq(final String sqrq) {
         this.sqrq = sqrq;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder sqrszbm(final String sqrszbm) {
         this.sqrszbm = sqrszbm;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder dtmc(final String dtmc) {
         this.dtmc = dtmc;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder yyfs(final String yyfs) {
         this.yyfs = yyfs;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder szxz(final String szxz) {
         this.szxz = szxz;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder bz(final String bz) {
         this.bz = bz;
         return this;
      }

      public OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder fj(final List<OaAttachmentsDTO> fj) {
         this.fj = fj;
         return this;
      }

      public OaDeepenDrawingDTOParam build() {
         return new OaDeepenDrawingDTOParam(
            this.title,
            this.requestName,
            this.sqr,
            this.sqrszgs,
            this.xmmc,
            this.yzlx,
            this.cplx,
            this.jtjbr,
            this.sqrq,
            this.sqrszbm,
            this.dtmc,
            this.yyfs,
            this.szxz,
            this.bz,
            this.fj
         );
      }

      @Override
      public String toString() {
         return "OaDeepenDrawingDTOParam.OaDeepenDrawingDTOParamBuilder(title="
            + this.title
            + ", requestName="
            + this.requestName
            + ", sqr="
            + this.sqr
            + ", sqrszgs="
            + this.sqrszgs
            + ", xmmc="
            + this.xmmc
            + ", yzlx="
            + this.yzlx
            + ", cplx="
            + this.cplx
            + ", jtjbr="
            + this.jtjbr
            + ", sqrq="
            + this.sqrq
            + ", sqrszbm="
            + this.sqrszbm
            + ", dtmc="
            + this.dtmc
            + ", yyfs="
            + this.yyfs
            + ", szxz="
            + this.szxz
            + ", bz="
            + this.bz
            + ", fj="
            + this.fj
            + ")";
      }
   }
}
