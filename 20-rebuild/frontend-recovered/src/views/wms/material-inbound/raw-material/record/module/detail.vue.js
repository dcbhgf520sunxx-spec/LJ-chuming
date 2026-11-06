import { inject as $ } from "vue";
import { computed as l } from "vue";
import { ref as N } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as i } from "vue";
import { createBlock as u } from "vue";
import { withCtx as p } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as _ } from "vue";
import { createElementVNode as m } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as x } from "vue";
import { createElementBlock as F } from "vue";
import { Fragment as H } from "vue";
import { ElTableColumn as L } from "element-plus";
import { _ as Y, t as I, jX as M, bD as O, D as c, gt as W, jY as q, o as K, gS as z, G, jZ as X, j_ as Z, cO as J, jl as Q, xm as ee, aR as ae, k4 as se, jG as te, jH as oe, k5 as le, vb as ne, k6 as ie, yB as re, ba as ue, jN as me } from "../../../../../../shared/runtime.js";
import { _ as ce } from "../../../../../../modules/index-e817c507.js";
const de = { __name: "detail", setup(pe) {
  const { decimalPrecision: h } = I(), T = $("permission"), C = l(() => [...M, ["invoiceType", ["parse-enum", O, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", h.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", h.value.wms]], ["amount", ["to-thousand", c.YUAN]], ["amountExcludingVAT", ["to-thousand", c.YUAN]], ["inputVAT", ["to-thousand", c.YUAN]], ["remark", "empty-text"], ["monomerName", "empty-text"], ["areaName", "empty-text"], ["realTime", "parse-time"]]), V = N(), b = N([]), { CRUD: E, crud: d, detail: s } = W(), { inboundFillWayCfg: g } = q(), { maxHeight: S } = K({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => l(() => !d.detailLoading)), o = l(() => s.purchaseOrder || {}), j = l(() => g.value ? g.value.amountFillWay === z.APPLICATION.V : false), w = l(() => G(T.showAmount) && j.value), v = l(() => {
    var n;
    return ((n = o.value) == null ? void 0 : n.supplyType) === X.PARTY_A.V;
  }), D = l(() => s.basicClass & Z.MANUFACTURED.V), B = l(() => d.detailLoading ? "入库单" : `入库单：${s.serialNumber}（ ${o.value.supplier ? o.value.supplier.name : "无供应商"} ）`), A = l(() => {
    const n = w.value && !v.value && o.value.projects && o.value.requisitionsSN, e = w.value && v.value && o.value.projects && o.value.requisitionsSN;
    return !(n || e);
  });
  E.HOOK.beforeDetailLoaded = async (n, e) => {
    await J(e.list), e.list = await Q(e.list, { toSmallest: false, toNum: false });
  };
  function P(n) {
    return ue(n, { props: ["quantity", ["mete", me.weight.precision], ["amount", c.YUAN], ["amountExcludingVAT", c.YUAN], ["inputVAT", c.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT"] });
  }
  return (n, e) => {
    const f = L, R = k("common-table"), U = k("common-drawer");
    return i(), u(U, { ref_key: "drawerRef", ref: V, visible: a(d).detailVisible, "content-loading": a(d).detailLoading, "before-close": a(d).cancelDetail, title: B.value, "show-close": true, size: "100%", "custom-class": "raw-mat-inbound-application-record-detail" }, { titleAfter: p(() => [t(ee, { order: o.value, detail: a(s) }, null, 8, ["order", "detail"])]), titleRight: p(() => [t(ce, { "purchase-id": o.value.id, size: "default" }, null, 8, ["purchase-id"])]), content: p(() => [t(R, { data: a(s).list, "data-format": C.value, "max-height": a(S), "show-summary": "", "summary-method": P, "expand-row-keys": b.value, "row-key": "id" }, { default: p(() => [t(ae, { data: a(s).list, "expand-row-keys": b.value, "onUpdate:expandRowKeys": e[0] || (e[0] = (r) => b.value = r), "row-key": "id", fixed: "left" }, { default: p(({ row: r }) => [A.value ? _("", true) : (i(), u(se, { key: 0, "basic-class": a(s).basicClass, row: r, "show-brand": "" }, null, 8, ["basic-class", "row"])), m("p", null, [e[1] || (e[1] = y(" 单体：")), m("span", null, x(r.monomerName), 1)]), m("p", null, [e[2] || (e[2] = y(" 区域：")), m("span", null, x(r.areaName), 1)]), m("p", null, [e[3] || (e[3] = y(" 备注：")), m("span", null, x(r.remark), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), t(te, { "basic-class": a(s).basicClass, fixed: "left" }, null, 8, ["basic-class"]), t(oe, { "basic-class": a(s).basicClass }, null, 8, ["basic-class"]), A.value ? (i(), u(le, { key: 0, "basic-class": a(s).basicClass }, null, 8, ["basic-class"])) : _("", true), w.value ? (i(), F(H, { key: 1 }, [v.value ? _("", true) : (i(), u(ne, { key: 0 }))], 64)) : _("", true), t(f, { prop: "project", label: "项目", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), t(f, { prop: "monomerName", label: "单体", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), t(f, { prop: "areaName", label: "区域", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), D.value ? (i(), u(f, { key: 3, prop: "workshop.name", label: "车间", align: "left", "min-width": "120px", "show-overflow-tooltip": "" })) : (i(), u(ie, { key: 2 })), t(re, { label: "实际入库时间" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, we = Y(de, [["__scopeId", "data-v-eb9a481c"]]);
export {
  we as default
};
