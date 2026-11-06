import { ref as m } from "vue";
import { inject as E } from "vue";
import { resolveComponent as Q } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as d } from "vue";
import { createBlock as x } from "vue";
import { withCtx as g } from "vue";
import { toDisplayString as f } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as U } from "vue";
import { withDirectives as D } from "vue";
import { createVNode as t } from "vue";
import { mergeProps as O } from "vue";
import { Fragment as T } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElPagination as R } from "element-plus";
import { vLoading as W } from "element-plus";
import { tC as $, J as F, b as H, u_ as J, u$ as K, i as L, V as X, bW as A, iX as M } from "../../../../../../../shared/runtime.js";
const Y = { class: "requisitions-application-header-class" }, ae = { __name: "structure-table", setup(Z, { expose: V }) {
  const r = m([]), P = m([]), y = m(false), w = m([]), { form: u } = $(), s = E("customQuery"), { handleSizeChange: k, handleCurrentChange: q, total: z, setTotalPage: S, queryPage: b } = F({ fetchHook: v });
  function j(n) {
    return !!n.canPurchaseQuantity;
  }
  async function v() {
    var n;
    if (r.value = [], w.value = [], s.value.structureClassId = void 0, !H(s.value.projectId)) try {
      const { content: o } = await J({ ...s.value });
      o != null && o.length && (r.value = o, s.value.structureClassId = (n = o[0]) == null ? void 0 : n.id, _());
    } catch (o) {
      console.log(o, "获取构件类型");
    }
  }
  async function _() {
    try {
      y.value = true;
      const { content: n, totalElements: o } = await K({ ...s.value, ...b });
      w.value = n.map((e) => {
        var c, p, h;
        let i = e.purchaseQuantity;
        if (L((c = u.originListObj) == null ? void 0 : c[e.id]) && (i = i - ((h = (p = u.originListObj) == null ? void 0 : p[e.id]) == null ? void 0 : h.quantity)), L(u.purchaseListObj[e.id])) {
          const a = X(u.purchaseListObj[e.id]);
          e.canPurchaseQuantity = e.quantity - i - a.curPurchaseQuantity;
        } else e.canPurchaseQuantity = e.quantity - i;
        return e.canPurchaseQuantity = e.canPurchaseQuantity > 0 ? e.canPurchaseQuantity : 0, e.curPurchaseQuantity = e.canPurchaseQuantity, e.measureUnit = "件", e.accountingUnit = "千克", e;
      }), S(o);
    } catch (n) {
      console.log(n, "获取成品清单");
    } finally {
      y.value = false;
    }
  }
  function B(n) {
    P.value = n;
  }
  return V({ refresh: v, refreshList: _, selectList: P }), (n, o) => {
    const e = G, i = Q("common-input-number"), c = Q("common-table"), p = R, h = W;
    return C(), I(T, null, [d("div", Y, [r.value.length ? (C(), x(l(A), { key: 0, modelValue: l(s).structureClassId, "onUpdate:modelValue": o[0] || (o[0] = (a) => l(s).structureClassId = a), class: "filter-item", style: { width: "100%", display: "inline-block", "margin-bottom": "10px" }, data: r.value, itemKey: "id", onChange: _ }, { default: g(({ item: a }) => [d("span", null, f(a.name) + "(件/kg)：", 1), d("span", null, f(a.quantity) + "/" + f(a.mete), 1)]), _: 1 }, 8, ["modelValue", "data"])) : U("", true)]), D((C(), x(c, O(n.$attrs, { data: w.value, style: { width: "100%" }, onSelectionChange: B }), { default: g(() => [t(e, { type: "selection", width: "55", align: "center", selectable: j }), t(e, { label: "序号", type: "index", align: "center", width: "60" }), t(e, { prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), t(e, { prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), t(e, { prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), t(e, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), t(e, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "140px" }), t(e, { prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": "" }), t(e, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }), t(e, { prop: "quantity", label: "清单数量", align: "center", "show-overflow-tooltip": "" }), t(e, { prop: "canPurchaseQuantity", label: "可采购数量", align: "center", "show-overflow-tooltip": "" }), t(e, { label: "采购数量", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }, { default: g(({ row: { sourceRow: a } }) => [t(i, { modelValue: a.curPurchaseQuantity, "onUpdate:modelValue": (N) => a.curPurchaseQuantity = N, min: 0, max: a.canPurchaseQuantity, "controls-position": "right", controls: false, step: 5, size: "default", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), t(e, { label: "总重（kg）", align: "center", "show-overflow-tooltip": "" }, { default: g(({ row: { sourceRow: a } }) => [d("span", null, f(l(M)(a.curPurchaseQuantity * a.netWeight, 2)), 1)]), _: 1 })]), _: 1 }, 16, ["data"])), [[h, y.value]]), t(p, { total: l(z), "current-page": l(b).pageNumber, "page-size": l(b).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(k), onCurrentChange: l(q) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 64);
  };
} };
export {
  ae as default
};
