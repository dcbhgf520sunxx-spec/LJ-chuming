import { computed as h } from "vue";
import { ref as E } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as H } from "vue";
import { createBlock as z } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { withModifiers as q } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElInputNumber as L } from "element-plus";
import { ElForm as P } from "element-plus";
import { a_ as $, o as j, aw as K } from "../../../../../shared/runtime.js";
import { u as J } from "../../../../../modules/use-table-operate-4f84437f.js";
const Q = { style: { float: "right" } }, Z = { __name: "batch-form", props: { menuArr: { type: Array, default: () => [] }, disabledId: { type: Array, default: () => [] } }, setup(x) {
  const f = x, w = h(() => {
    var t;
    return [...((t = s.list) == null ? void 0 : t.map((i) => i.menuId)) || [], ...f.disabledId];
  }), C = { menuId: [{ required: true, message: "请选择模块", trigger: "change" }], scale: [{ required: true, message: "请输入小数精度", trigger: "change" }] }, k = { list: [] }, v = { menuId: void 0, scale: void 0 }, b = /* @__PURE__ */ new Map([]), _ = E(), { CRUD: c, crud: o, form: s, ADD_FORM: V } = $(k, _), g = h(() => o.bStatus.cu > c.STATUS.NORMAL), { init: R, addRow: S, removeRow: B } = J(v, 10, b), { tableValidate: I, cleanUpData: U, wrongCellMask: T } = K({ rules: C, ditto: b }), { maxHeight: A } = j({ mainBox: ".decimal-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, g);
  return V.init = () => R(s.list), c.HOOK.beforeValidateBCU = () => {
    const { validResult: d, dealList: t } = I(s.list);
    if (d) s.list = t;
    else return d;
  }, o.submitBatchFormFormat = (d) => U(d.list), (d, t) => {
    const i = m("common-button"), r = G, M = m("common-select"), N = L, O = m("common-table"), F = P, D = m("common-dialog");
    return H(), z(D, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(o).cancelBCU, visible: g.value, title: e(o).bStatus.title, "show-close": false, "custom-class": "decimal-batch-add", width: "700px", top: "10vh" }, { titleRight: a(() => [p("span", Q, [l(i, { size: "default", type: "success", icon: "el-icon-plus", onClick: t[0] || (t[0] = (n) => e(S)(e(s).list)) }), l(i, { loading: e(o).bStatus.cu === e(c).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(o).submitBCU }, { default: a(() => t[1] || (t[1] = [y(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), l(i, { size: "default", onClick: e(o).cancelBCU }, { default: a(() => t[2] || (t[2] = [y("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: a(() => [p("div", null, [l(F, { ref_key: "formRef", ref: _, model: e(s), disabled: e(o).bStatus.cu === e(c).STATUS.PROCESSING }, { default: a(() => [l(O, { data: e(s).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": e(A), "default-expand-all": "", "cell-class-name": e(T), style: { width: "100%" } }, { default: a(() => [l(r, { label: "序号", type: "index", align: "center", width: "60" }), l(r, { key: "menuId", prop: "menuId", "show-overflow-tooltip": true, label: "模块" }, { default: a(({ row: n }) => [l(M, { modelValue: n.menuId, "onUpdate:modelValue": (u) => n.menuId = u, options: f.menuArr, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, "disabled-val": w.value, placeholder: "模块", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled-val"])]), _: 1 }), l(r, { key: "type", prop: "type", label: "小数类型", width: "100px" }, { default: a(() => t[3] || (t[3] = [p("span", null, "单价", -1)])), _: 1 }), l(r, { key: "scale", prop: "scale", label: "小数精度", align: "center" }, { default: a(({ row: n }) => [l(N, { modelValue: n.scale, "onUpdate:modelValue": (u) => n.scale = u, modelModifiers: { number: true }, min: 1, max: 7, precision: 0, step: 1, placeholder: "小数精度", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(r, { label: "操作", width: "70px", align: "center", fixed: "right" }, { default: a(({ $index: n }) => [l(i, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: q((u) => e(B)(e(s).list, n), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]), _: 1 }, 8, ["model", "disabled"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  Z as default
};
