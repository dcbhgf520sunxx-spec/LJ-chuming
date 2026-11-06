import { ref as E } from "vue";
import { computed as F } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as M } from "vue";
import { createBlock as A } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { withModifiers as L } from "vue";
import { ElTableColumn as D } from "element-plus";
import { ElInput as I } from "element-plus";
import { ElInputNumber as q } from "element-plus";
import { ElForm as j } from "element-plus";
import { a_ as G, aw as P } from "../../../../../../../shared/runtime.js";
import { u as $ } from "../../../../../../../modules/use-table-operate-4f84437f.js";
const H = { style: { float: "right" } }, K = { style: { "text-align": "center" } }, X = { __name: "form", props: { currentLine: Object }, setup(h) {
  const b = E(), y = { classConfigs: [] }, _ = h, C = { name: void 0, behaviorScore: void 0, penalty: void 0 }, v = { name: [{ required: true, message: "请输入名称", trigger: "blur" }], behaviorScore: [{ required: true, max: 4, message: "请输入行为分", trigger: "change" }], penalty: [{ required: true, message: "请输入罚金", trigger: "blur" }] }, { CRUD: u, crud: s, form: n, ADD_FORM: S } = G(y, b), w = F(() => s.bStatus.cu > u.STATUS.NORMAL), { init: V, addRow: x, removeRow: k } = $(C, 1), { tableValidate: U, cleanUpData: R, wrongCellMask: O } = P({ rules: v });
  return S.init = () => {
    V(n.classConfigs);
  }, u.HOOK.beforeValidateBCU = () => {
    const { validResult: i, dealList: a } = U(n.classConfigs);
    if (i) n.classConfigs = a.filter((r) => r.name !== void 0), n.pid = _.currentLine.id, n.factoryOrConstructionSite = _.currentLine.factoryOrConstructionSite;
    else return i;
  }, s.submitBatchFormFormat = (i) => (R(i.classConfigs), i), (i, a) => {
    const r = m("common-button"), c = D, g = I, T = q, B = m("common-table"), N = j, z = m("common-dialog");
    return M(), A(z, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(s).cancelCU, visible: w.value, title: e(s).bStatus.title, "show-close": false, "custom-class": "warehouse-batch-add", width: "800px", top: "10vh" }, { titleRight: l(() => [p("span", H, [t(r, { loading: e(s).bStatus.cu === e(u).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(s).submitBCU }, { default: l(() => a[1] || (a[1] = [f(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), t(r, { size: "default", onClick: e(s).cancelBCU }, { default: l(() => a[2] || (a[2] = [f("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: l(() => [p("div", null, [t(N, { ref_key: "formRef", ref: b, model: e(n), disabled: e(s).bStatus.cu === e(u).STATUS.PROCESSING }, { default: l(() => [t(B, { data: e(n).classConfigs, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": "500px", "default-expand-all": "", "cell-class-name": e(O), "row-key": "pid" }, { default: l(() => [t(c, { label: "序号", type: "index", align: "center", width: "60" }), t(c, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "二级分类", width: "220" }, { default: l(({ row: o }) => [t(g, { modelValue: o.name, "onUpdate:modelValue": (d) => o.name = d, modelModifiers: { trim: true }, type: "text", clearable: "", placeholder: "二级分类名称", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(c, { key: "behaviorScore", prop: "behaviorScore", "show-overflow-tooltip": true, label: "行为分" }, { default: l(({ row: o }) => [t(g, { modelValue: o.behaviorScore, "onUpdate:modelValue": (d) => o.behaviorScore = d, oninput: "value=value.replace(/[^0-9.]/g, '').replace(/\\./g,'')", clearable: "", placeholder: "请输入", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(c, { key: "penalty", prop: "penalty", "show-overflow-tooltip": true, label: "处罚（元）" }, { default: l(({ row: o }) => [t(T, { modelValue: o.penalty, "onUpdate:modelValue": (d) => o.penalty = d, modelModifiers: { number: true }, min: 0, max: 9999999, step: 1, precision: 2, "controls-position": "right", placeholder: "请输入罚金" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(c, { label: "操作", width: "55", align: "center", fixed: "right" }, { default: l(({ $index: o }) => [t(r, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: L((d) => e(k)(e(n).classConfigs, o), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"]), p("div", K, [t(r, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-top": "15px" }, onClick: a[0] || (a[0] = (o) => e(x)(e(n).classConfigs)) }, { default: l(() => a[3] || (a[3] = [f(" 添加 ")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model", "disabled"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  X as default
};
