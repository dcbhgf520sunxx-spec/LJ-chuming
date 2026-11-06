import { ref as A } from "vue";
import { computed as H } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as p } from "vue";
import { createBlock as f } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as x } from "vue";
import { withModifiers as I } from "vue";
import { createCommentVNode as G } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElInput as L } from "element-plus";
import { ElForm as P } from "element-plus";
import { cW as w, a_ as $, o as j, b4 as K, aw as W } from "../../../../../shared/runtime.js";
import { u as J } from "../../../../../modules/use-table-operate-4f84437f.js";
const Q = { style: { float: "right" } }, te = { __name: "batch-form", setup(X) {
  const V = { name: [{ required: true, max: 20, message: "不能超过20个字符", trigger: "blur" }], symbol: [{ max: 3, message: "不能超过3个字符", trigger: "blur" }], type: [{ required: true, message: "请选择单位类型", trigger: "change" }] }, C = { list: [] }, k = { name: void 0, symbol: void 0, type: w.DIGIT.V }, _ = /* @__PURE__ */ new Map([["type", -1]]), b = A(), { CRUD: r, crud: a, form: n, ADD_FORM: U } = $(C, b), y = H(() => a.bStatus.cu > r.STATUS.NORMAL), { init: B, addRow: R, removeRow: S } = J(k, 10, _), { tableValidate: v, cleanUpData: T, wrongCellMask: M } = W({ rules: V, ditto: _ }), { maxHeight: N } = j({ mainBox: ".unit-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, y);
  return U.init = () => B(n.list), r.HOOK.beforeValidateBCU = () => {
    const { validResult: d, dealList: s } = v(n.list);
    if (d) n.list = s;
    else return d;
  }, a.submitBatchFormFormat = (d) => T(d.list), (d, s) => {
    const c = u("common-button"), m = q, h = L, E = u("common-select"), O = u("common-table"), z = P, D = u("common-dialog");
    return p(), f(D, { "before-close": e(a).cancelBCU, "close-on-click-modal": false, "show-close": false, title: e(a).bStatus.title, visible: y.value, "append-to-body": "", "custom-class": "unit-batch-add", top: "10vh", width: "700px" }, { titleRight: o(() => [g("span", Q, [t(c, { icon: "el-icon-plus", size: "mini", type: "success", onClick: s[0] || (s[0] = (l) => e(R)(e(n).list)) }), t(c, { loading: e(a).bStatus.cu === e(r).STATUS.PROCESSING, size: "mini", type: "primary", onClick: e(a).submitBCU }, { default: o(() => s[1] || (s[1] = [x(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), t(K, { type: "crudBatch" }), t(c, { size: "default", onClick: e(a).cancelBCU, style: { "margin-left": "6px" } }, { default: o(() => s[2] || (s[2] = [x("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: o(() => [g("div", null, [t(z, { ref_key: "formRef", ref: b, disabled: e(a).bStatus.cu === e(r).STATUS.PROCESSING, model: e(n) }, { default: o(() => [t(O, { "cell-class-name": e(M), data: e(n).list, "max-height": e(N), "show-empty-symbol": false, "default-expand-all": "", "empty-text": "暂无数据", "return-source-data": "", style: { width: "100%" } }, { default: o(() => [t(m, { align: "center", label: "序号", type: "index", width: "60" }), t(m, { key: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "150", prop: "name" }, { default: o(({ row: l }) => [t(h, { modelValue: l.name, "onUpdate:modelValue": (i) => l.name = i, modelModifiers: { trim: true }, clearable: "", placeholder: "名称", size: "default", style: { width: "100%" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(m, { key: "symbol", "show-overflow-tooltip": true, label: "符号", prop: "symbol", width: "125" }, { default: o(({ row: l }) => [t(h, { modelValue: l.symbol, "onUpdate:modelValue": (i) => l.symbol = i, modelModifiers: { trim: true }, maxlength: "3", placeholder: "符号", size: "small", style: { width: "100%" }, type: "text" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(m, { key: "type", label: "类型", prop: "type", width: "192" }, { default: o(({ row: l, $index: i }) => [(p(), f(E, { key: Math.random(), modelValue: l.type, "onUpdate:modelValue": (F) => l.type = F, options: e(w).ENUM, "show-extra": i !== 0, placeholder: "类型", style: { width: "170px" }, type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"]))]), _: 1 }), t(m, { align: "center", fixed: "right", label: "操作", width: "70px" }, { default: o(({ $index: l }) => [l > 0 ? (p(), f(c, { key: 0, icon: "el-icon-delete", size: "default", style: { padding: "6px" }, type: "danger", onClick: I((i) => e(S)(e(n).list, l), ["stop"]) }, null, 8, ["onClick"])) : G("", true)]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "data", "max-height"])]), _: 1 }, 8, ["disabled", "model"])])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} };
export {
  te as default
};
