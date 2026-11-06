import { ref as k } from "vue";
import { computed as U } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as v } from "vue";
import { createBlock as E } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as C } from "vue";
import { ElFormItem as I } from "element-plus";
import { ElInput as N } from "element-plus";
import { ElInputNumber as B } from "element-plus";
import { ElForm as M } from "element-plus";
import { _ as R, m as F, fa as u, ao as O, D as z } from "../../../../../../shared/runtime.js";
const q = { __name: "form", setup(D) {
  const { flag: f, hasBridgeMenu: c } = F(["flag", "hasBridgeMenu"]), d = k(), g = { id: void 0, factoryId: void 0, type: u.BUILDING.V, name: "", shortName: "", ton: void 0, sort: 1, remark: "" }, { crud: n, form: l } = O(g, d), b = { sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }], type: [{ required: true, message: "请选择车间类型", trigger: "change" }], name: [{ required: true, message: "请填写车间名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], shortName: [{ required: false, message: "请填写车间简称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], remark: [{ max: 500, message: "不能超过 500 个字符", trigger: "blur" }] }, y = U(() => {
    const m = [];
    return c.value || m.push(u.BRIDGE.K), f.value && m.push(u.ENCLOSURE.K), m;
  });
  return (m, o) => {
    const x = i("common-button"), V = i("common-select"), a = I, p = N, _ = B, h = M, w = i("common-dialog");
    return v(), E(w, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, width: "500px" }, { titleRight: r(() => [t(x, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: r(() => o[5] || (o[5] = [C("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: r(() => [t(h, { ref_key: "formRef", ref: d, model: e(l), rules: b, size: "default", "label-width": "120px" }, { default: r(() => [t(a, { label: "车间类型", prop: "type" }, { default: r(() => [t(V, { modelValue: e(l).type, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(l).type = s), options: e(u).ENUM, unshowOptions: y.value, type: "enum", size: "default", placeholder: "制造分类", style: { width: "270px" } }, null, 8, ["modelValue", "options", "unshowOptions"])]), _: 1 }), t(a, { label: "车间名称", prop: "name" }, { default: r(() => [t(p, { modelValue: e(l).name, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(l).name = s), modelModifiers: { trim: true }, type: "text", placeholder: "请填写名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(a, { label: "目标名称(吨)", prop: "ton" }, { default: r(() => [t(_, { modelValue: e(l).ton, "onUpdate:modelValue": o[2] || (o[2] = (s) => e(l).ton = s), modelModifiers: { number: true }, min: 1, max: 999999, step: 1, precision: e(z).COM_WT__G, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), t(a, { label: "排序", prop: "sort" }, { default: r(() => [t(_, { modelValue: e(l).sort, "onUpdate:modelValue": o[3] || (o[3] = (s) => e(l).sort = s), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(a, { label: "备注", prop: "remark" }, { default: r(() => [t(p, { modelValue: e(l).remark, "onUpdate:modelValue": o[4] || (o[4] = (s) => e(l).remark = s), type: "textarea", autosize: { minRows: 4, maxRows: 6 }, placeholder: "请填写备注", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, K = R(q, [["__scopeId", "data-v-234f5712"]]);
export {
  K as default
};
