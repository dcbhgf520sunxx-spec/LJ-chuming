package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("OaPurchaseSettleAccountDTOParam")
public class OaPurchaseSettleAccountDTOParam {
   @ApiModelProperty(name = "title ", value = "标题")
   private String title;
   @ApiModelProperty(name = "requestName ", value = "OA审批流程")
   private String requestName;
   @ApiModelProperty(name = "purchaseContractNumber", value = "采购合同编号")
   private String purchaseContractNumber;
   @ApiModelProperty(name = "sqrq", value = "申请日期")
   private String sqrq;
   @ApiModelProperty(name = "sqr", value = "申请人")
   private String sqr;
   @ApiModelProperty(name = "ssbm", value = "申请人部门")
   private String ssbm;
   @ApiModelProperty(name = "szgs", value = "公司")
   private String szgs;
   @ApiModelProperty(name = "xmmc", value = "项目名称")
   private String xmmc;
   @ApiModelProperty(name = "htzt", value = "合同主体")
   private String htzt;
   @ApiModelProperty(name = "jtjbr", value = "具体经办人")
   private String jtjbr;
   @ApiModelProperty(name = "yyfs", value = "用印份数")
   private String yyfs;
   @ApiModelProperty(name = "yynr", value = "用印内容")
   private String yynr;
   @ApiModelProperty(name = "yzlx", value = "用章类型")
   private String yzlx;
   @ApiModelProperty(name = "jyfs", value = "经营方式")
   private String jyfs;
   @ApiModelProperty(name = "jsdx", value = "结算对象")
   private String jsdx;
   @ApiModelProperty(name = "jsje", value = "结算金额")
   private String jsje;
   @ApiModelProperty(name = "bz", value = "备注")
   private String bz;
   @ApiModelProperty(name = "htfj", value = "附件")
   List<OaAttachmentsDTO> htfj;

   public static OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder builder() {
      return new OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder();
   }

   public OaPurchaseSettleAccountDTOParam(
      final String title,
      final String requestName,
      final String purchaseContractNumber,
      final String sqrq,
      final String sqr,
      final String ssbm,
      final String szgs,
      final String xmmc,
      final String htzt,
      final String jtjbr,
      final String yyfs,
      final String yynr,
      final String yzlx,
      final String jyfs,
      final String jsdx,
      final String jsje,
      final String bz,
      final List<OaAttachmentsDTO> htfj
   ) {
      this.title = title;
      this.requestName = requestName;
      this.purchaseContractNumber = purchaseContractNumber;
      this.sqrq = sqrq;
      this.sqr = sqr;
      this.ssbm = ssbm;
      this.szgs = szgs;
      this.xmmc = xmmc;
      this.htzt = htzt;
      this.jtjbr = jtjbr;
      this.yyfs = yyfs;
      this.yynr = yynr;
      this.yzlx = yzlx;
      this.jyfs = jyfs;
      this.jsdx = jsdx;
      this.jsje = jsje;
      this.bz = bz;
      this.htfj = htfj;
   }

   public OaPurchaseSettleAccountDTOParam() {
   }

   public String getTitle() {
      return this.title;
   }

   public String getRequestName() {
      return this.requestName;
   }

   public String getPurchaseContractNumber() {
      return this.purchaseContractNumber;
   }

   public String getSqrq() {
      return this.sqrq;
   }

   public String getSqr() {
      return this.sqr;
   }

   public String getSsbm() {
      return this.ssbm;
   }

   public String getSzgs() {
      return this.szgs;
   }

   public String getXmmc() {
      return this.xmmc;
   }

   public String getHtzt() {
      return this.htzt;
   }

   public String getJtjbr() {
      return this.jtjbr;
   }

   public String getYyfs() {
      return this.yyfs;
   }

   public String getYynr() {
      return this.yynr;
   }

   public String getYzlx() {
      return this.yzlx;
   }

   public String getJyfs() {
      return this.jyfs;
   }

   public String getJsdx() {
      return this.jsdx;
   }

   public String getJsje() {
      return this.jsje;
   }

   public String getBz() {
      return this.bz;
   }

   public List<OaAttachmentsDTO> getHtfj() {
      return this.htfj;
   }

   public OaPurchaseSettleAccountDTOParam setTitle(final String title) {
      this.title = title;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setRequestName(final String requestName) {
      this.requestName = requestName;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setPurchaseContractNumber(final String purchaseContractNumber) {
      this.purchaseContractNumber = purchaseContractNumber;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setSqrq(final String sqrq) {
      this.sqrq = sqrq;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setSqr(final String sqr) {
      this.sqr = sqr;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setSsbm(final String ssbm) {
      this.ssbm = ssbm;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setSzgs(final String szgs) {
      this.szgs = szgs;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setXmmc(final String xmmc) {
      this.xmmc = xmmc;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setHtzt(final String htzt) {
      this.htzt = htzt;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setJtjbr(final String jtjbr) {
      this.jtjbr = jtjbr;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setYyfs(final String yyfs) {
      this.yyfs = yyfs;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setYynr(final String yynr) {
      this.yynr = yynr;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setYzlx(final String yzlx) {
      this.yzlx = yzlx;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setJyfs(final String jyfs) {
      this.jyfs = jyfs;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setJsdx(final String jsdx) {
      this.jsdx = jsdx;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setJsje(final String jsje) {
      this.jsje = jsje;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setBz(final String bz) {
      this.bz = bz;
      return this;
   }

   public OaPurchaseSettleAccountDTOParam setHtfj(final List<OaAttachmentsDTO> htfj) {
      this.htfj = htfj;
      return this;
   }

   @Override
   public String toString() {
      return "OaPurchaseSettleAccountDTOParam(title="
         + this.getTitle()
         + ", requestName="
         + this.getRequestName()
         + ", purchaseContractNumber="
         + this.getPurchaseContractNumber()
         + ", sqrq="
         + this.getSqrq()
         + ", sqr="
         + this.getSqr()
         + ", ssbm="
         + this.getSsbm()
         + ", szgs="
         + this.getSzgs()
         + ", xmmc="
         + this.getXmmc()
         + ", htzt="
         + this.getHtzt()
         + ", jtjbr="
         + this.getJtjbr()
         + ", yyfs="
         + this.getYyfs()
         + ", yynr="
         + this.getYynr()
         + ", yzlx="
         + this.getYzlx()
         + ", jyfs="
         + this.getJyfs()
         + ", jsdx="
         + this.getJsdx()
         + ", jsje="
         + this.getJsje()
         + ", bz="
         + this.getBz()
         + ", htfj="
         + this.getHtfj()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaPurchaseSettleAccountDTOParam)) {
         return false;
      }

      OaPurchaseSettleAccountDTOParam other = (OaPurchaseSettleAccountDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$title = this.getTitle();
      Object other$title = other.getTitle();
      if (this$title == null ? other$title == null : this$title.equals(other$title)) {
         Object this$requestName = this.getRequestName();
         Object other$requestName = other.getRequestName();
         if (this$requestName == null ? other$requestName == null : this$requestName.equals(other$requestName)) {
            Object this$purchaseContractNumber = this.getPurchaseContractNumber();
            Object other$purchaseContractNumber = other.getPurchaseContractNumber();
            if (this$purchaseContractNumber == null ? other$purchaseContractNumber == null : this$purchaseContractNumber.equals(other$purchaseContractNumber)) {
               Object this$sqrq = this.getSqrq();
               Object other$sqrq = other.getSqrq();
               if (this$sqrq == null ? other$sqrq == null : this$sqrq.equals(other$sqrq)) {
                  Object this$sqr = this.getSqr();
                  Object other$sqr = other.getSqr();
                  if (this$sqr == null ? other$sqr == null : this$sqr.equals(other$sqr)) {
                     Object this$ssbm = this.getSsbm();
                     Object other$ssbm = other.getSsbm();
                     if (this$ssbm == null ? other$ssbm == null : this$ssbm.equals(other$ssbm)) {
                        Object this$szgs = this.getSzgs();
                        Object other$szgs = other.getSzgs();
                        if (this$szgs == null ? other$szgs == null : this$szgs.equals(other$szgs)) {
                           Object this$xmmc = this.getXmmc();
                           Object other$xmmc = other.getXmmc();
                           if (this$xmmc == null ? other$xmmc == null : this$xmmc.equals(other$xmmc)) {
                              Object this$htzt = this.getHtzt();
                              Object other$htzt = other.getHtzt();
                              if (this$htzt == null ? other$htzt == null : this$htzt.equals(other$htzt)) {
                                 Object this$jtjbr = this.getJtjbr();
                                 Object other$jtjbr = other.getJtjbr();
                                 if (this$jtjbr == null ? other$jtjbr == null : this$jtjbr.equals(other$jtjbr)) {
                                    Object this$yyfs = this.getYyfs();
                                    Object other$yyfs = other.getYyfs();
                                    if (this$yyfs == null ? other$yyfs == null : this$yyfs.equals(other$yyfs)) {
                                       Object this$yynr = this.getYynr();
                                       Object other$yynr = other.getYynr();
                                       if (this$yynr == null ? other$yynr == null : this$yynr.equals(other$yynr)) {
                                          Object this$yzlx = this.getYzlx();
                                          Object other$yzlx = other.getYzlx();
                                          if (this$yzlx == null ? other$yzlx == null : this$yzlx.equals(other$yzlx)) {
                                             Object this$jyfs = this.getJyfs();
                                             Object other$jyfs = other.getJyfs();
                                             if (this$jyfs == null ? other$jyfs == null : this$jyfs.equals(other$jyfs)) {
                                                Object this$jsdx = this.getJsdx();
                                                Object other$jsdx = other.getJsdx();
                                                if (this$jsdx == null ? other$jsdx == null : this$jsdx.equals(other$jsdx)) {
                                                   Object this$jsje = this.getJsje();
                                                   Object other$jsje = other.getJsje();
                                                   if (this$jsje == null ? other$jsje == null : this$jsje.equals(other$jsje)) {
                                                      Object this$bz = this.getBz();
                                                      Object other$bz = other.getBz();
                                                      if (this$bz == null ? other$bz == null : this$bz.equals(other$bz)) {
                                                         Object this$htfj = this.getHtfj();
                                                         Object other$htfj = other.getHtfj();
                                                         return this$htfj == null ? other$htfj == null : this$htfj.equals(other$htfj);
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
      return other instanceof OaPurchaseSettleAccountDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $requestName = this.getRequestName();
      result = result * 59 + ($requestName == null ? 43 : $requestName.hashCode());
      Object $purchaseContractNumber = this.getPurchaseContractNumber();
      result = result * 59 + ($purchaseContractNumber == null ? 43 : $purchaseContractNumber.hashCode());
      Object $sqrq = this.getSqrq();
      result = result * 59 + ($sqrq == null ? 43 : $sqrq.hashCode());
      Object $sqr = this.getSqr();
      result = result * 59 + ($sqr == null ? 43 : $sqr.hashCode());
      Object $ssbm = this.getSsbm();
      result = result * 59 + ($ssbm == null ? 43 : $ssbm.hashCode());
      Object $szgs = this.getSzgs();
      result = result * 59 + ($szgs == null ? 43 : $szgs.hashCode());
      Object $xmmc = this.getXmmc();
      result = result * 59 + ($xmmc == null ? 43 : $xmmc.hashCode());
      Object $htzt = this.getHtzt();
      result = result * 59 + ($htzt == null ? 43 : $htzt.hashCode());
      Object $jtjbr = this.getJtjbr();
      result = result * 59 + ($jtjbr == null ? 43 : $jtjbr.hashCode());
      Object $yyfs = this.getYyfs();
      result = result * 59 + ($yyfs == null ? 43 : $yyfs.hashCode());
      Object $yynr = this.getYynr();
      result = result * 59 + ($yynr == null ? 43 : $yynr.hashCode());
      Object $yzlx = this.getYzlx();
      result = result * 59 + ($yzlx == null ? 43 : $yzlx.hashCode());
      Object $jyfs = this.getJyfs();
      result = result * 59 + ($jyfs == null ? 43 : $jyfs.hashCode());
      Object $jsdx = this.getJsdx();
      result = result * 59 + ($jsdx == null ? 43 : $jsdx.hashCode());
      Object $jsje = this.getJsje();
      result = result * 59 + ($jsje == null ? 43 : $jsje.hashCode());
      Object $bz = this.getBz();
      result = result * 59 + ($bz == null ? 43 : $bz.hashCode());
      Object $htfj = this.getHtfj();
      return result * 59 + ($htfj == null ? 43 : $htfj.hashCode());
   }

   public static class OaPurchaseSettleAccountDTOParamBuilder {
      private String title;
      private String requestName;
      private String purchaseContractNumber;
      private String sqrq;
      private String sqr;
      private String ssbm;
      private String szgs;
      private String xmmc;
      private String htzt;
      private String jtjbr;
      private String yyfs;
      private String yynr;
      private String yzlx;
      private String jyfs;
      private String jsdx;
      private String jsje;
      private String bz;
      private List<OaAttachmentsDTO> htfj;

      OaPurchaseSettleAccountDTOParamBuilder() {
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder purchaseContractNumber(final String purchaseContractNumber) {
         this.purchaseContractNumber = purchaseContractNumber;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder sqrq(final String sqrq) {
         this.sqrq = sqrq;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder sqr(final String sqr) {
         this.sqr = sqr;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder ssbm(final String ssbm) {
         this.ssbm = ssbm;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder szgs(final String szgs) {
         this.szgs = szgs;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder xmmc(final String xmmc) {
         this.xmmc = xmmc;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder htzt(final String htzt) {
         this.htzt = htzt;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder jtjbr(final String jtjbr) {
         this.jtjbr = jtjbr;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder yyfs(final String yyfs) {
         this.yyfs = yyfs;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder yynr(final String yynr) {
         this.yynr = yynr;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder yzlx(final String yzlx) {
         this.yzlx = yzlx;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder jyfs(final String jyfs) {
         this.jyfs = jyfs;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder jsdx(final String jsdx) {
         this.jsdx = jsdx;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder jsje(final String jsje) {
         this.jsje = jsje;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder bz(final String bz) {
         this.bz = bz;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder htfj(final List<OaAttachmentsDTO> htfj) {
         this.htfj = htfj;
         return this;
      }

      public OaPurchaseSettleAccountDTOParam build() {
         return new OaPurchaseSettleAccountDTOParam(
            this.title,
            this.requestName,
            this.purchaseContractNumber,
            this.sqrq,
            this.sqr,
            this.ssbm,
            this.szgs,
            this.xmmc,
            this.htzt,
            this.jtjbr,
            this.yyfs,
            this.yynr,
            this.yzlx,
            this.jyfs,
            this.jsdx,
            this.jsje,
            this.bz,
            this.htfj
         );
      }

      @Override
      public String toString() {
         return "OaPurchaseSettleAccountDTOParam.OaPurchaseSettleAccountDTOParamBuilder(title="
            + this.title
            + ", requestName="
            + this.requestName
            + ", purchaseContractNumber="
            + this.purchaseContractNumber
            + ", sqrq="
            + this.sqrq
            + ", sqr="
            + this.sqr
            + ", ssbm="
            + this.ssbm
            + ", szgs="
            + this.szgs
            + ", xmmc="
            + this.xmmc
            + ", htzt="
            + this.htzt
            + ", jtjbr="
            + this.jtjbr
            + ", yyfs="
            + this.yyfs
            + ", yynr="
            + this.yynr
            + ", yzlx="
            + this.yzlx
            + ", jyfs="
            + this.jyfs
            + ", jsdx="
            + this.jsdx
            + ", jsje="
            + this.jsje
            + ", bz="
            + this.bz
            + ", htfj="
            + this.htfj
            + ")";
      }
   }
}
