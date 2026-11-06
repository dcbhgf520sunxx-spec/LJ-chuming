import { ref as p } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as h } from "vue";
import { mergeProps as X } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as l } from "vue";
import { withCtx as b } from "vue";
import { createCommentVNode as c } from "vue";
import { normalizeClass as k } from "vue";
import { toDisplayString as L } from "vue";
import { createElementVNode as Y } from "vue";
import { withModifiers as Z } from "vue";
import { ElMessage as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { vLoading as ie } from "element-plus";
import { c as ne } from "../../../../../modules/structure-70e27af9.js";
import { O as I } from "../../../../../modules/contract-9b18cc88.js";
import { t as ae, x as oe, o as le, bT as M, bV as se, G as re, P as ce, aw as ue, i as de } from "../../../../../shared/runtime.js";
import me from "./module/header.vue.js";
import pe from "./module/detail.vue.js";
import "../preview.vue.js";
import "../../../../../modules/common-913d415d.js";
import "../../../../../modules/index-61ce89a1.js";
import "./module/adjust.vue.js";
const Ve = { __name: "index", emits: ["showLog"], setup(he, { expose: D, emit: R }) {
  const { decimalPrecision: m } = ae(), U = { add: false, edit: false, del: false, download: false }, x = p(), f = p(), V = p({}), y = p(false), g = p([]), v = p([]), E = R, { crud: o, columns: u } = oe({ title: "结构价格", sort: [], permission: { ...I }, crudApi: { ...ne }, optShow: { ...U }, requiredQuery: ["monomerId"] }, x);
  function S(t) {
    return t.status !== 1;
  }
  const { maxHeight: H } = le({ paginate: true, extraHeight: 100 }), T = { unitPrice: [{ validator: (t, d) => de(t), message: "请填写单价", trigger: ["blur", "change"] }] }, A = /* @__PURE__ */ new Map([["pricingManner", -1], ["unitPrice", "同上"]]), { tableValidate: B, cleanUpData: N, wrongCellMask: W } = ue({ rules: T, ditto: A });
  function z(t) {
    v.value = [], o.selectionChangeHandler(t), o.selections.sort(function(d, n) {
      return d.orderIndex - n.orderIndex;
    }), t.forEach((d) => {
      v.value.push(d.id);
    }), console.log(v.value);
  }
  async function Q(t) {
    g.value = [];
    const d = o.selections.map((s) => s), { validResult: n, dealList: w } = B(d);
    if (y.value = false, n) {
      if (N(w), g.value = w.filter((s) => s.pricingManner !== s.originPricingManner && s.unitPrice !== "同上" || s.unitPrice !== s.originUnitPrice && (typeof s.originUnitPrice == "number" && s.originUnitPrice > 0 || s.unitPrice > 0)), g.value.length === 0) {
        ee.error("请修改至少一条数据");
        return;
      }
      y.value = !!g.value.length;
    }
  }
  function $(t) {
    V.value = t, o.toDetail(t);
  }
  function q() {
    E("showLog");
  }
  function G(t) {
    t.totalPrice = (t.pricingManner === M.WEIGHT.V ? t.totalWeight : t.totalLength) * (t.unitPrice && typeof t.unitPrice == "number" ? t.unitPrice : 0);
  }
  return D({ refresh: o.refresh }), (t, d) => {
    const n = te, w = _("common-select"), s = _("common-input-number"), F = _("common-button"), O = _("common-table"), j = K("thousand"), J = ie;
    return a(), P("div", null, [h(e(me), X({ ref_key: "headerRef", ref: f }, t.$attrs, { onCheckSubmit: Q, showAble: y.value, submitList: g.value, rowIds: v.value, onShowVisible: q }), null, 16, ["showAble", "submitList", "rowIds"]), C((a(), l(O, { ref_key: "tableRef", ref: x, data: e(o).data, "return-source-data": "", style: { width: "100%" }, class: "businessTable", "max-height": e(H), showEmptySymbol: false, "cell-class-name": e(W), onSelectionChange: z }, { default: b(() => [h(n, { type: "selection", align: "center", width: "60", class: "selection", selectable: S }), h(n, { label: "序号", type: "index", align: "center", width: "60" }), e(u).visible("name") ? (a(), l(n, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称", align: "center", "min-width": "140" })) : c("", true), e(u).visible("specification") ? (a(), l(n, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "140" })) : c("", true), e(u).visible("material") ? (a(), l(n, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center", "min-width": "120" })) : c("", true), e(u).visible("totalQuantity") ? (a(), l(n, { key: "totalQuantity", prop: "totalQuantity", label: "数量", align: "center", "min-width": "70", "show-overflow-tooltip": "" })) : c("", true), e(u).visible("totalLength") ? (a(), l(n, { key: "totalLength", prop: "totalLength", label: "总长度(米)", align: "center", "min-width": "70", "show-overflow-tooltip": "" })) : c("", true), e(u).visible("totalWeight") ? (a(), l(n, { key: "totalWeight", prop: "totalWeight", "show-overflow-tooltip": "", label: "总量(t)", align: "center", "min-width": "120" })) : c("", true), e(u).visible("pricingManner") ? (a(), l(n, { key: "pricingManner", prop: "pricingManner", "show-overflow-tooltip": "", label: "计价方式", align: "center", "min-width": "120" }, { default: b(({ row: i }) => [f.value && f.value.modifying && e(o).selections && e(o).selections.findIndex((r) => r.id === i.id) > -1 ? (a(), l(w, { key: 0, modelValue: i.pricingManner, "onUpdate:modelValue": (r) => i.pricingManner = r, options: e(M).ENUM, default: "", type: "enum", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (a(), P("span", { key: 1, class: k(i.status === 1 ? "tc-danger" : "") }, L(e(M).VL[i.pricingManner]), 3))]), _: 1 })) : c("", true), e(u).visible("unitPrice") ? (a(), l(n, { key: "unitPrice", prop: "unitPrice", "show-overflow-tooltip": "", label: "综合单价", align: "center", "min-width": "120" }, { default: b(({ row: i }) => [f.value && f.value.modifying && e(o).selections && e(o).selections.findIndex((r) => r.id === i.id) > -1 ? (a(), l(s, { key: 0, modelValue: i.unitPrice, "onUpdate:modelValue": (r) => i.unitPrice = r, step: 1, min: 0, max: 99999999, precision: e(m).contract === 2 ? 3 : e(m).contract, placeholder: e(o).selections.findIndex((r) => r.id === i.id) === 0 ? "" : i.unitPrice || "", size: "default", style: { width: "100%" }, onChange: (r) => G(i) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "placeholder", "onChange"])) : (a(), P("span", { key: 1, class: k(i.status === 1 ? "tc-danger" : "") }, L(i.unitPrice !== "同上" ? e(se)(i.unitPrice, e(m).contract === 2 ? 3 : e(m).contract) : "-"), 3))]), _: 1 })) : c("", true), e(u).visible("totalPrice") ? (a(), l(n, { key: "totalPrice", prop: "totalPrice", align: "center", "min-width": "120", label: "金额" }, { default: b(({ row: i }) => [C(Y("span", { class: k(i.status === 1 ? "tc-danger" : "") }, null, 2), [[j, { val: i.totalPrice || 0, dp: e(m).contract === 2 ? 3 : e(m).contract }]])]), _: 1 })) : c("", true), e(re)([...e(I).detail]) ? (a(), l(n, { key: 9, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: b(({ row: i }) => [h(F, { icon: "el-icon-view", type: "info", size: "default", onClick: Z((r) => $(i), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[J, e(o).loading]]), h(e(ce)), h(e(pe), { "detail-info": V.value, onRefresh: e(o).refresh }, null, 8, ["detail-info", "onRefresh"])]);
  };
} };
export {
  Ve as default
};
