import { computed as m } from "vue";
import { ref as h } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as o } from "vue";
import { createBlock as r } from "vue";
import { withCtx as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as u } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as f } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as q } from "vue";
import { createElementBlock as R } from "vue";
import { Fragment as S } from "vue";
import { renderList as U } from "vue";
import { ElTag as I } from "element-plus";
import { ElTableColumn as P } from "element-plus";
import { ElFormItem as j } from "element-plus";
import { ElImage as F } from "element-plus";
import { ElForm as O } from "element-plus";
import { _ as $, t as z, jX as G, bD as M, D as g, gt as Y, o as K, cO as X, jl as J, k0 as w, xm as Q, jG as W, jH as Z, k5 as ee, By as v } from "../../../../../shared/runtime.js";
const ae = { class: "detail-imgs-box" }, te = { __name: "detail", setup(se) {
  const { decimalPrecision: b } = z(), T = m(() => [...G, ["invoiceType", ["parse-enum", M, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", b.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", b.value.wms]], ["amount", ["to-thousand", g.YUAN]], ["amountExcludingVAT", ["to-thousand", g.YUAN]], ["inputVAT", ["to-thousand", g.YUAN]], ["remark", "empty-text"]]), E = h(), k = h([]), { CRUD: D, crud: c, detail: a } = Y(), { maxHeight: B } = K({ mainBox: ".inbound-inspection-detail", extraBox: [".el-drawer__header", ".detail-other"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => m(() => !c.detailLoading)), _ = m(() => a.purchaseOrder || {}), C = m(() => c.detailLoading ? "质检详情" : `质检详情：${a.serialNumber}（ ${_.value.supplier ? _.value.supplier.name : ""} ）`);
  return D.HOOK.beforeDetailLoaded = async (V, n) => {
    var l;
    await X(n.list), n.list = await J(n.list, { toSmallest: false, toNum: false }), n.imgUrls = ((l = n.attachments) == null ? void 0 : l.map((p) => p.imageUrl)) || [];
  }, (V, n) => {
    const l = I, p = P, A = x("common-table"), y = j, H = F, L = O, N = x("common-drawer");
    return o(), r(N, { ref_key: "drawerRef", ref: E, visible: e(c).detailVisible, "content-loading": e(c).detailLoading, "before-close": e(c).cancelDetail, title: C.value, "show-close": true, size: "100%", "custom-class": "inbound-inspection-detail" }, { titleAfter: t(() => [e(a).qualityTestingEnum ? (o(), r(l, { key: 0, type: e(w).V[e(a).qualityTestingEnum].TAG, effect: "plain" }, { default: t(() => [u(d(e(w).V[e(a).qualityTestingEnum].SL), 1)]), _: 1 }, 8, ["type"])) : f("", true)]), titleRight: t(() => [e(a).licensePlate ? (o(), r(l, { key: 0, effect: "plain" }, { default: t(() => [u(d(e(a).licensePlate), 1)]), _: 1 })) : f("", true), s(Q, { order: _.value, detail: e(a) }, null, 8, ["order", "detail"])]), content: t(() => [s(A, { data: e(a).list, "data-format": T.value, "max-height": e(B), "expand-row-keys": k.value, "row-key": "id" }, { default: t(() => [s(W, { "basic-class": e(a).basicClass }, null, 8, ["basic-class"]), s(Z, { "basic-class": e(a).basicClass }, null, 8, ["basic-class"]), s(ee, { "basic-class": e(a).basicClass }, null, 8, ["basic-class"]), s(p, { "show-overflow-tooltip": true, prop: "qualityTestingEnum", label: "状态", align: "center", width: "110" }, { default: t(({ row: i }) => [i.qualityTestingEnum ? (o(), r(l, { key: 0, type: e(v).V[i.qualityTestingEnum].TAG }, { default: t(() => [u(d(e(v).V[i.qualityTestingEnum].L), 1)]), _: 2 }, 1032, ["type"])) : f("", true)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"]), s(L, { class: "detail-other" }, { default: t(() => [s(y, { label: "质检备注：" }, { default: t(() => [u(d(e(a).qualityTestingRemark), 1)]), _: 1 }), s(y, { label: "质检图片/视频：" }), q("div", ae, [(o(true), R(S, null, U(e(a).attachments, (i) => (o(), r(H, { "preview-src-list": e(a).imgUrls, "initial-index": 1, key: i.id, src: i.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })]), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, ie = $(te, [["__scopeId", "data-v-70f9ddbb"]]);
export {
  ie as default
};
