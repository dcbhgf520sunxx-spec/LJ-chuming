import { ref as j } from "vue";
import { computed as N } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as F } from "vue";
import { createBlock as z } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { withModifiers as M } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElInput as D } from "element-plus";
import { ElForm as L } from "element-plus";
import { a_ as I, K as b, aw as q } from "../../../../../../shared/runtime.js";
import { u as G } from "../../../../../../modules/use-table-operate-4f84437f.js";
const K = { style: { float: "right" } }, P = { style: { "text-align": "center" } }, W = { __name: "batchForm", setup($) {
  const _ = j(), y = { structureTypeConfig: [] }, g = { name: void 0, projectType: void 0 }, C = { name: [{ required: true, message: "请填写类型名称", trigger: "blur" }], projectType: [{ required: true, message: "请选择项目类型", trigger: "change" }] }, { CRUD: u, crud: a, form: s, ADD_FORM: T } = I(y, _), h = N(() => a.bStatus.cu > u.STATUS.NORMAL), { init: w, addRow: V, removeRow: S } = G(g, 1), { tableValidate: k, cleanUpData: U, wrongCellMask: v } = q({ rules: C });
  return T.init = () => {
    w(s.structureTypeConfig);
  }, u.HOOK.beforeValidateBCU = () => {
    const { validResult: i, dealList: o } = k(s.structureTypeConfig);
    if (i) s.structureTypeConfig = o.filter((r) => r.name !== void 0);
    else return i;
  }, a.submitBatchFormFormat = (i) => (U(i.structureTypeConfig), i), (i, o) => {
    const r = m("common-button"), c = A, x = D, R = m("common-select"), O = m("common-table"), B = L, E = m("common-dialog");
    return F(), z(E, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(a).cancelCU, visible: h.value, title: e(a).bStatus.title, "show-close": false, "custom-class": "structure-type-config-batch-add", width: "600px", top: "10vh" }, { titleRight: l(() => [p("span", K, [t(r, { loading: e(a).bStatus.cu === e(u).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(a).submitBCU }, { default: l(() => o[1] || (o[1] = [f(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), t(r, { size: "default", onClick: e(a).cancelBCU }, { default: l(() => o[2] || (o[2] = [f("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: l(() => [p("div", null, [t(B, { ref_key: "formRef", ref: _, model: e(s), disabled: e(a).bStatus.cu === e(u).STATUS.PROCESSING }, { default: l(() => [t(O, { data: e(s).structureTypeConfig, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": "500px", "default-expand-all": "", "cell-class-name": e(v), "row-key": "pid" }, { default: l(() => [t(c, { label: "序号", type: "index", align: "center", width: "60" }), t(c, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "类型名称", "min-width": "180" }, { default: l(({ row: n }) => [t(x, { modelValue: n.name, "onUpdate:modelValue": (d) => n.name = d, modelModifiers: { trim: true }, clearable: "", placeholder: "请填写类型名称", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(c, { key: "projectType", prop: "projectType", "show-overflow-tooltip": true, label: "项目类型", "min-width": "120" }, { default: l(({ row: n }) => [t(R, { modelValue: n.projectType, "onUpdate:modelValue": (d) => n.projectType = d, options: e(b).ENUM, dataStructure: { key: "V", label: "SL", value: "V" }, unshowOptions: [e(b).ENCLOSURE.V], clearable: "", placeholder: "请选择项目类型", size: "default", style: { width: "100%" }, type: "other" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshowOptions"])]), _: 1 }), t(c, { label: "操作", width: "55", align: "center", fixed: "right" }, { default: l(({ $index: n }) => [t(r, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: M((d) => e(S)(e(s).structureTypeConfig, n), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"]), p("div", P, [t(r, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-top": "15px" }, onClick: o[0] || (o[0] = (n) => e(V)(e(s).structureTypeConfig)) }, { default: l(() => o[3] || (o[3] = [f(" 添加 ")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model", "disabled"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  W as default
};
