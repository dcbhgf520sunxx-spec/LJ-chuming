import { ref as A } from "vue";
import { computed as L } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as M } from "vue";
import { createBlock as D } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { withModifiers as I } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElInput as j } from "element-plus";
import { ElInputNumber as G } from "element-plus";
import { ElSwitch as P } from "element-plus";
import { ElForm as $ } from "element-plus";
import { a_ as H, au as y, aw as K } from "../../../../../../../shared/runtime.js";
import { u as J } from "../../../../../../../modules/use-table-operate-4f84437f.js";
const Q = { style: { float: "right" } }, W = { style: { "text-align": "center" } }, ee = { __name: "form", props: { currentLine: Object }, setup(h) {
  const b = A(), v = { safetyConfigs: [] }, _ = h, C = { name: void 0, behaviorScore: void 0, penalty: void 0, boolUpdate: false }, w = { name: [{ required: true, max: 8, message: "请输入名称", trigger: "blur" }], behaviorScore: [{ required: true, max: 4, message: "请输入行为分", trigger: "change" }], penalty: [{ required: true, message: "请输入罚金", trigger: "blur" }] }, { CRUD: c, crud: i, form: n, ADD_FORM: V } = H(v, b), S = L(() => i.bStatus.cu > c.STATUS.NORMAL), { init: U, addRow: x, removeRow: k } = J(C, 1), { tableValidate: R, cleanUpData: T, wrongCellMask: B } = K({ rules: w });
  return V.init = () => {
    U(n.safetyConfigs);
  }, c.HOOK.beforeValidateBCU = () => {
    const { validResult: r, dealList: a } = R(n.safetyConfigs);
    if (r) n.safetyConfigs = a.filter((d) => d.name !== void 0), n.pid = _.currentLine.id, n.factoryOrConstructionSite = _.currentLine.factoryOrConstructionSite;
    else return r;
  }, i.submitBatchFormFormat = (r) => (T(r.safetyConfigs), r), (r, a) => {
    const d = m("common-button"), u = q, g = j, E = G, O = P, F = m("common-table"), N = $, z = m("common-dialog");
    return M(), D(z, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(i).cancelCU, visible: S.value, title: e(i).bStatus.title, "show-close": false, "custom-class": "warehouse-batch-add", width: "800px", top: "10vh" }, { titleRight: l(() => [p("span", Q, [t(d, { loading: e(i).bStatus.cu === e(c).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(i).submitBCU }, { default: l(() => a[1] || (a[1] = [f(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), t(d, { size: "default", onClick: e(i).cancelBCU }, { default: l(() => a[2] || (a[2] = [f("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: l(() => [p("div", null, [t(N, { ref_key: "formRef", ref: b, model: e(n), disabled: e(i).bStatus.cu === e(c).STATUS.PROCESSING }, { default: l(() => [t(F, { data: e(n).safetyConfigs, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": "500px", "default-expand-all": "", "cell-class-name": e(B), "row-key": "pid" }, { default: l(() => [t(u, { label: "序号", type: "index", align: "center", width: "60" }), t(u, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "二级分类", width: "220" }, { default: l(({ row: o }) => [t(g, { modelValue: o.name, "onUpdate:modelValue": (s) => o.name = s, modelModifiers: { trim: true }, type: "text", maxlength: 8, clearable: "", placeholder: "二级分类名称", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(u, { key: "behaviorScore", prop: "behaviorScore", "show-overflow-tooltip": true, label: "行为分" }, { default: l(({ row: o }) => [t(g, { modelValue: o.behaviorScore, "onUpdate:modelValue": (s) => o.behaviorScore = s, clearable: "", placeholder: "请输入", size: "default", style: { width: "100%" }, oninput: "value=value.replace(/[^0-9.]/g, '').replace(/\\./g,'')" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(u, { key: "penalty", prop: "penalty", "show-overflow-tooltip": true, label: "处罚（元）" }, { default: l(({ row: o }) => [t(E, { modelValue: o.penalty, "onUpdate:modelValue": (s) => o.penalty = s, modelModifiers: { number: true }, min: 0, max: 9999999, step: 1, precision: 2, "controls-position": "right", placeholder: "请输入罚金" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(u, { key: "boolUpdate", prop: "boolUpdate", "show-overflow-tooltip": true, align: "center", label: "是否可修改金额", width: "110" }, { default: l(({ row: o }) => [t(O, { modelValue: o.boolUpdate, "onUpdate:modelValue": (s) => o.boolUpdate = s, "active-value": e(y).TRUE.V, "inactive-value": e(y).FALSE.V }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value"])]), _: 1 }), t(u, { label: "操作", width: "55", align: "center", fixed: "right" }, { default: l(({ $index: o }) => [t(d, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: I((s) => e(k)(e(n).safetyConfigs, o), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"]), p("div", W, [t(d, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-top": "15px" }, onClick: a[0] || (a[0] = (o) => e(x)(e(n).safetyConfigs)) }, { default: l(() => a[3] || (a[3] = [f(" 添加 ")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model", "disabled"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  ee as default
};
