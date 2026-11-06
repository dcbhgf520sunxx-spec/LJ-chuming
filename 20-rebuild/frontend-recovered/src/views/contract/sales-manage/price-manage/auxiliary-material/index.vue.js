import { ref as f } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as b } from "vue";
import { mergeProps as F } from "vue";
import { unref as e } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as o } from "vue";
import { withCtx as g } from "vue";
import { createElementVNode as v } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as c } from "vue";
import { normalizeClass as V } from "vue";
import { ElMessage as Q } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { vLoading as J } from "element-plus";
import { c as K } from "../preview.vue.js";
import { O as W } from "../../../../../modules/contract-9b18cc88.js";
import { t as X, x as Y, o as Z, ky as ee, bV as U, P as te, aw as ie, i as ae } from "../../../../../shared/runtime.js";
import ne from "./module/header.vue.js";
import "../../../../../modules/common-913d415d.js";
import "../../../../../modules/index-61ce89a1.js";
const fe = { __name: "index", emits: ["showLog"], setup(oe, { expose: I, emit: L }) {
  const { decimalPrecision: d } = X(), M = { add: false, edit: false, del: false, download: false }, D = L, k = f(), P = f(), y = f(false), w = f([]), m = f([]), { crud: l, columns: s } = Y({ title: "配套件价格", sort: [], permission: { ...W }, crudApi: { ...K }, optShow: { ...M }, requiredQuery: ["projectId", "relationType"] }, k), { maxHeight: R } = Z({ paginate: true, extraHeight: 100 }), S = { unitPrice: [{ validator: (i, u) => ae(i), message: "请填写单价", trigger: ["blur", "change"] }] }, E = /* @__PURE__ */ new Map([["unitPrice", "同上"]]);
  function T() {
    D("showLog");
  }
  function A(i) {
    return i.status !== 1;
  }
  function B(i) {
    w.value = [], l.selectionChangeHandler(i), l.selections.sort(function(u, a) {
      return u.orderIndex - a.orderIndex;
    }), i.forEach((u) => {
      w.value.push(u.id);
    });
  }
  const { tableValidate: q, cleanUpData: H, wrongCellMask: N } = ie({ rules: S, ditto: E });
  async function $(i) {
    m.value = [];
    const u = l.selections.map((r) => r), { validResult: a, dealList: h } = q(u);
    if (y.value = false, a) {
      if (H(h), m.value = h.filter((r) => r.unitPrice !== r.originUnitPrice && (typeof r.originUnitPrice == "number" && r.originUnitPrice > 0 || r.unitPrice > 0)), m.value.length === 0) {
        Q.error("请修改至少一条数据");
        return;
      }
      y.value = !!m.value.length;
    }
  }
  function z(i) {
    i.totalPrice = i.mete * (i.unitPrice && typeof i.unitPrice == "number" ? i.unitPrice : 0);
  }
  return I({ refresh: l.refresh }), (i, u) => {
    const a = G, h = x("common-input-number"), r = x("common-table"), j = J;
    return n(), C("div", null, [b(e(ne), F({ ref_key: "headerRef", ref: P }, i.$attrs, { onCheckSubmit: $, showAble: y.value, rowIds: w.value, submitList: m.value, onShowVisible: T }), null, 16, ["showAble", "rowIds", "submitList"]), O((n(), o(r, { ref_key: "tableRef", ref: k, data: e(l).data, "return-source-data": "", style: { width: "100%" }, class: "businessTable", "max-height": e(R), showEmptySymbol: false, "cell-class-name": e(N), onSelectionChange: B }, { default: g(() => [b(a, { type: "selection", align: "center", width: "60", class: "selection", selectable: A }), b(a, { label: "序号", type: "index", align: "center", width: "60" }), e(s).visible("useProperty") ? (n(), o(a, { key: 0, prop: "useProperty", label: "使用类别", align: "center" }, { default: g(({ row: t }) => [v("span", null, _(t.useProperty ? e(ee).VL[t.useProperty] : "-"), 1)]), _: 1 })) : c("", true), e(s).visible("name") ? (n(), o(a, { key: 1, prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true })) : c("", true), e(s).visible("specification") ? (n(), o(a, { key: 2, "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center", "min-width": "120" })) : c("", true), e(s).visible("measureUnit") ? (n(), o(a, { key: 3, "show-overflow-tooltip": true, prop: "measureUnit", label: "单位", align: "center" })) : c("", true), e(s).visible("quantity") ? (n(), o(a, { key: 4, "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center" })) : c("", true), e(s).visible("accountingUnit") ? (n(), o(a, { key: 5, prop: "accountingUnit", "show-overflow-tooltip": true, label: "核算单位", align: "center", "min-width": "100" })) : c("", true), e(s).visible("mete") ? (n(), o(a, { key: 6, prop: "mete", "show-overflow-tooltip": true, label: "核算量", align: "center", "min-width": "100" })) : c("", true), e(s).visible("unitPrice") ? (n(), o(a, { key: "unitPrice", prop: "unitPrice", "show-overflow-tooltip": true, label: "综合单价", align: "center", "min-width": "120" }, { default: g(({ row: t }) => [P.value && P.value.modifying && e(l).selections && e(l).selections.findIndex((p) => p.id === t.id) > -1 ? (n(), o(h, { key: 0, modelValue: t.unitPrice, "onUpdate:modelValue": (p) => t.unitPrice = p, step: 1, min: 0, max: 99999999, precision: e(d).contract === 2 ? 3 : e(d).contract, placeholder: e(l).selections.findIndex((p) => p.id === t.id) === 0 ? "" : t.unitPrice || "", size: "default", style: { width: "100%" }, onChange: (p) => z(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "placeholder", "onChange"])) : (n(), C("span", { key: 1, class: V(t.status === 1 ? "tc-danger" : "") }, _(t.unitPrice !== "同上" ? e(U)(t.unitPrice, e(d).contract === 2 ? 3 : e(d).contract) : "-"), 3))]), _: 1 })) : c("", true), e(s).visible("totalPrice") ? (n(), o(a, { key: "totalPrice", prop: "totalPrice", align: "center", "min-width": "120", label: "金额" }, { default: g(({ row: t }) => [v("span", { class: V(t.status === 1 ? "tc-danger" : "") }, [v("span", null, _(t.totalPrice ? e(U)(t.totalPrice, e(d).contract === 2 ? 3 : e(d).contract) : "-"), 1)], 2)]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[j, e(l).loading]]), b(e(te))]);
  };
} };
export {
  fe as default
};
