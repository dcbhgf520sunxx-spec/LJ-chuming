import { ref as A } from "vue";
import { computed as D } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as b } from "vue";
import { createBlock as C } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as p } from "vue";
import { withModifiers as q } from "vue";
import { createCommentVNode as I } from "vue";
import { ElFormItem as L } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { ElInput as j } from "element-plus";
import { ElForm as G } from "element-plus";
import { pc as y, a_ as H, aw as K } from "../../../../../../../shared/runtime.js";
import { u as P } from "../../../../../../../modules/use-table-operate-4f84437f.js";
const Y = { style: { float: "right" } }, J = { style: { "text-align": "center" } }, ee = { __name: "form", setup(Q) {
  const _ = A(), w = { classConfigs: [{}], factoryOrConstructionSite: y.FACTORY.V, pid: 0 }, h = { name: void 0, serialNumber: void 0 }, V = { factoryOrConstructionSite: [{ required: true, message: "请选择分类", trigger: "change" }] }, x = { name: [{ required: true, message: "输入分类名称", trigger: "change" }], serialNumber: [{ required: true, message: "输入代码", trigger: "change" }] }, { CRUD: u, crud: s, form: l, ADD_FORM: k } = H(w, _), S = D(() => s.bStatus.cu > u.STATUS.NORMAL), { init: R, addRow: U, removeRow: N } = P(h, 1), { tableValidate: v, cleanUpData: O, wrongCellMask: T } = K({ rules: x });
  return k.init = () => {
    R(l.classConfigs);
  }, u.HOOK.beforeValidateBCU = () => {
    const { validResult: r, dealList: o } = v(l.classConfigs);
    if (r) l.classConfigs = o.filter((i) => i.name !== void 0), l.status = true;
    else return r;
  }, s.submitBatchFormFormat = (r) => (O(r.classConfigs), r), (r, o) => {
    const i = d("common-button"), B = d("common-select"), E = L, m = $, g = j, F = d("common-table"), M = G, z = d("common-dialog");
    return b(), C(z, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(s).cancelCU, visible: S.value, title: e(s).bStatus.title, "show-close": false, "custom-class": "warehouse-batch-add", width: "500px", top: "10vh" }, { titleRight: a(() => [f("span", Y, [t(i, { loading: e(s).bStatus.cu === e(u).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(s).submitBCU }, { default: a(() => o[2] || (o[2] = [p(" 提 交 ")])), _: 1, __: [2] }, 8, ["loading", "onClick"]), t(i, { size: "default", onClick: e(s).cancelBCU }, { default: a(() => o[3] || (o[3] = [p("关 闭")])), _: 1, __: [3] }, 8, ["onClick"])])]), default: a(() => [f("div", null, [t(M, { ref_key: "formRef", ref: _, model: e(l), rules: V, size: "default", "label-width": "80px" }, { default: a(() => [t(E, { label: "分类", prop: "factoryOrConstructionSite" }, { default: a(() => [t(B, { type: "enum", modelValue: e(l).factoryOrConstructionSite, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(l).factoryOrConstructionSite = n), options: e(y).ENUM, clearable: "", placeholder: "请选择", style: { width: "80%" }, class: "filter-item" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(F, { ref: "detailRef", border: "", data: e(l).classConfigs, style: { width: "100%", "margin-top": "10px" }, class: "upload-table", "return-source-data": "", "max-height": "500px", showEmptySymbol: false, "cell-class-name": e(T) }, { default: a(() => [t(m, { label: "序号", type: "index", align: "center", width: "50" }), t(m, { key: "serialNumber", prop: "serialNumber", label: "分类代码", align: "center" }, { default: a((n) => [t(g, { modelValue: n.row.serialNumber, "onUpdate:modelValue": (c) => n.row.serialNumber = c, modelModifiers: { trim: true }, type: "text", placeholder: "请填写", maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(m, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "分类名称", align: "center" }, { default: a((n) => [t(g, { modelValue: n.row.name, "onUpdate:modelValue": (c) => n.row.name = c, modelModifiers: { trim: true }, type: "text", placeholder: "请填写", maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e(l).id ? I("", true) : (b(), C(m, { key: 0, label: "操作", align: "center", width: "100" }, { default: a(({ $index: n }) => [t(i, { size: "default", icon: "el-icon-delete", type: "danger", onClick: q((c) => e(N)(e(l).classConfigs, n), ["stop"]) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 8, ["data", "cell-class-name"]), f("div", J, [t(i, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-top": "15px" }, onClick: o[1] || (o[1] = (n) => e(U)(e(l).classConfigs)) }, { default: a(() => o[4] || (o[4] = [p(" 添加 ")])), _: 1, __: [4] })])]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  ee as default
};
