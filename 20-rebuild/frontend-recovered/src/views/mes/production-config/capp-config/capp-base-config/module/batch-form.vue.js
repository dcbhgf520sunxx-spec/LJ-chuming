import { ref as u } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as N } from "vue";
import { createBlock as O } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { createElementVNode as M } from "vue";
import { ElTableColumn as $ } from "element-plus";
import { ElInput as A } from "element-plus";
import { ElInputNumber as I } from "element-plus";
import { ElSwitch as K } from "element-plus";
import { ElForm as L } from "element-plus";
import { o as j, a_ as q, aS as p, i as g, aw as D, b as G } from "../../../../../../shared/runtime.js";
import { u as J } from "../../../../../../modules/use-table-operate-4f84437f.js";
const P = { class: "add-row-box" }, ee = { __name: "batch-form", setup(Q) {
  const b = u(), V = u(), h = { dictType: "", list: [] }, { maxHeight: v } = j({ wrapperBox: ".el-dialog__body", extraBox: [".el-dialog__header", ".add-row-box"], extraHeight: "15vh" }), { CRUD: _, crud: i, form: n } = q(h, b), y = { dictValue: [{ validator: (s, l) => !(G(l.dictValue) && g(l.sort)), trigger: "blur" }] }, x = /* @__PURE__ */ new Map([]), { init: w, addRow: k, removeRow: B } = J({ enabledFlag: p.TRUE.V }, 9, x), { tableValidate: C, wrongCellMask: F } = D({ rules: y }), R = u(false);
  return _.HOOK.beforeToBatchAdd = () => {
    w(n.list);
  }, _.HOOK.beforeValidateBCU = () => {
    const { validResult: s, dealList: l } = C(n.list);
    if (s) n.list = l;
    else return s;
  }, i.submitBatchFormFormat = (s) => ({ dictType: i.query.dictType, items: s.list.filter((r) => g(r.dictValue)) }), (s, l) => {
    const r = m("common-button"), c = $, U = A, E = I, T = K, S = m("common-table"), z = L, H = m("common-dialog");
    return N(), O(H, { "before-close": e(i).cancelBCU, "close-on-click-modal": false, title: e(i).bStatus.title, visible: e(i).bStatus.cu > 0, "append-to-body": "", top: "5vh", width: "800px" }, { titleRight: o(() => [t(r, { loading: R.value, size: "default", type: "primary", onClick: e(i).submitBCU }, { default: o(() => l[1] || (l[1] = [f("保存")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), default: o(() => [M("div", P, [t(r, { size: "default", type: "success", onClick: l[0] || (l[0] = (a) => e(k)(e(n).list)) }, { default: o(() => l[2] || (l[2] = [f(" 添加 ")])), _: 1, __: [2] })]), t(z, { ref_key: "formRef", ref: b, model: e(n), "label-width": "130px", size: "default" }, { default: o(() => [t(S, { ref_key: "detailRef", ref: V, "cell-class-name": e(F), data: e(n).list, "max-height": e(v), showEmptySymbol: false, stripe: false, border: "", class: "table-form", "return-source-data": "", style: { width: "100%", "margin-top": "10px" } }, { default: o(() => [t(c, { align: "center", label: "序号", type: "index", width: "50" }), t(c, { key: "dictValue", prop: "dictValue", align: "center", label: "*字典值", "min-width": "100" }, { default: o(({ row: a }) => [t(U, { modelValue: a.dictValue, "onUpdate:modelValue": (d) => a.dictValue = d, modelModifiers: { trim: true }, clearable: "", placeholder: "字典值", class: "input-border-none", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(c, { key: "sort", prop: "sort", align: "center", label: "排序", "min-width": "100" }, { default: o(({ row: a }) => [t(E, { modelValue: a.sort, "onUpdate:modelValue": (d) => a.sort = d, clearable: "", placeholder: "排序", min: 1, max: 9999999, class: "input-border-none", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(c, { key: "enabledFlag", prop: "enabledFlag", align: "center", label: "状态", "min-width": "100" }, { default: o(({ row: a }) => [t(T, { modelValue: a.enabledFlag, "onUpdate:modelValue": (d) => a.enabledFlag = d, "active-color": "#409EFF", "inactive-color": "#F56C6C", size: "default", "active-value": e(p).TRUE.V, "inactive-value": e(p).FALSE.V }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value"])]), _: 1 }), t(c, { align: "center", label: "操作", width: "100" }, { default: o((a) => [t(r, { icon: "el-icon-delete", size: "small", type: "danger", onClick: (d) => e(B)(e(n).list, a.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} };
export {
  ee as default
};
