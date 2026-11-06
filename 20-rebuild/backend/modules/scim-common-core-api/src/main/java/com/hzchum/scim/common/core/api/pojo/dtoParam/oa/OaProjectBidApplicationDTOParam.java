package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("OaProjectBidApplicationDTOParam")
public class OaProjectBidApplicationDTOParam {
   private String requestName;
   private String title;
   @ApiModelProperty("招标单位")
   private String zbdw;
   @ApiModelProperty("申请日期")
   private String sqrq;
   @ApiModelProperty("申请人")
   private String sqr;
   @ApiModelProperty("附件")
   private List<OaAttachmentsDTO> fj;
   @ApiModelProperty("备注")
   private String bz;
   @ApiModelProperty("申请人所属公司")
   private String sqrszgs;
   @ApiModelProperty("申请人所属部门")
   private String sqrszbm;
   @ApiModelProperty("项目名称")
   private String xmmc;
   @ApiModelProperty("招标方式")
   private String zbfs;
   @ApiModelProperty("招标规定")
   private String zbgd;
   @ApiModelProperty("标书提交方式")
   private String bstjfs;
   @ApiModelProperty("投标截止日")
   private String tbjzr;
   @ApiModelProperty("开标时间")
   private String kbsj;
   @ApiModelProperty("评标方式")
   private String pbfs;
   @ApiModelProperty("招标控制价（万元）")
   private String zbkzjwy;
   @ApiModelProperty("投标保证金额（万元）")
   private String tbbzjewy;
   @ApiModelProperty("投标保证金截止日")
   private String tbbzjjzr;
   @ApiModelProperty("材料调差")
   private String cldc;
   @ApiModelProperty("付款方式")
   private String fkfs;
   @ApiModelProperty("标书需求")
   private String bsxq;

   public static OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder builder() {
      return new OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder();
   }

   public String getRequestName() {
      return this.requestName;
   }

   public String getTitle() {
      return this.title;
   }

   public String getZbdw() {
      return this.zbdw;
   }

   public String getSqrq() {
      return this.sqrq;
   }

   public String getSqr() {
      return this.sqr;
   }

   public List<OaAttachmentsDTO> getFj() {
      return this.fj;
   }

   public String getBz() {
      return this.bz;
   }

   public String getSqrszgs() {
      return this.sqrszgs;
   }

   public String getSqrszbm() {
      return this.sqrszbm;
   }

   public String getXmmc() {
      return this.xmmc;
   }

   public String getZbfs() {
      return this.zbfs;
   }

   public String getZbgd() {
      return this.zbgd;
   }

   public String getBstjfs() {
      return this.bstjfs;
   }

   public String getTbjzr() {
      return this.tbjzr;
   }

   public String getKbsj() {
      return this.kbsj;
   }

   public String getPbfs() {
      return this.pbfs;
   }

   public String getZbkzjwy() {
      return this.zbkzjwy;
   }

   public String getTbbzjewy() {
      return this.tbbzjewy;
   }

   public String getTbbzjjzr() {
      return this.tbbzjjzr;
   }

   public String getCldc() {
      return this.cldc;
   }

   public String getFkfs() {
      return this.fkfs;
   }

   public String getBsxq() {
      return this.bsxq;
   }

   public void setRequestName(final String requestName) {
      this.requestName = requestName;
   }

   public void setTitle(final String title) {
      this.title = title;
   }

   public void setZbdw(final String zbdw) {
      this.zbdw = zbdw;
   }

   public void setSqrq(final String sqrq) {
      this.sqrq = sqrq;
   }

   public void setSqr(final String sqr) {
      this.sqr = sqr;
   }

   public void setFj(final List<OaAttachmentsDTO> fj) {
      this.fj = fj;
   }

   public void setBz(final String bz) {
      this.bz = bz;
   }

   public void setSqrszgs(final String sqrszgs) {
      this.sqrszgs = sqrszgs;
   }

   public void setSqrszbm(final String sqrszbm) {
      this.sqrszbm = sqrszbm;
   }

   public void setXmmc(final String xmmc) {
      this.xmmc = xmmc;
   }

   public void setZbfs(final String zbfs) {
      this.zbfs = zbfs;
   }

   public void setZbgd(final String zbgd) {
      this.zbgd = zbgd;
   }

   public void setBstjfs(final String bstjfs) {
      this.bstjfs = bstjfs;
   }

   public void setTbjzr(final String tbjzr) {
      this.tbjzr = tbjzr;
   }

   public void setKbsj(final String kbsj) {
      this.kbsj = kbsj;
   }

   public void setPbfs(final String pbfs) {
      this.pbfs = pbfs;
   }

   public void setZbkzjwy(final String zbkzjwy) {
      this.zbkzjwy = zbkzjwy;
   }

   public void setTbbzjewy(final String tbbzjewy) {
      this.tbbzjewy = tbbzjewy;
   }

   public void setTbbzjjzr(final String tbbzjjzr) {
      this.tbbzjjzr = tbbzjjzr;
   }

   public void setCldc(final String cldc) {
      this.cldc = cldc;
   }

   public void setFkfs(final String fkfs) {
      this.fkfs = fkfs;
   }

   public void setBsxq(final String bsxq) {
      this.bsxq = bsxq;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaProjectBidApplicationDTOParam)) {
         return false;
      }

      OaProjectBidApplicationDTOParam other = (OaProjectBidApplicationDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$requestName = this.getRequestName();
      Object other$requestName = other.getRequestName();
      if (this$requestName == null ? other$requestName == null : this$requestName.equals(other$requestName)) {
         Object this$title = this.getTitle();
         Object other$title = other.getTitle();
         if (this$title == null ? other$title == null : this$title.equals(other$title)) {
            Object this$zbdw = this.getZbdw();
            Object other$zbdw = other.getZbdw();
            if (this$zbdw == null ? other$zbdw == null : this$zbdw.equals(other$zbdw)) {
               Object this$sqrq = this.getSqrq();
               Object other$sqrq = other.getSqrq();
               if (this$sqrq == null ? other$sqrq == null : this$sqrq.equals(other$sqrq)) {
                  Object this$sqr = this.getSqr();
                  Object other$sqr = other.getSqr();
                  if (this$sqr == null ? other$sqr == null : this$sqr.equals(other$sqr)) {
                     Object this$fj = this.getFj();
                     Object other$fj = other.getFj();
                     if (this$fj == null ? other$fj == null : this$fj.equals(other$fj)) {
                        Object this$bz = this.getBz();
                        Object other$bz = other.getBz();
                        if (this$bz == null ? other$bz == null : this$bz.equals(other$bz)) {
                           Object this$sqrszgs = this.getSqrszgs();
                           Object other$sqrszgs = other.getSqrszgs();
                           if (this$sqrszgs == null ? other$sqrszgs == null : this$sqrszgs.equals(other$sqrszgs)) {
                              Object this$sqrszbm = this.getSqrszbm();
                              Object other$sqrszbm = other.getSqrszbm();
                              if (this$sqrszbm == null ? other$sqrszbm == null : this$sqrszbm.equals(other$sqrszbm)) {
                                 Object this$xmmc = this.getXmmc();
                                 Object other$xmmc = other.getXmmc();
                                 if (this$xmmc == null ? other$xmmc == null : this$xmmc.equals(other$xmmc)) {
                                    Object this$zbfs = this.getZbfs();
                                    Object other$zbfs = other.getZbfs();
                                    if (this$zbfs == null ? other$zbfs == null : this$zbfs.equals(other$zbfs)) {
                                       Object this$zbgd = this.getZbgd();
                                       Object other$zbgd = other.getZbgd();
                                       if (this$zbgd == null ? other$zbgd == null : this$zbgd.equals(other$zbgd)) {
                                          Object this$bstjfs = this.getBstjfs();
                                          Object other$bstjfs = other.getBstjfs();
                                          if (this$bstjfs == null ? other$bstjfs == null : this$bstjfs.equals(other$bstjfs)) {
                                             Object this$tbjzr = this.getTbjzr();
                                             Object other$tbjzr = other.getTbjzr();
                                             if (this$tbjzr == null ? other$tbjzr == null : this$tbjzr.equals(other$tbjzr)) {
                                                Object this$kbsj = this.getKbsj();
                                                Object other$kbsj = other.getKbsj();
                                                if (this$kbsj == null ? other$kbsj == null : this$kbsj.equals(other$kbsj)) {
                                                   Object this$pbfs = this.getPbfs();
                                                   Object other$pbfs = other.getPbfs();
                                                   if (this$pbfs == null ? other$pbfs == null : this$pbfs.equals(other$pbfs)) {
                                                      Object this$zbkzjwy = this.getZbkzjwy();
                                                      Object other$zbkzjwy = other.getZbkzjwy();
                                                      if (this$zbkzjwy == null ? other$zbkzjwy == null : this$zbkzjwy.equals(other$zbkzjwy)) {
                                                         Object this$tbbzjewy = this.getTbbzjewy();
                                                         Object other$tbbzjewy = other.getTbbzjewy();
                                                         if (this$tbbzjewy == null ? other$tbbzjewy == null : this$tbbzjewy.equals(other$tbbzjewy)) {
                                                            Object this$tbbzjjzr = this.getTbbzjjzr();
                                                            Object other$tbbzjjzr = other.getTbbzjjzr();
                                                            if (this$tbbzjjzr == null ? other$tbbzjjzr == null : this$tbbzjjzr.equals(other$tbbzjjzr)) {
                                                               Object this$cldc = this.getCldc();
                                                               Object other$cldc = other.getCldc();
                                                               if (this$cldc == null ? other$cldc == null : this$cldc.equals(other$cldc)) {
                                                                  Object this$fkfs = this.getFkfs();
                                                                  Object other$fkfs = other.getFkfs();
                                                                  if (this$fkfs == null ? other$fkfs == null : this$fkfs.equals(other$fkfs)) {
                                                                     Object this$bsxq = this.getBsxq();
                                                                     Object other$bsxq = other.getBsxq();
                                                                     return this$bsxq == null ? other$bsxq == null : this$bsxq.equals(other$bsxq);
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
      return other instanceof OaProjectBidApplicationDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $requestName = this.getRequestName();
      result = result * 59 + ($requestName == null ? 43 : $requestName.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $zbdw = this.getZbdw();
      result = result * 59 + ($zbdw == null ? 43 : $zbdw.hashCode());
      Object $sqrq = this.getSqrq();
      result = result * 59 + ($sqrq == null ? 43 : $sqrq.hashCode());
      Object $sqr = this.getSqr();
      result = result * 59 + ($sqr == null ? 43 : $sqr.hashCode());
      Object $fj = this.getFj();
      result = result * 59 + ($fj == null ? 43 : $fj.hashCode());
      Object $bz = this.getBz();
      result = result * 59 + ($bz == null ? 43 : $bz.hashCode());
      Object $sqrszgs = this.getSqrszgs();
      result = result * 59 + ($sqrszgs == null ? 43 : $sqrszgs.hashCode());
      Object $sqrszbm = this.getSqrszbm();
      result = result * 59 + ($sqrszbm == null ? 43 : $sqrszbm.hashCode());
      Object $xmmc = this.getXmmc();
      result = result * 59 + ($xmmc == null ? 43 : $xmmc.hashCode());
      Object $zbfs = this.getZbfs();
      result = result * 59 + ($zbfs == null ? 43 : $zbfs.hashCode());
      Object $zbgd = this.getZbgd();
      result = result * 59 + ($zbgd == null ? 43 : $zbgd.hashCode());
      Object $bstjfs = this.getBstjfs();
      result = result * 59 + ($bstjfs == null ? 43 : $bstjfs.hashCode());
      Object $tbjzr = this.getTbjzr();
      result = result * 59 + ($tbjzr == null ? 43 : $tbjzr.hashCode());
      Object $kbsj = this.getKbsj();
      result = result * 59 + ($kbsj == null ? 43 : $kbsj.hashCode());
      Object $pbfs = this.getPbfs();
      result = result * 59 + ($pbfs == null ? 43 : $pbfs.hashCode());
      Object $zbkzjwy = this.getZbkzjwy();
      result = result * 59 + ($zbkzjwy == null ? 43 : $zbkzjwy.hashCode());
      Object $tbbzjewy = this.getTbbzjewy();
      result = result * 59 + ($tbbzjewy == null ? 43 : $tbbzjewy.hashCode());
      Object $tbbzjjzr = this.getTbbzjjzr();
      result = result * 59 + ($tbbzjjzr == null ? 43 : $tbbzjjzr.hashCode());
      Object $cldc = this.getCldc();
      result = result * 59 + ($cldc == null ? 43 : $cldc.hashCode());
      Object $fkfs = this.getFkfs();
      result = result * 59 + ($fkfs == null ? 43 : $fkfs.hashCode());
      Object $bsxq = this.getBsxq();
      return result * 59 + ($bsxq == null ? 43 : $bsxq.hashCode());
   }

   @Override
   public String toString() {
      return "OaProjectBidApplicationDTOParam(requestName="
         + this.getRequestName()
         + ", title="
         + this.getTitle()
         + ", zbdw="
         + this.getZbdw()
         + ", sqrq="
         + this.getSqrq()
         + ", sqr="
         + this.getSqr()
         + ", fj="
         + this.getFj()
         + ", bz="
         + this.getBz()
         + ", sqrszgs="
         + this.getSqrszgs()
         + ", sqrszbm="
         + this.getSqrszbm()
         + ", xmmc="
         + this.getXmmc()
         + ", zbfs="
         + this.getZbfs()
         + ", zbgd="
         + this.getZbgd()
         + ", bstjfs="
         + this.getBstjfs()
         + ", tbjzr="
         + this.getTbjzr()
         + ", kbsj="
         + this.getKbsj()
         + ", pbfs="
         + this.getPbfs()
         + ", zbkzjwy="
         + this.getZbkzjwy()
         + ", tbbzjewy="
         + this.getTbbzjewy()
         + ", tbbzjjzr="
         + this.getTbbzjjzr()
         + ", cldc="
         + this.getCldc()
         + ", fkfs="
         + this.getFkfs()
         + ", bsxq="
         + this.getBsxq()
         + ")";
   }

   public OaProjectBidApplicationDTOParam() {
   }

   public OaProjectBidApplicationDTOParam(
      final String requestName,
      final String title,
      final String zbdw,
      final String sqrq,
      final String sqr,
      final List<OaAttachmentsDTO> fj,
      final String bz,
      final String sqrszgs,
      final String sqrszbm,
      final String xmmc,
      final String zbfs,
      final String zbgd,
      final String bstjfs,
      final String tbjzr,
      final String kbsj,
      final String pbfs,
      final String zbkzjwy,
      final String tbbzjewy,
      final String tbbzjjzr,
      final String cldc,
      final String fkfs,
      final String bsxq
   ) {
      this.requestName = requestName;
      this.title = title;
      this.zbdw = zbdw;
      this.sqrq = sqrq;
      this.sqr = sqr;
      this.fj = fj;
      this.bz = bz;
      this.sqrszgs = sqrszgs;
      this.sqrszbm = sqrszbm;
      this.xmmc = xmmc;
      this.zbfs = zbfs;
      this.zbgd = zbgd;
      this.bstjfs = bstjfs;
      this.tbjzr = tbjzr;
      this.kbsj = kbsj;
      this.pbfs = pbfs;
      this.zbkzjwy = zbkzjwy;
      this.tbbzjewy = tbbzjewy;
      this.tbbzjjzr = tbbzjjzr;
      this.cldc = cldc;
      this.fkfs = fkfs;
      this.bsxq = bsxq;
   }

   public static class OaProjectBidApplicationDTOParamBuilder {
      private String requestName;
      private String title;
      private String zbdw;
      private String sqrq;
      private String sqr;
      private List<OaAttachmentsDTO> fj;
      private String bz;
      private String sqrszgs;
      private String sqrszbm;
      private String xmmc;
      private String zbfs;
      private String zbgd;
      private String bstjfs;
      private String tbjzr;
      private String kbsj;
      private String pbfs;
      private String zbkzjwy;
      private String tbbzjewy;
      private String tbbzjjzr;
      private String cldc;
      private String fkfs;
      private String bsxq;

      OaProjectBidApplicationDTOParamBuilder() {
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder requestName(final String requestName) {
         this.requestName = requestName;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder zbdw(final String zbdw) {
         this.zbdw = zbdw;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder sqrq(final String sqrq) {
         this.sqrq = sqrq;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder sqr(final String sqr) {
         this.sqr = sqr;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder fj(final List<OaAttachmentsDTO> fj) {
         this.fj = fj;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder bz(final String bz) {
         this.bz = bz;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder sqrszgs(final String sqrszgs) {
         this.sqrszgs = sqrszgs;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder sqrszbm(final String sqrszbm) {
         this.sqrszbm = sqrszbm;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder xmmc(final String xmmc) {
         this.xmmc = xmmc;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder zbfs(final String zbfs) {
         this.zbfs = zbfs;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder zbgd(final String zbgd) {
         this.zbgd = zbgd;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder bstjfs(final String bstjfs) {
         this.bstjfs = bstjfs;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder tbjzr(final String tbjzr) {
         this.tbjzr = tbjzr;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder kbsj(final String kbsj) {
         this.kbsj = kbsj;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder pbfs(final String pbfs) {
         this.pbfs = pbfs;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder zbkzjwy(final String zbkzjwy) {
         this.zbkzjwy = zbkzjwy;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder tbbzjewy(final String tbbzjewy) {
         this.tbbzjewy = tbbzjewy;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder tbbzjjzr(final String tbbzjjzr) {
         this.tbbzjjzr = tbbzjjzr;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder cldc(final String cldc) {
         this.cldc = cldc;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder fkfs(final String fkfs) {
         this.fkfs = fkfs;
         return this;
      }

      public OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder bsxq(final String bsxq) {
         this.bsxq = bsxq;
         return this;
      }

      public OaProjectBidApplicationDTOParam build() {
         return new OaProjectBidApplicationDTOParam(
            this.requestName,
            this.title,
            this.zbdw,
            this.sqrq,
            this.sqr,
            this.fj,
            this.bz,
            this.sqrszgs,
            this.sqrszbm,
            this.xmmc,
            this.zbfs,
            this.zbgd,
            this.bstjfs,
            this.tbjzr,
            this.kbsj,
            this.pbfs,
            this.zbkzjwy,
            this.tbbzjewy,
            this.tbbzjjzr,
            this.cldc,
            this.fkfs,
            this.bsxq
         );
      }

      @Override
      public String toString() {
         return "OaProjectBidApplicationDTOParam.OaProjectBidApplicationDTOParamBuilder(requestName="
            + this.requestName
            + ", title="
            + this.title
            + ", zbdw="
            + this.zbdw
            + ", sqrq="
            + this.sqrq
            + ", sqr="
            + this.sqr
            + ", fj="
            + this.fj
            + ", bz="
            + this.bz
            + ", sqrszgs="
            + this.sqrszgs
            + ", sqrszbm="
            + this.sqrszbm
            + ", xmmc="
            + this.xmmc
            + ", zbfs="
            + this.zbfs
            + ", zbgd="
            + this.zbgd
            + ", bstjfs="
            + this.bstjfs
            + ", tbjzr="
            + this.tbjzr
            + ", kbsj="
            + this.kbsj
            + ", pbfs="
            + this.pbfs
            + ", zbkzjwy="
            + this.zbkzjwy
            + ", tbbzjewy="
            + this.tbbzjewy
            + ", tbbzjjzr="
            + this.tbbzjjzr
            + ", cldc="
            + this.cldc
            + ", fkfs="
            + this.fkfs
            + ", bsxq="
            + this.bsxq
            + ")";
      }
   }
}
