import { inject as B } from "vue";
import { ref as p } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as O } from "vue";
import { createVNode as a } from "vue";
import { normalizeProps as D } from "vue";
import { guardReactiveProps as E } from "vue";
import { unref as e } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as u } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as H } from "vue";
import { createCommentVNode as b } from "vue";
import { mergeProps as P } from "vue";
import { ElTableColumn as j } from "element-plus";
import { vLoading as q } from "element-plus";
import { l as L, jX as A, x as I, o as F, cO as K, jl as M, am as z, jG as G, jH as X, k5 as J, k6 as Q, ux as W, P as Y } from "../../../../shared/runtime.js";
import Z from "./module/header.vue.js";
import { _ as ee } from "../../../../modules/material-print-button-3ec7d08d.js";
import "../../../../modules/use-print-d47bc68b.js";
import "../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../modules/popover-confirm-35927771.js";
function te(f) {
  return L({ module: "wms", url: "material/label-print/material-mode", method: "get", params: f });
}
const ae = { get: te }, se = { class: "app-container" }, pe = { __name: "index", emits: ["printed-success"], setup(f, { emit: g }) {
  const C = g, N = { batchAdd: false, add: false, edit: false, del: false, download: false }, x = B("permission"), y = p([]), _ = p(), v = p([...A, ["createTime", "parse-time"]]), { CRUD: h, crud: s, columns: i } = I({ title: "打印标签-物料模式", sort: ["id.desc"], invisibleColumns: ["serialNumber"], permission: { ...x }, optShow: { ...N }, crudApi: { ...ae } }, _), { maxHeight: w } = F({ paginate: true, extraHeight: 60 });
  h.HOOK.beforeRefresh = () => {
    C("printed-success");
  }, h.HOOK.handleRefresh = async (l, { data: o }) => {
    await K(o.content), o.content = await M(o.content, { toSmallest: false, toNum: false }), o.content.forEach((t) => {
      t.basicClass === z.STEEL_COIL.V ? t.number = 1 : t.number = t.quantity, t.printedNumber = t.printedNumber || 0, t.printNumber = t.number - t.printedNumber, t.printNumber = t.printNumber > 0 ? t.printNumber : 1;
    });
  };
  function R(l) {
    l.printedNumber < l.number && s.refresh();
  }
  return (l, o) => {
    const t = j, S = d("table-cell-tag"), k = d("common-input-number"), T = d("common-table"), $ = q;
    return r(), O("div", se, [a(e(Z), D(E(l.$attrs)), null, 16), U((r(), u(T, { key: `material_label_print_material_mode_${e(s).query.basicClass}`, ref_key: "tableRef", ref: _, data: e(s).data, "data-format": v.value, "max-height": e(w), "default-expand-all": false, "expand-row-keys": y.value, "row-key": "id", onSortChange: e(s).handleSortChange, onSelectionChange: e(s).selectionChangeHandler }, { default: c(() => [a(t, { type: "selection", width: "55", align: "center", fixed: "left" }), a(t, { label: "序号", type: "index", align: "center", width: "55", fixed: "left" }, { default: c(({ row: n, $index: m }) => [a(S, { show: n.printedNumber >= n.number, name: "已打印", type: "printed" }, null, 8, ["show"]), V("span", null, H(m + 1), 1)]), _: 1 }), a(G, { columns: e(i), "basic-class": e(s).query.basicClass, "spec-merge": "", fixed: "left", "show-index": false }, null, 8, ["columns", "basic-class"]), a(X, { columns: e(i), "basic-class": e(s).query.basicClass }, null, 8, ["columns", "basic-class"]), a(J, { columns: e(i), "basic-class": e(s).query.basicClass }, null, 8, ["columns", "basic-class"]), a(Q, { columns: e(i), "show-project": "" }, null, 8, ["columns"]), e(i).visible("receipt") ? (r(), u(t, { key: "receipt", "show-overflow-tooltip": true, prop: "receipt", label: "单据编号", align: "left", "min-width": "120" }, { default: c(({ row: n }) => [a(e(W), { "receipt-types": ["INBOUND", "OUTBOUND", "TRANSFER", "RETURN"], receipt: n.receipt }, null, 8, ["receipt"])]), _: 1 })) : b("", true), e(i).visible("createTime") ? (r(), u(t, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "生成日期", align: "center", width: "130", sortable: "custom" })) : b("", true), e(i).visible("printNumber") ? (r(), u(t, { key: "printNumber", "show-overflow-tooltip": true, prop: "printNumber", label: "批量打印数量", align: "center", fixed: "right", "min-width": "120" }, { default: c(({ row: { sourceRow: n } }) => [a(k, { modelValue: n.printNumber, "onUpdate:modelValue": (m) => n.printNumber = m, min: 1, max: 999 }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : b("", true), a(t, { label: "操作", width: "70px", align: "center", fixed: "right" }, { default: c(({ row: { sourceRow: n } }) => [a(ee, P(l.$attrs, { material: n, number: n.printNumber, copies: e(s) ? e(s).props.copies : 1, "submit-print-record": "", onPrintedSuccess: (m) => R(n) }), null, 16, ["material", "number", "copies", "onPrintedSuccess"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys", "onSortChange", "onSelectionChange"])), [[$, e(s).loading]]), a(e(Y))]);
  };
} };
export {
  pe as default
};
