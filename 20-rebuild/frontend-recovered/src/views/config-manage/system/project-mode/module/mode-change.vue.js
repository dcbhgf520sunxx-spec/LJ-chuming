import { ref as i } from "vue";
import { watch as I } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as u } from "vue";
import { createBlock as V } from "vue";
import { withCtx as o } from "vue";
import { createVNode as m } from "vue";
import { createTextVNode as y } from "vue";
import { createElementVNode as E } from "vue";
import { unref as l } from "vue";
import { ElRadioGroup as D } from "element-plus";
import { createElementBlock as h } from "vue";
import { Fragment as C } from "vue";
import { renderList as q } from "vue";
import { createCommentVNode as T } from "vue";
import { isRef as J } from "vue";
import { ElRadio as K } from "element-plus";
import { ElFormItem as G } from "element-plus";
import { ElForm as W } from "element-plus";
import { ElNotification as $ } from "element-plus";
import { l as p, _ as H, u as Q, bC as X, c0 as f } from "../../../../../shared/runtime.js";
function Y(t) {
  return p({ module: "contract", url: "project/listAllProject", method: "get", params: t });
}
function U(t) {
  return p({ module: "contract", url: "config/setProjectMode", method: "put", data: t });
}
function Z(t) {
  return p({ module: "contract", url: "config/getProjectMode", method: "get" });
}
function ee(t) {
  return p({ module: "contract", url: "config/listProjectMode", method: "get" });
}
const se = { get: Y, edit: U };
const oe = { style: { width: "260px" } }, te = { __name: "mode-change", props: { modelValue: { type: Boolean, require: true } }, emits: ["success", "update:modelValue"], setup(t, { emit: w }) {
  const d = i(), x = { projectMode: void 0 }, b = t, S = [{ L: "简约模式", K: "STRUCTURE", V: 1 }, { L: "标准模式", K: "STRUCTURE_ASSEMBLE", V: 2 }], n = i(JSON.parse(JSON.stringify(x))), _ = i(false), R = w, { visible: g, handleClose: j } = Q({ emit: R, props: b });
  I(() => b.modelValue, (a) => {
    a && (B(), F());
  }, { deep: true, immediate: true });
  const v = i([]), k = { projectMode: [{ required: true, message: "请选择项目模式", trigger: "change" }] };
  function B() {
    d.value && d.value.resetFields(), X(d, n);
  }
  function L() {
    $({ title: "提交成功", type: "success" }), R("success"), j();
  }
  async function F() {
    v.value = [];
    try {
      const a = await Z(), { content: e } = await ee();
      e && e.length > 0 && e.forEach((c) => {
        S.findIndex((s) => s.V === c) > -1 && v.value.push(S.find((s) => s.V === c));
      }), n.value.projectMode = a.projectMode;
    } catch (a) {
      console.log("获取项目模式", a);
    }
  }
  async function N(a) {
    _.value = true;
    try {
      await d.value.validate(), await U(n.value), L();
    } catch (e) {
      console.log("项目模式修改", e);
    } finally {
      _.value = false;
    }
  }
  return (a, e) => {
    const c = M("common-button"), s = K, P = G, A = W, O = M("common-dialog");
    return u(), V(O, { "append-to-body": "", "close-on-click-modal": false, "before-close": l(j), modelValue: l(g), "onUpdate:modelValue": e[1] || (e[1] = (r) => J(g) ? g.value = r : null), title: "编辑项目模式", width: "860px" }, { titleRight: o(() => [m(c, { loading: _.value, type: "primary", size: "default", onClick: N }, { default: o(() => e[2] || (e[2] = [y("确认")])), _: 1, __: [2] }, 8, ["loading"])]), default: o(() => [m(A, { ref_key: "formRef", ref: d, model: n.value, rules: k, size: "default", "label-width": "100px" }, { default: o(() => [m(P, { label: "项目模式", prop: "projectMode" }, { default: o(() => [E("div", oe, [m(l(D), { modelValue: n.value.projectMode, "onUpdate:modelValue": e[0] || (e[0] = (r) => n.value.projectMode = r) }, { default: o(() => [(u(true), h(C, null, q(v.value, (r, z) => (u(), h(C, { key: z }, [r.V === l(f).STRUCTURE.V ? (u(), V(s, { key: 0, value: l(f).STRUCTURE.V }, { default: o(() => e[3] || (e[3] = [y("简约模式 "), E("span", { style: { color: "red" } }, "（简约模式下，只对构件生产过程进行管理）", -1)])), _: 1, __: [3] }, 8, ["value"])) : T("", true), r.V === l(f).STRUCTURE_ASSEMBLE.V ? (u(), V(s, { key: 1, value: l(f).STRUCTURE_ASSEMBLE.V }, { default: o(() => e[4] || (e[4] = [y("标准模式 "), E("span", { style: { color: "red" } }, "（标准模式下，可将清单中构件和零件拆分为二，生成构件清单和零件清单，对其进行分开排产和管理）", -1)])), _: 1, __: [4] }, 8, ["value"])) : T("", true)], 64))), 128))]), _: 1 }, 8, ["modelValue"])])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, ae = H(te, [["__scopeId", "data-v-b96d024f"]]), re = Object.freeze(Object.defineProperty({ __proto__: null, default: ae }, Symbol.toStringTag, { value: "Module" }));
export {
  re as a,
  se as c,
  ae as m
};
