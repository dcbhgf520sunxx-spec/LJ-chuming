import { inject as $ } from "vue";
import { ref as d } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as a } from "vue";
import { normalizeProps as E } from "vue";
import { guardReactiveProps as O } from "vue";
import { unref as t } from "vue";
import { withDirectives as V } from "vue";
import { createBlock as p } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as j } from "vue";
import { toDisplayString as D } from "vue";
import { createCommentVNode as f } from "vue";
import { mergeProps as P } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as q } from "../../../../../../modules/material-mode-V2-9ef0c850.js";
import { jX as L, x as A, o as I, cO as F, jl as K, cP as M, jG as z, jH as G, k5 as X, k6 as J, ux as Q, P as W } from "../../../../../../shared/runtime.js";
import Y from "./module/header.vue.js";
import { _ as Z } from "../../../../../../modules/material-print-button-3ec7d08d.js";
import "../../../../../../modules/use-print-7c5ddea7.js";
import "../../../../../../modules/wms-material-label-cf4447ff.js";
import "../../../../../../modules/warehouse-project-cascader-17e2b952.js";
import "../../../../../../modules/popover-confirm-35927771.js";
const ee = { class: "app-container" }, ue = { __name: "index", emits: ["printed-success"], setup(te, { emit: g }) {
  const N = g, C = { batchAdd: false, add: false, edit: false, del: false, download: false }, y = $("permission"), x = d([]), _ = d(), v = d([...L, ["createTime", "parse-time"]]), { CRUD: h, crud: n, columns: i } = A({ title: "打印标签-物料模式", sort: ["id.desc"], invisibleColumns: ["serialNumber"], permission: { ...y }, optShow: { ...C }, crudApi: { ...q } }, _), { maxHeight: S } = I({ paginate: true, extraHeight: 60 });
  h.HOOK.beforeRefresh = () => {
    N("printed-success");
  }, h.HOOK.handleRefresh = async (o, { data: l }) => {
    await F(l.content), l.content = await K(l.content, { toSmallest: false, toNum: false }), l.content.forEach((e) => {
      var m;
      e.projectShortName = (m = e.project) == null ? void 0 : m.shortName, e.basicClass === M.STEEL_COIL.V ? e.number = 1 : e.number = e.quantity, e.printedNumber = e.printedNumber || 0, e.printNumber = e.number - e.printedNumber, e.printNumber = e.printNumber > 0 ? e.printNumber : 1;
    });
  };
  function R(o) {
    o.printedNumber < o.number && n.refresh();
  }
  return (o, l) => {
    const e = U, m = b("table-cell-tag"), k = b("common-input-number"), w = b("common-table"), T = H;
    return r(), B("div", ee, [a(t(Y), E(O(o.$attrs)), null, 16), V((r(), p(w, { key: `material_label_print_material_mode_${t(n).query.basicClass}`, ref_key: "tableRef", ref: _, data: t(n).data, "data-format": v.value, "default-expand-all": false, "expand-row-keys": x.value, "max-height": t(S), showEmptySymbol: false, "row-key": "id", onSortChange: t(n).handleSortChange, onSelectionChange: t(n).selectionChangeHandler }, { default: c(() => [a(e, { align: "center", fixed: "left", type: "selection", width: "55" }), a(e, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: c(({ row: s, $index: u }) => [a(m, { show: s.printedNumber >= s.number, name: "已打印", type: "printed" }, null, 8, ["show"]), j("span", null, D(u + 1), 1)]), _: 1 }), a(z, { "basic-class": t(n).query.basicClass, columns: t(i), "show-index": false, fixed: "left", "spec-merge": "" }, null, 8, ["basic-class", "columns"]), a(G, { "basic-class": t(n).query.basicClass, columns: t(i) }, null, 8, ["basic-class", "columns"]), a(X, { "basic-class": t(n).query.basicClass, columns: t(i) }, null, 8, ["basic-class", "columns"]), a(J, { columns: t(i), "show-project": "" }, null, 8, ["columns"]), t(i).visible("receipt") ? (r(), p(e, { key: "receipt", "show-overflow-tooltip": true, align: "left", label: "单据编号", "min-width": "120", prop: "receipt" }, { default: c(({ row: s }) => [a(t(Q), { receipt: s.receipt ? s.receipt : [], "receipt-types": ["INBOUND", "OUTBOUND", "TRANSFER", "RETURN"] }, null, 8, ["receipt"])]), _: 1 })) : f("", true), t(i).visible("createTime") ? (r(), p(e, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "生成日期", prop: "createTime", sortable: "custom", width: "130" })) : f("", true), t(i).visible("printNumber") ? (r(), p(e, { key: "printNumber", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "批量打印数量", "min-width": "120", prop: "printNumber" }, { default: c(({ row: { sourceRow: s } }) => [a(k, { modelValue: s.printNumber, "onUpdate:modelValue": (u) => s.printNumber = u, max: 999, min: 1 }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : f("", true), a(e, { align: "center", fixed: "right", label: "操作", width: "70px" }, { default: c(({ row: { sourceRow: s } }) => [a(Z, P({ copies: t(n) ? t(n).props.copies : 1, material: s, number: s.printNumber, "submit-print-record": "" }, o.$attrs, { onPrintedSuccess: (u) => R(s) }), null, 16, ["copies", "material", "number", "onPrintedSuccess"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height", "onSortChange", "onSelectionChange"])), [[T, t(n).loading]]), a(t(W))]);
  };
} };
export {
  ue as default
};
