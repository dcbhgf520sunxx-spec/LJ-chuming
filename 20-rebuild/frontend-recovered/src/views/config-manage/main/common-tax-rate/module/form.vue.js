import { ref as u } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as l } from "vue";
import { createBlock as r } from "vue";
import { withCtx as a } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { createTextVNode as _ } from "vue";
import { withModifiers as E } from "vue";
import { createElementVNode as C } from "vue";
import { toDisplayString as y } from "vue";
import { createElementBlock as N } from "vue";
import { Fragment as I } from "vue";
import { renderList as O } from "vue";
import { withKeys as A } from "vue";
import { ElMessage as L } from "element-plus";
import { nextTick as K } from "vue";
import { ElFormItem as M } from "element-plus";
import { ElTag as D } from "element-plus";
import { ElForm as j } from "element-plus";
import { _ as G, ao as H, i as P } from "../../../../../shared/runtime.js";
const $ = { class: "tax-list flex-rsc" }, q = { __name: "form", setup(J) {
  const w = { name: "", taxRateList: [] }, S = {}, p = u(), x = u(), m = u(false), n = u(), { CRUD: f, crud: s, form: t } = H(w, p);
  f.HOOK.beforeToCU = () => {
    b();
  };
  function b() {
    m.value = false, n.value = void 0;
  }
  function T(v) {
    if (t.taxRateList.splice(t.taxRateList.indexOf(v), 1), t.taxRateList.length === 0) {
      L.warning("至少保留一条税率数据");
      return;
    }
  }
  function V() {
    m.value = true, K(() => {
      x.value.focus();
    });
  }
  function g() {
    if (t.taxRateList.includes(n.value)) {
      L.warning("当前税率已存在");
      return;
    }
    P(n.value) && t.taxRateList.push(n.value), b();
  }
  return (v, o) => {
    const R = d("common-button"), k = M, h = D, B = d("common-input-number"), F = j, U = d("common-dialog");
    return l(), r(U, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(s).cancelCU, visible: e(s).status.cu > e(f).STATUS.NORMAL, title: e(s).status.title, width: "500px" }, { titleRight: a(() => [c(R, { loading: e(s).status.cu === e(f).STATUS.PROCESSING, size: "default", type: "primary", disabled: e(t).taxRateList.length === 0, onClick: e(s).submitCU }, { default: a(() => o[2] || (o[2] = [_(" 确认 ")])), _: 1, __: [2] }, 8, ["loading", "disabled", "onClick"])]), default: a(() => [c(F, { ref_key: "formRef", ref: p, model: e(t), rules: S, size: "default", "label-width": "100px", class: "tax-setting", onSubmit: o[1] || (o[1] = E(() => {
    }, ["prevent"])) }, { default: a(() => [c(k, { label: "种类", prop: "name" }, { default: a(() => [C("div", null, y(e(t).name), 1)]), _: 1 }), c(k, { label: "税率", prop: "taxRateList" }, { default: a(() => [C("div", $, [(l(true), N(I, null, O(e(t).taxRateList, (i, z) => (l(), r(h, { size: "large", key: z, closable: "", "disable-transitions": false, onClose: (Q) => T(i) }, { default: a(() => [_(y(i + "%"), 1)]), _: 2 }, 1032, ["onClose"]))), 128)), m.value ? (l(), r(B, { key: 0, ref_key: "inputRef", ref: x, modelValue: n.value, "onUpdate:modelValue": o[0] || (o[0] = (i) => n.value = i), class: "input-new-tag", size: "default", max: 100, min: 0, precision: 2, controls: false, placeholder: "数字", onKeyup: A(g, ["enter"]), onBlur: g }, null, 8, ["modelValue"])) : (l(), r(R, { key: 1, class: "button-new-tag", icon: "el-icon-plus", size: "default", onClick: V }, { default: a(() => o[3] || (o[3] = [_("添加")])), _: 1, __: [3] }))])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Y = G(q, [["__scopeId", "data-v-c53c79c9"]]);
export {
  Y as default
};
