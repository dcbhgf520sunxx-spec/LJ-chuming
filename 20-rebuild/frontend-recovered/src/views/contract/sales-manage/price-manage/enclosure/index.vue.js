import { ref as g } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as w } from "vue";
import { mergeProps as Y } from "vue";
import { unref as e } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as l } from "vue";
import { withCtx as p } from "vue";
import { createCommentVNode as s } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as b } from "vue";
import { normalizeClass as D } from "vue";
import { ElMessage as Z } from "element-plus";
import { ElTableColumn as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { c as oe, _ as ae } from "./module/header.vue.js";
import { O as ie } from "../../../../../modules/contract-9b18cc88.js";
import { t as le, x as ne, o as se, T as v, D as N, iB as T, bV as re, P as ce, aw as ue, i as de } from "../../../../../shared/runtime.js";
import "../preview.vue.js";
import "../../../../../modules/common-913d415d.js";
import "../../../../../modules/index-61ce89a1.js";
const ve = { __name: "index", props: { category: { type: Object } }, emits: ["showLog"], setup(S, { expose: I, emit: A }) {
  const { decimalPrecision: m } = le(), _ = S, R = { add: false, edit: false, del: false, download: false }, B = A, M = g(), P = g(), k = g(false), h = g([]), x = g([]), { crud: r, columns: n } = ne({ title: "围护价格", sort: [], permission: { ...ie }, crudApi: { ...oe }, optShow: { ...R }, requiredQuery: ["enclosurePlanId"] }, M), { maxHeight: U } = se({ paginate: true, extraHeight: 100 }), W = { unitPrice: [{ validator: (i, d) => de(i), message: "请填写单价", trigger: ["blur", "change"] }] }, H = /* @__PURE__ */ new Map([["unitPrice", "同上"]]);
  function G(i) {
    return i.status !== 1;
  }
  const { tableValidate: O, cleanUpData: Q, wrongCellMask: F } = ue({ rules: W, ditto: H });
  function $() {
    B("showLog");
  }
  function q(i) {
    x.value = [], r.selectionChangeHandler(i), r.selections.sort(function(d, o) {
      return d.orderIndex - o.orderIndex;
    }), i.forEach((d) => {
      x.value.push(d.id);
    });
  }
  async function z(i) {
    h.value = [];
    const d = r.selections.map((c) => c), { validResult: o, dealList: y } = O(d);
    if (k.value = false, o) {
      if (Q(y), h.value = y.filter((c) => c.unitPrice !== c.originUnitPrice && (typeof c.originUnitPrice == "number" && c.originUnitPrice > 0 || c.unitPrice > 0)), h.value.length === 0) {
        Z.error("请修改至少一条数据");
        return;
      }
      k.value = !!h.value.length;
    }
  }
  function j(i) {
    i.totalPrice = (i.pricingManner === T.LENGTH.V ? i.totalLength : i.totalArea) * (i.unitPrice && typeof i.unitPrice == "number" ? i.unitPrice : 0);
  }
  return I({ refresh: r.refresh }), (i, d) => {
    const o = ee, y = C("common-input-number"), c = C("common-table"), J = X("thousand"), K = te;
    return a(), E("div", null, [w(e(ae), Y({ ref_key: "headerRef", ref: P }, i.$attrs, { onCheckSubmit: z, showAble: k.value, rowIds: x.value, submitList: h.value, onShowVisible: $ }), null, 16, ["showAble", "rowIds", "submitList"]), L((a(), l(c, { ref_key: "tableRef", ref: M, data: e(r).data, "return-source-data": "", style: { width: "100%" }, class: "businessTable", "max-height": e(U), showEmptySymbol: false, "cell-class-name": e(F), onSelectionChange: q }, { default: p(() => [w(o, { type: "selection", align: "center", width: "60", class: "selection", selectable: G }), w(o, { label: "序号", type: "index", align: "center", width: "60" }), e(n).visible("name") ? (a(), l(o, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称", align: "center", "min-width": "120" })) : s("", true), e(n).visible("plate") && _.category !== e(v).BENDING.V ? (a(), l(o, { key: "plate", prop: "plate", "show-overflow-tooltip": "", label: "板型", align: "center", width: "100" })) : s("", true), e(n).visible("thickness") ? (a(), l(o, { key: "thickness", prop: "thickness", "show-overflow-tooltip": "", label: "厚度(mm)", align: "center" }, { default: p(({ row: t }) => [f("span", null, b(t.thickness ? t.thickness.toFixed(e(N).MES_ENCLOSURE_T__MM) : ""), 1)]), _: 1 })) : s("", true), e(n).visible("unfoldedWidth") && _.category === e(v).BENDING.V ? (a(), l(o, { key: "unfoldedWidth", prop: "unfoldedWidth", "show-overflow-tooltip": "", label: "展开宽度(mm)", align: "center" }, { default: p(({ row: t }) => [f("span", null, b(t.unfoldedWidth ? t.unfoldedWidth.toFixed(e(N).MES_ENCLOSURE_W__MM) : ""), 1)]), _: 1 })) : s("", true), e(n).visible("bendTimes") && _.category === e(v).BENDING.V ? (a(), l(o, { key: "bendTimes", prop: "bendTimes", "show-overflow-tooltip": "", label: "折弯次数", align: "center" })) : s("", true), e(n).visible("brand") ? (a(), l(o, { key: "brand", prop: "brand", "show-overflow-tooltip": "", label: "品牌", align: "center" })) : s("", true), e(n).visible("color") ? (a(), l(o, { key: "color", prop: "color", "show-overflow-tooltip": "", label: "颜色", align: "center", width: "100" })) : s("", true), e(n).visible("totalQuantity") ? (a(), l(o, { key: "totalQuantity", prop: "totalQuantity", "show-overflow-tooltip": true, label: "数量(张)", align: "center", width: "100" })) : s("", true), e(n).visible("totalArea") ? (a(), l(o, { key: "totalArea", prop: "totalArea", "show-overflow-tooltip": "", label: "总面积(㎡)", align: "center" })) : s("", true), e(n).visible("totalLength") ? (a(), l(o, { key: "totalLength", prop: "totalLength", "show-overflow-tooltip": "", label: "总长度(m)", align: "center" })) : s("", true), e(n).visible("category") ? (a(), l(o, { key: "category", prop: "category", "show-overflow-tooltip": "", label: "类别", align: "center" }, { default: p(({ row: t }) => {
      var u, V;
      return [f("span", null, b((V = (u = e(v).V) == null ? void 0 : u[t.category]) == null ? void 0 : V.L), 1)];
    }), _: 1 })) : s("", true), e(n).visible("pricingManner") ? (a(), l(o, { key: "pricingManner", prop: "pricingManner", "show-overflow-tooltip": "", label: "计价方式", align: "center" }, { default: p(({ row: t }) => [f("span", null, b(e(T).VL[t.pricingManner]), 1)]), _: 1 })) : s("", true), e(n).visible("unitPrice") ? (a(), l(o, { key: "unitPrice", prop: "unitPrice", "show-overflow-tooltip": true, label: "综合单价", align: "center", "min-width": "120" }, { default: p(({ row: t }) => [P.value && P.value.modifying && e(r).selections && e(r).selections.findIndex((u) => u.id === t.id) > -1 ? (a(), l(y, { key: 0, modelValue: t.unitPrice, "onUpdate:modelValue": (u) => t.unitPrice = u, step: 1, min: 0, max: 99999999, precision: e(m).contract === 2 ? 3 : e(m).contract, placeholder: e(r).selections.findIndex((u) => u.id === t.id) === 0 ? "" : t.unitPrice || "", size: "default", style: { width: "100%" }, onChange: (u) => j(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "placeholder", "onChange"])) : (a(), E("span", { key: 1, class: D(t.status === 1 ? "tc-danger" : "") }, b(t.unitPrice !== "同上" ? e(re)(t.unitPrice, e(m).contract === 2 ? 3 : e(m).contract) : "-"), 3))]), _: 1 })) : s("", true), e(n).visible("totalPrice") ? (a(), l(o, { key: "totalPrice", prop: "totalPrice", align: "center", "min-width": "120", label: "金额" }, { default: p(({ row: t }) => [L(f("span", { class: D(t.status === 1 ? "tc-danger" : "") }, null, 2), [[J, { val: t.totalPrice || 0, dp: e(m).contract === 2 ? 3 : e(m).contract }]])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[K, e(r).loading]]), w(e(ce))]);
  };
} };
export {
  ve as default
};
