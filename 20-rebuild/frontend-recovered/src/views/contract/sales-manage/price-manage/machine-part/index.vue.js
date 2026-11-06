import { ref as f } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as P } from "vue";
import { createVNode as d } from "vue";
import { mergeProps as Y } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as s } from "vue";
import { withCtx as h } from "vue";
import { createElementVNode as D } from "vue";
import { toDisplayString as k } from "vue";
import { createCommentVNode as u } from "vue";
import { normalizeClass as M } from "vue";
import { withModifiers as Z } from "vue";
import { ElMessage as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { vLoading as ie } from "element-plus";
import { c as ne, _ as ae } from "./module/header.vue.js";
import { O as oe } from "../../../../../modules/contract-9b18cc88.js";
import { t as le, x as se, o as ce, bT as x, bV as re, P as ue, aw as de, i as me } from "../../../../../shared/runtime.js";
import pe from "./module/detail.vue.js";
import "../preview.vue.js";
import "../../../../../modules/common-913d415d.js";
import "../../../../../modules/index-61ce89a1.js";
const Me = { __name: "index", emits: ["showLog"], setup(fe, { expose: I, emit: U }) {
  const { decimalPrecision: p } = le(), E = { add: false, edit: false, del: false, download: false }, R = U, V = f(), g = f(), w = f(false), y = f([]), b = f([]), C = f({}), { crud: o, columns: r } = se({ title: "散发制品价格", sort: [], permission: { ...oe }, crudApi: { ...ne }, optShow: { ...E }, requiredQuery: ["monomerId"] }, V), { maxHeight: S } = ce({ paginate: true, extraHeight: 100 }), A = (i) => {
    console.log(i), C.value = i, o.toDetail(i);
  };
  function T() {
    R("showLog");
  }
  function B(i) {
    return i.status !== 1;
  }
  const H = { unitPrice: [{ validator: (i, m) => me(i), message: "请填写单价", trigger: ["blur", "change"] }] }, N = /* @__PURE__ */ new Map([["pricingManner", -1], ["unitPrice", "同上"]]), { tableValidate: W, cleanUpData: $, wrongCellMask: z } = de({ rules: H, ditto: N });
  function Q(i) {
    y.value = [], o.selectionChangeHandler(i), o.selections.sort(function(m, n) {
      return m.orderIndex - n.orderIndex;
    }), i.forEach((m) => {
      y.value.push(m.id);
    });
  }
  async function q(i) {
    b.value = [];
    const m = o.selections.map((l) => l), { validResult: n, dealList: v } = W(m);
    if (w.value = false, n) {
      if ($(v), b.value = v.filter((l) => l.pricingManner !== l.originPricingManner && l.unitPrice !== "同上" || l.unitPrice !== l.originUnitPrice && (typeof l.originUnitPrice == "number" && l.originUnitPrice > 0 || l.unitPrice > 0)), b.value.length === 0) {
        ee.error("请修改至少一条数据");
        return;
      }
      w.value = !!b.value.length;
    }
  }
  function F(i) {
    i.totalPrice = (i.pricingManner === x.WEIGHT.V ? i.totalWeight : i.totalLength) * (i.unitPrice && typeof i.unitPrice == "number" ? i.unitPrice : 0);
  }
  return I({ refresh: o.refresh }), (i, m) => {
    const n = te, v = _("table-cell-tag"), l = _("common-select"), G = _("common-input-number"), O = _("common-button"), j = _("common-table"), J = X("thousand"), K = ie;
    return a(), P("div", null, [d(e(ae), Y({ ref_key: "headerRef", ref: g }, i.$attrs, { onCheckSubmit: q, showAble: w.value, rowIds: y.value, submitList: b.value, onShowVisible: T }), null, 16, ["showAble", "rowIds", "submitList"]), L((a(), s(j, { ref_key: "tableRef", ref: V, data: e(o).data, "return-source-data": "", style: { width: "100%" }, class: "businessTable", "max-height": e(S), showEmptySymbol: false, "cell-class-name": e(z), onSelectionChange: Q }, { default: h(() => [d(n, { type: "selection", align: "center", width: "60", class: "selection", selectable: B }), d(n, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("name") ? (a(), s(n, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称", align: "center", "min-width": "140" }, { default: h(({ row: t }) => [d(v, { name: "檩条直发", show: t.boolAllPartSendDirectly, color: "#f56c6c" }, null, 8, ["show"]), D("span", null, k(t.name), 1)]), _: 1 })) : u("", true), e(r).visible("specification") ? (a(), s(n, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "140" })) : u("", true), e(r).visible("material") ? (a(), s(n, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center", "min-width": "120" })) : u("", true), e(r).visible("totalQuantity") ? (a(), s(n, { key: "totalQuantity", prop: "totalQuantity", label: "数量", align: "center", "min-width": "70", "show-overflow-tooltip": "" })) : u("", true), e(r).visible("totalWeight") ? (a(), s(n, { key: "totalWeight", prop: "totalWeight", "show-overflow-tooltip": "", label: "总量(t)", align: "center", "min-width": "120" })) : u("", true), e(r).visible("totalLength") ? (a(), s(n, { key: "totalLength", prop: "totalLength", label: "总长度(米)", align: "center", "min-width": "70", "show-overflow-tooltip": "" })) : u("", true), e(r).visible("pricingManner") ? (a(), s(n, { key: "pricingManner", prop: "pricingManner", "show-overflow-tooltip": "", label: "计价方式", align: "center", "min-width": "120" }, { default: h(({ row: t }) => [g.value && g.value.modifying && e(o).selections && e(o).selections.findIndex((c) => c.id === t.id) > -1 ? (a(), s(l, { key: 0, modelValue: t.pricingManner, "onUpdate:modelValue": (c) => t.pricingManner = c, options: e(x).ENUM, default: "", type: "enum", size: "default", class: "filter-item" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])) : (a(), P("span", { key: 1, class: M(t.status === 1 ? "tc-danger" : "") }, k(e(x).VL[t.pricingManner]), 3))]), _: 1 })) : u("", true), e(r).visible("unitPrice") ? (a(), s(n, { key: "unitPrice", prop: "unitPrice", "show-overflow-tooltip": "", label: "综合单价", align: "center", "min-width": "120" }, { default: h(({ row: t }) => [g.value && g.value.modifying && e(o).selections && e(o).selections.findIndex((c) => c.id === t.id) > -1 ? (a(), s(G, { key: 0, modelValue: t.unitPrice, "onUpdate:modelValue": (c) => t.unitPrice = c, step: 1, min: 0, max: 99999999, precision: e(p).contract === 2 ? 3 : e(p).contract, placeholder: e(o).selections.findIndex((c) => c.id === t.id) === 0 ? "" : t.unitPrice || "", size: "default", style: { width: "100%" }, onChange: (c) => F(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "placeholder", "onChange"])) : (a(), P("span", { key: 1, class: M(t.status === 1 ? "tc-danger" : "") }, k(t.unitPrice !== "同上" ? e(re)(t.unitPrice, e(p).contract === 2 ? 3 : e(p).contract) : "-"), 3))]), _: 1 })) : u("", true), e(r).visible("totalPrice") ? (a(), s(n, { key: "totalPrice", prop: "totalPrice", align: "center", "min-width": "120", label: "金额" }, { default: h(({ row: t }) => [L(D("span", { class: M(t.status === 1 ? "tc-danger" : "") }, null, 2), [[J, { val: t.totalPrice || 0, dp: e(p).contract === 2 ? 3 : e(p).contract }]])]), _: 1 })) : u("", true), d(n, { label: "操作", align: "center", fixed: "right" }, { default: h(({ row: t }) => [d(O, { icon: "el-icon-view", type: "info", size: "default", onClick: Z((c) => A(t), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[K, e(o).loading]]), d(e(ue)), d(e(pe), { "detail-info": C.value }, null, 8, ["detail-info"])]);
  };
} };
export {
  Me as default
};
