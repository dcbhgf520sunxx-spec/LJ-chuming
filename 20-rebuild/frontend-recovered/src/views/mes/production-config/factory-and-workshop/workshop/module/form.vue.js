import { ref as k } from "vue";
import { computed as w } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as U } from "vue";
import { createBlock as N } from "vue";
import { withCtx as s } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as E } from "vue";
import { ElInput as v } from "element-plus";
import { ElFormItem as M } from "element-plus";
import { ElInputNumber as C } from "element-plus";
import { ElForm as F } from "element-plus";
import { _ as q, m as z, ao as I, fa as i } from "../../../../../../shared/runtime.js";
const R = { __name: "form", setup(B) {
  const { user: p } = z(["user"]), f = k(), _ = { id: void 0, factoryId: void 0, type: p.value.factoryProductEnum[0], name: "", shortName: "", sort: 1, remark: "", ton: void 0 }, { crud: m, form: l } = I(_, f), g = { sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }], type: [{ required: true, message: "请选择车间类型", trigger: "change" }], name: [{ required: true, message: "请填写车间名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], shortName: [{ required: false, message: "请填写车间简称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], remark: [{ max: 500, message: "不能超过 500 个字符", trigger: "blur" }], ton: [{ required: true, message: "请填写目标产量", trigger: "blur", type: "number" }] }, b = w(() => {
    const n = [];
    for (const o in i.ENUM) p.value.factoryProductEnum.includes(i.ENUM[o].V) && n.push(i.ENUM[o]);
    return n;
  });
  return (n, o) => {
    const y = d("common-button"), u = v, a = M, x = d("common-select"), c = C, V = F, h = d("common-dialog");
    return U(), N(h, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(m).cancelCU, visible: e(m).status.cu > 0, title: e(m).status.title, width: "500px" }, { titleRight: s(() => [t(y, { loading: e(m).status.cu === 2, type: "primary", size: "default", onClick: e(m).submitCU }, { default: s(() => o[6] || (o[6] = [E("确认")])), _: 1, __: [6] }, 8, ["loading", "onClick"])]), default: s(() => [t(V, { ref_key: "formRef", ref: f, model: e(l), rules: g, size: "default", "label-width": "130px" }, { default: s(() => [t(a, { label: "车间名称", prop: "name" }, { default: s(() => [t(u, { modelValue: e(l).name, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(l).name = r), modelModifiers: { trim: true }, type: "text", placeholder: "请填写名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(a, { label: "车间简称", prop: "shortName" }, { default: s(() => [t(u, { modelValue: e(l).shortName, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(l).shortName = r), modelModifiers: { trim: true }, type: "text", placeholder: "请填写简称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(a, { label: "车间类型", prop: "type" }, { default: s(() => [t(x, { modelValue: e(l).type, "onUpdate:modelValue": o[2] || (o[2] = (r) => e(l).type = r), options: b.value, type: "enum", size: "default", placeholder: "车间类型", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), t(a, { label: "目标产量(吨)", prop: "ton" }, { default: s(() => [t(c, { modelValue: e(l).ton, "onUpdate:modelValue": o[3] || (o[3] = (r) => e(l).ton = r), modelModifiers: { number: true }, controls: false, min: 0, max: 999999999, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(a, { label: "排序", prop: "sort" }, { default: s(() => [t(c, { modelValue: e(l).sort, "onUpdate:modelValue": o[4] || (o[4] = (r) => e(l).sort = r), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), t(a, { label: "备注", prop: "remark" }, { default: s(() => [t(u, { modelValue: e(l).remark, "onUpdate:modelValue": o[5] || (o[5] = (r) => e(l).remark = r), type: "textarea", autosize: { minRows: 4, maxRows: 6 }, placeholder: "请填写备注", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, O = q(R, [["__scopeId", "data-v-028d2b2a"]]);
export {
  O as default
};
