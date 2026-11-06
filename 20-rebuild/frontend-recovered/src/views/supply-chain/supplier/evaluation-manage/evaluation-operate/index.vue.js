import { useRoute as M } from "vue-router";
import { ref as m } from "vue";
import { onMounted as V } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as q } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as u } from "vue";
import { withDirectives as T } from "vue";
import { unref as t } from "vue";
import { createBlock as l } from "vue";
import { withCtx as k } from "vue";
import { createCommentVNode as p } from "vue";
import { ElTableColumn as z } from "element-plus";
import { vLoading as $ } from "element-plus";
import { x as G, wS as w, wT as K, o as F, p as J, P as Q, G as W } from "../../../../../shared/runtime.js";
import { g as X } from "../../../../../modules/supplier-evaluation-config-2fb6916b.js";
import Y from "./module/operate-drawer.vue.js";
import Z from "./module/detail-drawer.vue.js";
import j from "./module/header.vue.js";
const ee = { class: "app-container" }, ue = { __name: "index", setup(ie) {
  const g = M(), h = m(), b = m([]), v = m(false), d = m(false), y = m({}), N = m({}), S = { batchAdd: false, add: false, edit: false, del: false, download: false }, { CRUD: x, crud: c, columns: s } = G({ title: "供应商评价", sort: ["id.desc"], permission: { ...w }, optShow: { ...S }, crudApi: { get: K } }, h), { maxHeight: A } = F({ paginate: true });
  V(() => {
    O();
    const e = g.query.supplierId;
    e && (y.value = { id: Number(e), name: g.query.supplierName || "" }, v.value = true);
  }), x.HOOK.handleRefresh = (e, i) => {
    const r = R(i.data);
    i.data.content = r.map((o) => E(o));
  };
  function D(e) {
    var r;
    if (!W(w.add)) return;
    const i = e || ((r = c.selections) == null ? void 0 : r[0]) || {};
    y.value = { id: i.supplierId || i.id, name: i.supplierName || i.name || "", classifyId: i.classifyId }, v.value = true;
  }
  function I(e) {
    N.value = { ...e }, d.value = true;
  }
  async function O() {
    try {
      const [e] = await Promise.allSettled([X()]);
      e.status === "fulfilled" && (b.value = R(e.value));
    } catch (e) {
      console.log("供应商评价管理-配置读取", e);
    }
  }
  function E(e = {}) {
    var i;
    return { ...e, id: e.id || e.evaluateId, supplierId: e.supplierId || ((i = e.supplier) == null ? void 0 : i.id), reviewTime: _(a(e, ["reviewTime", "approveTime", "checkTime", "auditTime"])), evaluateTime: _(a(e, ["evaluateTime", "evaluateDate", "createTime"])), classifyId: a(e, ["classifyId", "evaluationCategoryId"]), classifyName: a(e, ["scmSupplierConfigDTO.name", "classifyName", "evaluationCategoryName", "evaluationCategoryLabel", "evaluationCategory.name"]), supplierName: a(e, ["supplierName", "name", "supplier.name"]), supplierShortName: a(e, ["supplierShortName", "shortName", "supplier.shortName"]), reviewResult: a(e, ["score", "reviewResult", "evaluateResult"]), scoreRating: a(e, ["scoreRating", "scoreRatingName", "ratingName"]), evaluatorName: a(e, ["evaluatorName", "evaluateUserName", "createUserName"]) };
  }
  function _(e) {
    if (e == null || e === "") return "-";
    const i = Number(e);
    return Number.isNaN(i) ? String(e) : J(i);
  }
  function a(e, i = []) {
    if (!e || typeof e != "object") return "";
    for (const r of i) {
      const o = P(e, r);
      if (o != null && o !== "") return o;
    }
    return "";
  }
  function P(e, i) {
    if (!(!e || !i)) return i.includes(".") ? i.split(".").reduce((r, o) => r ? r[o] : void 0, e) : e[i];
  }
  function R(e) {
    var i;
    return Array.isArray(e) ? e : Array.isArray(e == null ? void 0 : e.content) ? e.content : Array.isArray((i = e == null ? void 0 : e.data) == null ? void 0 : i.content) ? e.data.content : Array.isArray(e == null ? void 0 : e.records) ? e.records : Array.isArray(e == null ? void 0 : e.list) ? e.list : Array.isArray(e == null ? void 0 : e.data) ? e.data : [];
  }
  return (e, i) => {
    const r = z, o = C("common-button"), U = C("common-table"), B = q("permission"), H = $;
    return n(), L("div", ee, [u(j, { onOpenEvaluate: D }), T((n(), l(U, { ref_key: "tableRef", ref: h, data: t(c).data, "empty-text": t(c).emptyText, "max-height": t(A), "return-source-data": "", "row-key": "id", style: { width: "100%" }, onSelectionChange: t(c).selectionChangeHandler }, { default: k(() => [u(r, { type: "selection", width: "55", align: "center" }), u(r, { label: "序号", type: "index", width: "60", align: "center" }), t(s).visible("reviewTime") ? (n(), l(r, { key: 0, label: "审核时间", prop: "reviewTime", "min-width": "130", align: "center" })) : p("", true), t(s).visible("evaluateTime") ? (n(), l(r, { key: 1, label: "评价时间", prop: "evaluateTime", "min-width": "130", align: "center" })) : p("", true), t(s).visible("classifyName") ? (n(), l(r, { key: 2, label: "评价分类", prop: "classifyName", "min-width": "140", "show-overflow-tooltip": "" })) : p("", true), t(s).visible("supplierName") ? (n(), l(r, { key: 3, label: "供应商名称", prop: "supplierName", "min-width": "160", "show-overflow-tooltip": "" })) : p("", true), t(s).visible("supplierShortName") ? (n(), l(r, { key: 4, label: "供应商简称", prop: "supplierShortName", "min-width": "140", "show-overflow-tooltip": "" })) : p("", true), t(s).visible("reviewResult") ? (n(), l(r, { key: 5, label: "评审结果", prop: "reviewResult", "min-width": "120", "show-overflow-tooltip": "" })) : p("", true), t(s).visible("scoreRating") ? (n(), l(r, { key: 6, label: "评级", prop: "scoreRating", "min-width": "100", "show-overflow-tooltip": "" })) : p("", true), t(s).visible("evaluatorName") ? (n(), l(r, { key: 7, label: "评价人", prop: "evaluatorName", "min-width": "120", "show-overflow-tooltip": "" })) : p("", true), u(r, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: k(({ row: f }) => [T(u(o, { icon: "el-icon-view", size: "mini", type: "primary", onClick: (re) => I(f) }, null, 8, ["onClick"]), [[B, t(w).detail]])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[H, t(c).loading]]), u(t(Q)), u(Y, { visible: v.value, "onUpdate:visible": i[0] || (i[0] = (f) => v.value = f), "category-options": b.value, "seed-supplier": y.value, onSuccess: t(c).refresh }, null, 8, ["visible", "category-options", "seed-supplier", "onSuccess"]), u(Z, { visible: d.value, "onUpdate:visible": i[1] || (i[1] = (f) => d.value = f), "detail-row": N.value }, null, 8, ["visible", "detail-row"])]);
  };
} };
export {
  ue as default
};
