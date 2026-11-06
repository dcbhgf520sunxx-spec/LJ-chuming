import { ref as w } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as i } from "vue";
import { createBlock as d } from "vue";
import { withCtx as a } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as p } from "vue";
import { toDisplayString as c } from "vue";
import { createElementVNode as f } from "vue";
import { unref as t } from "vue";
import { createElementBlock as W } from "vue";
import { createCommentVNode as _ } from "vue";
import { isRef as B } from "vue";
import { ElTag as I } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElButton as A } from "element-plus";
import { ElForm as R } from "element-plus";
import { _ as S, u as U, oC as y } from "../../../../../shared/runtime.js";
import T from "./statistical/index.vue.js";
import F from "./actuary/index.vue.js";
const L = { class: "header" }, M = { style: { display: "flex" } }, O = { key: 0, style: { color: "red" } }, q = { __name: "index", props: { visible: { type: Boolean, default: false }, projectData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(o, { emit: v }) {
  const j = v, E = o, l = w({ paintingTypeEnum: void 0, boolALLmonomer: false, monomerId: void 0 }), { visible: m, handleClose: u } = U({ emit: j, props: E, field: "visible", showHook: g }), V = { paintCalculationWayEnum: [{ required: true, message: "请选择计算方式", trigger: "change" }] };
  function g() {
  }
  return (H, n) => {
    const b = I, h = C("common-select"), x = z, k = A, D = R, N = C("common-drawer");
    return i(), d(N, { "append-to-body": "", ref: "drawerRef", title: "", "with-header": false, modelValue: t(m), "onUpdate:modelValue": n[1] || (n[1] = (e) => B(m) ? m.value = e : null), "before-close": t(u), size: "100%" }, { titleAfter: a(() => [s(b, { size: "large" }, { default: a(() => {
      var e, r;
      return [p("项目：" + c((e = o.projectData) == null ? void 0 : e.projectSerialNumber) + " - " + c((r = o.projectData) == null ? void 0 : r.projectShortName), 1)];
    }), _: 1 })]), content: a(() => [s(D, { ref: "formRef", model: l.value, rules: V, size: "small", "label-width": "140px" }, { default: a(() => [f("div", L, [f("div", M, [s(x, { label: "请选择计算方式：", prop: "paintCalculationWayEnum" }, { default: a(() => [s(h, { type: "enum", modelValue: l.value.paintCalculationWayEnum, "onUpdate:modelValue": n[0] || (n[0] = (e) => l.value.paintCalculationWayEnum = e), options: t(y).ENUM, clearable: "", placeholder: "计算方式", style: { width: "270px" }, class: "filter-item" }, null, 8, ["modelValue", "options"])]), _: 1 }), s(b, { class: "header-tag", size: "large" }, { default: a(() => {
      var e, r;
      return [p(" 项目：" + c((e = o.projectData) == null ? void 0 : e.projectSerialNumber) + " - " + c((r = o.projectData) == null ? void 0 : r.projectShortName), 1)];
    }), _: 1 })]), s(k, { onClick: t(u) }, { default: a(() => n[2] || (n[2] = [p("关闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), _: 1 }, 8, ["model"]), f("div", null, [l.value.paintCalculationWayEnum ? _("", true) : (i(), W("span", O, "*请先选择计算方式")), l.value.paintCalculationWayEnum === t(y).UNIFORM.V ? (i(), d(t(T), { key: 1, projectData: o.projectData, onClose: t(u) }, null, 8, ["projectData", "onClose"])) : _("", true), l.value.paintCalculationWayEnum === t(y).ACTUARIAL.V ? (i(), d(t(F), { key: 2 })) : _("", true)])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, X = S(q, [["__scopeId", "data-v-62626fbf"]]);
export {
  X as default
};
