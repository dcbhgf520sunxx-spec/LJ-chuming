import { ref as T } from "vue";
import { inject as P } from "vue";
import { computed as f } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as t } from "vue";
import { createBlock as l } from "vue";
import { withCtx as o } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createElementBlock as b } from "vue";
import { withDirectives as Y } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as h } from "vue";
import { ElTag as j } from "element-plus";
import { ElTableColumn as I } from "element-plus";
import { _ as $, t as M, jX as F, bD as x, D as c, gt as G, o as K, G as O, cO as q, jl as X, zd as J, zn as Q, i as A, kD as N, zr as W, aR as Z, k4 as ee, jG as ae, jH as se, k5 as te, zE as oe, k6 as ne, ba as ie } from "../../../../../../shared/runtime.js";
import le from "./common-title-info.vue.js";
const re = { key: 0, class: "invoice-type-info" }, ce = { key: 0 }, ue = { key: 1 }, me = { __name: "detail", setup(de) {
  const { decimalPrecision: k } = M(), V = T(), w = T([]), E = P("permission"), C = f(() => [...F, ["invoiceType", ["parse-enum", x, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", k.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", k.value.wms]], ["amount", ["to-thousand", c.YUAN]], ["amountExcludingVAT", ["to-thousand", c.YUAN]], ["inputVAT", ["to-thousand", c.YUAN]], ["remark", "empty-text"]]), { CRUD: D, crud: u, detail: a } = G(), { maxHeight: R } = K({ mainBox: ".raw-mat-transfer-application-review-detail", extraBox: [".el-drawer__header", ".unfreeze-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => f(() => !u.detailLoading)), S = f(() => u.detailLoading ? "调拨单：" : `调拨单：${a.serialNumber || ""}`), i = f(() => O(E.showAmount));
  D.HOOK.beforeDetailLoaded = async (v, s) => {
    if (await q(s.list), s.list = await X(s.list, { toSmallest: false, toNum: false }), s.transferType !== J.RETURN_PARTY_A.V) {
      let d = 0;
      s.list.forEach((p) => {
        p.boolPartyA && p.partyATransferType === Q.BUY_IN.V && d++;
      }), i.value = d > 0;
    } else i.value = false;
  };
  function B(v) {
    return ie(v, { props: ["quantity", "mete", ["amount", c.YUAN], ["amountExcludingVAT", c.YUAN], ["inputVAT", c.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT"] });
  }
  return (v, s) => {
    const d = j, p = I, z = g("common-table"), U = g("common-drawer"), H = L("parse-enum");
    return t(), l(U, { ref_key: "drawerRef", ref: V, visible: e(u).detailVisible, "content-loading": e(u).detailLoading, "before-close": e(u).cancelDetail, title: S.value, "show-close": true, size: "100%", "custom-class": "raw-mat-transfer-application-review-detail" }, { titleAfter: o(() => [n(le, { detail: e(a) }, null, 8, ["detail"])]), titleRight: o(() => [i.value && e(A)(e(a).invoiceType) ? (t(), b("span", re, [Y(_("span", null, null, 512), [[H, { e: e(x), v: e(a).invoiceType }]]), e(a).invoiceType !== e(x).RECEIPT.V ? (t(), b("span", ce, "（" + y(e(a).taxRate) + "%）", 1)) : r("", true)])) : r("", true), e(A)(e(a).reviewStatus) ? (t(), l(d, { key: 1, type: e(N).V[e(a).reviewStatus].TAG, size: "large", style: { "margin-right": "10px" } }, { default: o(() => [h(y(e(N).VL[e(a).reviewStatus]), 1)]), _: 1 }, 8, ["type"])) : r("", true)]), content: o(() => [e(a).boolHasUnfreeze ? (t(), l(W, { key: 0, class: "unfreeze-info", "basic-class": e(a).basicClass, list: e(a).unfreezeList }, null, 8, ["basic-class", "list"])) : r("", true), n(z, { data: e(a).list, "data-format": C.value, "max-height": e(R), "show-summary": "", "summary-method": B, "expand-row-keys": w.value, "row-key": "id" }, { default: o(() => [n(Z, { data: e(a).list, "expand-row-keys": w.value, "onUpdate:expandRowKeys": s[0] || (s[0] = (m) => w.value = m), "row-key": "id", fixed: "left" }, { default: o(({ row: m }) => [i.value ? (t(), l(ee, { key: 0, "basic-class": e(a).basicClass, row: m, "show-brand": "" }, { default: o(() => [_("p", null, [s[1] || (s[1] = h(" 备注：")), _("span", null, y(m.remark), 1)])]), _: 2 }, 1032, ["basic-class", "row"])) : (t(), b("p", ue, [s[2] || (s[2] = h(" 备注：")), _("span", null, y(m.remark), 1)]))]), _: 1 }, 8, ["data", "expand-row-keys"]), n(ae, { "basic-class": e(a).basicClass, "show-party-a-transfer": "" }, { afterMaterialSn: o(() => [n(p, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), n(se, { "basic-class": e(a).basicClass }, null, 8, ["basic-class"]), i.value ? r("", true) : (t(), l(te, { key: 0, "basic-class": e(a).basicClass }, null, 8, ["basic-class"])), i.value ? (t(), l(oe, { key: 1 })) : r("", true), n(ne, { "show-project": "", "show-monomer": false, "show-area": false })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, ye = $(me, [["__scopeId", "data-v-1a93412f"]]);
export {
  ye as default
};
