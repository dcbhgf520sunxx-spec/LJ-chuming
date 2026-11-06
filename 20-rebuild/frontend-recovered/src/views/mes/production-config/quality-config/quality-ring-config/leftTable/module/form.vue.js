import { ref as C } from "vue";
import { computed as I } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as V } from "vue";
import { createBlock as w } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { withModifiers as L } from "vue";
import { createCommentVNode as Y } from "vue";
import { ElFormItem as $ } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElInput as G } from "element-plus";
import { ElForm as H } from "element-plus";
import { pc as h, a_ as K, y as x, aw as P } from "../../../../../../../shared/runtime.js";
import { u as J } from "../../../../../../../modules/use-table-operate-4f84437f.js";
const Q = { style: { float: "right" } }, W = { style: { "text-align": "center" } }, oe = { __name: "form", setup(X) {
  const g = C(), N = { safetyConfigs: [{}], factoryOrConstructionSite: h.FACTORY.V, pid: 0 }, R = { name: void 0, serialNumber: void 0 }, S = { factoryOrConstructionSite: [{ required: true, message: "请选择分类", trigger: "change" }], type: [{ required: true, message: "请选择类型", trigger: "change" }] }, U = { name: [{ required: true, message: "输入分类名称", trigger: "change" }], serialNumber: [{ required: true, message: "输入代码", trigger: "change" }] }, { CRUD: c, crud: s, form: l, ADD_FORM: k } = K(N, g), O = I(() => s.bStatus.cu > c.STATUS.NORMAL), { init: T, addRow: v, removeRow: E } = J(R, 1), { tableValidate: B, cleanUpData: F, wrongCellMask: M } = P({ rules: U }), z = C([x.SECURITY, x.ENVIRONMENT]);
  return k.init = () => {
    T(l.safetyConfigs);
  }, c.HOOK.beforeValidateBCU = () => {
    const { validResult: r, dealList: o } = B(l.safetyConfigs);
    if (r) l.safetyConfigs = o.filter((i) => i.name !== void 0), l.status = true;
    else return r;
  }, s.submitBatchFormFormat = (r) => (F(r.safetyConfigs), r), (r, o) => {
    const i = d("common-button"), _ = d("common-select"), b = $, m = j, y = G, q = d("common-table"), A = H, D = d("common-dialog");
    return V(), w(D, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(s).cancelCU, visible: O.value, title: e(s).bStatus.title, "show-close": false, "custom-class": "warehouse-batch-add", width: "500px", top: "10vh" }, { titleRight: n(() => [p("span", Q, [t(i, { loading: e(s).bStatus.cu === e(c).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(s).submitBCU }, { default: n(() => o[3] || (o[3] = [f(" 提 交 ")])), _: 1, __: [3] }, 8, ["loading", "onClick"]), t(i, { size: "default", onClick: e(s).cancelBCU }, { default: n(() => o[4] || (o[4] = [f("关 闭")])), _: 1, __: [4] }, 8, ["onClick"])])]), default: n(() => [p("div", null, [t(A, { ref_key: "formRef", ref: g, model: e(l), rules: S, size: "default", "label-width": "80px" }, { default: n(() => [t(b, { label: "分类", prop: "factoryOrConstructionSite" }, { default: n(() => [t(_, { type: "enum", modelValue: e(l).factoryOrConstructionSite, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(l).factoryOrConstructionSite = a), options: e(h).ENUM, clearable: "", placeholder: "请选择", style: { width: "80%" }, class: "filter-item" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(b, { label: "类型", prop: "type" }, { default: n(() => [t(_, { type: "enum", modelValue: e(l).type, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(l).type = a), options: z.value, clearable: "", placeholder: "请选择类型", style: { width: "80%" }, class: "filter-item" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(q, { ref: "detailRef", border: "", data: e(l).safetyConfigs, style: { width: "100%", "margin-top": "10px" }, "max-height": "500px", class: "upload-table", "return-source-data": "", showEmptySymbol: false, "cell-class-name": e(M) }, { default: n(() => [t(m, { label: "序号", type: "index", align: "center", width: "50" }), t(m, { key: "serialNumber", prop: "serialNumber", label: "分类代码", align: "center" }, { default: n((a) => [t(y, { modelValue: a.row.serialNumber, "onUpdate:modelValue": (u) => a.row.serialNumber = u, modelModifiers: { trim: true }, type: "text", placeholder: "请填写", maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(m, { key: "name", prop: "name", label: "分类名称", align: "center" }, { default: n((a) => [t(y, { modelValue: a.row.name, "onUpdate:modelValue": (u) => a.row.name = u, modelModifiers: { trim: true }, type: "text", placeholder: "请填写", maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e(l).id ? Y("", true) : (V(), w(m, { key: 0, label: "操作", align: "center", width: "100" }, { default: n(({ $index: a }) => [t(i, { size: "default", icon: "el-icon-delete", type: "danger", onClick: L((u) => e(E)(e(l).safetyConfigs, a), ["stop"]) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 8, ["data", "cell-class-name"]), p("div", W, [t(i, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-top": "15px" }, onClick: o[2] || (o[2] = (a) => e(v)(e(l).safetyConfigs)) }, { default: n(() => o[5] || (o[5] = [f(" 添加 ")])), _: 1, __: [5] })])]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  oe as default
};
