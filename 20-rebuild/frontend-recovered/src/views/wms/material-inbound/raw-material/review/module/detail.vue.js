import { inject as F } from "vue";
import { computed as o } from "vue";
import { ref as E } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as i } from "vue";
import { createBlock as r } from "vue";
import { withCtx as f } from "vue";
import { createVNode as t } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as _ } from "vue";
import { createElementVNode as m } from "vue";
import { createTextVNode as g } from "vue";
import { toDisplayString as x } from "vue";
import { createElementBlock as I } from "vue";
import { Fragment as H } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { _ as q, t as M, jX as W, bD as O, D as c, gt as G, jY as K, o as z, gS as X, G as Z, jZ as J, j_ as Q, cO as ee, jl as ae, k0 as y, V as se, xm as te, aR as oe, k4 as ne, jG as le, jH as ie, k5 as re, vb as ue, k6 as me, yB as ce, ba as pe, jN as de } from "../../../../../../shared/runtime.js";
import fe from "../../components/inspection-return-info.vue.js";
import { _ as _e } from "../../../../../../modules/index-e817c507.js";
const be = { __name: "detail", setup(we) {
  const { decimalPrecision: A } = M(), C = F("permission"), V = o(() => [...W, ["invoiceType", ["parse-enum", O, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", A.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", A.value.wms]], ["amount", ["to-thousand", c.YUAN]], ["amountExcludingVAT", ["to-thousand", c.YUAN]], ["inputVAT", ["to-thousand", c.YUAN]], ["remark", "empty-text"], ["realTime", "parse-time"]]), S = E(), v = E([]), { CRUD: L, crud: p, detail: a } = G(), { inboundFillWayCfg: T } = K(), { maxHeight: R } = z({ mainBox: ".raw-mat-inbound-application-record-preview", extraBox: [".el-drawer__header", ".inspection-return-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => o(() => !p.detailLoading)), n = o(() => a.purchaseOrder || {}), D = o(() => T.value ? T.value.amountFillWay === X.REVIEWING.V : false), b = o(() => Z(C.showAmount) || D.value), w = o(() => (a == null ? void 0 : a.supplyType) === J.PARTY_A.V), j = o(() => a.basicClass & Q.MANUFACTURED.V), U = o(() => p.detailLoading ? "入库单" : `入库单：${a.serialNumber}（ ${n.value.supplier ? n.value.supplier.name : "无供应商"} ）`), h = o(() => {
    const d = b.value && !w.value && n.value.projects && n.value.requisitionsSN, e = b.value && w.value && n.value.projects && n.value.requisitionsSN;
    return !(d || e);
  });
  L.HOOK.beforeDetailLoaded = async (d, e) => {
    await ee(e.list), e.list = await ae(e.list, { toSmallest: false, toNum: false }), !(e.qualityTestingEnum & y.UNREVIEWED.V) && (e.originList = se(e.list), e.list = e.originList.filter((l) => l.qualityTestingEnum & (y.ALL_PASS.V | y.NO.V)), e.returnList = e.originList.filter((l) => l.qualityTestingEnum & y.ALL_REFUSE.V));
  };
  function B(d) {
    return pe(d, { props: ["quantity", ["mete", de.weight.precision], ["amount", c.YUAN], ["amountExcludingVAT", c.YUAN], ["inputVAT", c.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT"] });
  }
  return (d, e) => {
    const l = Y, P = N("common-table"), $ = N("common-drawer");
    return i(), r($, { ref_key: "drawerRef", ref: S, visible: s(p).detailVisible, "content-loading": s(p).detailLoading, "before-close": s(p).cancelDetail, title: U.value, "show-close": true, size: "100%", "custom-class": "raw-mat-inbound-application-review-detail" }, { titleAfter: f(() => [t(te, { order: n.value, detail: s(a) }, null, 8, ["order", "detail"])]), titleRight: f(() => [t(_e, { "purchase-id": n.value.id, size: "default" }, null, 8, ["purchase-id"])]), content: f(() => {
      var k;
      return [(k = s(a).returnList) != null && k.length ? (i(), r(fe, { key: 0, class: "inspection-return-info", "basic-class": s(a).basicClass, list: s(a).returnList, showTableColumnSecondary: h.value, showAmount: b.value, boolPartyA: w.value }, null, 8, ["basic-class", "list", "showTableColumnSecondary", "showAmount", "boolPartyA"])) : _("", true), t(P, { data: s(a).list, "data-format": V.value, "max-height": s(R), "show-summary": "", "summary-method": B, "expand-row-keys": v.value, "row-key": "id" }, { default: f(() => [t(oe, { data: s(a).list, "expand-row-keys": v.value, "onUpdate:expandRowKeys": e[0] || (e[0] = (u) => v.value = u), "row-key": "id", fixed: "left" }, { default: f(({ row: u }) => [h.value ? _("", true) : (i(), r(ne, { key: 0, "basic-class": s(a).basicClass, row: u, "show-brand": "" }, null, 8, ["basic-class", "row"])), m("p", null, [e[1] || (e[1] = g(" 单体：")), m("span", null, x(u.monomerName), 1)]), m("p", null, [e[2] || (e[2] = g(" 区域：")), m("span", null, x(u.areaName), 1)]), m("p", null, [e[3] || (e[3] = g(" 备注：")), m("span", null, x(u.remark), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), t(le, { "basic-class": s(a).basicClass, fixed: "left" }, null, 8, ["basic-class"]), t(ie, { "basic-class": s(a).basicClass }, null, 8, ["basic-class"]), h.value ? (i(), r(re, { key: 0, "basic-class": s(a).basicClass }, null, 8, ["basic-class"])) : _("", true), b.value ? (i(), I(H, { key: 1 }, [w.value ? _("", true) : (i(), r(ue, { key: 0 }))], 64)) : _("", true), t(l, { prop: "project", label: "项目", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), t(l, { prop: "monomerName", label: "单体", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), t(l, { prop: "areaName", label: "区域", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), j.value ? (i(), r(l, { key: 3, prop: "workshop.name", label: "车间", align: "left", "min-width": "120px", "show-overflow-tooltip": "" })) : (i(), r(me, { key: 2 })), t(ce, { label: "实际入库时间" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])];
    }), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, xe = q(be, [["__scopeId", "data-v-63d60841"]]);
export {
  xe as default
};
